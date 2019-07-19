package com.e.a.c;

import com.e.a.m;
import e.a.b.b;
import e.a.b.d;
import java.io.Serializable;

public final class g
  implements b, Serializable
{
  public static final g a = new g("EC", m.b);
  public static final g b = new g("RSA", m.a);
  public static final g c = new g("oct", m.c);
  public static final g d = new g("OKP", m.c);
  private final String e;
  private final m f;

  public g(String paramString, m paramm)
  {
    if (paramString == null)
      throw new IllegalArgumentException("The key type value must not be null");
    this.e = paramString;
    this.f = paramm;
  }

  public static g a(String paramString)
  {
    if (paramString.equals(a.a()))
      return a;
    if (paramString.equals(b.a()))
      return b;
    if (paramString.equals(c.a()))
      return c;
    if (paramString.equals(d.a()))
      return d;
    return new g(paramString, null);
  }

  public String a()
  {
    return this.e;
  }

  public String b()
  {
    return "\"" + d.a(this.e) + '"';
  }

  public boolean equals(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof g)) && (toString().equals(paramObject.toString()));
  }

  public int hashCode()
  {
    return this.e.hashCode();
  }

  public String toString()
  {
    return this.e;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.c.g
 * JD-Core Version:    0.6.2
 */