package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

final class zzbgc
  implements Runnable
{
  zzbgc(zzbfu paramzzbfu, String paramString1, String paramString2, String paramString3, String paramString4)
  {
  }

  public final void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", "precacheCanceled");
    localHashMap.put("src", this.zzdlk);
    if (!TextUtils.isEmpty(this.zzehw))
      localHashMap.put("cachedSrc", this.zzehw);
    localHashMap.put("type", zzbfu.zza(this.zzeia, this.zzeif));
    localHashMap.put("reason", this.zzeif);
    if (!TextUtils.isEmpty(this.val$message))
      localHashMap.put("message", this.val$message);
    zzbfu.zza(this.zzeia, "onPrecacheEvent", localHashMap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbgc
 * JD-Core Version:    0.6.2
 */