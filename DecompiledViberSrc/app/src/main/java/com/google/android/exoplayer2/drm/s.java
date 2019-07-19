package com.google.android.exoplayer2.drm;

import android.util.Pair;
import java.util.Map;

public final class s
{
  private static long a(Map<String, String> paramMap, String paramString)
  {
    if (paramMap != null)
      try
      {
        String str = (String)paramMap.get(paramString);
        if (str != null)
        {
          long l = Long.parseLong(str);
          return l;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    return -9223372036854775807L;
  }

  public static Pair<Long, Long> a(k<?> paramk)
  {
    Map localMap = paramk.h();
    if (localMap == null)
      return null;
    return new Pair(Long.valueOf(a(localMap, "LicenseDurationRemaining")), Long.valueOf(a(localMap, "PlaybackDurationRemaining")));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.s
 * JD-Core Version:    0.6.2
 */