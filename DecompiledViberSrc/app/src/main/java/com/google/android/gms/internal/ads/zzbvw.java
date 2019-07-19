package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

public final class zzbvw extends zzbpb
{
  private final zzbuo zzflh;
  private final zzbwy zzfli;
  private final zzbpu zzflj;
  private final zzdam zzflk;
  private boolean zzfll = false;
  private final Context zzlj;

  zzbvw(Context paramContext, zzbrx paramzzbrx, zzbuo paramzzbuo, zzbwy paramzzbwy, zzbpu paramzzbpu, zzdam paramzzdam)
  {
    this.zzlj = paramContext;
    this.zzfip = paramzzbrx;
    this.zzflh = paramzzbuo;
    this.zzfli = paramzzbwy;
    this.zzflj = paramzzbpu;
    this.zzflk = paramzzdam;
  }

  public final boolean isClosed()
  {
    return this.zzflj.isClosed();
  }

  public final void show(boolean paramBoolean)
  {
    this.zzflh.zzagu();
    this.zzfli.zza(paramBoolean, this.zzlj);
    this.zzfll = true;
  }

  public final zzbrx zzadd()
  {
    return this.zzfip;
  }

  public final boolean zzagz()
  {
    zzaci localzzaci1 = zzact.zzcof;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci1)).booleanValue())
    {
      zzk.zzlg();
      if (zzaxj.zzaq(this.zzlj))
      {
        zzaxa.zzep("It is not recommended to show an interstitial when app is not in foreground.");
        zzaci localzzaci2 = zzact.zzcog;
        if (((Boolean)zzyr.zzpe().zzd(localzzaci2)).booleanValue())
          this.zzflk.zzgb(this.zzffc.zzgky.zzgku.zzceq);
        return false;
      }
    }
    return !this.zzfll;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbvw
 * JD-Core Version:    0.6.2
 */