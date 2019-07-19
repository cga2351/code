package com.viber.voip.analytics.story.l;

import com.viber.voip.analytics.story.b.a;
import com.viber.voip.analytics.story.f.a;
import com.viber.voip.analytics.t.b;
import com.viber.voip.util.da;
import com.viber.voip.util.upload.b.b;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class d
{
  static Pattern a = Pattern.compile("(.+?)[\\,=;/'\"].*");

  public static com.viber.voip.analytics.story.e a(long paramLong)
  {
    f.a locala = new b.a().a(t.b.b).a(t.b.f).a();
    return a("database", "update", t.b.f).a("nmsgs", Long.toString(()Math.log10(Math.max(1L, paramLong)))).a(com.viber.voip.analytics.f.d.class, locala);
  }

  public static com.viber.voip.analytics.story.e a(long paramLong1, long paramLong2)
  {
    f.a locala = new b.a().a(t.b.a).a(t.b.g).a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("push");
    localStringBuilder.append(" ");
    localStringBuilder.append(b(paramLong1 - paramLong2));
    localStringBuilder.append("; ");
    localStringBuilder.append("app");
    localStringBuilder.append(" ");
    localStringBuilder.append(b(paramLong2));
    return a("CallPush", t.b.g).a("delay", localStringBuilder.toString()).a(com.viber.voip.analytics.f.d.class, locala);
  }

  public static com.viber.voip.analytics.story.e a(String paramString)
  {
    f.a locala = new b.a().a(t.b.a).a(new String[] { "state" }).a();
    return a("mid_migration_1", null).a("state", paramString).a(com.viber.voip.analytics.f.d.class, locala);
  }

  public static com.viber.voip.analytics.story.e a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    f.a locala = new b.a().a(t.b.a).a(new String[] { "state" }).a(new String[] { "server_error" }).a(new String[] { "numbersCount" }).a(new String[] { "connectionType" }).a("numbersCount", new e(paramInt2)).a();
    return a("mid_migration_1", null).a("state", paramString1).a("server_error", String.valueOf(paramInt1)).a("numbersCount", Integer.valueOf(paramInt2)).a("connectionType", paramString2).a(com.viber.voip.analytics.f.d.class, locala);
  }

  public static com.viber.voip.analytics.story.e a(String paramString, b.b paramb)
  {
    return c(paramString, a(paramb));
  }

  public static com.viber.voip.analytics.story.e a(String paramString1, String paramString2)
  {
    f.a locala = new b.a().a(t.b.a).a(t.b.d).a();
    com.viber.voip.analytics.story.e locale = a("Download", t.b.d).a("exc", paramString1);
    if (!da.a(paramString2))
      locale.a("desc", d(paramString2));
    locale.a(com.viber.voip.analytics.f.d.class, locala);
    return locale;
  }

  public static com.viber.voip.analytics.story.e a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    f.a locala = new b.a().a(t.b.a).a(t.b.i).a();
    return a(paramString1, t.b.i).a("error", paramString2).a("exc", paramString3).a("desc", paramString4).a(com.viber.voip.analytics.f.d.class, locala);
  }

  public static com.viber.voip.analytics.story.e a(String paramString1, String paramString2, boolean paramBoolean)
  {
    f.a locala = new b.a().a(t.b.b).a(t.b.e).a();
    String str1;
    com.viber.voip.analytics.story.e locale;
    if (paramString1.equals("0"))
    {
      str1 = "register";
      locale = a("registration", str1, t.b.e);
      if (!paramBoolean)
        break label85;
    }
    label85: for (String str2 = "0"; ; str2 = "1")
    {
      return locale.a("primary", str2).a("key", paramString2).a(com.viber.voip.analytics.f.d.class, locala);
      str1 = "re_register";
      break;
    }
  }

  private static com.viber.voip.analytics.story.e a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return a(paramString1, paramArrayOfString).a("api", paramString2);
  }

  private static com.viber.voip.analytics.story.e a(String paramString, final String[] paramArrayOfString)
  {
    return new com.viber.voip.analytics.story.d(paramString)
    {
    };
  }

  private static String a(b.b paramb)
  {
    switch (2.a[paramb.ordinal()])
    {
    default:
      return "UNKNOWN";
    case 1:
      return "REDIRECT";
    case 2:
      return "TOO_MANY_REDIRECTS";
    case 3:
      return "INTERRUPTED";
    case 4:
      return "NETWORK_TIMEOUT";
    case 5:
      return "INCOMPLETE";
    case 6:
      return "FORBIDDEN";
    case 7:
      return "NO_SPACE";
    case 8:
      return "MALFORMED_URL";
    case 9:
    }
    return "IO_ERROR";
  }

  public static com.viber.voip.analytics.story.e b(String paramString)
  {
    f.a locala = new b.a().a(t.b.a).a(new String[] { "dialog_code" }).a();
    return a("dialog_from_background", null).a("dialog_code", paramString).a(com.viber.voip.analytics.f.d.class, locala);
  }

  public static com.viber.voip.analytics.story.e b(String paramString1, String paramString2)
  {
    f.a locala = new b.a().a(t.b.a).a(t.b.d).a();
    com.viber.voip.analytics.story.e locale = a("Upload", t.b.d).a("exc", paramString1);
    if (!da.a(paramString2))
      locale.a("desc", d(paramString2));
    locale.a(com.viber.voip.analytics.f.d.class, locala);
    return locale;
  }

  private static String b(long paramLong)
  {
    if (paramLong > 600L)
      return "> 10 min";
    if (paramLong > 300L)
      return "5-10 min";
    if (paramLong > 180L)
      return "3-5 min";
    if (paramLong > 120L)
      return "2-3 min";
    if (paramLong > 60L)
      return "1-2 min";
    return "< 1 min";
  }

  public static com.viber.voip.analytics.story.e c(String paramString)
  {
    f.a locala = new b.a().a(t.b.a).a(t.b.h).a();
    return a("Encryption", t.b.h).a("error", paramString).a(com.viber.voip.analytics.f.d.class, locala);
  }

  public static com.viber.voip.analytics.story.e c(String paramString1, String paramString2)
  {
    f.a locala = new b.a().a(t.b.a).a(t.b.h).a();
    return a(paramString1, t.b.h).a("error", paramString2).a(com.viber.voip.analytics.f.d.class, locala);
  }

  private static String d(String paramString)
  {
    try
    {
      Matcher localMatcher = a.matcher(paramString);
      if (localMatcher.matches())
      {
        String str = localMatcher.group(1);
        paramString = str;
      }
      return paramString;
    }
    catch (Exception localException)
    {
      while (paramString.length() <= 80);
    }
    return paramString.substring(0, 80);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.l.d
 * JD-Core Version:    0.6.2
 */