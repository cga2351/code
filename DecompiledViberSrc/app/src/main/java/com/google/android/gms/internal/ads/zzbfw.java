package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

final class zzbfw
  implements Runnable
{
  zzbfw(zzbfu paramzzbfu, String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
  }

  public final void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", "precacheProgress");
    localHashMap.put("src", this.zzdlk);
    localHashMap.put("cachedSrc", this.zzehw);
    localHashMap.put("bytesLoaded", Integer.toString(this.zzehx));
    localHashMap.put("totalBytes", Integer.toString(this.zzehy));
    if (this.zzehz);
    for (String str = "1"; ; str = "0")
    {
      localHashMap.put("cacheReady", str);
      localHashMap.put("playerCount", Integer.toString(this.zzeib));
      localHashMap.put("playerPreparedCount", Integer.toString(this.zzeic));
      zzbfu.zza(this.zzeia, "onPrecacheEvent", localHashMap);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbfw
 * JD-Core Version:    0.6.2
 */