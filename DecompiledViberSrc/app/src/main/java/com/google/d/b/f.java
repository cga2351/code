package com.google.d.b;

import java.math.BigDecimal;

public final class f extends Number
{
  private final String a;

  public f(String paramString)
  {
    this.a = paramString;
  }

  public double doubleValue()
  {
    return Double.parseDouble(this.a);
  }

  public boolean equals(Object paramObject)
  {
    boolean bool2;
    if (this == paramObject)
      bool2 = true;
    boolean bool3;
    do
    {
      boolean bool1;
      do
      {
        return bool2;
        bool1 = paramObject instanceof f;
        bool2 = false;
      }
      while (!bool1);
      f localf = (f)paramObject;
      if (this.a == localf.a)
        break;
      bool3 = this.a.equals(localf.a);
      bool2 = false;
    }
    while (!bool3);
    return true;
  }

  public float floatValue()
  {
    return Float.parseFloat(this.a);
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }

  public int intValue()
  {
    try
    {
      int i = Integer.parseInt(this.a);
      return i;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        long l = Long.parseLong(this.a);
        return (int)l;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
      }
    }
    return new BigDecimal(this.a).intValue();
  }

  public long longValue()
  {
    try
    {
      long l = Long.parseLong(this.a);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return new BigDecimal(this.a).longValue();
  }

  public String toString()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.b.f
 * JD-Core Version:    0.6.2
 */