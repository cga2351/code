package com.mopub.mobileads;

 enum r
{
  private final String a;

  static
  {
    FIRST_QUARTILE = new r("FIRST_QUARTILE", 1, "firstQuartile");
    MIDPOINT = new r("MIDPOINT", 2, "midpoint");
    THIRD_QUARTILE = new r("THIRD_QUARTILE", 3, "thirdQuartile");
    COMPLETE = new r("COMPLETE", 4, "complete");
    COMPANION_AD_VIEW = new r("COMPANION_AD_VIEW", 5, "companionAdView");
    COMPANION_AD_CLICK = new r("COMPANION_AD_CLICK", 6, "companionAdClick");
    UNKNOWN = new r("UNKNOWN", 7, "");
    r[] arrayOfr = new r[8];
    arrayOfr[0] = START;
    arrayOfr[1] = FIRST_QUARTILE;
    arrayOfr[2] = MIDPOINT;
    arrayOfr[3] = THIRD_QUARTILE;
    arrayOfr[4] = COMPLETE;
    arrayOfr[5] = COMPANION_AD_VIEW;
    arrayOfr[6] = COMPANION_AD_CLICK;
    arrayOfr[7] = UNKNOWN;
  }

  private r(String paramString)
  {
    this.a = paramString;
  }

  public static r fromString(String paramString)
  {
    r localr;
    if (paramString == null)
    {
      localr = UNKNOWN;
      return localr;
    }
    r[] arrayOfr = values();
    int i = arrayOfr.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label49;
      localr = arrayOfr[j];
      if (paramString.equals(localr.getName()))
        break;
    }
    label49: return UNKNOWN;
  }

  public String getName()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.r
 * JD-Core Version:    0.6.2
 */