package com.revolsys.record.io;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.config.AbstractFactoryBean;

import com.revolsys.collection.map.MapEx;
import com.revolsys.record.io.format.json.JsonObject;
import com.revolsys.record.schema.RecordStore;

public class RecordStoreFactoryBean extends AbstractFactoryBean<RecordStore> {
  private MapEx config = JsonObject.hash();

  private Map<String, Object> properties = new LinkedHashMap<>();

  @Override
  protected RecordStore createInstance() throws Exception {
    final RecordStore recordStore = RecordStore.newRecordStore(this.config);
    recordStore.setProperties(this.properties);
    recordStore.initialize();
    return recordStore;
  }

  @Override
  protected void destroyInstance(final RecordStore recordStore) throws Exception {
    recordStore.close();
    this.properties = null;
    this.config = null;
  }

  public MapEx getConfig() {
    return this.config;
  }

  @Override
  public Class<?> getObjectType() {
    return RecordStore.class;
  }

  public Map<String, Object> getProperties() {
    return this.properties;
  }

  public void setConfig(final MapEx config) {
    this.config = config;
  }

  public void setProperties(final Map<String, Object> properties) {
    this.properties = properties;
  }

  public void setUrl(final String url) {
    this.config.put("url", url);
  }
}
