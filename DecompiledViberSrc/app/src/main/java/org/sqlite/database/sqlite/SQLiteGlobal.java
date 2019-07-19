package org.sqlite.database.sqlite;

import android.os.StatFs;

public final class SQLiteGlobal
{
  private static int sDefaultPageSize;
  private static final Object sLock = new Object();

  public static String getDefaultJournalMode()
  {
    return "persist";
  }

  public static int getDefaultPageSize()
  {
    synchronized (sLock)
    {
      if (sDefaultPageSize == 0)
        sDefaultPageSize = new StatFs("/data").getBlockSize();
      int i = sDefaultPageSize;
      return i;
    }
  }

  public static String getDefaultSyncMode()
  {
    return "normal";
  }

  public static int getJournalSizeLimit()
  {
    return 524288;
  }

  public static int getWALAutoCheckpoint()
  {
    return Math.max(1, 1000);
  }

  public static int getWALConnectionPoolSize()
  {
    return Math.max(2, 10);
  }

  public static String getWALSyncMode()
  {
    return "normal";
  }

  private static native int nativeReleaseMemory();

  public static int releaseMemory()
  {
    return nativeReleaseMemory();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.sqlite.database.sqlite.SQLiteGlobal
 * JD-Core Version:    0.6.2
 */