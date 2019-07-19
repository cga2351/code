package com.adjust.sdk;

import android.content.Context;
import java.util.List;

public class AdjustConfig
{
  public static final String ENVIRONMENT_PRODUCTION = "production";
  public static final String ENVIRONMENT_SANDBOX = "sandbox";
  String appSecret;
  String appToken;
  String basePath;
  Context context;
  Class deepLinkComponent;
  String defaultTracker;
  Double delayStart;
  Boolean deviceKnown;
  String environment;
  boolean eventBufferingEnabled;
  String gdprPath;
  ILogger logger;
  OnAttributionChangedListener onAttributionChangedListener;
  OnDeeplinkResponseListener onDeeplinkResponseListener;
  OnEventTrackingFailedListener onEventTrackingFailedListener;
  OnEventTrackingSucceededListener onEventTrackingSucceededListener;
  OnSessionTrackingFailedListener onSessionTrackingFailedListener;
  OnSessionTrackingSucceededListener onSessionTrackingSucceededListener;
  List<IRunActivityHandler> preLaunchActionsArray;
  String processName;
  String pushToken;
  String sdkPrefix;
  String secretId;
  boolean sendInBackground;
  Boolean startEnabled;
  boolean startOffline;
  String userAgent;

  public AdjustConfig(Context paramContext, String paramString1, String paramString2)
  {
    init(paramContext, paramString1, paramString2, false);
  }

  public AdjustConfig(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    init(paramContext, paramString1, paramString2, paramBoolean);
  }

  private boolean checkAppToken(String paramString)
  {
    if (paramString == null)
    {
      this.logger.error("Missing App Token", new Object[0]);
      return false;
    }
    if (paramString.length() != 12)
    {
      this.logger.error("Malformed App Token '%s'", new Object[] { paramString });
      return false;
    }
    return true;
  }

  private boolean checkContext(Context paramContext)
  {
    if (paramContext == null)
    {
      this.logger.error("Missing context", new Object[0]);
      return false;
    }
    if (!Util.checkPermission(paramContext, "android.permission.INTERNET"))
    {
      this.logger.error("Missing permission: INTERNET", new Object[0]);
      return false;
    }
    return true;
  }

  private boolean checkEnvironment(String paramString)
  {
    if (paramString == null)
    {
      this.logger.error("Missing environment", new Object[0]);
      return false;
    }
    if (paramString.equals("sandbox"))
    {
      this.logger.warnInProduction("SANDBOX: Adjust is running in Sandbox mode. Use this setting for testing. Don't forget to set the environment to `production` before publishing!", new Object[0]);
      return true;
    }
    if (paramString.equals("production"))
    {
      this.logger.warnInProduction("PRODUCTION: Adjust is running in Production mode. Use this setting only for the build that you want to publish. Set the environment to `sandbox` if you want to test your app!", new Object[0]);
      return true;
    }
    this.logger.error("Unknown environment '%s'", new Object[] { paramString });
    return false;
  }

  private void init(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.logger = AdjustFactory.getLogger();
    if ((paramBoolean) && ("production".equals(paramString2)))
      setLogLevel(LogLevel.SUPRESS, paramString2);
    while (true)
    {
      if (paramContext != null)
        paramContext = paramContext.getApplicationContext();
      this.context = paramContext;
      this.appToken = paramString1;
      this.environment = paramString2;
      this.eventBufferingEnabled = false;
      this.sendInBackground = false;
      return;
      setLogLevel(LogLevel.INFO, paramString2);
    }
  }

  private void setLogLevel(LogLevel paramLogLevel, String paramString)
  {
    this.logger.setLogLevel(paramLogLevel, "production".equals(paramString));
  }

  public boolean isValid()
  {
    if (!checkAppToken(this.appToken));
    while ((!checkEnvironment(this.environment)) || (!checkContext(this.context)))
      return false;
    return true;
  }

  public void setAppSecret(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = Long.valueOf(paramLong1);
    this.secretId = Util.formatString("%d", arrayOfObject1);
    Object[] arrayOfObject2 = new Object[4];
    arrayOfObject2[0] = Long.valueOf(paramLong2);
    arrayOfObject2[1] = Long.valueOf(paramLong3);
    arrayOfObject2[2] = Long.valueOf(paramLong4);
    arrayOfObject2[3] = Long.valueOf(paramLong5);
    this.appSecret = Util.formatString("%d%d%d%d", arrayOfObject2);
  }

  public void setDeepLinkComponent(Class paramClass)
  {
    this.deepLinkComponent = paramClass;
  }

  public void setDefaultTracker(String paramString)
  {
    this.defaultTracker = paramString;
  }

  public void setDelayStart(double paramDouble)
  {
    this.delayStart = Double.valueOf(paramDouble);
  }

  public void setDeviceKnown(boolean paramBoolean)
  {
    this.deviceKnown = Boolean.valueOf(paramBoolean);
  }

  public void setEventBufferingEnabled(Boolean paramBoolean)
  {
    if (paramBoolean == null)
    {
      this.eventBufferingEnabled = false;
      return;
    }
    this.eventBufferingEnabled = paramBoolean.booleanValue();
  }

  public void setLogLevel(LogLevel paramLogLevel)
  {
    setLogLevel(paramLogLevel, this.environment);
  }

  public void setOnAttributionChangedListener(OnAttributionChangedListener paramOnAttributionChangedListener)
  {
    this.onAttributionChangedListener = paramOnAttributionChangedListener;
  }

  public void setOnDeeplinkResponseListener(OnDeeplinkResponseListener paramOnDeeplinkResponseListener)
  {
    this.onDeeplinkResponseListener = paramOnDeeplinkResponseListener;
  }

  public void setOnEventTrackingFailedListener(OnEventTrackingFailedListener paramOnEventTrackingFailedListener)
  {
    this.onEventTrackingFailedListener = paramOnEventTrackingFailedListener;
  }

  public void setOnEventTrackingSucceededListener(OnEventTrackingSucceededListener paramOnEventTrackingSucceededListener)
  {
    this.onEventTrackingSucceededListener = paramOnEventTrackingSucceededListener;
  }

  public void setOnSessionTrackingFailedListener(OnSessionTrackingFailedListener paramOnSessionTrackingFailedListener)
  {
    this.onSessionTrackingFailedListener = paramOnSessionTrackingFailedListener;
  }

  public void setOnSessionTrackingSucceededListener(OnSessionTrackingSucceededListener paramOnSessionTrackingSucceededListener)
  {
    this.onSessionTrackingSucceededListener = paramOnSessionTrackingSucceededListener;
  }

  public void setProcessName(String paramString)
  {
    this.processName = paramString;
  }

  @Deprecated
  public void setReadMobileEquipmentIdentity(boolean paramBoolean)
  {
    this.logger.warn("This method has been deprecated and shouldn't be used anymore", new Object[0]);
  }

  public void setSdkPrefix(String paramString)
  {
    this.sdkPrefix = paramString;
  }

  public void setSendInBackground(boolean paramBoolean)
  {
    this.sendInBackground = paramBoolean;
  }

  public void setUserAgent(String paramString)
  {
    this.userAgent = paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.AdjustConfig
 * JD-Core Version:    0.6.2
 */