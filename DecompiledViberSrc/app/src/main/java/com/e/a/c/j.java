package com.e.a.c;

import com.e.a.d.c;
import java.net.URI;
import java.security.KeyStore;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class j extends d
{
  public static final Set<a> a = Collections.unmodifiableSet(new HashSet(Arrays.asList(arrayOfa)));
  private final a b;
  private final c c;
  private final c d;

  static
  {
    a[] arrayOfa = new a[4];
    arrayOfa[0] = a.d;
    arrayOfa[1] = a.e;
    arrayOfa[2] = a.f;
    arrayOfa[3] = a.g;
  }

  public j(a parama, c paramc1, h paramh, Set<f> paramSet, com.e.a.a parama1, String paramString, URI paramURI, c paramc2, c paramc3, List<com.e.a.d.a> paramList, KeyStore paramKeyStore)
  {
    super(g.d, paramh, paramSet, parama1, paramString, paramURI, paramc2, paramc3, paramList, paramKeyStore);
    if (parama == null)
      throw new IllegalArgumentException("The curve must not be null");
    if (!a.contains(parama))
      throw new IllegalArgumentException("Unknown / unsupported curve: " + parama);
    this.b = parama;
    if (paramc1 == null)
      throw new IllegalArgumentException("The 'x' parameter must not be null");
    this.c = paramc1;
    this.d = null;
  }

  public j(a parama, c paramc1, c paramc2, h paramh, Set<f> paramSet, com.e.a.a parama1, String paramString, URI paramURI, c paramc3, c paramc4, List<com.e.a.d.a> paramList, KeyStore paramKeyStore)
  {
    super(g.d, paramh, paramSet, parama1, paramString, paramURI, paramc3, paramc4, paramList, paramKeyStore);
    if (parama == null)
      throw new IllegalArgumentException("The curve must not be null");
    if (!a.contains(parama))
      throw new IllegalArgumentException("Unknown / unsupported curve: " + parama);
    this.b = parama;
    if (paramc1 == null)
      throw new IllegalArgumentException("The 'x' parameter must not be null");
    this.c = paramc1;
    if (paramc2 == null)
      throw new IllegalArgumentException("The 'd' parameter must not be null");
    this.d = paramc2;
  }

  public static j a(e.a.b.d paramd)
    throws ParseException
  {
    a locala = a.a(com.e.a.d.e.b(paramd, "crv"));
    c localc1 = new c(com.e.a.d.e.b(paramd, "x"));
    if (e.a(paramd) != g.d)
      throw new ParseException("The key type \"kty\" must be OKP", 0);
    Object localObject = paramd.get("d");
    c localc2 = null;
    if (localObject != null)
      localc2 = new c(com.e.a.d.e.b(paramd, "d"));
    if (localc2 == null);
    try
    {
      return new j(locala, localc1, e.b(paramd), e.c(paramd), e.d(paramd), e.e(paramd), e.f(paramd), e.g(paramd), e.h(paramd), e.i(paramd), null);
      j localj = new j(locala, localc1, localc2, e.b(paramd), e.c(paramd), e.d(paramd), e.e(paramd), e.f(paramd), e.g(paramd), e.h(paramd), e.i(paramd), null);
      return localj;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new ParseException(localIllegalArgumentException.getMessage(), 0);
    }
  }

  public e.a.b.d a()
  {
    e.a.b.d locald = super.a();
    locald.put("crv", this.b.toString());
    locald.put("x", this.c.toString());
    if (this.d != null)
      locald.put("d", this.d.toString());
    return locald;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.c.j
 * JD-Core Version:    0.6.2
 */