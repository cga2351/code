package com.google.e.f.a.a;

import com.google.e.f.a.c;

final class b
{
  private final boolean a;
  private final com.google.e.f.a.b b;
  private final com.google.e.f.a.b c;
  private final c d;

  b(com.google.e.f.a.b paramb1, com.google.e.f.a.b paramb2, c paramc, boolean paramBoolean)
  {
    this.b = paramb1;
    this.c = paramb2;
    this.d = paramc;
    this.a = paramBoolean;
  }

  private static int a(Object paramObject)
  {
    if (paramObject == null)
      return 0;
    return paramObject.hashCode();
  }

  private static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null)
      return paramObject2 == null;
    return paramObject1.equals(paramObject2);
  }

  com.google.e.f.a.b a()
  {
    return this.b;
  }

  com.google.e.f.a.b b()
  {
    return this.c;
  }

  c c()
  {
    return this.d;
  }

  public boolean d()
  {
    return this.c == null;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof b));
    b localb;
    do
    {
      return false;
      localb = (b)paramObject;
    }
    while ((!a(this.b, localb.b)) || (!a(this.c, localb.c)) || (!a(this.d, localb.d)));
    return true;
  }

  public int hashCode()
  {
    return a(this.b) ^ a(this.c) ^ a(this.d);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[ ").append(this.b).append(" , ").append(this.c).append(" : ");
    if (this.d == null);
    for (Object localObject = "null"; ; localObject = Integer.valueOf(this.d.a()))
      return localObject + " ]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.f.a.a.b
 * JD-Core Version:    0.6.2
 */