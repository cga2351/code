package com.yandex.mobile.ads.rewarded;

import android.os.Handler;
import android.os.Looper;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.impl.fs;

public final class a
  implements fs
{
  private static final Object a = new Object();
  private final Handler b = new Handler(Looper.getMainLooper());
  private RewardedAdEventListener c;

  public final void a()
  {
    this.b.post(new Runnable()
    {
      public final void run()
      {
        synchronized (a.g())
        {
          if (a.a(a.this) != null)
            a.a(a.this).onAdClosed();
          return;
        }
      }
    });
  }

  public final void a(final AdRequestError paramAdRequestError)
  {
    this.b.post(new Runnable()
    {
      public final void run()
      {
        synchronized (a.g())
        {
          if (a.a(a.this) != null)
            a.a(a.this).onAdFailedToLoad(paramAdRequestError);
          return;
        }
      }
    });
  }

  public final void a(final Reward paramReward)
  {
    this.b.post(new Runnable()
    {
      public final void run()
      {
        synchronized (a.g())
        {
          if (a.a(a.this) != null)
            a.a(a.this).onRewarded(paramReward);
          return;
        }
      }
    });
  }

  final void a(RewardedAdEventListener paramRewardedAdEventListener)
  {
    synchronized (a)
    {
      this.c = paramRewardedAdEventListener;
      return;
    }
  }

  public final void b()
  {
    this.b.post(new Runnable()
    {
      public final void run()
      {
        synchronized (a.g())
        {
          if (a.a(a.this) != null)
            a.a(a.this).onAdDismissed();
          return;
        }
      }
    });
  }

  public final void c()
  {
    this.b.post(new Runnable()
    {
      public final void run()
      {
        synchronized (a.g())
        {
          if (a.a(a.this) != null)
            a.a(a.this).onAdLeftApplication();
          return;
        }
      }
    });
  }

  public final void d()
  {
    this.b.post(new Runnable()
    {
      public final void run()
      {
        synchronized (a.g())
        {
          if (a.a(a.this) != null)
            a.a(a.this).onAdLoaded();
          return;
        }
      }
    });
  }

  public final void e()
  {
    this.b.post(new Runnable()
    {
      public final void run()
      {
        synchronized (a.g())
        {
          if (a.a(a.this) != null)
            a.a(a.this).onAdOpened();
          return;
        }
      }
    });
  }

  public final void f()
  {
    this.b.post(new Runnable()
    {
      public final void run()
      {
        synchronized (a.g())
        {
          if (a.a(a.this) != null)
            a.a(a.this).onAdShown();
          return;
        }
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.rewarded.a
 * JD-Core Version:    0.6.2
 */