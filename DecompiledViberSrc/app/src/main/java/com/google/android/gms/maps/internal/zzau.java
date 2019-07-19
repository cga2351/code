package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzu;

public abstract class zzau extends zzb
  implements zzat
{
  public zzau()
  {
    super("com.google.android.gms.maps.internal.IOnMarkerDragListener");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      zzb(zzu.zzg(paramParcel1.readStrongBinder()));
    case 2:
    case 3:
    }
    while (true)
    {
      paramParcel2.writeNoException();
      return true;
      zzd(zzu.zzg(paramParcel1.readStrongBinder()));
      continue;
      zzc(zzu.zzg(paramParcel1.readStrongBinder()));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.zzau
 * JD-Core Version:    0.6.2
 */