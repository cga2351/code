package com.google.android.gms.internal.gcm;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class zzs
{
  private final ConcurrentHashMap<zzt, List<Throwable>> zzdt = new ConcurrentHashMap(16, 0.75F, 10);
  private final ReferenceQueue<Throwable> zzdu = new ReferenceQueue();

  public final List<Throwable> zzd(Throwable paramThrowable, boolean paramBoolean)
  {
    for (Reference localReference = this.zzdu.poll(); localReference != null; localReference = this.zzdu.poll())
      this.zzdt.remove(localReference);
    zzt localzzt = new zzt(paramThrowable, null);
    List localList = (List)this.zzdt.get(localzzt);
    if (localList != null);
    Vector localVector;
    do
    {
      return localList;
      localVector = new Vector(2);
      localList = (List)this.zzdt.putIfAbsent(new zzt(paramThrowable, this.zzdu), localVector);
    }
    while (localList != null);
    return localVector;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gcm.zzs
 * JD-Core Version:    0.6.2
 */