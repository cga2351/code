package com.e.a.c;

import com.e.a.d.c;
import com.e.a.d.e;
import java.io.Serializable;
import java.net.URI;
import java.security.KeyStore;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class d
  implements e.a.b.b, Serializable
{
  private final g a;
  private final h b;
  private final Set<f> c;
  private final com.e.a.a d;
  private final String e;
  private final URI f;

  @Deprecated
  private final c g;
  private c h;
  private final List<com.e.a.d.a> i;
  private final KeyStore j;

  protected d(g paramg, h paramh, Set<f> paramSet, com.e.a.a parama, String paramString, URI paramURI, c paramc1, c paramc2, List<com.e.a.d.a> paramList, KeyStore paramKeyStore)
  {
    if (paramg == null)
      throw new IllegalArgumentException("The key type \"kty\" parameter must not be null");
    this.a = paramg;
    if (!i.a(paramh, paramSet))
      throw new IllegalArgumentException("The key use \"use\" and key options \"key_opts\" parameters are not consistent, see RFC 7517, section 4.3");
    this.b = paramh;
    this.c = paramSet;
    this.d = parama;
    this.e = paramString;
    this.f = paramURI;
    this.g = paramc1;
    this.h = paramc2;
    this.i = paramList;
    this.j = paramKeyStore;
  }

  public static d b(e.a.b.d paramd)
    throws ParseException
  {
    g localg = g.a(e.b(paramd, "kty"));
    if (localg == g.a)
      return b.a(paramd);
    if (localg == g.b)
      return l.a(paramd);
    if (localg == g.c)
      return k.a(paramd);
    if (localg == g.d)
      return j.a(paramd);
    throw new ParseException("Unsupported key type \"kty\" parameter: " + localg, 0);
  }

  public e.a.b.d a()
  {
    e.a.b.d locald = new e.a.b.d();
    locald.put("kty", this.a.a());
    if (this.b != null)
      locald.put("use", this.b.a());
    ArrayList localArrayList;
    Iterator localIterator;
    if (this.c != null)
    {
      localArrayList = new ArrayList(this.c.size());
      localIterator = this.c.iterator();
    }
    while (true)
    {
      if (!localIterator.hasNext())
      {
        locald.put("key_ops", localArrayList);
        if (this.d != null)
          locald.put("alg", this.d.a());
        if (this.e != null)
          locald.put("kid", this.e);
        if (this.f != null)
          locald.put("x5u", this.f.toString());
        if (this.g != null)
          locald.put("x5t", this.g.toString());
        if (this.h != null)
          locald.put("x5t#S256", this.h.toString());
        if (this.i != null)
          locald.put("x5c", this.i);
        return locald;
      }
      localArrayList.add(((f)localIterator.next()).a());
    }
  }

  public String b()
  {
    return a().toString();
  }

  public String toString()
  {
    return a().toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.c.d
 * JD-Core Version:    0.6.2
 */