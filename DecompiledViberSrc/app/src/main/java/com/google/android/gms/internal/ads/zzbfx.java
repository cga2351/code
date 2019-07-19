package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

final class zzbfx
  implements Runnable
{
  zzbfx(zzbfu paramzzbfu, String paramString1, String paramString2, long paramLong1, long paramLong2, boolean paramBoolean)
  {
  }

  public final void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", "precacheProgress");
    localHashMap.put("src", this.zzdlk);
    localHashMap.put("cachedSrc", this.zzehw);
    localHashMap.put("bufferedDuration", Long.toString(this.zzeid));
    localHashMap.put("totalDuration", Long.toString(this.zzeie));
    if (this.zzehz);
    for (String str = "1"; ; str = "0")
    {
      localHashMap.put("cacheReady", str);
      zzbfu.zza(this.zzeia, "onPrecacheEvent", localHashMap);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbfx
 * JD-Core Version:    0.6.2
 */