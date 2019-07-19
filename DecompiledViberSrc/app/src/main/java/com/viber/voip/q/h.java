package com.viber.voip.q;

import android.os.Handler;
import android.os.Looper;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public abstract class h
{
  private final Handler a;

  protected h()
  {
    this.a = null;
  }

  protected h(Handler paramHandler)
  {
    this.a = paramHandler;
  }

  private void a(g paramg)
  {
    switch (paramg.b)
    {
    default:
      return;
    case 0:
      a(paramg.a, paramg.c);
      return;
    case 2:
      b(paramg.a, paramg.d);
      return;
    case 3:
      c(paramg.a, paramg.d);
      return;
    case 1:
    }
    a(paramg.a, paramg.d);
  }

  protected void a(long paramLong)
  {
  }

  public abstract void a(String paramString, int paramInt);

  public abstract void a(String paramString, long paramLong);

  public abstract void b(String paramString, long paramLong);

  public abstract void c(String paramString, long paramLong);

  @Subscribe(threadMode=ThreadMode.MAIN_ORDERED)
  public final void onPlayerStateChanged(final g paramg)
  {
    if ((this.a != null) && (this.a.getLooper().getThread() != Thread.currentThread()))
    {
      this.a.post(new Runnable()
      {
        public void run()
        {
          h.a(h.this, paramg);
        }
      });
      return;
    }
    a(paramg);
  }

  @Subscribe(threadMode=ThreadMode.MAIN_ORDERED)
  public final void onProgressChanged(final e parame)
  {
    if ((this.a != null) && (this.a.getLooper().getThread() != Thread.currentThread()))
    {
      this.a.post(new Runnable()
      {
        public void run()
        {
          h.this.a(parame.b);
        }
      });
      return;
    }
    a(parame.b);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.q.h
 * JD-Core Version:    0.6.2
 */