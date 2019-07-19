package com.viber.voip.ads.d;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAdView;

public class e
  implements h
{
  private NativeContentAdView a;

  public e(NativeContentAdView paramNativeContentAdView)
  {
    this.a = paramNativeContentAdView;
  }

  public View a()
  {
    return this.a;
  }

  @Deprecated
  public void a(View paramView)
  {
    this.a.setImageView(paramView);
  }

  public void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.a.addView(paramView, paramLayoutParams);
  }

  public void a(MediaView paramMediaView)
  {
    this.a.setMediaView(paramMediaView);
  }

  public void a(NativeAd paramNativeAd)
  {
    this.a.setNativeAd(paramNativeAd);
  }

  public void b(View paramView)
  {
    this.a.setHeadlineView(paramView);
  }

  public void c(View paramView)
  {
    this.a.setBodyView(paramView);
  }

  public void d(View paramView)
  {
    this.a.setCallToActionView(paramView);
  }

  public void e(View paramView)
  {
    this.a.setLogoView(paramView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.d.e
 * JD-Core Version:    0.6.2
 */