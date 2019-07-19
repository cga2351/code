package com.viber.voip.g.b;

import com.viber.voip.av.f;
import com.viber.voip.util.dd;
import dagger.a;
import java.util.concurrent.ScheduledExecutorService;

public abstract class b<T>
  implements a<T>, Runnable
{
  private volatile T instance;
  private boolean logWarnIfInitInMainThread;

  public b()
  {
  }

  public b(boolean paramBoolean)
  {
    this.logWarnIfInitInMainThread = paramBoolean;
  }

  public b(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.logWarnIfInitInMainThread = paramBoolean1;
    if (paramBoolean2)
      startAsyncInit();
  }

  public final T get()
  {
    if (this.instance == null);
    try
    {
      if (this.instance == null)
      {
        if (this.logWarnIfInitInMainThread)
          dd.b();
        this.instance = initInstance();
      }
      return this.instance;
    }
    finally
    {
    }
  }

  protected abstract T initInstance();

  public void run()
  {
    get();
  }

  void startAsyncInit()
  {
    av.f.b.execute(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.b.b
 * JD-Core Version:    0.6.2
 */