package com.google.android.gms.internal.ads;

import android.os.Handler;

@zzare
final class zzbdi
  implements Runnable
{
  private boolean zzbuu = false;
  private zzbcr zzecs;

  zzbdi(zzbcr paramzzbcr)
  {
    this.zzecs = paramzzbcr;
  }

  private final void zzyn()
  {
    zzaxj.zzdvx.removeCallbacks(this);
    zzaxj.zzdvx.postDelayed(this, 250L);
  }

  public final void pause()
  {
    this.zzbuu = true;
    this.zzecs.zzxt();
  }

  public final void resume()
  {
    this.zzbuu = false;
    zzyn();
  }

  public final void run()
  {
    if (!this.zzbuu)
    {
      this.zzecs.zzxt();
      zzyn();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbdi
 * JD-Core Version:    0.6.2
 */