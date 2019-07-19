package android.arch.persistence.a.a;

import android.arch.persistence.a.c;
import android.arch.persistence.a.c.a;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class b
  implements c
{
  private final a a = a(paramContext, paramString, parama);

  b(Context paramContext, String paramString, c.a parama)
  {
  }

  private a a(Context paramContext, String paramString, c.a parama)
  {
    return new a(paramContext, paramString, new a[1], parama);
  }

  public android.arch.persistence.a.b a()
  {
    return this.a.a();
  }

  public void a(boolean paramBoolean)
  {
    this.a.setWriteAheadLoggingEnabled(paramBoolean);
  }

  static class a extends SQLiteOpenHelper
  {
    final a[] a;
    final c.a b;
    private boolean c;

    a(Context paramContext, String paramString, a[] paramArrayOfa, final c.a parama)
    {
      super(paramString, null, parama.a, new DatabaseErrorHandler()
      {
        public void onCorruption(SQLiteDatabase paramAnonymousSQLiteDatabase)
        {
          a locala = b.a.this[0];
          if (locala != null)
            parama.d(locala);
        }
      });
      this.b = parama;
      this.a = paramArrayOfa;
    }

    a a(SQLiteDatabase paramSQLiteDatabase)
    {
      if (this.a[0] == null)
      {
        a locala = new a(paramSQLiteDatabase);
        this.a[0] = locala;
      }
      return this.a[0];
    }

    android.arch.persistence.a.b a()
    {
      try
      {
        this.c = false;
        SQLiteDatabase localSQLiteDatabase = super.getWritableDatabase();
        android.arch.persistence.a.b localb;
        if (this.c)
        {
          close();
          localb = a();
        }
        a locala;
        for (Object localObject2 = localb; ; localObject2 = locala)
        {
          return localObject2;
          locala = a(localSQLiteDatabase);
        }
      }
      finally
      {
      }
    }

    public void close()
    {
      try
      {
        super.close();
        this.a[0] = null;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    public void onConfigure(SQLiteDatabase paramSQLiteDatabase)
    {
      this.b.a(a(paramSQLiteDatabase));
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      this.b.b(a(paramSQLiteDatabase));
    }

    public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      this.c = true;
      this.b.b(a(paramSQLiteDatabase), paramInt1, paramInt2);
    }

    public void onOpen(SQLiteDatabase paramSQLiteDatabase)
    {
      if (!this.c)
        this.b.c(a(paramSQLiteDatabase));
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      this.c = true;
      this.b.a(a(paramSQLiteDatabase), paramInt1, paramInt2);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.persistence.a.a.b
 * JD-Core Version:    0.6.2
 */