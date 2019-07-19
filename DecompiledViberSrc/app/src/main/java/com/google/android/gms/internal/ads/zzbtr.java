package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

public class zzbtr<ListenerT>
{

  @GuardedBy("this")
  private final Map<ListenerT, Executor> zzfkm = new HashMap();

  protected zzbtr(Set<zzbuy<ListenerT>> paramSet)
  {
    zzb(paramSet);
  }

  private final void zzb(Set<zzbuy<ListenerT>> paramSet)
  {
    try
    {
      Iterator localIterator = paramSet.iterator();
      while (localIterator.hasNext())
        zza((zzbuy)localIterator.next());
    }
    finally
    {
    }
  }

  protected final void zza(zzbtt<ListenerT> paramzzbtt)
  {
    try
    {
      Iterator localIterator = this.zzfkm.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Object localObject2 = localEntry.getKey();
        ((Executor)localEntry.getValue()).execute(new zzbts(paramzzbtt, localObject2));
      }
    }
    finally
    {
    }
  }

  public final void zza(zzbuy<ListenerT> paramzzbuy)
  {
    try
    {
      zza(paramzzbuy.zzflc, paramzzbuy.zzfiv);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(ListenerT paramListenerT, Executor paramExecutor)
  {
    try
    {
      this.zzfkm.put(paramListenerT, paramExecutor);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbtr
 * JD-Core Version:    0.6.2
 */