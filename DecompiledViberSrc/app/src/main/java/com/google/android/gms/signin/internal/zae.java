package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zac;

public abstract class zae extends zab
  implements zad
{
  public zae()
  {
    super("com.google.android.gms.signin.internal.ISignInCallbacks");
  }

  protected boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    case 5:
    default:
      return false;
    case 3:
      zaa((ConnectionResult)zac.zaa(paramParcel1, ConnectionResult.CREATOR), (zaa)zac.zaa(paramParcel1, zaa.CREATOR));
    case 4:
    case 6:
    case 7:
    case 8:
    }
    while (true)
    {
      paramParcel2.writeNoException();
      return true;
      zag((Status)zac.zaa(paramParcel1, Status.CREATOR));
      continue;
      zah((Status)zac.zaa(paramParcel1, Status.CREATOR));
      continue;
      zaa((Status)zac.zaa(paramParcel1, Status.CREATOR), (GoogleSignInAccount)zac.zaa(paramParcel1, GoogleSignInAccount.CREATOR));
      continue;
      zab((zaj)zac.zaa(paramParcel1, zaj.CREATOR));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.signin.internal.zae
 * JD-Core Version:    0.6.2
 */