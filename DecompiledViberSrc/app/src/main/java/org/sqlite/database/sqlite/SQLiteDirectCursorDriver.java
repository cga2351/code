package org.sqlite.database.sqlite;

import android.database.Cursor;
import org.sqlite.os.CancellationSignal;

public final class SQLiteDirectCursorDriver
  implements SQLiteCursorDriver
{
  private final CancellationSignal mCancellationSignal;
  private final SQLiteDatabase mDatabase;
  private SQLiteQuery mQuery;
  private final String mSql;

  public SQLiteDirectCursorDriver(SQLiteDatabase paramSQLiteDatabase, String paramString, CancellationSignal paramCancellationSignal)
  {
    this.mDatabase = paramSQLiteDatabase;
    this.mSql = paramString;
    this.mCancellationSignal = paramCancellationSignal;
  }

  public void cursorClosed()
  {
  }

  public void cursorDeactivated()
  {
  }

  public void cursorRequeried(Cursor paramCursor)
  {
  }

  public Cursor query(int paramInt, String[] paramArrayOfString)
  {
    SQLiteQuery localSQLiteQuery = new SQLiteQuery(this.mDatabase, this.mSql, this.mCancellationSignal);
    try
    {
      localSQLiteQuery.bindAllArgsAsStrings(paramArrayOfString);
      CustomWindowSizeSQLiteCursor localCustomWindowSizeSQLiteCursor = new CustomWindowSizeSQLiteCursor(paramInt, this, localSQLiteQuery);
      this.mQuery = localSQLiteQuery;
      return localCustomWindowSizeSQLiteCursor;
    }
    catch (RuntimeException localRuntimeException)
    {
      localSQLiteQuery.close();
      throw localRuntimeException;
    }
  }

  public Cursor query(SQLiteDatabase.CursorFactory paramCursorFactory, String[] paramArrayOfString)
  {
    SQLiteQuery localSQLiteQuery = new SQLiteQuery(this.mDatabase, this.mSql, this.mCancellationSignal);
    try
    {
      localSQLiteQuery.bindAllArgsAsStrings(paramArrayOfString);
      if (paramCursorFactory == null);
      Cursor localCursor;
      for (Object localObject = new SQLiteCursor(this, localSQLiteQuery); ; localObject = localCursor)
      {
        this.mQuery = localSQLiteQuery;
        return localObject;
        localCursor = paramCursorFactory.newCursor(this.mDatabase, this, localSQLiteQuery);
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      localSQLiteQuery.close();
      throw localRuntimeException;
    }
  }

  public void setBindArguments(String[] paramArrayOfString)
  {
    this.mQuery.bindAllArgsAsStrings(paramArrayOfString);
  }

  public String toString()
  {
    return "SQLiteDirectCursorDriver: " + this.mSql;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.sqlite.database.sqlite.SQLiteDirectCursorDriver
 * JD-Core Version:    0.6.2
 */