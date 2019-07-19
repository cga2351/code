package com.facebook.common.statfs;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import com.facebook.common.internal.Throwables;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class StatFsHelper
{
  private static final long RESTAT_INTERVAL_MS = TimeUnit.MINUTES.toMillis(2L);
  private static StatFsHelper sStatsFsHelper;
  private final Lock lock = new ReentrantLock();
  private volatile File mExternalPath;
  private volatile StatFs mExternalStatFs = null;
  private volatile boolean mInitialized = false;
  private volatile File mInternalPath;
  private volatile StatFs mInternalStatFs = null;

  @GuardedBy("lock")
  private long mLastRestatTime;

  protected static StatFs createStatFs(String paramString)
  {
    return new StatFs(paramString);
  }

  private void ensureInitialized()
  {
    if (!this.mInitialized)
      this.lock.lock();
    try
    {
      if (!this.mInitialized)
      {
        this.mInternalPath = Environment.getDataDirectory();
        this.mExternalPath = Environment.getExternalStorageDirectory();
        updateStats();
        this.mInitialized = true;
      }
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }

  public static StatFsHelper getInstance()
  {
    try
    {
      if (sStatsFsHelper == null)
        sStatsFsHelper = new StatFsHelper();
      StatFsHelper localStatFsHelper = sStatsFsHelper;
      return localStatFsHelper;
    }
    finally
    {
    }
  }

  private void maybeUpdateStats()
  {
    if (this.lock.tryLock());
    try
    {
      if (SystemClock.uptimeMillis() - this.mLastRestatTime > RESTAT_INTERVAL_MS)
        updateStats();
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }

  @GuardedBy("lock")
  private void updateStats()
  {
    this.mInternalStatFs = updateStatsHelper(this.mInternalStatFs, this.mInternalPath);
    this.mExternalStatFs = updateStatsHelper(this.mExternalStatFs, this.mExternalPath);
    this.mLastRestatTime = SystemClock.uptimeMillis();
  }

  private StatFs updateStatsHelper(@Nullable StatFs paramStatFs, @Nullable File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()))
      return null;
    if (paramStatFs == null);
    try
    {
      return createStatFs(paramFile.getAbsolutePath());
      paramStatFs.restat(paramFile.getAbsolutePath());
      return paramStatFs;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      return null;
    }
    catch (Throwable localThrowable)
    {
      throw Throwables.propagate(localThrowable);
    }
  }

  @SuppressLint({"DeprecatedMethod"})
  public long getAvailableStorageSpace(StorageType paramStorageType)
  {
    ensureInitialized();
    maybeUpdateStats();
    StatFs localStatFs;
    long l1;
    if (paramStorageType == StorageType.INTERNAL)
    {
      localStatFs = this.mInternalStatFs;
      if (localStatFs == null)
        break label72;
      if (Build.VERSION.SDK_INT < 18)
        break label56;
      l1 = localStatFs.getBlockSizeLong();
    }
    for (long l2 = localStatFs.getAvailableBlocksLong(); ; l2 = localStatFs.getAvailableBlocks())
    {
      return l2 * l1;
      localStatFs = this.mExternalStatFs;
      break;
      label56: l1 = localStatFs.getBlockSize();
    }
    label72: return 0L;
  }

  @SuppressLint({"DeprecatedMethod"})
  public long getFreeStorageSpace(StorageType paramStorageType)
  {
    ensureInitialized();
    maybeUpdateStats();
    StatFs localStatFs;
    long l1;
    if (paramStorageType == StorageType.INTERNAL)
    {
      localStatFs = this.mInternalStatFs;
      if (localStatFs == null)
        break label72;
      if (Build.VERSION.SDK_INT < 18)
        break label56;
      l1 = localStatFs.getBlockSizeLong();
    }
    for (long l2 = localStatFs.getFreeBlocksLong(); ; l2 = localStatFs.getFreeBlocks())
    {
      return l2 * l1;
      localStatFs = this.mExternalStatFs;
      break;
      label56: l1 = localStatFs.getBlockSize();
    }
    label72: return -1L;
  }

  @SuppressLint({"DeprecatedMethod"})
  public long getTotalStorageSpace(StorageType paramStorageType)
  {
    ensureInitialized();
    maybeUpdateStats();
    StatFs localStatFs;
    long l1;
    if (paramStorageType == StorageType.INTERNAL)
    {
      localStatFs = this.mInternalStatFs;
      if (localStatFs == null)
        break label72;
      if (Build.VERSION.SDK_INT < 18)
        break label56;
      l1 = localStatFs.getBlockSizeLong();
    }
    for (long l2 = localStatFs.getBlockCountLong(); ; l2 = localStatFs.getBlockCount())
    {
      return l2 * l1;
      localStatFs = this.mExternalStatFs;
      break;
      label56: l1 = localStatFs.getBlockSize();
    }
    label72: return -1L;
  }

  public void resetStats()
  {
    if (this.lock.tryLock());
    try
    {
      ensureInitialized();
      updateStats();
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }

  public boolean testLowDiskSpace(StorageType paramStorageType, long paramLong)
  {
    ensureInitialized();
    long l = getAvailableStorageSpace(paramStorageType);
    return (l <= 0L) || (l < paramLong);
  }

  public static enum StorageType
  {
    static
    {
      EXTERNAL = new StorageType("EXTERNAL", 1);
      StorageType[] arrayOfStorageType = new StorageType[2];
      arrayOfStorageType[0] = INTERNAL;
      arrayOfStorageType[1] = EXTERNAL;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.statfs.StatFsHelper
 * JD-Core Version:    0.6.2
 */