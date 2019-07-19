package com.crashlytics.android.c;

import c.a.a.a.c;
import c.a.a.a.l;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class am
{
  private static final Pattern a = Pattern.compile("\\s*(\\p{XDigit}+)-\\s*(\\p{XDigit}+)\\s+(.{4})\\s+\\p{XDigit}+\\s+.+\\s+\\d+\\s+(.*)");

  public static al a(String paramString)
  {
    Matcher localMatcher = a.matcher(paramString);
    if (!localMatcher.matches())
      return null;
    try
    {
      long l = Long.valueOf(localMatcher.group(1), 16).longValue();
      al localal = new al(l, Long.valueOf(localMatcher.group(2), 16).longValue() - l, localMatcher.group(3), localMatcher.group(4));
      return localal;
    }
    catch (Exception localException)
    {
      c.g().a("CrashlyticsCore", "Could not parse map entry: " + paramString);
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.am
 * JD-Core Version:    0.6.2
 */