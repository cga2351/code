package com.viber.voip.report.a.a;

import android.os.Handler;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.registration.af;
import com.viber.voip.report.a.b.a;
import com.viber.voip.util.cl;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicLong;
import javax.inject.Inject;

public class a
{
  private static final a a = (a)cl.b(a.class);
  private final ab b;
  private final af c;
  private final dagger.a<com.viber.voip.report.a.b> d;
  private final ScheduledExecutorService e;
  private final Handler f;
  private final AtomicLong g = new AtomicLong();
  private a h = a;

  @Inject
  public a(ab paramab, af paramaf, dagger.a<com.viber.voip.report.a.b> parama, ScheduledExecutorService paramScheduledExecutorService, Handler paramHandler)
  {
    this.b = paramab;
    this.c = paramaf;
    this.d = parama;
    this.e = paramScheduledExecutorService;
    this.f = paramHandler;
  }

  public void a()
  {
    this.h = a;
  }

  public void a(long paramLong, e parame, String paramString)
  {
    this.g.set(paramLong);
    this.e.execute(new b(this, paramLong, parame, paramString));
  }

  public void a(a parama)
  {
    this.h = parama;
  }

  public void b()
  {
    this.g.set(0L);
  }

  public static abstract interface a
  {
    public abstract void b();

    public abstract void c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.report.a.a.a
 * JD-Core Version:    0.6.2
 */