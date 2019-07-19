package com.viber.voip.ads.d;

import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.NativeAd;
import com.viber.voip.ads.e;
import com.viber.voip.banner.datatype.AdsCallMetaInfo.AltAdsConfig;
import com.viber.voip.util.ca;

public class g
  implements a
{
  protected boolean a;
  private PublisherAdView b;
  private long c;
  private String d;

  public g(PublisherAdView paramPublisherAdView, AdsCallMetaInfo.AltAdsConfig paramAltAdsConfig)
  {
    this.b = paramPublisherAdView;
    this.c = ((Long)ca.a(paramAltAdsConfig.getTimer(), Long.valueOf(e.a))).longValue();
    this.d = paramAltAdsConfig.getPromotedByTag();
  }

  public NativeAd a()
  {
    return null;
  }

  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public void b()
  {
    this.b.destroy();
    this.b = null;
    this.c = 0L;
    this.d = null;
  }

  public PublisherAdView c()
  {
    this.b.getAdSize();
    return this.b;
  }

  public String d()
  {
    return "";
  }

  public String e()
  {
    return "";
  }

  public String f()
  {
    return "google admob sdk";
  }

  public long g()
  {
    return this.c;
  }

  public String h()
  {
    return this.d;
  }

  public boolean i()
  {
    return false;
  }

  public String[] j()
  {
    return null;
  }

  public String[] k()
  {
    return null;
  }

  public String[] l()
  {
    return null;
  }

  public String m()
  {
    return null;
  }

  public String n()
  {
    return null;
  }

  public String o()
  {
    return null;
  }

  public String p()
  {
    return null;
  }

  public String q()
  {
    return null;
  }

  public String r()
  {
    return null;
  }

  public String s()
  {
    return "google admob sdk";
  }

  public String t()
  {
    return null;
  }

  public String toString()
  {
    return "AdmobExpressAfterCallAd{mAdView=" + this.b + ", mTimer=" + this.c + ", mPromotedByTag='" + this.d + '\'' + '}';
  }

  public String u()
  {
    return null;
  }

  public int v()
  {
    return 2;
  }

  public boolean w()
  {
    return this.a;
  }

  public int x()
  {
    return 2;
  }

  public boolean y()
  {
    return true;
  }

  public boolean z()
  {
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.d.g
 * JD-Core Version:    0.6.2
 */