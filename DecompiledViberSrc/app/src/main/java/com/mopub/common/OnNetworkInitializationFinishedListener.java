package com.mopub.common;

import com.mopub.mobileads.MoPubErrorCode;

public abstract interface OnNetworkInitializationFinishedListener
{
  public abstract void onNetworkInitializationFinished(Class<? extends AdapterConfiguration> paramClass, MoPubErrorCode paramMoPubErrorCode);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.OnNetworkInitializationFinishedListener
 * JD-Core Version:    0.6.2
 */