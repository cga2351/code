package com.mopub.mobileads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.mopub.common.AdReport;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mraid.MraidNativeCommandHandler;
import com.mopub.network.AdLoader;
import com.mopub.network.AdLoader.Listener;
import com.mopub.network.AdResponse;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.SingleImpression;
import com.mopub.network.TrackingRequest;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.VolleyError;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;

public class AdViewController
{
  private static final FrameLayout.LayoutParams c = new FrameLayout.LayoutParams(-2, -2, 17);
  private static final WeakHashMap<View, Boolean> d = new WeakHashMap();
  private String A;
  AdLoader a;

  @VisibleForTesting
  int b = 1;
  private final long e;
  private Context f;
  private MoPubView g;
  private WebViewAdUrlGenerator h;
  private Request i;
  private final AdLoader.Listener j;
  private AdResponse k;
  private String l;
  private final Runnable m;
  private boolean n;
  private Handler o;
  private boolean p;
  private Map<String, Object> q = new HashMap();
  private boolean r = true;
  private boolean s = true;
  private String t;
  private String u;
  private Location v;
  private boolean w;
  private boolean x;
  private String y;
  private Integer z;

  public AdViewController(Context paramContext, MoPubView paramMoPubView)
  {
    this.f = paramContext;
    this.g = paramMoPubView;
    this.e = Utils.generateUniqueId();
    this.h = new WebViewAdUrlGenerator(this.f.getApplicationContext(), MraidNativeCommandHandler.isStorePictureSupported(this.f));
    this.j = new AdLoader.Listener()
    {
      public void onErrorResponse(VolleyError paramAnonymousVolleyError)
      {
        AdViewController.this.a(paramAnonymousVolleyError);
      }

      public void onSuccess(AdResponse paramAnonymousAdResponse)
      {
        AdViewController.this.a(paramAnonymousAdResponse);
      }
    };
    this.m = new Runnable()
    {
      public void run()
      {
        AdViewController.a(AdViewController.this);
      }
    };
    this.z = Integer.valueOf(60000);
    this.o = new Handler();
    this.A = "";
  }

  @VisibleForTesting
  static MoPubErrorCode a(VolleyError paramVolleyError, Context paramContext)
  {
    NetworkResponse localNetworkResponse = paramVolleyError.networkResponse;
    if ((paramVolleyError instanceof MoPubNetworkError))
    {
      switch (4.a[((MoPubNetworkError)paramVolleyError).getReason().ordinal()])
      {
      default:
        return MoPubErrorCode.UNSPECIFIED;
      case 1:
        return MoPubErrorCode.WARMUP;
      case 2:
      }
      return MoPubErrorCode.NO_FILL;
    }
    if (localNetworkResponse == null)
    {
      if (!DeviceUtils.isNetworkAvailable(paramContext))
        return MoPubErrorCode.NO_CONNECTION;
      return MoPubErrorCode.UNSPECIFIED;
    }
    if (paramVolleyError.networkResponse.statusCode >= 400)
      return MoPubErrorCode.SERVER_ERROR;
    return MoPubErrorCode.UNSPECIFIED;
  }

  private void b(boolean paramBoolean)
  {
    int i1;
    String str;
    if ((this.x) && (this.r != paramBoolean))
    {
      i1 = 1;
      if (i1 != 0)
      {
        if (!paramBoolean)
          break label115;
        str = "enabled";
        label28: MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = ("Refresh " + str + " for ad unit (" + this.y + ").");
        MoPubLog.log(localSdkLogEvent, arrayOfObject);
      }
      this.r = paramBoolean;
      if ((!this.x) || (!this.r))
        break label121;
      l();
    }
    label115: label121: 
    while (this.r)
    {
      return;
      i1 = 0;
      break;
      str = "disabled";
      break label28;
    }
    o();
  }

  private static boolean b(View paramView)
  {
    return d.get(paramView) != null;
  }

  private FrameLayout.LayoutParams c(View paramView)
  {
    Integer localInteger2;
    Integer localInteger1;
    if (this.k != null)
    {
      localInteger2 = this.k.getWidth();
      localInteger1 = this.k.getHeight();
    }
    while (true)
    {
      if ((localInteger2 != null) && (localInteger1 != null) && (b(paramView)) && (localInteger2.intValue() > 0) && (localInteger1.intValue() > 0))
        return new FrameLayout.LayoutParams(Dips.asIntPixels(localInteger2.intValue(), this.f), Dips.asIntPixels(localInteger1.intValue(), this.f), 17);
      return c;
      localInteger1 = null;
      localInteger2 = null;
    }
  }

  private void n()
  {
    this.x = true;
    if (TextUtils.isEmpty(this.y))
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Can't load an ad in this ad view because the ad unit ID is not set. Did you forget to call setAdUnitId()?" });
      b(MoPubErrorCode.MISSING_AD_UNIT_ID);
      return;
    }
    if (!p())
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Can't load an ad because there is no network connectivity." });
      b(MoPubErrorCode.NO_CONNECTION);
      return;
    }
    a(k(), null);
  }

  private void o()
  {
    this.o.removeCallbacks(this.m);
  }

  @SuppressLint({"MissingPermission"})
  private boolean p()
  {
    if (this.f == null)
      return false;
    if (!DeviceUtils.isPermissionGranted(this.f, "android.permission.ACCESS_NETWORK_STATE"))
      return true;
    ConnectivityManager localConnectivityManager = (ConnectivityManager)this.f.getSystemService("connectivity");
    if (localConnectivityManager != null);
    for (NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo(); ; localNetworkInfo = null)
    {
      if ((localNetworkInfo != null) && (localNetworkInfo.isConnected()));
      for (boolean bool = true; ; bool = false)
        return bool;
    }
  }

  public static void setShouldHonorServerDimensions(View paramView)
  {
    d.put(paramView, Boolean.valueOf(true));
  }

  Integer a(int paramInt)
  {
    if (this.k == null)
      return Integer.valueOf(paramInt);
    return this.k.getAdTimeoutMillis(paramInt);
  }

  void a()
  {
    if (this.i != null)
    {
      if (!this.i.isCanceled())
        this.i.cancel();
      this.i = null;
    }
    this.a = null;
  }

  void a(final View paramView)
  {
    this.o.post(new Runnable()
    {
      public void run()
      {
        MoPubView localMoPubView = AdViewController.this.getMoPubView();
        if (localMoPubView == null)
          return;
        localMoPubView.removeAllViews();
        localMoPubView.addView(paramView, AdViewController.a(AdViewController.this, paramView));
      }
    });
  }

  @VisibleForTesting
  void a(MoPubView paramMoPubView, String paramString, Map<String, String> paramMap)
  {
    Preconditions.checkNotNull(paramMap);
    if (paramMoPubView == null)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Can't load an ad in this ad view because it was destroyed." });
      return;
    }
    paramMoPubView.a(paramString, paramMap);
  }

  @VisibleForTesting
  void a(AdResponse paramAdResponse)
  {
    this.b = 1;
    this.k = paramAdResponse;
    this.l = paramAdResponse.getCustomEventClassName();
    this.z = this.k.getRefreshTimeMillis();
    this.i = null;
    a(this.g, paramAdResponse.getCustomEventClassName(), paramAdResponse.getServerExtras());
    l();
  }

  @VisibleForTesting
  void a(VolleyError paramVolleyError)
  {
    if ((paramVolleyError instanceof MoPubNetworkError))
    {
      MoPubNetworkError localMoPubNetworkError = (MoPubNetworkError)paramVolleyError;
      if (localMoPubNetworkError.getRefreshTimeMillis() != null)
        this.z = localMoPubNetworkError.getRefreshTimeMillis();
    }
    MoPubErrorCode localMoPubErrorCode = a(paramVolleyError, this.f);
    if (localMoPubErrorCode == MoPubErrorCode.SERVER_ERROR)
      this.b = (1 + this.b);
    b(localMoPubErrorCode);
  }

  void a(String paramString, MoPubError paramMoPubError)
  {
    if (paramString == null)
      b(MoPubErrorCode.NO_FILL);
    do
    {
      return;
      if (!paramString.startsWith("javascript:"))
      {
        MoPubLog.SdkLogEvent localSdkLogEvent2 = MoPubLog.SdkLogEvent.CUSTOM;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = ("Loading url: " + paramString);
        MoPubLog.log(localSdkLogEvent2, arrayOfObject2);
      }
      if (this.i == null)
        break;
    }
    while (TextUtils.isEmpty(this.y));
    MoPubLog.SdkLogEvent localSdkLogEvent1 = MoPubLog.SdkLogEvent.CUSTOM;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = ("Already loading an ad for " + this.y + ", wait to finish.");
    MoPubLog.log(localSdkLogEvent1, arrayOfObject1);
    return;
    b(paramString, paramMoPubError);
  }

  void a(Map<String, Object> paramMap)
  {
    if (paramMap != null);
    for (TreeMap localTreeMap = new TreeMap(paramMap); ; localTreeMap = new TreeMap())
    {
      this.q = localTreeMap;
      return;
    }
  }

  void a(boolean paramBoolean)
  {
    this.s = paramBoolean;
    b(paramBoolean);
  }

  boolean a(MoPubErrorCode paramMoPubErrorCode)
  {
    if (paramMoPubErrorCode == null)
    {
      MoPubLog.AdLogEvent localAdLogEvent2 = MoPubLog.AdLogEvent.LOAD_FAILED;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Integer.valueOf(MoPubErrorCode.UNSPECIFIED.getIntCode());
      arrayOfObject2[1] = MoPubErrorCode.UNSPECIFIED;
      MoPubLog.log(localAdLogEvent2, arrayOfObject2);
    }
    while ((this.a != null) && (this.a.hasMoreAds()))
    {
      a("", paramMoPubErrorCode);
      return true;
      MoPubLog.AdLogEvent localAdLogEvent1 = MoPubLog.AdLogEvent.LOAD_FAILED;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Integer.valueOf(paramMoPubErrorCode.getIntCode());
      arrayOfObject1[1] = paramMoPubErrorCode;
      MoPubLog.log(localAdLogEvent1, arrayOfObject1);
    }
    b(MoPubErrorCode.NO_FILL);
    return false;
  }

  void b()
  {
    l();
    if (this.a == null)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "mAdLoader is not supposed to be null" });
      return;
    }
    this.a.creativeDownloadSuccess();
    this.a = null;
  }

  void b(MoPubErrorCode paramMoPubErrorCode)
  {
    MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Ad failed to load." });
    a();
    MoPubView localMoPubView = getMoPubView();
    if (localMoPubView == null)
      return;
    if (!TextUtils.isEmpty(this.y))
      l();
    localMoPubView.b(paramMoPubErrorCode);
  }

  void b(String paramString, MoPubError paramMoPubError)
  {
    MoPubView localMoPubView = getMoPubView();
    if ((localMoPubView == null) || (this.f == null))
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Can't load an ad in this ad view because it was destroyed." });
      a();
      return;
    }
    try
    {
      if ((this.a == null) || (!this.a.hasMoreAds()))
        this.a = new AdLoader(paramString, localMoPubView.getAdFormat(), this.y, this.f, this.j);
      this.i = this.a.loadNextAd(paramMoPubError);
      return;
    }
    finally
    {
    }
  }

  void c()
  {
    b(false);
  }

  void d()
  {
    if ((this.s) && (!this.p))
      b(true);
  }

  void e()
  {
    this.p = true;
    c();
  }

  void f()
  {
    this.p = false;
    d();
  }

  void g()
  {
    if (this.n)
      return;
    a();
    b(false);
    o();
    this.g = null;
    this.f = null;
    this.h = null;
    this.A = "";
    this.n = true;
  }

  public int getAdHeight()
  {
    if ((this.k != null) && (this.k.getHeight() != null))
      return this.k.getHeight().intValue();
    return 0;
  }

  public AdReport getAdReport()
  {
    if ((this.y != null) && (this.k != null))
      return new AdReport(this.y, ClientMetadata.getInstance(this.f), this.k);
    return null;
  }

  public String getAdUnitId()
  {
    return this.y;
  }

  public int getAdWidth()
  {
    if ((this.k != null) && (this.k.getWidth() != null))
      return this.k.getWidth().intValue();
    return 0;
  }

  @Deprecated
  public boolean getAutorefreshEnabled()
  {
    return getCurrentAutoRefreshStatus();
  }

  public long getBroadcastIdentifier()
  {
    return this.e;
  }

  public boolean getCurrentAutoRefreshStatus()
  {
    return this.r;
  }

  public String getCustomEventClassName()
  {
    return this.l;
  }

  public String getKeywords()
  {
    return this.t;
  }

  public Location getLocation()
  {
    if (!MoPub.canCollectPersonalInformation())
      return null;
    return this.v;
  }

  public MoPubView getMoPubView()
  {
    return this.g;
  }

  public boolean getTesting()
  {
    return this.w;
  }

  public String getUserDataKeywords()
  {
    if (!MoPub.canCollectPersonalInformation())
      return null;
    return this.u;
  }

  void h()
  {
    String str;
    if (this.k != null)
    {
      str = this.k.getRequestId();
      if (this.A.equals(str))
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Ignoring duplicate impression." });
    }
    else
    {
      return;
    }
    if (str != null)
      this.A = str;
    TrackingRequest.makeTrackingHttpRequest(this.k.getImpressionTrackingUrls(), this.f);
    new SingleImpression(this.k.getAdUnitId(), this.k.getImpressionData()).sendImpression();
  }

  void i()
  {
    if (this.k != null)
      TrackingRequest.makeTrackingHttpRequest(this.k.getClickTrackingUrl(), this.f);
  }

  void j()
  {
    a();
    loadAd();
  }

  String k()
  {
    if (this.h == null)
      return null;
    boolean bool = MoPub.canCollectPersonalInformation();
    AdUrlGenerator localAdUrlGenerator1 = this.h.withAdUnitId(this.y).withKeywords(this.t);
    if (bool);
    for (String str = this.u; ; str = null)
    {
      AdUrlGenerator localAdUrlGenerator2 = localAdUrlGenerator1.withUserDataKeywords(str);
      Location localLocation = null;
      if (bool)
        localLocation = this.v;
      localAdUrlGenerator2.withLocation(localLocation);
      return this.h.generateUrlString(Constants.HOST);
    }
  }

  void l()
  {
    o();
    if ((this.r) && (this.z != null) && (this.z.intValue() > 0))
      this.o.postDelayed(this.m, Math.min(600000L, this.z.intValue() * ()Math.pow(1.5D, this.b)));
  }

  public void loadAd()
  {
    this.b = 1;
    n();
  }

  Map<String, Object> m()
  {
    if (this.q != null)
      return new TreeMap(this.q);
    return new TreeMap();
  }

  @Deprecated
  public void reload()
  {
    loadAd();
  }

  public void setAdUnitId(String paramString)
  {
    this.y = paramString;
  }

  public void setKeywords(String paramString)
  {
    this.t = paramString;
  }

  public void setLocation(Location paramLocation)
  {
    if (!MoPub.canCollectPersonalInformation())
    {
      this.v = null;
      return;
    }
    this.v = paramLocation;
  }

  public void setTesting(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }

  public void setUserDataKeywords(String paramString)
  {
    if (!MoPub.canCollectPersonalInformation())
    {
      this.u = null;
      return;
    }
    this.u = paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.AdViewController
 * JD-Core Version:    0.6.2
 */