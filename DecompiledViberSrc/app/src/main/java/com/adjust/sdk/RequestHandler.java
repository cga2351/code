package com.adjust.sdk;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.SocketTimeoutException;

public class RequestHandler
  implements IRequestHandler
{
  private WeakReference<IActivityHandler> activityHandlerWeakRef;
  private String basePath;
  private String gdprPath;
  private ILogger logger = AdjustFactory.getLogger();
  private WeakReference<IPackageHandler> packageHandlerWeakRef;
  private CustomScheduledExecutor scheduledExecutor = new CustomScheduledExecutor("RequestHandler", false);

  public RequestHandler(IActivityHandler paramIActivityHandler, IPackageHandler paramIPackageHandler)
  {
    init(paramIActivityHandler, paramIPackageHandler);
    this.basePath = paramIPackageHandler.getBasePath();
    this.gdprPath = paramIPackageHandler.getGdprPath();
  }

  private void closePackageI(ActivityPackage paramActivityPackage, String paramString, Throwable paramThrowable)
  {
    String str = Util.formatString("%s. (%s) Will retry later", new Object[] { paramActivityPackage.getFailureMessage(), Util.getReasonString(paramString, paramThrowable) });
    this.logger.error(str, new Object[0]);
    ResponseData localResponseData = ResponseData.buildResponseData(paramActivityPackage);
    localResponseData.message = str;
    IPackageHandler localIPackageHandler = (IPackageHandler)this.packageHandlerWeakRef.get();
    if (localIPackageHandler == null)
      return;
    localIPackageHandler.closeFirstPackage(localResponseData, paramActivityPackage);
  }

  private void sendI(ActivityPackage paramActivityPackage, int paramInt)
  {
    String str1;
    if (paramActivityPackage.getActivityKind() != ActivityKind.GDPR)
    {
      str1 = AdjustFactory.getBaseUrl();
      if (this.basePath != null)
        str1 = str1 + this.basePath;
    }
    while (true)
    {
      String str2 = str1 + paramActivityPackage.getPath();
      try
      {
        localResponseData = UtilNetworking.createPOSTHttpsURLConnection(str2, paramActivityPackage, paramInt);
        localIPackageHandler = (IPackageHandler)this.packageHandlerWeakRef.get();
        if (localIPackageHandler == null);
        IActivityHandler localIActivityHandler;
        do
        {
          return;
          str1 = AdjustFactory.getGdprUrl();
          if (this.gdprPath == null)
            break;
          str1 = str1 + this.gdprPath;
          break;
          localIActivityHandler = (IActivityHandler)this.activityHandlerWeakRef.get();
        }
        while (localIActivityHandler == null);
        if (localResponseData.trackingState == TrackingState.OPTED_OUT)
        {
          localIActivityHandler.gotOptOutResponse();
          return;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        sendNextPackageI(paramActivityPackage, "Failed to encode parameters", localUnsupportedEncodingException);
        return;
        if (localResponseData.jsonResponse == null)
        {
          localIPackageHandler.closeFirstPackage(localResponseData, paramActivityPackage);
          return;
        }
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        ResponseData localResponseData;
        IPackageHandler localIPackageHandler;
        closePackageI(paramActivityPackage, "Request timed out", localSocketTimeoutException);
        return;
        localIPackageHandler.sendNextPackage(localResponseData);
        return;
      }
      catch (IOException localIOException)
      {
        closePackageI(paramActivityPackage, "Request failed", localIOException);
        return;
      }
      catch (Throwable localThrowable)
      {
        sendNextPackageI(paramActivityPackage, "Runtime exception", localThrowable);
      }
    }
  }

  private void sendNextPackageI(ActivityPackage paramActivityPackage, String paramString, Throwable paramThrowable)
  {
    String str = Util.formatString("%s. (%s)", new Object[] { paramActivityPackage.getFailureMessage(), Util.getReasonString(paramString, paramThrowable) });
    this.logger.error(str, new Object[0]);
    ResponseData localResponseData = ResponseData.buildResponseData(paramActivityPackage);
    localResponseData.message = str;
    IPackageHandler localIPackageHandler = (IPackageHandler)this.packageHandlerWeakRef.get();
    if (localIPackageHandler == null)
      return;
    localIPackageHandler.sendNextPackage(localResponseData);
  }

  public void init(IActivityHandler paramIActivityHandler, IPackageHandler paramIPackageHandler)
  {
    this.packageHandlerWeakRef = new WeakReference(paramIPackageHandler);
    this.activityHandlerWeakRef = new WeakReference(paramIActivityHandler);
  }

  public void sendPackage(final ActivityPackage paramActivityPackage, final int paramInt)
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        RequestHandler.this.sendI(paramActivityPackage, paramInt);
      }
    });
  }

  public void teardown()
  {
    this.logger.verbose("RequestHandler teardown", new Object[0]);
    if (this.scheduledExecutor != null);
    try
    {
      this.scheduledExecutor.shutdownNow();
      label30: if (this.packageHandlerWeakRef != null)
        this.packageHandlerWeakRef.clear();
      if (this.activityHandlerWeakRef != null)
        this.activityHandlerWeakRef.clear();
      this.scheduledExecutor = null;
      this.packageHandlerWeakRef = null;
      this.activityHandlerWeakRef = null;
      this.logger = null;
      return;
    }
    catch (SecurityException localSecurityException)
    {
      break label30;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.RequestHandler
 * JD-Core Version:    0.6.2
 */