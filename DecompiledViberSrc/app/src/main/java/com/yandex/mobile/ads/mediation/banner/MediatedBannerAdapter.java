package com.yandex.mobile.ads.mediation.banner;

import android.content.Context;
import android.view.View;
import com.yandex.mobile.ads.AdRequestError;
import java.util.Map;

abstract class MediatedBannerAdapter
{
  abstract void loadBanner(Context paramContext, MediatedBannerAdapterListener paramMediatedBannerAdapterListener, Map<String, Object> paramMap, Map<String, String> paramMap1);

  abstract void onInvalidate();

  static abstract interface MediatedBannerAdapterListener
  {
    public abstract void onAdClicked();

    public abstract void onAdFailedToLoad(AdRequestError paramAdRequestError);

    public abstract void onAdLeftApplication();

    public abstract void onAdLoaded(View paramView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.banner.MediatedBannerAdapter
 * JD-Core Version:    0.6.2
 */