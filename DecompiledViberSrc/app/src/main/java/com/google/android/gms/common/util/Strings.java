package com.google.android.gms.common.util;

import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.regex.Pattern;

@KeepForSdk
@VisibleForTesting
public class Strings
{
  private static final Pattern zzhf = Pattern.compile("\\$\\{(.*?)\\}");

  @KeepForSdk
  public static String emptyToNull(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      paramString = null;
    return paramString;
  }

  @KeepForSdk
  public static boolean isEmptyOrWhitespace(String paramString)
  {
    return (paramString == null) || (paramString.trim().isEmpty());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.Strings
 * JD-Core Version:    0.6.2
 */