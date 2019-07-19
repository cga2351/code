package com.facebook.react.modules.network;

import com.facebook.common.logging.FLog;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ProgressiveStringDecoder
{
  private static final String EMPTY_STRING = "";
  private final CharsetDecoder mDecoder;
  private byte[] remainder = null;

  public ProgressiveStringDecoder(Charset paramCharset)
  {
    this.mDecoder = paramCharset.newDecoder();
  }

  public String decodeNext(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.remainder != null)
    {
      byte[] arrayOfByte = new byte[paramInt + this.remainder.length];
      System.arraycopy(this.remainder, 0, arrayOfByte, 0, this.remainder.length);
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, this.remainder.length, paramInt);
      paramInt += this.remainder.length;
      paramArrayOfByte = arrayOfByte;
    }
    ByteBuffer localByteBuffer1 = ByteBuffer.wrap(paramArrayOfByte, 0, paramInt);
    int i = 0;
    int j = 0;
    Object localObject = null;
    ByteBuffer localByteBuffer2 = localByteBuffer1;
    while ((j == 0) && (i < 4))
      try
      {
        CharBuffer localCharBuffer = this.mDecoder.decode(localByteBuffer2);
        j = 1;
        localObject = localCharBuffer;
      }
      catch (CharacterCodingException localCharacterCodingException)
      {
        int m = i + 1;
        localByteBuffer2 = ByteBuffer.wrap(paramArrayOfByte, 0, paramInt - m);
        i = m;
      }
    int k;
    if ((j != 0) && (i > 0))
    {
      k = 1;
      if (k == 0)
        break label197;
      this.remainder = new byte[i];
      System.arraycopy(paramArrayOfByte, paramInt - i, this.remainder, 0, i);
    }
    while (true)
    {
      if (j != 0)
        break label205;
      FLog.w("ReactNative", "failed to decode string from byte array");
      return "";
      k = 0;
      break;
      label197: this.remainder = null;
    }
    label205: return new String(localObject.array(), 0, localObject.length());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.network.ProgressiveStringDecoder
 * JD-Core Version:    0.6.2
 */