package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.List;

public final class zzcoj
  implements zzcju<zzbne>
{
  private final zzbob zzfzo;
  private final zzczs zzgbk;
  private final zzbbm zzgci;
  private final Context zzgcn;
  private final zzadn zzgco;

  public zzcoj(Context paramContext, zzbob paramzzbob, zzczs paramzzczs, zzbbm paramzzbbm, zzadn paramzzadn)
  {
    this.zzgcn = paramContext;
    this.zzfzo = paramzzbob;
    this.zzgbk = paramzzczs;
    this.zzgci = paramzzbbm;
    this.zzgco = paramzzadn;
  }

  public final boolean zza(zzcxt paramzzcxt, zzcxl paramzzcxl)
  {
    return (this.zzgco != null) && (paramzzcxl.zzgke != null) && (paramzzcxl.zzgke.zzdkr != null);
  }

  public final zzbbi<zzbne> zzb(zzcxt paramzzcxt, zzcxl paramzzcxl)
  {
    zzcom localzzcom = new zzcom(this, new View(this.zzgcn), null, zzcok.zzgcp, (zzcxm)paramzzcxl.zzgkg.get(0));
    zzbnf localzzbnf = this.zzfzo.zza(new zzbpq(paramzzcxt, paramzzcxl, null), localzzcom);
    zzadi localzzadi = new zzadi(localzzbnf.zzaea(), paramzzcxl.zzgke.zzdkp, paramzzcxl.zzgke.zzdkr);
    return this.zzgbk.zzv(zzczr.zzgnj).zza(new zzcol(this, localzzadi), this.zzgci).zzx(zzczr.zzgnk).zzb(zzbas.zzm(localzzbnf.zzadx())).zzane();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcoj
 * JD-Core Version:    0.6.2
 */