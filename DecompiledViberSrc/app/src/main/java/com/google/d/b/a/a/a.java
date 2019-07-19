package com.google.d.b.a.a;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class a
{
  private static final TimeZone a = TimeZone.getTimeZone("UTC");

  private static int a(String paramString, int paramInt)
  {
    while (paramInt < paramString.length())
    {
      int i = paramString.charAt(paramInt);
      if ((i < 48) || (i > 57))
        return paramInt;
      paramInt++;
    }
    return paramString.length();
  }

  private static int a(String paramString, int paramInt1, int paramInt2)
    throws NumberFormatException
  {
    if ((paramInt1 < 0) || (paramInt2 > paramString.length()) || (paramInt1 > paramInt2))
      throw new NumberFormatException(paramString);
    int i;
    int j;
    if (paramInt1 < paramInt2)
    {
      i = paramInt1 + 1;
      int n = Character.digit(paramString.charAt(paramInt1), 10);
      if (n < 0)
        throw new NumberFormatException("Invalid number: " + paramString.substring(paramInt1, paramInt2));
      j = -n;
    }
    while (true)
      if (i < paramInt2)
      {
        int k = i + 1;
        int m = Character.digit(paramString.charAt(i), 10);
        if (m < 0)
          throw new NumberFormatException("Invalid number: " + paramString.substring(paramInt1, paramInt2));
        j = j * 10 - m;
        i = k;
      }
      else
      {
        return -j;
        i = paramInt1;
        j = 0;
      }
  }

  public static Date a(String paramString, ParsePosition paramParsePosition)
    throws ParseException
  {
    try
    {
      int i = paramParsePosition.getIndex();
      j = i + 4;
      k = a(paramString, i, j);
      if (a(paramString, j, '-'))
      {
        m = j + 1;
        n = m + 2;
        i1 = a(paramString, m, n);
        if (a(paramString, n, '-'))
        {
          i2 = n + 1;
          i3 = i2 + 2;
          i4 = a(paramString, i2, i3);
          boolean bool = a(paramString, i3, 'T');
          if ((!bool) && (paramString.length() <= i3))
          {
            GregorianCalendar localGregorianCalendar1 = new GregorianCalendar(k, i1 - 1, i4);
            paramParsePosition.setIndex(i3);
            return localGregorianCalendar1.getTime();
          }
          if (bool)
          {
            int i10 = i3 + 1;
            i11 = i10 + 2;
            i12 = a(paramString, i10, i11);
            if (a(paramString, i11, ':'))
            {
              i13 = i11 + 1;
              i3 = i13 + 2;
              i14 = a(paramString, i13, i3);
              if (a(paramString, i3, ':'))
                i3++;
              if (paramString.length() > i3)
              {
                int i15 = paramString.charAt(i3);
                if ((i15 != 90) && (i15 != 43) && (i15 != 45))
                {
                  i16 = i3 + 2;
                  i17 = a(paramString, i3, i16);
                  if ((i17 > 59) && (i17 < 63))
                    i17 = 59;
                  if (a(paramString, i16, '.'))
                  {
                    int i18 = i16 + 1;
                    i19 = a(paramString, i18 + 1);
                    int i20 = Math.min(i19, i18 + 3);
                    i21 = a(paramString, i18, i20);
                    switch (i20 - i18)
                    {
                    case 2:
                      if (paramString.length() <= i3)
                        throw new IllegalArgumentException("No time zone indicator");
                      break;
                    case 1:
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      int k;
      int i1;
      int i4;
      localObject = localIndexOutOfBoundsException;
      if (paramString == null)
      {
        str1 = null;
        String str2 = ((Exception)localObject).getMessage();
        if ((str2 == null) || (str2.isEmpty()))
          str2 = "(" + localObject.getClass().getName() + ")";
        ParseException localParseException = new ParseException("Failed to parse date [" + str1 + "]: " + str2, paramParsePosition.getIndex());
        localParseException.initCause((Throwable)localObject);
        throw localParseException;
        i21 *= 10;
        break label963;
        i21 *= 100;
        break label963;
        c = paramString.charAt(i3);
        if (c != 'Z')
          break label986;
        TimeZone localTimeZone = a;
        int i9 = i3 + 1;
        String str4;
        String str5;
        do
        {
          GregorianCalendar localGregorianCalendar2 = new GregorianCalendar(localTimeZone);
          localGregorianCalendar2.setLenient(false);
          localGregorianCalendar2.set(1, k);
          localGregorianCalendar2.set(2, i1 - 1);
          localGregorianCalendar2.set(5, i4);
          localGregorianCalendar2.set(11, i8);
          localGregorianCalendar2.set(12, i7);
          localGregorianCalendar2.set(13, i6);
          localGregorianCalendar2.set(14, i5);
          paramParsePosition.setIndex(i9);
          return localGregorianCalendar2.getTime();
          String str3 = paramString.substring(i3);
          if (str3.length() >= 5);
          while (true)
          {
            i9 = i3 + str3.length();
            if ((!"+0000".equals(str3)) && (!"+00:00".equals(str3)))
              break label716;
            localTimeZone = a;
            break;
            str3 = str3 + "00";
          }
          str4 = "GMT" + str3;
          localTimeZone = TimeZone.getTimeZone(str4);
          str5 = localTimeZone.getID();
        }
        while ((str5.equals(str4)) || (str5.replace(":", "").equals(str4)));
        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str4 + " given, resolves to " + localTimeZone.getID());
        throw new IndexOutOfBoundsException("Invalid time zone indicator '" + c + "'");
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
      {
        int j;
        int n;
        int i11;
        int i12;
        int i14;
        int i16;
        int i17;
        int i19;
        int i21;
        char c;
        localObject = localIllegalArgumentException;
        continue;
        String str1 = '"' + paramString + "'";
        continue;
        int i8 = i12;
        int i6 = i17;
        int i3 = i16;
        int i7 = i14;
        int i5 = 0;
        continue;
        i7 = i14;
        i8 = i12;
        i5 = 0;
        i6 = 0;
        continue;
        int i13 = i11;
        continue;
        i5 = 0;
        i6 = 0;
        i7 = 0;
        i8 = 0;
        continue;
        int i2 = n;
        continue;
        int m = j;
        continue;
        i8 = i12;
        i6 = i17;
        i3 = i19;
        i7 = i14;
        i5 = i21;
        continue;
        if (c != '+')
          if (c != '-');
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label963: 
      while (true)
        label716: label986: Object localObject = localNumberFormatException;
    }
  }

  private static boolean a(String paramString, int paramInt, char paramChar)
  {
    return (paramInt < paramString.length()) && (paramString.charAt(paramInt) == paramChar);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.b.a.a.a
 * JD-Core Version:    0.6.2
 */