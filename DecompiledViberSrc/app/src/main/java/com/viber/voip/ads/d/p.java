package com.viber.voip.ads.d;

import android.graphics.Bitmap;
import com.viber.voip.banner.datatype.AdsCallMetaInfo.AltAdsConfig;
import com.viber.voip.util.ca;
import java.util.concurrent.TimeUnit;

public abstract class p
  implements j
{
  public static final long a = TimeUnit.MINUTES.toSeconds(2L);
  protected boolean b;
  private long c;
  private String d;

  p(AdsCallMetaInfo.AltAdsConfig paramAltAdsConfig)
  {
    this.c = ((Long)ca.a(paramAltAdsConfig.getTimer(), Long.valueOf(a))).longValue();
    this.d = paramAltAdsConfig.getPromotedByTag();
  }

  public abstract String a();

  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public Bitmap b()
  {
    return null;
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
    return "";
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

  public String t()
  {
    return null;
  }

  public String toString()
  {
    return "GenericAfterCallAd{mTimer=" + this.c + ", mPromotedByTag='" + this.d + '\'' + ", mAdPrepared=" + this.b + '}';
  }

  public String u()
  {
    return null;
  }

  public boolean w()
  {
    return this.b;
  }

  public boolean z()
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.d.p
 * JD-Core Version:    0.6.2
 */