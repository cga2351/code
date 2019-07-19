package com.google.a.a.f;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class k
  implements Serializable
{
  private static final TimeZone a = TimeZone.getTimeZone("GMT");
  private static final Pattern b = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})([Tt](\\d{2}):(\\d{2}):(\\d{2})(\\.\\d+)?)?([Zz]|([+-])(\\d{2}):(\\d{2}))?");
  private final long c;
  private final boolean d;
  private final int e;

  public k(long paramLong)
  {
    this(false, paramLong, null);
  }

  public k(String paramString)
  {
    k localk = a(paramString);
    this.d = localk.d;
    this.c = localk.c;
    this.e = localk.e;
  }

  public k(boolean paramBoolean, long paramLong, Integer paramInteger)
  {
    this.d = paramBoolean;
    this.c = paramLong;
    int i;
    if (paramBoolean)
      i = 0;
    while (true)
    {
      this.e = i;
      return;
      if (paramInteger == null)
        i = TimeZone.getDefault().getOffset(paramLong) / 60000;
      else
        i = paramInteger.intValue();
    }
  }

  public static k a(String paramString)
    throws NumberFormatException
  {
    Matcher localMatcher = b.matcher(paramString);
    if (!localMatcher.matches())
    {
      String str5 = String.valueOf(paramString);
      if (str5.length() != 0);
      for (String str6 = "Invalid date/time format: ".concat(str5); ; str6 = new String("Invalid date/time format: "))
        throw new NumberFormatException(str6);
    }
    int i = Integer.parseInt(localMatcher.group(1));
    int j = -1 + Integer.parseInt(localMatcher.group(2));
    int k = Integer.parseInt(localMatcher.group(3));
    int m;
    String str1;
    int n;
    label119: String str2;
    String str3;
    if (localMatcher.group(4) != null)
    {
      m = 1;
      str1 = localMatcher.group(9);
      if (str1 == null)
        break label175;
      n = 1;
      if ((n == 0) || (m != 0))
        break label195;
      str2 = String.valueOf("Invalid date/time format, cannot specify time zone shift without specifying time: ");
      str3 = String.valueOf(paramString);
      if (str3.length() == 0)
        break label181;
    }
    label175: label181: for (String str4 = str2.concat(str3); ; str4 = new String(str2))
    {
      throw new NumberFormatException(str4);
      m = 0;
      break;
      n = 0;
      break label119;
    }
    label195: int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i6;
    int i7;
    if (m != 0)
    {
      i1 = Integer.parseInt(localMatcher.group(5));
      i2 = Integer.parseInt(localMatcher.group(6));
      i3 = Integer.parseInt(localMatcher.group(7));
      if (localMatcher.group(8) != null)
      {
        i6 = Integer.parseInt(localMatcher.group(8).substring(1));
        i7 = -3 + localMatcher.group(8).substring(1).length();
      }
    }
    for (int i4 = (int)(i6 / Math.pow(10.0D, i7)); ; i4 = 0)
    {
      GregorianCalendar localGregorianCalendar = new GregorianCalendar(a);
      localGregorianCalendar.set(i, j, k, i1, i2, i3);
      localGregorianCalendar.set(14, i4);
      long l = localGregorianCalendar.getTimeInMillis();
      int i5;
      if ((m != 0) && (n != 0))
        if (Character.toUpperCase(str1.charAt(0)) == 'Z')
          i5 = 0;
      for (Integer localInteger = Integer.valueOf(i5); ; localInteger = null)
      {
        if (m == 0);
        for (boolean bool = true; ; bool = false)
        {
          return new k(bool, l, localInteger);
          i5 = 60 * Integer.parseInt(localMatcher.group(11)) + Integer.parseInt(localMatcher.group(12));
          if (localMatcher.group(10).charAt(0) == '-')
            i5 = -i5;
          l -= 60000L * i5;
          break;
        }
      }
    }
  }

  private static void a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
    {
      paramStringBuilder.append('-');
      paramInt1 = -paramInt1;
    }
    int i = paramInt1;
    while (i > 0)
    {
      i /= 10;
      paramInt2--;
    }
    for (int j = 0; j < paramInt2; j++)
      paramStringBuilder.append('0');
    if (paramInt1 != 0)
      paramStringBuilder.append(paramInt1);
  }

  public long a()
  {
    return this.c;
  }

  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(a);
    localGregorianCalendar.setTimeInMillis(this.c + 60000L * this.e);
    a(localStringBuilder, localGregorianCalendar.get(1), 4);
    localStringBuilder.append('-');
    a(localStringBuilder, 1 + localGregorianCalendar.get(2), 2);
    localStringBuilder.append('-');
    a(localStringBuilder, localGregorianCalendar.get(5), 2);
    if (!this.d)
    {
      localStringBuilder.append('T');
      a(localStringBuilder, localGregorianCalendar.get(11), 2);
      localStringBuilder.append(':');
      a(localStringBuilder, localGregorianCalendar.get(12), 2);
      localStringBuilder.append(':');
      a(localStringBuilder, localGregorianCalendar.get(13), 2);
      if (localGregorianCalendar.isSet(14))
      {
        localStringBuilder.append('.');
        a(localStringBuilder, localGregorianCalendar.get(14), 3);
      }
      if (this.e == 0)
        localStringBuilder.append('Z');
    }
    else
    {
      return localStringBuilder.toString();
    }
    int i = this.e;
    if (this.e > 0)
      localStringBuilder.append('+');
    while (true)
    {
      int j = i / 60;
      int k = i % 60;
      a(localStringBuilder, j, 2);
      localStringBuilder.append(':');
      a(localStringBuilder, k, 2);
      break;
      localStringBuilder.append('-');
      i = -i;
    }
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    k localk;
    do
    {
      return true;
      if (!(paramObject instanceof k))
        return false;
      localk = (k)paramObject;
    }
    while ((this.d == localk.d) && (this.c == localk.c) && (this.e == localk.e));
    return false;
  }

  public int hashCode()
  {
    long[] arrayOfLong = new long[3];
    arrayOfLong[0] = this.c;
    if (this.d);
    for (long l = 1L; ; l = 0L)
    {
      arrayOfLong[1] = l;
      arrayOfLong[2] = this.e;
      return Arrays.hashCode(arrayOfLong);
    }
  }

  public String toString()
  {
    return b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.f.k
 * JD-Core Version:    0.6.2
 */