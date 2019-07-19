package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzk;

public final class zzbqq
  implements zzbtj
{
  private final zzbaj zzbrd;
  private final zzaxc zzdum;
  private final zzcga zzfej;
  private final zzcxu zzfjp;
  private final Context zzys;

  public zzbqq(Context paramContext, zzcxu paramzzcxu, zzbaj paramzzbaj, zzaxc paramzzaxc, zzcga paramzzcga)
  {
    this.zzys = paramContext;
    this.zzfjp = paramzzcxu;
    this.zzbrd = paramzzbaj;
    this.zzdum = paramzzaxc;
    this.zzfej = paramzzcga;
  }

  public final void zza(zzcxt paramzzcxt)
  {
  }

  public final void zzb(zzary paramzzary)
  {
    zzaci localzzaci = zzact.zzcsw;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
    {
      zzawm localzzawm = this.zzdum.zzvr();
      zzk.zzlo().zza(this.zzys, this.zzbrd, this.zzfjp.zzglb, localzzawm);
    }
    this.zzfej.zzajx();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbqq
 * JD-Core Version:    0.6.2
 */