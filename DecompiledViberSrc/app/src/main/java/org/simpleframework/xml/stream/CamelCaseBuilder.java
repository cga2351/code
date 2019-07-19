package org.simpleframework.xml.stream;

class CamelCaseBuilder
  implements Style
{
  protected final boolean attribute;
  protected final boolean element;

  public CamelCaseBuilder(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.attribute = paramBoolean2;
    this.element = paramBoolean1;
  }

  public String getAttribute(String paramString)
  {
    String str = null;
    if (paramString != null)
      str = new Attribute(paramString, null).process();
    return str;
  }

  public String getElement(String paramString)
  {
    String str = null;
    if (paramString != null)
      str = new Element(paramString, null).process();
    return str;
  }

  private class Attribute extends Splitter
  {
    private boolean capital;

    private Attribute(String arg2)
    {
      super();
    }

    protected void commit(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      this.builder.append(paramArrayOfChar, paramInt1, paramInt2);
    }

    protected void parse(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      if ((CamelCaseBuilder.this.attribute) || (this.capital))
        paramArrayOfChar[paramInt1] = toUpper(paramArrayOfChar[paramInt1]);
      this.capital = true;
    }
  }

  private class Element extends CamelCaseBuilder.Attribute
  {
    private boolean capital;

    private Element(String arg2)
    {
      super(str, null);
    }

    protected void parse(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      if ((CamelCaseBuilder.this.element) || (this.capital))
        paramArrayOfChar[paramInt1] = toUpper(paramArrayOfChar[paramInt1]);
      this.capital = true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.CamelCaseBuilder
 * JD-Core Version:    0.6.2
 */