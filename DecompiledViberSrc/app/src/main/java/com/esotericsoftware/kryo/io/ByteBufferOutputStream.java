package com.esotericsoftware.kryo.io;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class ByteBufferOutputStream extends OutputStream
{
  private ByteBuffer byteBuffer;

  public ByteBufferOutputStream()
  {
  }

  public ByteBufferOutputStream(int paramInt)
  {
    this(ByteBuffer.allocate(paramInt));
  }

  public ByteBufferOutputStream(ByteBuffer paramByteBuffer)
  {
    this.byteBuffer = paramByteBuffer;
  }

  public ByteBuffer getByteBuffer()
  {
    return this.byteBuffer;
  }

  public void setByteBuffer(ByteBuffer paramByteBuffer)
  {
    this.byteBuffer = paramByteBuffer;
  }

  public void write(int paramInt)
    throws IOException
  {
    if (!this.byteBuffer.hasRemaining())
      flush();
    this.byteBuffer.put((byte)paramInt);
  }

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.byteBuffer.remaining() < paramInt2)
      flush();
    this.byteBuffer.put(paramArrayOfByte, paramInt1, paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.io.ByteBufferOutputStream
 * JD-Core Version:    0.6.2
 */