package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.atomic.AtomicReference;

public final class zzcsj<S extends zzcuy>
  implements zzcuz<S>
{
  private final Clock zzbsb;
  private final AtomicReference<zzcsk<S>> zzggv = new AtomicReference();
  private final zzcuz<S> zzggw;
  private final long zzggx;

  public zzcsj(zzcuz<S> paramzzcuz, long paramLong, Clock paramClock)
  {
    this.zzbsb = paramClock;
    this.zzggw = paramzzcuz;
    this.zzggx = paramLong;
  }

  public final zzbbi<S> zzalm()
  {
    zzcsk localzzcsk = (zzcsk)this.zzggv.get();
    if ((localzzcsk == null) || (localzzcsk.hasExpired()))
    {
      localzzcsk = new zzcsk(this.zzggw.zzalm(), this.zzggx, this.zzbsb);
      this.zzggv.set(localzzcsk);
    }
    return localzzcsk.zzggy;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcsj
 * JD-Core Version:    0.6.2
 */