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
public final class zzabj extends RemoteCreator<zzaac>
{
  public zzabj()
  {
    super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
  }

  public final zzzz zzi(Context paramContext)
  {
    try
    {
      IObjectWrapper localIObjectWrapper = ObjectWrapper.wrap(paramContext);
      IBinder localIBinder = ((zzaac)getRemoteCreatorInstance(paramContext)).zzb(localIObjectWrapper, 15000000);
      if (localIBinder == null)
        return null;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
      if ((localIInterface instanceof zzzz))
        return (zzzz)localIInterface;
      zzaab localzzaab = new zzaab(localIBinder);
      return localzzaab;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzd("Could not get remote MobileAdsSettingManager.", localRemoteException);
      return null;
    }
    catch (RemoteCreator.RemoteCreatorException localRemoteCreatorException)
    {
      label70: break label70;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzabj
 * JD-Core Version:    0.6.2
 */