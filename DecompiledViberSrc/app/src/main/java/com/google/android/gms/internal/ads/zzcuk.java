package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

public final class zzcuk
  implements zzcuz<zzcuj>
{
  private final List<zzcpj> zzdek;
  private final ScheduledExecutorService zzfiw;
  private final zzcxu zzfjp;
  private final zzbbm zzfqw;
  private String zzgft;
  private final Context zzlj;

  public zzcuk(zzbbm paramzzbbm, ScheduledExecutorService paramScheduledExecutorService, String paramString, zzcpe paramzzcpe, Context paramContext, zzcxu paramzzcxu)
  {
    this.zzfqw = paramzzbbm;
    this.zzfiw = paramScheduledExecutorService;
    this.zzgft = paramString;
    this.zzlj = paramContext;
    this.zzfjp = paramzzcxu;
    if (paramzzcpe.zzakx().containsKey(paramzzcxu.zzglb))
    {
      this.zzdek = ((List)paramzzcpe.zzakx().get(paramzzcxu.zzglb));
      return;
    }
    this.zzdek = Collections.emptyList();
  }

  public final zzbbi<zzcuj> zzalm()
  {
    zzaci localzzaci = zzact.zzcqu;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
      return zzbas.zza(this.zzfqw.zza(new zzcul(this)), new zzcum(this), this.zzfqw);
    return zzbas.zzm(null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcuk
 * JD-Core Version:    0.6.2
 */