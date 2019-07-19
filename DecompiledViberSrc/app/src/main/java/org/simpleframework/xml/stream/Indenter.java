package org.simpleframework.xml.stream;

class Indenter
{
  private Cache cache;
  private int count;
  private int indent;
  private int index;

  public Indenter()
  {
    this(new Format());
  }

  public Indenter(Format paramFormat)
  {
    this(paramFormat, 16);
  }

  private Indenter(Format paramFormat, int paramInt)
  {
    this.indent = paramFormat.getIndent();
    this.cache = new Cache(paramInt);
  }

  private String create()
  {
    char[] arrayOfChar = new char[1 + this.count];
    if (this.count > 0)
    {
      arrayOfChar[0] = '\n';
      for (int i = 1; i <= this.count; i++)
        arrayOfChar[i] = ' ';
      return new String(arrayOfChar);
    }
    return "\n";
  }

  private String indent(int paramInt)
  {
    if (this.indent > 0)
    {
      String str = this.cache.get(paramInt);
      if (str == null)
      {
        str = create();
        this.cache.set(paramInt, str);
      }
      if (this.cache.size() > 0)
        return str;
    }
    return "";
  }

  public String pop()
  {
    int i = -1 + this.index;
    this.index = i;
    String str = indent(i);
    if (this.indent > 0)
      this.count -= this.indent;
    return str;
  }

  public String push()
  {
    int i = this.index;
    this.index = (i + 1);
    String str = indent(i);
    if (this.indent > 0)
      this.count += this.indent;
    return str;
  }

  public String top()
  {
    return indent(this.index);
  }

  private static class Cache
  {
    private int count;
    private String[] list;

    public Cache(int paramInt)
    {
      this.list = new String[paramInt];
    }

    private void resize(int paramInt)
    {
      String[] arrayOfString = new String[paramInt];
      for (int i = 0; i < this.list.length; i++)
        arrayOfString[i] = this.list[i];
      this.list = arrayOfString;
    }

    public String get(int paramInt)
    {
      if (paramInt < this.list.length)
        return this.list[paramInt];
      return null;
    }

    public void set(int paramInt, String paramString)
    {
      if (paramInt >= this.list.length)
        resize(paramInt * 2);
      if (paramInt > this.count)
        this.count = paramInt;
      this.list[paramInt] = paramString;
    }

    public int size()
    {
      return this.count;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.Indenter
 * JD-Core Version:    0.6.2
 */