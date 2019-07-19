package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzj;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public final class zzbhg
{
  public static zzbbi<zzbha> zza(Context paramContext, zzbaj paramzzbaj, String paramString, zzdh paramzzdh, zza paramzza)
  {
    return zzbas.zza(zzbas.zzm(null), new zzbhh(paramContext, paramzzdh, paramzzbaj, paramzza, paramString), zzbbn.zzeag);
  }

  public static zzbha zza(Context paramContext, zzbio paramzzbio, String paramString, boolean paramBoolean1, boolean paramBoolean2, zzdh paramzzdh, zzbaj paramzzbaj, zzadh paramzzadh, zzj paramzzj, zza paramzza, zzwh paramzzwh)
    throws zzbhk
  {
    zzact.initialize(paramContext);
    zzaci localzzaci = zzact.zzcoj;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
      return zzbiu.zza(paramContext, paramzzbio, paramString, paramBoolean1, paramBoolean2, paramzzdh, paramzzbaj, null, paramzzj, paramzza, paramzzwh);
    try
    {
      zzbha localzzbha = (zzbha)zzazm.zzb(new zzbhi(paramContext, paramzzbio, paramString, paramBoolean1, paramBoolean2, paramzzdh, paramzzbaj, null, paramzzj, paramzza, paramzzwh));
      return localzzbha;
    }
    catch (Throwable localThrowable)
    {
      throw new zzbhk("Webview initialization failed.", localThrowable);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbhg
 * JD-Core Version:    0.6.2
 */