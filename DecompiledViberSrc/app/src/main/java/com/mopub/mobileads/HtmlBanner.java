package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import com.mopub.common.AdReport;
import com.mopub.common.ExternalViewabilitySessionManager;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.common.util.JavaScriptWebViewCallbacks;
import com.mopub.mobileads.factories.HtmlBannerWebViewFactory;
import java.lang.ref.WeakReference;
import java.util.Map;

public class HtmlBanner extends CustomEventBanner
{
  public static final String ADAPTER_NAME = HtmlBanner.class.getSimpleName();
  private HtmlBannerWebView a;
  private ExternalViewabilitySessionManager b;
  private boolean c = false;
  private WeakReference<Activity> d;

  private boolean a(Map<String, String> paramMap)
  {
    return paramMap.containsKey("html-response-body");
  }

  protected void a()
  {
    if (this.b != null)
    {
      this.b.endDisplaySession();
      this.b = null;
    }
    if (this.a != null)
    {
      this.a.destroy();
      this.a = null;
    }
  }

  protected void a(Context paramContext, CustomEventBanner.CustomEventBannerListener paramCustomEventBannerListener, Map<String, Object> paramMap, Map<String, String> paramMap1)
  {
    MoPubLog.AdapterLogEvent localAdapterLogEvent1 = MoPubLog.AdapterLogEvent.LOAD_ATTEMPTED;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = ADAPTER_NAME;
    MoPubLog.log(localAdapterLogEvent1, arrayOfObject1);
    Object localObject = paramMap.get("banner-impression-pixel-count-enabled");
    if ((localObject instanceof Boolean))
      this.c = ((Boolean)localObject).booleanValue();
    String str1;
    String str2;
    if (a(paramMap1))
    {
      str1 = (String)paramMap1.get("html-response-body");
      str2 = (String)paramMap1.get("clickthrough-url");
    }
    while (true)
    {
      try
      {
        AdReport localAdReport = (AdReport)paramMap.get("mopub-intent-ad-report");
        this.a = HtmlBannerWebViewFactory.create(paramContext, localAdReport, paramCustomEventBannerListener, str2);
        AdViewController.setShouldHonorServerDimensions(this.a);
        MoPubLog.AdapterLogEvent localAdapterLogEvent4 = MoPubLog.AdapterLogEvent.SHOW_ATTEMPTED;
        Object[] arrayOfObject4 = new Object[1];
        arrayOfObject4[0] = ADAPTER_NAME;
        MoPubLog.log(localAdapterLogEvent4, arrayOfObject4);
        if (!(paramContext instanceof Activity))
          break label353;
        Activity localActivity = (Activity)paramContext;
        this.d = new WeakReference(localActivity);
        this.b = new ExternalViewabilitySessionManager(localActivity);
        this.b.createDisplaySession(localActivity, this.a, this.c);
        this.a.a(str1);
        MoPubLog.AdapterLogEvent localAdapterLogEvent6 = MoPubLog.AdapterLogEvent.SHOW_SUCCESS;
        Object[] arrayOfObject6 = new Object[1];
        arrayOfObject6[0] = ADAPTER_NAME;
        MoPubLog.log(localAdapterLogEvent6, arrayOfObject6);
        return;
      }
      catch (ClassCastException localClassCastException)
      {
        MoPubLog.AdapterLogEvent localAdapterLogEvent3 = MoPubLog.AdapterLogEvent.LOAD_FAILED;
        Object[] arrayOfObject3 = new Object[3];
        arrayOfObject3[0] = ADAPTER_NAME;
        arrayOfObject3[1] = Integer.valueOf(MoPubErrorCode.INTERNAL_ERROR.getIntCode());
        arrayOfObject3[2] = MoPubErrorCode.INTERNAL_ERROR;
        MoPubLog.log(localAdapterLogEvent3, arrayOfObject3);
        paramCustomEventBannerListener.onBannerFailed(MoPubErrorCode.INTERNAL_ERROR);
        return;
      }
      MoPubLog.AdapterLogEvent localAdapterLogEvent2 = MoPubLog.AdapterLogEvent.LOAD_FAILED;
      Object[] arrayOfObject2 = new Object[3];
      arrayOfObject2[0] = ADAPTER_NAME;
      arrayOfObject2[1] = Integer.valueOf(MoPubErrorCode.NETWORK_INVALID_STATE.getIntCode());
      arrayOfObject2[2] = MoPubErrorCode.NETWORK_INVALID_STATE;
      MoPubLog.log(localAdapterLogEvent2, arrayOfObject2);
      paramCustomEventBannerListener.onBannerFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
      return;
      label353: MoPubLog.AdapterLogEvent localAdapterLogEvent5 = MoPubLog.AdapterLogEvent.CUSTOM;
      Object[] arrayOfObject5 = new Object[2];
      arrayOfObject5[0] = ADAPTER_NAME;
      arrayOfObject5[1] = "Unable to start viewability session for HTML banner: Context provided was not an Activity.";
      MoPubLog.log(localAdapterLogEvent5, arrayOfObject5);
    }
  }

  protected void b()
  {
    if (this.a == null);
    do
    {
      return;
      this.a.loadUrl(JavaScriptWebViewCallbacks.WEB_VIEW_DID_APPEAR.getUrl());
    }
    while ((!this.c) || (this.b == null) || (this.d == null));
    Activity localActivity = (Activity)this.d.get();
    if (localActivity != null)
    {
      this.b.startDeferredDisplaySession(localActivity);
      return;
    }
    MoPubLog.AdapterLogEvent localAdapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = ADAPTER_NAME;
    arrayOfObject[1] = "Lost the activity for deferred Viewability tracking. Dropping session.";
    MoPubLog.log(localAdapterLogEvent, arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.HtmlBanner
 * JD-Core Version:    0.6.2
 */