package com.mopub.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateAndTime
{
  protected static DateAndTime a = new DateAndTime();

  public static String getTimeZoneOffsetString()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("Z", Locale.US);
    localSimpleDateFormat.setTimeZone(localTimeZone());
    return localSimpleDateFormat.format(now());
  }

  public static TimeZone localTimeZone()
  {
    return a.internalLocalTimeZone();
  }

  public static Date now()
  {
    return a.internalNow();
  }

  @Deprecated
  public static void setInstance(DateAndTime paramDateAndTime)
  {
    a = paramDateAndTime;
  }

  public TimeZone internalLocalTimeZone()
  {
    return TimeZone.getDefault();
  }

  public Date internalNow()
  {
    return new Date();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.util.DateAndTime
 * JD-Core Version:    0.6.2
 */