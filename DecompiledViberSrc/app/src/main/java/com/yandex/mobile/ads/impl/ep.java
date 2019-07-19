package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.location.Location;
import com.yandex.metrica.impl.interact.DeviceInfo;
import com.yandex.metrica.p;

public final class ep
{
  public static Location a(Context paramContext)
  {
    try
    {
      Location localLocation = p.glkl(paramContext);
      return localLocation;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public static Boolean a()
  {
    try
    {
      Boolean localBoolean = p.plat();
      return localBoolean;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public static DeviceInfo b(Context paramContext)
  {
    try
    {
      DeviceInfo localDeviceInfo = p.gdi(paramContext);
      return localDeviceInfo;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public static String b()
  {
    try
    {
      String str = p.pgai();
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ep
 * JD-Core Version:    0.6.2
 */