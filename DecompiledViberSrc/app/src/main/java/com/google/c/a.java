package com.google.c;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

public class a
{
  private static final Charset c = Charset.forName("UTF-8");
  private static final ThreadLocal<CharsetDecoder> d = new ThreadLocal()
  {
    protected CharsetDecoder a()
    {
      return a.a().newDecoder();
    }
  };
  private static final ThreadLocal<CharBuffer> e = new ThreadLocal();
  protected int a;
  protected ByteBuffer b;

  protected int a(int paramInt)
  {
    int i = this.a - this.b.getInt(this.a);
    if (paramInt < this.b.getShort(i))
      return this.b.getShort(i + paramInt);
    return 0;
  }

  protected int b(int paramInt)
  {
    return paramInt + this.b.getInt(paramInt);
  }

  protected String c(int paramInt)
  {
    CharsetDecoder localCharsetDecoder = (CharsetDecoder)d.get();
    localCharsetDecoder.reset();
    int i = paramInt + this.b.getInt(paramInt);
    ByteBuffer localByteBuffer = this.b.duplicate().order(ByteOrder.LITTLE_ENDIAN);
    int j = localByteBuffer.getInt(i);
    localByteBuffer.position(i + 4);
    localByteBuffer.limit(j + (i + 4));
    int k = (int)(j * localCharsetDecoder.maxCharsPerByte());
    CharBuffer localCharBuffer = (CharBuffer)e.get();
    if ((localCharBuffer == null) || (localCharBuffer.capacity() < k))
    {
      localCharBuffer = CharBuffer.allocate(k);
      e.set(localCharBuffer);
    }
    localCharBuffer.clear();
    try
    {
      CoderResult localCoderResult = localCharsetDecoder.decode(localByteBuffer, localCharBuffer, true);
      if (!localCoderResult.isUnderflow())
        localCoderResult.throwException();
      return localCharBuffer.flip().toString();
    }
    catch (CharacterCodingException localCharacterCodingException)
    {
      throw new Error(localCharacterCodingException);
    }
  }

  protected int d(int paramInt)
  {
    int i = paramInt + this.a;
    int j = i + this.b.getInt(i);
    return this.b.getInt(j);
  }

  protected int e(int paramInt)
  {
    int i = paramInt + this.a;
    return 4 + (i + this.b.getInt(i));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.c.a
 * JD-Core Version:    0.6.2
 */