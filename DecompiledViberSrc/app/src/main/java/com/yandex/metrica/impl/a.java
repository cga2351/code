package com.yandex.metrica.impl;

import android.os.Handler;
import com.yandex.metrica.impl.ob.om;
import java.util.concurrent.TimeUnit;

public class a
{
  public static final long a = TimeUnit.SECONDS.toMillis(10L);
  private long b;
  private final om c;

  public a()
  {
    this(new om());
  }

  a(om paramom)
  {
    this.c = paramom;
  }

  public void a()
  {
    this.b = this.c.a();
  }

  public void a(long paramLong, Handler paramHandler, final a parama)
  {
    long l = Math.max(paramLong - (this.c.a() - this.b), 0L);
    paramHandler.postDelayed(new Runnable()
    {
      public void run()
      {
        parama.a();
      }
    }
    , l);
  }

  public static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.a
 * JD-Core Version:    0.6.2
 */