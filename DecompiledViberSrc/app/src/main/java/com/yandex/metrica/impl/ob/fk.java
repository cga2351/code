package com.yandex.metrica.impl.ob;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class fk
{
  private final Map<String, Object> a = new HashMap();
  private final Map<String, Object> b = new HashMap();
  private final String c;
  private final a d;
  private volatile boolean e;
  private final fr f;

  static
  {
    fk.class.getSimpleName();
  }

  public fk(fi paramfi, String paramString)
  {
    this(paramString, new ft(paramfi));
  }

  protected fk(String paramString, fr paramfr)
  {
    this.f = paramfr;
    this.c = paramString;
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(od.b());
    this.d = new a(String.format(localLocale, "YMM-DW-%s", arrayOfObject));
    this.d.start();
  }

  // ERROR //
  private void a(android.content.ContentValues[] paramArrayOfContentValues)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: aload_1
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: aload_0
    //   10: getfield 45	com/yandex/metrica/impl/ob/fk:f	Lcom/yandex/metrica/impl/ob/fr;
    //   13: invokeinterface 168 1 0
    //   18: astore 8
    //   20: aload 8
    //   22: astore_2
    //   23: aload_2
    //   24: invokevirtual 173	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   27: aload_1
    //   28: arraylength
    //   29: istore 10
    //   31: iload_3
    //   32: iload 10
    //   34: if_icmpge +83 -> 117
    //   37: aload_1
    //   38: iload_3
    //   39: aaload
    //   40: astore 11
    //   42: aload 11
    //   44: ldc 128
    //   46: invokevirtual 177	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   49: ifnonnull +35 -> 84
    //   52: aload 11
    //   54: ldc 122
    //   56: invokevirtual 177	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   59: astore 14
    //   61: aload_2
    //   62: aload_0
    //   63: invokevirtual 179	com/yandex/metrica/impl/ob/fk:a	()Ljava/lang/String;
    //   66: ldc 181
    //   68: iconst_1
    //   69: anewarray 70	java/lang/String
    //   72: dup
    //   73: iconst_0
    //   74: aload 14
    //   76: aastore
    //   77: invokevirtual 185	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   80: pop
    //   81: goto +95 -> 176
    //   84: aload_2
    //   85: aload_0
    //   86: invokevirtual 179	com/yandex/metrica/impl/ob/fk:a	()Ljava/lang/String;
    //   89: aconst_null
    //   90: aload 11
    //   92: iconst_5
    //   93: invokevirtual 189	android/database/sqlite/SQLiteDatabase:insertWithOnConflict	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    //   96: pop2
    //   97: goto +79 -> 176
    //   100: astore 7
    //   102: aload_2
    //   103: invokestatic 194	com/yandex/metrica/impl/bw:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   106: aload_0
    //   107: getfield 45	com/yandex/metrica/impl/ob/fk:f	Lcom/yandex/metrica/impl/ob/fr;
    //   110: aload_2
    //   111: invokeinterface 195 2 0
    //   116: return
    //   117: aload_2
    //   118: invokevirtual 198	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   121: aload_2
    //   122: invokestatic 194	com/yandex/metrica/impl/bw:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   125: aload_0
    //   126: getfield 45	com/yandex/metrica/impl/ob/fk:f	Lcom/yandex/metrica/impl/ob/fr;
    //   129: aload_2
    //   130: invokeinterface 195 2 0
    //   135: return
    //   136: astore 4
    //   138: aconst_null
    //   139: astore 5
    //   141: aload 4
    //   143: astore 6
    //   145: aload 5
    //   147: invokestatic 194	com/yandex/metrica/impl/bw:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   150: aload_0
    //   151: getfield 45	com/yandex/metrica/impl/ob/fk:f	Lcom/yandex/metrica/impl/ob/fr;
    //   154: aload 5
    //   156: invokeinterface 195 2 0
    //   161: aload 6
    //   163: athrow
    //   164: astore 9
    //   166: aload_2
    //   167: astore 5
    //   169: aload 9
    //   171: astore 6
    //   173: goto -28 -> 145
    //   176: iinc 3 1
    //   179: goto -148 -> 31
    //
    // Exception table:
    //   from	to	target	type
    //   9	20	100	java/lang/Exception
    //   23	31	100	java/lang/Exception
    //   37	81	100	java/lang/Exception
    //   84	97	100	java/lang/Exception
    //   117	121	100	java/lang/Exception
    //   9	20	136	finally
    //   23	31	164	finally
    //   37	81	164	finally
    //   84	97	164	finally
    //   117	121	164	finally
  }

  private Object c(String paramString)
  {
    synchronized (this.a)
    {
      c();
      Object localObject2 = this.a.get(paramString);
      return localObject2;
    }
  }

  private void c()
  {
    if (!this.e);
    try
    {
      this.a.wait();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
  }

  public int a(String paramString, int paramInt)
  {
    Object localObject = c(paramString);
    if ((localObject instanceof Integer))
      paramInt = ((Integer)localObject).intValue();
    return paramInt;
  }

  public long a(String paramString, long paramLong)
  {
    Object localObject = c(paramString);
    if ((localObject instanceof Long))
      paramLong = ((Long)localObject).longValue();
    return paramLong;
  }

  public fk a(String paramString)
  {
    synchronized (this.a)
    {
      c();
      this.a.remove(paramString);
    }
    synchronized (this.d)
    {
      this.b.put(paramString, this);
      this.d.notifyAll();
      return this;
      localObject1 = finally;
      throw localObject1;
    }
  }

  String a()
  {
    return this.c;
  }

  public String a(String paramString1, String paramString2)
  {
    Object localObject = c(paramString1);
    if ((localObject instanceof String))
      return (String)localObject;
    return paramString2;
  }

  void a(String paramString, Object paramObject)
  {
    synchronized (this.a)
    {
      c();
      this.a.put(paramString, paramObject);
    }
    synchronized (this.d)
    {
      this.b.put(paramString, paramObject);
      this.d.notifyAll();
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }

  public boolean a(String paramString, boolean paramBoolean)
  {
    Object localObject = c(paramString);
    if ((localObject instanceof Boolean))
      paramBoolean = ((Boolean)localObject).booleanValue();
    return paramBoolean;
  }

  public fk b(String paramString, int paramInt)
  {
    try
    {
      a(paramString, Integer.valueOf(paramInt));
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public fk b(String paramString, long paramLong)
  {
    a(paramString, Long.valueOf(paramLong));
    return this;
  }

  public fk b(String paramString1, String paramString2)
  {
    try
    {
      a(paramString1, paramString2);
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public fk b(String paramString, boolean paramBoolean)
  {
    a(paramString, Boolean.valueOf(paramBoolean));
    return this;
  }

  public void b()
  {
    synchronized (this.d)
    {
      this.d.notifyAll();
      return;
    }
  }

  public boolean b(String paramString)
  {
    synchronized (this.a)
    {
      c();
      boolean bool = this.a.containsKey(paramString);
      return bool;
    }
  }

  private class a extends Thread
  {
    public a(String arg2)
    {
      super();
    }

    public void run()
    {
      while (true)
      {
        synchronized (fk.a(fk.this))
        {
          fk.b(fk.this);
          fk.a(fk.this, true);
          fk.a(fk.this).notifyAll();
          if (isInterrupted())
            break;
        }
        try
        {
          int i = fk.c(fk.this).size();
          if (i == 0);
          try
          {
            wait();
            HashMap localHashMap = new HashMap(fk.c(fk.this));
            fk.c(fk.this).clear();
            if (localHashMap.size() > 0)
            {
              fk.a(fk.this, localHashMap);
              localHashMap.clear();
              continue;
              localObject1 = finally;
              throw localObject1;
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            while (true)
              interrupt();
          }
        }
        finally
        {
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.fk
 * JD-Core Version:    0.6.2
 */