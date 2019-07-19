package com.google.android.gms.internal.auth-api;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

public abstract class zzv extends zzd
  implements zzu
{
  public zzv()
  {
    super("com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      zzc((Status)zze.zzc(paramParcel1, Status.CREATOR), (Credential)zze.zzc(paramParcel1, Credential.CREATOR));
    case 2:
    case 3:
    }
    while (true)
    {
      paramParcel2.writeNoException();
      return true;
      zzc((Status)zze.zzc(paramParcel1, Status.CREATOR));
      continue;
      zzc((Status)zze.zzc(paramParcel1, Status.CREATOR), paramParcel1.readString());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth-api.zzv
 * JD-Core Version:    0.6.2
 */