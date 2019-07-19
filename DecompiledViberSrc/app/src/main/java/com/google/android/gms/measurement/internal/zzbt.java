package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzbt
  implements Thread.UncaughtExceptionHandler
{
  private final String zzapd;

  public zzbt(zzbr paramzzbr, String paramString)
  {
    Preconditions.checkNotNull(paramString);
    this.zzapd = paramString;
  }

  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      this.zzape.zzgt().zzjg().zzg(this.zzapd, paramThrowable);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzbt
 * JD-Core Version:    0.6.2
 */