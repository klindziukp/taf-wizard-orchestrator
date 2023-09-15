/*
 * Copyright (c) Dandelion development.
 */

package com.klindziuk.taf.orchestrator.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProjectPlatform {
  JAVA,
  JS,
  DOTNET,
  PYTHON,

  MOCK
}
