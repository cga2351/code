package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

public abstract class zzj extends zzb
  implements zzi
{
  public zzj()
  {
    super("com.google.android.gms.common.internal.ICertData");
  }

  public static zzi zzb(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
    if ((localIInterface instanceof zzi))
      return (zzi)localIInterface;
    return new zzk(paramIBinder);
  }

  protected final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 1:
      IObjectWrapper localIObjectWrapper = zzb();
      paramParcel2.writeNoException();
      zzc.zza(paramParcel2, localIObjectWrapper);
    case 2:
    }
    while (true)
    {
      return true;
      int i = zzc();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(i);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzj
 * JD-Core Version:    0.6.2
 */