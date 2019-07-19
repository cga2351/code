package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Set;

public final class zzcfl
  implements zzdth<zzcfj>
{
  private final zzdtt<Clock> zzfgi;
  private final zzdtt<zzcfh> zzfuv;
  private final zzdtt<Set<zzcfk>> zzfuw;

  private zzcfl(zzdtt<zzcfh> paramzzdtt, zzdtt<Set<zzcfk>> paramzzdtt1, zzdtt<Clock> paramzzdtt2)
  {
    this.zzfuv = paramzzdtt;
    this.zzfuw = paramzzdtt1;
    this.zzfgi = paramzzdtt2;
  }

  public static zzcfl zzk(zzdtt<zzcfh> paramzzdtt, zzdtt<Set<zzcfk>> paramzzdtt1, zzdtt<Clock> paramzzdtt2)
  {
    return new zzcfl(paramzzdtt, paramzzdtt1, paramzzdtt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcfl
 * JD-Core Version:    0.6.2
 */