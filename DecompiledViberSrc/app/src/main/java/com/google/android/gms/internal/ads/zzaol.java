package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public abstract class zzaol extends zzfn
  implements zzaok
{
  public zzaol()
  {
    super("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      zzw(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
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
 * Qualified Name:     com.google.android.gms.internal.ads.zzaol
 * JD-Core Version:    0.6.2
 */