package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

@zzare
public final class zzbcx
{
  private final Context zzckp;
  private final zzbdg zzebv;
  private final ViewGroup zzecr;
  private zzbcr zzecs;

  @VisibleForTesting
  private zzbcx(Context paramContext, ViewGroup paramViewGroup, zzbdg paramzzbdg, zzbcr paramzzbcr)
  {
    if (paramContext.getApplicationContext() != null)
      paramContext = paramContext.getApplicationContext();
    this.zzckp = paramContext;
    this.zzecr = paramViewGroup;
    this.zzebv = paramzzbdg;
    this.zzecs = null;
  }

  public zzbcx(Context paramContext, ViewGroup paramViewGroup, zzbha paramzzbha)
  {
    this(paramContext, paramViewGroup, paramzzbha, null);
  }

  public final void onDestroy()
  {
    Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
    if (this.zzecs != null)
    {
      this.zzecs.destroy();
      this.zzecr.removeView(this.zzecs);
      this.zzecs = null;
    }
  }

  public final void onPause()
  {
    Preconditions.checkMainThread("onPause must be called from the UI thread.");
    if (this.zzecs != null)
      this.zzecs.pause();
  }

  public final void zza(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, zzbdf paramzzbdf)
  {
    if (this.zzecs != null)
      return;
    zzada.zza(this.zzebv.zzyg().zzqw(), this.zzebv.zzyc(), new String[] { "vpr2" });
    this.zzecs = new zzbcr(this.zzckp, this.zzebv, paramInt5, paramBoolean, this.zzebv.zzyg().zzqw(), paramzzbdf);
    this.zzecr.addView(this.zzecs, 0, new ViewGroup.LayoutParams(-1, -1));
    this.zzecs.zzd(paramInt1, paramInt2, paramInt3, paramInt4);
    this.zzebv.zzao(false);
  }

  public final void zze(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
    if (this.zzecs != null)
      this.zzecs.zzd(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public final zzbcr zzxw()
  {
    Preconditions.checkMainThread("getAdVideoUnderlay must be called from the UI thread.");
    return this.zzecs;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbcx
 * JD-Core Version:    0.6.2
 */