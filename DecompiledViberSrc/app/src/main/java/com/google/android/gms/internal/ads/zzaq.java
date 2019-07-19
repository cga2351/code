package com.google.android.gms.internal.ads;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class zzaq
{
  public static zzc zzb(zzp paramzzp)
  {
    long l1 = System.currentTimeMillis();
    Map localMap = paramzzp.zzab;
    long l2 = 0L;
    long l3 = 0L;
    long l4 = 0L;
    String str1 = (String)localMap.get("Date");
    if (str1 != null)
      l2 = zzf(str1);
    String str2 = (String)localMap.get("Cache-Control");
    int k;
    int i;
    long l9;
    long l10;
    String str6;
    if (str2 != null)
    {
      String[] arrayOfString = str2.split(",", 0);
      k = 0;
      i = 0;
      l9 = l4;
      l10 = l3;
      if (k < arrayOfString.length)
      {
        str6 = arrayOfString[k].trim();
        if ((str6.equals("no-cache")) || (str6.equals("no-store")))
          return null;
        if (!str6.startsWith("max-age="));
      }
    }
    while (true)
    {
      try
      {
        long l12 = Long.parseLong(str6.substring(8));
        l10 = l12;
        k++;
        break;
        if (str6.startsWith("stale-while-revalidate="));
        try
        {
          long l11 = Long.parseLong(str6.substring(23));
          l9 = l11;
          continue;
          if ((!str6.equals("must-revalidate")) && (!str6.equals("proxy-revalidate")))
            continue;
          i = 1;
          continue;
          l3 = l10;
          l4 = l9;
          j = 1;
          String str3 = (String)localMap.get("Expires");
          if (str3 == null)
            continue;
          l5 = zzf(str3);
          String str4 = (String)localMap.get("Last-Modified");
          if (str4 == null)
            continue;
          l6 = zzf(str4);
          String str5 = (String)localMap.get("ETag");
          if (j != 0)
          {
            l8 = l1 + 1000L * l3;
            if (i != 0)
            {
              l7 = l8;
              zzc localzzc = new zzc();
              localzzc.data = paramzzp.data;
              localzzc.zza = str5;
              localzzc.zze = l8;
              localzzc.zzd = l7;
              localzzc.zzb = l2;
              localzzc.zzc = l6;
              localzzc.zzf = localMap;
              localzzc.zzg = paramzzp.allHeaders;
              return localzzc;
            }
            l7 = l8 + 1000L * l4;
            continue;
          }
          if ((l2 <= 0L) || (l5 < l2))
            continue;
          l7 = l1 + (l5 - l2);
          l8 = l7;
          continue;
        }
        catch (Exception localException1)
        {
        }
        continue;
      }
      catch (Exception localException2)
      {
        continue;
        long l7 = 0L;
        long l8 = 0L;
        continue;
        long l6 = 0L;
        continue;
        long l5 = 0L;
        continue;
      }
      i = 0;
      int j = 0;
    }
  }

  static String zzb(long paramLong)
  {
    return zzp().format(new Date(paramLong));
  }

  private static long zzf(String paramString)
  {
    try
    {
      long l = zzp().parse(paramString).getTime();
      return l;
    }
    catch (ParseException localParseException)
    {
      zzag.zza(localParseException, "Unable to parse dateStr: %s, falling back to 0", new Object[] { paramString });
    }
    return 0L;
  }

  private static SimpleDateFormat zzp()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    return localSimpleDateFormat;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaq
 * JD-Core Version:    0.6.2
 */