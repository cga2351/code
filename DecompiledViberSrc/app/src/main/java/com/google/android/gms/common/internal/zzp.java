package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.concurrent.GuardedBy;

public final class zzp
{
  private static Object sLock = new Object();

  @GuardedBy("sLock")
  private static boolean zzeo;
  private static String zzep;
  private static int zzeq;

  public static String zzc(Context paramContext)
  {
    zze(paramContext);
    return zzep;
  }

  public static int zzd(Context paramContext)
  {
    zze(paramContext);
    return zzeq;
  }

  private static void zze(Context paramContext)
  {
    String str;
    PackageManagerWrapper localPackageManagerWrapper;
    synchronized (sLock)
    {
      if (zzeo)
        return;
      zzeo = true;
      str = paramContext.getPackageName();
      localPackageManagerWrapper = Wrappers.packageManager(paramContext);
    }
    try
    {
      Bundle localBundle = localPackageManagerWrapper.getApplicationInfo(str, 128).metaData;
      if (localBundle == null)
      {
        return;
        localObject2 = finally;
        throw localObject2;
      }
      zzep = localBundle.getString("com.google.app.id");
      zzeq = localBundle.getInt("com.google.android.gms.version");
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
        Log.wtf("MetadataValueReader", "This should never happen.", localNameNotFoundException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzp
 * JD-Core Version:    0.6.2
 */