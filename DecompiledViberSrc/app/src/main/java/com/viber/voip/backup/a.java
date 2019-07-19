package com.viber.voip.backup;

import com.viber.voip.R.string;
import java.util.concurrent.TimeUnit;

public enum a
{
  private static final a[] i = values();
  private final long j;
  private final int k;
  private final int l;

  static
  {
    a[] arrayOfa = new a[8];
    arrayOfa[0] = a;
    arrayOfa[1] = b;
    arrayOfa[2] = c;
    arrayOfa[3] = d;
    arrayOfa[4] = e;
    arrayOfa[5] = f;
    arrayOfa[6] = g;
    arrayOfa[7] = h;
    m = arrayOfa;
  }

  private a(long paramLong, int paramInt1, int paramInt2)
  {
    this.j = paramLong;
    this.k = paramInt1;
    this.l = paramInt2;
  }

  public static a a(int paramInt)
  {
    for (a locala : i)
      if (locala.l == paramInt)
        return locala;
    return b;
  }

  public static a a(long paramLong)
  {
    for (a locala : i)
      if (locala.j == paramLong)
        return locala;
    return a;
  }

  public static boolean b(long paramLong)
  {
    return paramLong > b.a();
  }

  public static int[] e()
  {
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = a(0).c();
    arrayOfInt[1] = a(1).c();
    arrayOfInt[2] = a(2).c();
    arrayOfInt[3] = a(3).c();
    return arrayOfInt;
  }

  public long a()
  {
    return this.j;
  }

  public boolean b()
  {
    return (this != a) && (this != b);
  }

  public int c()
  {
    return this.k;
  }

  public int d()
  {
    return this.l;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.a
 * JD-Core Version:    0.6.2
 */