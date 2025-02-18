package com.revolsys.gis.wmts.capabilities;

import org.w3c.dom.Element;

public class WmtsResourceUrl {

  private final String format;

  private final String resourceType;

  private final String template;

  public WmtsResourceUrl(final Element element) {
    this.format = element.getAttribute("format");
    this.resourceType = element.getAttribute("resourceType");
    this.template = element.getAttribute("template");
  }

  public String getFormat() {
    return this.format;
  }

  public String getResourceType() {
    return this.resourceType;
  }

  public String getTemplate() {
    return this.template;
  }

  @Override
  public String toString() {
    return this.template;
  }
}
