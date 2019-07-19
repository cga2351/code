package twitter4j.internal.async;

import twitter4j.internal.logging.Logger;

class ExecuteThread extends Thread
{
  private static Logger logger = Logger.getLogger(ExecuteThread.class);
  private boolean alive = true;
  DispatcherImpl q;

  ExecuteThread(String paramString, DispatcherImpl paramDispatcherImpl, int paramInt)
  {
    super(paramString + "[" + paramInt + "]");
    this.q = paramDispatcherImpl;
  }

  public void run()
  {
    while (this.alive)
    {
      Runnable localRunnable = this.q.poll();
      if (localRunnable != null)
        try
        {
          localRunnable.run();
        }
        catch (Exception localException)
        {
          logger.error("Got an exception while running a task:", localException);
        }
    }
  }

  public void shutdown()
  {
    this.alive = false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.async.ExecuteThread
 * JD-Core Version:    0.6.2
 */