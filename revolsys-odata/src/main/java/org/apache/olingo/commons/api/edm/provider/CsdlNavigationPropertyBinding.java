/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.olingo.commons.api.edm.provider;

/**
 * The type Csdl navigation property binding.
 */
public class CsdlNavigationPropertyBinding implements CsdlAbstractEdmItem {

  private String path;

  private String target;

  /**
   * Gets path.
   *
   * @return the path
   */
  public String getPath() {
    return this.path;
  }

  /**
   * Gets target.
   *
   * @return the target
   */
  public String getTarget() {
    return this.target;
  }

  /**
   * Sets path.
   *
   * @param path the path
   * @return the path
   */
  public CsdlNavigationPropertyBinding setPath(final String path) {
    this.path = path;
    return this;
  }

  /**
   * Sets target.
   *
   * @param target the target
   * @return the target
   */
  public CsdlNavigationPropertyBinding setTarget(final String target) {
    this.target = target;
    return this;
  }
}
