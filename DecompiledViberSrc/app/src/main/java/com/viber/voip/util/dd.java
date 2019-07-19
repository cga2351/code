package com.viber.voip.util;

import android.os.Handler;
import android.os.Looper;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;

public final class dd
{
  private static final Logger a = ViberEnv.getLogger();

  public static void a(Handler paramHandler, Runnable paramRunnable)
  {
    if (a(paramHandler))
    {
      paramRunnable.run();
      return;
    }
    paramHandler.post(paramRunnable);
  }

  public static void a(Runnable paramRunnable)
  {
    a(av.a(av.e.a), paramRunnable);
  }

  public static boolean a()
  {
    Looper localLooper = Looper.getMainLooper();
    return (localLooper != null) && (Thread.currentThread() == localLooper.getThread());
  }

  public static boolean a(Handler paramHandler)
  {
    return Thread.currentThread() == paramHandler.getLooper().getThread();
  }

  public static void b()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.dd
 * JD-Core Version:    0.6.2
 */