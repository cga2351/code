package com.appnexus.opensdk;

public abstract interface AdListener
{
  public abstract void onAdClicked(AdView paramAdView);

  public abstract void onAdClicked(AdView paramAdView, String paramString);

  public abstract void onAdCollapsed(AdView paramAdView);

  public abstract void onAdExpanded(AdView paramAdView);

  public abstract void onAdLoaded(AdView paramAdView);

  public abstract void onAdLoaded(NativeAdResponse paramNativeAdResponse);

  public abstract void onAdRequestFailed(AdView paramAdView, ResultCode paramResultCode);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.AdListener
 * JD-Core Version:    0.6.2
 */