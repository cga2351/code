package com.viber.voip.ads.d;

import com.viber.voip.banner.datatype.AdsCallMetaInfo.AdsAfterCallMetaInfoItem;
import java.util.concurrent.TimeUnit;

public class q
  implements j
{
  private static final long a = TimeUnit.MINUTES.toSeconds(2L);
  private AdsCallMetaInfo.AdsAfterCallMetaInfoItem b;
  private boolean c;

  public q(AdsCallMetaInfo.AdsAfterCallMetaInfoItem paramAdsAfterCallMetaInfoItem)
  {
    this.b = paramAdsAfterCallMetaInfoItem;
  }

  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public String d()
  {
    return this.b.getId();
  }

  public String e()
  {
    return this.b.getSessionId();
  }

  public String f()
  {
    return this.b.getAdType();
  }

  public long g()
  {
    return a;
  }

  public String h()
  {
    return this.b.getPromotedByTag();
  }

  public boolean i()
  {
    return this.b.shouldShowProviderIcon();
  }

  public String[] j()
  {
    return this.b.getViewUrls();
  }

  public String[] k()
  {
    return this.b.getImpressionUrls();
  }

  public String[] l()
  {
    return this.b.getClickUrls();
  }

  public String m()
  {
    return this.b.getLandingUrl();
  }

  public String n()
  {
    return this.b.getImageUrl();
  }

  public String o()
  {
    return this.b.getTitle();
  }

  public String p()
  {
    return this.b.getText();
  }

  public String q()
  {
    return this.b.getCtaText();
  }

  public String r()
  {
    return null;
  }

  public String s()
  {
    return this.b.getProviderName();
  }

  public String t()
  {
    return this.b.getProviderIconUrl();
  }

  public String toString()
  {
    return "NativeAdsAfterCallAd{mItem=" + this.b + '}';
  }

  public String u()
  {
    return this.b.getProviderTargetUrl();
  }

  public int v()
  {
    return 1;
  }

  public boolean w()
  {
    return this.c;
  }

  public int x()
  {
    return 1;
  }

  public boolean y()
  {
    return true;
  }

  public boolean z()
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.d.q
 * JD-Core Version:    0.6.2
 */