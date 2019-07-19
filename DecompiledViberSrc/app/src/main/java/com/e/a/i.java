package com.e.a;

import com.e.a.d.e;
import com.e.a.d.g;
import java.net.URI;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class i extends b
{
  private static final Set<String> a = Collections.unmodifiableSet(localHashSet);

  static
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("alg");
    localHashSet.add("jku");
    localHashSet.add("jwk");
    localHashSet.add("x5u");
    localHashSet.add("x5t");
    localHashSet.add("x5t#S256");
    localHashSet.add("x5c");
    localHashSet.add("kid");
    localHashSet.add("typ");
    localHashSet.add("cty");
    localHashSet.add("crit");
  }

  public i(h paramh, f paramf, String paramString1, Set<String> paramSet, URI paramURI1, com.e.a.c.d paramd, URI paramURI2, com.e.a.d.c paramc1, com.e.a.d.c paramc2, List<com.e.a.d.a> paramList, String paramString2, Map<String, Object> paramMap, com.e.a.d.c paramc3)
  {
    super(paramh, paramf, paramString1, paramSet, paramURI1, paramd, paramURI2, paramc1, paramc2, paramList, paramString2, paramMap, paramc3);
    if (paramh.a().equals(a.a.a()))
      throw new IllegalArgumentException("The JWS algorithm \"alg\" cannot be \"none\"");
  }

  public static i a(com.e.a.d.c paramc)
    throws ParseException
  {
    return a(paramc.d(), paramc);
  }

  public static i a(e.a.b.d paramd, com.e.a.d.c paramc)
    throws ParseException
  {
    a locala = c.a(paramd);
    if (!(locala instanceof h))
      throw new ParseException("The algorithm \"alg\" header parameter must be for signatures", 0);
    a locala1 = new a((h)locala).c(paramc);
    Iterator localIterator = paramd.keySet().iterator();
    a locala2 = locala1;
    while (true)
    {
      if (!localIterator.hasNext())
        return locala2.a();
      String str = (String)localIterator.next();
      if (!"alg".equals(str))
        if ("typ".equals(str))
          locala2 = locala2.a(new f(e.b(paramd, str)));
        else if ("cty".equals(str))
          locala2 = locala2.a(e.b(paramd, str));
        else if ("crit".equals(str))
          locala2 = locala2.a(new HashSet(e.f(paramd, str)));
        else if ("jku".equals(str))
          locala2 = locala2.a(e.c(paramd, str));
        else if ("jwk".equals(str))
          locala2 = locala2.a(com.e.a.c.d.b(e.g(paramd, str)));
        else if ("x5u".equals(str))
          locala2 = locala2.b(e.c(paramd, str));
        else if ("x5t".equals(str))
          locala2 = locala2.a(new com.e.a.d.c(e.b(paramd, str)));
        else if ("x5t#S256".equals(str))
          locala2 = locala2.b(new com.e.a.d.c(e.b(paramd, str)));
        else if ("x5c".equals(str))
          locala2 = locala2.a(g.a(e.d(paramd, str)));
        else if ("kid".equals(str))
          locala2 = locala2.b(e.b(paramd, str));
        else
          locala2 = locala2.a(str, paramd.get(str));
    }
  }

  public static i a(String paramString, com.e.a.d.c paramc)
    throws ParseException
  {
    return a(e.a(paramString), paramc);
  }

  public static Set<String> d()
  {
    return a;
  }

  public h e()
  {
    return (h)super.b();
  }

  public static class a
  {
    private final h a;
    private f b;
    private String c;
    private Set<String> d;
    private URI e;
    private com.e.a.c.d f;
    private URI g;

    @Deprecated
    private com.e.a.d.c h;
    private com.e.a.d.c i;
    private List<com.e.a.d.a> j;
    private String k;
    private Map<String, Object> l;
    private com.e.a.d.c m;

    public a(h paramh)
    {
      if (paramh.a().equals(a.a.a()))
        throw new IllegalArgumentException("The JWS algorithm \"alg\" cannot be \"none\"");
      this.a = paramh;
    }

    public a a(com.e.a.c.d paramd)
    {
      this.f = paramd;
      return this;
    }

    @Deprecated
    public a a(com.e.a.d.c paramc)
    {
      this.h = paramc;
      return this;
    }

    public a a(f paramf)
    {
      this.b = paramf;
      return this;
    }

    public a a(String paramString)
    {
      this.c = paramString;
      return this;
    }

    public a a(String paramString, Object paramObject)
    {
      if (i.d().contains(paramString))
        throw new IllegalArgumentException("The parameter name \"" + paramString + "\" matches a registered name");
      if (this.l == null)
        this.l = new HashMap();
      this.l.put(paramString, paramObject);
      return this;
    }

    public a a(URI paramURI)
    {
      this.e = paramURI;
      return this;
    }

    public a a(List<com.e.a.d.a> paramList)
    {
      this.j = paramList;
      return this;
    }

    public a a(Set<String> paramSet)
    {
      this.d = paramSet;
      return this;
    }

    public i a()
    {
      return new i(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m);
    }

    public a b(com.e.a.d.c paramc)
    {
      this.i = paramc;
      return this;
    }

    public a b(String paramString)
    {
      this.k = paramString;
      return this;
    }

    public a b(URI paramURI)
    {
      this.g = paramURI;
      return this;
    }

    public a c(com.e.a.d.c paramc)
    {
      this.m = paramc;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.i
 * JD-Core Version:    0.6.2
 */