/*
 * Copyright (c) Dandelion development.
 */

package com.klindziuk.taf.orchestrator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

  private final ProviderConfig providerConfig;

  @Autowired
  public WebClientConfig(ProviderConfig providerConfig) {
    this.providerConfig = providerConfig;
  }

  @Bean
  public WebClient javaWebClient() {
    return webClient(providerConfig.getJavaBaseUrl());
  }

  @Bean
  public WebClient jsWebClient() {
    return webClient(providerConfig.getJsBaseUrl());
  }

  @Bean
  public WebClient dotNetWebClient() {
    return webClient(providerConfig.getDotNetBaseUrl());
  }

  @Bean
  public WebClient pythonWebClient() {
    return webClient(providerConfig.getPythonBaseUrl());
  }

  @Bean
  public WebClient mockWebClient() {
    return webClient(providerConfig.getMockProviderUrl());
  }

  private WebClient webClient(String baseUrl) {
    return WebClient.builder().baseUrl(baseUrl).build();
  }
}
