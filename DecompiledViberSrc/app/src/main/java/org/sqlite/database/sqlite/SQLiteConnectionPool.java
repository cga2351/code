package org.sqlite.database.sqlite;

import android.util.Printer;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;
import org.sqlite.os.CancellationSignal;
import org.sqlite.os.CancellationSignal.OnCancelListener;
import org.sqlite.os.OperationCanceledException;

public final class SQLiteConnectionPool
  implements Closeable
{
  public static final int CONNECTION_FLAG_INTERACTIVE = 4;
  public static final int CONNECTION_FLAG_PRIMARY_CONNECTION_AFFINITY = 2;
  public static final int CONNECTION_FLAG_READ_ONLY = 1;
  private static final long CONNECTION_POOL_BUSY_MILLIS = 30000L;
  private static final String TAG = "SQLiteConnectionPool";
  private final WeakHashMap<SQLiteConnection, AcquiredConnectionStatus> mAcquiredConnections = new WeakHashMap();
  private final ArrayList<SQLiteConnection> mAvailableNonPrimaryConnections = new ArrayList();
  private SQLiteConnection mAvailablePrimaryConnection;
  private final CloseGuard mCloseGuard = CloseGuard.get();
  private final SQLiteDatabaseConfiguration mConfiguration;
  private final AtomicBoolean mConnectionLeaked = new AtomicBoolean();
  private ConnectionWaiter mConnectionWaiterPool;
  private ConnectionWaiter mConnectionWaiterQueue;
  private boolean mIsOpen;
  private final Object mLock = new Object();
  private int mMaxConnectionPoolSize;
  private int mNextConnectionId;

  static
  {
    if (!SQLiteConnectionPool.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }

  private SQLiteConnectionPool(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration)
  {
    this.mConfiguration = new SQLiteDatabaseConfiguration(paramSQLiteDatabaseConfiguration);
    setMaxConnectionPoolSizeLocked();
  }

  private void cancelConnectionWaiterLocked(ConnectionWaiter paramConnectionWaiter)
  {
    if ((paramConnectionWaiter.mAssignedConnection != null) || (paramConnectionWaiter.mException != null))
      return;
    Object localObject1 = null;
    ConnectionWaiter localConnectionWaiter;
    for (Object localObject2 = this.mConnectionWaiterQueue; localObject2 != paramConnectionWaiter; localObject2 = localConnectionWaiter)
    {
      assert (localObject2 != null);
      localConnectionWaiter = ((ConnectionWaiter)localObject2).mNext;
      localObject1 = localObject2;
    }
    if (localObject1 != null)
      localObject1.mNext = paramConnectionWaiter.mNext;
    while (true)
    {
      paramConnectionWaiter.mException = new OperationCanceledException();
      LockSupport.unpark(paramConnectionWaiter.mThread);
      wakeConnectionWaitersLocked();
      return;
      this.mConnectionWaiterQueue = paramConnectionWaiter.mNext;
    }
  }

  private void closeAvailableConnectionsAndLogExceptionsLocked()
  {
    closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked();
    if (this.mAvailablePrimaryConnection != null)
    {
      closeConnectionAndLogExceptionsLocked(this.mAvailablePrimaryConnection);
      this.mAvailablePrimaryConnection = null;
    }
  }

  private void closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked()
  {
    int i = this.mAvailableNonPrimaryConnections.size();
    for (int j = 0; j < i; j++)
      closeConnectionAndLogExceptionsLocked((SQLiteConnection)this.mAvailableNonPrimaryConnections.get(j));
    this.mAvailableNonPrimaryConnections.clear();
  }

  private void closeConnectionAndLogExceptionsLocked(SQLiteConnection paramSQLiteConnection)
  {
    try
    {
      paramSQLiteConnection.close();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
    }
  }

  private void closeExcessConnectionsAndLogExceptionsLocked()
  {
    int j;
    for (int i = this.mAvailableNonPrimaryConnections.size(); ; i = j)
    {
      j = i - 1;
      if (i <= -1 + this.mMaxConnectionPoolSize)
        break;
      closeConnectionAndLogExceptionsLocked((SQLiteConnection)this.mAvailableNonPrimaryConnections.remove(j));
    }
  }

  private void discardAcquiredConnectionsLocked()
  {
    markAcquiredConnectionsLocked(AcquiredConnectionStatus.DISCARD);
  }

  private void dispose(boolean paramBoolean)
  {
    if (this.mCloseGuard != null)
    {
      if (paramBoolean)
        this.mCloseGuard.warnIfOpen();
      this.mCloseGuard.close();
    }
    if (!paramBoolean)
      synchronized (this.mLock)
      {
        throwIfClosedLocked();
        this.mIsOpen = false;
        closeAvailableConnectionsAndLogExceptionsLocked();
        if (this.mAcquiredConnections.size() != 0);
        wakeConnectionWaitersLocked();
        return;
      }
  }

  private void finishAcquireConnectionLocked(SQLiteConnection paramSQLiteConnection, int paramInt)
  {
    boolean bool;
    if ((paramInt & 0x1) != 0)
      bool = true;
    try
    {
      while (true)
      {
        paramSQLiteConnection.setOnlyAllowReadOnlyOperations(bool);
        this.mAcquiredConnections.put(paramSQLiteConnection, AcquiredConnectionStatus.NORMAL);
        return;
        bool = false;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      closeConnectionAndLogExceptionsLocked(paramSQLiteConnection);
      throw localRuntimeException;
    }
  }

  private static int getPriority(int paramInt)
  {
    if ((paramInt & 0x4) != 0)
      return 1;
    return 0;
  }

  private boolean isSessionBlockingImportantConnectionWaitersLocked(boolean paramBoolean, int paramInt)
  {
    ConnectionWaiter localConnectionWaiter = this.mConnectionWaiterQueue;
    if (localConnectionWaiter != null)
    {
      int i = getPriority(paramInt);
      if (i <= localConnectionWaiter.mPriority)
        break label26;
    }
    while (true)
    {
      return false;
      label26: if ((paramBoolean) || (!localConnectionWaiter.mWantPrimaryConnection))
        return true;
      localConnectionWaiter = localConnectionWaiter.mNext;
      if (localConnectionWaiter != null)
        break;
    }
  }

  private void logConnectionPoolBusyLocked(long paramLong, int paramInt)
  {
  }

  private void markAcquiredConnectionsLocked(AcquiredConnectionStatus paramAcquiredConnectionStatus)
  {
    if (!this.mAcquiredConnections.isEmpty())
    {
      ArrayList localArrayList = new ArrayList(this.mAcquiredConnections.size());
      Iterator localIterator = this.mAcquiredConnections.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        AcquiredConnectionStatus localAcquiredConnectionStatus = (AcquiredConnectionStatus)localEntry.getValue();
        if ((paramAcquiredConnectionStatus != localAcquiredConnectionStatus) && (localAcquiredConnectionStatus != AcquiredConnectionStatus.DISCARD))
          localArrayList.add(localEntry.getKey());
      }
      int i = localArrayList.size();
      for (int j = 0; j < i; j++)
        this.mAcquiredConnections.put(localArrayList.get(j), paramAcquiredConnectionStatus);
    }
  }

  private ConnectionWaiter obtainConnectionWaiterLocked(Thread paramThread, long paramLong, int paramInt1, boolean paramBoolean, String paramString, int paramInt2)
  {
    ConnectionWaiter localConnectionWaiter = this.mConnectionWaiterPool;
    if (localConnectionWaiter != null)
    {
      this.mConnectionWaiterPool = localConnectionWaiter.mNext;
      localConnectionWaiter.mNext = null;
    }
    while (true)
    {
      localConnectionWaiter.mThread = paramThread;
      localConnectionWaiter.mStartTime = paramLong;
      localConnectionWaiter.mPriority = paramInt1;
      localConnectionWaiter.mWantPrimaryConnection = paramBoolean;
      localConnectionWaiter.mSql = paramString;
      localConnectionWaiter.mConnectionFlags = paramInt2;
      return localConnectionWaiter;
      localConnectionWaiter = new ConnectionWaiter(null);
    }
  }

  public static SQLiteConnectionPool open(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration)
  {
    if (paramSQLiteDatabaseConfiguration == null)
      throw new IllegalArgumentException("configuration must not be null.");
    SQLiteConnectionPool localSQLiteConnectionPool = new SQLiteConnectionPool(paramSQLiteDatabaseConfiguration);
    localSQLiteConnectionPool.open();
    return localSQLiteConnectionPool;
  }

  private void open()
  {
    this.mAvailablePrimaryConnection = openConnectionLocked(this.mConfiguration, true);
    this.mIsOpen = true;
    this.mCloseGuard.open("close");
  }

  private SQLiteConnection openConnectionLocked(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration, boolean paramBoolean)
  {
    int i = this.mNextConnectionId;
    this.mNextConnectionId = (i + 1);
    return SQLiteConnection.open(this, paramSQLiteDatabaseConfiguration, i, paramBoolean);
  }

  private void reconfigureAllConnectionsLocked()
  {
    if (this.mAvailablePrimaryConnection != null);
    try
    {
      this.mAvailablePrimaryConnection.reconfigure(this.mConfiguration);
      i = this.mAvailableNonPrimaryConnections.size();
      j = 0;
      if (j < i)
        localSQLiteConnection = (SQLiteConnection)this.mAvailableNonPrimaryConnections.get(j);
    }
    catch (RuntimeException localRuntimeException2)
    {
      try
      {
        while (true)
        {
          localSQLiteConnection.reconfigure(this.mConfiguration);
          k = j;
          m = i;
          int n = k + 1;
          i = m;
          j = n;
        }
        localRuntimeException2 = localRuntimeException2;
        closeConnectionAndLogExceptionsLocked(this.mAvailablePrimaryConnection);
        this.mAvailablePrimaryConnection = null;
      }
      catch (RuntimeException localRuntimeException1)
      {
        while (true)
        {
          int i;
          int j;
          SQLiteConnection localSQLiteConnection;
          closeConnectionAndLogExceptionsLocked(localSQLiteConnection);
          ArrayList localArrayList = this.mAvailableNonPrimaryConnections;
          int k = j - 1;
          localArrayList.remove(j);
          int m = i - 1;
        }
      }
      markAcquiredConnectionsLocked(AcquiredConnectionStatus.RECONFIGURE);
    }
  }

  private boolean recycleConnectionLocked(SQLiteConnection paramSQLiteConnection, AcquiredConnectionStatus paramAcquiredConnectionStatus)
  {
    if (paramAcquiredConnectionStatus == AcquiredConnectionStatus.RECONFIGURE);
    try
    {
      paramSQLiteConnection.reconfigure(this.mConfiguration);
      if (paramAcquiredConnectionStatus == AcquiredConnectionStatus.DISCARD)
      {
        closeConnectionAndLogExceptionsLocked(paramSQLiteConnection);
        return false;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      while (true)
        paramAcquiredConnectionStatus = AcquiredConnectionStatus.DISCARD;
    }
    return true;
  }

  private void recycleConnectionWaiterLocked(ConnectionWaiter paramConnectionWaiter)
  {
    paramConnectionWaiter.mNext = this.mConnectionWaiterPool;
    paramConnectionWaiter.mThread = null;
    paramConnectionWaiter.mSql = null;
    paramConnectionWaiter.mAssignedConnection = null;
    paramConnectionWaiter.mException = null;
    paramConnectionWaiter.mNonce = (1 + paramConnectionWaiter.mNonce);
    this.mConnectionWaiterPool = paramConnectionWaiter;
  }

  private void setMaxConnectionPoolSizeLocked()
  {
    if ((!SQLiteDatabase.hasCodec()) && ((0x20000000 & this.mConfiguration.openFlags) != 0))
    {
      this.mMaxConnectionPoolSize = SQLiteGlobal.getWALConnectionPoolSize();
      return;
    }
    this.mMaxConnectionPoolSize = 1;
  }

  private void throwIfClosedLocked()
  {
    if (!this.mIsOpen)
      throw new IllegalStateException("Cannot perform this operation because the connection pool has been closed.");
  }

  private SQLiteConnection tryAcquireNonPrimaryConnectionLocked(String paramString, int paramInt)
  {
    int i = this.mAvailableNonPrimaryConnections.size();
    if ((i > 1) && (paramString != null))
      for (int k = 0; k < i; k++)
      {
        SQLiteConnection localSQLiteConnection3 = (SQLiteConnection)this.mAvailableNonPrimaryConnections.get(k);
        if (localSQLiteConnection3.isPreparedStatementInCache(paramString))
        {
          this.mAvailableNonPrimaryConnections.remove(k);
          finishAcquireConnectionLocked(localSQLiteConnection3, paramInt);
          return localSQLiteConnection3;
        }
      }
    if (i > 0)
    {
      SQLiteConnection localSQLiteConnection2 = (SQLiteConnection)this.mAvailableNonPrimaryConnections.remove(i - 1);
      finishAcquireConnectionLocked(localSQLiteConnection2, paramInt);
      return localSQLiteConnection2;
    }
    int j = this.mAcquiredConnections.size();
    if (this.mAvailablePrimaryConnection != null)
      j++;
    if (j >= this.mMaxConnectionPoolSize)
      return null;
    SQLiteConnection localSQLiteConnection1 = openConnectionLocked(this.mConfiguration, false);
    finishAcquireConnectionLocked(localSQLiteConnection1, paramInt);
    return localSQLiteConnection1;
  }

  private SQLiteConnection tryAcquirePrimaryConnectionLocked(int paramInt)
  {
    SQLiteConnection localSQLiteConnection1 = this.mAvailablePrimaryConnection;
    if (localSQLiteConnection1 != null)
    {
      this.mAvailablePrimaryConnection = null;
      finishAcquireConnectionLocked(localSQLiteConnection1, paramInt);
      return localSQLiteConnection1;
    }
    Iterator localIterator = this.mAcquiredConnections.keySet().iterator();
    while (localIterator.hasNext())
      if (((SQLiteConnection)localIterator.next()).isPrimaryConnection())
        return null;
    SQLiteConnection localSQLiteConnection2 = openConnectionLocked(this.mConfiguration, true);
    finishAcquireConnectionLocked(localSQLiteConnection2, paramInt);
    return localSQLiteConnection2;
  }

  // ERROR //
  private SQLiteConnection waitForConnection(String paramString, int paramInt, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: iload_2
    //   1: iconst_2
    //   2: iand
    //   3: ifeq +445 -> 448
    //   6: iconst_1
    //   7: istore 4
    //   9: aload_0
    //   10: getfield 70	org/sqlite/database/sqlite/SQLiteConnectionPool:mLock	Ljava/lang/Object;
    //   13: astore 5
    //   15: aload 5
    //   17: monitorenter
    //   18: aload_0
    //   19: invokespecial 188	org/sqlite/database/sqlite/SQLiteConnectionPool:throwIfClosedLocked	()V
    //   22: aload_3
    //   23: ifnull +7 -> 30
    //   26: aload_3
    //   27: invokevirtual 351	org/sqlite/os/CancellationSignal:throwIfCanceled	()V
    //   30: aconst_null
    //   31: astore 7
    //   33: iload 4
    //   35: ifne +11 -> 46
    //   38: aload_0
    //   39: aload_1
    //   40: iload_2
    //   41: invokespecial 353	org/sqlite/database/sqlite/SQLiteConnectionPool:tryAcquireNonPrimaryConnectionLocked	(Ljava/lang/String;I)Lorg/sqlite/database/sqlite/SQLiteConnection;
    //   44: astore 7
    //   46: aload 7
    //   48: ifnonnull +10 -> 58
    //   51: aload_0
    //   52: iload_2
    //   53: invokespecial 355	org/sqlite/database/sqlite/SQLiteConnectionPool:tryAcquirePrimaryConnectionLocked	(I)Lorg/sqlite/database/sqlite/SQLiteConnection;
    //   56: astore 7
    //   58: aload 7
    //   60: ifnull +9 -> 69
    //   63: aload 5
    //   65: monitorexit
    //   66: aload 7
    //   68: areturn
    //   69: iload_2
    //   70: invokestatic 211	org/sqlite/database/sqlite/SQLiteConnectionPool:getPriority	(I)I
    //   73: istore 8
    //   75: invokestatic 361	android/os/SystemClock:uptimeMillis	()J
    //   78: lstore 9
    //   80: aload_0
    //   81: invokestatic 367	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   84: lload 9
    //   86: iload 8
    //   88: iload 4
    //   90: aload_1
    //   91: iload_2
    //   92: invokespecial 369	org/sqlite/database/sqlite/SQLiteConnectionPool:obtainConnectionWaiterLocked	(Ljava/lang/Thread;JIZLjava/lang/String;I)Lorg/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter;
    //   95: astore 11
    //   97: aconst_null
    //   98: astore 12
    //   100: aload_0
    //   101: getfield 113	org/sqlite/database/sqlite/SQLiteConnectionPool:mConnectionWaiterQueue	Lorg/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter;
    //   104: astore 13
    //   106: aload 13
    //   108: ifnull +20 -> 128
    //   111: iload 8
    //   113: aload 13
    //   115: getfield 214	org/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter:mPriority	I
    //   118: if_icmple +181 -> 299
    //   121: aload 11
    //   123: aload 13
    //   125: putfield 119	org/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter:mNext	Lorg/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter;
    //   128: aload 12
    //   130: ifnull +187 -> 317
    //   133: aload 12
    //   135: aload 11
    //   137: putfield 119	org/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter:mNext	Lorg/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter;
    //   140: aload 11
    //   142: getfield 309	org/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter:mNonce	I
    //   145: istore 15
    //   147: aload 5
    //   149: monitorexit
    //   150: aload_3
    //   151: ifnull +19 -> 170
    //   154: aload_3
    //   155: new 371	org/sqlite/database/sqlite/SQLiteConnectionPool$1
    //   158: dup
    //   159: aload_0
    //   160: aload 11
    //   162: iload 15
    //   164: invokespecial 374	org/sqlite/database/sqlite/SQLiteConnectionPool$1:<init>	(Lorg/sqlite/database/sqlite/SQLiteConnectionPool;Lorg/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter;I)V
    //   167: invokevirtual 378	org/sqlite/os/CancellationSignal:setOnCancelListener	(Lorg/sqlite/os/CancellationSignal$OnCancelListener;)V
    //   170: ldc2_w 19
    //   173: aload 11
    //   175: getfield 263	org/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter:mStartTime	J
    //   178: ladd
    //   179: lstore 17
    //   181: ldc2_w 19
    //   184: lstore 19
    //   186: lload 17
    //   188: lstore 21
    //   190: aload_0
    //   191: getfield 75	org/sqlite/database/sqlite/SQLiteConnectionPool:mConnectionLeaked	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   194: iconst_1
    //   195: iconst_0
    //   196: invokevirtual 382	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   199: ifeq +19 -> 218
    //   202: aload_0
    //   203: getfield 70	org/sqlite/database/sqlite/SQLiteConnectionPool:mLock	Ljava/lang/Object;
    //   206: astore 42
    //   208: aload 42
    //   210: monitorenter
    //   211: aload_0
    //   212: invokespecial 135	org/sqlite/database/sqlite/SQLiteConnectionPool:wakeConnectionWaitersLocked	()V
    //   215: aload 42
    //   217: monitorexit
    //   218: lload 19
    //   220: ldc2_w 383
    //   223: lmul
    //   224: lstore 23
    //   226: aload_0
    //   227: lload 23
    //   229: invokestatic 388	java/util/concurrent/locks/LockSupport:parkNanos	(Ljava/lang/Object;J)V
    //   232: invokestatic 391	java/lang/Thread:interrupted	()Z
    //   235: pop
    //   236: aload_0
    //   237: getfield 70	org/sqlite/database/sqlite/SQLiteConnectionPool:mLock	Ljava/lang/Object;
    //   240: astore 26
    //   242: aload 26
    //   244: monitorenter
    //   245: aload_0
    //   246: invokespecial 188	org/sqlite/database/sqlite/SQLiteConnectionPool:throwIfClosedLocked	()V
    //   249: aload 11
    //   251: getfield 107	org/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter:mAssignedConnection	Lorg/sqlite/database/sqlite/SQLiteConnection;
    //   254: astore 28
    //   256: aload 11
    //   258: getfield 111	org/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter:mException	Ljava/lang/RuntimeException;
    //   261: astore 29
    //   263: aload 28
    //   265: ifnonnull +8 -> 273
    //   268: aload 29
    //   270: ifnull +97 -> 367
    //   273: aload_0
    //   274: aload 11
    //   276: invokespecial 393	org/sqlite/database/sqlite/SQLiteConnectionPool:recycleConnectionWaiterLocked	(Lorg/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter;)V
    //   279: aload 28
    //   281: ifnull +75 -> 356
    //   284: aload 26
    //   286: monitorexit
    //   287: aload_3
    //   288: ifnull +157 -> 445
    //   291: aload_3
    //   292: aconst_null
    //   293: invokevirtual 378	org/sqlite/os/CancellationSignal:setOnCancelListener	(Lorg/sqlite/os/CancellationSignal$OnCancelListener;)V
    //   296: aload 28
    //   298: areturn
    //   299: aload 13
    //   301: getfield 119	org/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter:mNext	Lorg/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter;
    //   304: astore 14
    //   306: aload 13
    //   308: astore 12
    //   310: aload 14
    //   312: astore 13
    //   314: goto -208 -> 106
    //   317: aload_0
    //   318: aload 11
    //   320: putfield 113	org/sqlite/database/sqlite/SQLiteConnectionPool:mConnectionWaiterQueue	Lorg/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter;
    //   323: goto -183 -> 140
    //   326: astore 6
    //   328: aload 5
    //   330: monitorexit
    //   331: aload 6
    //   333: athrow
    //   334: astore 43
    //   336: aload 42
    //   338: monitorexit
    //   339: aload 43
    //   341: athrow
    //   342: astore 16
    //   344: aload_3
    //   345: ifnull +8 -> 353
    //   348: aload_3
    //   349: aconst_null
    //   350: invokevirtual 378	org/sqlite/os/CancellationSignal:setOnCancelListener	(Lorg/sqlite/os/CancellationSignal$OnCancelListener;)V
    //   353: aload 16
    //   355: athrow
    //   356: aload 29
    //   358: athrow
    //   359: astore 27
    //   361: aload 26
    //   363: monitorexit
    //   364: aload 27
    //   366: athrow
    //   367: invokestatic 361	android/os/SystemClock:uptimeMillis	()J
    //   370: lstore 30
    //   372: lload 30
    //   374: lload 21
    //   376: lcmp
    //   377: ifge +40 -> 417
    //   380: lload 30
    //   382: lload 21
    //   384: lsub
    //   385: lstore 38
    //   387: lload 21
    //   389: lstore 40
    //   391: lload 38
    //   393: lstore 32
    //   395: lload 40
    //   397: lstore 34
    //   399: aload 26
    //   401: monitorexit
    //   402: lload 34
    //   404: lstore 36
    //   406: lload 32
    //   408: lstore 19
    //   410: lload 36
    //   412: lstore 21
    //   414: goto -224 -> 190
    //   417: aload_0
    //   418: lload 30
    //   420: aload 11
    //   422: getfield 263	org/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter:mStartTime	J
    //   425: lsub
    //   426: iload_2
    //   427: invokespecial 395	org/sqlite/database/sqlite/SQLiteConnectionPool:logConnectionPoolBusyLocked	(JI)V
    //   430: ldc2_w 19
    //   433: lstore 32
    //   435: lload 30
    //   437: lload 32
    //   439: ladd
    //   440: lstore 34
    //   442: goto -43 -> 399
    //   445: aload 28
    //   447: areturn
    //   448: iconst_0
    //   449: istore 4
    //   451: goto -442 -> 9
    //
    // Exception table:
    //   from	to	target	type
    //   18	22	326	finally
    //   26	30	326	finally
    //   38	46	326	finally
    //   51	58	326	finally
    //   63	66	326	finally
    //   69	97	326	finally
    //   100	106	326	finally
    //   111	128	326	finally
    //   133	140	326	finally
    //   140	150	326	finally
    //   299	306	326	finally
    //   317	323	326	finally
    //   328	331	326	finally
    //   211	218	334	finally
    //   336	339	334	finally
    //   170	181	342	finally
    //   190	211	342	finally
    //   226	245	342	finally
    //   339	342	342	finally
    //   364	367	342	finally
    //   245	263	359	finally
    //   273	279	359	finally
    //   284	287	359	finally
    //   356	359	359	finally
    //   361	364	359	finally
    //   367	372	359	finally
    //   399	402	359	finally
    //   417	430	359	finally
  }

  // ERROR //
  private void wakeConnectionWaitersLocked()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 113	org/sqlite/database/sqlite/SQLiteConnectionPool:mConnectionWaiterQueue	Lorg/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter;
    //   4: astore_1
    //   5: iconst_0
    //   6: istore_2
    //   7: iconst_0
    //   8: istore_3
    //   9: aconst_null
    //   10: astore 4
    //   12: aload_1
    //   13: ifnull +149 -> 162
    //   16: aload_0
    //   17: getfield 190	org/sqlite/database/sqlite/SQLiteConnectionPool:mIsOpen	Z
    //   20: ifne +53 -> 73
    //   23: iload_2
    //   24: istore 8
    //   26: iconst_1
    //   27: istore 9
    //   29: aload_1
    //   30: getfield 119	org/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter:mNext	Lorg/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter;
    //   33: astore 10
    //   35: iload 9
    //   37: ifeq +162 -> 199
    //   40: aload 4
    //   42: ifnull +148 -> 190
    //   45: aload 4
    //   47: aload 10
    //   49: putfield 119	org/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter:mNext	Lorg/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter;
    //   52: aload_1
    //   53: aconst_null
    //   54: putfield 119	org/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter:mNext	Lorg/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter;
    //   57: aload_1
    //   58: getfield 126	org/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter:mThread	Ljava/lang/Thread;
    //   61: invokestatic 132	java/util/concurrent/locks/LockSupport:unpark	(Ljava/lang/Thread;)V
    //   64: iload 8
    //   66: istore_2
    //   67: aload 10
    //   69: astore_1
    //   70: goto -58 -> 12
    //   73: aload_1
    //   74: getfield 217	org/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter:mWantPrimaryConnection	Z
    //   77: ifne +159 -> 236
    //   80: iload_2
    //   81: ifne +155 -> 236
    //   84: aload_0
    //   85: aload_1
    //   86: getfield 266	org/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter:mSql	Ljava/lang/String;
    //   89: aload_1
    //   90: getfield 269	org/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter:mConnectionFlags	I
    //   93: invokespecial 353	org/sqlite/database/sqlite/SQLiteConnectionPool:tryAcquireNonPrimaryConnectionLocked	(Ljava/lang/String;I)Lorg/sqlite/database/sqlite/SQLiteConnection;
    //   96: astore 11
    //   98: aload 11
    //   100: ifnonnull +126 -> 226
    //   103: aload 11
    //   105: astore 12
    //   107: iconst_1
    //   108: istore 8
    //   110: aload 12
    //   112: ifnonnull +24 -> 136
    //   115: iload_3
    //   116: ifne +20 -> 136
    //   119: aload_0
    //   120: aload_1
    //   121: getfield 269	org/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter:mConnectionFlags	I
    //   124: invokespecial 355	org/sqlite/database/sqlite/SQLiteConnectionPool:tryAcquirePrimaryConnectionLocked	(I)Lorg/sqlite/database/sqlite/SQLiteConnection;
    //   127: astore 12
    //   129: aload 12
    //   131: ifnonnull +5 -> 136
    //   134: iconst_1
    //   135: istore_3
    //   136: aload 12
    //   138: ifnull +15 -> 153
    //   141: aload_1
    //   142: aload 12
    //   144: putfield 107	org/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter:mAssignedConnection	Lorg/sqlite/database/sqlite/SQLiteConnection;
    //   147: iconst_1
    //   148: istore 9
    //   150: goto -121 -> 29
    //   153: iload 8
    //   155: ifeq +65 -> 220
    //   158: iload_3
    //   159: ifeq +61 -> 220
    //   162: return
    //   163: astore 5
    //   165: iload_3
    //   166: istore 6
    //   168: aload 5
    //   170: astore 7
    //   172: aload_1
    //   173: aload 7
    //   175: putfield 111	org/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter:mException	Ljava/lang/RuntimeException;
    //   178: iload 6
    //   180: istore_3
    //   181: iload_2
    //   182: istore 8
    //   184: iconst_1
    //   185: istore 9
    //   187: goto -158 -> 29
    //   190: aload_0
    //   191: aload 10
    //   193: putfield 113	org/sqlite/database/sqlite/SQLiteConnectionPool:mConnectionWaiterQueue	Lorg/sqlite/database/sqlite/SQLiteConnectionPool$ConnectionWaiter;
    //   196: goto -144 -> 52
    //   199: aload_1
    //   200: astore 4
    //   202: goto -138 -> 64
    //   205: astore 13
    //   207: iload 8
    //   209: istore_2
    //   210: iload_3
    //   211: istore 6
    //   213: aload 13
    //   215: astore 7
    //   217: goto -45 -> 172
    //   220: iconst_0
    //   221: istore 9
    //   223: goto -194 -> 29
    //   226: iload_2
    //   227: istore 8
    //   229: aload 11
    //   231: astore 12
    //   233: goto -123 -> 110
    //   236: iload_2
    //   237: istore 8
    //   239: aconst_null
    //   240: astore 12
    //   242: goto -132 -> 110
    //
    // Exception table:
    //   from	to	target	type
    //   73	80	163	java/lang/RuntimeException
    //   84	98	163	java/lang/RuntimeException
    //   119	129	205	java/lang/RuntimeException
    //   141	147	205	java/lang/RuntimeException
  }

  public SQLiteConnection acquireConnection(String paramString, int paramInt, CancellationSignal paramCancellationSignal)
  {
    return waitForConnection(paramString, paramInt, paramCancellationSignal);
  }

  public void close()
  {
    dispose(false);
  }

  public void collectDbStats(ArrayList<SQLiteDebug.DbStats> paramArrayList)
  {
    synchronized (this.mLock)
    {
      if (this.mAvailablePrimaryConnection != null)
        this.mAvailablePrimaryConnection.collectDbStats(paramArrayList);
      Iterator localIterator1 = this.mAvailableNonPrimaryConnections.iterator();
      if (localIterator1.hasNext())
        ((SQLiteConnection)localIterator1.next()).collectDbStats(paramArrayList);
    }
    Iterator localIterator2 = this.mAcquiredConnections.keySet().iterator();
    while (localIterator2.hasNext())
      ((SQLiteConnection)localIterator2.next()).collectDbStatsUnsafe(paramArrayList);
  }

  public void dump(Printer paramPrinter, boolean paramBoolean)
  {
  }

  // ERROR //
  public void enableLocalizedCollators()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 70	org/sqlite/database/sqlite/SQLiteConnectionPool:mLock	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 85	org/sqlite/database/sqlite/SQLiteConnectionPool:mAcquiredConnections	Ljava/util/WeakHashMap;
    //   11: invokevirtual 222	java/util/WeakHashMap:isEmpty	()Z
    //   14: ifeq +10 -> 24
    //   17: aload_0
    //   18: getfield 141	org/sqlite/database/sqlite/SQLiteConnectionPool:mAvailablePrimaryConnection	Lorg/sqlite/database/sqlite/SQLiteConnection;
    //   21: ifnonnull +19 -> 40
    //   24: new 325	java/lang/IllegalStateException
    //   27: dup
    //   28: ldc_w 413
    //   31: invokespecial 328	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   34: athrow
    //   35: astore_2
    //   36: aload_1
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    //   40: aload_0
    //   41: getfield 141	org/sqlite/database/sqlite/SQLiteConnectionPool:mAvailablePrimaryConnection	Lorg/sqlite/database/sqlite/SQLiteConnection;
    //   44: invokevirtual 415	org/sqlite/database/sqlite/SQLiteConnection:enableLocalizedCollators	()V
    //   47: aload_1
    //   48: monitorexit
    //   49: return
    //
    // Exception table:
    //   from	to	target	type
    //   7	24	35	finally
    //   24	35	35	finally
    //   36	38	35	finally
    //   40	49	35	finally
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

  void onConnectionLeaked()
  {
    this.mConnectionLeaked.set(true);
  }

  public void reconfigure(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration)
  {
    int i = 1;
    if (paramSQLiteDatabaseConfiguration == null)
      throw new IllegalArgumentException("configuration must not be null.");
    int j;
    while (true)
    {
      synchronized (this.mLock)
      {
        throwIfClosedLocked();
        if ((0x20000000 & (paramSQLiteDatabaseConfiguration.openFlags ^ this.mConfiguration.openFlags)) != 0)
        {
          j = i;
          if (j == 0)
            break label117;
          if (this.mAcquiredConnections.isEmpty())
            break;
          throw new IllegalStateException("Write Ahead Logging (WAL) mode cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");
        }
      }
      j = 0;
    }
    closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked();
    assert (this.mAvailableNonPrimaryConnections.isEmpty());
    label117: if (paramSQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled != this.mConfiguration.foreignKeyConstraintsEnabled);
    while (true)
    {
      if ((i != 0) && (!this.mAcquiredConnections.isEmpty()))
        throw new IllegalStateException("Foreign Key Constraints cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");
      if (this.mConfiguration.openFlags != paramSQLiteDatabaseConfiguration.openFlags)
      {
        if (j != 0)
          closeAvailableConnectionsAndLogExceptionsLocked();
        SQLiteConnection localSQLiteConnection = openConnectionLocked(paramSQLiteDatabaseConfiguration, true);
        closeAvailableConnectionsAndLogExceptionsLocked();
        discardAcquiredConnectionsLocked();
        this.mAvailablePrimaryConnection = localSQLiteConnection;
        this.mConfiguration.updateParametersFrom(paramSQLiteDatabaseConfiguration);
        setMaxConnectionPoolSizeLocked();
      }
      while (true)
      {
        wakeConnectionWaitersLocked();
        return;
        this.mConfiguration.updateParametersFrom(paramSQLiteDatabaseConfiguration);
        setMaxConnectionPoolSizeLocked();
        closeExcessConnectionsAndLogExceptionsLocked();
        reconfigureAllConnectionsLocked();
      }
      i = 0;
    }
  }

  public void releaseConnection(SQLiteConnection paramSQLiteConnection)
  {
    AcquiredConnectionStatus localAcquiredConnectionStatus;
    synchronized (this.mLock)
    {
      localAcquiredConnectionStatus = (AcquiredConnectionStatus)this.mAcquiredConnections.remove(paramSQLiteConnection);
      if (localAcquiredConnectionStatus == null)
        throw new IllegalStateException("Cannot perform this operation because the specified connection was not acquired from this pool or has already been released.");
    }
    if (!this.mIsOpen)
      closeConnectionAndLogExceptionsLocked(paramSQLiteConnection);
    while (true)
    {
      return;
      if (paramSQLiteConnection.isPrimaryConnection())
      {
        if (recycleConnectionLocked(paramSQLiteConnection, localAcquiredConnectionStatus))
        {
          assert (this.mAvailablePrimaryConnection == null);
          this.mAvailablePrimaryConnection = paramSQLiteConnection;
        }
        wakeConnectionWaitersLocked();
      }
      else if (this.mAvailableNonPrimaryConnections.size() >= -1 + this.mMaxConnectionPoolSize)
      {
        closeConnectionAndLogExceptionsLocked(paramSQLiteConnection);
      }
      else
      {
        if (recycleConnectionLocked(paramSQLiteConnection, localAcquiredConnectionStatus))
          this.mAvailableNonPrimaryConnections.add(paramSQLiteConnection);
        wakeConnectionWaitersLocked();
      }
    }
  }

  public boolean shouldYieldConnection(SQLiteConnection paramSQLiteConnection, int paramInt)
  {
    synchronized (this.mLock)
    {
      if (!this.mAcquiredConnections.containsKey(paramSQLiteConnection))
        throw new IllegalStateException("Cannot perform this operation because the specified connection was not acquired from this pool or has already been released.");
    }
    if (!this.mIsOpen)
      return false;
    boolean bool = isSessionBlockingImportantConnectionWaitersLocked(paramSQLiteConnection.isPrimaryConnection(), paramInt);
    return bool;
  }

  public String toString()
  {
    return "SQLiteConnectionPool: " + this.mConfiguration.path;
  }

  static enum AcquiredConnectionStatus
  {
    static
    {
      DISCARD = new AcquiredConnectionStatus("DISCARD", 2);
      AcquiredConnectionStatus[] arrayOfAcquiredConnectionStatus = new AcquiredConnectionStatus[3];
      arrayOfAcquiredConnectionStatus[0] = NORMAL;
      arrayOfAcquiredConnectionStatus[1] = RECONFIGURE;
      arrayOfAcquiredConnectionStatus[2] = DISCARD;
    }
  }

  private static final class ConnectionWaiter
  {
    public SQLiteConnection mAssignedConnection;
    public int mConnectionFlags;
    public RuntimeException mException;
    public ConnectionWaiter mNext;
    public int mNonce;
    public int mPriority;
    public String mSql;
    public long mStartTime;
    public Thread mThread;
    public boolean mWantPrimaryConnection;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.sqlite.database.sqlite.SQLiteConnectionPool
 * JD-Core Version:    0.6.2
 */