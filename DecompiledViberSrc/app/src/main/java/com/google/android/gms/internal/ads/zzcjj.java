package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;

public final class zzcjj
  implements zzczy
{
  private final zzcjh zzfyt;

  zzcjj(zzcjh paramzzcjh)
  {
    this.zzfyt = paramzzcjh;
  }

  public final void zza(zzczr paramzzczr, String paramString)
  {
  }

  public final void zza(zzczr paramzzczr, String paramString, Throwable paramThrowable)
  {
    zzaci localzzaci = zzact.zzcwt;
    if ((((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue()) && (zzczr.zzgmw == paramzzczr) && (this.zzfyt.zzakm() != 0L))
      this.zzfyt.zzev(zzk.zzln().elapsedRealtime() - this.zzfyt.zzakm());
  }

  public final void zzb(zzczr paramzzczr, String paramString)
  {
    zzaci localzzaci = zzact.zzcwt;
    if ((((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue()) && (zzczr.zzgmw == paramzzczr))
      this.zzfyt.zzfh(zzk.zzln().elapsedRealtime());
  }

  public final void zzc(zzczr paramzzczr, String paramString)
  {
    zzaci localzzaci = zzact.zzcwt;
    if ((((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue()) && (zzczr.zzgmw == paramzzczr) && (this.zzfyt.zzakm() != 0L))
      this.zzfyt.zzev(zzk.zzln().elapsedRealtime() - this.zzfyt.zzakm());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcjj
 * JD-Core Version:    0.6.2
 */