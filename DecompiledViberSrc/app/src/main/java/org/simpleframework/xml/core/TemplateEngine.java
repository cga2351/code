package org.simpleframework.xml.core;

import org.simpleframework.xml.filter.Filter;

class TemplateEngine
{
  private Filter filter;
  private Template name = new Template();
  private int off;
  private Template source = new Template();
  private Template text = new Template();

  public TemplateEngine(Filter paramFilter)
  {
    this.filter = paramFilter;
  }

  private void name()
  {
    while (true)
    {
      char c;
      if (this.off < this.source.count)
      {
        char[] arrayOfChar = this.source.buf;
        int i = this.off;
        this.off = (i + 1);
        c = arrayOfChar[i];
        if (c == '}')
          replace();
      }
      else
      {
        if (this.name.length() > 0)
        {
          this.text.append("${");
          this.text.append(this.name);
        }
        return;
      }
      this.name.append(c);
    }
  }

  private void parse()
  {
    while (this.off < this.source.count)
    {
      char[] arrayOfChar1 = this.source.buf;
      int i = this.off;
      this.off = (i + 1);
      char c = arrayOfChar1[i];
      if ((c == '$') && (this.off < this.source.count))
      {
        char[] arrayOfChar2 = this.source.buf;
        int j = this.off;
        this.off = (j + 1);
        if (arrayOfChar2[j] == '{')
          name();
        else
          this.off = (-1 + this.off);
      }
      else
      {
        this.text.append(c);
      }
    }
  }

  private void replace()
  {
    if (this.name.length() > 0)
      replace(this.name);
    this.name.clear();
  }

  private void replace(String paramString)
  {
    String str = this.filter.replace(paramString);
    if (str == null)
    {
      this.text.append("${");
      this.text.append(paramString);
      this.text.append("}");
      return;
    }
    this.text.append(str);
  }

  private void replace(Template paramTemplate)
  {
    replace(paramTemplate.toString());
  }

  public void clear()
  {
    this.name.clear();
    this.text.clear();
    this.source.clear();
    this.off = 0;
  }

  public String process(String paramString)
  {
    if (paramString.indexOf('$') < 0)
      return paramString;
    try
    {
      this.source.append(paramString);
      parse();
      String str = this.text.toString();
      return str;
    }
    finally
    {
      clear();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.TemplateEngine
 * JD-Core Version:    0.6.2
 */