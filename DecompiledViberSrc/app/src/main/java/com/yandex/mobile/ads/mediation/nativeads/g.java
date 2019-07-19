package com.yandex.mobile.ads.mediation.nativeads;

import android.content.Context;
import com.yandex.mobile.ads.impl.ar;
import com.yandex.mobile.ads.impl.at;
import com.yandex.mobile.ads.impl.av;

final class g
  implements at<MediatedNativeAdapter>
{
  private final av<MediatedNativeAdapter> a;

  g(av<MediatedNativeAdapter> paramav)
  {
    this.a = paramav;
  }

  public final ar<MediatedNativeAdapter> a(Context paramContext)
  {
    return this.a.a(paramContext, MediatedNativeAdapter.class);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.nativeads.g
 * JD-Core Version:    0.6.2
 */