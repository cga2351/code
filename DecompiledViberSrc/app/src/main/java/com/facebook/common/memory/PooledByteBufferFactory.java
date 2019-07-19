package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;

public abstract interface PooledByteBufferFactory
{
  public abstract PooledByteBuffer newByteBuffer(int paramInt);

  public abstract PooledByteBuffer newByteBuffer(InputStream paramInputStream)
    throws IOException;

  public abstract PooledByteBuffer newByteBuffer(InputStream paramInputStream, int paramInt)
    throws IOException;

  public abstract PooledByteBuffer newByteBuffer(byte[] paramArrayOfByte);

  public abstract PooledByteBufferOutputStream newOutputStream();

  public abstract PooledByteBufferOutputStream newOutputStream(int paramInt);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.memory.PooledByteBufferFactory
 * JD-Core Version:    0.6.2
 */