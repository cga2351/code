package com.yandex.metrica.impl.ob;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.Executor;

class hx
  implements Executor
{
  private HandlerThread a;
  private Handler b;
  private Looper c;

  public hx()
  {
    this(od.a("YMM-UH-1"), new a());
  }

  hx(HandlerThread paramHandlerThread, a parama)
  {
    this.a = paramHandlerThread;
    this.a.start();
    this.c = paramHandlerThread.getLooper();
    this.b = parama.a(this.c);
  }

  public Looper a()
  {
    return this.c;
  }

  public void a(Runnable paramRunnable)
  {
    if (paramRunnable != null)
      this.b.removeCallbacks(paramRunnable);
  }

  public void a(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable != null)
      this.b.postDelayed(paramRunnable, paramLong);
  }

  public void execute(Runnable paramRunnable)
  {
    if (paramRunnable != null)
      this.b.post(paramRunnable);
  }

  static class a
  {
    public Handler a(Looper paramLooper)
    {
      return new Handler(paramLooper);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.hx
 * JD-Core Version:    0.6.2
 */