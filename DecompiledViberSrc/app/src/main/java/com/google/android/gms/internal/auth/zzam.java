package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyResponse;

public abstract class zzam extends zzb
  implements zzal
{
  public zzam()
  {
    super("com.google.android.gms.auth.api.internal.IAuthCallbacks");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      zza((ProxyResponse)zzc.zza(paramParcel1, ProxyResponse.CREATOR));
    case 2:
    }
    while (true)
    {
      paramParcel2.writeNoException();
      return true;
      zzb(paramParcel1.readString());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzam
 * JD-Core Version:    0.6.2
 */