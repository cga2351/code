package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

public final class zzctx
  implements zzdth<zzctv>
{
  private final zzdtt<Context> zzeol;
  private final zzdtt<zzbbm> zzfgg;
  private final zzdtt<Set<String>> zzggm;

  private zzctx(zzdtt<zzbbm> paramzzdtt, zzdtt<Context> paramzzdtt1, zzdtt<Set<String>> paramzzdtt2)
  {
    this.zzfgg = paramzzdtt;
    this.zzeol = paramzzdtt1;
    this.zzggm = paramzzdtt2;
  }

  public static zzctx zzm(zzdtt<zzbbm> paramzzdtt, zzdtt<Context> paramzzdtt1, zzdtt<Set<String>> paramzzdtt2)
  {
    return new zzctx(paramzzdtt, paramzzdtt1, paramzzdtt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzctx
 * JD-Core Version:    0.6.2
 */