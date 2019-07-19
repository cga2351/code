package com.appnexus.opensdk.mediatedviews;

import android.app.Activity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import com.appnexus.opensdk.MediatedBannerAdView;
import com.appnexus.opensdk.MediatedBannerAdViewController;
import com.appnexus.opensdk.TargetingParameters;
import com.appnexus.opensdk.utils.StringUtil;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest.Builder;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class GooglePlayDFPBanner
  implements MediatedBannerAdView
{
  private PublisherAdView a;
  private GooglePlayAdListener b;

  private PublisherAdRequest a(a parama, TargetingParameters paramTargetingParameters)
  {
    PublisherAdRequest.Builder localBuilder = new PublisherAdRequest.Builder();
    if ((parama.b != null) && (parama.b.length() > 0))
    {
      this.b.a("test device " + parama.b);
      localBuilder.addTestDevice(parama.b);
    }
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
    a locala = new a(paramString1);
    if (locala.c);
    for (AdSize localAdSize = AdSize.SMART_BANNER; ; localAdSize = new AdSize(paramInt1, paramInt2))
    {
      this.a = new PublisherAdView(paramActivity);
      this.a.setAdUnitId(paramString2);
      this.a.setAdSizes(new AdSize[] { localAdSize });
      this.a.setAdListener(this.b);
      this.a.loadAd(a(locala, paramTargetingParameters));
      return this.a;
    }
  }

  class a
  {
    public boolean a = false;
    public String b;
    public boolean c = false;

    public a(String arg2)
    {
      String str;
      if (!StringUtil.isEmpty(str));
      try
      {
        JSONObject localJSONObject = new JSONObject(str);
        this.c = a(localJSONObject, "smartbanner");
        this.a = a(localJSONObject, "swipeable");
        return;
      }
      catch (JSONException localJSONException)
      {
      }
    }

    private boolean a(JSONObject paramJSONObject, String paramString)
    {
      try
      {
        boolean bool2 = paramJSONObject.getBoolean(paramString);
        bool1 = bool2;
        return bool1;
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          int i = paramJSONObject.getInt(paramString);
          boolean bool1 = false;
          switch (i)
          {
          case 0:
          default:
            return false;
          case 1:
          }
          return true;
        }
        catch (JSONException localJSONException2)
        {
        }
      }
      return false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.mediatedviews.GooglePlayDFPBanner
 * JD-Core Version:    0.6.2
 */