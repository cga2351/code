package com.viber.voip.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.util.Pair;
import android.webkit.CookieSyncManager;
import com.appnexus.opensdk.NativeAdRequest;
import com.appnexus.opensdk.NativeAdRequestListener;
import com.appnexus.opensdk.NativeAdResponse;
import com.appnexus.opensdk.NativeAdResponse.Network;
import com.appnexus.opensdk.ResultCode;
import com.appnexus.opensdk.SDKSettings;
import com.appnexus.opensdk.mediatednativead.AdMobNativeSettings;
import com.appnexus.opensdk.mediatednativead.AdMobNativeSettings.AdMobNativeType;
import com.appnexus.opensdk.utils.Settings;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdLoader.Builder;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest.Builder;
import com.google.android.gms.ads.formats.NativeAdOptions.Builder;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.viber.common.b.b;
import com.viber.jni.Engine;
import com.viber.jni.cdr.CdrConst.AdTypes;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.b.b.b.c.a;
import com.viber.voip.ads.d.f;
import com.viber.voip.ads.d.f.a;
import com.viber.voip.ads.d.o;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.banner.a.a.g;
import com.viber.voip.banner.datatype.PublicAccountsAdsMetaInfo;
import com.viber.voip.banner.datatype.PublicAccountsAdsMetaInfo.Item;
import com.viber.voip.messages.orm.entity.json.action.OpenUrlAction;
import com.viber.voip.p;
import com.viber.voip.settings.d.al;
import com.viber.voip.settings.d.f;
import com.viber.voip.util.ax;
import com.viber.voip.util.cj;
import com.viber.voip.util.d.b;
import com.viber.voip.util.da;
import com.viber.voip.util.dx;
import com.viber.voip.util.i;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class k
  implements d.b
{
  private static final com.viber.common.a.e c = ViberEnv.getLogger();
  protected com.viber.voip.ads.d.n a;
  protected final c.a b;
  private final ICdrController d;
  private boolean e;
  private boolean f;
  private s g;
  private Map<String, List<Integer>> h;
  private h i;
  private h j;
  private Engine k;
  private Context l;
  private final d.al m;
  private final Handler n;
  private final com.viber.common.permission.c o;
  private final String p;
  private NativeAdRequest q;

  public k(Context paramContext, PhoneController paramPhoneController, ICdrController paramICdrController, Handler paramHandler1, c.a parama, Handler paramHandler2)
  {
    this.l = paramContext;
    this.b = parama;
    this.d = paramICdrController;
    com.viber.voip.util.d.c(this);
    this.h = new HashMap();
    this.g = new t(ViberApplication.getApplication(), av.e.g.a());
    this.n = paramHandler2;
    SDKSettings.useHttps(true);
    Settings.getSettings().getClass();
    this.i = new h(paramContext, paramPhoneController, paramICdrController, 3, paramHandler1, "4.11.2");
    int i1 = CdrConst.AdTypes.fromAdType("Story");
    this.i.a(i1);
    this.p = com.viber.voip.util.k.a.a(com.viber.voip.ads.b.b.b.c.d, true);
    this.i.a(this.p);
    this.j = new h(paramContext, paramPhoneController, paramICdrController, 2, paramHandler1, "");
    this.j.a(i1);
    this.j.a("/65656263/BCI_Native");
    this.k = ViberApplication.getInstance().getEngine(false);
    AdMobNativeSettings.setEnableAppInstallAd(true);
    AdMobNativeSettings.setEnableContentAd(true);
    this.o = com.viber.common.permission.c.a(ViberApplication.getApplication());
    g();
    Handler localHandler = this.n;
    com.viber.common.b.a[] arrayOfa = new com.viber.common.b.a[1];
    arrayOfa[0] = d.f.d;
    this.m = new d.al(localHandler, arrayOfa)
    {
      public void onPreferencesChanged(com.viber.common.b.a paramAnonymousa)
      {
        k.a(k.this);
      }
    };
    com.viber.voip.settings.d.a(this.m);
  }

  private void a(int paramInt1, int paramInt2)
  {
    long l1 = this.k.getPhoneController().generateSequence();
    this.d.handleReportAdsDisplay(l1, "", 1, 0, "", 1, paramInt1, paramInt2, "", "", "", a());
  }

  private void a(com.viber.voip.ads.d.n paramn, int paramInt1, int paramInt2)
  {
    long l1 = this.k.getPhoneController().generateSequence();
    ICdrController localICdrController = this.d;
    String str1 = paramn.b();
    int i1 = paramn.v();
    String str2 = paramn.d();
    int i2 = CdrConst.AdTypes.fromAdType(paramn.c());
    int i3 = paramn.E();
    String str3 = paramn.w();
    String str4 = paramn.D();
    Settings.getSettings().getClass();
    localICdrController.handleReportAdsClick(l1, paramInt1, str1, i1, paramInt2, str2, i2, i3, str3, str4, "4.11.2", a());
  }

  private void c(final n paramn)
  {
    AdMobNativeSettings.setCallScreen(false);
    if (!com.viber.common.d.a.g())
      CookieSyncManager.createInstance(ViberApplication.getApplication());
    com.viber.voip.util.k.a.a(this.o);
    NativeAdRequest localNativeAdRequest = new NativeAdRequest(ViberApplication.getApplication(), this.p);
    this.q = localNativeAdRequest;
    localNativeAdRequest.setOpensNativeBrowser(true);
    localNativeAdRequest.setListener(new NativeAdRequestListener()
    {
      public void onAdFailed(ResultCode paramAnonymousResultCode)
      {
        Pair localPair = com.viber.voip.util.k.a.a(paramAnonymousResultCode);
        int i = ((Integer)localPair.first).intValue();
        ((String)localPair.second);
        k.b(k.this).b(0);
        k.b(k.this).a(i, k.this.a());
        k.a(k.this, true);
        paramn.a();
        k.a(k.this, null);
      }

      public void onAdLoaded(NativeAdResponse paramAnonymousNativeAdResponse)
      {
        if (paramAnonymousNativeAdResponse.getNetworkIdentifier() == NativeAdResponse.Network.ADMOB)
        {
          k.b(k.this).b(1);
          if (paramAnonymousNativeAdResponse.getNativeElements().get(AdMobNativeSettings.NATIVE_ELEMENT_TYPE_KEY) == AdMobNativeSettings.AdMobNativeType.CONTENT_AD)
          {
            NativeContentAd localNativeContentAd = (NativeContentAd)paramAnonymousNativeAdResponse.getNativeElements().get(AdMobNativeSettings.NATIVE_ELEMENT_OBJECT);
            k.this.a = new f(localNativeContentAd, paramAnonymousNativeAdResponse, k.c(k.this));
          }
        }
        while (true)
        {
          k.d(k.this);
          k.b(k.this).a(100, k.this.a());
          paramn.a(k.this.a);
          k.a(k.this, null);
          return;
          NativeAppInstallAd localNativeAppInstallAd = (NativeAppInstallAd)paramAnonymousNativeAdResponse.getNativeElements().get(AdMobNativeSettings.NATIVE_ELEMENT_OBJECT);
          k.this.a = new f(localNativeAppInstallAd, paramAnonymousNativeAdResponse, k.c(k.this));
          continue;
          k.b(k.this).b(0);
          k.this.a = new com.viber.voip.ads.d.l(paramAnonymousNativeAdResponse, k.c(k.this));
        }
      }
    });
    localNativeAdRequest.addCustomKeywords("viber_version", p.d());
    if (d.f.d.d())
      localNativeAdRequest.addCustomKeywords("advertising_id", ax.a());
    localNativeAdRequest.setGender(com.viber.voip.ads.a.d.values()[com.viber.voip.settings.d.c.a.d()].toAppNexusGender());
    Calendar localCalendar = com.viber.voip.util.k.a.b();
    if (localCalendar != null)
      localNativeAdRequest.setAge(String.valueOf(localCalendar.get(1)));
    if (localNativeAdRequest.loadAd());
  }

  private void d(com.viber.voip.ads.d.n paramn, int paramInt)
  {
    long l1 = this.k.getPhoneController().generateSequence();
    ICdrController localICdrController = this.d;
    String str1 = paramn.b();
    int i1 = paramn.v();
    String str2 = paramn.d();
    int i2 = CdrConst.AdTypes.fromAdType(paramn.c());
    int i3 = paramn.E();
    String str3 = paramn.w();
    String str4 = paramn.D();
    Settings.getSettings().getClass();
    localICdrController.handleReportAdsDisplay(l1, str1, i1, paramInt, str2, i2, 0, i3, str3, str4, "4.11.2", a());
  }

  private void d(n paramn)
  {
    q.a locala = new r(ViberApplication.getInstance().getDownloadValve()).a(a(new g(0)));
    if (!da.a(locala.a))
      try
      {
        PublicAccountsAdsMetaInfo localPublicAccountsAdsMetaInfo = com.viber.voip.banner.e.a.d(locala.a);
        if ((localPublicAccountsAdsMetaInfo.items != null) && (localPublicAccountsAdsMetaInfo.items.length > 0))
        {
          PublicAccountsAdsMetaInfo.Item localItem = localPublicAccountsAdsMetaInfo.items[0];
          if (!da.a(localItem.imageUrl))
          {
            String str1 = com.viber.voip.util.e.e.a(Uri.parse(localItem.imageUrl));
            String str2 = localItem.title;
            String str3 = localItem.text;
            if ((!da.a(str1)) && (!da.a(str2)) && (!da.a(str3)))
            {
              this.a = new o(Uri.parse(str1), localItem);
              paramn.a(this.a);
              i();
              return;
            }
          }
        }
        a(1, 1);
        this.f = true;
        paramn.a();
        return;
      }
      catch (Exception localException)
      {
        while (true)
          a(3, 1);
      }
    if (locala.b == 1);
    for (int i1 = 2; ; i1 = 4)
    {
      a(i1, 1);
      break;
    }
  }

  private void e(n paramn)
  {
    AdView localAdView = new AdView(this.l);
    this.a = null;
    localAdView.setAdSize(AdSize.BANNER);
    localAdView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
    localAdView.setAdListener(new a(paramn, "ca-app-pub-3940256099942544/6300978111", new f(localAdView, "ca-app-pub-3940256099942544/6300978111"))
    {
      public void onAdLoaded()
      {
        if (k.this.a != this.a)
        {
          this.c = this.a;
          k.this.a = this.c;
          this.d.a(this.c);
        }
        k.e(k.this).a(100, k.this.a());
      }
    });
    localAdView.loadAd(j());
  }

  private void f(n paramn)
  {
    a locala = new a(paramn, "/65656263/BCI_Native");
    AdLoader.Builder localBuilder = new AdLoader.Builder(this.l, "/65656263/BCI_Native").withAdListener(locala).withNativeAdOptions(new NativeAdOptions.Builder().setReturnUrlsForImageAssets(false).setAdChoicesPlacement(2).build());
    localBuilder.forAppInstallAd(locala);
    localBuilder.forContentAd(locala);
    localBuilder.build().loadAd(k());
  }

  private void g()
  {
    SDKSettings.setAAIDEnabled(d.f.d.d());
  }

  private boolean h()
  {
    return false;
  }

  private void i()
  {
    f();
    this.g.a(this.a.p());
  }

  private AdRequest j()
  {
    AdRequest.Builder localBuilder = new AdRequest.Builder();
    com.viber.voip.util.k.a.a(com.viber.common.permission.c.a(ViberApplication.getApplication()), localBuilder);
    Calendar localCalendar = com.viber.voip.util.k.a.b();
    if (localCalendar != null)
      localBuilder.setBirthday(localCalendar.getTime());
    localBuilder.setGender(com.viber.voip.ads.a.d.values()[com.viber.voip.settings.d.c.a.d()].toAdmobGender());
    return localBuilder.build();
  }

  private PublisherAdRequest k()
  {
    Map localMap = com.viber.voip.util.k.a.b(this.l);
    PublisherAdRequest.Builder localBuilder = new PublisherAdRequest.Builder();
    com.viber.voip.util.k.a.a(com.viber.common.permission.c.a(ViberApplication.getApplication()), localBuilder);
    Calendar localCalendar = com.viber.voip.util.k.a.b();
    if (localCalendar != null)
      localBuilder.setBirthday(localCalendar.getTime());
    localBuilder.setGender(com.viber.voip.ads.a.d.values()[com.viber.voip.settings.d.c.a.d()].toAdmobGender());
    if (localMap != null)
    {
      Iterator localIterator = localMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localBuilder.addCustomTargeting((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    return localBuilder.build();
  }

  private void l()
  {
    Iterator localIterator = this.h.keySet().iterator();
    while (localIterator.hasNext())
      ((String)localIterator.next());
  }

  protected abstract int a();

  protected abstract Uri a(g paramg);

  public void a(com.viber.voip.ads.d.n paramn, int paramInt)
  {
    this.a = null;
    this.e = true;
    a(paramn, 2, paramInt);
  }

  public void a(n paramn)
  {
    int i1 = b();
    if (i1 == 0)
    {
      paramn.a();
      return;
    }
    if (this.e)
    {
      paramn.a();
      return;
    }
    if (this.f)
    {
      paramn.a();
      return;
    }
    if (this.a != null)
    {
      if (this.a.s())
      {
        paramn.a(this.a);
        return;
      }
      paramn.a();
      return;
    }
    if (!cj.b(ViberApplication.getApplication()))
    {
      this.f = true;
      paramn.a();
      return;
    }
    av.a(av.e.f).post(new l(this, i1, paramn));
  }

  public void a(String paramString, int paramInt)
  {
    List localList = (List)this.h.get(paramString);
    if (localList == null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Integer.valueOf(paramInt));
      this.h.put(paramString, localArrayList);
      return;
    }
    localList.add(Integer.valueOf(paramInt));
  }

  protected abstract int b();

  public void b(com.viber.voip.ads.d.n paramn, int paramInt)
  {
    if (!b(paramn.b(), 2))
    {
      e().a(paramn.r());
      a(paramn.b(), 2);
      a(paramn, 1, paramInt);
    }
  }

  public boolean b(String paramString, int paramInt)
  {
    l();
    return (this.h.containsKey(paramString)) && (((List)this.h.get(paramString)).contains(Integer.valueOf(paramInt)));
  }

  @SuppressLint({"WrongConstant"})
  public void c()
  {
    if (this.a != null)
    {
      new OpenUrlAction(dx.a(ViberApplication.getApplication(), this.a.p(), this.a.b(), this.a.w(), "", this.a.D(), a()).toString()).execute(ViberApplication.getApplication(), null);
      this.a = null;
    }
  }

  public void c(com.viber.voip.ads.d.n paramn, int paramInt)
  {
    if (!b(paramn.b(), 1))
    {
      a(paramn.b(), 1);
      d(paramn, paramInt);
      e().a(paramn.q());
    }
  }

  public com.viber.voip.ads.d.n d()
  {
    return this.a;
  }

  public s e()
  {
    return this.g;
  }

  public void f()
  {
    this.h.clear();
  }

  public void onAppStopped()
  {
    i.c(this);
  }

  public void onBackground()
  {
    this.a = null;
    this.e = false;
    this.f = false;
  }

  public void onForeground()
  {
    i.b(this);
  }

  public void onForegroundStateChanged(boolean paramBoolean)
  {
    i.a(this, paramBoolean);
  }

  private class a extends AdListener
    implements NativeAppInstallAd.OnAppInstallAdLoadedListener, NativeContentAd.OnContentAdLoadedListener
  {
    private final String a;
    protected f c;
    protected final n d;

    public a(n paramString, String arg3)
    {
      this.d = paramString;
      Object localObject;
      this.a = localObject;
    }

    public void onAdClicked()
    {
      super.onAdClicked();
    }

    public void onAdFailedToLoad(int paramInt)
    {
      super.onAdFailedToLoad(paramInt);
      Pair localPair = com.viber.voip.util.k.a.a(paramInt);
      k.e(k.this).a(((Integer)localPair.first).intValue(), k.this.a());
      this.d.a();
    }

    public void onAdOpened()
    {
      super.onAdOpened();
      if ((this.c != null) && (this.c.a() != null))
        this.c.a().a();
    }

    public void onAppInstallAdLoaded(NativeAppInstallAd paramNativeAppInstallAd)
    {
      k.e(k.this).a(100, k.this.a());
      this.c = new f(paramNativeAppInstallAd, this.a);
      k.this.a = this.c;
      this.d.a(this.c);
    }

    public void onContentAdLoaded(NativeContentAd paramNativeContentAd)
    {
      k.e(k.this).a(100, k.this.a());
      this.c = new f(paramNativeContentAd, this.a);
      k.this.a = this.c;
      this.d.a(this.c);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.k
 * JD-Core Version:    0.6.2
 */