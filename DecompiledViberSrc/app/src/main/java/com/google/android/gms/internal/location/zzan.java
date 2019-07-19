package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzan extends zzb
  implements zzam
{
  public zzan()
  {
    super("com.google.android.gms.location.internal.IGeofencerCallbacks");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      zza(paramParcel1.readInt(), paramParcel1.createStringArray());
    case 2:
    case 3:
    }
    while (true)
    {
      return true;
      zzb(paramParcel1.readInt(), paramParcel1.createStringArray());
      continue;
      zza(paramParcel1.readInt(), (PendingIntent)zzc.zza(paramParcel1, PendingIntent.CREATOR));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.location.zzan
 * JD-Core Version:    0.6.2
 */