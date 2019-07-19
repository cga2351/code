package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

public final class zzdbk
{
  public static zzdgx zza(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    zzdgx.zza localzza = zzdgx.zzasf().zzgn(paramString2);
    String str1 = String.valueOf(paramString3);
    if (str1.length() != 0);
    for (String str2 = "type.googleapis.com/google.crypto.tink.".concat(str1); ; str2 = new String("type.googleapis.com/google.crypto.tink."))
      return (zzdgx)localzza.zzgo(str2).zzeq(0).zzbe(true).zzgp(paramString1).zzaya();
  }

  public static void zza(zzdhn paramzzdhn)
    throws GeneralSecurityException
  {
    Iterator localIterator = paramzzdhn.zzatj().iterator();
    while (localIterator.hasNext())
    {
      zzdgx localzzdgx = (zzdgx)localIterator.next();
      if (localzzdgx.zzart().isEmpty())
        throw new GeneralSecurityException("Missing type_url.");
      if (localzzdgx.zzasb().isEmpty())
        throw new GeneralSecurityException("Missing primitive_name.");
      if (localzzdgx.zzase().isEmpty())
        throw new GeneralSecurityException("Missing catalogue_name.");
      zzdbj localzzdbj = zzdce.zzgi(localzzdgx.zzase());
      zzdce.zza(localzzdbj.zzanp());
      zzdce.zza(localzzdbj.zzb(localzzdgx.zzart(), localzzdgx.zzasb(), localzzdgx.zzasc()), localzzdgx.zzasd());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdbk
 * JD-Core Version:    0.6.2
 */