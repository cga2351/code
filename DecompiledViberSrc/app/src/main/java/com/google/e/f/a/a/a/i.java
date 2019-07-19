package com.google.e.f.a.a.a;

import com.google.e.c.a;

abstract class i extends h
{
  i(a parama)
  {
    super(parama);
  }

  protected abstract int a(int paramInt);

  protected abstract void a(StringBuilder paramStringBuilder, int paramInt);

  protected final void b(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    int i = c().a(paramInt1, paramInt2);
    a(paramStringBuilder, i);
    int j = a(i);
    int k = 100000;
    for (int m = 0; m < 5; m++)
    {
      if (j / k == 0)
        paramStringBuilder.append('0');
      k /= 10;
    }
    paramStringBuilder.append(j);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.f.a.a.a.i
 * JD-Core Version:    0.6.2
 */