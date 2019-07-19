package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

public final class zzchk extends zzchi
{
  private static final Pattern zzfwx = Pattern.compile("Received error HTTP response code: (.*)");
  private final ScheduledExecutorService zzfiw;
  private final zzcxu zzfjp;
  private final zzbbm zzfqw;
  private final zzcgm zzfwv;
  private final zzcjh zzfww;

  zzchk(zzbtf paramzzbtf, zzcxu paramzzcxu, zzcgm paramzzcgm, zzbbm paramzzbbm, ScheduledExecutorService paramScheduledExecutorService, zzcjh paramzzcjh)
  {
    super(paramzzbtf);
    this.zzfjp = paramzzcxu;
    this.zzfwv = paramzzcgm;
    this.zzfqw = paramzzbbm;
    this.zzfiw = paramScheduledExecutorService;
    this.zzfww = paramzzcjh;
  }

  public final zzbbi<zzcxt> zze(zzary paramzzary)
    throws zzcgl
  {
    zzbbi localzzbbi1 = zzbas.zza(this.zzfwv.zzc(paramzzary), new zzchl(this), this.zzfqw);
    zzaci localzzaci1 = zzact.zzcvn;
    zzaci localzzaci2;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci1)).booleanValue())
      localzzaci2 = zzact.zzcvo;
    for (zzbbi localzzbbi2 = zzbas.zza(zzbas.zza(localzzbbi1, ((Integer)zzyr.zzpe().zzd(localzzaci2)).intValue(), TimeUnit.SECONDS, this.zzfiw), TimeoutException.class, zzchm.zzbra, zzbbn.zzeah); ; localzzbbi2 = localzzbbi1)
    {
      zzbas.zza(localzzbbi2, new zzchn(this), zzbbn.zzeah);
      return localzzbbi2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzchk
 * JD-Core Version:    0.6.2
 */