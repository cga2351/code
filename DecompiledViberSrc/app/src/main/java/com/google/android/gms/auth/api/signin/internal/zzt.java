package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.auth-api.zzd;
import com.google.android.gms.internal.auth-api.zze;

public abstract class zzt extends zzd
  implements zzs
{
  public zzt()
  {
    super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 101:
      zzc((GoogleSignInAccount)zze.zzc(paramParcel1, GoogleSignInAccount.CREATOR), (Status)zze.zzc(paramParcel1, Status.CREATOR));
    case 102:
    case 103:
    }
    while (true)
    {
      paramParcel2.writeNoException();
      return true;
      zze((Status)zze.zzc(paramParcel1, Status.CREATOR));
      continue;
      zzf((Status)zze.zzc(paramParcel1, Status.CREATOR));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzt
 * JD-Core Version:    0.6.2
 */