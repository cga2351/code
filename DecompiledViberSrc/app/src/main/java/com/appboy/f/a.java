package com.appboy.f;

import android.net.Uri;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class a
{
  public static final List<String> a = Collections.unmodifiableList(Arrays.asList(new String[] { "http", "https", "ftp", "ftps", "about", "javascript" }));
  private static final String b = c.a(a.class);

  // ERROR //
  public static File a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: sipush 1337
    //   6: invokestatic 60	android/net/TrafficStats:setThreadStatsTag	(I)V
    //   9: invokestatic 66	com/appboy/a:j	()Z
    //   12: ifeq +31 -> 43
    //   15: getstatic 18	com/appboy/f/a:b	Ljava/lang/String;
    //   18: new 68	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   25: ldc 71
    //   27: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 83	com/appboy/f/c:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   40: pop
    //   41: aconst_null
    //   42: areturn
    //   43: aload_0
    //   44: invokestatic 88	com/appboy/f/i:c	(Ljava/lang/String;)Z
    //   47: ifeq +14 -> 61
    //   50: getstatic 18	com/appboy/f/a:b	Ljava/lang/String;
    //   53: ldc 90
    //   55: invokestatic 83	com/appboy/f/c:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   58: pop
    //   59: aconst_null
    //   60: areturn
    //   61: aload_1
    //   62: invokestatic 88	com/appboy/f/i:c	(Ljava/lang/String;)Z
    //   65: ifeq +14 -> 79
    //   68: getstatic 18	com/appboy/f/a:b	Ljava/lang/String;
    //   71: ldc 92
    //   73: invokestatic 83	com/appboy/f/c:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   76: pop
    //   77: aconst_null
    //   78: areturn
    //   79: aload_2
    //   80: invokestatic 88	com/appboy/f/i:c	(Ljava/lang/String;)Z
    //   83: ifeq +14 -> 97
    //   86: getstatic 18	com/appboy/f/a:b	Ljava/lang/String;
    //   89: ldc 94
    //   91: invokestatic 83	com/appboy/f/c:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   94: pop
    //   95: aconst_null
    //   96: areturn
    //   97: new 96	java/io/File
    //   100: dup
    //   101: aload_0
    //   102: invokespecial 99	java/io/File:<init>	(Ljava/lang/String;)V
    //   105: invokevirtual 102	java/io/File:mkdirs	()Z
    //   108: pop
    //   109: aload_3
    //   110: invokestatic 88	com/appboy/f/i:c	(Ljava/lang/String;)Z
    //   113: ifne +22 -> 135
    //   116: new 68	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   123: aload_2
    //   124: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload_3
    //   128: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: astore_2
    //   135: new 96	java/io/File
    //   138: dup
    //   139: aload_0
    //   140: aload_2
    //   141: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: astore 23
    //   146: new 107	java/net/URL
    //   149: dup
    //   150: aload_1
    //   151: invokespecial 108	java/net/URL:<init>	(Ljava/lang/String;)V
    //   154: invokestatic 113	a/a/gh:a	(Ljava/net/URL;)Ljava/net/URLConnection;
    //   157: checkcast 115	java/net/HttpURLConnection
    //   160: astore 24
    //   162: aload 24
    //   164: invokevirtual 119	java/net/HttpURLConnection:getResponseCode	()I
    //   167: istore 28
    //   169: iload 28
    //   171: sipush 200
    //   174: if_icmpeq +88 -> 262
    //   177: getstatic 18	com/appboy/f/a:b	Ljava/lang/String;
    //   180: new 68	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   187: ldc 121
    //   189: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: iload 28
    //   194: invokevirtual 124	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   197: ldc 126
    //   199: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload_1
    //   203: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc 128
    //   208: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 130	com/appboy/f/c:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   217: pop
    //   218: aload 24
    //   220: ifnull +8 -> 228
    //   223: aload 24
    //   225: invokevirtual 133	java/net/HttpURLConnection:disconnect	()V
    //   228: iconst_0
    //   229: ifeq +7 -> 236
    //   232: aconst_null
    //   233: invokevirtual 138	java/io/DataInputStream:close	()V
    //   236: iconst_0
    //   237: ifeq +7 -> 244
    //   240: aconst_null
    //   241: invokevirtual 141	java/io/BufferedOutputStream:close	()V
    //   244: aconst_null
    //   245: areturn
    //   246: astore 30
    //   248: getstatic 18	com/appboy/f/a:b	Ljava/lang/String;
    //   251: ldc 143
    //   253: aload 30
    //   255: invokestatic 147	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   258: pop
    //   259: goto -15 -> 244
    //   262: sipush 8192
    //   265: newarray byte
    //   267: astore 32
    //   269: new 135	java/io/DataInputStream
    //   272: dup
    //   273: aload 24
    //   275: invokevirtual 151	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   278: invokespecial 154	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   281: astore 11
    //   283: new 140	java/io/BufferedOutputStream
    //   286: dup
    //   287: new 156	java/io/FileOutputStream
    //   290: dup
    //   291: aload 23
    //   293: invokespecial 159	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   296: invokespecial 162	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   299: astore 18
    //   301: aload 11
    //   303: aload 32
    //   305: invokevirtual 166	java/io/DataInputStream:read	([B)I
    //   308: istore 36
    //   310: iload 36
    //   312: iconst_m1
    //   313: if_icmpeq +94 -> 407
    //   316: aload 18
    //   318: aload 32
    //   320: iconst_0
    //   321: iload 36
    //   323: invokevirtual 170	java/io/BufferedOutputStream:write	([BII)V
    //   326: goto -25 -> 301
    //   329: astore 35
    //   331: aload 18
    //   333: astore 6
    //   335: aload 11
    //   337: astore 7
    //   339: aload 24
    //   341: astore 8
    //   343: aload 35
    //   345: astore 5
    //   347: getstatic 18	com/appboy/f/a:b	Ljava/lang/String;
    //   350: new 68	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   357: ldc 172
    //   359: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload_1
    //   363: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: aload 5
    //   371: invokestatic 147	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   374: pop
    //   375: aload 8
    //   377: ifnull +8 -> 385
    //   380: aload 8
    //   382: invokevirtual 133	java/net/HttpURLConnection:disconnect	()V
    //   385: aload 7
    //   387: ifnull +8 -> 395
    //   390: aload 7
    //   392: invokevirtual 138	java/io/DataInputStream:close	()V
    //   395: aload 6
    //   397: ifnull +8 -> 405
    //   400: aload 6
    //   402: invokevirtual 141	java/io/BufferedOutputStream:close	()V
    //   405: aconst_null
    //   406: areturn
    //   407: aload 11
    //   409: invokevirtual 138	java/io/DataInputStream:close	()V
    //   412: aload 24
    //   414: invokevirtual 133	java/net/HttpURLConnection:disconnect	()V
    //   417: aload 18
    //   419: invokevirtual 141	java/io/BufferedOutputStream:close	()V
    //   422: aload 24
    //   424: ifnull +8 -> 432
    //   427: aload 24
    //   429: invokevirtual 133	java/net/HttpURLConnection:disconnect	()V
    //   432: aload 11
    //   434: ifnull +8 -> 442
    //   437: aload 11
    //   439: invokevirtual 138	java/io/DataInputStream:close	()V
    //   442: aload 18
    //   444: ifnull +8 -> 452
    //   447: aload 18
    //   449: invokevirtual 141	java/io/BufferedOutputStream:close	()V
    //   452: aload 23
    //   454: areturn
    //   455: astore 37
    //   457: getstatic 18	com/appboy/f/a:b	Ljava/lang/String;
    //   460: ldc 143
    //   462: aload 37
    //   464: invokestatic 147	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   467: pop
    //   468: goto -16 -> 452
    //   471: astore 15
    //   473: getstatic 18	com/appboy/f/a:b	Ljava/lang/String;
    //   476: ldc 143
    //   478: aload 15
    //   480: invokestatic 147	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   483: pop
    //   484: goto -79 -> 405
    //   487: astore 17
    //   489: aconst_null
    //   490: astore 18
    //   492: aconst_null
    //   493: astore 11
    //   495: aconst_null
    //   496: astore 10
    //   498: getstatic 18	com/appboy/f/a:b	Ljava/lang/String;
    //   501: new 68	java/lang/StringBuilder
    //   504: dup
    //   505: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   508: ldc 174
    //   510: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: aload_1
    //   514: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: aload 17
    //   522: invokestatic 147	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   525: pop
    //   526: aload 10
    //   528: ifnull +8 -> 536
    //   531: aload 10
    //   533: invokevirtual 133	java/net/HttpURLConnection:disconnect	()V
    //   536: aload 11
    //   538: ifnull +8 -> 546
    //   541: aload 11
    //   543: invokevirtual 138	java/io/DataInputStream:close	()V
    //   546: aload 18
    //   548: ifnull +8 -> 556
    //   551: aload 18
    //   553: invokevirtual 141	java/io/BufferedOutputStream:close	()V
    //   556: aconst_null
    //   557: areturn
    //   558: astore 20
    //   560: getstatic 18	com/appboy/f/a:b	Ljava/lang/String;
    //   563: ldc 143
    //   565: aload 20
    //   567: invokestatic 147	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   570: pop
    //   571: goto -15 -> 556
    //   574: astore 9
    //   576: aconst_null
    //   577: astore 11
    //   579: aconst_null
    //   580: astore 10
    //   582: aload 10
    //   584: ifnull +8 -> 592
    //   587: aload 10
    //   589: invokevirtual 133	java/net/HttpURLConnection:disconnect	()V
    //   592: aload 11
    //   594: ifnull +8 -> 602
    //   597: aload 11
    //   599: invokevirtual 138	java/io/DataInputStream:close	()V
    //   602: aload 4
    //   604: ifnull +8 -> 612
    //   607: aload 4
    //   609: invokevirtual 141	java/io/BufferedOutputStream:close	()V
    //   612: aload 9
    //   614: athrow
    //   615: astore 12
    //   617: getstatic 18	com/appboy/f/a:b	Ljava/lang/String;
    //   620: ldc 143
    //   622: aload 12
    //   624: invokestatic 147	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   627: pop
    //   628: goto -16 -> 612
    //   631: astore 27
    //   633: aload 24
    //   635: astore 10
    //   637: aload 27
    //   639: astore 9
    //   641: aconst_null
    //   642: astore 4
    //   644: aconst_null
    //   645: astore 11
    //   647: goto -65 -> 582
    //   650: astore 41
    //   652: aload 24
    //   654: astore 10
    //   656: aload 41
    //   658: astore 9
    //   660: aconst_null
    //   661: astore 4
    //   663: goto -81 -> 582
    //   666: astore 34
    //   668: aload 24
    //   670: astore 10
    //   672: aload 34
    //   674: astore 9
    //   676: aload 18
    //   678: astore 4
    //   680: goto -98 -> 582
    //   683: astore 9
    //   685: aload 6
    //   687: astore 4
    //   689: aload 8
    //   691: astore 10
    //   693: aload 7
    //   695: astore 11
    //   697: goto -115 -> 582
    //   700: astore 9
    //   702: aload 18
    //   704: astore 4
    //   706: goto -124 -> 582
    //   709: astore 26
    //   711: aload 24
    //   713: astore 10
    //   715: aload 26
    //   717: astore 17
    //   719: aconst_null
    //   720: astore 18
    //   722: aconst_null
    //   723: astore 11
    //   725: goto -227 -> 498
    //   728: astore 40
    //   730: aload 24
    //   732: astore 10
    //   734: aload 40
    //   736: astore 17
    //   738: aconst_null
    //   739: astore 18
    //   741: goto -243 -> 498
    //   744: astore 33
    //   746: aload 24
    //   748: astore 10
    //   750: aload 33
    //   752: astore 17
    //   754: goto -256 -> 498
    //   757: astore 5
    //   759: aconst_null
    //   760: astore 6
    //   762: aconst_null
    //   763: astore 7
    //   765: aconst_null
    //   766: astore 8
    //   768: goto -421 -> 347
    //   771: astore 25
    //   773: aload 24
    //   775: astore 8
    //   777: aload 25
    //   779: astore 5
    //   781: aconst_null
    //   782: astore 6
    //   784: aconst_null
    //   785: astore 7
    //   787: goto -440 -> 347
    //   790: astore 39
    //   792: aload 11
    //   794: astore 7
    //   796: aload 24
    //   798: astore 8
    //   800: aload 39
    //   802: astore 5
    //   804: aconst_null
    //   805: astore 6
    //   807: goto -460 -> 347
    //
    // Exception table:
    //   from	to	target	type
    //   232	236	246	java/lang/Exception
    //   240	244	246	java/lang/Exception
    //   301	310	329	java/lang/Exception
    //   316	326	329	java/lang/Exception
    //   407	422	329	java/lang/Exception
    //   437	442	455	java/lang/Exception
    //   447	452	455	java/lang/Exception
    //   390	395	471	java/lang/Exception
    //   400	405	471	java/lang/Exception
    //   97	135	487	java/lang/Throwable
    //   135	162	487	java/lang/Throwable
    //   541	546	558	java/lang/Exception
    //   551	556	558	java/lang/Exception
    //   97	135	574	finally
    //   135	162	574	finally
    //   597	602	615	java/lang/Exception
    //   607	612	615	java/lang/Exception
    //   162	169	631	finally
    //   177	218	631	finally
    //   262	283	631	finally
    //   283	301	650	finally
    //   301	310	666	finally
    //   316	326	666	finally
    //   407	422	666	finally
    //   347	375	683	finally
    //   498	526	700	finally
    //   162	169	709	java/lang/Throwable
    //   177	218	709	java/lang/Throwable
    //   262	283	709	java/lang/Throwable
    //   283	301	728	java/lang/Throwable
    //   301	310	744	java/lang/Throwable
    //   316	326	744	java/lang/Throwable
    //   407	422	744	java/lang/Throwable
    //   97	135	757	java/lang/Exception
    //   135	162	757	java/lang/Exception
    //   162	169	771	java/lang/Exception
    //   177	218	771	java/lang/Exception
    //   262	283	771	java/lang/Exception
    //   283	301	790	java/lang/Exception
  }

  // ERROR //
  public static String a(android.content.res.AssetManager paramAssetManager, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 181	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   5: astore 13
    //   7: aload 13
    //   9: astore 4
    //   11: new 183	java/io/BufferedReader
    //   14: dup
    //   15: new 185	java/io/InputStreamReader
    //   18: dup
    //   19: aload 4
    //   21: ldc 187
    //   23: invokespecial 190	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   26: invokespecial 193	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   29: astore_3
    //   30: new 68	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   37: astore 14
    //   39: aload_3
    //   40: invokevirtual 196	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: astore 15
    //   45: aload 15
    //   47: ifnull +71 -> 118
    //   50: aload 14
    //   52: aload 15
    //   54: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: bipush 10
    //   59: invokevirtual 199	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: goto -24 -> 39
    //   66: astore_2
    //   67: getstatic 18	com/appboy/f/a:b	Ljava/lang/String;
    //   70: new 68	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   77: ldc 201
    //   79: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_1
    //   83: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: aload_2
    //   90: invokestatic 147	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   93: pop
    //   94: aload 4
    //   96: ifnull +8 -> 104
    //   99: aload 4
    //   101: invokevirtual 204	java/io/InputStream:close	()V
    //   104: aconst_null
    //   105: astore 9
    //   107: aload_3
    //   108: ifnull +7 -> 115
    //   111: aload_3
    //   112: invokevirtual 205	java/io/BufferedReader:close	()V
    //   115: aload 9
    //   117: areturn
    //   118: aload 14
    //   120: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: astore 17
    //   125: aload 17
    //   127: astore 9
    //   129: aload 4
    //   131: ifnull +8 -> 139
    //   134: aload 4
    //   136: invokevirtual 204	java/io/InputStream:close	()V
    //   139: aload_3
    //   140: ifnull -25 -> 115
    //   143: aload_3
    //   144: invokevirtual 205	java/io/BufferedReader:close	()V
    //   147: aload 9
    //   149: areturn
    //   150: astore 18
    //   152: getstatic 18	com/appboy/f/a:b	Ljava/lang/String;
    //   155: new 68	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   162: ldc 207
    //   164: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_1
    //   168: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: aload 18
    //   176: invokestatic 147	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   179: pop
    //   180: aload 9
    //   182: areturn
    //   183: astore 10
    //   185: getstatic 18	com/appboy/f/a:b	Ljava/lang/String;
    //   188: new 68	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   195: ldc 207
    //   197: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload_1
    //   201: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: aload 10
    //   209: invokestatic 147	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   212: pop
    //   213: aconst_null
    //   214: areturn
    //   215: astore 12
    //   217: aconst_null
    //   218: astore_3
    //   219: aconst_null
    //   220: astore 4
    //   222: aload 12
    //   224: astore 5
    //   226: aload 4
    //   228: ifnull +8 -> 236
    //   231: aload 4
    //   233: invokevirtual 204	java/io/InputStream:close	()V
    //   236: aload_3
    //   237: ifnull +7 -> 244
    //   240: aload_3
    //   241: invokevirtual 205	java/io/BufferedReader:close	()V
    //   244: aload 5
    //   246: athrow
    //   247: astore 6
    //   249: getstatic 18	com/appboy/f/a:b	Ljava/lang/String;
    //   252: new 68	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   259: ldc 207
    //   261: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload_1
    //   265: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: aload 6
    //   273: invokestatic 147	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   276: pop
    //   277: goto -33 -> 244
    //   280: astore 20
    //   282: aload 20
    //   284: astore 5
    //   286: aconst_null
    //   287: astore_3
    //   288: goto -62 -> 226
    //   291: astore 5
    //   293: goto -67 -> 226
    //   296: astore_2
    //   297: aconst_null
    //   298: astore_3
    //   299: aconst_null
    //   300: astore 4
    //   302: goto -235 -> 67
    //   305: astore_2
    //   306: aconst_null
    //   307: astore_3
    //   308: goto -241 -> 67
    //
    // Exception table:
    //   from	to	target	type
    //   30	39	66	java/lang/Exception
    //   39	45	66	java/lang/Exception
    //   50	63	66	java/lang/Exception
    //   118	125	66	java/lang/Exception
    //   134	139	150	java/lang/Exception
    //   143	147	150	java/lang/Exception
    //   99	104	183	java/lang/Exception
    //   111	115	183	java/lang/Exception
    //   0	7	215	finally
    //   231	236	247	java/lang/Exception
    //   240	244	247	java/lang/Exception
    //   11	30	280	finally
    //   30	39	291	finally
    //   39	45	291	finally
    //   50	63	291	finally
    //   67	94	291	finally
    //   118	125	291	finally
    //   0	7	296	java/lang/Exception
    //   11	30	305	java/lang/Exception
  }

  public static void a(File paramFile)
  {
    if (paramFile != null)
      try
      {
        if (!paramFile.exists())
          return;
        if (paramFile.isDirectory())
        {
          String[] arrayOfString = paramFile.list();
          int i = arrayOfString.length;
          for (int j = 0; j < i; j++)
            a(new File(paramFile, arrayOfString[j]));
        }
        paramFile.delete();
        return;
      }
      catch (Exception localException)
      {
        c.d(b, "Caught exception while trying to delete file or directory " + paramFile.getName(), localException);
      }
  }

  public static boolean a(Uri paramUri)
  {
    if (paramUri == null)
    {
      c.c(b, "Null Uri received.");
      return false;
    }
    String str = paramUri.getScheme();
    if (i.c(str))
    {
      c.c(b, "Null or blank Uri scheme.");
      return false;
    }
    return a.contains(str);
  }

  public static boolean b(Uri paramUri)
  {
    if (paramUri == null)
      c.c(b, "Null Uri received.");
    String str;
    do
    {
      return false;
      str = paramUri.getScheme();
    }
    while ((!i.c(str)) && (!str.equals("file")));
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.f.a
 * JD-Core Version:    0.6.2
 */