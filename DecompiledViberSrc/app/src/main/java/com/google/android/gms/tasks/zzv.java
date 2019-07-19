package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

final class zzv
  implements Runnable
{
  zzv(zzu paramzzu, Callable paramCallable)
  {
  }

  public final void run()
  {
    try
    {
      this.zzad.setResult(this.val$callable.call());
      return;
    }
    catch (Exception localException)
    {
      this.zzad.setException(localException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.zzv
 * JD-Core Version:    0.6.2
 */