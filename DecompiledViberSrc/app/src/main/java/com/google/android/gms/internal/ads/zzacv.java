package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.regex.Pattern;

@zzare
public final class zzacv
{
  public static boolean zzcg(String paramString)
  {
    zzaci localzzaci = zzact.zzcve;
    return zzf((String)zzyr.zzpe().zzd(localzzaci), paramString);
  }

  private static boolean zzf(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null))
      return false;
    try
    {
      boolean bool = Pattern.matches(paramString1, paramString2);
      return bool;
    }
    catch (RuntimeException localRuntimeException)
    {
      zzk.zzlk().zza(localRuntimeException, "NonagonUtil.isPatternMatched");
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzacv
 * JD-Core Version:    0.6.2
 */