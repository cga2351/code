package com.google.android.gms.internal.ads;

public final class zzkl
{
  public static String zzau(String paramString)
  {
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
    return zzau(paramString).equals("audio");
  }

  public static boolean zzaw(String paramString)
  {
    return ("audio/ac3".equals(paramString)) || ("audio/eac3".equals(paramString));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzkl
 * JD-Core Version:    0.6.2
 */