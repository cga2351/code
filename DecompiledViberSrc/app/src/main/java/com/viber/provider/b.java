package com.viber.provider;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.Locale;
import org.sqlite.database.SQLException;
import org.sqlite.database.sqlite.SQLiteDatabase;
import org.sqlite.database.sqlite.SQLiteQueryBuilder;
import org.sqlite.database.sqlite.SQLiteStatement;

public abstract interface b
{
  public abstract int a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString);

  public abstract int a(String paramString1, String paramString2, String[] paramArrayOfString);

  public abstract long a(String paramString1, String paramString2, ContentValues paramContentValues);

  public abstract long a(SQLiteStatement paramSQLiteStatement);

  public abstract Cursor a(int paramInt, String paramString, String[] paramArrayOfString);

  public abstract Cursor a(String paramString, String[] paramArrayOfString);

  public abstract Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5);

  public abstract Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6);

  public abstract Cursor a(SQLiteQueryBuilder paramSQLiteQueryBuilder, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4);

  public abstract void a();

  public abstract void a(String paramString)
    throws SQLException;

  public abstract void a(String paramString, Object[] paramArrayOfObject)
    throws SQLException;

  public abstract void a(Locale paramLocale);

  public abstract long b(String paramString1, String paramString2, ContentValues paramContentValues)
    throws SQLException;

  public abstract SQLiteStatement b(String paramString)
    throws SQLException;

  public abstract void b();

  public abstract void c();

  public abstract void c(String paramString);

  public abstract boolean d();

  public abstract boolean e();

  public abstract boolean f();

  public abstract SQLiteDatabase g();

  public abstract void h();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.provider.b
 * JD-Core Version:    0.6.2
 */