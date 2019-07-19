package com.yandex.mobile.ads.mediation.interstitial;

import android.content.Context;
import com.yandex.mobile.ads.impl.as;
import com.yandex.mobile.ads.impl.av;
import com.yandex.mobile.ads.impl.aw;
import com.yandex.mobile.ads.impl.ax;
import com.yandex.mobile.ads.impl.ay;
import com.yandex.mobile.ads.impl.bb;
import com.yandex.mobile.ads.impl.eo;
import com.yandex.mobile.ads.impl.ft;
import com.yandex.mobile.ads.impl.hs;
import com.yandex.mobile.ads.impl.v;

public final class d
  implements hs
{
  private final as<MediatedInterstitialAdapter, MediatedInterstitialAdapter.MediatedInterstitialAdapterListener> a;
  private final c b;
  private final MediatedInterstitialAdapter.MediatedInterstitialAdapterListener c;

  public d(ft paramft, bb parambb)
  {
    eo localeo = paramft.r();
    aw localaw = new aw(localeo);
    ay localay = new ay(localeo);
    b localb = new b(new av(parambb, localaw, localay));
    ax localax = new ax(paramft, parambb);
    this.b = new c();
    this.a = new as(this.b, localay, localb, localax);
    this.c = new a(paramft, this.a);
  }

  public final void a(Context paramContext)
  {
    this.a.a(paramContext);
  }

  public final void a(Context paramContext, v<String> paramv)
  {
    this.a.a(paramContext, this.c);
  }

  public final boolean a()
  {
    return this.b.b();
  }

  public final void b()
  {
    MediatedInterstitialAdapter localMediatedInterstitialAdapter = this.b.a();
    if (localMediatedInterstitialAdapter != null)
      localMediatedInterstitialAdapter.showInterstitial();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.interstitial.d
 * JD-Core Version:    0.6.2
 */