package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

final class zzbfv
  implements Runnable
{
  zzbfv(zzbfu paramzzbfu, String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean)
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
      zzbfu.zza(this.zzeia, "onPrecacheEvent", localHashMap);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbfv
 * JD-Core Version:    0.6.2
 */