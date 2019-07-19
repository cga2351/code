package com.yandex.mobile.ads.mediation.interstitial;

import android.content.Context;
import com.yandex.mobile.ads.impl.ar;
import com.yandex.mobile.ads.impl.at;
import com.yandex.mobile.ads.impl.av;

final class b
  implements at<MediatedInterstitialAdapter>
{
  private final av<MediatedInterstitialAdapter> a;

  b(av<MediatedInterstitialAdapter> paramav)
  {
    this.a = paramav;
  }

  public final ar<MediatedInterstitialAdapter> a(Context paramContext)
  {
    return this.a.a(paramContext, MediatedInterstitialAdapter.class);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.interstitial.b
 * JD-Core Version:    0.6.2
 */