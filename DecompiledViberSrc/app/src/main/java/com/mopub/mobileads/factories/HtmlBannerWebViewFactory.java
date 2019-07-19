package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.common.AdReport;
import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;
import com.mopub.mobileads.HtmlBannerWebView;

public class HtmlBannerWebViewFactory
{
  protected static HtmlBannerWebViewFactory a = new HtmlBannerWebViewFactory();

  public static HtmlBannerWebView create(Context paramContext, AdReport paramAdReport, CustomEventBanner.CustomEventBannerListener paramCustomEventBannerListener, String paramString)
  {
    return a.internalCreate(paramContext, paramAdReport, paramCustomEventBannerListener, paramString);
  }

  @Deprecated
  public static void setInstance(HtmlBannerWebViewFactory paramHtmlBannerWebViewFactory)
  {
    a = paramHtmlBannerWebViewFactory;
  }

  public HtmlBannerWebView internalCreate(Context paramContext, AdReport paramAdReport, CustomEventBanner.CustomEventBannerListener paramCustomEventBannerListener, String paramString)
  {
    HtmlBannerWebView localHtmlBannerWebView = new HtmlBannerWebView(paramContext, paramAdReport);
    localHtmlBannerWebView.init(paramCustomEventBannerListener, paramString, paramAdReport.getDspCreativeId());
    return localHtmlBannerWebView;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.factories.HtmlBannerWebViewFactory
 * JD-Core Version:    0.6.2
 */