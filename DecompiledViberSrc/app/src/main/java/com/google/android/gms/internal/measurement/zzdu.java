package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzdu extends zzr
  implements zzdt
{
  public zzdu()
  {
    super("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      onEvent(paramParcel1.readString(), paramParcel1.readString(), (Bundle)zzs.zza(paramParcel1, Bundle.CREATOR), paramParcel1.readLong());
      paramParcel2.writeNoException();
    case 2:
    }
    while (true)
    {
      return true;
      int i = id();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(i);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzdu
 * JD-Core Version:    0.6.2
 */