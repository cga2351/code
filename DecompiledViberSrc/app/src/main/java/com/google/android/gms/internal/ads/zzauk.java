package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzare
public final class zzauk
{
  public static zzatu zzd(Context paramContext, String paramString, zzamq paramzzamq)
  {
    IObjectWrapper localIObjectWrapper = ObjectWrapper.wrap(paramContext);
    try
    {
      IBinder localIBinder = ((zzaua)zzbaf.zza(paramContext, "com.google.android.gms.ads.rewarded.ChimeraRewardedAdCreatorImpl", zzaul.zzbze)).zzd(localIObjectWrapper, paramString, paramzzamq, 15000000);
      if (localIBinder == null)
        return null;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
      if ((localIInterface instanceof zzatu))
        return (zzatu)localIInterface;
      zzatw localzzatw = new zzatw(localIBinder);
      return localzzatw;
    }
    catch (zzbah localzzbah)
    {
      zzbae.zze("#007 Could not call remote method.", localzzbah);
      return null;
    }
    catch (RemoteException localRemoteException)
    {
      label77: break label77;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzauk
 * JD-Core Version:    0.6.2
 */