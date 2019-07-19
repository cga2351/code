package com.e.a;

import com.e.a.d.e;
import e.a.b.d;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class c
  implements Serializable
{
  private static final Map<String, Object> f = Collections.unmodifiableMap(new HashMap());
  private final a a;
  private final f b;
  private final String c;
  private final Set<String> d;
  private final Map<String, Object> e;
  private final com.e.a.d.c g;

  protected c(a parama, f paramf, String paramString, Set<String> paramSet, Map<String, Object> paramMap, com.e.a.d.c paramc)
  {
    if (parama == null)
      throw new IllegalArgumentException("The algorithm \"alg\" header parameter must not be null");
    this.a = parama;
    this.b = paramf;
    this.c = paramString;
    if (paramSet != null)
    {
      this.d = Collections.unmodifiableSet(new HashSet(paramSet));
      if (paramMap == null)
        break label90;
    }
    label90: for (this.e = Collections.unmodifiableMap(new HashMap(paramMap)); ; this.e = f)
    {
      this.g = paramc;
      return;
      this.d = null;
      break;
    }
  }

  public static a a(d paramd)
    throws ParseException
  {
    String str = e.b(paramd, "alg");
    if (str.equals(a.a.a()))
      return a.a;
    if (paramd.containsKey("enc"))
      return g.a(str);
    return h.a(str);
  }

  public d a()
  {
    d locald = new d(this.e);
    locald.put("alg", this.a.toString());
    if (this.b != null)
      locald.put("typ", this.b.toString());
    if (this.c != null)
      locald.put("cty", this.c);
    if ((this.d != null) && (!this.d.isEmpty()))
      locald.put("crit", new ArrayList(this.d));
    return locald;
  }

  public a b()
  {
    return this.a;
  }

  public Set<String> c()
  {
    return this.d;
  }

  public String toString()
  {
    return a().toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.c
 * JD-Core Version:    0.6.2
 */