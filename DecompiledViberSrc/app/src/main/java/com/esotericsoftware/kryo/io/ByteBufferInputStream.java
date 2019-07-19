package com.esotericsoftware.kryo.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteBufferInputStream extends InputStream
{
  private ByteBuffer byteBuffer;

  public ByteBufferInputStream()
  {
  }

  public ByteBufferInputStream(int paramInt)
  {
    this(ByteBuffer.allocate(paramInt));
    this.byteBuffer.flip();
  }

  public ByteBufferInputStream(ByteBuffer paramByteBuffer)
  {
    this.byteBuffer = paramByteBuffer;
  }

  public int available()
    throws IOException
  {
    return this.byteBuffer.remaining();
  }

  public ByteBuffer getByteBuffer()
  {
    return this.byteBuffer;
  }

  public int read()
    throws IOException
  {
    if (!this.byteBuffer.hasRemaining())
      return -1;
    return this.byteBuffer.get();
  }

  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 == 0)
      return 0;
    int i = Math.min(this.byteBuffer.remaining(), paramInt2);
    if (i == 0)
      return -1;
    this.byteBuffer.get(paramArrayOfByte, paramInt1, i);
    return i;
  }

  public void setByteBuffer(ByteBuffer paramByteBuffer)
  {
    this.byteBuffer = paramByteBuffer;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.io.ByteBufferInputStream
 * JD-Core Version:    0.6.2
 */