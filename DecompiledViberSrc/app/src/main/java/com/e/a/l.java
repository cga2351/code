package com.e.a;

import com.e.a.d.e;
import com.e.a.d.f;
import e.a.b.d;
import java.io.Serializable;
import java.text.ParseException;

public final class l
  implements Serializable
{
  private final a a;
  private final d b;
  private final String c;
  private final byte[] d;
  private final com.e.a.d.c e;
  private final j f;
  private final com.e.b.c g;

  public l(com.e.a.d.c paramc)
  {
    if (paramc == null)
      throw new IllegalArgumentException("The Base64URL-encoded object must not be null");
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = paramc;
    this.f = null;
    this.g = null;
    this.a = a.d;
  }

  private static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
      return new String(paramArrayOfByte, f.a);
    return null;
  }

  public d a()
  {
    d locald1;
    if (this.b != null)
      locald1 = this.b;
    String str;
    do
    {
      return locald1;
      str = toString();
      locald1 = null;
    }
    while (str == null);
    try
    {
      d locald2 = e.a(str);
      return locald2;
    }
    catch (ParseException localParseException)
    {
    }
    return null;
  }

  public String toString()
  {
    if (this.c != null)
      return this.c;
    if (this.f != null)
    {
      if (this.f.b() != null)
        return this.f.b();
      return this.f.f();
    }
    if (this.b != null)
      return this.b.toString();
    if (this.d != null)
      return a(this.d);
    if (this.e != null)
      return this.e.d();
    return null;
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[6];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.l
 * JD-Core Version:    0.6.2
 */