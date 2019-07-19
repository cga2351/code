package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzxl extends zzdrq<zzxl>
{
  private Integer zzcfd = null;
  public String zzcfe = null;
  private Integer zzcff = null;
  private zzwv zzcfg = null;
  private zzxm zzcfh = null;
  public long[] zzcfi = zzdrx.zzhoc;
  public zzxj zzcfj = null;
  private zzxk zzcfk = null;
  private zzwr.zzg zzcfl = null;
  public zzxh zzcfm = null;
  public zzwr.zzi zzcfn = null;
  public zzwr.zzv zzcfo = null;

  public zzxl()
  {
    this.zzhno = null;
    this.zzhnx = -1;
  }

  public final void zza(zzdro paramzzdro)
    throws IOException
  {
    if (this.zzcfe != null)
      paramzzdro.zzf(10, this.zzcfe);
    if ((this.zzcfi != null) && (this.zzcfi.length > 0))
      for (int i = 0; i < this.zzcfi.length; i++)
      {
        long l = this.zzcfi[i];
        paramzzdro.zzw(14, 0);
        paramzzdro.zzfv(l);
      }
    if (this.zzcfj != null)
      paramzzdro.zza(15, this.zzcfj);
    if (this.zzcfm != null)
      paramzzdro.zza(18, this.zzcfm);
    if (this.zzcfn != null)
      paramzzdro.zze(19, this.zzcfn);
    if (this.zzcfo != null)
      paramzzdro.zze(20, this.zzcfo);
    super.zza(paramzzdro);
  }

  protected final int zzor()
  {
    int i = 0;
    int j = super.zzor();
    if (this.zzcfe != null)
      j += zzdro.zzg(10, this.zzcfe);
    if ((this.zzcfi != null) && (this.zzcfi.length > 0))
    {
      int k = 0;
      while (i < this.zzcfi.length)
      {
        k += zzdro.zzfw(this.zzcfi[i]);
        i++;
      }
      j = j + k + 1 * this.zzcfi.length;
    }
    if (this.zzcfj != null)
      j += zzdro.zzb(15, this.zzcfj);
    if (this.zzcfm != null)
      j += zzdro.zzb(18, this.zzcfm);
    if (this.zzcfn != null)
      j += zzdnh.zzc(19, this.zzcfn);
    if (this.zzcfo != null)
      j += zzdnh.zzc(20, this.zzcfo);
    return j;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzxl
 * JD-Core Version:    0.6.2
 */