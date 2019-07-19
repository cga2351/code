package org.simpleframework.xml.transform;

import java.text.SimpleDateFormat;
import java.util.Date;

 enum DateType
{
  private DateFormat format;

  static
  {
    DateType[] arrayOfDateType = new DateType[4];
    arrayOfDateType[0] = FULL;
    arrayOfDateType[1] = LONG;
    arrayOfDateType[2] = NORMAL;
    arrayOfDateType[3] = SHORT;
  }

  private DateType(String paramString)
  {
    this.format = new DateFormat(paramString);
  }

  public static Date getDate(String paramString)
    throws Exception
  {
    return getType(paramString).getFormat().getDate(paramString);
  }

  private DateFormat getFormat()
  {
    return this.format;
  }

  public static String getText(Date paramDate)
    throws Exception
  {
    return FULL.getFormat().getText(paramDate);
  }

  public static DateType getType(String paramString)
  {
    int i = paramString.length();
    if (i > 23)
      return FULL;
    if (i > 20)
      return LONG;
    if (i > 11)
      return NORMAL;
    return SHORT;
  }

  private static class DateFormat
  {
    private SimpleDateFormat format;

    public DateFormat(String paramString)
    {
      this.format = new SimpleDateFormat(paramString);
    }

    public Date getDate(String paramString)
      throws Exception
    {
      try
      {
        Date localDate = this.format.parse(paramString);
        return localDate;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    public String getText(Date paramDate)
      throws Exception
    {
      try
      {
        String str = this.format.format(paramDate);
        return str;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.DateType
 * JD-Core Version:    0.6.2
 */