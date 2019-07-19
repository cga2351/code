package com.yandex.mobile.ads.impl;

import android.os.Handler;
import java.util.concurrent.Executor;

public final class oe
  implements ol
{
  private final Executor a;

  public oe(final Handler paramHandler)
  {
    this.a = new Executor()
    {
      public final void execute(Runnable paramAnonymousRunnable)
      {
        paramHandler.post(paramAnonymousRunnable);
      }
    };
  }

  public final void a(oi<?> paramoi, ok<?> paramok)
  {
    a(paramoi, paramok, null);
  }

  public final void a(oi<?> paramoi, ok<?> paramok, Runnable paramRunnable)
  {
    paramoi.r();
    this.a.execute(new a(paramoi, paramok, paramRunnable));
  }

  public final void a(oi<?> paramoi, ov paramov)
  {
    ok localok = ok.a(paramov);
    this.a.execute(new a(paramoi, localok, null));
  }

  private final class a
    implements Runnable
  {
    private final oi b;
    private final ok c;
    private final Runnable d;

    public a(oi paramok, ok paramRunnable, Runnable arg4)
    {
      this.b = paramok;
      this.c = paramRunnable;
      Object localObject;
      this.d = localObject;
    }

    public final void run()
    {
      if (this.b.j())
      {
        this.b.g();
        return;
      }
      int i;
      if (this.c.c == null)
      {
        i = 1;
        label30: if (i == 0)
          break label87;
        this.b.b(this.c.a);
      }
      while (true)
      {
        if (!this.c.d)
          this.b.g();
        if (this.d == null)
          break;
        this.d.run();
        return;
        i = 0;
        break label30;
        label87: this.b.b(this.c.c);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.oe
 * JD-Core Version:    0.6.2
 */