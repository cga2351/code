package com.viber.common.d;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.text.BidiFormatter;
import android.text.TextUtils;
import java.util.Locale;

public class c
{
  public static CharSequence a(CharSequence paramCharSequence)
  {
    return BidiFormatter.getInstance(a()).unicodeWrap(paramCharSequence);
  }

  public static String a(Context paramContext, int paramInt1, int paramInt2, Object[] paramArrayOfObject)
  {
    return a(paramContext.getResources(), paramInt1, paramInt2, paramArrayOfObject);
  }

  public static String a(Context paramContext, int paramInt, Object[] paramArrayOfObject)
  {
    return a(paramContext.getResources(), paramInt, paramArrayOfObject);
  }

  public static String a(Resources paramResources, int paramInt1, int paramInt2, Object[] paramArrayOfObject)
  {
    return paramResources.getQuantityString(paramInt1, paramInt2, a(paramArrayOfObject));
  }

  public static String a(Resources paramResources, int paramInt, Object[] paramArrayOfObject)
  {
    return paramResources.getString(paramInt, a(paramArrayOfObject));
  }

  public static String a(String paramString)
  {
    return BidiFormatter.getInstance(a()).unicodeWrap(paramString);
  }

  public static boolean a()
  {
    return a(Locale.getDefault());
  }

  private static boolean a(Locale paramLocale)
  {
    String str = paramLocale.getDisplayName();
    if (TextUtils.isEmpty(str))
      return false;
    switch (Character.getDirectionality(str.charAt(0)))
    {
    default:
      return false;
    case 1:
    case 2:
    }
    return true;
  }

  public static Object[] a(Object[] paramArrayOfObject)
  {
    BidiFormatter localBidiFormatter = BidiFormatter.getInstance(a());
    for (int i = 0; i < paramArrayOfObject.length; i++)
      if ((paramArrayOfObject[i] instanceof String))
        paramArrayOfObject[i] = localBidiFormatter.unicodeWrap((String)paramArrayOfObject[i]);
    return paramArrayOfObject;
  }

  public static String b(String paramString)
  {
    return BidiFormatter.getInstance(false).unicodeWrap(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.d.c
 * JD-Core Version:    0.6.2
 */