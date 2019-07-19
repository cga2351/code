package com.google.e.f.a.a.a;

import com.google.e.c.a;
import com.google.e.g;
import com.google.e.j;

final class d extends h
{
  d(a parama)
  {
    super(parama);
  }

  public String a()
    throws j, g
  {
    if (b().a() < 48)
      throw j.a();
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder, 8);
    int i = c().a(48, 2);
    localStringBuilder.append("(393");
    localStringBuilder.append(i);
    localStringBuilder.append(')');
    int j = c().a(50, 10);
    if (j / 100 == 0)
      localStringBuilder.append('0');
    if (j / 10 == 0)
      localStringBuilder.append('0');
    localStringBuilder.append(j);
    localStringBuilder.append(c().a(60, null).a());
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.f.a.a.a.d
 * JD-Core Version:    0.6.2
 */