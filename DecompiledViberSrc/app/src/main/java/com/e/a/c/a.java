package com.e.a.c;

import java.io.Serializable;
import java.security.spec.ECParameterSpec;

public final class a
  implements Serializable
{
  public static final a a = new a("P-256", "secp256r1", "1.2.840.10045.3.1.7");
  public static final a b = new a("P-384", "secp384r1", "1.3.132.0.34");
  public static final a c = new a("P-521", "secp521r1", "1.3.132.0.35");
  public static final a d = new a("Ed25519", "Ed25519", null);
  public static final a e = new a("Ed448", "Ed448", null);
  public static final a f = new a("X25519", "X25519", null);
  public static final a g = new a("X448", "X448", null);
  private final String h;
  private final String i;
  private final String j;

  public a(String paramString)
  {
    this(paramString, null, null);
  }

  public a(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null)
      throw new IllegalArgumentException("The JOSE cryptographic curve name must not be null");
    this.h = paramString1;
    this.i = paramString2;
    this.j = paramString3;
  }

  public static a a(String paramString)
  {
    if ((paramString == null) || (paramString.trim().isEmpty()))
      throw new IllegalArgumentException("The cryptographic curve string must not be null or empty");
    if (paramString.equals(a.a()))
      return a;
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
    return new a(paramString);
  }

  public String a()
  {
    return this.h;
  }

  public ECParameterSpec b()
  {
    return c.a(this);
  }

  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof a)) && (toString().equals(paramObject.toString()));
  }

  public String toString()
  {
    return a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.c.a
 * JD-Core Version:    0.6.2
 */