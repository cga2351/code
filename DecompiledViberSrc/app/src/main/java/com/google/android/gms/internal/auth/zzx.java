package com.google.android.gms.internal.auth;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.accounttransfer.DeviceMetaData;
import com.google.android.gms.auth.api.accounttransfer.zzl;
import com.google.android.gms.auth.api.accounttransfer.zzt;
import com.google.android.gms.common.api.Status;

public abstract interface zzx extends IInterface
{
  public abstract void onFailure(Status paramStatus)
    throws RemoteException;

  public abstract void zza(DeviceMetaData paramDeviceMetaData)
    throws RemoteException;

  public abstract void zza(Status paramStatus, zzl paramzzl)
    throws RemoteException;

  public abstract void zza(Status paramStatus, zzt paramzzt)
    throws RemoteException;

  public abstract void zza(byte[] paramArrayOfByte)
    throws RemoteException;

  public abstract void zzb(Status paramStatus)
    throws RemoteException;

  public abstract void zzd()
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzx
 * JD-Core Version:    0.6.2
 */