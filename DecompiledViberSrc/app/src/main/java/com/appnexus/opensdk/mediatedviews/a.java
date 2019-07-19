package com.appnexus.opensdk.mediatedviews;

import com.appnexus.opensdk.MediatedBannerAdView;
import com.appnexus.opensdk.MediatedInterstitialAdView;

class a
{
  static MediatedBannerAdView a(String paramString)
  {
    if (paramString == null)
      return null;
    try
    {
      MediatedBannerAdView localMediatedBannerAdView = (MediatedBannerAdView)Class.forName(paramString).newInstance();
      return localMediatedBannerAdView;
    }
    catch (ClassCastException localClassCastException)
    {
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label23;
    }
    catch (InstantiationException localInstantiationException)
    {
      break label23;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label23: break label23;
    }
  }

  static boolean a()
  {
    try
    {
      Class localClass = Class.forName("com.google.android.gms.ads.AdListener");
      boolean bool = false;
      if (localClass != null)
        bool = true;
      return bool;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    return false;
  }

  static MediatedInterstitialAdView b(String paramString)
  {
    if (paramString == null)
      return null;
    try
    {
      MediatedInterstitialAdView localMediatedInterstitialAdView = (MediatedInterstitialAdView)Class.forName(paramString).newInstance();
      return localMediatedInterstitialAdView;
    }
    catch (ClassCastException localClassCastException)
    {
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label23;
    }
    catch (InstantiationException localInstantiationException)
    {
      break label23;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label23: break label23;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.mediatedviews.a
 * JD-Core Version:    0.6.2
 */