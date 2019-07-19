package com.mopub.mobileads.factories;

import com.mopub.common.AdReport;
import com.mopub.mobileads.CustomEventBannerAdapter;
import com.mopub.mobileads.MoPubView;
import java.util.Map;

public class CustomEventBannerAdapterFactory
{
  protected static CustomEventBannerAdapterFactory a = new CustomEventBannerAdapterFactory();

  public static CustomEventBannerAdapter create(MoPubView paramMoPubView, String paramString, Map<String, String> paramMap, long paramLong, AdReport paramAdReport)
  {
    return a.a(paramMoPubView, paramString, paramMap, paramLong, paramAdReport);
  }

  @Deprecated
  public static void setInstance(CustomEventBannerAdapterFactory paramCustomEventBannerAdapterFactory)
  {
    a = paramCustomEventBannerAdapterFactory;
  }

  protected CustomEventBannerAdapter a(MoPubView paramMoPubView, String paramString, Map<String, String> paramMap, long paramLong, AdReport paramAdReport)
  {
    return new CustomEventBannerAdapter(paramMoPubView, paramString, paramMap, paramLong, paramAdReport);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.factories.CustomEventBannerAdapterFactory
 * JD-Core Version:    0.6.2
 */