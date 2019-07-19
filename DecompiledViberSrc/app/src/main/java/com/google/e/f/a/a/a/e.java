package com.google.e.f.a.a.a;

import com.google.e.c.a;
import com.google.e.j;

final class e extends i
{
  private final String a;
  private final String b;

  e(a parama, String paramString1, String paramString2)
  {
    super(parama);
    this.a = paramString2;
    this.b = paramString1;
  }

  private void c(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = c().a(paramInt, 16);
    if (i == 38400)
      return;
    paramStringBuilder.append('(');
    paramStringBuilder.append(this.a);
    paramStringBuilder.append(')');
    int j = i % 32;
    int k = i / 32;
    int m = 1 + k % 12;
    int n = k / 12;
    if (n / 10 == 0)
      paramStringBuilder.append('0');
    paramStringBuilder.append(n);
    if (m / 10 == 0)
      paramStringBuilder.append('0');
    paramStringBuilder.append(m);
    if (j / 10 == 0)
      paramStringBuilder.append('0');
    paramStringBuilder.append(j);
  }

  protected int a(int paramInt)
  {
    return paramInt % 100000;
  }

  public String a()
    throws j
  {
    if (b().a() != 84)
      throw j.a();
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder, 8);
    b(localStringBuilder, 48, 20);
    c(localStringBuilder, 68);
    return localStringBuilder.toString();
  }

  protected void a(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = paramInt / 100000;
    paramStringBuilder.append('(');
    paramStringBuilder.append(this.b);
    paramStringBuilder.append(i);
    paramStringBuilder.append(')');
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.f.a.a.a.e
 * JD-Core Version:    0.6.2
 */