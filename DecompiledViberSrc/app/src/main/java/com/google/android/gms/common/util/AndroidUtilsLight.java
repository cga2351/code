package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@KeepForSdk
public class AndroidUtilsLight
{
  private static volatile int zzgd = -1;

  @TargetApi(24)
  @KeepForSdk
  public static Context getDeviceProtectedStorageContext(Context paramContext)
  {
    if ((PlatformVersion.isAtLeastN()) && (!paramContext.isDeviceProtectedStorage()))
      paramContext = paramContext.createDeviceProtectedStorageContext();
    return paramContext;
  }

  @KeepForSdk
  public static byte[] getPackageCertificateHashBytes(Context paramContext, String paramString)
    throws PackageManager.NameNotFoundException
  {
    PackageInfo localPackageInfo = Wrappers.packageManager(paramContext).getPackageInfo(paramString, 64);
    if ((localPackageInfo.signatures != null) && (localPackageInfo.signatures.length == 1))
    {
      MessageDigest localMessageDigest = zzi("SHA1");
      if (localMessageDigest != null)
        return localMessageDigest.digest(localPackageInfo.signatures[0].toByteArray());
    }
    return null;
  }

  public static MessageDigest zzi(String paramString)
  {
    int i = 0;
    while (i < 2)
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
        if (localMessageDigest != null)
          return localMessageDigest;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        i++;
      }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.AndroidUtilsLight
 * JD-Core Version:    0.6.2
 */