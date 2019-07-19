package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class zzchn
  implements zzbao<zzcxt>
{
  zzchn(zzchk paramzzchk)
  {
  }

  public final void zzb(Throwable paramThrowable)
  {
    zzaci localzzaci = zzact.zzcwt;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
    {
      Matcher localMatcher = zzchk.zzakf().matcher(paramThrowable.getMessage());
      if (localMatcher.matches())
      {
        String str = localMatcher.group(1);
        zzchk.zza(this.zzfwz).zzdo(Integer.parseInt(str));
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzchn
 * JD-Core Version:    0.6.2
 */