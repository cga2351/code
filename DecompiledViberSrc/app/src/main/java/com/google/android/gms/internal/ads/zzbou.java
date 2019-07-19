package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

public final class zzbou
  implements zzbsq, zzuc
{
  private final zzcxl zzffe;
  private final zzbrs zzfii;
  private final AtomicBoolean zzfij = new AtomicBoolean();

  public zzbou(zzcxl paramzzcxl, zzbrs paramzzbrs)
  {
    this.zzffe = paramzzcxl;
    this.zzfii = paramzzbrs;
  }

  private final void zzafw()
  {
    if (this.zzfij.compareAndSet(false, true))
      this.zzfii.onAdImpression();
  }

  public final void onAdLoaded()
  {
    try
    {
      if (this.zzffe.zzgjz != 1)
        zzafw();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzub paramzzub)
  {
    if ((this.zzffe.zzgjz == 1) && (paramzzub.zzbtl))
      zzafw();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbou
 * JD-Core Version:    0.6.2
 */