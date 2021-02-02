package org.yu.elasticsearchmodule.config;

import com.google.gson.Gson;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import org.apache.http.HttpHost;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.PropertyMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import java.time.Duration;

/**
 * @author yu.wenhua
 * @desc springboot2.3.0之后不支持自动注册，只能手动写注册配置文件.
 * @date 2021/2/2 17:51
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(JestClient.class)
@EnableConfigurationProperties(JestProperties.class)
@AutoConfigureAfter(GsonAutoConfiguration.class)
public class JestClientConfig {
    @Bean(destroyMethod = "shutdownClient")
    @ConditionalOnMissingBean
    public JestClient jestClient(JestProperties properties, ObjectProvider<Gson> gson,
                                 ObjectProvider<HttpClientConfigBuilderCustomizer> builderCustomizers) {
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(createHttpClientConfig(properties, gson, builderCustomizers));
        return factory.getObject();
    }

    protected HttpClientConfig createHttpClientConfig(JestProperties properties, ObjectProvider<Gson> gson,
                                                      ObjectProvider<HttpClientConfigBuilderCustomizer> builderCustomizers) {
        HttpClientConfig.Builder builder = new HttpClientConfig.Builder(properties.getUris());
        PropertyMapper map = PropertyMapper.get();
        map.from(properties::getUsername).whenHasText()
                .to((username) -> builder.defaultCredentials(username, properties.getPassword()));
        JestProperties.Proxy proxy = properties.getProxy();
        map.from(proxy::getHost).whenHasText().to((host) -> {
            Assert.notNull(proxy.getPort(), "Proxy port must not be null");
            builder.proxy(new HttpHost(host, proxy.getPort()));
        });
        map.from(gson::getIfUnique).whenNonNull().to(builder::gson);
        map.from(properties::isMultiThreaded).to(builder::multiThreaded);
        map.from(properties::getConnectionTimeout).whenNonNull().asInt(Duration::toMillis).to(builder::connTimeout);
        map.from(properties::getReadTimeout).whenNonNull().asInt(Duration::toMillis).to(builder::readTimeout);
        builderCustomizers.orderedStream().forEach((customizer) -> customizer.customize(builder));
        return builder.build();
    }


}

