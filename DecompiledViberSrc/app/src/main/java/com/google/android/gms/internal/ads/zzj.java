package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

final class zzj
  implements Executor
{
  zzj(zzi paramzzi, Handler paramHandler)
  {
  }

  public final void execute(Runnable paramRunnable)
  {
    this.val$handler.post(paramRunnable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzj
 * JD-Core Version:    0.6.2
 */