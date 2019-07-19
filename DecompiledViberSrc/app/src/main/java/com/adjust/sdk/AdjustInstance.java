package com.adjust.sdk;

import android.content.Context;
import android.net.Uri;
import java.util.ArrayList;
import java.util.List;

public class AdjustInstance
{
  private IActivityHandler activityHandler;
  private String basePath;
  private String gdprPath;
  private List<IRunActivityHandler> preLaunchActionsArray;
  private String pushToken;
  private Boolean startEnabled = null;
  private boolean startOffline = false;

  private boolean checkActivityHandler()
  {
    return checkActivityHandler(null);
  }

  private boolean checkActivityHandler(String paramString)
  {
    if (this.activityHandler == null)
    {
      if (paramString != null)
      {
        AdjustFactory.getLogger().warn("Adjust not initialized, but %s saved for launch", new Object[] { paramString });
        return false;
      }
      AdjustFactory.getLogger().error("Adjust not initialized correctly", new Object[0]);
      return false;
    }
    return true;
  }

  private boolean checkActivityHandler(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean)
      return checkActivityHandler(paramString1);
    return checkActivityHandler(paramString2);
  }

  private boolean isInstanceEnabled()
  {
    return (this.startEnabled == null) || (this.startEnabled.booleanValue());
  }

  private void saveGdprForgetMe(final Context paramContext)
  {
    Util.runInBackground(new Runnable()
    {
      public void run()
      {
        new SharedPreferencesManager(paramContext).setGdprForgetMe();
      }
    });
  }

  private void savePushToken(final String paramString, final Context paramContext)
  {
    Util.runInBackground(new Runnable()
    {
      public void run()
      {
        new SharedPreferencesManager(paramContext).savePushToken(paramString);
      }
    });
  }

  private void saveRawReferrer(final String paramString, final long paramLong, final Context paramContext)
  {
    Util.runInBackground(new Runnable()
    {
      public void run()
      {
        new SharedPreferencesManager(paramContext).saveRawReferrer(paramString, paramLong);
      }
    });
  }

  private void setSendingReferrersAsNotSent(final Context paramContext)
  {
    Util.runInBackground(new Runnable()
    {
      public void run()
      {
        new SharedPreferencesManager(paramContext).setSendingReferrersAsNotSent();
      }
    });
  }

  public void addSessionCallbackParameter(final String paramString1, final String paramString2)
  {
    if (checkActivityHandler("adding session callback parameter"))
    {
      this.activityHandler.addSessionCallbackParameter(paramString1, paramString2);
      return;
    }
    if (this.preLaunchActionsArray == null)
      this.preLaunchActionsArray = new ArrayList();
    this.preLaunchActionsArray.add(new IRunActivityHandler()
    {
      public void run(ActivityHandler paramAnonymousActivityHandler)
      {
        paramAnonymousActivityHandler.addSessionCallbackParameterI(paramString1, paramString2);
      }
    });
  }

  public void addSessionPartnerParameter(final String paramString1, final String paramString2)
  {
    if (checkActivityHandler("adding session partner parameter"))
    {
      this.activityHandler.addSessionPartnerParameter(paramString1, paramString2);
      return;
    }
    if (this.preLaunchActionsArray == null)
      this.preLaunchActionsArray = new ArrayList();
    this.preLaunchActionsArray.add(new IRunActivityHandler()
    {
      public void run(ActivityHandler paramAnonymousActivityHandler)
      {
        paramAnonymousActivityHandler.addSessionPartnerParameterI(paramString1, paramString2);
      }
    });
  }

  public void appWillOpenUrl(Uri paramUri)
  {
    if (!checkActivityHandler())
      return;
    long l = System.currentTimeMillis();
    this.activityHandler.readOpenUrl(paramUri, l);
  }

  public void appWillOpenUrl(Uri paramUri, Context paramContext)
  {
    long l = System.currentTimeMillis();
    if (!checkActivityHandler())
    {
      new SharedPreferencesManager(paramContext).saveDeeplink(paramUri, l);
      return;
    }
    this.activityHandler.readOpenUrl(paramUri, l);
  }

  public void gdprForgetMe(Context paramContext)
  {
    saveGdprForgetMe(paramContext);
    if ((checkActivityHandler("gdpr")) && (this.activityHandler.isEnabled()))
      this.activityHandler.gdprForgetMe();
  }

  public String getAdid()
  {
    if (!checkActivityHandler())
      return null;
    return this.activityHandler.getAdid();
  }

  public AdjustAttribution getAttribution()
  {
    if (!checkActivityHandler())
      return null;
    return this.activityHandler.getAttribution();
  }

  public boolean isEnabled()
  {
    if (!checkActivityHandler())
      return isInstanceEnabled();
    return this.activityHandler.isEnabled();
  }

  public void onCreate(AdjustConfig paramAdjustConfig)
  {
    if (paramAdjustConfig == null)
    {
      AdjustFactory.getLogger().error("AdjustConfig missing", new Object[0]);
      return;
    }
    if (!paramAdjustConfig.isValid())
    {
      AdjustFactory.getLogger().error("AdjustConfig not initialized correctly", new Object[0]);
      return;
    }
    if (this.activityHandler != null)
    {
      AdjustFactory.getLogger().error("Adjust already initialized", new Object[0]);
      return;
    }
    paramAdjustConfig.preLaunchActionsArray = this.preLaunchActionsArray;
    paramAdjustConfig.pushToken = this.pushToken;
    paramAdjustConfig.startEnabled = this.startEnabled;
    paramAdjustConfig.startOffline = this.startOffline;
    paramAdjustConfig.basePath = this.basePath;
    paramAdjustConfig.gdprPath = this.gdprPath;
    this.activityHandler = AdjustFactory.getActivityHandler(paramAdjustConfig);
    setSendingReferrersAsNotSent(paramAdjustConfig.context);
  }

  public void onPause()
  {
    if (!checkActivityHandler())
      return;
    this.activityHandler.onPause();
  }

  public void onResume()
  {
    if (!checkActivityHandler())
      return;
    this.activityHandler.onResume();
  }

  public void removeSessionCallbackParameter(final String paramString)
  {
    if (checkActivityHandler("removing session callback parameter"))
    {
      this.activityHandler.removeSessionCallbackParameter(paramString);
      return;
    }
    if (this.preLaunchActionsArray == null)
      this.preLaunchActionsArray = new ArrayList();
    this.preLaunchActionsArray.add(new IRunActivityHandler()
    {
      public void run(ActivityHandler paramAnonymousActivityHandler)
      {
        paramAnonymousActivityHandler.removeSessionCallbackParameterI(paramString);
      }
    });
  }

  public void removeSessionPartnerParameter(final String paramString)
  {
    if (checkActivityHandler("removing session partner parameter"))
    {
      this.activityHandler.removeSessionPartnerParameter(paramString);
      return;
    }
    if (this.preLaunchActionsArray == null)
      this.preLaunchActionsArray = new ArrayList();
    this.preLaunchActionsArray.add(new IRunActivityHandler()
    {
      public void run(ActivityHandler paramAnonymousActivityHandler)
      {
        paramAnonymousActivityHandler.removeSessionPartnerParameterI(paramString);
      }
    });
  }

  public void resetSessionCallbackParameters()
  {
    if (checkActivityHandler("resetting session callback parameters"))
    {
      this.activityHandler.resetSessionCallbackParameters();
      return;
    }
    if (this.preLaunchActionsArray == null)
      this.preLaunchActionsArray = new ArrayList();
    this.preLaunchActionsArray.add(new IRunActivityHandler()
    {
      public void run(ActivityHandler paramAnonymousActivityHandler)
      {
        paramAnonymousActivityHandler.resetSessionCallbackParametersI();
      }
    });
  }

  public void resetSessionPartnerParameters()
  {
    if (checkActivityHandler("resetting session partner parameters"))
    {
      this.activityHandler.resetSessionPartnerParameters();
      return;
    }
    if (this.preLaunchActionsArray == null)
      this.preLaunchActionsArray = new ArrayList();
    this.preLaunchActionsArray.add(new IRunActivityHandler()
    {
      public void run(ActivityHandler paramAnonymousActivityHandler)
      {
        paramAnonymousActivityHandler.resetSessionPartnerParametersI();
      }
    });
  }

  public void sendFirstPackages()
  {
    if (!checkActivityHandler())
      return;
    this.activityHandler.sendFirstPackages();
  }

  public void sendReferrer(String paramString, Context paramContext)
  {
    long l = System.currentTimeMillis();
    if ((paramString == null) || (paramString.length() == 0));
    do
    {
      return;
      saveRawReferrer(paramString, l, paramContext);
    }
    while ((!checkActivityHandler("referrer")) || (!this.activityHandler.isEnabled()));
    this.activityHandler.sendReftagReferrer();
  }

  public void setEnabled(boolean paramBoolean)
  {
    this.startEnabled = Boolean.valueOf(paramBoolean);
    if (checkActivityHandler(paramBoolean, "enabled mode", "disabled mode"))
      this.activityHandler.setEnabled(paramBoolean);
  }

  public void setOfflineMode(boolean paramBoolean)
  {
    if (!checkActivityHandler(paramBoolean, "offline mode", "online mode"))
    {
      this.startOffline = paramBoolean;
      return;
    }
    this.activityHandler.setOfflineMode(paramBoolean);
  }

  public void setPushToken(String paramString)
  {
    if (!checkActivityHandler("push token"))
    {
      this.pushToken = paramString;
      return;
    }
    this.activityHandler.setPushToken(paramString, false);
  }

  public void setPushToken(String paramString, Context paramContext)
  {
    savePushToken(paramString, paramContext);
    if ((checkActivityHandler("push token")) && (this.activityHandler.isEnabled()))
      this.activityHandler.setPushToken(paramString, true);
  }

  public void setTestOptions(AdjustTestOptions paramAdjustTestOptions)
  {
    if (paramAdjustTestOptions.basePath != null)
      this.basePath = paramAdjustTestOptions.basePath;
    if (paramAdjustTestOptions.gdprPath != null)
      this.gdprPath = paramAdjustTestOptions.gdprPath;
    if (paramAdjustTestOptions.baseUrl != null)
      AdjustFactory.setBaseUrl(paramAdjustTestOptions.baseUrl);
    if (paramAdjustTestOptions.gdprUrl != null)
      AdjustFactory.setGdprUrl(paramAdjustTestOptions.gdprUrl);
    if ((paramAdjustTestOptions.useTestConnectionOptions != null) && (paramAdjustTestOptions.useTestConnectionOptions.booleanValue()))
      AdjustFactory.useTestConnectionOptions();
    if (paramAdjustTestOptions.timerIntervalInMilliseconds != null)
      AdjustFactory.setTimerInterval(paramAdjustTestOptions.timerIntervalInMilliseconds.longValue());
    if (paramAdjustTestOptions.timerStartInMilliseconds != null)
      AdjustFactory.setTimerStart(paramAdjustTestOptions.timerIntervalInMilliseconds.longValue());
    if (paramAdjustTestOptions.sessionIntervalInMilliseconds != null)
      AdjustFactory.setSessionInterval(paramAdjustTestOptions.sessionIntervalInMilliseconds.longValue());
    if (paramAdjustTestOptions.subsessionIntervalInMilliseconds != null)
      AdjustFactory.setSubsessionInterval(paramAdjustTestOptions.subsessionIntervalInMilliseconds.longValue());
    if (paramAdjustTestOptions.tryInstallReferrer != null)
      AdjustFactory.setTryInstallReferrer(paramAdjustTestOptions.tryInstallReferrer.booleanValue());
    if (paramAdjustTestOptions.noBackoffWait != null)
    {
      AdjustFactory.setPackageHandlerBackoffStrategy(BackoffStrategy.NO_WAIT);
      AdjustFactory.setSdkClickBackoffStrategy(BackoffStrategy.NO_WAIT);
    }
  }

  public void teardown()
  {
    if (!checkActivityHandler())
      return;
    this.activityHandler.teardown();
    this.activityHandler = null;
  }

  public void trackEvent(AdjustEvent paramAdjustEvent)
  {
    if (!checkActivityHandler())
      return;
    this.activityHandler.trackEvent(paramAdjustEvent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.AdjustInstance
 * JD-Core Version:    0.6.2
 */