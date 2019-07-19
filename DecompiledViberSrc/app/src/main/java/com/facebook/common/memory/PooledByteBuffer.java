package com.facebook.common.memory;

import java.io.Closeable;

public abstract interface PooledByteBuffer extends Closeable
{
  public abstract void close();

  public abstract long getNativePtr();

  public abstract boolean isClosed();

  public abstract byte read(int paramInt);

  public abstract int read(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);

  public abstract int size();

  public static class ClosedException extends RuntimeException
  {
    public ClosedException()
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.memory.PooledByteBuffer
 * JD-Core Version:    0.6.2
 */