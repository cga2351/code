package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcva<T>
{
  private final Executor zzfiv;
  private final Set<zzcuz<? extends zzcuy<T>>> zzgih;

  public zzcva(Executor paramExecutor, Set<zzcuz<? extends zzcuy<T>>> paramSet)
  {
    this.zzfiv = paramExecutor;
    this.zzgih = paramSet;
  }

  public final zzbbi<T> zzu(T paramT)
  {
    ArrayList localArrayList = new ArrayList(this.zzgih.size());
    Iterator localIterator = this.zzgih.iterator();
    while (localIterator.hasNext())
    {
      zzcuz localzzcuz = (zzcuz)localIterator.next();
      zzbbi localzzbbi = localzzcuz.zzalm();
      zzaci localzzaci = zzact.zzcqh;
      if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
        localzzbbi.zza(new zzcvb(localzzcuz, zzk.zzln().elapsedRealtime()), zzbbn.zzeah);
      localArrayList.add(localzzbbi);
    }
    return zzbas.zzf(localArrayList).zza(new zzcvc(localArrayList, paramT), this.zzfiv);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcva
 * JD-Core Version:    0.6.2
 */