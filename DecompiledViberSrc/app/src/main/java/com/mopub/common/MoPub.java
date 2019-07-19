package com.mopub.common;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.privacy.PersonalInfoManager;
import com.mopub.common.util.Reflection;
import com.mopub.common.util.Reflection.MethodBuilder;
import com.mopub.network.Networking;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class MoPub
{
  public static final String SDK_VERSION = "5.7.1";
  private static volatile LocationAwareness a = LocationAwareness.NORMAL;
  private static volatile int b = 6;
  private static volatile long c = 60000L;
  private static volatile BrowserAgent d = BrowserAgent.IN_APP;
  private static volatile boolean e = false;
  private static boolean f = false;
  private static Method g;
  private static boolean h = false;
  private static boolean i = false;
  private static AdapterConfigurationManager j;
  private static PersonalInfoManager k;

  static String a(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    if (j == null)
      return null;
    return j.a(paramContext);
  }

  @VisibleForTesting
  static void a(Activity paramActivity)
  {
    if (!f)
      f = true;
    try
    {
      g = Reflection.getDeclaredMethodWithTraversal(Class.forName("com.mopub.mobileads.MoPubRewardedVideoManager"), "updateActivity", new Class[] { Activity.class });
      label32: if (g != null);
      try
      {
        g.invoke(null, new Object[] { paramActivity });
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        MoPubLog.log(MoPubLog.SdkLogEvent.ERROR, new Object[] { "Error while attempting to access the update activity method - this should not have happened", localIllegalAccessException });
        return;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        MoPubLog.log(MoPubLog.SdkLogEvent.ERROR, new Object[] { "Error while attempting to access the update activity method - this should not have happened", localInvocationTargetException });
        return;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label32;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      break label32;
    }
  }

  private static void a(Activity paramActivity, SdkConfiguration paramSdkConfiguration)
  {
    Preconditions.checkNotNull(paramActivity);
    Preconditions.checkNotNull(paramSdkConfiguration);
    try
    {
      new Reflection.MethodBuilder(null, "initializeRewardedVideo").setStatic(Class.forName("com.mopub.mobileads.MoPubRewardedVideos")).setAccessible().addParam(Activity.class, paramActivity).addParam(SdkConfiguration.class, paramSdkConfiguration).execute();
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "initializeRewardedVideo was called without the rewarded video module" });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "initializeRewardedVideo was called without the rewarded video module" });
      return;
    }
    catch (Exception localException)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.ERROR, new Object[] { "Error while initializing rewarded video", localException });
    }
  }

  private static void b(SdkInitializationListener paramSdkInitializationListener)
  {
    i = false;
    h = true;
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        if (this.a != null)
          this.a.onInitializationFinished();
      }
    });
  }

  public static boolean canCollectPersonalInformation()
  {
    return (k != null) && (k.canCollectPersonalInformation());
  }

  public static void disableViewability(ExternalViewabilitySessionManager.ViewabilityVendor paramViewabilityVendor)
  {
    Preconditions.checkNotNull(paramViewabilityVendor);
    paramViewabilityVendor.disable();
  }

  public static List<String> getAdapterConfigurationInfo()
  {
    AdapterConfigurationManager localAdapterConfigurationManager = j;
    if (localAdapterConfigurationManager != null)
      return localAdapterConfigurationManager.getAdapterConfigurationInfo();
    return null;
  }

  public static BrowserAgent getBrowserAgent()
  {
    Preconditions.checkNotNull(d);
    return d;
  }

  public static LocationAwareness getLocationAwareness()
  {
    Preconditions.checkNotNull(a);
    return a;
  }

  public static int getLocationPrecision()
  {
    return b;
  }

  public static long getMinimumLocationRefreshTimeMillis()
  {
    return c;
  }

  public static PersonalInfoManager getPersonalInformationManager()
  {
    return k;
  }

  public static void initializeSdk(Context paramContext, SdkConfiguration paramSdkConfiguration, SdkInitializationListener paramSdkInitializationListener)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramSdkConfiguration);
    MoPubLog.setLogLevel(paramSdkConfiguration.a());
    MoPubLog.log(MoPubLog.SdkLogEvent.INIT_STARTED, new Object[0]);
    MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = ("SDK initialize has been called with ad unit: " + paramSdkConfiguration.getAdUnitId());
    MoPubLog.log(localSdkLogEvent, arrayOfObject);
    if ((paramContext instanceof Activity))
      a((Activity)paramContext, paramSdkConfiguration);
    if (h)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "MoPub SDK is already initialized" });
      b(paramSdkInitializationListener);
      return;
    }
    if (i)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "MoPub SDK is currently initializing." });
      return;
    }
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "MoPub can only be initialized on the main thread." });
      return;
    }
    i = true;
    Networking.getRequestQueue(paramContext);
    d locald = new d(new a(paramSdkInitializationListener), 2);
    k = new PersonalInfoManager(paramContext, paramSdkConfiguration.getAdUnitId(), locald);
    k.setAllowLegitimateInterest(paramSdkConfiguration.getLegitimateInterestAllowed());
    ClientMetadata.getInstance(paramContext);
    j = new AdapterConfigurationManager(locald);
    j.initialize(paramContext, paramSdkConfiguration.getAdapterConfigurationClasses(), paramSdkConfiguration.getMediatedNetworkConfigurations(), paramSdkConfiguration.getMoPubRequestOptions());
  }

  public static boolean isSdkInitialized()
  {
    return h;
  }

  public static void onBackPressed(Activity paramActivity)
  {
    MoPubLifecycleManager.getInstance(paramActivity).onBackPressed(paramActivity);
  }

  public static void onCreate(Activity paramActivity)
  {
    MoPubLifecycleManager.getInstance(paramActivity).onCreate(paramActivity);
    a(paramActivity);
  }

  public static void onDestroy(Activity paramActivity)
  {
    MoPubLifecycleManager.getInstance(paramActivity).onDestroy(paramActivity);
  }

  public static void onPause(Activity paramActivity)
  {
    MoPubLifecycleManager.getInstance(paramActivity).onPause(paramActivity);
  }

  public static void onRestart(Activity paramActivity)
  {
    MoPubLifecycleManager.getInstance(paramActivity).onRestart(paramActivity);
    a(paramActivity);
  }

  public static void onResume(Activity paramActivity)
  {
    MoPubLifecycleManager.getInstance(paramActivity).onResume(paramActivity);
    a(paramActivity);
  }

  public static void onStart(Activity paramActivity)
  {
    MoPubLifecycleManager.getInstance(paramActivity).onStart(paramActivity);
    a(paramActivity);
  }

  public static void onStop(Activity paramActivity)
  {
    MoPubLifecycleManager.getInstance(paramActivity).onStop(paramActivity);
  }

  @Deprecated
  @VisibleForTesting
  public static void resetBrowserAgent()
  {
    d = BrowserAgent.IN_APP;
    e = false;
  }

  public static void setAllowLegitimateInterest(boolean paramBoolean)
  {
    if (k != null)
      k.setAllowLegitimateInterest(paramBoolean);
  }

  public static void setBrowserAgent(BrowserAgent paramBrowserAgent)
  {
    Preconditions.checkNotNull(paramBrowserAgent);
    d = paramBrowserAgent;
    e = true;
  }

  public static void setBrowserAgentFromAdServer(BrowserAgent paramBrowserAgent)
  {
    Preconditions.checkNotNull(paramBrowserAgent);
    if (e)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = ("Browser agent already overridden by client with value " + d);
      MoPubLog.log(localSdkLogEvent, arrayOfObject);
      return;
    }
    d = paramBrowserAgent;
  }

  public static void setLocationAwareness(LocationAwareness paramLocationAwareness)
  {
    Preconditions.checkNotNull(paramLocationAwareness);
    a = paramLocationAwareness;
  }

  public static void setLocationPrecision(int paramInt)
  {
    b = Math.min(Math.max(0, paramInt), 6);
  }

  public static void setMinimumLocationRefreshTimeMillis(long paramLong)
  {
    c = paramLong;
  }

  public static boolean shouldAllowLegitimateInterest()
  {
    return (k != null) && (k.shouldAllowLegitimateInterest());
  }

  public static enum BrowserAgent
  {
    static
    {
      BrowserAgent[] arrayOfBrowserAgent = new BrowserAgent[2];
      arrayOfBrowserAgent[0] = IN_APP;
      arrayOfBrowserAgent[1] = NATIVE;
    }

    public static BrowserAgent fromHeader(Integer paramInteger)
    {
      if (paramInteger == null)
        return IN_APP;
      if (paramInteger.intValue() == 1)
        return NATIVE;
      return IN_APP;
    }
  }

  public static enum LocationAwareness
  {
    static
    {
      DISABLED = new LocationAwareness("DISABLED", 2);
      LocationAwareness[] arrayOfLocationAwareness = new LocationAwareness[3];
      arrayOfLocationAwareness[0] = NORMAL;
      arrayOfLocationAwareness[1] = TRUNCATED;
      arrayOfLocationAwareness[2] = DISABLED;
    }
  }

  private static class a
    implements SdkInitializationListener
  {
    private SdkInitializationListener a;

    a(SdkInitializationListener paramSdkInitializationListener)
    {
      this.a = paramSdkInitializationListener;
    }

    public void onInitializationFinished()
    {
      AdapterConfigurationManager localAdapterConfigurationManager = MoPub.a();
      if (localAdapterConfigurationManager != null)
      {
        MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.INIT_FINISHED;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = localAdapterConfigurationManager.getAdapterConfigurationInfo();
        MoPubLog.log(localSdkLogEvent, arrayOfObject);
      }
      MoPub.a(this.a);
      this.a = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.MoPub
 * JD-Core Version:    0.6.2
 */