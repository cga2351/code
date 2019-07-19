package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

@KeepForSdk
public final class UidVerifier
{
  @KeepForSdk
  public static boolean isGooglePlayServicesUid(Context paramContext, int paramInt)
  {
    if (!uidHasPackageName(paramContext, paramInt, "com.google.android.gms"));
    do
    {
      return false;
      PackageManager localPackageManager = paramContext.getPackageManager();
      try
      {
        PackageInfo localPackageInfo = localPackageManager.getPackageInfo("com.google.android.gms", 64);
        return GoogleSignatureVerifier.getInstance(paramContext).isGooglePublicSignedPackage(localPackageInfo);
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
      }
    }
    while (!Log.isLoggable("UidVerifier", 3));
    Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
    return false;
  }

  @TargetApi(19)
  @KeepForSdk
  public static boolean uidHasPackageName(Context paramContext, int paramInt, String paramString)
  {
    return Wrappers.packageManager(paramContext).zzb(paramInt, paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.UidVerifier
 * JD-Core Version:    0.6.2
 */