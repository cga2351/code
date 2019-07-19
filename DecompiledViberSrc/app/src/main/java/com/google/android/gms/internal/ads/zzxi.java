package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzxi extends zzdrq<zzxi>
{
  public String zzceq = null;
  private zzwr.zza[] zzcer = new zzwr.zza[0];
  private zzwv zzces = null;
  private zzwv zzcet = null;
  private zzwv zzceu = null;

  public zzxi()
  {
    this.zzhno = null;
    this.zzhnx = -1;
  }

  public final void zza(zzdro paramzzdro)
    throws IOException
  {
    if (this.zzceq != null)
      paramzzdro.zzf(1, this.zzceq);
    if ((this.zzcer != null) && (this.zzcer.length > 0))
      for (int i = 0; i < this.zzcer.length; i++)
      {
        zzwr.zza localzza = this.zzcer[i];
        if (localzza != null)
          paramzzdro.zze(2, localzza);
      }
    super.zza(paramzzdro);
  }

  protected final int zzor()
  {
    int i = super.zzor();
    if (this.zzceq != null)
      i += zzdro.zzg(1, this.zzceq);
    if ((this.zzcer != null) && (this.zzcer.length > 0))
    {
      int j = i;
      for (int k = 0; k < this.zzcer.length; k++)
      {
        zzwr.zza localzza = this.zzcer[k];
        if (localzza != null)
          j += zzdnh.zzc(2, localzza);
      }
      i = j;
    }
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzxi
 * JD-Core Version:    0.6.2
 */