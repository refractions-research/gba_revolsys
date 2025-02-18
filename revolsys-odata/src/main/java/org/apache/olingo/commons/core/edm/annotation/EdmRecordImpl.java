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
package org.apache.olingo.commons.core.edm.annotation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.olingo.commons.api.edm.EdmException;
import org.apache.olingo.commons.api.edm.EdmStructuredType;
import org.apache.olingo.commons.api.edm.FullQualifiedName;
import org.apache.olingo.commons.api.edm.annotation.EdmPropertyValue;
import org.apache.olingo.commons.api.edm.annotation.EdmRecord;
import org.apache.olingo.commons.api.edm.provider.annotation.CsdlPropertyValue;
import org.apache.olingo.commons.api.edm.provider.annotation.CsdlRecord;
import org.apache.olingo.commons.core.edm.Edm;
import org.apache.olingo.commons.core.edm.EdmTypeInfo;

public class EdmRecordImpl extends AbstractEdmAnnotatableDynamicExpression implements EdmRecord {

  private List<EdmPropertyValue> propertyValues;

  private EdmStructuredType type;

  private final CsdlRecord record;

  public EdmRecordImpl(final Edm edm, final CsdlRecord csdlExp) {
    super(edm, "Record", csdlExp);
    this.record = csdlExp;
  }

  @Override
  public EdmExpressionType getExpressionType() {
    return EdmExpressionType.Record;
  }

  @Override
  public List<EdmPropertyValue> getPropertyValues() {
    if (this.propertyValues == null) {
      final List<EdmPropertyValue> localValues = new ArrayList<>();
      if (this.record.getPropertyValues() != null) {
        for (final CsdlPropertyValue value : this.record.getPropertyValues()) {
          localValues.add(new EdmPropertyValueImpl(this.edm, value));
        }
      }
      this.propertyValues = Collections.unmodifiableList(localValues);
    }
    return this.propertyValues;
  }

  @Override
  public EdmStructuredType getType() {
    if (this.type == null && this.record.getType() != null) {
      // record MAY have a type information.
      final EdmTypeInfo typeInfo = new EdmTypeInfo.Builder().setEdm(this.edm)
        .setTypeExpression(this.record.getType())
        .build();
      if (typeInfo.isEntityType() || typeInfo.isComplexType()) {
        this.type = typeInfo.isEntityType() ? typeInfo.getEntityType() : typeInfo.getComplexType();
      } else {
        throw new EdmException("Record expressions must specify a complex or entity type.");
      }
    }
    return this.type;
  }

  @Override
  public FullQualifiedName getTypeFQN() {
    return this.record.getType() != null ? new FullQualifiedName(this.record.getType()) : null;
  }
}
