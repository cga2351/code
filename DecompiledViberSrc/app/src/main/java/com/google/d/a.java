package com.google.d;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Locale;

final class a
  implements k<java.util.Date>, t<java.util.Date>
{
  private final DateFormat a;
  private final DateFormat b;

  a()
  {
    this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
  }

  public a(int paramInt1, int paramInt2)
  {
    this(DateFormat.getDateTimeInstance(paramInt1, paramInt2, Locale.US), DateFormat.getDateTimeInstance(paramInt1, paramInt2));
  }

  a(String paramString)
  {
    this(new SimpleDateFormat(paramString, Locale.US), new SimpleDateFormat(paramString));
  }

  a(DateFormat paramDateFormat1, DateFormat paramDateFormat2)
  {
    this.a = paramDateFormat1;
    this.b = paramDateFormat2;
  }

  private java.util.Date a(l paraml)
  {
    synchronized (this.b)
    {
      try
      {
        java.util.Date localDate3 = this.b.parse(paraml.b());
        return localDate3;
      }
      catch (ParseException localParseException1)
      {
      }
    }
    try
    {
      java.util.Date localDate2 = this.a.parse(paraml.b());
      return localDate2;
      localObject = finally;
      throw localObject;
    }
    catch (ParseException localParseException2)
    {
      try
      {
        java.util.Date localDate1 = com.google.d.b.a.a.a.a(paraml.b(), new ParsePosition(0));
        return localDate1;
      }
      catch (ParseException localParseException3)
      {
        throw new u(paraml.b(), localParseException3);
      }
    }
  }

  public l a(java.util.Date paramDate, Type paramType, s params)
  {
    synchronized (this.b)
    {
      r localr = new r(this.a.format(paramDate));
      return localr;
    }
  }

  public java.util.Date a(l paraml, Type paramType, j paramj)
    throws p
  {
    if (!(paraml instanceof r))
      throw new p("The date should be a string value");
    java.util.Date localDate = a(paraml);
    if (paramType == java.util.Date.class)
      return localDate;
    if (paramType == Timestamp.class)
      return new Timestamp(localDate.getTime());
    if (paramType == java.sql.Date.class)
      return new java.sql.Date(localDate.getTime());
    throw new IllegalArgumentException(getClass() + " cannot deserialize to " + paramType);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a.class.getSimpleName());
    localStringBuilder.append('(').append(this.b.getClass().getSimpleName()).append(')');
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.a
 * JD-Core Version:    0.6.2
 */