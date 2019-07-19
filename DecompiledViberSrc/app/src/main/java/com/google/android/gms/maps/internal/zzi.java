package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.internal.maps.zzu;

public abstract class zzi extends zzb
  implements zzh
{
  public zzi()
  {
    super("com.google.android.gms.maps.internal.IInfoWindowAdapter");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      IObjectWrapper localIObjectWrapper2 = zzh(zzu.zzg(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      zzc.zza(paramParcel2, localIObjectWrapper2);
    case 2:
    }
    while (true)
    {
      return true;
      IObjectWrapper localIObjectWrapper1 = zzi(zzu.zzg(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      zzc.zza(paramParcel2, localIObjectWrapper1);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.zzi
 * JD-Core Version:    0.6.2
 */