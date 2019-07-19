package com.viber.voip.gdpr;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class e
{
  private final Calendar a = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
  private long b = -9223372036854775808L;

  private e()
  {
  }

  private e(int paramInt1, int paramInt2, int paramInt3)
  {
    this();
    this.a.set(paramInt3, paramInt2, paramInt1, 0, 0, 0);
  }

  private e(long paramLong)
  {
    this();
    this.a.setTimeInMillis(paramLong);
  }

  public static e a(int paramInt1, int paramInt2, int paramInt3)
  {
    return new e(paramInt1, paramInt2, paramInt3);
  }

  public static e a(long paramLong)
  {
    return new e(paramLong);
  }

  public long a()
  {
    if (-9223372036854775808L == this.b)
    {
      Calendar localCalendar = (Calendar)this.a.clone();
      localCalendar.add(1, 16);
      localCalendar.add(5, 1);
      this.b = localCalendar.getTimeInMillis();
    }
    return this.b;
  }

  public String a(DateFormat paramDateFormat)
  {
    paramDateFormat.setCalendar(this.a);
    return paramDateFormat.format(new Date(b()));
  }

  public long b()
  {
    return this.a.getTimeInMillis();
  }

  public boolean c()
  {
    return a() > System.currentTimeMillis();
  }

  public int d()
  {
    return this.a.get(1);
  }

  public int e()
  {
    return this.a.get(2);
  }

  public int f()
  {
    return this.a.get(5);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gdpr.e
 * JD-Core Version:    0.6.2
 */