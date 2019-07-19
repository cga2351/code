package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzabw extends zzasy
{
  private zzatc zzckd;

  public final void destroy()
    throws RemoteException
  {
  }

  public final Bundle getAdMetadata()
    throws RemoteException
  {
    return new Bundle();
  }

  public final String getMediationAdapterClassName()
    throws RemoteException
  {
    return null;
  }

  public final boolean isLoaded()
    throws RemoteException
  {
    return false;
  }

  public final void pause()
    throws RemoteException
  {
  }

  public final void resume()
    throws RemoteException
  {
  }

  public final void setAppPackageName(String paramString)
  {
  }

  public final void setCustomData(String paramString)
    throws RemoteException
  {
  }

  public final void setImmersiveMode(boolean paramBoolean)
    throws RemoteException
  {
  }

  public final void setUserId(String paramString)
    throws RemoteException
  {
  }

  public final void show()
    throws RemoteException
  {
  }

  public final void zza(zzasv paramzzasv)
    throws RemoteException
  {
  }

  public final void zza(zzatc paramzzatc)
    throws RemoteException
  {
    this.zzckd = paramzzatc;
  }

  public final void zza(zzati paramzzati)
    throws RemoteException
  {
    zzbae.zzen("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
    zzazu.zzyr.post(new zzabx(this));
  }

  public final void zza(zzzn paramzzzn)
    throws RemoteException
  {
  }

  public final void zzk(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
  }

  public final void zzl(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
  }

  public final void zzm(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
  }

  public final void zzn(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzabw
 * JD-Core Version:    0.6.2
 */