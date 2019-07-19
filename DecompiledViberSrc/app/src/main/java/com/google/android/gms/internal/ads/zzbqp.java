package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeUnit;

public final class zzbqp
{
  public static <T> zzbbi<T> zza(zzczs paramzzczs, zzbbi<zzcxt> paramzzbbi, zzblr paramzzblr, zzcmw<T> paramzzcmw)
  {
    zzaci localzzaci1 = zzact.zzcvn;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci1)).booleanValue())
      return paramzzczs.zza(zzczr.zzgmw, paramzzbbi).zza(paramzzblr).zza(paramzzcmw).zzane();
    zzczk localzzczk = paramzzczs.zza(zzczr.zzgmw, paramzzbbi).zza(paramzzblr).zza(paramzzcmw);
    zzaci localzzaci2 = zzact.zzcvo;
    return localzzczk.zza(((Integer)zzyr.zzpe().zzd(localzzaci2)).intValue(), TimeUnit.SECONDS).zzane();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbqp
 * JD-Core Version:    0.6.2
 */