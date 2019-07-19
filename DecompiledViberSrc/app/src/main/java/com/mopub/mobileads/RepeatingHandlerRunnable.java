package com.mopub.mobileads;

import android.os.Handler;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;

public abstract class RepeatingHandlerRunnable
  implements Runnable
{
  protected final Handler a;
  protected volatile long b;
  private volatile boolean c;

  public RepeatingHandlerRunnable(Handler paramHandler)
  {
    Preconditions.checkNotNull(paramHandler);
    this.a = paramHandler;
  }

  public abstract void doWork();

  @Deprecated
  @VisibleForTesting
  public boolean isRunning()
  {
    return this.c;
  }

  public void run()
  {
    if (this.c)
    {
      doWork();
      this.a.postDelayed(this, this.b);
    }
  }

  public void startRepeating(long paramLong)
  {
    if (paramLong > 0L);
    for (boolean bool = true; ; bool = false)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Long.valueOf(paramLong);
      Preconditions.checkArgument(bool, "intervalMillis must be greater than 0. Saw: %d", arrayOfObject);
      this.b = paramLong;
      if (!this.c)
      {
        this.c = true;
        this.a.post(this);
      }
      return;
    }
  }

  public void stop()
  {
    this.c = false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.RepeatingHandlerRunnable
 * JD-Core Version:    0.6.2
 */