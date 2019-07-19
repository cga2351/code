package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

final class zzcib
  implements zzbtj
{
  private final zzavh zzbsr;
  private final Context zzlj;

  zzcib(Context paramContext, zzavh paramzzavh)
  {
    this.zzlj = paramContext;
    this.zzbsr = paramzzavh;
  }

  public final void zza(zzcxt paramzzcxt)
  {
    if (!TextUtils.isEmpty(paramzzcxt.zzgky.zzgku.zzdol))
      this.zzbsr.zzi(this.zzlj, paramzzcxt.zzgky.zzgku.zzdol);
  }

  public final void zzb(zzary paramzzary)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcib
 * JD-Core Version:    0.6.2
 */