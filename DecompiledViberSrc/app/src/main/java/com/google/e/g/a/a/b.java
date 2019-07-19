package com.google.e.g.a.a;

public final class b
{
  public static final b a = new b(929, 3);
  private final int[] b;
  private final int[] c;
  private final c d;
  private final c e;
  private final int f;

  private b(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.b = new int[paramInt1];
    this.c = new int[paramInt1];
    int i = 0;
    int j = 1;
    while (i < paramInt1)
    {
      this.b[i] = j;
      j = j * paramInt2 % paramInt1;
      i++;
    }
    for (int k = 0; k < paramInt1 - 1; k++)
      this.c[this.b[k]] = k;
    this.d = new c(this, new int[] { 0 });
    this.e = new c(this, new int[] { 1 });
  }

  int a(int paramInt)
  {
    return this.b[paramInt];
  }

  c a()
  {
    return this.d;
  }

  c a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
      throw new IllegalArgumentException();
    if (paramInt2 == 0)
      return this.d;
    int[] arrayOfInt = new int[paramInt1 + 1];
    arrayOfInt[0] = paramInt2;
    return new c(this, arrayOfInt);
  }

  int b(int paramInt)
  {
    if (paramInt == 0)
      throw new IllegalArgumentException();
    return this.c[paramInt];
  }

  int b(int paramInt1, int paramInt2)
  {
    return (paramInt1 + paramInt2) % this.f;
  }

  c b()
  {
    return this.e;
  }

  int c()
  {
    return this.f;
  }

  int c(int paramInt)
  {
    if (paramInt == 0)
      throw new ArithmeticException();
    return this.b[(-1 + (this.f - this.c[paramInt]))];
  }

  int c(int paramInt1, int paramInt2)
  {
    return (paramInt1 + this.f - paramInt2) % this.f;
  }

  int d(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0))
      return 0;
    return this.b[((this.c[paramInt1] + this.c[paramInt2]) % (-1 + this.f))];
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.g.a.a.b
 * JD-Core Version:    0.6.2
 */