package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

public final class zag extends zaa
  implements zaf
{
  zag(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.signin.internal.ISignInService");
  }

  public final void zaa(IAccountAccessor paramIAccountAccessor, int paramInt, boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zaa();
    zac.zaa(localParcel, paramIAccountAccessor);
    localParcel.writeInt(paramInt);
    zac.writeBoolean(localParcel, paramBoolean);
    zab(9, localParcel);
  }

  public final void zaa(zah paramzah, zad paramzad)
    throws RemoteException
  {
    Parcel localParcel = zaa();
    zac.zaa(localParcel, paramzah);
    zac.zaa(localParcel, paramzad);
    zab(12, localParcel);
  }

  public final void zam(int paramInt)
    throws RemoteException
  {
    Parcel localParcel = zaa();
    localParcel.writeInt(paramInt);
    zab(7, localParcel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.signin.internal.zag
 * JD-Core Version:    0.6.2
 */