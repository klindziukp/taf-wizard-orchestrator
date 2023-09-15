/*
 * Copyright (c) Dandelion development.
 */

package com.klindziuk.taf.orchestrator.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class ProviderConfig {

  @Value("${com.klindziuk.taf.provider.java.base-url}")
  private String javaBaseUrl;

  @Value("${com.klindziuk.taf.provider.java.module-path}")
  private String javaModulesPath;

  @Value("${com.klindziuk.taf.provider.java.project-path}")
  private String javaProjectPath;

  @Value("${com.klindziuk.taf.provider.js.base-url}")
  private String jsBaseUrl;

  @Value("${com.klindziuk.taf.provider.js.module-path}")
  private String jsModulesPath;

  @Value("${com.klindziuk.taf.provider.js.project-path}")
  private String jsProjectPath;

  @Value("${com.klindziuk.taf.provider.dotnet.base-url}")
  private String dotNetBaseUrl;

  @Value("${com.klindziuk.taf.provider.dotnet.module-path}")
  private String dotNetModulesPath;

  @Value("${com.klindziuk.taf.provider.dotnet.project-path}")
  private String dotNetProjectPath;

  @Value("${com.klindziuk.taf.provider.python.base-url}")
  private String pythonBaseUrl;

  @Value("${com.klindziuk.taf.provider.python.module-path}")
  private String pythonModulesPath;

  @Value("${com.klindziuk.taf.provider.python.project-path}")
  private String pythonProjectPath;

  @Value("${com.klindziuk.taf.provider.mock.base-url}")
  private String mockProviderUrl;

  @Value("${com.klindziuk.taf.provider.mock.module-path}")
  private String mockModulesPath;

  @Value("${com.klindziuk.taf.provider.mock.project-path}")
  private String mockProjectPath;
}
