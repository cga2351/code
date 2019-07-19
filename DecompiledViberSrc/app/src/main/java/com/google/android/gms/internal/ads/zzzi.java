package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract interface zzzi extends IInterface
{
  public abstract void destroy()
    throws RemoteException;

  public abstract Bundle getAdMetadata()
    throws RemoteException;

  public abstract String getAdUnitId()
    throws RemoteException;

  public abstract String getMediationAdapterClassName()
    throws RemoteException;

  public abstract zzaap getVideoController()
    throws RemoteException;

  public abstract boolean isLoading()
    throws RemoteException;

  public abstract boolean isReady()
    throws RemoteException;

  public abstract void pause()
    throws RemoteException;

  public abstract void resume()
    throws RemoteException;

  public abstract void setImmersiveMode(boolean paramBoolean)
    throws RemoteException;

  public abstract void setManualImpressionsEnabled(boolean paramBoolean)
    throws RemoteException;

  public abstract void setUserId(String paramString)
    throws RemoteException;

  public abstract void showInterstitial()
    throws RemoteException;

  public abstract void stopLoading()
    throws RemoteException;

  public abstract void zza(zzaav paramzzaav)
    throws RemoteException;

  public abstract void zza(zzacc paramzzacc)
    throws RemoteException;

  public abstract void zza(zzadn paramzzadn)
    throws RemoteException;

  public abstract void zza(zzaqo paramzzaqo)
    throws RemoteException;

  public abstract void zza(zzaqu paramzzaqu, String paramString)
    throws RemoteException;

  public abstract void zza(zzatc paramzzatc)
    throws RemoteException;

  public abstract void zza(zzyb paramzzyb)
    throws RemoteException;

  public abstract void zza(zzyu paramzzyu)
    throws RemoteException;

  public abstract void zza(zzzn paramzzzn)
    throws RemoteException;

  public abstract void zza(zzzq paramzzzq)
    throws RemoteException;

  public abstract void zzb(zzyx paramzzyx)
    throws RemoteException;

  public abstract void zzb(zzzw paramzzzw)
    throws RemoteException;

  public abstract boolean zzb(zzxx paramzzxx)
    throws RemoteException;

  public abstract void zzbt(String paramString)
    throws RemoteException;

  public abstract String zzpj()
    throws RemoteException;

  public abstract IObjectWrapper zzpl()
    throws RemoteException;

  public abstract void zzpm()
    throws RemoteException;

  public abstract zzyb zzpn()
    throws RemoteException;

  public abstract zzzq zzpo()
    throws RemoteException;

  public abstract zzyx zzpp()
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzzi
 * JD-Core Version:    0.6.2
 */