package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamite.DynamiteModule;
import java.lang.reflect.Constructor;
import java.util.Random;
import javax.annotation.Nonnull;

abstract class zzyq<T>
{
  private static final zzzt zzcid = zzox();

  private static zzzt zzox()
  {
    try
    {
      Object localObject = zzyf.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi2").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      if (!(localObject instanceof IBinder))
      {
        zzbae.zzep("ClientApi class is not an instance of IBinder.");
        return null;
      }
      IBinder localIBinder = (IBinder)localObject;
      if (localIBinder == null)
        return null;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
      if ((localIInterface instanceof zzzt))
        return (zzzt)localIInterface;
      zzzv localzzzv = new zzzv(localIBinder);
      return localzzzv;
    }
    catch (Exception localException)
    {
      zzbae.zzep("Failed to instantiate ClientApi class.");
    }
    return null;
  }

  private final T zzoy()
  {
    if (zzcid == null)
    {
      zzbae.zzep("ClientApi class cannot be loaded.");
      return null;
    }
    try
    {
      Object localObject = zza(zzcid);
      return localObject;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzd("Cannot invoke local loader using ClientApi class.", localRemoteException);
    }
    return null;
  }

  private final T zzoz()
  {
    try
    {
      Object localObject = zzow();
      return localObject;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzd("Cannot invoke remote loader.", localRemoteException);
    }
    return null;
  }

  protected abstract T zza(zzzt paramzzzt)
    throws RemoteException;

  public final T zzd(Context paramContext, boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = 1;
      if (i == 0)
      {
        zzyr.zzpa();
        if (!zzazu.zzc(paramContext, 12451000))
        {
          zzbae.zzdp("Google Play Services is not available.");
          i = 1;
        }
      }
      if (DynamiteModule.getLocalVersion(paramContext, "com.google.android.gms.ads.dynamite") <= DynamiteModule.getRemoteVersion(paramContext, "com.google.android.gms.ads.dynamite"))
        break label269;
    }
    label132: label262: label269: for (int j = 1; ; j = i)
    {
      zzact.initialize(paramContext);
      zzaci localzzaci1 = zzact.zzcus;
      if (((Boolean)zzyr.zzpe().zzd(localzzaci1)).booleanValue())
        j = 0;
      Object localObject2;
      if (j != 0)
      {
        localObject2 = zzoy();
        if (localObject2 == null)
          localObject2 = zzoz();
      }
      while (true)
      {
        if (localObject2 == null)
          localObject2 = zzov();
        return localObject2;
        i = 0;
        break;
        Object localObject1 = zzoz();
        int k;
        int n;
        label172: Bundle localBundle;
        if (localObject1 == null)
        {
          k = 1;
          if (k != 0)
          {
            zzaci localzzaci2 = zzact.zzcwr;
            int m = ((Integer)zzyr.zzpe().zzd(localzzaci2)).intValue();
            if (zzyr.zzph().nextInt(m) != 0)
              break label250;
            n = 1;
            if (n != 0)
            {
              localBundle = new Bundle();
              localBundle.putString("action", "dynamite_load");
              if (k == 0)
                break label256;
            }
          }
        }
        for (int i1 = 1; ; i1 = 0)
        {
          localBundle.putInt("is_missing", i1);
          zzyr.zzpa().zza(paramContext, zzyr.zzpg().zzbsy, "gmob-apps", localBundle, true);
          if (localObject1 != null)
            break label262;
          localObject2 = zzoy();
          break;
          k = 0;
          break label132;
          label250: n = 0;
          break label172;
        }
        localObject2 = localObject1;
      }
    }
  }

  @Nonnull
  protected abstract T zzov();

  protected abstract T zzow()
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzyq
 * JD-Core Version:    0.6.2
 */