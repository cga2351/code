package com.e.a.d;

import e.a.b.i;
import java.io.Serializable;
import java.math.BigInteger;
import java.nio.charset.Charset;

public class a
  implements e.a.b.b, Serializable
{
  public static final Charset a = Charset.forName("UTF-8");
  private final String b;

  public a(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("The Base64 value must not be null");
    this.b = paramString;
  }

  public byte[] a()
  {
    return b.c(this.b);
  }

  public String b()
  {
    return "\"" + i.a(this.b) + "\"";
  }

  public BigInteger c()
  {
    return new BigInteger(1, a());
  }

  public String d()
  {
    return new String(a(), a);
  }

  public boolean equals(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof a)) && (toString().equals(paramObject.toString()));
  }

  public int hashCode()
  {
    return this.b.hashCode();
  }

  public String toString()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.d.a
 * JD-Core Version:    0.6.2
 */