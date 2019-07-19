package com.adjust.sdk;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class PackageHandler
  implements IPackageHandler
{
  private static final String PACKAGE_QUEUE_FILENAME = "AdjustIoPackageQueue";
  private static final String PACKAGE_QUEUE_NAME = "Package queue";
  private WeakReference<IActivityHandler> activityHandlerWeakRef;
  private BackoffStrategy backoffStrategy = AdjustFactory.getPackageHandlerBackoffStrategy();
  private String basePath;
  private Context context;
  private String gdprPath;
  private AtomicBoolean isSending;
  private ILogger logger = AdjustFactory.getLogger();
  private List<ActivityPackage> packageQueue;
  private boolean paused;
  private IRequestHandler requestHandler;
  private CustomScheduledExecutor scheduledExecutor = new CustomScheduledExecutor("PackageHandler", false);

  public PackageHandler(IActivityHandler paramIActivityHandler, Context paramContext, boolean paramBoolean)
  {
    init(paramIActivityHandler, paramContext, paramBoolean);
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        PackageHandler.this.initI();
      }
    });
  }

  private void addI(ActivityPackage paramActivityPackage)
  {
    this.packageQueue.add(paramActivityPackage);
    ILogger localILogger1 = this.logger;
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Integer.valueOf(this.packageQueue.size());
    arrayOfObject1[1] = paramActivityPackage;
    localILogger1.debug("Added package %d (%s)", arrayOfObject1);
    ILogger localILogger2 = this.logger;
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = paramActivityPackage.getExtendedString();
    localILogger2.verbose("%s", arrayOfObject2);
    writePackageQueueI();
  }

  public static Boolean deletePackageQueue(Context paramContext)
  {
    return Boolean.valueOf(paramContext.deleteFile("AdjustIoPackageQueue"));
  }

  static void deleteState(Context paramContext)
  {
    deletePackageQueue(paramContext);
  }

  private void flushI()
  {
    this.packageQueue.clear();
    writePackageQueueI();
  }

  private void initI()
  {
    this.requestHandler = AdjustFactory.getRequestHandler((IActivityHandler)this.activityHandlerWeakRef.get(), this);
    this.isSending = new AtomicBoolean();
    readPackageQueueI();
  }

  private void readPackageQueueI()
  {
    try
    {
      this.packageQueue = ((List)Util.readObject(this.context, "AdjustIoPackageQueue", "Package queue", List.class));
      if (this.packageQueue != null)
      {
        ILogger localILogger2 = this.logger;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Integer.valueOf(this.packageQueue.size());
        localILogger2.debug("Package handler read %d packages", arrayOfObject2);
        return;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        ILogger localILogger1 = this.logger;
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = "Package queue";
        arrayOfObject1[1] = localException.getMessage();
        localILogger1.error("Failed to read %s file (%s)", arrayOfObject1);
        this.packageQueue = null;
      }
      this.packageQueue = new ArrayList();
    }
  }

  private void sendFirstI()
  {
    if (this.packageQueue.isEmpty())
      return;
    if (this.paused)
    {
      this.logger.debug("Package handler is paused", new Object[0]);
      return;
    }
    if (this.isSending.getAndSet(true))
    {
      this.logger.verbose("Package handler is already sending", new Object[0]);
      return;
    }
    ActivityPackage localActivityPackage = (ActivityPackage)this.packageQueue.get(0);
    this.requestHandler.sendPackage(localActivityPackage, -1 + this.packageQueue.size());
  }

  private void sendNextI()
  {
    if (this.packageQueue.isEmpty())
      return;
    this.packageQueue.remove(0);
    writePackageQueueI();
    this.isSending.set(false);
    this.logger.verbose("Package handler can send", new Object[0]);
    sendFirstI();
  }

  private void writePackageQueueI()
  {
    Util.writeObject(this.packageQueue, this.context, "AdjustIoPackageQueue", "Package queue");
    ILogger localILogger = this.logger;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(this.packageQueue.size());
    localILogger.debug("Package handler wrote %d packages", arrayOfObject);
  }

  public void addPackage(final ActivityPackage paramActivityPackage)
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        PackageHandler.this.addI(paramActivityPackage);
      }
    });
  }

  public void closeFirstPackage(ResponseData paramResponseData, ActivityPackage paramActivityPackage)
  {
    paramResponseData.willRetry = true;
    IActivityHandler localIActivityHandler = (IActivityHandler)this.activityHandlerWeakRef.get();
    if (localIActivityHandler != null)
      localIActivityHandler.finishedTrackingActivity(paramResponseData);
    Runnable local5 = new Runnable()
    {
      public void run()
      {
        PackageHandler.this.logger.verbose("Package handler can send", new Object[0]);
        PackageHandler.this.isSending.set(false);
        PackageHandler.this.sendFirstPackage();
      }
    };
    if (paramActivityPackage == null)
    {
      local5.run();
      return;
    }
    int i = paramActivityPackage.increaseRetries();
    long l = Util.getWaitingTime(i, this.backoffStrategy);
    double d = l / 1000.0D;
    String str = Util.SecondsDisplayFormat.format(d);
    ILogger localILogger = this.logger;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = str;
    arrayOfObject[1] = Integer.valueOf(i);
    localILogger.verbose("Waiting for %s seconds before retrying the %d time", arrayOfObject);
    this.scheduledExecutor.schedule(local5, l, TimeUnit.MILLISECONDS);
  }

  public void flush()
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        PackageHandler.this.flushI();
      }
    });
  }

  public String getBasePath()
  {
    return this.basePath;
  }

  public String getGdprPath()
  {
    return this.gdprPath;
  }

  public void init(IActivityHandler paramIActivityHandler, Context paramContext, boolean paramBoolean)
  {
    this.activityHandlerWeakRef = new WeakReference(paramIActivityHandler);
    this.context = paramContext;
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      this.paused = bool;
      this.basePath = paramIActivityHandler.getBasePath();
      this.gdprPath = paramIActivityHandler.getGdprPath();
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

  public void sendFirstPackage()
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        PackageHandler.this.sendFirstI();
      }
    });
  }

  public void sendNextPackage(ResponseData paramResponseData)
  {
    this.scheduledExecutor.submit(new Runnable()
    {
      public void run()
      {
        PackageHandler.this.sendNextI();
      }
    });
    IActivityHandler localIActivityHandler = (IActivityHandler)this.activityHandlerWeakRef.get();
    if (localIActivityHandler != null)
      localIActivityHandler.finishedTrackingActivity(paramResponseData);
  }

  public void teardown()
  {
    this.logger.verbose("PackageHandler teardown", new Object[0]);
    if (this.scheduledExecutor != null);
    try
    {
      this.scheduledExecutor.shutdownNow();
      label31: if (this.activityHandlerWeakRef != null)
        this.activityHandlerWeakRef.clear();
      if (this.requestHandler != null)
        this.requestHandler.teardown();
      if (this.packageQueue != null)
        this.packageQueue.clear();
      this.scheduledExecutor = null;
      this.requestHandler = null;
      this.activityHandlerWeakRef = null;
      this.packageQueue = null;
      this.isSending = null;
      this.context = null;
      this.logger = null;
      this.backoffStrategy = null;
      return;
    }
    catch (SecurityException localSecurityException)
    {
      break label31;
    }
  }

  public void updatePackages(SessionParameters paramSessionParameters)
  {
    if (paramSessionParameters != null);
    for (final SessionParameters localSessionParameters = paramSessionParameters.deepCopy(); ; localSessionParameters = null)
    {
      this.scheduledExecutor.submit(new Runnable()
      {
        public void run()
        {
          PackageHandler.this.updatePackagesI(localSessionParameters);
        }
      });
      return;
    }
  }

  public void updatePackagesI(SessionParameters paramSessionParameters)
  {
    if (paramSessionParameters == null)
      return;
    this.logger.debug("Updating package handler queue", new Object[0]);
    ILogger localILogger1 = this.logger;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = paramSessionParameters.callbackParameters;
    localILogger1.verbose("Session callback parameters: %s", arrayOfObject1);
    ILogger localILogger2 = this.logger;
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = paramSessionParameters.partnerParameters;
    localILogger2.verbose("Session partner parameters: %s", arrayOfObject2);
    Iterator localIterator = this.packageQueue.iterator();
    while (localIterator.hasNext())
    {
      ActivityPackage localActivityPackage = (ActivityPackage)localIterator.next();
      Map localMap = localActivityPackage.getParameters();
      b.a(localMap, "callback_params", Util.mergeParameters(paramSessionParameters.callbackParameters, localActivityPackage.getCallbackParameters(), "Callback"));
      b.a(localMap, "partner_params", Util.mergeParameters(paramSessionParameters.partnerParameters, localActivityPackage.getPartnerParameters(), "Partner"));
    }
    writePackageQueueI();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.PackageHandler
 * JD-Core Version:    0.6.2
 */