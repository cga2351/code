package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.yandex.metrica.c;
import com.yandex.metrica.impl.b.a;
import com.yandex.metrica.impl.bu;
import com.yandex.metrica.impl.bw;
import com.yandex.metrica.impl.l;
import com.yandex.metrica.impl.s;
import com.yandex.metrica.impl.s.a;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class fh
  implements Closeable
{
  private final ReentrantReadWriteLock a = new ReentrantReadWriteLock();
  private final Lock b = this.a.readLock();
  private final Lock c = this.a.writeLock();
  private final fi d;
  private final a e;
  private final Object f = new Object();
  private final List<ContentValues> g = new ArrayList(3);
  private final Context h;
  private final ab i;
  private final AtomicLong j = new AtomicLong();

  public fh(ab paramab, fi paramfi)
  {
    this.d = paramfi;
    this.h = paramab.c();
    this.i = paramab;
    this.j.set(b());
    this.e = new a();
    this.e.setName("DatabaseWorker [" + paramab.b() + "]");
    this.e.start();
    c();
  }

  private Cursor a(String paramString)
  {
    try
    {
      Cursor localCursor = this.d.getReadableDatabase().query("reports", null, paramString, null, null, null, null, null);
      return localCursor;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private static String a(String paramString, Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    Iterator localIterator = paramMap.keySet().iterator();
    if (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (localStringBuilder.length() > 0);
      for (String str2 = " AND "; ; str2 = "")
      {
        localStringBuilder.append(str2);
        localStringBuilder.append(str1 + " = ? ");
        break;
      }
    }
    if (TextUtils.isEmpty(localStringBuilder.toString()))
      return null;
    return localStringBuilder.toString();
  }

  private void a(ContentValues paramContentValues, String paramString)
  {
    Integer localInteger = paramContentValues.getAsInteger("type");
    if (localInteger != null);
    for (int k = localInteger.intValue(); ; k = -1)
    {
      if (s.b(k))
      {
        StringBuilder localStringBuilder = new StringBuilder(paramString);
        localStringBuilder.append(": ");
        localStringBuilder.append(b(paramContentValues, "name"));
        String str = b(paramContentValues, "value");
        if ((s.c(paramContentValues.getAsInteger("type").intValue())) && (!TextUtils.isEmpty(str)))
        {
          localStringBuilder.append(" with value ");
          localStringBuilder.append(str);
        }
        this.i.o().a(localStringBuilder.toString());
      }
      return;
    }
  }

  private void a(List<ContentValues> paramList, String paramString)
  {
    for (int k = 0; k < paramList.size(); k++)
      a((ContentValues)paramList.get(k), paramString);
  }

  private static String[] a(String[] paramArrayOfString, Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(Arrays.asList(paramArrayOfString));
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }

  // ERROR //
  private long b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/yandex/metrica/impl/ob/fh:b	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 229 1 0
    //   9: aload_0
    //   10: getfield 64	com/yandex/metrica/impl/ob/fh:d	Lcom/yandex/metrica/impl/ob/fi;
    //   13: invokevirtual 129	com/yandex/metrica/impl/ob/fi:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   16: ldc 131
    //   18: invokestatic 308	com/yandex/metrica/impl/ob/nw:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)J
    //   21: lstore_3
    //   22: aload_0
    //   23: getfield 42	com/yandex/metrica/impl/ob/fh:b	Ljava/util/concurrent/locks/Lock;
    //   26: invokeinterface 257 1 0
    //   31: lload_3
    //   32: lreturn
    //   33: astore_2
    //   34: aload_0
    //   35: getfield 42	com/yandex/metrica/impl/ob/fh:b	Ljava/util/concurrent/locks/Lock;
    //   38: invokeinterface 257 1 0
    //   43: lconst_0
    //   44: lreturn
    //   45: astore_1
    //   46: aload_0
    //   47: getfield 42	com/yandex/metrica/impl/ob/fh:b	Ljava/util/concurrent/locks/Lock;
    //   50: invokeinterface 257 1 0
    //   55: aload_1
    //   56: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   9	22	33	java/lang/Exception
    //   9	22	45	finally
  }

  private static String b(ContentValues paramContentValues, String paramString)
  {
    return bu.b(paramContentValues.getAsString(paramString), "");
  }

  // ERROR //
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 48	com/yandex/metrica/impl/ob/fh:c	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 229 1 0
    //   9: aload_0
    //   10: getfield 64	com/yandex/metrica/impl/ob/fh:d	Lcom/yandex/metrica/impl/ob/fi;
    //   13: invokevirtual 232	com/yandex/metrica/impl/ob/fi:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore_3
    //   17: new 321	java/io/File
    //   20: dup
    //   21: aload_3
    //   22: invokevirtual 324	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   25: invokespecial 325	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: invokevirtual 327	java/io/File:length	()J
    //   31: ldc2_w 328
    //   34: lcmp
    //   35: ifle +22 -> 57
    //   38: aload_0
    //   39: aload_3
    //   40: invokevirtual 332	com/yandex/metrica/impl/ob/fh:a	(Landroid/database/sqlite/SQLiteDatabase;)I
    //   43: istore 4
    //   45: aload_0
    //   46: getfield 62	com/yandex/metrica/impl/ob/fh:j	Ljava/util/concurrent/atomic/AtomicLong;
    //   49: iload 4
    //   51: ineg
    //   52: i2l
    //   53: invokevirtual 336	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
    //   56: pop2
    //   57: aload_0
    //   58: getfield 48	com/yandex/metrica/impl/ob/fh:c	Ljava/util/concurrent/locks/Lock;
    //   61: invokeinterface 257 1 0
    //   66: return
    //   67: astore_2
    //   68: aload_0
    //   69: getfield 48	com/yandex/metrica/impl/ob/fh:c	Ljava/util/concurrent/locks/Lock;
    //   72: invokeinterface 257 1 0
    //   77: return
    //   78: astore_1
    //   79: aload_0
    //   80: getfield 48	com/yandex/metrica/impl/ob/fh:c	Ljava/util/concurrent/locks/Lock;
    //   83: invokeinterface 257 1 0
    //   88: aload_1
    //   89: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	57	67	java/lang/Exception
    //   0	57	78	finally
  }

  private boolean d()
  {
    synchronized (this.f)
    {
      boolean bool = this.g.isEmpty();
      return bool;
    }
  }

  final int a(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      Integer[] arrayOfInteger = new Integer[s.a.size()];
      Iterator localIterator = s.a.iterator();
      int n;
      for (int k = 0; localIterator.hasNext(); k = n)
      {
        s.a locala = (s.a)localIterator.next();
        n = k + 1;
        arrayOfInteger[k] = Integer.valueOf(locala.a());
      }
      long l = System.currentTimeMillis() / 1000L - TimeUnit.DAYS.toSeconds(14L);
      Object[] arrayOfObject = new Object[8];
      arrayOfObject[0] = "type";
      arrayOfObject[1] = TextUtils.join(",", arrayOfInteger);
      arrayOfObject[2] = "id";
      arrayOfObject[3] = "reports";
      arrayOfObject[4] = "session_id";
      arrayOfObject[5] = "number";
      arrayOfObject[6] = Integer.valueOf(10);
      arrayOfObject[7] = Long.valueOf(l);
      int m = paramSQLiteDatabase.delete("reports", String.format("%1$s NOT IN (%2$s) AND (%3$s IN (SELECT %3$s FROM %4$s ORDER BY %5$s, %6$s LIMIT (SELECT count() FROM %4$s) / %7$s ) OR %5$s < %8$s )", arrayOfObject), null);
      return m;
    }
    catch (Throwable localThrowable)
    {
      mi.a(this.h).reportError("deleteExcessiveReports exception", localThrowable);
    }
    return 0;
  }

  // ERROR //
  public int a(long[] paramArrayOfLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 48	com/yandex/metrica/impl/ob/fh:c	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 229 1 0
    //   11: getstatic 417	com/yandex/metrica/impl/ob/ff:a	Ljava/lang/Boolean;
    //   14: invokevirtual 422	java/lang/Boolean:booleanValue	()Z
    //   17: ifeq +110 -> 127
    //   20: aload_0
    //   21: getfield 42	com/yandex/metrica/impl/ob/fh:b	Ljava/util/concurrent/locks/Lock;
    //   24: invokeinterface 229 1 0
    //   29: aload_0
    //   30: getfield 64	com/yandex/metrica/impl/ob/fh:d	Lcom/yandex/metrica/impl/ob/fi;
    //   33: invokevirtual 129	com/yandex/metrica/impl/ob/fi:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   36: astore 12
    //   38: aload 12
    //   40: ldc_w 424
    //   43: iconst_0
    //   44: anewarray 162	java/lang/String
    //   47: invokevirtual 428	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   50: astore 13
    //   52: aload 13
    //   54: astore 7
    //   56: new 430	java/lang/StringBuffer
    //   59: dup
    //   60: invokespecial 431	java/lang/StringBuffer:<init>	()V
    //   63: astore 14
    //   65: aload 14
    //   67: ldc_w 433
    //   70: invokevirtual 436	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   73: pop
    //   74: aload 7
    //   76: invokeinterface 441 1 0
    //   81: ifeq +80 -> 161
    //   84: aload 14
    //   86: aload 7
    //   88: iconst_0
    //   89: invokeinterface 445 2 0
    //   94: invokevirtual 436	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   97: ldc_w 447
    //   100: invokevirtual 436	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   103: pop
    //   104: goto -30 -> 74
    //   107: astore 16
    //   109: aload_0
    //   110: getfield 42	com/yandex/metrica/impl/ob/fh:b	Ljava/util/concurrent/locks/Lock;
    //   113: invokeinterface 257 1 0
    //   118: aload 7
    //   120: invokestatic 450	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   123: aload_2
    //   124: invokestatic 450	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   127: aload_0
    //   128: getfield 64	com/yandex/metrica/impl/ob/fh:d	Lcom/yandex/metrica/impl/ob/fi;
    //   131: invokevirtual 232	com/yandex/metrica/impl/ob/fi:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   134: ldc_w 452
    //   137: getstatic 457	com/yandex/metrica/impl/ob/ff$ag:c	Ljava/lang/String;
    //   140: aload_1
    //   141: invokestatic 460	com/yandex/metrica/impl/bw:a	([J)[Ljava/lang/String;
    //   144: invokevirtual 398	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   147: istore 5
    //   149: aload_0
    //   150: getfield 48	com/yandex/metrica/impl/ob/fh:c	Ljava/util/concurrent/locks/Lock;
    //   153: invokeinterface 257 1 0
    //   158: iload 5
    //   160: ireturn
    //   161: aload 12
    //   163: ldc_w 462
    //   166: iconst_0
    //   167: anewarray 162	java/lang/String
    //   170: invokevirtual 428	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   173: astore 18
    //   175: aload 18
    //   177: astore_2
    //   178: new 430	java/lang/StringBuffer
    //   181: dup
    //   182: invokespecial 431	java/lang/StringBuffer:<init>	()V
    //   185: astore 19
    //   187: aload 19
    //   189: ldc_w 464
    //   192: invokevirtual 436	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   195: pop
    //   196: aload_2
    //   197: invokeinterface 441 1 0
    //   202: ifeq +73 -> 275
    //   205: aload 19
    //   207: aload_2
    //   208: iconst_0
    //   209: invokeinterface 445 2 0
    //   214: invokevirtual 436	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   217: ldc_w 447
    //   220: invokevirtual 436	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   223: pop
    //   224: goto -28 -> 196
    //   227: astore 20
    //   229: aload 7
    //   231: astore 11
    //   233: aload_2
    //   234: astore 10
    //   236: aload 20
    //   238: astore 9
    //   240: aload_0
    //   241: getfield 42	com/yandex/metrica/impl/ob/fh:b	Ljava/util/concurrent/locks/Lock;
    //   244: invokeinterface 257 1 0
    //   249: aload 11
    //   251: invokestatic 450	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   254: aload 10
    //   256: invokestatic 450	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   259: aload 9
    //   261: athrow
    //   262: astore 4
    //   264: aload_0
    //   265: getfield 48	com/yandex/metrica/impl/ob/fh:c	Ljava/util/concurrent/locks/Lock;
    //   268: invokeinterface 257 1 0
    //   273: iconst_0
    //   274: ireturn
    //   275: aload_0
    //   276: getfield 42	com/yandex/metrica/impl/ob/fh:b	Ljava/util/concurrent/locks/Lock;
    //   279: invokeinterface 257 1 0
    //   284: aload 7
    //   286: invokestatic 450	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   289: aload_2
    //   290: invokestatic 450	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   293: goto -166 -> 127
    //   296: astore_3
    //   297: aload_0
    //   298: getfield 48	com/yandex/metrica/impl/ob/fh:c	Ljava/util/concurrent/locks/Lock;
    //   301: invokeinterface 257 1 0
    //   306: aload_3
    //   307: athrow
    //   308: astore 8
    //   310: aload 8
    //   312: astore 9
    //   314: aconst_null
    //   315: astore 10
    //   317: aconst_null
    //   318: astore 11
    //   320: goto -80 -> 240
    //   323: astore 15
    //   325: aload 7
    //   327: astore 11
    //   329: aload 15
    //   331: astore 9
    //   333: aconst_null
    //   334: astore 10
    //   336: goto -96 -> 240
    //   339: astore 6
    //   341: aconst_null
    //   342: astore_2
    //   343: aconst_null
    //   344: astore 7
    //   346: goto -237 -> 109
    //
    // Exception table:
    //   from	to	target	type
    //   56	74	107	java/lang/Exception
    //   74	104	107	java/lang/Exception
    //   161	175	107	java/lang/Exception
    //   178	196	107	java/lang/Exception
    //   196	224	107	java/lang/Exception
    //   178	196	227	finally
    //   196	224	227	finally
    //   11	29	262	java/lang/Exception
    //   109	127	262	java/lang/Exception
    //   127	149	262	java/lang/Exception
    //   240	262	262	java/lang/Exception
    //   275	293	262	java/lang/Exception
    //   11	29	296	finally
    //   109	127	296	finally
    //   127	149	296	finally
    //   240	262	296	finally
    //   275	293	296	finally
    //   29	52	308	finally
    //   56	74	323	finally
    //   74	104	323	finally
    //   161	175	323	finally
    //   29	52	339	java/lang/Exception
  }

  public long a()
  {
    this.b.lock();
    try
    {
      long l = this.j.get();
      return l;
    }
    finally
    {
      this.b.unlock();
    }
  }

  // ERROR //
  public Cursor a(long paramLong, ek paramek)
    throws android.database.sqlite.SQLiteException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/yandex/metrica/impl/ob/fh:b	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 229 1 0
    //   9: aload_0
    //   10: getfield 64	com/yandex/metrica/impl/ob/fh:d	Lcom/yandex/metrica/impl/ob/fi;
    //   13: invokevirtual 129	com/yandex/metrica/impl/ob/fi:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore 6
    //   18: iconst_2
    //   19: anewarray 162	java/lang/String
    //   22: astore 7
    //   24: aload 7
    //   26: iconst_0
    //   27: lload_1
    //   28: invokestatic 470	java/lang/Long:toString	(J)Ljava/lang/String;
    //   31: aastore
    //   32: aload 7
    //   34: iconst_1
    //   35: aload_3
    //   36: invokevirtual 473	com/yandex/metrica/impl/ob/ek:a	()I
    //   39: invokestatic 475	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   42: aastore
    //   43: aload 6
    //   45: ldc 131
    //   47: aconst_null
    //   48: ldc_w 477
    //   51: aload 7
    //   53: aconst_null
    //   54: aconst_null
    //   55: ldc_w 479
    //   58: aconst_null
    //   59: invokevirtual 137	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   62: astore 8
    //   64: aload_0
    //   65: getfield 42	com/yandex/metrica/impl/ob/fh:b	Ljava/util/concurrent/locks/Lock;
    //   68: invokeinterface 257 1 0
    //   73: aload 8
    //   75: areturn
    //   76: astore 5
    //   78: aload_0
    //   79: getfield 42	com/yandex/metrica/impl/ob/fh:b	Ljava/util/concurrent/locks/Lock;
    //   82: invokeinterface 257 1 0
    //   87: aconst_null
    //   88: areturn
    //   89: astore 4
    //   91: aload_0
    //   92: getfield 42	com/yandex/metrica/impl/ob/fh:b	Ljava/util/concurrent/locks/Lock;
    //   95: invokeinterface 257 1 0
    //   100: aload 4
    //   102: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   9	64	76	java/lang/Exception
    //   9	64	89	finally
  }

  // ERROR //
  public Cursor a(long paramLong, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/yandex/metrica/impl/ob/fh:b	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 229 1 0
    //   9: aload_0
    //   10: getfield 64	com/yandex/metrica/impl/ob/fh:d	Lcom/yandex/metrica/impl/ob/fi;
    //   13: invokevirtual 129	com/yandex/metrica/impl/ob/fi:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore 6
    //   18: ldc_w 482
    //   21: aload_3
    //   22: invokestatic 484	com/yandex/metrica/impl/ob/fh:a	(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   25: astore 7
    //   27: iconst_1
    //   28: anewarray 162	java/lang/String
    //   31: astore 8
    //   33: aload 8
    //   35: iconst_0
    //   36: lload_1
    //   37: invokestatic 470	java/lang/Long:toString	(J)Ljava/lang/String;
    //   40: aastore
    //   41: aload 6
    //   43: ldc_w 452
    //   46: aconst_null
    //   47: aload 7
    //   49: aload 8
    //   51: aload_3
    //   52: invokestatic 486	com/yandex/metrica/impl/ob/fh:a	([Ljava/lang/String;Ljava/util/Map;)[Ljava/lang/String;
    //   55: aconst_null
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: invokevirtual 137	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   62: astore 9
    //   64: aload_0
    //   65: getfield 42	com/yandex/metrica/impl/ob/fh:b	Ljava/util/concurrent/locks/Lock;
    //   68: invokeinterface 257 1 0
    //   73: aload 9
    //   75: areturn
    //   76: astore 5
    //   78: aload_0
    //   79: getfield 42	com/yandex/metrica/impl/ob/fh:b	Ljava/util/concurrent/locks/Lock;
    //   82: invokeinterface 257 1 0
    //   87: aconst_null
    //   88: areturn
    //   89: astore 4
    //   91: aload_0
    //   92: getfield 42	com/yandex/metrica/impl/ob/fh:b	Ljava/util/concurrent/locks/Lock;
    //   95: invokeinterface 257 1 0
    //   100: aload 4
    //   102: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   9	64	76	java/lang/Exception
    //   9	64	89	finally
  }

  // ERROR //
  public Cursor a(Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/yandex/metrica/impl/ob/fh:b	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 229 1 0
    //   9: aload_0
    //   10: getfield 64	com/yandex/metrica/impl/ob/fh:d	Lcom/yandex/metrica/impl/ob/fi;
    //   13: invokevirtual 129	com/yandex/metrica/impl/ob/fi:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore 4
    //   18: ldc_w 489
    //   21: aload_1
    //   22: invokestatic 484	com/yandex/metrica/impl/ob/fh:a	(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   25: astore 5
    //   27: iconst_1
    //   28: anewarray 162	java/lang/String
    //   31: astore 6
    //   33: aload 6
    //   35: iconst_0
    //   36: lconst_0
    //   37: invokestatic 470	java/lang/Long:toString	(J)Ljava/lang/String;
    //   40: aastore
    //   41: aload 4
    //   43: ldc_w 452
    //   46: aconst_null
    //   47: aload 5
    //   49: aload 6
    //   51: aload_1
    //   52: invokestatic 486	com/yandex/metrica/impl/ob/fh:a	([Ljava/lang/String;Ljava/util/Map;)[Ljava/lang/String;
    //   55: aconst_null
    //   56: aconst_null
    //   57: ldc_w 491
    //   60: aconst_null
    //   61: invokevirtual 137	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   64: astore 7
    //   66: aload_0
    //   67: getfield 42	com/yandex/metrica/impl/ob/fh:b	Ljava/util/concurrent/locks/Lock;
    //   70: invokeinterface 257 1 0
    //   75: aload 7
    //   77: areturn
    //   78: astore_3
    //   79: aload_0
    //   80: getfield 42	com/yandex/metrica/impl/ob/fh:b	Ljava/util/concurrent/locks/Lock;
    //   83: invokeinterface 257 1 0
    //   88: aconst_null
    //   89: areturn
    //   90: astore_2
    //   91: aload_0
    //   92: getfield 42	com/yandex/metrica/impl/ob/fh:b	Ljava/util/concurrent/locks/Lock;
    //   95: invokeinterface 257 1 0
    //   100: aload_2
    //   101: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   9	66	78	java/lang/Exception
    //   9	66	90	finally
  }

  public List<ContentValues> a(Long paramLong)
  {
    Cursor localCursor = null;
    ArrayList localArrayList1 = new ArrayList();
    this.b.lock();
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.d.getReadableDatabase();
      String str = "SELECT DISTINCT report_request_parameters FROM sessions WHERE id >= 0 ORDER BY id";
      localCursor = null;
      if (paramLong != null)
        str = String.format(Locale.US, "SELECT DISTINCT report_request_parameters FROM sessions WHERE id = %s", new Object[] { paramLong });
      localCursor = localSQLiteDatabase.rawQuery(str, null);
      while (localCursor.moveToNext())
      {
        ContentValues localContentValues = new ContentValues();
        DatabaseUtils.cursorRowToContentValues(localCursor, localContentValues);
        localArrayList1.add(localContentValues);
      }
    }
    catch (Exception localException)
    {
      ArrayList localArrayList2 = new ArrayList();
      return localArrayList2;
      return localArrayList1;
    }
    finally
    {
      bw.a(localCursor);
      this.b.unlock();
    }
  }

  // ERROR //
  public void a(long paramLong, int paramInt1, int paramInt2)
    throws android.database.sqlite.SQLiteException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iload 4
    //   5: ifgt +4 -> 9
    //   8: return
    //   9: aload_0
    //   10: getfield 48	com/yandex/metrica/impl/ob/fh:c	Ljava/util/concurrent/locks/Lock;
    //   13: invokeinterface 229 1 0
    //   18: aload_0
    //   19: getfield 64	com/yandex/metrica/impl/ob/fh:d	Lcom/yandex/metrica/impl/ob/fi;
    //   22: invokevirtual 232	com/yandex/metrica/impl/ob/fi:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   25: astore 10
    //   27: getstatic 500	java/util/Locale:US	Ljava/util/Locale;
    //   30: astore 11
    //   32: bipush 7
    //   34: anewarray 4	java/lang/Object
    //   37: astore 12
    //   39: aload 12
    //   41: iconst_0
    //   42: ldc_w 381
    //   45: aastore
    //   46: aload 12
    //   48: iconst_1
    //   49: lload_1
    //   50: invokestatic 470	java/lang/Long:toString	(J)Ljava/lang/String;
    //   53: aastore
    //   54: aload 12
    //   56: iconst_2
    //   57: ldc_w 515
    //   60: aastore
    //   61: aload 12
    //   63: iconst_3
    //   64: iload_3
    //   65: invokestatic 475	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   68: aastore
    //   69: aload 12
    //   71: iconst_4
    //   72: ldc_w 379
    //   75: aastore
    //   76: aload 12
    //   78: iconst_5
    //   79: ldc 131
    //   81: aastore
    //   82: aload 12
    //   84: bipush 6
    //   86: iload 4
    //   88: iconst_1
    //   89: isub
    //   90: invokestatic 475	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   93: aastore
    //   94: aload 11
    //   96: ldc_w 517
    //   99: aload 12
    //   101: invokestatic 505	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   104: astore 13
    //   106: aload_0
    //   107: getfield 73	com/yandex/metrica/impl/ob/fh:i	Lcom/yandex/metrica/impl/ob/ab;
    //   110: invokevirtual 215	com/yandex/metrica/impl/ob/ab:o	()Lcom/yandex/metrica/impl/ob/of;
    //   113: invokevirtual 519	com/yandex/metrica/impl/ob/of:c	()Z
    //   116: istore 14
    //   118: aconst_null
    //   119: astore 5
    //   121: iload 14
    //   123: ifeq +230 -> 353
    //   126: aload_0
    //   127: aload 13
    //   129: invokespecial 521	com/yandex/metrica/impl/ob/fh:a	(Ljava/lang/String;)Landroid/database/Cursor;
    //   132: astore 15
    //   134: aload 15
    //   136: astore 8
    //   138: aconst_null
    //   139: astore 16
    //   141: aload 8
    //   143: ifnull +96 -> 239
    //   146: aload 8
    //   148: invokeinterface 524 1 0
    //   153: istore 24
    //   155: aconst_null
    //   156: astore 16
    //   158: iload 24
    //   160: ifle +79 -> 239
    //   163: new 52	java/util/ArrayList
    //   166: dup
    //   167: aload 8
    //   169: invokeinterface 524 1 0
    //   174: invokespecial 55	java/util/ArrayList:<init>	(I)V
    //   177: astore 16
    //   179: aload 8
    //   181: invokeinterface 441 1 0
    //   186: ifeq +53 -> 239
    //   189: new 184	android/content/ContentValues
    //   192: dup
    //   193: invokespecial 506	android/content/ContentValues:<init>	()V
    //   196: astore 25
    //   198: aload 8
    //   200: aload 25
    //   202: invokestatic 512	android/database/DatabaseUtils:cursorRowToContentValues	(Landroid/database/Cursor;Landroid/content/ContentValues;)V
    //   205: aload 16
    //   207: aload 25
    //   209: invokeinterface 297 2 0
    //   214: pop
    //   215: goto -36 -> 179
    //   218: astore 23
    //   220: aload 8
    //   222: astore 5
    //   224: aload 5
    //   226: invokestatic 450	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   229: aload_0
    //   230: getfield 48	com/yandex/metrica/impl/ob/fh:c	Ljava/util/concurrent/locks/Lock;
    //   233: invokeinterface 257 1 0
    //   238: return
    //   239: aload 16
    //   241: astore 17
    //   243: aload 8
    //   245: astore 5
    //   247: aload 17
    //   249: astore 18
    //   251: aload 10
    //   253: ldc 131
    //   255: aload 13
    //   257: aconst_null
    //   258: invokevirtual 398	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   261: istore 20
    //   263: aload 18
    //   265: ifnull +12 -> 277
    //   268: aload_0
    //   269: aload 18
    //   271: ldc_w 526
    //   274: invokespecial 528	com/yandex/metrica/impl/ob/fh:a	(Ljava/util/List;Ljava/lang/String;)V
    //   277: aload_0
    //   278: getfield 62	com/yandex/metrica/impl/ob/fh:j	Ljava/util/concurrent/atomic/AtomicLong;
    //   281: iload 20
    //   283: ineg
    //   284: i2l
    //   285: invokevirtual 336	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
    //   288: pop2
    //   289: aload 5
    //   291: invokestatic 450	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   294: aload_0
    //   295: getfield 48	com/yandex/metrica/impl/ob/fh:c	Ljava/util/concurrent/locks/Lock;
    //   298: invokeinterface 257 1 0
    //   303: return
    //   304: astore 7
    //   306: aconst_null
    //   307: astore 8
    //   309: aload 7
    //   311: astore 9
    //   313: aload 8
    //   315: invokestatic 450	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   318: aload_0
    //   319: getfield 48	com/yandex/metrica/impl/ob/fh:c	Ljava/util/concurrent/locks/Lock;
    //   322: invokeinterface 257 1 0
    //   327: aload 9
    //   329: athrow
    //   330: astore 9
    //   332: goto -19 -> 313
    //   335: astore 19
    //   337: aload 5
    //   339: astore 8
    //   341: aload 19
    //   343: astore 9
    //   345: goto -32 -> 313
    //   348: astore 6
    //   350: goto -126 -> 224
    //   353: aconst_null
    //   354: astore 5
    //   356: aconst_null
    //   357: astore 18
    //   359: goto -108 -> 251
    //
    // Exception table:
    //   from	to	target	type
    //   146	155	218	java/lang/Exception
    //   163	179	218	java/lang/Exception
    //   179	215	218	java/lang/Exception
    //   18	118	304	finally
    //   126	134	304	finally
    //   146	155	330	finally
    //   163	179	330	finally
    //   179	215	330	finally
    //   251	263	335	finally
    //   268	277	335	finally
    //   277	289	335	finally
    //   18	118	348	java/lang/Exception
    //   126	134	348	java/lang/Exception
    //   251	263	348	java/lang/Exception
    //   268	277	348	java/lang/Exception
    //   277	289	348	java/lang/Exception
  }

  public void a(long paramLong1, ek paramek, long paramLong2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("id", Long.valueOf(paramLong1));
    localContentValues.put("start_time", Long.valueOf(paramLong2));
    localContentValues.put("server_time_offset", Long.valueOf(oo.a()));
    localContentValues.put("obtained_before_first_sync", Boolean.valueOf(ok.a().d()));
    localContentValues.put("type", Integer.valueOf(paramek.a()));
    new l(this.h).a(this.i.l()).a(localContentValues).a();
    a(localContentValues);
  }

  // ERROR //
  public void a(ContentValues paramContentValues)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: getfield 48	com/yandex/metrica/impl/ob/fh:c	Ljava/util/concurrent/locks/Lock;
    //   9: invokeinterface 229 1 0
    //   14: aload_0
    //   15: getfield 64	com/yandex/metrica/impl/ob/fh:d	Lcom/yandex/metrica/impl/ob/fi;
    //   18: invokevirtual 232	com/yandex/metrica/impl/ob/fi:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   21: ldc_w 452
    //   24: aconst_null
    //   25: aload_1
    //   26: invokevirtual 245	android/database/sqlite/SQLiteDatabase:insertOrThrow	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   29: pop2
    //   30: aload_0
    //   31: getfield 48	com/yandex/metrica/impl/ob/fh:c	Ljava/util/concurrent/locks/Lock;
    //   34: invokeinterface 257 1 0
    //   39: return
    //   40: astore_3
    //   41: aload_0
    //   42: getfield 48	com/yandex/metrica/impl/ob/fh:c	Ljava/util/concurrent/locks/Lock;
    //   45: invokeinterface 257 1 0
    //   50: return
    //   51: astore_2
    //   52: aload_0
    //   53: getfield 48	com/yandex/metrica/impl/ob/fh:c	Ljava/util/concurrent/locks/Lock;
    //   56: invokeinterface 257 1 0
    //   61: aload_2
    //   62: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   14	30	40	java/lang/Exception
    //   14	30	51	finally
  }

  public void a(fg paramfg)
  {
    this.e.a(paramfg);
  }

  public void a(oy paramoy, eh parameh, b.a parama)
  {
    ContentValues localContentValues = new ContentValues(21);
    localContentValues.put("number", Long.valueOf(parameh.c()));
    localContentValues.put("time", Long.valueOf(parameh.d()));
    localContentValues.put("session_id", Long.valueOf(parameh.a()));
    localContentValues.put("session_type", Integer.valueOf(parameh.b().a()));
    new l(this.h).a(this.i.l()).a(localContentValues).a(paramoy, parama);
    b(localContentValues);
  }

  // ERROR //
  public ContentValues b(long paramLong, ek paramek)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 184	android/content/ContentValues
    //   6: dup
    //   7: invokespecial 506	android/content/ContentValues:<init>	()V
    //   10: astore 5
    //   12: aload_0
    //   13: getfield 42	com/yandex/metrica/impl/ob/fh:b	Ljava/util/concurrent/locks/Lock;
    //   16: invokeinterface 229 1 0
    //   21: aload_0
    //   22: getfield 64	com/yandex/metrica/impl/ob/fh:d	Lcom/yandex/metrica/impl/ob/fi;
    //   25: invokevirtual 129	com/yandex/metrica/impl/ob/fi:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   28: astore 10
    //   30: getstatic 500	java/util/Locale:US	Ljava/util/Locale;
    //   33: astore 11
    //   35: iconst_2
    //   36: anewarray 4	java/lang/Object
    //   39: astore 12
    //   41: aload 12
    //   43: iconst_0
    //   44: lload_1
    //   45: invokestatic 388	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   48: aastore
    //   49: aload 12
    //   51: iconst_1
    //   52: aload_3
    //   53: invokevirtual 473	com/yandex/metrica/impl/ob/ek:a	()I
    //   56: invokestatic 353	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   59: aastore
    //   60: aload 10
    //   62: aload 11
    //   64: ldc_w 603
    //   67: aload 12
    //   69: invokestatic 505	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   72: aconst_null
    //   73: invokevirtual 428	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   76: astore 13
    //   78: aload 13
    //   80: astore 7
    //   82: aload 7
    //   84: invokeinterface 441 1 0
    //   89: ifeq +95 -> 184
    //   92: new 184	android/content/ContentValues
    //   95: dup
    //   96: invokespecial 506	android/content/ContentValues:<init>	()V
    //   99: astore 15
    //   101: aload 7
    //   103: aload 15
    //   105: invokestatic 512	android/database/DatabaseUtils:cursorRowToContentValues	(Landroid/database/Cursor;Landroid/content/ContentValues;)V
    //   108: aload 7
    //   110: invokestatic 450	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   113: aload_0
    //   114: getfield 42	com/yandex/metrica/impl/ob/fh:b	Ljava/util/concurrent/locks/Lock;
    //   117: invokeinterface 257 1 0
    //   122: aload 15
    //   124: areturn
    //   125: astore 9
    //   127: aload 4
    //   129: invokestatic 450	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   132: aload_0
    //   133: getfield 42	com/yandex/metrica/impl/ob/fh:b	Ljava/util/concurrent/locks/Lock;
    //   136: invokeinterface 257 1 0
    //   141: aload 5
    //   143: areturn
    //   144: astore 6
    //   146: aconst_null
    //   147: astore 7
    //   149: aload 6
    //   151: astore 8
    //   153: aload 7
    //   155: invokestatic 450	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   158: aload_0
    //   159: getfield 42	com/yandex/metrica/impl/ob/fh:b	Ljava/util/concurrent/locks/Lock;
    //   162: invokeinterface 257 1 0
    //   167: aload 8
    //   169: athrow
    //   170: astore 8
    //   172: goto -19 -> 153
    //   175: astore 14
    //   177: aload 7
    //   179: astore 4
    //   181: goto -54 -> 127
    //   184: aload 5
    //   186: astore 15
    //   188: goto -80 -> 108
    //
    // Exception table:
    //   from	to	target	type
    //   21	78	125	java/lang/Exception
    //   21	78	144	finally
    //   82	108	170	finally
    //   82	108	175	java/lang/Exception
  }

  public void b(ContentValues paramContentValues)
  {
    synchronized (this.f)
    {
      this.g.add(paramContentValues);
    }
    synchronized (this.e)
    {
      this.e.notifyAll();
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }

  public void close()
  {
    this.g.clear();
    this.e.a();
  }

  private class a extends Thread
  {
    private final List<ContentValues> b = new ArrayList();
    private fg c;

    public a()
    {
    }

    void a()
    {
      try
      {
        interrupt();
        this.c = null;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    void a(fg paramfg)
    {
      try
      {
        this.c = paramfg;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    void b()
    {
      try
      {
        if (this.c != null)
          this.c.g();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    // ERROR //
    public void run()
    {
      // Byte code:
      //   0: invokestatic 41	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   3: invokevirtual 45	java/lang/Thread:isInterrupted	()Z
      //   6: ifne +111 -> 117
      //   9: aload_0
      //   10: monitorenter
      //   11: aload_0
      //   12: getfield 15	com/yandex/metrica/impl/ob/fh$a:a	Lcom/yandex/metrica/impl/ob/fh;
      //   15: invokestatic 50	com/yandex/metrica/impl/ob/fh:a	(Lcom/yandex/metrica/impl/ob/fh;)Z
      //   18: ifeq +7 -> 25
      //   21: aload_0
      //   22: invokevirtual 55	java/lang/Object:wait	()V
      //   25: aload_0
      //   26: monitorexit
      //   27: aload_0
      //   28: getfield 15	com/yandex/metrica/impl/ob/fh$a:a	Lcom/yandex/metrica/impl/ob/fh;
      //   31: invokestatic 58	com/yandex/metrica/impl/ob/fh:b	(Lcom/yandex/metrica/impl/ob/fh;)Ljava/lang/Object;
      //   34: astore_2
      //   35: aload_2
      //   36: monitorenter
      //   37: aload_0
      //   38: getfield 23	com/yandex/metrica/impl/ob/fh$a:b	Ljava/util/List;
      //   41: invokeinterface 63 1 0
      //   46: aload_0
      //   47: getfield 23	com/yandex/metrica/impl/ob/fh$a:b	Ljava/util/List;
      //   50: aload_0
      //   51: getfield 15	com/yandex/metrica/impl/ob/fh$a:a	Lcom/yandex/metrica/impl/ob/fh;
      //   54: invokestatic 66	com/yandex/metrica/impl/ob/fh:c	(Lcom/yandex/metrica/impl/ob/fh;)Ljava/util/List;
      //   57: invokeinterface 70 2 0
      //   62: pop
      //   63: aload_0
      //   64: getfield 15	com/yandex/metrica/impl/ob/fh$a:a	Lcom/yandex/metrica/impl/ob/fh;
      //   67: invokestatic 66	com/yandex/metrica/impl/ob/fh:c	(Lcom/yandex/metrica/impl/ob/fh;)Ljava/util/List;
      //   70: invokeinterface 63 1 0
      //   75: aload_0
      //   76: getfield 15	com/yandex/metrica/impl/ob/fh$a:a	Lcom/yandex/metrica/impl/ob/fh;
      //   79: aload_0
      //   80: getfield 23	com/yandex/metrica/impl/ob/fh$a:b	Ljava/util/List;
      //   83: invokestatic 73	com/yandex/metrica/impl/ob/fh:a	(Lcom/yandex/metrica/impl/ob/fh;Ljava/util/List;)V
      //   86: aload_2
      //   87: monitorexit
      //   88: aload_0
      //   89: invokevirtual 75	com/yandex/metrica/impl/ob/fh$a:b	()V
      //   92: goto -92 -> 0
      //   95: astore 5
      //   97: aload_0
      //   98: monitorexit
      //   99: aload 5
      //   101: athrow
      //   102: astore_1
      //   103: invokestatic 41	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   106: invokevirtual 76	java/lang/Thread:interrupt	()V
      //   109: goto -82 -> 27
      //   112: astore_3
      //   113: aload_2
      //   114: monitorexit
      //   115: aload_3
      //   116: athrow
      //   117: return
      //
      // Exception table:
      //   from	to	target	type
      //   11	25	95	finally
      //   25	27	95	finally
      //   97	99	95	finally
      //   9	11	102	java/lang/Exception
      //   99	102	102	java/lang/Exception
      //   37	88	112	finally
      //   113	115	112	finally
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.fh
 * JD-Core Version:    0.6.2
 */