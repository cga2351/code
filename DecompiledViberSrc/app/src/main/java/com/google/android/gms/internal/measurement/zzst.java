package com.google.android.gms.internal.measurement;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

final class zzst
{
  private final ConcurrentHashMap<zzsu, List<Throwable>> zzbsi = new ConcurrentHashMap(16, 0.75F, 10);
  private final ReferenceQueue<Throwable> zzbsj = new ReferenceQueue();

  public final List<Throwable> zza(Throwable paramThrowable, boolean paramBoolean)
  {
    for (Reference localReference = this.zzbsj.poll(); localReference != null; localReference = this.zzbsj.poll())
      this.zzbsi.remove(localReference);
    zzsu localzzsu = new zzsu(paramThrowable, null);
    return (List)this.zzbsi.get(localzzsu);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzst
 * JD-Core Version:    0.6.2
 */