package com.viber.voip.ads.d;

import android.net.Uri;
import android.view.View;
import com.appnexus.opensdk.NativeAdResponse;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import java.util.concurrent.TimeUnit;

public class f
  implements n
{
  private final long a;
  private final View b;
  private NativeAd c;
  private NativeAdResponse d;
  private String e;
  private a f;
  private String g;
  private String h;

  public f(View paramView, String paramString)
  {
    this.b = paramView;
    this.a = (System.currentTimeMillis() + TimeUnit.HOURS.toMillis(6L));
    this.e = paramString;
    this.g = String.valueOf(hashCode());
  }

  public f(NativeAd paramNativeAd, NativeAdResponse paramNativeAdResponse, String paramString)
  {
    this.c = paramNativeAd;
    this.d = paramNativeAdResponse;
    this.a = (System.currentTimeMillis() + TimeUnit.HOURS.toMillis(6L));
    this.e = paramString;
    if (this.d != null)
      this.g = this.d.getCreativeId();
    for (this.h = "AppNexus"; ; this.h = "Google")
    {
      this.b = null;
      return;
    }
  }

  public f(NativeAppInstallAd paramNativeAppInstallAd, String paramString)
  {
    this(paramNativeAppInstallAd, null, paramString);
    this.g = paramNativeAppInstallAd.getHeadline().toString();
  }

  public f(NativeContentAd paramNativeContentAd, String paramString)
  {
    this(paramNativeContentAd, null, paramString);
    this.g = paramNativeContentAd.getHeadline().toString();
  }

  public boolean A()
  {
    return false;
  }

  public NativeAdResponse B()
  {
    return this.d;
  }

  public NativeAd C()
  {
    return this.c;
  }

  public String D()
  {
    return this.e;
  }

  public int E()
  {
    return 2;
  }

  public View F()
  {
    return this.b;
  }

  public a a()
  {
    return this.f;
  }

  public void a(int paramInt)
  {
  }

  public void a(a parama)
  {
    this.f = parama;
  }

  public String b()
  {
    return this.g;
  }

  public String c()
  {
    return "Story";
  }

  public String d()
  {
    return null;
  }

  public String e()
  {
    return null;
  }

  public Uri f()
  {
    return null;
  }

  public String g()
  {
    return null;
  }

  public String h()
  {
    return null;
  }

  public String i()
  {
    return "Sponsored";
  }

  public boolean j()
  {
    return true;
  }

  public String k()
  {
    return null;
  }

  public boolean l()
  {
    return false;
  }

  public String m()
  {
    return null;
  }

  public boolean n()
  {
    return true;
  }

  public boolean o()
  {
    return true;
  }

  public String[] p()
  {
    return new String[0];
  }

  public String[] q()
  {
    return new String[0];
  }

  public String[] r()
  {
    return new String[0];
  }

  public boolean s()
  {
    return System.currentTimeMillis() <= this.a;
  }

  public boolean t()
  {
    return false;
  }

  public String u()
  {
    return null;
  }

  public int v()
  {
    return 0;
  }

  public String w()
  {
    return this.h;
  }

  public String x()
  {
    return null;
  }

  public String y()
  {
    return null;
  }

  public boolean z()
  {
    return false;
  }

  public static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.d.f
 * JD-Core Version:    0.6.2
 */