/*
 * Copyright (c) Dandelion development.
 */

package com.klindziuk.taf.orchestrator.service;

import com.klindziuk.taf.orchestrator.config.ProviderConfig;
import com.klindziuk.taf.orchestrator.config.WebClientConfig;
import org.springframework.stereotype.Service;

@Service
public abstract class TafProviderService implements ProviderService {

  protected final WebClientConfig webClientConfig;
  protected final ProviderConfig providerConfig;

  public TafProviderService(WebClientConfig webClientConfig, ProviderConfig providerConfig) {
    this.webClientConfig = webClientConfig;
    this.providerConfig = providerConfig;
  }
}
