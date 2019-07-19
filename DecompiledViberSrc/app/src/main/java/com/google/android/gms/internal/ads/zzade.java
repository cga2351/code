package com.google.android.gms.internal.ads;

import android.text.TextUtils;

final class zzade extends zzadb
{
  private static String zzci(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    int i;
    int j;
    do
    {
      return paramString;
      i = 0;
      j = paramString.length();
      while ((i < paramString.length()) && (paramString.charAt(i) == ','))
        i++;
      while ((j > 0) && (paramString.charAt(j - 1) == ','))
        j--;
      if (j < i)
        return null;
    }
    while ((i == 0) && (j == paramString.length()));
    return paramString.substring(i, j);
  }

  public final String zzg(String paramString1, String paramString2)
  {
    String str1 = zzci(paramString1);
    String str2 = zzci(paramString2);
    if (TextUtils.isEmpty(str1))
      return str2;
    if (TextUtils.isEmpty(str2))
      return str1;
    return 1 + String.valueOf(str1).length() + String.valueOf(str2).length() + str1 + "," + str2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzade
 * JD-Core Version:    0.6.2
 */