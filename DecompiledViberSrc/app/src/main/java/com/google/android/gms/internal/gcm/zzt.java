package com.google.android.gms.internal.gcm;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzt extends WeakReference<Throwable>
{
  private final int zzdv;

  public zzt(Throwable paramThrowable, ReferenceQueue<Throwable> paramReferenceQueue)
  {
    super(paramThrowable, paramReferenceQueue);
    if (paramThrowable == null)
      throw new NullPointerException("The referent cannot be null");
    this.zzdv = System.identityHashCode(paramThrowable);
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool = true;
    if ((paramObject == null) || (paramObject.getClass() != getClass()))
      bool = false;
    zzt localzzt;
    do
    {
      do
        return bool;
      while (this == paramObject);
      localzzt = (zzt)paramObject;
    }
    while ((this.zzdv == localzzt.zzdv) && (get() == localzzt.get()));
    return false;
  }

  public final int hashCode()
  {
    return this.zzdv;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gcm.zzt
 * JD-Core Version:    0.6.2
 */