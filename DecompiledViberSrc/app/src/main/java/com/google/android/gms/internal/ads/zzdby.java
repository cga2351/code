package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

@Deprecated
public final class zzdby
{
  public static final zzdbt zza(zzdbu paramzzdbu)
    throws GeneralSecurityException, IOException
  {
    zzdgz localzzdgz = paramzzdbu.zzanq();
    zzb(localzzdgz);
    return zzdbt.zza(localzzdgz);
  }

  private static void zzb(zzdgz paramzzdgz)
    throws GeneralSecurityException
  {
    Iterator localIterator = paramzzdgz.zzasi().iterator();
    while (localIterator.hasNext())
    {
      zzdgz.zzb localzzb = (zzdgz.zzb)localIterator.next();
      if ((localzzb.zzasn().zzarv() == zzdgq.zzb.zzgud) || (localzzb.zzasn().zzarv() == zzdgq.zzb.zzgue) || (localzzb.zzasn().zzarv() == zzdgq.zzb.zzguf))
        throw new GeneralSecurityException("keyset contains secret key material");
    }
  }

  @Deprecated
  public static final zzdbt zzl(byte[] paramArrayOfByte)
    throws GeneralSecurityException
  {
    try
    {
      zzdgz localzzdgz = zzdgz.zzn(paramArrayOfByte);
      zzb(localzzdgz);
      zzdbt localzzdbt = zzdbt.zza(localzzdgz);
      return localzzdbt;
    }
    catch (zzdoj localzzdoj)
    {
    }
    throw new GeneralSecurityException("invalid keyset");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdby
 * JD-Core Version:    0.6.2
 */