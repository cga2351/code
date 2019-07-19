package com.google.android.gms.internal.auth-api;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

public abstract interface zzu extends IInterface
{
  public abstract void zzc(Status paramStatus)
    throws RemoteException;

  public abstract void zzc(Status paramStatus, Credential paramCredential)
    throws RemoteException;

  public abstract void zzc(Status paramStatus, String paramString)
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth-api.zzu
 * JD-Core Version:    0.6.2
 */