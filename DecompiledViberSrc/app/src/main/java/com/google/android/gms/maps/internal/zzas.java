package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.internal.maps.zzu;

public abstract class zzas extends zzb
  implements zzar
{
  public zzas()
  {
    super("com.google.android.gms.maps.internal.IOnMarkerClickListener");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      boolean bool = zza(zzu.zzg(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      zzc.writeBoolean(paramParcel2, bool);
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.zzas
 * JD-Core Version:    0.6.2
 */