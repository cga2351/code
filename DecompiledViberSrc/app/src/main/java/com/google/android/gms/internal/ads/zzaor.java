package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzaor extends zzfn
  implements zzaoq
{
  public zzaor()
  {
    super("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      zza(zzani.zzaa(paramParcel1.readStrongBinder()));
    case 2:
    }
    while (true)
    {
      paramParcel2.writeNoException();
      return true;
      zzdb(paramParcel1.readString());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaor
 * JD-Core Version:    0.6.2
 */