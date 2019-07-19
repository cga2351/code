package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.lang.ref.WeakReference;

public final class zzbzs
{
  private final zzbza zzfno;
  private final zzcci zzfpz;
  private final zzcdm zzfqh;
  private final zzbmx zzfqi;
  private final Context zzlj;

  public zzbzs(Context paramContext, zzcdm paramzzcdm, zzcci paramzzcci, zzbmx paramzzbmx, zzbza paramzzbza)
  {
    this.zzlj = paramContext;
    this.zzfqh = paramzzcdm;
    this.zzfpz = paramzzcci;
    this.zzfqi = paramzzbmx;
    this.zzfno = paramzzbza;
  }

  public final View zzajb()
    throws zzbhk
  {
    zzbha localzzbha = this.zzfqh.zzc(zzyb.zzg(this.zzlj));
    localzzbha.getView().setVisibility(8);
    localzzbha.zza("/sendMessageToSdk", new zzbzt(this));
    localzzbha.zza("/adMuted", new zzbzu(this));
    this.zzfpz.zza(new WeakReference(localzzbha), "/loadHtml", new zzbzv(this));
    this.zzfpz.zza(new WeakReference(localzzbha), "/showOverlay", new zzbzw(this));
    this.zzfpz.zza(new WeakReference(localzzbha), "/hideOverlay", new zzbzx(this));
    return localzzbha.getView();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbzs
 * JD-Core Version:    0.6.2
 */