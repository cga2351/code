package com.google.android.exoplayer2.g;

public final class v
{
  public static int a(int paramInt1, int paramInt2)
  {
    for (int i = 1; ; i++)
      if (i <= 2)
      {
        int j = (paramInt1 + i) % 3;
        if (b(j, paramInt2))
          paramInt1 = j;
      }
      else
      {
        return paramInt1;
      }
  }

  public static boolean b(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    switch (paramInt1)
    {
    default:
      bool = false;
    case 0:
    case 1:
    case 2:
    }
    do
    {
      do
        return bool;
      while ((paramInt2 & 0x1) != 0);
      return false;
    }
    while ((paramInt2 & 0x2) != 0);
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.g.v
 * JD-Core Version:    0.6.2
 */