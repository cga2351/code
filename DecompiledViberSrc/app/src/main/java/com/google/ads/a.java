package com.google.ads;

@Deprecated
public final class a
{
  public static enum a
  {
    private final String e;

    static
    {
      a[] arrayOfa = new a[4];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
    }

    private a(String paramString)
    {
      this.e = paramString;
    }

    public final String toString()
    {
      return this.e;
    }
  }

  public static enum b
  {
    static
    {
      b[] arrayOfb = new b[3];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.ads.a
 * JD-Core Version:    0.6.2
 */