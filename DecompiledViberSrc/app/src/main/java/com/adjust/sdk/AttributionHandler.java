package com.adjust.sdk;

import android.net.Uri;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.Map;
import org.json.JSONObject;

public class AttributionHandler
  implements IAttributionHandler
{
  private static final String ATTRIBUTION_TIMER_NAME = "Attribution timer";
  private WeakReference<IActivityHandler> activityHandlerWeakRef;
  private ActivityPackage attributionPackage;
  private String basePath;
  private ILogger logger = AdjustFactory.getLogger();
  private boolean paused;
  private CustomScheduledExecutor scheduledExecutor = new CustomScheduledExecutor("AttributionHandler", false);
  private TimerOnce timer = new TimerOnce(new Runnable()
  {
    public void run()
    {
      AttributionHandler.this.sendAttributionRequest();
    }
  }
  , "Attribution timer");

  public AttributionHandler(IActivityHandler paramIActivityHandler, ActivityPackage paramActivityPackage, boolean paramBoolean)
  {
    this.basePath = paramIActivityHandler.getBasePath();
    init(paramIActivityHandler, paramActivityPackage, paramBoolean);
  }

  private void checkAttributionI(IActivityHandler paramIActivityHandler, ResponseData paramResponseData)
  {
    if (paramResponseData.jsonResponse == null)
      return;
    long l = paramResponseData.jsonResponse.optLong("ask_in", -1L);
    if (l >= 0L)
    {
      paramIActivityHandler.setAskingAttribution(true);
      getAttributionI(l, false);
      return;
    }
    paramIActivityHandler.setAskingAttribution(false);
    paramResponseData.attribution = AdjustAttribution.fromJson(paramResponseData.jsonResponse.optJSONObject("attribution"), paramResponseData.adid, Util.getSdkPrefixPlatform(this.attributionPackage.getClientSdk()));
  }

  private void checkAttributionResponseI(IActivityHandler paramIActivityHandler, AttributionResponseData paramAttributionResponseData)
  {
    checkAttributionI(paramIActivityHandler, paramAttributionResponseData);
    checkDeeplinkI(paramAttributionResponseData);
    paramIActivityHandler.launchAttributionResponseTasks(paramAttributionResponseData);
  }

  private void checkDeeplinkI(AttributionResponseData paramAttributionResponseData)
  {
    if (paramAttributionResponseData.jsonResponse == null);
    String str;
    do
    {
      JSONObject localJSONObject;
      do
      {
        return;
        localJSONObject = paramAttributionResponseData.jsonResponse.optJSONObject("attribution");
      }
      while (localJSONObject == null);
      str = localJSONObject.optString("deeplink", null);
    }
    while (str == null);
    paramAttributionResponseData.deeplink = Uri.parse(str);
  }

  private void checkSdkClickResponseI(IActivityHandler paramIActivityHandler, SdkClickResponseData paramSdkClickResponseData)
  {
    checkAttributionI(paramIActivityHandler, paramSdkClickResponseData);
    paramIActivityHandler.launchSdkClickResponseTasks(paramSdkClickResponseData);
  }

  private void checkSessionResponseI(IActivityHandler paramIActivityHandler, SessionResponseData paramSessionResponseData)
  {
    checkAttributionI(paramIActivityHandler, paramSessionResponseData);
    paramIActivityHandler.launchSessionResponseTasks(paramSessionResponseData);
  }

  private void getAttributionI(long paramLong, boolean paramBoolean)
  {
    if (this.timer.getFireIn() > paramLong)
      return;
    if (paramLong != 0L)
    {
      double d = paramLong / 1000.0D;
      String str2 = Util.SecondsDisplayFormat.format(d);
      this.logger.debug("Waiting to query attribution in %s seconds", new Object[] { str2 });
    }
    if (paramBoolean);
    for (String str1 = "sdk"; ; str1 = "backend")
    {
      this.attributionPackage.getParameters().put("initiated_by", str1);
      this.timer.startIn(paramLong);
      return;
    }
  }

  private void sendAttributionRequestI()
  {
    if (((IActivityHandler)this.activityHandlerWeakRef.get()).getActivityState().isGdprForgotten);
    ResponseData localResponseData;
    while (true)
    {
      return;
      if (this.paused)
      {
        this.logger.debug("Attribution handler is paused", new Object[0]);
        return;
      }
      ILogger localILogger1 = this.logger;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = this.attributionPackage.getExtendedString();
      localILogger1.verbose("%s", arrayOfObject1);
      try
      {
        localResponseData = UtilNetworking.createGETHttpsURLConnection(this.attributionPackage, this.basePath);
        if ((localResponseData instanceof AttributionResponseData))
          if (localResponseData.trackingState == TrackingState.OPTED_OUT)
          {
            ((IActivityHandler)this.activityHandlerWeakRef.get()).gotOptOutResponse();
            return;
          }
      }
      catch (Exception localException)
      {
        ILogger localILogger2 = this.logger;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = localException.getMessage();
        localILogger2.error("Failed to get attribution (%s)", arrayOfObject2);
        return;
      }
    }
    checkAttributionResponse((AttributionResponseData)localResponseData);
  }

  public void checkAttributionResponse(final AttributionResponseData paramAttributionResponseData)
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        IActivityHandler localIActivityHandler = (IActivityHandler)AttributionHandler.this.activityHandlerWeakRef.get();
        if (localIActivityHandler == null)
          return;
        AttributionHandler.this.checkAttributionResponseI(localIActivityHandler, paramAttributionResponseData);
      }
    });
  }

  public void checkSdkClickResponse(final SdkClickResponseData paramSdkClickResponseData)
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        IActivityHandler localIActivityHandler = (IActivityHandler)AttributionHandler.this.activityHandlerWeakRef.get();
        if (localIActivityHandler == null)
          return;
        AttributionHandler.this.checkSdkClickResponseI(localIActivityHandler, paramSdkClickResponseData);
      }
    });
  }

  public void checkSessionResponse(final SessionResponseData paramSessionResponseData)
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        IActivityHandler localIActivityHandler = (IActivityHandler)AttributionHandler.this.activityHandlerWeakRef.get();
        if (localIActivityHandler == null)
          return;
        AttributionHandler.this.checkSessionResponseI(localIActivityHandler, paramSessionResponseData);
      }
    });
  }

  public void getAttribution()
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        AttributionHandler.this.getAttributionI(0L, true);
      }
    });
  }

  public void init(IActivityHandler paramIActivityHandler, ActivityPackage paramActivityPackage, boolean paramBoolean)
  {
    this.activityHandlerWeakRef = new WeakReference(paramIActivityHandler);
    this.attributionPackage = paramActivityPackage;
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      this.paused = bool;
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
  }

  public void sendAttributionRequest()
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        AttributionHandler.this.sendAttributionRequestI();
      }
    });
  }

  public void teardown()
  {
    this.logger.verbose("AttributionHandler teardown", new Object[0]);
    if (this.timer != null)
      this.timer.teardown();
    if (this.scheduledExecutor != null);
    try
    {
      this.scheduledExecutor.shutdownNow();
      label45: if (this.activityHandlerWeakRef != null)
        this.activityHandlerWeakRef.clear();
      this.scheduledExecutor = null;
      this.activityHandlerWeakRef = null;
      this.logger = null;
      this.attributionPackage = null;
      this.timer = null;
      return;
    }
    catch (SecurityException localSecurityException)
    {
      break label45;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.AttributionHandler
 * JD-Core Version:    0.6.2
 */