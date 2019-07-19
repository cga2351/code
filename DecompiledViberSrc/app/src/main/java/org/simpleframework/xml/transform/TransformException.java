package org.simpleframework.xml.transform;

import org.simpleframework.xml.core.PersistenceException;

public class TransformException extends PersistenceException
{
  public TransformException(String paramString, Object[] paramArrayOfObject)
  {
    super(String.format(paramString, paramArrayOfObject), new Object[0]);
  }

  public TransformException(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    super(String.format(paramString, paramArrayOfObject), new Object[] { paramThrowable });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.TransformException
 * JD-Core Version:    0.6.2
 */