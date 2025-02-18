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

import org.apache.olingo.commons.api.edm.FullQualifiedName;

/**
 * The type Csdl entity container info.
 */
public class CsdlEntityContainerInfo {

  private FullQualifiedName containerName;

  private FullQualifiedName extendsContainer;

  /**
   * Gets container name.
   *
   * @return the container name
   */
  public FullQualifiedName getContainerName() {
    return this.containerName;
  }

  /**
   * Gets extends container.
   *
   * @return the extends container
   */
  public FullQualifiedName getExtendsContainer() {
    return this.extendsContainer;
  }

  /**
   * Sets container name.
   *
   * @param containerName the container name
   * @return the container name
   */
  public CsdlEntityContainerInfo setContainerName(final FullQualifiedName containerName) {
    this.containerName = containerName;
    return this;
  }

  /**
   * Sets extends container.
   *
   * @param extendsContainer the extends container
   * @return the extends container
   */
  public CsdlEntityContainerInfo setExtendsContainer(final FullQualifiedName extendsContainer) {
    this.extendsContainer = extendsContainer;
    return this;
  }

}
