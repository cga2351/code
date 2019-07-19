package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcht
  implements zzdth<zzchp>
{
  private final zzdtt<Context> zzeol;
  private final zzdtt<Executor> zzfgg;
  private final zzdtt<zzcxu> zzfhq;
  private final zzdtt<zzbaj> zzfwo;

  private zzcht(zzdtt<Context> paramzzdtt, zzdtt<zzbaj> paramzzdtt1, zzdtt<zzcxu> paramzzdtt2, zzdtt<Executor> paramzzdtt3)
  {
    this.zzeol = paramzzdtt;
    this.zzfwo = paramzzdtt1;
    this.zzfhq = paramzzdtt2;
    this.zzfgg = paramzzdtt3;
  }

  public static zzcht zzd(zzdtt<Context> paramzzdtt, zzdtt<zzbaj> paramzzdtt1, zzdtt<zzcxu> paramzzdtt2, zzdtt<Executor> paramzzdtt3)
  {
    return new zzcht(paramzzdtt, paramzzdtt1, paramzzdtt2, paramzzdtt3);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcht
 * JD-Core Version:    0.6.2
 */