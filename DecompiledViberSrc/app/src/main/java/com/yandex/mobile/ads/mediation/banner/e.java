package com.yandex.mobile.ads.mediation.banner;

import android.content.Context;
import com.yandex.mobile.ads.impl.as;
import com.yandex.mobile.ads.impl.av;
import com.yandex.mobile.ads.impl.ax;
import com.yandex.mobile.ads.impl.ay;
import com.yandex.mobile.ads.impl.bb;
import com.yandex.mobile.ads.impl.eo;
import com.yandex.mobile.ads.impl.v;

public final class e
  implements b
{
  private final MediatedBannerAdapter.MediatedBannerAdapterListener a;
  private final as<MediatedBannerAdapter, MediatedBannerAdapter.MediatedBannerAdapterListener> b;

  public e(com.yandex.mobile.ads.impl.a parama, bb parambb)
  {
    eo localeo = parama.r();
    f localf = new f(localeo);
    ay localay = new ay(localeo);
    c localc = new c(new av(parambb, localf, localay));
    ax localax = new ax(parama, parambb);
    this.b = new as(new d(), localay, localc, localax);
    g localg = new g(parama.a(), this.b);
    this.a = new a(parama, this.b, localg);
  }

  public final void a(Context paramContext)
  {
    this.b.a(paramContext);
  }

  public final void a(Context paramContext, v<String> paramv)
  {
    this.b.a(paramContext, this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.banner.e
 * JD-Core Version:    0.6.2
 */