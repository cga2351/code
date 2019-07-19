package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

final class zzcvf
  implements zzcuz<zzcve>
{
  private final zzbbm zzfqw;
  private final Context zzlj;

  public zzcvf(zzbbm paramzzbbm, Context paramContext)
  {
    this.zzfqw = paramzzbbm;
    this.zzlj = paramContext;
  }

  private static ResolveInfo zza(PackageManager paramPackageManager, String paramString)
  {
    return paramPackageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)), 65536);
  }

  private static String zza(Context paramContext, PackageManager paramPackageManager)
  {
    ResolveInfo localResolveInfo = zza(paramPackageManager, "market://details?id=com.google.android.gms.ads");
    if (localResolveInfo == null);
    while (true)
    {
      return null;
      ActivityInfo localActivityInfo = localResolveInfo.activityInfo;
      if (localActivityInfo != null)
        try
        {
          PackageInfo localPackageInfo = Wrappers.packageManager(paramContext).getPackageInfo(localActivityInfo.packageName, 0);
          if (localPackageInfo != null)
          {
            int i = localPackageInfo.versionCode;
            String str1 = localActivityInfo.packageName;
            String str2 = 12 + String.valueOf(str1).length() + i + "." + str1;
            return str2;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
        }
    }
    return null;
  }

  private static String zzs(Context paramContext)
  {
    try
    {
      PackageInfo localPackageInfo = Wrappers.packageManager(paramContext).getPackageInfo("com.android.vending", 128);
      Object localObject = null;
      if (localPackageInfo != null)
      {
        int i = localPackageInfo.versionCode;
        String str1 = localPackageInfo.packageName;
        String str2 = 12 + String.valueOf(str1).length() + i + "." + str1;
        localObject = str2;
      }
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public final zzbbi<zzcve> zzalm()
  {
    return this.zzfqw.zza(new zzcvg(this));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcvf
 * JD-Core Version:    0.6.2
 */