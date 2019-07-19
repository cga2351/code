package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzk;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public final class zzbiu
{
  public static zzbha zza(Context paramContext, zzbio paramzzbio, String paramString, boolean paramBoolean1, boolean paramBoolean2, zzdh paramzzdh, zzbaj paramzzbaj, zzadh paramzzadh, zzj paramzzj, zza paramzza, zzwh paramzzwh)
    throws zzbhk
  {
    try
    {
      zzbha localzzbha = (zzbha)zzazm.zzb(new zzbiv(paramContext, paramzzbio, paramString, paramBoolean1, paramBoolean2, paramzzdh, paramzzbaj, null, paramzzj, paramzza, paramzzwh));
      return localzzbha;
    }
    catch (Throwable localThrowable)
    {
      zzk.zzlk().zza(localThrowable, "AdWebViewFactory.newAdWebView2");
      throw new zzbhk("Webview initialization failed.", localThrowable);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbiu
 * JD-Core Version:    0.6.2
 */