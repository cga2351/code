package com.yandex.metrica.impl.ob;

public class fn
{
  private final fr a;
  private String b;

  public fn(fi paramfi, String paramString)
  {
    this(new ft(paramfi), paramString);
  }

  fn(fr paramfr, String paramString)
  {
    this.a = paramfr;
    this.b = paramString;
  }

  // ERROR //
  public java.util.List<iy> a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: getfield 23	com/yandex/metrica/impl/ob/fn:a	Lcom/yandex/metrica/impl/ob/fr;
    //   6: invokeinterface 33 1 0
    //   11: astore 7
    //   13: aload 7
    //   15: aload_0
    //   16: getfield 25	com/yandex/metrica/impl/ob/fn:b	Ljava/lang/String;
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: invokevirtual 39	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore 10
    //   30: aload 10
    //   32: astore_3
    //   33: aload_3
    //   34: ifnull +123 -> 157
    //   37: aload_3
    //   38: invokeinterface 45 1 0
    //   43: ifeq +114 -> 157
    //   46: new 47	java/util/ArrayList
    //   49: dup
    //   50: invokespecial 48	java/util/ArrayList:<init>	()V
    //   53: astore 13
    //   55: aload_3
    //   56: ldc 50
    //   58: invokeinterface 54 2 0
    //   63: istore 14
    //   65: aload_3
    //   66: ldc 56
    //   68: invokeinterface 54 2 0
    //   73: istore 15
    //   75: aload_3
    //   76: iload 14
    //   78: invokeinterface 60 2 0
    //   83: astore 16
    //   85: aload_3
    //   86: iload 15
    //   88: invokeinterface 64 2 0
    //   93: lconst_1
    //   94: lcmp
    //   95: ifne +56 -> 151
    //   98: iconst_1
    //   99: istore 17
    //   101: aload 13
    //   103: new 66	com/yandex/metrica/impl/ob/iy
    //   106: dup
    //   107: aload 16
    //   109: iload 17
    //   111: invokespecial 69	com/yandex/metrica/impl/ob/iy:<init>	(Ljava/lang/String;Z)V
    //   114: invokeinterface 75 2 0
    //   119: pop
    //   120: aload_3
    //   121: invokeinterface 78 1 0
    //   126: istore 19
    //   128: iload 19
    //   130: ifne -75 -> 55
    //   133: aload_0
    //   134: getfield 23	com/yandex/metrica/impl/ob/fn:a	Lcom/yandex/metrica/impl/ob/fr;
    //   137: aload 7
    //   139: invokeinterface 81 2 0
    //   144: aload_3
    //   145: invokestatic 86	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   148: aload 13
    //   150: areturn
    //   151: iconst_0
    //   152: istore 17
    //   154: goto -53 -> 101
    //   157: aload_0
    //   158: getfield 23	com/yandex/metrica/impl/ob/fn:a	Lcom/yandex/metrica/impl/ob/fr;
    //   161: aload 7
    //   163: invokeinterface 81 2 0
    //   168: aload_3
    //   169: invokestatic 86	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   172: aconst_null
    //   173: areturn
    //   174: astore 4
    //   176: aconst_null
    //   177: astore 5
    //   179: aconst_null
    //   180: astore 6
    //   182: aload_0
    //   183: getfield 23	com/yandex/metrica/impl/ob/fn:a	Lcom/yandex/metrica/impl/ob/fr;
    //   186: aload 6
    //   188: invokeinterface 81 2 0
    //   193: aload 5
    //   195: invokestatic 86	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   198: aconst_null
    //   199: areturn
    //   200: astore_2
    //   201: aconst_null
    //   202: astore_3
    //   203: aload_0
    //   204: getfield 23	com/yandex/metrica/impl/ob/fn:a	Lcom/yandex/metrica/impl/ob/fr;
    //   207: aload_1
    //   208: invokeinterface 81 2 0
    //   213: aload_3
    //   214: invokestatic 86	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   217: aload_2
    //   218: athrow
    //   219: astore 9
    //   221: aload 7
    //   223: astore_1
    //   224: aload 9
    //   226: astore_2
    //   227: aconst_null
    //   228: astore_3
    //   229: goto -26 -> 203
    //   232: astore 12
    //   234: aload 7
    //   236: astore_1
    //   237: aload 12
    //   239: astore_2
    //   240: goto -37 -> 203
    //   243: astore 8
    //   245: aload 7
    //   247: astore 6
    //   249: aconst_null
    //   250: astore 5
    //   252: goto -70 -> 182
    //   255: astore 11
    //   257: aload 7
    //   259: astore 6
    //   261: aload_3
    //   262: astore 5
    //   264: goto -82 -> 182
    //
    // Exception table:
    //   from	to	target	type
    //   2	13	174	java/lang/Exception
    //   2	13	200	finally
    //   13	30	219	finally
    //   37	55	232	finally
    //   55	98	232	finally
    //   101	128	232	finally
    //   13	30	243	java/lang/Exception
    //   37	55	255	java/lang/Exception
    //   55	98	255	java/lang/Exception
    //   101	128	255	java/lang/Exception
  }

  // ERROR //
  public void b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: getfield 23	com/yandex/metrica/impl/ob/fn:a	Lcom/yandex/metrica/impl/ob/fr;
    //   6: invokeinterface 33 1 0
    //   11: astore 6
    //   13: aload 6
    //   15: astore_1
    //   16: aload_1
    //   17: ldc 88
    //   19: invokevirtual 92	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   22: aload_0
    //   23: getfield 23	com/yandex/metrica/impl/ob/fn:a	Lcom/yandex/metrica/impl/ob/fr;
    //   26: aload_1
    //   27: invokeinterface 81 2 0
    //   32: return
    //   33: astore 5
    //   35: aload_0
    //   36: getfield 23	com/yandex/metrica/impl/ob/fn:a	Lcom/yandex/metrica/impl/ob/fr;
    //   39: aload_1
    //   40: invokeinterface 81 2 0
    //   45: return
    //   46: astore_2
    //   47: aconst_null
    //   48: astore_3
    //   49: aload_2
    //   50: astore 4
    //   52: aload_0
    //   53: getfield 23	com/yandex/metrica/impl/ob/fn:a	Lcom/yandex/metrica/impl/ob/fr;
    //   56: aload_3
    //   57: invokeinterface 81 2 0
    //   62: aload 4
    //   64: athrow
    //   65: astore 7
    //   67: aload_1
    //   68: astore_3
    //   69: aload 7
    //   71: astore 4
    //   73: goto -21 -> 52
    //
    // Exception table:
    //   from	to	target	type
    //   2	13	33	java/lang/Exception
    //   16	22	33	java/lang/Exception
    //   2	13	46	finally
    //   16	22	65	finally
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.fn
 * JD-Core Version:    0.6.2
 */