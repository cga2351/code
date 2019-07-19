package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract interface zzaqh extends IInterface
{
  public abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    throws RemoteException;

  public abstract void onBackPressed()
    throws RemoteException;

  public abstract void onCreate(Bundle paramBundle)
    throws RemoteException;

  public abstract void onDestroy()
    throws RemoteException;

  public abstract void onPause()
    throws RemoteException;

  public abstract void onRestart()
    throws RemoteException;

  public abstract void onResume()
    throws RemoteException;

  public abstract void onSaveInstanceState(Bundle paramBundle)
    throws RemoteException;

  public abstract void onStart()
    throws RemoteException;

  public abstract void onStop()
    throws RemoteException;

  public abstract void zzac(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;

  public abstract void zzdd()
    throws RemoteException;

  public abstract boolean zztg()
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaqh
 * JD-Core Version:    0.6.2
 */