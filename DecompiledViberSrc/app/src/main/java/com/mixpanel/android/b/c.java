package com.mixpanel.android.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;

public class c
  implements i
{
  private static boolean a;

  private boolean a(h paramh)
  {
    boolean bool1 = false;
    if (paramh != null);
    try
    {
      boolean bool2 = paramh.a();
      bool1 = false;
      if (bool2)
        bool1 = true;
      return bool1;
    }
    catch (Exception localException)
    {
      f.a("MixpanelAPI.Message", "Client State should not throw exception, will assume is not on offline mode", localException);
    }
    return false;
  }

  private static byte[] a(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[8192];
    while (true)
    {
      int i = paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
      if (i == -1)
        break;
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    localByteArrayOutputStream.flush();
    return localByteArrayOutputStream.toByteArray();
  }

  public void a()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        while (true)
        {
          try
          {
            InetAddress localInetAddress1 = InetAddress.getByName("api.mixpanel.com");
            InetAddress localInetAddress2 = InetAddress.getByName("decide.mixpanel.com");
            boolean bool;
            if ((!localInetAddress1.isLoopbackAddress()) && (!localInetAddress1.isAnyLocalAddress()) && (!localInetAddress2.isLoopbackAddress()))
              if (localInetAddress2.isAnyLocalAddress())
              {
                break label71;
                c.a(bool);
                if (c.b())
                  f.a("MixpanelAPI.Message", "AdBlocker is enabled. Won't be able to use Mixpanel services.");
              }
              else
              {
                bool = false;
                continue;
              }
          }
          catch (Exception localException)
          {
            return;
          }
          label71: bool = true;
        }
      }
    }).start();
  }

  @SuppressLint({"MissingPermission"})
  public boolean a(Context paramContext, h paramh)
  {
    if (a);
    while (a(paramh))
      return false;
    while (true)
    {
      try
      {
        NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (localNetworkInfo == null)
        {
          f.a("MixpanelAPI.Message", "A default network has not been set so we cannot be certain whether we are offline");
          return true;
        }
        boolean bool = localNetworkInfo.isConnectedOrConnecting();
        StringBuilder localStringBuilder = new StringBuilder().append("ConnectivityManager says we ");
        if (bool)
        {
          str = "are";
          f.a("MixpanelAPI.Message", str + " online");
          return bool;
        }
      }
      catch (SecurityException localSecurityException)
      {
        f.a("MixpanelAPI.Message", "Don't have permission to check connectivity, will assume we are online");
        return true;
      }
      String str = "are not";
    }
  }

  // ERROR //
  public byte[] a(String paramString, java.util.Map<String, Object> paramMap, javax.net.ssl.SSLSocketFactory paramSSLSocketFactory)
    throws i.a, IOException
  {
    // Byte code:
    //   0: ldc 22
    //   2: new 103	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   9: ldc 129
    //   11: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_1
    //   15: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21: invokestatic 96	com/mixpanel/android/b/f:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: aconst_null
    //   25: astore 4
    //   27: iconst_0
    //   28: istore 5
    //   30: iconst_0
    //   31: istore 6
    //   33: iload 5
    //   35: iconst_3
    //   36: if_icmpge +483 -> 519
    //   39: iload 6
    //   41: ifne +478 -> 519
    //   44: aconst_null
    //   45: astore 7
    //   47: aconst_null
    //   48: astore 8
    //   50: aconst_null
    //   51: astore 9
    //   53: aconst_null
    //   54: astore 10
    //   56: new 131	java/net/URL
    //   59: dup
    //   60: aload_1
    //   61: invokespecial 134	java/net/URL:<init>	(Ljava/lang/String;)V
    //   64: invokevirtual 138	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   67: checkcast 140	java/net/HttpURLConnection
    //   70: astore 26
    //   72: aload_3
    //   73: ifnull +20 -> 93
    //   76: aload 26
    //   78: instanceof 142
    //   81: ifeq +12 -> 93
    //   84: aload 26
    //   86: checkcast 142	javax/net/ssl/HttpsURLConnection
    //   89: aload_3
    //   90: invokevirtual 146	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   93: aload 26
    //   95: sipush 2000
    //   98: invokevirtual 150	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   101: aload 26
    //   103: sipush 30000
    //   106: invokevirtual 153	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   109: aload_2
    //   110: ifnull +251 -> 361
    //   113: new 155	android/net/Uri$Builder
    //   116: dup
    //   117: invokespecial 156	android/net/Uri$Builder:<init>	()V
    //   120: astore 30
    //   122: aload_2
    //   123: invokeinterface 162 1 0
    //   128: invokeinterface 168 1 0
    //   133: astore 31
    //   135: aload 31
    //   137: invokeinterface 173 1 0
    //   142: ifeq +134 -> 276
    //   145: aload 31
    //   147: invokeinterface 177 1 0
    //   152: checkcast 179	java/util/Map$Entry
    //   155: astore 53
    //   157: aload 30
    //   159: aload 53
    //   161: invokeinterface 182 1 0
    //   166: checkcast 184	java/lang/String
    //   169: aload 53
    //   171: invokeinterface 187 1 0
    //   176: invokevirtual 188	java/lang/Object:toString	()Ljava/lang/String;
    //   179: invokevirtual 192	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   182: pop
    //   183: goto -48 -> 135
    //   186: astore 29
    //   188: aload 26
    //   190: astore 13
    //   192: aload 4
    //   194: astore 12
    //   196: ldc 22
    //   198: ldc 194
    //   200: invokestatic 196	com/mixpanel/android/b/f:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: iload 5
    //   205: iconst_1
    //   206: iadd
    //   207: istore 18
    //   209: aload 9
    //   211: ifnull +8 -> 219
    //   214: aload 9
    //   216: invokevirtual 201	java/io/BufferedOutputStream:close	()V
    //   219: aload 8
    //   221: ifnull +8 -> 229
    //   224: aload 8
    //   226: invokevirtual 204	java/io/OutputStream:close	()V
    //   229: aload 7
    //   231: ifnull +8 -> 239
    //   234: aload 7
    //   236: invokevirtual 205	java/io/InputStream:close	()V
    //   239: aload 13
    //   241: ifnull +716 -> 957
    //   244: aload 13
    //   246: invokevirtual 208	java/net/HttpURLConnection:disconnect	()V
    //   249: aload 12
    //   251: astore 19
    //   253: iload 18
    //   255: istore 20
    //   257: iload 6
    //   259: istore 21
    //   261: iload 21
    //   263: istore 6
    //   265: iload 20
    //   267: istore 5
    //   269: aload 19
    //   271: astore 4
    //   273: goto -240 -> 33
    //   276: aload 30
    //   278: invokevirtual 212	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   281: invokevirtual 217	android/net/Uri:getEncodedQuery	()Ljava/lang/String;
    //   284: astore 32
    //   286: aload 26
    //   288: aload 32
    //   290: invokevirtual 220	java/lang/String:getBytes	()[B
    //   293: arraylength
    //   294: invokevirtual 223	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   297: aload 26
    //   299: iconst_1
    //   300: invokevirtual 227	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   303: aload 26
    //   305: ldc 229
    //   307: invokevirtual 232	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   310: aload 26
    //   312: invokevirtual 236	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   315: astore 33
    //   317: new 198	java/io/BufferedOutputStream
    //   320: dup
    //   321: aload 33
    //   323: invokespecial 239	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   326: astore 34
    //   328: aload 34
    //   330: aload 32
    //   332: ldc 241
    //   334: invokevirtual 244	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   337: invokevirtual 247	java/io/BufferedOutputStream:write	([B)V
    //   340: aload 34
    //   342: invokevirtual 248	java/io/BufferedOutputStream:flush	()V
    //   345: aload 34
    //   347: invokevirtual 201	java/io/BufferedOutputStream:close	()V
    //   350: aload 33
    //   352: invokevirtual 204	java/io/OutputStream:close	()V
    //   355: aconst_null
    //   356: astore 8
    //   358: aconst_null
    //   359: astore 9
    //   361: aload 26
    //   363: invokevirtual 252	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   366: astore 41
    //   368: aload 41
    //   370: invokestatic 254	com/mixpanel/android/b/c:a	(Ljava/io/InputStream;)[B
    //   373: astore 45
    //   375: aload 45
    //   377: astore 19
    //   379: aload 41
    //   381: invokevirtual 205	java/io/InputStream:close	()V
    //   384: iconst_0
    //   385: ifeq +7 -> 392
    //   388: aconst_null
    //   389: invokevirtual 201	java/io/BufferedOutputStream:close	()V
    //   392: iconst_0
    //   393: ifeq +7 -> 400
    //   396: aconst_null
    //   397: invokevirtual 204	java/io/OutputStream:close	()V
    //   400: iconst_0
    //   401: ifeq +7 -> 408
    //   404: aconst_null
    //   405: invokevirtual 205	java/io/InputStream:close	()V
    //   408: aload 26
    //   410: ifnull +562 -> 972
    //   413: aload 26
    //   415: invokevirtual 208	java/net/HttpURLConnection:disconnect	()V
    //   418: iconst_1
    //   419: istore 21
    //   421: iload 5
    //   423: istore 20
    //   425: goto -164 -> 261
    //   428: astore 25
    //   430: aload 10
    //   432: invokevirtual 258	java/net/HttpURLConnection:getResponseCode	()I
    //   435: sipush 500
    //   438: if_icmplt +78 -> 516
    //   441: aload 10
    //   443: invokevirtual 258	java/net/HttpURLConnection:getResponseCode	()I
    //   446: sipush 599
    //   449: if_icmpgt +67 -> 516
    //   452: new 125	com/mixpanel/android/b/i$a
    //   455: dup
    //   456: ldc_w 260
    //   459: aload 10
    //   461: ldc_w 262
    //   464: invokevirtual 266	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   467: invokespecial 268	com/mixpanel/android/b/i$a:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: athrow
    //   471: astore 14
    //   473: aload 9
    //   475: ifnull +8 -> 483
    //   478: aload 9
    //   480: invokevirtual 201	java/io/BufferedOutputStream:close	()V
    //   483: aload 8
    //   485: ifnull +8 -> 493
    //   488: aload 8
    //   490: invokevirtual 204	java/io/OutputStream:close	()V
    //   493: aload 7
    //   495: ifnull +8 -> 503
    //   498: aload 7
    //   500: invokevirtual 205	java/io/InputStream:close	()V
    //   503: aload 10
    //   505: ifnull +8 -> 513
    //   508: aload 10
    //   510: invokevirtual 208	java/net/HttpURLConnection:disconnect	()V
    //   513: aload 14
    //   515: athrow
    //   516: aload 25
    //   518: athrow
    //   519: iload 5
    //   521: iconst_3
    //   522: if_icmplt +11 -> 533
    //   525: ldc 22
    //   527: ldc_w 270
    //   530: invokestatic 96	com/mixpanel/android/b/f:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   533: aload 4
    //   535: areturn
    //   536: astore 49
    //   538: goto -146 -> 392
    //   541: astore 48
    //   543: goto -143 -> 400
    //   546: astore 47
    //   548: goto -140 -> 408
    //   551: astore 24
    //   553: goto -334 -> 219
    //   556: astore 23
    //   558: goto -329 -> 229
    //   561: astore 22
    //   563: goto -324 -> 239
    //   566: astore 17
    //   568: goto -85 -> 483
    //   571: astore 16
    //   573: goto -80 -> 493
    //   576: astore 15
    //   578: goto -75 -> 503
    //   581: astore 14
    //   583: aload 13
    //   585: astore 10
    //   587: goto -114 -> 473
    //   590: astore 28
    //   592: aload 26
    //   594: astore 10
    //   596: aload 28
    //   598: astore 14
    //   600: aconst_null
    //   601: astore 9
    //   603: aconst_null
    //   604: astore 8
    //   606: aconst_null
    //   607: astore 7
    //   609: goto -136 -> 473
    //   612: astore 52
    //   614: aload 33
    //   616: astore 8
    //   618: aload 52
    //   620: astore 14
    //   622: aload 26
    //   624: astore 10
    //   626: aconst_null
    //   627: astore 9
    //   629: aconst_null
    //   630: astore 7
    //   632: goto -159 -> 473
    //   635: astore 37
    //   637: aload 34
    //   639: astore 9
    //   641: aload 33
    //   643: astore 8
    //   645: aload 26
    //   647: astore 10
    //   649: aload 37
    //   651: astore 14
    //   653: aconst_null
    //   654: astore 7
    //   656: goto -183 -> 473
    //   659: astore 40
    //   661: aload 33
    //   663: astore 8
    //   665: aload 26
    //   667: astore 10
    //   669: aload 40
    //   671: astore 14
    //   673: aconst_null
    //   674: astore 9
    //   676: aconst_null
    //   677: astore 7
    //   679: goto -206 -> 473
    //   682: astore 44
    //   684: aload 41
    //   686: astore 7
    //   688: aload 26
    //   690: astore 10
    //   692: aload 44
    //   694: astore 14
    //   696: aconst_null
    //   697: astore 9
    //   699: aconst_null
    //   700: astore 8
    //   702: goto -229 -> 473
    //   705: astore 27
    //   707: aload 26
    //   709: astore 10
    //   711: aload 27
    //   713: astore 25
    //   715: aconst_null
    //   716: astore 9
    //   718: aconst_null
    //   719: astore 8
    //   721: aconst_null
    //   722: astore 7
    //   724: goto -294 -> 430
    //   727: astore 51
    //   729: aload 33
    //   731: astore 8
    //   733: aload 51
    //   735: astore 25
    //   737: aload 26
    //   739: astore 10
    //   741: aconst_null
    //   742: astore 9
    //   744: aconst_null
    //   745: astore 7
    //   747: goto -317 -> 430
    //   750: astore 36
    //   752: aload 34
    //   754: astore 9
    //   756: aload 33
    //   758: astore 8
    //   760: aload 26
    //   762: astore 10
    //   764: aload 36
    //   766: astore 25
    //   768: aconst_null
    //   769: astore 7
    //   771: goto -341 -> 430
    //   774: astore 39
    //   776: aload 33
    //   778: astore 8
    //   780: aload 26
    //   782: astore 10
    //   784: aload 39
    //   786: astore 25
    //   788: aconst_null
    //   789: astore 9
    //   791: aconst_null
    //   792: astore 7
    //   794: goto -364 -> 430
    //   797: astore 43
    //   799: aload 41
    //   801: astore 7
    //   803: aload 26
    //   805: astore 10
    //   807: aload 43
    //   809: astore 25
    //   811: aconst_null
    //   812: astore 9
    //   814: aconst_null
    //   815: astore 8
    //   817: goto -387 -> 430
    //   820: astore 11
    //   822: aload 4
    //   824: astore 12
    //   826: aconst_null
    //   827: astore 13
    //   829: aconst_null
    //   830: astore 9
    //   832: aconst_null
    //   833: astore 8
    //   835: aconst_null
    //   836: astore 7
    //   838: goto -642 -> 196
    //   841: astore 50
    //   843: aload 33
    //   845: astore 8
    //   847: aload 4
    //   849: astore 12
    //   851: aload 26
    //   853: astore 13
    //   855: aconst_null
    //   856: astore 9
    //   858: aconst_null
    //   859: astore 7
    //   861: goto -665 -> 196
    //   864: astore 35
    //   866: aload 34
    //   868: astore 9
    //   870: aload 33
    //   872: astore 8
    //   874: aload 26
    //   876: astore 13
    //   878: aload 4
    //   880: astore 12
    //   882: aconst_null
    //   883: astore 7
    //   885: goto -689 -> 196
    //   888: astore 38
    //   890: aload 33
    //   892: astore 8
    //   894: aload 26
    //   896: astore 13
    //   898: aload 4
    //   900: astore 12
    //   902: aconst_null
    //   903: astore 9
    //   905: aconst_null
    //   906: astore 7
    //   908: goto -712 -> 196
    //   911: astore 42
    //   913: aload 26
    //   915: astore 13
    //   917: aload 41
    //   919: astore 7
    //   921: aload 4
    //   923: astore 12
    //   925: aconst_null
    //   926: astore 9
    //   928: aconst_null
    //   929: astore 8
    //   931: goto -735 -> 196
    //   934: astore 46
    //   936: aload 41
    //   938: astore 7
    //   940: aload 19
    //   942: astore 12
    //   944: aload 26
    //   946: astore 13
    //   948: aconst_null
    //   949: astore 9
    //   951: aconst_null
    //   952: astore 8
    //   954: goto -758 -> 196
    //   957: aload 12
    //   959: astore 19
    //   961: iload 18
    //   963: istore 20
    //   965: iload 6
    //   967: istore 21
    //   969: goto -708 -> 261
    //   972: iconst_1
    //   973: istore 21
    //   975: iload 5
    //   977: istore 20
    //   979: goto -718 -> 261
    //
    // Exception table:
    //   from	to	target	type
    //   76	93	186	java/io/EOFException
    //   93	109	186	java/io/EOFException
    //   113	135	186	java/io/EOFException
    //   135	183	186	java/io/EOFException
    //   276	317	186	java/io/EOFException
    //   361	368	186	java/io/EOFException
    //   56	72	428	java/io/IOException
    //   56	72	471	finally
    //   430	471	471	finally
    //   516	519	471	finally
    //   388	392	536	java/io/IOException
    //   396	400	541	java/io/IOException
    //   404	408	546	java/io/IOException
    //   214	219	551	java/io/IOException
    //   224	229	556	java/io/IOException
    //   234	239	561	java/io/IOException
    //   478	483	566	java/io/IOException
    //   488	493	571	java/io/IOException
    //   498	503	576	java/io/IOException
    //   196	203	581	finally
    //   76	93	590	finally
    //   93	109	590	finally
    //   113	135	590	finally
    //   135	183	590	finally
    //   276	317	590	finally
    //   361	368	590	finally
    //   317	328	612	finally
    //   328	350	635	finally
    //   350	355	659	finally
    //   368	375	682	finally
    //   379	384	682	finally
    //   76	93	705	java/io/IOException
    //   93	109	705	java/io/IOException
    //   113	135	705	java/io/IOException
    //   135	183	705	java/io/IOException
    //   276	317	705	java/io/IOException
    //   361	368	705	java/io/IOException
    //   317	328	727	java/io/IOException
    //   328	350	750	java/io/IOException
    //   350	355	774	java/io/IOException
    //   368	375	797	java/io/IOException
    //   379	384	797	java/io/IOException
    //   56	72	820	java/io/EOFException
    //   317	328	841	java/io/EOFException
    //   328	350	864	java/io/EOFException
    //   350	355	888	java/io/EOFException
    //   368	375	911	java/io/EOFException
    //   379	384	934	java/io/EOFException
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.b.c
 * JD-Core Version:    0.6.2
 */