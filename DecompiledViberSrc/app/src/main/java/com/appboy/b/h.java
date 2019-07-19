package com.appboy.b;

import com.appboy.f.c;

public enum h
{
  private static final String m = c.a(h.class);
  private final int n;

  static
  {
    h[] arrayOfh = new h[12];
    arrayOfh[0] = a;
    arrayOfh[1] = b;
    arrayOfh[2] = c;
    arrayOfh[3] = d;
    arrayOfh[4] = e;
    arrayOfh[5] = f;
    arrayOfh[6] = g;
    arrayOfh[7] = h;
    arrayOfh[8] = i;
    arrayOfh[9] = j;
    arrayOfh[10] = k;
    arrayOfh[11] = l;
    o = arrayOfh;
  }

  private h(int paramInt)
  {
    this.n = paramInt;
  }

  public static h a(int paramInt)
  {
    for (h localh : values())
      if (localh.a() == paramInt)
        return localh;
    c.e(m, "No month with value " + paramInt + ", value must be in (0,11)");
    return null;
  }

  public int a()
  {
    return this.n;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.b.h
 * JD-Core Version:    0.6.2
 */