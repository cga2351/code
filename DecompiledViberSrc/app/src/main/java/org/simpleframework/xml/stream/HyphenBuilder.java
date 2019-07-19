package org.simpleframework.xml.stream;

class HyphenBuilder
  implements Style
{
  public String getAttribute(String paramString)
  {
    String str = null;
    if (paramString != null)
      str = new Parser(paramString, null).process();
    return str;
  }

  public String getElement(String paramString)
  {
    String str = null;
    if (paramString != null)
      str = new Parser(paramString, null).process();
    return str;
  }

  private class Parser extends Splitter
  {
    private Parser(String arg2)
    {
      super();
    }

    protected void commit(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      this.builder.append(paramArrayOfChar, paramInt1, paramInt2);
      if (paramInt1 + paramInt2 < this.count)
        this.builder.append('-');
    }

    protected void parse(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      paramArrayOfChar[paramInt1] = toLower(paramArrayOfChar[paramInt1]);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.HyphenBuilder
 * JD-Core Version:    0.6.2
 */