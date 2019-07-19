package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class NativeMemoryChunkPool extends BasePool<NativeMemoryChunk>
{
  private final int[] mBucketSizes;

  public NativeMemoryChunkPool(MemoryTrimmableRegistry paramMemoryTrimmableRegistry, PoolParams paramPoolParams, PoolStatsTracker paramPoolStatsTracker)
  {
    super(paramMemoryTrimmableRegistry, paramPoolParams, paramPoolStatsTracker);
    SparseIntArray localSparseIntArray = paramPoolParams.bucketSizes;
    this.mBucketSizes = new int[localSparseIntArray.size()];
    for (int i = 0; i < this.mBucketSizes.length; i++)
      this.mBucketSizes[i] = localSparseIntArray.keyAt(i);
    initialize();
  }

  protected NativeMemoryChunk alloc(int paramInt)
  {
    return new NativeMemoryChunk(paramInt);
  }

  protected void free(NativeMemoryChunk paramNativeMemoryChunk)
  {
    Preconditions.checkNotNull(paramNativeMemoryChunk);
    paramNativeMemoryChunk.close();
  }

  protected int getBucketedSize(int paramInt)
  {
    if (paramInt <= 0)
      throw new BasePool.InvalidSizeException(Integer.valueOf(paramInt));
    int[] arrayOfInt = this.mBucketSizes;
    int i = arrayOfInt.length;
    for (int j = 0; ; j++)
      if (j < i)
      {
        int k = arrayOfInt[j];
        if (k >= paramInt)
          paramInt = k;
      }
      else
      {
        return paramInt;
      }
  }

  protected int getBucketedSizeForValue(NativeMemoryChunk paramNativeMemoryChunk)
  {
    Preconditions.checkNotNull(paramNativeMemoryChunk);
    return paramNativeMemoryChunk.getSize();
  }

  public int getMinBufferSize()
  {
    return this.mBucketSizes[0];
  }

  protected int getSizeInBytes(int paramInt)
  {
    return paramInt;
  }

  protected boolean isReusable(NativeMemoryChunk paramNativeMemoryChunk)
  {
    Preconditions.checkNotNull(paramNativeMemoryChunk);
    return !paramNativeMemoryChunk.isClosed();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.memory.NativeMemoryChunkPool
 * JD-Core Version:    0.6.2
 */