package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;
import java.util.HashMap;

@zzare
public final class zzagk extends RemoteCreator<zzaet>
{
  @VisibleForTesting
  public zzagk()
  {
    super("com.google.android.gms.ads.NativeAdViewHolderDelegateCreatorImpl");
  }

  public final zzaeq zzb(View paramView, HashMap<String, View> paramHashMap1, HashMap<String, View> paramHashMap2)
  {
    try
    {
      IObjectWrapper localIObjectWrapper1 = ObjectWrapper.wrap(paramView);
      IObjectWrapper localIObjectWrapper2 = ObjectWrapper.wrap(paramHashMap1);
      IObjectWrapper localIObjectWrapper3 = ObjectWrapper.wrap(paramHashMap2);
      IBinder localIBinder = ((zzaet)getRemoteCreatorInstance(paramView.getContext())).zzb(localIObjectWrapper1, localIObjectWrapper2, localIObjectWrapper3);
      if (localIBinder == null)
        return null;
      IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
      if ((localIInterface instanceof zzaeq))
        return (zzaeq)localIInterface;
      zzaes localzzaes = new zzaes(localIBinder);
      return localzzaes;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzd("Could not create remote NativeAdViewHolderDelegate.", localRemoteException);
      return null;
    }
    catch (RemoteCreator.RemoteCreatorException localRemoteCreatorException)
    {
      label90: break label90;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzagk
 * JD-Core Version:    0.6.2
 */