package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zzc;

public abstract interface IGmsCallbacks extends IInterface
{
  public abstract void onPostInitComplete(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    throws RemoteException;

  public abstract void zza(int paramInt, Bundle paramBundle)
    throws RemoteException;

  public abstract void zza(int paramInt, IBinder paramIBinder, zzb paramzzb)
    throws RemoteException;

  public static abstract class zza extends com.google.android.gms.internal.common.zzb
    implements IGmsCallbacks
  {
    public zza()
    {
      super();
    }

    protected final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default:
        return false;
      case 1:
        onPostInitComplete(paramParcel1.readInt(), paramParcel1.readStrongBinder(), (Bundle)zzc.zza(paramParcel1, Bundle.CREATOR));
      case 2:
      case 3:
      }
      while (true)
      {
        paramParcel2.writeNoException();
        return true;
        zza(paramParcel1.readInt(), (Bundle)zzc.zza(paramParcel1, Bundle.CREATOR));
        continue;
        zza(paramParcel1.readInt(), paramParcel1.readStrongBinder(), (zzb)zzc.zza(paramParcel1, zzb.CREATOR));
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.IGmsCallbacks
 * JD-Core Version:    0.6.2
 */