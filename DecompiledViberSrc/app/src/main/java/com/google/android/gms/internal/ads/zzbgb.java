package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

final class zzbgb
  implements Runnable
{
  zzbgb(zzbfu paramzzbfu, String paramString1, String paramString2, long paramLong)
  {
  }

  public final void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", "precacheComplete");
    localHashMap.put("src", this.zzdlk);
    localHashMap.put("cachedSrc", this.zzehw);
    localHashMap.put("totalDuration", Long.toString(this.zzeie));
    zzbfu.zza(this.zzeia, "onPrecacheEvent", localHashMap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbgb
 * JD-Core Version:    0.6.2
 */