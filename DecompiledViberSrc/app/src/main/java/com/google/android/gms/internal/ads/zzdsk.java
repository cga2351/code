package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzdsk extends zzdrq<zzdsk>
{
  private static volatile zzdsk[] zzhsm;
  public byte[] zzhsn = null;
  public byte[] zzhso = null;

  public zzdsk()
  {
    this.zzhno = null;
    this.zzhnx = -1;
  }

  public static zzdsk[] zzbaz()
  {
    if (zzhsm == null);
    synchronized (zzdru.zzhnw)
    {
      if (zzhsm == null)
        zzhsm = new zzdsk[0];
      return zzhsm;
    }
  }

  public final void zza(zzdro paramzzdro)
    throws IOException
  {
    paramzzdro.zza(1, this.zzhsn);
    if (this.zzhso != null)
      paramzzdro.zza(2, this.zzhso);
    super.zza(paramzzdro);
  }

  protected final int zzor()
  {
    int i = super.zzor() + zzdro.zzb(1, this.zzhsn);
    if (this.zzhso != null)
      i += zzdro.zzb(2, this.zzhso);
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdsk
 * JD-Core Version:    0.6.2
 */