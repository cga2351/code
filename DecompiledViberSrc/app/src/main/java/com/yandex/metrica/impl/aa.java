package com.yandex.metrica.impl;

import android.os.Handler;
import android.os.SystemClock;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.impl.ob.oq;

class aa
{
  private final Handler a;
  private final c b;
  private final ab c;

  aa(Handler paramHandler, c paramc)
  {
    this.a = paramHandler;
    this.b = paramc;
    this.c = new ab(paramHandler, paramc);
  }

  private static long a(c paramc)
  {
    return SystemClock.uptimeMillis() + c(paramc);
  }

  static void a(Handler paramHandler, c paramc, Runnable paramRunnable)
  {
    b(paramHandler, paramc, paramRunnable);
    paramHandler.postAtTime(paramRunnable, b(paramc), a(paramc));
  }

  private static String b(c paramc)
  {
    return paramc.d().b().f();
  }

  private static void b(Handler paramHandler, c paramc, Runnable paramRunnable)
  {
    paramHandler.removeCallbacks(paramRunnable, b(paramc));
  }

  private static int c(c paramc)
  {
    return 500 * oq.a(paramc.d().b().d(), 10);
  }

  void a()
  {
    b(this.a, this.b, this.c);
  }

  void b()
  {
    a(this.a, this.b, this.c);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.aa
 * JD-Core Version:    0.6.2
 */