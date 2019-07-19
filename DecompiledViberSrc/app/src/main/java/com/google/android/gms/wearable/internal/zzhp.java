package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class zzhp
{
  private static zzhp zzfs;

  @VisibleForTesting
  private static final byte[] zzfu = zzd("");

  @VisibleForTesting
  private static final byte[] zzfv = zzd("");
  private final Context zzft;

  @VisibleForTesting
  private zzhp(Context paramContext)
  {
    this.zzft = paramContext.getApplicationContext();
  }

  public static zzhp zza(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    try
    {
      if (zzfs == null)
        zzfs = new zzhp(paramContext);
      return zzfs;
    }
    finally
    {
    }
  }

  @VisibleForTesting
  private static boolean zza(PackageInfo paramPackageInfo, boolean paramBoolean)
  {
    if (paramPackageInfo.signatures.length != 1)
    {
      Log.w("WearSignatureVerifier", "Package has more than one signature.");
      return false;
    }
    paramPackageInfo.signatures[0].toByteArray();
    if (paramBoolean)
    {
      byte[][] arrayOfByte2 = new byte[2][];
      arrayOfByte2[0] = zzfu;
      arrayOfByte2[1] = zzfv;
      return zza(paramPackageInfo, arrayOfByte2);
    }
    byte[][] arrayOfByte1 = new byte[1][];
    arrayOfByte1[0] = zzfu;
    return zza(paramPackageInfo, arrayOfByte1);
  }

  private static boolean zza(PackageInfo paramPackageInfo, byte[][] paramArrayOfByte)
  {
    if (paramPackageInfo.signatures == null);
    while (true)
    {
      return false;
      if (paramPackageInfo.signatures.length != 1)
      {
        Log.w("WearSignatureVerifier", "Package has more than one signature.");
        return false;
      }
      byte[] arrayOfByte = paramPackageInfo.signatures[0].toByteArray();
      for (int i = 0; i < paramArrayOfByte.length; i++)
        if (Arrays.equals(paramArrayOfByte[i], arrayOfByte))
          return true;
    }
  }

  private static byte[] zzd(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("ISO-8859-1");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new AssertionError(localUnsupportedEncodingException);
    }
  }

  private final PackageInfo zzf(String paramString)
  {
    try
    {
      PackageInfo localPackageInfo = Wrappers.packageManager(this.zzft).getPackageInfo(paramString, 64);
      return localPackageInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return null;
  }

  public final boolean zze(String paramString)
  {
    PackageInfo localPackageInfo = zzf(paramString);
    boolean bool = false;
    if (localPackageInfo == null);
    do
    {
      return bool;
      if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzft))
        return zza(localPackageInfo, true);
      bool = zza(localPackageInfo, false);
    }
    while ((bool) || (!zza(localPackageInfo, true)));
    Log.w("WearSignatureVerifier", "Test-keys aren't accepted on this build.");
    return bool;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzhp
 * JD-Core Version:    0.6.2
 */