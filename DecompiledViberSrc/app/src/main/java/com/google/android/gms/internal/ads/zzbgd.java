package com.google.android.gms.internal.ads;

import java.util.Map;

@zzare
public final class zzbgd
  implements zzahn<zzbdg>
{
  private static Integer zza(Map<String, String> paramMap, String paramString)
  {
    if (!paramMap.containsKey(paramString))
      return null;
    try
    {
      Integer localInteger = Integer.valueOf(Integer.parseInt((String)paramMap.get(paramString)));
      return localInteger;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      String str = (String)paramMap.get(paramString);
      zzaxa.zzep(39 + String.valueOf(paramString).length() + String.valueOf(str).length() + "Precache invalid numeric parameter '" + paramString + "': " + str);
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbgd
 * JD-Core Version:    0.6.2
 */