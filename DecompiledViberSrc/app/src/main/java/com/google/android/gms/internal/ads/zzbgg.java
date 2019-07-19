package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

@zzare
public final class zzbgg extends zzbfu
{
  public zzbgg(zzbdg paramzzbdg)
  {
    super(paramzzbdg);
  }

  public final void abort()
  {
  }

  public final boolean zzex(String paramString)
  {
    zzbdg localzzbdg = (zzbdg)this.zzehv.get();
    if (localzzbdg != null)
      localzzbdg.zza(zzey(paramString), this);
    zzaxa.zzep("VideoStreamNoopCache is doing nothing.");
    zza(paramString, zzey(paramString), "noop", "Noop cache is a noop.");
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbgg
 * JD-Core Version:    0.6.2
 */