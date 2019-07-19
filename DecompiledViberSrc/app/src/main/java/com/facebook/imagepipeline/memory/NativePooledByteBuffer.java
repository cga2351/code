package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBuffer.ClosedException;
import com.facebook.common.references.CloseableReference;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class NativePooledByteBuffer
  implements PooledByteBuffer
{

  @VisibleForTesting
  @GuardedBy("this")
  CloseableReference<NativeMemoryChunk> mBufRef;
  private final int mSize;

  public NativePooledByteBuffer(CloseableReference<NativeMemoryChunk> paramCloseableReference, int paramInt)
  {
    Preconditions.checkNotNull(paramCloseableReference);
    if ((paramInt >= 0) && (paramInt <= ((NativeMemoryChunk)paramCloseableReference.get()).getSize()));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.mBufRef = paramCloseableReference.clone();
      this.mSize = paramInt;
      return;
    }
  }

  public void close()
  {
    try
    {
      CloseableReference.closeSafely(this.mBufRef);
      this.mBufRef = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void ensureValid()
  {
    try
    {
      if (isClosed())
        throw new PooledByteBuffer.ClosedException();
    }
    finally
    {
    }
  }

  public long getNativePtr()
  {
    try
    {
      ensureValid();
      long l = ((NativeMemoryChunk)this.mBufRef.get()).getNativePtr();
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean isClosed()
  {
    try
    {
      boolean bool1 = CloseableReference.isValid(this.mBufRef);
      if (!bool1)
      {
        bool2 = true;
        return bool2;
      }
      boolean bool2 = false;
    }
    finally
    {
    }
  }

  public byte read(int paramInt)
  {
    boolean bool1 = true;
    try
    {
      ensureValid();
      boolean bool2;
      if (paramInt >= 0)
      {
        bool2 = bool1;
        Preconditions.checkArgument(bool2);
        if (paramInt >= this.mSize)
          break label59;
      }
      while (true)
      {
        Preconditions.checkArgument(bool1);
        byte b = ((NativeMemoryChunk)this.mBufRef.get()).read(paramInt);
        return b;
        bool2 = false;
        break;
        label59: bool1 = false;
      }
    }
    finally
    {
    }
  }

  public int read(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    try
    {
      ensureValid();
      if (paramInt1 + paramInt3 <= this.mSize);
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkArgument(bool);
        int i = ((NativeMemoryChunk)this.mBufRef.get()).read(paramInt1, paramArrayOfByte, paramInt2, paramInt3);
        return i;
      }
    }
    finally
    {
    }
  }

  public int size()
  {
    try
    {
      ensureValid();
      int i = this.mSize;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.memory.NativePooledByteBuffer
 * JD-Core Version:    0.6.2
 */