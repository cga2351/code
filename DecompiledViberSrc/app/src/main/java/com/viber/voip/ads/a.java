package com.viber.voip.ads;

import android.net.Uri;
import com.appnexus.opensdk.AdListener;
import com.appnexus.opensdk.AdView;
import com.appnexus.opensdk.NativeAdResponse;
import com.appnexus.opensdk.ResultCode;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.da;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.h.a;

class a
  implements AdListener
{
  private static final com.viber.common.a.e a = ViberEnv.getLogger("AdListenerWithImageLoad");
  private com.viber.voip.util.e.e b;
  private f c;
  private final AdListener d;
  private h.a e;

  public a(com.viber.voip.util.e.e parame, f paramf, AdListener paramAdListener)
  {
    this.b = parame;
    this.c = paramf;
    this.d = paramAdListener;
  }

  public void onAdClicked(AdView paramAdView)
  {
    this.d.onAdClicked(paramAdView);
  }

  public void onAdClicked(AdView paramAdView, String paramString)
  {
    this.d.onAdClicked(paramAdView, paramString);
  }

  public void onAdCollapsed(AdView paramAdView)
  {
    this.d.onAdCollapsed(paramAdView);
  }

  public void onAdExpanded(AdView paramAdView)
  {
    this.d.onAdExpanded(paramAdView);
  }

  public void onAdLoaded(AdView paramAdView)
  {
    this.d.onAdLoaded(paramAdView);
  }

  public void onAdLoaded(NativeAdResponse paramNativeAdResponse)
  {
    try
    {
      if (paramNativeAdResponse.getImage() == null)
      {
        String str = paramNativeAdResponse.getImageUrl();
        if (!da.b(str))
        {
          Uri localUri = Uri.parse(str);
          this.e = new b(this, paramNativeAdResponse);
          this.b.a(localUri, this.c, this.e);
          return;
        }
        this.d.onAdLoaded(paramNativeAdResponse);
        return;
      }
    }
    catch (Exception localException)
    {
      this.d.onAdLoaded(paramNativeAdResponse);
      return;
    }
    this.d.onAdLoaded(paramNativeAdResponse);
  }

  public void onAdRequestFailed(AdView paramAdView, ResultCode paramResultCode)
  {
    this.d.onAdRequestFailed(paramAdView, paramResultCode);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.a
 * JD-Core Version:    0.6.2
 */