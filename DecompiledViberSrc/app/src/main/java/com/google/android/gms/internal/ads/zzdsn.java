package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzdsn extends zzdrq<zzdsn>
{
  public String mimeType = null;
  public Integer zzhrv = null;
  public byte[] zzhsu = null;

  public zzdsn()
  {
    this.zzhno = null;
    this.zzhnx = -1;
  }

  public final void zza(zzdro paramzzdro)
    throws IOException
  {
    if (this.zzhrv != null)
      paramzzdro.zzx(1, this.zzhrv.intValue());
    if (this.mimeType != null)
      paramzzdro.zzf(2, this.mimeType);
    if (this.zzhsu != null)
      paramzzdro.zza(3, this.zzhsu);
    super.zza(paramzzdro);
  }

  protected final int zzor()
  {
    int i = super.zzor();
    if (this.zzhrv != null)
      i += zzdro.zzab(1, this.zzhrv.intValue());
    if (this.mimeType != null)
      i += zzdro.zzg(2, this.mimeType);
    if (this.zzhsu != null)
      i += zzdro.zzb(3, this.zzhsu);
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdsn
 * JD-Core Version:    0.6.2
 */