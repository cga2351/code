package com.yandex.mobile.ads.mediation.banner;

import android.content.Context;
import com.yandex.mobile.ads.impl.ar;
import com.yandex.mobile.ads.impl.at;
import com.yandex.mobile.ads.impl.av;

final class c
  implements at<MediatedBannerAdapter>
{
  private final av<MediatedBannerAdapter> a;

  c(av<MediatedBannerAdapter> paramav)
  {
    this.a = paramav;
  }

  public final ar<MediatedBannerAdapter> a(Context paramContext)
  {
    return this.a.a(paramContext, MediatedBannerAdapter.class);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.banner.c
 * JD-Core Version:    0.6.2
 */