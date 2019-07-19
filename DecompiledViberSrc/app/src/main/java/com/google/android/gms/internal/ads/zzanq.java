package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzanq extends zzamx
{
  private final zzatl zzdgg;
  private final Adapter zzdgr;

  zzanq(Adapter paramAdapter, zzatl paramzzatl)
  {
    this.zzdgr = paramAdapter;
    this.zzdgg = paramzzatl;
  }

  public final void onAdClicked()
    throws RemoteException
  {
    if (this.zzdgg != null)
      this.zzdgg.zzaj(ObjectWrapper.wrap(this.zzdgr));
  }

  public final void onAdClosed()
    throws RemoteException
  {
    if (this.zzdgg != null)
      this.zzdgg.zzai(ObjectWrapper.wrap(this.zzdgr));
  }

  public final void onAdFailedToLoad(int paramInt)
    throws RemoteException
  {
    if (this.zzdgg != null)
      this.zzdgg.zze(ObjectWrapper.wrap(this.zzdgr), paramInt);
  }

  public final void onAdImpression()
    throws RemoteException
  {
  }

  public final void onAdLeftApplication()
    throws RemoteException
  {
  }

  public final void onAdLoaded()
    throws RemoteException
  {
    if (this.zzdgg != null)
      this.zzdgg.zzaf(ObjectWrapper.wrap(this.zzdgr));
  }

  public final void onAdOpened()
    throws RemoteException
  {
    if (this.zzdgg != null)
      this.zzdgg.zzag(ObjectWrapper.wrap(this.zzdgr));
  }

  public final void onAppEvent(String paramString1, String paramString2)
    throws RemoteException
  {
  }

  public final void onVideoEnd()
    throws RemoteException
  {
  }

  public final void onVideoPause()
    throws RemoteException
  {
  }

  public final void onVideoPlay()
    throws RemoteException
  {
  }

  public final void zza(zzafd paramzzafd, String paramString)
    throws RemoteException
  {
  }

  public final void zza(zzamz paramzzamz)
    throws RemoteException
  {
  }

  public final void zza(zzatr paramzzatr)
    throws RemoteException
  {
    if (this.zzdgg != null)
      this.zzdgg.zza(ObjectWrapper.wrap(this.zzdgr), new zzatp(paramzzatr.getType(), paramzzatr.getAmount()));
  }

  public final void zzb(Bundle paramBundle)
    throws RemoteException
  {
  }

  public final void zzb(zzatp paramzzatp)
    throws RemoteException
  {
  }

  public final void zzcs(int paramInt)
    throws RemoteException
  {
  }

  public final void zzcz(String paramString)
    throws RemoteException
  {
  }

  public final void zzsm()
    throws RemoteException
  {
    if (this.zzdgg != null)
      this.zzdgg.zzah(ObjectWrapper.wrap(this.zzdgr));
  }

  public final void zzsn()
    throws RemoteException
  {
    if (this.zzdgg != null)
      this.zzdgg.zzal(ObjectWrapper.wrap(this.zzdgr));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzanq
 * JD-Core Version:    0.6.2
 */