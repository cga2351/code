package org.simpleframework.xml.filter;

public class EnvironmentFilter
  implements Filter
{
  private Filter filter;

  public EnvironmentFilter()
  {
    this(null);
  }

  public EnvironmentFilter(Filter paramFilter)
  {
    this.filter = paramFilter;
  }

  public String replace(String paramString)
  {
    String str = System.getenv(paramString);
    if (str != null)
      return str;
    if (this.filter != null)
      return this.filter.replace(paramString);
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.filter.EnvironmentFilter
 * JD-Core Version:    0.6.2
 */