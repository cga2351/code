package com.google.android.gms.maps.internal;

import android.graphics.Bitmap;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract interface zzbs extends IInterface
{
  public abstract void onSnapshotReady(Bitmap paramBitmap)
    throws RemoteException;

  public abstract void zzb(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.zzbs
 * JD-Core Version:    0.6.2
 */