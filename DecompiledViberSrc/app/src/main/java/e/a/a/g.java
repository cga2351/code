package e.a.a;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.TreeMap;

public class g
{
  static TreeMap<String, Integer> a = new TreeMap(new a());
  static TreeMap<String, Integer> b = new TreeMap(new a());
  static TreeMap<String, TimeZone> c;
  private static HashSet<String> d = new HashSet();

  static
  {
    c = new TreeMap();
    d.add("MEZ");
    d.add("Uhr");
    d.add("h");
    d.add("pm");
    d.add("PM");
    d.add("AM");
    d.add("o'clock");
    String[] arrayOfString1 = TimeZone.getAvailableIDs();
    int i = arrayOfString1.length;
    Locale[] arrayOfLocale;
    int m;
    for (int j = 0; ; j++)
    {
      if (j >= i)
      {
        arrayOfLocale = DateFormatSymbols.getAvailableLocales();
        int k = arrayOfLocale.length;
        m = 0;
        if (m < k)
          break;
        return;
      }
      String str1 = arrayOfString1[j];
      c.put(str1, TimeZone.getTimeZone(str1));
    }
    Locale localLocale = arrayOfLocale[m];
    if ("ja".equals(localLocale.getLanguage()));
    while (("ko".equals(localLocale.getLanguage())) || ("zh".equals(localLocale.getLanguage())))
    {
      m++;
      break;
    }
    DateFormatSymbols localDateFormatSymbols = DateFormatSymbols.getInstance(localLocale);
    String[] arrayOfString2 = localDateFormatSymbols.getMonths();
    int n = 0;
    String[] arrayOfString3;
    int i1;
    String[] arrayOfString4;
    int i2;
    int i3;
    label308: String str4;
    if (n >= arrayOfString2.length)
    {
      arrayOfString3 = localDateFormatSymbols.getShortMonths();
      i1 = 0;
      if (i1 < arrayOfString3.length)
        break label373;
      arrayOfString4 = localDateFormatSymbols.getWeekdays();
      i2 = 0;
      if (i2 < arrayOfString4.length)
        break label454;
      String[] arrayOfString5 = localDateFormatSymbols.getShortWeekdays();
      i3 = 0;
      if (i3 < arrayOfString5.length)
      {
        str4 = arrayOfString5[i3];
        if (str4.length() != 0)
          break label511;
      }
    }
    while (true)
    {
      i3++;
      break label308;
      break;
      if (arrayOfString2[n].length() == 0);
      while (true)
      {
        n++;
        break;
        a(a, arrayOfString2[n], Integer.valueOf(n));
      }
      label373: String str2 = arrayOfString3[i1];
      if (str2.length() == 0);
      while (true)
      {
        i1++;
        break;
        if (!Character.isDigit(str2.charAt(-1 + str2.length())))
        {
          a(a, arrayOfString3[i1], Integer.valueOf(i1));
          a(a, arrayOfString3[i1].replace(".", ""), Integer.valueOf(i1));
        }
      }
      label454: String str3 = arrayOfString4[i2];
      if (str3.length() == 0);
      while (true)
      {
        i2++;
        break;
        a(b, str3, Integer.valueOf(i2));
        a(b, str3.replace(".", ""), Integer.valueOf(i2));
      }
      label511: a(b, str4, Integer.valueOf(i3));
      a(b, str4.replace(".", ""), Integer.valueOf(i3));
    }
  }

  private static Integer a(String paramString)
  {
    if (Character.isDigit(paramString.charAt(0)))
      return Integer.valueOf(-1 + Integer.parseInt(paramString));
    Integer localInteger = (Integer)a.get(paramString);
    if (localInteger == null)
      throw new NullPointerException("can not parse " + paramString + " as month");
    return Integer.valueOf(localInteger.intValue());
  }

  private static String a(StringTokenizer paramStringTokenizer, String paramString, Calendar paramCalendar)
  {
    while (true)
    {
      TimeZone localTimeZone = (TimeZone)c.get(paramString);
      if (localTimeZone != null)
      {
        paramCalendar.setTimeZone(localTimeZone);
        if (!paramStringTokenizer.hasMoreTokens())
          paramString = null;
      }
      while (!d.contains(paramString))
      {
        return paramString;
        paramString = paramStringTokenizer.nextToken();
        break;
      }
      if (paramString.equalsIgnoreCase("pm"))
        paramCalendar.add(9, 1);
      if (paramString.equalsIgnoreCase("am"))
        paramCalendar.add(9, 0);
      if (!paramStringTokenizer.hasMoreTokens())
        return null;
      paramString = paramStringTokenizer.nextToken();
    }
  }

  public static Date a(Object paramObject)
  {
    if (paramObject == null)
      return null;
    if ((paramObject instanceof Date))
      return (Date)paramObject;
    if ((paramObject instanceof Number))
      return new Date(((Number)paramObject).longValue());
    if ((paramObject instanceof String))
    {
      StringTokenizer localStringTokenizer = new StringTokenizer((String)paramObject, " -/:,.+");
      if (!localStringTokenizer.hasMoreTokens())
        return null;
      String str = localStringTokenizer.nextToken();
      if ((str.length() == 4) && (Character.isDigit(str.charAt(0))))
        return a(localStringTokenizer, str);
      if (b.containsKey(str))
      {
        if (!localStringTokenizer.hasMoreTokens())
          return null;
        str = localStringTokenizer.nextToken();
      }
      if (a.containsKey(str))
        return b(localStringTokenizer, str);
      if (Character.isDigit(str.charAt(0)))
        return c(localStringTokenizer, str);
      return null;
    }
    throw new RuntimeException("Primitive: Can not convert " + paramObject.getClass().getName() + " to int");
  }

  private static Date a(StringTokenizer paramStringTokenizer, String paramString)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(2000, 0, 0, 0, 0, 0);
    localGregorianCalendar.setTimeInMillis(0L);
    localGregorianCalendar.set(1, Integer.parseInt(paramString));
    if (!paramStringTokenizer.hasMoreTokens())
      return localGregorianCalendar.getTime();
    localGregorianCalendar.set(2, a(paramStringTokenizer.nextToken()).intValue());
    if (!paramStringTokenizer.hasMoreTokens())
      return localGregorianCalendar.getTime();
    String str = paramStringTokenizer.nextToken();
    if (Character.isDigit(str.charAt(0)))
    {
      if ((str.length() == 5) && (str.charAt(2) == 'T'))
      {
        localGregorianCalendar.set(5, Integer.parseInt(str.substring(0, 2)));
        return a(paramStringTokenizer, localGregorianCalendar, str.substring(3));
      }
      localGregorianCalendar.set(5, Integer.parseInt(str));
      return a(paramStringTokenizer, localGregorianCalendar, null);
    }
    return localGregorianCalendar.getTime();
  }

  private static Date a(StringTokenizer paramStringTokenizer, Calendar paramCalendar, String paramString)
  {
    if (paramString == null)
    {
      if (!paramStringTokenizer.hasMoreTokens())
        return paramCalendar.getTime();
      paramString = paramStringTokenizer.nextToken();
    }
    return b(paramStringTokenizer, paramCalendar, paramString);
  }

  private static void a(TreeMap<String, Integer> paramTreeMap, String paramString, Integer paramInteger)
  {
    paramTreeMap.put(paramString, paramInteger);
    paramTreeMap.put(paramString.replace("é", "e").replace("û", "u"), paramInteger);
  }

  private static int b(String paramString)
  {
    int i = Integer.parseInt(paramString);
    if (i < 100)
    {
      if (i > 23)
        i += 2000;
    }
    else
      return i;
    return i + 1900;
  }

  private static Date b(StringTokenizer paramStringTokenizer, String paramString)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(2000, 0, 0, 0, 0, 0);
    Integer localInteger = (Integer)a.get(paramString);
    if (localInteger == null)
      throw new NullPointerException("can not parse " + paramString + " as month");
    localGregorianCalendar.set(2, localInteger.intValue());
    if (!paramStringTokenizer.hasMoreTokens())
      return null;
    localGregorianCalendar.set(5, Integer.parseInt(paramStringTokenizer.nextToken()));
    if (!paramStringTokenizer.hasMoreTokens())
      return null;
    String str = paramStringTokenizer.nextToken();
    if (Character.isLetter(str.charAt(0)))
    {
      if (!paramStringTokenizer.hasMoreTokens())
        return null;
      str = paramStringTokenizer.nextToken();
    }
    if (str.length() == 4)
      localGregorianCalendar.set(1, b(str));
    while (str.length() != 2)
      return a(paramStringTokenizer, localGregorianCalendar, null);
    return b(paramStringTokenizer, localGregorianCalendar, str);
  }

  private static Date b(StringTokenizer paramStringTokenizer, Calendar paramCalendar, String paramString)
  {
    paramCalendar.set(11, Integer.parseInt(paramString));
    if (!paramStringTokenizer.hasMoreTokens())
      return paramCalendar.getTime();
    String str1 = a(paramStringTokenizer, paramStringTokenizer.nextToken(), paramCalendar);
    if (str1 == null)
      return paramCalendar.getTime();
    paramCalendar.set(12, Integer.parseInt(str1));
    if (!paramStringTokenizer.hasMoreTokens())
      return paramCalendar.getTime();
    String str2 = a(paramStringTokenizer, paramStringTokenizer.nextToken(), paramCalendar);
    if (str2 == null)
      return paramCalendar.getTime();
    paramCalendar.set(13, Integer.parseInt(str2));
    if (!paramStringTokenizer.hasMoreTokens())
      return paramCalendar.getTime();
    String str3 = a(paramStringTokenizer, paramStringTokenizer.nextToken(), paramCalendar);
    if (str3 == null)
      return paramCalendar.getTime();
    String str4 = a(paramStringTokenizer, str3, paramCalendar);
    if ((str4.length() == 4) && (Character.isDigit(str4.charAt(0))))
      paramCalendar.set(1, b(str4));
    return paramCalendar.getTime();
  }

  private static Date c(StringTokenizer paramStringTokenizer, String paramString)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(2000, 0, 0, 0, 0, 0);
    localGregorianCalendar.set(5, Integer.parseInt(paramString));
    if (!paramStringTokenizer.hasMoreTokens())
      return null;
    localGregorianCalendar.set(2, a(paramStringTokenizer.nextToken()).intValue());
    if (!paramStringTokenizer.hasMoreTokens())
      return null;
    localGregorianCalendar.set(1, b(paramStringTokenizer.nextToken()));
    return a(paramStringTokenizer, localGregorianCalendar, null);
  }

  public static class a
    implements Comparator<String>
  {
    public int a(String paramString1, String paramString2)
    {
      return paramString1.compareToIgnoreCase(paramString2);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     e.a.a.g
 * JD-Core Version:    0.6.2
 */