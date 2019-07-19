package com.viber.common.app;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.viber.common.a.e;
import com.viber.common.a.f;

public final class a
{
  private static final e a = f.a();

  public static void a(Context paramContext, Intent paramIntent)
  {
    a(new b(paramContext, paramIntent), new Intent[] { paramIntent });
  }

  public static void a(Runnable paramRunnable, Intent[] paramArrayOfIntent)
  {
    try
    {
      paramRunnable.run();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      a.b(localRuntimeException, "startActivity(): System can't start the requested activity.", new Object[0]);
    }
  }

  public static boolean a(Context paramContext, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    try
    {
      boolean bool = paramContext.bindService(paramIntent, paramServiceConnection, paramInt);
      return bool;
    }
    catch (RuntimeException localRuntimeException)
    {
      a.b(localRuntimeException, "bindService(): System can't bind to the requested service.", new Object[0]);
    }
    return false;
  }

  public static void b(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramContext.startService(paramIntent);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      a.b(localRuntimeException, "startService(): System can't start the requested service.", new Object[0]);
    }
  }

  public static void c(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (com.viber.common.d.a.m())
      {
        paramContext.startForegroundService(paramIntent);
        return;
      }
      paramContext.startService(paramIntent);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      a.b(localRuntimeException, "startForegroundService(): System can't start the requested service.", new Object[0]);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.app.a
 * JD-Core Version:    0.6.2
 */