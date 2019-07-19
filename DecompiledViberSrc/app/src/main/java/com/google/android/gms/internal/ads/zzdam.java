package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
public final class zzdam
{
  private final Looper zzgob;
  private final Context zzlj;

  public zzdam(Context paramContext, Looper paramLooper)
  {
    this.zzlj = paramContext;
    this.zzgob = paramLooper;
  }

  public final void zzgb(String paramString)
  {
    zzdat localzzdat = (zzdat)zzdat.zzank().zzge(this.zzlj.getPackageName()).zzb(zzdat.zzb.zzgos).zzb(zzdao.zzani().zzgd(paramString).zzb(zzdao.zza.zzgol)).zzaya();
    new zzdan(this.zzlj, this.zzgob, localzzdat).zzanh();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdam
 * JD-Core Version:    0.6.2
 */