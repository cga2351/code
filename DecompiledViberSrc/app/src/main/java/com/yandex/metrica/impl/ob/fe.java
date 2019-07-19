package com.yandex.metrica.impl.ob;

public class fe
{
  private final fr a;
  private final String b;

  public fe(fr paramfr, String paramString)
  {
    this.a = paramfr;
    this.b = paramString;
  }

  // ERROR //
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 15	com/yandex/metrica/impl/ob/fe:a	Lcom/yandex/metrica/impl/ob/fr;
    //   6: invokeinterface 25 1 0
    //   11: astore 8
    //   13: aload 8
    //   15: astore_3
    //   16: new 27	android/content/ContentValues
    //   19: dup
    //   20: invokespecial 28	android/content/ContentValues:<init>	()V
    //   23: astore 9
    //   25: aload 9
    //   27: ldc 30
    //   29: aload_1
    //   30: invokevirtual 34	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload 9
    //   35: ldc 36
    //   37: aload_2
    //   38: invokevirtual 38	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   41: aload_3
    //   42: aload_0
    //   43: getfield 17	com/yandex/metrica/impl/ob/fe:b	Ljava/lang/String;
    //   46: aconst_null
    //   47: aload 9
    //   49: iconst_5
    //   50: invokevirtual 44	android/database/sqlite/SQLiteDatabase:insertWithOnConflict	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    //   53: pop2
    //   54: aload_0
    //   55: getfield 15	com/yandex/metrica/impl/ob/fe:a	Lcom/yandex/metrica/impl/ob/fr;
    //   58: aload_3
    //   59: invokeinterface 47 2 0
    //   64: return
    //   65: astore 7
    //   67: aload_0
    //   68: getfield 15	com/yandex/metrica/impl/ob/fe:a	Lcom/yandex/metrica/impl/ob/fr;
    //   71: aload_3
    //   72: invokeinterface 47 2 0
    //   77: return
    //   78: astore 4
    //   80: aconst_null
    //   81: astore 5
    //   83: aload 4
    //   85: astore 6
    //   87: aload_0
    //   88: getfield 15	com/yandex/metrica/impl/ob/fe:a	Lcom/yandex/metrica/impl/ob/fr;
    //   91: aload 5
    //   93: invokeinterface 47 2 0
    //   98: aload 6
    //   100: athrow
    //   101: astore 10
    //   103: aload_3
    //   104: astore 5
    //   106: aload 10
    //   108: astore 6
    //   110: goto -23 -> 87
    //
    // Exception table:
    //   from	to	target	type
    //   2	13	65	java/lang/Exception
    //   16	54	65	java/lang/Exception
    //   2	13	78	finally
    //   16	54	101	finally
  }

  // ERROR //
  public byte[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 15	com/yandex/metrica/impl/ob/fe:a	Lcom/yandex/metrica/impl/ob/fr;
    //   6: invokeinterface 25 1 0
    //   11: astore 8
    //   13: aload 8
    //   15: aload_0
    //   16: getfield 17	com/yandex/metrica/impl/ob/fe:b	Ljava/lang/String;
    //   19: aconst_null
    //   20: ldc 50
    //   22: iconst_1
    //   23: anewarray 52	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: aload_1
    //   29: aastore
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: invokevirtual 56	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore 11
    //   38: aload 11
    //   40: ifnull +61 -> 101
    //   43: aload 11
    //   45: invokeinterface 62 1 0
    //   50: iconst_1
    //   51: if_icmpne +50 -> 101
    //   54: aload 11
    //   56: invokeinterface 66 1 0
    //   61: ifeq +40 -> 101
    //   64: aload 11
    //   66: aload 11
    //   68: ldc 36
    //   70: invokeinterface 70 2 0
    //   75: invokeinterface 74 2 0
    //   80: astore 14
    //   82: aload 11
    //   84: invokestatic 79	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   87: aload_0
    //   88: getfield 15	com/yandex/metrica/impl/ob/fe:a	Lcom/yandex/metrica/impl/ob/fr;
    //   91: aload 8
    //   93: invokeinterface 47 2 0
    //   98: aload 14
    //   100: areturn
    //   101: aload 11
    //   103: invokestatic 79	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   106: aload_0
    //   107: getfield 15	com/yandex/metrica/impl/ob/fe:a	Lcom/yandex/metrica/impl/ob/fr;
    //   110: aload 8
    //   112: invokeinterface 47 2 0
    //   117: aconst_null
    //   118: areturn
    //   119: astore 5
    //   121: aconst_null
    //   122: astore 6
    //   124: aconst_null
    //   125: astore 7
    //   127: aload 6
    //   129: invokestatic 79	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   132: aload_0
    //   133: getfield 15	com/yandex/metrica/impl/ob/fe:a	Lcom/yandex/metrica/impl/ob/fr;
    //   136: aload 7
    //   138: invokeinterface 47 2 0
    //   143: aconst_null
    //   144: areturn
    //   145: astore_3
    //   146: aconst_null
    //   147: astore 4
    //   149: aload_2
    //   150: invokestatic 79	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   153: aload_0
    //   154: getfield 15	com/yandex/metrica/impl/ob/fe:a	Lcom/yandex/metrica/impl/ob/fr;
    //   157: aload 4
    //   159: invokeinterface 47 2 0
    //   164: aload_3
    //   165: athrow
    //   166: astore 10
    //   168: aload 8
    //   170: astore 4
    //   172: aload 10
    //   174: astore_3
    //   175: aconst_null
    //   176: astore_2
    //   177: goto -28 -> 149
    //   180: astore 13
    //   182: aload 11
    //   184: astore_2
    //   185: aload 8
    //   187: astore 4
    //   189: aload 13
    //   191: astore_3
    //   192: goto -43 -> 149
    //   195: astore 9
    //   197: aload 8
    //   199: astore 7
    //   201: aconst_null
    //   202: astore 6
    //   204: goto -77 -> 127
    //   207: astore 12
    //   209: aload 8
    //   211: astore 7
    //   213: aload 11
    //   215: astore 6
    //   217: goto -90 -> 127
    //
    // Exception table:
    //   from	to	target	type
    //   2	13	119	java/lang/Exception
    //   2	13	145	finally
    //   13	38	166	finally
    //   43	82	180	finally
    //   13	38	195	java/lang/Exception
    //   43	82	207	java/lang/Exception
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.fe
 * JD-Core Version:    0.6.2
 */