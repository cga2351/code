package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public final class zzcrd
  implements zzcuz<zzcrc>
{
  private final zzcxu zzfjp;
  private final zzbbm zzgfz;
  private final View zzgga;
  private final Context zzlj;

  public zzcrd(zzbbm paramzzbbm, Context paramContext, zzcxu paramzzcxu, ViewGroup paramViewGroup)
  {
    this.zzgfz = paramzzbbm;
    this.zzlj = paramContext;
    this.zzfjp = paramzzcxu;
    this.zzgga = paramViewGroup;
  }

  public final zzbbi<zzcrc> zzalm()
  {
    zzaci localzzaci = zzact.zzcns;
    if (!((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
      return zzbas.zzd(new Exception("Ad Key signal disabled."));
    return this.zzgfz.zza(new zzcre(this));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcrd
 * JD-Core Version:    0.6.2
 */