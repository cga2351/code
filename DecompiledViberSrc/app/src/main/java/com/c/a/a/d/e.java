package com.c.a.a.d;

public final class e extends c
{
  final int c;
  final int d;

  e(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramString, paramInt1);
    this.c = paramInt2;
    this.d = paramInt3;
  }

  public boolean a(int paramInt)
  {
    return false;
  }

  public boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 == this.c) && (paramInt2 == this.d);
  }

  public boolean a(int[] paramArrayOfInt, int paramInt)
  {
    return (paramInt == 2) && (paramArrayOfInt[0] == this.c) && (paramArrayOfInt[1] == this.d);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.d.e
 * JD-Core Version:    0.6.2
 */