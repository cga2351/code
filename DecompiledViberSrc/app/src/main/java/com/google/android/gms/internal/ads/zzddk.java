package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

final class zzddk extends zzdbs<zzdbx, zzdgk, zzdgm>
{
  public zzddk()
  {
    super(zzdbx.class, zzdgk.class, zzdgm.class, "type.googleapis.com/google.crypto.tink.HmacKey");
  }

  private static void zza(zzdgo paramzzdgo)
    throws GeneralSecurityException
  {
    if (paramzzdgo.zzarq() < 10)
      throw new GeneralSecurityException("tag size too small");
    switch (zzddl.zzgqb[paramzzdgo.zzarp().ordinal()])
    {
    default:
      throw new GeneralSecurityException("unknown hash type");
    case 1:
      if (paramzzdgo.zzarq() > 20)
        throw new GeneralSecurityException("tag size too big");
      break;
    case 2:
      if (paramzzdgo.zzarq() > 32)
        throw new GeneralSecurityException("tag size too big");
      break;
    case 3:
      if (paramzzdgo.zzarq() > 64)
        throw new GeneralSecurityException("tag size too big");
      break;
    }
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
 * Qualified Name:     com.google.android.gms.internal.ads.zzddk
 * JD-Core Version:    0.6.2
 */