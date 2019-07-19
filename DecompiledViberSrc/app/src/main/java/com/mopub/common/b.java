package com.mopub.common;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Reflection;
import com.mopub.common.util.Reflection.MethodBuilder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class b
  implements ExternalViewabilitySession
{
  private static Object a;
  private static Object b;
  private static Boolean c;
  private static boolean d;
  private Object e;
  private Object f;

  private void a(ExternalViewabilitySession.VideoEvent paramVideoEvent)
    throws Exception
  {
    a(paramVideoEvent, null);
  }

  private void a(ExternalViewabilitySession.VideoEvent paramVideoEvent, String paramString)
    throws Exception
  {
    Reflection.MethodBuilder localMethodBuilder = new Reflection.MethodBuilder(new Reflection.MethodBuilder(this.f, "getAvidVideoPlaybackListener").execute(), paramVideoEvent.getAvidMethodName());
    if (!TextUtils.isEmpty(paramString))
      localMethodBuilder.addParam(String.class, paramString);
    localMethodBuilder.execute();
  }

  static boolean a()
  {
    return (!d) && (c());
  }

  static void b()
  {
    d = true;
  }

  private static boolean c()
  {
    MoPubLog.SdkLogEvent localSdkLogEvent;
    Object[] arrayOfObject;
    StringBuilder localStringBuilder;
    if (c == null)
    {
      c = Boolean.valueOf(Reflection.classFound("com.integralads.avid.library.mopub.session.AvidAdSessionManager"));
      localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      arrayOfObject = new Object[1];
      localStringBuilder = new StringBuilder().append("Avid is ");
      if (!c.booleanValue())
        break label79;
    }
    label79: for (String str = ""; ; str = "un")
    {
      arrayOfObject[0] = (str + "available via reflection.");
      MoPubLog.log(localSdkLogEvent, arrayOfObject);
      return c.booleanValue();
    }
  }

  private static Object d()
  {
    if (a == null);
    try
    {
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = String.class;
      arrayOfClass[1] = Boolean.TYPE;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = "5.7.1";
      arrayOfObject2[1] = Boolean.valueOf(true);
      a = Reflection.instantiateClassWithConstructor("com.integralads.avid.library.mopub.session.ExternalAvidAdSessionContext", Object.class, arrayOfClass, arrayOfObject2);
      return a;
    }
    catch (Exception localException)
    {
      while (true)
      {
        MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = ("Unable to generate Avid deferred ad session context: " + localException.getMessage());
        MoPubLog.log(localSdkLogEvent, arrayOfObject1);
      }
    }
  }

  private static Object e()
  {
    if (b == null);
    try
    {
      b = Reflection.instantiateClassWithConstructor("com.integralads.avid.library.mopub.session.ExternalAvidAdSessionContext", Object.class, new Class[] { String.class }, new Object[] { "5.7.1" });
      return b;
    }
    catch (Exception localException)
    {
      while (true)
      {
        MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = ("Unable to generate Avid ad session context: " + localException.getMessage());
        MoPubLog.log(localSdkLogEvent, arrayOfObject);
      }
    }
  }

  public Boolean createDisplaySession(Context paramContext, WebView paramWebView, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramWebView);
    if (!a())
      return null;
    Object localObject;
    if (paramBoolean)
      localObject = d();
    while (true)
    {
      Activity localActivity;
      if ((paramContext instanceof Activity))
        localActivity = (Activity)paramContext;
      try
      {
        while (true)
        {
          this.e = new Reflection.MethodBuilder(null, "startAvidDisplayAdSession").setStatic("com.integralads.avid.library.mopub.session.AvidAdSessionManager").addParam(Context.class, paramContext).addParam("com.integralads.avid.library.mopub.session.ExternalAvidAdSessionContext", localObject).execute();
          new Reflection.MethodBuilder(this.e, "registerAdView").addParam(View.class, paramWebView).addParam(Activity.class, localActivity).execute();
          Boolean localBoolean = Boolean.valueOf(true);
          return localBoolean;
          localObject = e();
          break;
          localActivity = null;
        }
      }
      catch (Exception localException)
      {
        MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = ("Unable to execute Avid start display session: " + localException.getMessage());
        MoPubLog.log(localSdkLogEvent, arrayOfObject);
      }
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
    try
    {
      this.f = new Reflection.MethodBuilder(null, "startAvidManagedVideoAdSession").setStatic("com.integralads.avid.library.mopub.session.AvidAdSessionManager").addParam(Context.class, paramActivity).addParam("com.integralads.avid.library.mopub.session.ExternalAvidAdSessionContext", e()).execute();
      new Reflection.MethodBuilder(this.f, "registerAdView").addParam(View.class, paramView).addParam(Activity.class, paramActivity).execute();
      if (!TextUtils.isEmpty((CharSequence)paramMap.get("avid")))
        new Reflection.MethodBuilder(this.f, "injectJavaScriptResource").addParam(String.class, paramMap.get("avid")).execute();
      Iterator localIterator = paramSet.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!TextUtils.isEmpty(str))
          new Reflection.MethodBuilder(this.f, "injectJavaScriptResource").addParam(String.class, str).execute();
      }
    }
    catch (Exception localException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = ("Unable to execute Avid start video session: " + localException.getMessage());
      MoPubLog.log(localSdkLogEvent, arrayOfObject);
      return Boolean.valueOf(false);
    }
    Boolean localBoolean = Boolean.valueOf(true);
    return localBoolean;
  }

  public Boolean endDisplaySession()
  {
    if (!a())
      return null;
    if (this.e == null)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Avid DisplayAdSession unexpectedly null." });
      return Boolean.valueOf(false);
    }
    try
    {
      new Reflection.MethodBuilder(this.e, "endSession").execute();
      Boolean localBoolean = Boolean.valueOf(true);
      return localBoolean;
    }
    catch (Exception localException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = ("Unable to execute Avid end session: " + localException.getMessage());
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
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Avid VideoAdSession unexpectedly null." });
      return Boolean.valueOf(false);
    }
    try
    {
      new Reflection.MethodBuilder(this.f, "endSession").execute();
      Boolean localBoolean = Boolean.valueOf(true);
      return localBoolean;
    }
    catch (Exception localException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = ("Unable to execute Avid end video session: " + localException.getMessage());
      MoPubLog.log(localSdkLogEvent, arrayOfObject);
    }
    return Boolean.valueOf(false);
  }

  public String getName()
  {
    return "AVID";
  }

  public Boolean initialize(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    if (!a())
      return null;
    return Boolean.valueOf(true);
  }

  public Boolean invalidate()
  {
    if (!a())
      return null;
    this.e = null;
    this.f = null;
    return Boolean.valueOf(true);
  }

  public Boolean onVideoPrepared(View paramView, int paramInt)
  {
    Preconditions.checkNotNull(paramView);
    if (!a())
      return null;
    return Boolean.valueOf(true);
  }

  public Boolean recordVideoEvent(ExternalViewabilitySession.VideoEvent paramVideoEvent, int paramInt)
  {
    Preconditions.checkNotNull(paramVideoEvent);
    if (!a())
      return null;
    if (this.f == null)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Avid VideoAdSession unexpectedly null." });
      return Boolean.valueOf(false);
    }
    try
    {
      switch (1.a[paramVideoEvent.ordinal()])
      {
      default:
        MoPubLog.SdkLogEvent localSdkLogEvent2 = MoPubLog.SdkLogEvent.CUSTOM;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = ("Unexpected video event type: " + paramVideoEvent);
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
      case 10:
      case 11:
      case 12:
        a(paramVideoEvent);
        return Boolean.valueOf(true);
      case 13:
      }
      a(paramVideoEvent, "error");
      Boolean localBoolean = Boolean.valueOf(true);
      return localBoolean;
    }
    catch (Exception localException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent1 = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = ("Unable to execute Avid video event for " + paramVideoEvent.getAvidMethodName() + ": " + localException.getMessage());
      MoPubLog.log(localSdkLogEvent1, arrayOfObject1);
    }
    return Boolean.valueOf(false);
  }

  public Boolean registerVideoObstruction(View paramView)
  {
    Preconditions.checkNotNull(paramView);
    if (!a())
      return null;
    if (this.f == null)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Avid VideoAdSession unexpectedly null." });
      return Boolean.valueOf(false);
    }
    try
    {
      new Reflection.MethodBuilder(this.f, "registerFriendlyObstruction").addParam(View.class, paramView).execute();
      Boolean localBoolean = Boolean.valueOf(true);
      return localBoolean;
    }
    catch (Exception localException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = ("Unable to register Avid video obstructions: " + localException.getMessage());
      MoPubLog.log(localSdkLogEvent, arrayOfObject);
    }
    return Boolean.valueOf(false);
  }

  public Boolean startDeferredDisplaySession(Activity paramActivity)
  {
    if (!a())
      return null;
    if (this.e == null)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Avid DisplayAdSession unexpectedly null." });
      return Boolean.valueOf(false);
    }
    try
    {
      new Reflection.MethodBuilder(new Reflection.MethodBuilder(null, "getInstance").setStatic("com.integralads.avid.library.mopub.AvidManager").execute(), "registerActivity").addParam(Activity.class, paramActivity).execute();
      Object localObject = new Reflection.MethodBuilder(this.e, "getAvidDeferredAdSessionListener").execute();
      if (localObject == null)
      {
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Avid AdSessionListener unexpectedly null." });
        return Boolean.valueOf(false);
      }
      new Reflection.MethodBuilder(localObject, "recordReadyEvent").execute();
      Boolean localBoolean = Boolean.valueOf(true);
      return localBoolean;
    }
    catch (Exception localException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = ("Unable to execute Avid record deferred session: " + localException.getMessage());
      MoPubLog.log(localSdkLogEvent, arrayOfObject);
    }
    return Boolean.valueOf(false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.b
 * JD-Core Version:    0.6.2
 */