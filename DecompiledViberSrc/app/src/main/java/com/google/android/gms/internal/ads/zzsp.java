package com.google.android.gms.internal.ads;

public final class zzsp
{
  private static String zzau(String paramString)
  {
    if (paramString == null)
      return null;
    int i = paramString.indexOf('/');
    if (i == -1)
    {
      String str1 = String.valueOf(paramString);
      if (str1.length() != 0);
      for (String str2 = "Invalid mime type: ".concat(str1); ; str2 = new String("Invalid mime type: "))
        throw new IllegalArgumentException(str2);
    }
    return paramString.substring(0, i);
  }

  public static boolean zzav(String paramString)
  {
    return "audio".equals(zzau(paramString));
  }

  public static boolean zzbf(String paramString)
  {
    return "video".equals(zzau(paramString));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzsp
 * JD-Core Version:    0.6.2
 */