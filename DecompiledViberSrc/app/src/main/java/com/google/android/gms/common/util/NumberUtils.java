package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@VisibleForTesting
public class NumberUtils
{
  @KeepForSdk
  public static long parseHexLong(String paramString)
  {
    if (paramString.length() > 16)
      throw new NumberFormatException(37 + String.valueOf(paramString).length() + "Invalid input: " + paramString + " exceeds 16 characters");
    if (paramString.length() == 16)
      return Long.parseLong(paramString.substring(8), 16) | Long.parseLong(paramString.substring(0, 8), 16) << 32;
    return Long.parseLong(paramString, 16);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.NumberUtils
 * JD-Core Version:    0.6.2
 */