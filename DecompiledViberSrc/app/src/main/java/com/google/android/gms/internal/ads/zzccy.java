package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

public final class zzccy
  implements zzahx
{
  private final zzbsd zzfjg;

  @Nullable
  private final zzatp zzfsz;
  private final String zzfta;
  private final String zzftb;

  public zzccy(zzbsd paramzzbsd, zzcxl paramzzcxl)
  {
    this.zzfjg = paramzzbsd;
    this.zzfsz = paramzzcxl.zzdnz;
    this.zzfta = paramzzcxl.zzdew;
    this.zzftb = paramzzcxl.zzdex;
  }

  @ParametersAreNonnullByDefault
  public final void zza(zzatp paramzzatp)
  {
    String str = "";
    int i = 1;
    if (this.zzfsz != null)
      paramzzatp = this.zzfsz;
    if (paramzzatp != null)
    {
      str = paramzzatp.type;
      i = paramzzatp.zzdqo;
    }
    zzasq localzzasq = new zzasq(str, i);
    this.zzfjg.zzb(localzzasq, this.zzfta, this.zzftb);
  }

  public final void zzrq()
  {
    this.zzfjg.onRewardedVideoStarted();
  }

  public final void zzrr()
  {
    this.zzfjg.onRewardedVideoCompleted();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzccy
 * JD-Core Version:    0.6.2
 */