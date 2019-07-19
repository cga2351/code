package com.viber.voip.market;

import android.os.Handler;
import android.os.SystemClock;
import android.webkit.SslErrorHandler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class t
{
  private static final Logger a = ViberEnv.getLogger();
  private static final long b = TimeUnit.MINUTES.toMillis(5L);
  private static Map<String, Long> c = new HashMap();

  public static void a(String paramString, final SslErrorHandler paramSslErrorHandler, final Runnable paramRunnable)
  {
    av.a(av.e.f).post(new Runnable()
    {
      public void run()
      {
        Long localLong = (Long)t.a().get(this.a);
        if ((localLong != null) && (SystemClock.elapsedRealtime() - localLong.longValue() < t.b()))
          paramSslErrorHandler.proceed();
        do
        {
          return;
          if (t.a(this.a))
          {
            t.a().put(this.a, Long.valueOf(SystemClock.elapsedRealtime()));
            paramSslErrorHandler.proceed();
            return;
          }
        }
        while (paramRunnable == null);
        av.a(av.e.a).post(paramRunnable);
      }
    });
  }

  // ERROR //
  private static boolean b(String paramString)
  {
    // Byte code:
    //   0: invokestatic 75	com/viber/voip/ViberEnv:getOkHttpClientFactory	()Lcom/viber/voip/util/http/OkHttpClientFactory;
    //   3: invokeinterface 81 1 0
    //   8: lconst_1
    //   9: getstatic 84	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   12: invokevirtual 90	okhttp3/OkHttpClient$Builder:connectTimeout	(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;
    //   15: astore 4
    //   17: new 92	okhttp3/Request$Builder
    //   20: dup
    //   21: invokespecial 93	okhttp3/Request$Builder:<init>	()V
    //   24: aload_0
    //   25: invokevirtual 97	okhttp3/Request$Builder:url	(Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   28: astore 5
    //   30: aload 5
    //   32: invokevirtual 101	okhttp3/Request$Builder:head	()Lokhttp3/Request$Builder;
    //   35: pop
    //   36: aload 4
    //   38: invokevirtual 105	okhttp3/OkHttpClient$Builder:build	()Lokhttp3/OkHttpClient;
    //   41: aload 5
    //   43: invokevirtual 108	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   46: invokevirtual 114	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
    //   49: invokeinterface 120 1 0
    //   54: invokevirtual 126	okhttp3/Response:isSuccessful	()Z
    //   57: istore 7
    //   59: iload 7
    //   61: istore_3
    //   62: iconst_0
    //   63: ifeq +7 -> 70
    //   66: aconst_null
    //   67: invokevirtual 131	java/net/HttpURLConnection:disconnect	()V
    //   70: iload_3
    //   71: ireturn
    //   72: astore_2
    //   73: iconst_0
    //   74: istore_3
    //   75: iconst_0
    //   76: ifeq -6 -> 70
    //   79: aconst_null
    //   80: invokevirtual 131	java/net/HttpURLConnection:disconnect	()V
    //   83: iconst_0
    //   84: ireturn
    //   85: astore_1
    //   86: iconst_0
    //   87: ifeq +7 -> 94
    //   90: aconst_null
    //   91: invokevirtual 131	java/net/HttpURLConnection:disconnect	()V
    //   94: aload_1
    //   95: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	59	72	java/lang/Exception
    //   0	59	85	finally
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.t
 * JD-Core Version:    0.6.2
 */