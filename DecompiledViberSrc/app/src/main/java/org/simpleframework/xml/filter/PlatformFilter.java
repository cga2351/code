package org.simpleframework.xml.filter;

import java.util.Map;

public class PlatformFilter extends StackFilter
{
  public PlatformFilter()
  {
    this(null);
  }

  public PlatformFilter(Map paramMap)
  {
    push(new EnvironmentFilter());
    push(new SystemFilter());
    push(new MapFilter(paramMap));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.filter.PlatformFilter
 * JD-Core Version:    0.6.2
 */