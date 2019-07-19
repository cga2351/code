package com.e.a;

import e.a.b.b;
import e.a.b.d;
import java.io.Serializable;

public class a
  implements b, Serializable
{
  public static final a a = new a("none", m.a);
  private final String b;
  private final m c;

  public a(String paramString)
  {
    this(paramString, null);
  }

  public a(String paramString, m paramm)
  {
    if (paramString == null)
      throw new IllegalArgumentException("The algorithm name must not be null");
    this.b = paramString;
    this.c = paramm;
  }

  public final String a()
  {
    return this.b;
  }

  public final String b()
  {
    return "\"" + d.a(this.b) + '"';
  }

  public boolean equals(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof a)) && (toString().equals(paramObject.toString()));
  }

  public final int hashCode()
  {
    return this.b.hashCode();
  }

  public final String toString()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.a
 * JD-Core Version:    0.6.2
 */