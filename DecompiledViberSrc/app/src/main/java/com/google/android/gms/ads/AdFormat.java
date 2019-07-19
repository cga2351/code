package com.google.android.gms.ads;

public enum AdFormat
{
  static
  {
    NATIVE = new AdFormat("NATIVE", 3);
    AdFormat[] arrayOfAdFormat = new AdFormat[4];
    arrayOfAdFormat[0] = BANNER;
    arrayOfAdFormat[1] = INTERSTITIAL;
    arrayOfAdFormat[2] = REWARDED;
    arrayOfAdFormat[3] = NATIVE;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.AdFormat
 * JD-Core Version:    0.6.2
 */