package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.auth-api.zzd;

public abstract class zzr extends zzd
  implements zzq
{
  public zzr()
  {
    super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      zzj();
    case 2:
    }
    while (true)
    {
      return true;
      zzk();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzr
 * JD-Core Version:    0.6.2
 */