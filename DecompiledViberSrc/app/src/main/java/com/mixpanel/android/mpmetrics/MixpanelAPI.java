package com.mixpanel.android.mpmetrics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.mixpanel.android.R.animator;
import com.mixpanel.android.c.l;
import com.mixpanel.android.takeoverinapp.TakeoverInAppActivity;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MixpanelAPI
{
  private static final String APP_LINKS_LOGTAG = "MixpanelAPI.AL";
  private static final String ENGAGE_DATE_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ss";
  private static final String LOGTAG = "MixpanelAPI.API";
  public static final String VERSION = "5.4.4-SNAPSHOT";
  private static final Map<String, Map<Context, MixpanelAPI>> sInstanceMap = new HashMap();
  private static final r sPrefsLoader = new r();
  private static Future<SharedPreferences> sReferrerPrefs;
  private static final v sSharedTweaks = new v();
  private final i mConfig;
  private final d mConnectIntegrations;
  private final Context mContext;
  private final f mDecideMessages;
  private final Map<String, String> mDeviceInfo;
  private final Map<String, Long> mEventTimings;
  private final a mMessages;
  private k mMixpanelActivityLifecycleCallbacks;
  private final d mPeople;
  private final n mPersistentIdentity;
  private final q mSessionMetadata;
  private final String mToken;
  private final com.mixpanel.android.c.j mTrackingDebug;
  private final l mUpdatesFromMixpanel;
  private final g mUpdatesListener;

  MixpanelAPI(Context paramContext, Future<SharedPreferences> paramFuture, String paramString, i parami, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mToken = paramString;
    this.mPeople = new d(null);
    this.mConfig = parami;
    HashMap localHashMap = new HashMap();
    localHashMap.put("$android_lib_version", "5.4.4-SNAPSHOT");
    localHashMap.put("$android_os", "Android");
    String str1;
    if (Build.VERSION.RELEASE == null)
      str1 = "UNKNOWN";
    while (true)
    {
      localHashMap.put("$android_os_version", str1);
      String str2;
      label98: String str3;
      label120: String str4;
      if (Build.MANUFACTURER == null)
      {
        str2 = "UNKNOWN";
        localHashMap.put("$android_manufacturer", str2);
        if (Build.BRAND != null)
          break label655;
        str3 = "UNKNOWN";
        localHashMap.put("$android_brand", str3);
        if (Build.MODEL != null)
          break label663;
        str4 = "UNKNOWN";
        label142: localHashMap.put("$android_model", str4);
      }
      try
      {
        PackageInfo localPackageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0);
        localHashMap.put("$android_app_version", localPackageInfo.versionName);
        localHashMap.put("$android_app_version_code", Integer.toString(localPackageInfo.versionCode));
        this.mDeviceInfo = Collections.unmodifiableMap(localHashMap);
        this.mSessionMetadata = new q();
        this.mUpdatesFromMixpanel = constructUpdatesFromMixpanel(paramContext, paramString);
        this.mTrackingDebug = constructTrackingDebug();
        this.mPersistentIdentity = getPersistentIdentity(paramContext, paramFuture, paramString);
        this.mEventTimings = this.mPersistentIdentity.l();
        this.mMessages = getAnalyticsMessages();
        if (paramBoolean)
          optOutTracking();
        this.mUpdatesListener = constructUpdatesListener();
        this.mDecideMessages = constructDecideUpdates(paramString, this.mUpdatesListener, this.mUpdatesFromMixpanel);
        this.mConnectIntegrations = new d(this, this.mContext);
        String str5 = this.mPersistentIdentity.g();
        if (str5 == null)
          str5 = this.mPersistentIdentity.d();
        this.mDecideMessages.a(str5);
        if (this.mPersistentIdentity.a(j.a(this.mContext).b().exists()))
        {
          track("$ae_first_open", null, true);
          this.mPersistentIdentity.n();
        }
        if (!this.mConfig.s())
          this.mMessages.a(this.mDecideMessages);
        registerMixpanelActivityLifecycleCallbacks();
        if (sendAppOpen())
          track("$app_open", null);
        if (this.mPersistentIdentity.f(this.mToken));
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        try
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("mp_lib", "Android");
          localJSONObject2.put("lib", "Android");
          localJSONObject2.put("distinct_id", paramString);
          localJSONObject2.put("$lib_version", "5.4.4-SNAPSHOT");
          localJSONObject2.put("$user_id", paramString);
          a.a locala = new a.a("Integration", localJSONObject2, "85053bf24bba75239b16a601d9387e17");
          this.mMessages.a(locala);
          this.mMessages.a(new a.b("85053bf24bba75239b16a601d9387e17", false));
          this.mPersistentIdentity.g(this.mToken);
          label567: if (this.mPersistentIdentity.h((String)localHashMap.get("$android_app_version_code")));
          try
          {
            JSONObject localJSONObject1 = new JSONObject();
            localJSONObject1.put("$ae_updated_version", localHashMap.get("$android_app_version"));
            track("$ae_updated", localJSONObject1, true);
            label626: this.mUpdatesFromMixpanel.a();
            g.a();
            return;
            str1 = Build.VERSION.RELEASE;
            continue;
            str2 = Build.MANUFACTURER;
            break label98;
            label655: str3 = Build.BRAND;
            break label120;
            label663: str4 = Build.MODEL;
            break label142;
            localNameNotFoundException = localNameNotFoundException;
            com.mixpanel.android.b.f.e("MixpanelAPI.API", "Exception getting app version name", localNameNotFoundException);
          }
          catch (JSONException localJSONException1)
          {
            break label626;
          }
        }
        catch (JSONException localJSONException2)
        {
          break label567;
        }
      }
    }
  }

  MixpanelAPI(Context paramContext, Future<SharedPreferences> paramFuture, String paramString, boolean paramBoolean)
  {
    this(paramContext, paramFuture, paramString, i.a(paramContext), paramBoolean);
  }

  static void allInstances(a parama)
  {
    synchronized (sInstanceMap)
    {
      Iterator localIterator1 = sInstanceMap.values().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((Map)localIterator1.next()).values().iterator();
        if (localIterator2.hasNext())
          parama.a((MixpanelAPI)localIterator2.next());
      }
    }
  }

  public static u<Boolean> booleanTweak(String paramString, boolean paramBoolean)
  {
    return sSharedTweaks.a(paramString, paramBoolean);
  }

  public static u<Byte> byteTweak(String paramString, byte paramByte)
  {
    return sSharedTweaks.a(paramString, paramByte);
  }

  private static void checkIntentForInboundAppLink(Context paramContext)
  {
    if ((paramContext instanceof Activity))
      try
      {
        Class localClass = Class.forName("b.b");
        Intent localIntent = ((Activity)paramContext).getIntent();
        localClass.getMethod("getTargetUrlFromInboundIntent", new Class[] { Context.class, Intent.class }).invoke(null, new Object[] { paramContext, localIntent });
        return;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        com.mixpanel.android.b.f.b("MixpanelAPI.AL", "Failed to invoke bolts.AppLinks.getTargetUrlFromInboundIntent() -- Unable to detect inbound App Links", localInvocationTargetException);
        return;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        com.mixpanel.android.b.f.b("MixpanelAPI.AL", "Please install the Bolts library >= 1.1.2 to track App Links: " + localClassNotFoundException.getMessage());
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        com.mixpanel.android.b.f.b("MixpanelAPI.AL", "Please install the Bolts library >= 1.1.2 to track App Links: " + localNoSuchMethodException.getMessage());
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        com.mixpanel.android.b.f.b("MixpanelAPI.AL", "Unable to detect inbound App Links: " + localIllegalAccessException.getMessage());
        return;
      }
    com.mixpanel.android.b.f.b("MixpanelAPI.AL", "Context is not an instance of Activity. To detect inbound App Links, pass an instance of an Activity to getInstance.");
  }

  public static u<Double> doubleTweak(String paramString, double paramDouble)
  {
    return sSharedTweaks.a(paramString, paramDouble);
  }

  public static u<Double> doubleTweak(String paramString, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return sSharedTweaks.a(paramString, paramDouble1, paramDouble2, paramDouble3);
  }

  public static u<Float> floatTweak(String paramString, float paramFloat)
  {
    return sSharedTweaks.a(paramString, paramFloat);
  }

  public static u<Float> floatTweak(String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return sSharedTweaks.a(paramString, paramFloat1, paramFloat2, paramFloat3);
  }

  public static MixpanelAPI getInstance(Context paramContext, String paramString)
  {
    return getInstance(paramContext, paramString, false);
  }

  public static MixpanelAPI getInstance(Context paramContext, String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramContext == null))
      return null;
    while (true)
    {
      Map localMap2;
      synchronized (sInstanceMap)
      {
        Context localContext = paramContext.getApplicationContext();
        if (sReferrerPrefs == null)
          sReferrerPrefs = sPrefsLoader.a(paramContext, "com.mixpanel.android.mpmetrics.ReferralInfo", null);
        localMap2 = (Map)sInstanceMap.get(paramString);
        if (localMap2 == null)
        {
          HashMap localHashMap = new HashMap();
          sInstanceMap.put(paramString, localHashMap);
          localObject2 = localHashMap;
          MixpanelAPI localMixpanelAPI = (MixpanelAPI)((Map)localObject2).get(localContext);
          if ((localMixpanelAPI == null) && (c.a(localContext)))
          {
            localMixpanelAPI = new MixpanelAPI(localContext, sReferrerPrefs, paramString, paramBoolean);
            registerAppLinksListeners(paramContext, localMixpanelAPI);
            ((Map)localObject2).put(localContext, localMixpanelAPI);
          }
          checkIntentForInboundAppLink(paramContext);
          return localMixpanelAPI;
        }
      }
      Object localObject2 = localMap2;
    }
  }

  private void identify(String paramString, boolean paramBoolean)
  {
    if (hasOptedOutTracking())
      return;
    synchronized (this.mPersistentIdentity)
    {
      this.mPersistentIdentity.a(paramString);
      if (paramBoolean)
        this.mPersistentIdentity.f();
      String str = this.mPersistentIdentity.g();
      if (str == null)
        str = this.mPersistentIdentity.d();
      this.mDecideMessages.a(str);
      return;
    }
  }

  public static u<Integer> intTweak(String paramString, int paramInt)
  {
    return sSharedTweaks.a(paramString, paramInt);
  }

  public static u<Integer> intTweak(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return sSharedTweaks.a(paramString, paramInt1, paramInt2, paramInt3);
  }

  public static u<Long> longTweak(String paramString, long paramLong)
  {
    return sSharedTweaks.a(paramString, paramLong);
  }

  public static u<Long> longTweak(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    return sSharedTweaks.a(paramString, paramLong1, paramLong2, paramLong3);
  }

  private void pushWaitingPeopleRecord()
  {
    if (hasOptedOutTracking());
    JSONArray localJSONArray;
    do
    {
      return;
      localJSONArray = this.mPersistentIdentity.h();
    }
    while (localJSONArray == null);
    sendAllPeopleRecords(localJSONArray);
  }

  private void recordPeopleMessage(JSONObject paramJSONObject)
  {
    if (hasOptedOutTracking())
      return;
    if (paramJSONObject.has("$distinct_id"))
    {
      this.mMessages.a(new a.d(paramJSONObject, this.mToken));
      return;
    }
    this.mPersistentIdentity.b(paramJSONObject);
  }

  private static void registerAppLinksListeners(Context paramContext, MixpanelAPI paramMixpanelAPI)
  {
    try
    {
      Class localClass = Class.forName("android.support.v4.content.LocalBroadcastManager");
      Method localMethod1 = localClass.getMethod("getInstance", new Class[] { Context.class });
      Method localMethod2 = localClass.getMethod("registerReceiver", new Class[] { BroadcastReceiver.class, IntentFilter.class });
      Object localObject = localMethod1.invoke(null, new Object[] { paramContext });
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = new BroadcastReceiver()
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          JSONObject localJSONObject = new JSONObject();
          Bundle localBundle = paramAnonymousIntent.getBundleExtra("event_args");
          if (localBundle != null)
          {
            Iterator localIterator = localBundle.keySet().iterator();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              try
              {
                localJSONObject.put(str, localBundle.get(str));
              }
              catch (JSONException localJSONException)
              {
                com.mixpanel.android.b.f.e("MixpanelAPI.AL", "failed to add key \"" + str + "\" to properties for tracking bolts event", localJSONException);
              }
            }
          }
          this.a.track("$" + paramAnonymousIntent.getStringExtra("event_name"), localJSONObject);
        }
      };
      arrayOfObject[1] = new IntentFilter("com.parse.bolts.measurement_event");
      localMethod2.invoke(localObject, arrayOfObject);
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      com.mixpanel.android.b.f.b("MixpanelAPI.AL", "Failed to invoke LocalBroadcastManager.registerReceiver() -- App Links tracking will not be enabled due to this exception", localInvocationTargetException);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      com.mixpanel.android.b.f.b("MixpanelAPI.AL", "To enable App Links tracking android.support.v4 must be installed: " + localClassNotFoundException.getMessage());
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      com.mixpanel.android.b.f.b("MixpanelAPI.AL", "To enable App Links tracking android.support.v4 must be installed: " + localNoSuchMethodException.getMessage());
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      com.mixpanel.android.b.f.b("MixpanelAPI.AL", "App Links tracking will not be enabled due to this exception: " + localIllegalAccessException.getMessage());
    }
  }

  private void sendAllPeopleRecords(JSONArray paramJSONArray)
  {
    if (hasOptedOutTracking())
      return;
    int i = 0;
    while (i < paramJSONArray.length())
      try
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        this.mMessages.a(new a.d(localJSONObject, this.mToken));
        i++;
      }
      catch (JSONException localJSONException)
      {
        while (true)
          com.mixpanel.android.b.f.e("MixpanelAPI.API", "Malformed people record stored pending identity, will not send it.", localJSONException);
      }
  }

  @Deprecated
  public static void setFlushInterval(Context paramContext, long paramLong)
  {
    com.mixpanel.android.b.f.c("MixpanelAPI.API", "MixpanelAPI.setFlushInterval is deprecated. Calling is now a no-op.\n    To set a custom Mixpanel flush interval for your application, add\n    <meta-data android:name=\"com.mixpanel.android.MPConfig.FlushInterval\" android:value=\"YOUR_INTERVAL\" />\n    to the <application> section of your AndroidManifest.xml.");
  }

  public static u<Short> shortTweak(String paramString, short paramShort)
  {
    return sSharedTweaks.a(paramString, paramShort);
  }

  public static u<String> stringTweak(String paramString1, String paramString2)
  {
    return sSharedTweaks.a(paramString1, paramString2);
  }

  public void alias(String paramString1, String paramString2)
  {
    if (hasOptedOutTracking())
      return;
    if (paramString2 == null)
      paramString2 = getDistinctId();
    if (paramString1.equals(paramString2))
    {
      com.mixpanel.android.b.f.d("MixpanelAPI.API", "Attempted to alias identical distinct_ids " + paramString1 + ". Alias message will not be sent.");
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("alias", paramString1);
      localJSONObject.put("original", paramString2);
      track("$create_alias", localJSONObject);
      flush();
      return;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        com.mixpanel.android.b.f.e("MixpanelAPI.API", "Failed to alias", localJSONException);
    }
  }

  public void clearSuperProperties()
  {
    this.mPersistentIdentity.m();
  }

  f constructDecideUpdates(String paramString, f.a parama, l paraml)
  {
    return new f(this.mContext, paramString, parama, paraml, this.mPersistentIdentity.o());
  }

  com.mixpanel.android.c.j constructTrackingDebug()
  {
    if ((this.mUpdatesFromMixpanel instanceof com.mixpanel.android.c.m))
      return (com.mixpanel.android.c.j)this.mUpdatesFromMixpanel;
    return null;
  }

  l constructUpdatesFromMixpanel(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      com.mixpanel.android.b.f.c("MixpanelAPI.API", "SDK version is lower than 16. Web Configuration, A/B Testing, and Dynamic Tweaks are disabled.");
      return new b(sSharedTweaks);
    }
    if ((this.mConfig.h()) || (Arrays.asList(this.mConfig.i()).contains(paramString)))
    {
      com.mixpanel.android.b.f.c("MixpanelAPI.API", "DisableViewCrawler is set to true. Web Configuration, A/B Testing, and Dynamic Tweaks are disabled.");
      return new b(sSharedTweaks);
    }
    return new com.mixpanel.android.c.m(this.mContext, this.mToken, this, sSharedTweaks);
  }

  g constructUpdatesListener()
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      com.mixpanel.android.b.f.c("MixpanelAPI.API", "Notifications are not supported on this Android OS Version");
      return new f(null);
    }
    return new e(null);
  }

  public double eventElapsedTime(String paramString)
  {
    long l = System.currentTimeMillis();
    Long localLong;
    synchronized (this.mEventTimings)
    {
      localLong = (Long)this.mEventTimings.get(paramString);
      if (localLong == null)
        return 0.0D;
    }
    return (l - localLong.longValue()) / 1000L;
  }

  public void flush()
  {
    if (hasOptedOutTracking())
      return;
    this.mMessages.a(new a.b(this.mToken));
  }

  protected void flushNoDecideCheck()
  {
    if (hasOptedOutTracking())
      return;
    this.mMessages.a(new a.b(this.mToken, false));
  }

  a getAnalyticsMessages()
  {
    return a.a(this.mContext);
  }

  protected String getAnonymousId()
  {
    return this.mPersistentIdentity.c();
  }

  public Map<String, String> getDeviceInfo()
  {
    return this.mDeviceInfo;
  }

  public String getDistinctId()
  {
    return this.mPersistentIdentity.d();
  }

  public c getPeople()
  {
    return this.mPeople;
  }

  n getPersistentIdentity(Context paramContext, Future<SharedPreferences> paramFuture, String paramString)
  {
    r.b local1 = new r.b()
    {
      public void a(SharedPreferences paramAnonymousSharedPreferences)
      {
        JSONArray localJSONArray = n.a(paramAnonymousSharedPreferences);
        if (localJSONArray != null)
          MixpanelAPI.this.sendAllPeopleRecords(localJSONArray);
      }
    };
    String str1 = "com.mixpanel.android.mpmetrics.MixpanelAPI_" + paramString;
    Future localFuture = sPrefsLoader.a(paramContext, str1, local1);
    String str2 = "com.mixpanel.android.mpmetrics.MixpanelAPI.TimeEvents_" + paramString;
    return new n(paramFuture, localFuture, sPrefsLoader.a(paramContext, str2, null), sPrefsLoader.a(paramContext, "com.mixpanel.android.mpmetrics.Mixpanel", null));
  }

  public JSONObject getSuperProperties()
  {
    JSONObject localJSONObject = new JSONObject();
    this.mPersistentIdentity.a(localJSONObject);
    return localJSONObject;
  }

  protected String getUserId()
  {
    return this.mPersistentIdentity.e();
  }

  public boolean hasOptedOutTracking()
  {
    return this.mPersistentIdentity.i(this.mToken);
  }

  public void identify(String paramString)
  {
    identify(paramString, true);
  }

  public boolean isAppInForeground()
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      if (this.mMixpanelActivityLifecycleCallbacks != null)
        return this.mMixpanelActivityLifecycleCallbacks.a();
    }
    else
      com.mixpanel.android.b.f.e("MixpanelAPI.API", "Your build version is below 14. This method will always return false.");
    return false;
  }

  @Deprecated
  public void logPosts()
  {
    com.mixpanel.android.b.f.c("MixpanelAPI.API", "MixpanelAPI.logPosts() is deprecated.\n    To get verbose debug level logging, add\n    <meta-data android:name=\"com.mixpanel.android.MPConfig.EnableDebugLogging\" value=\"true\" />\n    to the <application> section of your AndroidManifest.xml.");
  }

  void onBackground()
  {
    flush();
    this.mUpdatesFromMixpanel.b();
  }

  void onForeground()
  {
    this.mSessionMetadata.a();
  }

  public void optInTracking()
  {
    optInTracking(null, null);
  }

  public void optInTracking(String paramString)
  {
    optInTracking(paramString, null);
  }

  public void optInTracking(String paramString, JSONObject paramJSONObject)
  {
    this.mPersistentIdentity.a(false, this.mToken);
    if (paramString != null)
      identify(paramString);
    track("$opt_in", paramJSONObject);
  }

  public void optOutTracking()
  {
    getAnalyticsMessages().a(new a.c(this.mToken));
    if (getPeople().c())
    {
      getPeople().b();
      getPeople().a();
    }
    this.mPersistentIdentity.i();
    synchronized (this.mEventTimings)
    {
      this.mEventTimings.clear();
      this.mPersistentIdentity.j();
      this.mPersistentIdentity.b();
      this.mPersistentIdentity.a(true, this.mToken);
      return;
    }
  }

  @TargetApi(14)
  void registerMixpanelActivityLifecycleCallbacks()
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      if ((this.mContext.getApplicationContext() instanceof Application))
      {
        Application localApplication = (Application)this.mContext.getApplicationContext();
        this.mMixpanelActivityLifecycleCallbacks = new k(this, this.mConfig);
        localApplication.registerActivityLifecycleCallbacks(this.mMixpanelActivityLifecycleCallbacks);
      }
    }
    else
      return;
    com.mixpanel.android.b.f.c("MixpanelAPI.API", "Context is not an Application, Mixpanel will not automatically show in-app notifications or A/B test experiments. We won't be able to automatically flush on an app background.");
  }

  public void registerSuperProperties(JSONObject paramJSONObject)
  {
    if (hasOptedOutTracking())
      return;
    this.mPersistentIdentity.c(paramJSONObject);
  }

  public void registerSuperPropertiesMap(Map<String, Object> paramMap)
  {
    if (hasOptedOutTracking())
      return;
    if (paramMap == null)
    {
      com.mixpanel.android.b.f.e("MixpanelAPI.API", "registerSuperPropertiesMap does not accept null properties");
      return;
    }
    try
    {
      registerSuperProperties(new JSONObject(paramMap));
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      com.mixpanel.android.b.f.d("MixpanelAPI.API", "Can't have null keys in the properties of registerSuperPropertiesMap");
    }
  }

  public void registerSuperPropertiesOnce(JSONObject paramJSONObject)
  {
    if (hasOptedOutTracking())
      return;
    this.mPersistentIdentity.d(paramJSONObject);
  }

  public void registerSuperPropertiesOnceMap(Map<String, Object> paramMap)
  {
    if (hasOptedOutTracking())
      return;
    if (paramMap == null)
    {
      com.mixpanel.android.b.f.e("MixpanelAPI.API", "registerSuperPropertiesOnceMap does not accept null properties");
      return;
    }
    try
    {
      registerSuperPropertiesOnce(new JSONObject(paramMap));
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      com.mixpanel.android.b.f.d("MixpanelAPI.API", "Can't have null keys in the properties of registerSuperPropertiesOnce!");
    }
  }

  public void reset()
  {
    this.mPersistentIdentity.i();
    identify(getDistinctId(), false);
    this.mConnectIntegrations.a();
    this.mUpdatesFromMixpanel.a(new JSONArray());
    this.mUpdatesFromMixpanel.b();
    flush();
  }

  boolean sendAppOpen()
  {
    return !this.mConfig.g();
  }

  public void timeEvent(String paramString)
  {
    if (hasOptedOutTracking())
      return;
    long l = System.currentTimeMillis();
    synchronized (this.mEventTimings)
    {
      this.mEventTimings.put(paramString, Long.valueOf(l));
      this.mPersistentIdentity.a(paramString, Long.valueOf(l));
      return;
    }
  }

  public void track(String paramString)
  {
    if (hasOptedOutTracking())
      return;
    track(paramString, null);
  }

  public void track(String paramString, JSONObject paramJSONObject)
  {
    if (hasOptedOutTracking())
      return;
    track(paramString, paramJSONObject, false);
  }

  protected void track(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    if ((hasOptedOutTracking()) || ((paramBoolean) && (!this.mDecideMessages.f())));
    do
    {
      return;
      Long localLong;
      JSONObject localJSONObject;
      synchronized (this.mEventTimings)
      {
        localLong = (Long)this.mEventTimings.get(paramString);
        this.mEventTimings.remove(paramString);
        this.mPersistentIdentity.e(paramString);
        try
        {
          localJSONObject = new JSONObject();
          Iterator localIterator1 = this.mPersistentIdentity.a().entrySet().iterator();
          while (localIterator1.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator1.next();
            localJSONObject.put((String)localEntry.getKey(), (String)localEntry.getValue());
          }
        }
        catch (JSONException localJSONException)
        {
          com.mixpanel.android.b.f.e("MixpanelAPI.API", "Exception tracking event " + paramString, localJSONException);
          return;
        }
      }
      this.mPersistentIdentity.a(localJSONObject);
      double d = System.currentTimeMillis() / 1000.0D;
      long l = ()d;
      String str1 = getDistinctId();
      String str2 = getAnonymousId();
      String str3 = getUserId();
      localJSONObject.put("time", l);
      localJSONObject.put("distinct_id", str1);
      if (str2 != null)
        localJSONObject.put("$device_id", str2);
      if (str3 != null)
        localJSONObject.put("$user_id", str3);
      if (localLong != null)
        localJSONObject.put("$duration", d - localLong.longValue() / 1000.0D);
      if (paramJSONObject != null)
      {
        Iterator localIterator2 = paramJSONObject.keys();
        while (localIterator2.hasNext())
        {
          String str4 = (String)localIterator2.next();
          if (!paramJSONObject.isNull(str4))
            localJSONObject.put(str4, paramJSONObject.get(str4));
        }
      }
      a.a locala = new a.a(paramString, localJSONObject, this.mToken, paramBoolean, this.mSessionMetadata.b());
      this.mMessages.a(locala);
    }
    while (this.mTrackingDebug == null);
    this.mTrackingDebug.a(paramString);
  }

  public void trackMap(String paramString, Map<String, Object> paramMap)
  {
    if (hasOptedOutTracking())
      return;
    if (paramMap == null)
    {
      track(paramString, null);
      return;
    }
    try
    {
      track(paramString, new JSONObject(paramMap));
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      com.mixpanel.android.b.f.d("MixpanelAPI.API", "Can't have null keys in the properties of trackMap!");
    }
  }

  public void unregisterSuperProperty(String paramString)
  {
    if (hasOptedOutTracking())
      return;
    this.mPersistentIdentity.d(paramString);
  }

  public void updateSuperProperties(s params)
  {
    if (hasOptedOutTracking())
      return;
    this.mPersistentIdentity.a(params);
  }

  static abstract interface a
  {
    public abstract void a(MixpanelAPI paramMixpanelAPI);
  }

  class b
    implements l
  {
    private final v b;

    public b(v arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    public void a()
    {
    }

    public void a(JSONArray paramJSONArray)
    {
    }

    public void b()
    {
    }

    public void b(JSONArray paramJSONArray)
    {
    }

    public void c(JSONArray paramJSONArray)
    {
    }
  }

  public static abstract interface c
  {
    public abstract void a();

    public abstract void a(Activity paramActivity);

    public abstract void a(String paramString);

    public abstract void a(String paramString, double paramDouble);

    public abstract void a(String paramString, InAppNotification paramInAppNotification, JSONObject paramJSONObject);

    public abstract void a(String paramString, Object paramObject);

    public abstract void a(String paramString, JSONArray paramJSONArray);

    public abstract void a(String paramString, JSONObject paramJSONObject);

    public abstract void a(Map<String, Object> paramMap);

    public abstract void b();

    public abstract void b(String paramString);

    public abstract void b(String paramString, Object paramObject);

    public abstract void b(Map<String, Object> paramMap);

    public abstract void c(String paramString);

    public abstract void c(String paramString, Object paramObject);

    public abstract boolean c();

    public abstract c d(String paramString);

    public abstract void d();

    public abstract void e();
  }

  private class d
    implements MixpanelAPI.c
  {
    private d()
    {
    }

    private void a(final InAppNotification paramInAppNotification, final Activity paramActivity)
    {
      if (Build.VERSION.SDK_INT < 16)
      {
        com.mixpanel.android.b.f.a("MixpanelAPI.API", "Will not show notifications, os version is too low.");
        return;
      }
      paramActivity.runOnUiThread(new Runnable()
      {
        @TargetApi(16)
        public void run()
        {
          ReentrantLock localReentrantLock = UpdateDisplayState.getLockObject();
          localReentrantLock.lock();
          while (true)
          {
            InAppNotification localInAppNotification1;
            int i;
            try
            {
              if (UpdateDisplayState.hasCurrentProposal())
              {
                com.mixpanel.android.b.f.a("MixpanelAPI.API", "DisplayState is locked, will not show notifications.");
                return;
              }
              localInAppNotification1 = paramInAppNotification;
              if (localInAppNotification1 != null)
                break label454;
              localInAppNotification2 = MixpanelAPI.d.this.f();
              if (localInAppNotification2 == null)
              {
                com.mixpanel.android.b.f.a("MixpanelAPI.API", "No notification available, will not show.");
                return;
              }
              InAppNotification.a locala = localInAppNotification2.getType();
              if ((locala == InAppNotification.a.c) && (!c.b(paramActivity.getApplicationContext())))
              {
                com.mixpanel.android.b.f.a("MixpanelAPI.API", "Application is not configured to show takeover notifications, none will be shown.");
                return;
              }
              i = UpdateDisplayState.proposeDisplay(new UpdateDisplayState.DisplayState.InAppNotificationState(localInAppNotification2, com.mixpanel.android.b.a.a(paramActivity)), MixpanelAPI.d.this.g(), MixpanelAPI.this.mToken);
              if (i <= 0)
              {
                com.mixpanel.android.b.f.e("MixpanelAPI.API", "DisplayState Lock in inconsistent state! Please report this issue to Mixpanel");
                return;
              }
              switch (MixpanelAPI.3.a[locala.ordinal()])
              {
              default:
                com.mixpanel.android.b.f.e("MixpanelAPI.API", "Unrecognized notification type " + locala + " can't be shown");
                if (!MixpanelAPI.this.mConfig.j())
                  MixpanelAPI.d.this.a(localInAppNotification2);
                return;
              case 1:
                UpdateDisplayState localUpdateDisplayState = UpdateDisplayState.claimDisplayState(i);
                if (localUpdateDisplayState == null)
                {
                  com.mixpanel.android.b.f.a("MixpanelAPI.API", "Notification's display proposal was already consumed, no notification will be shown.");
                  return;
                }
                h localh = new h();
                localh.a(MixpanelAPI.this, i, (UpdateDisplayState.DisplayState.InAppNotificationState)localUpdateDisplayState.getDisplayState());
                localh.setRetainInstance(true);
                com.mixpanel.android.b.f.a("MixpanelAPI.API", "Attempting to show mini notification.");
                FragmentTransaction localFragmentTransaction = paramActivity.getFragmentManager().beginTransaction();
                localFragmentTransaction.setCustomAnimations(0, R.animator.com_mixpanel_android_slide_down);
                localFragmentTransaction.add(16908290, localh);
                try
                {
                  localFragmentTransaction.commit();
                }
                catch (IllegalStateException localIllegalStateException)
                {
                  com.mixpanel.android.b.f.a("MixpanelAPI.API", "Unable to show notification.");
                  MixpanelAPI.this.mDecideMessages.a(localInAppNotification2);
                }
                continue;
              case 2:
              }
            }
            finally
            {
              localReentrantLock.unlock();
            }
            com.mixpanel.android.b.f.a("MixpanelAPI.API", "Sending intent for takeover notification.");
            Intent localIntent = new Intent(paramActivity.getApplicationContext(), TakeoverInAppActivity.class);
            localIntent.addFlags(268435456);
            localIntent.addFlags(131072);
            localIntent.putExtra("com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.INTENT_ID_KEY", i);
            paramActivity.startActivity(localIntent);
            continue;
            label454: InAppNotification localInAppNotification2 = localInAppNotification1;
          }
        }
      });
    }

    private JSONObject d(String paramString, Object paramObject)
      throws JSONException
    {
      JSONObject localJSONObject = new JSONObject();
      String str1 = g();
      String str2 = MixpanelAPI.this.getAnonymousId();
      localJSONObject.put(paramString, paramObject);
      localJSONObject.put("$token", MixpanelAPI.this.mToken);
      localJSONObject.put("$time", System.currentTimeMillis());
      if (str2 != null)
        localJSONObject.put("$device_id", str2);
      if (str1 != null)
      {
        localJSONObject.put("$distinct_id", str1);
        localJSONObject.put("$user_id", str1);
      }
      localJSONObject.put("$mp_metadata", MixpanelAPI.this.mSessionMetadata.c());
      return localJSONObject;
    }

    public void a()
    {
      b("$transactions");
    }

    public void a(Activity paramActivity)
    {
      if (Build.VERSION.SDK_INT < 16)
        return;
      a(null, paramActivity);
    }

    public void a(InAppNotification paramInAppNotification)
    {
      if (paramInAppNotification == null);
      do
      {
        return;
        MixpanelAPI.this.mPersistentIdentity.a(Integer.valueOf(paramInAppNotification.getId()));
      }
      while (MixpanelAPI.this.hasOptedOutTracking());
      a("$campaign_delivery", paramInAppNotification, null);
      MixpanelAPI.c localc = MixpanelAPI.this.getPeople().d(g());
      if (localc != null)
      {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
        JSONObject localJSONObject = paramInAppNotification.getCampaignProperties();
        try
        {
          localJSONObject.put("$time", localSimpleDateFormat.format(new Date()));
          localc.b("$campaigns", Integer.valueOf(paramInAppNotification.getId()));
          localc.b("$notifications", localJSONObject);
          return;
        }
        catch (JSONException localJSONException)
        {
          while (true)
            com.mixpanel.android.b.f.e("MixpanelAPI.API", "Exception trying to track an in-app notification seen", localJSONException);
        }
      }
      com.mixpanel.android.b.f.e("MixpanelAPI.API", "No identity found. Make sure to call getPeople().identify() before showing in-app notifications.");
    }

    public void a(String paramString)
    {
      if (MixpanelAPI.this.hasOptedOutTracking())
        return;
      synchronized (MixpanelAPI.this.mPersistentIdentity)
      {
        MixpanelAPI.this.mPersistentIdentity.b(paramString);
        MixpanelAPI.this.mDecideMessages.a(paramString);
        MixpanelAPI.this.pushWaitingPeopleRecord();
        return;
      }
    }

    public void a(String paramString, double paramDouble)
    {
      if (MixpanelAPI.this.hasOptedOutTracking())
        return;
      HashMap localHashMap = new HashMap();
      localHashMap.put(paramString, Double.valueOf(paramDouble));
      c(localHashMap);
    }

    public void a(String paramString, InAppNotification paramInAppNotification, JSONObject paramJSONObject)
    {
      if (MixpanelAPI.this.hasOptedOutTracking())
        return;
      JSONObject localJSONObject = paramInAppNotification.getCampaignProperties();
      if (paramJSONObject != null)
        try
        {
          Iterator localIterator = paramJSONObject.keys();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localJSONObject.put(str, paramJSONObject.get(str));
          }
        }
        catch (JSONException localJSONException)
        {
          com.mixpanel.android.b.f.e("MixpanelAPI.API", "Exception merging provided properties with notification properties", localJSONException);
        }
      MixpanelAPI.this.track(paramString, localJSONObject);
    }

    public void a(String paramString, Object paramObject)
    {
      if (MixpanelAPI.this.hasOptedOutTracking())
        return;
      try
      {
        a(new JSONObject().put(paramString, paramObject));
        return;
      }
      catch (JSONException localJSONException)
      {
        com.mixpanel.android.b.f.e("MixpanelAPI.API", "set", localJSONException);
      }
    }

    public void a(String paramString, JSONArray paramJSONArray)
    {
      if (MixpanelAPI.this.hasOptedOutTracking())
        return;
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put(paramString, paramJSONArray);
        JSONObject localJSONObject2 = d("$union", localJSONObject1);
        MixpanelAPI.this.recordPeopleMessage(localJSONObject2);
        return;
      }
      catch (JSONException localJSONException)
      {
        com.mixpanel.android.b.f.e("MixpanelAPI.API", "Exception unioning a property");
      }
    }

    public void a(String paramString, JSONObject paramJSONObject)
    {
      if (MixpanelAPI.this.hasOptedOutTracking())
        return;
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject1.put(paramString, paramJSONObject);
        JSONObject localJSONObject2 = d("$merge", localJSONObject1);
        MixpanelAPI.this.recordPeopleMessage(localJSONObject2);
        return;
      }
      catch (JSONException localJSONException)
      {
        com.mixpanel.android.b.f.e("MixpanelAPI.API", "Exception merging a property", localJSONException);
      }
    }

    public void a(Map<String, Object> paramMap)
    {
      if (MixpanelAPI.this.hasOptedOutTracking())
        return;
      if (paramMap == null)
      {
        com.mixpanel.android.b.f.e("MixpanelAPI.API", "setMap does not accept null properties");
        return;
      }
      try
      {
        a(new JSONObject(paramMap));
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        com.mixpanel.android.b.f.d("MixpanelAPI.API", "Can't have null keys in the properties of setMap!");
      }
    }

    public void a(JSONObject paramJSONObject)
    {
      if (MixpanelAPI.this.hasOptedOutTracking())
        return;
      JSONObject localJSONObject1;
      try
      {
        localJSONObject1 = new JSONObject(MixpanelAPI.this.mDeviceInfo);
        Iterator localIterator = paramJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localJSONObject1.put(str, paramJSONObject.get(str));
        }
      }
      catch (JSONException localJSONException)
      {
        com.mixpanel.android.b.f.e("MixpanelAPI.API", "Exception setting people properties", localJSONException);
        return;
      }
      JSONObject localJSONObject2 = d("$set", localJSONObject1);
      MixpanelAPI.this.recordPeopleMessage(localJSONObject2);
    }

    public void b()
    {
      try
      {
        JSONObject localJSONObject = d("$delete", JSONObject.NULL);
        MixpanelAPI.this.recordPeopleMessage(localJSONObject);
        return;
      }
      catch (JSONException localJSONException)
      {
        com.mixpanel.android.b.f.e("MixpanelAPI.API", "Exception deleting a user");
      }
    }

    public void b(String paramString)
    {
      if (MixpanelAPI.this.hasOptedOutTracking())
        return;
      try
      {
        JSONArray localJSONArray = new JSONArray();
        localJSONArray.put(paramString);
        JSONObject localJSONObject = d("$unset", localJSONArray);
        MixpanelAPI.this.recordPeopleMessage(localJSONObject);
        return;
      }
      catch (JSONException localJSONException)
      {
        com.mixpanel.android.b.f.e("MixpanelAPI.API", "Exception unsetting a property", localJSONException);
      }
    }

    public void b(String paramString, Object paramObject)
    {
      if (MixpanelAPI.this.hasOptedOutTracking())
        return;
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put(paramString, paramObject);
        JSONObject localJSONObject2 = d("$append", localJSONObject1);
        MixpanelAPI.this.recordPeopleMessage(localJSONObject2);
        return;
      }
      catch (JSONException localJSONException)
      {
        com.mixpanel.android.b.f.e("MixpanelAPI.API", "Exception appending a property", localJSONException);
      }
    }

    public void b(Map<String, Object> paramMap)
    {
      if (MixpanelAPI.this.hasOptedOutTracking())
        return;
      if (paramMap == null)
      {
        com.mixpanel.android.b.f.e("MixpanelAPI.API", "setOnceMap does not accept null properties");
        return;
      }
      try
      {
        b(new JSONObject(paramMap));
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        com.mixpanel.android.b.f.d("MixpanelAPI.API", "Can't have null keys in the properties setOnceMap!");
      }
    }

    public void b(JSONObject paramJSONObject)
    {
      if (MixpanelAPI.this.hasOptedOutTracking())
        return;
      try
      {
        JSONObject localJSONObject = d("$set_once", paramJSONObject);
        MixpanelAPI.this.recordPeopleMessage(localJSONObject);
        return;
      }
      catch (JSONException localJSONException)
      {
        com.mixpanel.android.b.f.e("MixpanelAPI.API", "Exception setting people properties");
      }
    }

    public void c(String paramString)
    {
      synchronized (MixpanelAPI.this.mPersistentIdentity)
      {
        if (MixpanelAPI.this.mPersistentIdentity.g() == null)
          return;
        MixpanelAPI.this.mPersistentIdentity.c(paramString);
        JSONArray localJSONArray = new JSONArray();
        localJSONArray.put(paramString);
        a("$android_devices", localJSONArray);
        return;
      }
    }

    public void c(String paramString, Object paramObject)
    {
      if (MixpanelAPI.this.hasOptedOutTracking())
        return;
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put(paramString, paramObject);
        JSONObject localJSONObject2 = d("$remove", localJSONObject1);
        MixpanelAPI.this.recordPeopleMessage(localJSONObject2);
        return;
      }
      catch (JSONException localJSONException)
      {
        com.mixpanel.android.b.f.e("MixpanelAPI.API", "Exception appending a property", localJSONException);
      }
    }

    public void c(Map<String, ? extends Number> paramMap)
    {
      if (MixpanelAPI.this.hasOptedOutTracking())
        return;
      JSONObject localJSONObject1 = new JSONObject(paramMap);
      try
      {
        JSONObject localJSONObject2 = d("$add", localJSONObject1);
        MixpanelAPI.this.recordPeopleMessage(localJSONObject2);
        return;
      }
      catch (JSONException localJSONException)
      {
        com.mixpanel.android.b.f.e("MixpanelAPI.API", "Exception incrementing properties", localJSONException);
      }
    }

    public boolean c()
    {
      return g() != null;
    }

    public MixpanelAPI.c d(final String paramString)
    {
      // Byte code:
      //   0: aload_1
      //   1: ifnonnull +5 -> 6
      //   4: aconst_null
      //   5: areturn
      //   6: new 325	com/mixpanel/android/mpmetrics/MixpanelAPI$d$1
      //   9: dup
      //   10: aload_0
      //   11: aload_1
      //   12: invokespecial 328	com/mixpanel/android/mpmetrics/MixpanelAPI$d$1:<init>	(Lcom/mixpanel/android/mpmetrics/MixpanelAPI$d;Ljava/lang/String;)V
      //   15: areturn
    }

    public void d()
    {
      MixpanelAPI.this.mPersistentIdentity.k();
      a("$android_devices", new JSONArray());
    }

    public void e()
    {
      JSONArray localJSONArray = MixpanelAPI.this.mDecideMessages.c();
      MixpanelAPI.this.mUpdatesFromMixpanel.c(localJSONArray);
    }

    public InAppNotification f()
    {
      return MixpanelAPI.this.mDecideMessages.a(MixpanelAPI.this.mConfig.j());
    }

    public String g()
    {
      return MixpanelAPI.this.mPersistentIdentity.g();
    }
  }

  private class e
    implements MixpanelAPI.g, Runnable
  {
    private final Set<m> b = Collections.newSetFromMap(new ConcurrentHashMap());
    private final Executor c = Executors.newSingleThreadExecutor();

    private e()
    {
    }

    public void a()
    {
      this.c.execute(this);
    }

    public void run()
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
        ((m)localIterator.next()).a();
      MixpanelAPI.this.mConnectIntegrations.a(MixpanelAPI.this.mDecideMessages.d());
    }
  }

  private class f
    implements MixpanelAPI.g
  {
    private f()
    {
    }

    public void a()
    {
    }
  }

  private static abstract interface g extends f.a
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.MixpanelAPI
 * JD-Core Version:    0.6.2
 */