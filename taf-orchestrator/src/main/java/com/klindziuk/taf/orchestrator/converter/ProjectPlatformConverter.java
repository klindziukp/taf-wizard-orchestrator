/*
 * Copyright (c) Dandelion development.
 */

package com.klindziuk.taf.orchestrator.converter;

import com.klindziuk.taf.orchestrator.model.ProjectPlatform;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProjectPlatformConverter implements Converter<String, ProjectPlatform> {

  @Override
  public ProjectPlatform convert(String value) {
    return ProjectPlatform.valueOf(value.toUpperCase());
  }
}
