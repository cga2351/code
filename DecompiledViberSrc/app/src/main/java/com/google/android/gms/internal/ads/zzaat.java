package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzaat extends zzfn
  implements zzaas
{
  public zzaat()
  {
    super("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      onVideoStart();
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      paramParcel2.writeNoException();
      return true;
      onVideoPlay();
      continue;
      onVideoPause();
      continue;
      onVideoEnd();
      continue;
      onVideoMute(zzfo.zza(paramParcel1));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaat
 * JD-Core Version:    0.6.2
 */