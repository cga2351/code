package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

final class zzbdo
  implements zzgh
{
  private WeakReference<zzgh> zzefn = new WeakReference(null);

  private zzbdo(zzbdl paramzzbdl)
  {
  }

  public final void zza(zzgd paramzzgd)
  {
    zzbdl.zza(this.zzefo, "PlayerError", paramzzgd.getMessage());
    zzgh localzzgh = (zzgh)this.zzefn.get();
    if (localzzgh != null)
      localzzgh.zza(paramzzgd);
  }

  public final void zza(boolean paramBoolean, int paramInt)
  {
    zzgh localzzgh = (zzgh)this.zzefn.get();
    if (localzzgh != null)
      localzzgh.zza(paramBoolean, paramInt);
  }

  public final void zzb(zzgh paramzzgh)
  {
    this.zzefn = new WeakReference(paramzzgh);
  }

  public final void zzdo()
  {
    zzgh localzzgh = (zzgh)this.zzefn.get();
    if (localzzgh != null)
      localzzgh.zzdo();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbdo
 * JD-Core Version:    0.6.2
 */