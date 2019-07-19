package com.google.android.gms.common.wrappers;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;

@KeepForSdk
public class InstantApps
{
  private static Context zzht;
  private static Boolean zzhu;

  @KeepForSdk
  public static boolean isInstantApp(Context paramContext)
  {
    try
    {
      Context localContext = paramContext.getApplicationContext();
      boolean bool2;
      if ((zzht != null) && (zzhu != null) && (zzht == localContext))
      {
        boolean bool3 = zzhu.booleanValue();
        bool2 = bool3;
        return bool2;
      }
      zzhu = null;
      if (PlatformVersion.isAtLeastO())
        zzhu = Boolean.valueOf(localContext.getPackageManager().isInstantApp());
      while (true)
      {
        zzht = localContext;
        boolean bool1 = zzhu.booleanValue();
        bool2 = bool1;
        break;
        try
        {
          paramContext.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
          zzhu = Boolean.valueOf(true);
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          zzhu = Boolean.valueOf(false);
        }
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.wrappers.InstantApps
 * JD-Core Version:    0.6.2
 */