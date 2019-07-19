package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzxm extends zzdrq<zzxm>
{
  public Integer zzcfp = null;
  public Integer zzcfq = null;
  public Integer zzcfr = null;

  public zzxm()
  {
    this.zzhno = null;
    this.zzhnx = -1;
  }

  public final void zza(zzdro paramzzdro)
    throws IOException
  {
    if (this.zzcfp != null)
      paramzzdro.zzx(1, this.zzcfp.intValue());
    if (this.zzcfq != null)
      paramzzdro.zzx(2, this.zzcfq.intValue());
    if (this.zzcfr != null)
      paramzzdro.zzx(3, this.zzcfr.intValue());
    super.zza(paramzzdro);
  }

  protected final int zzor()
  {
    int i = super.zzor();
    if (this.zzcfp != null)
      i += zzdro.zzab(1, this.zzcfp.intValue());
    if (this.zzcfq != null)
      i += zzdro.zzab(2, this.zzcfq.intValue());
    if (this.zzcfr != null)
      i += zzdro.zzab(3, this.zzcfr.intValue());
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzxm
 * JD-Core Version:    0.6.2
 */