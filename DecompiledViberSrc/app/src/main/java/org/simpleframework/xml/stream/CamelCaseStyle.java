package org.simpleframework.xml.stream;

public class CamelCaseStyle
  implements Style
{
  private final Builder builder;
  private final Style style;

  public CamelCaseStyle()
  {
    this(true, false);
  }

  public CamelCaseStyle(boolean paramBoolean)
  {
    this(paramBoolean, false);
  }

  public CamelCaseStyle(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.style = new CamelCaseBuilder(paramBoolean1, paramBoolean2);
    this.builder = new Builder(this.style);
  }

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
 * Qualified Name:     org.simpleframework.xml.stream.CamelCaseStyle
 * JD-Core Version:    0.6.2
 */