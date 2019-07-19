package com.yandex.metrica.impl.ob;

public class pm extends pf<String>
{
  public pm(int paramInt, String paramString)
  {
    this(paramInt, paramString, og.a());
  }

  public pm(int paramInt, String paramString, of paramof)
  {
    super(paramInt, paramString, paramof);
  }

  // ERROR //
  public String a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 34	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +94 -> 98
    //   7: aload_1
    //   8: ldc 36
    //   10: invokevirtual 40	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   13: astore_3
    //   14: aload_3
    //   15: arraylength
    //   16: aload_0
    //   17: invokevirtual 41	com/yandex/metrica/impl/ob/pm:a	()I
    //   20: if_icmple +78 -> 98
    //   23: new 23	java/lang/String
    //   26: dup
    //   27: aload_3
    //   28: iconst_0
    //   29: aload_0
    //   30: invokevirtual 41	com/yandex/metrica/impl/ob/pm:a	()I
    //   33: ldc 36
    //   35: invokespecial 44	java/lang/String:<init>	([BIILjava/lang/String;)V
    //   38: astore 4
    //   40: aload_0
    //   41: getfield 47	com/yandex/metrica/impl/ob/pm:a	Lcom/yandex/metrica/impl/ob/of;
    //   44: invokevirtual 53	com/yandex/metrica/impl/ob/of:c	()Z
    //   47: ifeq +48 -> 95
    //   50: aload_0
    //   51: getfield 47	com/yandex/metrica/impl/ob/pm:a	Lcom/yandex/metrica/impl/ob/of;
    //   54: astore 6
    //   56: iconst_3
    //   57: anewarray 55	java/lang/Object
    //   60: astore 7
    //   62: aload 7
    //   64: iconst_0
    //   65: aload_0
    //   66: invokevirtual 59	com/yandex/metrica/impl/ob/pm:b	()Ljava/lang/String;
    //   69: aastore
    //   70: aload 7
    //   72: iconst_1
    //   73: aload_1
    //   74: aastore
    //   75: aload 7
    //   77: iconst_2
    //   78: aload_0
    //   79: invokevirtual 41	com/yandex/metrica/impl/ob/pm:a	()I
    //   82: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   85: aastore
    //   86: aload 6
    //   88: ldc 67
    //   90: aload 7
    //   92: invokevirtual 70	com/yandex/metrica/impl/ob/of:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: aload 4
    //   97: astore_1
    //   98: aload_1
    //   99: areturn
    //   100: astore_2
    //   101: aload_1
    //   102: areturn
    //   103: astore 5
    //   105: aload 4
    //   107: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   7	40	100	java/io/UnsupportedEncodingException
    //   40	95	103	java/io/UnsupportedEncodingException
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.pm
 * JD-Core Version:    0.6.2
 */