package com.yandex.mobile.ads.mediation.nativeads;

import android.content.Context;
import com.yandex.mobile.ads.impl.eo;
import com.yandex.mobile.ads.nativeads.q;
import com.yandex.mobile.ads.nativeads.r;

public final class d
  implements r
{
  private final a a;

  d(a parama)
  {
    this.a = parama;
  }

  public final q a(Context paramContext, eo parameo)
  {
    q localq = new q(paramContext, parameo);
    this.a.a(localq);
    return localq;
  }

  static abstract interface a
  {
    public abstract void a(q paramq);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.nativeads.d
 * JD-Core Version:    0.6.2
 */