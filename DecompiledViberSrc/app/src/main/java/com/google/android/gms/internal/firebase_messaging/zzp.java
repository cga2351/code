package com.google.android.gms.internal.firebase_messaging;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class zzp
{
  private final ConcurrentHashMap<zzo, List<Throwable>> zzn = new ConcurrentHashMap(16, 0.75F, 10);
  private final ReferenceQueue<Throwable> zzo = new ReferenceQueue();

  public final List<Throwable> zza(Throwable paramThrowable, boolean paramBoolean)
  {
    for (Reference localReference = this.zzo.poll(); localReference != null; localReference = this.zzo.poll())
      this.zzn.remove(localReference);
    zzo localzzo = new zzo(paramThrowable, null);
    List localList = (List)this.zzn.get(localzzo);
    if (localList != null);
    Vector localVector;
    do
    {
      return localList;
      localVector = new Vector(2);
      localList = (List)this.zzn.putIfAbsent(new zzo(paramThrowable, this.zzo), localVector);
    }
    while (localList != null);
    return localVector;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.firebase_messaging.zzp
 * JD-Core Version:    0.6.2
 */