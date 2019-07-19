package android.arch.persistence.room;

import android.arch.a.a.a;
import android.arch.persistence.a.f;
import android.database.Cursor;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.ArraySet;
import android.util.Log;
import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class c
{
  private static final String[] f = { "UPDATE", "DELETE", "INSERT" };
  ArrayMap<String, Integer> a;
  long[] b;
  AtomicBoolean c = new AtomicBoolean(false);
  final android.arch.a.b.b<b, c> d = new android.arch.a.b.b();
  Runnable e = new Runnable()
  {
    private boolean a()
    {
      boolean bool = false;
      Cursor localCursor = c.a(c.this).a("SELECT * FROM room_table_modification_log WHERE version  > ? ORDER BY version ASC;", c.d(c.this));
      try
      {
        while (localCursor.moveToNext())
        {
          long l = localCursor.getLong(0);
          int i = localCursor.getInt(1);
          c.this.b[i] = l;
          c.a(c.this, l);
          bool = true;
        }
        return bool;
      }
      finally
      {
        localCursor.close();
      }
    }

    // ERROR //
    public void run()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: aload_0
      //   3: getfield 14	android/arch/persistence/room/c$1:a	Landroid/arch/persistence/room/c;
      //   6: invokestatic 21	android/arch/persistence/room/c:a	(Landroid/arch/persistence/room/c;)Landroid/arch/persistence/room/e;
      //   9: invokevirtual 63	android/arch/persistence/room/e:a	()Ljava/util/concurrent/locks/Lock;
      //   12: astore_2
      //   13: aload_2
      //   14: invokeinterface 68 1 0
      //   19: aload_0
      //   20: getfield 14	android/arch/persistence/room/c$1:a	Landroid/arch/persistence/room/c;
      //   23: invokestatic 71	android/arch/persistence/room/c:b	(Landroid/arch/persistence/room/c;)Z
      //   26: istore 14
      //   28: iload 14
      //   30: ifne +10 -> 40
      //   33: aload_2
      //   34: invokeinterface 74 1 0
      //   39: return
      //   40: aload_0
      //   41: getfield 14	android/arch/persistence/room/c$1:a	Landroid/arch/persistence/room/c;
      //   44: getfield 78	android/arch/persistence/room/c:c	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   47: iconst_1
      //   48: iconst_0
      //   49: invokevirtual 84	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
      //   52: istore 15
      //   54: iload 15
      //   56: ifne +10 -> 66
      //   59: aload_2
      //   60: invokeinterface 74 1 0
      //   65: return
      //   66: aload_0
      //   67: getfield 14	android/arch/persistence/room/c$1:a	Landroid/arch/persistence/room/c;
      //   70: invokestatic 21	android/arch/persistence/room/c:a	(Landroid/arch/persistence/room/c;)Landroid/arch/persistence/room/e;
      //   73: invokevirtual 87	android/arch/persistence/room/e:i	()Z
      //   76: istore 16
      //   78: iload 16
      //   80: ifeq +10 -> 90
      //   83: aload_2
      //   84: invokeinterface 74 1 0
      //   89: return
      //   90: aload_0
      //   91: getfield 14	android/arch/persistence/room/c$1:a	Landroid/arch/persistence/room/c;
      //   94: invokestatic 90	android/arch/persistence/room/c:c	(Landroid/arch/persistence/room/c;)Landroid/arch/persistence/a/f;
      //   97: invokeinterface 95 1 0
      //   102: pop
      //   103: aload_0
      //   104: getfield 14	android/arch/persistence/room/c$1:a	Landroid/arch/persistence/room/c;
      //   107: invokestatic 27	android/arch/persistence/room/c:d	(Landroid/arch/persistence/room/c;)[Ljava/lang/Object;
      //   110: iconst_0
      //   111: aload_0
      //   112: getfield 14	android/arch/persistence/room/c$1:a	Landroid/arch/persistence/room/c;
      //   115: invokestatic 99	android/arch/persistence/room/c:e	(Landroid/arch/persistence/room/c;)J
      //   118: invokestatic 105	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   121: aastore
      //   122: aload_0
      //   123: getfield 14	android/arch/persistence/room/c$1:a	Landroid/arch/persistence/room/c;
      //   126: invokestatic 21	android/arch/persistence/room/c:a	(Landroid/arch/persistence/room/c;)Landroid/arch/persistence/room/e;
      //   129: getfield 108	android/arch/persistence/room/e:b	Z
      //   132: istore 18
      //   134: iconst_0
      //   135: istore_1
      //   136: iload 18
      //   138: ifeq +179 -> 317
      //   141: aload_0
      //   142: getfield 14	android/arch/persistence/room/c$1:a	Landroid/arch/persistence/room/c;
      //   145: invokestatic 21	android/arch/persistence/room/c:a	(Landroid/arch/persistence/room/c;)Landroid/arch/persistence/room/e;
      //   148: invokevirtual 111	android/arch/persistence/room/e:b	()Landroid/arch/persistence/a/c;
      //   151: invokeinterface 116 1 0
      //   156: astore 19
      //   158: aload 19
      //   160: invokeinterface 120 1 0
      //   165: aload_0
      //   166: invokespecial 122	android/arch/persistence/room/c$1:a	()Z
      //   169: istore 21
      //   171: iload 21
      //   173: istore 5
      //   175: aload 19
      //   177: invokeinterface 124 1 0
      //   182: aload 19
      //   184: invokeinterface 126 1 0
      //   189: aload_2
      //   190: invokeinterface 74 1 0
      //   195: iload 5
      //   197: ifeq -158 -> 39
      //   200: aload_0
      //   201: getfield 14	android/arch/persistence/room/c$1:a	Landroid/arch/persistence/room/c;
      //   204: getfield 129	android/arch/persistence/room/c:d	Landroid/arch/a/b/b;
      //   207: astore 9
      //   209: aload 9
      //   211: monitorenter
      //   212: aload_0
      //   213: getfield 14	android/arch/persistence/room/c$1:a	Landroid/arch/persistence/room/c;
      //   216: getfield 129	android/arch/persistence/room/c:d	Landroid/arch/a/b/b;
      //   219: invokevirtual 135	android/arch/a/b/b:iterator	()Ljava/util/Iterator;
      //   222: astore 11
      //   224: aload 11
      //   226: invokeinterface 140 1 0
      //   231: ifeq +110 -> 341
      //   234: aload 11
      //   236: invokeinterface 144 1 0
      //   241: checkcast 146	java/util/Map$Entry
      //   244: invokeinterface 149 1 0
      //   249: checkcast 151	android/arch/persistence/room/c$c
      //   252: aload_0
      //   253: getfield 14	android/arch/persistence/room/c$1:a	Landroid/arch/persistence/room/c;
      //   256: getfield 49	android/arch/persistence/room/c:b	[J
      //   259: invokevirtual 154	android/arch/persistence/room/c$c:a	([J)V
      //   262: goto -38 -> 224
      //   265: astore 10
      //   267: aload 9
      //   269: monitorexit
      //   270: aload 10
      //   272: athrow
      //   273: astore 20
      //   275: aload 19
      //   277: invokeinterface 126 1 0
      //   282: aload 20
      //   284: athrow
      //   285: astore 12
      //   287: aload 12
      //   289: astore 13
      //   291: iload_1
      //   292: istore 5
      //   294: aload 13
      //   296: astore 6
      //   298: ldc 156
      //   300: ldc 158
      //   302: aload 6
      //   304: invokestatic 163	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   307: pop
      //   308: aload_2
      //   309: invokeinterface 74 1 0
      //   314: goto -119 -> 195
      //   317: aload_0
      //   318: invokespecial 122	android/arch/persistence/room/c$1:a	()Z
      //   321: istore 25
      //   323: iload 25
      //   325: istore 5
      //   327: goto -138 -> 189
      //   330: astore 7
      //   332: aload_2
      //   333: invokeinterface 74 1 0
      //   338: aload 7
      //   340: athrow
      //   341: aload 9
      //   343: monitorexit
      //   344: return
      //   345: astore_3
      //   346: aload_3
      //   347: astore 4
      //   349: iload_1
      //   350: istore 5
      //   352: aload 4
      //   354: astore 6
      //   356: goto -58 -> 298
      //   359: astore 24
      //   361: iload 5
      //   363: istore_1
      //   364: aload 24
      //   366: astore 12
      //   368: goto -81 -> 287
      //   371: astore 23
      //   373: iload 5
      //   375: istore_1
      //   376: aload 23
      //   378: astore_3
      //   379: goto -33 -> 346
      //   382: astore 22
      //   384: iload 5
      //   386: istore_1
      //   387: aload 22
      //   389: astore 20
      //   391: goto -116 -> 275
      //
      // Exception table:
      //   from	to	target	type
      //   212	224	265	finally
      //   224	262	265	finally
      //   267	270	265	finally
      //   341	344	265	finally
      //   158	171	273	finally
      //   13	28	285	java/lang/IllegalStateException
      //   40	54	285	java/lang/IllegalStateException
      //   66	78	285	java/lang/IllegalStateException
      //   90	134	285	java/lang/IllegalStateException
      //   141	158	285	java/lang/IllegalStateException
      //   275	285	285	java/lang/IllegalStateException
      //   317	323	285	java/lang/IllegalStateException
      //   13	28	330	finally
      //   40	54	330	finally
      //   66	78	330	finally
      //   90	134	330	finally
      //   141	158	330	finally
      //   182	189	330	finally
      //   275	285	330	finally
      //   298	308	330	finally
      //   317	323	330	finally
      //   13	28	345	android/database/sqlite/SQLiteException
      //   40	54	345	android/database/sqlite/SQLiteException
      //   66	78	345	android/database/sqlite/SQLiteException
      //   90	134	345	android/database/sqlite/SQLiteException
      //   141	158	345	android/database/sqlite/SQLiteException
      //   275	285	345	android/database/sqlite/SQLiteException
      //   317	323	345	android/database/sqlite/SQLiteException
      //   182	189	359	java/lang/IllegalStateException
      //   182	189	371	android/database/sqlite/SQLiteException
      //   175	182	382	finally
    }
  };
  private String[] g;
  private Object[] h = new Object[1];
  private long i = 0L;
  private final e j;
  private volatile boolean k = false;
  private volatile f l;
  private a m;

  public c(e parame, String[] paramArrayOfString)
  {
    this.j = parame;
    this.m = new a(paramArrayOfString.length);
    this.a = new ArrayMap();
    int i1 = paramArrayOfString.length;
    this.g = new String[i1];
    while (n < i1)
    {
      String str = paramArrayOfString[n].toLowerCase(Locale.US);
      this.a.put(str, Integer.valueOf(n));
      this.g[n] = str;
      n++;
    }
    this.b = new long[paramArrayOfString.length];
    Arrays.fill(this.b, 0L);
  }

  private void a(android.arch.persistence.a.b paramb, int paramInt)
  {
    String str1 = this.g[paramInt];
    StringBuilder localStringBuilder = new StringBuilder();
    for (String str2 : f)
    {
      localStringBuilder.setLength(0);
      localStringBuilder.append("DROP TRIGGER IF EXISTS ");
      a(localStringBuilder, str1, str2);
      paramb.c(localStringBuilder.toString());
    }
  }

  private static void a(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    paramStringBuilder.append("`").append("room_table_modification_trigger_").append(paramString1).append("_").append(paramString2).append("`");
  }

  private void b(android.arch.persistence.a.b paramb, int paramInt)
  {
    String str1 = this.g[paramInt];
    StringBuilder localStringBuilder = new StringBuilder();
    for (String str2 : f)
    {
      localStringBuilder.setLength(0);
      localStringBuilder.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
      a(localStringBuilder, str1, str2);
      localStringBuilder.append(" AFTER ").append(str2).append(" ON `").append(str1).append("` BEGIN INSERT OR REPLACE INTO ").append("room_table_modification_log").append(" VALUES(null, ").append(paramInt).append("); END");
      paramb.c(localStringBuilder.toString());
    }
  }

  private boolean b()
  {
    if (!this.j.d())
      return false;
    if (!this.k)
      this.j.b().a();
    if (!this.k)
    {
      Log.e("ROOM", "database is not initialized even though it is open");
      return false;
    }
    return true;
  }

  public void a()
  {
    if (this.c.compareAndSet(false, true))
      a.a().a(this.e);
  }

  // ERROR //
  void a(android.arch.persistence.a.b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 60	android/arch/persistence/room/c:k	Z
    //   6: ifeq +14 -> 20
    //   9: ldc 181
    //   11: ldc 211
    //   13: invokestatic 188	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   16: pop
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_1
    //   21: invokeinterface 213 1 0
    //   26: aload_1
    //   27: ldc 215
    //   29: invokeinterface 143 2 0
    //   34: aload_1
    //   35: ldc 217
    //   37: invokeinterface 143 2 0
    //   42: aload_1
    //   43: ldc 219
    //   45: invokeinterface 143 2 0
    //   50: aload_1
    //   51: invokeinterface 221 1 0
    //   56: aload_1
    //   57: invokeinterface 223 1 0
    //   62: aload_0
    //   63: aload_1
    //   64: invokevirtual 225	android/arch/persistence/room/c:b	(Landroid/arch/persistence/a/b;)V
    //   67: aload_0
    //   68: aload_1
    //   69: ldc 227
    //   71: invokeinterface 230 2 0
    //   76: putfield 194	android/arch/persistence/room/c:l	Landroid/arch/persistence/a/f;
    //   79: aload_0
    //   80: iconst_1
    //   81: putfield 60	android/arch/persistence/room/c:k	Z
    //   84: aload_0
    //   85: monitorexit
    //   86: return
    //   87: astore_2
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_2
    //   91: athrow
    //   92: astore_3
    //   93: aload_1
    //   94: invokeinterface 223 1 0
    //   99: aload_3
    //   100: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   2	19	87	finally
    //   20	26	87	finally
    //   56	86	87	finally
    //   88	90	87	finally
    //   93	101	87	finally
    //   26	56	92	finally
  }

  // ERROR //
  void b(android.arch.persistence.a.b paramb)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 235 1 0
    //   6: ifeq +30 -> 36
    //   9: return
    //   10: aload_1
    //   11: invokeinterface 221 1 0
    //   16: aload_1
    //   17: invokeinterface 223 1 0
    //   22: aload_0
    //   23: getfield 81	android/arch/persistence/room/c:m	Landroid/arch/persistence/room/c$a;
    //   26: invokevirtual 236	android/arch/persistence/room/c$a:b	()V
    //   29: aload 4
    //   31: invokeinterface 241 1 0
    //   36: aload_0
    //   37: getfield 74	android/arch/persistence/room/c:j	Landroid/arch/persistence/room/e;
    //   40: invokevirtual 244	android/arch/persistence/room/e:a	()Ljava/util/concurrent/locks/Lock;
    //   43: astore 4
    //   45: aload 4
    //   47: invokeinterface 247 1 0
    //   52: aload_0
    //   53: getfield 81	android/arch/persistence/room/c:m	Landroid/arch/persistence/room/c$a;
    //   56: invokevirtual 250	android/arch/persistence/room/c$a:a	()[I
    //   59: astore 6
    //   61: aload 6
    //   63: ifnonnull +22 -> 85
    //   66: aload 4
    //   68: invokeinterface 241 1 0
    //   73: return
    //   74: astore_2
    //   75: ldc 181
    //   77: ldc 252
    //   79: aload_2
    //   80: invokestatic 255	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   83: pop
    //   84: return
    //   85: aload 6
    //   87: arraylength
    //   88: istore 7
    //   90: aload_1
    //   91: invokeinterface 213 1 0
    //   96: iconst_0
    //   97: istore 9
    //   99: iload 9
    //   101: iload 7
    //   103: if_icmpge -93 -> 10
    //   106: aload 6
    //   108: iload 9
    //   110: iaload
    //   111: tableswitch	default:+65 -> 176, 1:+21->132, 2:+58->169
    //   133: aload_1
    //   134: iload 9
    //   136: invokespecial 257	android/arch/persistence/room/c:b	(Landroid/arch/persistence/a/b;I)V
    //   139: goto +37 -> 176
    //   142: astore 8
    //   144: aload_1
    //   145: invokeinterface 223 1 0
    //   150: aload 8
    //   152: athrow
    //   153: astore 5
    //   155: aload 4
    //   157: invokeinterface 241 1 0
    //   162: aload 5
    //   164: athrow
    //   165: astore_2
    //   166: goto -91 -> 75
    //   169: aload_0
    //   170: aload_1
    //   171: iload 9
    //   173: invokespecial 259	android/arch/persistence/room/c:a	(Landroid/arch/persistence/a/b;I)V
    //   176: iinc 9 1
    //   179: goto -80 -> 99
    //
    // Exception table:
    //   from	to	target	type
    //   29	36	74	java/lang/IllegalStateException
    //   36	52	74	java/lang/IllegalStateException
    //   66	73	74	java/lang/IllegalStateException
    //   155	165	74	java/lang/IllegalStateException
    //   10	16	142	finally
    //   90	96	142	finally
    //   106	132	142	finally
    //   132	139	142	finally
    //   169	176	142	finally
    //   16	29	153	finally
    //   52	61	153	finally
    //   85	90	153	finally
    //   144	153	153	finally
    //   29	36	165	android/database/sqlite/SQLiteException
    //   36	52	165	android/database/sqlite/SQLiteException
    //   66	73	165	android/database/sqlite/SQLiteException
    //   155	165	165	android/database/sqlite/SQLiteException
  }

  static class a
  {
    final long[] a;
    final boolean[] b;
    final int[] c;
    boolean d;
    boolean e;

    a(int paramInt)
    {
      this.a = new long[paramInt];
      this.b = new boolean[paramInt];
      this.c = new int[paramInt];
      Arrays.fill(this.a, 0L);
      Arrays.fill(this.b, false);
    }

    int[] a()
    {
      while (true)
      {
        try
        {
          if ((!this.d) || (this.e))
            return null;
          int i = this.a.length;
          int j = 0;
          if (j < i)
          {
            if (this.a[j] <= 0L)
              break label128;
            k = 1;
            if (k != this.b[j])
            {
              int[] arrayOfInt1 = this.c;
              if (k == 0)
                break label134;
              m = 1;
              arrayOfInt1[j] = m;
              this.b[j] = k;
              j++;
              continue;
            }
            this.c[j] = 0;
            continue;
          }
        }
        finally
        {
        }
        this.e = true;
        this.d = false;
        int[] arrayOfInt2 = this.c;
        return arrayOfInt2;
        label128: int k = 0;
        continue;
        label134: int m = 2;
      }
    }

    void b()
    {
      try
      {
        this.e = false;
        return;
      }
      finally
      {
      }
    }
  }

  public static abstract class b
  {
    public abstract void a(Set<String> paramSet);
  }

  static class c
  {
    final int[] a;
    final c.b b;
    private final String[] c;
    private final long[] d;
    private final Set<String> e;

    void a(long[] paramArrayOfLong)
    {
      int i = this.a.length;
      Object localObject = null;
      int j = 0;
      if (j < i)
      {
        long l = paramArrayOfLong[this.a[j]];
        if (this.d[j] < l)
        {
          this.d[j] = l;
          if (i != 1)
            break label66;
          localObject = this.e;
        }
        while (true)
        {
          j++;
          break;
          label66: if (localObject == null)
            localObject = new ArraySet(i);
          ((Set)localObject).add(this.c[j]);
        }
      }
      if (localObject != null)
        this.b.a((Set)localObject);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.persistence.room.c
 * JD-Core Version:    0.6.2
 */