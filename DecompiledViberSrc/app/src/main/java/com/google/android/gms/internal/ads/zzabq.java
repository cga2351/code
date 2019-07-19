package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Collections;
import java.util.List;

public final class zzabq extends zzaaa
{
  private zzais zzcka;

  public final String getVersionString()
  {
    return "";
  }

  public final void setAppMuted(boolean paramBoolean)
    throws RemoteException
  {
  }

  public final void setAppVolume(float paramFloat)
    throws RemoteException
  {
  }

  public final void zza()
    throws RemoteException
  {
    zzbae.zzen("The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
    zzazu.zzyr.post(new zzabr(this));
  }

  public final void zza(zzais paramzzais)
    throws RemoteException
  {
    this.zzcka = paramzzais;
  }

  public final void zza(zzamq paramzzamq)
    throws RemoteException
  {
  }

  public final void zzb(String paramString, IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
  }

  public final void zzbu(String paramString)
    throws RemoteException
  {
  }

  public final void zzbv(String paramString)
    throws RemoteException
  {
  }

  public final void zzc(IObjectWrapper paramIObjectWrapper, String paramString)
    throws RemoteException
  {
  }

  public final float zzpq()
    throws RemoteException
  {
    return 1.0F;
  }

  public final boolean zzpr()
    throws RemoteException
  {
    return false;
  }

  public final List<zzain> zzps()
    throws RemoteException
  {
    return Collections.EMPTY_LIST;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzabq
 * JD-Core Version:    0.6.2
 */