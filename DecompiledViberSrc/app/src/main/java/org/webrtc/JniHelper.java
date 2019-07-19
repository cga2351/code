package org.webrtc;

import java.io.UnsupportedEncodingException;
import java.util.Map.Entry;

class JniHelper
{
  @CalledByNative
  static Object getKey(Map.Entry paramEntry)
  {
    return paramEntry.getKey();
  }

  @CalledByNative
  static byte[] getStringBytes(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("ISO-8859-1");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new RuntimeException("ISO-8859-1 is unsupported");
  }

  @CalledByNative
  static Object getStringClass()
  {
    return String.class;
  }

  @CalledByNative
  static Object getValue(Map.Entry paramEntry)
  {
    return paramEntry.getValue();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.JniHelper
 * JD-Core Version:    0.6.2
 */