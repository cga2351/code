package com.google.e.h.a;

import com.google.e.c.b;

abstract class c
{
  private static final c[] a = arrayOfc;

  static
  {
    c[] arrayOfc = new c[8];
    arrayOfc[0] = new a(null);
    arrayOfc[1] = new b(null);
    arrayOfc[2] = new c(null);
    arrayOfc[3] = new d(null);
    arrayOfc[4] = new e(null);
    arrayOfc[5] = new f(null);
    arrayOfc[6] = new g(null);
    arrayOfc[7] = new h(null);
  }

  static c a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 7))
      throw new IllegalArgumentException();
    return a[paramInt];
  }

  final void a(b paramb, int paramInt)
  {
    for (int i = 0; i < paramInt; i++)
      for (int j = 0; j < paramInt; j++)
        if (a(i, j))
          paramb.c(j, i);
  }

  abstract boolean a(int paramInt1, int paramInt2);

  private static final class a extends c
  {
    private a()
    {
      super();
    }

    boolean a(int paramInt1, int paramInt2)
    {
      return (0x1 & paramInt1 + paramInt2) == 0;
    }
  }

  private static final class b extends c
  {
    private b()
    {
      super();
    }

    boolean a(int paramInt1, int paramInt2)
    {
      return (paramInt1 & 0x1) == 0;
    }
  }

  private static final class c extends c
  {
    private c()
    {
      super();
    }

    boolean a(int paramInt1, int paramInt2)
    {
      return paramInt2 % 3 == 0;
    }
  }

  private static final class d extends c
  {
    private d()
    {
      super();
    }

    boolean a(int paramInt1, int paramInt2)
    {
      return (paramInt1 + paramInt2) % 3 == 0;
    }
  }

  private static final class e extends c
  {
    private e()
    {
      super();
    }

    boolean a(int paramInt1, int paramInt2)
    {
      return (0x1 & paramInt1 / 2 + paramInt2 / 3) == 0;
    }
  }

  private static final class f extends c
  {
    private f()
    {
      super();
    }

    boolean a(int paramInt1, int paramInt2)
    {
      int i = paramInt1 * paramInt2;
      return (i & 0x1) + i % 3 == 0;
    }
  }

  private static final class g extends c
  {
    private g()
    {
      super();
    }

    boolean a(int paramInt1, int paramInt2)
    {
      int i = paramInt1 * paramInt2;
      return (0x1 & (i & 0x1) + i % 3) == 0;
    }
  }

  private static final class h extends c
  {
    private h()
    {
      super();
    }

    boolean a(int paramInt1, int paramInt2)
    {
      return (0x1 & (0x1 & paramInt1 + paramInt2) + paramInt1 * paramInt2 % 3) == 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.h.a.c
 * JD-Core Version:    0.6.2
 */