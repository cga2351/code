package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public final class zzbr extends zzej
{
  private final Object lock = new Object();

  @Nullable
  @GuardedBy("lock")
  private zzav zzcw;

  @Nullable
  @GuardedBy("lock")
  private zzbs zzda;

  public final void zza(int paramInt1, int paramInt2)
  {
    synchronized (this.lock)
    {
      zzbs localzzbs = this.zzda;
      zzav localzzav = new zzav(paramInt1, paramInt2);
      this.zzcw = localzzav;
      if (localzzbs != null)
        localzzbs.zzb(localzzav);
      return;
    }
  }

  public final void zza(zzbs paramzzbs)
  {
    synchronized (this.lock)
    {
      this.zzda = ((zzbs)Preconditions.checkNotNull(paramzzbs));
      zzav localzzav = this.zzcw;
      if (localzzav != null)
        paramzzbs.zzb(localzzav);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbr
 * JD-Core Version:    0.6.2
 */