package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

public final class zah extends zaa
  implements ISignInButtonCreator
{
  zah(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
  }

  public final IObjectWrapper newSignInButton(IObjectWrapper paramIObjectWrapper, int paramInt1, int paramInt2)
    throws RemoteException
  {
    Parcel localParcel1 = zaa();
    zac.zaa(localParcel1, paramIObjectWrapper);
    localParcel1.writeInt(paramInt1);
    localParcel1.writeInt(paramInt2);
    Parcel localParcel2 = zaa(1, localParcel1);
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localIObjectWrapper;
  }

  public final IObjectWrapper newSignInButtonFromConfig(IObjectWrapper paramIObjectWrapper, SignInButtonConfig paramSignInButtonConfig)
    throws RemoteException
  {
    Parcel localParcel1 = zaa();
    zac.zaa(localParcel1, paramIObjectWrapper);
    zac.zaa(localParcel1, paramSignInButtonConfig);
    Parcel localParcel2 = zaa(2, localParcel1);
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localIObjectWrapper;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zah
 * JD-Core Version:    0.6.2
 */