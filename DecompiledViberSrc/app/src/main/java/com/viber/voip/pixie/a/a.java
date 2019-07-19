package com.viber.voip.pixie.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.viber.common.a.e;
import com.viber.voip.ViberEnv;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class a
{
  static e a = ViberEnv.getLogger();

  public static boolean a(Context paramContext)
  {
    try
    {
      if (com.viber.common.d.a.a())
      {
        if (com.viber.common.d.a.g())
          return c(paramContext);
        boolean bool = b(paramContext);
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  static boolean b(Context paramContext)
  {
    try
    {
      Iterator localIterator = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
      while (localIterator.hasNext())
      {
        NetworkInterface localNetworkInterface = (NetworkInterface)localIterator.next();
        if (localNetworkInterface.isUp())
        {
          boolean bool = localNetworkInterface.getName().matches("^(?i)(tun|ppp)\\d");
          if (bool)
            return true;
        }
      }
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  static boolean c(Context paramContext)
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    Network[] arrayOfNetwork = localConnectivityManager.getAllNetworks();
    for (int i = 0; ; i++)
    {
      int j = arrayOfNetwork.length;
      boolean bool = false;
      if (i < j)
      {
        if (localConnectivityManager.getNetworkCapabilities(arrayOfNetwork[i]).hasTransport(4))
          bool = true;
      }
      else
        return bool;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.pixie.a.a
 * JD-Core Version:    0.6.2
 */