package com.viber.voip.ads.d;

import com.appnexus.opensdk.AdView;
import com.appnexus.opensdk.utils.Settings;
import com.viber.voip.banner.datatype.AdsCallMetaInfo.AltAdsConfig;
import java.util.List;

public class k extends p
{
  private AdView c;

  public k(AdView paramAdView, AdsCallMetaInfo.AltAdsConfig paramAltAdsConfig)
  {
    super(paramAltAdsConfig);
    this.c = paramAdView;
  }

  public String a()
  {
    Settings.getSettings().getClass();
    return "4.11.2";
  }

  public String d()
  {
    return String.valueOf(this.c.getCreativeId());
  }

  public String f()
  {
    return "Banner";
  }

  public String[] k()
  {
    return (String[])this.c.getImpressionUrls().toArray(new String[this.c.getImpressionUrls().size()]);
  }

  public String s()
  {
    return "";
  }

  public int v()
  {
    return 3;
  }

  public int x()
  {
    return 3;
  }

  public boolean y()
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.d.k
 * JD-Core Version:    0.6.2
 */