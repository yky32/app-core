package com.quinsic.core.config;

import com.quinsic.core.config.prop.AppApiProp;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration(proxyBeanMethods = false)
@Import({WebClientConfig.class})
@EnableConfigurationProperties(AppApiProp.class)
public class CoreAutoConfig {
}