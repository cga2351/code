package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.R.styleable;

@zzare
public final class zzye
{
  private final AdSize[] zzchk;
  private final String zzchl;

  public zzye(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.AdsAttrs);
    String str1 = localTypedArray.getString(R.styleable.AdsAttrs_adSize);
    String str2 = localTypedArray.getString(R.styleable.AdsAttrs_adSizes);
    int j;
    if (!TextUtils.isEmpty(str1))
    {
      j = i;
      if (TextUtils.isEmpty(str2))
        break label114;
      label58: if ((j == 0) || (i != 0))
        break label119;
    }
    for (this.zzchk = zzbs(str1); ; this.zzchk = zzbs(str2))
    {
      this.zzchl = localTypedArray.getString(R.styleable.AdsAttrs_adUnitId);
      if (!TextUtils.isEmpty(this.zzchl))
        return;
      throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
      j = 0;
      break;
      label114: i = 0;
      break label58;
      label119: if ((j != 0) || (i == 0))
        break label140;
    }
    label140: if (j != 0)
      throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
    throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
  }

  private static AdSize[] zzbs(String paramString)
  {
    String[] arrayOfString1 = paramString.split("\\s*,\\s*");
    AdSize[] arrayOfAdSize = new AdSize[arrayOfString1.length];
    int i = 0;
    if (i < arrayOfString1.length)
    {
      String str3 = arrayOfString1[i].trim();
      String[] arrayOfString2;
      if (str3.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$"))
      {
        arrayOfString2 = str3.split("[xX]");
        arrayOfString2[0] = arrayOfString2[0].trim();
        arrayOfString2[1] = arrayOfString2[1].trim();
      }
      while (true)
      {
        String str6;
        try
        {
          if ("FULL_WIDTH".equals(arrayOfString2[0]))
          {
            j = -1;
            boolean bool = "AUTO_HEIGHT".equals(arrayOfString2[1]);
            if (!bool)
              continue;
            m = -2;
            arrayOfAdSize[i] = new AdSize(j, m);
            i++;
            break;
          }
          int j = Integer.parseInt(arrayOfString2[0]);
          continue;
          int k = Integer.parseInt(arrayOfString2[1]);
          int m = k;
          continue;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          str6 = String.valueOf(str3);
          if (str6.length() == 0);
        }
        for (String str7 = "Could not parse XML attribute \"adSize\": ".concat(str6); ; str7 = new String("Could not parse XML attribute \"adSize\": "))
          throw new IllegalArgumentException(str7);
        if ("BANNER".equals(str3))
        {
          arrayOfAdSize[i] = AdSize.BANNER;
        }
        else if ("LARGE_BANNER".equals(str3))
        {
          arrayOfAdSize[i] = AdSize.LARGE_BANNER;
        }
        else if ("FULL_BANNER".equals(str3))
        {
          arrayOfAdSize[i] = AdSize.FULL_BANNER;
        }
        else if ("LEADERBOARD".equals(str3))
        {
          arrayOfAdSize[i] = AdSize.LEADERBOARD;
        }
        else if ("MEDIUM_RECTANGLE".equals(str3))
        {
          arrayOfAdSize[i] = AdSize.MEDIUM_RECTANGLE;
        }
        else if ("SMART_BANNER".equals(str3))
        {
          arrayOfAdSize[i] = AdSize.SMART_BANNER;
        }
        else if ("WIDE_SKYSCRAPER".equals(str3))
        {
          arrayOfAdSize[i] = AdSize.WIDE_SKYSCRAPER;
        }
        else if ("FLUID".equals(str3))
        {
          arrayOfAdSize[i] = AdSize.FLUID;
        }
        else
        {
          if (!"ICON".equals(str3))
            break label374;
          arrayOfAdSize[i] = AdSize.zzaao;
        }
      }
      label374: String str4 = String.valueOf(str3);
      if (str4.length() != 0);
      for (String str5 = "Could not parse XML attribute \"adSize\": ".concat(str4); ; str5 = new String("Could not parse XML attribute \"adSize\": "))
        throw new IllegalArgumentException(str5);
    }
    if (arrayOfAdSize.length == 0)
    {
      String str1 = String.valueOf(paramString);
      if (str1.length() != 0);
      for (String str2 = "Could not parse XML attribute \"adSize\": ".concat(str1); ; str2 = new String("Could not parse XML attribute \"adSize\": "))
        throw new IllegalArgumentException(str2);
    }
    return arrayOfAdSize;
  }

  public final String getAdUnitId()
  {
    return this.zzchl;
  }

  public final AdSize[] zzs(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.zzchk.length != 1))
      throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
    return this.zzchk;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzye
 * JD-Core Version:    0.6.2
 */