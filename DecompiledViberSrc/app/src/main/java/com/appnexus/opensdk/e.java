package com.appnexus.opensdk;

import android.app.Activity;
import com.appnexus.opensdk.ut.UTAdRequest;
import com.appnexus.opensdk.ut.UTAdResponse;
import com.appnexus.opensdk.ut.UTRequestParameters;
import com.appnexus.opensdk.ut.adresponse.BaseAdResponse;
import com.appnexus.opensdk.ut.adresponse.CSMSDKAdResponse;
import com.appnexus.opensdk.ut.adresponse.RTBNativeAdResponse;
import com.appnexus.opensdk.ut.adresponse.RTBVASTAdResponse;
import com.appnexus.opensdk.ut.adresponse.SSMHTMLAdResponse;
import com.appnexus.opensdk.utils.Clog;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

class e extends RequestManager
{
  private MediatedAdViewController c;
  private MediatedSSMAdViewController d;
  private MediatedNativeAdController e;
  private final WeakReference<b> f;

  public e(b paramb)
  {
    this.f = new WeakReference(paramb);
  }

  private void a(AdView paramAdView, BaseAdResponse paramBaseAdResponse)
  {
    f localf = new f(paramAdView, this);
    localf.a(paramBaseAdResponse);
    if (paramAdView.getMediaType().equals(MediaType.BANNER))
    {
      BannerAdView localBannerAdView = (BannerAdView)paramAdView;
      if (localBannerAdView.getExpandsToFitScreenWidth())
        localBannerAdView.b(paramBaseAdResponse.getWidth(), paramBaseAdResponse.getHeight(), localf);
      if (localBannerAdView.getResizeAdToFitContainer())
        localBannerAdView.a(paramBaseAdResponse.getWidth(), paramBaseAdResponse.getHeight(), localf);
    }
  }

  private void a(AdView paramAdView, SSMHTMLAdResponse paramSSMHTMLAdResponse)
  {
    Clog.i(Clog.baseLogTag, "Mediation type is SSM, passing it to SSMAdViewController.");
    this.d = MediatedSSMAdViewController.a(paramAdView, this, paramSSMHTMLAdResponse);
  }

  private void a(b paramb, final BaseAdResponse paramBaseAdResponse)
  {
    final ANNativeAdResponse localANNativeAdResponse = ((RTBNativeAdResponse)paramBaseAdResponse).getNativeAdResponse();
    if (paramb != null)
    {
      localANNativeAdResponse.a(paramb.getRequestParameters().getLoadsInBackground());
      localANNativeAdResponse.setClickThroughAction(paramb.getRequestParameters().getClickThroughAction());
    }
    onReceiveAd(new AdResponse()
    {
      public void destroy()
      {
        localANNativeAdResponse.destroy();
      }

      public i getDisplayable()
      {
        return null;
      }

      public MediaType getMediaType()
      {
        return MediaType.NATIVE;
      }

      public NativeAdResponse getNativeAdResponse()
      {
        return localANNativeAdResponse;
      }

      public BaseAdResponse getResponseData()
      {
        return paramBaseAdResponse;
      }

      public boolean isMediated()
      {
        return false;
      }
    });
  }

  private void a(b paramb, CSMSDKAdResponse paramCSMSDKAdResponse)
  {
    Clog.i(Clog.baseLogTag, "Mediation type is CSM, passing it to MediatedAdViewController.");
    if (paramCSMSDKAdResponse.getAdType().equals("native"))
    {
      this.e = MediatedNativeAdController.create(paramCSMSDKAdResponse, this);
      return;
    }
    AdView localAdView = (AdView)paramb;
    if (localAdView.getMediaType().equals(MediaType.BANNER))
    {
      this.c = MediatedBannerAdViewController.a((Activity)localAdView.getContext(), this, paramCSMSDKAdResponse, localAdView.getAdDispatcher());
      return;
    }
    if (localAdView.getMediaType().equals(MediaType.INTERSTITIAL))
    {
      this.c = MediatedInterstitialAdViewController.a((Activity)localAdView.getContext(), this, paramCSMSDKAdResponse, localAdView.getAdDispatcher());
      return;
    }
    Clog.e(Clog.baseLogTag, "MediaType type can not be identified.");
    continueWaterfall(ResultCode.INVALID_REQUEST);
  }

  private boolean a(UTAdResponse paramUTAdResponse)
  {
    return (paramUTAdResponse != null) && (paramUTAdResponse.getAdList() != null) && (!paramUTAdResponse.getAdList().isEmpty());
  }

  private void b(b paramb, BaseAdResponse paramBaseAdResponse)
  {
    if ((paramBaseAdResponse instanceof RTBNativeAdResponse))
    {
      a(paramb, paramBaseAdResponse);
      return;
    }
    AdView localAdView = (AdView)paramb;
    if (paramBaseAdResponse.getAdContent() != null)
    {
      if (("banner".equalsIgnoreCase(paramBaseAdResponse.getAdType())) || ("video".equalsIgnoreCase(paramBaseAdResponse.getAdType())))
      {
        if ("video".equalsIgnoreCase(paramBaseAdResponse.getAdType()))
          a(((RTBVASTAdResponse)paramBaseAdResponse).getNotifyUrl(), Clog.getString(R.string.notify_url));
        a(localAdView, paramBaseAdResponse);
        return;
      }
      Clog.e(Clog.baseLogTag, "handleRTBResponse failed:: invalid adType::" + paramBaseAdResponse.getAdType());
      continueWaterfall(ResultCode.INTERNAL_ERROR);
      return;
    }
    continueWaterfall(ResultCode.UNABLE_TO_FILL);
  }

  private void c()
  {
    b localb = (b)this.f.get();
    BaseAdResponse localBaseAdResponse;
    if ((localb != null) && (getAdList() != null) && (!getAdList().isEmpty()))
    {
      localBaseAdResponse = b();
      if ("rtb".equalsIgnoreCase(localBaseAdResponse.getContentSource()))
        b(localb, localBaseAdResponse);
    }
    else
    {
      return;
    }
    if ("csm".equalsIgnoreCase(localBaseAdResponse.getContentSource()))
    {
      a(localb, (CSMSDKAdResponse)localBaseAdResponse);
      return;
    }
    if ("ssm".equalsIgnoreCase(localBaseAdResponse.getContentSource()))
    {
      a((AdView)localb, (SSMHTMLAdResponse)localBaseAdResponse);
      return;
    }
    Clog.e(Clog.baseLogTag, "processNextAd failed:: invalid content source:: " + localBaseAdResponse.getContentSource());
    continueWaterfall(ResultCode.INTERNAL_ERROR);
  }

  public void cancel()
  {
    if (this.a != null)
    {
      this.a.cancel(true);
      this.a = null;
    }
    a(null);
    if (this.c != null)
    {
      this.c.a(true);
      this.c = null;
    }
    if (this.e != null)
    {
      this.e.a(true);
      this.e = null;
    }
    if (this.d != null)
      this.d = null;
    if (this.f != null)
      this.f.clear();
  }

  public void continueWaterfall(ResultCode paramResultCode)
  {
    Clog.d(Clog.baseLogTag, "Waterfall continueWaterfall");
    if ((getAdList() == null) || (getAdList().isEmpty()))
    {
      failed(paramResultCode);
      return;
    }
    c();
  }

  public void failed(ResultCode paramResultCode)
  {
    a();
    Clog.e("AdViewRequestManager", paramResultCode.name());
    b localb = (b)this.f.get();
    a(this.b, Clog.getString(R.string.no_ad_url));
    if (localb != null)
      localb.getAdDispatcher().a(paramResultCode);
  }

  public UTRequestParameters getRequestParams()
  {
    b localb = (b)this.f.get();
    if (localb != null)
      return localb.getRequestParameters();
    return null;
  }

  public void onReceiveAd(AdResponse paramAdResponse)
  {
    a();
    if (this.c != null)
      this.c = null;
    if (this.e != null)
      this.e = null;
    if (this.d != null)
      this.d = null;
    b localb = (b)this.f.get();
    if (localb != null)
    {
      localb.getAdDispatcher().a(paramAdResponse);
      return;
    }
    paramAdResponse.destroy();
  }

  public void onReceiveUTResponse(UTAdResponse paramUTAdResponse)
  {
    super.onReceiveUTResponse(paramUTAdResponse);
    Clog.e("AdViewRequestManager", "onReceiveUTResponse");
    if (((b)this.f.get() != null) && (a(paramUTAdResponse)))
    {
      a(paramUTAdResponse.getAdList());
      c();
      return;
    }
    Clog.w(Clog.httpRespLogTag, Clog.getString(R.string.response_no_ads));
    failed(ResultCode.UNABLE_TO_FILL);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.e
 * JD-Core Version:    0.6.2
 */