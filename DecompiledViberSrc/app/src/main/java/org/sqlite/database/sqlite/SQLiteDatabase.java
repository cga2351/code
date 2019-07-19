package org.sqlite.database.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import android.util.EventLog;
import android.util.Log;
import android.util.Printer;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.WeakHashMap;
import org.sqlite.database.DatabaseErrorHandler;
import org.sqlite.database.DatabaseUtils;
import org.sqlite.database.DefaultDatabaseErrorHandler;
import org.sqlite.database.SQLException;
import org.sqlite.os.CancellationSignal;

public final class SQLiteDatabase extends SQLiteClosable
{
  public static final int CONFLICT_ABORT = 2;
  public static final int CONFLICT_FAIL = 3;
  public static final int CONFLICT_IGNORE = 4;
  public static final int CONFLICT_NONE = 0;
  public static final int CONFLICT_REPLACE = 5;
  public static final int CONFLICT_ROLLBACK = 1;
  private static final String[] CONFLICT_VALUES;
  public static final int CREATE_IF_NECESSARY = 268435456;
  public static final int ENABLE_WRITE_AHEAD_LOGGING = 536870912;
  private static final int EVENT_DB_CORRUPT = 75004;
  public static final int MAX_SQL_CACHE_SIZE = 100;
  public static final int NO_LOCALIZED_COLLATORS = 16;
  public static final int OPEN_READONLY = 1;
  public static final int OPEN_READWRITE = 0;
  private static final int OPEN_READ_MASK = 1;
  public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
  private static final String TAG = "SQLiteDatabase";
  private static final WeakHashMap<SQLiteDatabase, Object> sActiveDatabases;
  private final CloseGuard mCloseGuardLocked = CloseGuard.get();
  private final SQLiteDatabaseConfiguration mConfigurationLocked;
  private SQLiteConnectionPool mConnectionPoolLocked;
  private final CursorFactory mCursorFactory;
  private final boolean mEnableJournalSizeLimit;
  private final DatabaseErrorHandler mErrorHandler;
  private boolean mHasAttachedDbsLocked;
  private final Object mLock = new Object();
  private final ThreadLocal<SQLiteSession> mThreadSession = new ThreadLocal()
  {
    protected SQLiteSession initialValue()
    {
      return SQLiteDatabase.this.createSession();
    }
  };

  static
  {
    if (!SQLiteDatabase.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      sActiveDatabases = new WeakHashMap(5);
      CONFLICT_VALUES = new String[] { "", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE " };
      return;
    }
  }

  private SQLiteDatabase(String paramString, int paramInt, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler, boolean paramBoolean)
  {
    this.mEnableJournalSizeLimit = paramBoolean;
    this.mCursorFactory = paramCursorFactory;
    if (paramDatabaseErrorHandler != null);
    while (true)
    {
      this.mErrorHandler = paramDatabaseErrorHandler;
      this.mConfigurationLocked = new SQLiteDatabaseConfiguration(paramString, paramInt, paramBoolean);
      return;
      paramDatabaseErrorHandler = new DefaultDatabaseErrorHandler();
    }
  }

  private void beginTransaction(SQLiteTransactionListener paramSQLiteTransactionListener, boolean paramBoolean)
  {
    acquireReference();
    try
    {
      SQLiteSession localSQLiteSession = getThreadSession();
      if (paramBoolean);
      for (int i = 2; ; i = 1)
      {
        localSQLiteSession.beginTransaction(i, paramSQLiteTransactionListener, getThreadDefaultConnectionFlags(false), null);
        return;
      }
    }
    finally
    {
      releaseReference();
    }
  }

  private void collectDbStats(ArrayList<SQLiteDebug.DbStats> paramArrayList)
  {
    synchronized (this.mLock)
    {
      if (this.mConnectionPoolLocked != null)
        this.mConnectionPoolLocked.collectDbStats(paramArrayList);
      return;
    }
  }

  public static SQLiteDatabase create(CursorFactory paramCursorFactory, boolean paramBoolean)
  {
    return openDatabase(":memory:", paramCursorFactory, 268435456, paramBoolean);
  }

  public static boolean deleteDatabase(File paramFile)
  {
    int i = 0;
    if (paramFile == null)
      throw new IllegalArgumentException("file must not be null");
    boolean bool1 = false | paramFile.delete() | new File(paramFile.getPath() + "-journal").delete() | new File(paramFile.getPath() + "-shm").delete() | new File(paramFile.getPath() + "-wal").delete();
    File localFile = paramFile.getParentFile();
    if (localFile != null)
    {
      File[] arrayOfFile = localFile.listFiles(new FileFilter()
      {
        public boolean accept(File paramAnonymousFile)
        {
          return paramAnonymousFile.getName().startsWith(this.val$prefix);
        }
      });
      int j = arrayOfFile.length;
      while (i < j)
      {
        boolean bool2 = bool1 | arrayOfFile[i].delete();
        i++;
        bool1 = bool2;
      }
    }
    return bool1;
  }

  private void dispose(boolean paramBoolean)
  {
    SQLiteConnectionPool localSQLiteConnectionPool;
    synchronized (this.mLock)
    {
      if (this.mCloseGuardLocked != null)
      {
        if (paramBoolean)
          this.mCloseGuardLocked.warnIfOpen();
        this.mCloseGuardLocked.close();
      }
      localSQLiteConnectionPool = this.mConnectionPoolLocked;
      this.mConnectionPoolLocked = null;
      if (paramBoolean);
    }
    synchronized (sActiveDatabases)
    {
      sActiveDatabases.remove(this);
      if (localSQLiteConnectionPool != null)
        localSQLiteConnectionPool.close();
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }

  private void dump(Printer paramPrinter, boolean paramBoolean)
  {
    synchronized (this.mLock)
    {
      if (this.mConnectionPoolLocked != null)
      {
        paramPrinter.println("");
        this.mConnectionPoolLocked.dump(paramPrinter, paramBoolean);
      }
      return;
    }
  }

  static void dumpAll(Printer paramPrinter, boolean paramBoolean)
  {
    Iterator localIterator = getActiveDatabases().iterator();
    while (localIterator.hasNext())
      ((SQLiteDatabase)localIterator.next()).dump(paramPrinter, paramBoolean);
  }

  // ERROR //
  private int executeSql(String paramString, Object[] paramArrayOfObject)
    throws SQLException
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: invokevirtual 138	org/sqlite/database/sqlite/SQLiteDatabase:acquireReference	()V
    //   6: aload_1
    //   7: invokestatic 274	org/sqlite/database/DatabaseUtils:getSqlStatementType	(Ljava/lang/String;)I
    //   10: iconst_3
    //   11: if_icmpne +35 -> 46
    //   14: aload_0
    //   15: getfield 109	org/sqlite/database/sqlite/SQLiteDatabase:mLock	Ljava/lang/Object;
    //   18: astore 8
    //   20: aload 8
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 276	org/sqlite/database/sqlite/SQLiteDatabase:mHasAttachedDbsLocked	Z
    //   27: ifne +77 -> 104
    //   30: aload_0
    //   31: iconst_1
    //   32: putfield 276	org/sqlite/database/sqlite/SQLiteDatabase:mHasAttachedDbsLocked	Z
    //   35: aload 8
    //   37: monitorexit
    //   38: iload_3
    //   39: ifeq +7 -> 46
    //   42: aload_0
    //   43: invokevirtual 279	org/sqlite/database/sqlite/SQLiteDatabase:disableWriteAheadLogging	()V
    //   46: new 281	org/sqlite/database/sqlite/SQLiteStatement
    //   49: dup
    //   50: aload_0
    //   51: aload_1
    //   52: aload_2
    //   53: invokespecial 284	org/sqlite/database/sqlite/SQLiteStatement:<init>	(Lorg/sqlite/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/Object;)V
    //   56: astore 5
    //   58: aload 5
    //   60: invokevirtual 288	org/sqlite/database/sqlite/SQLiteStatement:executeUpdateDelete	()I
    //   63: istore 7
    //   65: aload 5
    //   67: invokevirtual 289	org/sqlite/database/sqlite/SQLiteStatement:close	()V
    //   70: aload_0
    //   71: invokevirtual 154	org/sqlite/database/sqlite/SQLiteDatabase:releaseReference	()V
    //   74: iload 7
    //   76: ireturn
    //   77: astore 9
    //   79: aload 8
    //   81: monitorexit
    //   82: aload 9
    //   84: athrow
    //   85: astore 4
    //   87: aload_0
    //   88: invokevirtual 154	org/sqlite/database/sqlite/SQLiteDatabase:releaseReference	()V
    //   91: aload 4
    //   93: athrow
    //   94: astore 6
    //   96: aload 5
    //   98: invokevirtual 289	org/sqlite/database/sqlite/SQLiteStatement:close	()V
    //   101: aload 6
    //   103: athrow
    //   104: iconst_0
    //   105: istore_3
    //   106: goto -71 -> 35
    //
    // Exception table:
    //   from	to	target	type
    //   23	35	77	finally
    //   35	38	77	finally
    //   79	82	77	finally
    //   6	23	85	finally
    //   42	46	85	finally
    //   46	58	85	finally
    //   65	70	85	finally
    //   82	85	85	finally
    //   96	104	85	finally
    //   58	65	94	finally
  }

  private static ArrayList<SQLiteDatabase> getActiveDatabases()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (sActiveDatabases)
    {
      localArrayList.addAll(sActiveDatabases.keySet());
      return localArrayList;
    }
  }

  static ArrayList<SQLiteDebug.DbStats> getDbStats()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getActiveDatabases().iterator();
    while (localIterator.hasNext())
      ((SQLiteDatabase)localIterator.next()).collectDbStats(localArrayList);
    return localArrayList;
  }

  public static boolean hasCodec()
  {
    return SQLiteConnection.hasCodec();
  }

  @Deprecated
  private static boolean isMainThread()
  {
    Looper localLooper = Looper.myLooper();
    return (localLooper != null) && (localLooper == Looper.getMainLooper());
  }

  private boolean isReadOnlyLocked()
  {
    return (0x1 & this.mConfigurationLocked.openFlags) == 1;
  }

  private void open()
  {
    try
    {
      openInner();
      return;
    }
    catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
    {
      onCorruption();
      openInner();
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      close();
      throw localSQLiteException;
    }
  }

  public static SQLiteDatabase openDatabase(String paramString, CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler, boolean paramBoolean)
  {
    SQLiteDatabase localSQLiteDatabase = new SQLiteDatabase(paramString, paramInt, paramCursorFactory, paramDatabaseErrorHandler, paramBoolean);
    localSQLiteDatabase.open();
    return localSQLiteDatabase;
  }

  public static SQLiteDatabase openDatabase(String paramString, CursorFactory paramCursorFactory, int paramInt, boolean paramBoolean)
  {
    return openDatabase(paramString, paramCursorFactory, paramInt, null, paramBoolean);
  }

  private void openInner()
  {
    synchronized (this.mLock)
    {
      if ((!$assertionsDisabled) && (this.mConnectionPoolLocked != null))
        throw new AssertionError();
    }
    this.mConnectionPoolLocked = SQLiteConnectionPool.open(this.mConfigurationLocked);
    this.mCloseGuardLocked.open("close");
    synchronized (sActiveDatabases)
    {
      sActiveDatabases.put(this, null);
      return;
    }
  }

  public static SQLiteDatabase openOrCreateDatabase(File paramFile, CursorFactory paramCursorFactory, boolean paramBoolean)
  {
    return openOrCreateDatabase(paramFile.getPath(), paramCursorFactory, paramBoolean);
  }

  public static SQLiteDatabase openOrCreateDatabase(String paramString, CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler, boolean paramBoolean)
  {
    return openDatabase(paramString, paramCursorFactory, 268435456, paramDatabaseErrorHandler, paramBoolean);
  }

  public static SQLiteDatabase openOrCreateDatabase(String paramString, CursorFactory paramCursorFactory, boolean paramBoolean)
  {
    return openDatabase(paramString, paramCursorFactory, 268435456, null, paramBoolean);
  }

  public static int releaseMemory()
  {
    return SQLiteGlobal.releaseMemory();
  }

  private void throwIfNotOpenLocked()
  {
    if (this.mConnectionPoolLocked == null)
      throw new IllegalStateException("The database '" + this.mConfigurationLocked.label + "' is not open.");
  }

  private boolean yieldIfContendedHelper(boolean paramBoolean, long paramLong)
  {
    acquireReference();
    try
    {
      boolean bool = getThreadSession().yieldTransaction(paramLong, paramBoolean, null);
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }

  public void addCustomFunction(String paramString, int paramInt, CustomFunction paramCustomFunction)
  {
    SQLiteCustomFunction localSQLiteCustomFunction = new SQLiteCustomFunction(paramString, paramInt, paramCustomFunction);
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      this.mConfigurationLocked.customFunctions.add(localSQLiteCustomFunction);
      try
      {
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        this.mConfigurationLocked.customFunctions.remove(localSQLiteCustomFunction);
        throw localRuntimeException;
      }
    }
  }

  public void beginTransaction()
  {
    beginTransaction(null, true);
  }

  public void beginTransactionNonExclusive()
  {
    beginTransaction(null, false);
  }

  public void beginTransactionWithListener(SQLiteTransactionListener paramSQLiteTransactionListener)
  {
    beginTransaction(paramSQLiteTransactionListener, true);
  }

  public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener paramSQLiteTransactionListener)
  {
    beginTransaction(paramSQLiteTransactionListener, false);
  }

  public SQLiteStatement compileStatement(String paramString)
    throws SQLException
  {
    acquireReference();
    try
    {
      SQLiteStatement localSQLiteStatement = new SQLiteStatement(this, paramString, null);
      return localSQLiteStatement;
    }
    finally
    {
      releaseReference();
    }
  }

  SQLiteSession createSession()
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      SQLiteConnectionPool localSQLiteConnectionPool = this.mConnectionPoolLocked;
      return new SQLiteSession(localSQLiteConnectionPool);
    }
  }

  public int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    acquireReference();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder().append("DELETE FROM ").append(paramString1);
      if (!TextUtils.isEmpty(paramString2))
      {
        str = " WHERE " + paramString2;
        localSQLiteStatement = new SQLiteStatement(this, str, paramArrayOfString);
      }
    }
    finally
    {
      try
      {
        int i = localSQLiteStatement.executeUpdateDelete();
        localSQLiteStatement.close();
        return i;
        String str = "";
      }
      finally
      {
        SQLiteStatement localSQLiteStatement;
        localSQLiteStatement.close();
      }
      releaseReference();
    }
  }

  public void disableWriteAheadLogging()
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      if ((0x20000000 & this.mConfigurationLocked.openFlags) == 0)
        return;
      SQLiteDatabaseConfiguration localSQLiteDatabaseConfiguration1 = this.mConfigurationLocked;
      localSQLiteDatabaseConfiguration1.openFlags = (0xDFFFFFFF & localSQLiteDatabaseConfiguration1.openFlags);
    }
    try
    {
      this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (RuntimeException localRuntimeException)
    {
      SQLiteDatabaseConfiguration localSQLiteDatabaseConfiguration2 = this.mConfigurationLocked;
      localSQLiteDatabaseConfiguration2.openFlags = (0x20000000 | localSQLiteDatabaseConfiguration2.openFlags);
      throw localRuntimeException;
    }
  }

  public void enableLocalizedCollators()
  {
    this.mConnectionPoolLocked.enableLocalizedCollators();
  }

  public boolean enableWriteAheadLogging()
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      if ((0x20000000 & this.mConfigurationLocked.openFlags) != 0)
        return true;
      if (isReadOnlyLocked())
        return false;
      if (this.mConfigurationLocked.isInMemoryDb())
      {
        Log.i("SQLiteDatabase", "can't enable WAL for memory databases.");
        return false;
      }
      if (this.mHasAttachedDbsLocked)
        return false;
      SQLiteDatabaseConfiguration localSQLiteDatabaseConfiguration1 = this.mConfigurationLocked;
      localSQLiteDatabaseConfiguration1.openFlags = (0x20000000 | localSQLiteDatabaseConfiguration1.openFlags);
    }
    try
    {
      this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
      return true;
      localObject2 = finally;
      throw localObject2;
    }
    catch (RuntimeException localRuntimeException)
    {
      SQLiteDatabaseConfiguration localSQLiteDatabaseConfiguration2 = this.mConfigurationLocked;
      localSQLiteDatabaseConfiguration2.openFlags = (0xDFFFFFFF & localSQLiteDatabaseConfiguration2.openFlags);
      throw localRuntimeException;
    }
  }

  public void endTransaction()
  {
    acquireReference();
    try
    {
      getThreadSession().endTransaction(null);
      return;
    }
    finally
    {
      releaseReference();
    }
  }

  public void execSQL(String paramString)
    throws SQLException
  {
    executeSql(paramString, null);
  }

  public void execSQL(String paramString, Object[] paramArrayOfObject)
    throws SQLException
  {
    if (paramArrayOfObject == null)
      throw new IllegalArgumentException("Empty bindArgs");
    executeSql(paramString, paramArrayOfObject);
  }

  protected void finalize()
    throws Throwable
  {
    try
    {
      dispose(true);
      return;
    }
    finally
    {
      super.finalize();
    }
  }

  // ERROR //
  public java.util.List<android.util.Pair<String, String>> getAttachedDbs()
  {
    // Byte code:
    //   0: new 250	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 290	java/util/ArrayList:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 109	org/sqlite/database/sqlite/SQLiteDatabase:mLock	Ljava/lang/Object;
    //   12: astore_2
    //   13: aload_2
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 158	org/sqlite/database/sqlite/SQLiteDatabase:mConnectionPoolLocked	Lorg/sqlite/database/sqlite/SQLiteConnectionPool;
    //   19: ifnonnull +7 -> 26
    //   22: aload_2
    //   23: monitorexit
    //   24: aconst_null
    //   25: areturn
    //   26: aload_0
    //   27: getfield 276	org/sqlite/database/sqlite/SQLiteDatabase:mHasAttachedDbsLocked	Z
    //   30: ifne +29 -> 59
    //   33: aload_1
    //   34: new 466	android/util/Pair
    //   37: dup
    //   38: ldc_w 468
    //   41: aload_0
    //   42: getfield 130	org/sqlite/database/sqlite/SQLiteDatabase:mConfigurationLocked	Lorg/sqlite/database/sqlite/SQLiteDatabaseConfiguration;
    //   45: getfield 471	org/sqlite/database/sqlite/SQLiteDatabaseConfiguration:path	Ljava/lang/String;
    //   48: invokespecial 474	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   51: invokevirtual 398	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   54: pop
    //   55: aload_2
    //   56: monitorexit
    //   57: aload_1
    //   58: areturn
    //   59: aload_0
    //   60: invokevirtual 138	org/sqlite/database/sqlite/SQLiteDatabase:acquireReference	()V
    //   63: aload_2
    //   64: monitorexit
    //   65: aload_0
    //   66: ldc_w 476
    //   69: aconst_null
    //   70: invokevirtual 480	org/sqlite/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   73: astore 8
    //   75: aload 8
    //   77: invokeinterface 485 1 0
    //   82: ifeq +69 -> 151
    //   85: aload_1
    //   86: new 466	android/util/Pair
    //   89: dup
    //   90: aload 8
    //   92: iconst_1
    //   93: invokeinterface 489 2 0
    //   98: aload 8
    //   100: iconst_2
    //   101: invokeinterface 489 2 0
    //   106: invokespecial 474	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   109: invokevirtual 398	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   112: pop
    //   113: goto -38 -> 75
    //   116: astore 5
    //   118: aload 8
    //   120: astore 6
    //   122: aload 6
    //   124: ifnull +10 -> 134
    //   127: aload 6
    //   129: invokeinterface 490 1 0
    //   134: aload 5
    //   136: athrow
    //   137: astore 7
    //   139: aload_0
    //   140: invokevirtual 154	org/sqlite/database/sqlite/SQLiteDatabase:releaseReference	()V
    //   143: aload 7
    //   145: athrow
    //   146: astore_3
    //   147: aload_2
    //   148: monitorexit
    //   149: aload_3
    //   150: athrow
    //   151: aload 8
    //   153: ifnull +10 -> 163
    //   156: aload 8
    //   158: invokeinterface 490 1 0
    //   163: aload_0
    //   164: invokevirtual 154	org/sqlite/database/sqlite/SQLiteDatabase:releaseReference	()V
    //   167: aload_1
    //   168: areturn
    //   169: astore 4
    //   171: aload 4
    //   173: astore 5
    //   175: aconst_null
    //   176: astore 6
    //   178: goto -56 -> 122
    //
    // Exception table:
    //   from	to	target	type
    //   75	113	116	finally
    //   127	134	137	finally
    //   134	137	137	finally
    //   156	163	137	finally
    //   15	24	146	finally
    //   26	57	146	finally
    //   59	65	146	finally
    //   147	149	146	finally
    //   65	75	169	finally
  }

  String getLabel()
  {
    synchronized (this.mLock)
    {
      String str = this.mConfigurationLocked.label;
      return str;
    }
  }

  public long getMaximumSize()
  {
    return DatabaseUtils.longForQuery(this, "PRAGMA max_page_count;", null) * getPageSize();
  }

  public long getPageSize()
  {
    return DatabaseUtils.longForQuery(this, "PRAGMA page_size;", null);
  }

  public final String getPath()
  {
    synchronized (this.mLock)
    {
      String str = this.mConfigurationLocked.path;
      return str;
    }
  }

  int getThreadDefaultConnectionFlags(boolean paramBoolean)
  {
    if (paramBoolean)
      return 1;
    return 2;
  }

  SQLiteSession getThreadSession()
  {
    return (SQLiteSession)this.mThreadSession.get();
  }

  public int getVersion()
  {
    return Long.valueOf(DatabaseUtils.longForQuery(this, "PRAGMA user_version;", null)).intValue();
  }

  public boolean inTransaction()
  {
    acquireReference();
    try
    {
      boolean bool = getThreadSession().hasTransaction();
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }

  public long insert(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    try
    {
      long l = insertWithOnConflict(paramString1, paramString2, paramContentValues, 0);
      return l;
    }
    catch (SQLException localSQLException)
    {
    }
    return -1L;
  }

  public long insertOrThrow(String paramString1, String paramString2, ContentValues paramContentValues)
    throws SQLException
  {
    return insertWithOnConflict(paramString1, paramString2, paramContentValues, 0);
  }

  public long insertWithOnConflict(String paramString1, String paramString2, ContentValues paramContentValues, int paramInt)
  {
    acquireReference();
    if (paramContentValues != null);
    while (true)
    {
      int i;
      StringBuilder localStringBuilder;
      Object[] arrayOfObject1;
      int k;
      try
      {
        if (paramContentValues.size() <= 0)
          break label322;
        i = paramContentValues.size();
        localStringBuilder = new StringBuilder(60 + i * 12);
        localStringBuilder.append("INSERT");
        localStringBuilder.append(CONFLICT_VALUES[paramInt]);
        localStringBuilder.append(" INTO ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append('(');
        if (i <= 0)
          break label280;
        arrayOfObject1 = new Object[i];
        Iterator localIterator = paramContentValues.keySet().iterator();
        int j = 0;
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (j > 0)
            localStringBuilder.append(',');
          localStringBuilder.append(str);
          int m = j + 1;
          arrayOfObject1[j] = paramContentValues.get(str);
          j = m;
          continue;
        }
        localStringBuilder.append(") VALUES (");
        k = 0;
        if (k < i)
          if (k > 0)
            localStringBuilder.append(",?");
          else
            localStringBuilder.append('?');
      }
      finally
      {
        releaseReference();
      }
      Object[] arrayOfObject2 = arrayOfObject1;
      while (true)
      {
        localStringBuilder.append(')');
        SQLiteStatement localSQLiteStatement = new SQLiteStatement(this, localStringBuilder.toString(), arrayOfObject2);
        label280: label322: 
        try
        {
          long l = localSQLiteStatement.executeInsert();
          localSQLiteStatement.close();
          return l;
          localStringBuilder.append(paramString2 + ") VALUES (NULL");
          arrayOfObject2 = null;
        }
        finally
        {
          localSQLiteStatement.close();
        }
      }
      continue;
      k++;
    }
  }

  // ERROR //
  public boolean isDatabaseIntegrityOk()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 138	org/sqlite/database/sqlite/SQLiteDatabase:acquireReference	()V
    //   4: aload_0
    //   5: invokevirtual 565	org/sqlite/database/sqlite/SQLiteDatabase:getAttachedDbs	()Ljava/util/List;
    //   8: astore 12
    //   10: aload 12
    //   12: ifnonnull +175 -> 187
    //   15: new 366	java/lang/IllegalStateException
    //   18: dup
    //   19: new 186	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   26: ldc_w 567
    //   29: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: invokevirtual 568	org/sqlite/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   36: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc_w 570
    //   42: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokespecial 374	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   51: athrow
    //   52: astore_2
    //   53: new 250	java/util/ArrayList
    //   56: dup
    //   57: invokespecial 290	java/util/ArrayList:<init>	()V
    //   60: astore_3
    //   61: aload_3
    //   62: new 466	android/util/Pair
    //   65: dup
    //   66: ldc_w 468
    //   69: aload_0
    //   70: invokevirtual 568	org/sqlite/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   73: invokespecial 474	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   76: invokeinterface 573 2 0
    //   81: pop
    //   82: aload_3
    //   83: astore 5
    //   85: goto +157 -> 242
    //   88: iload 6
    //   90: aload 5
    //   92: invokeinterface 574 1 0
    //   97: if_icmpge +130 -> 227
    //   100: aload 5
    //   102: iload 6
    //   104: invokeinterface 577 2 0
    //   109: checkcast 466	android/util/Pair
    //   112: astore 7
    //   114: aload_0
    //   115: new 186	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   122: ldc_w 579
    //   125: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload 7
    //   130: getfield 582	android/util/Pair:first	Ljava/lang/Object;
    //   133: checkcast 80	java/lang/String
    //   136: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc_w 584
    //   142: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokevirtual 586	org/sqlite/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Lorg/sqlite/database/sqlite/SQLiteStatement;
    //   151: astore 10
    //   153: aload 10
    //   155: invokevirtual 589	org/sqlite/database/sqlite/SQLiteStatement:simpleQueryForString	()Ljava/lang/String;
    //   158: ldc_w 591
    //   161: invokevirtual 595	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   164: istore 11
    //   166: iload 11
    //   168: ifne +26 -> 194
    //   171: aload 10
    //   173: ifnull +8 -> 181
    //   176: aload 10
    //   178: invokevirtual 289	org/sqlite/database/sqlite/SQLiteStatement:close	()V
    //   181: aload_0
    //   182: invokevirtual 154	org/sqlite/database/sqlite/SQLiteDatabase:releaseReference	()V
    //   185: iconst_0
    //   186: ireturn
    //   187: aload 12
    //   189: astore 5
    //   191: goto +51 -> 242
    //   194: aload 10
    //   196: ifnull +52 -> 248
    //   199: aload 10
    //   201: invokevirtual 289	org/sqlite/database/sqlite/SQLiteStatement:close	()V
    //   204: goto +44 -> 248
    //   207: aload 9
    //   209: ifnull +8 -> 217
    //   212: aload 9
    //   214: invokevirtual 289	org/sqlite/database/sqlite/SQLiteStatement:close	()V
    //   217: aload 8
    //   219: athrow
    //   220: astore_1
    //   221: aload_0
    //   222: invokevirtual 154	org/sqlite/database/sqlite/SQLiteDatabase:releaseReference	()V
    //   225: aload_1
    //   226: athrow
    //   227: aload_0
    //   228: invokevirtual 154	org/sqlite/database/sqlite/SQLiteDatabase:releaseReference	()V
    //   231: iconst_1
    //   232: ireturn
    //   233: astore 8
    //   235: aload 10
    //   237: astore 9
    //   239: goto -32 -> 207
    //   242: iconst_0
    //   243: istore 6
    //   245: goto -157 -> 88
    //   248: iinc 6 1
    //   251: goto -163 -> 88
    //   254: astore 8
    //   256: aconst_null
    //   257: astore 9
    //   259: goto -52 -> 207
    //
    // Exception table:
    //   from	to	target	type
    //   4	10	52	org/sqlite/database/sqlite/SQLiteException
    //   15	52	52	org/sqlite/database/sqlite/SQLiteException
    //   4	10	220	finally
    //   15	52	220	finally
    //   53	82	220	finally
    //   88	114	220	finally
    //   176	181	220	finally
    //   199	204	220	finally
    //   212	217	220	finally
    //   217	220	220	finally
    //   153	166	233	finally
    //   114	153	254	finally
  }

  public boolean isDbLockedByCurrentThread()
  {
    acquireReference();
    try
    {
      boolean bool = getThreadSession().hasConnection();
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }

  public boolean isInMemoryDatabase()
  {
    synchronized (this.mLock)
    {
      boolean bool = this.mConfigurationLocked.isInMemoryDb();
      return bool;
    }
  }

  public boolean isOpen()
  {
    while (true)
    {
      synchronized (this.mLock)
      {
        if (this.mConnectionPoolLocked != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  public boolean isReadOnly()
  {
    synchronized (this.mLock)
    {
      boolean bool = isReadOnlyLocked();
      return bool;
    }
  }

  public boolean isWriteAheadLoggingEnabled()
  {
    while (true)
    {
      synchronized (this.mLock)
      {
        throwIfNotOpenLocked();
        if ((0x20000000 & this.mConfigurationLocked.openFlags) != 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  public boolean needUpgrade(int paramInt)
  {
    return paramInt > getVersion();
  }

  protected void onAllReferencesReleased()
  {
    dispose(false);
  }

  void onCorruption()
  {
    EventLog.writeEvent(75004, getLabel());
    this.mErrorHandler.onCorruption(this);
  }

  public Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
  {
    return query(false, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, null);
  }

  public Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return query(false, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
  }

  public Cursor query(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return queryWithFactory(null, paramBoolean, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6, null);
  }

  public Cursor query(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6, CancellationSignal paramCancellationSignal)
  {
    return queryWithFactory(null, paramBoolean, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6, paramCancellationSignal);
  }

  public Cursor queryWithFactory(CursorFactory paramCursorFactory, boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return queryWithFactory(paramCursorFactory, paramBoolean, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6, null);
  }

  public Cursor queryWithFactory(CursorFactory paramCursorFactory, boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6, CancellationSignal paramCancellationSignal)
  {
    acquireReference();
    try
    {
      Cursor localCursor = rawQueryWithFactory(paramCursorFactory, SQLiteQueryBuilder.buildQueryString(paramBoolean, paramString1, paramArrayOfString1, paramString2, paramString3, paramString4, paramString5, paramString6), paramArrayOfString2, paramCancellationSignal);
      return localCursor;
    }
    finally
    {
      releaseReference();
    }
  }

  public Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    return rawQueryWithFactory(null, paramString, paramArrayOfString, null);
  }

  public Cursor rawQuery(String paramString, String[] paramArrayOfString, CancellationSignal paramCancellationSignal)
  {
    return rawQueryWithFactory(null, paramString, paramArrayOfString, paramCancellationSignal);
  }

  public Cursor rawQueryWithCustomWindowSize(int paramInt, String paramString, String[] paramArrayOfString)
  {
    acquireReference();
    try
    {
      Cursor localCursor = new SQLiteDirectCursorDriver(this, paramString, null).query(paramInt, paramArrayOfString);
      return localCursor;
    }
    finally
    {
      releaseReference();
    }
  }

  public Cursor rawQueryWithFactory(CursorFactory paramCursorFactory, String paramString, String[] paramArrayOfString)
  {
    return rawQueryWithFactory(paramCursorFactory, paramString, paramArrayOfString, null);
  }

  public Cursor rawQueryWithFactory(CursorFactory paramCursorFactory, String paramString, String[] paramArrayOfString, CancellationSignal paramCancellationSignal)
  {
    acquireReference();
    try
    {
      SQLiteDirectCursorDriver localSQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, paramString, paramCancellationSignal);
      if (paramCursorFactory != null);
      while (true)
      {
        Cursor localCursor = localSQLiteDirectCursorDriver.query(paramCursorFactory, paramArrayOfString);
        return localCursor;
        paramCursorFactory = this.mCursorFactory;
      }
    }
    finally
    {
      releaseReference();
    }
  }

  public void reopenReadWrite()
  {
    int i;
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      if (!isReadOnlyLocked())
        return;
      i = this.mConfigurationLocked.openFlags;
      this.mConfigurationLocked.openFlags = (0x0 | 0xFFFFFFFE & this.mConfigurationLocked.openFlags);
    }
    try
    {
      this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (RuntimeException localRuntimeException)
    {
      this.mConfigurationLocked.openFlags = i;
      throw localRuntimeException;
    }
  }

  public long replace(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    try
    {
      long l = insertWithOnConflict(paramString1, paramString2, paramContentValues, 5);
      return l;
    }
    catch (SQLException localSQLException)
    {
    }
    return -1L;
  }

  public long replaceOrThrow(String paramString1, String paramString2, ContentValues paramContentValues)
    throws SQLException
  {
    return insertWithOnConflict(paramString1, paramString2, paramContentValues, 5);
  }

  public void setForeignKeyConstraintsEnabled(boolean paramBoolean)
  {
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      if (this.mConfigurationLocked.foreignKeyConstraintsEnabled == paramBoolean)
        return;
      this.mConfigurationLocked.foreignKeyConstraintsEnabled = paramBoolean;
    }
    SQLiteDatabaseConfiguration localSQLiteDatabaseConfiguration;
    try
    {
      this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (RuntimeException localRuntimeException)
    {
      localSQLiteDatabaseConfiguration = this.mConfigurationLocked;
      if (paramBoolean);
    }
    for (boolean bool = true; ; bool = false)
    {
      localSQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled = bool;
      throw localRuntimeException;
    }
  }

  public void setLocale(Locale paramLocale)
  {
    if (paramLocale == null)
      throw new IllegalArgumentException("locale must not be null.");
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      Locale localLocale = this.mConfigurationLocked.locale;
      this.mConfigurationLocked.locale = paramLocale;
      try
      {
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        this.mConfigurationLocked.locale = localLocale;
        throw localRuntimeException;
      }
    }
  }

  @Deprecated
  public void setLockingEnabled(boolean paramBoolean)
  {
  }

  public void setMaxSqlCacheSize(int paramInt)
  {
    if ((paramInt > 100) || (paramInt < 0))
      throw new IllegalStateException("expected value between 0 and 100");
    synchronized (this.mLock)
    {
      throwIfNotOpenLocked();
      int i = this.mConfigurationLocked.maxSqlCacheSize;
      this.mConfigurationLocked.maxSqlCacheSize = paramInt;
      try
      {
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        this.mConfigurationLocked.maxSqlCacheSize = i;
        throw localRuntimeException;
      }
    }
  }

  public long setMaximumSize(long paramLong)
  {
    long l1 = getPageSize();
    long l2 = paramLong / l1;
    if (paramLong % l1 != 0L)
      l2 += 1L;
    return l1 * DatabaseUtils.longForQuery(this, "PRAGMA max_page_count = " + l2, null);
  }

  public void setPageSize(long paramLong)
  {
    execSQL("PRAGMA page_size = " + paramLong);
  }

  public void setTransactionSuccessful()
  {
    acquireReference();
    try
    {
      getThreadSession().setTransactionSuccessful();
      return;
    }
    finally
    {
      releaseReference();
    }
  }

  public void setVersion(int paramInt)
  {
    execSQL("PRAGMA user_version = " + paramInt);
  }

  public String toString()
  {
    return "SQLiteDatabase: " + getPath();
  }

  public int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    return updateWithOnConflict(paramString1, paramContentValues, paramString2, paramArrayOfString, 0);
  }

  public int updateWithOnConflict(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, int paramInt)
  {
    if ((paramContentValues == null) || (paramContentValues.size() == 0))
      throw new IllegalArgumentException("Empty values");
    acquireReference();
    while (true)
    {
      int i;
      int i1;
      try
      {
        i = paramContentValues.size();
        int j = 24 + i * 16;
        if (paramString2 != null)
          j += 7 + paramString2.length();
        StringBuilder localStringBuilder = new StringBuilder(j);
        localStringBuilder.append("UPDATE ");
        localStringBuilder.append(CONFLICT_VALUES[paramInt]);
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" SET ");
        int k;
        Object[] arrayOfObject;
        if (paramArrayOfString == null)
        {
          k = i;
          arrayOfObject = new Object[k];
          Iterator localIterator = paramContentValues.keySet().iterator();
          int m = 0;
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (m > 0)
              localStringBuilder.append(',');
            localStringBuilder.append(str);
            int i2 = m + 1;
            arrayOfObject[m] = paramContentValues.get(str);
            localStringBuilder.append("=?");
            m = i2;
            continue;
          }
        }
        else
        {
          k = i + paramArrayOfString.length;
          continue;
          if (i1 < k)
          {
            arrayOfObject[i1] = paramArrayOfString[(i1 - i)];
            i1++;
            continue;
          }
          if (!TextUtils.isEmpty(paramString2))
          {
            localStringBuilder.append(" WHERE ");
            localStringBuilder.append(paramString2);
          }
          SQLiteStatement localSQLiteStatement = new SQLiteStatement(this, localStringBuilder.toString(), arrayOfObject);
          try
          {
            int n = localSQLiteStatement.executeUpdateDelete();
            return n;
          }
          finally
          {
          }
        }
      }
      finally
      {
        releaseReference();
      }
      if (paramArrayOfString != null)
        i1 = i;
    }
  }

  @Deprecated
  public boolean yieldIfContended()
  {
    return yieldIfContendedHelper(false, -1L);
  }

  public boolean yieldIfContendedSafely()
  {
    return yieldIfContendedHelper(true, -1L);
  }

  public boolean yieldIfContendedSafely(long paramLong)
  {
    return yieldIfContendedHelper(true, paramLong);
  }

  public static abstract interface CursorFactory
  {
    public abstract Cursor newCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, SQLiteQuery paramSQLiteQuery);
  }

  public static abstract interface CustomFunction
  {
    public abstract void callback(String[] paramArrayOfString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.sqlite.database.sqlite.SQLiteDatabase
 * JD-Core Version:    0.6.2
 */