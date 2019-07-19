package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.Closeable;

public class fi extends SQLiteOpenHelper
  implements Closeable
{
  protected final fo a;

  public fi(Context paramContext, String paramString, fo paramfo)
  {
    super(paramContext, paramString, null, ff.b);
    this.a = paramfo;
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    this.a.b(paramSQLiteDatabase);
  }

  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onOpen(paramSQLiteDatabase);
    this.a.a(paramSQLiteDatabase);
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    this.a.a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.fi
 * JD-Core Version:    0.6.2
 */