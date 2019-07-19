package com.c.a.a.d;

public final class d extends c
{
  static final d c = new d("", 0, 0);
  final int d;

  d(String paramString, int paramInt1, int paramInt2)
  {
    super(paramString, paramInt1);
    this.d = paramInt2;
  }

  static d b()
  {
    return c;
  }

  public boolean a(int paramInt)
  {
    return paramInt == this.d;
  }

  public boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 == this.d) && (paramInt2 == 0);
  }

  public boolean a(int[] paramArrayOfInt, int paramInt)
  {
    return (paramInt == 1) && (paramArrayOfInt[0] == this.d);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.d.d
 * JD-Core Version:    0.6.2
 */