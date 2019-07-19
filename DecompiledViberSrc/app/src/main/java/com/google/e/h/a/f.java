package com.google.e.h.a;

public enum f
{
  private static final f[] e = arrayOff2;
  private final int f;

  static
  {
    f[] arrayOff1 = new f[4];
    arrayOff1[0] = a;
    arrayOff1[1] = b;
    arrayOff1[2] = c;
    arrayOff1[3] = d;
    g = arrayOff1;
    f[] arrayOff2 = new f[4];
    arrayOff2[0] = b;
    arrayOff2[1] = a;
    arrayOff2[2] = d;
    arrayOff2[3] = c;
  }

  private f(int paramInt)
  {
    this.f = paramInt;
  }

  public static f a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= e.length))
      throw new IllegalArgumentException();
    return e[paramInt];
  }

  public int a()
  {
    return this.f;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.h.a.f
 * JD-Core Version:    0.6.2
 */