package com.appnexus.opensdk.mediatedviews;

import android.app.Activity;
import android.view.View;
import com.appnexus.opensdk.MediatedBannerAdView;
import com.appnexus.opensdk.MediatedBannerAdViewController;
import com.appnexus.opensdk.ResultCode;
import com.appnexus.opensdk.TargetingParameters;

public class DFPBanner
  implements MediatedBannerAdView
{
  private MediatedBannerAdView a;

  public void destroy()
  {
    if (this.a != null)
    {
      this.a.destroy();
      this.a = null;
    }
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

  public View requestAd(MediatedBannerAdViewController paramMediatedBannerAdViewController, Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, TargetingParameters paramTargetingParameters)
  {
    if (a.a());
    for (String str = "com.appnexus.opensdk.mediatedviews.GooglePlayDFPBanner"; ; str = "com.appnexus.opensdk.mediatedviews.LegacyDFPBanner")
    {
      this.a = a.a(str);
      if (this.a != null)
        break;
      if (paramMediatedBannerAdViewController != null)
        paramMediatedBannerAdViewController.onAdFailed(ResultCode.MEDIATED_SDK_UNAVAILABLE);
      return null;
    }
    return this.a.requestAd(paramMediatedBannerAdViewController, paramActivity, paramString1, paramString2, paramInt1, paramInt2, paramTargetingParameters);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.mediatedviews.DFPBanner
 * JD-Core Version:    0.6.2
 */