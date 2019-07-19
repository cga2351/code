package com.yandex.metrica.impl.ob;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ew
{
  private final ScheduledExecutorService a;
  private final es b;

  public ew(ScheduledExecutorService paramScheduledExecutorService, es parames)
  {
    this.a = paramScheduledExecutorService;
    this.b = parames;
  }

  public void a()
  {
    this.b.a();
  }

  public void a(long paramLong, final a parama)
  {
    this.a.schedule(new Runnable()
    {
      public void run()
      {
        try
        {
          parama.a();
          return;
        }
        catch (Exception localException)
        {
        }
      }
    }
    , paramLong, TimeUnit.MILLISECONDS);
  }

  public void a(long paramLong, boolean paramBoolean)
  {
    this.b.a(paramLong, paramBoolean);
  }

  public static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ew
 * JD-Core Version:    0.6.2
 */