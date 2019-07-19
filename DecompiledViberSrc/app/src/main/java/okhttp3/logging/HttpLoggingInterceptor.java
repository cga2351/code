package okhttp3.logging;

import f.c;
import java.io.EOFException;
import java.nio.charset.Charset;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.internal.platform.Platform;

public final class HttpLoggingInterceptor
  implements Interceptor
{
  private static final Charset UTF8 = Charset.forName("UTF-8");
  private volatile Level level = Level.NONE;
  private final Logger logger;

  public HttpLoggingInterceptor()
  {
    this(Logger.DEFAULT);
  }

  public HttpLoggingInterceptor(Logger paramLogger)
  {
    this.logger = paramLogger;
  }

  private boolean bodyHasUnknownEncoding(Headers paramHeaders)
  {
    String str = paramHeaders.get("Content-Encoding");
    return (str != null) && (!str.equalsIgnoreCase("identity")) && (!str.equalsIgnoreCase("gzip"));
  }

  static boolean isPlaintext(c paramc)
  {
    long l = 64L;
    try
    {
      c localc = new c();
      if (paramc.a() < l)
        l = paramc.a();
      paramc.a(localc, 0L, l);
      for (int i = 0; (i < 16) && (!localc.f()); i++)
      {
        int j = localc.t();
        if (Character.isISOControl(j))
        {
          boolean bool = Character.isWhitespace(j);
          if (!bool)
            return false;
        }
      }
    }
    catch (EOFException localEOFException)
    {
      return false;
    }
    return true;
  }

  public Level getLevel()
  {
    return this.level;
  }

  // ERROR //
  public okhttp3.Response intercept(okhttp3.Interceptor.Chain paramChain)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	okhttp3/logging/HttpLoggingInterceptor:level	Lokhttp3/logging/HttpLoggingInterceptor$Level;
    //   4: astore_2
    //   5: aload_1
    //   6: invokeinterface 111 1 0
    //   11: astore_3
    //   12: aload_2
    //   13: getstatic 40	okhttp3/logging/HttpLoggingInterceptor$Level:NONE	Lokhttp3/logging/HttpLoggingInterceptor$Level;
    //   16: if_acmpne +11 -> 27
    //   19: aload_1
    //   20: aload_3
    //   21: invokeinterface 115 2 0
    //   26: areturn
    //   27: aload_2
    //   28: getstatic 118	okhttp3/logging/HttpLoggingInterceptor$Level:BODY	Lokhttp3/logging/HttpLoggingInterceptor$Level;
    //   31: if_acmpne +367 -> 398
    //   34: iconst_1
    //   35: istore 4
    //   37: iload 4
    //   39: ifne +10 -> 49
    //   42: aload_2
    //   43: getstatic 121	okhttp3/logging/HttpLoggingInterceptor$Level:HEADERS	Lokhttp3/logging/HttpLoggingInterceptor$Level;
    //   46: if_acmpne +358 -> 404
    //   49: iconst_1
    //   50: istore 5
    //   52: aload_3
    //   53: invokevirtual 127	okhttp3/Request:body	()Lokhttp3/RequestBody;
    //   56: astore 6
    //   58: aload 6
    //   60: ifnull +350 -> 410
    //   63: iconst_1
    //   64: istore 7
    //   66: aload_1
    //   67: invokeinterface 131 1 0
    //   72: astore 8
    //   74: new 133	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   81: ldc 136
    //   83: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_3
    //   87: invokevirtual 144	okhttp3/Request:method	()Ljava/lang/String;
    //   90: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: bipush 32
    //   95: invokevirtual 147	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   98: aload_3
    //   99: invokevirtual 151	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   102: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   105: astore 9
    //   107: aload 8
    //   109: ifnull +307 -> 416
    //   112: new 133	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   119: ldc 156
    //   121: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload 8
    //   126: invokeinterface 162 1 0
    //   131: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: astore 10
    //   139: aload 9
    //   141: aload 10
    //   143: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: astore 11
    //   151: iload 5
    //   153: ifne +43 -> 196
    //   156: iload 7
    //   158: ifeq +38 -> 196
    //   161: new 133	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   168: aload 11
    //   170: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: ldc 167
    //   175: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload 6
    //   180: invokevirtual 172	okhttp3/RequestBody:contentLength	()J
    //   183: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   186: ldc 177
    //   188: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: astore 11
    //   196: aload_0
    //   197: getfield 44	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   200: aload 11
    //   202: invokeinterface 181 2 0
    //   207: iload 5
    //   209: ifeq +255 -> 464
    //   212: iload 7
    //   214: ifeq +87 -> 301
    //   217: aload 6
    //   219: invokevirtual 185	okhttp3/RequestBody:contentType	()Lokhttp3/MediaType;
    //   222: ifnull +35 -> 257
    //   225: aload_0
    //   226: getfield 44	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   229: new 133	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   236: ldc 187
    //   238: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload 6
    //   243: invokevirtual 185	okhttp3/RequestBody:contentType	()Lokhttp3/MediaType;
    //   246: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokeinterface 181 2 0
    //   257: aload 6
    //   259: invokevirtual 172	okhttp3/RequestBody:contentLength	()J
    //   262: ldc2_w 188
    //   265: lcmp
    //   266: ifeq +35 -> 301
    //   269: aload_0
    //   270: getfield 44	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   273: new 133	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   280: ldc 191
    //   282: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload 6
    //   287: invokevirtual 172	okhttp3/RequestBody:contentLength	()J
    //   290: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   293: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokeinterface 181 2 0
    //   301: aload_3
    //   302: invokevirtual 195	okhttp3/Request:headers	()Lokhttp3/Headers;
    //   305: astore 42
    //   307: iconst_0
    //   308: istore 43
    //   310: aload 42
    //   312: invokevirtual 198	okhttp3/Headers:size	()I
    //   315: istore 44
    //   317: iload 43
    //   319: iload 44
    //   321: if_icmpge +102 -> 423
    //   324: aload 42
    //   326: iload 43
    //   328: invokevirtual 202	okhttp3/Headers:name	(I)Ljava/lang/String;
    //   331: astore 48
    //   333: ldc 204
    //   335: aload 48
    //   337: invokevirtual 62	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   340: ifne +52 -> 392
    //   343: ldc 206
    //   345: aload 48
    //   347: invokevirtual 62	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   350: ifne +42 -> 392
    //   353: aload_0
    //   354: getfield 44	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   357: new 133	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   364: aload 48
    //   366: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: ldc 208
    //   371: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: aload 42
    //   376: iload 43
    //   378: invokevirtual 211	okhttp3/Headers:value	(I)Ljava/lang/String;
    //   381: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokeinterface 181 2 0
    //   392: iinc 43 1
    //   395: goto -78 -> 317
    //   398: iconst_0
    //   399: istore 4
    //   401: goto -364 -> 37
    //   404: iconst_0
    //   405: istore 5
    //   407: goto -355 -> 52
    //   410: iconst_0
    //   411: istore 7
    //   413: goto -347 -> 66
    //   416: ldc 213
    //   418: astore 10
    //   420: goto -281 -> 139
    //   423: iload 4
    //   425: ifeq +8 -> 433
    //   428: iload 7
    //   430: ifne +326 -> 756
    //   433: aload_0
    //   434: getfield 44	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   437: new 133	java/lang/StringBuilder
    //   440: dup
    //   441: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   444: ldc 215
    //   446: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: aload_3
    //   450: invokevirtual 144	okhttp3/Request:method	()Ljava/lang/String;
    //   453: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokeinterface 181 2 0
    //   464: invokestatic 220	java/lang/System:nanoTime	()J
    //   467: lstore 12
    //   469: aload_1
    //   470: aload_3
    //   471: invokeinterface 115 2 0
    //   476: astore 15
    //   478: getstatic 226	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
    //   481: invokestatic 220	java/lang/System:nanoTime	()J
    //   484: lload 12
    //   486: lsub
    //   487: invokevirtual 230	java/util/concurrent/TimeUnit:toMillis	(J)J
    //   490: lstore 16
    //   492: aload 15
    //   494: invokevirtual 235	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   497: astore 18
    //   499: aload 18
    //   501: invokevirtual 238	okhttp3/ResponseBody:contentLength	()J
    //   504: lstore 19
    //   506: lload 19
    //   508: ldc2_w 188
    //   511: lcmp
    //   512: ifeq +514 -> 1026
    //   515: new 133	java/lang/StringBuilder
    //   518: dup
    //   519: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   522: lload 19
    //   524: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   527: ldc 240
    //   529: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   535: astore 21
    //   537: aload_0
    //   538: getfield 44	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   541: astore 22
    //   543: new 133	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   550: ldc 242
    //   552: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload 15
    //   557: invokevirtual 245	okhttp3/Response:code	()I
    //   560: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   563: astore 23
    //   565: aload 15
    //   567: invokevirtual 251	okhttp3/Response:message	()Ljava/lang/String;
    //   570: invokevirtual 254	java/lang/String:isEmpty	()Z
    //   573: ifeq +461 -> 1034
    //   576: ldc 213
    //   578: astore 24
    //   580: aload 23
    //   582: aload 24
    //   584: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: bipush 32
    //   589: invokevirtual 147	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   592: aload 15
    //   594: invokevirtual 255	okhttp3/Response:request	()Lokhttp3/Request;
    //   597: invokevirtual 151	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   600: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   603: ldc 167
    //   605: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: lload 16
    //   610: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   613: ldc_w 257
    //   616: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: astore 25
    //   621: iload 5
    //   623: ifne +439 -> 1062
    //   626: new 133	java/lang/StringBuilder
    //   629: dup
    //   630: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   633: ldc_w 259
    //   636: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: aload 21
    //   641: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: ldc_w 261
    //   647: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   653: astore 26
    //   655: aload 22
    //   657: aload 25
    //   659: aload 26
    //   661: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: bipush 41
    //   666: invokevirtual 147	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   669: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   672: invokeinterface 181 2 0
    //   677: iload 5
    //   679: ifeq +415 -> 1094
    //   682: aload 15
    //   684: invokevirtual 262	okhttp3/Response:headers	()Lokhttp3/Headers;
    //   687: astore 27
    //   689: iconst_0
    //   690: istore 28
    //   692: aload 27
    //   694: invokevirtual 198	okhttp3/Headers:size	()I
    //   697: istore 29
    //   699: iload 28
    //   701: iload 29
    //   703: if_icmpge +366 -> 1069
    //   706: aload_0
    //   707: getfield 44	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   710: new 133	java/lang/StringBuilder
    //   713: dup
    //   714: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   717: aload 27
    //   719: iload 28
    //   721: invokevirtual 202	okhttp3/Headers:name	(I)Ljava/lang/String;
    //   724: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: ldc 208
    //   729: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: aload 27
    //   734: iload 28
    //   736: invokevirtual 211	okhttp3/Headers:value	(I)Ljava/lang/String;
    //   739: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   745: invokeinterface 181 2 0
    //   750: iinc 28 1
    //   753: goto -54 -> 699
    //   756: aload_0
    //   757: aload_3
    //   758: invokevirtual 195	okhttp3/Request:headers	()Lokhttp3/Headers;
    //   761: invokespecial 264	okhttp3/logging/HttpLoggingInterceptor:bodyHasUnknownEncoding	(Lokhttp3/Headers;)Z
    //   764: ifeq +43 -> 807
    //   767: aload_0
    //   768: getfield 44	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   771: new 133	java/lang/StringBuilder
    //   774: dup
    //   775: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   778: ldc 215
    //   780: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: aload_3
    //   784: invokevirtual 144	okhttp3/Request:method	()Ljava/lang/String;
    //   787: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: ldc_w 266
    //   793: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   799: invokeinterface 181 2 0
    //   804: goto -340 -> 464
    //   807: new 72	f/c
    //   810: dup
    //   811: invokespecial 73	f/c:<init>	()V
    //   814: astore 45
    //   816: aload 6
    //   818: aload 45
    //   820: invokevirtual 270	okhttp3/RequestBody:writeTo	(Lf/d;)V
    //   823: getstatic 24	okhttp3/logging/HttpLoggingInterceptor:UTF8	Ljava/nio/charset/Charset;
    //   826: astore 46
    //   828: aload 6
    //   830: invokevirtual 185	okhttp3/RequestBody:contentType	()Lokhttp3/MediaType;
    //   833: astore 47
    //   835: aload 47
    //   837: ifnull +13 -> 850
    //   840: aload 47
    //   842: getstatic 24	okhttp3/logging/HttpLoggingInterceptor:UTF8	Ljava/nio/charset/Charset;
    //   845: invokevirtual 276	okhttp3/MediaType:charset	(Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;
    //   848: astore 46
    //   850: aload_0
    //   851: getfield 44	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   854: ldc 213
    //   856: invokeinterface 181 2 0
    //   861: aload 45
    //   863: invokestatic 278	okhttp3/logging/HttpLoggingInterceptor:isPlaintext	(Lf/c;)Z
    //   866: ifeq +71 -> 937
    //   869: aload_0
    //   870: getfield 44	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   873: aload 45
    //   875: aload 46
    //   877: invokevirtual 281	f/c:a	(Ljava/nio/charset/Charset;)Ljava/lang/String;
    //   880: invokeinterface 181 2 0
    //   885: aload_0
    //   886: getfield 44	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   889: new 133	java/lang/StringBuilder
    //   892: dup
    //   893: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   896: ldc 215
    //   898: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: aload_3
    //   902: invokevirtual 144	okhttp3/Request:method	()Ljava/lang/String;
    //   905: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: ldc 167
    //   910: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   913: aload 6
    //   915: invokevirtual 172	okhttp3/RequestBody:contentLength	()J
    //   918: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   921: ldc 177
    //   923: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   926: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   929: invokeinterface 181 2 0
    //   934: goto -470 -> 464
    //   937: aload_0
    //   938: getfield 44	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   941: new 133	java/lang/StringBuilder
    //   944: dup
    //   945: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   948: ldc 215
    //   950: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: aload_3
    //   954: invokevirtual 144	okhttp3/Request:method	()Ljava/lang/String;
    //   957: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   960: ldc_w 283
    //   963: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: aload 6
    //   968: invokevirtual 172	okhttp3/RequestBody:contentLength	()J
    //   971: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   974: ldc_w 285
    //   977: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   980: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   983: invokeinterface 181 2 0
    //   988: goto -524 -> 464
    //   991: astore 14
    //   993: aload_0
    //   994: getfield 44	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   997: new 133	java/lang/StringBuilder
    //   1000: dup
    //   1001: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1004: ldc_w 287
    //   1007: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1010: aload 14
    //   1012: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1015: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1018: invokeinterface 181 2 0
    //   1023: aload 14
    //   1025: athrow
    //   1026: ldc_w 289
    //   1029: astore 21
    //   1031: goto -494 -> 537
    //   1034: new 133	java/lang/StringBuilder
    //   1037: dup
    //   1038: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1041: bipush 32
    //   1043: invokevirtual 147	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1046: aload 15
    //   1048: invokevirtual 251	okhttp3/Response:message	()Ljava/lang/String;
    //   1051: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1054: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1057: astore 24
    //   1059: goto -479 -> 580
    //   1062: ldc 213
    //   1064: astore 26
    //   1066: goto -411 -> 655
    //   1069: iload 4
    //   1071: ifeq +11 -> 1082
    //   1074: aload 15
    //   1076: invokestatic 295	okhttp3/internal/http/HttpHeaders:hasBody	(Lokhttp3/Response;)Z
    //   1079: ifne +18 -> 1097
    //   1082: aload_0
    //   1083: getfield 44	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   1086: ldc_w 297
    //   1089: invokeinterface 181 2 0
    //   1094: aload 15
    //   1096: areturn
    //   1097: aload_0
    //   1098: aload 15
    //   1100: invokevirtual 262	okhttp3/Response:headers	()Lokhttp3/Headers;
    //   1103: invokespecial 264	okhttp3/logging/HttpLoggingInterceptor:bodyHasUnknownEncoding	(Lokhttp3/Headers;)Z
    //   1106: ifeq +18 -> 1124
    //   1109: aload_0
    //   1110: getfield 44	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   1113: ldc_w 299
    //   1116: invokeinterface 181 2 0
    //   1121: goto -27 -> 1094
    //   1124: aload 18
    //   1126: invokevirtual 303	okhttp3/ResponseBody:source	()Lf/e;
    //   1129: astore 30
    //   1131: aload 30
    //   1133: ldc2_w 304
    //   1136: invokeinterface 311 3 0
    //   1141: pop
    //   1142: aload 30
    //   1144: invokeinterface 314 1 0
    //   1149: astore 32
    //   1151: ldc 64
    //   1153: aload 27
    //   1155: ldc 48
    //   1157: invokevirtual 54	okhttp3/Headers:get	(Ljava/lang/String;)Ljava/lang/String;
    //   1160: invokevirtual 62	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1163: istore 33
    //   1165: aconst_null
    //   1166: astore 34
    //   1168: iload 33
    //   1170: ifeq +54 -> 1224
    //   1173: aload 32
    //   1175: invokevirtual 77	f/c:a	()J
    //   1178: invokestatic 320	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1181: astore 34
    //   1183: new 322	f/j
    //   1186: dup
    //   1187: aload 32
    //   1189: invokevirtual 325	f/c:w	()Lf/c;
    //   1192: invokespecial 328	f/j:<init>	(Lf/t;)V
    //   1195: astore 37
    //   1197: new 72	f/c
    //   1200: dup
    //   1201: invokespecial 73	f/c:<init>	()V
    //   1204: astore 32
    //   1206: aload 32
    //   1208: aload 37
    //   1210: invokevirtual 331	f/c:a	(Lf/t;)J
    //   1213: pop2
    //   1214: aload 37
    //   1216: ifnull +8 -> 1224
    //   1219: aload 37
    //   1221: invokevirtual 334	f/j:close	()V
    //   1224: getstatic 24	okhttp3/logging/HttpLoggingInterceptor:UTF8	Ljava/nio/charset/Charset;
    //   1227: astore 35
    //   1229: aload 18
    //   1231: invokevirtual 335	okhttp3/ResponseBody:contentType	()Lokhttp3/MediaType;
    //   1234: astore 36
    //   1236: aload 36
    //   1238: ifnull +13 -> 1251
    //   1241: aload 36
    //   1243: getstatic 24	okhttp3/logging/HttpLoggingInterceptor:UTF8	Ljava/nio/charset/Charset;
    //   1246: invokevirtual 276	okhttp3/MediaType:charset	(Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;
    //   1249: astore 35
    //   1251: aload 32
    //   1253: invokestatic 278	okhttp3/logging/HttpLoggingInterceptor:isPlaintext	(Lf/c;)Z
    //   1256: ifne +74 -> 1330
    //   1259: aload_0
    //   1260: getfield 44	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   1263: ldc 213
    //   1265: invokeinterface 181 2 0
    //   1270: aload_0
    //   1271: getfield 44	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   1274: new 133	java/lang/StringBuilder
    //   1277: dup
    //   1278: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1281: ldc_w 337
    //   1284: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1287: aload 32
    //   1289: invokevirtual 77	f/c:a	()J
    //   1292: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1295: ldc_w 285
    //   1298: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1301: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1304: invokeinterface 181 2 0
    //   1309: aload 15
    //   1311: areturn
    //   1312: astore 38
    //   1314: aconst_null
    //   1315: astore 39
    //   1317: aload 39
    //   1319: ifnull +8 -> 1327
    //   1322: aload 39
    //   1324: invokevirtual 334	f/j:close	()V
    //   1327: aload 38
    //   1329: athrow
    //   1330: lload 19
    //   1332: lconst_0
    //   1333: lcmp
    //   1334: ifeq +33 -> 1367
    //   1337: aload_0
    //   1338: getfield 44	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   1341: ldc 213
    //   1343: invokeinterface 181 2 0
    //   1348: aload_0
    //   1349: getfield 44	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   1352: aload 32
    //   1354: invokevirtual 325	f/c:w	()Lf/c;
    //   1357: aload 35
    //   1359: invokevirtual 281	f/c:a	(Ljava/nio/charset/Charset;)Ljava/lang/String;
    //   1362: invokeinterface 181 2 0
    //   1367: aload 34
    //   1369: ifnull +56 -> 1425
    //   1372: aload_0
    //   1373: getfield 44	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   1376: new 133	java/lang/StringBuilder
    //   1379: dup
    //   1380: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1383: ldc_w 339
    //   1386: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1389: aload 32
    //   1391: invokevirtual 77	f/c:a	()J
    //   1394: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1397: ldc_w 341
    //   1400: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1403: aload 34
    //   1405: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1408: ldc_w 343
    //   1411: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1414: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1417: invokeinterface 181 2 0
    //   1422: goto -328 -> 1094
    //   1425: aload_0
    //   1426: getfield 44	okhttp3/logging/HttpLoggingInterceptor:logger	Lokhttp3/logging/HttpLoggingInterceptor$Logger;
    //   1429: new 133	java/lang/StringBuilder
    //   1432: dup
    //   1433: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1436: ldc_w 339
    //   1439: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1442: aload 32
    //   1444: invokevirtual 77	f/c:a	()J
    //   1447: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1450: ldc 177
    //   1452: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1455: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1458: invokeinterface 181 2 0
    //   1463: goto -369 -> 1094
    //   1466: astore 38
    //   1468: aload 37
    //   1470: astore 39
    //   1472: goto -155 -> 1317
    //
    // Exception table:
    //   from	to	target	type
    //   469	478	991	java/lang/Exception
    //   1183	1197	1312	finally
    //   1197	1214	1466	finally
  }

  public HttpLoggingInterceptor setLevel(Level paramLevel)
  {
    if (paramLevel == null)
      throw new NullPointerException("level == null. Use Level.NONE instead.");
    this.level = paramLevel;
    return this;
  }

  public static enum Level
  {
    static
    {
      BASIC = new Level("BASIC", 1);
      HEADERS = new Level("HEADERS", 2);
      BODY = new Level("BODY", 3);
      Level[] arrayOfLevel = new Level[4];
      arrayOfLevel[0] = NONE;
      arrayOfLevel[1] = BASIC;
      arrayOfLevel[2] = HEADERS;
      arrayOfLevel[3] = BODY;
    }
  }

  public static abstract interface Logger
  {
    public static final Logger DEFAULT = new Logger()
    {
      public void log(String paramAnonymousString)
      {
        Platform.get().log(4, paramAnonymousString, null);
      }
    };

    public abstract void log(String paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.logging.HttpLoggingInterceptor
 * JD-Core Version:    0.6.2
 */