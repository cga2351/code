package com.appnexus.opensdk;

import android.app.Activity;
import com.appnexus.opensdk.ut.UTAdRequester;
import com.appnexus.opensdk.ut.adresponse.CSMSDKAdResponse;
import com.appnexus.opensdk.utils.Clog;

public class MediatedInterstitialAdViewController extends MediatedAdViewController
{
  private MediatedInterstitialAdViewController(Activity paramActivity, UTAdRequester paramUTAdRequester, CSMSDKAdResponse paramCSMSDKAdResponse, c paramc)
  {
    super(paramUTAdRequester, paramCSMSDKAdResponse, paramc, MediaType.INTERSTITIAL);
    if (!a(MediatedInterstitialAdView.class));
    while (true)
    {
      return;
      Clog.d(Clog.mediationLogTag, Clog.getString(R.string.mediated_request));
      e();
      g();
      if (paramActivity != null);
      try
      {
        ((MediatedInterstitialAdView)this.b).requestAd(this, paramActivity, this.c.getParam(), this.c.getId(), a());
        for (localResultCode = null; localResultCode != null; localResultCode = ResultCode.INTERNAL_ERROR)
        {
          onAdFailed(localResultCode);
          return;
          Clog.e(Clog.mediationLogTag, Clog.getString(R.string.mediated_request_null_activity));
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          Clog.e(Clog.mediationLogTag, Clog.getString(R.string.mediated_request_exception), localException);
          localResultCode = ResultCode.INTERNAL_ERROR;
        }
      }
      catch (Error localError)
      {
        while (true)
        {
          Clog.e(Clog.mediationLogTag, Clog.getString(R.string.mediated_request_error), localError);
          ResultCode localResultCode = ResultCode.INTERNAL_ERROR;
        }
      }
    }
  }

  static MediatedInterstitialAdViewController a(Activity paramActivity, UTAdRequester paramUTAdRequester, CSMSDKAdResponse paramCSMSDKAdResponse, c paramc)
  {
    MediatedInterstitialAdViewController localMediatedInterstitialAdViewController = new MediatedInterstitialAdViewController(paramActivity, paramUTAdRequester, paramCSMSDKAdResponse, paramc);
    if (localMediatedInterstitialAdViewController.f)
      localMediatedInterstitialAdViewController = null;
    return localMediatedInterstitialAdViewController;
  }

  boolean c()
  {
    return ((MediatedInterstitialAdView)this.b).isReady();
  }

  void d()
  {
    if ((this.b != null) && (!this.h))
      ((MediatedInterstitialAdView)this.b).show();
  }

  public void onDestroy()
  {
    this.h = true;
    if (this.b != null)
      this.b.onDestroy();
  }

  public void onPause()
  {
    if (this.b != null)
      this.b.onPause();
  }

  public void onResume()
  {
    if (this.b != null)
      this.b.onResume();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.MediatedInterstitialAdViewController
 * JD-Core Version:    0.6.2
 */