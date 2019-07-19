package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;

public final class zzcnh extends zzcoi
{
  private zzbvi zzgbr;
  private zzbro zzgbs;

  public zzcnh(zzbrh paramzzbrh, zzbrs paramzzbrs, zzbsd paramzzbsd, zzbsn paramzzbsn, zzbro paramzzbro, zzbto paramzzbto, zzbvp paramzzbvp, zzbsu paramzzbsu, zzbvi paramzzbvi)
  {
    super(paramzzbrh, paramzzbrs, paramzzbsd, paramzzbsn, paramzzbto, paramzzbsu, paramzzbvp);
    this.zzgbr = paramzzbvi;
    this.zzgbs = paramzzbro;
  }

  public final void onVideoEnd()
  {
    this.zzgbr.zzrr();
  }

  public final void zza(zzatr paramzzatr)
    throws RemoteException
  {
    this.zzgbr.zza(new zzatp(paramzzatr.getType(), paramzzatr.getAmount()));
  }

  public final void zzb(Bundle paramBundle)
    throws RemoteException
  {
  }

  public final void zzb(zzatp paramzzatp)
  {
    this.zzgbr.zza(paramzzatp);
  }

  public final void zzcs(int paramInt)
    throws RemoteException
  {
    this.zzgbs.zzcs(paramInt);
  }

  public final void zzsm()
  {
    this.zzgbr.zzrq();
  }

  public final void zzsn()
    throws RemoteException
  {
    this.zzgbr.zzrr();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcnh
 * JD-Core Version:    0.6.2
 */