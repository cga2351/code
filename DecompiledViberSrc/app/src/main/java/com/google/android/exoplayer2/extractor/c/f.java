package com.google.android.exoplayer2.extractor.c;

import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.g.r;
import java.io.IOException;

final class f
{
  private final r a = new r(8);
  private int b;

  private long b(h paramh)
    throws IOException, InterruptedException
  {
    int i = 0;
    paramh.c(this.a.a, 0, 1);
    int j = 0xFF & this.a.a[0];
    if (j == 0)
      return -9223372036854775808L;
    int k = 128;
    int m = 0;
    while ((j & k) == 0)
    {
      int i1 = k >> 1;
      m++;
      k = i1;
    }
    int n = j & (k ^ 0xFFFFFFFF);
    paramh.c(this.a.a, 1, m);
    while (i < m)
    {
      n = (n << 8) + (0xFF & this.a.a[(i + 1)]);
      i++;
    }
    this.b += m + 1;
    return n;
  }

  public boolean a(h paramh)
    throws IOException, InterruptedException
  {
    long l1 = paramh.d();
    long l2;
    long l3;
    if ((l1 == -1L) || (l1 > 1024L))
    {
      l2 = 1024L;
      int i = (int)l2;
      paramh.c(this.a.a, 0, 4);
      l3 = this.a.n();
      this.b = 4;
      label62: if (l3 == 440786851L)
        break label144;
      int k = 1 + this.b;
      this.b = k;
      if (k != i)
        break label100;
    }
    label100: long l4;
    label144: long l5;
    do
    {
      return false;
      l2 = l1;
      break;
      paramh.c(this.a.a, 0, 1);
      l3 = 0xFFFFFF00 & l3 << 8 | 0xFF & this.a.a[0];
      break label62;
      l4 = b(paramh);
      l5 = this.b;
    }
    while ((l4 == -9223372036854775808L) || ((l1 != -1L) && (l5 + l4 >= l1)));
    while (true)
    {
      if (this.b >= l5 + l4)
        break label268;
      if (b(paramh) == -9223372036854775808L)
        break;
      long l6 = b(paramh);
      if ((l6 < 0L) || (l6 > 2147483647L))
        break;
      if (l6 != 0L)
      {
        int j = (int)l6;
        paramh.c(j);
        this.b = (j + this.b);
      }
    }
    label268: if (this.b == l4 + l5);
    for (boolean bool = true; ; bool = false)
      return bool;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.c.f
 * JD-Core Version:    0.6.2
 */