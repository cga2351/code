package com.e.a.c;

import com.e.a.d.c;
import java.net.URI;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class b extends d
{
  public static final Set<a> a = Collections.unmodifiableSet(new HashSet(Arrays.asList(arrayOfa)));
  private final a b;
  private final c c;
  private final c d;
  private final c e;
  private final PrivateKey f;

  static
  {
    a[] arrayOfa = new a[3];
    arrayOfa[0] = a.a;
    arrayOfa[1] = a.b;
    arrayOfa[2] = a.c;
  }

  public b(a parama, c paramc1, c paramc2, h paramh, Set<f> paramSet, com.e.a.a parama1, String paramString, URI paramURI, c paramc3, c paramc4, List<com.e.a.d.a> paramList, KeyStore paramKeyStore)
  {
    super(g.a, paramh, paramSet, parama1, paramString, paramURI, paramc3, paramc4, paramList, paramKeyStore);
    if (parama == null)
      throw new IllegalArgumentException("The curve must not be null");
    this.b = parama;
    if (paramc1 == null)
      throw new IllegalArgumentException("The 'x' coordinate must not be null");
    this.c = paramc1;
    if (paramc2 == null)
      throw new IllegalArgumentException("The 'y' coordinate must not be null");
    this.d = paramc2;
    a(parama, paramc1, paramc2);
    this.e = null;
    this.f = null;
  }

  public b(a parama, c paramc1, c paramc2, c paramc3, h paramh, Set<f> paramSet, com.e.a.a parama1, String paramString, URI paramURI, c paramc4, c paramc5, List<com.e.a.d.a> paramList, KeyStore paramKeyStore)
  {
    super(g.a, paramh, paramSet, parama1, paramString, paramURI, paramc4, paramc5, paramList, paramKeyStore);
    if (parama == null)
      throw new IllegalArgumentException("The curve must not be null");
    this.b = parama;
    if (paramc1 == null)
      throw new IllegalArgumentException("The 'x' coordinate must not be null");
    this.c = paramc1;
    if (paramc2 == null)
      throw new IllegalArgumentException("The 'y' coordinate must not be null");
    this.d = paramc2;
    a(parama, paramc1, paramc2);
    if (paramc3 == null)
      throw new IllegalArgumentException("The 'd' coordinate must not be null");
    this.e = paramc3;
    this.f = null;
  }

  public static b a(e.a.b.d paramd)
    throws ParseException
  {
    a locala = a.a(com.e.a.d.e.b(paramd, "crv"));
    c localc1 = new c(com.e.a.d.e.b(paramd, "x"));
    c localc2 = new c(com.e.a.d.e.b(paramd, "y"));
    if (e.a(paramd) != g.a)
      throw new ParseException("The key type \"kty\" must be EC", 0);
    Object localObject = paramd.get("d");
    c localc3 = null;
    if (localObject != null)
      localc3 = new c(com.e.a.d.e.b(paramd, "d"));
    if (localc3 == null);
    try
    {
      return new b(locala, localc1, localc2, e.b(paramd), e.c(paramd), e.d(paramd), e.e(paramd), e.f(paramd), e.g(paramd), e.h(paramd), e.i(paramd), null);
      b localb = new b(locala, localc1, localc2, localc3, e.b(paramd), e.c(paramd), e.d(paramd), e.e(paramd), e.f(paramd), e.g(paramd), e.h(paramd), e.i(paramd), null);
      return localb;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new ParseException(localIllegalArgumentException.getMessage(), 0);
    }
  }

  private static void a(a parama, c paramc1, c paramc2)
  {
    if (!a.contains(parama))
      throw new IllegalArgumentException("Unknown / unsupported curve: " + parama);
    if (!com.e.a.a.a.a.a(paramc1.c(), paramc2.c(), parama.b()))
      throw new IllegalArgumentException("Invalid EC JWK: The 'x' and 'y' public coordinates are not on the " + parama + " curve");
  }

  public e.a.b.d a()
  {
    e.a.b.d locald = super.a();
    locald.put("crv", this.b.toString());
    locald.put("x", this.c.toString());
    locald.put("y", this.d.toString());
    if (this.e != null)
      locald.put("d", this.e.toString());
    return locald;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.c.b
 * JD-Core Version:    0.6.2
 */