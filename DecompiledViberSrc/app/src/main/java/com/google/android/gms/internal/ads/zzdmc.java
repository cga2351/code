package com.google.android.gms.internal.ads;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class zzdmc
{
  private final ConcurrentHashMap<zzdmd, List<Throwable>> zzhby = new ConcurrentHashMap(16, 0.75F, 10);
  private final ReferenceQueue<Throwable> zzhbz = new ReferenceQueue();

  public final List<Throwable> zza(Throwable paramThrowable, boolean paramBoolean)
  {
    for (Reference localReference = this.zzhbz.poll(); localReference != null; localReference = this.zzhbz.poll())
      this.zzhby.remove(localReference);
    zzdmd localzzdmd = new zzdmd(paramThrowable, null);
    List localList = (List)this.zzhby.get(localzzdmd);
    if (!paramBoolean);
    Vector localVector;
    do
    {
      do
        return localList;
      while (localList != null);
      localVector = new Vector(2);
      localList = (List)this.zzhby.putIfAbsent(new zzdmd(paramThrowable, this.zzhbz), localVector);
    }
    while (localList != null);
    return localVector;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdmc
 * JD-Core Version:    0.6.2
 */