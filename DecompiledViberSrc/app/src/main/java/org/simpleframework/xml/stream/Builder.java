package org.simpleframework.xml.stream;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

class Builder
  implements Style
{
  private final Cache<String> attributes = new ConcurrentCache();
  private final Cache<String> elements = new ConcurrentCache();
  private final Style style;

  public Builder(Style paramStyle)
  {
    this.style = paramStyle;
  }

  public String getAttribute(String paramString)
  {
    String str = (String)this.attributes.fetch(paramString);
    if (str != null);
    do
    {
      return str;
      str = this.style.getAttribute(paramString);
    }
    while (str == null);
    this.attributes.cache(paramString, str);
    return str;
  }

  public String getElement(String paramString)
  {
    String str = (String)this.elements.fetch(paramString);
    if (str != null);
    do
    {
      return str;
      str = this.style.getElement(paramString);
    }
    while (str == null);
    this.elements.cache(paramString, str);
    return str;
  }

  public void setAttribute(String paramString1, String paramString2)
  {
    this.attributes.cache(paramString1, paramString2);
  }

  public void setElement(String paramString1, String paramString2)
  {
    this.elements.cache(paramString1, paramString2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.Builder
 * JD-Core Version:    0.6.2
 */