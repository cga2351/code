package org.simpleframework.xml.core;

public class UnionException extends PersistenceException
{
  public UnionException(String paramString, Object[] paramArrayOfObject)
  {
    super(String.format(paramString, paramArrayOfObject), new Object[0]);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.UnionException
 * JD-Core Version:    0.6.2
 */