package com.viber.voip.p;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.viber.common.d.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class g
  implements c
{
  private static final Logger a = ViberEnv.getLogger();
  private PowerManager b;
  private PowerManager.WakeLock c;

  public g(Context paramContext)
  {
    this.b = ((PowerManager)paramContext.getSystemService("power"));
    if (a())
    {
      this.c = this.b.newWakeLock(32, "WakeLockProximityHelper");
      this.c.setReferenceCounted(false);
    }
  }

  private void d()
  {
    this.c.acquire();
  }

  private void e()
  {
    int i = 1;
    try
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Integer.TYPE;
      Method localMethod = PowerManager.WakeLock.class.getDeclaredMethod("release", arrayOfClass);
      PowerManager.WakeLock localWakeLock = this.c;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(1);
      localMethod.invoke(localWakeLock, arrayOfObject);
      if (i == 0)
        this.c.release();
      return;
    }
    catch (Exception localException)
    {
      while (true)
        i = 0;
    }
  }

  public void a(boolean paramBoolean)
  {
    if (this.c != null)
      synchronized (this.c)
      {
        boolean bool = this.c.isHeld();
        if ((paramBoolean) && (!bool))
          d();
        while ((paramBoolean) || (!bool))
          return;
        e();
      }
  }

  public boolean a()
  {
    try
    {
      if (!a.b())
      {
        int i = ((Integer)PowerManager.class.getDeclaredMethod("getSupportedWakeLockFlags", new Class[0]).invoke(this.b, new Object[0])).intValue();
        int j = ((Integer)PowerManager.class.getDeclaredField("PROXIMITY_SCREEN_OFF_WAKE_LOCK").get(null)).intValue();
        if (((i & j) != 0) && (32 == j))
          return true;
      }
      else
      {
        Class[] arrayOfClass = new Class[2];
        arrayOfClass[0] = Integer.TYPE;
        arrayOfClass[1] = String.class;
        Method localMethod = PowerManager.class.getDeclaredMethod("validateWakeLockParameters", arrayOfClass);
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Integer.valueOf(32);
        arrayOfObject[1] = "WakeLockProximityHelper";
        localMethod.invoke(null, arrayOfObject);
        return true;
      }
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public void b()
  {
    synchronized (this.c)
    {
      if (!this.c.isHeld())
        d();
      return;
    }
  }

  public void c()
  {
    synchronized (this.c)
    {
      if (this.c.isHeld())
        e();
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.p.g
 * JD-Core Version:    0.6.2
 */