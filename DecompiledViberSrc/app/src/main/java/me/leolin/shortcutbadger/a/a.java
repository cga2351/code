package me.leolin.shortcutbadger.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.leolin.shortcutbadger.b;

public class a
{
  public static List<ResolveInfo> a(Context paramContext, Intent paramIntent)
  {
    List localList = paramContext.getPackageManager().queryBroadcastReceivers(paramIntent, 0);
    if (localList != null)
      return localList;
    return Collections.emptyList();
  }

  public static void b(Context paramContext, Intent paramIntent)
    throws b
  {
    List localList = a(paramContext, paramIntent);
    if (localList.size() == 0)
      throw new b("unable to resolve intent: " + paramIntent.toString());
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
      Intent localIntent = new Intent(paramIntent);
      if (localResolveInfo != null)
      {
        localIntent.setPackage(localResolveInfo.resolvePackageName);
        paramContext.sendBroadcast(localIntent);
      }
    }
  }

  public static void c(Context paramContext, Intent paramIntent)
    throws b
  {
    int i = Build.VERSION.SDK_INT;
    int j = 0;
    Intent localIntent;
    if (i >= 26)
    {
      localIntent = new Intent(paramIntent);
      localIntent.setAction("me.leolin.shortcutbadger.BADGE_COUNT_UPDATE");
    }
    try
    {
      b(paramContext, localIntent);
      j = 1;
      if (j != 0)
        return;
      b(paramContext, paramIntent);
      return;
    }
    catch (b localb)
    {
      while (true)
        j = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     me.leolin.shortcutbadger.a.a
 * JD-Core Version:    0.6.2
 */