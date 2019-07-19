package com.e.a.c;

import com.e.a.d.c;
import java.io.Serializable;
import java.net.URI;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class l extends d
{
  private final c a;
  private final c b;
  private final c c;
  private final c d;
  private final c e;
  private final c f;
  private final c g;
  private final c h;
  private final List<a> i;
  private final PrivateKey j;

  public l(c paramc1, c paramc2, c paramc3, c paramc4, c paramc5, c paramc6, c paramc7, c paramc8, List<a> paramList, PrivateKey paramPrivateKey, h paramh, Set<f> paramSet, com.e.a.a parama, String paramString, URI paramURI, c paramc9, c paramc10, List<com.e.a.d.a> paramList1, KeyStore paramKeyStore)
  {
    super(g.b, paramh, paramSet, parama, paramString, paramURI, paramc9, paramc10, paramList1, paramKeyStore);
    if (paramc1 == null)
      throw new IllegalArgumentException("The modulus value must not be null");
    this.a = paramc1;
    if (paramc2 == null)
      throw new IllegalArgumentException("The public exponent value must not be null");
    this.b = paramc2;
    this.c = paramc3;
    if ((paramc4 != null) && (paramc5 != null) && (paramc6 != null) && (paramc7 != null) && (paramc8 != null))
    {
      this.d = paramc4;
      this.e = paramc5;
      this.f = paramc6;
      this.g = paramc7;
      this.h = paramc8;
      if (paramList != null)
        this.i = Collections.unmodifiableList(paramList);
    }
    while (true)
    {
      this.j = paramPrivateKey;
      return;
      this.i = Collections.emptyList();
      continue;
      if ((paramc4 == null) && (paramc5 == null) && (paramc6 == null) && (paramc7 == null) && (paramc8 == null) && (paramList == null))
      {
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = Collections.emptyList();
      }
      else
      {
        if ((paramc4 != null) || (paramc5 != null) || (paramc6 != null) || (paramc7 != null) || (paramc8 != null))
        {
          if (paramc4 == null)
            throw new IllegalArgumentException("Incomplete second private (CRT) representation: The first prime factor must not be null");
          if (paramc5 == null)
            throw new IllegalArgumentException("Incomplete second private (CRT) representation: The second prime factor must not be null");
          if (paramc6 == null)
            throw new IllegalArgumentException("Incomplete second private (CRT) representation: The first factor CRT exponent must not be null");
          if (paramc7 == null)
            throw new IllegalArgumentException("Incomplete second private (CRT) representation: The second factor CRT exponent must not be null");
          throw new IllegalArgumentException("Incomplete second private (CRT) representation: The first CRT coefficient must not be null");
        }
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = Collections.emptyList();
      }
    }
  }

  public static l a(e.a.b.d paramd)
    throws ParseException
  {
    c localc1 = new c(com.e.a.d.e.b(paramd, "n"));
    c localc2 = new c(com.e.a.d.e.b(paramd, "e"));
    if (g.a(com.e.a.d.e.b(paramd, "kty")) != g.b)
      throw new ParseException("The key type \"kty\" must be RSA", 0);
    boolean bool1 = paramd.containsKey("d");
    c localc3 = null;
    if (bool1)
      localc3 = new c(com.e.a.d.e.b(paramd, "d"));
    boolean bool2 = paramd.containsKey("p");
    c localc4 = null;
    if (bool2)
      localc4 = new c(com.e.a.d.e.b(paramd, "p"));
    boolean bool3 = paramd.containsKey("q");
    c localc5 = null;
    if (bool3)
      localc5 = new c(com.e.a.d.e.b(paramd, "q"));
    boolean bool4 = paramd.containsKey("dp");
    c localc6 = null;
    if (bool4)
      localc6 = new c(com.e.a.d.e.b(paramd, "dp"));
    boolean bool5 = paramd.containsKey("dq");
    c localc7 = null;
    if (bool5)
      localc7 = new c(com.e.a.d.e.b(paramd, "dq"));
    boolean bool6 = paramd.containsKey("qi");
    c localc8 = null;
    if (bool6)
      localc8 = new c(com.e.a.d.e.b(paramd, "qi"));
    boolean bool7 = paramd.containsKey("oth");
    ArrayList localArrayList = null;
    Iterator localIterator;
    if (bool7)
    {
      e.a.b.a locala = com.e.a.d.e.d(paramd, "oth");
      localArrayList = new ArrayList(locala.size());
      localIterator = locala.iterator();
    }
    while (true)
    {
      if (!localIterator.hasNext());
      try
      {
        l locall = new l(localc1, localc2, localc3, localc4, localc5, localc6, localc7, localc8, localArrayList, null, e.b(paramd), e.c(paramd), e.d(paramd), e.e(paramd), e.f(paramd), e.g(paramd), e.h(paramd), e.i(paramd), null);
        return locall;
        Object localObject = localIterator.next();
        if (!(localObject instanceof e.a.b.d))
          continue;
        e.a.b.d locald = (e.a.b.d)localObject;
        localArrayList.add(new a(new c(com.e.a.d.e.b(locald, "r")), new c(com.e.a.d.e.b(locald, "dq")), new c(com.e.a.d.e.b(locald, "t"))));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw new ParseException(localIllegalArgumentException.getMessage(), 0);
      }
    }
  }

  public e.a.b.d a()
  {
    e.a.b.d locald1 = super.a();
    locald1.put("n", this.a.toString());
    locald1.put("e", this.b.toString());
    if (this.c != null)
      locald1.put("d", this.c.toString());
    if (this.d != null)
      locald1.put("p", this.d.toString());
    if (this.e != null)
      locald1.put("q", this.e.toString());
    if (this.f != null)
      locald1.put("dp", this.f.toString());
    if (this.g != null)
      locald1.put("dq", this.g.toString());
    if (this.h != null)
      locald1.put("qi", this.h.toString());
    e.a.b.a locala;
    Iterator localIterator;
    if ((this.i != null) && (!this.i.isEmpty()))
    {
      locala = new e.a.b.a();
      localIterator = this.i.iterator();
    }
    while (true)
    {
      if (!localIterator.hasNext())
      {
        locald1.put("oth", locala);
        return locald1;
      }
      a locala1 = (a)localIterator.next();
      e.a.b.d locald2 = new e.a.b.d();
      locald2.put("r", a.a(locala1).toString());
      locald2.put("d", a.b(locala1).toString());
      locald2.put("t", a.c(locala1).toString());
      locala.add(locald2);
    }
  }

  public static class a
    implements Serializable
  {
    private final c a;
    private final c b;
    private final c c;

    public a(c paramc1, c paramc2, c paramc3)
    {
      if (paramc1 == null)
        throw new IllegalArgumentException("The prime factor must not be null");
      this.a = paramc1;
      if (paramc2 == null)
        throw new IllegalArgumentException("The factor CRT exponent must not be null");
      this.b = paramc2;
      if (paramc3 == null)
        throw new IllegalArgumentException("The factor CRT coefficient must not be null");
      this.c = paramc3;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.c.l
 * JD-Core Version:    0.6.2
 */