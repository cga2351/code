package com.viber.libnativehttp;

import java.nio.charset.Charset;

public class Utils
{
  private static final Charset CHARSET_UTF_8 = Charset.forName("UTF-8");

  private static byte[] getUtf8Bytes(String paramString)
  {
    byte[] arrayOfByte = null;
    if (paramString != null)
    {
      int i = paramString.length();
      arrayOfByte = null;
      if (i > 0)
        arrayOfByte = paramString.getBytes(CHARSET_UTF_8);
    }
    return arrayOfByte;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.libnativehttp.Utils
 * JD-Core Version:    0.6.2
 */