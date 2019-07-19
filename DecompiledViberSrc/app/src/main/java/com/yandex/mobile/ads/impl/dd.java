package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class dd
{
  private static final Comparator<ScanResult> a = new Comparator()
  {
  };

  public static Integer a(Context paramContext)
  {
    try
    {
      String str = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperator().substring(0, 3);
      if (!TextUtils.isEmpty(str))
      {
        Integer localInteger = Integer.valueOf(Integer.parseInt(str));
        return localInteger;
      }
      return null;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static Integer b(Context paramContext)
  {
    try
    {
      String str = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperator().substring(3);
      if (!TextUtils.isEmpty(str))
      {
        Integer localInteger = Integer.valueOf(Integer.parseInt(str));
        return localInteger;
      }
      return null;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static String c(Context paramContext)
  {
    try
    {
      String str = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperatorName();
      boolean bool = TextUtils.isEmpty(str);
      if (!bool)
        return str;
      return null;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static String d(Context paramContext)
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
      switch (localNetworkInfo.getType())
      {
      default:
        return localNetworkInfo.getTypeName();
      case 0:
      }
      String str = localNetworkInfo.getSubtypeName();
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static Integer e(Context paramContext)
  {
    try
    {
      int i = ((GsmCellLocation)((TelephonyManager)paramContext.getSystemService("phone")).getCellLocation()).getCid();
      if (-1 != i)
      {
        Integer localInteger = Integer.valueOf(i & 0xFFFF);
        return localInteger;
      }
      return null;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static Integer f(Context paramContext)
  {
    try
    {
      int i = ((GsmCellLocation)((TelephonyManager)paramContext.getSystemService("phone")).getCellLocation()).getLac();
      if (-1 != i)
      {
        Integer localInteger = Integer.valueOf(i & 0xFFFF);
        return localInteger;
      }
      return null;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static String g(Context paramContext)
  {
    while (true)
    {
      try
      {
        WifiManager localWifiManager = (WifiManager)paramContext.getSystemService("wifi");
        if (!localWifiManager.isWifiEnabled())
          return null;
        List localList = localWifiManager.getScanResults();
        ScanResult[] arrayOfScanResult = (ScanResult[])fl.a(localList.toArray(new ScanResult[localList.size()]));
        Arrays.sort(arrayOfScanResult, Collections.reverseOrder(a));
        if (arrayOfScanResult.length > 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          int i = Math.min(3, arrayOfScanResult.length);
          int j = 0;
          if (j < i)
          {
            localStringBuilder.append(arrayOfScanResult[j].BSSID);
            localStringBuilder.append(",");
            localStringBuilder.append(arrayOfScanResult[j].level);
            if (j + 1 >= i)
              break label168;
            str1 = ";";
            localStringBuilder.append(str1);
            j++;
            continue;
          }
          String str2 = localStringBuilder.toString();
          return str2;
        }
      }
      catch (Exception localException)
      {
      }
      return null;
      label168: String str1 = "";
    }
  }

  public static Integer h(Context paramContext)
  {
    try
    {
      Intent localIntent = paramContext.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      Object localObject = null;
      if (localIntent != null)
      {
        int i = localIntent.getIntExtra("level", -1);
        int j = localIntent.getIntExtra("scale", -1);
        localObject = null;
        if (i >= 0)
        {
          localObject = null;
          if (j > 0)
          {
            Integer localInteger = Integer.valueOf(Math.round(100.0F * (i / j)));
            localObject = localInteger;
          }
        }
      }
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static int i(Context paramContext)
  {
    Point localPoint = j(paramContext);
    return Math.min(localPoint.x, localPoint.y);
  }

  public static Point j(Context paramContext)
  {
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics;
    int i;
    if (Build.VERSION.SDK_INT >= 17)
    {
      localDisplayMetrics = new DisplayMetrics();
      localDisplay.getRealMetrics(localDisplayMetrics);
      i = localDisplayMetrics.widthPixels;
    }
    for (int j = localDisplayMetrics.heightPixels; ; j = localDisplay.getHeight())
    {
      while (true)
      {
        return new Point(i, j);
        if (Build.VERSION.SDK_INT >= 14)
          try
          {
            Method localMethod = Display.class.getMethod("getRawHeight", new Class[0]);
            i = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(localDisplay, new Object[0])).intValue();
            int k = ((Integer)localMethod.invoke(localDisplay, new Object[0])).intValue();
            j = k;
          }
          catch (Exception localException)
          {
          }
      }
      i = localDisplay.getWidth();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.dd
 * JD-Core Version:    0.6.2
 */