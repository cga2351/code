package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

@zzare
public final class zzaqb extends zzaqc
  implements zzahn<zzbha>
{
  private float density;
  private int rotation;
  private final WindowManager zzbtg;
  private final zzbha zzdbu;
  private final zzace zzdix;
  private DisplayMetrics zzdiy;
  private int zzdiz = -1;
  private int zzdja = -1;
  private int zzdjb = -1;
  private int zzdjc = -1;
  private int zzdjd = -1;
  private int zzdje = -1;
  private final Context zzlj;

  public zzaqb(zzbha paramzzbha, Context paramContext, zzace paramzzace)
  {
    super(paramzzbha);
    this.zzdbu = paramzzbha;
    this.zzlj = paramContext;
    this.zzdix = paramzzace;
    this.zzbtg = ((WindowManager)paramContext.getSystemService("window"));
  }

  public final void zzj(int paramInt1, int paramInt2)
  {
    if ((this.zzlj instanceof Activity));
    for (int i = com.google.android.gms.ads.internal.zzk.zzlg().zzf((Activity)this.zzlj)[0]; ; i = 0)
    {
      if ((this.zzdbu.zzaag() == null) || (!this.zzdbu.zzaag().zzabx()))
      {
        this.zzdjd = zzyr.zzpa().zzb(this.zzlj, this.zzdbu.getWidth());
        this.zzdje = zzyr.zzpa().zzb(this.zzlj, this.zzdbu.getHeight());
      }
      zzb(paramInt1, paramInt2 - i, this.zzdjd, this.zzdje);
      this.zzdbu.zzaai().zzi(paramInt1, paramInt2);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaqb
 * JD-Core Version:    0.6.2
 */