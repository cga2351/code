package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;

@zzare
public final class zzagj extends RemoteCreator<zzaeo>
{
  @VisibleForTesting
  public zzagj()
  {
    super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
  }

  public final zzael zzb(Context paramContext, FrameLayout paramFrameLayout1, FrameLayout paramFrameLayout2)
  {
    try
    {
      IObjectWrapper localIObjectWrapper1 = ObjectWrapper.wrap(paramContext);
      IObjectWrapper localIObjectWrapper2 = ObjectWrapper.wrap(paramFrameLayout1);
      IObjectWrapper localIObjectWrapper3 = ObjectWrapper.wrap(paramFrameLayout2);
      IBinder localIBinder = ((zzaeo)getRemoteCreatorInstance(paramContext)).zza(localIObjectWrapper1, localIObjectWrapper2, localIObjectWrapper3, 15000000);
      if (localIBinder == null)
        return null;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
      if ((localIInterface instanceof zzael))
        return (zzael)localIInterface;
      zzaen localzzaen = new zzaen(localIBinder);
      return localzzaen;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzd("Could not create remote NativeAdViewDelegate.", localRemoteException);
      return null;
    }
    catch (RemoteCreator.RemoteCreatorException localRemoteCreatorException)
    {
      label89: break label89;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzagj
 * JD-Core Version:    0.6.2
 */