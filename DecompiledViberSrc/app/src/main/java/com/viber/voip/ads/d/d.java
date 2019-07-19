package com.viber.voip.ads.d;

import android.net.Uri;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.viber.voip.ads.e;
import com.viber.voip.util.ca;
import com.viber.voip.util.da;
import java.util.List;

public class d
  implements a
{
  protected boolean a;
  private NativeContentAd b;
  private long c;
  private String d;
  private final String e;
  private boolean f = true;

  public d(NativeContentAd paramNativeContentAd, Long paramLong, String paramString1, String paramString2)
  {
    this.b = paramNativeContentAd;
    this.c = ((Long)ca.a(paramLong, Long.valueOf(e.a))).longValue();
    this.d = paramString1;
    this.e = paramString2;
  }

  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public void b()
  {
    this.b.destroy();
    this.c = 0L;
    this.d = null;
  }

  public void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }

  public NativeContentAd c()
  {
    return this.b;
  }

  public String d()
  {
    return this.e;
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
    return ((NativeAd.Image)this.b.getImages().get(0)).getUri().toString();
  }

  public String o()
  {
    return da.a(this.b.getHeadline());
  }

  public String p()
  {
    return da.a(this.b.getBody());
  }

  public String q()
  {
    return da.a(this.b.getCallToAction());
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
    return "AdmobAfterCallAd{mAd=" + this.b + ", mTimer=" + this.c + ", mPromotedByTag='" + this.d + '\'' + '}';
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
    return this.f;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.d.d
 * JD-Core Version:    0.6.2
 */