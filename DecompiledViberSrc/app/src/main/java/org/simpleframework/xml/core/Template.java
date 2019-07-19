package org.simpleframework.xml.core;

class Template
{
  protected char[] buf;
  protected String cache;
  protected int count;

  public Template()
  {
    this(16);
  }

  public Template(int paramInt)
  {
    this.buf = new char[paramInt];
  }

  public void append(char paramChar)
  {
    ensureCapacity(1 + this.count);
    char[] arrayOfChar = this.buf;
    int i = this.count;
    this.count = (i + 1);
    arrayOfChar[i] = paramChar;
  }

  public void append(String paramString)
  {
    ensureCapacity(this.count + paramString.length());
    paramString.getChars(0, paramString.length(), this.buf, this.count);
    this.count += paramString.length();
  }

  public void append(String paramString, int paramInt1, int paramInt2)
  {
    ensureCapacity(paramInt2 + this.count);
    paramString.getChars(paramInt1, paramInt2, this.buf, this.count);
    this.count = (paramInt2 + this.count);
  }

  public void append(Template paramTemplate)
  {
    append(paramTemplate.buf, 0, paramTemplate.count);
  }

  public void append(Template paramTemplate, int paramInt1, int paramInt2)
  {
    append(paramTemplate.buf, paramInt1, paramInt2);
  }

  public void append(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    ensureCapacity(paramInt2 + this.count);
    System.arraycopy(paramArrayOfChar, paramInt1, this.buf, this.count, paramInt2);
    this.count = (paramInt2 + this.count);
  }

  public void clear()
  {
    this.cache = null;
    this.count = 0;
  }

  protected void ensureCapacity(int paramInt)
  {
    if (this.buf.length < paramInt)
    {
      char[] arrayOfChar = new char[Math.max(paramInt, 2 * this.buf.length)];
      System.arraycopy(this.buf, 0, arrayOfChar, 0, this.count);
      this.buf = arrayOfChar;
    }
  }

  public int length()
  {
    return this.count;
  }

  public String toString()
  {
    return new String(this.buf, 0, this.count);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Template
 * JD-Core Version:    0.6.2
 */