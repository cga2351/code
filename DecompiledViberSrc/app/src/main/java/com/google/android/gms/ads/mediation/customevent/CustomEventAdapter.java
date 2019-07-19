package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbae;

@KeepForSdkWithMembers
@KeepName
public final class CustomEventAdapter
  implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter
{

  @VisibleForTesting
  private CustomEventBanner zzenv;

  @VisibleForTesting
  private CustomEventInterstitial zzenw;

  @VisibleForTesting
  private CustomEventNative zzenx;
  private View zzmx;

  private final void zza(View paramView)
  {
    this.zzmx = paramView;
  }

  private static <T> T zzaj(String paramString)
  {
    try
    {
      Object localObject = Class.forName(paramString).newInstance();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      String str = localThrowable.getMessage();
      zzbae.zzep(46 + String.valueOf(paramString).length() + String.valueOf(str).length() + "Could not instantiate custom event adapter: " + paramString + ". " + str);
    }
    return null;
  }

  public final View getBannerView()
  {
    return this.zzmx;
  }

  public final void onDestroy()
  {
    if (this.zzenv != null)
      this.zzenv.onDestroy();
    if (this.zzenw != null)
      this.zzenw.onDestroy();
    if (this.zzenx != null)
      this.zzenx.onDestroy();
  }

  public final void onPause()
  {
    if (this.zzenv != null)
      this.zzenv.onPause();
    if (this.zzenw != null)
      this.zzenw.onPause();
    if (this.zzenx != null)
      this.zzenx.onPause();
  }

  public final void onResume()
  {
    if (this.zzenv != null)
      this.zzenv.onResume();
    if (this.zzenw != null)
      this.zzenw.onResume();
    if (this.zzenx != null)
      this.zzenx.onResume();
  }

  public final void requestBannerAd(Context paramContext, MediationBannerListener paramMediationBannerListener, Bundle paramBundle1, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    this.zzenv = ((CustomEventBanner)zzaj(paramBundle1.getString("class_name")));
    if (this.zzenv == null)
    {
      paramMediationBannerListener.onAdFailedToLoad(this, 0);
      return;
    }
    if (paramBundle2 == null);
    for (Bundle localBundle = null; ; localBundle = paramBundle2.getBundle(paramBundle1.getString("class_name")))
    {
      this.zzenv.requestBannerAd(paramContext, new zza(this, paramMediationBannerListener), paramBundle1.getString("parameter"), paramAdSize, paramMediationAdRequest, localBundle);
      return;
    }
  }

  public final void requestInterstitialAd(Context paramContext, MediationInterstitialListener paramMediationInterstitialListener, Bundle paramBundle1, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    this.zzenw = ((CustomEventInterstitial)zzaj(paramBundle1.getString("class_name")));
    if (this.zzenw == null)
    {
      paramMediationInterstitialListener.onAdFailedToLoad(this, 0);
      return;
    }
    if (paramBundle2 == null);
    for (Bundle localBundle = null; ; localBundle = paramBundle2.getBundle(paramBundle1.getString("class_name")))
    {
      this.zzenw.requestInterstitialAd(paramContext, new zzb(this, paramMediationInterstitialListener), paramBundle1.getString("parameter"), paramMediationAdRequest, localBundle);
      return;
    }
  }

  public final void requestNativeAd(Context paramContext, MediationNativeListener paramMediationNativeListener, Bundle paramBundle1, NativeMediationAdRequest paramNativeMediationAdRequest, Bundle paramBundle2)
  {
    this.zzenx = ((CustomEventNative)zzaj(paramBundle1.getString("class_name")));
    if (this.zzenx == null)
    {
      paramMediationNativeListener.onAdFailedToLoad(this, 0);
      return;
    }
    if (paramBundle2 == null);
    for (Bundle localBundle = null; ; localBundle = paramBundle2.getBundle(paramBundle1.getString("class_name")))
    {
      this.zzenx.requestNativeAd(paramContext, new zzc(this, paramMediationNativeListener), paramBundle1.getString("parameter"), paramNativeMediationAdRequest, localBundle);
      return;
    }
  }

  public final void showInterstitial()
  {
    this.zzenw.showInterstitial();
  }

  @VisibleForTesting
  static final class zza
    implements CustomEventBannerListener
  {
    private final CustomEventAdapter zzeny;
    private final MediationBannerListener zzenz;

    public zza(CustomEventAdapter paramCustomEventAdapter, MediationBannerListener paramMediationBannerListener)
    {
      this.zzeny = paramCustomEventAdapter;
      this.zzenz = paramMediationBannerListener;
    }

    public final void onAdClicked()
    {
      zzbae.zzdp("Custom event adapter called onAdClicked.");
      this.zzenz.onAdClicked(this.zzeny);
    }

    public final void onAdClosed()
    {
      zzbae.zzdp("Custom event adapter called onAdClosed.");
      this.zzenz.onAdClosed(this.zzeny);
    }

    public final void onAdFailedToLoad(int paramInt)
    {
      zzbae.zzdp("Custom event adapter called onAdFailedToLoad.");
      this.zzenz.onAdFailedToLoad(this.zzeny, paramInt);
    }

    public final void onAdLeftApplication()
    {
      zzbae.zzdp("Custom event adapter called onAdLeftApplication.");
      this.zzenz.onAdLeftApplication(this.zzeny);
    }

    public final void onAdLoaded(View paramView)
    {
      zzbae.zzdp("Custom event adapter called onAdLoaded.");
      CustomEventAdapter.zza(this.zzeny, paramView);
      this.zzenz.onAdLoaded(this.zzeny);
    }

    public final void onAdOpened()
    {
      zzbae.zzdp("Custom event adapter called onAdOpened.");
      this.zzenz.onAdOpened(this.zzeny);
    }
  }

  @VisibleForTesting
  final class zzb
    implements CustomEventInterstitialListener
  {
    private final CustomEventAdapter zzeny;
    private final MediationInterstitialListener zzeoa;

    public zzb(CustomEventAdapter paramMediationInterstitialListener, MediationInterstitialListener arg3)
    {
      this.zzeny = paramMediationInterstitialListener;
      Object localObject;
      this.zzeoa = localObject;
    }

    public final void onAdClicked()
    {
      zzbae.zzdp("Custom event adapter called onAdClicked.");
      this.zzeoa.onAdClicked(this.zzeny);
    }

    public final void onAdClosed()
    {
      zzbae.zzdp("Custom event adapter called onAdClosed.");
      this.zzeoa.onAdClosed(this.zzeny);
    }

    public final void onAdFailedToLoad(int paramInt)
    {
      zzbae.zzdp("Custom event adapter called onFailedToReceiveAd.");
      this.zzeoa.onAdFailedToLoad(this.zzeny, paramInt);
    }

    public final void onAdLeftApplication()
    {
      zzbae.zzdp("Custom event adapter called onAdLeftApplication.");
      this.zzeoa.onAdLeftApplication(this.zzeny);
    }

    public final void onAdLoaded()
    {
      zzbae.zzdp("Custom event adapter called onReceivedAd.");
      this.zzeoa.onAdLoaded(CustomEventAdapter.this);
    }

    public final void onAdOpened()
    {
      zzbae.zzdp("Custom event adapter called onAdOpened.");
      this.zzeoa.onAdOpened(this.zzeny);
    }
  }

  @VisibleForTesting
  static final class zzc
    implements CustomEventNativeListener
  {
    private final CustomEventAdapter zzeny;
    private final MediationNativeListener zzeoc;

    public zzc(CustomEventAdapter paramCustomEventAdapter, MediationNativeListener paramMediationNativeListener)
    {
      this.zzeny = paramCustomEventAdapter;
      this.zzeoc = paramMediationNativeListener;
    }

    public final void onAdClicked()
    {
      zzbae.zzdp("Custom event adapter called onAdClicked.");
      this.zzeoc.onAdClicked(this.zzeny);
    }

    public final void onAdClosed()
    {
      zzbae.zzdp("Custom event adapter called onAdClosed.");
      this.zzeoc.onAdClosed(this.zzeny);
    }

    public final void onAdFailedToLoad(int paramInt)
    {
      zzbae.zzdp("Custom event adapter called onAdFailedToLoad.");
      this.zzeoc.onAdFailedToLoad(this.zzeny, paramInt);
    }

    public final void onAdImpression()
    {
      zzbae.zzdp("Custom event adapter called onAdImpression.");
      this.zzeoc.onAdImpression(this.zzeny);
    }

    public final void onAdLeftApplication()
    {
      zzbae.zzdp("Custom event adapter called onAdLeftApplication.");
      this.zzeoc.onAdLeftApplication(this.zzeny);
    }

    public final void onAdLoaded(NativeAdMapper paramNativeAdMapper)
    {
      zzbae.zzdp("Custom event adapter called onAdLoaded.");
      this.zzeoc.onAdLoaded(this.zzeny, paramNativeAdMapper);
    }

    public final void onAdLoaded(UnifiedNativeAdMapper paramUnifiedNativeAdMapper)
    {
      zzbae.zzdp("Custom event adapter called onAdLoaded.");
      this.zzeoc.onAdLoaded(this.zzeny, paramUnifiedNativeAdMapper);
    }

    public final void onAdOpened()
    {
      zzbae.zzdp("Custom event adapter called onAdOpened.");
      this.zzeoc.onAdOpened(this.zzeny);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.customevent.CustomEventAdapter
 * JD-Core Version:    0.6.2
 */