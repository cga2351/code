package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;

public abstract class zzd extends zzb
  implements zzc
{
  public zzd()
  {
    super("com.google.android.gms.maps.internal.ICancelableCallback");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      onFinish();
    case 2:
    }
    while (true)
    {
      paramParcel2.writeNoException();
      return true;
      onCancel();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.zzd
 * JD-Core Version:    0.6.2
 */