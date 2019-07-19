package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzcbh
{
  private final Executor zzffu;
  private final zzcxu zzfjp;
  private final zzcdm zzfqh;
  private final Context zzlj;

  public zzcbh(Context paramContext, zzcxu paramzzcxu, Executor paramExecutor, zzcdm paramzzcdm)
  {
    this.zzlj = paramContext;
    this.zzfjp = paramzzcxu;
    this.zzffu = paramExecutor;
    this.zzfqh = paramzzcdm;
  }

  private final void zzj(zzbha paramzzbha)
  {
    paramzzbha.zza("/video", zzagy.zzdab);
    paramzzbha.zza("/videoMeta", zzagy.zzdac);
    paramzzbha.zza("/precache", new zzbgd());
    paramzzbha.zza("/delayPageLoaded", zzagy.zzdaf);
    paramzzbha.zza("/instrument", zzagy.zzdad);
    paramzzbha.zza("/log", zzagy.zzczw);
    paramzzbha.zza("/videoClicked", zzagy.zzczx);
    paramzzbha.zzaai().zzau(true);
    if (this.zzfjp.zzdng != null)
      paramzzbha.zza("/open", new zzahr(null, null));
  }

  public final zzbbi<zzbha> zzm(JSONObject paramJSONObject)
  {
    return zzbas.zza(zzbas.zza(zzbas.zzm(null), new zzcbk(this), this.zzffu), new zzcbi(this, paramJSONObject), this.zzffu);
  }

  public final zzbbi<zzbha> zzq(String paramString1, String paramString2)
  {
    return zzbas.zza(zzbas.zzm(null), new zzcbj(this, paramString1, paramString2), this.zzffu);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcbh
 * JD-Core Version:    0.6.2
 */