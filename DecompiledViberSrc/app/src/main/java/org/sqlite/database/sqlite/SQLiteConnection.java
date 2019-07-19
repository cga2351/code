package org.sqlite.database.sqlite;

import android.os.ParcelFileDescriptor;
import android.util.LruCache;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import org.sqlite.database.DatabaseUtils;
import org.sqlite.os.CancellationSignal;
import org.sqlite.os.CancellationSignal.OnCancelListener;

public final class SQLiteConnection
  implements CancellationSignal.OnCancelListener
{
  private static final String[] EMPTY_STRING_ARRAY;
  private static final String TAG = "SQLiteConnection";
  private int mCancellationSignalAttachCount;
  private final CloseGuard mCloseGuard = CloseGuard.get();
  private final SQLiteDatabaseConfiguration mConfiguration;
  private final int mConnectionId;
  private long mConnectionPtr;
  private final boolean mIsPrimaryConnection;
  private final boolean mIsReadOnlyConnection;
  private boolean mOnlyAllowReadOnlyOperations;
  private final SQLiteConnectionPool mPool;
  private final PreparedStatementCache mPreparedStatementCache;
  private PreparedStatement mPreparedStatementPool;

  static
  {
    if (!SQLiteConnection.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      EMPTY_STRING_ARRAY = new String[0];
      return;
    }
  }

  private SQLiteConnection(SQLiteConnectionPool paramSQLiteConnectionPool, SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration, int paramInt, boolean paramBoolean)
  {
    this.mPool = paramSQLiteConnectionPool;
    this.mConfiguration = new SQLiteDatabaseConfiguration(paramSQLiteDatabaseConfiguration);
    this.mConnectionId = paramInt;
    this.mIsPrimaryConnection = paramBoolean;
    if ((0x1 & paramSQLiteDatabaseConfiguration.openFlags) != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.mIsReadOnlyConnection = bool;
      this.mPreparedStatementCache = new PreparedStatementCache(this.mConfiguration.maxSqlCacheSize);
      this.mCloseGuard.open("close");
      return;
    }
  }

  private PreparedStatement acquirePreparedStatement(String paramString)
  {
    PreparedStatement localPreparedStatement = (PreparedStatement)this.mPreparedStatementCache.get(paramString);
    if (localPreparedStatement != null)
      if (!localPreparedStatement.mInUse)
        return localPreparedStatement;
    for (int i = 1; ; i = 0)
    {
      long l = nativePrepareStatement(this.mConnectionPtr, paramString);
      try
      {
        localPreparedStatement = obtainPreparedStatement(paramString, l, nativeGetParameterCount(this.mConnectionPtr, l), nativeIsReadOnly(this.mConnectionPtr, l));
        if ((i == 0) && (isCacheableSql(paramString)))
        {
          this.mPreparedStatementCache.put(paramString, localPreparedStatement);
          localPreparedStatement.mInCache = true;
        }
        localPreparedStatement.mInUse = true;
        return localPreparedStatement;
      }
      catch (RuntimeException localRuntimeException)
      {
        if ((localPreparedStatement == null) || (!localPreparedStatement.mInCache))
          nativeFinalizeStatement(this.mConnectionPtr, l);
        throw localRuntimeException;
      }
    }
  }

  private void attachCancellationSignal(CancellationSignal paramCancellationSignal)
  {
    if (paramCancellationSignal != null)
    {
      paramCancellationSignal.throwIfCanceled();
      this.mCancellationSignalAttachCount = (1 + this.mCancellationSignalAttachCount);
      if (this.mCancellationSignalAttachCount == 1)
      {
        nativeResetCancel(this.mConnectionPtr, true);
        paramCancellationSignal.setOnCancelListener(this);
      }
    }
  }

  private void bindArguments(PreparedStatement paramPreparedStatement, Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject != null);
    for (int i = paramArrayOfObject.length; i != paramPreparedStatement.mNumParameters; i = 0)
      throw new SQLiteBindOrColumnIndexOutOfRangeException("Expected " + paramPreparedStatement.mNumParameters + " bind arguments but " + i + " were provided.");
    if (i == 0)
      return;
    long l1 = paramPreparedStatement.mStatementPtr;
    int j = 0;
    label78: Object localObject;
    if (j < i)
    {
      localObject = paramArrayOfObject[j];
      if (localObject != null)
        break label114;
      nativeBindNull(this.mConnectionPtr, l1, j + 1);
    }
    while (true)
    {
      j++;
      break label78;
      break;
      label114: if ((localObject instanceof String))
      {
        nativeBindString(this.mConnectionPtr, l1, j + 1, localObject.toString());
      }
      else if (((localObject instanceof Long)) || ((localObject instanceof Integer)) || ((localObject instanceof Short)) || ((localObject instanceof Byte)))
      {
        nativeBindLong(this.mConnectionPtr, l1, j + 1, ((Number)localObject).longValue());
      }
      else if (((localObject instanceof Float)) || ((localObject instanceof Double)))
      {
        nativeBindDouble(this.mConnectionPtr, l1, j + 1, ((Number)localObject).doubleValue());
      }
      else if ((localObject instanceof byte[]))
      {
        nativeBindBlob(this.mConnectionPtr, l1, j + 1, (byte[])localObject);
      }
      else
      {
        if ((localObject instanceof Boolean))
        {
          long l2 = this.mConnectionPtr;
          int k = j + 1;
          if (((Boolean)localObject).booleanValue());
          for (long l3 = 1L; ; l3 = 0L)
          {
            nativeBindLong(l2, l1, k, l3);
            break;
          }
        }
        nativeBindString(this.mConnectionPtr, l1, j + 1, localObject.toString());
      }
    }
  }

  private static String canonicalizeSyncMode(String paramString)
  {
    if (paramString.equals("0"))
      paramString = "OFF";
    do
    {
      return paramString;
      if (paramString.equals("1"))
        return "NORMAL";
    }
    while (!paramString.equals("2"));
    return "FULL";
  }

  private void detachCancellationSignal(CancellationSignal paramCancellationSignal)
  {
    if (paramCancellationSignal != null)
    {
      assert (this.mCancellationSignalAttachCount > 0);
      this.mCancellationSignalAttachCount = (-1 + this.mCancellationSignalAttachCount);
      if (this.mCancellationSignalAttachCount == 0)
      {
        paramCancellationSignal.setOnCancelListener(null);
        nativeResetCancel(this.mConnectionPtr, false);
      }
    }
  }

  private void dispose(boolean paramBoolean)
  {
    if (this.mCloseGuard != null)
    {
      if (paramBoolean)
        this.mCloseGuard.warnIfOpen();
      this.mCloseGuard.close();
    }
    if (this.mConnectionPtr != 0L)
    {
      this.mPreparedStatementCache.evictAll();
      nativeClose(this.mConnectionPtr);
      this.mConnectionPtr = 0L;
    }
  }

  private void finalizePreparedStatement(PreparedStatement paramPreparedStatement)
  {
    nativeFinalizeStatement(this.mConnectionPtr, paramPreparedStatement.mStatementPtr);
    recyclePreparedStatement(paramPreparedStatement);
  }

  private SQLiteDebug.DbStats getMainDbStatsUnsafe(int paramInt, long paramLong1, long paramLong2)
  {
    String str = this.mConfiguration.path;
    if (!this.mIsPrimaryConnection)
      str = str + " (" + this.mConnectionId + ")";
    return new SQLiteDebug.DbStats(str, paramLong1, paramLong2, paramInt, this.mPreparedStatementCache.hitCount(), this.mPreparedStatementCache.missCount(), this.mPreparedStatementCache.size());
  }

  public static boolean hasCodec()
  {
    return nativeHasCodec();
  }

  private static boolean isCacheable(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 1);
  }

  private static boolean isCacheableSql(String paramString)
  {
    if ((paramString == "COMMIT;") || (paramString == "BEGIN EXCLUSIVE;") || (paramString == "BEGIN IMMEDIATE;"))
      return false;
    return isCacheable(DatabaseUtils.getSqlStatementType(paramString));
  }

  private static native void nativeBindBlob(long paramLong1, long paramLong2, int paramInt, byte[] paramArrayOfByte);

  private static native void nativeBindDouble(long paramLong1, long paramLong2, int paramInt, double paramDouble);

  private static native void nativeBindLong(long paramLong1, long paramLong2, int paramInt, long paramLong3);

  private static native void nativeBindNull(long paramLong1, long paramLong2, int paramInt);

  private static native void nativeBindString(long paramLong1, long paramLong2, int paramInt, String paramString);

  private static native void nativeCancel(long paramLong);

  private static native void nativeClose(long paramLong);

  private static native void nativeExecute(long paramLong1, long paramLong2);

  private static native int nativeExecuteForBlobFileDescriptor(long paramLong1, long paramLong2);

  private static native int nativeExecuteForChangedRowCount(long paramLong1, long paramLong2);

  private static native long nativeExecuteForCursorWindow(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, boolean paramBoolean);

  private static native long nativeExecuteForLastInsertedRowId(long paramLong1, long paramLong2);

  private static native long nativeExecuteForLong(long paramLong1, long paramLong2);

  private static native String nativeExecuteForString(long paramLong1, long paramLong2);

  private static native void nativeFinalizeStatement(long paramLong1, long paramLong2);

  private static native int nativeGetColumnCount(long paramLong1, long paramLong2);

  private static native String nativeGetColumnName(long paramLong1, long paramLong2, int paramInt);

  private static native int nativeGetDbLookaside(long paramLong);

  private static native int nativeGetParameterCount(long paramLong1, long paramLong2);

  private static native boolean nativeHasCodec();

  private static native boolean nativeIsReadOnly(long paramLong1, long paramLong2);

  private static native long nativeOpen(String paramString1, String paramString2, int paramInt, String paramString3, boolean paramBoolean1, boolean paramBoolean2);

  private static native long nativePrepareStatement(long paramLong, String paramString);

  private static native void nativeRegisterCustomFunction(long paramLong, SQLiteCustomFunction paramSQLiteCustomFunction);

  private static native void nativeRegisterLocalizedCollators(long paramLong, String paramString);

  private static native void nativeResetCancel(long paramLong, boolean paramBoolean);

  private static native void nativeResetStatementAndClearBindings(long paramLong1, long paramLong2);

  private PreparedStatement obtainPreparedStatement(String paramString, long paramLong, int paramInt, boolean paramBoolean)
  {
    PreparedStatement localPreparedStatement = this.mPreparedStatementPool;
    if (localPreparedStatement != null)
    {
      this.mPreparedStatementPool = localPreparedStatement.mPoolNext;
      localPreparedStatement.mPoolNext = null;
      localPreparedStatement.mInCache = false;
    }
    while (true)
    {
      localPreparedStatement.mSql = paramString;
      localPreparedStatement.mStatementPtr = paramLong;
      localPreparedStatement.mNumParameters = paramInt;
      localPreparedStatement.mReadOnly = paramBoolean;
      return localPreparedStatement;
      localPreparedStatement = new PreparedStatement(null);
    }
  }

  static SQLiteConnection open(SQLiteConnectionPool paramSQLiteConnectionPool, SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration, int paramInt, boolean paramBoolean)
  {
    SQLiteConnection localSQLiteConnection = new SQLiteConnection(paramSQLiteConnectionPool, paramSQLiteDatabaseConfiguration, paramInt, paramBoolean);
    try
    {
      localSQLiteConnection.open();
      return localSQLiteConnection;
    }
    catch (SQLiteException localSQLiteException)
    {
      localSQLiteConnection.dispose(false);
      throw localSQLiteException;
    }
  }

  private void open()
  {
    int i = 0;
    String str = new File(this.mConfiguration.path).getParent();
    if ((str != null) && (!str.isEmpty()))
    {
      File localFile = new File(str);
      if (!localFile.exists())
        localFile.mkdirs();
    }
    this.mConnectionPtr = nativeOpen(this.mConfiguration.path, this.mConfiguration.locale.toString(), this.mConfiguration.openFlags, this.mConfiguration.label, false, false);
    setPageSize();
    setForeignKeyModeFromConfiguration();
    setJournalSizeLimit();
    setAutoCheckpointInterval();
    if (!hasCodec())
    {
      setWalModeFromConfiguration();
      setLocaleFromConfiguration();
    }
    int j = this.mConfiguration.customFunctions.size();
    while (i < j)
    {
      SQLiteCustomFunction localSQLiteCustomFunction = (SQLiteCustomFunction)this.mConfiguration.customFunctions.get(i);
      nativeRegisterCustomFunction(this.mConnectionPtr, localSQLiteCustomFunction);
      i++;
    }
  }

  private void recyclePreparedStatement(PreparedStatement paramPreparedStatement)
  {
    paramPreparedStatement.mSql = null;
    paramPreparedStatement.mPoolNext = this.mPreparedStatementPool;
    this.mPreparedStatementPool = paramPreparedStatement;
  }

  private void releasePreparedStatement(PreparedStatement paramPreparedStatement)
  {
    paramPreparedStatement.mInUse = false;
    if (paramPreparedStatement.mInCache)
      try
      {
        nativeResetStatementAndClearBindings(this.mConnectionPtr, paramPreparedStatement.mStatementPtr);
        return;
      }
      catch (SQLiteException localSQLiteException)
      {
        this.mPreparedStatementCache.remove(paramPreparedStatement.mSql);
        return;
      }
    finalizePreparedStatement(paramPreparedStatement);
  }

  private void setAutoCheckpointInterval()
  {
    if ((!this.mConfiguration.isInMemoryDb()) && (!this.mIsReadOnlyConnection))
    {
      long l = SQLiteGlobal.getWALAutoCheckpoint();
      if (executeForLong("PRAGMA wal_autocheckpoint", null, null) != l)
        executeForLong("PRAGMA wal_autocheckpoint=" + l, null, null);
    }
  }

  private void setForeignKeyModeFromConfiguration()
  {
    if (!this.mIsReadOnlyConnection)
      if (!this.mConfiguration.foreignKeyConstraintsEnabled)
        break label60;
    label60: for (long l = 1L; ; l = 0L)
    {
      if (executeForLong("PRAGMA foreign_keys", null, null) != l)
        execute("PRAGMA foreign_keys=" + l, null, null);
      return;
    }
  }

  private void setJournalMode(String paramString)
  {
    if (!executeForString("PRAGMA journal_mode", null, null).equalsIgnoreCase(paramString));
    try
    {
      boolean bool = executeForString("PRAGMA journal_mode=" + paramString, null, null).equalsIgnoreCase(paramString);
      if (bool);
      return;
    }
    catch (SQLiteDatabaseLockedException localSQLiteDatabaseLockedException)
    {
    }
  }

  private void setJournalSizeLimit()
  {
    if ((!this.mConfiguration.isInMemoryDb()) && (this.mConfiguration.isEnableJournalSizeLimit()) && (!this.mIsReadOnlyConnection))
    {
      long l = SQLiteGlobal.getJournalSizeLimit();
      if (executeForLong("PRAGMA journal_size_limit", null, null) != l)
        executeForLong("PRAGMA journal_size_limit=" + l, null, null);
    }
  }

  private void setLocaleFromConfiguration()
  {
    if ((0x10 & this.mConfiguration.openFlags) != 0)
      return;
    String str = this.mConfiguration.locale.toString();
    nativeRegisterLocalizedCollators(this.mConnectionPtr, str);
  }

  private void setPageSize()
  {
    if ((!this.mConfiguration.isInMemoryDb()) && (!this.mIsReadOnlyConnection))
    {
      long l = SQLiteGlobal.getDefaultPageSize();
      if (executeForLong("PRAGMA page_size", null, null) != l)
        execute("PRAGMA page_size=" + l, null, null);
    }
  }

  private void setSyncMode(String paramString)
  {
    if (!canonicalizeSyncMode(executeForString("PRAGMA synchronous", null, null)).equalsIgnoreCase(canonicalizeSyncMode(paramString)))
      execute("PRAGMA synchronous=" + paramString, null, null);
  }

  private void setWalModeFromConfiguration()
  {
    if ((!this.mConfiguration.isInMemoryDb()) && (!this.mIsReadOnlyConnection))
    {
      if ((0x20000000 & this.mConfiguration.openFlags) != 0)
      {
        setJournalMode("WAL");
        setSyncMode(SQLiteGlobal.getWALSyncMode());
      }
    }
    else
      return;
    setJournalMode(SQLiteGlobal.getDefaultJournalMode());
    setSyncMode(SQLiteGlobal.getDefaultSyncMode());
  }

  private void throwIfStatementForbidden(PreparedStatement paramPreparedStatement)
  {
    if ((this.mOnlyAllowReadOnlyOperations) && (!paramPreparedStatement.mReadOnly))
      throw new SQLiteException("Cannot execute this statement because it might modify the database but the connection is read-only.");
  }

  void close()
  {
    dispose(false);
  }

  void collectDbStats(ArrayList<SQLiteDebug.DbStats> paramArrayList)
  {
    int i = nativeGetDbLookaside(this.mConnectionPtr);
    long l1 = 0L;
    long l2 = 0L;
    try
    {
      l1 = executeForLong("PRAGMA page_count;", null, null);
      long l7 = executeForLong("PRAGMA page_size;", null, null);
      l2 = l7;
      label38: paramArrayList.add(getMainDbStatsUnsafe(i, l1, l2));
      CursorWindow localCursorWindow = new CursorWindow();
      try
      {
        executeForCursorWindow("PRAGMA database_list;", null, localCursorWindow, 0, 0, false, null);
        int j = 1;
        while (true)
          if (j < localCursorWindow.getNumRows())
          {
            String str1 = localCursorWindow.getString(j, 1);
            String str2 = localCursorWindow.getString(j, 2);
            long l3 = 0L;
            long l4 = 0L;
            try
            {
              l3 = executeForLong("PRAGMA " + str1 + ".page_count;", null, null);
              long l6 = executeForLong("PRAGMA " + str1 + ".page_size;", null, null);
              l4 = l6;
              l5 = l3;
              String str3 = "  (attached) " + str1;
              if (!str2.isEmpty())
                str3 = str3 + ": " + str2;
              paramArrayList.add(new SQLiteDebug.DbStats(str3, l5, l4, 0, 0, 0, 0));
              j++;
            }
            catch (SQLiteException localSQLiteException3)
            {
              while (true)
                long l5 = l3;
            }
          }
        return;
      }
      catch (SQLiteException localSQLiteException2)
      {
      }
      finally
      {
        localCursorWindow.close();
      }
    }
    catch (SQLiteException localSQLiteException1)
    {
      break label38;
    }
  }

  void collectDbStatsUnsafe(ArrayList<SQLiteDebug.DbStats> paramArrayList)
  {
    paramArrayList.add(getMainDbStatsUnsafe(0, 0L, 0L));
  }

  public void enableLocalizedCollators()
  {
    if (hasCodec())
      setLocaleFromConfiguration();
  }

  public void execute(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null)
      throw new IllegalArgumentException("sql must not be null.");
    try
    {
      PreparedStatement localPreparedStatement = acquirePreparedStatement(paramString);
      try
      {
        throwIfStatementForbidden(localPreparedStatement);
        bindArguments(localPreparedStatement, paramArrayOfObject);
        attachCancellationSignal(paramCancellationSignal);
        try
        {
          nativeExecute(this.mConnectionPtr, localPreparedStatement.mStatementPtr);
          return;
        }
        finally
        {
        }
      }
      finally
      {
        releasePreparedStatement(localPreparedStatement);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
  }

  public ParcelFileDescriptor executeForBlobFileDescriptor(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null)
      throw new IllegalArgumentException("sql must not be null.");
    try
    {
      PreparedStatement localPreparedStatement = acquirePreparedStatement(paramString);
      try
      {
        throwIfStatementForbidden(localPreparedStatement);
        bindArguments(localPreparedStatement, paramArrayOfObject);
        attachCancellationSignal(paramCancellationSignal);
        try
        {
          int i = nativeExecuteForBlobFileDescriptor(this.mConnectionPtr, localPreparedStatement.mStatementPtr);
          ParcelFileDescriptor localParcelFileDescriptor1;
          if (i >= 0)
            localParcelFileDescriptor1 = ParcelFileDescriptor.adoptFd(i);
          for (ParcelFileDescriptor localParcelFileDescriptor2 = localParcelFileDescriptor1; ; localParcelFileDescriptor2 = null)
            return localParcelFileDescriptor2;
        }
        finally
        {
        }
      }
      finally
      {
        releasePreparedStatement(localPreparedStatement);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
  }

  public int executeForChangedRowCount(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null)
      throw new IllegalArgumentException("sql must not be null.");
    try
    {
      PreparedStatement localPreparedStatement = acquirePreparedStatement(paramString);
      try
      {
        throwIfStatementForbidden(localPreparedStatement);
        bindArguments(localPreparedStatement, paramArrayOfObject);
        attachCancellationSignal(paramCancellationSignal);
        try
        {
          int i = nativeExecuteForChangedRowCount(this.mConnectionPtr, localPreparedStatement.mStatementPtr);
          return i;
        }
        finally
        {
        }
      }
      finally
      {
        releasePreparedStatement(localPreparedStatement);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
  }

  public int executeForCursorWindow(String paramString, Object[] paramArrayOfObject, CursorWindow paramCursorWindow, int paramInt1, int paramInt2, boolean paramBoolean, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null)
      throw new IllegalArgumentException("sql must not be null.");
    if (paramCursorWindow == null)
      throw new IllegalArgumentException("window must not be null.");
    paramCursorWindow.acquireReference();
    try
    {
      PreparedStatement localPreparedStatement = acquirePreparedStatement(paramString);
      try
      {
        throwIfStatementForbidden(localPreparedStatement);
        bindArguments(localPreparedStatement, paramArrayOfObject);
        attachCancellationSignal(paramCancellationSignal);
        try
        {
          long l = nativeExecuteForCursorWindow(this.mConnectionPtr, localPreparedStatement.mStatementPtr, paramCursorWindow.mWindowPtr, paramInt1, paramInt2, paramBoolean);
          int i = (int)(l >> 32);
          int j = (int)l;
          paramCursorWindow.setStartPosition(i);
          detachCancellationSignal(paramCancellationSignal);
          releasePreparedStatement(localPreparedStatement);
          return j;
        }
        finally
        {
        }
      }
      finally
      {
        releasePreparedStatement(localPreparedStatement);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    finally
    {
      paramCursorWindow.releaseReference();
    }
  }

  public long executeForLastInsertedRowId(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null)
      throw new IllegalArgumentException("sql must not be null.");
    try
    {
      PreparedStatement localPreparedStatement = acquirePreparedStatement(paramString);
      try
      {
        throwIfStatementForbidden(localPreparedStatement);
        bindArguments(localPreparedStatement, paramArrayOfObject);
        attachCancellationSignal(paramCancellationSignal);
        try
        {
          long l = nativeExecuteForLastInsertedRowId(this.mConnectionPtr, localPreparedStatement.mStatementPtr);
          return l;
        }
        finally
        {
        }
      }
      finally
      {
        releasePreparedStatement(localPreparedStatement);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
  }

  public long executeForLong(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null)
      throw new IllegalArgumentException("sql must not be null.");
    try
    {
      PreparedStatement localPreparedStatement = acquirePreparedStatement(paramString);
      try
      {
        throwIfStatementForbidden(localPreparedStatement);
        bindArguments(localPreparedStatement, paramArrayOfObject);
        attachCancellationSignal(paramCancellationSignal);
        try
        {
          long l = nativeExecuteForLong(this.mConnectionPtr, localPreparedStatement.mStatementPtr);
          return l;
        }
        finally
        {
        }
      }
      finally
      {
        releasePreparedStatement(localPreparedStatement);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
  }

  public String executeForString(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null)
      throw new IllegalArgumentException("sql must not be null.");
    try
    {
      PreparedStatement localPreparedStatement = acquirePreparedStatement(paramString);
      try
      {
        throwIfStatementForbidden(localPreparedStatement);
        bindArguments(localPreparedStatement, paramArrayOfObject);
        attachCancellationSignal(paramCancellationSignal);
        try
        {
          String str = nativeExecuteForString(this.mConnectionPtr, localPreparedStatement.mStatementPtr);
          return str;
        }
        finally
        {
        }
      }
      finally
      {
        releasePreparedStatement(localPreparedStatement);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
  }

  protected void finalize()
    throws Throwable
  {
    try
    {
      if ((this.mPool != null) && (this.mConnectionPtr != 0L))
        this.mPool.onConnectionLeaked();
      dispose(true);
      return;
    }
    finally
    {
      super.finalize();
    }
  }

  public int getConnectionId()
  {
    return this.mConnectionId;
  }

  boolean isPreparedStatementInCache(String paramString)
  {
    return this.mPreparedStatementCache.get(paramString) != null;
  }

  public boolean isPrimaryConnection()
  {
    return this.mIsPrimaryConnection;
  }

  public void onCancel()
  {
    nativeCancel(this.mConnectionPtr);
  }

  public void prepare(String paramString, SQLiteStatementInfo paramSQLiteStatementInfo)
  {
    if (paramString == null)
      throw new IllegalArgumentException("sql must not be null.");
    try
    {
      PreparedStatement localPreparedStatement = acquirePreparedStatement(paramString);
      if (paramSQLiteStatementInfo != null);
      try
      {
        paramSQLiteStatementInfo.numParameters = localPreparedStatement.mNumParameters;
        paramSQLiteStatementInfo.readOnly = localPreparedStatement.mReadOnly;
        int i = nativeGetColumnCount(this.mConnectionPtr, localPreparedStatement.mStatementPtr);
        if (i == 0)
          paramSQLiteStatementInfo.columnNames = EMPTY_STRING_ARRAY;
        while (true)
        {
          return;
          paramSQLiteStatementInfo.columnNames = new String[i];
          for (int j = 0; j < i; j++)
            paramSQLiteStatementInfo.columnNames[j] = nativeGetColumnName(this.mConnectionPtr, localPreparedStatement.mStatementPtr, j);
        }
      }
      finally
      {
        releasePreparedStatement(localPreparedStatement);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
  }

  void reconfigure(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration)
  {
    int i = 1;
    this.mOnlyAllowReadOnlyOperations = false;
    int j = paramSQLiteDatabaseConfiguration.customFunctions.size();
    for (int k = 0; k < j; k++)
    {
      SQLiteCustomFunction localSQLiteCustomFunction = (SQLiteCustomFunction)paramSQLiteDatabaseConfiguration.customFunctions.get(k);
      if (!this.mConfiguration.customFunctions.contains(localSQLiteCustomFunction))
        nativeRegisterCustomFunction(this.mConnectionPtr, localSQLiteCustomFunction);
    }
    int m;
    int n;
    if (paramSQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled != this.mConfiguration.foreignKeyConstraintsEnabled)
    {
      m = i;
      if ((0x20000000 & (paramSQLiteDatabaseConfiguration.openFlags ^ this.mConfiguration.openFlags)) == 0)
        break label165;
      n = i;
      label107: if (paramSQLiteDatabaseConfiguration.locale.equals(this.mConfiguration.locale))
        break label171;
    }
    while (true)
    {
      this.mConfiguration.updateParametersFrom(paramSQLiteDatabaseConfiguration);
      if (m != 0)
        setForeignKeyModeFromConfiguration();
      if (n != 0)
        setWalModeFromConfiguration();
      if (i != 0)
        setLocaleFromConfiguration();
      return;
      m = 0;
      break;
      label165: n = 0;
      break label107;
      label171: i = 0;
    }
  }

  void setOnlyAllowReadOnlyOperations(boolean paramBoolean)
  {
    this.mOnlyAllowReadOnlyOperations = paramBoolean;
  }

  public String toString()
  {
    return "SQLiteConnection: " + this.mConfiguration.path + " (" + this.mConnectionId + ")";
  }

  private static final class PreparedStatement
  {
    public boolean mInCache;
    public boolean mInUse;
    public int mNumParameters;
    public PreparedStatement mPoolNext;
    public boolean mReadOnly;
    public String mSql;
    public long mStatementPtr;
  }

  private final class PreparedStatementCache extends LruCache<String, SQLiteConnection.PreparedStatement>
  {
    public PreparedStatementCache(int arg2)
    {
      super();
    }

    protected void entryRemoved(boolean paramBoolean, String paramString, SQLiteConnection.PreparedStatement paramPreparedStatement1, SQLiteConnection.PreparedStatement paramPreparedStatement2)
    {
      paramPreparedStatement1.mInCache = false;
      if (!paramPreparedStatement1.mInUse)
        SQLiteConnection.this.finalizePreparedStatement(paramPreparedStatement1);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.sqlite.database.sqlite.SQLiteConnection
 * JD-Core Version:    0.6.2
 */