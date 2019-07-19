package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public final class ow
  implements of
{
  protected static final boolean a = on.b;
  private static int d = 3000;
  private static int e = 4096;
  protected final pa b;
  protected final ox c;

  public ow(pa parampa)
  {
    this(parampa, new ox(e));
  }

  private ow(pa parampa, ox paramox)
  {
    this.b = parampa;
    this.c = paramox;
  }

  private static Map<String, String> a(Header[] paramArrayOfHeader)
  {
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    for (int i = 0; i < paramArrayOfHeader.length; i++)
      localTreeMap.put(paramArrayOfHeader[i].getName(), paramArrayOfHeader[i].getValue());
    return localTreeMap;
  }

  private static void a(String paramString, oi<?> paramoi, ov paramov)
    throws ov
  {
    om localom = paramoi.q();
    int i = paramoi.p();
    try
    {
      localom.a(paramov);
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = paramString;
      arrayOfObject2[1] = Integer.valueOf(i);
      String.format("%s-retry [timeout=%s]", arrayOfObject2);
      return;
    }
    catch (ov localov)
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = paramString;
      arrayOfObject1[1] = Integer.valueOf(i);
      String.format("%s-timeout-giveup [timeout=%s]", arrayOfObject1);
      throw localov;
    }
  }

  private byte[] a(HttpEntity paramHttpEntity)
    throws IOException, ot
  {
    pf localpf = new pf(this.c, (int)paramHttpEntity.getContentLength());
    byte[] arrayOfByte1 = null;
    InputStream localInputStream;
    try
    {
      localInputStream = paramHttpEntity.getContent();
      arrayOfByte1 = null;
      if (localInputStream == null)
        throw new ot();
    }
    finally
    {
    }
    try
    {
      paramHttpEntity.consumeContent();
      this.c.a(arrayOfByte1);
      localpf.close();
      throw localObject;
      arrayOfByte1 = this.c.a(1024);
      while (true)
      {
        int i = localInputStream.read(arrayOfByte1);
        if (i == -1)
          break;
        localpf.write(arrayOfByte1, 0, i);
      }
      byte[] arrayOfByte2 = localpf.toByteArray();
      try
      {
        paramHttpEntity.consumeContent();
        this.c.a(arrayOfByte1);
        localpf.close();
        return arrayOfByte2;
      }
      catch (IOException localIOException2)
      {
        while (true)
          on.a("Error occured when calling consumingContent", new Object[0]);
      }
    }
    catch (IOException localIOException1)
    {
      while (true)
        on.a("Error occured when calling consumingContent", new Object[0]);
    }
  }

  // ERROR //
  public final oh a(oi<?> paramoi)
    throws ov
  {
    // Byte code:
    //   0: invokestatic 166	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore_2
    //   4: aconst_null
    //   5: astore 4
    //   7: invokestatic 172	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   10: astore 5
    //   12: new 174	java/util/HashMap
    //   15: dup
    //   16: invokespecial 175	java/util/HashMap:<init>	()V
    //   19: astore 6
    //   21: aload_1
    //   22: invokevirtual 179	com/yandex/mobile/ads/impl/oi:h	()Lcom/yandex/mobile/ads/impl/ob$a;
    //   25: astore 15
    //   27: aload 15
    //   29: ifnull +61 -> 90
    //   32: aload 15
    //   34: getfield 184	com/yandex/mobile/ads/impl/ob$a:b	Ljava/lang/String;
    //   37: ifnull +18 -> 55
    //   40: aload 6
    //   42: ldc 186
    //   44: aload 15
    //   46: getfield 184	com/yandex/mobile/ads/impl/ob$a:b	Ljava/lang/String;
    //   49: invokeinterface 70 3 0
    //   54: pop
    //   55: aload 15
    //   57: getfield 189	com/yandex/mobile/ads/impl/ob$a:d	J
    //   60: lconst_0
    //   61: lcmp
    //   62: ifle +28 -> 90
    //   65: aload 6
    //   67: ldc 191
    //   69: new 193	java/util/Date
    //   72: dup
    //   73: aload 15
    //   75: getfield 189	com/yandex/mobile/ads/impl/ob$a:d	J
    //   78: invokespecial 196	java/util/Date:<init>	(J)V
    //   81: invokestatic 202	org/apache/http/impl/cookie/DateUtils:formatDate	(Ljava/util/Date;)Ljava/lang/String;
    //   84: invokeinterface 70 3 0
    //   89: pop
    //   90: aload_0
    //   91: getfield 41	com/yandex/mobile/ads/impl/ow:b	Lcom/yandex/mobile/ads/impl/pa;
    //   94: aload_1
    //   95: aload 6
    //   97: invokeinterface 207 3 0
    //   102: astore 16
    //   104: aload 16
    //   106: invokeinterface 213 1 0
    //   111: astore 17
    //   113: aload 17
    //   115: invokeinterface 218 1 0
    //   120: istore 18
    //   122: aload 16
    //   124: invokeinterface 222 1 0
    //   129: invokestatic 224	com/yandex/mobile/ads/impl/ow:a	([Lorg/apache/http/Header;)Ljava/util/Map;
    //   132: astore 5
    //   134: iload 18
    //   136: sipush 304
    //   139: if_icmpne +73 -> 212
    //   142: aload_1
    //   143: invokevirtual 179	com/yandex/mobile/ads/impl/oi:h	()Lcom/yandex/mobile/ads/impl/ob$a;
    //   146: astore 19
    //   148: aload 19
    //   150: ifnonnull +23 -> 173
    //   153: new 226	com/yandex/mobile/ads/impl/oh
    //   156: dup
    //   157: sipush 304
    //   160: aconst_null
    //   161: aload 5
    //   163: iconst_1
    //   164: invokestatic 166	android/os/SystemClock:elapsedRealtime	()J
    //   167: lload_2
    //   168: lsub
    //   169: invokespecial 229	com/yandex/mobile/ads/impl/oh:<init>	(I[BLjava/util/Map;ZJ)V
    //   172: areturn
    //   173: aload 19
    //   175: getfield 233	com/yandex/mobile/ads/impl/ob$a:g	Ljava/util/Map;
    //   178: aload 5
    //   180: invokeinterface 237 2 0
    //   185: new 226	com/yandex/mobile/ads/impl/oh
    //   188: dup
    //   189: sipush 304
    //   192: aload 19
    //   194: getfield 240	com/yandex/mobile/ads/impl/ob$a:a	[B
    //   197: aload 19
    //   199: getfield 233	com/yandex/mobile/ads/impl/ob$a:g	Ljava/util/Map;
    //   202: iconst_1
    //   203: invokestatic 166	android/os/SystemClock:elapsedRealtime	()J
    //   206: lload_2
    //   207: lsub
    //   208: invokespecial 229	com/yandex/mobile/ads/impl/oh:<init>	(I[BLjava/util/Map;ZJ)V
    //   211: areturn
    //   212: aload 16
    //   214: invokeinterface 244 1 0
    //   219: ifnull +149 -> 368
    //   222: aload_0
    //   223: aload 16
    //   225: invokeinterface 244 1 0
    //   230: invokespecial 246	com/yandex/mobile/ads/impl/ow:a	(Lorg/apache/http/HttpEntity;)[B
    //   233: astore 25
    //   235: aload 25
    //   237: astore 8
    //   239: invokestatic 166	android/os/SystemClock:elapsedRealtime	()J
    //   242: lload_2
    //   243: lsub
    //   244: lstore 20
    //   246: getstatic 23	com/yandex/mobile/ads/impl/ow:a	Z
    //   249: ifne +13 -> 262
    //   252: lload 20
    //   254: getstatic 25	com/yandex/mobile/ads/impl/ow:d	I
    //   257: i2l
    //   258: lcmp
    //   259: ifle +452 -> 711
    //   262: iconst_5
    //   263: anewarray 4	java/lang/Object
    //   266: astore 22
    //   268: aload 22
    //   270: iconst_0
    //   271: aload_1
    //   272: aastore
    //   273: aload 22
    //   275: iconst_1
    //   276: lload 20
    //   278: invokestatic 251	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   281: aastore
    //   282: aload 8
    //   284: ifnull +92 -> 376
    //   287: aload 8
    //   289: arraylength
    //   290: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   293: astore 23
    //   295: aload 22
    //   297: iconst_2
    //   298: aload 23
    //   300: aastore
    //   301: aload 22
    //   303: iconst_3
    //   304: aload 17
    //   306: invokeinterface 218 1 0
    //   311: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   314: aastore
    //   315: aload 22
    //   317: iconst_4
    //   318: aload_1
    //   319: invokevirtual 79	com/yandex/mobile/ads/impl/oi:q	()Lcom/yandex/mobile/ads/impl/om;
    //   322: invokeinterface 253 1 0
    //   327: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   330: aastore
    //   331: ldc 255
    //   333: aload 22
    //   335: invokestatic 257	com/yandex/mobile/ads/impl/on:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   338: goto +373 -> 711
    //   341: new 105	java/io/IOException
    //   344: dup
    //   345: invokespecial 258	java/io/IOException:<init>	()V
    //   348: athrow
    //   349: astore 14
    //   351: ldc_w 260
    //   354: aload_1
    //   355: new 262	com/yandex/mobile/ads/impl/ou
    //   358: dup
    //   359: invokespecial 263	com/yandex/mobile/ads/impl/ou:<init>	()V
    //   362: invokestatic 265	com/yandex/mobile/ads/impl/ow:a	(Ljava/lang/String;Lcom/yandex/mobile/ads/impl/oi;Lcom/yandex/mobile/ads/impl/ov;)V
    //   365: goto -361 -> 4
    //   368: iconst_0
    //   369: newarray byte
    //   371: astore 8
    //   373: goto -134 -> 239
    //   376: ldc_w 267
    //   379: astore 23
    //   381: goto -86 -> 295
    //   384: new 226	com/yandex/mobile/ads/impl/oh
    //   387: dup
    //   388: iload 18
    //   390: aload 8
    //   392: aload 5
    //   394: iconst_0
    //   395: invokestatic 166	android/os/SystemClock:elapsedRealtime	()J
    //   398: lload_2
    //   399: lsub
    //   400: invokespecial 229	com/yandex/mobile/ads/impl/oh:<init>	(I[BLjava/util/Map;ZJ)V
    //   403: astore 24
    //   405: aload 24
    //   407: areturn
    //   408: astore 13
    //   410: ldc_w 269
    //   413: aload_1
    //   414: new 262	com/yandex/mobile/ads/impl/ou
    //   417: dup
    //   418: invokespecial 263	com/yandex/mobile/ads/impl/ou:<init>	()V
    //   421: invokestatic 265	com/yandex/mobile/ads/impl/ow:a	(Ljava/lang/String;Lcom/yandex/mobile/ads/impl/oi;Lcom/yandex/mobile/ads/impl/ov;)V
    //   424: goto -420 -> 4
    //   427: astore 12
    //   429: new 271	java/lang/RuntimeException
    //   432: dup
    //   433: new 273	java/lang/StringBuilder
    //   436: dup
    //   437: ldc_w 275
    //   440: invokespecial 278	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   443: aload_1
    //   444: invokevirtual 280	com/yandex/mobile/ads/impl/oi:b	()Ljava/lang/String;
    //   447: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: aload 12
    //   455: invokespecial 290	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   458: athrow
    //   459: astore 7
    //   461: aconst_null
    //   462: astore 8
    //   464: aload 4
    //   466: ifnull +109 -> 575
    //   469: aload 4
    //   471: invokeinterface 213 1 0
    //   476: invokeinterface 218 1 0
    //   481: istore 9
    //   483: iconst_2
    //   484: anewarray 4	java/lang/Object
    //   487: astore 10
    //   489: aload 10
    //   491: iconst_0
    //   492: iload 9
    //   494: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   497: aastore
    //   498: aload 10
    //   500: iconst_1
    //   501: aload_1
    //   502: invokevirtual 280	com/yandex/mobile/ads/impl/oi:b	()Ljava/lang/String;
    //   505: aastore
    //   506: ldc_w 292
    //   509: aload 10
    //   511: invokestatic 294	com/yandex/mobile/ads/impl/on:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   514: aload 8
    //   516: ifnull +157 -> 673
    //   519: new 226	com/yandex/mobile/ads/impl/oh
    //   522: dup
    //   523: iload 9
    //   525: aload 8
    //   527: aload 5
    //   529: iconst_0
    //   530: invokestatic 166	android/os/SystemClock:elapsedRealtime	()J
    //   533: lload_2
    //   534: lsub
    //   535: invokespecial 229	com/yandex/mobile/ads/impl/oh:<init>	(I[BLjava/util/Map;ZJ)V
    //   538: astore 11
    //   540: iload 9
    //   542: sipush 401
    //   545: if_icmpeq +11 -> 556
    //   548: iload 9
    //   550: sipush 403
    //   553: if_icmpne +32 -> 585
    //   556: ldc_w 296
    //   559: aload_1
    //   560: new 298	com/yandex/mobile/ads/impl/oo
    //   563: dup
    //   564: aload 11
    //   566: invokespecial 301	com/yandex/mobile/ads/impl/oo:<init>	(Lcom/yandex/mobile/ads/impl/oh;)V
    //   569: invokestatic 265	com/yandex/mobile/ads/impl/ow:a	(Ljava/lang/String;Lcom/yandex/mobile/ads/impl/oi;Lcom/yandex/mobile/ads/impl/ov;)V
    //   572: goto -568 -> 4
    //   575: new 303	com/yandex/mobile/ads/impl/or
    //   578: dup
    //   579: aload 7
    //   581: invokespecial 306	com/yandex/mobile/ads/impl/or:<init>	(Ljava/lang/Throwable;)V
    //   584: athrow
    //   585: iload 9
    //   587: sipush 400
    //   590: if_icmplt +21 -> 611
    //   593: iload 9
    //   595: sipush 499
    //   598: if_icmpgt +13 -> 611
    //   601: new 308	com/yandex/mobile/ads/impl/op
    //   604: dup
    //   605: aload 11
    //   607: invokespecial 309	com/yandex/mobile/ads/impl/op:<init>	(Lcom/yandex/mobile/ads/impl/oh;)V
    //   610: athrow
    //   611: iload 9
    //   613: sipush 500
    //   616: if_icmplt +47 -> 663
    //   619: iload 9
    //   621: sipush 599
    //   624: if_icmpgt +39 -> 663
    //   627: aload_1
    //   628: invokevirtual 313	com/yandex/mobile/ads/impl/oi:n	()Z
    //   631: ifeq +22 -> 653
    //   634: ldc_w 315
    //   637: aload_1
    //   638: new 107	com/yandex/mobile/ads/impl/ot
    //   641: dup
    //   642: aload 11
    //   644: invokespecial 316	com/yandex/mobile/ads/impl/ot:<init>	(Lcom/yandex/mobile/ads/impl/oh;)V
    //   647: invokestatic 265	com/yandex/mobile/ads/impl/ow:a	(Ljava/lang/String;Lcom/yandex/mobile/ads/impl/oi;Lcom/yandex/mobile/ads/impl/ov;)V
    //   650: goto -646 -> 4
    //   653: new 107	com/yandex/mobile/ads/impl/ot
    //   656: dup
    //   657: aload 11
    //   659: invokespecial 316	com/yandex/mobile/ads/impl/ot:<init>	(Lcom/yandex/mobile/ads/impl/oh;)V
    //   662: athrow
    //   663: new 107	com/yandex/mobile/ads/impl/ot
    //   666: dup
    //   667: aload 11
    //   669: invokespecial 316	com/yandex/mobile/ads/impl/ot:<init>	(Lcom/yandex/mobile/ads/impl/oh;)V
    //   672: athrow
    //   673: ldc_w 318
    //   676: aload_1
    //   677: new 320	com/yandex/mobile/ads/impl/oq
    //   680: dup
    //   681: invokespecial 321	com/yandex/mobile/ads/impl/oq:<init>	()V
    //   684: invokestatic 265	com/yandex/mobile/ads/impl/ow:a	(Ljava/lang/String;Lcom/yandex/mobile/ads/impl/oi;Lcom/yandex/mobile/ads/impl/ov;)V
    //   687: goto -683 -> 4
    //   690: astore 7
    //   692: aload 16
    //   694: astore 4
    //   696: aconst_null
    //   697: astore 8
    //   699: goto -235 -> 464
    //   702: astore 7
    //   704: aload 16
    //   706: astore 4
    //   708: goto -244 -> 464
    //   711: iload 18
    //   713: sipush 200
    //   716: if_icmplt -375 -> 341
    //   719: iload 18
    //   721: sipush 299
    //   724: if_icmple -340 -> 384
    //   727: goto -386 -> 341
    //
    // Exception table:
    //   from	to	target	type
    //   12	27	349	java/net/SocketTimeoutException
    //   32	55	349	java/net/SocketTimeoutException
    //   55	90	349	java/net/SocketTimeoutException
    //   90	104	349	java/net/SocketTimeoutException
    //   104	134	349	java/net/SocketTimeoutException
    //   142	148	349	java/net/SocketTimeoutException
    //   153	173	349	java/net/SocketTimeoutException
    //   173	212	349	java/net/SocketTimeoutException
    //   212	235	349	java/net/SocketTimeoutException
    //   239	262	349	java/net/SocketTimeoutException
    //   262	282	349	java/net/SocketTimeoutException
    //   287	295	349	java/net/SocketTimeoutException
    //   295	338	349	java/net/SocketTimeoutException
    //   341	349	349	java/net/SocketTimeoutException
    //   368	373	349	java/net/SocketTimeoutException
    //   384	405	349	java/net/SocketTimeoutException
    //   12	27	408	org/apache/http/conn/ConnectTimeoutException
    //   32	55	408	org/apache/http/conn/ConnectTimeoutException
    //   55	90	408	org/apache/http/conn/ConnectTimeoutException
    //   90	104	408	org/apache/http/conn/ConnectTimeoutException
    //   104	134	408	org/apache/http/conn/ConnectTimeoutException
    //   142	148	408	org/apache/http/conn/ConnectTimeoutException
    //   153	173	408	org/apache/http/conn/ConnectTimeoutException
    //   173	212	408	org/apache/http/conn/ConnectTimeoutException
    //   212	235	408	org/apache/http/conn/ConnectTimeoutException
    //   239	262	408	org/apache/http/conn/ConnectTimeoutException
    //   262	282	408	org/apache/http/conn/ConnectTimeoutException
    //   287	295	408	org/apache/http/conn/ConnectTimeoutException
    //   295	338	408	org/apache/http/conn/ConnectTimeoutException
    //   341	349	408	org/apache/http/conn/ConnectTimeoutException
    //   368	373	408	org/apache/http/conn/ConnectTimeoutException
    //   384	405	408	org/apache/http/conn/ConnectTimeoutException
    //   12	27	427	java/net/MalformedURLException
    //   32	55	427	java/net/MalformedURLException
    //   55	90	427	java/net/MalformedURLException
    //   90	104	427	java/net/MalformedURLException
    //   104	134	427	java/net/MalformedURLException
    //   142	148	427	java/net/MalformedURLException
    //   153	173	427	java/net/MalformedURLException
    //   173	212	427	java/net/MalformedURLException
    //   212	235	427	java/net/MalformedURLException
    //   239	262	427	java/net/MalformedURLException
    //   262	282	427	java/net/MalformedURLException
    //   287	295	427	java/net/MalformedURLException
    //   295	338	427	java/net/MalformedURLException
    //   341	349	427	java/net/MalformedURLException
    //   368	373	427	java/net/MalformedURLException
    //   384	405	427	java/net/MalformedURLException
    //   12	27	459	java/io/IOException
    //   32	55	459	java/io/IOException
    //   55	90	459	java/io/IOException
    //   90	104	459	java/io/IOException
    //   104	134	690	java/io/IOException
    //   142	148	690	java/io/IOException
    //   153	173	690	java/io/IOException
    //   173	212	690	java/io/IOException
    //   212	235	690	java/io/IOException
    //   368	373	690	java/io/IOException
    //   239	262	702	java/io/IOException
    //   262	282	702	java/io/IOException
    //   287	295	702	java/io/IOException
    //   295	338	702	java/io/IOException
    //   341	349	702	java/io/IOException
    //   384	405	702	java/io/IOException
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ow
 * JD-Core Version:    0.6.2
 */