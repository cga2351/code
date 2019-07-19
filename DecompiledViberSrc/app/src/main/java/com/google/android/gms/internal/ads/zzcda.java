package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

public final class zzcda extends zzbpb
{
  private final zzatr zzdqy;
  private final zzbuo zzflh;
  private final zzbpu zzflj;
  private final zzdam zzflk;
  private boolean zzfll = false;
  private final zzbwy zzflm;
  private final zzbro zzftc;
  private final Context zzlj;

  zzcda(Context paramContext, zzbwy paramzzbwy, zzbuo paramzzbuo, zzbro paramzzbro, zzbrx paramzzbrx, zzbpu paramzzbpu, zzcxl paramzzcxl, zzdam paramzzdam)
  {
    this.zzlj = paramContext;
    this.zzflm = paramzzbwy;
    this.zzflh = paramzzbuo;
    this.zzftc = paramzzbro;
    this.zzfip = paramzzbrx;
    this.zzflj = paramzzbpu;
    this.zzflk = paramzzdam;
    this.zzdqy = new zzauq(paramzzcxl.zzdnz);
  }

  public final boolean isClosed()
  {
    return this.zzflj.isClosed();
  }

  public final zzbrx zzadd()
  {
    return this.zzfip;
  }

  public final void zzb(boolean paramBoolean, Activity paramActivity)
  {
    zzaci localzzaci1 = zzact.zzcof;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci1)).booleanValue())
    {
      zzk.zzlg();
      if (zzaxj.zzaq(this.zzlj))
      {
        zzaxa.zzep("Rewarded ad can not be shown when app is not in foreground.");
        this.zzftc.zzcs(3);
        zzaci localzzaci2 = zzact.zzcog;
        if (((Boolean)zzyr.zzpe().zzd(localzzaci2)).booleanValue())
          this.zzflk.zzgb(this.zzffc.zzgky.zzgku.zzceq);
        return;
      }
    }
    if (this.zzfll)
    {
      zzaxa.zzep("The rewarded ad have been showed.");
      this.zzftc.zzcs(1);
      return;
    }
    this.zzfll = true;
    this.zzflh.zzagu();
    if (paramActivity == null)
      paramActivity = this.zzlj;
    this.zzflm.zza(paramBoolean, paramActivity);
  }

  public final zzatr zzqh()
  {
    return this.zzdqy;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcda
 * JD-Core Version:    0.6.2
 */