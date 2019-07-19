package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;

public class zzcoi extends zzamx
{
  private final zzbsn zzfiq;
  private final zzbsd zzfjg;
  private final zzbsu zzflp;
  private final zzbrs zzfmr;
  private final zzbrh zzfms;
  private final zzbto zzfsr;
  private final zzbvp zzgcm;

  public zzcoi(zzbrh paramzzbrh, zzbrs paramzzbrs, zzbsd paramzzbsd, zzbsn paramzzbsn, zzbto paramzzbto, zzbsu paramzzbsu, zzbvp paramzzbvp)
  {
    this.zzfms = paramzzbrh;
    this.zzfmr = paramzzbrs;
    this.zzfjg = paramzzbsd;
    this.zzfiq = paramzzbsn;
    this.zzfsr = paramzzbto;
    this.zzflp = paramzzbsu;
    this.zzgcm = paramzzbvp;
  }

  public final void onAdClicked()
  {
    this.zzfms.onAdClicked();
  }

  public final void onAdClosed()
  {
    this.zzflp.zzsz();
  }

  public final void onAdFailedToLoad(int paramInt)
  {
  }

  public final void onAdImpression()
  {
    this.zzfmr.onAdImpression();
  }

  public final void onAdLeftApplication()
  {
    this.zzfjg.onAdLeftApplication();
  }

  public final void onAdLoaded()
  {
    this.zzfiq.onAdLoaded();
  }

  public final void onAdOpened()
  {
    this.zzflp.zzta();
  }

  public final void onAppEvent(String paramString1, String paramString2)
  {
    this.zzfsr.onAppEvent(paramString1, paramString2);
  }

  public void onVideoEnd()
  {
    this.zzgcm.onVideoEnd();
  }

  public final void onVideoPause()
  {
    this.zzgcm.onVideoPause();
  }

  public final void onVideoPlay()
    throws RemoteException
  {
    this.zzgcm.onVideoPlay();
  }

  public final void zza(zzafd paramzzafd, String paramString)
  {
  }

  public final void zza(zzamz paramzzamz)
  {
  }

  public void zza(zzatr paramzzatr)
    throws RemoteException
  {
  }

  public void zzb(Bundle paramBundle)
    throws RemoteException
  {
  }

  public void zzb(zzatp paramzzatp)
  {
  }

  public void zzcs(int paramInt)
    throws RemoteException
  {
  }

  public final void zzcz(String paramString)
  {
  }

  public void zzsm()
  {
    this.zzgcm.onVideoStart();
  }

  public void zzsn()
    throws RemoteException
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcoi
 * JD-Core Version:    0.6.2
 */