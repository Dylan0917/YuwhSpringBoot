package org.yu.elasticsearchmodule.config;

import io.searchbox.client.config.HttpClientConfig.Builder;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/2/2 18:46
 */
@FunctionalInterface
public interface HttpClientConfigBuilderCustomizer {
    /**
     * Customize the {@link Builder}.
     * @param builder the builder to customize
     */
    void customize(Builder builder);

}
