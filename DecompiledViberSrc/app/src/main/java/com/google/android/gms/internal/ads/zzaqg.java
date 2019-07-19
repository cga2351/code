package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;

@zzare
public final class zzaqg extends RemoteCreator<zzaqk>
{
  public zzaqg()
  {
    super("com.google.android.gms.ads.AdOverlayCreatorImpl");
  }

  public final zzaqh zzc(Activity paramActivity)
  {
    try
    {
      IObjectWrapper localIObjectWrapper = ObjectWrapper.wrap(paramActivity);
      IBinder localIBinder = ((zzaqk)getRemoteCreatorInstance(paramActivity)).zzad(localIObjectWrapper);
      if (localIBinder == null)
        return null;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
      if ((localIInterface instanceof zzaqh))
        return (zzaqh)localIInterface;
      zzaqj localzzaqj = new zzaqj(localIBinder);
      return localzzaqj;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzd("Could not create remote AdOverlay.", localRemoteException);
      return null;
    }
    catch (RemoteCreator.RemoteCreatorException localRemoteCreatorException)
    {
      zzbae.zzd("Could not create remote AdOverlay.", localRemoteCreatorException);
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaqg
 * JD-Core Version:    0.6.2
 */