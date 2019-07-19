package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zznr
{
  private static final zzpu zzazn = new zzns();
  private static final Pattern zzazo = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
  public int zzaty = -1;
  public int zzatz = -1;

  private final boolean zzd(String paramString1, String paramString2)
  {
    if (!"iTunSMPB".equals(paramString1));
    while (true)
    {
      return false;
      Matcher localMatcher = zzazo.matcher(paramString2);
      if (localMatcher.find())
        try
        {
          int i = Integer.parseInt(localMatcher.group(1), 16);
          int j = Integer.parseInt(localMatcher.group(2), 16);
          if ((i > 0) || (j > 0))
          {
            this.zzaty = i;
            this.zzatz = j;
            return true;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
        }
    }
    return false;
  }

  public final boolean zzb(zzpo paramzzpo)
  {
    for (int i = 0; ; i++)
    {
      int j = paramzzpo.length();
      boolean bool = false;
      if (i < j)
      {
        zzpo.zza localzza = paramzzpo.zzbc(i);
        if ((localzza instanceof zzps))
        {
          zzps localzzps = (zzps)localzza;
          if (zzd(localzzps.description, localzzps.zzbhy))
            bool = true;
        }
      }
      else
      {
        return bool;
      }
    }
  }

  public final boolean zzii()
  {
    return (this.zzaty != -1) && (this.zzatz != -1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zznr
 * JD-Core Version:    0.6.2
 */