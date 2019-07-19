package com.yandex.mobile.ads.impl;

import android.content.Context;

public final class cr
  implements cs
{
  private final bz a;
  private final cp b;
  private final Context c;
  private final int d;

  public cr(Context paramContext, v paramv, bz parambz, cp paramcp)
  {
    this.a = parambz;
    this.b = paramcp;
    this.c = paramContext.getApplicationContext();
    this.d = paramv.l();
  }

  // ERROR //
  private String b(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_1
    //   5: astore 4
    //   7: iload_2
    //   8: aload_0
    //   9: getfield 39	com/yandex/mobile/ads/impl/cr:d	I
    //   12: if_icmpge +27 -> 39
    //   15: aload 4
    //   17: invokestatic 47	com/yandex/mobile/ads/impl/df:a	(Ljava/lang/String;)Z
    //   20: ifne +15 -> 35
    //   23: aload 4
    //   25: invokestatic 49	com/yandex/mobile/ads/impl/df:c	(Ljava/lang/String;)Z
    //   28: istore 12
    //   30: iload 12
    //   32: ifne +10 -> 42
    //   35: aload_3
    //   36: invokestatic 54	com/yandex/mobile/ads/impl/cw:a	(Ljava/net/HttpURLConnection;)V
    //   39: aload 4
    //   41: areturn
    //   42: aload_0
    //   43: getfield 31	com/yandex/mobile/ads/impl/cr:c	Landroid/content/Context;
    //   46: astore 13
    //   48: getstatic 58	com/yandex/mobile/ads/impl/ez:a	I
    //   51: istore 14
    //   53: new 60	java/net/URL
    //   56: dup
    //   57: aload 4
    //   59: invokespecial 63	java/net/URL:<init>	(Ljava/lang/String;)V
    //   62: invokevirtual 67	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   65: checkcast 69	java/net/HttpURLConnection
    //   68: astore 7
    //   70: aload 7
    //   72: ldc 71
    //   74: new 73	com/yandex/mobile/ads/impl/fk
    //   77: dup
    //   78: invokespecial 74	com/yandex/mobile/ads/impl/fk:<init>	()V
    //   81: aload 13
    //   83: invokevirtual 77	com/yandex/mobile/ads/impl/fk:a	(Landroid/content/Context;)Ljava/lang/String;
    //   86: invokevirtual 81	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: iload 14
    //   91: ifle +17 -> 108
    //   94: aload 7
    //   96: iload 14
    //   98: invokevirtual 85	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   101: aload 7
    //   103: iload 14
    //   105: invokevirtual 88	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   108: bipush 21
    //   110: invokestatic 93	com/yandex/mobile/ads/impl/fl:a	(I)Z
    //   113: ifeq +31 -> 144
    //   116: aload 7
    //   118: instanceof 95
    //   121: ifeq +23 -> 144
    //   124: invokestatic 100	com/yandex/mobile/ads/impl/pn:a	()Ljavax/net/ssl/SSLSocketFactory;
    //   127: astore 20
    //   129: aload 20
    //   131: ifnull +13 -> 144
    //   134: aload 7
    //   136: checkcast 95	javax/net/ssl/HttpsURLConnection
    //   139: aload 20
    //   141: invokevirtual 104	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   144: aload 7
    //   146: iconst_0
    //   147: invokevirtual 108	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   150: aload 7
    //   152: invokevirtual 111	java/net/HttpURLConnection:getResponseCode	()I
    //   155: istore 15
    //   157: iconst_2
    //   158: anewarray 4	java/lang/Object
    //   161: astore 16
    //   163: aload 16
    //   165: iconst_0
    //   166: aload 4
    //   168: aastore
    //   169: aload 16
    //   171: iconst_1
    //   172: iload 15
    //   174: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   177: aastore
    //   178: aload 7
    //   180: getstatic 123	com/yandex/mobile/ads/impl/oa:x	Lcom/yandex/mobile/ads/impl/oa;
    //   183: invokevirtual 126	com/yandex/mobile/ads/impl/oa:a	()Ljava/lang/String;
    //   186: invokevirtual 129	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   189: astore 11
    //   191: iconst_1
    //   192: anewarray 4	java/lang/Object
    //   195: dup
    //   196: iconst_0
    //   197: aload 11
    //   199: aastore
    //   200: pop
    //   201: iload 15
    //   203: sipush 300
    //   206: if_icmplt +49 -> 255
    //   209: iload 15
    //   211: sipush 400
    //   214: if_icmpge +41 -> 255
    //   217: aload 11
    //   219: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   222: istore 19
    //   224: iload 19
    //   226: ifne +29 -> 255
    //   229: iconst_1
    //   230: istore 18
    //   232: iload 18
    //   234: ifeq +27 -> 261
    //   237: aload 7
    //   239: invokestatic 54	com/yandex/mobile/ads/impl/cw:a	(Ljava/net/HttpURLConnection;)V
    //   242: iinc 2 1
    //   245: aload 7
    //   247: astore_3
    //   248: aload 11
    //   250: astore 4
    //   252: goto -245 -> 7
    //   255: iconst_0
    //   256: istore 18
    //   258: goto -26 -> 232
    //   261: aload 7
    //   263: invokestatic 54	com/yandex/mobile/ads/impl/cw:a	(Ljava/net/HttpURLConnection;)V
    //   266: aload 4
    //   268: areturn
    //   269: astore 6
    //   271: iconst_2
    //   272: anewarray 4	java/lang/Object
    //   275: astore 10
    //   277: aload 10
    //   279: iconst_0
    //   280: aload 4
    //   282: aastore
    //   283: aload 10
    //   285: iconst_1
    //   286: aload 6
    //   288: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   291: aastore
    //   292: aload 7
    //   294: invokestatic 54	com/yandex/mobile/ads/impl/cw:a	(Ljava/net/HttpURLConnection;)V
    //   297: aload 4
    //   299: astore 11
    //   301: goto -59 -> 242
    //   304: astore 8
    //   306: aload 7
    //   308: astore_3
    //   309: aload 8
    //   311: astore 9
    //   313: aload_3
    //   314: invokestatic 54	com/yandex/mobile/ads/impl/cw:a	(Ljava/net/HttpURLConnection;)V
    //   317: aload 9
    //   319: athrow
    //   320: astore 9
    //   322: goto -9 -> 313
    //   325: astore 5
    //   327: aload 5
    //   329: astore 6
    //   331: aload_3
    //   332: astore 7
    //   334: goto -63 -> 271
    //
    // Exception table:
    //   from	to	target	type
    //   150	201	269	java/lang/Exception
    //   217	224	269	java/lang/Exception
    //   150	201	304	finally
    //   217	224	304	finally
    //   271	292	304	finally
    //   15	30	320	finally
    //   42	89	320	finally
    //   94	108	320	finally
    //   108	129	320	finally
    //   134	144	320	finally
    //   144	150	320	finally
    //   15	30	325	java/lang/Exception
    //   42	89	325	java/lang/Exception
    //   94	108	325	java/lang/Exception
    //   108	129	325	java/lang/Exception
    //   134	144	325	java/lang/Exception
    //   144	150	325	java/lang/Exception
  }

  public final void a(String paramString)
  {
    String str = b(paramString);
    this.b.a(this.a, str);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.cr
 * JD-Core Version:    0.6.2
 */