package com.yandex.mobile.ads.mediation.interstitial;

import android.content.Context;
import com.yandex.mobile.ads.AdRequestError;
import java.util.Map;

abstract class MediatedInterstitialAdapter
{
  abstract boolean isLoaded();

  abstract void loadInterstitial(Context paramContext, MediatedInterstitialAdapterListener paramMediatedInterstitialAdapterListener, Map<String, Object> paramMap, Map<String, String> paramMap1);

  abstract void onInvalidate();

  abstract void showInterstitial();

  static abstract interface MediatedInterstitialAdapterListener
  {
    public abstract void onInterstitialClicked();

    public abstract void onInterstitialDismissed();

    public abstract void onInterstitialFailedToLoad(AdRequestError paramAdRequestError);

    public abstract void onInterstitialLeftApplication();

    public abstract void onInterstitialLoaded();

    public abstract void onInterstitialShown();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.interstitial.MediatedInterstitialAdapter
 * JD-Core Version:    0.6.2
 */