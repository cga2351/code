package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.CapabilityInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzgk
{
  private static Map<String, CapabilityInfo> zza(List<zzah> paramList)
  {
    HashMap localHashMap = new HashMap();
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        zzah localzzah = (zzah)localIterator.next();
        localHashMap.put(localzzah.getName(), new zzw(localzzah));
      }
    }
    return localHashMap;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgk
 * JD-Core Version:    0.6.2
 */