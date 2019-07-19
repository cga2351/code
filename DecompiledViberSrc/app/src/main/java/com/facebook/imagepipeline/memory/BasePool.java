package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.common.internal.Throwables;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.Pool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;

public abstract class BasePool<V>
  implements Pool<V>
{
  private final Class<?> TAG = getClass();
  private boolean mAllowNewBuckets;

  @VisibleForTesting
  final SparseArray<Bucket<V>> mBuckets;

  @VisibleForTesting
  @GuardedBy("this")
  final Counter mFree;

  @VisibleForTesting
  final Set<V> mInUseValues;
  final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
  final PoolParams mPoolParams;
  private final PoolStatsTracker mPoolStatsTracker;

  @VisibleForTesting
  @GuardedBy("this")
  final Counter mUsed;

  public BasePool(MemoryTrimmableRegistry paramMemoryTrimmableRegistry, PoolParams paramPoolParams, PoolStatsTracker paramPoolStatsTracker)
  {
    this.mMemoryTrimmableRegistry = ((MemoryTrimmableRegistry)Preconditions.checkNotNull(paramMemoryTrimmableRegistry));
    this.mPoolParams = ((PoolParams)Preconditions.checkNotNull(paramPoolParams));
    this.mPoolStatsTracker = ((PoolStatsTracker)Preconditions.checkNotNull(paramPoolStatsTracker));
    this.mBuckets = new SparseArray();
    if (this.mPoolParams.fixBucketsReinitialization)
      initBuckets();
    while (true)
    {
      this.mInUseValues = Sets.newIdentityHashSet();
      this.mFree = new Counter();
      this.mUsed = new Counter();
      return;
      legacyInitBuckets(new SparseIntArray(0));
    }
  }

  private void ensurePoolSizeInvariant()
  {
    while (true)
    {
      try
      {
        if (isMaxSizeSoftCapExceeded())
          if (this.mFree.mNumBytes == 0)
          {
            break label39;
            Preconditions.checkState(bool);
          }
          else
          {
            bool = false;
            continue;
          }
      }
      finally
      {
      }
      label39: boolean bool = true;
    }
  }

  private void fillBuckets(SparseIntArray paramSparseIntArray)
  {
    this.mBuckets.clear();
    for (int i = 0; i < paramSparseIntArray.size(); i++)
    {
      int j = paramSparseIntArray.keyAt(i);
      int k = paramSparseIntArray.valueAt(i);
      this.mBuckets.put(j, new Bucket(getSizeInBytes(j), k, 0, this.mPoolParams.fixBucketsReinitialization));
    }
  }

  private Bucket<V> getBucketIfPresent(int paramInt)
  {
    try
    {
      Bucket localBucket = (Bucket)this.mBuckets.get(paramInt);
      return localBucket;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void initBuckets()
  {
    try
    {
      SparseIntArray localSparseIntArray = this.mPoolParams.bucketSizes;
      if (localSparseIntArray != null)
        fillBuckets(localSparseIntArray);
      for (this.mAllowNewBuckets = false; ; this.mAllowNewBuckets = true)
        return;
    }
    finally
    {
    }
  }

  private void legacyInitBuckets(SparseIntArray paramSparseIntArray)
  {
    try
    {
      Preconditions.checkNotNull(paramSparseIntArray);
      this.mBuckets.clear();
      SparseIntArray localSparseIntArray = this.mPoolParams.bucketSizes;
      int i = 0;
      if (localSparseIntArray != null)
        while (i < localSparseIntArray.size())
        {
          int j = localSparseIntArray.keyAt(i);
          int k = localSparseIntArray.valueAt(i);
          int m = paramSparseIntArray.get(j, 0);
          this.mBuckets.put(j, new Bucket(getSizeInBytes(j), k, m, this.mPoolParams.fixBucketsReinitialization));
          i++;
        }
      for (this.mAllowNewBuckets = false; ; this.mAllowNewBuckets = true)
        return;
    }
    finally
    {
    }
  }

  @SuppressLint({"InvalidAccessToGuardedField"})
  private void logStats()
  {
    if (FLog.isLoggable(2))
      FLog.v(this.TAG, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.mUsed.mCount), Integer.valueOf(this.mUsed.mNumBytes), Integer.valueOf(this.mFree.mCount), Integer.valueOf(this.mFree.mNumBytes));
  }

  private List<Bucket<V>> refillBuckets()
  {
    ArrayList localArrayList = new ArrayList(this.mBuckets.size());
    int i = this.mBuckets.size();
    for (int j = 0; j < i; j++)
    {
      Bucket localBucket = (Bucket)this.mBuckets.valueAt(j);
      int k = localBucket.mItemSize;
      int m = localBucket.mMaxLength;
      int n = localBucket.getInUseCount();
      if (localBucket.getFreeListSize() > 0)
        localArrayList.add(localBucket);
      this.mBuckets.setValueAt(j, new Bucket(getSizeInBytes(k), m, n, this.mPoolParams.fixBucketsReinitialization));
    }
    return localArrayList;
  }

  protected abstract V alloc(int paramInt);

  @VisibleForTesting
  boolean canAllocate(int paramInt)
  {
    boolean bool = false;
    while (true)
    {
      try
      {
        int i = this.mPoolParams.maxSizeHardCap;
        if (paramInt > i - this.mUsed.mNumBytes)
        {
          this.mPoolStatsTracker.onHardCapReached();
          return bool;
        }
        int j = this.mPoolParams.maxSizeSoftCap;
        if (paramInt > j - (this.mUsed.mNumBytes + this.mFree.mNumBytes))
          trimToSize(j - paramInt);
        if (paramInt > i - (this.mUsed.mNumBytes + this.mFree.mNumBytes))
        {
          this.mPoolStatsTracker.onHardCapReached();
          bool = false;
          continue;
        }
      }
      finally
      {
      }
      bool = true;
    }
  }

  @VisibleForTesting
  protected abstract void free(V paramV);

  public V get(int paramInt)
  {
    ensurePoolSizeInvariant();
    int i = getBucketedSize(paramInt);
    Bucket localBucket1;
    int m;
    try
    {
      localBucket1 = getBucket(i);
      if (localBucket1 != null)
      {
        Object localObject2 = localBucket1.get();
        if (localObject2 != null)
        {
          Preconditions.checkState(this.mInUseValues.add(localObject2));
          int j = getBucketedSizeForValue(localObject2);
          int k = getSizeInBytes(j);
          this.mUsed.increment(k);
          this.mFree.decrement(k);
          this.mPoolStatsTracker.onValueReuse(k);
          logStats();
          if (FLog.isLoggable(2))
            FLog.v(this.TAG, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(localObject2)), Integer.valueOf(j));
          return localObject2;
        }
      }
      m = getSizeInBytes(i);
      if (!canAllocate(m))
        throw new PoolSizeViolationException(this.mPoolParams.maxSizeHardCap, this.mUsed.mNumBytes, this.mFree.mNumBytes, m);
    }
    finally
    {
    }
    this.mUsed.increment(m);
    if (localBucket1 != null)
      localBucket1.incrementInUseCount();
    try
    {
      Object localObject6 = alloc(i);
      localObject4 = localObject6;
      try
      {
        Preconditions.checkState(this.mInUseValues.add(localObject4));
        trimToSoftCap();
        this.mPoolStatsTracker.onAlloc(m);
        logStats();
        if (FLog.isLoggable(2))
          FLog.v(this.TAG, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(localObject4)), Integer.valueOf(i));
        return localObject4;
      }
      finally
      {
      }
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        Object localObject4;
        try
        {
          this.mUsed.decrement(m);
          Bucket localBucket2 = getBucket(i);
          if (localBucket2 != null)
            localBucket2.decrementInUseCount();
          Throwables.propagateIfPossible(localThrowable);
          localObject4 = null;
        }
        finally
        {
        }
      }
    }
  }

  @VisibleForTesting
  Bucket<V> getBucket(int paramInt)
  {
    try
    {
      Bucket localBucket = (Bucket)this.mBuckets.get(paramInt);
      if (localBucket == null)
      {
        boolean bool = this.mAllowNewBuckets;
        if (bool)
          break label33;
      }
      while (true)
      {
        return localBucket;
        label33: if (FLog.isLoggable(2))
          FLog.v(this.TAG, "creating new bucket %s", Integer.valueOf(paramInt));
        localBucket = newBucket(paramInt);
        this.mBuckets.put(paramInt, localBucket);
      }
    }
    finally
    {
    }
  }

  protected abstract int getBucketedSize(int paramInt);

  protected abstract int getBucketedSizeForValue(V paramV);

  protected abstract int getSizeInBytes(int paramInt);

  public Map<String, Integer> getStats()
  {
    try
    {
      HashMap localHashMap = new HashMap();
      for (int i = 0; i < this.mBuckets.size(); i++)
      {
        int j = this.mBuckets.keyAt(i);
        Bucket localBucket = (Bucket)this.mBuckets.valueAt(i);
        localHashMap.put("buckets_used_" + getSizeInBytes(j), Integer.valueOf(localBucket.getInUseCount()));
      }
      localHashMap.put("soft_cap", Integer.valueOf(this.mPoolParams.maxSizeSoftCap));
      localHashMap.put("hard_cap", Integer.valueOf(this.mPoolParams.maxSizeHardCap));
      localHashMap.put("used_count", Integer.valueOf(this.mUsed.mCount));
      localHashMap.put("used_bytes", Integer.valueOf(this.mUsed.mNumBytes));
      localHashMap.put("free_count", Integer.valueOf(this.mFree.mCount));
      localHashMap.put("free_bytes", Integer.valueOf(this.mFree.mNumBytes));
      return localHashMap;
    }
    finally
    {
    }
  }

  protected void initialize()
  {
    this.mMemoryTrimmableRegistry.registerMemoryTrimmable(this);
    this.mPoolStatsTracker.setBasePool(this);
  }

  @VisibleForTesting
  boolean isMaxSizeSoftCapExceeded()
  {
    try
    {
      if (this.mUsed.mNumBytes + this.mFree.mNumBytes > this.mPoolParams.maxSizeSoftCap);
      for (boolean bool = true; ; bool = false)
      {
        if (bool)
          this.mPoolStatsTracker.onSoftCapReached();
        return bool;
      }
    }
    finally
    {
    }
  }

  protected boolean isReusable(V paramV)
  {
    Preconditions.checkNotNull(paramV);
    return true;
  }

  Bucket<V> newBucket(int paramInt)
  {
    return new Bucket(getSizeInBytes(paramInt), 2147483647, 0, this.mPoolParams.fixBucketsReinitialization);
  }

  protected void onParamsChanged()
  {
  }

  public void release(V paramV)
  {
    Preconditions.checkNotNull(paramV);
    int i = getBucketedSizeForValue(paramV);
    int j = getSizeInBytes(i);
    while (true)
    {
      Bucket localBucket;
      try
      {
        localBucket = getBucketIfPresent(i);
        if (!this.mInUseValues.remove(paramV))
        {
          Class localClass = this.TAG;
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = Integer.valueOf(System.identityHashCode(paramV));
          arrayOfObject[1] = Integer.valueOf(i);
          FLog.e(localClass, "release (free, value unrecognized) (object, size) = (%x, %s)", arrayOfObject);
          free(paramV);
          this.mPoolStatsTracker.onFree(j);
          logStats();
          return;
        }
        if ((localBucket == null) || (localBucket.isMaxLengthExceeded()) || (isMaxSizeSoftCapExceeded()) || (!isReusable(paramV)))
        {
          if (localBucket != null)
            localBucket.decrementInUseCount();
          if (FLog.isLoggable(2))
            FLog.v(this.TAG, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(paramV)), Integer.valueOf(i));
          free(paramV);
          this.mUsed.decrement(j);
          this.mPoolStatsTracker.onFree(j);
          continue;
        }
      }
      finally
      {
      }
      localBucket.release(paramV);
      this.mFree.increment(j);
      this.mUsed.decrement(j);
      this.mPoolStatsTracker.onValueRelease(j);
      if (FLog.isLoggable(2))
        FLog.v(this.TAG, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(paramV)), Integer.valueOf(i));
    }
  }

  public void trim(MemoryTrimType paramMemoryTrimType)
  {
    trimToNothing();
  }

  @VisibleForTesting
  void trimToNothing()
  {
    int i = 0;
    while (true)
    {
      Object localObject3;
      try
      {
        Object localObject2;
        if (this.mPoolParams.fixBucketsReinitialization)
        {
          localObject2 = refillBuckets();
          this.mFree.reset();
          logStats();
          onParamsChanged();
          if (i >= ((List)localObject2).size())
            break;
          Bucket localBucket1 = (Bucket)((List)localObject2).get(i);
          localObject3 = localBucket1.pop();
          if (localObject3 == null)
          {
            i++;
            continue;
          }
        }
        else
        {
          localObject2 = new ArrayList(this.mBuckets.size());
          SparseIntArray localSparseIntArray = new SparseIntArray();
          int j = 0;
          if (j < this.mBuckets.size())
          {
            Bucket localBucket2 = (Bucket)this.mBuckets.valueAt(j);
            if (localBucket2.getFreeListSize() > 0)
              ((List)localObject2).add(localBucket2);
            localSparseIntArray.put(this.mBuckets.keyAt(j), localBucket2.getInUseCount());
            j++;
            continue;
          }
          legacyInitBuckets(localSparseIntArray);
          continue;
        }
      }
      finally
      {
      }
      free(localObject3);
    }
  }

  @VisibleForTesting
  void trimToSize(int paramInt)
  {
    while (true)
    {
      int j;
      int k;
      try
      {
        int i = Math.min(this.mUsed.mNumBytes + this.mFree.mNumBytes - paramInt, this.mFree.mNumBytes);
        j = i;
        if (j <= 0)
          return;
        if (FLog.isLoggable(2))
          FLog.v(this.TAG, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(paramInt), Integer.valueOf(this.mUsed.mNumBytes + this.mFree.mNumBytes), Integer.valueOf(j));
        logStats();
        k = 0;
        if ((k >= this.mBuckets.size()) || (j <= 0))
        {
          logStats();
          if (!FLog.isLoggable(2))
            continue;
          FLog.v(this.TAG, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(paramInt), Integer.valueOf(this.mUsed.mNumBytes + this.mFree.mNumBytes));
          continue;
        }
      }
      finally
      {
      }
      Bucket localBucket = (Bucket)this.mBuckets.valueAt(k);
      while (j > 0)
      {
        Object localObject2 = localBucket.pop();
        if (localObject2 == null)
          break;
        free(localObject2);
        j -= localBucket.mItemSize;
        this.mFree.decrement(localBucket.mItemSize);
      }
      k++;
    }
  }

  @VisibleForTesting
  void trimToSoftCap()
  {
    try
    {
      if (isMaxSizeSoftCapExceeded())
        trimToSize(this.mPoolParams.maxSizeSoftCap);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  @VisibleForTesting
  @NotThreadSafe
  static class Counter
  {
    private static final String TAG = "com.facebook.imagepipeline.memory.BasePool.Counter";
    int mCount;
    int mNumBytes;

    public void decrement(int paramInt)
    {
      if ((this.mNumBytes >= paramInt) && (this.mCount > 0))
      {
        this.mCount = (-1 + this.mCount);
        this.mNumBytes -= paramInt;
        return;
      }
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      arrayOfObject[1] = Integer.valueOf(this.mNumBytes);
      arrayOfObject[2] = Integer.valueOf(this.mCount);
      FLog.wtf("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", arrayOfObject);
    }

    public void increment(int paramInt)
    {
      this.mCount = (1 + this.mCount);
      this.mNumBytes = (paramInt + this.mNumBytes);
    }

    public void reset()
    {
      this.mCount = 0;
      this.mNumBytes = 0;
    }
  }

  public static class InvalidSizeException extends RuntimeException
  {
    public InvalidSizeException(Object paramObject)
    {
      super();
    }
  }

  public static class InvalidValueException extends RuntimeException
  {
    public InvalidValueException(Object paramObject)
    {
      super();
    }
  }

  public static class PoolSizeViolationException extends RuntimeException
  {
    public PoolSizeViolationException(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super();
    }
  }

  public static class SizeTooLargeException extends BasePool.InvalidSizeException
  {
    public SizeTooLargeException(Object paramObject)
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.memory.BasePool
 * JD-Core Version:    0.6.2
 */