package com.viber.voip.ads;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.ap;
import java.util.concurrent.TimeUnit;

public class r
  implements q
{
  private static final Logger a = ViberEnv.getLogger();
  private static final int b = (int)TimeUnit.SECONDS.toMillis(5L);
  private final ap c;

  public r(ap paramap)
  {
    this.c = paramap;
  }

  private String a(String paramString)
  {
    return paramString.replaceFirst("(?<=[?&;])long=.*?($|[&;])", "").replaceFirst("(?<=[?&;])lat=.*?($|[&;])", "");
  }

  // ERROR //
  public q.a a(android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 70	android/net/Uri:toString	()Ljava/lang/String;
    //   4: astore_2
    //   5: aload_0
    //   6: aload_2
    //   7: invokespecial 72	com/viber/voip/ads/r:a	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore_3
    //   11: aload_0
    //   12: getfield 42	com/viber/voip/ads/r:c	Lcom/viber/voip/util/ap;
    //   15: aload_3
    //   16: invokevirtual 77	com/viber/voip/util/ap:c	(Ljava/lang/String;)Z
    //   19: ifne +17 -> 36
    //   22: new 79	com/viber/voip/ads/q$a
    //   25: dup
    //   26: aconst_null
    //   27: iconst_2
    //   28: invokespecial 82	com/viber/voip/ads/q$a:<init>	(Ljava/lang/String;I)V
    //   31: astore 4
    //   33: aload 4
    //   35: areturn
    //   36: getstatic 36	com/viber/voip/ads/r:b	I
    //   39: istore 10
    //   41: invokestatic 86	com/viber/voip/ViberEnv:getOkHttpClientFactory	()Lcom/viber/voip/util/http/OkHttpClientFactory;
    //   44: invokeinterface 92 1 0
    //   49: iload 10
    //   51: i2l
    //   52: getstatic 95	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   55: invokevirtual 101	okhttp3/OkHttpClient$Builder:readTimeout	(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;
    //   58: iload 10
    //   60: i2l
    //   61: getstatic 95	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   64: invokevirtual 104	okhttp3/OkHttpClient$Builder:connectTimeout	(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;
    //   67: astore 11
    //   69: new 106	okhttp3/Request$Builder
    //   72: dup
    //   73: invokespecial 107	okhttp3/Request$Builder:<init>	()V
    //   76: aload_2
    //   77: invokevirtual 111	okhttp3/Request$Builder:url	(Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   80: astore 12
    //   82: aload 11
    //   84: invokevirtual 115	okhttp3/OkHttpClient$Builder:build	()Lokhttp3/OkHttpClient;
    //   87: aload 12
    //   89: invokevirtual 118	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   92: invokevirtual 124	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
    //   95: invokeinterface 130 1 0
    //   100: astore 13
    //   102: aload 13
    //   104: invokevirtual 136	okhttp3/Response:isSuccessful	()Z
    //   107: ifeq +146 -> 253
    //   110: new 79	com/viber/voip/ads/q$a
    //   113: dup
    //   114: aload 13
    //   116: invokevirtual 140	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   119: invokevirtual 145	okhttp3/ResponseBody:string	()Ljava/lang/String;
    //   122: iconst_0
    //   123: invokespecial 82	com/viber/voip/ads/q$a:<init>	(Ljava/lang/String;I)V
    //   126: astore 4
    //   128: aload_0
    //   129: getfield 42	com/viber/voip/ads/r:c	Lcom/viber/voip/util/ap;
    //   132: aload_3
    //   133: invokevirtual 149	com/viber/voip/util/ap:d	(Ljava/lang/String;)V
    //   136: aconst_null
    //   137: invokestatic 154	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   140: aload 4
    //   142: ifnonnull -109 -> 33
    //   145: new 79	com/viber/voip/ads/q$a
    //   148: dup
    //   149: aconst_null
    //   150: iconst_3
    //   151: invokespecial 82	com/viber/voip/ads/q$a:<init>	(Ljava/lang/String;I)V
    //   154: areturn
    //   155: astore 9
    //   157: aload_0
    //   158: getfield 42	com/viber/voip/ads/r:c	Lcom/viber/voip/util/ap;
    //   161: aload_3
    //   162: iconst_0
    //   163: invokevirtual 156	com/viber/voip/util/ap:a	(Ljava/lang/String;I)V
    //   166: new 79	com/viber/voip/ads/q$a
    //   169: dup
    //   170: aconst_null
    //   171: iconst_1
    //   172: invokespecial 82	com/viber/voip/ads/q$a:<init>	(Ljava/lang/String;I)V
    //   175: astore 4
    //   177: aconst_null
    //   178: invokestatic 154	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   181: goto -41 -> 140
    //   184: astore 8
    //   186: aconst_null
    //   187: astore 4
    //   189: aload_0
    //   190: getfield 42	com/viber/voip/ads/r:c	Lcom/viber/voip/util/ap;
    //   193: aload_3
    //   194: iconst_0
    //   195: invokevirtual 156	com/viber/voip/util/ap:a	(Ljava/lang/String;I)V
    //   198: aconst_null
    //   199: invokestatic 154	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   202: goto -62 -> 140
    //   205: astore 7
    //   207: aconst_null
    //   208: astore 4
    //   210: aconst_null
    //   211: invokestatic 154	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   214: goto -74 -> 140
    //   217: astore 6
    //   219: aconst_null
    //   220: astore 4
    //   222: aconst_null
    //   223: invokestatic 154	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   226: goto -86 -> 140
    //   229: astore 5
    //   231: aconst_null
    //   232: invokestatic 154	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   235: aload 5
    //   237: athrow
    //   238: astore 16
    //   240: goto -18 -> 222
    //   243: astore 15
    //   245: goto -35 -> 210
    //   248: astore 14
    //   250: goto -61 -> 189
    //   253: aconst_null
    //   254: astore 4
    //   256: goto -120 -> 136
    //
    // Exception table:
    //   from	to	target	type
    //   36	128	155	java/net/SocketTimeoutException
    //   128	136	155	java/net/SocketTimeoutException
    //   36	128	184	java/io/IOException
    //   36	128	205	java/lang/IllegalArgumentException
    //   36	128	217	java/lang/Exception
    //   36	128	229	finally
    //   128	136	229	finally
    //   157	177	229	finally
    //   189	198	229	finally
    //   128	136	238	java/lang/Exception
    //   128	136	243	java/lang/IllegalArgumentException
    //   128	136	248	java/io/IOException
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.r
 * JD-Core Version:    0.6.2
 */