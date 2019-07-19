package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.OOMSoftReference;
import com.facebook.common.references.ResourceReleaser;
import java.util.concurrent.Semaphore;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class SharedByteArray
  implements MemoryTrimmable
{

  @VisibleForTesting
  final OOMSoftReference<byte[]> mByteArraySoftRef;

  @VisibleForTesting
  final int mMaxByteArraySize;

  @VisibleForTesting
  final int mMinByteArraySize;
  private final ResourceReleaser<byte[]> mResourceReleaser;

  @VisibleForTesting
  final Semaphore mSemaphore;

  public SharedByteArray(MemoryTrimmableRegistry paramMemoryTrimmableRegistry, PoolParams paramPoolParams)
  {
    Preconditions.checkNotNull(paramMemoryTrimmableRegistry);
    if (paramPoolParams.minBucketSize > 0);
    for (boolean bool1 = true; ; bool1 = false)
    {
      Preconditions.checkArgument(bool1);
      int i = paramPoolParams.maxBucketSize;
      int j = paramPoolParams.minBucketSize;
      boolean bool2 = false;
      if (i >= j)
        bool2 = true;
      Preconditions.checkArgument(bool2);
      this.mMaxByteArraySize = paramPoolParams.maxBucketSize;
      this.mMinByteArraySize = paramPoolParams.minBucketSize;
      this.mByteArraySoftRef = new OOMSoftReference();
      this.mSemaphore = new Semaphore(1);
      this.mResourceReleaser = new ResourceReleaser()
      {
        public void release(byte[] paramAnonymousArrayOfByte)
        {
          SharedByteArray.this.mSemaphore.release();
        }
      };
      paramMemoryTrimmableRegistry.registerMemoryTrimmable(this);
      return;
    }
  }

  private byte[] allocateByteArray(int paramInt)
  {
    try
    {
      this.mByteArraySoftRef.clear();
      byte[] arrayOfByte = new byte[paramInt];
      this.mByteArraySoftRef.set(arrayOfByte);
      return arrayOfByte;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private byte[] getByteArray(int paramInt)
  {
    int i = getBucketedSize(paramInt);
    byte[] arrayOfByte = (byte[])this.mByteArraySoftRef.get();
    if ((arrayOfByte == null) || (arrayOfByte.length < i))
      arrayOfByte = allocateByteArray(i);
    return arrayOfByte;
  }

  public CloseableReference<byte[]> get(int paramInt)
  {
    boolean bool1 = true;
    boolean bool2;
    if (paramInt > 0)
      bool2 = bool1;
    while (true)
    {
      Preconditions.checkArgument(bool2, "Size must be greater than zero");
      if (paramInt <= this.mMaxByteArraySize)
      {
        Preconditions.checkArgument(bool1, "Requested size is too big");
        this.mSemaphore.acquireUninterruptibly();
      }
      try
      {
        CloseableReference localCloseableReference = CloseableReference.of(getByteArray(paramInt), this.mResourceReleaser);
        return localCloseableReference;
        bool2 = false;
        continue;
        bool1 = false;
      }
      catch (Throwable localThrowable)
      {
        this.mSemaphore.release();
        throw Throwables.propagate(localThrowable);
      }
    }
  }

  @VisibleForTesting
  int getBucketedSize(int paramInt)
  {
    return 2 * Integer.highestOneBit(-1 + Math.max(paramInt, this.mMinByteArraySize));
  }

  public void trim(MemoryTrimType paramMemoryTrimType)
  {
    if (!this.mSemaphore.tryAcquire())
      return;
    try
    {
      this.mByteArraySoftRef.clear();
      return;
    }
    finally
    {
      this.mSemaphore.release();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.memory.SharedByteArray
 * JD-Core Version:    0.6.2
 */