package com.appnexus.opensdk.mediatedviews;

import android.app.Activity;
import android.os.Bundle;
import android.util.Pair;
import com.appnexus.opensdk.MediatedInterstitialAdView;
import com.appnexus.opensdk.MediatedInterstitialAdViewController;
import com.appnexus.opensdk.TargetingParameters;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest.Builder;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import java.util.ArrayList;
import java.util.Iterator;

public class GooglePlayDFPInterstitial
  implements MediatedInterstitialAdView
{
  private PublisherInterstitialAd a;
  private GooglePlayAdListener b;

  private PublisherAdRequest a(TargetingParameters paramTargetingParameters)
  {
    PublisherAdRequest.Builder localBuilder = new PublisherAdRequest.Builder();
    switch (1.a[paramTargetingParameters.getGender().ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    Bundle localBundle;
    while (true)
    {
      localBundle = new Bundle();
      if (paramTargetingParameters.getAge() != null)
        localBundle.putString("Age", paramTargetingParameters.getAge());
      if (paramTargetingParameters.getLocation() != null)
        localBuilder.setLocation(paramTargetingParameters.getLocation());
      Iterator localIterator = paramTargetingParameters.getCustomKeywords().iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        localBundle.putString((String)localPair.first, (String)localPair.second);
      }
      localBuilder.setGender(0);
      continue;
      localBuilder.setGender(2);
      continue;
      localBuilder.setGender(1);
    }
    localBuilder.addNetworkExtras(new AdMobExtras(localBundle));
    return localBuilder.build();
  }

  public void destroy()
  {
    if (this.a != null)
    {
      this.a.setAdListener(null);
      this.a = null;
      this.b = null;
    }
  }

  public boolean isReady()
  {
    return (this.a != null) && (this.a.isLoaded());
  }

  public void onDestroy()
  {
    destroy();
  }

  public void onPause()
  {
  }

  public void onResume()
  {
  }

  public void requestAd(MediatedInterstitialAdViewController paramMediatedInterstitialAdViewController, Activity paramActivity, String paramString1, String paramString2, TargetingParameters paramTargetingParameters)
  {
    this.b = new GooglePlayAdListener(paramMediatedInterstitialAdViewController, super.getClass().getSimpleName());
    this.b.a(String.format(" - requesting an ad: [%s, %s]", new Object[] { paramString1, paramString2 }));
    this.a = new PublisherInterstitialAd(paramActivity);
    this.a.setAdUnitId(paramString2);
    this.a.setAdListener(this.b);
    this.a.loadAd(a(paramTargetingParameters));
  }

  public void show()
  {
    this.b.a("show called");
    if (this.a == null)
    {
      this.b.b("show called while interstitial ad view was null");
      return;
    }
    if (!this.a.isLoaded())
    {
      this.b.b("show called while interstitial ad view was not ready");
      return;
    }
    this.a.show();
    this.b.a("interstitial ad shown");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.mediatedviews.GooglePlayDFPInterstitial
 * JD-Core Version:    0.6.2
 */