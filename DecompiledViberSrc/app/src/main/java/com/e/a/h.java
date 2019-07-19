package com.e.a;

public final class h extends a
{
  public static final h b = new h("HS256", m.a);
  public static final h c = new h("HS384", m.c);
  public static final h d = new h("HS512", m.c);
  public static final h e = new h("RS256", m.b);
  public static final h f = new h("RS384", m.c);
  public static final h g = new h("RS512", m.c);
  public static final h h = new h("ES256", m.b);
  public static final h i = new h("ES384", m.c);
  public static final h j = new h("ES512", m.c);
  public static final h k = new h("PS256", m.c);
  public static final h l = new h("PS384", m.c);
  public static final h m = new h("PS512", m.c);
  public static final h n = new h("EdDSA", m.c);

  public h(String paramString)
  {
    super(paramString, null);
  }

  public h(String paramString, m paramm)
  {
    super(paramString, paramm);
  }

  public static h a(String paramString)
  {
    if (paramString.equals(b.a()))
      return b;
    if (paramString.equals(c.a()))
      return c;
    if (paramString.equals(d.a()))
      return d;
    if (paramString.equals(e.a()))
      return e;
    if (paramString.equals(f.a()))
      return f;
    if (paramString.equals(g.a()))
      return g;
    if (paramString.equals(h.a()))
      return h;
    if (paramString.equals(i.a()))
      return i;
    if (paramString.equals(j.a()))
      return j;
    if (paramString.equals(k.a()))
      return k;
    if (paramString.equals(l.a()))
      return l;
    if (paramString.equals(m.a()))
      return m;
    if (paramString.equals(n.a()))
      return n;
    return new h(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.h
 * JD-Core Version:    0.6.2
 */