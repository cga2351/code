package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class GenericByteArrayPool extends BasePool<byte[]>
  implements ByteArrayPool
{
  private final int[] mBucketSizes;

  public GenericByteArrayPool(MemoryTrimmableRegistry paramMemoryTrimmableRegistry, PoolParams paramPoolParams, PoolStatsTracker paramPoolStatsTracker)
  {
    super(paramMemoryTrimmableRegistry, paramPoolParams, paramPoolStatsTracker);
    SparseIntArray localSparseIntArray = paramPoolParams.bucketSizes;
    this.mBucketSizes = new int[localSparseIntArray.size()];
    for (int i = 0; i < localSparseIntArray.size(); i++)
      this.mBucketSizes[i] = localSparseIntArray.keyAt(i);
    initialize();
  }

  protected byte[] alloc(int paramInt)
  {
    return new byte[paramInt];
  }

  protected void free(byte[] paramArrayOfByte)
  {
    Preconditions.checkNotNull(paramArrayOfByte);
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

  protected int getBucketedSizeForValue(byte[] paramArrayOfByte)
  {
    Preconditions.checkNotNull(paramArrayOfByte);
    return paramArrayOfByte.length;
  }

  public int getMinBufferSize()
  {
    return this.mBucketSizes[0];
  }

  protected int getSizeInBytes(int paramInt)
  {
    return paramInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.memory.GenericByteArrayPool
 * JD-Core Version:    0.6.2
 */