package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

final class zzbga
  implements Runnable
{
  zzbga(zzbfu paramzzbfu, String paramString1, String paramString2, int paramInt)
  {
  }

  public final void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", "precacheComplete");
    localHashMap.put("src", this.zzdlk);
    localHashMap.put("cachedSrc", this.zzehw);
    localHashMap.put("totalBytes", Integer.toString(this.zzehy));
    zzbfu.zza(this.zzeia, "onPrecacheEvent", localHashMap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbga
 * JD-Core Version:    0.6.2
 */