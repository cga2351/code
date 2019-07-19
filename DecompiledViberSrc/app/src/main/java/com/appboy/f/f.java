package com.appboy.f;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public final class f
{
  private static final String a = String.format("%s.%s", arrayOfObject);
  private static final Random b = new Random();

  static
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "Appboy v3.2.1 .";
    arrayOfObject[1] = f.class.getName();
  }

  public static int a()
  {
    return b.nextInt();
  }

  public static void a(Context paramContext, Intent paramIntent)
  {
    List localList = paramContext.getPackageManager().queryBroadcastReceivers(paramIntent, 0);
    if (localList == null)
      c.b(a, "No components found for the following intent: " + paramIntent.getAction());
    while (true)
    {
      return;
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
        Intent localIntent = new Intent(paramIntent);
        localIntent.setComponent(new ComponentName(localResolveInfo.activityInfo.applicationInfo.packageName, localResolveInfo.activityInfo.name));
        paramContext.sendBroadcast(localIntent);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.f.f
 * JD-Core Version:    0.6.2
 */