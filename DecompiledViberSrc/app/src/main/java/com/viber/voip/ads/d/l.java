package com.viber.voip.ads.d;

import android.net.Uri;
import com.appnexus.opensdk.NativeAdResponse;
import com.viber.voip.util.da;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class l
  implements n
{
  private final String a;
  private final String b;
  private final String c;
  private final String d;
  private final Uri e;
  private final String f;
  private final String g;
  private final String h;
  private final String i;
  private final String j;
  private final String k;
  private final boolean l;
  private final String m;
  private final boolean n;
  private final String o;
  private final boolean p;
  private final boolean q;
  private final String[] r;
  private final String[] s;
  private final String[] t;
  private final long u;
  private final String v;
  private int w;
  private NativeAdResponse x;
  private String y;

  public l(NativeAdResponse paramNativeAdResponse, String paramString)
  {
    this.a = String.valueOf(paramNativeAdResponse.getCreativeId());
    this.x = paramNativeAdResponse;
    this.b = "Story";
    this.c = "";
    this.d = "";
    Uri localUri;
    boolean bool;
    if (da.a(paramNativeAdResponse.getImageUrl()))
    {
      localUri = null;
      this.e = localUri;
      this.f = paramNativeAdResponse.getTitle();
      this.g = paramNativeAdResponse.getDescription();
      this.h = "Sponsored";
      this.l = true;
      this.m = paramNativeAdResponse.getCallToAction();
      if (da.a(this.m))
        break label258;
      bool = true;
      label113: this.n = bool;
      this.v = "";
      this.o = this.d;
      this.p = true;
      this.q = true;
      if (paramNativeAdResponse.getImpressionTrackers() == null)
        break label264;
    }
    label258: label264: for (String[] arrayOfString = (String[])paramNativeAdResponse.getImpressionTrackers().toArray(new String[paramNativeAdResponse.getImpressionTrackers().size()]); ; arrayOfString = new String[0])
    {
      this.r = arrayOfString;
      this.s = new String[0];
      this.t = new String[0];
      this.k = "AppNexus";
      this.i = "";
      this.j = "";
      this.u = (System.currentTimeMillis() + TimeUnit.HOURS.toMillis(6L));
      this.y = paramString;
      return;
      localUri = Uri.parse(paramNativeAdResponse.getImageUrl());
      break;
      bool = false;
      break label113;
    }
  }

  public boolean A()
  {
    return !da.a(this.j);
  }

  public NativeAdResponse B()
  {
    return this.x;
  }

  public String D()
  {
    return this.y;
  }

  public int E()
  {
    return 3;
  }

  public void a(int paramInt)
  {
    this.w = paramInt;
  }

  public String b()
  {
    return this.a;
  }

  public String c()
  {
    return this.b;
  }

  public String d()
  {
    return this.c;
  }

  public String e()
  {
    return this.d;
  }

  public Uri f()
  {
    return this.e;
  }

  public String g()
  {
    return this.f;
  }

  public String h()
  {
    return this.g;
  }

  public String i()
  {
    return this.h;
  }

  public boolean j()
  {
    return this.l;
  }

  public String k()
  {
    return this.m;
  }

  public boolean l()
  {
    return this.n;
  }

  public String m()
  {
    return this.o;
  }

  public boolean n()
  {
    return this.p;
  }

  public boolean o()
  {
    return this.q;
  }

  public String[] p()
  {
    return this.r;
  }

  public String[] q()
  {
    return this.s;
  }

  public String[] r()
  {
    return this.t;
  }

  public boolean s()
  {
    return System.currentTimeMillis() <= this.u;
  }

  public boolean t()
  {
    return !da.a(this.v);
  }

  public String toString()
  {
    return "AppNexusConversationItemAdImpl{mId='" + this.a + '\'' + ", mAdType='" + this.b + '\'' + ", mSessionId='" + this.c + '\'' + ", mAdClickUrl='" + this.d + '\'' + ", mImage=" + this.e + ", mTitle='" + this.f + '\'' + ", mText='" + this.g + '\'' + ", mSponsoredText='" + this.h + '\'' + ", mProviderIconUrl='" + this.i + '\'' + ", mProviderTargetUrl='" + this.j + '\'' + ", mAdProvider='" + this.k + '\'' + ", mShowSponsored=" + this.l + ", mButtonText='" + this.m + '\'' + ", mShowButton=" + this.n + ", mButtonClickUrl='" + this.o + '\'' + ", mShowReportMenuItem=" + this.p + ", mShowHideMenuItem=" + this.q + ", mOnLoadUrls=" + Arrays.toString(this.r) + ", mOnViewUrls=" + Arrays.toString(this.s) + ", mOnClickUrls=" + Arrays.toString(this.t) + ", mTimeOfDeathInMilliseconds=" + this.u + ", mPaUri='" + this.v + '\'' + ", mPosition=" + this.w + '}';
  }

  public String u()
  {
    return this.v;
  }

  public int v()
  {
    return this.w;
  }

  public String w()
  {
    return this.k;
  }

  public String x()
  {
    return this.i;
  }

  public String y()
  {
    return this.j;
  }

  public boolean z()
  {
    return !da.a(this.i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.d.l
 * JD-Core Version:    0.6.2
 */