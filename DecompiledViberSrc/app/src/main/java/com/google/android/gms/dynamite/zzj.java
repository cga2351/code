package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

public final class zzj extends zza
  implements zzi
{
  zzj(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
  }

  public final int zza(IObjectWrapper paramIObjectWrapper, String paramString, boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    zzc.zza(localParcel1, paramIObjectWrapper);
    localParcel1.writeString(paramString);
    zzc.writeBoolean(localParcel1, paramBoolean);
    Parcel localParcel2 = zza(3, localParcel1);
    int i = localParcel2.readInt();
    localParcel2.recycle();
    return i;
  }

  public final IObjectWrapper zza(IObjectWrapper paramIObjectWrapper, String paramString, int paramInt)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    zzc.zza(localParcel1, paramIObjectWrapper);
    localParcel1.writeString(paramString);
    localParcel1.writeInt(paramInt);
    Parcel localParcel2 = zza(2, localParcel1);
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localIObjectWrapper;
  }

  public final int zzaj()
    throws RemoteException
  {
    Parcel localParcel = zza(6, zza());
    int i = localParcel.readInt();
    localParcel.recycle();
    return i;
  }

  public final int zzb(IObjectWrapper paramIObjectWrapper, String paramString, boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    zzc.zza(localParcel1, paramIObjectWrapper);
    localParcel1.writeString(paramString);
    zzc.writeBoolean(localParcel1, paramBoolean);
    Parcel localParcel2 = zza(5, localParcel1);
    int i = localParcel2.readInt();
    localParcel2.recycle();
    return i;
  }

  public final IObjectWrapper zzb(IObjectWrapper paramIObjectWrapper, String paramString, int paramInt)
    throws RemoteException
  {
    Parcel localParcel1 = zza();
    zzc.zza(localParcel1, paramIObjectWrapper);
    localParcel1.writeString(paramString);
    localParcel1.writeInt(paramInt);
    Parcel localParcel2 = zza(4, localParcel1);
    IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel2.readStrongBinder());
    localParcel2.recycle();
    return localIObjectWrapper;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.dynamite.zzj
 * JD-Core Version:    0.6.2
 */