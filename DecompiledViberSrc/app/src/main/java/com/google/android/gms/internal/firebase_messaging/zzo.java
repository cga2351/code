package com.google.android.gms.internal.firebase_messaging;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzo extends WeakReference<Throwable>
{
  private final int zzm;

  public zzo(Throwable paramThrowable, ReferenceQueue<Throwable> paramReferenceQueue)
  {
    super(paramThrowable, paramReferenceQueue);
    if (paramThrowable == null)
      throw new NullPointerException("The referent cannot be null");
    this.zzm = System.identityHashCode(paramThrowable);
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool = true;
    if ((paramObject == null) || (paramObject.getClass() != getClass()))
      bool = false;
    zzo localzzo;
    do
    {
      do
        return bool;
      while (this == paramObject);
      localzzo = (zzo)paramObject;
    }
    while ((this.zzm == localzzo.zzm) && (get() == localzzo.get()));
    return false;
  }

  public final int hashCode()
  {
    return this.zzm;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.firebase_messaging.zzo
 * JD-Core Version:    0.6.2
 */