package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Executor;

final class zzbbo
  implements Executor
{
  private final Handler zzeak = new zzaxb(Looper.getMainLooper());

  public final void execute(Runnable paramRunnable)
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
      try
      {
        paramRunnable.run();
        return;
      }
      catch (Throwable localThrowable)
      {
        zzk.zzlg();
        zzaxj.zza(zzk.zzlk().getApplicationContext(), localThrowable);
        throw localThrowable;
      }
    this.zzeak.post(paramRunnable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbbo
 * JD-Core Version:    0.6.2
 */