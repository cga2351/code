package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;
import java.util.Map;

@TargetApi(21)
public class zzaxw extends zzaxv
{
  public final WebResourceResponse zza(String paramString1, String paramString2, int paramInt, String paramString3, Map<String, String> paramMap, InputStream paramInputStream)
  {
    return new WebResourceResponse(paramString1, paramString2, paramInt, paramString3, paramMap, paramInputStream);
  }

  public final zzbhb zza(zzbha paramzzbha, zzwh paramzzwh, boolean paramBoolean)
  {
    return new zzbic(paramzzbha, paramzzwh, paramBoolean);
  }

  public final CookieManager zzaz(Context paramContext)
  {
    if (zzwh())
      return null;
    try
    {
      CookieManager localCookieManager = CookieManager.getInstance();
      return localCookieManager;
    }
    catch (Throwable localThrowable)
    {
      zzaxa.zzc("Failed to obtain CookieManager.", localThrowable);
      zzk.zzlk().zza(localThrowable, "ApiLevelUtil.getCookieManager");
    }
    return null;
  }

  public final int zzwi()
  {
    return 16974374;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaxw
 * JD-Core Version:    0.6.2
 */