package com.viber.voip.banner.datatype;

import com.viber.voip.ads.d.j;

public class AdsAfterCallBanner extends Banner
{
  private j mAd;
  private int mAdCallProvider;
  private int mAdCallType;
  private int mAdsAfterCallLayoutItemsOrientation = 0;

  public j getAd()
  {
    return this.mAd;
  }

  public int getAdCallProvider()
  {
    return this.mAdCallProvider;
  }

  public int getAdCallType()
  {
    return this.mAdCallType;
  }

  public boolean hasActionSupport()
  {
    return false;
  }

  public boolean isOrientedVertically()
  {
    return 1 == this.mAdsAfterCallLayoutItemsOrientation;
  }

  public void orientVertically()
  {
    this.mAdsAfterCallLayoutItemsOrientation = 1;
  }

  public void setAd(j paramj)
  {
    this.mAd = paramj;
  }

  public void setAdCallProvider(int paramInt)
  {
    this.mAdCallProvider = paramInt;
  }

  public void setAdCallType(int paramInt)
  {
    this.mAdCallType = paramInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.datatype.AdsAfterCallBanner
 * JD-Core Version:    0.6.2
 */