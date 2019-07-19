package com.google.android.gms.auth;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;

public final class CookieUtil
{
  public static String getCookieUrl(String paramString, Boolean paramBoolean)
  {
    Preconditions.checkNotEmpty(paramString);
    if (zza(paramBoolean));
    for (String str = "https"; ; str = "http")
      return 3 + String.valueOf(str).length() + String.valueOf(paramString).length() + str + "://" + paramString;
  }

  public static String getCookieValue(String paramString1, String paramString2, String paramString3, String paramString4, Boolean paramBoolean1, Boolean paramBoolean2, Long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString1).append('=');
    if (!TextUtils.isEmpty(paramString2))
      localStringBuilder.append(paramString2);
    if (zza(paramBoolean1))
      localStringBuilder.append(";HttpOnly");
    if (zza(paramBoolean2))
      localStringBuilder.append(";Secure");
    if (!TextUtils.isEmpty(paramString3))
      localStringBuilder.append(";Domain=").append(paramString3);
    if (!TextUtils.isEmpty(paramString4))
      localStringBuilder.append(";Path=").append(paramString4);
    if ((paramLong != null) && (paramLong.longValue() > 0L))
      localStringBuilder.append(";Max-Age=").append(paramLong);
    return localStringBuilder.toString();
  }

  private static boolean zza(Boolean paramBoolean)
  {
    return (paramBoolean != null) && (paramBoolean.booleanValue());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.CookieUtil
 * JD-Core Version:    0.6.2
 */