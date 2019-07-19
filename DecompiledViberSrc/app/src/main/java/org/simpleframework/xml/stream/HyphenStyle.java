package org.simpleframework.xml.stream;

public class HyphenStyle
  implements Style
{
  private final Builder builder = new Builder(this.style);
  private final Style style = new HyphenBuilder();

  public String getAttribute(String paramString)
  {
    return this.builder.getAttribute(paramString);
  }

  public String getElement(String paramString)
  {
    return this.builder.getElement(paramString);
  }

  public void setAttribute(String paramString1, String paramString2)
  {
    this.builder.setAttribute(paramString1, paramString2);
  }

  public void setElement(String paramString1, String paramString2)
  {
    this.builder.setElement(paramString1, paramString2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.HyphenStyle
 * JD-Core Version:    0.6.2
 */