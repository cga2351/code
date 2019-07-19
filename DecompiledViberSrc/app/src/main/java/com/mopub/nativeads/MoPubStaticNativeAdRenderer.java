package com.mopub.nativeads;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import java.util.WeakHashMap;

public class MoPubStaticNativeAdRenderer
  implements MoPubAdRenderer<StaticNativeAd>
{

  @VisibleForTesting
  final WeakHashMap<View, j> a;
  private final ViewBinder b;

  public MoPubStaticNativeAdRenderer(ViewBinder paramViewBinder)
  {
    this.b = paramViewBinder;
    this.a = new WeakHashMap();
  }

  private void a(j paramj, int paramInt)
  {
    if (paramj.a != null)
      paramj.a.setVisibility(paramInt);
  }

  private void a(j paramj, StaticNativeAd paramStaticNativeAd)
  {
    NativeRendererHelper.addTextView(paramj.b, paramStaticNativeAd.getTitle());
    NativeRendererHelper.addTextView(paramj.c, paramStaticNativeAd.getText());
    NativeRendererHelper.addTextView(paramj.d, paramStaticNativeAd.getCallToAction());
    NativeImageHelper.loadImageView(paramStaticNativeAd.getMainImageUrl(), paramj.e);
    NativeImageHelper.loadImageView(paramStaticNativeAd.getIconImageUrl(), paramj.f);
    NativeRendererHelper.addPrivacyInformationIcon(paramj.g, paramStaticNativeAd.getPrivacyInformationIconImageUrl(), paramStaticNativeAd.getPrivacyInformationIconClickThroughUrl());
  }

  public View createAdView(Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(this.b.a, paramViewGroup, false);
  }

  public void renderAdView(View paramView, StaticNativeAd paramStaticNativeAd)
  {
    j localj = (j)this.a.get(paramView);
    if (localj == null)
    {
      localj = j.a(paramView, this.b);
      this.a.put(paramView, localj);
    }
    a(localj, paramStaticNativeAd);
    NativeRendererHelper.updateExtras(localj.a, this.b.h, paramStaticNativeAd.getExtras());
    a(localj, 0);
  }

  public boolean supports(BaseNativeAd paramBaseNativeAd)
  {
    Preconditions.checkNotNull(paramBaseNativeAd);
    return paramBaseNativeAd instanceof StaticNativeAd;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.MoPubStaticNativeAdRenderer
 * JD-Core Version:    0.6.2
 */