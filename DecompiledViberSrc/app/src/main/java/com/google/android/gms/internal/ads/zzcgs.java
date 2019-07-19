package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.Nullable;

public final class zzcgs
{
  @Nullable
  public static PackageInfo zza(Context paramContext, ApplicationInfo paramApplicationInfo)
  {
    try
    {
      PackageInfo localPackageInfo = Wrappers.packageManager(paramContext).getPackageInfo(paramApplicationInfo.packageName, 0);
      return localPackageInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcgs
 * JD-Core Version:    0.6.2
 */