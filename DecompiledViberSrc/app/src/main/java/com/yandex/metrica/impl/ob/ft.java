package com.yandex.metrica.impl.ob;

import android.database.sqlite.SQLiteDatabase;

public class ft
  implements fr
{
  private final fi a;

  public ft(fi paramfi)
  {
    this.a = paramfi;
  }

  public SQLiteDatabase a()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public void a(SQLiteDatabase paramSQLiteDatabase)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ft
 * JD-Core Version:    0.6.2
 */