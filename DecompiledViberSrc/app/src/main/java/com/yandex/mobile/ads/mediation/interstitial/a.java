package com.yandex.mobile.ads.mediation.interstitial;

import android.content.Context;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.impl.as;
import com.yandex.mobile.ads.impl.ft;
import java.lang.ref.WeakReference;

final class a
  implements MediatedInterstitialAdapter.MediatedInterstitialAdapterListener
{
  private final WeakReference<ft> a;
  private final as<MediatedInterstitialAdapter, MediatedInterstitialAdapter.MediatedInterstitialAdapterListener> b;

  a(ft paramft, as<MediatedInterstitialAdapter, MediatedInterstitialAdapter.MediatedInterstitialAdapterListener> paramas)
  {
    this.a = new WeakReference(paramft);
    this.b = paramas;
  }

  public final void onInterstitialClicked()
  {
    ft localft = (ft)this.a.get();
    if (localft != null)
    {
      Context localContext = localft.l();
      this.b.b(localContext);
    }
  }

  public final void onInterstitialDismissed()
  {
    ft localft = (ft)this.a.get();
    if (localft != null)
      localft.y();
  }

  public final void onInterstitialFailedToLoad(AdRequestError paramAdRequestError)
  {
    ft localft = (ft)this.a.get();
    if (localft != null)
    {
      Context localContext = localft.l();
      this.b.a(localContext, paramAdRequestError, this);
    }
  }

  public final void onInterstitialLeftApplication()
  {
    ft localft = (ft)this.a.get();
    if (localft != null)
      localft.onAdLeftApplication();
  }

  public final void onInterstitialLoaded()
  {
    ft localft = (ft)this.a.get();
    if (localft != null)
    {
      Context localContext = localft.l();
      this.b.e(localContext);
      localft.onAdLoaded();
    }
  }

  public final void onInterstitialShown()
  {
    ft localft = (ft)this.a.get();
    if (localft != null)
    {
      Context localContext = localft.l();
      this.b.c(localContext);
      localft.x();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.interstitial.a
 * JD-Core Version:    0.6.2
 */