package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;

@zzare
public final class zzawh
  implements zzawj
{
  public final zzbbi<String> zza(String paramString, PackageInfo paramPackageInfo)
  {
    return zzbas.zzm(paramString);
  }

  public final zzbbi<AdvertisingIdClient.Info> zzag(Context paramContext)
  {
    zzbbs localzzbbs = new zzbbs();
    zzyr.zzpa();
    if (zzazu.zzbg(paramContext))
      zzaxh.zzc(new zzawi(this, paramContext, localzzbbs));
    return localzzbbs;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzawh
 * JD-Core Version:    0.6.2
 */