package com.viber.voip.model.a;

import android.database.Cursor;
import com.viber.dexshared.Logger;
import com.viber.provider.b;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.af;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.sqlite.database.sqlite.SQLiteStatement;

class f extends d
{
  private static final Logger a = ViberEnv.getLogger();
  private static final String[] b = { "_id", "category", "key", "value", "value_type" };
  private final Object c = new Object();
  private SQLiteStatement d;

  private Object a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default:
      paramString = null;
    case 0:
      return paramString;
    case 1:
    case 2:
    case 3:
    }
    try
    {
      return Long.valueOf(Long.parseLong(paramString));
      return Integer.valueOf(Integer.parseInt(paramString));
      Boolean localBoolean = Boolean.valueOf(Boolean.parseBoolean(paramString));
      return localBoolean;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return null;
  }

  private static b d()
  {
    return com.viber.provider.a.a.a(ViberApplication.getApplication());
  }

  private SQLiteStatement e()
  {
    int i = 1;
    if (this.d == null)
    {
      StringBuilder localStringBuilder = new StringBuilder(500);
      localStringBuilder.append("INSERT OR REPLACE INTO ").append("kvdata").append('(');
      String[] arrayOfString = new String[4];
      arrayOfString[0] = "category";
      arrayOfString[i] = "key";
      arrayOfString[2] = "value";
      arrayOfString[3] = "value_type";
      com.viber.voip.s.a.b(localStringBuilder, arrayOfString);
      localStringBuilder.append(") VALUES (?");
      while (i < arrayOfString.length)
      {
        localStringBuilder.append(",?");
        i++;
      }
      localStringBuilder.append(')');
      this.d = d().b(localStringBuilder.toString());
    }
    return this.d;
  }

  public int a(String paramString, Long[] paramArrayOfLong)
  {
    b localb = d();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = com.viber.voip.s.a.a(paramArrayOfLong);
    return localb.a("kvdata", String.format("key=? AND category IN (%s)", arrayOfObject), new String[] { paramString });
  }

  public int a(String paramString, String[] paramArrayOfString)
  {
    b localb = d();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = com.viber.voip.s.a.a(paramArrayOfString);
    return localb.a("kvdata", String.format("key IN (%s) AND category=?", arrayOfObject), new String[] { paramString });
  }

  // ERROR //
  Object a(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 118	com/viber/voip/model/a/f:d	()Lcom/viber/provider/b;
    //   3: astore 4
    //   5: getstatic 36	com/viber/voip/model/a/f:b	[Ljava/lang/String;
    //   8: astore 5
    //   10: iconst_3
    //   11: anewarray 24	java/lang/String
    //   14: astore 6
    //   16: aload 6
    //   18: iconst_0
    //   19: aload_2
    //   20: aastore
    //   21: aload 6
    //   23: iconst_1
    //   24: iload_3
    //   25: invokestatic 152	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   28: aastore
    //   29: aload 6
    //   31: iconst_2
    //   32: aload_1
    //   33: aastore
    //   34: aload 4
    //   36: ldc 104
    //   38: aload 5
    //   40: ldc 154
    //   42: aload 6
    //   44: aconst_null
    //   45: aconst_null
    //   46: aconst_null
    //   47: invokeinterface 157 8 0
    //   52: astore 7
    //   54: aload 7
    //   56: ifnull +148 -> 204
    //   59: aload 7
    //   61: invokeinterface 163 1 0
    //   66: ifeq +138 -> 204
    //   69: aload 7
    //   71: iconst_3
    //   72: invokeinterface 166 2 0
    //   77: astore 15
    //   79: aload_0
    //   80: aload 7
    //   82: iconst_4
    //   83: invokeinterface 170 2 0
    //   88: aload 15
    //   90: invokespecial 172	com/viber/voip/model/a/f:a	(ILjava/lang/String;)Ljava/lang/Object;
    //   93: astore 16
    //   95: aload 16
    //   97: astore 8
    //   99: aload 7
    //   101: ifnull +14 -> 115
    //   104: iconst_0
    //   105: ifeq +24 -> 129
    //   108: aload 7
    //   110: invokeinterface 175 1 0
    //   115: aload 8
    //   117: areturn
    //   118: astore 9
    //   120: aconst_null
    //   121: aload 9
    //   123: invokevirtual 179	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   126: aload 8
    //   128: areturn
    //   129: aload 7
    //   131: invokeinterface 175 1 0
    //   136: aload 8
    //   138: areturn
    //   139: astore 13
    //   141: aload 13
    //   143: athrow
    //   144: astore 14
    //   146: aload 13
    //   148: astore 11
    //   150: aload 14
    //   152: astore 10
    //   154: aload 7
    //   156: ifnull +15 -> 171
    //   159: aload 11
    //   161: ifnull +25 -> 186
    //   164: aload 7
    //   166: invokeinterface 175 1 0
    //   171: aload 10
    //   173: athrow
    //   174: astore 12
    //   176: aload 11
    //   178: aload 12
    //   180: invokevirtual 179	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   183: goto -12 -> 171
    //   186: aload 7
    //   188: invokeinterface 175 1 0
    //   193: goto -22 -> 171
    //   196: astore 10
    //   198: aconst_null
    //   199: astore 11
    //   201: goto -47 -> 154
    //   204: aconst_null
    //   205: astore 8
    //   207: goto -108 -> 99
    //
    // Exception table:
    //   from	to	target	type
    //   108	115	118	java/lang/Throwable
    //   59	95	139	java/lang/Throwable
    //   141	144	144	finally
    //   164	171	174	java/lang/Throwable
    //   59	95	196	finally
  }

  public List<String> a(String paramString1, String paramString2)
  {
    Cursor localCursor = d().a("kvdata", b, "key=? AND value=?", new String[] { paramString1, paramString2 }, null, null, null);
    try
    {
      if (af.c(localCursor))
      {
        localArrayList = new ArrayList(localCursor.getCount());
        boolean bool;
        do
        {
          localArrayList.add(localCursor.getString(1));
          bool = localCursor.moveToNext();
        }
        while (bool);
        if ((localCursor == null) || (0 != 0));
        while (true)
        {
          try
          {
            localCursor.close();
            if (localArrayList == null)
              localArrayList = new ArrayList(0);
            return localArrayList;
          }
          catch (Throwable localThrowable4)
          {
            null.addSuppressed(localThrowable4);
            continue;
          }
          localCursor.close();
        }
      }
    }
    catch (Throwable localThrowable3)
    {
      Object localObject1;
      try
      {
        throw localThrowable3;
      }
      finally
      {
        localThrowable1 = localThrowable3;
      }
      if ((localCursor == null) || (localThrowable1 != null));
      while (true)
      {
        try
        {
          localCursor.close();
          throw localObject1;
        }
        catch (Throwable localThrowable2)
        {
          localThrowable1.addSuppressed(localThrowable2);
          continue;
        }
        localCursor.close();
      }
    }
    finally
    {
      while (true)
      {
        Throwable localThrowable1 = null;
        continue;
        ArrayList localArrayList = null;
      }
    }
  }

  public List<String> a(String paramString, boolean paramBoolean)
  {
    return a(paramString, String.valueOf(paramBoolean));
  }

  public Set<String> a(String paramString)
  {
    Cursor localCursor = d().a("kvdata", new String[] { "key" }, "category=?", new String[] { paramString }, null, null, null);
    if (localCursor != null);
    while (true)
    {
      try
      {
        if (localCursor.moveToFirst())
        {
          localHashSet = new HashSet(localCursor.getCount());
          localHashSet.add(localCursor.getString(0));
          boolean bool = localCursor.moveToNext();
          if (bool)
            continue;
          if ((localCursor == null) || (0 != 0))
            try
            {
              localCursor.close();
              if (localHashSet == null)
                localHashSet = new HashSet(0);
              return localHashSet;
            }
            catch (Throwable localThrowable1)
            {
              null.addSuppressed(localThrowable1);
              continue;
            }
          localCursor.close();
          continue;
        }
      }
      catch (Throwable localThrowable4)
      {
        Object localObject1;
        try
        {
          throw localThrowable4;
        }
        finally
        {
          localThrowable2 = localThrowable4;
        }
        if ((localCursor == null) || (localThrowable2 != null))
          try
          {
            localCursor.close();
            throw localObject1;
          }
          catch (Throwable localThrowable3)
          {
            localThrowable2.addSuppressed(localThrowable3);
            continue;
          }
        localCursor.close();
        continue;
      }
      finally
      {
        Throwable localThrowable2 = null;
        continue;
      }
      HashSet localHashSet = null;
    }
  }

  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    synchronized (this.c)
    {
      SQLiteStatement localSQLiteStatement = e();
      localSQLiteStatement.bindString(1, paramString1);
      localSQLiteStatement.bindString(2, paramString2);
      if (paramString3 == null)
      {
        localSQLiteStatement.bindNull(3);
        localSQLiteStatement.bindLong(4, paramInt);
        localSQLiteStatement.executeInsert();
        return;
      }
      localSQLiteStatement.bindString(3, paramString3);
    }
  }

  public int b()
  {
    return d().a("kvdata", null, null);
  }

  public Set<d.a> b(String paramString)
  {
    Cursor localCursor = d().a("kvdata", new String[] { "key", "value", "value_type" }, "category=?", new String[] { paramString }, null, null, null);
    if (localCursor != null);
    while (true)
    {
      try
      {
        if (localCursor.moveToFirst())
        {
          localHashSet = new HashSet(localCursor.getCount());
          String str1 = localCursor.getString(0);
          String str2 = localCursor.getString(1);
          int i = localCursor.getInt(2);
          Object localObject4;
          if (str2 != null)
          {
            localObject4 = a(i, str2);
            localHashSet.add(new d.a(paramString, str1, localObject4, i));
            boolean bool = localCursor.moveToNext();
            if (bool)
              continue;
            if ((localCursor != null) && (0 == 0))
              continue;
          }
          try
          {
            localCursor.close();
            if (localHashSet == null)
              localHashSet = new HashSet(0);
            return localHashSet;
            localObject4 = null;
          }
          catch (Throwable localThrowable1)
          {
            null.addSuppressed(localThrowable1);
            continue;
          }
          localCursor.close();
          continue;
        }
      }
      catch (Throwable localThrowable4)
      {
        Object localObject1;
        try
        {
          throw localThrowable4;
        }
        finally
        {
          localThrowable2 = localThrowable4;
        }
        if ((localCursor == null) || (localThrowable2 != null))
          try
          {
            localCursor.close();
            throw localObject1;
          }
          catch (Throwable localThrowable3)
          {
            localThrowable2.addSuppressed(localThrowable3);
            continue;
          }
        localCursor.close();
        continue;
      }
      finally
      {
        Throwable localThrowable2 = null;
        continue;
      }
      HashSet localHashSet = null;
    }
  }

  protected void b(List<d.a> paramList)
  {
    b localb = d();
    synchronized (this.c)
    {
      localb.a();
      try
      {
        super.b(paramList);
        localb.c();
        localb.b();
        return;
      }
      finally
      {
        localObject3 = finally;
        localb.b();
        throw localObject3;
      }
    }
  }

  public int c(String paramString)
  {
    return d().a("kvdata", "category=?", new String[] { paramString });
  }

  public List<d.a> d(String paramString)
  {
    Cursor localCursor = d().a("kvdata", b, "category like('" + paramString + "%')", null, null, null, null);
    if (localCursor != null);
    try
    {
      ArrayList localArrayList2;
      Object localObject4;
      if (localCursor.moveToFirst())
      {
        localArrayList2 = new ArrayList(localCursor.getCount());
        boolean bool;
        do
        {
          String str1 = localCursor.getString(1);
          String str2 = localCursor.getString(2);
          String str3 = localCursor.getString(3);
          int i = localCursor.getInt(4);
          if (str3 == null)
            break;
          localObject4 = a(i, str3);
          localArrayList2.add(new d.a(str1, str2, localObject4, i));
          bool = localCursor.moveToNext();
        }
        while (bool);
        if ((localCursor != null) && (0 == 0));
      }
      do
      {
        while (true)
        {
          try
          {
            localCursor.close();
            localArrayList1 = localArrayList2;
            return localArrayList1;
            localObject4 = null;
          }
          catch (Throwable localThrowable5)
          {
            null.addSuppressed(localThrowable5);
            continue;
          }
          localCursor.close();
        }
        ArrayList localArrayList1 = null;
      }
      while (localCursor == null);
      if (0 != 0)
        try
        {
          localCursor.close();
          return null;
        }
        catch (Throwable localThrowable1)
        {
          null.addSuppressed(localThrowable1);
          return null;
        }
      localCursor.close();
      return null;
    }
    catch (Throwable localThrowable4)
    {
      Object localObject1;
      try
      {
        throw localThrowable4;
      }
      finally
      {
        localThrowable2 = localThrowable4;
      }
      if ((localCursor == null) || (localThrowable2 != null));
      while (true)
      {
        try
        {
          localCursor.close();
          throw localObject1;
        }
        catch (Throwable localThrowable3)
        {
          localThrowable2.addSuppressed(localThrowable3);
          continue;
        }
        localCursor.close();
      }
    }
    finally
    {
      while (true)
        Throwable localThrowable2 = null;
    }
  }

  protected void d(List<d.a> paramList)
  {
    b localb = d();
    synchronized (this.c)
    {
      localb.a();
      try
      {
        super.d(paramList);
        localb.c();
        localb.b();
        return;
      }
      finally
      {
        localObject3 = finally;
        localb.b();
        throw localObject3;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.a.f
 * JD-Core Version:    0.6.2
 */