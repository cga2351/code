package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzcmp extends zzcmm<zzbvw>
{
  private final zzbtu zzeqd;
  private final zzcov zzezw;
  private final zzbjn zzgbc;
  private final zzbqx.zza zzgbd;

  public zzcmp(zzbjn paramzzbjn, zzbqx.zza paramzza, zzcov paramzzcov, zzbtu paramzzbtu)
  {
    this.zzgbc = paramzzbjn;
    this.zzgbd = paramzza;
    this.zzezw = paramzzcov;
    this.zzeqd = paramzzbtu;
  }

  protected final zzbbi<zzbvw> zza(zzcxu paramzzcxu, Bundle paramBundle)
  {
    return this.zzgbc.zzack().zzc(this.zzgbd.zza(paramzzcxu).zze(paramBundle).zzagh()).zzc(this.zzeqd).zzb(this.zzezw).zzaed().zzadu();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcmp
 * JD-Core Version:    0.6.2
 */