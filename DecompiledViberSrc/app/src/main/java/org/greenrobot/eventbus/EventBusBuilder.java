package org.greenrobot.eventbus;

import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

public class EventBusBuilder
{
  private static final ExecutorService DEFAULT_EXECUTOR_SERVICE = Executors.newCachedThreadPool();
  boolean eventInheritance = true;
  ExecutorService executorService = DEFAULT_EXECUTOR_SERVICE;
  boolean ignoreGeneratedIndex;
  boolean logNoSubscriberMessages = true;
  boolean logSubscriberExceptions = true;
  Logger logger;
  MainThreadSupport mainThreadSupport;
  boolean sendNoSubscriberEvent = true;
  boolean sendSubscriberExceptionEvent = true;
  List<Class<?>> skipMethodVerificationForClasses;
  boolean strictMethodVerification;
  List<SubscriberInfoIndex> subscriberInfoIndexes;
  boolean throwSubscriberException;

  public EventBusBuilder addIndex(SubscriberInfoIndex paramSubscriberInfoIndex)
  {
    if (this.subscriberInfoIndexes == null)
      this.subscriberInfoIndexes = new ArrayList();
    this.subscriberInfoIndexes.add(paramSubscriberInfoIndex);
    return this;
  }

  public EventBus build()
  {
    return new EventBus(this);
  }

  public EventBusBuilder eventInheritance(boolean paramBoolean)
  {
    this.eventInheritance = paramBoolean;
    return this;
  }

  public EventBusBuilder executorService(ExecutorService paramExecutorService)
  {
    this.executorService = paramExecutorService;
    return this;
  }

  Object getAndroidMainLooperOrNull()
  {
    try
    {
      Looper localLooper = Looper.getMainLooper();
      return localLooper;
    }
    catch (RuntimeException localRuntimeException)
    {
    }
    return null;
  }

  Logger getLogger()
  {
    if (this.logger != null)
      return this.logger;
    if ((Logger.AndroidLogger.isAndroidLogAvailable()) && (getAndroidMainLooperOrNull() != null))
      return new Logger.AndroidLogger("EventBus");
    return new Logger.SystemOutLogger();
  }

  MainThreadSupport getMainThreadSupport()
  {
    if (this.mainThreadSupport != null)
      return this.mainThreadSupport;
    if (Logger.AndroidLogger.isAndroidLogAvailable())
    {
      Object localObject = getAndroidMainLooperOrNull();
      if (localObject == null)
        return null;
      return new MainThreadSupport.AndroidHandlerMainThreadSupport((Looper)localObject);
    }
    return null;
  }

  public EventBusBuilder ignoreGeneratedIndex(boolean paramBoolean)
  {
    this.ignoreGeneratedIndex = paramBoolean;
    return this;
  }

  public EventBus installDefaultEventBus()
  {
    try
    {
      if (EventBus.defaultInstance != null)
        throw new EventBusException("Default instance already exists. It may be only set once before it's used the first time to ensure consistent behavior.");
    }
    finally
    {
    }
    EventBus.defaultInstance = build();
    EventBus localEventBus = EventBus.defaultInstance;
    return localEventBus;
  }

  public EventBusBuilder logNoSubscriberMessages(boolean paramBoolean)
  {
    this.logNoSubscriberMessages = paramBoolean;
    return this;
  }

  public EventBusBuilder logSubscriberExceptions(boolean paramBoolean)
  {
    this.logSubscriberExceptions = paramBoolean;
    return this;
  }

  public EventBusBuilder logger(Logger paramLogger)
  {
    this.logger = paramLogger;
    return this;
  }

  public EventBusBuilder sendNoSubscriberEvent(boolean paramBoolean)
  {
    this.sendNoSubscriberEvent = paramBoolean;
    return this;
  }

  public EventBusBuilder sendSubscriberExceptionEvent(boolean paramBoolean)
  {
    this.sendSubscriberExceptionEvent = paramBoolean;
    return this;
  }

  public EventBusBuilder skipMethodVerificationFor(Class<?> paramClass)
  {
    if (this.skipMethodVerificationForClasses == null)
      this.skipMethodVerificationForClasses = new ArrayList();
    this.skipMethodVerificationForClasses.add(paramClass);
    return this;
  }

  public EventBusBuilder strictMethodVerification(boolean paramBoolean)
  {
    this.strictMethodVerification = paramBoolean;
    return this;
  }

  public EventBusBuilder throwSubscriberException(boolean paramBoolean)
  {
    this.throwSubscriberException = paramBoolean;
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.greenrobot.eventbus.EventBusBuilder
 * JD-Core Version:    0.6.2
 */