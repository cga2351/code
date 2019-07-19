package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;

@zzare
public final class zzxv extends RemoteCreator<zzzl>
{
  @VisibleForTesting
  public zzxv()
  {
    super("com.google.android.gms.ads.AdManagerCreatorImpl");
  }

  public final zzzi zza(Context paramContext, zzyb paramzzyb, String paramString, zzamq paramzzamq, int paramInt)
  {
    try
    {
      IObjectWrapper localIObjectWrapper = ObjectWrapper.wrap(paramContext);
      IBinder localIBinder = ((zzzl)getRemoteCreatorInstance(paramContext)).zza(localIObjectWrapper, paramzzyb, paramString, paramzzamq, 15000000, paramInt);
      if (localIBinder == null)
        return null;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
      if ((localIInterface instanceof zzzi))
        return (zzzi)localIInterface;
      zzzk localzzzk = new zzzk(localIBinder);
      return localzzzk;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzb("Could not create remote AdManager.", localRemoteException);
      return null;
    }
    catch (RemoteCreator.RemoteCreatorException localRemoteCreatorException)
    {
      label79: break label79;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzxv
 * JD-Core Version:    0.6.2
 */