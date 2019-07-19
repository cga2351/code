package com.appnexus.opensdk;

import android.content.Context;
import android.util.AttributeSet;

public class ViberBannerAdView extends BannerAdView
{
  public static final String ADS_NATIVE = "AdsNative";
  public static final String ADS_NATIVE_VIEW_CLASS = "AdsAfterCall";
  public static final String GOOGLE = "Google";
  private boolean v;
  private String w;

  public ViberBannerAdView(Context paramContext)
  {
    super(paramContext);
  }

  public ViberBannerAdView(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }

  public ViberBannerAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ViberBannerAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void a(q paramq)
  {
    super.a(paramq);
    this.v = true;
    if (paramq.i().getClass().getName().contains("AdsAfterCall"));
    for (String str = "AdsNative"; ; str = "Google")
    {
      this.w = str;
      return;
    }
  }

  public String getAdNetworkName()
  {
    return this.w;
  }

  public boolean isMediated()
  {
    return this.v;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.ViberBannerAdView
 * JD-Core Version:    0.6.2
 */