package org.simpleframework.xml.stream;

public abstract interface Node
{
  public abstract String getName();

  public abstract Node getParent();

  public abstract String getValue()
    throws Exception;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.Node
 * JD-Core Version:    0.6.2
 */