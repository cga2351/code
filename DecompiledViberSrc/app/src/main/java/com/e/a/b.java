package com.e.a;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

abstract class b extends c
{
  private final URI a;
  private final com.e.a.c.d b;
  private final URI c;
  private final com.e.a.d.c d;
  private final com.e.a.d.c e;
  private final List<com.e.a.d.a> f;
  private final String g;

  protected b(a parama, f paramf, String paramString1, Set<String> paramSet, URI paramURI1, com.e.a.c.d paramd, URI paramURI2, com.e.a.d.c paramc1, com.e.a.d.c paramc2, List<com.e.a.d.a> paramList, String paramString2, Map<String, Object> paramMap, com.e.a.d.c paramc3)
  {
    super(parama, paramf, paramString1, paramSet, paramMap, paramc3);
    this.a = paramURI1;
    this.b = paramd;
    this.c = paramURI2;
    this.d = paramc1;
    this.e = paramc2;
    if (paramList != null);
    for (this.f = Collections.unmodifiableList(new ArrayList(paramList)); ; this.f = null)
    {
      this.g = paramString2;
      return;
    }
  }

  public e.a.b.d a()
  {
    e.a.b.d locald = super.a();
    if (this.a != null)
      locald.put("jku", this.a.toString());
    if (this.b != null)
      locald.put("jwk", this.b.a());
    if (this.c != null)
      locald.put("x5u", this.c.toString());
    if (this.d != null)
      locald.put("x5t", this.d.toString());
    if (this.e != null)
      locald.put("x5t#S256", this.e.toString());
    if ((this.f != null) && (!this.f.isEmpty()))
      locald.put("x5c", this.f);
    if (this.g != null)
      locald.put("kid", this.g);
    return locald;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.b
 * JD-Core Version:    0.6.2
 */