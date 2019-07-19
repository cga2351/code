package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.accounttransfer.DeviceMetaData;
import com.google.android.gms.auth.api.accounttransfer.zzl;
import com.google.android.gms.auth.api.accounttransfer.zzt;
import com.google.android.gms.common.api.Status;

public abstract class zzy extends zzb
  implements zzx
{
  public zzy()
  {
    super("com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferCallbacks");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      zzb((Status)zzc.zza(paramParcel1, Status.CREATOR));
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    }
    while (true)
    {
      return true;
      zza((Status)zzc.zza(paramParcel1, Status.CREATOR), (zzt)zzc.zza(paramParcel1, zzt.CREATOR));
      continue;
      zza((Status)zzc.zza(paramParcel1, Status.CREATOR), (zzl)zzc.zza(paramParcel1, zzl.CREATOR));
      continue;
      zzd();
      continue;
      onFailure((Status)zzc.zza(paramParcel1, Status.CREATOR));
      continue;
      zza(paramParcel1.createByteArray());
      continue;
      zza((DeviceMetaData)zzc.zza(paramParcel1, DeviceMetaData.CREATOR));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzy
 * JD-Core Version:    0.6.2
 */