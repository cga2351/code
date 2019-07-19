package com.yandex.metrica.impl;

import android.os.Bundle;
import android.os.RemoteException;

public abstract interface ai extends am
{
  public abstract void a(Bundle paramBundle)
    throws RemoteException;

  @Deprecated
  public abstract void a(String paramString1, int paramInt, String paramString2, Bundle paramBundle)
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ai
 * JD-Core Version:    0.6.2
 */