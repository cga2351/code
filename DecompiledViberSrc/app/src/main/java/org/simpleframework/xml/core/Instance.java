package org.simpleframework.xml.core;

abstract interface Instance
{
  public abstract Object getInstance()
    throws Exception;

  public abstract Class getType();

  public abstract boolean isReference();

  public abstract Object setInstance(Object paramObject)
    throws Exception;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Instance
 * JD-Core Version:    0.6.2
 */