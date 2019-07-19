package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzdbt
{
  private zzdgz zzgph;

  private zzdbt(zzdgz paramzzdgz)
  {
    this.zzgph = paramzzdgz;
  }

  static final zzdbt zza(zzdgz paramzzdgz)
    throws GeneralSecurityException
  {
    if ((paramzzdgz == null) || (paramzzdgz.zzasj() <= 0))
      throw new GeneralSecurityException("empty keyset");
    return new zzdbt(paramzzdgz);
  }

  public final String toString()
  {
    return zzdcg.zzc(this.zzgph).toString();
  }

  final zzdgz zzant()
  {
    return this.zzgph;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdbt
 * JD-Core Version:    0.6.2
 */