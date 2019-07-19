package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdLoader.Builder;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAdViewHolder;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter.zza;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzaap;
import com.google.android.gms.internal.ads.zzare;
import com.google.android.gms.internal.ads.zzazu;
import com.google.android.gms.internal.ads.zzbae;
import com.google.android.gms.internal.ads.zzbjm;
import com.google.android.gms.internal.ads.zzxp;
import com.google.android.gms.internal.ads.zzyr;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

@zzare
public abstract class AbstractAdViewAdapter
  implements MediationBannerAdapter, MediationNativeAdapter, OnImmersiveModeUpdatedListener, zza, MediationRewardedVideoAdAdapter, zzbjm
{
  public static final String AD_UNIT_ID_PARAMETER = "pubid";
  private AdView zzmd;
  private InterstitialAd zzme;
  private AdLoader zzmf;
  private Context zzmg;
  private InterstitialAd zzmh;
  private MediationRewardedVideoAdListener zzmi;

  @VisibleForTesting
  private final RewardedVideoAdListener zzmj = new g(this);

  private final AdRequest zza(Context paramContext, MediationAdRequest paramMediationAdRequest, Bundle paramBundle1, Bundle paramBundle2)
  {
    AdRequest.Builder localBuilder = new AdRequest.Builder();
    Date localDate = paramMediationAdRequest.getBirthday();
    if (localDate != null)
      localBuilder.setBirthday(localDate);
    int i = paramMediationAdRequest.getGender();
    if (i != 0)
      localBuilder.setGender(i);
    Set localSet = paramMediationAdRequest.getKeywords();
    if (localSet != null)
    {
      Iterator localIterator = localSet.iterator();
      while (localIterator.hasNext())
        localBuilder.addKeyword((String)localIterator.next());
    }
    Location localLocation = paramMediationAdRequest.getLocation();
    if (localLocation != null)
      localBuilder.setLocation(localLocation);
    if (paramMediationAdRequest.isTesting())
    {
      zzyr.zzpa();
      localBuilder.addTestDevice(zzazu.zzbe(paramContext));
    }
    if (paramMediationAdRequest.taggedForChildDirectedTreatment() != -1)
      if (paramMediationAdRequest.taggedForChildDirectedTreatment() != 1)
        break label210;
    label210: for (boolean bool = true; ; bool = false)
    {
      localBuilder.tagForChildDirectedTreatment(bool);
      localBuilder.setIsDesignedForFamilies(paramMediationAdRequest.isDesignedForFamilies());
      localBuilder.addNetworkExtrasBundle(AdMobAdapter.class, zza(paramBundle1, paramBundle2));
      return localBuilder.build();
    }
  }

  public String getAdUnitId(Bundle paramBundle)
  {
    return paramBundle.getString("pubid");
  }

  public View getBannerView()
  {
    return this.zzmd;
  }

  public Bundle getInterstitialAdapterInfo()
  {
    return new MediationAdapter.zza().zzdj(1).zzacc();
  }

  public zzaap getVideoController()
  {
    if (this.zzmd != null)
    {
      VideoController localVideoController = this.zzmd.getVideoController();
      if (localVideoController != null)
        return localVideoController.zzdh();
    }
    return null;
  }

  public void initialize(Context paramContext, MediationAdRequest paramMediationAdRequest, String paramString, MediationRewardedVideoAdListener paramMediationRewardedVideoAdListener, Bundle paramBundle1, Bundle paramBundle2)
  {
    this.zzmg = paramContext.getApplicationContext();
    this.zzmi = paramMediationRewardedVideoAdListener;
    this.zzmi.onInitializationSucceeded(this);
  }

  public boolean isInitialized()
  {
    return this.zzmi != null;
  }

  public void loadAd(MediationAdRequest paramMediationAdRequest, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((this.zzmg == null) || (this.zzmi == null))
    {
      zzbae.zzen("AdMobAdapter.loadAd called before initialize.");
      return;
    }
    this.zzmh = new InterstitialAd(this.zzmg);
    this.zzmh.zzc(true);
    this.zzmh.setAdUnitId(getAdUnitId(paramBundle1));
    this.zzmh.setRewardedVideoAdListener(this.zzmj);
    this.zzmh.setAdMetadataListener(new h(this));
    this.zzmh.loadAd(zza(this.zzmg, paramMediationAdRequest, paramBundle2, paramBundle1));
  }

  public void onDestroy()
  {
    if (this.zzmd != null)
    {
      this.zzmd.destroy();
      this.zzmd = null;
    }
    if (this.zzme != null)
      this.zzme = null;
    if (this.zzmf != null)
      this.zzmf = null;
    if (this.zzmh != null)
      this.zzmh = null;
  }

  public void onImmersiveModeUpdated(boolean paramBoolean)
  {
    if (this.zzme != null)
      this.zzme.setImmersiveMode(paramBoolean);
    if (this.zzmh != null)
      this.zzmh.setImmersiveMode(paramBoolean);
  }

  public void onPause()
  {
    if (this.zzmd != null)
      this.zzmd.pause();
  }

  public void onResume()
  {
    if (this.zzmd != null)
      this.zzmd.resume();
  }

  public void requestBannerAd(Context paramContext, MediationBannerListener paramMediationBannerListener, Bundle paramBundle1, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    this.zzmd = new AdView(paramContext);
    this.zzmd.setAdSize(new AdSize(paramAdSize.getWidth(), paramAdSize.getHeight()));
    this.zzmd.setAdUnitId(getAdUnitId(paramBundle1));
    this.zzmd.setAdListener(new d(this, paramMediationBannerListener));
    this.zzmd.loadAd(zza(paramContext, paramMediationAdRequest, paramBundle2, paramBundle1));
  }

  public void requestInterstitialAd(Context paramContext, MediationInterstitialListener paramMediationInterstitialListener, Bundle paramBundle1, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    this.zzme = new InterstitialAd(paramContext);
    this.zzme.setAdUnitId(getAdUnitId(paramBundle1));
    this.zzme.setAdListener(new e(this, paramMediationInterstitialListener));
    this.zzme.loadAd(zza(paramContext, paramMediationAdRequest, paramBundle2, paramBundle1));
  }

  public void requestNativeAd(Context paramContext, MediationNativeListener paramMediationNativeListener, Bundle paramBundle1, NativeMediationAdRequest paramNativeMediationAdRequest, Bundle paramBundle2)
  {
    f localf1 = new f(this, paramMediationNativeListener);
    AdLoader.Builder localBuilder = new AdLoader.Builder(paramContext, paramBundle1.getString("pubid")).withAdListener(localf1);
    NativeAdOptions localNativeAdOptions = paramNativeMediationAdRequest.getNativeAdOptions();
    if (localNativeAdOptions != null)
      localBuilder.withNativeAdOptions(localNativeAdOptions);
    if (paramNativeMediationAdRequest.isUnifiedNativeAdRequested())
      localBuilder.forUnifiedNativeAd(localf1);
    if (paramNativeMediationAdRequest.isAppInstallAdRequested())
      localBuilder.forAppInstallAd(localf1);
    if (paramNativeMediationAdRequest.isContentAdRequested())
      localBuilder.forContentAd(localf1);
    if (paramNativeMediationAdRequest.zzsu())
    {
      Iterator localIterator = paramNativeMediationAdRequest.zzsv().keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((Boolean)paramNativeMediationAdRequest.zzsv().get(str)).booleanValue());
        for (f localf2 = localf1; ; localf2 = null)
        {
          localBuilder.forCustomTemplateAd(str, localf1, localf2);
          break;
        }
      }
    }
    this.zzmf = localBuilder.build();
    this.zzmf.loadAd(zza(paramContext, paramNativeMediationAdRequest, paramBundle2, paramBundle1));
  }

  public void showInterstitial()
  {
    this.zzme.show();
  }

  public void showVideo()
  {
    this.zzmh.show();
  }

  protected abstract Bundle zza(Bundle paramBundle1, Bundle paramBundle2);

  static final class a extends NativeAppInstallAdMapper
  {
    private final NativeAppInstallAd a;

    public a(NativeAppInstallAd paramNativeAppInstallAd)
    {
      this.a = paramNativeAppInstallAd;
      setHeadline(paramNativeAppInstallAd.getHeadline().toString());
      setImages(paramNativeAppInstallAd.getImages());
      setBody(paramNativeAppInstallAd.getBody().toString());
      setIcon(paramNativeAppInstallAd.getIcon());
      setCallToAction(paramNativeAppInstallAd.getCallToAction().toString());
      if (paramNativeAppInstallAd.getStarRating() != null)
        setStarRating(paramNativeAppInstallAd.getStarRating().doubleValue());
      if (paramNativeAppInstallAd.getStore() != null)
        setStore(paramNativeAppInstallAd.getStore().toString());
      if (paramNativeAppInstallAd.getPrice() != null)
        setPrice(paramNativeAppInstallAd.getPrice().toString());
      setOverrideImpressionRecording(true);
      setOverrideClickHandling(true);
      zza(paramNativeAppInstallAd.getVideoController());
    }

    public final void trackView(View paramView)
    {
      if ((paramView instanceof NativeAdView))
        ((NativeAdView)paramView).setNativeAd(this.a);
      NativeAdViewHolder localNativeAdViewHolder = (NativeAdViewHolder)NativeAdViewHolder.zzbql.get(paramView);
      if (localNativeAdViewHolder != null)
        localNativeAdViewHolder.setNativeAd(this.a);
    }
  }

  static final class b extends NativeContentAdMapper
  {
    private final NativeContentAd a;

    public b(NativeContentAd paramNativeContentAd)
    {
      this.a = paramNativeContentAd;
      setHeadline(paramNativeContentAd.getHeadline().toString());
      setImages(paramNativeContentAd.getImages());
      setBody(paramNativeContentAd.getBody().toString());
      if (paramNativeContentAd.getLogo() != null)
        setLogo(paramNativeContentAd.getLogo());
      setCallToAction(paramNativeContentAd.getCallToAction().toString());
      setAdvertiser(paramNativeContentAd.getAdvertiser().toString());
      setOverrideImpressionRecording(true);
      setOverrideClickHandling(true);
      zza(paramNativeContentAd.getVideoController());
    }

    public final void trackView(View paramView)
    {
      if ((paramView instanceof NativeAdView))
        ((NativeAdView)paramView).setNativeAd(this.a);
      NativeAdViewHolder localNativeAdViewHolder = (NativeAdViewHolder)NativeAdViewHolder.zzbql.get(paramView);
      if (localNativeAdViewHolder != null)
        localNativeAdViewHolder.setNativeAd(this.a);
    }
  }

  static final class c extends UnifiedNativeAdMapper
  {
    private final UnifiedNativeAd a;

    public c(UnifiedNativeAd paramUnifiedNativeAd)
    {
      this.a = paramUnifiedNativeAd;
      setHeadline(paramUnifiedNativeAd.getHeadline());
      setImages(paramUnifiedNativeAd.getImages());
      setBody(paramUnifiedNativeAd.getBody());
      setIcon(paramUnifiedNativeAd.getIcon());
      setCallToAction(paramUnifiedNativeAd.getCallToAction());
      setAdvertiser(paramUnifiedNativeAd.getAdvertiser());
      setStarRating(paramUnifiedNativeAd.getStarRating());
      setStore(paramUnifiedNativeAd.getStore());
      setPrice(paramUnifiedNativeAd.getPrice());
      zzp(paramUnifiedNativeAd.zzkv());
      setOverrideImpressionRecording(true);
      setOverrideClickHandling(true);
      zza(paramUnifiedNativeAd.getVideoController());
    }

    public final void trackViews(View paramView, Map<String, View> paramMap1, Map<String, View> paramMap2)
    {
      if ((paramView instanceof UnifiedNativeAdView))
        ((UnifiedNativeAdView)paramView).setNativeAd(this.a);
      NativeAdViewHolder localNativeAdViewHolder;
      do
      {
        return;
        localNativeAdViewHolder = (NativeAdViewHolder)NativeAdViewHolder.zzbql.get(paramView);
      }
      while (localNativeAdViewHolder == null);
      localNativeAdViewHolder.setNativeAd(this.a);
    }
  }

  @VisibleForTesting
  static final class d extends AdListener
    implements AppEventListener, zzxp
  {

    @VisibleForTesting
    private final AbstractAdViewAdapter a;

    @VisibleForTesting
    private final MediationBannerListener b;

    public d(AbstractAdViewAdapter paramAbstractAdViewAdapter, MediationBannerListener paramMediationBannerListener)
    {
      this.a = paramAbstractAdViewAdapter;
      this.b = paramMediationBannerListener;
    }

    public final void onAdClicked()
    {
      this.b.onAdClicked(this.a);
    }

    public final void onAdClosed()
    {
      this.b.onAdClosed(this.a);
    }

    public final void onAdFailedToLoad(int paramInt)
    {
      this.b.onAdFailedToLoad(this.a, paramInt);
    }

    public final void onAdLeftApplication()
    {
      this.b.onAdLeftApplication(this.a);
    }

    public final void onAdLoaded()
    {
      this.b.onAdLoaded(this.a);
    }

    public final void onAdOpened()
    {
      this.b.onAdOpened(this.a);
    }

    public final void onAppEvent(String paramString1, String paramString2)
    {
      this.b.zza(this.a, paramString1, paramString2);
    }
  }

  @VisibleForTesting
  static final class e extends AdListener
    implements zzxp
  {

    @VisibleForTesting
    private final AbstractAdViewAdapter a;

    @VisibleForTesting
    private final MediationInterstitialListener b;

    public e(AbstractAdViewAdapter paramAbstractAdViewAdapter, MediationInterstitialListener paramMediationInterstitialListener)
    {
      this.a = paramAbstractAdViewAdapter;
      this.b = paramMediationInterstitialListener;
    }

    public final void onAdClicked()
    {
      this.b.onAdClicked(this.a);
    }

    public final void onAdClosed()
    {
      this.b.onAdClosed(this.a);
    }

    public final void onAdFailedToLoad(int paramInt)
    {
      this.b.onAdFailedToLoad(this.a, paramInt);
    }

    public final void onAdLeftApplication()
    {
      this.b.onAdLeftApplication(this.a);
    }

    public final void onAdLoaded()
    {
      this.b.onAdLoaded(this.a);
    }

    public final void onAdOpened()
    {
      this.b.onAdOpened(this.a);
    }
  }

  @VisibleForTesting
  static final class f extends AdListener
    implements NativeAppInstallAd.OnAppInstallAdLoadedListener, NativeContentAd.OnContentAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener, UnifiedNativeAd.OnUnifiedNativeAdLoadedListener
  {

    @VisibleForTesting
    private final AbstractAdViewAdapter a;

    @VisibleForTesting
    private final MediationNativeListener b;

    public f(AbstractAdViewAdapter paramAbstractAdViewAdapter, MediationNativeListener paramMediationNativeListener)
    {
      this.a = paramAbstractAdViewAdapter;
      this.b = paramMediationNativeListener;
    }

    public final void onAdClicked()
    {
      this.b.onAdClicked(this.a);
    }

    public final void onAdClosed()
    {
      this.b.onAdClosed(this.a);
    }

    public final void onAdFailedToLoad(int paramInt)
    {
      this.b.onAdFailedToLoad(this.a, paramInt);
    }

    public final void onAdImpression()
    {
      this.b.onAdImpression(this.a);
    }

    public final void onAdLeftApplication()
    {
      this.b.onAdLeftApplication(this.a);
    }

    public final void onAdLoaded()
    {
    }

    public final void onAdOpened()
    {
      this.b.onAdOpened(this.a);
    }

    public final void onAppInstallAdLoaded(NativeAppInstallAd paramNativeAppInstallAd)
    {
      this.b.onAdLoaded(this.a, new AbstractAdViewAdapter.a(paramNativeAppInstallAd));
    }

    public final void onContentAdLoaded(NativeContentAd paramNativeContentAd)
    {
      this.b.onAdLoaded(this.a, new AbstractAdViewAdapter.b(paramNativeContentAd));
    }

    public final void onCustomClick(NativeCustomTemplateAd paramNativeCustomTemplateAd, String paramString)
    {
      this.b.zza(this.a, paramNativeCustomTemplateAd, paramString);
    }

    public final void onCustomTemplateAdLoaded(NativeCustomTemplateAd paramNativeCustomTemplateAd)
    {
      this.b.zza(this.a, paramNativeCustomTemplateAd);
    }

    public final void onUnifiedNativeAdLoaded(UnifiedNativeAd paramUnifiedNativeAd)
    {
      this.b.onAdLoaded(this.a, new AbstractAdViewAdapter.c(paramUnifiedNativeAd));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.ads.mediation.AbstractAdViewAdapter
 * JD-Core Version:    0.6.2
 */