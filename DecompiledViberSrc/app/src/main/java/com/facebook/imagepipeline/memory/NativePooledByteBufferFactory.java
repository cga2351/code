package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.common.references.CloseableReference;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class NativePooledByteBufferFactory
  implements PooledByteBufferFactory
{
  private final NativeMemoryChunkPool mPool;
  private final PooledByteStreams mPooledByteStreams;

  public NativePooledByteBufferFactory(NativeMemoryChunkPool paramNativeMemoryChunkPool, PooledByteStreams paramPooledByteStreams)
  {
    this.mPool = paramNativeMemoryChunkPool;
    this.mPooledByteStreams = paramPooledByteStreams;
  }

  @VisibleForTesting
  NativePooledByteBuffer newByteBuf(InputStream paramInputStream, NativePooledByteBufferOutputStream paramNativePooledByteBufferOutputStream)
    throws IOException
  {
    this.mPooledByteStreams.copy(paramInputStream, paramNativePooledByteBufferOutputStream);
    return paramNativePooledByteBufferOutputStream.toByteBuffer();
  }

  public NativePooledByteBuffer newByteBuffer(int paramInt)
  {
    boolean bool;
    if (paramInt > 0)
      bool = true;
    while (true)
    {
      Preconditions.checkArgument(bool);
      CloseableReference localCloseableReference = CloseableReference.of(this.mPool.get(paramInt), this.mPool);
      try
      {
        NativePooledByteBuffer localNativePooledByteBuffer = new NativePooledByteBuffer(localCloseableReference, paramInt);
        return localNativePooledByteBuffer;
        bool = false;
      }
      finally
      {
        localCloseableReference.close();
      }
    }
  }

  public NativePooledByteBuffer newByteBuffer(InputStream paramInputStream)
    throws IOException
  {
    NativePooledByteBufferOutputStream localNativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.mPool);
    try
    {
      NativePooledByteBuffer localNativePooledByteBuffer = newByteBuf(paramInputStream, localNativePooledByteBufferOutputStream);
      return localNativePooledByteBuffer;
    }
    finally
    {
      localNativePooledByteBufferOutputStream.close();
    }
  }

  public NativePooledByteBuffer newByteBuffer(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    NativePooledByteBufferOutputStream localNativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.mPool, paramInt);
    try
    {
      NativePooledByteBuffer localNativePooledByteBuffer = newByteBuf(paramInputStream, localNativePooledByteBufferOutputStream);
      return localNativePooledByteBuffer;
    }
    finally
    {
      localNativePooledByteBufferOutputStream.close();
    }
  }

  public NativePooledByteBuffer newByteBuffer(byte[] paramArrayOfByte)
  {
    NativePooledByteBufferOutputStream localNativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.mPool, paramArrayOfByte.length);
    try
    {
      localNativePooledByteBufferOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      NativePooledByteBuffer localNativePooledByteBuffer = localNativePooledByteBufferOutputStream.toByteBuffer();
      return localNativePooledByteBuffer;
    }
    catch (IOException localIOException)
    {
      throw Throwables.propagate(localIOException);
    }
    finally
    {
      localNativePooledByteBufferOutputStream.close();
    }
  }

  public NativePooledByteBufferOutputStream newOutputStream()
  {
    return new NativePooledByteBufferOutputStream(this.mPool);
  }

  public NativePooledByteBufferOutputStream newOutputStream(int paramInt)
  {
    return new NativePooledByteBufferOutputStream(this.mPool, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.memory.NativePooledByteBufferFactory
 * JD-Core Version:    0.6.2
 */