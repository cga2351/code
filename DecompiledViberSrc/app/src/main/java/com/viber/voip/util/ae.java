package com.viber.voip.util;

import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings.System;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.format.Time;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.l.b;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class ae extends DateUtils
{
  public static boolean a;
  private static final FieldPosition b = new FieldPosition(0);
  private static final SimpleDateFormat c = new SimpleDateFormat("H:mm", Locale.US);
  private static final SimpleDateFormat d = new SimpleDateFormat("h:mm a", Locale.US);
  private static final SimpleDateFormat e = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
  private static Time f = new Time();
  private static final Pools.Pool<Date> g = new Pools.SimplePool(10);

  static
  {
    a = android.text.format.DateFormat.is24HourFormat(ViberApplication.getLocalizedContext());
    e.setTimeZone(TimeZone.getTimeZone("UTC"));
  }

  public static long a()
  {
    return System.currentTimeMillis() - 4838400000L;
  }

  public static String a(Context paramContext, int paramInt)
  {
    if (paramInt < 60)
    {
      int n = R.string.timebomb_in_sec;
      Object[] arrayOfObject5 = new Object[1];
      arrayOfObject5[0] = Integer.valueOf(paramInt);
      return paramContext.getString(n, arrayOfObject5);
    }
    if ((paramInt >= 60) && (paramInt < 3600))
    {
      int m = R.string.timebomb_in_min;
      Object[] arrayOfObject4 = new Object[1];
      arrayOfObject4[0] = Integer.valueOf(paramInt / 60);
      return paramContext.getString(m, arrayOfObject4);
    }
    if ((paramInt >= 3600) && (paramInt < 86400))
    {
      int k = R.string.timebomb_in_hour;
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = Integer.valueOf(paramInt / 3600);
      return paramContext.getString(k, arrayOfObject3);
    }
    if ((paramInt >= 86400) && (paramInt < 604800))
    {
      int j = R.string.timebomb_in_day;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(paramInt / 86400);
      return paramContext.getString(j, arrayOfObject2);
    }
    int i = R.string.timebomb_in_week;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = Integer.valueOf(paramInt / 604800);
    return paramContext.getString(i, arrayOfObject1);
  }

  public static String a(Context paramContext, long paramLong, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      paramString = Settings.System.getString(paramContext.getContentResolver(), "date_format");
    Date localDate = i(paramLong);
    StringBuffer localStringBuffer = new StringBuffer();
    if (TextUtils.isEmpty(paramString))
      android.text.format.DateFormat.getDateFormat(paramContext).format(localDate, localStringBuffer, b);
    while (true)
    {
      g.release(localDate);
      return localStringBuffer.toString();
      localStringBuffer.append(android.text.format.DateFormat.format(paramString, paramLong));
    }
  }

  public static String a(Context paramContext, long paramLong, boolean paramBoolean)
  {
    return a(paramContext, paramLong, paramBoolean, null);
  }

  public static String a(Context paramContext, long paramLong, boolean paramBoolean, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      paramString = Settings.System.getString(paramContext.getContentResolver(), "date_format");
    Date localDate = i(paramLong);
    StringBuffer localStringBuffer = new StringBuffer();
    if (a(paramLong))
      android.text.format.DateFormat.getTimeFormat(paramContext).format(localDate, localStringBuffer, b);
    label149: 
    while (true)
    {
      g.release(localDate);
      return localStringBuffer.toString();
      if ((paramString != null) && (!TextUtils.isEmpty(paramString)))
        localStringBuffer.append(android.text.format.DateFormat.format(paramString, paramLong));
      while (true)
      {
        if (!paramBoolean)
          break label149;
        localStringBuffer.append(' ');
        android.text.format.DateFormat.getTimeFormat(paramContext).format(localDate, localStringBuffer, b);
        break;
        ViberApplication.getInstance().getLocaleDataCache().b().format(localDate, localStringBuffer, b);
      }
    }
  }

  public static String a(java.text.DateFormat paramDateFormat1, java.text.DateFormat paramDateFormat2, long paramLong, boolean paramBoolean)
  {
    Date localDate = i(paramLong);
    StringBuffer localStringBuffer = new StringBuffer();
    if (a(paramLong))
      paramDateFormat1.format(localDate, localStringBuffer, b);
    while (true)
    {
      g.release(localDate);
      return localStringBuffer.toString();
      if (b(paramLong))
        return c().getString(R.string.msg_yesterday_txt);
      paramDateFormat2.format(localDate, localStringBuffer, b);
      if (paramBoolean)
      {
        localStringBuffer.append(' ');
        paramDateFormat1.format(localDate, localStringBuffer, b);
      }
    }
  }

  public static boolean a(long paramLong)
  {
    f.set(paramLong);
    int i = f.year;
    int j = f.month;
    int k = f.monthDay;
    f.set(System.currentTimeMillis());
    return (i == f.year) && (j == f.month) && (k == f.monthDay);
  }

  public static boolean a(long paramLong1, long paramLong2)
  {
    f.set(paramLong1);
    int i = f.yearDay;
    int j = f.year;
    f.set(paramLong2);
    return (i != f.yearDay) || (j != f.year);
  }

  public static boolean a(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    if ((paramCalendar1 == null) || (paramCalendar2 == null));
    Calendar localCalendar1;
    Calendar localCalendar2;
    GregorianCalendar localGregorianCalendar;
    do
    {
      return true;
      localCalendar1 = (Calendar)paramCalendar1.clone();
      localCalendar2 = (Calendar)paramCalendar2.clone();
      localGregorianCalendar = new GregorianCalendar();
      localCalendar1.set(localGregorianCalendar.get(1), localGregorianCalendar.get(2), localGregorianCalendar.get(5));
      localCalendar2.set(localGregorianCalendar.get(1), localGregorianCalendar.get(2), localGregorianCalendar.get(5));
      if (localCalendar2.before(localCalendar1))
      {
        if ((localGregorianCalendar.before(localCalendar2)) || (localGregorianCalendar.after(localCalendar1)));
        for (boolean bool = true; ; bool = false)
          return bool;
      }
    }
    while ((localGregorianCalendar.after(localCalendar1)) && (localGregorianCalendar.before(localCalendar2)));
    return false;
  }

  public static String b()
  {
    return e.format(new Date());
  }

  public static boolean b(long paramLong)
  {
    return a(86400000L + paramLong);
  }

  public static boolean b(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    return (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6));
  }

  private static Resources c()
  {
    return ViberApplication.getLocalizedResources();
  }

  public static boolean c(long paramLong)
  {
    return paramLong > System.currentTimeMillis() - 604800000L;
  }

  public static boolean c(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    return (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) - localCalendar2.get(6) == 1);
  }

  public static boolean d(long paramLong)
  {
    return paramLong > System.currentTimeMillis() - 31449600000L;
  }

  public static boolean d(long paramLong1, long paramLong2)
  {
    return System.currentTimeMillis() - paramLong1 < paramLong2;
  }

  public static String e(long paramLong)
  {
    Date localDate = i(paramLong);
    StringBuffer localStringBuffer1 = new StringBuffer();
    if (a);
    for (StringBuffer localStringBuffer2 = c.format(localDate, localStringBuffer1, b); ; localStringBuffer2 = d.format(localDate, localStringBuffer1, b))
    {
      g.release(localDate);
      return localStringBuffer2.toString();
    }
  }

  public static String f(long paramLong)
  {
    return g(Math.round((float)paramLong / 1000.0F));
  }

  public static String g(long paramLong)
  {
    long l2;
    long l1;
    if (paramLong >= 3600L)
    {
      long l4 = paramLong / 3600L;
      l2 = paramLong - 3600L * l4;
      l1 = l4;
    }
    while (true)
    {
      long l3;
      if (l2 >= 60L)
      {
        l3 = l2 / 60L;
        l2 -= 60L * l3;
      }
      while (true)
      {
        if (l1 > 0L)
        {
          Locale localLocale2 = Locale.US;
          Object[] arrayOfObject2 = new Object[3];
          arrayOfObject2[0] = Long.valueOf(l1);
          arrayOfObject2[1] = Long.valueOf(l3);
          arrayOfObject2[2] = Long.valueOf(l2);
          return String.format(localLocale2, "%d:%02d:%02d", arrayOfObject2);
        }
        Locale localLocale1 = Locale.US;
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = Long.valueOf(l3);
        arrayOfObject1[1] = Long.valueOf(l2);
        return String.format(localLocale1, "%02d:%02d", arrayOfObject1);
        l3 = 0L;
      }
      l1 = 0L;
      l2 = paramLong;
    }
  }

  public static String h(long paramLong)
  {
    long l1 = paramLong / 1000L % 60L;
    long l2 = paramLong / 60000L;
    String str1;
    if (l1 > 9L)
    {
      str1 = "" + l1;
      if (l2 <= 9L)
        break label131;
    }
    label131: for (String str2 = "" + l2; ; str2 = "0" + l2)
    {
      return str2 + ":" + str1;
      str1 = "0" + l1;
      break;
    }
  }

  private static Date i(long paramLong)
  {
    Date localDate = (Date)g.acquire();
    if (localDate == null)
      return new Date(paramLong);
    localDate.setTime(paramLong);
    return localDate;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.ae
 * JD-Core Version:    0.6.2
 */