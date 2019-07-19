package com.viber.voip.messages.conversation.publicaccount.a;

public class a
{
  private static int a(int paramInt)
  {
    return 50 * (paramInt / 50);
  }

  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0);
    while (paramInt1 + 50 > paramInt2)
      return paramInt2;
    return a(paramInt1 + 50);
  }

  public static int[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 >= paramInt3);
    do
    {
      return null;
      if (paramInt2 > paramInt1)
      {
        int k = a(paramInt3);
        if ((paramInt3 - k >= 30) || (k == paramInt3) || (k <= paramInt1))
          return new int[] { paramInt3 };
        return new int[] { paramInt3, k };
      }
    }
    while (paramInt1 - paramInt2 >= 30);
    int i = a(paramInt1, paramInt3);
    if ((i - paramInt2 >= 30) || (i == paramInt3))
    {
      int j = a(i);
      if ((j == i) || (j <= paramInt1))
        return new int[] { i };
      if (j - paramInt2 >= 30)
        return new int[] { j };
      return new int[] { j, i };
    }
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = i;
    arrayOfInt[1] = a(i, paramInt3);
    return arrayOfInt;
  }

  public static int b(int paramInt1, int paramInt2)
  {
    int i = a(paramInt1);
    if ((i == paramInt1) || (paramInt1 == i + 1))
      if (i != 0);
    do
    {
      return paramInt2;
      return i;
      if (paramInt1 <= i)
        break;
    }
    while (i + 50 >= paramInt2);
    return i + 50;
    return i;
  }

  public static boolean b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 <= 0);
    while (true)
    {
      return false;
      int i = a(paramInt3);
      if (i == paramInt3);
      for (int j = 1 + (i - 50); (paramInt1 < paramInt3) && (paramInt2 > j); j = i + 1)
        return true;
    }
  }

  public static int c(int paramInt1, int paramInt2)
  {
    int i = a(paramInt1);
    if (paramInt1 > i)
    {
      if (i + 50 < paramInt2)
        paramInt2 = i + 50;
      return paramInt2;
    }
    return i;
  }

  public static boolean d(int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 0);
    while (paramInt1 >= paramInt2)
      return false;
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.publicaccount.a.a
 * JD-Core Version:    0.6.2
 */