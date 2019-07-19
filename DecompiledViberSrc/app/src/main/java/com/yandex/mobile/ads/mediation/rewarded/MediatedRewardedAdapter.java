package com.yandex.mobile.ads.mediation.rewarded;

import android.content.Context;
import java.util.Map;

abstract class MediatedRewardedAdapter
{
  abstract boolean isLoaded();

  abstract void loadRewardedAd(Context paramContext, MediatedRewardedAdapterListener paramMediatedRewardedAdapterListener, Map<String, Object> paramMap, Map<String, String> paramMap1);

  abstract void onInvalidate();

  abstract void showRewardedAd();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.rewarded.MediatedRewardedAdapter
 * JD-Core Version:    0.6.2
 */