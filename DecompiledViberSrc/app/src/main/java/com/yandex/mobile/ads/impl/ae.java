package com.yandex.mobile.ads.impl;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.PowerManager;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public final class ae extends BroadcastReceiver
{
  private static volatile ae d;
  private static final Object e = new Object();
  private boolean a = false;
  private int b = a.c;
  private WeakHashMap<b, Object> c = new WeakHashMap();

  public static ae a()
  {
    if (d == null);
    synchronized (e)
    {
      if (d == null)
        d = new ae();
      return d;
    }
  }

  private void a(Intent paramIntent)
  {
    try
    {
      Iterator localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext())
        ((b)localIterator.next()).a(paramIntent);
    }
    finally
    {
    }
  }

  private boolean b(Context paramContext)
  {
    try
    {
      KeyguardManager localKeyguardManager = (KeyguardManager)paramContext.getSystemService("keyguard");
      boolean bool1;
      if (Build.VERSION.SDK_INT >= 16)
      {
        boolean bool2 = localKeyguardManager.isKeyguardLocked();
        bool1 = bool2;
      }
      while (true)
      {
        return bool1;
        int i = this.b;
        int j = a.b;
        if (i == j)
          bool1 = true;
        else
          bool1 = false;
      }
    }
    finally
    {
    }
  }

  private boolean c(Context paramContext)
  {
    try
    {
      PowerManager localPowerManager = (PowerManager)paramContext.getSystemService("power");
      boolean bool3;
      if (Build.VERSION.SDK_INT >= 20)
        bool3 = localPowerManager.isInteractive();
      boolean bool1;
      for (boolean bool2 = bool3; ; bool2 = bool1)
      {
        return bool2;
        bool1 = localPowerManager.isScreenOn();
      }
    }
    finally
    {
    }
  }

  public final void a(b paramb, Context paramContext)
  {
    if (paramContext != null);
    try
    {
      this.c.put(paramb, null);
      if (!this.a)
      {
        Context localContext = paramContext.getApplicationContext();
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.SCREEN_ON");
        localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
        localIntentFilter.addAction("android.intent.action.USER_PRESENT");
        localContext.registerReceiver(this, localIntentFilter);
        this.a = true;
      }
      return;
    }
    catch (Exception localException)
    {
      while (true)
        b(paramb, paramContext);
    }
    finally
    {
    }
  }

  public final boolean a(Context paramContext)
  {
    try
    {
      if (c(paramContext))
      {
        boolean bool2 = b(paramContext);
        if (!bool2)
        {
          bool1 = true;
          return bool1;
        }
      }
      boolean bool1 = false;
    }
    finally
    {
    }
  }

  // ERROR //
  public final void b(b paramb, Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnull +42 -> 45
    //   6: aload_0
    //   7: getfield 30	com/yandex/mobile/ads/impl/ae:c	Ljava/util/WeakHashMap;
    //   10: aload_1
    //   11: invokevirtual 135	java/util/WeakHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: pop
    //   15: aload_0
    //   16: getfield 38	com/yandex/mobile/ads/impl/ae:a	Z
    //   19: ifeq +26 -> 45
    //   22: aload_0
    //   23: getfield 30	com/yandex/mobile/ads/impl/ae:c	Ljava/util/WeakHashMap;
    //   26: invokevirtual 138	java/util/WeakHashMap:isEmpty	()Z
    //   29: ifeq +16 -> 45
    //   32: aload_2
    //   33: invokevirtual 108	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   36: aload_0
    //   37: invokevirtual 142	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   40: aload_0
    //   41: iconst_0
    //   42: putfield 38	com/yandex/mobile/ads/impl/ae:a	Z
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: astore_3
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_3
    //   52: athrow
    //   53: astore 5
    //   55: goto -10 -> 45
    //
    // Exception table:
    //   from	to	target	type
    //   6	15	48	finally
    //   15	45	48	finally
    //   15	45	53	java/lang/Exception
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null);
    while (true)
    {
      String str;
      try
      {
        new Object[1][0] = paramIntent.getAction();
        str = paramIntent.getAction();
        if ("android.intent.action.SCREEN_OFF".equals(str))
        {
          this.b = a.b;
          a(paramIntent);
          return;
        }
        if ("android.intent.action.USER_PRESENT".equals(str))
        {
          this.b = a.c;
          continue;
        }
      }
      finally
      {
      }
      if ("android.intent.action.SCREEN_ON".equals(str))
        this.b = a.a;
    }
  }

  static enum a
  {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;

    static
    {
      int[] arrayOfInt = new int[3];
      arrayOfInt[0] = a;
      arrayOfInt[1] = b;
      arrayOfInt[2] = c;
    }
  }

  public static abstract interface b
  {
    public abstract void a(Intent paramIntent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ae
 * JD-Core Version:    0.6.2
 */