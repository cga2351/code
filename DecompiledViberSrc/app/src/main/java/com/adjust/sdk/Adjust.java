package com.adjust.sdk;

import android.content.Context;
import android.net.Uri;

public class Adjust
{
  private static AdjustInstance defaultInstance;

  public static void addSessionCallbackParameter(String paramString1, String paramString2)
  {
    getDefaultInstance().addSessionCallbackParameter(paramString1, paramString2);
  }

  public static void addSessionPartnerParameter(String paramString1, String paramString2)
  {
    getDefaultInstance().addSessionPartnerParameter(paramString1, paramString2);
  }

  @Deprecated
  public static void appWillOpenUrl(Uri paramUri)
  {
    getDefaultInstance().appWillOpenUrl(paramUri);
  }

  public static void appWillOpenUrl(Uri paramUri, Context paramContext)
  {
    getDefaultInstance().appWillOpenUrl(paramUri, paramContext);
  }

  public static void gdprForgetMe(Context paramContext)
  {
    getDefaultInstance().gdprForgetMe(paramContext);
  }

  public static String getAdid()
  {
    return getDefaultInstance().getAdid();
  }

  public static String getAmazonAdId(Context paramContext)
  {
    return Util.getFireAdvertisingId(paramContext.getContentResolver());
  }

  public static AdjustAttribution getAttribution()
  {
    return getDefaultInstance().getAttribution();
  }

  public static AdjustInstance getDefaultInstance()
  {
    try
    {
      if (defaultInstance == null)
        defaultInstance = new AdjustInstance();
      AdjustInstance localAdjustInstance = defaultInstance;
      return localAdjustInstance;
    }
    finally
    {
    }
  }

  public static void getGoogleAdId(Context paramContext, OnDeviceIdsRead paramOnDeviceIdsRead)
  {
    Util.getGoogleAdId(paramContext, paramOnDeviceIdsRead);
  }

  public static boolean isEnabled()
  {
    return getDefaultInstance().isEnabled();
  }

  public static void onCreate(AdjustConfig paramAdjustConfig)
  {
    getDefaultInstance().onCreate(paramAdjustConfig);
  }

  public static void onPause()
  {
    getDefaultInstance().onPause();
  }

  public static void onResume()
  {
    getDefaultInstance().onResume();
  }

  public static void removeSessionCallbackParameter(String paramString)
  {
    getDefaultInstance().removeSessionCallbackParameter(paramString);
  }

  public static void removeSessionPartnerParameter(String paramString)
  {
    getDefaultInstance().removeSessionPartnerParameter(paramString);
  }

  public static void resetSessionCallbackParameters()
  {
    getDefaultInstance().resetSessionCallbackParameters();
  }

  public static void resetSessionPartnerParameters()
  {
    getDefaultInstance().resetSessionPartnerParameters();
  }

  public static void sendFirstPackages()
  {
    getDefaultInstance().sendFirstPackages();
  }

  public static void setEnabled(boolean paramBoolean)
  {
    getDefaultInstance().setEnabled(paramBoolean);
  }

  public static void setOfflineMode(boolean paramBoolean)
  {
    getDefaultInstance().setOfflineMode(paramBoolean);
  }

  public static void setPushToken(String paramString)
  {
    getDefaultInstance().setPushToken(paramString);
  }

  public static void setPushToken(String paramString, Context paramContext)
  {
    getDefaultInstance().setPushToken(paramString, paramContext);
  }

  public static void setReferrer(String paramString, Context paramContext)
  {
    getDefaultInstance().sendReferrer(paramString, paramContext);
  }

  public static void setTestOptions(AdjustTestOptions paramAdjustTestOptions)
  {
    if ((paramAdjustTestOptions.teardown != null) && (paramAdjustTestOptions.teardown.booleanValue()))
    {
      if (defaultInstance != null)
        defaultInstance.teardown();
      defaultInstance = null;
      AdjustFactory.teardown(paramAdjustTestOptions.context);
    }
    getDefaultInstance().setTestOptions(paramAdjustTestOptions);
  }

  public static void trackEvent(AdjustEvent paramAdjustEvent)
  {
    getDefaultInstance().trackEvent(paramAdjustEvent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.Adjust
 * JD-Core Version:    0.6.2
 */