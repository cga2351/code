package com.google.android.gms.internal.ads;

import javax.annotation.concurrent.GuardedBy;

public final class zzceo
  implements zzbrn, zzbrv, zzbsq, zzbtj, zzxp
{
  private final zzwh zzftz;

  @GuardedBy("this")
  private boolean zzfua = false;

  @GuardedBy("this")
  private boolean zzfub = false;

  public zzceo(zzwh paramzzwh)
  {
    this.zzftz = paramzzwh;
    paramzzwh.zza(zzwj.zza.zzb.zzbxq);
  }

  public final void onAdClicked()
  {
    try
    {
      if (!this.zzfub)
      {
        this.zzftz.zza(zzwj.zza.zzb.zzbxt);
        this.zzfub = true;
      }
      while (true)
      {
        return;
        this.zzftz.zza(zzwj.zza.zzb.zzbxu);
      }
    }
    finally
    {
    }
  }

  public final void onAdFailedToLoad(int paramInt)
  {
    switch (paramInt)
    {
    default:
      this.zzftz.zza(zzwj.zza.zzb.zzbyh);
      return;
    case 1:
      this.zzftz.zza(zzwj.zza.zzb.zzbyj);
      return;
    case 2:
      this.zzftz.zza(zzwj.zza.zzb.zzbyk);
      return;
    case 3:
      this.zzftz.zza(zzwj.zza.zzb.zzbyi);
      return;
    case 4:
      this.zzftz.zza(zzwj.zza.zzb.zzbyl);
      return;
    case 5:
      this.zzftz.zza(zzwj.zza.zzb.zzbym);
      return;
    case 6:
      this.zzftz.zza(zzwj.zza.zzb.zzbyn);
      return;
    case 7:
    }
    this.zzftz.zza(zzwj.zza.zzb.zzbyo);
  }

  public final void onAdImpression()
  {
    try
    {
      this.zzftz.zza(zzwj.zza.zzb.zzbxs);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void onAdLoaded()
  {
    this.zzftz.zza(zzwj.zza.zzb.zzbxr);
  }

  public final void zza(zzcxt paramzzcxt)
  {
    this.zzftz.zza(new zzcep(paramzzcxt));
  }

  public final void zzb(zzary paramzzary)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzceo
 * JD-Core Version:    0.6.2
 */