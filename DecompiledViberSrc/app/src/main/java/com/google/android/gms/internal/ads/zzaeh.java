package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract interface zzaeh extends IInterface
{
  public abstract int getHeight()
    throws RemoteException;

  public abstract double getScale()
    throws RemoteException;

  public abstract Uri getUri()
    throws RemoteException;

  public abstract int getWidth()
    throws RemoteException;

  public abstract IObjectWrapper zzrf()
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaeh
 * JD-Core Version:    0.6.2
 */