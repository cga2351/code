package com.adjust.sdk;

import java.text.DecimalFormat;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TimerOnce
{
  private Runnable command;
  private CustomScheduledExecutor executor;
  private ILogger logger;
  private String name;
  private ScheduledFuture waitingTask;

  public TimerOnce(Runnable paramRunnable, String paramString)
  {
    this.name = paramString;
    this.executor = new CustomScheduledExecutor(paramString, true);
    this.command = paramRunnable;
    this.logger = AdjustFactory.getLogger();
  }

  private void cancel(boolean paramBoolean)
  {
    if (this.waitingTask != null)
      this.waitingTask.cancel(paramBoolean);
    this.waitingTask = null;
    ILogger localILogger = this.logger;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.name;
    localILogger.verbose("%s canceled", arrayOfObject);
  }

  public void cancel()
  {
    cancel(false);
  }

  public long getFireIn()
  {
    if (this.waitingTask == null)
      return 0L;
    return this.waitingTask.getDelay(TimeUnit.MILLISECONDS);
  }

  public void startIn(long paramLong)
  {
    cancel(false);
    String str = Util.SecondsDisplayFormat.format(paramLong / 1000.0D);
    ILogger localILogger = this.logger;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.name;
    arrayOfObject[1] = str;
    localILogger.verbose("%s starting. Launching in %s seconds", arrayOfObject);
    this.waitingTask = this.executor.schedule(new Runnable()
    {
      public void run()
      {
        ILogger localILogger = TimerOnce.this.logger;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = TimerOnce.this.name;
        localILogger.verbose("%s fired", arrayOfObject);
        TimerOnce.this.command.run();
        TimerOnce.access$302(TimerOnce.this, null);
      }
    }
    , paramLong, TimeUnit.MILLISECONDS);
  }

  public void teardown()
  {
    cancel(true);
    this.executor = null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.TimerOnce
 * JD-Core Version:    0.6.2
 */