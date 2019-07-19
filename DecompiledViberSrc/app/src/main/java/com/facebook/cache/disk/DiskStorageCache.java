package com.facebook.cache.disk;

import android.content.Context;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.CacheEventListener.EvictionReason;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.CacheKeyUtil;
import com.facebook.cache.common.WriterCallback;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.statfs.StatFsHelper.StorageType;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class DiskStorageCache
  implements FileCache, DiskTrimmable
{
  private static final long FILECACHE_SIZE_UPDATE_PERIOD_MS = 0L;
  private static final long FUTURE_TIMESTAMP_THRESHOLD_MS = 0L;
  private static final String SHARED_PREFS_FILENAME_PREFIX = "disk_entries_list";
  public static final int START_OF_VERSIONING = 1;
  private static final Class<?> TAG = DiskStorageCache.class;
  private static final double TRIMMING_LOWER_BOUND = 0.02D;
  private static final long UNINITIALIZED = -1L;
  private final CacheErrorLogger mCacheErrorLogger;
  private final CacheEventListener mCacheEventListener;
  private long mCacheSizeLastUpdateTime;
  private long mCacheSizeLimit;
  private final long mCacheSizeLimitMinimum;
  private final CacheStats mCacheStats;
  private final Clock mClock;
  private final CountDownLatch mCountDownLatch;
  private final long mDefaultCacheSizeLimit;
  private final EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier;
  private final boolean mIndexPopulateAtStartupEnabled;
  private boolean mIndexReady;
  private final Object mLock = new Object();
  private final long mLowDiskSpaceCacheSizeLimit;

  @VisibleForTesting
  @GuardedBy("mLock")
  final Set<String> mResourceIndex;
  private final StatFsHelper mStatFsHelper;
  private final DiskStorage mStorage;

  static
  {
    FUTURE_TIMESTAMP_THRESHOLD_MS = TimeUnit.HOURS.toMillis(2L);
  }

  public DiskStorageCache(DiskStorage paramDiskStorage, EntryEvictionComparatorSupplier paramEntryEvictionComparatorSupplier, Params paramParams, CacheEventListener paramCacheEventListener, CacheErrorLogger paramCacheErrorLogger, @Nullable DiskTrimmableRegistry paramDiskTrimmableRegistry, Context paramContext, Executor paramExecutor, boolean paramBoolean)
  {
    this.mLowDiskSpaceCacheSizeLimit = paramParams.mLowDiskSpaceCacheSizeLimit;
    this.mDefaultCacheSizeLimit = paramParams.mDefaultCacheSizeLimit;
    this.mCacheSizeLimit = paramParams.mDefaultCacheSizeLimit;
    this.mStatFsHelper = StatFsHelper.getInstance();
    this.mStorage = paramDiskStorage;
    this.mEntryEvictionComparatorSupplier = paramEntryEvictionComparatorSupplier;
    this.mCacheSizeLastUpdateTime = -1L;
    this.mCacheEventListener = paramCacheEventListener;
    this.mCacheSizeLimitMinimum = paramParams.mCacheSizeLimitMinimum;
    this.mCacheErrorLogger = paramCacheErrorLogger;
    this.mCacheStats = new CacheStats();
    if (paramDiskTrimmableRegistry != null)
      paramDiskTrimmableRegistry.registerDiskTrimmable(this);
    this.mClock = SystemClock.get();
    this.mIndexPopulateAtStartupEnabled = paramBoolean;
    this.mResourceIndex = new HashSet();
    if (this.mIndexPopulateAtStartupEnabled)
    {
      this.mCountDownLatch = new CountDownLatch(1);
      paramExecutor.execute(new Runnable()
      {
        public void run()
        {
          synchronized (DiskStorageCache.this.mLock)
          {
            DiskStorageCache.this.maybeUpdateFileCacheSize();
            DiskStorageCache.access$202(DiskStorageCache.this, true);
            DiskStorageCache.this.mCountDownLatch.countDown();
            return;
          }
        }
      });
      return;
    }
    this.mCountDownLatch = new CountDownLatch(0);
  }

  private BinaryResource endInsert(DiskStorage.Inserter paramInserter, CacheKey paramCacheKey, String paramString)
    throws IOException
  {
    synchronized (this.mLock)
    {
      BinaryResource localBinaryResource = paramInserter.commit(paramCacheKey);
      this.mResourceIndex.add(paramString);
      this.mCacheStats.increment(localBinaryResource.size(), 1L);
      return localBinaryResource;
    }
  }

  @GuardedBy("mLock")
  private void evictAboveSize(long paramLong, CacheEventListener.EvictionReason paramEvictionReason)
    throws IOException
  {
    while (true)
    {
      long l1;
      int i;
      DiskStorage.Entry localEntry;
      try
      {
        Collection localCollection = getSortedEntries(this.mStorage.getEntries());
        l1 = this.mCacheStats.getSize();
        long l2 = l1 - paramLong;
        Iterator localIterator = localCollection.iterator();
        i = 0;
        l3 = 0L;
        if (localIterator.hasNext())
        {
          localEntry = (DiskStorage.Entry)localIterator.next();
          if (l3 <= l2);
        }
        else
        {
          this.mCacheStats.increment(-l3, -i);
          this.mStorage.purgeUnexpectedResources();
          return;
        }
      }
      catch (IOException localIOException)
      {
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "evictAboveSize: " + localIOException.getMessage(), localIOException);
        throw localIOException;
      }
      long l4 = this.mStorage.remove(localEntry);
      this.mResourceIndex.remove(localEntry.getId());
      if (l4 > 0L)
      {
        i++;
        l3 += l4;
        SettableCacheEvent localSettableCacheEvent = SettableCacheEvent.obtain().setResourceId(localEntry.getId()).setEvictionReason(paramEvictionReason).setItemSize(l4).setCacheSize(l1 - l3).setCacheLimit(paramLong);
        this.mCacheEventListener.onEviction(localSettableCacheEvent);
        localSettableCacheEvent.recycle();
      }
      long l5 = l3;
      long l3 = l5;
    }
  }

  private Collection<DiskStorage.Entry> getSortedEntries(Collection<DiskStorage.Entry> paramCollection)
  {
    long l = this.mClock.now() + FUTURE_TIMESTAMP_THRESHOLD_MS;
    ArrayList localArrayList1 = new ArrayList(paramCollection.size());
    ArrayList localArrayList2 = new ArrayList(paramCollection.size());
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      DiskStorage.Entry localEntry = (DiskStorage.Entry)localIterator.next();
      if (localEntry.getTimestamp() > l)
        localArrayList1.add(localEntry);
      else
        localArrayList2.add(localEntry);
    }
    Collections.sort(localArrayList2, this.mEntryEvictionComparatorSupplier.get());
    localArrayList1.addAll(localArrayList2);
    return localArrayList1;
  }

  private void maybeEvictFilesInCacheDir()
    throws IOException
  {
    synchronized (this.mLock)
    {
      boolean bool = maybeUpdateFileCacheSize();
      updateFileCacheSizeLimit();
      long l = this.mCacheStats.getSize();
      if ((l > this.mCacheSizeLimit) && (!bool))
      {
        this.mCacheStats.reset();
        maybeUpdateFileCacheSize();
      }
      if (l > this.mCacheSizeLimit)
        evictAboveSize(9L * this.mCacheSizeLimit / 10L, CacheEventListener.EvictionReason.CACHE_FULL);
      return;
    }
  }

  @GuardedBy("mLock")
  private boolean maybeUpdateFileCacheSize()
  {
    long l = this.mClock.now();
    if ((!this.mCacheStats.isInitialized()) || (this.mCacheSizeLastUpdateTime == -1L) || (l - this.mCacheSizeLastUpdateTime > FILECACHE_SIZE_UPDATE_PERIOD_MS))
      return maybeUpdateFileCacheSizeAndIndex();
    return false;
  }

  @GuardedBy("mLock")
  private boolean maybeUpdateFileCacheSizeAndIndex()
  {
    int i = 0;
    int j = 0;
    int k = 0;
    long l1 = -1L;
    long l2 = this.mClock.now();
    long l3 = l2 + FUTURE_TIMESTAMP_THRESHOLD_MS;
    Object localObject;
    if ((this.mIndexPopulateAtStartupEnabled) && (this.mResourceIndex.isEmpty()))
      localObject = this.mResourceIndex;
    while (true)
    {
      try
      {
        Iterator localIterator = this.mStorage.getEntries().iterator();
        long l4 = 0L;
        int m = 0;
        if (localIterator.hasNext())
        {
          DiskStorage.Entry localEntry = (DiskStorage.Entry)localIterator.next();
          int n = m + 1;
          l4 += localEntry.getSize();
          if (localEntry.getTimestamp() > l3)
          {
            int i1 = j + 1;
            int i2 = (int)(k + localEntry.getSize());
            long l5 = Math.max(localEntry.getTimestamp() - l2, l1);
            l6 = l5;
            i3 = i2;
            i4 = i1;
            i5 = 1;
            i = i5;
            m = n;
            j = i4;
            long l7 = l6;
            k = i3;
            l1 = l7;
            continue;
            if (this.mIndexPopulateAtStartupEnabled)
            {
              localObject = new HashSet();
              continue;
            }
            localObject = null;
            continue;
          }
          if (!this.mIndexPopulateAtStartupEnabled)
            break label450;
          ((Set)localObject).add(localEntry.getId());
          break label450;
        }
        if (i != 0)
          this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, TAG, "Future timestamp found in " + j + " files , with a total size of " + k + " bytes, and a maximum time delta of " + l1 + "ms", null);
        if ((this.mCacheStats.getCount() != m) || (this.mCacheStats.getSize() != l4))
        {
          if ((this.mIndexPopulateAtStartupEnabled) && (this.mResourceIndex != localObject))
          {
            this.mResourceIndex.clear();
            this.mResourceIndex.addAll((Collection)localObject);
          }
          this.mCacheStats.set(l4, m);
        }
        this.mCacheSizeLastUpdateTime = l2;
        return true;
      }
      catch (IOException localIOException)
      {
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, TAG, "calcFileCacheSize: " + localIOException.getMessage(), localIOException);
        return false;
      }
      label450: long l8 = l1;
      int i3 = k;
      int i4 = j;
      long l6 = l8;
      int i5 = i;
    }
  }

  private DiskStorage.Inserter startInsert(String paramString, CacheKey paramCacheKey)
    throws IOException
  {
    maybeEvictFilesInCacheDir();
    return this.mStorage.insert(paramString, paramCacheKey);
  }

  private void trimBy(double paramDouble)
  {
    synchronized (this.mLock)
    {
      try
      {
        this.mCacheStats.reset();
        maybeUpdateFileCacheSize();
        long l = this.mCacheStats.getSize();
        evictAboveSize(l - ()(paramDouble * l), CacheEventListener.EvictionReason.CACHE_MANAGER_TRIMMED);
        return;
      }
      catch (IOException localIOException)
      {
        while (true)
          this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "trimBy: " + localIOException.getMessage(), localIOException);
      }
    }
  }

  @GuardedBy("mLock")
  private void updateFileCacheSizeLimit()
  {
    if (this.mStorage.isExternal());
    for (StatFsHelper.StorageType localStorageType = StatFsHelper.StorageType.EXTERNAL; this.mStatFsHelper.testLowDiskSpace(localStorageType, this.mDefaultCacheSizeLimit - this.mCacheStats.getSize()); localStorageType = StatFsHelper.StorageType.INTERNAL)
    {
      this.mCacheSizeLimit = this.mLowDiskSpaceCacheSizeLimit;
      return;
    }
    this.mCacheSizeLimit = this.mDefaultCacheSizeLimit;
  }

  @VisibleForTesting
  protected void awaitIndex()
  {
    try
    {
      this.mCountDownLatch.await();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      FLog.e(TAG, "Memory Index is not ready yet. ");
    }
  }

  public void clearAll()
  {
    synchronized (this.mLock)
    {
      try
      {
        this.mStorage.clearAll();
        this.mResourceIndex.clear();
        this.mCacheEventListener.onCleared();
        this.mCacheStats.reset();
        return;
      }
      catch (IOException localIOException)
      {
        while (true)
          this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "clearAll: " + localIOException.getMessage(), localIOException);
      }
    }
  }

  public long clearOldEntries(long paramLong)
  {
    long l1 = 0L;
    while (true)
    {
      synchronized (this.mLock)
      {
        try
        {
          long l2 = this.mClock.now();
          Collection localCollection = this.mStorage.getEntries();
          long l3 = this.mCacheStats.getSize();
          i = 0;
          l4 = 0L;
          Iterator localIterator = localCollection.iterator();
          if (localIterator.hasNext())
          {
            DiskStorage.Entry localEntry = (DiskStorage.Entry)localIterator.next();
            long l5 = Math.max(1L, Math.abs(l2 - localEntry.getTimestamp()));
            if (l5 >= paramLong)
            {
              long l6 = this.mStorage.remove(localEntry);
              this.mResourceIndex.remove(localEntry.getId());
              if (l6 > 0L)
              {
                i++;
                l4 += l6;
                SettableCacheEvent localSettableCacheEvent = SettableCacheEvent.obtain().setResourceId(localEntry.getId()).setEvictionReason(CacheEventListener.EvictionReason.CONTENT_STALE).setItemSize(l6).setCacheSize(l3 - l4);
                this.mCacheEventListener.onEviction(localSettableCacheEvent);
                localSettableCacheEvent.recycle();
              }
            }
            else
            {
              l1 = Math.max(l1, l5);
              long l10 = l4;
              j = i;
              l8 = l10;
              break label331;
            }
          }
          else
          {
            this.mStorage.purgeUnexpectedResources();
            if (i > 0)
            {
              maybeUpdateFileCacheSize();
              this.mCacheStats.increment(-l4, -i);
            }
            return l1;
          }
        }
        catch (IOException localIOException)
        {
          this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "clearOldEntries: " + localIOException.getMessage(), localIOException);
          continue;
        }
      }
      long l7 = l4;
      int j = i;
      long l8 = l7;
      label331: long l9 = l8;
      int i = j;
      long l4 = l9;
    }
  }

  public long getCount()
  {
    return this.mCacheStats.getCount();
  }

  public DiskStorage.DiskDumpInfo getDumpInfo()
    throws IOException
  {
    return this.mStorage.getDumpInfo();
  }

  public BinaryResource getResource(CacheKey paramCacheKey)
  {
    SettableCacheEvent localSettableCacheEvent = SettableCacheEvent.obtain().setCacheKey(paramCacheKey);
    try
    {
      synchronized (this.mLock)
      {
        List localList = CacheKeyUtil.getResourceIds(paramCacheKey);
        int i = 0;
        Object localObject4 = null;
        BinaryResource localBinaryResource;
        for (Object localObject5 = null; ; localObject5 = localBinaryResource)
        {
          String str;
          if (i < localList.size())
          {
            str = (String)localList.get(i);
            localSettableCacheEvent.setResourceId(str);
            localBinaryResource = this.mStorage.getResource(str, paramCacheKey);
            if (localBinaryResource != null)
            {
              localObject4 = str;
              localObject5 = localBinaryResource;
            }
          }
          else
          {
            if (localObject5 != null)
              break;
            this.mCacheEventListener.onMiss(localSettableCacheEvent);
            this.mResourceIndex.remove(localObject4);
            return localObject5;
          }
          i++;
          localObject4 = str;
        }
        this.mCacheEventListener.onHit(localSettableCacheEvent);
        this.mResourceIndex.add(localObject4);
      }
    }
    catch (IOException localIOException)
    {
      this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, TAG, "getResource", localIOException);
      localSettableCacheEvent.setException(localIOException);
      this.mCacheEventListener.onReadException(localSettableCacheEvent);
      return null;
    }
    finally
    {
      localSettableCacheEvent.recycle();
    }
  }

  public long getSize()
  {
    return this.mCacheStats.getSize();
  }

  public boolean hasKey(CacheKey paramCacheKey)
  {
    while (true)
    {
      int i;
      synchronized (this.mLock)
      {
        if (hasKeySync(paramCacheKey))
          return true;
        try
        {
          List localList = CacheKeyUtil.getResourceIds(paramCacheKey);
          i = 0;
          if (i < localList.size())
          {
            String str = (String)localList.get(i);
            if (this.mStorage.contains(str, paramCacheKey))
            {
              this.mResourceIndex.add(str);
              return true;
            }
          }
          else
          {
            return false;
          }
        }
        catch (IOException localIOException)
        {
          return false;
        }
      }
      i++;
    }
  }

  public boolean hasKeySync(CacheKey paramCacheKey)
  {
    while (true)
    {
      int i;
      synchronized (this.mLock)
      {
        List localList = CacheKeyUtil.getResourceIds(paramCacheKey);
        i = 0;
        if (i < localList.size())
        {
          String str = (String)localList.get(i);
          if (this.mResourceIndex.contains(str))
            return true;
        }
        else
        {
          return false;
        }
      }
      i++;
    }
  }

  public BinaryResource insert(CacheKey paramCacheKey, WriterCallback paramWriterCallback)
    throws IOException
  {
    SettableCacheEvent localSettableCacheEvent = SettableCacheEvent.obtain().setCacheKey(paramCacheKey);
    this.mCacheEventListener.onWriteAttempt(localSettableCacheEvent);
    String str;
    synchronized (this.mLock)
    {
      str = CacheKeyUtil.getFirstResourceId(paramCacheKey);
      localSettableCacheEvent.setResourceId(str);
    }
    try
    {
      DiskStorage.Inserter localInserter = startInsert(str, paramCacheKey);
      try
      {
        localInserter.writeData(paramWriterCallback, paramCacheKey);
        BinaryResource localBinaryResource = endInsert(localInserter, paramCacheKey, str);
        localSettableCacheEvent.setItemSize(localBinaryResource.size()).setCacheSize(this.mCacheStats.getSize());
        this.mCacheEventListener.onWriteSuccess(localSettableCacheEvent);
        if (!localInserter.cleanUp())
          FLog.e(TAG, "Failed to delete temp file");
        return localBinaryResource;
        localObject2 = finally;
        throw localObject2;
      }
      finally
      {
        if (!localInserter.cleanUp())
          FLog.e(TAG, "Failed to delete temp file");
      }
    }
    catch (IOException localIOException)
    {
      localSettableCacheEvent.setException(localIOException);
      this.mCacheEventListener.onWriteException(localSettableCacheEvent);
      FLog.e(TAG, "Failed inserting a file into the cache", localIOException);
      throw localIOException;
    }
    finally
    {
      localSettableCacheEvent.recycle();
    }
  }

  public boolean isEnabled()
  {
    return this.mStorage.isEnabled();
  }

  public boolean isIndexReady()
  {
    return (this.mIndexReady) || (!this.mIndexPopulateAtStartupEnabled);
  }

  // ERROR //
  public boolean probe(CacheKey paramCacheKey)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 95	com/facebook/cache/disk/DiskStorageCache:mLock	Ljava/lang/Object;
    //   6: astore 5
    //   8: aload 5
    //   10: monitorenter
    //   11: aload_1
    //   12: invokestatic 490	com/facebook/cache/common/CacheKeyUtil:getResourceIds	(Lcom/facebook/cache/common/CacheKey;)Ljava/util/List;
    //   15: astore 7
    //   17: iconst_0
    //   18: istore 8
    //   20: iload 8
    //   22: aload 7
    //   24: invokeinterface 493 1 0
    //   29: if_icmpge +58 -> 87
    //   32: aload 7
    //   34: iload 8
    //   36: invokeinterface 496 2 0
    //   41: checkcast 498	java/lang/String
    //   44: astore 9
    //   46: aload_0
    //   47: getfield 115	com/facebook/cache/disk/DiskStorageCache:mStorage	Lcom/facebook/cache/disk/DiskStorage;
    //   50: aload 9
    //   52: aload_1
    //   53: invokeinterface 566 3 0
    //   58: ifeq +20 -> 78
    //   61: aload_0
    //   62: getfield 152	com/facebook/cache/disk/DiskStorageCache:mResourceIndex	Ljava/util/Set;
    //   65: aload 9
    //   67: invokeinterface 200 2 0
    //   72: pop
    //   73: aload 5
    //   75: monitorexit
    //   76: iconst_1
    //   77: ireturn
    //   78: iinc 8 1
    //   81: aload 9
    //   83: astore_2
    //   84: goto -64 -> 20
    //   87: aload 5
    //   89: monitorexit
    //   90: iconst_0
    //   91: ireturn
    //   92: aload 5
    //   94: monitorexit
    //   95: aload 6
    //   97: athrow
    //   98: astore_3
    //   99: invokestatic 288	com/facebook/cache/disk/SettableCacheEvent:obtain	()Lcom/facebook/cache/disk/SettableCacheEvent;
    //   102: aload_1
    //   103: invokevirtual 484	com/facebook/cache/disk/SettableCacheEvent:setCacheKey	(Lcom/facebook/cache/common/CacheKey;)Lcom/facebook/cache/disk/SettableCacheEvent;
    //   106: aload_2
    //   107: invokevirtual 292	com/facebook/cache/disk/SettableCacheEvent:setResourceId	(Ljava/lang/String;)Lcom/facebook/cache/disk/SettableCacheEvent;
    //   110: aload_3
    //   111: invokevirtual 512	com/facebook/cache/disk/SettableCacheEvent:setException	(Ljava/io/IOException;)Lcom/facebook/cache/disk/SettableCacheEvent;
    //   114: astore 4
    //   116: aload_0
    //   117: getfield 121	com/facebook/cache/disk/DiskStorageCache:mCacheEventListener	Lcom/facebook/cache/common/CacheEventListener;
    //   120: aload 4
    //   122: invokeinterface 515 2 0
    //   127: aload 4
    //   129: invokevirtual 315	com/facebook/cache/disk/SettableCacheEvent:recycle	()V
    //   132: iconst_0
    //   133: ireturn
    //   134: astore 10
    //   136: aload 9
    //   138: astore_2
    //   139: aload 10
    //   141: astore 6
    //   143: goto -51 -> 92
    //   146: astore 6
    //   148: goto -56 -> 92
    //
    // Exception table:
    //   from	to	target	type
    //   2	11	98	java/io/IOException
    //   95	98	98	java/io/IOException
    //   46	76	134	finally
    //   11	17	146	finally
    //   20	46	146	finally
    //   87	90	146	finally
    //   92	95	146	finally
  }

  public void remove(CacheKey paramCacheKey)
  {
    synchronized (this.mLock)
    {
      try
      {
        List localList = CacheKeyUtil.getResourceIds(paramCacheKey);
        for (int i = 0; i < localList.size(); i++)
        {
          String str = (String)localList.get(i);
          this.mStorage.remove(str);
          this.mResourceIndex.remove(str);
        }
      }
      catch (IOException localIOException)
      {
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, TAG, "delete: " + localIOException.getMessage(), localIOException);
        return;
      }
    }
  }

  public void trimToMinimum()
  {
    synchronized (this.mLock)
    {
      maybeUpdateFileCacheSize();
      long l = this.mCacheStats.getSize();
      if ((this.mCacheSizeLimitMinimum <= 0L) || (l <= 0L) || (l < this.mCacheSizeLimitMinimum))
        return;
      double d = 1.0D - this.mCacheSizeLimitMinimum / l;
      if (d > 0.02D)
        trimBy(d);
      return;
    }
  }

  public void trimToNothing()
  {
    clearAll();
  }

  @VisibleForTesting
  static class CacheStats
  {
    private long mCount = -1L;
    private boolean mInitialized = false;
    private long mSize = -1L;

    public long getCount()
    {
      try
      {
        long l = this.mCount;
        return l;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    public long getSize()
    {
      try
      {
        long l = this.mSize;
        return l;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    public void increment(long paramLong1, long paramLong2)
    {
      try
      {
        if (this.mInitialized)
        {
          this.mSize = (paramLong1 + this.mSize);
          this.mCount = (paramLong2 + this.mCount);
        }
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    public boolean isInitialized()
    {
      try
      {
        boolean bool = this.mInitialized;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    public void reset()
    {
      try
      {
        this.mInitialized = false;
        this.mCount = -1L;
        this.mSize = -1L;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    public void set(long paramLong1, long paramLong2)
    {
      try
      {
        this.mCount = paramLong2;
        this.mSize = paramLong1;
        this.mInitialized = true;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }

  public static class Params
  {
    public final long mCacheSizeLimitMinimum;
    public final long mDefaultCacheSizeLimit;
    public final long mLowDiskSpaceCacheSizeLimit;

    public Params(long paramLong1, long paramLong2, long paramLong3)
    {
      this.mCacheSizeLimitMinimum = paramLong1;
      this.mLowDiskSpaceCacheSizeLimit = paramLong2;
      this.mDefaultCacheSizeLimit = paramLong3;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.cache.disk.DiskStorageCache
 * JD-Core Version:    0.6.2
 */