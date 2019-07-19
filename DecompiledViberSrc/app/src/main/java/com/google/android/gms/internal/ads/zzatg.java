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
public final class zzatg extends RemoteCreator<zzata>
{
  public zzatg()
  {
    super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
  }

  public final zzasx zza(Context paramContext, zzamq paramzzamq)
  {
    try
    {
      IObjectWrapper localIObjectWrapper = ObjectWrapper.wrap(paramContext);
      IBinder localIBinder = ((zzata)getRemoteCreatorInstance(paramContext)).zzb(localIObjectWrapper, paramzzamq, 15000000);
      if (localIBinder == null)
        return null;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
      if ((localIInterface instanceof zzasx))
        return (zzasx)localIInterface;
      zzasz localzzasz = new zzasz(localIBinder);
      return localzzasz;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzd("Could not get remote RewardedVideoAd.", localRemoteException);
      return null;
    }
    catch (RemoteCreator.RemoteCreatorException localRemoteCreatorException)
    {
      label73: break label73;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzatg
 * JD-Core Version:    0.6.2
 */