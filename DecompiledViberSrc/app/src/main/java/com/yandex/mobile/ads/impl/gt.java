package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;

public final class gt
{
  private final gs a;
  private final Handler b;
  private final he c;
  private final gr d;
  private boolean e;

  public gt(gs paramgs)
  {
    this.a = paramgs;
    this.c = new he();
    this.b = new Handler(Looper.getMainLooper());
    this.d = new gr();
  }

  public final void a()
  {
    if (!this.e)
      this.c.a(new Runnable()
      {
        public final void run()
        {
          gt.b(gt.this).postDelayed(gt.a(gt.this), 10000L);
        }
      });
  }

  public final void a(int paramInt, String paramString)
  {
    this.e = true;
    this.b.removeCallbacks(this.d);
    this.b.post(new gu(paramInt, paramString, this.a));
  }

  public final void a(dn paramdn)
  {
    this.d.a(paramdn);
  }

  public final void b()
  {
    this.b.removeCallbacksAndMessages(null);
    this.d.a(null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.gt
 * JD-Core Version:    0.6.2
 */