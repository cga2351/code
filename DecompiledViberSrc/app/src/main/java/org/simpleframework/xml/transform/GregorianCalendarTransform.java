package org.simpleframework.xml.transform;

import java.util.Date;
import java.util.GregorianCalendar;

class GregorianCalendarTransform
  implements Transform<GregorianCalendar>
{
  private final DateTransform transform;

  public GregorianCalendarTransform()
    throws Exception
  {
    this(Date.class);
  }

  public GregorianCalendarTransform(Class paramClass)
    throws Exception
  {
    this.transform = new DateTransform(paramClass);
  }

  private GregorianCalendar read(Date paramDate)
    throws Exception
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    if (paramDate != null)
      localGregorianCalendar.setTime(paramDate);
    return localGregorianCalendar;
  }

  public GregorianCalendar read(String paramString)
    throws Exception
  {
    return read(this.transform.read(paramString));
  }

  public String write(GregorianCalendar paramGregorianCalendar)
    throws Exception
  {
    return this.transform.write(paramGregorianCalendar.getTime());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.GregorianCalendarTransform
 * JD-Core Version:    0.6.2
 */