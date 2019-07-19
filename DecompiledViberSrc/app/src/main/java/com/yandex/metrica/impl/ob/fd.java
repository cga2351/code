package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

public abstract class fd
{
  private final fi a;
  private final fy b;
  private final AtomicLong c;
  private final AtomicLong d;
  private final AtomicLong e;
  private final ContentValues f = new ContentValues();

  fd(fi paramfi, fy paramfy)
  {
    this.a = paramfi;
    this.b = paramfy;
    this.c = new AtomicLong(f());
    this.d = new AtomicLong(b(9223372036854775807L));
    this.e = new AtomicLong(d(-1L));
  }

  private long f()
  {
    try
    {
      long l = nw.a(d().getReadableDatabase(), e());
      return l;
    }
    catch (Exception localException)
    {
    }
    return 0L;
  }

  public long a()
  {
    return this.c.get();
  }

  void a(int paramInt)
  {
    this.c.getAndAdd(-paramInt);
    this.d.set(b(9223372036854775807L));
  }

  void a(long paramLong)
  {
    this.c.incrementAndGet();
    this.e.incrementAndGet();
    e(this.e.get()).i();
    if (this.d.get() > paramLong)
      this.d.set(paramLong);
  }

  // ERROR //
  public void a(long paramLong, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 56	com/yandex/metrica/impl/ob/fd:d	()Lcom/yandex/metrica/impl/ob/fi;
    //   6: invokevirtual 95	com/yandex/metrica/impl/ob/fi:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore 6
    //   11: aload_0
    //   12: getfield 24	com/yandex/metrica/impl/ob/fd:f	Landroid/content/ContentValues;
    //   15: invokevirtual 98	android/content/ContentValues:clear	()V
    //   18: aload_0
    //   19: getfield 24	com/yandex/metrica/impl/ob/fd:f	Landroid/content/ContentValues;
    //   22: ldc 100
    //   24: lconst_1
    //   25: aload_0
    //   26: getfield 51	com/yandex/metrica/impl/ob/fd:e	Ljava/util/concurrent/atomic/AtomicLong;
    //   29: invokevirtual 73	java/util/concurrent/atomic/AtomicLong:get	()J
    //   32: ladd
    //   33: invokestatic 106	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   36: invokevirtual 110	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   39: aload_0
    //   40: getfield 24	com/yandex/metrica/impl/ob/fd:f	Landroid/content/ContentValues;
    //   43: ldc 112
    //   45: lload_1
    //   46: invokestatic 106	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   49: invokevirtual 110	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   52: aload_0
    //   53: getfield 24	com/yandex/metrica/impl/ob/fd:f	Landroid/content/ContentValues;
    //   56: ldc 114
    //   58: aload_3
    //   59: invokevirtual 117	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: aload_0
    //   63: getfield 24	com/yandex/metrica/impl/ob/fd:f	Landroid/content/ContentValues;
    //   66: astore 7
    //   68: aload 6
    //   70: aload_0
    //   71: invokevirtual 65	com/yandex/metrica/impl/ob/fd:e	()Ljava/lang/String;
    //   74: aconst_null
    //   75: aload 7
    //   77: invokevirtual 123	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   80: ldc2_w 46
    //   83: lcmp
    //   84: ifeq +8 -> 92
    //   87: aload_0
    //   88: lload_1
    //   89: invokevirtual 125	com/yandex/metrica/impl/ob/fd:a	(J)V
    //   92: aload_0
    //   93: monitorexit
    //   94: return
    //   95: astore 5
    //   97: aload_0
    //   98: monitorexit
    //   99: aload 5
    //   101: athrow
    //   102: astore 4
    //   104: goto -12 -> 92
    //
    // Exception table:
    //   from	to	target	type
    //   2	92	95	finally
    //   2	92	102	java/lang/Exception
  }

  public long b()
  {
    return this.d.get();
  }

  // ERROR //
  public long b(long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 131	java/util/Locale:US	Ljava/util/Locale;
    //   5: astore 4
    //   7: iconst_2
    //   8: anewarray 4	java/lang/Object
    //   11: astore 5
    //   13: aload 5
    //   15: iconst_0
    //   16: ldc 112
    //   18: aastore
    //   19: aload 5
    //   21: iconst_1
    //   22: aload_0
    //   23: invokevirtual 65	com/yandex/metrica/impl/ob/fd:e	()Ljava/lang/String;
    //   26: aastore
    //   27: aload 4
    //   29: ldc 133
    //   31: aload 5
    //   33: invokestatic 139	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   36: astore 6
    //   38: aload_0
    //   39: invokevirtual 56	com/yandex/metrica/impl/ob/fd:d	()Lcom/yandex/metrica/impl/ob/fi;
    //   42: invokevirtual 62	com/yandex/metrica/impl/ob/fi:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   45: aload 6
    //   47: aconst_null
    //   48: invokevirtual 143	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   51: astore 11
    //   53: aload 11
    //   55: astore 8
    //   57: aload 8
    //   59: invokeinterface 149 1 0
    //   64: ifeq +23 -> 87
    //   67: aload 8
    //   69: iconst_0
    //   70: invokeinterface 153 2 0
    //   75: lstore 13
    //   77: lload 13
    //   79: lconst_0
    //   80: lcmp
    //   81: ifeq +6 -> 87
    //   84: lload 13
    //   86: lstore_1
    //   87: aload 8
    //   89: invokestatic 158	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   92: lload_1
    //   93: lreturn
    //   94: astore 10
    //   96: aload_3
    //   97: invokestatic 158	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   100: lload_1
    //   101: lreturn
    //   102: astore 7
    //   104: aconst_null
    //   105: astore 8
    //   107: aload 7
    //   109: astore 9
    //   111: aload 8
    //   113: invokestatic 158	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   116: aload 9
    //   118: athrow
    //   119: astore 9
    //   121: goto -10 -> 111
    //   124: astore 12
    //   126: aload 8
    //   128: astore_3
    //   129: goto -33 -> 96
    //
    // Exception table:
    //   from	to	target	type
    //   38	53	94	java/lang/Exception
    //   38	53	102	finally
    //   57	77	119	finally
    //   57	77	124	java/lang/Exception
  }

  // ERROR //
  public java.util.Map<java.lang.Long, String> b(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: new 161	java/util/LinkedHashMap
    //   7: dup
    //   8: invokespecial 162	java/util/LinkedHashMap:<init>	()V
    //   11: astore_3
    //   12: aload_0
    //   13: invokevirtual 56	com/yandex/metrica/impl/ob/fd:d	()Lcom/yandex/metrica/impl/ob/fi;
    //   16: invokevirtual 62	com/yandex/metrica/impl/ob/fi:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   19: aload_0
    //   20: invokevirtual 65	com/yandex/metrica/impl/ob/fd:e	()Ljava/lang/String;
    //   23: iconst_2
    //   24: anewarray 135	java/lang/String
    //   27: dup
    //   28: iconst_0
    //   29: ldc 100
    //   31: aastore
    //   32: dup
    //   33: iconst_1
    //   34: ldc 114
    //   36: aastore
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: aconst_null
    //   41: ldc 164
    //   43: iload_1
    //   44: invokestatic 167	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   47: invokevirtual 171	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   50: astore 8
    //   52: aload 8
    //   54: astore 5
    //   56: aload 5
    //   58: invokeinterface 174 1 0
    //   63: ifeq +58 -> 121
    //   66: aload_0
    //   67: getfield 24	com/yandex/metrica/impl/ob/fd:f	Landroid/content/ContentValues;
    //   70: invokevirtual 98	android/content/ContentValues:clear	()V
    //   73: aload 5
    //   75: aload_0
    //   76: getfield 24	com/yandex/metrica/impl/ob/fd:f	Landroid/content/ContentValues;
    //   79: invokestatic 177	com/yandex/metrica/impl/ob/nw:a	(Landroid/database/Cursor;Landroid/content/ContentValues;)V
    //   82: aload_3
    //   83: aload_0
    //   84: getfield 24	com/yandex/metrica/impl/ob/fd:f	Landroid/content/ContentValues;
    //   87: ldc 100
    //   89: invokevirtual 181	android/content/ContentValues:getAsLong	(Ljava/lang/String;)Ljava/lang/Long;
    //   92: aload_0
    //   93: getfield 24	com/yandex/metrica/impl/ob/fd:f	Landroid/content/ContentValues;
    //   96: ldc 114
    //   98: invokevirtual 185	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   101: invokeinterface 190 3 0
    //   106: pop
    //   107: goto -51 -> 56
    //   110: astore 10
    //   112: aload 5
    //   114: invokestatic 158	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   117: aload_0
    //   118: monitorexit
    //   119: aload_3
    //   120: areturn
    //   121: aload 5
    //   123: invokestatic 158	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   126: goto -9 -> 117
    //   129: astore 6
    //   131: aload_0
    //   132: monitorexit
    //   133: aload 6
    //   135: athrow
    //   136: astore 7
    //   138: aload_2
    //   139: invokestatic 158	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   142: aload 7
    //   144: athrow
    //   145: astore 9
    //   147: aload 5
    //   149: astore_2
    //   150: aload 9
    //   152: astore 7
    //   154: goto -16 -> 138
    //   157: astore 4
    //   159: aconst_null
    //   160: astore 5
    //   162: goto -50 -> 112
    //
    // Exception table:
    //   from	to	target	type
    //   56	107	110	java/lang/Exception
    //   4	12	129	finally
    //   112	117	129	finally
    //   121	126	129	finally
    //   138	145	129	finally
    //   12	52	136	finally
    //   56	107	145	finally
    //   12	52	157	java/lang/Exception
  }

  public int c(int paramInt)
  {
    int i = 0;
    if (paramInt <= 0);
    while (true)
    {
      return i;
      try
      {
        Locale localLocale = Locale.US;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = "incremental_id";
        arrayOfObject[1] = e();
        String str1 = String.format(localLocale, "%1$s <= (select max(%1$s) from (select %1$s from %2$s order by %1$s limit ?))", arrayOfObject);
        try
        {
          SQLiteDatabase localSQLiteDatabase = d().getWritableDatabase();
          String str2 = e();
          String[] arrayOfString = new String[1];
          arrayOfString[0] = String.valueOf(paramInt);
          i = localSQLiteDatabase.delete(str2, str1, arrayOfString);
          if (i <= 0)
            continue;
          a(i);
        }
        catch (Exception localException)
        {
        }
      }
      finally
      {
      }
    }
  }

  // ERROR //
  public int c(long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: getstatic 131	java/util/Locale:US	Ljava/util/Locale;
    //   7: ldc 202
    //   9: iconst_1
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: ldc 100
    //   17: aastore
    //   18: invokestatic 139	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   21: astore 5
    //   23: aload_0
    //   24: invokevirtual 56	com/yandex/metrica/impl/ob/fd:d	()Lcom/yandex/metrica/impl/ob/fi;
    //   27: invokevirtual 95	com/yandex/metrica/impl/ob/fi:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   30: astore 7
    //   32: aload_0
    //   33: invokevirtual 65	com/yandex/metrica/impl/ob/fd:e	()Ljava/lang/String;
    //   36: astore 8
    //   38: iconst_1
    //   39: anewarray 135	java/lang/String
    //   42: astore 9
    //   44: aload 9
    //   46: iconst_0
    //   47: lload_1
    //   48: invokestatic 205	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   51: aastore
    //   52: aload 7
    //   54: aload 8
    //   56: aload 5
    //   58: aload 9
    //   60: invokevirtual 197	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   63: istore_3
    //   64: iload_3
    //   65: ifle +8 -> 73
    //   68: aload_0
    //   69: iload_3
    //   70: invokevirtual 199	com/yandex/metrica/impl/ob/fd:a	(I)V
    //   73: aload_0
    //   74: monitorexit
    //   75: iload_3
    //   76: ireturn
    //   77: astore 4
    //   79: aload_0
    //   80: monitorexit
    //   81: aload 4
    //   83: athrow
    //   84: astore 6
    //   86: goto -13 -> 73
    //
    // Exception table:
    //   from	to	target	type
    //   4	23	77	finally
    //   23	64	77	finally
    //   68	73	77	finally
    //   23	64	84	java/lang/Exception
    //   68	73	84	java/lang/Exception
  }

  fy c()
  {
    return this.b;
  }

  protected abstract long d(long paramLong);

  protected fi d()
  {
    return this.a;
  }

  protected abstract fy e(long paramLong);

  public abstract String e();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.fd
 * JD-Core Version:    0.6.2
 */