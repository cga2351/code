package com.mopub.common;

import java.util.HashSet;
import java.util.Set;

public enum DefaultAdapterClasses
{
  private final String a;

  static
  {
    GOOGLE_PLAY_SERVICES_ADAPTER_CONFIGURATION = new DefaultAdapterClasses("GOOGLE_PLAY_SERVICES_ADAPTER_CONFIGURATION", 6, "com.mopub.mobileads.GooglePlayServicesAdapterConfiguration");
    TAPJOY_ADAPTER_CONFIGURATION = new DefaultAdapterClasses("TAPJOY_ADAPTER_CONFIGURATION", 7, "com.mopub.mobileads.TapjoyAdapterConfiguration");
    UNITY_ADS_ADAPTER_CONFIGURATION = new DefaultAdapterClasses("UNITY_ADS_ADAPTER_CONFIGURATION", 8, "com.mopub.mobileads.UnityAdsAdapterConfiguration");
    VERIZON_ADAPTER_CONFIGURATION = new DefaultAdapterClasses("VERIZON_ADAPTER_CONFIGURATION", 9, "com.mopub.mobileads.VerizonAdapterConfiguration");
    VUNGLE_ADAPTER_CONFIGURATION = new DefaultAdapterClasses("VUNGLE_ADAPTER_CONFIGURATION", 10, "com.mopub.mobileads.VungleAdapterConfiguration");
    DefaultAdapterClasses[] arrayOfDefaultAdapterClasses = new DefaultAdapterClasses[11];
    arrayOfDefaultAdapterClasses[0] = AD_COLONY_ADAPTER_CONFIGURATION;
    arrayOfDefaultAdapterClasses[1] = APPLOVIN_ADAPTER_CONFIGURATION;
    arrayOfDefaultAdapterClasses[2] = CHARTBOOST_ADAPTER_CONFIGURATION;
    arrayOfDefaultAdapterClasses[3] = FACEBOOK_ADAPTER_CONFIGURATION;
    arrayOfDefaultAdapterClasses[4] = FLURRY_ADAPTER_CONFIGURATION;
    arrayOfDefaultAdapterClasses[5] = IRON_SOURCE_ADAPTER_CONFIGURATION;
    arrayOfDefaultAdapterClasses[6] = GOOGLE_PLAY_SERVICES_ADAPTER_CONFIGURATION;
    arrayOfDefaultAdapterClasses[7] = TAPJOY_ADAPTER_CONFIGURATION;
    arrayOfDefaultAdapterClasses[8] = UNITY_ADS_ADAPTER_CONFIGURATION;
    arrayOfDefaultAdapterClasses[9] = VERIZON_ADAPTER_CONFIGURATION;
    arrayOfDefaultAdapterClasses[10] = VUNGLE_ADAPTER_CONFIGURATION;
  }

  private DefaultAdapterClasses(String paramString)
  {
    this.a = paramString;
  }

  public static Set<String> getClassNamesSet()
  {
    HashSet localHashSet = new HashSet();
    DefaultAdapterClasses[] arrayOfDefaultAdapterClasses = values();
    int i = arrayOfDefaultAdapterClasses.length;
    for (int j = 0; j < i; j++)
      localHashSet.add(arrayOfDefaultAdapterClasses[j].a);
    return localHashSet;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.DefaultAdapterClasses
 * JD-Core Version:    0.6.2
 */