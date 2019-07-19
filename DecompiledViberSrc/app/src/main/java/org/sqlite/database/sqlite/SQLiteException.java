package org.sqlite.database.sqlite;

import org.sqlite.database.SQLException;

public class SQLiteException extends SQLException
{
  public SQLiteException()
  {
  }

  public SQLiteException(String paramString)
  {
    super(paramString);
  }

  public SQLiteException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.sqlite.database.sqlite.SQLiteException
 * JD-Core Version:    0.6.2
 */