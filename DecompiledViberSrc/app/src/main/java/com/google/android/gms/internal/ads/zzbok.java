package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewGroup;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public final class zzbok extends zzbne
{
  private final Executor zzffu;
  private final zzafz zzfia;
  private final Runnable zzfib;

  public zzbok(zzafz paramzzafz, Runnable paramRunnable, Executor paramExecutor)
  {
    this.zzfia = paramzzafz;
    this.zzfib = paramRunnable;
    this.zzffu = paramExecutor;
  }

  public final zzaap getVideoController()
  {
    return null;
  }

  public final void zza(ViewGroup paramViewGroup, zzyb paramzzyb)
  {
  }

  public final View zzafi()
  {
    return null;
  }

  public final zzcxm zzafj()
  {
    return null;
  }

  public final int zzafk()
  {
    return 0;
  }

  public final void zzafl()
  {
    zzbol localzzbol = new zzbol(new AtomicReference(this.zzfib));
    this.zzffu.execute(new zzbom(this, localzzbol));
  }

  public final void zzpm()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbok
 * JD-Core Version:    0.6.2
 */