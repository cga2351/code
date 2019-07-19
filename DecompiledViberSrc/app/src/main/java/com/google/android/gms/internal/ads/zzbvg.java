package com.google.android.gms.internal.ads;

import java.util.List;

public final class zzbvg
  implements zzbvf
{
  private final List<String> zzdnn;
  private final zzdad zzffd;
  private boolean zzflf;

  public zzbvg(zzcxl paramzzcxl, zzdad paramzzdad)
  {
    this.zzdnn = paramzzcxl.zzdnn;
    this.zzffd = paramzzdad;
  }

  public final void zzagx()
  {
    if (!this.zzflf)
    {
      this.zzffd.zzh(this.zzdnn);
      this.zzflf = true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbvg
 * JD-Core Version:    0.6.2
 */