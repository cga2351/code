package com.appnexus.opensdk;

public abstract interface NativeAdEventListener
{
  public abstract void onAdWasClicked();

  public abstract void onAdWasClicked(String paramString1, String paramString2);

  public abstract void onAdWillLeaveApplication();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.NativeAdEventListener
 * JD-Core Version:    0.6.2
 */