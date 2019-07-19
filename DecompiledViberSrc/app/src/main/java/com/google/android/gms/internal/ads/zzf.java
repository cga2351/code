package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

final class zzf
  implements zzt
{
  private final Map<String, List<zzr<?>>> zzp = new HashMap();
  private final zzd zzq;

  zzf(zzd paramzzd)
  {
    this.zzq = paramzzd;
  }

  private final boolean zzb(zzr<?> paramzzr)
  {
    try
    {
      String str = paramzzr.zze();
      boolean bool2;
      if (this.zzp.containsKey(str))
      {
        Object localObject2 = (List)this.zzp.get(str);
        if (localObject2 == null)
          localObject2 = new ArrayList();
        paramzzr.zzb("waiting-for-response");
        ((List)localObject2).add(paramzzr);
        this.zzp.put(str, localObject2);
        if (zzag.DEBUG)
          zzag.d("Request for cacheKey=%s is in flight, putting on hold.", new Object[] { str });
        bool2 = true;
      }
      while (true)
      {
        return bool2;
        this.zzp.put(str, null);
        paramzzr.zza(this);
        boolean bool1 = zzag.DEBUG;
        bool2 = false;
        if (bool1)
        {
          zzag.d("new request, sending to network %s", new Object[] { str });
          bool2 = false;
        }
      }
    }
    finally
    {
    }
  }

  public final void zza(zzr<?> paramzzr)
  {
    try
    {
      String str = paramzzr.zze();
      List localList = (List)this.zzp.remove(str);
      zzr localzzr;
      if ((localList != null) && (!localList.isEmpty()))
      {
        if (zzag.DEBUG)
        {
          Object[] arrayOfObject2 = new Object[2];
          arrayOfObject2[0] = Integer.valueOf(localList.size());
          arrayOfObject2[1] = str;
          zzag.v("%d waiting requests for cacheKey=%s; resend to network", arrayOfObject2);
        }
        localzzr = (zzr)localList.remove(0);
        this.zzp.put(str, localList);
        localzzr.zza(this);
      }
      try
      {
        zzd.zza(this.zzq).put(localzzr);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        while (true)
        {
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = localInterruptedException.toString();
          zzag.e("Couldn't add request to queue. %s", arrayOfObject1);
          Thread.currentThread().interrupt();
          this.zzq.quit();
        }
      }
    }
    finally
    {
    }
  }

  public final void zza(zzr<?> paramzzr, zzy<?> paramzzy)
  {
    if ((paramzzy.zzbh == null) || (paramzzy.zzbh.isExpired()))
      zza(paramzzr);
    while (true)
    {
      return;
      String str = paramzzr.zze();
      try
      {
        List localList = (List)this.zzp.remove(str);
        if (localList == null)
          continue;
        if (zzag.DEBUG)
        {
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = Integer.valueOf(localList.size());
          arrayOfObject[1] = str;
          zzag.v("Releasing %d waiting requests for cacheKey=%s.", arrayOfObject);
        }
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          zzr localzzr = (zzr)localIterator.next();
          zzd.zzb(this.zzq).zzb(localzzr, paramzzy);
        }
      }
      finally
      {
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzf
 * JD-Core Version:    0.6.2
 */