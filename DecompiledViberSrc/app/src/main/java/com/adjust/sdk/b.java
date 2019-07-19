package com.adjust.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class b
{
  private static ILogger o = AdjustFactory.getLogger();
  Map<String, String> a;
  AdjustAttribution b;
  String c;
  String d;
  String e;
  String f;
  long g = -1L;
  long h = -1L;
  long i = -1L;
  private AdjustConfig j;
  private a k;
  private a l;
  private SessionParameters m;
  private long n;

  public b(AdjustConfig paramAdjustConfig, a parama, ActivityState paramActivityState, SessionParameters paramSessionParameters, long paramLong)
  {
    this.j = paramAdjustConfig;
    this.k = parama;
    this.l = new a(paramActivityState);
    this.m = paramSessionParameters;
    this.n = paramLong;
  }

  private ActivityPackage a(ActivityKind paramActivityKind)
  {
    ActivityPackage localActivityPackage = new ActivityPackage(paramActivityKind);
    localActivityPackage.setClientSdk(this.k.g);
    return localActivityPackage;
  }

  private String a(AdjustEvent paramAdjustEvent)
  {
    if (paramAdjustEvent.revenue == null)
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = paramAdjustEvent.eventToken;
      return Util.formatString("'%s'", arrayOfObject2);
    }
    Object[] arrayOfObject1 = new Object[3];
    arrayOfObject1[0] = paramAdjustEvent.revenue;
    arrayOfObject1[1] = paramAdjustEvent.currency;
    arrayOfObject1[2] = paramAdjustEvent.eventToken;
    return Util.formatString("(%.5f %s, '%s')", arrayOfObject1);
  }

  private void a(Map<String, String> paramMap)
  {
    b(paramMap);
    a(paramMap, "fb_id", this.k.f);
    a(paramMap, "package_name", this.k.h);
    a(paramMap, "app_version", this.k.i);
    a(paramMap, "device_type", this.k.j);
    a(paramMap, "device_name", this.k.k);
    a(paramMap, "device_manufacturer", this.k.l);
    a(paramMap, "os_name", this.k.m);
    a(paramMap, "os_version", this.k.n);
    a(paramMap, "api_level", this.k.o);
    a(paramMap, "language", this.k.p);
    a(paramMap, "country", this.k.q);
    a(paramMap, "screen_size", this.k.r);
    a(paramMap, "screen_format", this.k.s);
    a(paramMap, "screen_density", this.k.t);
    a(paramMap, "display_width", this.k.u);
    a(paramMap, "display_height", this.k.v);
    a(paramMap, "hardware_name", this.k.w);
    a(paramMap, "cpu_type", this.k.x);
    a(paramMap, "os_build", this.k.y);
    a(paramMap, "mcc", Util.getMcc(this.j.context));
    a(paramMap, "mnc", Util.getMnc(this.j.context));
    a(paramMap, "connectivity_type", Util.getConnectivityType(this.j.context));
    a(paramMap, "network_type", Util.getNetworkType(this.j.context));
  }

  public static void a(Map<String, String> paramMap, String paramString, long paramLong)
  {
    if (paramLong < 0L)
      return;
    a(paramMap, paramString, Long.toString(paramLong));
  }

  public static void a(Map<String, String> paramMap, String paramString, Boolean paramBoolean)
  {
    if (paramBoolean == null)
      return;
    if (paramBoolean.booleanValue());
    for (int i1 = 1; ; i1 = 0)
    {
      a(paramMap, paramString, i1);
      return;
    }
  }

  public static void a(Map<String, String> paramMap, String paramString, Double paramDouble)
  {
    if (paramDouble == null)
      return;
    a(paramMap, paramString, Util.formatString("%.5f", new Object[] { paramDouble }));
  }

  public static void a(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
      return;
    paramMap.put(paramString1, paramString2);
  }

  public static void a(Map<String, String> paramMap, String paramString, Date paramDate)
  {
    if (paramDate == null)
      return;
    a(paramMap, paramString, Util.dateFormatter.format(paramDate));
  }

  public static void a(Map<String, String> paramMap1, String paramString, Map<String, String> paramMap2)
  {
    if (paramMap2 == null);
    while (paramMap2.size() == 0)
      return;
    a(paramMap1, paramString, new JSONObject(paramMap2).toString());
  }

  private Map<String, String> b(boolean paramBoolean)
  {
    Map localMap = c();
    d(localMap, "last_interval", this.l.a);
    a(localMap, "default_tracker", this.j.defaultTracker);
    a(localMap, "installed_at", this.k.z);
    a(localMap, "updated_at", this.k.A);
    if (!paramBoolean)
    {
      a(localMap, "callback_params", this.m.callbackParameters);
      a(localMap, "partner_params", this.m.partnerParameters);
    }
    return localMap;
  }

  private void b(Map<String, String> paramMap)
  {
    this.k.a(this.j.context);
    a(paramMap, "tracking_enabled", this.k.b);
    a(paramMap, "gps_adid", this.k.a);
    if (this.k.a == null)
    {
      a(paramMap, "mac_sha1", this.k.c);
      a(paramMap, "mac_md5", this.k.d);
      a(paramMap, "android_id", this.k.e);
    }
  }

  public static void b(Map<String, String> paramMap, String paramString, long paramLong)
  {
    if (paramLong <= 0L)
      return;
    a(paramMap, paramString, new Date(paramLong));
  }

  private Map<String, String> c()
  {
    HashMap localHashMap = new HashMap();
    a(localHashMap);
    c(localHashMap);
    d(localHashMap);
    e(localHashMap);
    g(localHashMap);
    return localHashMap;
  }

  private void c(Map<String, String> paramMap)
  {
    a(paramMap, "app_token", this.j.appToken);
    a(paramMap, "environment", this.j.environment);
    a(paramMap, "device_known", this.j.deviceKnown);
    a(paramMap, "event_buffering_enabled", Boolean.valueOf(this.j.eventBufferingEnabled));
    a(paramMap, "push_token", this.l.h);
    ContentResolver localContentResolver = this.j.context.getContentResolver();
    a(paramMap, "fire_adid", Util.getFireAdvertisingId(localContentResolver));
    a(paramMap, "fire_tracking_enabled", Util.getFireTrackingEnabled(localContentResolver));
    a(paramMap, "secret_id", this.j.secretId);
    a(paramMap, "app_secret", this.j.appSecret);
  }

  public static void c(Map<String, String> paramMap, String paramString, long paramLong)
  {
    if (paramLong <= 0L)
      return;
    a(paramMap, paramString, new Date(1000L * paramLong));
  }

  private Map<String, String> d()
  {
    HashMap localHashMap = new HashMap();
    b(localHashMap);
    c(localHashMap);
    e(localHashMap);
    g(localHashMap);
    return localHashMap;
  }

  private void d(Map<String, String> paramMap)
  {
    a(paramMap, "android_uuid", this.l.c);
    a(paramMap, "session_count", this.l.d);
    a(paramMap, "subsession_count", this.l.e);
    d(paramMap, "session_length", this.l.f);
    d(paramMap, "time_spent", this.l.g);
  }

  public static void d(Map<String, String> paramMap, String paramString, long paramLong)
  {
    if (paramLong < 0L)
      return;
    a(paramMap, paramString, (500L + paramLong) / 1000L);
  }

  private void e(Map<String, String> paramMap)
  {
    b(paramMap, "created_at", this.n);
    a(paramMap, "attribution_deeplink", Boolean.valueOf(true));
    a(paramMap, "needs_response_details", Boolean.valueOf(true));
  }

  private void f(Map<String, String> paramMap)
  {
    if (this.b == null)
      return;
    a(paramMap, "tracker", this.b.trackerName);
    a(paramMap, "campaign", this.b.campaign);
    a(paramMap, "adgroup", this.b.adgroup);
    a(paramMap, "creative", this.b.creative);
  }

  private void g(Map<String, String> paramMap)
  {
    if ((!paramMap.containsKey("mac_sha1")) && (!paramMap.containsKey("mac_md5")) && (!paramMap.containsKey("android_id")) && (!paramMap.containsKey("gps_adid")))
      o.error("Missing device id's. Please check if Proguard is correctly set with Adjust SDK", new Object[0]);
  }

  public ActivityPackage a()
  {
    Map localMap = d();
    ActivityPackage localActivityPackage = a(ActivityKind.ATTRIBUTION);
    localActivityPackage.setPath("attribution");
    localActivityPackage.setSuffix("");
    localActivityPackage.setParameters(localMap);
    return localActivityPackage;
  }

  public ActivityPackage a(AdjustEvent paramAdjustEvent, boolean paramBoolean)
  {
    Map localMap = c();
    a(localMap, "event_count", this.l.b);
    a(localMap, "event_token", paramAdjustEvent.eventToken);
    a(localMap, "revenue", paramAdjustEvent.revenue);
    a(localMap, "currency", paramAdjustEvent.currency);
    a(localMap, "event_callback_id", paramAdjustEvent.callbackId);
    if (!paramBoolean)
    {
      a(localMap, "callback_params", Util.mergeParameters(this.m.callbackParameters, paramAdjustEvent.callbackParameters, "Callback"));
      a(localMap, "partner_params", Util.mergeParameters(this.m.partnerParameters, paramAdjustEvent.partnerParameters, "Partner"));
    }
    ActivityPackage localActivityPackage = a(ActivityKind.EVENT);
    localActivityPackage.setPath("/event");
    localActivityPackage.setSuffix(a(paramAdjustEvent));
    localActivityPackage.setParameters(localMap);
    if (paramBoolean)
    {
      localActivityPackage.setCallbackParameters(paramAdjustEvent.callbackParameters);
      localActivityPackage.setPartnerParameters(paramAdjustEvent.partnerParameters);
    }
    return localActivityPackage;
  }

  public ActivityPackage a(String paramString)
  {
    Map localMap = b(false);
    a(localMap, "source", paramString);
    b(localMap, "click_time", this.g);
    a(localMap, "reftag", this.c);
    a(localMap, "params", this.a);
    a(localMap, "referrer", this.d);
    a(localMap, "raw_referrer", this.e);
    a(localMap, "deeplink", this.f);
    c(localMap, "click_time", this.h);
    c(localMap, "install_begin_time", this.i);
    f(localMap);
    ActivityPackage localActivityPackage = a(ActivityKind.CLICK);
    localActivityPackage.setPath("/sdk_click");
    localActivityPackage.setSuffix("");
    localActivityPackage.setClickTimeInMilliseconds(this.g);
    localActivityPackage.setClickTimeInSeconds(this.h);
    localActivityPackage.setInstallBeginTimeInSeconds(this.i);
    localActivityPackage.setParameters(localMap);
    return localActivityPackage;
  }

  public ActivityPackage a(boolean paramBoolean)
  {
    Map localMap = b(paramBoolean);
    ActivityPackage localActivityPackage = a(ActivityKind.SESSION);
    localActivityPackage.setPath("/session");
    localActivityPackage.setSuffix("");
    localActivityPackage.setParameters(localMap);
    return localActivityPackage;
  }

  public ActivityPackage b()
  {
    Map localMap = d();
    ActivityPackage localActivityPackage = a(ActivityKind.GDPR);
    localActivityPackage.setPath("/gdpr_forget_device");
    localActivityPackage.setSuffix("");
    localActivityPackage.setParameters(localMap);
    return localActivityPackage;
  }

  public ActivityPackage b(String paramString)
  {
    Map localMap = d();
    a(localMap, "source", paramString);
    ActivityPackage localActivityPackage = a(ActivityKind.INFO);
    localActivityPackage.setPath("/sdk_info");
    localActivityPackage.setSuffix("");
    localActivityPackage.setParameters(localMap);
    return localActivityPackage;
  }

  private class a
  {
    long a = -1L;
    int b = -1;
    String c = null;
    int d = -1;
    int e = -1;
    long f = -1L;
    long g = -1L;
    String h = null;

    a(ActivityState arg2)
    {
      Object localObject;
      if (localObject == null)
        return;
      this.a = localObject.lastInterval;
      this.b = localObject.eventCount;
      this.c = localObject.uuid;
      this.d = localObject.sessionCount;
      this.e = localObject.subsessionCount;
      this.f = localObject.sessionLength;
      this.g = localObject.timeSpent;
      this.h = localObject.pushToken;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.b
 * JD-Core Version:    0.6.2
 */