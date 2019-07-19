package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzdsl extends zzdrq<zzdsl>
{
  private zzdry.zzb.zzd.zzb zzhsp = null;
  public zzdsk[] zzhsq = zzdsk.zzbaz();
  private byte[] zzhsr = null;
  private byte[] zzhss = null;
  private Integer zzhst = null;

  public zzdsl()
  {
    this.zzhno = null;
    this.zzhnx = -1;
  }

  public final void zza(zzdro paramzzdro)
    throws IOException
  {
    if ((this.zzhsq != null) && (this.zzhsq.length > 0))
      for (int i = 0; i < this.zzhsq.length; i++)
      {
        zzdsk localzzdsk = this.zzhsq[i];
        if (localzzdsk != null)
          paramzzdro.zza(2, localzzdsk);
      }
    super.zza(paramzzdro);
  }

  protected final int zzor()
  {
    int i = super.zzor();
    if ((this.zzhsq != null) && (this.zzhsq.length > 0))
      for (int j = 0; j < this.zzhsq.length; j++)
      {
        zzdsk localzzdsk = this.zzhsq[j];
        if (localzzdsk != null)
          i += zzdro.zzb(2, localzzdsk);
      }
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdsl
 * JD-Core Version:    0.6.2
 */