package com.mopub.mobileads;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.mopub.common.AdFormat;
import com.mopub.common.AdReport;
import com.mopub.common.MoPub;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.ManifestUtils;
import com.mopub.common.util.Reflection;
import com.mopub.common.util.Reflection.MethodBuilder;
import com.mopub.common.util.Visibility;
import com.mopub.mobileads.factories.AdViewControllerFactory;
import java.util.Map;
import java.util.TreeMap;

public class MoPubView extends FrameLayout
{
  protected AdViewController a;
  protected Object b;
  private Context c;
  private int d;
  private BroadcastReceiver e;
  private BannerAdListener f;

  public MoPubView(Context paramContext)
  {
    this(paramContext, null);
  }

  public MoPubView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ManifestUtils.checkWebViewActivitiesDeclared(paramContext);
    this.c = paramContext;
    this.d = getVisibility();
    setHorizontalScrollBarEnabled(false);
    setVerticalScrollBarEnabled(false);
    this.a = AdViewControllerFactory.create(paramContext, this);
    l();
  }

  private void l()
  {
    this.e = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        if ((!Visibility.isScreenVisible(MoPubView.a(MoPubView.this))) || (paramAnonymousIntent == null));
        String str;
        do
        {
          return;
          str = paramAnonymousIntent.getAction();
          if ("android.intent.action.USER_PRESENT".equals(str))
          {
            MoPubView.a(MoPubView.this, 0);
            return;
          }
        }
        while (!"android.intent.action.SCREEN_OFF".equals(str));
        MoPubView.a(MoPubView.this, 8);
      }
    };
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    this.c.registerReceiver(this.e, localIntentFilter);
  }

  private void m()
  {
    try
    {
      this.c.unregisterReceiver(this.e);
      return;
    }
    catch (Exception localException)
    {
      MoPubLog.log(MoPubLog.AdLogEvent.CUSTOM, new Object[] { "Failed to unregister screen state broadcast receiver (never registered)." });
    }
  }

  private void n()
  {
    if (this.b != null);
    try
    {
      new Reflection.MethodBuilder(this.b, "invalidate").setAccessible().execute();
      return;
    }
    catch (Exception localException)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.ERROR, new Object[] { "Error invalidating adapter", localException });
    }
  }

  private void setAdVisibility(int paramInt)
  {
    if (this.a == null)
      return;
    if (Visibility.isScreenVisible(paramInt))
    {
      this.a.d();
      return;
    }
    this.a.c();
  }

  Integer a(int paramInt)
  {
    if (this.a == null)
      return Integer.valueOf(paramInt);
    return this.a.a(paramInt);
  }

  protected void a()
  {
    if (this.a != null)
    {
      this.a.i();
      f();
    }
  }

  protected void a(String paramString, Map<String, String> paramMap)
  {
    if (this.a == null)
      return;
    if (TextUtils.isEmpty(paramString))
    {
      MoPubLog.log(MoPubLog.AdLogEvent.CUSTOM, new Object[] { "Couldn't invoke custom event because the server did not specify one." });
      a(MoPubErrorCode.ADAPTER_NOT_FOUND);
      return;
    }
    if (this.b != null)
      n();
    MoPubLog.log(MoPubLog.AdLogEvent.CUSTOM, new Object[] { "Loading custom event adapter." });
    if (Reflection.classFound("com.mopub.mobileads.factories.CustomEventBannerAdapterFactory"))
      try
      {
        Class localClass = Class.forName("com.mopub.mobileads.factories.CustomEventBannerAdapterFactory");
        this.b = new Reflection.MethodBuilder(null, "create").setStatic(localClass).addParam(MoPubView.class, this).addParam(String.class, paramString).addParam(Map.class, paramMap).addParam(Long.TYPE, Long.valueOf(this.a.getBroadcastIdentifier())).addParam(AdReport.class, this.a.getAdReport()).execute();
        new Reflection.MethodBuilder(this.b, "loadAd").setAccessible().execute();
        return;
      }
      catch (Exception localException)
      {
        MoPubLog.log(MoPubLog.SdkLogEvent.ERROR, new Object[] { "Error loading custom event", localException });
        return;
      }
    MoPubLog.log(MoPubLog.AdLogEvent.CUSTOM, new Object[] { "Could not load custom event -- missing banner module" });
  }

  protected boolean a(MoPubErrorCode paramMoPubErrorCode)
  {
    if (this.a == null)
      return false;
    return this.a.a(paramMoPubErrorCode);
  }

  protected void b()
  {
    MoPubLog.log(MoPubLog.AdLogEvent.CUSTOM, new Object[] { "Tracking impression. MoPubView internal." });
    if (this.a != null)
      this.a.h();
  }

  protected void b(MoPubErrorCode paramMoPubErrorCode)
  {
    MoPubLog.AdLogEvent localAdLogEvent = MoPubLog.AdLogEvent.LOAD_FAILED;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(paramMoPubErrorCode.getIntCode());
    arrayOfObject[1] = paramMoPubErrorCode;
    MoPubLog.log(localAdLogEvent, arrayOfObject);
    if (this.f != null)
      this.f.onBannerFailed(this, paramMoPubErrorCode);
  }

  protected void c()
  {
    MoPubLog.log(MoPubLog.AdLogEvent.LOAD_SUCCESS, new Object[0]);
    if (this.f != null)
      this.f.onBannerLoaded(this);
  }

  protected void d()
  {
    if (this.f != null)
      this.f.onBannerExpanded(this);
  }

  public void destroy()
  {
    MoPubLog.log(MoPubLog.AdLogEvent.CUSTOM, new Object[] { "Destroy() called" });
    m();
    removeAllViews();
    if (this.a != null)
    {
      this.a.g();
      this.a = null;
    }
    if (this.b != null)
    {
      n();
      this.b = null;
    }
  }

  protected void e()
  {
    MoPubLog.log(MoPubLog.AdLogEvent.DID_DISAPPEAR, new Object[0]);
    if (this.f != null)
      this.f.onBannerCollapsed(this);
  }

  protected void f()
  {
    MoPubLog.log(MoPubLog.AdLogEvent.CLICKED, new Object[0]);
    if (this.f != null)
      this.f.onBannerClicked(this);
  }

  public void forceRefresh()
  {
    if (this.b != null)
    {
      n();
      this.b = null;
    }
    if (this.a != null)
      this.a.j();
  }

  protected void g()
  {
    if (this.a != null)
      this.a.b();
    c();
  }

  public Activity getActivity()
  {
    return (Activity)this.c;
  }

  public AdFormat getAdFormat()
  {
    return AdFormat.BANNER;
  }

  public int getAdHeight()
  {
    if (this.a != null)
      return this.a.getAdHeight();
    return 0;
  }

  public String getAdUnitId()
  {
    if (this.a != null)
      return this.a.getAdUnitId();
    return null;
  }

  AdViewController getAdViewController()
  {
    return this.a;
  }

  public int getAdWidth()
  {
    if (this.a != null)
      return this.a.getAdWidth();
    return 0;
  }

  public boolean getAutorefreshEnabled()
  {
    if (this.a != null)
      return this.a.getCurrentAutoRefreshStatus();
    MoPubLog.log(MoPubLog.AdLogEvent.CUSTOM, new Object[] { "Can't get autorefresh status for destroyed MoPubView. Returning false." });
    return false;
  }

  public BannerAdListener getBannerAdListener()
  {
    return this.f;
  }

  @Deprecated
  public String getClickTrackingUrl()
  {
    return null;
  }

  public String getKeywords()
  {
    if (this.a != null)
      return this.a.getKeywords();
    return null;
  }

  public Map<String, Object> getLocalExtras()
  {
    if (this.a != null)
      return this.a.m();
    return new TreeMap();
  }

  public Location getLocation()
  {
    if ((this.a != null) && (MoPub.canCollectPersonalInformation()))
      return this.a.getLocation();
    return null;
  }

  @Deprecated
  public String getResponseString()
  {
    return null;
  }

  public boolean getTesting()
  {
    if (this.a != null)
      return this.a.getTesting();
    MoPubLog.log(MoPubLog.AdLogEvent.CUSTOM, new Object[] { "Can't get testing status for destroyed MoPubView. Returning false." });
    return false;
  }

  public String getUserDataKeywords()
  {
    if ((this.a != null) && (MoPub.canCollectPersonalInformation()))
      return this.a.getUserDataKeywords();
    return null;
  }

  void h()
  {
    if (this.a != null)
      this.a.c();
  }

  void i()
  {
    if (this.a != null)
      this.a.d();
  }

  void j()
  {
    if (this.a != null)
      this.a.e();
  }

  void k()
  {
    if (this.a != null)
      this.a.f();
  }

  public void loadAd()
  {
    if (this.a != null)
    {
      MoPubLog.log(MoPubLog.AdLogEvent.LOAD_ATTEMPTED, new Object[0]);
      this.a.loadAd();
    }
  }

  protected void onWindowVisibilityChanged(int paramInt)
  {
    if (Visibility.hasScreenVisibilityChanged(this.d, paramInt))
    {
      this.d = paramInt;
      setAdVisibility(this.d);
    }
  }

  public void setAdContentView(View paramView)
  {
    MoPubLog.log(MoPubLog.AdLogEvent.SHOW_ATTEMPTED, new Object[0]);
    if (this.a != null)
    {
      this.a.a(paramView);
      MoPubLog.log(MoPubLog.AdLogEvent.SHOW_SUCCESS, new Object[0]);
      return;
    }
    MoPubLog.log(MoPubLog.AdLogEvent.SHOW_FAILED, new Object[0]);
  }

  public void setAdUnitId(String paramString)
  {
    if (this.a != null)
      this.a.setAdUnitId(paramString);
  }

  public void setAutorefreshEnabled(boolean paramBoolean)
  {
    if (this.a != null)
      this.a.a(paramBoolean);
  }

  public void setBannerAdListener(BannerAdListener paramBannerAdListener)
  {
    this.f = paramBannerAdListener;
  }

  public void setKeywords(String paramString)
  {
    if (this.a != null)
      this.a.setKeywords(paramString);
  }

  public void setLocalExtras(Map<String, Object> paramMap)
  {
    if (this.a != null)
      this.a.a(paramMap);
  }

  public void setLocation(Location paramLocation)
  {
    if ((this.a != null) && (MoPub.canCollectPersonalInformation()))
      this.a.setLocation(paramLocation);
  }

  public void setTesting(boolean paramBoolean)
  {
    if (this.a != null)
      this.a.setTesting(paramBoolean);
  }

  @Deprecated
  public void setTimeout(int paramInt)
  {
  }

  public void setUserDataKeywords(String paramString)
  {
    if ((this.a != null) && (MoPub.canCollectPersonalInformation()))
      this.a.setUserDataKeywords(paramString);
  }

  public static abstract interface BannerAdListener
  {
    public abstract void onBannerClicked(MoPubView paramMoPubView);

    public abstract void onBannerCollapsed(MoPubView paramMoPubView);

    public abstract void onBannerExpanded(MoPubView paramMoPubView);

    public abstract void onBannerFailed(MoPubView paramMoPubView, MoPubErrorCode paramMoPubErrorCode);

    public abstract void onBannerLoaded(MoPubView paramMoPubView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.MoPubView
 * JD-Core Version:    0.6.2
 */