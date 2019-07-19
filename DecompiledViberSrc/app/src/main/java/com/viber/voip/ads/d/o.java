package com.viber.voip.ads.d;

import android.net.Uri;
import com.appnexus.opensdk.NativeAdResponse;
import com.viber.voip.banner.datatype.PublicAccountsAdsMetaInfo.Item;
import com.viber.voip.util.da;
import java.util.Arrays;

public class o
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

  public o(Uri paramUri, PublicAccountsAdsMetaInfo.Item paramItem)
  {
    this.a = paramItem.id;
    this.b = paramItem.adType;
    this.c = paramItem.sessionId;
    this.d = paramItem.landingUrl;
    this.e = paramUri;
    this.f = paramItem.title;
    this.g = paramItem.text;
    this.h = paramItem.promotedByTag;
    boolean bool2;
    label111: String str1;
    label140: String[] arrayOfString1;
    label186: String[] arrayOfString2;
    label216: String[] arrayOfString3;
    if ((!da.a(this.h)) && (paramItem.sponsoredOption))
    {
      bool2 = bool1;
      this.l = bool2;
      this.m = paramItem.ctaTitle;
      if (da.a(this.m))
        break label313;
      this.n = bool1;
      this.v = paramItem.paURI;
      if (da.a(paramItem.ctaUrl))
        break label318;
      str1 = paramItem.ctaUrl;
      this.o = str1;
      this.p = paramItem.reportOption;
      this.q = paramItem.hideOption;
      if (paramItem.impressionUrls == null)
        break label327;
      arrayOfString1 = (String[])Arrays.copyOf(paramItem.impressionUrls, paramItem.impressionUrls.length);
      this.r = arrayOfString1;
      if (paramItem.viewUrls == null)
        break label336;
      arrayOfString2 = (String[])Arrays.copyOf(paramItem.viewUrls, paramItem.viewUrls.length);
      this.s = arrayOfString2;
      if (paramItem.reportClickUrls == null)
        break label345;
      arrayOfString3 = (String[])Arrays.copyOf(paramItem.reportClickUrls, paramItem.reportClickUrls.length);
      label246: this.t = arrayOfString3;
      if (da.a(paramItem.adProvider))
        break label354;
    }
    label313: label318: label327: label336: label345: label354: for (String str2 = paramItem.adProvider; ; str2 = "")
    {
      this.k = str2;
      this.i = paramItem.providerIconUrl;
      this.j = paramItem.providerTargetUrl;
      this.u = (System.currentTimeMillis() + 1000L * paramItem.ttl);
      return;
      bool2 = false;
      break;
      bool1 = false;
      break label111;
      str1 = this.d;
      break label140;
      arrayOfString1 = new String[0];
      break label186;
      arrayOfString2 = new String[0];
      break label216;
      arrayOfString3 = new String[0];
      break label246;
    }
  }

  public boolean A()
  {
    return !da.a(this.j);
  }

  public NativeAdResponse B()
  {
    return null;
  }

  public String D()
  {
    return "";
  }

  public int E()
  {
    return 1;
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
 * Qualified Name:     com.viber.voip.ads.d.o
 * JD-Core Version:    0.6.2
 */