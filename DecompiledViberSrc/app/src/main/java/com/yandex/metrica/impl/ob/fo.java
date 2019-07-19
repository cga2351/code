package com.yandex.metrica.impl.ob;

import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;

public class fo
{
  private final String a;
  private final ff.q b;
  private final ff.q c;
  private final SparseArray<ff.q> d;
  private final fp e;

  public fo(String paramString, ff.q paramq1, ff.q paramq2, SparseArray<ff.q> paramSparseArray, fp paramfp)
  {
    this.a = paramString;
    this.b = paramq1;
    this.c = paramq2;
    this.d = paramSparseArray;
    this.e = paramfp;
  }

  public void a(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      if ((this.e != null) && (!this.e.a(paramSQLiteDatabase)))
        a(paramSQLiteDatabase, this.b, this.c);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    int i = 1;
    int k;
    if (paramInt2 > paramInt1)
    {
      k = paramInt1 + 1;
      if (k > paramInt2);
    }
    while (true)
    {
      try
      {
        ff.q localq = (ff.q)this.d.get(k);
        if (localq != null)
          localq.a(paramSQLiteDatabase);
        k++;
        break;
        j = 0;
        if (!this.e.a(paramSQLiteDatabase))
        {
          if ((j | i) != 0)
            a(paramSQLiteDatabase, this.b, this.c);
          return;
        }
      }
      catch (Exception localException)
      {
        j = i;
        continue;
        i = 0;
        continue;
      }
      int j = i;
    }
  }

  void a(SQLiteDatabase paramSQLiteDatabase, ff.q paramq1, ff.q paramq2)
  {
    try
    {
      paramq2.a(paramSQLiteDatabase);
      label5: a(paramq1, paramSQLiteDatabase);
      return;
    }
    catch (Exception localException)
    {
      break label5;
    }
  }

  void a(ff.q paramq, SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramq.a(paramSQLiteDatabase);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void b(SQLiteDatabase paramSQLiteDatabase)
  {
    a(this.b, paramSQLiteDatabase);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.fo
 * JD-Core Version:    0.6.2
 */