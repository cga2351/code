package com.google.android.gms.maps.internal;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;

public abstract class zzbt extends zzb
  implements zzbs
{
  public zzbt()
  {
    super("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      onSnapshotReady((Bitmap)zzc.zza(paramParcel1, Bitmap.CREATOR));
    case 2:
    }
    while (true)
    {
      paramParcel2.writeNoException();
      return true;
      zzb(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.zzbt
 * JD-Core Version:    0.6.2
 */