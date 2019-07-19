package com.yandex.mobile.ads.mediation.nativeads;

import android.content.Context;
import com.yandex.mobile.ads.impl.as;
import com.yandex.mobile.ads.impl.av;
import com.yandex.mobile.ads.impl.aw;
import com.yandex.mobile.ads.impl.ax;
import com.yandex.mobile.ads.impl.ay;
import com.yandex.mobile.ads.impl.bb;
import com.yandex.mobile.ads.impl.eo;
import com.yandex.mobile.ads.impl.lm;
import com.yandex.mobile.ads.impl.v;
import com.yandex.mobile.ads.nativeads.t;

public final class i
  implements o
{
  private final MediatedNativeAdapterListener a;
  private final as<MediatedNativeAdapter, MediatedNativeAdapterListener> b;

  public i(t paramt, bb parambb)
  {
    eo localeo = paramt.r();
    aw localaw = new aw(localeo);
    ay localay = new ay(localeo);
    g localg = new g(new av(parambb, localaw, localay));
    ax localax = new ax(paramt, parambb);
    this.b = new as(new h(), localay, localg, localax);
    this.a = new n(paramt, this.b);
  }

  public final void a(Context paramContext, v<lm> paramv)
  {
    this.b.a(paramContext, this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.nativeads.i
 * JD-Core Version:    0.6.2
 */