package org.simpleframework.xml.transform;

public class InvalidFormatException extends TransformException
{
  public InvalidFormatException(String paramString, Object[] paramArrayOfObject)
  {
    super(String.format(paramString, paramArrayOfObject), new Object[0]);
  }

  public InvalidFormatException(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    super(String.format(paramString, paramArrayOfObject), new Object[] { paramThrowable });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.InvalidFormatException
 * JD-Core Version:    0.6.2
 */