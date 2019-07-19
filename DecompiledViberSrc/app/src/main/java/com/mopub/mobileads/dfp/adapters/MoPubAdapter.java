package com.mopub.mobileads.dfp.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.mopub.common.MoPub;
import com.mopub.common.SdkConfiguration;
import com.mopub.common.SdkConfiguration.Builder;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView;
import com.mopub.mobileads.MoPubView.BannerAdListener;
import com.mopub.nativeads.BaseNativeAd;
import com.mopub.nativeads.MoPubNative;
import com.mopub.nativeads.MoPubNative.MoPubNativeNetworkListener;
import com.mopub.nativeads.MoPubStaticNativeAdRenderer;
import com.mopub.nativeads.NativeAd;
import com.mopub.nativeads.NativeAd.MoPubNativeEventListener;
import com.mopub.nativeads.NativeErrorCode;
import com.mopub.nativeads.RequestParameters;
import com.mopub.nativeads.RequestParameters.Builder;
import com.mopub.nativeads.RequestParameters.NativeAdAsset;
import com.mopub.nativeads.StaticNativeAd;
import com.mopub.nativeads.ViewBinder.Builder;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.a.d;
import com.viber.voip.settings.d.c;
import com.viber.voip.util.k.a;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;

public class MoPubAdapter
  implements MediationBannerAdapter, MediationNativeAdapter
{
  public static final double DEFAULT_MOPUB_IMAGE_SCALE = 1.0D;
  public static final String MOPUB_NATIVE_CEVENT_VERSION = "gmext";
  private static final Logger a = ViberEnv.getLogger();
  private MoPubView b;
  private AdSize c;
  private int d;
  private int e;
  private NativeAd.MoPubNativeEventListener f;
  private RequestParameters g;

  private AdSize a(Context paramContext, AdSize paramAdSize)
  {
    AdSize localAdSize = new AdSize(paramAdSize.getWidth(), paramAdSize.getHeight());
    ArrayList localArrayList = new ArrayList(2);
    localArrayList.add(AdSize.BANNER);
    localArrayList.add(AdSize.MEDIUM_RECTANGLE);
    localArrayList.add(AdSize.LEADERBOARD);
    localArrayList.add(AdSize.WIDE_SKYSCRAPER);
    a.c(localArrayList.toString(), new Object[0]);
    return findClosestSize(paramContext, localAdSize, localArrayList);
  }

  private static boolean a(AdSize paramAdSize1, AdSize paramAdSize2)
  {
    if (paramAdSize2 == null);
    int i;
    int j;
    int k;
    int m;
    do
    {
      return false;
      i = paramAdSize1.getWidth();
      j = paramAdSize2.getWidth();
      k = paramAdSize1.getHeight();
      m = paramAdSize2.getHeight();
    }
    while ((0.5D * i > j) || (i < j) || (0.7D * k > m) || (k < m));
    return true;
  }

  private static AdSize b(AdSize paramAdSize1, AdSize paramAdSize2)
  {
    if (paramAdSize1.getWidth() * paramAdSize1.getHeight() > paramAdSize2.getWidth() * paramAdSize2.getHeight())
      return paramAdSize1;
    return paramAdSize2;
  }

  public static AdSize findClosestSize(Context paramContext, AdSize paramAdSize, ArrayList<AdSize> paramArrayList)
  {
    Object localObject1 = null;
    if (paramArrayList != null)
    {
      localObject1 = null;
      if (paramAdSize != null);
    }
    else
    {
      return localObject1;
    }
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    AdSize localAdSize = new AdSize(Math.round(paramAdSize.getWidthInPixels(paramContext) / f1), Math.round(paramAdSize.getHeightInPixels(paramContext) / f1));
    Iterator localIterator = paramArrayList.iterator();
    label65: Object localObject2;
    if (localIterator.hasNext())
    {
      localObject2 = (AdSize)localIterator.next();
      if (!a(localAdSize, (AdSize)localObject2))
        break label118;
      if (localObject1 != null)
        break label107;
    }
    while (true)
    {
      localObject1 = localObject2;
      break label65;
      break;
      label107: localObject2 = b((AdSize)localObject1, (AdSize)localObject2);
      continue;
      label118: localObject2 = localObject1;
    }
  }

  public static String getKeywords(MediationAdRequest paramMediationAdRequest, boolean paramBoolean)
  {
    Calendar localCalendar = a.a(paramMediationAdRequest);
    String str1 = "";
    if (localCalendar != null)
    {
      int j = localCalendar.get(1);
      int k = Calendar.getInstance().get(1) - j;
      str1 = "m_age:" + k;
      a.b("Set age to ?", new Object[] { str1 });
    }
    d locald = a.a(d.c.a, paramMediationAdRequest);
    Logger localLogger = a;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = locald.name();
    localLogger.b("Set gender to ?", arrayOfObject);
    String str2 = locald.toMopubTargetingParamGender();
    StringBuilder localStringBuilder = new StringBuilder().append("gmext").append(",").append(str1).append(",").append(str2);
    int i;
    if ((localCalendar != null) || (locald != d.UNKNOWN) || (paramMediationAdRequest.getLocation() != null))
      i = 1;
    while (paramBoolean)
      if (MoPub.canCollectPersonalInformation())
      {
        if (i != 0)
        {
          return localStringBuilder.toString();
          i = 0;
        }
        else
        {
          return "";
        }
      }
      else
        return "";
    if (i != 0)
      return "";
    return localStringBuilder.toString();
  }

  public View getBannerView()
  {
    return this.b;
  }

  public void onDestroy()
  {
    if (this.b != null)
    {
      this.b.destroy();
      this.b = null;
    }
  }

  public void onPause()
  {
  }

  public void onResume()
  {
  }

  public void requestBannerAd(Context paramContext, MediationBannerListener paramMediationBannerListener, Bundle paramBundle1, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    String str = paramBundle1.getString("adUnitId");
    this.c = a(paramContext, paramAdSize);
    if (this.c == null)
    {
      a.b("Failed to request ad, AdSize is null.", new Object[0]);
      paramMediationBannerListener.onAdFailedToLoad(this, 1);
      return;
    }
    this.b = new MoPubView(paramContext);
    this.b.setBannerAdListener(new a(paramMediationBannerListener));
    this.b.setAdUnitId(str);
    if (paramMediationAdRequest.isTesting())
      this.b.setTesting(true);
    if (paramMediationAdRequest.getLocation() != null)
      this.b.setLocation(paramMediationAdRequest.getLocation());
    this.b.setKeywords(getKeywords(paramMediationAdRequest, false));
    this.b.setUserDataKeywords(getKeywords(paramMediationAdRequest, true));
    SdkConfiguration localSdkConfiguration = new SdkConfiguration.Builder(str).build();
    com.google.ads.mediation.mopub.b localb = com.google.ads.mediation.mopub.b.a();
    MoPubView localMoPubView = this.b;
    localMoPubView.getClass();
    localb.a(paramContext, localSdkConfiguration, c.a(localMoPubView));
  }

  public void requestNativeAd(final Context paramContext, final MediationNativeListener paramMediationNativeListener, Bundle paramBundle1, NativeMediationAdRequest paramNativeMediationAdRequest, Bundle paramBundle2)
  {
    String str = paramBundle1.getString("adUnitId");
    NativeAdOptions localNativeAdOptions = paramNativeMediationAdRequest.getNativeAdOptions();
    int i;
    if (localNativeAdOptions != null)
    {
      this.d = localNativeAdOptions.getAdChoicesPlacement();
      if (paramBundle2 == null)
        break label133;
      i = paramBundle2.getInt("privacy_icon_size_dp");
      if (i >= 10)
        break label108;
      this.e = 10;
    }
    MoPubNative.MoPubNativeNetworkListener local1;
    label133: 
    while (true)
    {
      local1 = new MoPubNative.MoPubNativeNetworkListener()
      {
        public void onNativeFail(NativeErrorCode paramAnonymousNativeErrorCode)
        {
          MoPubAdapter.a().e("onNativeFail ? ", new Object[] { paramAnonymousNativeErrorCode });
          switch (MoPubAdapter.3.a[paramAnonymousNativeErrorCode.ordinal()])
          {
          default:
            paramMediationNativeListener.onAdFailedToLoad(MoPubAdapter.this, 0);
            return;
          case 1:
            paramMediationNativeListener.onAdFailedToLoad(MoPubAdapter.this, 3);
            return;
          case 2:
            paramMediationNativeListener.onAdFailedToLoad(MoPubAdapter.this, 1);
            return;
          case 3:
            paramMediationNativeListener.onAdFailedToLoad(MoPubAdapter.this, 1);
            return;
          case 4:
          }
          paramMediationNativeListener.onAdFailedToLoad(MoPubAdapter.this, 0);
        }

        public void onNativeLoad(NativeAd paramAnonymousNativeAd)
        {
          MoPubAdapter.a().b("onNativeLoad ?" + paramAnonymousNativeAd, new Object[0]);
          paramAnonymousNativeAd.setMoPubNativeEventListener(MoPubAdapter.a(MoPubAdapter.this));
          BaseNativeAd localBaseNativeAd = paramAnonymousNativeAd.getBaseNativeAd();
          if ((localBaseNativeAd instanceof StaticNativeAd))
          {
            final StaticNativeAd localStaticNativeAd = (StaticNativeAd)localBaseNativeAd;
            try
            {
              HashMap localHashMap = new HashMap();
              try
              {
                localHashMap.put("icon_key", new URL(localStaticNativeAd.getIconImageUrl()));
                localHashMap.put("image_key", new URL(localStaticNativeAd.getMainImageUrl()));
                new DownloadDrawablesAsync(new DrawableDownloadListener()
                {
                  public void onDownloadFailure()
                  {
                    MoPubAdapter.1.this.a.onAdFailedToLoad(MoPubAdapter.this, 0);
                  }

                  public void onDownloadSuccess(HashMap<String, Drawable> paramAnonymous2HashMap)
                  {
                    try
                    {
                      MoPubNativeAppInstallAdMapper localMoPubNativeAppInstallAdMapper = new MoPubNativeAppInstallAdMapper(localStaticNativeAd, paramAnonymous2HashMap, MoPubAdapter.b(MoPubAdapter.this), MoPubAdapter.c(MoPubAdapter.this));
                      ImageView localImageView = new ImageView(MoPubAdapter.1.this.b);
                      localImageView.setImageDrawable((Drawable)paramAnonymous2HashMap.get("image_key"));
                      localMoPubNativeAppInstallAdMapper.setMediaView(localImageView);
                      MoPubAdapter.1.this.a.onAdLoaded(MoPubAdapter.this, localMoPubNativeAppInstallAdMapper);
                      return;
                    }
                    catch (Exception localException)
                    {
                      MoPubAdapter.a().e("Exception trying to download native ad drawables", new Object[0]);
                      MoPubAdapter.1.this.a.onAdFailedToLoad(MoPubAdapter.this, 0);
                    }
                  }
                }).execute(new Object[] { localHashMap });
                return;
              }
              catch (MalformedURLException localMalformedURLException)
              {
                while (true)
                {
                  MoPubAdapter.a().e("Invalid ad response received from MoPub. Image URLs are invalid", new Object[0]);
                  paramMediationNativeListener.onAdFailedToLoad(MoPubAdapter.this, 0);
                }
              }
            }
            catch (Exception localException)
            {
              MoPubAdapter.a().e("Exception constructing the native ad", new Object[0]);
              paramMediationNativeListener.onAdFailedToLoad(MoPubAdapter.this, 0);
            }
          }
        }
      };
      if (str != null)
        break label142;
      a.e("Ad unit id is invalid. So failing the request.", new Object[0]);
      paramMediationNativeListener.onAdFailedToLoad(this, 1);
      return;
      this.d = 1;
      break;
      label108: if (i > 30)
      {
        this.e = 30;
      }
      else
      {
        this.e = i;
        continue;
        this.e = 20;
      }
    }
    label142: MoPubNative localMoPubNative = new MoPubNative(paramContext, str, local1);
    localMoPubNative.registerAdRenderer(new MoPubStaticNativeAdRenderer(new ViewBinder.Builder(0).build()));
    EnumSet localEnumSet = EnumSet.of(RequestParameters.NativeAdAsset.TITLE, RequestParameters.NativeAdAsset.TEXT, RequestParameters.NativeAdAsset.CALL_TO_ACTION_TEXT, RequestParameters.NativeAdAsset.MAIN_IMAGE, RequestParameters.NativeAdAsset.ICON_IMAGE);
    this.g = new RequestParameters.Builder().keywords(getKeywords(paramNativeMediationAdRequest, false)).userDataKeywords(getKeywords(paramNativeMediationAdRequest, true)).location(paramNativeMediationAdRequest.getLocation()).desiredAssets(localEnumSet).build();
    SdkConfiguration localSdkConfiguration = new SdkConfiguration.Builder(str).build();
    com.google.ads.mediation.mopub.b.a().a(paramContext, localSdkConfiguration, new b(this, localMoPubNative));
    this.f = new NativeAd.MoPubNativeEventListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramMediationNativeListener.onAdClicked(MoPubAdapter.this);
        paramMediationNativeListener.onAdOpened(MoPubAdapter.this);
        paramMediationNativeListener.onAdLeftApplication(MoPubAdapter.this);
        MoPubAdapter.a().b("onClick", new Object[0]);
      }

      public void onImpression(View paramAnonymousView)
      {
        paramMediationNativeListener.onAdImpression(MoPubAdapter.this);
        MoPubAdapter.a().b("onImpression", new Object[0]);
      }
    };
  }

  public static final class BundleBuilder
  {
    private int a;

    public Bundle build()
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("privacy_icon_size_dp", this.a);
      return localBundle;
    }

    public BundleBuilder setPrivacyIconSize(int paramInt)
    {
      this.a = paramInt;
      return this;
    }
  }

  private class a
    implements MoPubView.BannerAdListener
  {
    private MediationBannerListener b;

    public a(MediationBannerListener arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    public void onBannerClicked(MoPubView paramMoPubView)
    {
      this.b.onAdClicked(MoPubAdapter.this);
      this.b.onAdLeftApplication(MoPubAdapter.this);
    }

    public void onBannerCollapsed(MoPubView paramMoPubView)
    {
      this.b.onAdClosed(MoPubAdapter.this);
    }

    public void onBannerExpanded(MoPubView paramMoPubView)
    {
      this.b.onAdOpened(MoPubAdapter.this);
    }

    public void onBannerFailed(MoPubView paramMoPubView, MoPubErrorCode paramMoPubErrorCode)
    {
      try
      {
        switch (MoPubAdapter.3.b[paramMoPubErrorCode.ordinal()])
        {
        default:
          this.b.onAdFailedToLoad(MoPubAdapter.this, 0);
          return;
        case 1:
          this.b.onAdFailedToLoad(MoPubAdapter.this, 3);
          return;
        case 2:
          this.b.onAdFailedToLoad(MoPubAdapter.this, 2);
          return;
        case 3:
        }
        this.b.onAdFailedToLoad(MoPubAdapter.this, 1);
        return;
      }
      catch (NoClassDefFoundError localNoClassDefFoundError)
      {
      }
    }

    public void onBannerLoaded(MoPubView paramMoPubView)
    {
      if ((MoPubAdapter.d(MoPubAdapter.this).getWidth() != paramMoPubView.getAdWidth()) || (MoPubAdapter.d(MoPubAdapter.this).getHeight() != paramMoPubView.getAdHeight()))
      {
        MoPubAdapter.a().e("The banner ad size loaded does not match the request size. Update the ad size on your MoPub UI to match the request size.", new Object[0]);
        this.b.onAdFailedToLoad(MoPubAdapter.this, 3);
        return;
      }
      this.b.onAdLoaded(MoPubAdapter.this);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.dfp.adapters.MoPubAdapter
 * JD-Core Version:    0.6.2
 */