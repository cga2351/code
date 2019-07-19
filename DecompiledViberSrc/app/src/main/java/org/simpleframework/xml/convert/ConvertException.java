package org.simpleframework.xml.convert;

public class ConvertException extends Exception
{
  public ConvertException(String paramString, Object[] paramArrayOfObject)
  {
    super(String.format(paramString, paramArrayOfObject));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.convert.ConvertException
 * JD-Core Version:    0.6.2
 */