package com.viber.voip.util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ab
{
  private Calendar a = Calendar.getInstance(TimeZone.getDefault());

  public ab()
  {
    this.a.setTime(new Date());
  }

  public ab(int paramInt1, int paramInt2)
  {
    this();
    this.a.set(10, paramInt1);
    this.a.set(12, paramInt2);
  }

  public ab(Date paramDate)
  {
    this.a.setTime(paramDate);
  }

  public ab a(int paramInt)
  {
    this.a.set(9, paramInt);
    return this;
  }

  public Date a()
  {
    return this.a.getTime();
  }

  public ab b(int paramInt)
  {
    this.a.add(2, -paramInt);
    return this;
  }

  public ab c(int paramInt)
  {
    this.a.add(6, -paramInt);
    return this;
  }

  public ab d(int paramInt)
  {
    this.a.add(10, -paramInt);
    return this;
  }

  public ab e(int paramInt)
  {
    this.a.add(12, -paramInt);
    return this;
  }

  public ab f(int paramInt)
  {
    this.a.add(13, -paramInt);
    return this;
  }

  public ab g(int paramInt)
  {
    this.a.set(13, paramInt);
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.ab
 * JD-Core Version:    0.6.2
 */