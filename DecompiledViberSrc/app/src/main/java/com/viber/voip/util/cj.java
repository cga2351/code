package com.viber.voip.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v4.app.Fragment;
import com.viber.common.b.b;
import com.viber.common.d.a;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.service.ServiceStateDelegate.ServiceState;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.settings.d.ag;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.f;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class cj
{
  private static final Logger b;
  private static volatile cj h;
  private int c = -1;
  private int d = -1;
  private boolean e;
  private final ConnectivityManager f;
  private final Set<b> g = new HashSet();
  private final Context i;
  private final Handler j = av.e.f.a();
  private final Handler k = av.e.a.a();
  private c l;
  private final Runnable m = new Runnable()
  {
    public void run()
    {
      final NetworkInfo localNetworkInfo = cj.a(cj.this).getActiveNetworkInfo();
      cj.b(cj.this).post(new Runnable()
      {
        public void run()
        {
          cj.a(cj.this, localNetworkInfo);
        }
      });
    }
  };

  static
  {
    if (!cj.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      a = bool;
      b = ViberEnv.getLogger();
      return;
    }
  }

  private cj(Context paramContext)
  {
    this.i = paramContext;
    this.f = ((ConnectivityManager)paramContext.getSystemService("connectivity"));
    this.e = this.f.getBackgroundDataSetting();
    f();
    Reachability.2 local2 = new Reachability.2(this);
    this.l = new c(null);
    paramContext.registerReceiver(this.l, local2);
  }

  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return 3;
    case -1:
      return 0;
    case 0:
      return 2;
    case 1:
    }
    return 1;
  }

  public static cj a(Context paramContext)
  {
    try
    {
      if (h == null)
        h = new cj(paramContext);
      cj localcj = h;
      return localcj;
    }
    finally
    {
    }
  }

  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != this.c)
    {
      this.c = paramInt1;
      this.d = paramInt2;
      synchronized (this.g)
      {
        ArrayList localArrayList = new ArrayList(this.g);
        Iterator localIterator = localArrayList.iterator();
        if (localIterator.hasNext())
          ((b)localIterator.next()).connectivityChanged(paramInt1, paramInt2);
      }
    }
  }

  private void a(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("noConnectivity", false))
    {
      a(-1, -1);
      return;
    }
    f();
  }

  private void a(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo != null)
    {
      int n = paramNetworkInfo.getType();
      int i1 = paramNetworkInfo.getSubtype();
      if (this.c != n)
        a(n, i1);
      while (n != 1)
        return;
      e();
      return;
    }
    a(-1, -1);
  }

  public static boolean a(Fragment paramFragment, boolean paramBoolean)
  {
    if (!b(ViberApplication.getApplication()))
      if (paramBoolean)
      {
        if (paramFragment == null)
          break label31;
        ad.a().a(paramFragment).b(paramFragment);
      }
    label31: 
    do
    {
      return false;
      ad.a().d();
      return false;
      if (ViberApplication.getInstance().getEngine(false).getServiceState() == ServiceStateDelegate.ServiceState.SERVICE_CONNECTED)
        break;
    }
    while (!paramBoolean);
    if (paramFragment != null)
    {
      f.d().a(paramFragment).b(paramFragment);
      return false;
    }
    f.d().d();
    return false;
    return true;
  }

  public static boolean a(boolean paramBoolean)
  {
    return a(null, paramBoolean);
  }

  private static String b(NetworkInfo paramNetworkInfo)
  {
    switch (paramNetworkInfo.getSubtype())
    {
    default:
      return "Unknown";
    case 1:
    case 2:
    case 4:
    case 7:
    case 11:
      return "2G";
    case 3:
    case 5:
    case 6:
    case 8:
    case 9:
    case 10:
    case 12:
    case 14:
      return "3G";
    case 13:
    case 15:
    }
    return "4G";
  }

  private void b(boolean paramBoolean)
  {
    if (paramBoolean != this.e)
    {
      Iterator localIterator = this.g.iterator();
      while (localIterator.hasNext())
        ((b)localIterator.next()).backgroundDataChanged(paramBoolean);
    }
  }

  public static boolean b(Context paramContext)
  {
    if (paramContext == null)
      return false;
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (localNetworkInfo == null)
      return false;
    return localNetworkInfo.isConnected();
  }

  public static boolean c(Context paramContext)
  {
    boolean bool;
    if (paramContext == null)
      bool = false;
    do
    {
      return bool;
      bool = b(paramContext);
    }
    while (bool);
    ad.a().d();
    return bool;
  }

  public static Boolean d(Context paramContext)
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    try
    {
      Method localMethod = Class.forName(localConnectivityManager.getClass().getName()).getDeclaredMethod("getMobileDataEnabled", new Class[0]);
      localMethod.setAccessible(true);
      Boolean localBoolean = (Boolean)localMethod.invoke(localConnectivityManager, new Object[0]);
      return localBoolean;
    }
    catch (Exception localException)
    {
    }
    return Boolean.valueOf(true);
  }

  private void e()
  {
    synchronized (this.g)
    {
      ArrayList localArrayList = new ArrayList(this.g);
      Iterator localIterator = localArrayList.iterator();
      if (localIterator.hasNext())
        ((b)localIterator.next()).wifiConnectivityChanged();
    }
  }

  public static boolean e(Context paramContext)
  {
    if (paramContext != null)
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getNetworkInfo(0);
      return (localNetworkInfo != null) && (localNetworkInfo.isConnected());
    }
    return false;
  }

  private void f()
  {
    this.j.post(this.m);
  }

  public static boolean f(Context paramContext)
  {
    if (a.k())
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager.isActiveNetworkMetered())
        switch (localConnectivityManager.getRestrictBackgroundStatus())
        {
        default:
        case 3:
        }
    }
    do
      return false;
    while (d.ag.e.d());
    return true;
  }

  public static String g(Context paramContext)
  {
    if (paramContext == null)
      return "Unknown";
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localConnectivityManager == null)
      return "Unknown";
    NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected()))
      return "None";
    switch (localNetworkInfo.getType())
    {
    case 2:
    case 3:
    case 5:
    case 8:
    default:
      return "Unknown";
    case 0:
    case 4:
      return b(localNetworkInfo);
    case 1:
      return "Wifi";
    case 6:
      return "Wimax";
    case 7:
      return "Bluetooth";
    case 9:
    }
    return "Ethernet";
  }

  public int a()
  {
    return this.c;
  }

  public void a(b paramb)
  {
    if ((!a) && (paramb == null))
      throw new AssertionError();
    synchronized (this.g)
    {
      this.g.add(paramb);
      paramb.connectivityChanged(this.c, this.d);
      return;
    }
  }

  public void b(b paramb)
  {
    synchronized (this.g)
    {
      this.g.remove(paramb);
      paramb.backgroundDataChanged(this.f.getBackgroundDataSetting());
      return;
    }
  }

  public boolean b()
  {
    return b(this.i);
  }

  public boolean c()
  {
    return by.b(ViberApplication.getApplication());
  }

  public String d()
  {
    return g(this.i);
  }

  protected void finalize()
    throws Throwable
  {
    if (this.i != null)
      this.i.unregisterReceiver(this.l);
    super.finalize();
  }

  public static class a
    implements cj.b
  {
    public void backgroundDataChanged(boolean paramBoolean)
    {
    }

    public void connectivityChanged(int paramInt1, int paramInt2)
    {
    }

    public void wifiConnectivityChanged()
    {
    }
  }

  public static abstract interface b
  {
    public abstract void backgroundDataChanged(boolean paramBoolean);

    public abstract void connectivityChanged(int paramInt1, int paramInt2);

    public abstract void wifiConnectivityChanged();
  }

  private class c extends BroadcastReceiver
  {
    private c()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (("android.intent.action.AIRPLANE_MODE".equals(paramIntent.getAction())) && (paramIntent.getBooleanExtra("state", false)))
        cj.a(cj.this, -1, -1);
      do
      {
        return;
        if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
        {
          cj.a(cj.this, paramIntent);
          return;
        }
      }
      while (!paramIntent.getAction().equals("android.net.conn.BACKGROUND_DATA_SETTING_CHANGED"));
      cj.a(cj.this, cj.a(cj.this).getBackgroundDataSetting());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.cj
 * JD-Core Version:    0.6.2
 */