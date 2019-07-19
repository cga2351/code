package com.appnexus.opensdk;

import android.app.Activity;
import android.view.View;
import com.appnexus.opensdk.ut.UTAdRequester;
import com.appnexus.opensdk.ut.adresponse.CSMSDKAdResponse;
import com.appnexus.opensdk.utils.Clog;

public class MediatedBannerAdViewController extends MediatedAdViewController
{
  private MediatedBannerAdViewController(Activity paramActivity, UTAdRequester paramUTAdRequester, CSMSDKAdResponse paramCSMSDKAdResponse, c paramc)
  {
    super(paramUTAdRequester, paramCSMSDKAdResponse, paramc, MediaType.BANNER);
    if (!a(MediatedBannerAdView.class));
    while (true)
    {
      return;
      Clog.d(Clog.mediationLogTag, Clog.getString(R.string.mediated_request));
      e();
      g();
      if (paramActivity != null);
      try
      {
        if (!this.h)
        {
          View localView = ((MediatedBannerAdView)this.b).requestAd(this, paramActivity, this.c.getParam(), this.c.getId(), this.c.getWidth(), this.c.getHeight(), a());
          this.e.a(localView);
        }
        for (localResultCode = null; ; localResultCode = ResultCode.INTERNAL_ERROR)
        {
          if ((localResultCode == null) && (this.e.i() == null))
          {
            Clog.e(Clog.mediationLogTag, Clog.getString(R.string.mediated_view_null));
            localResultCode = ResultCode.INTERNAL_ERROR;
          }
          if (localResultCode == null)
            break;
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

  static MediatedBannerAdViewController a(Activity paramActivity, UTAdRequester paramUTAdRequester, CSMSDKAdResponse paramCSMSDKAdResponse, c paramc)
  {
    MediatedBannerAdViewController localMediatedBannerAdViewController = new MediatedBannerAdViewController(paramActivity, paramUTAdRequester, paramCSMSDKAdResponse, paramc);
    if (localMediatedBannerAdViewController.f)
      localMediatedBannerAdViewController = null;
    return localMediatedBannerAdViewController;
  }

  boolean c()
  {
    return true;
  }

  void d()
  {
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
 * Qualified Name:     com.appnexus.opensdk.MediatedBannerAdViewController
 * JD-Core Version:    0.6.2
 */