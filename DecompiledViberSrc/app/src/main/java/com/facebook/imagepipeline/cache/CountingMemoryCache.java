package com.facebook.imagepipeline.cache;

import android.graphics.Bitmap;
import android.os.SystemClock;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class CountingMemoryCache<K, V>
  implements MemoryTrimmable, MemoryCache<K, V>
{

  @VisibleForTesting
  static final long PARAMS_INTERCHECK_INTERVAL_MS = TimeUnit.MINUTES.toMillis(5L);
  private final CacheTrimStrategy mCacheTrimStrategy;

  @VisibleForTesting
  @GuardedBy("this")
  final CountingLruMap<K, Entry<K, V>> mCachedEntries;

  @VisibleForTesting
  @GuardedBy("this")
  final CountingLruMap<K, Entry<K, V>> mExclusiveEntries;

  @GuardedBy("this")
  private long mLastCacheParamsCheck;

  @GuardedBy("this")
  protected MemoryCacheParams mMemoryCacheParams;
  private final Supplier<MemoryCacheParams> mMemoryCacheParamsSupplier;

  @VisibleForTesting
  @GuardedBy("this")
  final Map<Bitmap, Object> mOtherEntries = new WeakHashMap();
  private final ValueDescriptor<V> mValueDescriptor;

  public CountingMemoryCache(ValueDescriptor<V> paramValueDescriptor, CacheTrimStrategy paramCacheTrimStrategy, Supplier<MemoryCacheParams> paramSupplier)
  {
    this.mValueDescriptor = paramValueDescriptor;
    this.mExclusiveEntries = new CountingLruMap(wrapValueDescriptor(paramValueDescriptor));
    this.mCachedEntries = new CountingLruMap(wrapValueDescriptor(paramValueDescriptor));
    this.mCacheTrimStrategy = paramCacheTrimStrategy;
    this.mMemoryCacheParamsSupplier = paramSupplier;
    this.mMemoryCacheParams = ((MemoryCacheParams)this.mMemoryCacheParamsSupplier.get());
    this.mLastCacheParamsCheck = SystemClock.uptimeMillis();
  }

  private boolean canCacheNewValue(V paramV)
  {
    try
    {
      int i = this.mValueDescriptor.getSizeInBytes(paramV);
      if ((i <= this.mMemoryCacheParams.maxCacheEntrySize) && (getInUseCount() <= -1 + this.mMemoryCacheParams.maxCacheEntries))
      {
        int j = getInUseSizeInBytes();
        int k = this.mMemoryCacheParams.maxCacheSize;
        if (j <= k - i)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  private void decreaseClientCount(Entry<K, V> paramEntry)
  {
    try
    {
      Preconditions.checkNotNull(paramEntry);
      if (paramEntry.clientCount > 0);
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkState(bool);
        paramEntry.clientCount = (-1 + paramEntry.clientCount);
        return;
      }
    }
    finally
    {
    }
  }

  private void increaseClientCount(Entry<K, V> paramEntry)
  {
    try
    {
      Preconditions.checkNotNull(paramEntry);
      if (!paramEntry.isOrphan);
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkState(bool);
        paramEntry.clientCount = (1 + paramEntry.clientCount);
        return;
      }
    }
    finally
    {
    }
  }

  private void makeOrphan(Entry<K, V> paramEntry)
  {
    boolean bool = true;
    try
    {
      Preconditions.checkNotNull(paramEntry);
      if (!paramEntry.isOrphan);
      while (true)
      {
        Preconditions.checkState(bool);
        paramEntry.isOrphan = true;
        return;
        bool = false;
      }
    }
    finally
    {
    }
  }

  private void makeOrphans(@Nullable ArrayList<Entry<K, V>> paramArrayList)
  {
    if (paramArrayList != null)
      try
      {
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext())
          makeOrphan((Entry)localIterator.next());
      }
      finally
      {
      }
  }

  private boolean maybeAddToExclusives(Entry<K, V> paramEntry)
  {
    try
    {
      if ((!paramEntry.isOrphan) && (paramEntry.clientCount == 0))
      {
        this.mExclusiveEntries.put(paramEntry.key, paramEntry);
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  private void maybeClose(@Nullable ArrayList<Entry<K, V>> paramArrayList)
  {
    if (paramArrayList != null)
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
        CloseableReference.closeSafely(referenceToClose((Entry)localIterator.next()));
    }
  }

  private void maybeEvictEntries()
  {
    try
    {
      ArrayList localArrayList = trimExclusivelyOwnedEntries(Math.min(this.mMemoryCacheParams.maxEvictionQueueEntries, this.mMemoryCacheParams.maxCacheEntries - getInUseCount()), Math.min(this.mMemoryCacheParams.maxEvictionQueueSize, this.mMemoryCacheParams.maxCacheSize - getInUseSizeInBytes()));
      makeOrphans(localArrayList);
      maybeClose(localArrayList);
      maybeNotifyExclusiveEntryRemoval(localArrayList);
      return;
    }
    finally
    {
    }
  }

  private static <K, V> void maybeNotifyExclusiveEntryInsertion(@Nullable Entry<K, V> paramEntry)
  {
    if ((paramEntry != null) && (paramEntry.observer != null))
      paramEntry.observer.onExclusivityChanged(paramEntry.key, true);
  }

  private static <K, V> void maybeNotifyExclusiveEntryRemoval(@Nullable Entry<K, V> paramEntry)
  {
    if ((paramEntry != null) && (paramEntry.observer != null))
      paramEntry.observer.onExclusivityChanged(paramEntry.key, false);
  }

  private void maybeNotifyExclusiveEntryRemoval(@Nullable ArrayList<Entry<K, V>> paramArrayList)
  {
    if (paramArrayList != null)
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
        maybeNotifyExclusiveEntryRemoval((Entry)localIterator.next());
    }
  }

  private void maybeUpdateCacheParams()
  {
    try
    {
      long l1 = this.mLastCacheParamsCheck + PARAMS_INTERCHECK_INTERVAL_MS;
      long l2 = SystemClock.uptimeMillis();
      if (l1 > l2);
      while (true)
      {
        return;
        this.mLastCacheParamsCheck = SystemClock.uptimeMillis();
        this.mMemoryCacheParams = ((MemoryCacheParams)this.mMemoryCacheParamsSupplier.get());
      }
    }
    finally
    {
    }
  }

  private CloseableReference<V> newClientReference(final Entry<K, V> paramEntry)
  {
    try
    {
      increaseClientCount(paramEntry);
      CloseableReference localCloseableReference = CloseableReference.of(paramEntry.valueRef.get(), new ResourceReleaser()
      {
        public void release(V paramAnonymousV)
        {
          CountingMemoryCache.this.releaseClientReference(paramEntry);
        }
      });
      return localCloseableReference;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  @Nullable
  private CloseableReference<V> referenceToClose(Entry<K, V> paramEntry)
  {
    try
    {
      Preconditions.checkNotNull(paramEntry);
      if ((paramEntry.isOrphan) && (paramEntry.clientCount == 0))
      {
        localCloseableReference = paramEntry.valueRef;
        return localCloseableReference;
      }
      CloseableReference localCloseableReference = null;
    }
    finally
    {
    }
  }

  private void releaseClientReference(Entry<K, V> paramEntry)
  {
    Preconditions.checkNotNull(paramEntry);
    while (true)
    {
      try
      {
        decreaseClientCount(paramEntry);
        boolean bool = maybeAddToExclusives(paramEntry);
        CloseableReference localCloseableReference = referenceToClose(paramEntry);
        CloseableReference.closeSafely(localCloseableReference);
        if (bool)
        {
          maybeNotifyExclusiveEntryInsertion(paramEntry);
          maybeUpdateCacheParams();
          maybeEvictEntries();
          return;
        }
      }
      finally
      {
      }
      paramEntry = null;
    }
  }

  @Nullable
  private ArrayList<Entry<K, V>> trimExclusivelyOwnedEntries(int paramInt1, int paramInt2)
  {
    try
    {
      int i = Math.max(paramInt1, 0);
      int j = Math.max(paramInt2, 0);
      Object localObject2;
      if (this.mExclusiveEntries.getCount() <= i)
      {
        int k = this.mExclusiveEntries.getSizeInBytes();
        if (k <= j)
          localObject2 = null;
      }
      while (true)
      {
        return localObject2;
        localObject2 = new ArrayList();
        while ((this.mExclusiveEntries.getCount() > i) || (this.mExclusiveEntries.getSizeInBytes() > j))
        {
          Object localObject3 = this.mExclusiveEntries.getFirstKey();
          this.mExclusiveEntries.remove(localObject3);
          ((ArrayList)localObject2).add(this.mCachedEntries.remove(localObject3));
        }
      }
    }
    finally
    {
    }
  }

  private ValueDescriptor<Entry<K, V>> wrapValueDescriptor(final ValueDescriptor<V> paramValueDescriptor)
  {
    return new ValueDescriptor()
    {
      public int getSizeInBytes(CountingMemoryCache.Entry<K, V> paramAnonymousEntry)
      {
        return paramValueDescriptor.getSizeInBytes(paramAnonymousEntry.valueRef.get());
      }
    };
  }

  public CloseableReference<V> cache(K paramK, CloseableReference<V> paramCloseableReference)
  {
    return cache(paramK, paramCloseableReference, null);
  }

  public CloseableReference<V> cache(K paramK, CloseableReference<V> paramCloseableReference, EntryStateObserver<K> paramEntryStateObserver)
  {
    Preconditions.checkNotNull(paramK);
    Preconditions.checkNotNull(paramCloseableReference);
    maybeUpdateCacheParams();
    while (true)
    {
      try
      {
        Entry localEntry1 = (Entry)this.mExclusiveEntries.remove(paramK);
        Entry localEntry2 = (Entry)this.mCachedEntries.remove(paramK);
        if (localEntry2 == null)
          break label131;
        makeOrphan(localEntry2);
        localCloseableReference1 = referenceToClose(localEntry2);
        if (canCacheNewValue(paramCloseableReference.get()))
        {
          Entry localEntry3 = Entry.of(paramK, paramCloseableReference, paramEntryStateObserver);
          this.mCachedEntries.put(paramK, localEntry3);
          localCloseableReference2 = newClientReference(localEntry3);
          CloseableReference.closeSafely(localCloseableReference1);
          maybeNotifyExclusiveEntryRemoval(localEntry1);
          maybeEvictEntries();
          return localCloseableReference2;
        }
      }
      finally
      {
      }
      CloseableReference localCloseableReference2 = null;
      continue;
      label131: CloseableReference localCloseableReference1 = null;
    }
  }

  public void clear()
  {
    try
    {
      ArrayList localArrayList1 = this.mExclusiveEntries.clear();
      ArrayList localArrayList2 = this.mCachedEntries.clear();
      makeOrphans(localArrayList2);
      maybeClose(localArrayList2);
      maybeNotifyExclusiveEntryRemoval(localArrayList1);
      maybeUpdateCacheParams();
      return;
    }
    finally
    {
    }
  }

  public boolean contains(Predicate<K> paramPredicate)
  {
    try
    {
      boolean bool1 = this.mCachedEntries.getMatchingEntries(paramPredicate).isEmpty();
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

  public boolean contains(K paramK)
  {
    try
    {
      boolean bool = this.mCachedEntries.contains(paramK);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  @Nullable
  public CloseableReference<V> get(K paramK)
  {
    Preconditions.checkNotNull(paramK);
    while (true)
    {
      try
      {
        Entry localEntry1 = (Entry)this.mExclusiveEntries.remove(paramK);
        Entry localEntry2 = (Entry)this.mCachedEntries.get(paramK);
        if (localEntry2 != null)
        {
          localCloseableReference = newClientReference(localEntry2);
          maybeNotifyExclusiveEntryRemoval(localEntry1);
          maybeUpdateCacheParams();
          maybeEvictEntries();
          return localCloseableReference;
        }
      }
      finally
      {
      }
      CloseableReference localCloseableReference = null;
    }
  }

  public int getCount()
  {
    try
    {
      int i = this.mCachedEntries.getCount();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public int getEvictionQueueCount()
  {
    try
    {
      int i = this.mExclusiveEntries.getCount();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public int getEvictionQueueSizeInBytes()
  {
    try
    {
      int i = this.mExclusiveEntries.getSizeInBytes();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public int getInUseCount()
  {
    try
    {
      int i = this.mCachedEntries.getCount();
      int j = this.mExclusiveEntries.getCount();
      int k = i - j;
      return k;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public int getInUseSizeInBytes()
  {
    try
    {
      int i = this.mCachedEntries.getSizeInBytes();
      int j = this.mExclusiveEntries.getSizeInBytes();
      int k = i - j;
      return k;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public int getSizeInBytes()
  {
    try
    {
      int i = this.mCachedEntries.getSizeInBytes();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public int removeAll(Predicate<K> paramPredicate)
  {
    try
    {
      ArrayList localArrayList1 = this.mExclusiveEntries.removeAll(paramPredicate);
      ArrayList localArrayList2 = this.mCachedEntries.removeAll(paramPredicate);
      makeOrphans(localArrayList2);
      maybeClose(localArrayList2);
      maybeNotifyExclusiveEntryRemoval(localArrayList1);
      maybeUpdateCacheParams();
      maybeEvictEntries();
      return localArrayList2.size();
    }
    finally
    {
    }
  }

  @Nullable
  public CloseableReference<V> reuse(K paramK)
  {
    Preconditions.checkNotNull(paramK);
    while (true)
    {
      try
      {
        Entry localEntry1 = (Entry)this.mExclusiveEntries.remove(paramK);
        if (localEntry1 != null)
        {
          Entry localEntry2 = (Entry)this.mCachedEntries.remove(paramK);
          Preconditions.checkNotNull(localEntry2);
          int i = localEntry2.clientCount;
          boolean bool = false;
          if (i == 0)
            bool = true;
          Preconditions.checkState(bool);
          localCloseableReference = localEntry2.valueRef;
          j = 1;
          if (j != 0)
            maybeNotifyExclusiveEntryRemoval(localEntry1);
          return localCloseableReference;
        }
      }
      finally
      {
      }
      int j = 0;
      CloseableReference localCloseableReference = null;
    }
  }

  public void trim(MemoryTrimType paramMemoryTrimType)
  {
    double d = this.mCacheTrimStrategy.getTrimRatio(paramMemoryTrimType);
    try
    {
      ArrayList localArrayList = trimExclusivelyOwnedEntries(2147483647, Math.max(0, (int)(this.mCachedEntries.getSizeInBytes() * (1.0D - d)) - getInUseSizeInBytes()));
      makeOrphans(localArrayList);
      maybeClose(localArrayList);
      maybeNotifyExclusiveEntryRemoval(localArrayList);
      maybeUpdateCacheParams();
      maybeEvictEntries();
      return;
    }
    finally
    {
    }
  }

  public static abstract interface CacheTrimStrategy
  {
    public abstract double getTrimRatio(MemoryTrimType paramMemoryTrimType);
  }

  @VisibleForTesting
  static class Entry<K, V>
  {
    public int clientCount;
    public boolean isOrphan;
    public final K key;

    @Nullable
    public final CountingMemoryCache.EntryStateObserver<K> observer;
    public final CloseableReference<V> valueRef;

    private Entry(K paramK, CloseableReference<V> paramCloseableReference, @Nullable CountingMemoryCache.EntryStateObserver<K> paramEntryStateObserver)
    {
      this.key = Preconditions.checkNotNull(paramK);
      this.valueRef = ((CloseableReference)Preconditions.checkNotNull(CloseableReference.cloneOrNull(paramCloseableReference)));
      this.clientCount = 0;
      this.isOrphan = false;
      this.observer = paramEntryStateObserver;
    }

    @VisibleForTesting
    static <K, V> Entry<K, V> of(K paramK, CloseableReference<V> paramCloseableReference, @Nullable CountingMemoryCache.EntryStateObserver<K> paramEntryStateObserver)
    {
      return new Entry(paramK, paramCloseableReference, paramEntryStateObserver);
    }
  }

  public static abstract interface EntryStateObserver<K>
  {
    public abstract void onExclusivityChanged(K paramK, boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.CountingMemoryCache
 * JD-Core Version:    0.6.2
 */