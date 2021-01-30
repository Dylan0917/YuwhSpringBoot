package org.yu.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/1/30 12:02
 */
@ConfigurationProperties(prefix = "yu.hello")
public class HelloProperties {

    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
