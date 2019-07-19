package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public abstract interface zzcjz<AdT, AdapterT, ListenerT extends zzbsl>
{
  public abstract void zza(zzcxt paramzzcxt, zzcxl paramzzcxl, zzcjx<AdapterT, ListenerT> paramzzcjx)
    throws RemoteException;

  public abstract AdT zzb(zzcxt paramzzcxt, zzcxl paramzzcxl, zzcjx<AdapterT, ListenerT> paramzzcjx)
    throws RemoteException, zzcmv;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcjz
 * JD-Core Version:    0.6.2
 */