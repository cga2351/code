package com.appnexus.opensdk;

public abstract interface NativeAdRequestListener
{
  public abstract void onAdFailed(ResultCode paramResultCode);

  public abstract void onAdLoaded(NativeAdResponse paramNativeAdResponse);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.NativeAdRequestListener
 * JD-Core Version:    0.6.2
 */