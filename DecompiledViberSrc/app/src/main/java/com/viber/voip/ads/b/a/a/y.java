package com.viber.voip.ads.b.a.a;

import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.b.a.a.a.d;
import com.viber.voip.ads.b.b.a.c;
import com.viber.voip.banner.datatype.PublicAccountsAdsMetaInfo;
import com.viber.voip.banner.e.a;
import com.viber.voip.util.ap;
import java.util.concurrent.TimeUnit;

public class y
  implements l<d>
{
  private static final Logger a = ViberEnv.getLogger();
  private static final int b = (int)TimeUnit.SECONDS.toMillis(5L);
  private final ap c;
  private final Handler d;

  y(ap paramap, Handler paramHandler)
  {
    this.c = paramap;
    this.d = paramHandler;
  }

  // ERROR //
  private a a(d paramd)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 61	com/viber/voip/ads/b/a/a/a/d:b	Landroid/net/Uri;
    //   4: invokevirtual 67	android/net/Uri:toString	()Ljava/lang/String;
    //   7: astore_2
    //   8: aload_0
    //   9: aload_2
    //   10: invokespecial 70	com/viber/voip/ads/b/a/a/y:a	(Ljava/lang/String;)Ljava/lang/String;
    //   13: astore_3
    //   14: aload_0
    //   15: getfield 45	com/viber/voip/ads/b/a/a/y:c	Lcom/viber/voip/util/ap;
    //   18: aload_3
    //   19: invokevirtual 75	com/viber/voip/util/ap:c	(Ljava/lang/String;)Z
    //   22: ifne +17 -> 39
    //   25: new 77	com/viber/voip/ads/b/a/a/y$a
    //   28: dup
    //   29: aconst_null
    //   30: iconst_2
    //   31: invokespecial 80	com/viber/voip/ads/b/a/a/y$a:<init>	(Ljava/lang/String;I)V
    //   34: astore 4
    //   36: aload 4
    //   38: areturn
    //   39: getstatic 39	com/viber/voip/ads/b/a/a/y:b	I
    //   42: istore 10
    //   44: invokestatic 84	com/viber/voip/ViberEnv:getOkHttpClientFactory	()Lcom/viber/voip/util/http/OkHttpClientFactory;
    //   47: invokeinterface 90 1 0
    //   52: iload 10
    //   54: i2l
    //   55: getstatic 93	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   58: invokevirtual 99	okhttp3/OkHttpClient$Builder:readTimeout	(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;
    //   61: iload 10
    //   63: i2l
    //   64: getstatic 93	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   67: invokevirtual 102	okhttp3/OkHttpClient$Builder:connectTimeout	(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;
    //   70: astore 11
    //   72: new 104	okhttp3/Request$Builder
    //   75: dup
    //   76: invokespecial 105	okhttp3/Request$Builder:<init>	()V
    //   79: aload_2
    //   80: invokevirtual 109	okhttp3/Request$Builder:url	(Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   83: astore 12
    //   85: aload 11
    //   87: invokevirtual 113	okhttp3/OkHttpClient$Builder:build	()Lokhttp3/OkHttpClient;
    //   90: aload 12
    //   92: invokevirtual 116	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   95: invokevirtual 122	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
    //   98: invokeinterface 128 1 0
    //   103: astore 13
    //   105: aload 13
    //   107: invokevirtual 134	okhttp3/Response:isSuccessful	()Z
    //   110: ifeq +146 -> 256
    //   113: new 77	com/viber/voip/ads/b/a/a/y$a
    //   116: dup
    //   117: aload 13
    //   119: invokevirtual 138	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   122: invokevirtual 143	okhttp3/ResponseBody:string	()Ljava/lang/String;
    //   125: iconst_0
    //   126: invokespecial 80	com/viber/voip/ads/b/a/a/y$a:<init>	(Ljava/lang/String;I)V
    //   129: astore 4
    //   131: aload_0
    //   132: getfield 45	com/viber/voip/ads/b/a/a/y:c	Lcom/viber/voip/util/ap;
    //   135: aload_3
    //   136: invokevirtual 146	com/viber/voip/util/ap:d	(Ljava/lang/String;)V
    //   139: aconst_null
    //   140: invokestatic 151	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   143: aload 4
    //   145: ifnonnull -109 -> 36
    //   148: new 77	com/viber/voip/ads/b/a/a/y$a
    //   151: dup
    //   152: aconst_null
    //   153: iconst_3
    //   154: invokespecial 80	com/viber/voip/ads/b/a/a/y$a:<init>	(Ljava/lang/String;I)V
    //   157: areturn
    //   158: astore 9
    //   160: aload_0
    //   161: getfield 45	com/viber/voip/ads/b/a/a/y:c	Lcom/viber/voip/util/ap;
    //   164: aload_3
    //   165: iconst_0
    //   166: invokevirtual 153	com/viber/voip/util/ap:a	(Ljava/lang/String;I)V
    //   169: new 77	com/viber/voip/ads/b/a/a/y$a
    //   172: dup
    //   173: aconst_null
    //   174: iconst_1
    //   175: invokespecial 80	com/viber/voip/ads/b/a/a/y$a:<init>	(Ljava/lang/String;I)V
    //   178: astore 4
    //   180: aconst_null
    //   181: invokestatic 151	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   184: goto -41 -> 143
    //   187: astore 8
    //   189: aconst_null
    //   190: astore 4
    //   192: aload_0
    //   193: getfield 45	com/viber/voip/ads/b/a/a/y:c	Lcom/viber/voip/util/ap;
    //   196: aload_3
    //   197: iconst_0
    //   198: invokevirtual 153	com/viber/voip/util/ap:a	(Ljava/lang/String;I)V
    //   201: aconst_null
    //   202: invokestatic 151	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   205: goto -62 -> 143
    //   208: astore 7
    //   210: aconst_null
    //   211: astore 4
    //   213: aconst_null
    //   214: invokestatic 151	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   217: goto -74 -> 143
    //   220: astore 6
    //   222: aconst_null
    //   223: astore 4
    //   225: aconst_null
    //   226: invokestatic 151	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   229: goto -86 -> 143
    //   232: astore 5
    //   234: aconst_null
    //   235: invokestatic 151	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   238: aload 5
    //   240: athrow
    //   241: astore 16
    //   243: goto -18 -> 225
    //   246: astore 15
    //   248: goto -35 -> 213
    //   251: astore 14
    //   253: goto -61 -> 192
    //   256: aconst_null
    //   257: astore 4
    //   259: goto -120 -> 139
    //
    // Exception table:
    //   from	to	target	type
    //   39	131	158	java/net/SocketTimeoutException
    //   131	139	158	java/net/SocketTimeoutException
    //   39	131	187	java/io/IOException
    //   39	131	208	java/lang/IllegalArgumentException
    //   39	131	220	java/lang/Exception
    //   39	131	232	finally
    //   131	139	232	finally
    //   160	180	232	finally
    //   192	201	232	finally
    //   131	139	241	java/lang/Exception
    //   131	139	246	java/lang/IllegalArgumentException
    //   131	139	251	java/io/IOException
  }

  private String a(String paramString)
  {
    return paramString.replaceFirst("(?<=[?&;])long=.*?($|[&;])", "").replaceFirst("(?<=[?&;])lat=.*?($|[&;])", "");
  }

  private void b(c paramc, int paramInt)
  {
    this.d.post(new aa(paramc, paramInt));
  }

  public int a()
  {
    return 1;
  }

  public void a(d paramd, c paramc)
  {
    paramd.getClass();
    switch (0)
    {
    case 1:
    default:
      return;
    case 0:
    }
    a locala = a(paramd);
    if (locala.b == 0)
      switch (paramd.c)
      {
      default:
        return;
      case 0:
      }
    try
    {
      PublicAccountsAdsMetaInfo localPublicAccountsAdsMetaInfo2 = a.d(locala.a);
      localPublicAccountsAdsMetaInfo1 = localPublicAccountsAdsMetaInfo2;
      if ((localPublicAccountsAdsMetaInfo1 != null) && (localPublicAccountsAdsMetaInfo1.items != null) && (localPublicAccountsAdsMetaInfo1.items.length > 0))
      {
        this.d.post(new z(paramc, locala, localPublicAccountsAdsMetaInfo1));
        return;
      }
      b(paramc, 1);
      return;
      if (locala.b == 1);
      for (int i = 2; ; i = 4)
      {
        b(paramc, i);
        return;
      }
    }
    catch (Exception localException)
    {
      while (true)
        PublicAccountsAdsMetaInfo localPublicAccountsAdsMetaInfo1 = null;
    }
  }

  public static class a
  {
    public final String a;
    public final int b;

    public a(String paramString, int paramInt)
    {
      this.a = paramString;
      this.b = paramInt;
    }

    public String toString()
    {
      return "AdsResponse{data='" + this.a + '\'' + ", status=" + this.b + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.b.a.a.y
 * JD-Core Version:    0.6.2
 */