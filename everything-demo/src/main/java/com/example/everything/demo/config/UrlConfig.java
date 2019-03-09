package com.example.everything.demo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 上传文件的地址的配置文件
 * @author
 */
@ConfigurationProperties(prefix = "url-config")
@Setter
@Getter
public class UrlConfig {
    private String url;
}
