package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

final class zzdcm extends zzdbs<zzdlj, zzdea, zzdec>
{
  public zzdcm()
  {
    super(zzdlj.class, zzdea.class, zzdec.class, "type.googleapis.com/google.crypto.tink.AesCtrKey");
  }

  private static void zza(zzdee paramzzdee)
    throws GeneralSecurityException
  {
    if ((paramzzdee.zzaoy() < 12) || (paramzzdee.zzaoy() > 16))
      throw new GeneralSecurityException("invalid IV size");
  }

  public final int getVersion()
  {
    return 0;
  }

  protected final zzdgq.zzb zzans()
  {
    return zzdgq.zzb.zzgue;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdcm
 * JD-Core Version:    0.6.2
 */