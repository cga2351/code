package com.google.android.gms.internal.ads;

final class zzaqz
  implements Thread.UncaughtExceptionHandler
{
  zzaqz(zzaqy paramzzaqy, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
  }

  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      this.zzdlh.zza(paramThread, paramThrowable);
      return;
    }
    catch (Throwable localThrowable)
    {
      zzbae.zzen("AdMob exception reporter failed reporting the exception.");
      return;
    }
    finally
    {
      if (this.zzdlg != null)
        this.zzdlg.uncaughtException(paramThread, paramThrowable);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaqz
 * JD-Core Version:    0.6.2
 */