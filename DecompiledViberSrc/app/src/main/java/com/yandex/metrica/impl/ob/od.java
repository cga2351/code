package com.yandex.metrica.impl.ob;

import android.os.HandlerThread;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class od
  implements ThreadFactory
{
  private static final AtomicInteger a = new AtomicInteger(0);
  private final String b;

  public od(String paramString)
  {
    this.b = paramString;
  }

  public static HandlerThread a(String paramString)
  {
    return new od(paramString).a();
  }

  public static Thread a(String paramString, Runnable paramRunnable)
  {
    return new od(paramString).newThread(paramRunnable);
  }

  public static int b()
  {
    return a.incrementAndGet();
  }

  public static HandlerThread b(String paramString)
  {
    return a(String.format(Locale.US, "YMM-TH [%s]", new Object[] { paramString }));
  }

  public static String c(String paramString)
  {
    return paramString + "-" + a.incrementAndGet();
  }

  public HandlerThread a()
  {
    return new HandlerThread(c(this.b));
  }

  public Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, c(this.b));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.od
 * JD-Core Version:    0.6.2
 */