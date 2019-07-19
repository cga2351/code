package android.arch.persistence.a.a;

import android.arch.persistence.a.b;
import android.arch.persistence.a.f;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteQuery;
import android.util.Pair;
import java.io.IOException;
import java.util.List;

class a
  implements b
{
  private static final String[] a = { "", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE " };
  private static final String[] b = new String[0];
  private final SQLiteDatabase c;

  a(SQLiteDatabase paramSQLiteDatabase)
  {
    this.c = paramSQLiteDatabase;
  }

  public f a(String paramString)
  {
    return new e(this.c.compileStatement(paramString));
  }

  public Cursor a(final android.arch.persistence.a.e parame)
  {
    return this.c.rawQueryWithFactory(new SQLiteDatabase.CursorFactory()
    {
      public Cursor newCursor(SQLiteDatabase paramAnonymousSQLiteDatabase, SQLiteCursorDriver paramAnonymousSQLiteCursorDriver, String paramAnonymousString, SQLiteQuery paramAnonymousSQLiteQuery)
      {
        parame.a(new d(paramAnonymousSQLiteQuery));
        return new SQLiteCursor(paramAnonymousSQLiteCursorDriver, paramAnonymousString, paramAnonymousSQLiteQuery);
      }
    }
    , parame.a(), b, null);
  }

  public void a()
  {
    this.c.beginTransaction();
  }

  public Cursor b(String paramString)
  {
    return a(new android.arch.persistence.a.a(paramString));
  }

  public void b()
  {
    this.c.endTransaction();
  }

  public void c()
  {
    this.c.setTransactionSuccessful();
  }

  public void c(String paramString)
    throws SQLException
  {
    this.c.execSQL(paramString);
  }

  public void close()
    throws IOException
  {
    this.c.close();
  }

  public boolean d()
  {
    return this.c.inTransaction();
  }

  public boolean e()
  {
    return this.c.isOpen();
  }

  public String f()
  {
    return this.c.getPath();
  }

  public List<Pair<String, String>> g()
  {
    return this.c.getAttachedDbs();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.persistence.a.a.a
 * JD-Core Version:    0.6.2
 */