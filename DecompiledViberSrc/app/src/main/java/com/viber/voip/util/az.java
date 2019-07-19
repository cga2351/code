package com.viber.voip.util;

import android.os.Handler;
import android.os.Looper;

public class az
{
  private final Handler a;
  private final Handler b;

  public az(Handler paramHandler1, Handler paramHandler2)
  {
    this.a = paramHandler1;
    this.b = paramHandler2;
  }

  private void a(final Runnable paramRunnable, Handler paramHandler)
  {
    if (Looper.myLooper() == paramHandler.getLooper())
    {
      paramRunnable.run();
      return;
    }
    paramHandler.post(new Runnable()
    {
      public void run()
      {
        paramRunnable.run();
      }
    });
  }

  public final Handler a()
  {
    return this.b;
  }

  public void a(Runnable paramRunnable)
  {
    a(paramRunnable, this.b);
  }

  public void b(Runnable paramRunnable)
  {
    a(paramRunnable, this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.az
 * JD-Core Version:    0.6.2
 */