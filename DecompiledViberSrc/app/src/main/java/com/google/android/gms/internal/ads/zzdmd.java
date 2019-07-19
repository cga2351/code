package com.google.android.gms.internal.ads;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzdmd extends WeakReference<Throwable>
{
  private final int zzhca;

  public zzdmd(Throwable paramThrowable, ReferenceQueue<Throwable> paramReferenceQueue)
  {
    super(paramThrowable, paramReferenceQueue);
    if (paramThrowable == null)
      throw new NullPointerException("The referent cannot be null");
    this.zzhca = System.identityHashCode(paramThrowable);
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool = true;
    if ((paramObject == null) || (paramObject.getClass() != getClass()))
      bool = false;
    zzdmd localzzdmd;
    do
    {
      do
        return bool;
      while (this == paramObject);
      localzzdmd = (zzdmd)paramObject;
    }
    while ((this.zzhca == localzzdmd.zzhca) && (get() == localzzdmd.get()));
    return false;
  }

  public final int hashCode()
  {
    return this.zzhca;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdmd
 * JD-Core Version:    0.6.2
 */