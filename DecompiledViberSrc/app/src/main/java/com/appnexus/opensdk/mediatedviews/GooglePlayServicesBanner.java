package com.appnexus.opensdk.mediatedviews;

import android.app.Activity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import com.appnexus.opensdk.MediatedBannerAdView;
import com.appnexus.opensdk.MediatedBannerAdViewController;
import com.appnexus.opensdk.TargetingParameters;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import java.util.ArrayList;
import java.util.Iterator;

public class GooglePlayServicesBanner
  implements MediatedBannerAdView
{
  private AdView a;
  private GooglePlayAdListener b;

  public static AdRequest buildRequest(TargetingParameters paramTargetingParameters)
  {
    AdRequest.Builder localBuilder = new AdRequest.Builder();
    if (paramTargetingParameters != null)
    {
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
        if (paramTargetingParameters.getLocation() != null)
          localBuilder.setLocation(paramTargetingParameters.getLocation());
        localBundle = new Bundle();
        if (paramTargetingParameters.getAge() != null)
          localBundle.putString("Age", paramTargetingParameters.getAge());
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
      localBuilder.addNetworkExtrasBundle(AdMobAdapter.class, localBundle);
    }
    return localBuilder.build();
  }

  public void destroy()
  {
    if (this.a != null)
    {
      this.a.destroy();
      this.a.setAdListener(null);
    }
    this.b = null;
    this.a = null;
  }

  public void onDestroy()
  {
    destroy();
  }

  public void onPause()
  {
    if (this.a != null)
      this.a.pause();
  }

  public void onResume()
  {
    if (this.a != null)
      this.a.resume();
  }

  public View requestAd(MediatedBannerAdViewController paramMediatedBannerAdViewController, Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, TargetingParameters paramTargetingParameters)
  {
    this.b = new GooglePlayAdListener(paramMediatedBannerAdViewController, super.getClass().getSimpleName());
    GooglePlayAdListener localGooglePlayAdListener = this.b;
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = paramString1;
    arrayOfObject[1] = paramString2;
    arrayOfObject[2] = Integer.valueOf(paramInt1);
    arrayOfObject[3] = Integer.valueOf(paramInt2);
    localGooglePlayAdListener.a(String.format(" - requesting an ad: [%s, %s, %dx%d]", arrayOfObject));
    this.a = new AdView(paramActivity);
    this.a.setAdUnitId(paramString2);
    this.a.setAdSize(new AdSize(paramInt1, paramInt2));
    this.a.setAdListener(this.b);
    try
    {
      this.a.loadAd(buildRequest(paramTargetingParameters));
      return this.a;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      while (true)
        this.b.onAdFailedToLoad(3);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.mediatedviews.GooglePlayServicesBanner
 * JD-Core Version:    0.6.2
 */