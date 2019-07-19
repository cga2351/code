package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;

public final class zzcdm
{
  private final zzbhg zzbru;
  private final zzbaj zzbtd;
  private final zzwh zzejf;
  private final zzdh zzekq;
  private final zza zzeks;
  private final zzcxu zzfjp;
  private final zzbta zzftg;
  private final Context zzlj;

  public zzcdm(zzbhg paramzzbhg, Context paramContext, zzcxu paramzzcxu, zzdh paramzzdh, zzbaj paramzzbaj, zza paramzza, zzwh paramzzwh, zzbta paramzzbta)
  {
    this.zzbru = paramzzbhg;
    this.zzlj = paramContext;
    this.zzfjp = paramzzcxu;
    this.zzekq = paramzzdh;
    this.zzbtd = paramzzbaj;
    this.zzeks = paramzza;
    this.zzejf = paramzzwh;
    this.zzftg = paramzzbta;
  }

  public final zzbha zzc(zzyb paramzzyb)
    throws zzbhk
  {
    return zzbhg.zza(this.zzlj, zzbio.zzb(paramzzyb), paramzzyb.zzaap, false, false, this.zzekq, this.zzbtd, null, new zzcdn(this), this.zzeks, this.zzejf);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcdm
 * JD-Core Version:    0.6.2
 */