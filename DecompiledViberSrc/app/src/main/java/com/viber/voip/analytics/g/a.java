package com.viber.voip.analytics.g;

import com.viber.voip.analytics.p;
import com.viber.voip.analytics.w;

public abstract interface a extends p, w
{
  public static final a[] a_ = arrayOfa;

  static
  {
    a[] arrayOfa = new a[8];
    arrayOfa[0] = a.a;
    arrayOfa[1] = a.b;
    arrayOfa[2] = a.c;
    arrayOfa[3] = a.d;
    arrayOfa[4] = a.e;
    arrayOfa[5] = a.f;
    arrayOfa[6] = a.g;
    arrayOfa[7] = a.h;
  }

  public abstract String a(a parama, boolean paramBoolean);

  public abstract boolean a(a parama);

  public abstract boolean a(a parama, String paramString);

  public abstract boolean a(b paramb);

  public abstract boolean b(b paramb);

  public abstract String g();

  public abstract String h();

  public abstract String i();

  public abstract String j();

  public abstract String k();

  public abstract void r_();

  public static enum a
  {
    private final String j;

    static
    {
      a[] arrayOfa = new a[9];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
      arrayOfa[7] = h;
      arrayOfa[8] = i;
    }

    private a(String paramString)
    {
      this.j = paramString;
    }

    public static a a(String paramString)
    {
      for (a locala : values())
        if (locala.a().equalsIgnoreCase(paramString))
          return locala;
      return null;
    }

    public String a()
    {
      return this.j;
    }
  }

  public static enum b
  {
    private final String w;
    private final boolean x;

    static
    {
      b[] arrayOfb = new b[22];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
      arrayOfb[4] = e;
      arrayOfb[5] = f;
      arrayOfb[6] = g;
      arrayOfb[7] = h;
      arrayOfb[8] = i;
      arrayOfb[9] = j;
      arrayOfb[10] = k;
      arrayOfb[11] = l;
      arrayOfb[12] = m;
      arrayOfb[13] = n;
      arrayOfb[14] = o;
      arrayOfb[15] = p;
      arrayOfb[16] = q;
      arrayOfb[17] = r;
      arrayOfb[18] = s;
      arrayOfb[19] = t;
      arrayOfb[20] = u;
      arrayOfb[21] = v;
    }

    private b(String paramString)
    {
      this(paramString, false);
    }

    private b(String paramString, boolean paramBoolean)
    {
      this.w = paramString;
      this.x = paramBoolean;
    }

    public String a()
    {
      return this.w;
    }

    public boolean b()
    {
      return this.x;
    }

    public String c()
    {
      return "wasabi_cache_" + this.w + "_payload";
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.g.a
 * JD-Core Version:    0.6.2
 */