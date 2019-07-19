package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@KeepForSdk
@ShowFirstParty
public class GoogleSignatureVerifier
{
  private static GoogleSignatureVerifier zzal;
  private final Context mContext;
  private volatile String zzam;

  private GoogleSignatureVerifier(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
  }

  @KeepForSdk
  public static GoogleSignatureVerifier getInstance(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    try
    {
      if (zzal == null)
      {
        zzc.zza(paramContext);
        zzal = new GoogleSignatureVerifier(paramContext);
      }
      return zzal;
    }
    finally
    {
    }
  }

  private static zze zza(PackageInfo paramPackageInfo, zze[] paramArrayOfzze)
  {
    int i = 0;
    if (paramPackageInfo.signatures == null)
      return null;
    if (paramPackageInfo.signatures.length != 1)
    {
      Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
      return null;
    }
    zzf localzzf = new zzf(paramPackageInfo.signatures[0].toByteArray());
    while (i < paramArrayOfzze.length)
    {
      if (paramArrayOfzze[i].equals(localzzf))
        return paramArrayOfzze[i];
      i++;
    }
    return null;
  }

  private final zzm zza(PackageInfo paramPackageInfo)
  {
    boolean bool = GooglePlayServicesUtilLight.honorsDebugCertificates(this.mContext);
    zzm localzzm;
    if (paramPackageInfo == null)
      localzzm = zzm.zzb("null pkg");
    zzf localzzf;
    String str;
    do
    {
      return localzzm;
      if (paramPackageInfo.signatures.length != 1)
        return zzm.zzb("single cert required");
      localzzf = new zzf(paramPackageInfo.signatures[0].toByteArray());
      str = paramPackageInfo.packageName;
      localzzm = zzc.zza(str, localzzf, bool);
    }
    while ((!localzzm.zzac) || (paramPackageInfo.applicationInfo == null) || ((0x2 & paramPackageInfo.applicationInfo.flags) == 0) || ((bool) && (!zzc.zza(str, localzzf, false).zzac)));
    return zzm.zzb("debuggable release cert app rejected");
  }

  private final zzm zza(String paramString, int paramInt)
  {
    String str1;
    try
    {
      zzm localzzm = zza(Wrappers.packageManager(this.mContext).zza(paramString, 64, paramInt));
      return localzzm;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      str1 = String.valueOf(paramString);
      if (str1.length() == 0);
    }
    for (String str2 = "no pkg ".concat(str1); ; str2 = new String("no pkg "))
      return zzm.zzb(str2);
  }

  public static boolean zza(PackageInfo paramPackageInfo, boolean paramBoolean)
  {
    if ((paramPackageInfo != null) && (paramPackageInfo.signatures != null))
    {
      if (paramBoolean);
      zze[] arrayOfzze;
      for (zze localzze = zza(paramPackageInfo, zzh.zzx); localzze != null; localzze = zza(paramPackageInfo, arrayOfzze))
      {
        return true;
        arrayOfzze = new zze[1];
        arrayOfzze[0] = zzh.zzx[0];
      }
    }
    return false;
  }

  private final zzm zzc(String paramString)
  {
    zzm localzzm;
    if (paramString == null)
      localzzm = zzm.zzb("null pkg");
    String str1;
    while (true)
    {
      return localzzm;
      if (paramString.equals(this.zzam))
        return zzm.zze();
      try
      {
        PackageInfo localPackageInfo = Wrappers.packageManager(this.mContext).getPackageInfo(paramString, 64);
        localzzm = zza(localPackageInfo);
        if (localzzm.zzac)
        {
          this.zzam = paramString;
          return localzzm;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        str1 = String.valueOf(paramString);
        if (str1.length() == 0);
      }
    }
    for (String str2 = "no pkg ".concat(str1); ; str2 = new String("no pkg "))
      return zzm.zzb(str2);
  }

  @KeepForSdk
  public boolean isGooglePublicSignedPackage(PackageInfo paramPackageInfo)
  {
    if (paramPackageInfo == null);
    do
    {
      return false;
      if (zza(paramPackageInfo, false))
        return true;
    }
    while (!zza(paramPackageInfo, true));
    if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.mContext))
      return true;
    Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
    return false;
  }

  @KeepForSdk
  @ShowFirstParty
  public boolean isPackageGoogleSigned(String paramString)
  {
    zzm localzzm = zzc(paramString);
    localzzm.zzf();
    return localzzm.zzac;
  }

  @KeepForSdk
  @ShowFirstParty
  public boolean isUidGoogleSigned(int paramInt)
  {
    String[] arrayOfString = Wrappers.packageManager(this.mContext).getPackagesForUid(paramInt);
    zzm localzzm;
    if ((arrayOfString == null) || (arrayOfString.length == 0))
      localzzm = zzm.zzb("no pkgs");
    label73: 
    while (true)
    {
      localzzm.zzf();
      return localzzm.zzac;
      int i = arrayOfString.length;
      localzzm = null;
      for (int j = 0; ; j++)
      {
        if (j >= i)
          break label73;
        localzzm = zza(arrayOfString[j], paramInt);
        if (localzzm.zzac)
          break;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.GoogleSignatureVerifier
 * JD-Core Version:    0.6.2
 */