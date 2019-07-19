package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzdso extends zzdrq<zzdso>
{
  private static volatile zzdso[] zzhsv;
  public String url = null;
  public Integer zzhsw = null;
  public zzdsl zzhsx = null;
  private zzdsm zzhsy = null;
  private Integer zzhsz = null;
  private int[] zzhta = zzdrx.zzhjo;
  private String zzhtb = null;
  public Integer zzhtc = null;
  public String[] zzhtd = zzdrx.zzhog;

  public zzdso()
  {
    this.zzhno = null;
    this.zzhnx = -1;
  }

  public static zzdso[] zzbba()
  {
    if (zzhsv == null);
    synchronized (zzdru.zzhnw)
    {
      if (zzhsv == null)
        zzhsv = new zzdso[0];
      return zzhsv;
    }
  }

  public final void zza(zzdro paramzzdro)
    throws IOException
  {
    paramzzdro.zzx(1, this.zzhsw.intValue());
    if (this.url != null)
      paramzzdro.zzf(2, this.url);
    if (this.zzhsx != null)
      paramzzdro.zza(3, this.zzhsx);
    if ((this.zzhta != null) && (this.zzhta.length > 0))
      for (int k = 0; k < this.zzhta.length; k++)
        paramzzdro.zzx(6, this.zzhta[k]);
    if (this.zzhtc != null)
      paramzzdro.zzx(8, this.zzhtc.intValue());
    if (this.zzhtd != null)
    {
      int i = this.zzhtd.length;
      int j = 0;
      if (i > 0)
        while (j < this.zzhtd.length)
        {
          String str = this.zzhtd[j];
          if (str != null)
            paramzzdro.zzf(9, str);
          j++;
        }
    }
    super.zza(paramzzdro);
  }

  protected final int zzor()
  {
    int i = 0;
    int j = super.zzor() + zzdro.zzab(1, this.zzhsw.intValue());
    if (this.url != null)
      j += zzdro.zzg(2, this.url);
    if (this.zzhsx != null)
      j += zzdro.zzb(3, this.zzhsx);
    if ((this.zzhta != null) && (this.zzhta.length > 0))
    {
      int n = 0;
      int i1 = 0;
      while (n < this.zzhta.length)
      {
        i1 += zzdro.zzge(this.zzhta[n]);
        n++;
      }
      j = j + i1 + 1 * this.zzhta.length;
    }
    if (this.zzhtc != null)
      j += zzdro.zzab(8, this.zzhtc.intValue());
    if ((this.zzhtd != null) && (this.zzhtd.length > 0))
    {
      int k = 0;
      int m = 0;
      while (i < this.zzhtd.length)
      {
        String str = this.zzhtd[i];
        if (str != null)
        {
          m++;
          k += zzdro.zzgx(str);
        }
        i++;
      }
      j = j + k + m * 1;
    }
    return j;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdso
 * JD-Core Version:    0.6.2
 */