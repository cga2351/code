package com.adjust.sdk;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.SocketTimeoutException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;

public class SdkClickHandler
  implements ISdkClickHandler
{
  private static final double MILLISECONDS_TO_SECONDS_DIVISOR = 1000.0D;
  private static final String SCHEDULED_EXECUTOR_SOURCE = "SdkClickHandler";
  private static final String SOURCE_INSTALL_REFERRER = "install_referrer";
  private static final String SOURCE_REFTAG = "reftag";
  private WeakReference<IActivityHandler> activityHandlerWeakRef;
  private BackoffStrategy backoffStrategy;
  private String basePath;
  private ILogger logger;
  private List<ActivityPackage> packageQueue;
  private boolean paused;
  private CustomScheduledExecutor scheduledExecutor;

  public SdkClickHandler(IActivityHandler paramIActivityHandler, boolean paramBoolean)
  {
    init(paramIActivityHandler, paramBoolean);
    this.logger = AdjustFactory.getLogger();
    this.backoffStrategy = AdjustFactory.getSdkClickBackoffStrategy();
    this.scheduledExecutor = new CustomScheduledExecutor("SdkClickHandler", false);
  }

  private void logErrorMessageI(ActivityPackage paramActivityPackage, String paramString, Throwable paramThrowable)
  {
    String str = Util.formatString("%s. (%s)", new Object[] { paramActivityPackage.getFailureMessage(), Util.getReasonString(paramString, paramThrowable) });
    this.logger.error(str, new Object[0]);
  }

  private void retrySendingI(ActivityPackage paramActivityPackage)
  {
    int i = paramActivityPackage.increaseRetries();
    ILogger localILogger = this.logger;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(i);
    localILogger.error("Retrying sdk_click package for the %d time", arrayOfObject);
    sendSdkClick(paramActivityPackage);
  }

  private void sendNextSdkClick()
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        SdkClickHandler.this.sendNextSdkClickI();
      }
    });
  }

  private void sendNextSdkClickI()
  {
    if (this.paused);
    while (this.packageQueue.isEmpty())
      return;
    final ActivityPackage localActivityPackage = (ActivityPackage)this.packageQueue.remove(0);
    int i = localActivityPackage.getRetries();
    Runnable local4 = new Runnable()
    {
      public void run()
      {
        SdkClickHandler.this.sendSdkClickI(localActivityPackage);
        SdkClickHandler.this.sendNextSdkClick();
      }
    };
    if (i <= 0)
    {
      local4.run();
      return;
    }
    long l = Util.getWaitingTime(i, this.backoffStrategy);
    double d = l / 1000.0D;
    String str = Util.SecondsDisplayFormat.format(d);
    ILogger localILogger = this.logger;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = str;
    arrayOfObject[1] = Integer.valueOf(i);
    localILogger.verbose("Waiting for %s seconds before retrying sdk_click for the %d time", arrayOfObject);
    this.scheduledExecutor.schedule(local4, l, TimeUnit.MILLISECONDS);
  }

  private void sendSdkClickI(ActivityPackage paramActivityPackage)
  {
    long l1 = -1L;
    IActivityHandler localIActivityHandler = (IActivityHandler)this.activityHandlerWeakRef.get();
    if (localIActivityHandler.getActivityState().isGdprForgotten);
    String str1;
    int i;
    label64: String str2;
    do
    {
      return;
      str1 = (String)paramActivityPackage.getParameters().get("source");
      if ((str1 == null) || (!str1.equals("reftag")))
        break;
      i = 1;
      str2 = (String)paramActivityPackage.getParameters().get("raw_referrer");
    }
    while ((i != 0) && (new SharedPreferencesManager(localIActivityHandler.getContext()).getRawReferrer(str2, paramActivityPackage.getClickTimeInMilliseconds()) == null));
    int j;
    label129: String str6;
    long l2;
    if ((str1 != null) && (str1.equals("install_referrer")))
    {
      j = 1;
      if (j == 0)
        break label437;
      long l3 = paramActivityPackage.getClickTimeInSeconds();
      long l4 = paramActivityPackage.getInstallBeginTimeInSeconds();
      str6 = (String)paramActivityPackage.getParameters().get("referrer");
      l2 = l3;
      l1 = l4;
    }
    for (String str3 = str6; ; str3 = null)
    {
      while (true)
      {
        String str4 = AdjustFactory.getBaseUrl();
        if (this.basePath != null)
          str4 = str4 + this.basePath;
        String str5 = str4 + paramActivityPackage.getPath();
        try
        {
          localSdkClickResponseData = (SdkClickResponseData)UtilNetworking.createPOSTHttpsURLConnection(str5, paramActivityPackage, -1 + this.packageQueue.size());
          if (localSdkClickResponseData.jsonResponse == null)
          {
            retrySendingI(paramActivityPackage);
            return;
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          logErrorMessageI(paramActivityPackage, "Sdk_click failed to encode parameters", localUnsupportedEncodingException);
          return;
          i = 0;
          break label64;
          j = 0;
          break label129;
          if (localIActivityHandler == null)
            break;
          if (localSdkClickResponseData.trackingState == TrackingState.OPTED_OUT)
          {
            localIActivityHandler.gotOptOutResponse();
            return;
          }
        }
        catch (SocketTimeoutException localSocketTimeoutException)
        {
          SdkClickResponseData localSdkClickResponseData;
          logErrorMessageI(paramActivityPackage, "Sdk_click request timed out. Will retry later", localSocketTimeoutException);
          retrySendingI(paramActivityPackage);
          return;
          if (i != 0)
            new SharedPreferencesManager(localIActivityHandler.getContext()).removeRawReferrer(str2, paramActivityPackage.getClickTimeInMilliseconds());
          if (j != 0)
          {
            localSdkClickResponseData.clickTime = l2;
            localSdkClickResponseData.installBegin = l1;
            localSdkClickResponseData.installReferrer = str3;
            localSdkClickResponseData.isInstallReferrer = true;
          }
          localIActivityHandler.finishedTrackingActivity(localSdkClickResponseData);
          return;
        }
        catch (IOException localIOException)
        {
          logErrorMessageI(paramActivityPackage, "Sdk_click request failed. Will retry later", localIOException);
          retrySendingI(paramActivityPackage);
          return;
        }
        catch (Throwable localThrowable)
        {
          logErrorMessageI(paramActivityPackage, "Sdk_click runtime exception", localThrowable);
          return;
        }
      }
      label437: l2 = l1;
    }
  }

  public void init(IActivityHandler paramIActivityHandler, boolean paramBoolean)
  {
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      this.paused = bool;
      this.packageQueue = new ArrayList();
      this.activityHandlerWeakRef = new WeakReference(paramIActivityHandler);
      this.basePath = paramIActivityHandler.getBasePath();
      return;
    }
  }

  public void pauseSending()
  {
    this.paused = true;
  }

  public void resumeSending()
  {
    this.paused = false;
    sendNextSdkClick();
  }

  public void sendReftagReferrers()
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        IActivityHandler localIActivityHandler = (IActivityHandler)SdkClickHandler.this.activityHandlerWeakRef.get();
        SharedPreferencesManager localSharedPreferencesManager = new SharedPreferencesManager(localIActivityHandler.getContext());
        while (true)
        {
          int i;
          try
          {
            JSONArray localJSONArray1 = localSharedPreferencesManager.getRawReferrerArray();
            i = 0;
            int j = 0;
            if (i < localJSONArray1.length())
            {
              JSONArray localJSONArray2 = localJSONArray1.getJSONArray(i);
              if (localJSONArray2.optInt(2, -1) == 0)
              {
                String str = localJSONArray2.optString(0, null);
                long l = localJSONArray2.optLong(1, -1L);
                localJSONArray2.put(2, 1);
                ActivityPackage localActivityPackage = PackageFactory.buildReftagSdkClickPackage(str, l, localIActivityHandler.getActivityState(), localIActivityHandler.getAdjustConfig(), localIActivityHandler.getDeviceInfo(), localIActivityHandler.getSessionParameters());
                SdkClickHandler.this.sendSdkClick(localActivityPackage);
                j = 1;
              }
            }
            else
            {
              if (j != 0)
                localSharedPreferencesManager.saveRawReferrerArray(localJSONArray1);
              return;
            }
          }
          catch (JSONException localJSONException)
          {
            ILogger localILogger = SdkClickHandler.this.logger;
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = localJSONException.getMessage();
            localILogger.error("Send saved raw referrers error (%s)", arrayOfObject);
            return;
          }
          i++;
        }
      }
    });
  }

  public void sendSdkClick(final ActivityPackage paramActivityPackage)
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        SdkClickHandler.this.packageQueue.add(paramActivityPackage);
        ILogger localILogger1 = SdkClickHandler.this.logger;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Integer.valueOf(SdkClickHandler.this.packageQueue.size());
        localILogger1.debug("Added sdk_click %d", arrayOfObject1);
        ILogger localILogger2 = SdkClickHandler.this.logger;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = paramActivityPackage.getExtendedString();
        localILogger2.verbose("%s", arrayOfObject2);
        SdkClickHandler.this.sendNextSdkClick();
      }
    });
  }

  public void teardown()
  {
    this.logger.verbose("SdkClickHandler teardown", new Object[0]);
    if (this.scheduledExecutor != null);
    try
    {
      this.scheduledExecutor.shutdownNow();
      label31: if (this.packageQueue != null)
        this.packageQueue.clear();
      if (this.activityHandlerWeakRef != null)
        this.activityHandlerWeakRef.clear();
      this.logger = null;
      this.packageQueue = null;
      this.backoffStrategy = null;
      this.scheduledExecutor = null;
      return;
    }
    catch (SecurityException localSecurityException)
    {
      break label31;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.SdkClickHandler
 * JD-Core Version:    0.6.2
 */