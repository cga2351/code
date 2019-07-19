package org.simpleframework.xml.stream;

abstract interface Attribute
{
  public abstract String getName();

  public abstract String getPrefix();

  public abstract String getReference();

  public abstract Object getSource();

  public abstract String getValue();

  public abstract boolean isReserved();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.Attribute
 * JD-Core Version:    0.6.2
 */