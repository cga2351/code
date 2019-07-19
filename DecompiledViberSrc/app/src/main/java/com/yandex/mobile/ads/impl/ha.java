package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.InterstitialEventListener;

public final class ha
  implements fs
{
  private static final Object a = new Object();
  private final Handler b = new Handler(Looper.getMainLooper());
  private InterstitialEventListener c;

  public final void a()
  {
    this.b.post(new Runnable()
    {
      public final void run()
      {
        synchronized (ha.h())
        {
          if (ha.a(ha.this) != null)
            ha.a(ha.this).onAdClosed();
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
        synchronized (ha.h())
        {
          if (ha.a(ha.this) != null)
            ha.a(ha.this).onInterstitialFailedToLoad(paramAdRequestError);
          return;
        }
      }
    });
  }

  final void a(InterstitialEventListener paramInterstitialEventListener)
  {
    synchronized (a)
    {
      this.c = paramInterstitialEventListener;
      return;
    }
  }

  public final void b()
  {
    this.b.post(new Runnable()
    {
      public final void run()
      {
        synchronized (ha.h())
        {
          if (ha.a(ha.this) != null)
            ha.a(ha.this).onInterstitialDismissed();
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
        synchronized (ha.h())
        {
          if (ha.a(ha.this) != null)
            ha.a(ha.this).onAdLeftApplication();
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
        synchronized (ha.h())
        {
          if (ha.a(ha.this) != null)
            ha.a(ha.this).onInterstitialLoaded();
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
        synchronized (ha.h())
        {
          if (ha.a(ha.this) != null)
            ha.a(ha.this).onAdOpened();
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
        synchronized (ha.h())
        {
          if (ha.a(ha.this) != null)
            ha.a(ha.this).onInterstitialShown();
          return;
        }
      }
    });
  }

  final InterstitialEventListener g()
  {
    synchronized (a)
    {
      InterstitialEventListener localInterstitialEventListener = this.c;
      return localInterstitialEventListener;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ha
 * JD-Core Version:    0.6.2
 */