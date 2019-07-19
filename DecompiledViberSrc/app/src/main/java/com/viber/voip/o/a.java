package com.viber.voip.o;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import java.util.Iterator;
import java.util.List;

public enum a
{
  private static a e;
  private String d;

  static
  {
    a[] arrayOfa = new a[3];
    arrayOfa[0] = a;
    arrayOfa[1] = b;
    arrayOfa[2] = c;
  }

  private a(String paramString)
  {
    this.d = paramString;
  }

  public static a a()
  {
    return e;
  }

  public static a a(Context paramContext)
  {
    List localList;
    Object localObject1;
    label45: ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    if (e == null)
    {
      ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
      if (localActivityManager != null)
      {
        localList = localActivityManager.getRunningAppProcesses();
        if (localList == null)
          break label110;
        localObject1 = "";
        int i = Process.myPid();
        Iterator localIterator = localList.iterator();
        if (!localIterator.hasNext())
          break label95;
        localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        if (localRunningAppProcessInfo.pid != i)
          break label119;
      }
    }
    label95: label110: label119: for (Object localObject2 = localRunningAppProcessInfo.processName; ; localObject2 = localObject1)
    {
      localObject1 = localObject2;
      break label45;
      localList = null;
      break;
      for (e = a((String)localObject1, paramContext.getPackageName()); ; e = a)
        return e;
    }
  }

  private static a a(String paramString1, String paramString2)
  {
    if (paramString1.startsWith(paramString2))
      paramString1 = paramString1.substring(paramString2.length());
    for (a locala : values())
      if (paramString1.equals(locala.d))
        return locala;
    return c;
  }

  public static boolean b()
  {
    return e == a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.o.a
 * JD-Core Version:    0.6.2
 */