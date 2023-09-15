/*
 * Copyright (c) Dandelion development.
 */

package com.klindziuk.taf.mock.provider.model.project;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TafModule {

  private String id;
  private String displayName;
}
