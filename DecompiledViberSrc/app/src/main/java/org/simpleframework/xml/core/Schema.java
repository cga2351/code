package org.simpleframework.xml.core;

import org.simpleframework.xml.Version;

abstract interface Schema
{
  public abstract Caller getCaller();

  public abstract Decorator getDecorator();

  public abstract Instantiator getInstantiator();

  public abstract Version getRevision();

  public abstract Section getSection();

  public abstract Label getText();

  public abstract Label getVersion();

  public abstract boolean isPrimitive();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Schema
 * JD-Core Version:    0.6.2
 */