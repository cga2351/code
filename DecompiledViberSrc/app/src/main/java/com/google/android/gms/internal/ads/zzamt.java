package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public abstract interface zzamt extends IInterface
{
  public abstract void destroy()
    throws RemoteException;

  public abstract Bundle getInterstitialAdapterInfo()
    throws RemoteException;

  public abstract zzaap getVideoController()
    throws RemoteException;

  public abstract boolean isInitialized()
    throws RemoteException;

  public abstract void pause()
    throws RemoteException;

  public abstract void resume()
    throws RemoteException;

  public abstract void setImmersiveMode(boolean paramBoolean)
    throws RemoteException;

  public abstract void showInterstitial()
    throws RemoteException;

  public abstract void showVideo()
    throws RemoteException;

  public abstract void zza(IObjectWrapper paramIObjectWrapper, zzaip paramzzaip, List<zzaix> paramList)
    throws RemoteException;

  public abstract void zza(IObjectWrapper paramIObjectWrapper, zzatl paramzzatl, List<String> paramList)
    throws RemoteException;

  public abstract void zza(IObjectWrapper paramIObjectWrapper, zzxx paramzzxx, String paramString, zzamw paramzzamw)
    throws RemoteException;

  public abstract void zza(IObjectWrapper paramIObjectWrapper, zzxx paramzzxx, String paramString1, zzatl paramzzatl, String paramString2)
    throws RemoteException;

  public abstract void zza(IObjectWrapper paramIObjectWrapper, zzxx paramzzxx, String paramString1, String paramString2, zzamw paramzzamw)
    throws RemoteException;

  public abstract void zza(IObjectWrapper paramIObjectWrapper, zzxx paramzzxx, String paramString1, String paramString2, zzamw paramzzamw, zzadx paramzzadx, List<String> paramList)
    throws RemoteException;

  public abstract void zza(IObjectWrapper paramIObjectWrapper, zzyb paramzzyb, zzxx paramzzxx, String paramString, zzamw paramzzamw)
    throws RemoteException;

  public abstract void zza(IObjectWrapper paramIObjectWrapper, zzyb paramzzyb, zzxx paramzzxx, String paramString1, String paramString2, zzamw paramzzamw)
    throws RemoteException;

  public abstract void zza(zzxx paramzzxx, String paramString)
    throws RemoteException;

  public abstract void zza(zzxx paramzzxx, String paramString1, String paramString2)
    throws RemoteException;

  public abstract void zzb(IObjectWrapper paramIObjectWrapper, zzxx paramzzxx, String paramString, zzamw paramzzamw)
    throws RemoteException;

  public abstract void zzr(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;

  public abstract void zzs(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;

  public abstract IObjectWrapper zzse()
    throws RemoteException;

  public abstract zzanb zzsf()
    throws RemoteException;

  public abstract zzane zzsg()
    throws RemoteException;

  public abstract Bundle zzsh()
    throws RemoteException;

  public abstract Bundle zzsi()
    throws RemoteException;

  public abstract boolean zzsj()
    throws RemoteException;

  public abstract zzafd zzsk()
    throws RemoteException;

  public abstract zzanh zzsl()
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzamt
 * JD-Core Version:    0.6.2
 */