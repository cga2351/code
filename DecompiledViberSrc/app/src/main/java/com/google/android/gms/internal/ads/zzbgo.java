package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@zzare
final class zzbgo
{
  private final ArrayList<zzsa> zzeit = new ArrayList();
  private long zzeiu;

  final void zza(zzsa paramzzsa)
  {
    this.zzeit.add(paramzzsa);
  }

  final long zzzz()
  {
    Iterator localIterator1 = this.zzeit.iterator();
    while (localIterator1.hasNext())
    {
      Map localMap = ((zzsa)localIterator1.next()).getResponseHeaders();
      if (localMap != null)
      {
        Iterator localIterator2 = localMap.entrySet().iterator();
        while (localIterator2.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator2.next();
          try
          {
            if ("content-length".equalsIgnoreCase((String)localEntry.getKey()))
            {
              long l = Long.parseLong((String)((List)localEntry.getValue()).get(0));
              this.zzeiu = Math.max(this.zzeiu, l);
            }
          }
          catch (RuntimeException localRuntimeException)
          {
          }
        }
        localIterator1.remove();
      }
    }
    return this.zzeiu;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbgo
 * JD-Core Version:    0.6.2
 */