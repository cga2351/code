package android.arch.persistence.a.a;

import android.arch.persistence.a.f;
import android.database.sqlite.SQLiteStatement;

class e extends d
  implements f
{
  private final SQLiteStatement a;

  e(SQLiteStatement paramSQLiteStatement)
  {
    super(paramSQLiteStatement);
    this.a = paramSQLiteStatement;
  }

  public int a()
  {
    return this.a.executeUpdateDelete();
  }

  public long b()
  {
    return this.a.executeInsert();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.persistence.a.a.e
 * JD-Core Version:    0.6.2
 */