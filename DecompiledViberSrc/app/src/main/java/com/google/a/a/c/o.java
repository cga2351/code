package com.google.a.a.c;

import com.google.a.a.f.z;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class o
{
  private static final Pattern a = Pattern.compile("[\\w!#$&.+\\-\\^_]+|[*]");
  private static final Pattern b = Pattern.compile("[\\p{ASCII}&&[^\\p{Cntrl} ;/=\\[\\]\\(\\)\\<\\>\\@\\,\\:\\\"\\?\\=]]+");
  private static final Pattern c;
  private static final Pattern d = Pattern.compile(12 + str7.length() + str8.length() + "\\s*;\\s*(" + str7 + ")" + "=(" + str8 + ")");
  private String e = "application";
  private String f = "octet-stream";
  private final SortedMap<String, String> g = new TreeMap();
  private String h;

  static
  {
    String str1 = String.valueOf(String.valueOf("[^\\s/=;\"]+"));
    String str2 = String.valueOf(String.valueOf("[^\\s/=;\"]+"));
    String str3 = String.valueOf(String.valueOf(";.*"));
    c = Pattern.compile(14 + str1.length() + str2.length() + str3.length() + "\\s*(" + str1 + ")/(" + str2 + ")" + "\\s*(" + str3 + ")?", 32);
    String str4 = String.valueOf(String.valueOf("\"([^\"]*)\""));
    String str5 = String.valueOf(String.valueOf("[^\\s;\"]*"));
    String str6 = 1 + str4.length() + str5.length() + str4 + "|" + str5;
    String str7 = String.valueOf(String.valueOf("[^\\s/=;\"]+"));
    String str8 = String.valueOf(String.valueOf(str6));
  }

  public o(String paramString)
  {
    f(paramString);
  }

  public static boolean b(String paramString1, String paramString2)
  {
    return ((paramString1 == null) && (paramString2 == null)) || ((paramString1 != null) && (paramString2 != null) && (new o(paramString1).a(new o(paramString2))));
  }

  static boolean e(String paramString)
  {
    return b.matcher(paramString).matches();
  }

  private o f(String paramString)
  {
    Matcher localMatcher1 = c.matcher(paramString);
    z.a(localMatcher1.matches(), "Type must be in the 'maintype/subtype; parameter=value' format");
    a(localMatcher1.group(1));
    b(localMatcher1.group(2));
    String str1 = localMatcher1.group(3);
    if (str1 != null)
    {
      Matcher localMatcher2 = d.matcher(str1);
      while (localMatcher2.find())
      {
        String str2 = localMatcher2.group(1);
        String str3 = localMatcher2.group(3);
        if (str3 == null)
          str3 = localMatcher2.group(2);
        a(str2, str3);
      }
    }
    return this;
  }

  private static String g(String paramString)
  {
    String str = String.valueOf(String.valueOf(paramString.replace("\\", "\\\\").replace("\"", "\\\"")));
    return 2 + str.length() + "\"" + str + "\"";
  }

  public o a(String paramString)
  {
    z.a(a.matcher(paramString).matches(), "Type contains reserved characters");
    this.e = paramString;
    this.h = null;
    return this;
  }

  public o a(String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      d(paramString1);
      return this;
    }
    z.a(b.matcher(paramString1).matches(), "Name contains reserved characters");
    this.h = null;
    this.g.put(paramString1.toLowerCase(), paramString2);
    return this;
  }

  public o a(Charset paramCharset)
  {
    if (paramCharset == null);
    for (String str = null; ; str = paramCharset.name())
    {
      a("charset", str);
      return this;
    }
  }

  public String a()
  {
    return this.e;
  }

  public boolean a(o paramo)
  {
    return (paramo != null) && (a().equalsIgnoreCase(paramo.a())) && (b().equalsIgnoreCase(paramo.b()));
  }

  public o b(String paramString)
  {
    z.a(a.matcher(paramString).matches(), "Subtype contains reserved characters");
    this.f = paramString;
    this.h = null;
    return this;
  }

  public String b()
  {
    return this.f;
  }

  public String c()
  {
    if (this.h != null)
      return this.h;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.e);
    localStringBuilder.append('/');
    localStringBuilder.append(this.f);
    if (this.g != null)
    {
      Iterator localIterator = this.g.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str = (String)localEntry.getValue();
        localStringBuilder.append("; ");
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append("=");
        if (!e(str))
          str = g(str);
        localStringBuilder.append(str);
      }
    }
    this.h = localStringBuilder.toString();
    return this.h;
  }

  public String c(String paramString)
  {
    return (String)this.g.get(paramString.toLowerCase());
  }

  public o d(String paramString)
  {
    this.h = null;
    this.g.remove(paramString.toLowerCase());
    return this;
  }

  public Charset d()
  {
    String str = c("charset");
    if (str == null)
      return null;
    return Charset.forName(str);
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof o));
    o localo;
    do
    {
      return false;
      localo = (o)paramObject;
    }
    while ((!a(localo)) || (!this.g.equals(localo.g)));
    return true;
  }

  public int hashCode()
  {
    return c().hashCode();
  }

  public String toString()
  {
    return c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.c.o
 * JD-Core Version:    0.6.2
 */