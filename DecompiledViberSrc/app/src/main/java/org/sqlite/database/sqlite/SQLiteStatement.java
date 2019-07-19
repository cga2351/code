package org.sqlite.database.sqlite;

import android.os.ParcelFileDescriptor;

public final class SQLiteStatement extends SQLiteProgram
{
  private final int mConnectionFlags = getConnectionFlags();

  SQLiteStatement(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject)
  {
    super(paramSQLiteDatabase, paramString, paramArrayOfObject, null);
  }

  public void execute()
  {
    acquireReference();
    try
    {
      getSession().execute(getSql(), getBindArgs(), this.mConnectionFlags, null);
      return;
    }
    catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
    {
      throw localSQLiteDatabaseCorruptException;
    }
    finally
    {
      releaseReference();
    }
  }

  public long executeInsert()
  {
    acquireReference();
    try
    {
      long l = getSession().executeForLastInsertedRowId(getSql(), this.mSqlType, getBindArgs(), this.mConnectionFlags, null);
      return l;
    }
    catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
    {
      throw localSQLiteDatabaseCorruptException;
    }
    finally
    {
      releaseReference();
    }
  }

  public int executeUpdateDelete()
  {
    acquireReference();
    try
    {
      int i = getSession().executeForChangedRowCount(getSql(), this.mSqlType, getBindArgs(), this.mConnectionFlags, null);
      return i;
    }
    catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
    {
      throw localSQLiteDatabaseCorruptException;
    }
    finally
    {
      releaseReference();
    }
  }

  public ParcelFileDescriptor simpleQueryForBlobFileDescriptor()
  {
    acquireReference();
    try
    {
      ParcelFileDescriptor localParcelFileDescriptor = getSession().executeForBlobFileDescriptor(getSql(), getBindArgs(), this.mConnectionFlags, null);
      return localParcelFileDescriptor;
    }
    catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
    {
      throw localSQLiteDatabaseCorruptException;
    }
    finally
    {
      releaseReference();
    }
  }

  public long simpleQueryForLong()
  {
    acquireReference();
    try
    {
      long l = getSession().executeForLong(getSql(), this.mSqlType, getBindArgs(), this.mConnectionFlags, null);
      return l;
    }
    catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
    {
      throw localSQLiteDatabaseCorruptException;
    }
    finally
    {
      releaseReference();
    }
  }

  public String simpleQueryForString()
  {
    acquireReference();
    try
    {
      String str = getSession().executeForString(getSql(), this.mSqlType, getBindArgs(), this.mConnectionFlags, null);
      return str;
    }
    catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
    {
      throw localSQLiteDatabaseCorruptException;
    }
    finally
    {
      releaseReference();
    }
  }

  public String toString()
  {
    return "SQLiteProgram: " + getSql();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.sqlite.database.sqlite.SQLiteStatement
 * JD-Core Version:    0.6.2
 */