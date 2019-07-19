package com.viber.provider.messages;

import android.content.ContentValues;
import android.database.Cursor;
import com.viber.dexshared.Logger;
import com.viber.provider.b;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.af;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.sqlite.database.SQLException;
import org.sqlite.database.sqlite.SQLiteDatabase;
import org.sqlite.database.sqlite.SQLiteQueryBuilder;
import org.sqlite.database.sqlite.SQLiteStatement;

public class a
  implements b
{
  private static final Logger b = ViberEnv.getLogger();
  protected final SQLiteDatabase a;

  a(SQLiteDatabase paramSQLiteDatabase)
  {
    this.a = paramSQLiteDatabase;
  }

  protected static String a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return SQLiteQueryBuilder.buildQueryString(paramBoolean, paramString1, paramArrayOfString1, paramString2, paramString3, paramString4, paramString5, paramString6) + "; args = " + Arrays.toString(paramArrayOfString2);
  }

  private void a(Cursor paramCursor)
  {
    if (paramCursor != null)
      paramCursor.getCount();
  }

  public static void i()
  {
  }

  public int a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    return this.a.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
  }

  public int a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return this.a.delete(paramString1, paramString2, paramArrayOfString);
  }

  public long a(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    return this.a.insert(paramString1, paramString2, paramContentValues);
  }

  public long a(SQLiteStatement paramSQLiteStatement)
  {
    return paramSQLiteStatement.simpleQueryForLong();
  }

  public Cursor a(int paramInt, String paramString, String[] paramArrayOfString)
  {
    Cursor localCursor = this.a.rawQueryWithCustomWindowSize(paramInt, paramString, paramArrayOfString);
    a(localCursor);
    return localCursor;
  }

  public Cursor a(String paramString, String[] paramArrayOfString)
  {
    Cursor localCursor = this.a.rawQuery(paramString, paramArrayOfString);
    a(localCursor);
    return localCursor;
  }

  public Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
  {
    Cursor localCursor = this.a.query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5);
    a(localCursor);
    return localCursor;
  }

  public Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    Cursor localCursor = this.a.query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
    a(localCursor);
    return localCursor;
  }

  public Cursor a(SQLiteQueryBuilder paramSQLiteQueryBuilder, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4)
  {
    Cursor localCursor = paramSQLiteQueryBuilder.query(this.a, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramString3, paramString4);
    a(localCursor);
    return localCursor;
  }

  public void a()
  {
    this.a.beginTransaction();
  }

  public void a(String paramString)
    throws SQLException
  {
    this.a.execSQL(paramString);
  }

  public void a(String paramString, Object[] paramArrayOfObject)
    throws SQLException
  {
    this.a.execSQL(paramString, paramArrayOfObject);
  }

  public void a(Locale paramLocale)
  {
    this.a.setLocale(paramLocale);
  }

  public long b(String paramString1, String paramString2, ContentValues paramContentValues)
    throws SQLException
  {
    return this.a.insertOrThrow(paramString1, paramString2, paramContentValues);
  }

  public SQLiteStatement b(String paramString)
    throws SQLException
  {
    return this.a.compileStatement(paramString);
  }

  public void b()
  {
    this.a.endTransaction();
  }

  public void c()
  {
    this.a.setTransactionSuccessful();
  }

  public void c(String paramString)
  {
    try
    {
      List localList = d(paramString);
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!str.contains("sqlite_autoindex"))
            this.a.execSQL("DROP INDEX IF EXISTS " + str);
        }
      }
    }
    catch (SQLException localSQLException)
    {
    }
  }

  public List<String> d(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.a.rawQuery("PRAGMA index_list(" + paramString + ")", null);
    StringBuilder localStringBuilder = new StringBuilder(256);
    if ((localCursor != null) && (localCursor.moveToFirst()))
      do
      {
        String str = localCursor.getString(1);
        localArrayList.add(str);
        localStringBuilder.append(str).append('\n');
      }
      while (localCursor.moveToNext());
    af.a(localCursor);
    return localArrayList;
  }

  public boolean d()
  {
    return this.a.inTransaction();
  }

  public boolean e()
  {
    return this.a.isDbLockedByCurrentThread();
  }

  public boolean f()
  {
    return this.a.isOpen();
  }

  public SQLiteDatabase g()
  {
    return this.a;
  }

  public void h()
  {
    this.a.compileStatement("PRAGMA user_version").simpleQueryForLong();
    this.a.compileStatement("select count(*) from messages").simpleQueryForLong();
    this.a.compileStatement("select count(*) from conversations").simpleQueryForLong();
    this.a.compileStatement("select count(*) from participants").simpleQueryForLong();
    this.a.compileStatement("select count(*) from participants_info").simpleQueryForLong();
    this.a.compileStatement("select count(*) from public_accounts").simpleQueryForLong();
    this.a.compileStatement("select count(*) from stickers").simpleQueryForLong();
    this.a.compileStatement("select count(*) from stickers_packages").simpleQueryForLong();
    this.a.compileStatement("select count(*) from remote_banners").simpleQueryForLong();
    this.a.compileStatement("select count(*) from adx").simpleQueryForLong();
    this.a.compileStatement("select count(*) from conference_calls").simpleQueryForLong();
    d("messages");
    d("conversations");
    d("participants");
    d("participants_info");
    d("public_accounts");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.provider.messages.a
 * JD-Core Version:    0.6.2
 */