package com.adsnative.c;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import java.lang.reflect.Field;

public class c
{
  public static int a()
  {
    return Resources.getSystem().getDisplayMetrics().widthPixels;
  }

  public static int a(Context paramContext)
  {
    ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
    long l1 = localActivityManager.getMemoryClass();
    if (Build.VERSION.SDK_INT >= 11);
    try
    {
      int i = ApplicationInfo.class.getDeclaredField("FLAG_LARGE_HEAP").getInt(null);
      if (o.a(paramContext.getApplicationInfo().flags, i))
      {
        int j = ((Integer)new j.a(localActivityManager, "getLargeMemoryClass").a()).intValue();
        l2 = j;
        l1 = l2;
        return (int)Math.min(31457280L, 1024L * (1024L * (l1 / 8L)));
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        i.b("Unable to reflectively determine large heap size on Honeycomb and above.");
        continue;
        long l2 = l1;
      }
    }
  }

  public static int b()
  {
    return Resources.getSystem().getDisplayMetrics().heightPixels;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.c.c
 * JD-Core Version:    0.6.2
 */