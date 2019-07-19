package com.google.android.exoplayer2.e.a;

import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.r;

public final class g
{
  public static final int a = ag.g("GA94");

  private static int a(r paramr)
  {
    int i = 0;
    int j;
    do
    {
      if (paramr.b() == 0)
        return -1;
      j = paramr.h();
      i += j;
    }
    while (j == 255);
    return i;
  }

  public static void a(long paramLong, r paramr, q[] paramArrayOfq)
  {
    int k;
    int m;
    int n;
    int i1;
    while (true)
      if (paramr.b() > 1)
      {
        int i = a(paramr);
        int j = a(paramr);
        k = j + paramr.d();
        if ((j == -1) || (j > paramr.b()))
        {
          l.c("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
          m = paramr.c();
          paramr.c(m);
        }
        else if ((i == 4) && (j >= 8))
        {
          n = paramr.h();
          i1 = paramr.i();
          if (i1 != 49)
            break label216;
        }
      }
    label153: label171: label202: label209: label216: for (int i2 = paramr.p(); ; i2 = 0)
    {
      int i3 = paramr.h();
      if (i1 == 47)
        paramr.d(1);
      int i4;
      int i6;
      if ((n == 181) && ((i1 == 49) || (i1 == 47)) && (i3 == 3))
      {
        i4 = 1;
        if (i1 != 49)
          break label209;
        if (i2 != a)
          break label202;
        i6 = 1;
      }
      for (int i5 = i6 & i4; ; i5 = i4)
      {
        if (i5 != 0)
          b(paramLong, paramr, paramArrayOfq);
        m = k;
        break;
        i4 = 0;
        break label153;
        i6 = 0;
        break label171;
        return;
      }
    }
  }

  public static void b(long paramLong, r paramr, q[] paramArrayOfq)
  {
    int i = paramr.h();
    int j;
    if ((i & 0x40) != 0)
    {
      j = 1;
      if (j != 0)
        break label29;
    }
    while (true)
    {
      return;
      j = 0;
      break;
      label29: int k = i & 0x1F;
      paramr.d(1);
      int m = k * 3;
      int n = paramr.d();
      int i1 = paramArrayOfq.length;
      for (int i2 = 0; i2 < i1; i2++)
      {
        q localq = paramArrayOfq[i2];
        paramr.c(n);
        localq.a(paramr, m);
        localq.a(paramLong, 1, m, 0, null);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.a.g
 * JD-Core Version:    0.6.2
 */