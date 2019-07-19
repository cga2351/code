package com.appnexus.opensdk;

public enum AdType
{
  static
  {
    BANNER = new AdType("BANNER", 1);
    VIDEO = new AdType("VIDEO", 2);
    NATIVE = new AdType("NATIVE", 3);
    AdType[] arrayOfAdType = new AdType[4];
    arrayOfAdType[0] = UNKNOWN;
    arrayOfAdType[1] = BANNER;
    arrayOfAdType[2] = VIDEO;
    arrayOfAdType[3] = NATIVE;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.AdType
 * JD-Core Version:    0.6.2
 */