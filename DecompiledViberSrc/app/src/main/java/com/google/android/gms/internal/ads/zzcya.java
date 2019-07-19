package com.google.android.gms.internal.ads;

import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;
import javax.annotation.concurrent.GuardedBy;

public final class zzcya<T>
{
  private final zzbbm zzfqw;

  @GuardedBy("this")
  private final Deque<zzbbi<T>> zzglk = new LinkedBlockingDeque();
  private final Callable<T> zzgll;

  public zzcya(Callable<T> paramCallable, zzbbm paramzzbbm)
  {
    this.zzgll = paramCallable;
    this.zzfqw = paramzzbbm;
  }

  public final void zza(zzbbi<T> paramzzbbi)
  {
    try
    {
      this.zzglk.addFirst(paramzzbbi);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final zzbbi<T> zzamr()
  {
    try
    {
      zzdq(1);
      zzbbi localzzbbi = (zzbbi)this.zzglk.poll();
      return localzzbbi;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzdq(int paramInt)
  {
    try
    {
      int i = paramInt - this.zzglk.size();
      for (int j = 0; j < i; j++)
        this.zzglk.add(this.zzfqw.zza(this.zzgll));
      return;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcya
 * JD-Core Version:    0.6.2
 */