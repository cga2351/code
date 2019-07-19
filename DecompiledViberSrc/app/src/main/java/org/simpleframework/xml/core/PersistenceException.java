package org.simpleframework.xml.core;

public class PersistenceException extends Exception
{
  public PersistenceException(String paramString, Object[] paramArrayOfObject)
  {
    super(String.format(paramString, paramArrayOfObject));
  }

  public PersistenceException(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    super(String.format(paramString, paramArrayOfObject), paramThrowable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.PersistenceException
 * JD-Core Version:    0.6.2
 */