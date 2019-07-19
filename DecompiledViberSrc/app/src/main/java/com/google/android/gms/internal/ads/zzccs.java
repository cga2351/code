package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

final class zzccs<T>
  implements zzahn<Object>
{
  private final WeakReference<T> zzfst;
  private final String zzfsu;
  private final zzahn<T> zzfsv;

  private zzccs(WeakReference<T> paramWeakReference, String paramString, zzahn<T> paramzzahn)
  {
    this.zzfst = paramString;
    this.zzfsu = paramzzahn;
    Object localObject;
    this.zzfsv = localObject;
  }

  public final void zza(Object paramObject, Map<String, String> paramMap)
  {
    Object localObject = this.zzfst.get();
    if (localObject == null)
    {
      this.zzfsw.zzb(this.zzfsu, this);
      return;
    }
    this.zzfsv.zza(localObject, paramMap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzccs
 * JD-Core Version:    0.6.2
 */