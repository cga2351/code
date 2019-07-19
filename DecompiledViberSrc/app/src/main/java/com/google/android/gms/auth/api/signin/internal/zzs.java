package com.google.android.gms.auth.api.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

public abstract interface zzs extends IInterface
{
  public abstract void zzc(GoogleSignInAccount paramGoogleSignInAccount, Status paramStatus)
    throws RemoteException;

  public abstract void zze(Status paramStatus)
    throws RemoteException;

  public abstract void zzf(Status paramStatus)
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzs
 * JD-Core Version:    0.6.2
 */