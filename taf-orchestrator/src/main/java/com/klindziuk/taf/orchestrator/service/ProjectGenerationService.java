/*
 * Copyright (c) Dandelion development.
 */

package com.klindziuk.taf.orchestrator.service;

import com.klindziuk.taf.orchestrator.model.ProjectPlatform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectGenerationService {

  private final JavaTafProviderService javaTafProviderService;
  private final JsTafProviderService jsTafProviderService;
  private final MockTafProviderService mockTafProviderService;

  @Autowired
  public ProjectGenerationService(
      JavaTafProviderService javaTafProviderService,
      JsTafProviderService jsTafProviderService,
      MockTafProviderService mockTafProviderService) {
    this.javaTafProviderService = javaTafProviderService;
    this.jsTafProviderService = jsTafProviderService;
    this.mockTafProviderService = mockTafProviderService;
  }

  public ProviderService providerService(ProjectPlatform projectPlatform) {
    if (ProjectPlatform.JAVA.equals(projectPlatform)) {
      return javaTafProviderService;
    }
    if (ProjectPlatform.JS.equals(projectPlatform)) {
      return jsTafProviderService;
    }

    if (ProjectPlatform.MOCK.equals(projectPlatform)) {
      return mockTafProviderService;
    }
    throw new RuntimeException("Unsupported project platform - " + projectPlatform);
  }
}
