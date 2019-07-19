package com.c.a.a.c;

import com.c.a.a.i;

public class d extends i
{
  protected final d c;
  protected String d;
  protected d e = null;

  protected d(int paramInt, d paramd)
  {
    this.a = paramInt;
    this.c = paramd;
    this.b = -1;
  }

  private d a(int paramInt)
  {
    this.a = paramInt;
    this.b = -1;
    this.d = null;
    return this;
  }

  public static d g()
  {
    return new d(0, null);
  }

  public final int a(String paramString)
  {
    if ((this.a != 2) || (this.d != null))
      return 4;
    this.d = paramString;
    if (this.b < 0)
      return 0;
    return 1;
  }

  protected final void a(StringBuilder paramStringBuilder)
  {
    if (this.a == 2)
    {
      paramStringBuilder.append('{');
      if (this.d != null)
      {
        paramStringBuilder.append('"');
        paramStringBuilder.append(this.d);
        paramStringBuilder.append('"');
      }
      while (true)
      {
        paramStringBuilder.append('}');
        return;
        paramStringBuilder.append('?');
      }
    }
    if (this.a == 1)
    {
      paramStringBuilder.append('[');
      paramStringBuilder.append(f());
      paramStringBuilder.append(']');
      return;
    }
    paramStringBuilder.append("/");
  }

  public final d h()
  {
    d locald1 = this.e;
    if (locald1 == null)
    {
      d locald2 = new d(1, this);
      this.e = locald2;
      return locald2;
    }
    return locald1.a(1);
  }

  public final d i()
  {
    d locald1 = this.e;
    if (locald1 == null)
    {
      d locald2 = new d(2, this);
      this.e = locald2;
      return locald2;
    }
    return locald1.a(2);
  }

  public final d j()
  {
    return this.c;
  }

  public final int k()
  {
    int j;
    if (this.a == 2)
      if (this.d == null)
        j = 5;
    int i;
    do
    {
      int k;
      do
      {
        return j;
        this.d = null;
        this.b = (1 + this.b);
        return 2;
        if (this.a != 1)
          break;
        k = this.b;
        this.b = (1 + this.b);
        j = 0;
      }
      while (k < 0);
      return 1;
      this.b = (1 + this.b);
      i = this.b;
      j = 0;
    }
    while (i == 0);
    return 3;
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    a(localStringBuilder);
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.c.d
 * JD-Core Version:    0.6.2
 */