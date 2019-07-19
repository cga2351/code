package com.google.android.gms.internal.measurement;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzsu extends WeakReference<Throwable>
{
  private final int zzbsk;

  public zzsu(Throwable paramThrowable, ReferenceQueue<Throwable> paramReferenceQueue)
  {
    super(paramThrowable, null);
    if (paramThrowable == null)
      throw new NullPointerException("The referent cannot be null");
    this.zzbsk = System.identityHashCode(paramThrowable);
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool = true;
    if ((paramObject == null) || (paramObject.getClass() != getClass()))
      bool = false;
    zzsu localzzsu;
    do
    {
      do
        return bool;
      while (this == paramObject);
      localzzsu = (zzsu)paramObject;
    }
    while ((this.zzbsk == localzzsu.zzbsk) && (get() == localzzsu.get()));
    return false;
  }

  public final int hashCode()
  {
    return this.zzbsk;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzsu
 * JD-Core Version:    0.6.2
 */