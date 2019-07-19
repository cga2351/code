package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzxh extends zzdrq<zzxh>
{
  public Integer zzcef = null;
  private zzwv zzceg = null;
  private zzwr.zzb zzceh = null;
  public zzxi zzcei = null;
  private zzwr.zza[] zzcej = new zzwr.zza[0];
  private zzwr.zzc zzcek = null;
  private zzwr.zzj zzcel = null;
  private zzwr.zzh zzcem = null;
  private zzwr.zze zzcen = null;
  private zzwr.zzf zzceo = null;
  private zzxn[] zzcep = zzxn.zzos();

  public zzxh()
  {
    this.zzhno = null;
    this.zzhnx = -1;
  }

  public final void zza(zzdro paramzzdro)
    throws IOException
  {
    if (this.zzcef != null)
      paramzzdro.zzx(7, this.zzcef.intValue());
    if (this.zzcei != null)
      paramzzdro.zza(10, this.zzcei);
    if ((this.zzcej != null) && (this.zzcej.length > 0))
      for (int k = 0; k < this.zzcej.length; k++)
      {
        zzwr.zza localzza = this.zzcej[k];
        if (localzza != null)
          paramzzdro.zze(11, localzza);
      }
    if (this.zzcep != null)
    {
      int i = this.zzcep.length;
      int j = 0;
      if (i > 0)
        while (j < this.zzcep.length)
        {
          zzxn localzzxn = this.zzcep[j];
          if (localzzxn != null)
            paramzzdro.zza(17, localzzxn);
          j++;
        }
    }
    super.zza(paramzzdro);
  }

  protected final int zzor()
  {
    int i = super.zzor();
    if (this.zzcef != null)
      i += zzdro.zzab(7, this.zzcef.intValue());
    if (this.zzcei != null)
      i += zzdro.zzb(10, this.zzcei);
    if ((this.zzcej != null) && (this.zzcej.length > 0))
    {
      int m = i;
      for (int n = 0; n < this.zzcej.length; n++)
      {
        zzwr.zza localzza = this.zzcej[n];
        if (localzza != null)
          m += zzdnh.zzc(11, localzza);
      }
      i = m;
    }
    if (this.zzcep != null)
    {
      int j = this.zzcep.length;
      int k = 0;
      if (j > 0)
        while (k < this.zzcep.length)
        {
          zzxn localzzxn = this.zzcep[k];
          if (localzzxn != null)
            i += zzdro.zzb(17, localzzxn);
          k++;
        }
    }
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzxh
 * JD-Core Version:    0.6.2
 */