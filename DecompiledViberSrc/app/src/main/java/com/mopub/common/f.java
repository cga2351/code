package com.mopub.common;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Reflection;
import com.mopub.common.util.Reflection.MethodBuilder;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class f
  implements ExternalViewabilitySession
{
  private static Boolean a;
  private static boolean b;
  private static boolean c = false;
  private static final Map<String, String> d = new HashMap();
  private Object e;
  private Object f;
  private Map<String, String> g = new HashMap();
  private boolean h;

  static
  {
    d.put("moatClientLevel1", "level1");
    d.put("moatClientLevel2", "level2");
    d.put("moatClientLevel3", "level3");
    d.put("moatClientLevel4", "level4");
    d.put("moatClientSlicer1", "slicer1");
    d.put("moatClientSlicer2", "slicer2");
  }

  private void a(String paramString, Set<String> paramSet)
  {
    this.g.clear();
    this.g.put("partnerCode", "mopubinapphtmvideo468906546585");
    this.g.put("zMoatVASTIDs", TextUtils.join(";", paramSet));
    if (TextUtils.isEmpty(paramString));
    String str1;
    do
    {
      return;
      Uri localUri = Uri.parse(paramString);
      List localList = localUri.getPathSegments();
      if ((localList.size() > 0) && (!TextUtils.isEmpty((CharSequence)localList.get(0))))
        this.g.put("partnerCode", localList.get(0));
      str1 = localUri.getFragment();
    }
    while (TextUtils.isEmpty(str1));
    String[] arrayOfString1 = str1.split("&");
    int i = arrayOfString1.length;
    int j = 0;
    label141: String[] arrayOfString2;
    if (j < i)
    {
      arrayOfString2 = arrayOfString1[j].split("=");
      if (arrayOfString2.length >= 2)
        break label173;
    }
    while (true)
    {
      j++;
      break label141;
      break;
      label173: String str2 = arrayOfString2[0];
      String str3 = arrayOfString2[1];
      if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)) && (d.containsKey(str2)))
        this.g.put(d.get(str2), str3);
    }
  }

  static boolean a()
  {
    return (!b) && (c());
  }

  private boolean a(ExternalViewabilitySession.VideoEvent paramVideoEvent, int paramInt)
    throws Exception
  {
    if (paramVideoEvent.getMoatEnumName() == null)
      return false;
    Class localClass = Class.forName("com.moat.analytics.mobile.mpub.MoatAdEventType");
    Enum localEnum = Enum.valueOf(localClass.asSubclass(Enum.class), paramVideoEvent.getMoatEnumName());
    Class[] arrayOfClass = { localClass, Integer.class };
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = localEnum;
    arrayOfObject[1] = Integer.valueOf(paramInt);
    Object localObject = Reflection.instantiateClassWithConstructor("com.moat.analytics.mobile.mpub.MoatAdEvent", Object.class, arrayOfClass, arrayOfObject);
    new Reflection.MethodBuilder(this.f, "dispatchEvent").addParam("com.moat.analytics.mobile.mpub.MoatAdEvent", localObject).execute();
    return true;
  }

  static void b()
  {
    b = true;
  }

  private static boolean c()
  {
    MoPubLog.SdkLogEvent localSdkLogEvent;
    Object[] arrayOfObject;
    StringBuilder localStringBuilder;
    if (a == null)
    {
      a = Boolean.valueOf(Reflection.classFound("com.moat.analytics.mobile.mpub.MoatFactory"));
      localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      arrayOfObject = new Object[1];
      localStringBuilder = new StringBuilder().append("Moat is ");
      if (!a.booleanValue())
        break label79;
    }
    label79: for (String str = ""; ; str = "un")
    {
      arrayOfObject[0] = (str + "available via reflection.");
      MoPubLog.log(localSdkLogEvent, arrayOfObject);
      return a.booleanValue();
    }
  }

  public Boolean createDisplaySession(Context paramContext, WebView paramWebView, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramContext);
    if (!a())
      return null;
    try
    {
      this.e = new Reflection.MethodBuilder(new Reflection.MethodBuilder(null, "create").setStatic("com.moat.analytics.mobile.mpub.MoatFactory").execute(), "createWebAdTracker").addParam(WebView.class, paramWebView).execute();
      if (!paramBoolean)
        new Reflection.MethodBuilder(this.e, "startTracking").execute();
      Boolean localBoolean = Boolean.valueOf(true);
      return localBoolean;
    }
    catch (Exception localException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = ("Unable to execute Moat start display session: " + localException.getMessage());
      MoPubLog.log(localSdkLogEvent, arrayOfObject);
    }
    return Boolean.valueOf(false);
  }

  public Boolean createVideoSession(Activity paramActivity, View paramView, Set<String> paramSet, Map<String, String> paramMap)
  {
    Preconditions.checkNotNull(paramActivity);
    Preconditions.checkNotNull(paramView);
    Preconditions.checkNotNull(paramSet);
    Preconditions.checkNotNull(paramMap);
    if (!a())
      return null;
    a((String)paramMap.get("moat"), paramSet);
    String str = (String)this.g.get("partnerCode");
    if (TextUtils.isEmpty(str))
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "partnerCode was empty when starting Moat video session" });
      return Boolean.valueOf(false);
    }
    try
    {
      Object localObject = Reflection.instantiateClassWithConstructor("com.moat.analytics.mobile.mpub.ReactiveVideoTrackerPlugin", Object.class, new Class[] { String.class }, new Object[] { str });
      this.f = new Reflection.MethodBuilder(new Reflection.MethodBuilder(null, "create").setStatic("com.moat.analytics.mobile.mpub.MoatFactory").execute(), "createCustomTracker").addParam("com.moat.analytics.mobile.mpub.MoatPlugin", localObject).execute();
      Boolean localBoolean = Boolean.valueOf(true);
      return localBoolean;
    }
    catch (Exception localException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = ("Unable to execute Moat start video session: " + localException.getMessage());
      MoPubLog.log(localSdkLogEvent, arrayOfObject);
    }
    return Boolean.valueOf(false);
  }

  public Boolean endDisplaySession()
  {
    if (!a())
      return null;
    if (this.e == null)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Moat WebAdTracker unexpectedly null." });
      return Boolean.valueOf(false);
    }
    try
    {
      new Reflection.MethodBuilder(this.e, "stopTracking").execute();
      Boolean localBoolean = Boolean.valueOf(true);
      return localBoolean;
    }
    catch (Exception localException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = ("Unable to execute Moat end session: " + localException.getMessage());
      MoPubLog.log(localSdkLogEvent, arrayOfObject);
    }
    return Boolean.valueOf(false);
  }

  public Boolean endVideoSession()
  {
    if (!a())
      return null;
    if (this.f == null)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Moat VideoAdTracker unexpectedly null." });
      return Boolean.valueOf(false);
    }
    try
    {
      new Reflection.MethodBuilder(this.f, "stopTracking").execute();
      Boolean localBoolean = Boolean.valueOf(true);
      return localBoolean;
    }
    catch (Exception localException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = ("Unable to execute Moat end video session: " + localException.getMessage());
      MoPubLog.log(localSdkLogEvent, arrayOfObject);
    }
    return Boolean.valueOf(false);
  }

  public String getName()
  {
    return "Moat";
  }

  public Boolean initialize(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    if (!a())
      return null;
    if (c)
      return Boolean.valueOf(true);
    Application localApplication;
    if ((paramContext instanceof Activity))
      localApplication = ((Activity)paramContext).getApplication();
    try
    {
      while (true)
      {
        Object localObject = Reflection.instantiateClassWithEmptyConstructor("com.moat.analytics.mobile.mpub.MoatOptions", Object.class);
        localObject.getClass().getField("disableAdIdCollection").setBoolean(localObject, true);
        localObject.getClass().getField("disableLocationServices").setBoolean(localObject, true);
        new Reflection.MethodBuilder(new Reflection.MethodBuilder(null, "getInstance").setStatic("com.moat.analytics.mobile.mpub.MoatAnalytics").execute(), "start").addParam("com.moat.analytics.mobile.mpub.MoatOptions", localObject).addParam(Application.class, localApplication).execute();
        c = true;
        Boolean localBoolean = Boolean.valueOf(true);
        return localBoolean;
        try
        {
          localApplication = (Application)paramContext.getApplicationContext();
        }
        catch (ClassCastException localClassCastException)
        {
          MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Unable to initialize Moat, error obtaining application context." });
          return Boolean.valueOf(false);
        }
      }
    }
    catch (Exception localException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = ("Unable to initialize Moat: " + localException.getMessage());
      MoPubLog.log(localSdkLogEvent, arrayOfObject);
    }
    return Boolean.valueOf(false);
  }

  public Boolean invalidate()
  {
    if (!a())
      return null;
    this.e = null;
    this.f = null;
    this.g.clear();
    return Boolean.valueOf(true);
  }

  public Boolean onVideoPrepared(View paramView, int paramInt)
  {
    Preconditions.checkNotNull(paramView);
    if (!a())
      return null;
    if (this.f == null)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Moat VideoAdTracker unexpectedly null." });
      return Boolean.valueOf(false);
    }
    if (this.h)
      return Boolean.valueOf(false);
    try
    {
      new Reflection.MethodBuilder(this.f, "trackVideoAd").addParam(Map.class, this.g).addParam(Integer.class, Integer.valueOf(paramInt)).addParam(View.class, paramView).execute();
      this.h = true;
      Boolean localBoolean = Boolean.valueOf(true);
      return localBoolean;
    }
    catch (Exception localException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = ("Unable to execute Moat onVideoPrepared: " + localException.getMessage());
      MoPubLog.log(localSdkLogEvent, arrayOfObject);
    }
    return Boolean.valueOf(false);
  }

  public Boolean recordVideoEvent(ExternalViewabilitySession.VideoEvent paramVideoEvent, int paramInt)
  {
    Preconditions.checkNotNull(paramVideoEvent);
    if (!a())
      return null;
    if (this.f == null)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Moat VideoAdTracker unexpectedly null." });
      return Boolean.valueOf(false);
    }
    try
    {
      switch (1.a[paramVideoEvent.ordinal()])
      {
      case 10:
      case 11:
      case 12:
      case 13:
      default:
        MoPubLog.SdkLogEvent localSdkLogEvent2 = MoPubLog.SdkLogEvent.CUSTOM;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = ("Unexpected video event: " + paramVideoEvent.getMoatEnumName());
        MoPubLog.log(localSdkLogEvent2, arrayOfObject2);
        return Boolean.valueOf(false);
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      }
      a(paramVideoEvent, paramInt);
      Boolean localBoolean = Boolean.valueOf(true);
      return localBoolean;
    }
    catch (Exception localException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent1 = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = ("Video event " + paramVideoEvent.getMoatEnumName() + " failed. " + localException.getMessage());
      MoPubLog.log(localSdkLogEvent1, arrayOfObject1);
    }
    return Boolean.valueOf(false);
  }

  public Boolean registerVideoObstruction(View paramView)
  {
    Preconditions.checkNotNull(paramView);
    if (!a())
      return null;
    return Boolean.valueOf(true);
  }

  public Boolean startDeferredDisplaySession(Activity paramActivity)
  {
    if (!a())
      return null;
    if (this.e == null)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "MoatWebAdTracker unexpectedly null." });
      return Boolean.valueOf(false);
    }
    try
    {
      new Reflection.MethodBuilder(this.e, "startTracking").execute();
      Boolean localBoolean = Boolean.valueOf(true);
      return localBoolean;
    }
    catch (Exception localException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = ("Unable to record deferred display session for Moat: " + localException.getMessage());
      MoPubLog.log(localSdkLogEvent, arrayOfObject);
    }
    return Boolean.valueOf(false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.f
 * JD-Core Version:    0.6.2
 */