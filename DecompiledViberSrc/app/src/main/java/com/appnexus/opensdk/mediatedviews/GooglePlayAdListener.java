package com.appnexus.opensdk.mediatedviews;

import com.appnexus.opensdk.MediatedAdViewController;
import com.appnexus.opensdk.MediatedBannerAdViewController;
import com.appnexus.opensdk.ResultCode;
import com.appnexus.opensdk.utils.Clog;
import com.google.android.gms.ads.AdListener;

public class GooglePlayAdListener extends AdListener
{
  MediatedAdViewController a;
  String b;

  public GooglePlayAdListener(MediatedAdViewController paramMediatedAdViewController, String paramString)
  {
    this.a = paramMediatedAdViewController;
    this.b = paramString;
  }

  void a(String paramString)
  {
    Clog.d(Clog.mediationLogTag, this.b + " - " + paramString);
  }

  void b(String paramString)
  {
    Clog.e(Clog.mediationLogTag, this.b + " - " + paramString);
  }

  public void onAdClosed()
  {
    super.onAdClosed();
    a("onAdClosed");
    if ((this.a != null) && ((this.a instanceof MediatedBannerAdViewController)))
      this.a.onAdCollapsed();
  }

  public void onAdFailedToLoad(int paramInt)
  {
    super.onAdFailedToLoad(paramInt);
    a("onAdFailedToLoad with error code " + paramInt);
    ResultCode localResultCode = ResultCode.INTERNAL_ERROR;
    switch (paramInt)
    {
    default:
    case 0:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      if (this.a != null)
        this.a.onAdFailed(localResultCode);
      return;
      localResultCode = ResultCode.INTERNAL_ERROR;
      continue;
      localResultCode = ResultCode.INVALID_REQUEST;
      continue;
      localResultCode = ResultCode.NETWORK_ERROR;
      continue;
      localResultCode = ResultCode.UNABLE_TO_FILL;
    }
  }

  public void onAdLeftApplication()
  {
    super.onAdLeftApplication();
    a("onAdLeftApplication");
    if (this.a != null)
      this.a.onAdClicked();
  }

  public void onAdLoaded()
  {
    super.onAdLoaded();
    a("onAdLoaded");
    if (this.a != null)
      this.a.onAdLoaded();
  }

  public void onAdOpened()
  {
    super.onAdOpened();
    a("onAdOpened");
    if ((this.a != null) && ((this.a instanceof MediatedBannerAdViewController)))
      this.a.onAdExpanded();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.mediatedviews.GooglePlayAdListener
 * JD-Core Version:    0.6.2
 */