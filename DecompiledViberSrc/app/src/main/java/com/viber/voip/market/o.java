package com.viber.voip.market;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.util.Pair;
import android.webkit.CookieSyncManager;
import com.appnexus.opensdk.ANClickThroughAction;
import com.appnexus.opensdk.AdListener;
import com.appnexus.opensdk.AdView;
import com.appnexus.opensdk.NativeAdResponse;
import com.appnexus.opensdk.ResultCode;
import com.appnexus.opensdk.SDKSettings;
import com.appnexus.opensdk.ViberBannerAdView;
import com.appnexus.opensdk.mediatednativead.AdMobNativeSettings;
import com.appnexus.opensdk.utils.Settings;
import com.viber.common.b.b;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.cdr.CdrConst.AdTypes;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.dialer.DialerControllerDelegate.DialerLocalCallState;
import com.viber.jni.dialer.DialerLocalCallStateListener;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.h;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.orm.entity.json.action.OpenUrlAction;
import com.viber.voip.settings.d.f;
import com.viber.voip.util.ax;
import com.viber.voip.util.d.b;
import com.viber.voip.util.dx;
import com.viber.voip.util.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class o
  implements d.b
{
  private static final Logger a = ViberEnv.getLogger();
  private static final long b = TimeUnit.SECONDS.toMillis(6L);
  private static final long c = TimeUnit.MINUTES.toMillis(2L);
  private static volatile o p;
  private a d;
  private a e;
  private h f;
  private Set<b> g = new HashSet();
  private final Map<String, Boolean> h = new ConcurrentHashMap();
  private final Object i = new Object();
  private final c j;
  private String k;
  private AdView l;
  private Handler m;
  private Engine n;
  private final DialerControllerDelegate.DialerLocalCallState o = new DialerControllerDelegate.DialerLocalCallState()
  {
    public void onCallEnded(long paramAnonymousLong, boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
    {
    }

    public void onCallStarted(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, int paramAnonymousInt)
    {
      o.a(o.this).post(new q(this));
    }

    public void onHangup()
    {
    }
  };

  private o(Context paramContext, Handler paramHandler, PhoneController paramPhoneController)
  {
    this.m = paramHandler;
    this.j = c.a(ViberApplication.getApplication());
    SDKSettings.useHttps(true);
    AdMobNativeSettings.setEnableAppInstallAd(true);
    AdMobNativeSettings.setEnableContentAd(true);
    if (!com.viber.common.d.a.g())
      CookieSyncManager.createInstance(paramContext);
    com.viber.voip.util.d.b(this, this.m);
    this.n = ViberApplication.getInstance().getEngine(false);
    ICdrController localICdrController = this.n.getCdrController();
    Handler localHandler = av.e.g.a();
    Settings.getSettings().getClass();
    this.f = new h(paramContext, paramPhoneController, localICdrController, 3, localHandler, "4.11.2");
    this.d = new a(new o.a.a()
    {
      public void a()
      {
        o.b(o.this);
        o.c(o.this).b();
      }

      public void a(long paramAnonymousLong)
      {
        o.a(o.this, paramAnonymousLong);
      }
    }
    , b);
    this.e = new a(new o.a.a()
    {
      public void a()
      {
        o.this.a(true);
      }

      public void a(long paramAnonymousLong)
      {
      }
    }
    , c);
  }

  @Deprecated
  public static o a(Context paramContext, Handler paramHandler, PhoneController paramPhoneController)
  {
    if (p == null)
      p = new o(paramContext, paramHandler, paramPhoneController);
    return p;
  }

  private void a(long paramLong)
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a(paramLong);
  }

  private void a(AdView paramAdView, String paramString, int paramInt)
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a(paramAdView, paramString, paramInt);
  }

  private void b(String paramString)
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a(paramString);
  }

  private boolean b(AdView paramAdView)
  {
    synchronized (this.h)
    {
      Iterator localIterator = this.h.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str = (String)paramAdView.getTag();
        if ((((String)localEntry.getKey()).equals(str)) && (((Boolean)localEntry.getValue()).booleanValue()))
        {
          this.h.remove(paramAdView.getTag());
          return true;
        }
        this.h.remove(paramAdView.getTag());
      }
    }
    return false;
  }

  private void c()
  {
    DialerLocalCallStateListener localDialerLocalCallStateListener = this.n.getDelegatesManager().getDialerLocalCallStateListener();
    DialerControllerDelegate.DialerLocalCallState[] arrayOfDialerLocalCallState = new DialerControllerDelegate.DialerLocalCallState[1];
    arrayOfDialerLocalCallState[0] = this.o;
    localDialerLocalCallStateListener.registerDelegate(arrayOfDialerLocalCallState);
  }

  private void c(AdView paramAdView)
  {
    ICdrController localICdrController = this.n.getCdrController();
    long l1 = this.n.getPhoneController().generateSequence();
    String str1 = paramAdView.getCreativeId();
    int i1 = CdrConst.AdTypes.fromAdType("video");
    String str2 = paramAdView.getPlacementID();
    Settings.getSettings().getClass();
    localICdrController.handleReportVideoAdClick(l1, 1, str1, "", i1, 3, "", str2, "4.11.2");
  }

  private void d()
  {
    this.n.getDelegatesManager().getDialerLocalCallStateListener().removeDelegate(this.o);
  }

  private void e()
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a();
  }

  public void a(final Context paramContext, String paramString1, final String paramString2, Map<String, String> paramMap)
  {
    this.h.put(paramString2, Boolean.valueOf(false));
    int i1 = CdrConst.AdTypes.fromAdType("video");
    this.f.a(i1);
    this.f.a(paramString1);
    com.viber.voip.util.k.a.a(this.j);
    ViberBannerAdView localViberBannerAdView = new ViberBannerAdView(paramContext);
    localViberBannerAdView.setAutoRefreshInterval(0);
    localViberBannerAdView.setClickThroughAction(ANClickThroughAction.OPEN_DEVICE_BROWSER);
    localViberBannerAdView.setPlacementID(paramString1);
    localViberBannerAdView.setAdSize(300, 250);
    localViberBannerAdView.setAllowVideoDemand(true);
    localViberBannerAdView.addCustomKeywords("viber_version", com.viber.voip.p.d());
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localViberBannerAdView.addCustomKeywords((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    localViberBannerAdView.setGender(com.viber.voip.ads.a.d.values()[com.viber.voip.settings.d.c.a.d()].toAppNexusGender());
    localViberBannerAdView.setTag(paramString2);
    if (d.f.d.d())
      localViberBannerAdView.addCustomKeywords("advertising_id", ax.a());
    localViberBannerAdView.setAdListener(new AdListener()
    {
      public void onAdClicked(AdView paramAnonymousAdView)
      {
        o.b(o.this, paramAnonymousAdView);
        o.this.a(true);
      }

      public void onAdClicked(AdView paramAnonymousAdView, String paramAnonymousString)
      {
      }

      public void onAdCollapsed(AdView paramAnonymousAdView)
      {
      }

      public void onAdExpanded(AdView paramAnonymousAdView)
      {
      }

      public void onAdLoaded(AdView paramAnonymousAdView)
      {
        if (o.a(o.this, paramAnonymousAdView))
          return;
        synchronized (o.e(o.this))
        {
          o.a(o.this, (String)paramAnonymousAdView.getTag());
          o.a(o.this, paramAnonymousAdView, paramString2, 0);
          o.c(o.this).a();
          o.f(o.this).a();
          o.d(o.this).b(0);
          o.d(o.this).a(101, 6);
          return;
        }
      }

      public void onAdLoaded(NativeAdResponse paramAnonymousNativeAdResponse)
      {
      }

      public void onAdRequestFailed(AdView paramAnonymousAdView, ResultCode paramAnonymousResultCode)
      {
        if (o.a(o.this, paramAnonymousAdView))
          return;
        if (paramAnonymousResultCode == null);
        Pair localPair = com.viber.voip.util.k.a.a(paramAnonymousResultCode);
        o.d(o.this).b(0);
        o.d(o.this).a(((Integer)localPair.first).intValue(), 6);
        o.a(o.this, paramAnonymousAdView, paramString2, ((Integer)localPair.first).intValue());
      }
    });
    Handler localHandler = av.a(av.e.e);
    localViberBannerAdView.getClass();
    localHandler.post(p.a(localViberBannerAdView));
    if (this.l != null)
    {
      this.l.destroy();
      this.l = null;
    }
    this.l = localViberBannerAdView;
  }

  public void a(AdView paramAdView)
  {
    ICdrController localICdrController = this.n.getCdrController();
    long l1 = this.n.getPhoneController().generateSequence();
    String str1 = paramAdView.getCreativeId();
    int i1 = CdrConst.AdTypes.fromAdType("video");
    String str2 = paramAdView.getPlacementID();
    Settings.getSettings().getClass();
    localICdrController.handleReportVideoAdDisplay(l1, str1, "", i1, 0, 3, "", str2, "4.11.2");
  }

  public void a(b paramb)
  {
    c();
    this.g.add(paramb);
  }

  public void a(String paramString)
  {
    synchronized (this.h)
    {
      Iterator localIterator = this.h.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.equals(paramString))
          this.h.put(str, Boolean.valueOf(true));
      }
    }
  }

  public void a(boolean paramBoolean)
  {
    if (this.l != null)
    {
      this.l.destroy();
      this.l = null;
    }
    synchronized (this.i)
    {
      if (this.k != null)
      {
        b(this.k);
        this.k = null;
      }
      if ((paramBoolean) && (this.d != null))
        this.d.b();
      if (this.e != null)
        this.e.b();
      return;
    }
  }

  public boolean a()
  {
    while (true)
    {
      synchronized (this.i)
      {
        if (this.k != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  @SuppressLint({"WrongConstant"})
  public void b()
  {
    if (this.l != null)
    {
      new OpenUrlAction(dx.a(this.l.getContext(), (String[])this.l.getImpressionUrls().toArray(new String[this.l.getImpressionUrls().size()]), this.l.getCreativeId(), "AppNexus", "", this.l.getPlacementID(), -1).toString()).execute(this.l.getContext(), null);
      a(true);
    }
  }

  public void b(b paramb)
  {
    d();
    this.g.remove(paramb);
  }

  public void onAppStopped()
  {
    i.c(this);
  }

  public void onBackground()
  {
    a(true);
  }

  public void onForeground()
  {
    i.b(this);
  }

  public void onForegroundStateChanged(boolean paramBoolean)
  {
    i.a(this, paramBoolean);
  }

  private static class a
  {
    private a a;
    private CountDownTimer b;
    private long c;

    a(a parama, long paramLong)
    {
      this.a = parama;
      this.c = paramLong;
    }

    void a()
    {
      this.b = new CountDownTimer(200L + this.c, TimeUnit.SECONDS.toMillis(1L))
      {
        public void onFinish()
        {
          o.a.a(o.a.this).a();
        }

        public void onTick(long paramAnonymousLong)
        {
          o.a.a(o.a.this).a(paramAnonymousLong);
        }
      };
      this.b.start();
    }

    void b()
    {
      if (this.b != null)
      {
        this.b.cancel();
        this.b = null;
      }
    }

    public static abstract interface a
    {
      public abstract void a();

      public abstract void a(long paramLong);
    }
  }

  public static abstract interface b
  {
    public abstract void a();

    public abstract void a(long paramLong);

    public abstract void a(AdView paramAdView, String paramString, int paramInt);

    public abstract void a(String paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.o
 * JD-Core Version:    0.6.2
 */