package com.google.e.f.a.a.a;

import com.google.e.c.a;

abstract class h extends j
{
  h(a parama)
  {
    super(parama);
  }

  private static void a(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < 13)
    {
      int m = '￐' + paramStringBuilder.charAt(i + paramInt);
      if ((i & 0x1) == 0)
        m *= 3;
      j += m;
      i++;
    }
    int k = 10 - j % 10;
    if (k == 10)
      k = 0;
    paramStringBuilder.append(k);
  }

  protected final void a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    for (int i = 0; i < 4; i++)
    {
      int j = c().a(paramInt1 + i * 10, 10);
      if (j / 100 == 0)
        paramStringBuilder.append('0');
      if (j / 10 == 0)
        paramStringBuilder.append('0');
      paramStringBuilder.append(j);
    }
    a(paramStringBuilder, paramInt2);
  }

  protected final void b(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder.append("(01)");
    int i = paramStringBuilder.length();
    paramStringBuilder.append('9');
    a(paramStringBuilder, paramInt, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.f.a.a.a.h
 * JD-Core Version:    0.6.2
 */