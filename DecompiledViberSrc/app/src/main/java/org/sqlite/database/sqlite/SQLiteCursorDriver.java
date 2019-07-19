package org.sqlite.database.sqlite;

import android.database.Cursor;

public abstract interface SQLiteCursorDriver
{
  public abstract void cursorClosed();

  public abstract void cursorDeactivated();

  public abstract void cursorRequeried(Cursor paramCursor);

  public abstract Cursor query(int paramInt, String[] paramArrayOfString);

  public abstract Cursor query(SQLiteDatabase.CursorFactory paramCursorFactory, String[] paramArrayOfString);

  public abstract void setBindArguments(String[] paramArrayOfString);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.sqlite.database.sqlite.SQLiteCursorDriver
 * JD-Core Version:    0.6.2
 */