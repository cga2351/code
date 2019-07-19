package com.google.android.gms.dynamite;

import android.content.Context;

final class zze
  implements DynamiteModule.VersionPolicy
{
  public final DynamiteModule.VersionPolicy.zzb zza(Context paramContext, String paramString, DynamiteModule.VersionPolicy.zza paramzza)
    throws DynamiteModule.LoadingException
  {
    DynamiteModule.VersionPolicy.zzb localzzb = new DynamiteModule.VersionPolicy.zzb();
    localzzb.zziq = paramzza.getLocalVersion(paramContext, paramString);
    if (localzzb.zziq != 0);
    for (localzzb.zzir = paramzza.zza(paramContext, paramString, false); (localzzb.zziq == 0) && (localzzb.zzir == 0); localzzb.zzir = paramzza.zza(paramContext, paramString, true))
    {
      localzzb.zzis = 0;
      return localzzb;
    }
    if (localzzb.zziq >= localzzb.zzir)
    {
      localzzb.zzis = -1;
      return localzzb;
    }
    localzzb.zzis = 1;
    return localzzb;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.dynamite.zze
 * JD-Core Version:    0.6.2
 */