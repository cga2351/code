package org.simpleframework.xml.transform;

public abstract interface Transform<T>
{
  public abstract T read(String paramString)
    throws Exception;

  public abstract String write(T paramT)
    throws Exception;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.Transform
 * JD-Core Version:    0.6.2
 */