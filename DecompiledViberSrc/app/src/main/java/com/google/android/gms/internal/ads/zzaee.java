package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzaee extends zzfn
  implements zzaed
{
  public zzaee()
  {
    super("com.google.android.gms.ads.internal.formats.client.IMediaContent");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 2)
    {
      float f = getAspectRatio();
      paramParcel2.writeNoException();
      paramParcel2.writeFloat(f);
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaee
 * JD-Core Version:    0.6.2
 */