package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.mopub.common.AdReport;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.ReflectionTarget;
import com.mopub.mobileads.factories.CustomEventBannerFactory;
import java.util.Map;
import java.util.TreeMap;

public class CustomEventBannerAdapter
  implements InternalCustomEventBannerListener
{
  public static final int DEFAULT_BANNER_TIMEOUT_DELAY = 10000;
  private boolean a;
  private MoPubView b;
  private Context c;
  private CustomEventBanner d;
  private Map<String, Object> e;
  private Map<String, String> f;
  private final Handler g;
  private final Runnable h;
  private int i = -2147483648;
  private int j = -2147483648;
  private boolean k = false;
  private b l;

  public CustomEventBannerAdapter(MoPubView paramMoPubView, String paramString, Map<String, String> paramMap, long paramLong, AdReport paramAdReport)
  {
    Preconditions.checkNotNull(paramMap);
    this.g = new Handler();
    this.b = paramMoPubView;
    this.c = paramMoPubView.getContext();
    this.h = new Runnable()
    {
      public void run()
      {
        MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = ("CustomEventBannerAdapter failed with code " + MoPubErrorCode.NETWORK_TIMEOUT.getIntCode() + " and message " + MoPubErrorCode.NETWORK_TIMEOUT);
        MoPubLog.log(localSdkLogEvent, arrayOfObject);
        CustomEventBannerAdapter.this.onBannerFailed(MoPubErrorCode.NETWORK_TIMEOUT);
        CustomEventBannerAdapter.this.invalidate();
      }
    };
    MoPubLog.SdkLogEvent localSdkLogEvent1 = MoPubLog.SdkLogEvent.CUSTOM;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = ("Attempting to invoke custom event: " + paramString);
    MoPubLog.log(localSdkLogEvent1, arrayOfObject1);
    try
    {
      this.d = CustomEventBannerFactory.create(paramString);
      this.f = new TreeMap(paramMap);
      d();
      this.e = this.b.getLocalExtras();
      if (this.b.getLocation() != null)
        this.e.put("location", this.b.getLocation());
      this.e.put("broadcastIdentifier", Long.valueOf(paramLong));
      this.e.put("mopub-intent-ad-report", paramAdReport);
      this.e.put("com_mopub_ad_width", Integer.valueOf(this.b.getAdWidth()));
      this.e.put("com_mopub_ad_height", Integer.valueOf(this.b.getAdHeight()));
      this.e.put("banner-impression-pixel-count-enabled", Boolean.valueOf(this.k));
      return;
    }
    catch (Exception localException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent2 = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = ("Couldn't locate or instantiate custom event: " + paramString + ".");
      MoPubLog.log(localSdkLogEvent2, arrayOfObject2);
      this.b.a(MoPubErrorCode.ADAPTER_NOT_FOUND);
    }
  }

  private void b()
  {
    this.g.removeCallbacks(this.h);
  }

  private int c()
  {
    if (this.b == null)
      return 10000;
    return this.b.a(10000).intValue();
  }

  private void d()
  {
    String str1 = (String)this.f.get("banner-impression-min-pixels");
    String str2 = (String)this.f.get("banner-impression-min-ms");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)));
    try
    {
      this.i = Integer.parseInt(str1);
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        while (true)
        {
          this.j = Integer.parseInt(str2);
          if ((this.i > 0) && (this.j >= 0))
            this.k = true;
          return;
          localNumberFormatException1 = localNumberFormatException1;
          MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Cannot parse integer from header banner-impression-min-pixels" });
        }
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        while (true)
          MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Cannot parse integer from header banner-impression-min-ms" });
      }
    }
  }

  boolean a()
  {
    return this.a;
  }

  @ReflectionTarget
  void invalidate()
  {
    if (this.d != null);
    try
    {
      this.d.a();
      if (this.l == null);
    }
    catch (Exception localException2)
    {
      try
      {
        this.l.a();
        this.l = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.a = true;
        return;
        localException2 = localException2;
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM_WITH_THROWABLE, new Object[] { "Invalidating a custom event banner threw an exception", localException2 });
      }
      catch (Exception localException1)
      {
        while (true)
          MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM_WITH_THROWABLE, new Object[] { "Destroying a banner visibility tracker threw an exception", localException1 });
      }
    }
  }

  @ReflectionTarget
  void loadAd()
  {
    if ((a()) || (this.d == null))
      return;
    this.g.postDelayed(this.h, c());
    try
    {
      this.d.a(this.c, this, this.e, this.f);
      return;
    }
    catch (Exception localException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = ("loadAd() failed with code " + MoPubErrorCode.INTERNAL_ERROR.getIntCode() + " and message " + MoPubErrorCode.INTERNAL_ERROR);
      MoPubLog.log(localSdkLogEvent, arrayOfObject);
      onBannerFailed(MoPubErrorCode.INTERNAL_ERROR);
    }
  }

  public void onBannerClicked()
  {
    if (a());
    while (this.b == null)
      return;
    this.b.a();
  }

  public void onBannerCollapsed()
  {
    if (a())
      return;
    this.b.k();
    this.b.e();
  }

  public void onBannerExpanded()
  {
    if (a())
      return;
    this.b.j();
    this.b.d();
  }

  public void onBannerFailed(MoPubErrorCode paramMoPubErrorCode)
  {
    if (a());
    do
    {
      return;
      b();
    }
    while (this.b == null);
    if (paramMoPubErrorCode == null)
      paramMoPubErrorCode = MoPubErrorCode.UNSPECIFIED;
    this.b.a(paramMoPubErrorCode);
  }

  public void onBannerImpression()
  {
    if (a());
    do
    {
      do
        return;
      while ((this.b == null) || (this.d == null) || (this.d.c()));
      this.b.b();
    }
    while (!this.k);
    this.d.b();
  }

  public void onBannerLoaded(View paramView)
  {
    if (a())
      return;
    MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "onBannerLoaded() success. Attempting to show." });
    b();
    if (this.b != null)
    {
      this.b.g();
      if ((this.k) && (this.d != null) && (this.d.c()))
      {
        this.b.h();
        this.l = new b(this.c, this.b, paramView, this.i, this.j);
        this.l.a(new b.c()
        {
          public void onVisibilityChanged()
          {
            CustomEventBannerAdapter.a(CustomEventBannerAdapter.this).b();
            if (CustomEventBannerAdapter.b(CustomEventBannerAdapter.this) != null)
              CustomEventBannerAdapter.b(CustomEventBannerAdapter.this).b();
            CustomEventBannerAdapter.a(CustomEventBannerAdapter.this).i();
          }
        });
      }
      this.b.setAdContentView(paramView);
      if ((!this.k) && (this.d != null) && (this.d.c()) && (!(paramView instanceof HtmlBannerWebView)))
        this.b.b();
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "onBannerLoaded() - Show successful." });
      return;
    }
    MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = ("onBannerLoaded() - Show failed with code " + MoPubErrorCode.INTERNAL_ERROR.getIntCode() + " and message " + MoPubErrorCode.INTERNAL_ERROR);
    MoPubLog.log(localSdkLogEvent, arrayOfObject);
  }

  public void onLeaveApplication()
  {
    onBannerClicked();
  }

  public void onPauseAutoRefresh()
  {
    if (this.b != null)
      this.b.j();
  }

  public void onResumeAutoRefresh()
  {
    if (this.b != null)
      this.b.k();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.CustomEventBannerAdapter
 * JD-Core Version:    0.6.2
 */