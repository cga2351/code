package com.appboy.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import java.io.File;
import java.io.InputStream;

public class b
{
  private static final String a = c.a(b.class);

  public static int a()
  {
    return Math.max(1024, Math.min((int)Math.min(Runtime.getRuntime().maxMemory() / 8L, 2147483647L), 33554432));
  }

  public static int a(int paramInt1, int paramInt2)
  {
    return Math.abs(paramInt1 * paramInt2 / 160);
  }

  public static int a(Context paramContext, int paramInt)
  {
    return Math.abs(paramInt * a(paramContext).densityDpi / 160);
  }

  static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = paramOptions.outHeight;
    int j = paramOptions.outWidth;
    c.b(a, "Calculating sample size for source image bounds: (height " + paramOptions.outHeight + " width " + paramOptions.outWidth + ") and destination image bounds: (height " + paramInt2 + " width " + paramInt1 + ")");
    int k = 1;
    if ((i > paramInt2) || (j > paramInt1))
    {
      int m = i / 2;
      int n = j / 2;
      while ((m / k >= paramInt2) && (n / k >= paramInt1))
        k *= 2;
    }
    c.b(a, "Using image sample size of " + k);
    return k;
  }

  public static Bitmap a(Context paramContext, Uri paramUri, com.appboy.b.a parama)
  {
    if (paramUri == null)
    {
      c.c(a, "Null Uri received. Not getting image.");
      return null;
    }
    if (a.b(paramUri))
      return b(paramUri);
    if (a.a(paramUri))
    {
      if ((paramContext == null) || (parama == null))
        return a(paramUri, 0, 0);
      DisplayMetrics localDisplayMetrics = a(paramContext);
      int i = a(localDisplayMetrics.densityDpi, parama.a());
      return a(paramUri, a(localDisplayMetrics.densityDpi, parama.b()), i);
    }
    c.d(a, "Uri with unknown scheme received. Not getting image.");
    return null;
  }

  public static Bitmap a(Uri paramUri)
  {
    return a(null, paramUri, null);
  }

  // ERROR //
  private static Bitmap a(Uri paramUri, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: sipush 1337
    //   3: invokestatic 149	android/net/TrafficStats:setThreadStatsTag	(I)V
    //   6: aload_0
    //   7: invokevirtual 152	android/net/Uri:toString	()Ljava/lang/String;
    //   10: astore_3
    //   11: invokestatic 158	com/appboy/a:j	()Z
    //   14: ifeq +31 -> 45
    //   17: getstatic 15	com/appboy/f/b:a	Ljava/lang/String;
    //   20: new 71	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   27: ldc 160
    //   29: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_3
    //   33: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 103	com/appboy/f/c:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   42: pop
    //   43: aconst_null
    //   44: areturn
    //   45: new 162	java/net/URL
    //   48: dup
    //   49: aload_3
    //   50: invokespecial 165	java/net/URL:<init>	(Ljava/lang/String;)V
    //   53: astore 4
    //   55: aload 4
    //   57: invokestatic 170	a/a/gh:a	(Ljava/net/URL;)Ljava/net/URLConnection;
    //   60: checkcast 172	java/net/HttpURLConnection
    //   63: astore 33
    //   65: aload 33
    //   67: invokevirtual 175	java/net/HttpURLConnection:getResponseCode	()I
    //   70: istore 40
    //   72: iload 40
    //   74: sipush 200
    //   77: if_icmpeq +81 -> 158
    //   80: getstatic 15	com/appboy/f/b:a	Ljava/lang/String;
    //   83: new 71	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   90: ldc 177
    //   92: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: iload 40
    //   97: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   100: ldc 179
    //   102: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload 4
    //   107: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   110: ldc 184
    //   112: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 129	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   121: pop
    //   122: aload 33
    //   124: ifnull +8 -> 132
    //   127: aload 33
    //   129: invokevirtual 187	java/net/HttpURLConnection:disconnect	()V
    //   132: iconst_0
    //   133: ifeq +7 -> 140
    //   136: aconst_null
    //   137: invokevirtual 192	java/io/InputStream:close	()V
    //   140: aconst_null
    //   141: areturn
    //   142: astore 42
    //   144: getstatic 15	com/appboy/f/b:a	Ljava/lang/String;
    //   147: ldc 194
    //   149: aload 42
    //   151: invokestatic 197	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   154: pop
    //   155: goto -15 -> 140
    //   158: aload 33
    //   160: invokevirtual 201	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   163: astore 44
    //   165: aload 44
    //   167: astore 6
    //   169: iload_1
    //   170: ifeq +246 -> 416
    //   173: iload_2
    //   174: ifeq +242 -> 416
    //   177: getstatic 15	com/appboy/f/b:a	Ljava/lang/String;
    //   180: new 71	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   187: ldc 203
    //   189: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: iload_2
    //   193: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: ldc 83
    //   198: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: iload_1
    //   202: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   205: ldc 87
    //   207: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 95	com/appboy/f/c:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   216: pop
    //   217: aload 6
    //   219: invokestatic 206	com/appboy/f/b:a	(Ljava/io/InputStream;)Landroid/graphics/BitmapFactory$Options;
    //   222: astore 55
    //   224: aload 33
    //   226: invokevirtual 187	java/net/HttpURLConnection:disconnect	()V
    //   229: aload 4
    //   231: invokestatic 170	a/a/gh:a	(Ljava/net/URL;)Ljava/net/URLConnection;
    //   234: checkcast 172	java/net/HttpURLConnection
    //   237: astore 33
    //   239: aload 33
    //   241: invokevirtual 201	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   244: astore 6
    //   246: aload 55
    //   248: getfield 66	android/graphics/BitmapFactory$Options:outHeight	I
    //   251: ifeq +11 -> 262
    //   254: aload 55
    //   256: getfield 69	android/graphics/BitmapFactory$Options:outWidth	I
    //   259: ifne +107 -> 366
    //   262: getstatic 15	com/appboy/f/b:a	Ljava/lang/String;
    //   265: new 71	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   272: ldc 208
    //   274: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload 4
    //   279: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   282: ldc 210
    //   284: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload 55
    //   289: getfield 66	android/graphics/BitmapFactory$Options:outHeight	I
    //   292: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   295: ldc 83
    //   297: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload 55
    //   302: getfield 69	android/graphics/BitmapFactory$Options:outWidth	I
    //   305: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   308: ldc 212
    //   310: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 129	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   319: pop
    //   320: aload 6
    //   322: invokestatic 218	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   325: astore 57
    //   327: aload 33
    //   329: ifnull +8 -> 337
    //   332: aload 33
    //   334: invokevirtual 187	java/net/HttpURLConnection:disconnect	()V
    //   337: aload 6
    //   339: ifnull +8 -> 347
    //   342: aload 6
    //   344: invokevirtual 192	java/io/InputStream:close	()V
    //   347: aload 57
    //   349: areturn
    //   350: astore 58
    //   352: getstatic 15	com/appboy/f/b:a	Ljava/lang/String;
    //   355: ldc 194
    //   357: aload 58
    //   359: invokestatic 197	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   362: pop
    //   363: goto -16 -> 347
    //   366: aload 6
    //   368: aload 55
    //   370: iload_1
    //   371: iload_2
    //   372: invokestatic 221	com/appboy/f/b:a	(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;II)Landroid/graphics/Bitmap;
    //   375: astore 60
    //   377: aload 33
    //   379: ifnull +8 -> 387
    //   382: aload 33
    //   384: invokevirtual 187	java/net/HttpURLConnection:disconnect	()V
    //   387: aload 6
    //   389: ifnull +8 -> 397
    //   392: aload 6
    //   394: invokevirtual 192	java/io/InputStream:close	()V
    //   397: aload 60
    //   399: areturn
    //   400: astore 61
    //   402: getstatic 15	com/appboy/f/b:a	Ljava/lang/String;
    //   405: ldc 194
    //   407: aload 61
    //   409: invokestatic 197	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   412: pop
    //   413: goto -16 -> 397
    //   416: aload 6
    //   418: invokestatic 218	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   421: astore 51
    //   423: aload 33
    //   425: ifnull +8 -> 433
    //   428: aload 33
    //   430: invokevirtual 187	java/net/HttpURLConnection:disconnect	()V
    //   433: aload 6
    //   435: ifnull +8 -> 443
    //   438: aload 6
    //   440: invokevirtual 192	java/io/InputStream:close	()V
    //   443: aload 51
    //   445: areturn
    //   446: astore 52
    //   448: getstatic 15	com/appboy/f/b:a	Ljava/lang/String;
    //   451: ldc 194
    //   453: aload 52
    //   455: invokestatic 197	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   458: pop
    //   459: goto -16 -> 443
    //   462: astore 26
    //   464: aconst_null
    //   465: astore 27
    //   467: aconst_null
    //   468: astore 28
    //   470: getstatic 15	com/appboy/f/b:a	Ljava/lang/String;
    //   473: new 71	java/lang/StringBuilder
    //   476: dup
    //   477: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   480: ldc 223
    //   482: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: aload_3
    //   486: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: ldc 225
    //   491: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: aload 26
    //   499: invokestatic 197	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   502: pop
    //   503: aload 28
    //   505: ifnull +8 -> 513
    //   508: aload 28
    //   510: invokevirtual 187	java/net/HttpURLConnection:disconnect	()V
    //   513: aload 27
    //   515: ifnull +8 -> 523
    //   518: aload 27
    //   520: invokevirtual 192	java/io/InputStream:close	()V
    //   523: aconst_null
    //   524: areturn
    //   525: astore 31
    //   527: getstatic 15	com/appboy/f/b:a	Ljava/lang/String;
    //   530: ldc 194
    //   532: aload 31
    //   534: invokestatic 197	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   537: pop
    //   538: goto -15 -> 523
    //   541: astore 22
    //   543: aconst_null
    //   544: astore 6
    //   546: aconst_null
    //   547: astore 7
    //   549: getstatic 15	com/appboy/f/b:a	Ljava/lang/String;
    //   552: new 71	java/lang/StringBuilder
    //   555: dup
    //   556: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   559: ldc 227
    //   561: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: aload_3
    //   565: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: ldc 229
    //   570: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: aload 22
    //   578: invokestatic 197	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   581: pop
    //   582: aload 7
    //   584: ifnull +8 -> 592
    //   587: aload 7
    //   589: invokevirtual 187	java/net/HttpURLConnection:disconnect	()V
    //   592: aload 6
    //   594: ifnull -71 -> 523
    //   597: aload 6
    //   599: invokevirtual 192	java/io/InputStream:close	()V
    //   602: goto -79 -> 523
    //   605: astore 24
    //   607: getstatic 15	com/appboy/f/b:a	Ljava/lang/String;
    //   610: ldc 194
    //   612: aload 24
    //   614: invokestatic 197	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   617: pop
    //   618: goto -95 -> 523
    //   621: astore 18
    //   623: aconst_null
    //   624: astore 6
    //   626: aconst_null
    //   627: astore 7
    //   629: getstatic 15	com/appboy/f/b:a	Ljava/lang/String;
    //   632: new 71	java/lang/StringBuilder
    //   635: dup
    //   636: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   639: ldc 231
    //   641: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: aload_3
    //   645: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: ldc 233
    //   650: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   656: aload 18
    //   658: invokestatic 197	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   661: pop
    //   662: aload 7
    //   664: ifnull +8 -> 672
    //   667: aload 7
    //   669: invokevirtual 187	java/net/HttpURLConnection:disconnect	()V
    //   672: aload 6
    //   674: ifnull -151 -> 523
    //   677: aload 6
    //   679: invokevirtual 192	java/io/InputStream:close	()V
    //   682: goto -159 -> 523
    //   685: astore 20
    //   687: getstatic 15	com/appboy/f/b:a	Ljava/lang/String;
    //   690: ldc 194
    //   692: aload 20
    //   694: invokestatic 197	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   697: pop
    //   698: goto -175 -> 523
    //   701: astore 14
    //   703: aconst_null
    //   704: astore 6
    //   706: aconst_null
    //   707: astore 7
    //   709: getstatic 15	com/appboy/f/b:a	Ljava/lang/String;
    //   712: new 71	java/lang/StringBuilder
    //   715: dup
    //   716: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   719: ldc 235
    //   721: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: aload_3
    //   725: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   731: aload 14
    //   733: invokestatic 197	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   736: pop
    //   737: aload 7
    //   739: ifnull +8 -> 747
    //   742: aload 7
    //   744: invokevirtual 187	java/net/HttpURLConnection:disconnect	()V
    //   747: aload 6
    //   749: ifnull -226 -> 523
    //   752: aload 6
    //   754: invokevirtual 192	java/io/InputStream:close	()V
    //   757: goto -234 -> 523
    //   760: astore 16
    //   762: getstatic 15	com/appboy/f/b:a	Ljava/lang/String;
    //   765: ldc 194
    //   767: aload 16
    //   769: invokestatic 197	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   772: pop
    //   773: goto -250 -> 523
    //   776: astore 10
    //   778: aconst_null
    //   779: astore 6
    //   781: aconst_null
    //   782: astore 7
    //   784: getstatic 15	com/appboy/f/b:a	Ljava/lang/String;
    //   787: new 71	java/lang/StringBuilder
    //   790: dup
    //   791: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   794: ldc 237
    //   796: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: aload_3
    //   800: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   806: aload 10
    //   808: invokestatic 197	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   811: pop
    //   812: aload 7
    //   814: ifnull +8 -> 822
    //   817: aload 7
    //   819: invokevirtual 187	java/net/HttpURLConnection:disconnect	()V
    //   822: aload 6
    //   824: ifnull -301 -> 523
    //   827: aload 6
    //   829: invokevirtual 192	java/io/InputStream:close	()V
    //   832: goto -309 -> 523
    //   835: astore 12
    //   837: getstatic 15	com/appboy/f/b:a	Ljava/lang/String;
    //   840: ldc 194
    //   842: aload 12
    //   844: invokestatic 197	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   847: pop
    //   848: goto -325 -> 523
    //   851: astore 5
    //   853: aconst_null
    //   854: astore 6
    //   856: aconst_null
    //   857: astore 7
    //   859: aload 7
    //   861: ifnull +8 -> 869
    //   864: aload 7
    //   866: invokevirtual 187	java/net/HttpURLConnection:disconnect	()V
    //   869: aload 6
    //   871: ifnull +8 -> 879
    //   874: aload 6
    //   876: invokevirtual 192	java/io/InputStream:close	()V
    //   879: aload 5
    //   881: athrow
    //   882: astore 8
    //   884: getstatic 15	com/appboy/f/b:a	Ljava/lang/String;
    //   887: ldc 194
    //   889: aload 8
    //   891: invokestatic 197	com/appboy/f/c:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   894: pop
    //   895: goto -16 -> 879
    //   898: astore 39
    //   900: aload 33
    //   902: astore 7
    //   904: aload 39
    //   906: astore 5
    //   908: aconst_null
    //   909: astore 6
    //   911: goto -52 -> 859
    //   914: astore 50
    //   916: aload 33
    //   918: astore 7
    //   920: aload 50
    //   922: astore 5
    //   924: goto -65 -> 859
    //   927: astore 5
    //   929: aload 27
    //   931: astore 29
    //   933: aload 28
    //   935: astore 7
    //   937: aload 29
    //   939: astore 6
    //   941: goto -82 -> 859
    //   944: astore 5
    //   946: goto -87 -> 859
    //   949: astore 38
    //   951: aload 33
    //   953: astore 7
    //   955: aload 38
    //   957: astore 10
    //   959: aconst_null
    //   960: astore 6
    //   962: goto -178 -> 784
    //   965: astore 49
    //   967: aload 33
    //   969: astore 7
    //   971: aload 49
    //   973: astore 10
    //   975: goto -191 -> 784
    //   978: astore 37
    //   980: aload 33
    //   982: astore 7
    //   984: aload 37
    //   986: astore 14
    //   988: aconst_null
    //   989: astore 6
    //   991: goto -282 -> 709
    //   994: astore 48
    //   996: aload 33
    //   998: astore 7
    //   1000: aload 48
    //   1002: astore 14
    //   1004: goto -295 -> 709
    //   1007: astore 36
    //   1009: aload 33
    //   1011: astore 7
    //   1013: aload 36
    //   1015: astore 18
    //   1017: aconst_null
    //   1018: astore 6
    //   1020: goto -391 -> 629
    //   1023: astore 47
    //   1025: aload 33
    //   1027: astore 7
    //   1029: aload 47
    //   1031: astore 18
    //   1033: goto -404 -> 629
    //   1036: astore 35
    //   1038: aload 33
    //   1040: astore 7
    //   1042: aload 35
    //   1044: astore 22
    //   1046: aconst_null
    //   1047: astore 6
    //   1049: goto -500 -> 549
    //   1052: astore 46
    //   1054: aload 33
    //   1056: astore 7
    //   1058: aload 46
    //   1060: astore 22
    //   1062: goto -513 -> 549
    //   1065: astore 34
    //   1067: aload 33
    //   1069: astore 28
    //   1071: aload 34
    //   1073: astore 26
    //   1075: aconst_null
    //   1076: astore 27
    //   1078: goto -608 -> 470
    //   1081: astore 45
    //   1083: aload 6
    //   1085: astore 27
    //   1087: aload 33
    //   1089: astore 28
    //   1091: aload 45
    //   1093: astore 26
    //   1095: goto -625 -> 470
    //
    // Exception table:
    //   from	to	target	type
    //   136	140	142	java/io/IOException
    //   342	347	350	java/io/IOException
    //   392	397	400	java/io/IOException
    //   438	443	446	java/io/IOException
    //   45	65	462	java/lang/OutOfMemoryError
    //   518	523	525	java/io/IOException
    //   45	65	541	java/net/UnknownHostException
    //   597	602	605	java/io/IOException
    //   45	65	621	java/net/MalformedURLException
    //   677	682	685	java/io/IOException
    //   45	65	701	java/lang/Exception
    //   752	757	760	java/io/IOException
    //   45	65	776	java/lang/Throwable
    //   827	832	835	java/io/IOException
    //   45	65	851	finally
    //   874	879	882	java/io/IOException
    //   65	72	898	finally
    //   80	122	898	finally
    //   158	165	898	finally
    //   177	262	914	finally
    //   262	327	914	finally
    //   366	377	914	finally
    //   416	423	914	finally
    //   470	503	927	finally
    //   549	582	944	finally
    //   629	662	944	finally
    //   709	737	944	finally
    //   784	812	944	finally
    //   65	72	949	java/lang/Throwable
    //   80	122	949	java/lang/Throwable
    //   158	165	949	java/lang/Throwable
    //   177	262	965	java/lang/Throwable
    //   262	327	965	java/lang/Throwable
    //   366	377	965	java/lang/Throwable
    //   416	423	965	java/lang/Throwable
    //   65	72	978	java/lang/Exception
    //   80	122	978	java/lang/Exception
    //   158	165	978	java/lang/Exception
    //   177	262	994	java/lang/Exception
    //   262	327	994	java/lang/Exception
    //   366	377	994	java/lang/Exception
    //   416	423	994	java/lang/Exception
    //   65	72	1007	java/net/MalformedURLException
    //   80	122	1007	java/net/MalformedURLException
    //   158	165	1007	java/net/MalformedURLException
    //   177	262	1023	java/net/MalformedURLException
    //   262	327	1023	java/net/MalformedURLException
    //   366	377	1023	java/net/MalformedURLException
    //   416	423	1023	java/net/MalformedURLException
    //   65	72	1036	java/net/UnknownHostException
    //   80	122	1036	java/net/UnknownHostException
    //   158	165	1036	java/net/UnknownHostException
    //   177	262	1052	java/net/UnknownHostException
    //   262	327	1052	java/net/UnknownHostException
    //   366	377	1052	java/net/UnknownHostException
    //   416	423	1052	java/net/UnknownHostException
    //   65	72	1065	java/lang/OutOfMemoryError
    //   80	122	1065	java/lang/OutOfMemoryError
    //   158	165	1065	java/lang/OutOfMemoryError
    //   177	262	1081	java/lang/OutOfMemoryError
    //   262	327	1081	java/lang/OutOfMemoryError
    //   366	377	1081	java/lang/OutOfMemoryError
    //   416	423	1081	java/lang/OutOfMemoryError
  }

  private static Bitmap a(InputStream paramInputStream, BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    paramOptions.inSampleSize = a(paramOptions, paramInt1, paramInt2);
    paramOptions.inJustDecodeBounds = false;
    return BitmapFactory.decodeStream(paramInputStream, null, paramOptions);
  }

  static BitmapFactory.Options a(InputStream paramInputStream)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramInputStream, null, localOptions);
    return localOptions;
  }

  public static DisplayMetrics a(Context paramContext)
  {
    WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }

  public static void a(Bitmap paramBitmap, ImageView paramImageView)
  {
    if ((paramBitmap == null) || (paramImageView == null))
    {
      c.d(a, "Neither source bitmap nor ImageView may be null. Not resizing ImageView");
      return;
    }
    if ((paramBitmap.getWidth() == 0) || (paramBitmap.getHeight() == 0))
    {
      c.d(a, "Bitmap dimensions cannot be 0. Not resizing ImageView");
      return;
    }
    final float f = paramBitmap.getWidth() / paramBitmap.getHeight();
    c.b(a, "Resizing ImageView to aspect ratio: " + f);
    paramImageView.post(new Runnable()
    {
      public void run()
      {
        int i = this.a.getWidth();
        ViewGroup.LayoutParams localLayoutParams = this.a.getLayoutParams();
        localLayoutParams.height = ((int)(i / f));
        localLayoutParams.width = i;
        this.a.setLayoutParams(localLayoutParams);
      }
    });
  }

  private static Bitmap b(Uri paramUri)
  {
    try
    {
      File localFile = new File(paramUri.getPath());
      if (localFile.exists())
      {
        c.c(a, "Retrieving image from path: " + localFile.getAbsolutePath());
        Bitmap localBitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
        return localBitmap;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      c.d(a, "Out of Memory Error in local bitmap file retrieval for Uri: " + paramUri.toString() + ".", localOutOfMemoryError);
      return null;
    }
    catch (Exception localException)
    {
      while (true)
        c.d(a, "Exception occurred when attempting to retrieve local bitmap.", localException);
    }
    catch (Throwable localThrowable)
    {
      while (true)
        c.d(a, "Throwable caught in local bitmap file retrieval for Uri: " + paramUri.toString(), localThrowable);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.f.b
 * JD-Core Version:    0.6.2
 */