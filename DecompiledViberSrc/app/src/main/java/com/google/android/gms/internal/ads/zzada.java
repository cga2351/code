package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;

@zzare
public final class zzada
{
  public static boolean zza(zzadh paramzzadh, zzadf paramzzadf, String[] paramArrayOfString)
  {
    if ((paramzzadh == null) || (paramzzadf == null));
    while ((!paramzzadh.zzcxq) || (paramzzadf == null))
      return false;
    return paramzzadh.zza(paramzzadf, zzk.zzln().elapsedRealtime(), paramArrayOfString);
  }

  public static zzadf zzb(zzadh paramzzadh)
  {
    if (paramzzadh == null)
      return null;
    return paramzzadh.zzfa(zzk.zzln().elapsedRealtime());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzada
 * JD-Core Version:    0.6.2
 */