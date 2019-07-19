package com.viber.voip.util;

import com.viber.voip.registration.af;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public final class bk
{
  private static final Pattern a = Pattern.compile("^[-+]?\\d{1,19}$");
  private static final Pattern b = Pattern.compile("^[-+]?\\d{1,10}$");

  public static long a(String paramString1, String paramString2)
    throws JSONException
  {
    if (da.a(paramString2))
      return 0L;
    if (!a.matcher(paramString2).matches())
      throw a(paramString1, paramString2, "long");
    return Long.parseLong(paramString2);
  }

  private static JSONException a(String paramString1, String paramString2, String paramString3)
  {
    return new JSONException("Invalid JSON: field " + paramString1 + " is " + paramString2 + " but expected to be " + paramString3);
  }

  public static JSONObject a(af paramaf, String paramString1, String paramString2, String paramString3)
    throws JSONException
  {
    return a(paramString1, paramString2, "+" + paramaf.b(), paramString3);
  }

  private static JSONObject a(String paramString1, String paramString2, String paramString3, String paramString4)
    throws JSONException
  {
    if (da.a(paramString1));
    JSONObject localJSONObject;
    do
    {
      return null;
      localJSONObject = new JSONObject(paramString1).getJSONObject(paramString2);
    }
    while (localJSONObject == null);
    if (localJSONObject.has(paramString3))
      return localJSONObject.getJSONObject(paramString3);
    return localJSONObject.optJSONObject(paramString4);
  }

  public static JSONObject a(Locale paramLocale, String paramString1, String paramString2, String paramString3)
    throws JSONException
  {
    return a(paramString1, paramString2, paramLocale.getLanguage(), paramString3);
  }

  public static boolean a(String paramString)
  {
    if (da.a(paramString));
    String str;
    do
    {
      return false;
      str = paramString.toLowerCase();
      if (ce.h.matcher(str).matches())
        return true;
      if (ce.b.matcher(str).matches())
        return true;
      if (ce.c.matcher(str).matches())
        return true;
      if (ce.e.matcher(str).matches())
        return true;
      if (ce.g.matcher(str).matches())
        return true;
    }
    while (!ce.f.matcher(str).matches());
    return true;
  }

  public static boolean a(String paramString1, StringBuilder paramStringBuilder, String paramString2, String paramString3)
  {
    int i = paramString1.indexOf('{');
    if (i >= 0)
    {
      int j = i + 1;
      StringBuilder localStringBuilder = new StringBuilder().append(c(paramString2, paramString3));
      if ("{}".equals(paramString1));
      for (String str = ""; ; str = ",")
      {
        paramStringBuilder.insert(j, str);
        return true;
      }
    }
    return false;
  }

  public static int b(String paramString1, String paramString2)
    throws JSONException
  {
    if (da.a(paramString2))
      return 0;
    if (!b.matcher(paramString2).matches())
      throw a(paramString1, paramString2, "int");
    return Integer.parseInt(paramString2);
  }

  private static String c(String paramString1, String paramString2)
  {
    return String.format(Locale.US, "\"%1$s\":%2$s", new Object[] { paramString1, paramString2 });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.bk
 * JD-Core Version:    0.6.2
 */