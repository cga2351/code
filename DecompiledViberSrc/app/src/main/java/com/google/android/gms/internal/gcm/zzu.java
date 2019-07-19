package com.google.android.gms.internal.gcm;

import java.util.List;

final class zzu extends zzr
{
  private final zzs zzdw = new zzs();

  public final void zzd(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    if (paramThrowable2 == paramThrowable1)
      throw new IllegalArgumentException("Self suppression is not allowed.", paramThrowable2);
    if (paramThrowable2 == null)
      throw new NullPointerException("The suppressed exception cannot be null.");
    this.zzdw.zzd(paramThrowable1, true).add(paramThrowable2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gcm.zzu
 * JD-Core Version:    0.6.2
 */