package org.simpleframework.xml.transform;

import java.util.TimeZone;

class TimeZoneTransform
  implements Transform<TimeZone>
{
  public TimeZone read(String paramString)
  {
    return TimeZone.getTimeZone(paramString);
  }

  public String write(TimeZone paramTimeZone)
  {
    return paramTimeZone.getID();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.TimeZoneTransform
 * JD-Core Version:    0.6.2
 */