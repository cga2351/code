package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;

public final class zzbma
  implements zzblt
{
  private final Context zzlj;

  public zzbma(Context paramContext)
  {
    this.zzlj = paramContext;
  }

  public final void zzk(Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("cookie");
    if (!TextUtils.isEmpty(str))
    {
      CookieManager localCookieManager = zzk.zzli().zzaz(this.zzlj);
      if (localCookieManager != null)
        localCookieManager.setCookie("googleads.g.doubleclick.net", str);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbma
 * JD-Core Version:    0.6.2
 */