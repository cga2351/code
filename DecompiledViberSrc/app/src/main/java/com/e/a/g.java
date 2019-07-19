package com.e.a;

public final class g extends a
{

  @Deprecated
  public static final g b = new g("RSA1_5", m.a);

  @Deprecated
  public static final g c = new g("RSA-OAEP", m.c);
  public static final g d = new g("RSA-OAEP-256", m.c);
  public static final g e = new g("A128KW", m.b);
  public static final g f = new g("A192KW", m.c);
  public static final g g = new g("A256KW", m.b);
  public static final g h = new g("dir", m.b);
  public static final g i = new g("ECDH-ES", m.b);
  public static final g j = new g("ECDH-ES+A128KW", m.b);
  public static final g k = new g("ECDH-ES+A192KW", m.c);
  public static final g l = new g("ECDH-ES+A256KW", m.b);
  public static final g m = new g("A128GCMKW", m.c);
  public static final g n = new g("A192GCMKW", m.c);
  public static final g o = new g("A256GCMKW", m.c);
  public static final g p = new g("PBES2-HS256+A128KW", m.c);
  public static final g q = new g("PBES2-HS384+A192KW", m.c);
  public static final g r = new g("PBES2-HS512+A256KW", m.c);

  public g(String paramString)
  {
    super(paramString, null);
  }

  public g(String paramString, m paramm)
  {
    super(paramString, paramm);
  }

  public static g a(String paramString)
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
    if (paramString.equals(o.a()))
      return o;
    if (paramString.equals(p.a()))
      return p;
    if (paramString.equals(q.a()))
      return q;
    if (paramString.equals(r.a()))
      return r;
    return new g(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.g
 * JD-Core Version:    0.6.2
 */