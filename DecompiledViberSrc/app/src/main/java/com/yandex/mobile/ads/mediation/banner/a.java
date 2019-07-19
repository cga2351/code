package com.yandex.mobile.ads.mediation.banner;

import android.content.Context;
import android.view.View;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.impl.as;
import java.lang.ref.WeakReference;

final class a
  implements MediatedBannerAdapter.MediatedBannerAdapterListener
{
  private final WeakReference<com.yandex.mobile.ads.impl.a> a;
  private final g b;
  private final as<MediatedBannerAdapter, MediatedBannerAdapter.MediatedBannerAdapterListener> c;
  private boolean d;

  a(com.yandex.mobile.ads.impl.a parama, as<MediatedBannerAdapter, MediatedBannerAdapter.MediatedBannerAdapterListener> paramas, g paramg)
  {
    this.c = paramas;
    this.b = paramg;
    this.a = new WeakReference(parama);
  }

  public final void onAdClicked()
  {
    com.yandex.mobile.ads.impl.a locala = (com.yandex.mobile.ads.impl.a)this.a.get();
    if (locala != null)
    {
      Context localContext = locala.l();
      this.c.b(localContext);
    }
  }

  public final void onAdFailedToLoad(AdRequestError paramAdRequestError)
  {
    com.yandex.mobile.ads.impl.a locala = (com.yandex.mobile.ads.impl.a)this.a.get();
    Context localContext;
    if (locala != null)
    {
      localContext = locala.l();
      if (!this.d)
        this.c.a(localContext, paramAdRequestError, this);
    }
    else
    {
      return;
    }
    this.c.b(localContext, paramAdRequestError, this);
  }

  public final void onAdLeftApplication()
  {
    com.yandex.mobile.ads.impl.a locala = (com.yandex.mobile.ads.impl.a)this.a.get();
    if (locala != null)
      locala.onAdLeftApplication();
  }

  public final void onAdLoaded(View paramView)
  {
    com.yandex.mobile.ads.impl.a locala = (com.yandex.mobile.ads.impl.a)this.a.get();
    Context localContext;
    if (locala != null)
    {
      localContext = paramView.getContext();
      if (this.d)
        break label53;
      this.d = true;
      this.c.e(localContext);
    }
    while (true)
    {
      this.b.a(paramView);
      locala.onAdLoaded();
      return;
      label53: this.c.d(localContext);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.banner.a
 * JD-Core Version:    0.6.2
 */