package com.adjust.sdk;

import java.text.DecimalFormat;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TimerCycle
{
  private Runnable command;
  private long cycleDelay;
  private CustomScheduledExecutor executor;
  private long initialDelay;
  private boolean isPaused;
  private ILogger logger;
  private String name;
  private ScheduledFuture waitingTask;

  public TimerCycle(Runnable paramRunnable, long paramLong1, long paramLong2, String paramString)
  {
    this.executor = new CustomScheduledExecutor(paramString, true);
    this.name = paramString;
    this.command = paramRunnable;
    this.initialDelay = paramLong1;
    this.cycleDelay = paramLong2;
    this.isPaused = true;
    this.logger = AdjustFactory.getLogger();
    String str1 = Util.SecondsDisplayFormat.format(paramLong2 / 1000.0D);
    String str2 = Util.SecondsDisplayFormat.format(paramLong1 / 1000.0D);
    this.logger.verbose("%s configured to fire after %s seconds of starting and cycles every %s seconds", new Object[] { paramString, str2, str1 });
  }

  private void cancel(boolean paramBoolean)
  {
    if (this.waitingTask != null)
      this.waitingTask.cancel(paramBoolean);
    this.waitingTask = null;
  }

  public void start()
  {
    if (!this.isPaused)
    {
      ILogger localILogger2 = this.logger;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = this.name;
      localILogger2.verbose("%s is already started", arrayOfObject2);
      return;
    }
    ILogger localILogger1 = this.logger;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = this.name;
    localILogger1.verbose("%s starting", arrayOfObject1);
    this.waitingTask = this.executor.scheduleWithFixedDelay(new Runnable()
    {
      public void run()
      {
        ILogger localILogger = TimerCycle.this.logger;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = TimerCycle.this.name;
        localILogger.verbose("%s fired", arrayOfObject);
        TimerCycle.this.command.run();
      }
    }
    , this.initialDelay, this.cycleDelay, TimeUnit.MILLISECONDS);
    this.isPaused = false;
  }

  public void suspend()
  {
    if (this.isPaused)
    {
      ILogger localILogger2 = this.logger;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = this.name;
      localILogger2.verbose("%s is already suspended", arrayOfObject2);
      return;
    }
    this.initialDelay = this.waitingTask.getDelay(TimeUnit.MILLISECONDS);
    this.waitingTask.cancel(false);
    String str = Util.SecondsDisplayFormat.format(this.initialDelay / 1000.0D);
    ILogger localILogger1 = this.logger;
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = this.name;
    arrayOfObject1[1] = str;
    localILogger1.verbose("%s suspended with %s seconds left", arrayOfObject1);
    this.isPaused = true;
  }

  public void teardown()
  {
    cancel(true);
    if (this.executor != null);
    try
    {
      this.executor.shutdownNow();
      label20: this.executor = null;
      return;
    }
    catch (SecurityException localSecurityException)
    {
      break label20;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.TimerCycle
 * JD-Core Version:    0.6.2
 */