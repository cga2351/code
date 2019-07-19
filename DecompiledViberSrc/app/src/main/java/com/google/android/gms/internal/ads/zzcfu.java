package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcfu
  implements zzdth<Set<zzbuy<AppEventListener>>>
{
  private final zzdtt<Executor> zzfgg;
  private final zzdtt<zzcfy> zzfuc;
  private final zzcfo zzfux;

  private zzcfu(zzcfo paramzzcfo, zzdtt<zzcfy> paramzzdtt, zzdtt<Executor> paramzzdtt1)
  {
    this.zzfux = paramzzcfo;
    this.zzfuc = paramzzdtt;
    this.zzfgg = paramzzdtt1;
  }

  public static zzcfu zzf(zzcfo paramzzcfo, zzdtt<zzcfy> paramzzdtt, zzdtt<Executor> paramzzdtt1)
  {
    return new zzcfu(paramzzcfo, paramzzdtt, paramzzdtt1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcfu
 * JD-Core Version:    0.6.2
 */