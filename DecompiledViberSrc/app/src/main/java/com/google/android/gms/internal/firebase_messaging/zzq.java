package com.google.android.gms.internal.firebase_messaging;

import java.util.List;

final class zzq extends zzm
{
  private final zzp zzp = new zzp();

  public final void zza(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    if (paramThrowable2 == paramThrowable1)
      throw new IllegalArgumentException("Self suppression is not allowed.", paramThrowable2);
    if (paramThrowable2 == null)
      throw new NullPointerException("The suppressed exception cannot be null.");
    this.zzp.zza(paramThrowable1, true).add(paramThrowable2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.firebase_messaging.zzq
 * JD-Core Version:    0.6.2
 */