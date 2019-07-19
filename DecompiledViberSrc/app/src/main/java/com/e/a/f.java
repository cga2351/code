package com.e.a;

import e.a.b.b;
import e.a.b.d;
import java.io.Serializable;

public final class f
  implements b, Serializable
{
  public static final f a = new f("JOSE");
  public static final f b = new f("JOSE+JSON");
  public static final f c = new f("JWT");
  private final String d;

  public f(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("The object type must not be null");
    this.d = paramString;
  }

  public String b()
  {
    return "\"" + d.a(this.d) + '"';
  }

  public boolean equals(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof f)) && (toString().equals(paramObject.toString()));
  }

  public int hashCode()
  {
    return this.d.hashCode();
  }

  public String toString()
  {
    return this.d;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.f
 * JD-Core Version:    0.6.2
 */