package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;

@zzare
public final class zzxu extends RemoteCreator<zzzg>
{
  public zzxu()
  {
    super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
  }

  public final zzzd zza(Context paramContext, String paramString, zzamq paramzzamq)
  {
    try
    {
      IObjectWrapper localIObjectWrapper = ObjectWrapper.wrap(paramContext);
      IBinder localIBinder = ((zzzg)getRemoteCreatorInstance(paramContext)).zzc(localIObjectWrapper, paramString, paramzzamq, 15000000);
      if (localIBinder == null)
        return null;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
      if ((localIInterface instanceof zzzd))
        return (zzzd)localIInterface;
      zzzf localzzzf = new zzzf(localIBinder);
      return localzzzf;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzd("Could not create remote builder for AdLoader.", localRemoteException);
      return null;
    }
    catch (RemoteCreator.RemoteCreatorException localRemoteCreatorException)
    {
      label75: break label75;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzxu
 * JD-Core Version:    0.6.2
 */