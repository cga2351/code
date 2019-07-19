package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzdsp extends zzdrq<zzdsp>
{
  public String zzhte = null;
  public Long zzhtf = null;
  public Boolean zzhtg = null;

  public zzdsp()
  {
    this.zzhno = null;
    this.zzhnx = -1;
  }

  public final void zza(zzdro paramzzdro)
    throws IOException
  {
    if (this.zzhte != null)
      paramzzdro.zzf(1, this.zzhte);
    if (this.zzhtf != null)
    {
      long l = this.zzhtf.longValue();
      paramzzdro.zzw(2, 0);
      paramzzdro.zzfv(l);
    }
    if (this.zzhtg != null)
      paramzzdro.zzi(3, this.zzhtg.booleanValue());
    super.zza(paramzzdro);
  }

  protected final int zzor()
  {
    int i = super.zzor();
    if (this.zzhte != null)
      i += zzdro.zzg(1, this.zzhte);
    if (this.zzhtf != null)
    {
      long l = this.zzhtf.longValue();
      i += zzdro.zzgd(2) + zzdro.zzfw(l);
    }
    if (this.zzhtg != null)
    {
      this.zzhtg.booleanValue();
      i += 1 + zzdro.zzgd(3);
    }
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdsp
 * JD-Core Version:    0.6.2
 */