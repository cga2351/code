package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzbpu
  implements zzo
{
  private final zzbsd zzfjg;
  private AtomicBoolean zzfjh = new AtomicBoolean(false);

  public zzbpu(zzbsd paramzzbsd)
  {
    this.zzfjg = paramzzbsd;
  }

  public final boolean isClosed()
  {
    return this.zzfjh.get();
  }

  public final void onPause()
  {
  }

  public final void onResume()
  {
  }

  public final void zzsz()
  {
    this.zzfjh.set(true);
    this.zzfjg.onAdClosed();
  }

  public final void zzta()
  {
    this.zzfjg.onAdOpened();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbpu
 * JD-Core Version:    0.6.2
 */