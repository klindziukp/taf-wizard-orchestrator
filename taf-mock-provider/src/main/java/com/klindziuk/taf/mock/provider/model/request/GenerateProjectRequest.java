/*
 * Copyright (c) Dandelion development.
 */

package com.klindziuk.taf.mock.provider.model.request;

import com.klindziuk.taf.mock.provider.model.project.ProjectConfiguration;
import com.klindziuk.taf.mock.provider.model.project.TafModuleGroup;
import java.util.List;
import lombok.Data;

@Data
public class GenerateProjectRequest {

  private String platform;
  private List<ProjectConfiguration> projectConfigurations;
  private List<TafModuleGroup> groups;
}
