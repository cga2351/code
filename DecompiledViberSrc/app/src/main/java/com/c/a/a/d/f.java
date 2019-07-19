package com.c.a.a.d;

public final class f extends c
{
  final int c;
  final int d;
  final int e;

  f(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramString, paramInt1);
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
  }

  public boolean a(int paramInt)
  {
    return false;
  }

  public boolean a(int paramInt1, int paramInt2)
  {
    return false;
  }

  public boolean a(int[] paramArrayOfInt, int paramInt)
  {
    return (paramInt == 3) && (paramArrayOfInt[0] == this.c) && (paramArrayOfInt[1] == this.d) && (paramArrayOfInt[2] == this.e);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.d.f
 * JD-Core Version:    0.6.2
 */