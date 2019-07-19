package com.appnexus.opensdk.mediatedviews;

import android.app.Activity;
import com.appnexus.opensdk.MediatedInterstitialAdView;
import com.appnexus.opensdk.MediatedInterstitialAdViewController;
import com.appnexus.opensdk.ResultCode;
import com.appnexus.opensdk.TargetingParameters;

public class DFPInterstitial
  implements MediatedInterstitialAdView
{
  private MediatedInterstitialAdView a;

  public void destroy()
  {
    if (this.a != null)
    {
      this.a.destroy();
      this.a = null;
    }
  }

  public boolean isReady()
  {
    return (this.a != null) && (this.a.isReady());
  }

  public void onDestroy()
  {
    if (this.a != null)
      this.a.onDestroy();
  }

  public void onPause()
  {
    if (this.a != null)
      this.a.onPause();
  }

  public void onResume()
  {
    if (this.a != null)
      this.a.onResume();
  }

  public void requestAd(MediatedInterstitialAdViewController paramMediatedInterstitialAdViewController, Activity paramActivity, String paramString1, String paramString2, TargetingParameters paramTargetingParameters)
  {
    if (a.a());
    for (String str = "com.appnexus.opensdk.mediatedviews.GooglePlayDFPInterstitial"; ; str = "com.appnexus.opensdk.mediatedviews.LegacyDFPInterstitial")
    {
      this.a = a.b(str);
      if (this.a != null)
        break;
      if (paramMediatedInterstitialAdViewController != null)
        paramMediatedInterstitialAdViewController.onAdFailed(ResultCode.MEDIATED_SDK_UNAVAILABLE);
      return;
    }
    this.a.requestAd(paramMediatedInterstitialAdViewController, paramActivity, paramString1, paramString2, paramTargetingParameters);
  }

  public void show()
  {
    if (this.a != null)
      this.a.show();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.mediatedviews.DFPInterstitial
 * JD-Core Version:    0.6.2
 */