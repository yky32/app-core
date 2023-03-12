package com.quinsic.core.config;

import java.util.Optional;

import com.quinsic.core.config.prop.AppApiProp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebClientConfig {
  private final AppApiProp appApiProp;
  
    @Bean(name = "example-service")
    public WebClient paymentServiceWebClient() {
      String uri = Optional.ofNullable(appApiProp)
        .map(AppApiProp::getExt)
        .map(ext -> ext.get("example-service"))
        .map(AppApiProp.ApiProp::getUri)
        .orElse("http://example-service.default.svc.cluster.local:9000");
      return WebClient.builder()
                .baseUrl(uri)
                .build();
    }
}
