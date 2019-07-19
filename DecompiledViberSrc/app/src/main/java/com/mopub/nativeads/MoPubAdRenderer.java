package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public abstract interface MoPubAdRenderer<T extends BaseNativeAd>
{
  public abstract View createAdView(Context paramContext, ViewGroup paramViewGroup);

  public abstract void renderAdView(View paramView, T paramT);

  public abstract boolean supports(BaseNativeAd paramBaseNativeAd);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.MoPubAdRenderer
 * JD-Core Version:    0.6.2
 */