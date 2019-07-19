package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;

public final class zzbqm
  implements zzdth<zzb>
{
  private final zzdtt<Context> zzeol;
  private final zzbql zzfjm;
  private final zzdtt<zzavc> zzfjn;

  private zzbqm(zzbql paramzzbql, zzdtt<Context> paramzzdtt, zzdtt<zzavc> paramzzdtt1)
  {
    this.zzfjm = paramzzbql;
    this.zzeol = paramzzdtt;
    this.zzfjn = paramzzdtt1;
  }

  public static zzbqm zza(zzbql paramzzbql, zzdtt<Context> paramzzdtt, zzdtt<zzavc> paramzzdtt1)
  {
    return new zzbqm(paramzzbql, paramzzdtt, paramzzdtt1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbqm
 * JD-Core Version:    0.6.2
 */