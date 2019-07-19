package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.b;

abstract class f extends ga
{
  private boolean h;
  private Runnable i = new Runnable()
  {
    public final void run()
    {
      f.this.a(f.a(f.this));
    }
  };

  f(Context paramContext, b paramb)
  {
    super(paramContext, paramb);
    if ((o()) && (cz.b()))
      this.h = true;
  }

  private void a()
  {
    this.a.removeCallbacks(this.i);
  }

  private void d()
  {
    a();
    v localv = w();
    if ((localv != null) && (localv.t()) && (this.h) && (!A()))
    {
      this.a.postDelayed(this.i, localv.m());
      new Object[1][0] = Integer.valueOf(localv.k());
    }
  }

  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    d();
  }

  final void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if (this.h)
    {
      d();
      return;
    }
    a();
  }

  public void b(int paramInt)
  {
    super.b(paramInt);
    d();
  }

  public void e()
  {
    super.e();
    a(false);
  }

  protected final void h()
  {
    super.h();
    d();
  }

  public void onAdFailedToLoad(AdRequestError paramAdRequestError)
  {
    super.onAdFailedToLoad(paramAdRequestError);
    if ((5 != paramAdRequestError.getCode()) && (2 != paramAdRequestError.getCode()))
      d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.f
 * JD-Core Version:    0.6.2
 */