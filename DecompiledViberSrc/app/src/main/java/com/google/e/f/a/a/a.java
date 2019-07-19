package com.google.e.f.a.a;

import java.util.List;

final class a
{
  static com.google.e.c.a a(List<b> paramList)
  {
    int i = -1 + 2 * paramList.size();
    if (((b)paramList.get(-1 + paramList.size())).b() == null);
    for (int j = i - 1; ; j = i)
    {
      com.google.e.c.a locala = new com.google.e.c.a(j * 12);
      int k = ((b)paramList.get(0)).b().a();
      int m = 11;
      int i8;
      for (int n = 0; m >= 0; n = i8)
      {
        if ((k & 1 << m) != 0)
          locala.b(n);
        i8 = n + 1;
        m--;
      }
      int i1 = 1;
      int i2 = n;
      while (i1 < paramList.size())
      {
        b localb = (b)paramList.get(i1);
        int i3 = localb.a().a();
        int i4 = 11;
        while (i4 >= 0)
        {
          if ((i3 & 1 << i4) != 0)
            locala.b(i2);
          int i7 = i2 + 1;
          i4--;
          i2 = i7;
        }
        if (localb.b() != null)
        {
          int i5 = localb.b().a();
          for (int i6 = 11; i6 >= 0; i6--)
          {
            if ((i5 & 1 << i6) != 0)
              locala.b(i2);
            i2++;
          }
        }
        i1++;
      }
      return locala;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.f.a.a.a
 * JD-Core Version:    0.6.2
 */