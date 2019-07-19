package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzdca<P>
{
  private final P zzgpl;
  private final byte[] zzgpm;
  private final zzdgt zzgpn;
  private final zzdhl zzgpo;

  public zzdca(P paramP, byte[] paramArrayOfByte, zzdgt paramzzdgt, zzdhl paramzzdhl)
  {
    this.zzgpl = paramP;
    this.zzgpm = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
    this.zzgpn = paramzzdgt;
    this.zzgpo = paramzzdhl;
  }

  public final P zzanv()
  {
    return this.zzgpl;
  }

  public final zzdhl zzanw()
  {
    return this.zzgpo;
  }

  public final byte[] zzanx()
  {
    if (this.zzgpm == null)
      return null;
    return Arrays.copyOf(this.zzgpm, this.zzgpm.length);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdca
 * JD-Core Version:    0.6.2
 */