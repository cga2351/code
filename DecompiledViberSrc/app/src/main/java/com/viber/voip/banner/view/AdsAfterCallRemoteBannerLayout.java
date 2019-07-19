package com.viber.voip.banner.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.viber.voip.ads.d.j;
import com.viber.voip.banner.datatype.AdsAfterCallBanner;

public class AdsAfterCallRemoteBannerLayout extends f
{
  public AdsAfterCallRemoteBannerLayout(Context paramContext)
  {
    super(paramContext);
  }

  public AdsAfterCallRemoteBannerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public AdsAfterCallRemoteBannerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public AdsAfterCallRemoteBannerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }

  public j getAd()
  {
    return ((AdsAfterCallBanner)this.mBannerMeta).getAd();
  }

  protected ViewGroup.LayoutParams getBackgroundImageDefaultLayoutParams()
  {
    return new ViewGroup.LayoutParams(-1, -2);
  }

  protected ViewGroup.LayoutParams getItemsDefaultLayoutParams()
  {
    return new ViewGroup.LayoutParams(-1, -2);
  }

  public boolean hasAdsText()
  {
    return this.mItemsViewGroup.getChildCount() > 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.view.AdsAfterCallRemoteBannerLayout
 * JD-Core Version:    0.6.2
 */