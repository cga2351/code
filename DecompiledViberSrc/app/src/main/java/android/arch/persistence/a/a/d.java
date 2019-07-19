package android.arch.persistence.a.a;

import android.database.sqlite.SQLiteProgram;

class d
  implements android.arch.persistence.a.d
{
  private final SQLiteProgram a;

  d(SQLiteProgram paramSQLiteProgram)
  {
    this.a = paramSQLiteProgram;
  }

  public void a(int paramInt)
  {
    this.a.bindNull(paramInt);
  }

  public void a(int paramInt, double paramDouble)
  {
    this.a.bindDouble(paramInt, paramDouble);
  }

  public void a(int paramInt, long paramLong)
  {
    this.a.bindLong(paramInt, paramLong);
  }

  public void a(int paramInt, String paramString)
  {
    this.a.bindString(paramInt, paramString);
  }

  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    this.a.bindBlob(paramInt, paramArrayOfByte);
  }

  public void close()
  {
    this.a.close();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.persistence.a.a.d
 * JD-Core Version:    0.6.2
 */