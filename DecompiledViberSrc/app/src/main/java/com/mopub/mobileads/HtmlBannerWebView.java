package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.AdReport;

public class HtmlBannerWebView extends BaseHtmlWebView
{
  public static final String EXTRA_AD_CLICK_DATA = "com.mopub.intent.extra.AD_CLICK_DATA";

  public HtmlBannerWebView(Context paramContext, AdReport paramAdReport)
  {
    super(paramContext, paramAdReport);
  }

  public void init(CustomEventBanner.CustomEventBannerListener paramCustomEventBannerListener, String paramString1, String paramString2)
  {
    super.init();
    setWebViewClient(new d(new a(paramCustomEventBannerListener), this, paramString1, paramString2));
  }

  static class a
    implements HtmlWebViewListener
  {
    private final CustomEventBanner.CustomEventBannerListener a;

    public a(CustomEventBanner.CustomEventBannerListener paramCustomEventBannerListener)
    {
      this.a = paramCustomEventBannerListener;
    }

    public void onClicked()
    {
      this.a.onBannerClicked();
    }

    public void onCollapsed()
    {
      this.a.onBannerCollapsed();
    }

    public void onFailed(MoPubErrorCode paramMoPubErrorCode)
    {
      this.a.onBannerFailed(paramMoPubErrorCode);
    }

    public void onLoaded(BaseHtmlWebView paramBaseHtmlWebView)
    {
      this.a.onBannerLoaded(paramBaseHtmlWebView);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.HtmlBannerWebView
 * JD-Core Version:    0.6.2
 */