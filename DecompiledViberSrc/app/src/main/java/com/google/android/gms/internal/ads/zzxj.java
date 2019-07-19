package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzxj extends zzdrq<zzxj>
{
  public String zzcev = null;
  private zzwr.zzn zzcew = null;
  private Integer zzcex = null;
  public zzxm zzcey = null;
  private Integer zzcez = null;
  private zzwv zzcfa = null;
  private zzwv zzcfb = null;
  private zzwv zzcfc = null;

  public zzxj()
  {
    this.zzhno = null;
    this.zzhnx = -1;
  }

  public final void zza(zzdro paramzzdro)
    throws IOException
  {
    if (this.zzcev != null)
      paramzzdro.zzf(1, this.zzcev);
    if (this.zzcey != null)
      paramzzdro.zza(4, this.zzcey);
    super.zza(paramzzdro);
  }

  protected final int zzor()
  {
    int i = super.zzor();
    if (this.zzcev != null)
      i += zzdro.zzg(1, this.zzcev);
    if (this.zzcey != null)
      i += zzdro.zzb(4, this.zzcey);
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzxj
 * JD-Core Version:    0.6.2
 */