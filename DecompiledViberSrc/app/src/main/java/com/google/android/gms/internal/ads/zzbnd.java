package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

public final class zzbnd
  implements zzdth<zzbta>
{
  private final zzdtt<Clock> zzfgi;
  private final zzdtt<ScheduledExecutorService> zzfgv;

  public zzbnd(zzdtt<ScheduledExecutorService> paramzzdtt, zzdtt<Clock> paramzzdtt1)
  {
    this.zzfgv = paramzzdtt;
    this.zzfgi = paramzzdtt1;
  }

  public static zzbta zza(ScheduledExecutorService paramScheduledExecutorService, Clock paramClock)
  {
    return (zzbta)zzdtn.zza(new zzbta(paramScheduledExecutorService, paramClock), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbnd
 * JD-Core Version:    0.6.2
 */