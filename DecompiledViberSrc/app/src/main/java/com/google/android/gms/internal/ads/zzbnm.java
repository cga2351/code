package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbnm
  implements zzdth<zzbsn>
{
  private final zzbnj zzfho;
  private final zzdtt<Set<zzbuy<zzbsq>>> zzfhp;

  public zzbnm(zzbnj paramzzbnj, zzdtt<Set<zzbuy<zzbsq>>> paramzzdtt)
  {
    this.zzfho = paramzzbnj;
    this.zzfhp = paramzzdtt;
  }

  public static zzbsn zza(zzbnj paramzzbnj, Set<zzbuy<zzbsq>> paramSet)
  {
    return (zzbsn)zzdtn.zza(paramzzbnj.zza(paramSet), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbnm
 * JD-Core Version:    0.6.2
 */