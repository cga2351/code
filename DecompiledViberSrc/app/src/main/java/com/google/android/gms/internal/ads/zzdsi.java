package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzdsi extends zzdrq<zzdsi>
{
  public String url = null;
  public Integer zzhrv = null;
  private zzdry.zza.zzc zzhrw = null;
  public String zzhrx = null;
  private String zzhry = null;
  public zzdsj zzhrz = null;
  public zzdso[] zzhsa = zzdso.zzbba();
  public String zzhsb = null;
  public zzdsn zzhsc = null;
  private Boolean zzhsd = null;
  private String[] zzhse = zzdrx.zzhog;
  private String zzhsf = null;
  private Boolean zzhsg = null;
  private Boolean zzhsh = null;
  private byte[] zzhsi = null;
  public zzdsp zzhsj = null;
  public String[] zzhsk = zzdrx.zzhog;
  public String[] zzhsl = zzdrx.zzhog;

  public zzdsi()
  {
    this.zzhno = null;
    this.zzhnx = -1;
  }

  public final void zza(zzdro paramzzdro)
    throws IOException
  {
    if (this.url != null)
      paramzzdro.zzf(1, this.url);
    if (this.zzhrx != null)
      paramzzdro.zzf(2, this.zzhrx);
    if ((this.zzhsa != null) && (this.zzhsa.length > 0))
      for (int n = 0; n < this.zzhsa.length; n++)
      {
        zzdso localzzdso = this.zzhsa[n];
        if (localzzdso != null)
          paramzzdro.zza(4, localzzdso);
      }
    if ((this.zzhse != null) && (this.zzhse.length > 0))
      for (int m = 0; m < this.zzhse.length; m++)
      {
        String str3 = this.zzhse[m];
        if (str3 != null)
          paramzzdro.zzf(6, str3);
      }
    if (this.zzhrv != null)
      paramzzdro.zzx(10, this.zzhrv.intValue());
    if (this.zzhrz != null)
      paramzzdro.zza(12, this.zzhrz);
    if (this.zzhsb != null)
      paramzzdro.zzf(13, this.zzhsb);
    if (this.zzhsc != null)
      paramzzdro.zza(14, this.zzhsc);
    if (this.zzhsj != null)
      paramzzdro.zza(17, this.zzhsj);
    if ((this.zzhsk != null) && (this.zzhsk.length > 0))
      for (int k = 0; k < this.zzhsk.length; k++)
      {
        String str2 = this.zzhsk[k];
        if (str2 != null)
          paramzzdro.zzf(20, str2);
      }
    if (this.zzhsl != null)
    {
      int i = this.zzhsl.length;
      int j = 0;
      if (i > 0)
        while (j < this.zzhsl.length)
        {
          String str1 = this.zzhsl[j];
          if (str1 != null)
            paramzzdro.zzf(21, str1);
          j++;
        }
    }
    super.zza(paramzzdro);
  }

  protected final int zzor()
  {
    int i = 0;
    int j = super.zzor();
    if (this.url != null)
      j += zzdro.zzg(1, this.url);
    if (this.zzhrx != null)
      j += zzdro.zzg(2, this.zzhrx);
    if ((this.zzhsa != null) && (this.zzhsa.length > 0))
    {
      int i6 = j;
      for (int i7 = 0; i7 < this.zzhsa.length; i7++)
      {
        zzdso localzzdso = this.zzhsa[i7];
        if (localzzdso != null)
          i6 += zzdro.zzb(4, localzzdso);
      }
      j = i6;
    }
    if ((this.zzhse != null) && (this.zzhse.length > 0))
    {
      int i3 = 0;
      int i4 = 0;
      int i5 = 0;
      while (i3 < this.zzhse.length)
      {
        String str3 = this.zzhse[i3];
        if (str3 != null)
        {
          i5++;
          i4 += zzdro.zzgx(str3);
        }
        i3++;
      }
      j = j + i4 + i5 * 1;
    }
    if (this.zzhrv != null)
      j += zzdro.zzab(10, this.zzhrv.intValue());
    if (this.zzhrz != null)
      j += zzdro.zzb(12, this.zzhrz);
    if (this.zzhsb != null)
      j += zzdro.zzg(13, this.zzhsb);
    if (this.zzhsc != null)
      j += zzdro.zzb(14, this.zzhsc);
    if (this.zzhsj != null)
      j += zzdro.zzb(17, this.zzhsj);
    if ((this.zzhsk != null) && (this.zzhsk.length > 0))
    {
      int n = 0;
      int i1 = 0;
      int i2 = 0;
      while (n < this.zzhsk.length)
      {
        String str2 = this.zzhsk[n];
        if (str2 != null)
        {
          i2++;
          i1 += zzdro.zzgx(str2);
        }
        n++;
      }
      j = j + i1 + i2 * 2;
    }
    if ((this.zzhsl != null) && (this.zzhsl.length > 0))
    {
      int k = 0;
      int m = 0;
      while (i < this.zzhsl.length)
      {
        String str1 = this.zzhsl[i];
        if (str1 != null)
        {
          m++;
          k += zzdro.zzgx(str1);
        }
        i++;
      }
      j = j + k + m * 2;
    }
    return j;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdsi
 * JD-Core Version:    0.6.2
 */