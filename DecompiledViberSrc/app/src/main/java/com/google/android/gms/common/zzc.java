package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzn;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
final class zzc
{
  private static volatile com.google.android.gms.common.internal.zzm zzn;
  private static final Object zzo = new Object();
  private static Context zzp;

  static zzm zza(String paramString, zze paramzze, boolean paramBoolean)
  {
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.allowThreadDiskReads();
    try
    {
      zzm localzzm = zzb(paramString, paramzze, paramBoolean);
      return localzzm;
    }
    finally
    {
      StrictMode.setThreadPolicy(localThreadPolicy);
    }
  }

  static void zza(Context paramContext)
  {
    try
    {
      if (zzp == null)
        if (paramContext != null)
          zzp = paramContext.getApplicationContext();
      while (true)
      {
        return;
        Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
      }
    }
    finally
    {
    }
  }

  private static zzm zzb(String paramString, zze paramzze, boolean paramBoolean)
  {
    try
    {
      if (zzn == null)
        Preconditions.checkNotNull(zzp);
      synchronized (zzo)
      {
        if (zzn == null)
          zzn = zzn.zzc(DynamiteModule.load(zzp, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
        Preconditions.checkNotNull(zzp);
        localzzk = new zzk(paramString, paramzze, paramBoolean);
      }
    }
    catch (DynamiteModule.LoadingException localLoadingException)
    {
      try
      {
        zzk localzzk;
        boolean bool = zzn.zza(localzzk, ObjectWrapper.wrap(zzp.getPackageManager()));
        if (bool)
        {
          return zzm.zze();
          localObject2 = finally;
          throw localObject2;
          localLoadingException = localLoadingException;
          Log.e("GoogleCertificates", "Failed to get Google certificates from remote", localLoadingException);
          String str1 = String.valueOf(localLoadingException.getMessage());
          if (str1.length() != 0);
          for (String str2 = "module init: ".concat(str1); ; str2 = new String("module init: "))
            return zzm.zza(str2, localLoadingException);
        }
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("GoogleCertificates", "Failed to get Google certificates from remote", localRemoteException);
        return zzm.zza("module call", localRemoteException);
      }
    }
    return zzm.zza(new zzd(paramBoolean, paramString, paramzze));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.zzc
 * JD-Core Version:    0.6.2
 */