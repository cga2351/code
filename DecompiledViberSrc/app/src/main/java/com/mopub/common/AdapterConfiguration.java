package com.mopub.common;

import android.content.Context;
import java.util.Map;

public abstract interface AdapterConfiguration
{
  public abstract String getAdapterVersion();

  public abstract String getBiddingToken(Context paramContext);

  public abstract Map<String, String> getCachedInitializationParameters(Context paramContext);

  public abstract String getMoPubNetworkName();

  public abstract Map<String, String> getMoPubRequestOptions();

  public abstract String getNetworkSdkVersion();

  public abstract void initializeNetwork(Context paramContext, Map<String, String> paramMap, OnNetworkInitializationFinishedListener paramOnNetworkInitializationFinishedListener);

  public abstract void setCachedInitializationParameters(Context paramContext, Map<String, String> paramMap);

  public abstract void setMoPubRequestOptions(Map<String, String> paramMap);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.AdapterConfiguration
 * JD-Core Version:    0.6.2
 */