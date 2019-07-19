package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import com.yandex.mobile.ads.AdRequest;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.impl.ac;
import com.yandex.mobile.ads.impl.ad;
import com.yandex.mobile.ads.impl.nq;

public class NativeAdLoader
{
  private final t a = new t(paramContext.getApplicationContext(), paramNativeAdLoaderConfiguration, this.b);
  private final v b = new v();

  public NativeAdLoader(Context paramContext, NativeAdLoaderConfiguration paramNativeAdLoaderConfiguration)
  {
  }

  public NativeAdLoader(Context paramContext, String paramString)
  {
    this(paramContext, new NativeAdLoaderConfiguration.Builder(paramString, true).setImageSizes(new String[] { "small" }).build());
  }

  public void cancelLoading()
  {
    this.a.a();
    this.b.a();
  }

  public void loadAd(AdRequest paramAdRequest)
  {
    nq localnq = new nq();
    ac localac = ac.a;
    ad localad = ad.a;
    this.a.a(paramAdRequest, localnq, localac, localad);
  }

  public void setOnLoadListener(OnLoadListener paramOnLoadListener)
  {
    this.b.a(paramOnLoadListener);
  }

  public static abstract interface OnImageAdLoadListener extends NativeAdLoader.OnLoadListener
  {
    public abstract void onImageAdLoaded(NativeImageAd paramNativeImageAd);
  }

  public static abstract interface OnLoadListener
  {
    public abstract void onAdFailedToLoad(AdRequestError paramAdRequestError);

    public abstract void onAppInstallAdLoaded(NativeAppInstallAd paramNativeAppInstallAd);

    public abstract void onContentAdLoaded(NativeContentAd paramNativeContentAd);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.NativeAdLoader
 * JD-Core Version:    0.6.2
 */