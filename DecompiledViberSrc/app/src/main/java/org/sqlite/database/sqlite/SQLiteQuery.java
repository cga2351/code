package org.sqlite.database.sqlite;

import org.sqlite.os.CancellationSignal;

public final class SQLiteQuery extends SQLiteProgram
{
  private static final String TAG = "SQLiteQuery";
  private final CancellationSignal mCancellationSignal;

  SQLiteQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, CancellationSignal paramCancellationSignal)
  {
    super(paramSQLiteDatabase, paramString, null, paramCancellationSignal);
    this.mCancellationSignal = paramCancellationSignal;
  }

  // ERROR //
  int fillWindow(CursorWindow paramCursorWindow, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 27	org/sqlite/database/sqlite/SQLiteQuery:acquireReference	()V
    //   4: aload_1
    //   5: invokevirtual 30	org/sqlite/database/sqlite/CursorWindow:acquireReference	()V
    //   8: aload_0
    //   9: invokevirtual 34	org/sqlite/database/sqlite/SQLiteQuery:getSession	()Lorg/sqlite/database/sqlite/SQLiteSession;
    //   12: aload_0
    //   13: invokevirtual 38	org/sqlite/database/sqlite/SQLiteQuery:getSql	()Ljava/lang/String;
    //   16: aload_0
    //   17: invokevirtual 42	org/sqlite/database/sqlite/SQLiteQuery:getBindArgs	()[Ljava/lang/Object;
    //   20: aload_1
    //   21: iload_2
    //   22: iload_3
    //   23: iload 4
    //   25: aload_0
    //   26: invokevirtual 46	org/sqlite/database/sqlite/SQLiteQuery:getConnectionFlags	()I
    //   29: aload_0
    //   30: getfield 17	org/sqlite/database/sqlite/SQLiteQuery:mCancellationSignal	Lorg/sqlite/os/CancellationSignal;
    //   33: invokevirtual 52	org/sqlite/database/sqlite/SQLiteSession:executeForCursorWindow	(Ljava/lang/String;[Ljava/lang/Object;Lorg/sqlite/database/sqlite/CursorWindow;IIZILorg/sqlite/os/CancellationSignal;)I
    //   36: istore 9
    //   38: aload_1
    //   39: invokevirtual 55	org/sqlite/database/sqlite/CursorWindow:releaseReference	()V
    //   42: aload_0
    //   43: invokevirtual 56	org/sqlite/database/sqlite/SQLiteQuery:releaseReference	()V
    //   46: iload 9
    //   48: ireturn
    //   49: astore 8
    //   51: aload_0
    //   52: invokevirtual 59	org/sqlite/database/sqlite/SQLiteQuery:onCorruption	()V
    //   55: aload 8
    //   57: athrow
    //   58: astore 7
    //   60: aload_1
    //   61: invokevirtual 55	org/sqlite/database/sqlite/CursorWindow:releaseReference	()V
    //   64: aload 7
    //   66: athrow
    //   67: astore 5
    //   69: aload_0
    //   70: invokevirtual 56	org/sqlite/database/sqlite/SQLiteQuery:releaseReference	()V
    //   73: aload 5
    //   75: athrow
    //   76: astore 6
    //   78: aload 6
    //   80: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   8	38	49	org/sqlite/database/sqlite/SQLiteDatabaseCorruptException
    //   8	38	58	finally
    //   51	58	58	finally
    //   78	81	58	finally
    //   4	8	67	finally
    //   38	42	67	finally
    //   60	67	67	finally
    //   8	38	76	org/sqlite/database/sqlite/SQLiteException
  }

  public String toString()
  {
    return "SQLiteQuery: " + getSql();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.sqlite.database.sqlite.SQLiteQuery
 * JD-Core Version:    0.6.2
 */