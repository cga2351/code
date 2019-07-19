package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

public final class zzi
  implements zzab
{
  private final Executor zzv;

  public zzi(Handler paramHandler)
  {
    this.zzv = new zzj(this, paramHandler);
  }

  public final void zza(zzr<?> paramzzr, zzaf paramzzaf)
  {
    paramzzr.zzb("post-error");
    zzy localzzy = zzy.zzc(paramzzaf);
    this.zzv.execute(new zzk(paramzzr, localzzy, null));
  }

  public final void zza(zzr<?> paramzzr, zzy<?> paramzzy, Runnable paramRunnable)
  {
    paramzzr.zzk();
    paramzzr.zzb("post-response");
    this.zzv.execute(new zzk(paramzzr, paramzzy, paramRunnable));
  }

  public final void zzb(zzr<?> paramzzr, zzy<?> paramzzy)
  {
    zza(paramzzr, paramzzy, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzi
 * JD-Core Version:    0.6.2
 */