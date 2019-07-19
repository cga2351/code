package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;

final class zzbu<V> extends FutureTask<V>
  implements Comparable<zzbu>
{
  private final String zzapd;
  private final long zzapf;
  final boolean zzapg;

  zzbu(zzbr paramzzbr, Runnable paramRunnable, boolean paramBoolean, String paramString)
  {
    super(paramRunnable, null);
    Preconditions.checkNotNull(paramString);
    this.zzapf = zzbr.zzkh().getAndIncrement();
    this.zzapd = paramString;
    this.zzapg = false;
    if (this.zzapf == 9223372036854775807L)
      paramzzbr.zzgt().zzjg().zzby("Tasks index overflow");
  }

  zzbu(Callable<V> paramCallable, boolean paramBoolean, String paramString)
  {
    super(paramBoolean);
    Object localObject;
    Preconditions.checkNotNull(localObject);
    this.zzapf = zzbr.zzkh().getAndIncrement();
    this.zzapd = localObject;
    this.zzapg = paramString;
    if (this.zzapf == 9223372036854775807L)
      paramCallable.zzgt().zzjg().zzby("Tasks index overflow");
  }

  protected final void setException(Throwable paramThrowable)
  {
    this.zzape.zzgt().zzjg().zzg(this.zzapd, paramThrowable);
    if ((paramThrowable instanceof zzbs))
      Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), paramThrowable);
    super.setException(paramThrowable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzbu
 * JD-Core Version:    0.6.2
 */