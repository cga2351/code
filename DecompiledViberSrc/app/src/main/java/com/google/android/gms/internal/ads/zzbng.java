package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import java.util.concurrent.Executor;

final class zzbng extends zzbne
{
  private final View view;
  private final zzbha zzdbu;
  private final Executor zzffu;
  private final zzcxm zzfgw;
  private final zzbpa zzfgx;
  private final zzbzb zzfgy;
  private final zzbvc zzfgz;
  private final zzdtd<zzcpl> zzfha;
  private final Context zzlj;

  zzbng(Context paramContext, zzcxm paramzzcxm, View paramView, zzbha paramzzbha, zzbpa paramzzbpa, zzbzb paramzzbzb, zzbvc paramzzbvc, zzdtd<zzcpl> paramzzdtd, Executor paramExecutor)
  {
    this.zzlj = paramContext;
    this.view = paramView;
    this.zzdbu = paramzzbha;
    this.zzfgw = paramzzcxm;
    this.zzfgx = paramzzbpa;
    this.zzfgy = paramzzbzb;
    this.zzfgz = paramzzbvc;
    this.zzfha = paramzzdtd;
    this.zzffu = paramExecutor;
  }

  public final zzaap getVideoController()
  {
    try
    {
      zzaap localzzaap = this.zzfgx.getVideoController();
      return localzzaap;
    }
    catch (RemoteException localRemoteException)
    {
    }
    return null;
  }

  public final void zza(ViewGroup paramViewGroup, zzyb paramzzyb)
  {
    if ((paramViewGroup != null) && (this.zzdbu != null))
    {
      this.zzdbu.zza(zzbio.zzb(paramzzyb));
      paramViewGroup.setMinimumHeight(paramzzyb.heightPixels);
      paramViewGroup.setMinimumWidth(paramzzyb.widthPixels);
    }
  }

  public final View zzafi()
  {
    return this.view;
  }

  public final zzcxm zzafj()
  {
    return (zzcxm)this.zzfif.zzgkd.get(0);
  }

  public final int zzafk()
  {
    return this.zzffc.zzgky.zzgku.zzgkr;
  }

  public final void zzafl()
  {
    this.zzffu.execute(new zzbnh(this));
    super.zzafl();
  }

  public final void zzpm()
  {
    this.zzfgz.zzagx();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbng
 * JD-Core Version:    0.6.2
 */