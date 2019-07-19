package com.adjust.sdk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Process;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ActivityHandler
  implements IActivityHandler
{
  private static final String ACTIVITY_STATE_NAME = "Activity state";
  private static final String ATTRIBUTION_NAME = "Attribution";
  private static long BACKGROUND_TIMER_INTERVAL = 0L;
  private static final String BACKGROUND_TIMER_NAME = "Background timer";
  private static final String DELAY_START_TIMER_NAME = "Delay Start timer";
  private static long FOREGROUND_TIMER_INTERVAL = 0L;
  private static final String FOREGROUND_TIMER_NAME = "Foreground timer";
  private static long FOREGROUND_TIMER_START = 0L;
  private static final String SESSION_CALLBACK_PARAMETERS_NAME = "Session Callback parameters";
  private static long SESSION_INTERVAL = 0L;
  private static final String SESSION_PARAMETERS_NAME = "Session parameters";
  private static final String SESSION_PARTNER_PARAMETERS_NAME = "Session Partner parameters";
  private static long SUBSESSION_INTERVAL = 0L;
  private static final String TIME_TRAVEL = "Time travel!";
  private ActivityState activityState;
  private AdjustConfig adjustConfig;
  private AdjustAttribution attribution;
  private IAttributionHandler attributionHandler;
  private TimerOnce backgroundTimer;
  private String basePath;
  private TimerOnce delayStartTimer;
  private a deviceInfo;
  private TimerCycle foregroundTimer;
  private String gdprPath;
  private InstallReferrer installReferrer;
  private InternalState internalState;
  private ILogger logger;
  private IPackageHandler packageHandler;
  private CustomScheduledExecutor scheduledExecutor;
  private ISdkClickHandler sdkClickHandler;
  private SessionParameters sessionParameters;

  private ActivityHandler(AdjustConfig paramAdjustConfig)
  {
    init(paramAdjustConfig);
    this.logger = AdjustFactory.getLogger();
    this.logger.lockLogLevel();
    this.scheduledExecutor = new CustomScheduledExecutor("ActivityHandler", false);
    this.internalState = new InternalState();
    InternalState localInternalState = this.internalState;
    if (paramAdjustConfig.startEnabled != null);
    for (boolean bool = paramAdjustConfig.startEnabled.booleanValue(); ; bool = true)
    {
      localInternalState.enabled = bool;
      this.internalState.offline = paramAdjustConfig.startOffline;
      this.internalState.background = true;
      this.internalState.delayStart = false;
      this.internalState.updatePackages = false;
      this.internalState.sessionResponseProcessed = false;
      this.internalState.firstSdkStart = false;
      this.scheduledExecutor.submit(new Runnable()
      {
        public void run()
        {
          ActivityHandler.this.initI();
        }
      });
      return;
    }
  }

  private void backgroundTimerFiredI()
  {
    if (toSendI())
      this.packageHandler.sendFirstPackage();
  }

  private boolean checkActivityStateI(ActivityState paramActivityState)
  {
    if (this.internalState.hasFirstSdkStartNotOcurred())
    {
      this.logger.error("Sdk did not yet start", new Object[0]);
      return false;
    }
    return true;
  }

  private void checkAfterNewStartI()
  {
    checkAfterNewStartI(new SharedPreferencesManager(getContext()));
  }

  private void checkAfterNewStartI(SharedPreferencesManager paramSharedPreferencesManager)
  {
    String str = paramSharedPreferencesManager.getPushToken();
    if ((str != null) && (!str.equals(this.activityState.pushToken)))
      setPushToken(str, true);
    if (paramSharedPreferencesManager.getRawReferrerArray() != null)
      sendReftagReferrer();
    this.installReferrer.startConnection();
  }

  private void checkAttributionStateI()
  {
    if (!checkActivityStateI(this.activityState));
    while (((this.internalState.isFirstLaunch()) && (this.internalState.hasSessionResponseNotBeenProcessed())) || ((this.attribution != null) && (!this.activityState.askingAttribution)))
      return;
    this.attributionHandler.getAttribution();
  }

  private boolean checkEventI(AdjustEvent paramAdjustEvent)
  {
    if (paramAdjustEvent == null)
    {
      this.logger.error("Event missing", new Object[0]);
      return false;
    }
    if (!paramAdjustEvent.isValid())
    {
      this.logger.error("Event not initialized correctly", new Object[0]);
      return false;
    }
    return true;
  }

  private void checkForInstallReferrerInfo(SdkClickResponseData paramSdkClickResponseData)
  {
    if (!paramSdkClickResponseData.isInstallReferrer)
      return;
    this.activityState.clickTime = paramSdkClickResponseData.clickTime;
    this.activityState.installBegin = paramSdkClickResponseData.installBegin;
    this.activityState.installReferrer = paramSdkClickResponseData.installReferrer;
    writeActivityStateI();
  }

  private boolean checkOrderIdI(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty()))
      return true;
    if (this.activityState.findOrderId(paramString))
    {
      this.logger.info("Skipping duplicated order ID '%s'", new Object[] { paramString });
      return false;
    }
    this.activityState.addOrderId(paramString);
    this.logger.verbose("Added order ID '%s'", new Object[] { paramString });
    return true;
  }

  private Intent createDeeplinkIntentI(Uri paramUri)
  {
    if (this.adjustConfig.deepLinkComponent == null);
    for (Intent localIntent = new Intent("android.intent.action.VIEW", paramUri); ; localIntent = new Intent("android.intent.action.VIEW", paramUri, this.adjustConfig.context, this.adjustConfig.deepLinkComponent))
    {
      localIntent.setFlags(268435456);
      localIntent.setPackage(this.adjustConfig.context.getPackageName());
      return localIntent;
    }
  }

  private void delayStartI()
  {
    if (this.internalState.isNotInDelayedStart())
      break label10;
    label10: 
    while (isToUpdatePackagesI())
      return;
    double d1;
    label39: long l2;
    long l3;
    double d2;
    if (this.adjustConfig.delayStart != null)
    {
      d1 = this.adjustConfig.delayStart.doubleValue();
      long l1 = AdjustFactory.getMaxDelayStart();
      l2 = ()(1000.0D * d1);
      if (l2 <= l1)
        break label191;
      double d3 = l1 / 1000L;
      String str2 = Util.SecondsDisplayFormat.format(d1);
      String str3 = Util.SecondsDisplayFormat.format(d3);
      this.logger.warn("Delay start of %s seconds bigger than max allowed value of %s seconds", new Object[] { str2, str3 });
      l3 = l1;
      d2 = d3;
    }
    while (true)
    {
      String str1 = Util.SecondsDisplayFormat.format(d2);
      this.logger.info("Waiting %s seconds before starting first session", new Object[] { str1 });
      this.delayStartTimer.startIn(l3);
      this.internalState.updatePackages = true;
      if (this.activityState == null)
        break;
      this.activityState.updatePackages = true;
      writeActivityStateI();
      return;
      d1 = 0.0D;
      break label39;
      label191: d2 = d1;
      l3 = l2;
    }
  }

  public static boolean deleteActivityState(Context paramContext)
  {
    return paramContext.deleteFile("AdjustIoActivityState");
  }

  public static boolean deleteAttribution(Context paramContext)
  {
    return paramContext.deleteFile("AdjustAttribution");
  }

  public static boolean deleteSessionCallbackParameters(Context paramContext)
  {
    return paramContext.deleteFile("AdjustSessionCallbackParameters");
  }

  public static boolean deleteSessionPartnerParameters(Context paramContext)
  {
    return paramContext.deleteFile("AdjustSessionPartnerParameters");
  }

  static void deleteState(Context paramContext)
  {
    deleteActivityState(paramContext);
    deleteAttribution(paramContext);
    deleteSessionCallbackParameters(paramContext);
    deleteSessionPartnerParameters(paramContext);
    new SharedPreferencesManager(paramContext).clear();
  }

  private void endI()
  {
    if (!toSendI())
      pauseSendingI();
    if (updateActivityStateI(System.currentTimeMillis()))
      writeActivityStateI();
  }

  private void foregroundTimerFiredI()
  {
    if (!isEnabledI())
      stopForegroundTimerI();
    do
    {
      return;
      if (toSendI())
        this.packageHandler.sendFirstPackage();
    }
    while (!updateActivityStateI(System.currentTimeMillis()));
    writeActivityStateI();
  }

  private void gdprForgetMeI()
  {
    if (!checkActivityStateI(this.activityState));
    while ((!isEnabledI()) || (this.activityState.isGdprForgotten))
      return;
    this.activityState.isGdprForgotten = true;
    writeActivityStateI();
    long l = System.currentTimeMillis();
    ActivityPackage localActivityPackage = new b(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, l).b();
    this.packageHandler.addPackage(localActivityPackage);
    new SharedPreferencesManager(getContext()).removeGdprForgetMe();
    if (this.adjustConfig.eventBufferingEnabled)
    {
      ILogger localILogger = this.logger;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localActivityPackage.getSuffix();
      localILogger.info("Buffered event %s", arrayOfObject);
      return;
    }
    this.packageHandler.sendFirstPackage();
  }

  public static ActivityHandler getInstance(AdjustConfig paramAdjustConfig)
  {
    if (paramAdjustConfig == null)
    {
      AdjustFactory.getLogger().error("AdjustConfig missing", new Object[0]);
      return null;
    }
    if (!paramAdjustConfig.isValid())
    {
      AdjustFactory.getLogger().error("AdjustConfig not initialized correctly", new Object[0]);
      return null;
    }
    if (paramAdjustConfig.processName != null)
    {
      int i = Process.myPid();
      ActivityManager localActivityManager = (ActivityManager)paramAdjustConfig.context.getSystemService("activity");
      if (localActivityManager == null)
        return null;
      Iterator localIterator = localActivityManager.getRunningAppProcesses().iterator();
      while (localIterator.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        if (localRunningAppProcessInfo.pid == i)
          if (!localRunningAppProcessInfo.processName.equalsIgnoreCase(paramAdjustConfig.processName))
          {
            ILogger localILogger = AdjustFactory.getLogger();
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = localRunningAppProcessInfo.processName;
            localILogger.info("Skipping initialization in background process (%s)", arrayOfObject);
            return null;
          }
      }
    }
    return new ActivityHandler(paramAdjustConfig);
  }

  private void gotOptOutResponseI()
  {
    this.activityState.isGdprForgotten = true;
    writeActivityStateI();
    this.packageHandler.flush();
    setEnabledI(false);
  }

  private boolean hasChangedStateI(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    if (paramBoolean1 != paramBoolean2)
      return true;
    if (paramBoolean1)
    {
      this.logger.debug(paramString1, new Object[0]);
      return false;
    }
    this.logger.debug(paramString2, new Object[0]);
    return false;
  }

  private void initI()
  {
    SESSION_INTERVAL = AdjustFactory.getSessionInterval();
    SUBSESSION_INTERVAL = AdjustFactory.getSubsessionInterval();
    FOREGROUND_TIMER_INTERVAL = AdjustFactory.getTimerInterval();
    FOREGROUND_TIMER_START = AdjustFactory.getTimerStart();
    BACKGROUND_TIMER_INTERVAL = AdjustFactory.getTimerInterval();
    readAttributionI(this.adjustConfig.context);
    readActivityStateI(this.adjustConfig.context);
    this.sessionParameters = new SessionParameters();
    readSessionCallbackParametersI(this.adjustConfig.context);
    readSessionPartnerParametersI(this.adjustConfig.context);
    if (this.adjustConfig.startEnabled != null)
    {
      if (this.adjustConfig.preLaunchActionsArray == null)
        this.adjustConfig.preLaunchActionsArray = new ArrayList();
      this.adjustConfig.preLaunchActionsArray.add(new IRunActivityHandler()
      {
        public void run(ActivityHandler paramAnonymousActivityHandler)
        {
          paramAnonymousActivityHandler.setEnabledI(ActivityHandler.this.adjustConfig.startEnabled.booleanValue());
        }
      });
    }
    if (this.internalState.hasFirstSdkStartOcurred())
    {
      this.internalState.enabled = this.activityState.enabled;
      this.internalState.updatePackages = this.activityState.updatePackages;
      this.internalState.firstLaunch = false;
      readConfigFile(this.adjustConfig.context);
      this.deviceInfo = new a(this.adjustConfig.context, this.adjustConfig.sdkPrefix);
      if (this.adjustConfig.eventBufferingEnabled)
        this.logger.info("Event buffering is enabled", new Object[0]);
      if (this.deviceInfo.a != null)
        break label749;
      this.logger.warn("Unable to get Google Play Services Advertising ID at start time", new Object[0]);
      if ((this.deviceInfo.c == null) && (this.deviceInfo.d == null) && (this.deviceInfo.e == null))
        this.logger.error("Unable to get any device id's. Please check if Proguard is correctly set with Adjust SDK", new Object[0]);
      label320: if (this.adjustConfig.defaultTracker != null)
      {
        ILogger localILogger2 = this.logger;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = this.adjustConfig.defaultTracker;
        localILogger2.info("Default tracker: '%s'", arrayOfObject2);
      }
      if (this.adjustConfig.pushToken == null)
        break label792;
      ILogger localILogger1 = this.logger;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = this.adjustConfig.pushToken;
      localILogger1.info("Push token: '%s'", arrayOfObject1);
      if (!this.internalState.hasFirstSdkStartOcurred())
        break label768;
      setPushToken(this.adjustConfig.pushToken, false);
    }
    while (true)
    {
      if ((this.internalState.hasFirstSdkStartOcurred()) && (new SharedPreferencesManager(getContext()).getGdprForgetMe()))
        gdprForgetMe();
      this.foregroundTimer = new TimerCycle(new Runnable()
      {
        public void run()
        {
          ActivityHandler.this.foregroundTimerFired();
        }
      }
      , FOREGROUND_TIMER_START, FOREGROUND_TIMER_INTERVAL, "Foreground timer");
      if (this.adjustConfig.sendInBackground)
      {
        this.logger.info("Send in background configured", new Object[0]);
        this.backgroundTimer = new TimerOnce(new Runnable()
        {
          public void run()
          {
            ActivityHandler.this.backgroundTimerFired();
          }
        }
        , "Background timer");
      }
      if ((this.internalState.hasFirstSdkStartNotOcurred()) && (this.adjustConfig.delayStart != null) && (this.adjustConfig.delayStart.doubleValue() > 0.0D))
      {
        this.logger.info("Delay start configured", new Object[0]);
        this.internalState.delayStart = true;
        this.delayStartTimer = new TimerOnce(new Runnable()
        {
          public void run()
          {
            ActivityHandler.this.sendFirstPackages();
          }
        }
        , "Delay Start timer");
      }
      UtilNetworking.setUserAgent(this.adjustConfig.userAgent);
      this.basePath = this.adjustConfig.basePath;
      this.gdprPath = this.adjustConfig.gdprPath;
      this.packageHandler = AdjustFactory.getPackageHandler(this, this.adjustConfig.context, toSendI(false));
      this.attributionHandler = AdjustFactory.getAttributionHandler(this, getAttributionPackageI(), toSendI(false));
      this.sdkClickHandler = AdjustFactory.getSdkClickHandler(this, toSendI(true));
      if (isToUpdatePackagesI())
        updatePackagesI();
      this.installReferrer = new InstallReferrer(this.adjustConfig.context, this);
      preLaunchActionsI(this.adjustConfig.preLaunchActionsArray);
      sendReftagReferrerI();
      return;
      this.internalState.firstLaunch = true;
      break;
      label749: this.logger.info("Google Play Services Advertising ID read correctly at start time", new Object[0]);
      break label320;
      label768: new SharedPreferencesManager(getContext()).savePushToken(this.adjustConfig.pushToken);
      continue;
      label792: if (this.internalState.hasFirstSdkStartOcurred())
        setPushToken(new SharedPreferencesManager(getContext()).getPushToken(), true);
    }
  }

  private boolean isEnabledI()
  {
    if (this.activityState != null)
      return this.activityState.enabled;
    return this.internalState.isEnabled();
  }

  private boolean isToUpdatePackagesI()
  {
    if (this.activityState != null)
      return this.activityState.updatePackages;
    return this.internalState.itHasToUpdatePackages();
  }

  private void launchAttributionListenerI(Handler paramHandler)
  {
    if (this.adjustConfig.onAttributionChangedListener == null)
      return;
    paramHandler.post(new Runnable()
    {
      public void run()
      {
        if (ActivityHandler.this.adjustConfig == null);
        while (ActivityHandler.this.adjustConfig.onAttributionChangedListener == null)
          return;
        ActivityHandler.this.adjustConfig.onAttributionChangedListener.onAttributionChanged(ActivityHandler.this.attribution);
      }
    });
  }

  private void launchAttributionResponseTasksI(AttributionResponseData paramAttributionResponseData)
  {
    updateAdidI(paramAttributionResponseData.adid);
    Handler localHandler = new Handler(this.adjustConfig.context.getMainLooper());
    if (updateAttributionI(paramAttributionResponseData.attribution))
      launchAttributionListenerI(localHandler);
    prepareDeeplinkI(paramAttributionResponseData.deeplink, localHandler);
  }

  private void launchDeeplinkMain(Intent paramIntent, Uri paramUri)
  {
    if (this.adjustConfig.context.getPackageManager().queryIntentActivities(paramIntent, 0).size() > 0);
    for (int i = 1; i == 0; i = 0)
    {
      this.logger.error("Unable to open deferred deep link (%s)", new Object[] { paramUri });
      return;
    }
    this.logger.info("Open deferred deep link (%s)", new Object[] { paramUri });
    this.adjustConfig.context.startActivity(paramIntent);
  }

  private void launchEventResponseTasksI(final EventResponseData paramEventResponseData)
  {
    updateAdidI(paramEventResponseData.adid);
    Handler localHandler = new Handler(this.adjustConfig.context.getMainLooper());
    if ((paramEventResponseData.success) && (this.adjustConfig.onEventTrackingSucceededListener != null))
    {
      this.logger.debug("Launching success event tracking listener", new Object[0]);
      localHandler.post(new Runnable()
      {
        public void run()
        {
          if (ActivityHandler.this.adjustConfig == null);
          while (ActivityHandler.this.adjustConfig.onEventTrackingSucceededListener == null)
            return;
          ActivityHandler.this.adjustConfig.onEventTrackingSucceededListener.onFinishedEventTrackingSucceeded(paramEventResponseData.getSuccessResponseData());
        }
      });
    }
    while ((paramEventResponseData.success) || (this.adjustConfig.onEventTrackingFailedListener == null))
      return;
    this.logger.debug("Launching failed event tracking listener", new Object[0]);
    localHandler.post(new Runnable()
    {
      public void run()
      {
        if (ActivityHandler.this.adjustConfig == null);
        while (ActivityHandler.this.adjustConfig.onEventTrackingFailedListener == null)
          return;
        ActivityHandler.this.adjustConfig.onEventTrackingFailedListener.onFinishedEventTrackingFailed(paramEventResponseData.getFailureResponseData());
      }
    });
  }

  private void launchSdkClickResponseTasksI(SdkClickResponseData paramSdkClickResponseData)
  {
    updateAdidI(paramSdkClickResponseData.adid);
    Handler localHandler = new Handler(this.adjustConfig.context.getMainLooper());
    if (updateAttributionI(paramSdkClickResponseData.attribution))
      launchAttributionListenerI(localHandler);
  }

  private void launchSessionResponseListenerI(final SessionResponseData paramSessionResponseData, Handler paramHandler)
  {
    if ((paramSessionResponseData.success) && (this.adjustConfig.onSessionTrackingSucceededListener != null))
    {
      this.logger.debug("Launching success session tracking listener", new Object[0]);
      paramHandler.post(new Runnable()
      {
        public void run()
        {
          if (ActivityHandler.this.adjustConfig == null);
          while (ActivityHandler.this.adjustConfig.onSessionTrackingSucceededListener == null)
            return;
          ActivityHandler.this.adjustConfig.onSessionTrackingSucceededListener.onFinishedSessionTrackingSucceeded(paramSessionResponseData.getSuccessResponseData());
        }
      });
    }
    while ((paramSessionResponseData.success) || (this.adjustConfig.onSessionTrackingFailedListener == null))
      return;
    this.logger.debug("Launching failed session tracking listener", new Object[0]);
    paramHandler.post(new Runnable()
    {
      public void run()
      {
        if (ActivityHandler.this.adjustConfig == null);
        while (ActivityHandler.this.adjustConfig.onSessionTrackingFailedListener == null)
          return;
        ActivityHandler.this.adjustConfig.onSessionTrackingFailedListener.onFinishedSessionTrackingFailed(paramSessionResponseData.getFailureResponseData());
      }
    });
  }

  private void launchSessionResponseTasksI(SessionResponseData paramSessionResponseData)
  {
    updateAdidI(paramSessionResponseData.adid);
    Handler localHandler = new Handler(this.adjustConfig.context.getMainLooper());
    if (updateAttributionI(paramSessionResponseData.attribution))
      launchAttributionListenerI(localHandler);
    if ((this.attribution == null) && (!this.activityState.askingAttribution))
      this.attributionHandler.getAttribution();
    if (paramSessionResponseData.success)
      new SharedPreferencesManager(getContext()).setInstallTracked();
    launchSessionResponseListenerI(paramSessionResponseData, localHandler);
    this.internalState.sessionResponseProcessed = true;
  }

  private void pauseSendingI()
  {
    this.attributionHandler.pauseSending();
    this.packageHandler.pauseSending();
    if (!toSendI(true))
    {
      this.sdkClickHandler.pauseSending();
      return;
    }
    this.sdkClickHandler.resumeSending();
  }

  private boolean pausedI()
  {
    return pausedI(false);
  }

  private boolean pausedI(boolean paramBoolean)
  {
    boolean bool2;
    if (paramBoolean)
      if (!this.internalState.isOffline())
      {
        boolean bool3 = isEnabledI();
        bool2 = false;
        if (bool3);
      }
      else
      {
        bool2 = true;
      }
    boolean bool1;
    do
    {
      return bool2;
      if ((this.internalState.isOffline()) || (!isEnabledI()))
        break;
      bool1 = this.internalState.isInDelayedStart();
      bool2 = false;
    }
    while (!bool1);
    return true;
  }

  private void preLaunchActionsI(List<IRunActivityHandler> paramList)
  {
    if (paramList == null);
    while (true)
    {
      return;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
        ((IRunActivityHandler)localIterator.next()).run(this);
    }
  }

  private void prepareDeeplinkI(final Uri paramUri, Handler paramHandler)
  {
    if (paramUri == null)
      return;
    this.logger.info("Deferred deeplink received (%s)", new Object[] { paramUri });
    paramHandler.post(new Runnable()
    {
      public void run()
      {
        if (ActivityHandler.this.adjustConfig == null);
        boolean bool;
        do
        {
          return;
          bool = true;
          if (ActivityHandler.this.adjustConfig.onDeeplinkResponseListener != null)
            bool = ActivityHandler.this.adjustConfig.onDeeplinkResponseListener.launchReceivedDeeplink(paramUri);
        }
        while (!bool);
        ActivityHandler.this.launchDeeplinkMain(this.b, paramUri);
      }
    });
  }

  private void processCachedDeeplinkI()
  {
    if (!checkActivityStateI(this.activityState));
    SharedPreferencesManager localSharedPreferencesManager;
    String str;
    long l;
    do
    {
      return;
      localSharedPreferencesManager = new SharedPreferencesManager(getContext());
      str = localSharedPreferencesManager.getDeeplinkUrl();
      l = localSharedPreferencesManager.getDeeplinkClickTime();
    }
    while ((str == null) || (l == -1L));
    readOpenUrl(Uri.parse(str), l);
    localSharedPreferencesManager.removeDeeplink();
  }

  private void processSessionI()
  {
    if (this.activityState.isGdprForgotten)
      return;
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.activityState.lastActivity;
    if (l2 < 0L)
    {
      this.logger.error("Time travel!", new Object[0]);
      this.activityState.lastActivity = l1;
      writeActivityStateI();
      return;
    }
    if (l2 > SESSION_INTERVAL)
    {
      trackNewSessionI(l1);
      checkAfterNewStartI();
      return;
    }
    if (l2 > SUBSESSION_INTERVAL)
    {
      ActivityState localActivityState1 = this.activityState;
      localActivityState1.subsessionCount = (1 + localActivityState1.subsessionCount);
      ActivityState localActivityState2 = this.activityState;
      localActivityState2.sessionLength = (l2 + localActivityState2.sessionLength);
      this.activityState.lastActivity = l1;
      ILogger localILogger = this.logger;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(this.activityState.subsessionCount);
      arrayOfObject[1] = Integer.valueOf(this.activityState.sessionCount);
      localILogger.verbose("Started subsession %d of session %d", arrayOfObject);
      writeActivityStateI();
      this.installReferrer.startConnection();
      return;
    }
    this.logger.verbose("Time span since last activity too short for a new subsession", new Object[0]);
  }

  private void readActivityStateI(Context paramContext)
  {
    try
    {
      this.activityState = ((ActivityState)Util.readObject(paramContext, "AdjustIoActivityState", "Activity state", ActivityState.class));
      if (this.activityState != null)
        this.internalState.firstSdkStart = true;
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        ILogger localILogger = this.logger;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = "Activity state";
        arrayOfObject[1] = localException.getMessage();
        localILogger.error("Failed to read %s file (%s)", arrayOfObject);
        this.activityState = null;
      }
    }
  }

  private void readAttributionI(Context paramContext)
  {
    try
    {
      this.attribution = ((AdjustAttribution)Util.readObject(paramContext, "AdjustAttribution", "Attribution", AdjustAttribution.class));
      return;
    }
    catch (Exception localException)
    {
      ILogger localILogger = this.logger;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = "Attribution";
      arrayOfObject[1] = localException.getMessage();
      localILogger.error("Failed to read %s file (%s)", arrayOfObject);
      this.attribution = null;
    }
  }

  private void readConfigFile(Context paramContext)
  {
    try
    {
      InputStream localInputStream = paramContext.getAssets().open("adjust_config.properties");
      Properties localProperties = new Properties();
      localProperties.load(localInputStream);
      this.logger.verbose("adjust_config.properties file read and loaded", new Object[0]);
      String str = localProperties.getProperty("defaultTracker");
      if (str != null)
        this.adjustConfig.defaultTracker = str;
      return;
    }
    catch (Exception localException)
    {
      ILogger localILogger = this.logger;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localException.getMessage();
      localILogger.debug("%s file not found in this app", arrayOfObject);
    }
  }

  private void readOpenUrlI(Uri paramUri, long paramLong)
  {
    if (!isEnabledI());
    ActivityPackage localActivityPackage;
    do
    {
      return;
      localActivityPackage = PackageFactory.buildDeeplinkSdkClickPackage(paramUri, paramLong, this.activityState, this.adjustConfig, this.deviceInfo, this.sessionParameters);
    }
    while (localActivityPackage == null);
    this.sdkClickHandler.sendSdkClick(localActivityPackage);
  }

  private void readSessionCallbackParametersI(Context paramContext)
  {
    try
    {
      this.sessionParameters.callbackParameters = ((Map)Util.readObject(paramContext, "AdjustSessionCallbackParameters", "Session Callback parameters", Map.class));
      return;
    }
    catch (Exception localException)
    {
      ILogger localILogger = this.logger;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = "Session Callback parameters";
      arrayOfObject[1] = localException.getMessage();
      localILogger.error("Failed to read %s file (%s)", arrayOfObject);
      this.sessionParameters.callbackParameters = null;
    }
  }

  private void readSessionPartnerParametersI(Context paramContext)
  {
    try
    {
      this.sessionParameters.partnerParameters = ((Map)Util.readObject(paramContext, "AdjustSessionPartnerParameters", "Session Partner parameters", Map.class));
      return;
    }
    catch (Exception localException)
    {
      ILogger localILogger = this.logger;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = "Session Partner parameters";
      arrayOfObject[1] = localException.getMessage();
      localILogger.error("Failed to read %s file (%s)", arrayOfObject);
      this.sessionParameters.partnerParameters = null;
    }
  }

  private void resumeSendingI()
  {
    this.attributionHandler.resumeSending();
    this.packageHandler.resumeSending();
    this.sdkClickHandler.resumeSending();
  }

  private void sendFirstPackagesI()
  {
    if (this.internalState.isNotInDelayedStart())
    {
      this.logger.info("Start delay expired or never configured", new Object[0]);
      return;
    }
    updatePackagesI();
    this.internalState.delayStart = false;
    this.delayStartTimer.cancel();
    this.delayStartTimer = null;
    updateHandlersStatusAndSendI();
  }

  private void sendInstallReferrerI(long paramLong1, long paramLong2, String paramString)
  {
    if (!isEnabledI());
    while ((paramString == null) || ((paramLong1 == this.activityState.clickTime) && (paramLong2 == this.activityState.installBegin) && (paramString.equals(this.activityState.installReferrer))))
      return;
    ActivityPackage localActivityPackage = PackageFactory.buildInstallReferrerSdkClickPackage(paramString, paramLong1, paramLong2, this.activityState, this.adjustConfig, this.deviceInfo, this.sessionParameters);
    this.sdkClickHandler.sendSdkClick(localActivityPackage);
  }

  private void sendReftagReferrerI()
  {
    if (!isEnabledI());
    while (this.internalState.hasFirstSdkStartNotOcurred())
      return;
    this.sdkClickHandler.sendReftagReferrers();
  }

  private void setAskingAttributionI(boolean paramBoolean)
  {
    this.activityState.askingAttribution = paramBoolean;
    writeActivityStateI();
  }

  private void setEnabledI(boolean paramBoolean)
  {
    boolean bool = true;
    if (!hasChangedStateI(isEnabledI(), paramBoolean, "Adjust already enabled", "Adjust already disabled"))
      return;
    if ((paramBoolean) && (this.activityState.isGdprForgotten))
    {
      this.logger.error("Re-enabling SDK not possible for forgotten user", new Object[0]);
      return;
    }
    this.internalState.enabled = paramBoolean;
    if (this.internalState.hasFirstSdkStartNotOcurred())
    {
      if (!paramBoolean);
      while (true)
      {
        updateStatusI(bool, "Handlers will start as paused due to the SDK being disabled", "Handlers will still start as paused", "Handlers will start as active due to the SDK being enabled");
        return;
        bool = false;
      }
    }
    this.activityState.enabled = paramBoolean;
    writeActivityStateI();
    if (paramBoolean)
    {
      SharedPreferencesManager localSharedPreferencesManager = new SharedPreferencesManager(getContext());
      if (localSharedPreferencesManager.getGdprForgetMe())
        gdprForgetMeI();
      if (!localSharedPreferencesManager.getInstallTracked())
        trackNewSessionI(System.currentTimeMillis());
      checkAfterNewStartI(localSharedPreferencesManager);
    }
    if (!paramBoolean);
    while (true)
    {
      updateStatusI(bool, "Pausing handlers due to SDK being disabled", "Handlers remain paused", "Resuming handlers due to SDK being enabled");
      return;
      bool = false;
    }
  }

  private void setOfflineModeI(boolean paramBoolean)
  {
    if (!hasChangedStateI(this.internalState.isOffline(), paramBoolean, "Adjust already in offline mode", "Adjust already in online mode"))
      return;
    this.internalState.offline = paramBoolean;
    if (this.internalState.hasFirstSdkStartNotOcurred())
    {
      updateStatusI(paramBoolean, "Handlers will start paused due to SDK being offline", "Handlers will still start as paused", "Handlers will start as active due to SDK being online");
      return;
    }
    updateStatusI(paramBoolean, "Pausing handlers to put SDK offline mode", "Handlers remain paused", "Resuming handlers to put SDK in online mode");
  }

  private void setPushTokenI(String paramString)
  {
    if (!checkActivityStateI(this.activityState));
    while ((!isEnabledI()) || (this.activityState.isGdprForgotten) || (paramString == null) || (paramString.equals(this.activityState.pushToken)))
      return;
    this.activityState.pushToken = paramString;
    writeActivityStateI();
    long l = System.currentTimeMillis();
    ActivityPackage localActivityPackage = new b(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, l).b("push");
    this.packageHandler.addPackage(localActivityPackage);
    new SharedPreferencesManager(getContext()).removePushToken();
    if (this.adjustConfig.eventBufferingEnabled)
    {
      ILogger localILogger = this.logger;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localActivityPackage.getSuffix();
      localILogger.info("Buffered event %s", arrayOfObject);
      return;
    }
    this.packageHandler.sendFirstPackage();
  }

  private void startBackgroundTimerI()
  {
    if (this.backgroundTimer == null);
    while ((!toSendI()) || (this.backgroundTimer.getFireIn() > 0L))
      return;
    this.backgroundTimer.startIn(BACKGROUND_TIMER_INTERVAL);
  }

  private void startFirstSessionI()
  {
    updateHandlersStatusAndSendI();
    this.activityState = new ActivityState();
    this.internalState.firstSdkStart = true;
    long l = System.currentTimeMillis();
    SharedPreferencesManager localSharedPreferencesManager = new SharedPreferencesManager(getContext());
    this.activityState.pushToken = localSharedPreferencesManager.getPushToken();
    if (this.internalState.isEnabled())
    {
      if (localSharedPreferencesManager.getGdprForgetMe())
        break label138;
      this.activityState.sessionCount = 1;
      transferSessionPackageI(l);
      checkAfterNewStartI(localSharedPreferencesManager);
    }
    while (true)
    {
      this.activityState.resetSessionAttributes(l);
      this.activityState.enabled = this.internalState.isEnabled();
      this.activityState.updatePackages = this.internalState.itHasToUpdatePackages();
      writeActivityStateI();
      localSharedPreferencesManager.removePushToken();
      localSharedPreferencesManager.removeGdprForgetMe();
      processCachedDeeplinkI();
      return;
      label138: gdprForgetMeI();
    }
  }

  private void startForegroundTimerI()
  {
    if (!isEnabledI())
      return;
    this.foregroundTimer.start();
  }

  private void startI()
  {
    if (this.internalState.hasFirstSdkStartNotOcurred())
      startFirstSessionI();
    while (!this.activityState.enabled)
      return;
    updateHandlersStatusAndSendI();
    processSessionI();
    checkAttributionStateI();
    processCachedDeeplinkI();
  }

  private void stopBackgroundTimerI()
  {
    if (this.backgroundTimer == null)
      return;
    this.backgroundTimer.cancel();
  }

  private void stopForegroundTimerI()
  {
    this.foregroundTimer.suspend();
  }

  private void teardownActivityStateS()
  {
    try
    {
      if (this.activityState == null)
        return;
      this.activityState = null;
      return;
    }
    finally
    {
    }
  }

  private void teardownAllSessionParametersS()
  {
    try
    {
      if (this.sessionParameters == null)
        return;
      this.sessionParameters = null;
      return;
    }
    finally
    {
    }
  }

  private void teardownAttributionS()
  {
    try
    {
      if (this.attribution == null)
        return;
      this.attribution = null;
      return;
    }
    finally
    {
    }
  }

  private boolean toSendI()
  {
    return toSendI(false);
  }

  private boolean toSendI(boolean paramBoolean)
  {
    if (pausedI(paramBoolean))
      return false;
    if (this.adjustConfig.sendInBackground)
      return true;
    return this.internalState.isInForeground();
  }

  private void trackEventI(AdjustEvent paramAdjustEvent)
  {
    if (!checkActivityStateI(this.activityState));
    while ((!isEnabledI()) || (!checkEventI(paramAdjustEvent)) || (!checkOrderIdI(paramAdjustEvent.orderId)) || (this.activityState.isGdprForgotten))
      return;
    long l = System.currentTimeMillis();
    ActivityState localActivityState = this.activityState;
    localActivityState.eventCount = (1 + localActivityState.eventCount);
    updateActivityStateI(l);
    ActivityPackage localActivityPackage = new b(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, l).a(paramAdjustEvent, this.internalState.isInDelayedStart());
    this.packageHandler.addPackage(localActivityPackage);
    if (this.adjustConfig.eventBufferingEnabled)
    {
      ILogger localILogger = this.logger;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localActivityPackage.getSuffix();
      localILogger.info("Buffered event %s", arrayOfObject);
    }
    while (true)
    {
      if ((this.adjustConfig.sendInBackground) && (this.internalState.isInBackground()))
        startBackgroundTimerI();
      writeActivityStateI();
      return;
      this.packageHandler.sendFirstPackage();
    }
  }

  private void trackNewSessionI(long paramLong)
  {
    long l = paramLong - this.activityState.lastActivity;
    ActivityState localActivityState = this.activityState;
    localActivityState.sessionCount = (1 + localActivityState.sessionCount);
    this.activityState.lastInterval = l;
    transferSessionPackageI(paramLong);
    this.activityState.resetSessionAttributes(paramLong);
    writeActivityStateI();
  }

  private void transferSessionPackageI(long paramLong)
  {
    ActivityPackage localActivityPackage = new b(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, paramLong).a(this.internalState.isInDelayedStart());
    this.packageHandler.addPackage(localActivityPackage);
    this.packageHandler.sendFirstPackage();
  }

  private boolean updateActivityStateI(long paramLong)
  {
    if (!checkActivityStateI(this.activityState));
    long l;
    do
    {
      return false;
      l = paramLong - this.activityState.lastActivity;
    }
    while (l > SESSION_INTERVAL);
    this.activityState.lastActivity = paramLong;
    if (l < 0L)
      this.logger.error("Time travel!", new Object[0]);
    while (true)
    {
      return true;
      ActivityState localActivityState1 = this.activityState;
      localActivityState1.sessionLength = (l + localActivityState1.sessionLength);
      ActivityState localActivityState2 = this.activityState;
      localActivityState2.timeSpent = (l + localActivityState2.timeSpent);
    }
  }

  private void updateAdidI(String paramString)
  {
    if (paramString == null);
    while (paramString.equals(this.activityState.adid))
      return;
    this.activityState.adid = paramString;
    writeActivityStateI();
  }

  private void updateHandlersStatusAndSendI()
  {
    if (!toSendI())
      pauseSendingI();
    do
    {
      return;
      resumeSendingI();
    }
    while ((this.adjustConfig.eventBufferingEnabled) && ((!this.internalState.isFirstLaunch()) || (!this.internalState.hasSessionResponseNotBeenProcessed())));
    this.packageHandler.sendFirstPackage();
  }

  private void updatePackagesI()
  {
    this.packageHandler.updatePackages(this.sessionParameters);
    this.internalState.updatePackages = false;
    if (this.activityState != null)
    {
      this.activityState.updatePackages = false;
      writeActivityStateI();
    }
  }

  private void updateStatusI(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if (paramBoolean)
      this.logger.info(paramString1, new Object[0]);
    while (true)
    {
      updateHandlersStatusAndSendI();
      return;
      if (pausedI(false))
      {
        if (pausedI(true))
          this.logger.info(paramString2, new Object[0]);
        else
          this.logger.info(paramString2 + ", except the Sdk Click Handler", new Object[0]);
      }
      else
        this.logger.info(paramString3, new Object[0]);
    }
  }

  private void writeActivityStateI()
  {
    try
    {
      if (this.activityState == null)
        return;
      Util.writeObject(this.activityState, this.adjustConfig.context, "AdjustIoActivityState", "Activity state");
      return;
    }
    finally
    {
    }
  }

  private void writeAttributionI()
  {
    try
    {
      if (this.attribution == null)
        return;
      Util.writeObject(this.attribution, this.adjustConfig.context, "AdjustAttribution", "Attribution");
      return;
    }
    finally
    {
    }
  }

  private void writeSessionCallbackParametersI()
  {
    try
    {
      if (this.sessionParameters == null)
        return;
      Util.writeObject(this.sessionParameters.callbackParameters, this.adjustConfig.context, "AdjustSessionCallbackParameters", "Session Callback parameters");
      return;
    }
    finally
    {
    }
  }

  private void writeSessionPartnerParametersI()
  {
    try
    {
      if (this.sessionParameters == null)
        return;
      Util.writeObject(this.sessionParameters.partnerParameters, this.adjustConfig.context, "AdjustSessionPartnerParameters", "Session Partner parameters");
      return;
    }
    finally
    {
    }
  }

  public void addSessionCallbackParameter(final String paramString1, final String paramString2)
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        ActivityHandler.this.addSessionCallbackParameterI(paramString1, paramString2);
      }
    });
  }

  public void addSessionCallbackParameterI(String paramString1, String paramString2)
  {
    if (!Util.isValidParameter(paramString1, "key", "Session Callback"));
    while (!Util.isValidParameter(paramString2, "value", "Session Callback"))
      return;
    if (this.sessionParameters.callbackParameters == null)
      this.sessionParameters.callbackParameters = new LinkedHashMap();
    String str = (String)this.sessionParameters.callbackParameters.get(paramString1);
    if (paramString2.equals(str))
    {
      this.logger.verbose("Key %s already present with the same value", new Object[] { paramString1 });
      return;
    }
    if (str != null)
      this.logger.warn("Key %s will be overwritten", new Object[] { paramString1 });
    this.sessionParameters.callbackParameters.put(paramString1, paramString2);
    writeSessionCallbackParametersI();
  }

  public void addSessionPartnerParameter(final String paramString1, final String paramString2)
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        ActivityHandler.this.addSessionPartnerParameterI(paramString1, paramString2);
      }
    });
  }

  public void addSessionPartnerParameterI(String paramString1, String paramString2)
  {
    if (!Util.isValidParameter(paramString1, "key", "Session Partner"));
    while (!Util.isValidParameter(paramString2, "value", "Session Partner"))
      return;
    if (this.sessionParameters.partnerParameters == null)
      this.sessionParameters.partnerParameters = new LinkedHashMap();
    String str = (String)this.sessionParameters.partnerParameters.get(paramString1);
    if (paramString2.equals(str))
    {
      this.logger.verbose("Key %s already present with the same value", new Object[] { paramString1 });
      return;
    }
    if (str != null)
      this.logger.warn("Key %s will be overwritten", new Object[] { paramString1 });
    this.sessionParameters.partnerParameters.put(paramString1, paramString2);
    writeSessionPartnerParametersI();
  }

  public void backgroundTimerFired()
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        ActivityHandler.this.backgroundTimerFiredI();
      }
    });
  }

  public void finishedTrackingActivity(ResponseData paramResponseData)
  {
    if ((paramResponseData instanceof SessionResponseData))
      this.attributionHandler.checkSessionResponse((SessionResponseData)paramResponseData);
    do
    {
      return;
      if ((paramResponseData instanceof SdkClickResponseData))
      {
        checkForInstallReferrerInfo((SdkClickResponseData)paramResponseData);
        this.attributionHandler.checkSdkClickResponse((SdkClickResponseData)paramResponseData);
        return;
      }
    }
    while (!(paramResponseData instanceof EventResponseData));
    launchEventResponseTasks((EventResponseData)paramResponseData);
  }

  public void foregroundTimerFired()
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        ActivityHandler.this.foregroundTimerFiredI();
      }
    });
  }

  public void gdprForgetMe()
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        ActivityHandler.this.gdprForgetMeI();
      }
    });
  }

  public ActivityState getActivityState()
  {
    return this.activityState;
  }

  public String getAdid()
  {
    if (this.activityState == null)
      return null;
    return this.activityState.adid;
  }

  public AdjustConfig getAdjustConfig()
  {
    return this.adjustConfig;
  }

  public AdjustAttribution getAttribution()
  {
    return this.attribution;
  }

  public ActivityPackage getAttributionPackageI()
  {
    long l = System.currentTimeMillis();
    return new b(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, l).a();
  }

  public String getBasePath()
  {
    return this.basePath;
  }

  public Context getContext()
  {
    return this.adjustConfig.context;
  }

  public a getDeviceInfo()
  {
    return this.deviceInfo;
  }

  public String getGdprPath()
  {
    return this.gdprPath;
  }

  public InternalState getInternalState()
  {
    return this.internalState;
  }

  public SessionParameters getSessionParameters()
  {
    return this.sessionParameters;
  }

  public void gotOptOutResponse()
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        ActivityHandler.this.gotOptOutResponseI();
      }
    });
  }

  public void init(AdjustConfig paramAdjustConfig)
  {
    this.adjustConfig = paramAdjustConfig;
  }

  public boolean isEnabled()
  {
    return isEnabledI();
  }

  public void launchAttributionResponseTasks(final AttributionResponseData paramAttributionResponseData)
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        ActivityHandler.this.launchAttributionResponseTasksI(paramAttributionResponseData);
      }
    });
  }

  public void launchEventResponseTasks(final EventResponseData paramEventResponseData)
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        ActivityHandler.this.launchEventResponseTasksI(paramEventResponseData);
      }
    });
  }

  public void launchSdkClickResponseTasks(final SdkClickResponseData paramSdkClickResponseData)
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        ActivityHandler.this.launchSdkClickResponseTasksI(paramSdkClickResponseData);
      }
    });
  }

  public void launchSessionResponseTasks(final SessionResponseData paramSessionResponseData)
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        ActivityHandler.this.launchSessionResponseTasksI(paramSessionResponseData);
      }
    });
  }

  public void onPause()
  {
    this.internalState.background = true;
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        ActivityHandler.this.stopForegroundTimerI();
        ActivityHandler.this.startBackgroundTimerI();
        ActivityHandler.this.logger.verbose("Subsession end", new Object[0]);
        ActivityHandler.this.endI();
      }
    });
  }

  public void onResume()
  {
    this.internalState.background = false;
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        ActivityHandler.this.delayStartI();
        ActivityHandler.this.stopBackgroundTimerI();
        ActivityHandler.this.startForegroundTimerI();
        ActivityHandler.this.logger.verbose("Subsession start", new Object[0]);
        ActivityHandler.this.startI();
      }
    });
  }

  public void readOpenUrl(final Uri paramUri, final long paramLong)
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        ActivityHandler.this.readOpenUrlI(paramUri, paramLong);
      }
    });
  }

  public void removeSessionCallbackParameter(final String paramString)
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        ActivityHandler.this.removeSessionCallbackParameterI(paramString);
      }
    });
  }

  public void removeSessionCallbackParameterI(String paramString)
  {
    if (!Util.isValidParameter(paramString, "key", "Session Callback"))
      return;
    if (this.sessionParameters.callbackParameters == null)
    {
      this.logger.warn("Session Callback parameters are not set", new Object[0]);
      return;
    }
    if ((String)this.sessionParameters.callbackParameters.remove(paramString) == null)
    {
      this.logger.warn("Key %s does not exist", new Object[] { paramString });
      return;
    }
    this.logger.debug("Key %s will be removed", new Object[] { paramString });
    writeSessionCallbackParametersI();
  }

  public void removeSessionPartnerParameter(final String paramString)
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        ActivityHandler.this.removeSessionPartnerParameterI(paramString);
      }
    });
  }

  public void removeSessionPartnerParameterI(String paramString)
  {
    if (!Util.isValidParameter(paramString, "key", "Session Partner"))
      return;
    if (this.sessionParameters.partnerParameters == null)
    {
      this.logger.warn("Session Partner parameters are not set", new Object[0]);
      return;
    }
    if ((String)this.sessionParameters.partnerParameters.remove(paramString) == null)
    {
      this.logger.warn("Key %s does not exist", new Object[] { paramString });
      return;
    }
    this.logger.debug("Key %s will be removed", new Object[] { paramString });
    writeSessionPartnerParametersI();
  }

  public void resetSessionCallbackParameters()
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        ActivityHandler.this.resetSessionCallbackParametersI();
      }
    });
  }

  public void resetSessionCallbackParametersI()
  {
    if (this.sessionParameters.callbackParameters == null)
      this.logger.warn("Session Callback parameters are not set", new Object[0]);
    this.sessionParameters.callbackParameters = null;
    writeSessionCallbackParametersI();
  }

  public void resetSessionPartnerParameters()
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        ActivityHandler.this.resetSessionPartnerParametersI();
      }
    });
  }

  public void resetSessionPartnerParametersI()
  {
    if (this.sessionParameters.partnerParameters == null)
      this.logger.warn("Session Partner parameters are not set", new Object[0]);
    this.sessionParameters.partnerParameters = null;
    writeSessionPartnerParametersI();
  }

  public void sendFirstPackages()
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        ActivityHandler.this.sendFirstPackagesI();
      }
    });
  }

  public void sendInstallReferrer(final long paramLong1, long paramLong2, final String paramString)
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        ActivityHandler.this.sendInstallReferrerI(paramLong1, paramString, this.c);
      }
    });
  }

  public void sendReftagReferrer()
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        ActivityHandler.this.sendReftagReferrerI();
      }
    });
  }

  public void setAskingAttribution(final boolean paramBoolean)
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        ActivityHandler.this.setAskingAttributionI(paramBoolean);
      }
    });
  }

  public void setEnabled(final boolean paramBoolean)
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        ActivityHandler.this.setEnabledI(paramBoolean);
      }
    });
  }

  public void setOfflineMode(final boolean paramBoolean)
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        ActivityHandler.this.setOfflineModeI(paramBoolean);
      }
    });
  }

  public void setPushToken(final String paramString, final boolean paramBoolean)
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        if (!paramBoolean)
          new SharedPreferencesManager(ActivityHandler.this.getContext()).savePushToken(paramString);
        if (ActivityHandler.this.internalState.hasFirstSdkStartNotOcurred())
          return;
        ActivityHandler.this.setPushTokenI(paramString);
      }
    });
  }

  public void teardown()
  {
    if (this.backgroundTimer != null)
      this.backgroundTimer.teardown();
    if (this.foregroundTimer != null)
      this.foregroundTimer.teardown();
    if (this.delayStartTimer != null)
      this.delayStartTimer.teardown();
    if (this.scheduledExecutor != null);
    try
    {
      this.scheduledExecutor.shutdownNow();
      label57: if (this.packageHandler != null)
        this.packageHandler.teardown();
      if (this.attributionHandler != null)
        this.attributionHandler.teardown();
      if (this.sdkClickHandler != null)
        this.sdkClickHandler.teardown();
      if (this.sessionParameters != null)
      {
        if (this.sessionParameters.callbackParameters != null)
          this.sessionParameters.callbackParameters.clear();
        if (this.sessionParameters.partnerParameters != null)
          this.sessionParameters.partnerParameters.clear();
      }
      teardownActivityStateS();
      teardownAttributionS();
      teardownAllSessionParametersS();
      this.packageHandler = null;
      this.logger = null;
      this.foregroundTimer = null;
      this.scheduledExecutor = null;
      this.backgroundTimer = null;
      this.delayStartTimer = null;
      this.internalState = null;
      this.deviceInfo = null;
      this.adjustConfig = null;
      this.attributionHandler = null;
      this.sdkClickHandler = null;
      this.sessionParameters = null;
      return;
    }
    catch (SecurityException localSecurityException)
    {
      break label57;
    }
  }

  public void trackEvent(final AdjustEvent paramAdjustEvent)
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        if (ActivityHandler.this.internalState.hasFirstSdkStartNotOcurred())
        {
          ActivityHandler.this.logger.warn("Event tracked before first activity resumed.\nIf it was triggered in the Application class, it might timestamp or even send an install long before the user opens the app.\nPlease check https://github.com/adjust/android_sdk#can-i-trigger-an-event-at-application-launch for more information.", new Object[0]);
          ActivityHandler.this.startI();
        }
        ActivityHandler.this.trackEventI(paramAdjustEvent);
      }
    });
  }

  public boolean updateAttributionI(AdjustAttribution paramAdjustAttribution)
  {
    if (paramAdjustAttribution == null);
    while (paramAdjustAttribution.equals(this.attribution))
      return false;
    this.attribution = paramAdjustAttribution;
    writeAttributionI();
    return true;
  }

  public class InternalState
  {
    boolean background;
    boolean delayStart;
    boolean enabled;
    boolean firstLaunch;
    boolean firstSdkStart;
    boolean offline;
    boolean sessionResponseProcessed;
    boolean updatePackages;

    public InternalState()
    {
    }

    public boolean hasFirstSdkStartNotOcurred()
    {
      return !this.firstSdkStart;
    }

    public boolean hasFirstSdkStartOcurred()
    {
      return this.firstSdkStart;
    }

    public boolean hasSessionResponseNotBeenProcessed()
    {
      return !this.sessionResponseProcessed;
    }

    public boolean isDisabled()
    {
      return !this.enabled;
    }

    public boolean isEnabled()
    {
      return this.enabled;
    }

    public boolean isFirstLaunch()
    {
      return this.firstLaunch;
    }

    public boolean isInBackground()
    {
      return this.background;
    }

    public boolean isInDelayedStart()
    {
      return this.delayStart;
    }

    public boolean isInForeground()
    {
      return !this.background;
    }

    public boolean isNotFirstLaunch()
    {
      return !this.firstLaunch;
    }

    public boolean isNotInDelayedStart()
    {
      return !this.delayStart;
    }

    public boolean isOffline()
    {
      return this.offline;
    }

    public boolean isOnline()
    {
      return !this.offline;
    }

    public boolean itHasToUpdatePackages()
    {
      return this.updatePackages;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.ActivityHandler
 * JD-Core Version:    0.6.2
 */