package com.google.android.gms.internal.location;

import android.os.DeadObjectException;
import android.os.IInterface;

public abstract interface zzbj<T extends IInterface>
{
  public abstract void checkConnected();

  public abstract T getService()
    throws DeadObjectException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.location.zzbj
 * JD-Core Version:    0.6.2
 */