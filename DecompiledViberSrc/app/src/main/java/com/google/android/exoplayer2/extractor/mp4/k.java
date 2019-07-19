package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.r;
import java.io.IOException;

final class k
{
  private static final int[] a = arrayOfInt;

  static
  {
    int[] arrayOfInt = new int[24];
    arrayOfInt[0] = ag.g("isom");
    arrayOfInt[1] = ag.g("iso2");
    arrayOfInt[2] = ag.g("iso3");
    arrayOfInt[3] = ag.g("iso4");
    arrayOfInt[4] = ag.g("iso5");
    arrayOfInt[5] = ag.g("iso6");
    arrayOfInt[6] = ag.g("avc1");
    arrayOfInt[7] = ag.g("hvc1");
    arrayOfInt[8] = ag.g("hev1");
    arrayOfInt[9] = ag.g("mp41");
    arrayOfInt[10] = ag.g("mp42");
    arrayOfInt[11] = ag.g("3g2a");
    arrayOfInt[12] = ag.g("3g2b");
    arrayOfInt[13] = ag.g("3gr6");
    arrayOfInt[14] = ag.g("3gs6");
    arrayOfInt[15] = ag.g("3ge6");
    arrayOfInt[16] = ag.g("3gg6");
    arrayOfInt[17] = ag.g("M4V ");
    arrayOfInt[18] = ag.g("M4A ");
    arrayOfInt[19] = ag.g("f4v ");
    arrayOfInt[20] = ag.g("kddi");
    arrayOfInt[21] = ag.g("M4VP");
    arrayOfInt[22] = ag.g("qt  ");
    arrayOfInt[23] = ag.g("MSNV");
  }

  private static boolean a(int paramInt)
  {
    if (paramInt >>> 8 == ag.g("3gp"))
      return true;
    int[] arrayOfInt = a;
    int i = arrayOfInt.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label41;
      if (arrayOfInt[j] == paramInt)
        break;
    }
    label41: return false;
  }

  public static boolean a(h paramh)
    throws IOException, InterruptedException
  {
    return a(paramh, true);
  }

  private static boolean a(h paramh, boolean paramBoolean)
    throws IOException, InterruptedException
  {
    long l1 = paramh.d();
    long l2;
    r localr;
    int j;
    int k;
    int m;
    if ((l1 == -1L) || (l1 > 4096L))
    {
      l2 = 4096L;
      int i = (int)l2;
      localr = new r(64);
      j = 0;
      k = 0;
      m = i;
    }
    while (true)
    {
      boolean bool1 = false;
      int n;
      long l3;
      int i1;
      label212: int i6;
      if (k < m)
      {
        n = 8;
        localr.a(n);
        paramh.c(localr.a, 0, n);
        l3 = localr.n();
        i1 = localr.p();
        if (l3 == 1L)
        {
          n = 16;
          paramh.c(localr.a, 8, 8);
          localr.b(16);
          l3 = localr.r();
        }
        while (true)
        {
          if ((l1 == -1L) || (l3 + k <= l1))
            break label212;
          return false;
          l2 = l1;
          break;
          if (l3 == 0L)
          {
            long l4 = paramh.d();
            if (l4 != -1L)
              l3 = l4 - paramh.b() + n;
          }
        }
        if (l3 < n)
          return false;
        k += n;
        if (i1 == a.B)
        {
          i6 = m + (int)l3;
          if ((l1 != -1L) && (i6 > l1))
            m = (int)l1;
        }
        else if ((i1 == a.K) || (i1 == a.M))
        {
          bool1 = true;
        }
      }
      else
      {
        while (true)
          if ((j != 0) && (paramBoolean == bool1))
          {
            return true;
            boolean bool2 = l3 + k - n < m;
            bool1 = false;
            if (bool2)
            {
              int i2 = (int)(l3 - n);
              int i3 = k + i2;
              if (i1 == a.a)
              {
                if (i2 < 8)
                  return false;
                localr.a(i2);
                paramh.c(localr.a, 0, i2);
                int i4 = i2 / 4;
                int i5 = 0;
                if (i5 < i4)
                {
                  if (i5 == 1)
                    localr.d(4);
                  while (!a(localr.p()))
                  {
                    i5++;
                    break;
                  }
                  j = 1;
                }
                if (j == 0)
                  return false;
              }
              else if (i2 != 0)
              {
                paramh.c(i2);
              }
              k = i3;
              break;
            }
          }
        return false;
        m = i6;
      }
    }
  }

  public static boolean b(h paramh)
    throws IOException, InterruptedException
  {
    return a(paramh, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.k
 * JD-Core Version:    0.6.2
 */