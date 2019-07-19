package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzdtu
{
  private static String zzhur;

  public static String zzbu(Context paramContext)
  {
    if (zzhur != null)
      return zzhur;
    PackageManager localPackageManager = paramContext.getPackageManager();
    Intent localIntent1 = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
    ResolveInfo localResolveInfo1 = localPackageManager.resolveActivity(localIntent1, 0);
    if (localResolveInfo1 != null);
    for (String str = localResolveInfo1.activityInfo.packageName; ; str = null)
    {
      List localList = localPackageManager.queryIntentActivities(localIntent1, 0);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        ResolveInfo localResolveInfo2 = (ResolveInfo)localIterator.next();
        Intent localIntent2 = new Intent();
        localIntent2.setAction("android.support.customtabs.action.CustomTabsService");
        localIntent2.setPackage(localResolveInfo2.activityInfo.packageName);
        if (localPackageManager.resolveService(localIntent2, 0) != null)
          localArrayList.add(localResolveInfo2.activityInfo.packageName);
      }
      if (localArrayList.isEmpty())
        zzhur = null;
      while (true)
      {
        return zzhur;
        if (localArrayList.size() == 1)
          zzhur = (String)localArrayList.get(0);
        else if ((!TextUtils.isEmpty(str)) && (!zzd(paramContext, localIntent1)) && (localArrayList.contains(str)))
          zzhur = str;
        else if (localArrayList.contains("com.android.chrome"))
          zzhur = "com.android.chrome";
        else if (localArrayList.contains("com.chrome.beta"))
          zzhur = "com.chrome.beta";
        else if (localArrayList.contains("com.chrome.dev"))
          zzhur = "com.chrome.dev";
        else if (localArrayList.contains("com.google.android.apps.chrome"))
          zzhur = "com.google.android.apps.chrome";
      }
    }
  }

  private static boolean zzd(Context paramContext, Intent paramIntent)
  {
    try
    {
      List localList = paramContext.getPackageManager().queryIntentActivities(paramIntent, 64);
      if ((localList == null) || (localList.size() == 0))
        break label114;
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
        IntentFilter localIntentFilter = localResolveInfo.filter;
        if ((localIntentFilter != null) && (localIntentFilter.countDataAuthorities() != 0) && (localIntentFilter.countDataPaths() != 0))
        {
          ActivityInfo localActivityInfo = localResolveInfo.activityInfo;
          if (localActivityInfo != null)
            return true;
        }
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.e("CustomTabsHelper", "Runtime exception while getting specialized handlers");
    }
    return false;
    label114: return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdtu
 * JD-Core Version:    0.6.2
 */