package com.yandex.metrica.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import com.yandex.metrica.MetricaEventHandler;
import com.yandex.metrica.MetricaService;
import com.yandex.metrica.YandexMetrica;
import java.util.Iterator;
import java.util.List;

public class z
{
  public static void a(Context paramContext)
  {
    int i = 1;
    if (!a("com.yandex.metrica.CounterConfiguration"))
      throw new a("\nClass com.yandex.metrica.CounterConfiguration isn't found.\nPerhaps this is due to obfuscation.\nIf you build your application with ProGuard,\nyou need to keep the Metrica for Apps.\nPlease try to use the following lines of code:\n##########################################\n-keep class com.yandex.metrica.** { *; }\n-dontwarn com.yandex.metrica.**\n##########################################");
    int j;
    if ((0x2 & paramContext.getApplicationInfo().flags) != 0)
      j = i;
    while (true)
    {
      if (j != 0);
      try
      {
        ComponentName localComponentName = new ComponentName(paramContext, MetricaService.class);
        Bundle localBundle = paramContext.getPackageManager().getServiceInfo(localComponentName, 640).metaData;
        k = 0;
        if (localBundle != null)
        {
          boolean bool = localBundle.containsKey("metrica:api:level");
          k = 0;
          if (bool)
          {
            int m = localBundle.getInt("metrica:api:level");
            int n = YandexMetrica.getLibraryApiLevel();
            if (m != n)
              break label137;
          }
        }
        while (true)
        {
          k = i;
          if (k != 0)
            break label142;
          throw new c(MetricaService.class.getName());
          j = 0;
          break;
          label137: i = 0;
        }
        label142: String str = MetricaEventHandler.class.getName() + " receiver";
        Intent localIntent1 = new Intent("com.yandex.metrica.intent.action.SYNC");
        Intent localIntent2 = new Intent(null, Uri.parse("package://fake.data"));
        if (a(paramContext, localIntent1))
          throw new b(str, "com.yandex.metrica.intent.action.SYNC");
        if (a(paramContext, localIntent2.setAction("android.intent.action.PACKAGE_DATA_CLEARED")))
          throw new b(str, "android.intent.action.PACKAGE_DATA_CLEARED");
        if (a(paramContext, localIntent2.setAction("android.intent.action.PACKAGE_ADDED")))
          throw new b(str, "android.intent.action.PACKAGE_ADDED");
        return;
      }
      catch (Exception localException)
      {
        while (true)
          int k = 0;
      }
    }
  }

  private static boolean a(Context paramContext, Intent paramIntent)
  {
    List localList = paramContext.getPackageManager().queryBroadcastReceivers(paramIntent, 0);
    String str = MetricaEventHandler.class.getName();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
      if ((localResolveInfo.activityInfo.packageName.equals(paramContext.getPackageName())) && (localResolveInfo.activityInfo.name.equals(str)))
        return true;
    }
    return false;
  }

  public static boolean a(String paramString)
  {
    try
    {
      Class.forName(paramString);
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    return false;
  }

  static class a extends RuntimeException
  {
    public a(String paramString)
    {
      super();
    }

    public a(String paramString1, String paramString2)
    {
      super();
    }
  }

  static class b extends z.a
  {
    public b(String paramString1, String paramString2)
    {
      super("It should not include intent-filter with action " + paramString2 + "\n");
    }
  }

  static class c extends z.a
  {
    public c(String paramString)
    {
      super("Attribute metrica:api:level should be equal to " + YandexMetrica.getLibraryApiLevel() + ".\n");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.z
 * JD-Core Version:    0.6.2
 */