package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Map;

@zzare
public final class zzbfp
  implements zzahn<zzbdg>
{
  private boolean zzehr;

  private static int zza(Context paramContext, Map<String, String> paramMap, String paramString, int paramInt)
  {
    String str = (String)paramMap.get(paramString);
    if (str != null);
    try
    {
      zzyr.zzpa();
      int i = zzazu.zza(paramContext, Integer.parseInt(str));
      paramInt = i;
      return paramInt;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      zzaxa.zzep(34 + String.valueOf(paramString).length() + String.valueOf(str).length() + "Could not parse " + paramString + " in a video GMSG: " + str);
    }
    return paramInt;
  }

  private static void zza(zzbcr paramzzbcr, Map<String, String> paramMap)
  {
    String str1 = (String)paramMap.get("minBufferMs");
    String str2 = (String)paramMap.get("maxBufferMs");
    String str3 = (String)paramMap.get("bufferForPlaybackMs");
    String str4 = (String)paramMap.get("bufferForPlaybackAfterRebufferMs");
    String str5 = (String)paramMap.get("socketReceiveBufferSize");
    if (str1 != null);
    try
    {
      paramzzbcr.zzcy(Integer.parseInt(str1));
      if (str2 != null)
        paramzzbcr.zzcz(Integer.parseInt(str2));
      if (str3 != null)
        paramzzbcr.zzda(Integer.parseInt(str3));
      if (str4 != null)
        paramzzbcr.zzdb(Integer.parseInt(str4));
      if (str5 != null)
        paramzzbcr.zzdc(Integer.parseInt(str5));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      zzaxa.zzep(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", new Object[] { str1, str2 }));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbfp
 * JD-Core Version:    0.6.2
 */