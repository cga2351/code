package org.simpleframework.xml.stream;

abstract class Splitter
{
  protected StringBuilder builder = new StringBuilder();
  protected int count;
  protected int off;
  protected char[] text;

  public Splitter(String paramString)
  {
    this.text = paramString.toCharArray();
    this.count = this.text.length;
  }

  private boolean acronym()
  {
    int i = this.off;
    int j = 0;
    while ((i < this.count) && (isUpper(this.text[i])))
    {
      j++;
      i++;
    }
    if (j > 1)
    {
      if ((i < this.count) && (isUpper(this.text[(i - 1)])))
        i--;
      commit(this.text, this.off, i - this.off);
      this.off = i;
    }
    boolean bool = false;
    if (j > 1)
      bool = true;
    return bool;
  }

  private boolean isDigit(char paramChar)
  {
    return Character.isDigit(paramChar);
  }

  private boolean isLetter(char paramChar)
  {
    return Character.isLetter(paramChar);
  }

  private boolean isSpecial(char paramChar)
  {
    return !Character.isLetterOrDigit(paramChar);
  }

  private boolean isUpper(char paramChar)
  {
    return Character.isUpperCase(paramChar);
  }

  private boolean number()
  {
    int i = this.off;
    int j = 0;
    while ((i < this.count) && (isDigit(this.text[i])))
    {
      j++;
      i++;
    }
    if (j > 0)
      commit(this.text, this.off, i - this.off);
    this.off = i;
    boolean bool = false;
    if (j > 0)
      bool = true;
    return bool;
  }

  private void token()
  {
    for (int i = this.off; ; i++)
    {
      char c;
      if (i < this.count)
      {
        c = this.text[i];
        if (isLetter(c))
          break label78;
      }
      label78: 
      while ((i > this.off) && (isUpper(c)))
      {
        if (i > this.off)
        {
          parse(this.text, this.off, i - this.off);
          commit(this.text, this.off, i - this.off);
        }
        this.off = i;
        return;
      }
    }
  }

  protected abstract void commit(char[] paramArrayOfChar, int paramInt1, int paramInt2);

  protected abstract void parse(char[] paramArrayOfChar, int paramInt1, int paramInt2);

  public String process()
  {
    if (this.off < this.count)
      while (true)
      {
        if ((this.off >= this.count) || (!isSpecial(this.text[this.off])))
        {
          if (acronym())
            break;
          token();
          number();
          break;
        }
        this.off = (1 + this.off);
      }
    return this.builder.toString();
  }

  protected char toLower(char paramChar)
  {
    return Character.toLowerCase(paramChar);
  }

  protected char toUpper(char paramChar)
  {
    return Character.toUpperCase(paramChar);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.Splitter
 * JD-Core Version:    0.6.2
 */