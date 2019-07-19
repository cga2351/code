package com.google.android.gms.common.util.concurrent;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.common.zze;
import java.util.concurrent.Executor;

@KeepForSdk
public class HandlerExecutor
  implements Executor
{
  private final Handler handler;

  @KeepForSdk
  public HandlerExecutor(Looper paramLooper)
  {
    this.handler = new zze(paramLooper);
  }

  public void execute(Runnable paramRunnable)
  {
    this.handler.post(paramRunnable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.concurrent.HandlerExecutor
 * JD-Core Version:    0.6.2
 */