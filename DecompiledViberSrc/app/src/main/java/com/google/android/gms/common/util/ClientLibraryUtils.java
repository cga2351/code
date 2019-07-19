package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

@KeepForSdk
public class ClientLibraryUtils
{
  @KeepForSdk
  public static int getClientVersion(Context paramContext, String paramString)
  {
    PackageInfo localPackageInfo = zzb(paramContext, paramString);
    if ((localPackageInfo == null) || (localPackageInfo.applicationInfo == null));
    Bundle localBundle;
    do
    {
      return -1;
      localBundle = localPackageInfo.applicationInfo.metaData;
    }
    while (localBundle == null);
    return localBundle.getInt("com.google.android.gms.version", -1);
  }

  @KeepForSdk
  public static boolean isPackageSide()
  {
    return false;
  }

  private static PackageInfo zzb(Context paramContext, String paramString)
  {
    try
    {
      PackageInfo localPackageInfo = Wrappers.packageManager(paramContext).getPackageInfo(paramString, 128);
      return localPackageInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return null;
  }

  public static boolean zzc(Context paramContext, String paramString)
  {
    "com.google.android.gms".equals(paramString);
    try
    {
      int i = Wrappers.packageManager(paramContext).getApplicationInfo(paramString, 0).flags;
      int j = i & 0x200000;
      boolean bool = false;
      if (j != 0)
        bool = true;
      return bool;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.ClientLibraryUtils
 * JD-Core Version:    0.6.2
 */