package com.viber.voip.ads.d;

import android.graphics.Bitmap;
import com.appnexus.opensdk.NativeAdResponse;
import com.appnexus.opensdk.utils.Settings;
import com.viber.voip.banner.datatype.AdsCallMetaInfo.AltAdsConfig;
import java.util.List;

public class m extends p
{
  private NativeAdResponse c;

  public m(NativeAdResponse paramNativeAdResponse, AdsCallMetaInfo.AltAdsConfig paramAltAdsConfig)
  {
    super(paramAltAdsConfig);
    this.c = paramNativeAdResponse;
  }

  public String a()
  {
    Settings.getSettings().getClass();
    return "4.11.2";
  }

  public Bitmap b()
  {
    return this.c.getImage();
  }

  public String d()
  {
    return String.valueOf(this.c.getCreativeId());
  }

  public String[] k()
  {
    if (this.c.getImpressionTrackers() != null)
      return (String[])this.c.getImpressionTrackers().toArray(new String[this.c.getImpressionTrackers().size()]);
    return new String[0];
  }

  public String n()
  {
    return this.c.getImageUrl();
  }

  public String o()
  {
    return this.c.getTitle();
  }

  public String p()
  {
    return this.c.getDescription();
  }

  public String q()
  {
    return this.c.getCallToAction();
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
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.d.m
 * JD-Core Version:    0.6.2
 */