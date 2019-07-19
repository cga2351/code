package okhttp3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

public final class Cookie
{
  private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
  private static final Pattern MONTH_PATTERN;
  private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
  private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
  private final String domain;
  private final long expiresAt;
  private final boolean hostOnly;
  private final boolean httpOnly;
  private final String name;
  private final String path;
  private final boolean persistent;
  private final boolean secure;
  private final String value;

  static
  {
    MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
  }

  private Cookie(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.name = paramString1;
    this.value = paramString2;
    this.expiresAt = paramLong;
    this.domain = paramString3;
    this.path = paramString4;
    this.secure = paramBoolean1;
    this.httpOnly = paramBoolean2;
    this.hostOnly = paramBoolean3;
    this.persistent = paramBoolean4;
  }

  Cookie(Builder paramBuilder)
  {
    if (paramBuilder.name == null)
      throw new NullPointerException("builder.name == null");
    if (paramBuilder.value == null)
      throw new NullPointerException("builder.value == null");
    if (paramBuilder.domain == null)
      throw new NullPointerException("builder.domain == null");
    this.name = paramBuilder.name;
    this.value = paramBuilder.value;
    this.expiresAt = paramBuilder.expiresAt;
    this.domain = paramBuilder.domain;
    this.path = paramBuilder.path;
    this.secure = paramBuilder.secure;
    this.httpOnly = paramBuilder.httpOnly;
    this.persistent = paramBuilder.persistent;
    this.hostOnly = paramBuilder.hostOnly;
  }

  private static int dateCharacterOffset(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    label109: label115: label121: for (int i = paramInt1; ; i++)
    {
      int k;
      if (i < paramInt2)
      {
        int j = paramString.charAt(i);
        if (((j >= 32) || (j == 9)) && (j < 127) && ((j < 48) || (j > 57)) && ((j < 97) || (j > 122)) && ((j < 65) || (j > 90)) && (j != 58))
          break label109;
        k = 1;
        if (paramBoolean)
          break label115;
      }
      for (int m = 1; ; m = 0)
      {
        if (k != m)
          break label121;
        paramInt2 = i;
        return paramInt2;
        k = 0;
        break;
      }
    }
  }

  private static boolean domainMatch(String paramString1, String paramString2)
  {
    if (paramString1.equals(paramString2));
    while ((paramString1.endsWith(paramString2)) && (paramString1.charAt(-1 + (paramString1.length() - paramString2.length())) == '.') && (!Util.verifyAsIpAddress(paramString1)))
      return true;
    return false;
  }

  @Nullable
  static Cookie parse(long paramLong, HttpUrl paramHttpUrl, String paramString)
  {
    int i = paramString.length();
    int j = Util.delimiterOffset(paramString, 0, i, ';');
    int k = Util.delimiterOffset(paramString, 0, j, '=');
    if (k == j)
      return null;
    String str1 = Util.trimSubstring(paramString, 0, k);
    if ((str1.isEmpty()) || (Util.indexOfControlOrNonAscii(str1) != -1))
      return null;
    String str2 = Util.trimSubstring(paramString, k + 1, j);
    if (Util.indexOfControlOrNonAscii(str2) != -1)
      return null;
    long l1 = 253402300799999L;
    long l2 = -1L;
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = true;
    boolean bool4 = false;
    int m = j + 1;
    int i1;
    String str6;
    String str7;
    if (m < i)
    {
      i1 = Util.delimiterOffset(paramString, m, i, ';');
      int i2 = Util.delimiterOffset(paramString, m, i1, '=');
      str6 = Util.trimSubstring(paramString, m, i2);
      if (i2 < i1)
      {
        str7 = Util.trimSubstring(paramString, i2 + 1, i1);
        if (!str6.equalsIgnoreCase("expires"))
          break label261;
      }
    }
    while (true)
    {
      Object localObject4;
      long l5;
      try
      {
        long l7 = parseExpires(str7, 0, str7.length());
        bool4 = true;
        localObject4 = localObject1;
        l5 = l7;
        int i3 = i1 + 1;
        Object localObject5 = localObject4;
        m = i3;
        l1 = l5;
        localObject1 = localObject5;
        break;
        str7 = "";
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        localObject4 = localObject1;
        l5 = l1;
        continue;
      }
      label261: if (str6.equalsIgnoreCase("max-age"))
      {
        try
        {
          long l6 = parseMaxAge(str7);
          l2 = l6;
          bool4 = true;
          localObject4 = localObject1;
          l5 = l1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localObject4 = localObject1;
          l5 = l1;
        }
      }
      else if (str6.equalsIgnoreCase("domain"))
      {
        try
        {
          String str8 = parseDomain(str7);
          localObject4 = str8;
          l5 = l1;
          bool3 = false;
        }
        catch (IllegalArgumentException localIllegalArgumentException1)
        {
          localObject4 = localObject1;
          l5 = l1;
        }
      }
      else if (str6.equalsIgnoreCase("path"))
      {
        localObject2 = str7;
        localObject4 = localObject1;
        l5 = l1;
      }
      else if (str6.equalsIgnoreCase("secure"))
      {
        bool1 = true;
        localObject4 = localObject1;
        l5 = l1;
      }
      else if (str6.equalsIgnoreCase("httponly"))
      {
        bool2 = true;
        localObject4 = localObject1;
        l5 = l1;
        continue;
        long l3;
        if (l2 == -9223372036854775808L)
          l3 = -9223372036854775808L;
        while (true)
        {
          String str3 = paramHttpUrl.host();
          if (localObject1 == null)
            localObject1 = str3;
          while (true)
            if ((str3.length() != localObject1.length()) && (PublicSuffixDatabase.get().getEffectiveTldPlusOne(localObject1) == null))
            {
              return null;
              if (l2 == -1L)
                break label646;
              if (l2 <= 9223372036854775L);
              for (long l4 = l2 * 1000L; ; l4 = 9223372036854775807L)
              {
                l3 = l4 + paramLong;
                if ((l3 >= paramLong) && (l3 <= 253402300799999L))
                  break;
                l3 = 253402300799999L;
                break;
              }
              if (!domainMatch(str3, localObject1))
                return null;
            }
          String str5;
          if ((localObject2 == null) || (!localObject2.startsWith("/")))
          {
            String str4 = paramHttpUrl.encodedPath();
            int n = str4.lastIndexOf('/');
            if (n != 0)
              str5 = str4.substring(0, n);
          }
          for (Object localObject3 = str5; ; localObject3 = localObject2)
          {
            return new Cookie(str1, str2, l3, localObject1, (String)localObject3, bool1, bool2, bool3, bool4);
            str5 = "/";
            break;
          }
          label646: l3 = l1;
        }
      }
      else
      {
        localObject4 = localObject1;
        l5 = l1;
      }
    }
  }

  @Nullable
  public static Cookie parse(HttpUrl paramHttpUrl, String paramString)
  {
    return parse(System.currentTimeMillis(), paramHttpUrl, paramString);
  }

  public static List<Cookie> parseAll(HttpUrl paramHttpUrl, Headers paramHeaders)
  {
    List localList = paramHeaders.values("Set-Cookie");
    Object localObject1 = null;
    int i = localList.size();
    int j = 0;
    Cookie localCookie;
    while (j < i)
    {
      localCookie = parse(paramHttpUrl, (String)localList.get(j));
      if (localCookie == null)
        j++;
      else
        if (localObject1 != null)
          break label97;
    }
    label97: for (Object localObject2 = new ArrayList(); ; localObject2 = localObject1)
    {
      ((List)localObject2).add(localCookie);
      localObject1 = localObject2;
      break;
      if (localObject1 != null)
        return Collections.unmodifiableList(localObject1);
      return Collections.emptyList();
    }
  }

  private static String parseDomain(String paramString)
  {
    if (paramString.endsWith("."))
      throw new IllegalArgumentException();
    if (paramString.startsWith("."))
      paramString = paramString.substring(1);
    String str = Util.canonicalizeHost(paramString);
    if (str == null)
      throw new IllegalArgumentException();
    return str;
  }

  private static long parseExpires(String paramString, int paramInt1, int paramInt2)
  {
    int i = dateCharacterOffset(paramString, paramInt1, paramInt2, false);
    int j = -1;
    int k = -1;
    int m = -1;
    int n = -1;
    int i1 = -1;
    int i2 = -1;
    Matcher localMatcher = TIME_PATTERN.matcher(paramString);
    if (i < paramInt2)
    {
      int i3 = dateCharacterOffset(paramString, i + 1, paramInt2, true);
      localMatcher.region(i, i3);
      if ((j == -1) && (localMatcher.usePattern(TIME_PATTERN).matches()))
      {
        j = Integer.parseInt(localMatcher.group(1));
        k = Integer.parseInt(localMatcher.group(2));
        m = Integer.parseInt(localMatcher.group(3));
      }
      while (true)
      {
        i = dateCharacterOffset(paramString, i3 + 1, paramInt2, false);
        break;
        if ((n == -1) && (localMatcher.usePattern(DAY_OF_MONTH_PATTERN).matches()))
        {
          n = Integer.parseInt(localMatcher.group(1));
        }
        else if ((i1 == -1) && (localMatcher.usePattern(MONTH_PATTERN).matches()))
        {
          String str = localMatcher.group(1).toLowerCase(Locale.US);
          i1 = MONTH_PATTERN.pattern().indexOf(str) / 4;
        }
        else if ((i2 == -1) && (localMatcher.usePattern(YEAR_PATTERN).matches()))
        {
          i2 = Integer.parseInt(localMatcher.group(1));
        }
      }
    }
    if ((i2 >= 70) && (i2 <= 99))
      i2 += 1900;
    if ((i2 >= 0) && (i2 <= 69))
      i2 += 2000;
    if (i2 < 1601)
      throw new IllegalArgumentException();
    if (i1 == -1)
      throw new IllegalArgumentException();
    if ((n < 1) || (n > 31))
      throw new IllegalArgumentException();
    if ((j < 0) || (j > 23))
      throw new IllegalArgumentException();
    if ((k < 0) || (k > 59))
      throw new IllegalArgumentException();
    if ((m < 0) || (m > 59))
      throw new IllegalArgumentException();
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(Util.UTC);
    localGregorianCalendar.setLenient(false);
    localGregorianCalendar.set(1, i2);
    localGregorianCalendar.set(2, i1 - 1);
    localGregorianCalendar.set(5, n);
    localGregorianCalendar.set(11, j);
    localGregorianCalendar.set(12, k);
    localGregorianCalendar.set(13, m);
    localGregorianCalendar.set(14, 0);
    return localGregorianCalendar.getTimeInMillis();
  }

  private static long parseMaxAge(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      if (l <= 0L)
        return -9223372036854775808L;
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (paramString.matches("-?\\d+"))
        if (!paramString.startsWith("-"))
          return 9223372036854775807L;
      throw localNumberFormatException;
    }
  }

  private static boolean pathMatch(HttpUrl paramHttpUrl, String paramString)
  {
    String str = paramHttpUrl.encodedPath();
    if (str.equals(paramString));
    while ((str.startsWith(paramString)) && ((paramString.endsWith("/")) || (str.charAt(paramString.length()) == '/')))
      return true;
    return false;
  }

  public String domain()
  {
    return this.domain;
  }

  public boolean equals(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof Cookie));
    Cookie localCookie;
    do
    {
      return false;
      localCookie = (Cookie)paramObject;
    }
    while ((!localCookie.name.equals(this.name)) || (!localCookie.value.equals(this.value)) || (!localCookie.domain.equals(this.domain)) || (!localCookie.path.equals(this.path)) || (localCookie.expiresAt != this.expiresAt) || (localCookie.secure != this.secure) || (localCookie.httpOnly != this.httpOnly) || (localCookie.persistent != this.persistent) || (localCookie.hostOnly != this.hostOnly));
    return true;
  }

  public long expiresAt()
  {
    return this.expiresAt;
  }

  public int hashCode()
  {
    int i = 31 * (31 * (31 * (31 * (31 * (527 + this.name.hashCode()) + this.value.hashCode()) + this.domain.hashCode()) + this.path.hashCode()) + (int)(this.expiresAt ^ this.expiresAt >>> 32));
    int j;
    int m;
    label91: int i1;
    label110: int i2;
    int i3;
    if (this.secure)
    {
      j = 0;
      int k = 31 * (j + i);
      if (!this.httpOnly)
        break label145;
      m = 0;
      int n = 31 * (m + k);
      if (!this.persistent)
        break label151;
      i1 = 0;
      i2 = 31 * (i1 + n);
      boolean bool = this.hostOnly;
      i3 = 0;
      if (!bool)
        break label157;
    }
    while (true)
    {
      return i2 + i3;
      j = 1;
      break;
      label145: m = 1;
      break label91;
      label151: i1 = 1;
      break label110;
      label157: i3 = 1;
    }
  }

  public boolean hostOnly()
  {
    return this.hostOnly;
  }

  public boolean httpOnly()
  {
    return this.httpOnly;
  }

  public boolean matches(HttpUrl paramHttpUrl)
  {
    boolean bool;
    if (this.hostOnly)
    {
      bool = paramHttpUrl.host().equals(this.domain);
      if (bool)
        break label40;
    }
    label40: 
    while ((!pathMatch(paramHttpUrl, this.path)) || ((this.secure) && (!paramHttpUrl.isHttps())))
    {
      return false;
      bool = domainMatch(paramHttpUrl.host(), this.domain);
      break;
    }
    return true;
  }

  public String name()
  {
    return this.name;
  }

  public String path()
  {
    return this.path;
  }

  public boolean persistent()
  {
    return this.persistent;
  }

  public boolean secure()
  {
    return this.secure;
  }

  public String toString()
  {
    return toString(false);
  }

  String toString(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.name);
    localStringBuilder.append('=');
    localStringBuilder.append(this.value);
    if (this.persistent)
    {
      if (this.expiresAt != -9223372036854775808L)
        break label145;
      localStringBuilder.append("; max-age=0");
    }
    while (true)
    {
      if (!this.hostOnly)
      {
        localStringBuilder.append("; domain=");
        if (paramBoolean)
          localStringBuilder.append(".");
        localStringBuilder.append(this.domain);
      }
      localStringBuilder.append("; path=").append(this.path);
      if (this.secure)
        localStringBuilder.append("; secure");
      if (this.httpOnly)
        localStringBuilder.append("; httponly");
      return localStringBuilder.toString();
      label145: localStringBuilder.append("; expires=").append(HttpDate.format(new Date(this.expiresAt)));
    }
  }

  public String value()
  {
    return this.value;
  }

  public static final class Builder
  {
    String domain;
    long expiresAt = 253402300799999L;
    boolean hostOnly;
    boolean httpOnly;
    String name;
    String path = "/";
    boolean persistent;
    boolean secure;
    String value;

    private Builder domain(String paramString, boolean paramBoolean)
    {
      if (paramString == null)
        throw new NullPointerException("domain == null");
      String str = Util.canonicalizeHost(paramString);
      if (str == null)
        throw new IllegalArgumentException("unexpected domain: " + paramString);
      this.domain = str;
      this.hostOnly = paramBoolean;
      return this;
    }

    public Cookie build()
    {
      return new Cookie(this);
    }

    public Builder domain(String paramString)
    {
      return domain(paramString, false);
    }

    public Builder expiresAt(long paramLong)
    {
      long l1 = 253402300799999L;
      if (paramLong <= 0L);
      for (long l2 = -9223372036854775808L; ; l2 = paramLong)
      {
        if (l2 > l1);
        while (true)
        {
          this.expiresAt = l1;
          this.persistent = true;
          return this;
          l1 = l2;
        }
      }
    }

    public Builder hostOnlyDomain(String paramString)
    {
      return domain(paramString, true);
    }

    public Builder httpOnly()
    {
      this.httpOnly = true;
      return this;
    }

    public Builder name(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException("name == null");
      if (!paramString.trim().equals(paramString))
        throw new IllegalArgumentException("name is not trimmed");
      this.name = paramString;
      return this;
    }

    public Builder path(String paramString)
    {
      if (!paramString.startsWith("/"))
        throw new IllegalArgumentException("path must start with '/'");
      this.path = paramString;
      return this;
    }

    public Builder secure()
    {
      this.secure = true;
      return this;
    }

    public Builder value(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException("value == null");
      if (!paramString.trim().equals(paramString))
        throw new IllegalArgumentException("value is not trimmed");
      this.value = paramString;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.Cookie
 * JD-Core Version:    0.6.2
 */