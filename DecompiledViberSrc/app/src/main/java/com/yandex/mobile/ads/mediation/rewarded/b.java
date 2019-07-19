package com.yandex.mobile.ads.mediation.rewarded;

import android.content.Context;
import com.yandex.mobile.ads.impl.ar;
import com.yandex.mobile.ads.impl.at;
import com.yandex.mobile.ads.impl.av;

final class b
  implements at<MediatedRewardedAdapter>
{
  private final av<MediatedRewardedAdapter> a;

  b(av<MediatedRewardedAdapter> paramav)
  {
    this.a = paramav;
  }

  public final ar<MediatedRewardedAdapter> a(Context paramContext)
  {
    return this.a.a(paramContext, MediatedRewardedAdapter.class);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.rewarded.b
 * JD-Core Version:    0.6.2
 */