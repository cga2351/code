package org.simpleframework.xml.transform;

import java.util.Date;

class DateTransform<T extends Date>
  implements Transform<T>
{
  private final DateFactory<T> factory;

  public DateTransform(Class<T> paramClass)
    throws Exception
  {
    this.factory = new DateFactory(paramClass);
  }

  public T read(String paramString)
    throws Exception
  {
    try
    {
      Long localLong = Long.valueOf(DateType.getDate(paramString).getTime());
      Date localDate = this.factory.getInstance(new Object[] { localLong });
      return localDate;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String write(T paramT)
    throws Exception
  {
    try
    {
      String str = DateType.getText(paramT);
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.DateTransform
 * JD-Core Version:    0.6.2
 */