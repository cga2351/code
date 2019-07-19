package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzdsj extends zzdrq<zzdsj>
{
  public String zzdrt = null;

  public zzdsj()
  {
    this.zzhno = null;
    this.zzhnx = -1;
  }

  public final void zza(zzdro paramzzdro)
    throws IOException
  {
    if (this.zzdrt != null)
      paramzzdro.zzf(1, this.zzdrt);
    super.zza(paramzzdro);
  }

  protected final int zzor()
  {
    int i = super.zzor();
    if (this.zzdrt != null)
      i += zzdro.zzg(1, this.zzdrt);
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdsj
 * JD-Core Version:    0.6.2
 */