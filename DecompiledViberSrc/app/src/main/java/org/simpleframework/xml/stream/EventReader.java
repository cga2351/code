package org.simpleframework.xml.stream;

abstract interface EventReader
{
  public abstract EventNode next()
    throws Exception;

  public abstract EventNode peek()
    throws Exception;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.EventReader
 * JD-Core Version:    0.6.2
 */