package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import com.yandex.mobile.ads.VideoEventListener;

public final class dj
  implements dk
{
  private static final Object a = new Object();
  private final Handler b = new Handler(Looper.getMainLooper());
  private VideoEventListener c;

  public final void a()
  {
    this.b.post(new Runnable()
    {
      public final void run()
      {
        synchronized (dj.b())
        {
          if (dj.a(dj.this) != null)
            dj.a(dj.this).onVideoComplete();
          return;
        }
      }
    });
  }

  public final void a(VideoEventListener paramVideoEventListener)
  {
    synchronized (a)
    {
      this.c = paramVideoEventListener;
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.dj
 * JD-Core Version:    0.6.2
 */