package com.google.android.exoplayer2.source;

public class d
  implements aa
{
  protected final aa[] a;

  public d(aa[] paramArrayOfaa)
  {
    this.a = paramArrayOfaa;
  }

  public final void a(long paramLong)
  {
    aa[] arrayOfaa = this.a;
    int i = arrayOfaa.length;
    for (int j = 0; j < i; j++)
      arrayOfaa[j].a(paramLong);
  }

  public boolean c(long paramLong)
  {
    boolean bool1 = false;
    boolean bool2;
    do
    {
      long l1 = e();
      if (l1 == -9223372036854775808L)
        return bool1;
      aa[] arrayOfaa = this.a;
      int i = arrayOfaa.length;
      int j = 0;
      bool2 = false;
      if (j < i)
      {
        aa localaa = arrayOfaa[j];
        long l2 = localaa.e();
        if ((l2 != -9223372036854775808L) && (l2 <= paramLong));
        for (int k = 1; ; k = 0)
        {
          if ((l2 == l1) || (k != 0))
            bool2 |= localaa.c(paramLong);
          j++;
          break;
        }
      }
      bool1 |= bool2;
    }
    while (bool2);
    return bool1;
  }

  public final long d()
  {
    aa[] arrayOfaa = this.a;
    int i = arrayOfaa.length;
    int j = 0;
    long l1 = 9223372036854775807L;
    while (j < i)
    {
      long l2 = arrayOfaa[j].d();
      if (l2 != -9223372036854775808L)
        l1 = Math.min(l1, l2);
      j++;
    }
    if (l1 == 9223372036854775807L)
      l1 = -9223372036854775808L;
    return l1;
  }

  public final long e()
  {
    aa[] arrayOfaa = this.a;
    int i = arrayOfaa.length;
    int j = 0;
    long l1 = 9223372036854775807L;
    while (j < i)
    {
      long l2 = arrayOfaa[j].e();
      if (l2 != -9223372036854775808L)
        l1 = Math.min(l1, l2);
      j++;
    }
    if (l1 == 9223372036854775807L)
      l1 = -9223372036854775808L;
    return l1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.d
 * JD-Core Version:    0.6.2
 */