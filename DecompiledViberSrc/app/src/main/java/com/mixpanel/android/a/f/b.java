package com.mixpanel.android.a.f;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

public class b
{
  public static CodingErrorAction a = CodingErrorAction.REPORT;

  public static String a(ByteBuffer paramByteBuffer)
    throws com.mixpanel.android.a.c.b
  {
    CharsetDecoder localCharsetDecoder = Charset.forName("UTF8").newDecoder();
    localCharsetDecoder.onMalformedInput(a);
    localCharsetDecoder.onUnmappableCharacter(a);
    try
    {
      paramByteBuffer.mark();
      String str = localCharsetDecoder.decode(paramByteBuffer).toString();
      paramByteBuffer.reset();
      return str;
    }
    catch (CharacterCodingException localCharacterCodingException)
    {
      throw new com.mixpanel.android.a.c.b(1007, localCharacterCodingException);
    }
  }

  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      String str = new String(paramArrayOfByte, paramInt1, paramInt2, "ASCII");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException(localUnsupportedEncodingException);
    }
  }

  public static byte[] a(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF8");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException(localUnsupportedEncodingException);
    }
  }

  public static byte[] b(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("ASCII");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException(localUnsupportedEncodingException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.a.f.b
 * JD-Core Version:    0.6.2
 */