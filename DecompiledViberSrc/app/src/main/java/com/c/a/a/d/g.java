package com.c.a.a.d;

public final class g extends c
{
  final int[] c;
  final int d;

  g(String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    super(paramString, paramInt1);
    if (paramInt2 < 3)
      throw new IllegalArgumentException("Qlen must >= 3");
    this.c = paramArrayOfInt;
    this.d = paramInt2;
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
    if (paramInt != this.d)
      return false;
    for (int i = 0; ; i++)
    {
      if (i >= paramInt)
        break label35;
      if (paramArrayOfInt[i] != this.c[i])
        break;
    }
    label35: return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.d.g
 * JD-Core Version:    0.6.2
 */