package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzcon
  implements zzf
{
  private final zzbvc zzfgz;
  private final zzbrs zzfmr;
  private final zzbrh zzfms;
  private final zzbmm zzfmt;
  private final zzbuz zzfmv;
  private AtomicBoolean zzgcs = new AtomicBoolean(false);

  zzcon(zzbrh paramzzbrh, zzbrs paramzzbrs, zzbvc paramzzbvc, zzbuz paramzzbuz, zzbmm paramzzbmm)
  {
    this.zzfms = paramzzbrh;
    this.zzfmr = paramzzbrs;
    this.zzfgz = paramzzbvc;
    this.zzfmv = paramzzbuz;
    this.zzfmt = paramzzbmm;
  }

  public final void zzg(View paramView)
  {
    try
    {
      boolean bool = this.zzgcs.compareAndSet(false, true);
      if (!bool);
      while (true)
      {
        return;
        this.zzfmt.onAdImpression();
        this.zzfmv.zzq(paramView);
      }
    }
    finally
    {
    }
  }

  public final void zzky()
  {
    if (this.zzgcs.get())
      this.zzfms.onAdClicked();
  }

  public final void zzkz()
  {
    if (this.zzgcs.get())
    {
      this.zzfmr.onAdImpression();
      this.zzfgz.zzagx();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcon
 * JD-Core Version:    0.6.2
 */