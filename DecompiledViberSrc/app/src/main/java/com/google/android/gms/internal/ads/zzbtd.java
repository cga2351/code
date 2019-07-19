package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

final class zzbtd
  implements Runnable
{
  private final WeakReference<zzbta> zzfkj;

  private zzbtd(zzbta paramzzbta)
  {
    this.zzfkj = new WeakReference(paramzzbta);
  }

  public final void run()
  {
    zzbta localzzbta = (zzbta)this.zzfkj.get();
    if (localzzbta != null)
      zzbta.zza(localzzbta);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbtd
 * JD-Core Version:    0.6.2
 */