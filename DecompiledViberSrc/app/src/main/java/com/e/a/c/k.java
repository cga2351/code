package com.e.a.c;

import com.e.a.d.c;
import java.net.URI;
import java.security.KeyStore;
import java.text.ParseException;
import java.util.List;
import java.util.Set;

public final class k extends d
{
  private final c a;

  public k(c paramc1, h paramh, Set<f> paramSet, com.e.a.a parama, String paramString, URI paramURI, c paramc2, c paramc3, List<com.e.a.d.a> paramList, KeyStore paramKeyStore)
  {
    super(g.c, paramh, paramSet, parama, paramString, paramURI, paramc2, paramc3, paramList, paramKeyStore);
    if (paramc1 == null)
      throw new IllegalArgumentException("The key value must not be null");
    this.a = paramc1;
  }

  public static k a(e.a.b.d paramd)
    throws ParseException
  {
    c localc = new c(com.e.a.d.e.b(paramd, "k"));
    if (e.a(paramd) != g.c)
      throw new ParseException("The key type \"kty\" must be oct", 0);
    return new k(localc, e.b(paramd), e.c(paramd), e.d(paramd), e.e(paramd), e.f(paramd), e.g(paramd), e.h(paramd), e.i(paramd), null);
  }

  public e.a.b.d a()
  {
    e.a.b.d locald = super.a();
    locald.put("k", this.a.toString());
    return locald;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.c.k
 * JD-Core Version:    0.6.2
 */