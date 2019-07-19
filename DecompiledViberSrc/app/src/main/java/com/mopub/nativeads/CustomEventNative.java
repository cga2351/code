package com.mopub.nativeads;

import android.content.Context;
import java.util.Map;

public abstract class CustomEventNative
{
  protected void a()
  {
  }

  protected abstract void a(Context paramContext, CustomEventNativeListener paramCustomEventNativeListener, Map<String, Object> paramMap, Map<String, String> paramMap1);

  public static abstract interface CustomEventNativeListener
  {
    public abstract void onNativeAdFailed(NativeErrorCode paramNativeErrorCode);

    public abstract void onNativeAdLoaded(BaseNativeAd paramBaseNativeAd);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.CustomEventNative
 * JD-Core Version:    0.6.2
 */