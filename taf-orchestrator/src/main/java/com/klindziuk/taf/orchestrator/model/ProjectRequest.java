/*
 * Copyright (c) Dandelion development.
 */

package com.klindziuk.taf.orchestrator.model;

import java.util.Set;
import lombok.Data;

@Data
public class ProjectRequest {

  private String name;
  private String description;
  private String groupId;
  private String artifactId;
  private String javaVersion;
  private String buildTool;
  private String testEngine;
  private ProjectPlatform projectPlatform;
  private Set<String> webDriverModuleNames;
  private Set<String> apiModuleNames;
  private Set<String> reportingModuleNames;
}
