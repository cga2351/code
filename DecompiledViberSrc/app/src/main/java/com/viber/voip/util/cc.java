package com.viber.voip.util;

import android.app.Application;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class cc
{
  private static final Logger a = ViberEnv.getLogger();

  public static Intent a(String paramString)
  {
    if (paramString == null)
      return null;
    try
    {
      Intent localIntent = ViberApplication.getApplication().getPackageManager().getLaunchIntentForPackage(paramString);
      return localIntent;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static Set<String> a()
  {
    List localList = c();
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(localList.size());
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
      localLinkedHashSet.add(((ApplicationInfo)localIterator.next()).packageName);
    return localLinkedHashSet;
  }

  public static int b()
  {
    PackageInfo localPackageInfo = b(ViberApplication.getApplication().getPackageName());
    if (localPackageInfo != null)
      return localPackageInfo.versionCode;
    return 0;
  }

  public static PackageInfo b(String paramString)
  {
    PackageManager localPackageManager = ViberApplication.getApplication().getPackageManager();
    try
    {
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo(paramString, 128);
      return localPackageInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return null;
  }

  private static List<ApplicationInfo> c()
  {
    return ViberApplication.getApplication().getPackageManager().getInstalledApplications(128);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.cc
 * JD-Core Version:    0.6.2
 */