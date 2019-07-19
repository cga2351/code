package com.google.e.f.a;

import com.google.e.p;

public final class c
{
  private final int a;
  private final int[] b;
  private final p[] c;

  public c(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramArrayOfInt;
    p[] arrayOfp = new p[2];
    arrayOfp[0] = new p(paramInt2, paramInt4);
    arrayOfp[1] = new p(paramInt3, paramInt4);
    this.c = arrayOfp;
  }

  public int a()
  {
    return this.a;
  }

  public int[] b()
  {
    return this.b;
  }

  public p[] c()
  {
    return this.c;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof c));
    c localc;
    do
    {
      return false;
      localc = (c)paramObject;
    }
    while (this.a != localc.a);
    return true;
  }

  public int hashCode()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.f.a.c
 * JD-Core Version:    0.6.2
 */