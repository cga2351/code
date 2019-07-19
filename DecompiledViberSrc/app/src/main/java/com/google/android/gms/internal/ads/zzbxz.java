package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

final class zzbxz
  implements zzahn<Object>
{
  private WeakReference<zzbxw> zzfnf;

  private zzbxz(zzbxw paramzzbxw)
  {
    this.zzfnf = new WeakReference(paramzzbxw);
  }

  public final void zza(Object paramObject, Map<String, String> paramMap)
  {
    zzbxw localzzbxw = (zzbxw)this.zzfnf.get();
    if (localzzbxw == null)
      return;
    zzbxw.zza(localzzbxw).onAdImpression();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbxz
 * JD-Core Version:    0.6.2
 */