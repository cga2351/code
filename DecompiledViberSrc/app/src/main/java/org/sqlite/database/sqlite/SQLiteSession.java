package org.sqlite.database.sqlite;

import android.os.ParcelFileDescriptor;
import org.sqlite.database.DatabaseUtils;
import org.sqlite.os.CancellationSignal;

public final class SQLiteSession
{
  public static final int TRANSACTION_MODE_DEFERRED = 0;
  public static final int TRANSACTION_MODE_EXCLUSIVE = 2;
  public static final int TRANSACTION_MODE_IMMEDIATE = 1;
  private SQLiteConnection mConnection;
  private int mConnectionFlags;
  private final SQLiteConnectionPool mConnectionPool;
  private int mConnectionUseCount;
  private Transaction mTransactionPool;
  private Transaction mTransactionStack;

  static
  {
    if (!SQLiteSession.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }

  public SQLiteSession(SQLiteConnectionPool paramSQLiteConnectionPool)
  {
    if (paramSQLiteConnectionPool == null)
      throw new IllegalArgumentException("connectionPool must not be null");
    this.mConnectionPool = paramSQLiteConnectionPool;
  }

  private void acquireConnection(String paramString, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (this.mConnection == null)
    {
      assert (this.mConnectionUseCount == 0);
      this.mConnection = this.mConnectionPool.acquireConnection(paramString, paramInt, paramCancellationSignal);
      this.mConnectionFlags = paramInt;
    }
    this.mConnectionUseCount = (1 + this.mConnectionUseCount);
  }

  // ERROR //
  private void beginTransactionUnchecked(int paramInt1, SQLiteTransactionListener paramSQLiteTransactionListener, int paramInt2, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload 4
    //   2: ifnull +8 -> 10
    //   5: aload 4
    //   7: invokevirtual 70	org/sqlite/os/CancellationSignal:throwIfCanceled	()V
    //   10: aload_0
    //   11: getfield 72	org/sqlite/database/sqlite/SQLiteSession:mTransactionStack	Lorg/sqlite/database/sqlite/SQLiteSession$Transaction;
    //   14: ifnonnull +11 -> 25
    //   17: aload_0
    //   18: aconst_null
    //   19: iload_3
    //   20: aload 4
    //   22: invokespecial 74	org/sqlite/database/sqlite/SQLiteSession:acquireConnection	(Ljava/lang/String;ILorg/sqlite/os/CancellationSignal;)V
    //   25: aload_0
    //   26: getfield 72	org/sqlite/database/sqlite/SQLiteSession:mTransactionStack	Lorg/sqlite/database/sqlite/SQLiteSession$Transaction;
    //   29: ifnonnull +39 -> 68
    //   32: iload_1
    //   33: tableswitch	default:+23 -> 56, 1:+80->113, 2:+111->144
    //   57: getfield 49	org/sqlite/database/sqlite/SQLiteSession:mConnection	Lorg/sqlite/database/sqlite/SQLiteConnection;
    //   60: ldc 76
    //   62: aconst_null
    //   63: aload 4
    //   65: invokevirtual 82	org/sqlite/database/sqlite/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lorg/sqlite/os/CancellationSignal;)V
    //   68: aload_2
    //   69: ifnull +9 -> 78
    //   72: aload_2
    //   73: invokeinterface 87 1 0
    //   78: aload_0
    //   79: iload_1
    //   80: aload_2
    //   81: invokespecial 91	org/sqlite/database/sqlite/SQLiteSession:obtainTransaction	(ILorg/sqlite/database/sqlite/SQLiteTransactionListener;)Lorg/sqlite/database/sqlite/SQLiteSession$Transaction;
    //   84: astore 6
    //   86: aload 6
    //   88: aload_0
    //   89: getfield 72	org/sqlite/database/sqlite/SQLiteSession:mTransactionStack	Lorg/sqlite/database/sqlite/SQLiteSession$Transaction;
    //   92: putfield 96	org/sqlite/database/sqlite/SQLiteSession$Transaction:mParent	Lorg/sqlite/database/sqlite/SQLiteSession$Transaction;
    //   95: aload_0
    //   96: aload 6
    //   98: putfield 72	org/sqlite/database/sqlite/SQLiteSession:mTransactionStack	Lorg/sqlite/database/sqlite/SQLiteSession$Transaction;
    //   101: aload_0
    //   102: getfield 72	org/sqlite/database/sqlite/SQLiteSession:mTransactionStack	Lorg/sqlite/database/sqlite/SQLiteSession$Transaction;
    //   105: ifnonnull +7 -> 112
    //   108: aload_0
    //   109: invokespecial 99	org/sqlite/database/sqlite/SQLiteSession:releaseConnection	()V
    //   112: return
    //   113: aload_0
    //   114: getfield 49	org/sqlite/database/sqlite/SQLiteSession:mConnection	Lorg/sqlite/database/sqlite/SQLiteConnection;
    //   117: ldc 101
    //   119: aconst_null
    //   120: aload 4
    //   122: invokevirtual 82	org/sqlite/database/sqlite/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lorg/sqlite/os/CancellationSignal;)V
    //   125: goto -57 -> 68
    //   128: astore 5
    //   130: aload_0
    //   131: getfield 72	org/sqlite/database/sqlite/SQLiteSession:mTransactionStack	Lorg/sqlite/database/sqlite/SQLiteSession$Transaction;
    //   134: ifnonnull +7 -> 141
    //   137: aload_0
    //   138: invokespecial 99	org/sqlite/database/sqlite/SQLiteSession:releaseConnection	()V
    //   141: aload 5
    //   143: athrow
    //   144: aload_0
    //   145: getfield 49	org/sqlite/database/sqlite/SQLiteSession:mConnection	Lorg/sqlite/database/sqlite/SQLiteConnection;
    //   148: ldc 103
    //   150: aconst_null
    //   151: aload 4
    //   153: invokevirtual 82	org/sqlite/database/sqlite/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lorg/sqlite/os/CancellationSignal;)V
    //   156: goto -88 -> 68
    //   159: astore 7
    //   161: aload_0
    //   162: getfield 72	org/sqlite/database/sqlite/SQLiteSession:mTransactionStack	Lorg/sqlite/database/sqlite/SQLiteSession$Transaction;
    //   165: ifnonnull +15 -> 180
    //   168: aload_0
    //   169: getfield 49	org/sqlite/database/sqlite/SQLiteSession:mConnection	Lorg/sqlite/database/sqlite/SQLiteConnection;
    //   172: ldc 105
    //   174: aconst_null
    //   175: aload 4
    //   177: invokevirtual 82	org/sqlite/database/sqlite/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lorg/sqlite/os/CancellationSignal;)V
    //   180: aload 7
    //   182: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   25	32	128	finally
    //   56	68	128	finally
    //   72	78	128	finally
    //   78	101	128	finally
    //   113	125	128	finally
    //   144	156	128	finally
    //   161	180	128	finally
    //   180	183	128	finally
    //   72	78	159	java/lang/RuntimeException
  }

  private void endTransactionUnchecked(CancellationSignal paramCancellationSignal, boolean paramBoolean)
  {
    if (paramCancellationSignal != null)
      paramCancellationSignal.throwIfCanceled();
    Transaction localTransaction = this.mTransactionStack;
    int i;
    SQLiteTransactionListener localSQLiteTransactionListener;
    if (((localTransaction.mMarkedSuccessful) || (paramBoolean)) && (!localTransaction.mChildFailed))
    {
      i = 1;
      localSQLiteTransactionListener = localTransaction.mListener;
      if (localSQLiteTransactionListener == null)
        break label176;
      if (i == 0)
        break label111;
    }
    while (true)
    {
      try
      {
        localSQLiteTransactionListener.onCommit();
        j = i;
        Object localObject1 = null;
        this.mTransactionStack = localTransaction.mParent;
        recycleTransaction(localTransaction);
        if (this.mTransactionStack != null)
        {
          if (j == 0)
            this.mTransactionStack.mChildFailed = true;
          if (localObject1 == null)
            break label175;
          throw localObject1;
          i = 0;
          break;
          label111: localSQLiteTransactionListener.onRollback();
          continue;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        j = 0;
        continue;
        if (j != 0);
        try
        {
          this.mConnection.execute("COMMIT;", null, paramCancellationSignal);
          releaseConnection();
          continue;
          this.mConnection.execute("ROLLBACK;", null, paramCancellationSignal);
          continue;
        }
        finally
        {
          releaseConnection();
        }
      }
      label175: return;
      label176: int j = i;
      Object localObject2 = null;
    }
  }

  private boolean executeSpecial(int paramInt1, int paramInt2, CancellationSignal paramCancellationSignal)
  {
    if (paramCancellationSignal != null)
      paramCancellationSignal.throwIfCanceled();
    switch (paramInt1)
    {
    default:
      return false;
    case 4:
      beginTransaction(2, null, paramInt2, paramCancellationSignal);
      return true;
    case 5:
      setTransactionSuccessful();
      endTransaction(paramCancellationSignal);
      return true;
    case 6:
    }
    endTransaction(paramCancellationSignal);
    return true;
  }

  private boolean executeSpecial(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramCancellationSignal != null)
      paramCancellationSignal.throwIfCanceled();
    switch (DatabaseUtils.getSqlStatementType(paramString))
    {
    default:
      return false;
    case 4:
      beginTransaction(2, null, paramInt, paramCancellationSignal);
      return true;
    case 5:
      setTransactionSuccessful();
      endTransaction(paramCancellationSignal);
      return true;
    case 6:
    }
    endTransaction(paramCancellationSignal);
    return true;
  }

  private Transaction obtainTransaction(int paramInt, SQLiteTransactionListener paramSQLiteTransactionListener)
  {
    Transaction localTransaction = this.mTransactionPool;
    if (localTransaction != null)
    {
      this.mTransactionPool = localTransaction.mParent;
      localTransaction.mParent = null;
      localTransaction.mMarkedSuccessful = false;
      localTransaction.mChildFailed = false;
    }
    while (true)
    {
      localTransaction.mMode = paramInt;
      localTransaction.mListener = paramSQLiteTransactionListener;
      return localTransaction;
      localTransaction = new Transaction(null);
    }
  }

  private void recycleTransaction(Transaction paramTransaction)
  {
    paramTransaction.mParent = this.mTransactionPool;
    paramTransaction.mListener = null;
    this.mTransactionPool = paramTransaction;
  }

  private void releaseConnection()
  {
    assert (this.mConnection != null);
    assert (this.mConnectionUseCount > 0);
    int i = -1 + this.mConnectionUseCount;
    this.mConnectionUseCount = i;
    if (i == 0);
    try
    {
      this.mConnectionPool.releaseConnection(this.mConnection);
      return;
    }
    finally
    {
      this.mConnection = null;
    }
  }

  private void throwIfNestedTransaction()
  {
    if (hasNestedTransaction())
      throw new IllegalStateException("Cannot perform this operation because a nested transaction is in progress.");
  }

  private void throwIfNoTransaction()
  {
    if (this.mTransactionStack == null)
      throw new IllegalStateException("Cannot perform this operation because there is no current transaction.");
  }

  private void throwIfTransactionMarkedSuccessful()
  {
    if ((this.mTransactionStack != null) && (this.mTransactionStack.mMarkedSuccessful))
      throw new IllegalStateException("Cannot perform this operation because the transaction has already been marked successful.  The only thing you can do now is call endTransaction().");
  }

  private boolean yieldTransactionUnchecked(long paramLong, CancellationSignal paramCancellationSignal)
  {
    if (paramCancellationSignal != null)
      paramCancellationSignal.throwIfCanceled();
    if (!this.mConnectionPool.shouldYieldConnection(this.mConnection, this.mConnectionFlags))
      return false;
    int i = this.mTransactionStack.mMode;
    SQLiteTransactionListener localSQLiteTransactionListener = this.mTransactionStack.mListener;
    int j = this.mConnectionFlags;
    endTransactionUnchecked(paramCancellationSignal, true);
    if (paramLong > 0L);
    try
    {
      Thread.sleep(paramLong);
      label68: beginTransactionUnchecked(i, localSQLiteTransactionListener, j, paramCancellationSignal);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label68;
    }
  }

  public void beginTransaction(int paramInt1, SQLiteTransactionListener paramSQLiteTransactionListener, int paramInt2, CancellationSignal paramCancellationSignal)
  {
    throwIfTransactionMarkedSuccessful();
    beginTransactionUnchecked(paramInt1, paramSQLiteTransactionListener, paramInt2, paramCancellationSignal);
  }

  public void endTransaction(CancellationSignal paramCancellationSignal)
  {
    throwIfNoTransaction();
    assert (this.mConnection != null);
    endTransactionUnchecked(paramCancellationSignal, false);
  }

  public void execute(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null)
      throw new IllegalArgumentException("sql must not be null.");
    if (executeSpecial(paramString, paramArrayOfObject, paramInt, paramCancellationSignal))
      return;
    acquireConnection(paramString, paramInt, paramCancellationSignal);
    try
    {
      this.mConnection.execute(paramString, paramArrayOfObject, paramCancellationSignal);
      return;
    }
    finally
    {
      releaseConnection();
    }
  }

  public ParcelFileDescriptor executeForBlobFileDescriptor(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null)
      throw new IllegalArgumentException("sql must not be null.");
    if (executeSpecial(paramString, paramArrayOfObject, paramInt, paramCancellationSignal))
      return null;
    acquireConnection(paramString, paramInt, paramCancellationSignal);
    try
    {
      ParcelFileDescriptor localParcelFileDescriptor = this.mConnection.executeForBlobFileDescriptor(paramString, paramArrayOfObject, paramCancellationSignal);
      return localParcelFileDescriptor;
    }
    finally
    {
      releaseConnection();
    }
  }

  public int executeForChangedRowCount(String paramString, int paramInt1, Object[] paramArrayOfObject, int paramInt2, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null)
      throw new IllegalArgumentException("sql must not be null.");
    if (executeSpecial(paramInt1, paramInt2, paramCancellationSignal))
      return 0;
    acquireConnection(paramString, paramInt2, paramCancellationSignal);
    try
    {
      int i = this.mConnection.executeForChangedRowCount(paramString, paramArrayOfObject, paramCancellationSignal);
      return i;
    }
    finally
    {
      releaseConnection();
    }
  }

  public int executeForCursorWindow(String paramString, Object[] paramArrayOfObject, CursorWindow paramCursorWindow, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null)
      throw new IllegalArgumentException("sql must not be null.");
    if (paramCursorWindow == null)
      throw new IllegalArgumentException("window must not be null.");
    if (executeSpecial(paramString, paramArrayOfObject, paramInt3, paramCancellationSignal))
    {
      paramCursorWindow.clear();
      return 0;
    }
    acquireConnection(paramString, paramInt3, paramCancellationSignal);
    try
    {
      int i = this.mConnection.executeForCursorWindow(paramString, paramArrayOfObject, paramCursorWindow, paramInt1, paramInt2, paramBoolean, paramCancellationSignal);
      return i;
    }
    finally
    {
      releaseConnection();
    }
  }

  public long executeForLastInsertedRowId(String paramString, int paramInt1, Object[] paramArrayOfObject, int paramInt2, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null)
      throw new IllegalArgumentException("sql must not be null.");
    if (executeSpecial(paramInt1, paramInt2, paramCancellationSignal))
      return 0L;
    acquireConnection(paramString, paramInt2, paramCancellationSignal);
    try
    {
      long l = this.mConnection.executeForLastInsertedRowId(paramString, paramArrayOfObject, paramCancellationSignal);
      return l;
    }
    finally
    {
      releaseConnection();
    }
  }

  public long executeForLastInsertedRowId(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null)
      throw new IllegalArgumentException("sql must not be null.");
    if (executeSpecial(paramString, paramArrayOfObject, paramInt, paramCancellationSignal))
      return 0L;
    acquireConnection(paramString, paramInt, paramCancellationSignal);
    try
    {
      long l = this.mConnection.executeForLastInsertedRowId(paramString, paramArrayOfObject, paramCancellationSignal);
      return l;
    }
    finally
    {
      releaseConnection();
    }
  }

  public long executeForLong(String paramString, int paramInt1, Object[] paramArrayOfObject, int paramInt2, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null)
      throw new IllegalArgumentException("sql must not be null.");
    if (executeSpecial(paramInt1, paramInt2, paramCancellationSignal))
      return 0L;
    acquireConnection(paramString, paramInt2, paramCancellationSignal);
    try
    {
      long l = this.mConnection.executeForLong(paramString, paramArrayOfObject, paramCancellationSignal);
      return l;
    }
    finally
    {
      releaseConnection();
    }
  }

  public long executeForLong(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null)
      throw new IllegalArgumentException("sql must not be null.");
    if (executeSpecial(paramString, paramArrayOfObject, paramInt, paramCancellationSignal))
      return 0L;
    acquireConnection(paramString, paramInt, paramCancellationSignal);
    try
    {
      long l = this.mConnection.executeForLong(paramString, paramArrayOfObject, paramCancellationSignal);
      return l;
    }
    finally
    {
      releaseConnection();
    }
  }

  public String executeForString(String paramString, int paramInt1, Object[] paramArrayOfObject, int paramInt2, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null)
      throw new IllegalArgumentException("sql must not be null.");
    if (executeSpecial(paramInt1, paramInt2, paramCancellationSignal))
      return null;
    acquireConnection(paramString, paramInt2, paramCancellationSignal);
    try
    {
      String str = this.mConnection.executeForString(paramString, paramArrayOfObject, paramCancellationSignal);
      return str;
    }
    finally
    {
      releaseConnection();
    }
  }

  public String executeForString(String paramString, Object[] paramArrayOfObject, int paramInt, CancellationSignal paramCancellationSignal)
  {
    if (paramString == null)
      throw new IllegalArgumentException("sql must not be null.");
    if (executeSpecial(paramString, paramArrayOfObject, paramInt, paramCancellationSignal))
      return null;
    acquireConnection(paramString, paramInt, paramCancellationSignal);
    try
    {
      String str = this.mConnection.executeForString(paramString, paramArrayOfObject, paramCancellationSignal);
      return str;
    }
    finally
    {
      releaseConnection();
    }
  }

  public boolean hasConnection()
  {
    return this.mConnection != null;
  }

  public boolean hasNestedTransaction()
  {
    return (this.mTransactionStack != null) && (this.mTransactionStack.mParent != null);
  }

  public boolean hasTransaction()
  {
    return this.mTransactionStack != null;
  }

  public void prepare(String paramString, int paramInt, CancellationSignal paramCancellationSignal, SQLiteStatementInfo paramSQLiteStatementInfo)
  {
    if (paramString == null)
      throw new IllegalArgumentException("sql must not be null.");
    if (paramCancellationSignal != null)
      paramCancellationSignal.throwIfCanceled();
    acquireConnection(paramString, paramInt, paramCancellationSignal);
    try
    {
      this.mConnection.prepare(paramString, paramSQLiteStatementInfo);
      return;
    }
    finally
    {
      releaseConnection();
    }
  }

  public void setTransactionSuccessful()
  {
    throwIfNoTransaction();
    throwIfTransactionMarkedSuccessful();
    this.mTransactionStack.mMarkedSuccessful = true;
  }

  public boolean yieldTransaction(long paramLong, boolean paramBoolean, CancellationSignal paramCancellationSignal)
  {
    if (paramBoolean)
    {
      throwIfNoTransaction();
      throwIfTransactionMarkedSuccessful();
      throwIfNestedTransaction();
    }
    while ((this.mTransactionStack != null) && (!this.mTransactionStack.mMarkedSuccessful) && (this.mTransactionStack.mParent == null))
    {
      if (($assertionsDisabled) || (this.mConnection != null))
        break;
      throw new AssertionError();
    }
    while (this.mTransactionStack.mChildFailed)
      return false;
    return yieldTransactionUnchecked(paramLong, paramCancellationSignal);
  }

  private static final class Transaction
  {
    public boolean mChildFailed;
    public SQLiteTransactionListener mListener;
    public boolean mMarkedSuccessful;
    public int mMode;
    public Transaction mParent;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.sqlite.database.sqlite.SQLiteSession
 * JD-Core Version:    0.6.2
 */