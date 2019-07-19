package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.mobile.ads.InterstitialEventListener;
import com.yandex.mobile.ads.b;

public final class hb extends ft
{
  private final ha h;

  public hb(Context paramContext, ha paramha)
  {
    super(paramContext, b.b, paramha);
    this.h = paramha;
  }

  public final InterstitialEventListener B()
  {
    return this.h.g();
  }

  protected final hs a(ht paramht)
  {
    return paramht.a(this);
  }

  public final void a(InterstitialEventListener paramInterstitialEventListener)
  {
    this.h.a(paramInterstitialEventListener);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.hb
 * JD-Core Version:    0.6.2
 */