package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzoz
{
  private static final int[] zzbgi = arrayOfInt;

  static
  {
    int[] arrayOfInt = new int[24];
    arrayOfInt[0] = zzsy.zzay("isom");
    arrayOfInt[1] = zzsy.zzay("iso2");
    arrayOfInt[2] = zzsy.zzay("iso3");
    arrayOfInt[3] = zzsy.zzay("iso4");
    arrayOfInt[4] = zzsy.zzay("iso5");
    arrayOfInt[5] = zzsy.zzay("iso6");
    arrayOfInt[6] = zzsy.zzay("avc1");
    arrayOfInt[7] = zzsy.zzay("hvc1");
    arrayOfInt[8] = zzsy.zzay("hev1");
    arrayOfInt[9] = zzsy.zzay("mp41");
    arrayOfInt[10] = zzsy.zzay("mp42");
    arrayOfInt[11] = zzsy.zzay("3g2a");
    arrayOfInt[12] = zzsy.zzay("3g2b");
    arrayOfInt[13] = zzsy.zzay("3gr6");
    arrayOfInt[14] = zzsy.zzay("3gs6");
    arrayOfInt[15] = zzsy.zzay("3ge6");
    arrayOfInt[16] = zzsy.zzay("3gg6");
    arrayOfInt[17] = zzsy.zzay("M4V ");
    arrayOfInt[18] = zzsy.zzay("M4A ");
    arrayOfInt[19] = zzsy.zzay("f4v ");
    arrayOfInt[20] = zzsy.zzay("kddi");
    arrayOfInt[21] = zzsy.zzay("M4VP");
    arrayOfInt[22] = zzsy.zzay("qt  ");
    arrayOfInt[23] = zzsy.zzay("MSNV");
  }

  public static boolean zzd(zzno paramzzno)
    throws IOException, InterruptedException
  {
    long l1 = paramzzno.getLength();
    if ((l1 == -1L) || (l1 > 4096L))
      l1 = 4096L;
    int i = (int)l1;
    zzst localzzst = new zzst(64);
    int j = 0;
    int k = 0;
    while (true)
    {
      int m = 0;
      int n;
      long l2;
      int i1;
      if (k < i)
      {
        n = 8;
        localzzst.reset(8);
        paramzzno.zzc(localzzst.data, 0, 8);
        l2 = localzzst.zzge();
        i1 = localzzst.readInt();
        if (l2 == 1L)
        {
          n = 16;
          paramzzno.zzc(localzzst.data, 8, 8);
          localzzst.zzbo(16);
          l2 = localzzst.zzgh();
        }
        if (l2 < n)
          break;
        k += n;
        if (i1 != zzoj.zzako)
          if ((i1 == zzoj.zzakv) || (i1 == zzoj.zzakx))
            m = 1;
      }
      else
      {
        boolean bool;
        do
        {
          if ((j == 0) || (m != 0))
            break;
          return true;
          bool = l2 + k - n < i;
          m = 0;
        }
        while (!bool);
        int i2 = (int)(l2 - n);
        int i3 = k + i2;
        if (i1 == zzoj.zzajz)
        {
          if (i2 < 8)
            break;
          localzzst.reset(i2);
          paramzzno.zzc(localzzst.data, 0, i2);
          int i4 = i2 / 4;
          int i5 = 0;
          label274: if (i5 < i4)
            if (i5 == 1)
              localzzst.zzac(4);
          label384: label388: 
          while (true)
          {
            i5++;
            break label274;
            int i6 = localzzst.readInt();
            int i9;
            if (i6 >>> 8 == zzsy.zzay("3gp"))
              i9 = 1;
            while (true)
            {
              if (i9 == 0)
                break label388;
              j = 1;
              if (j == 0)
                break label410;
              k = i3;
              break;
              int[] arrayOfInt = zzbgi;
              int i7 = arrayOfInt.length;
              for (int i8 = 0; ; i8++)
              {
                if (i8 >= i7)
                  break label384;
                if (arrayOfInt[i8] == i6)
                {
                  i9 = 1;
                  break;
                }
              }
              i9 = 0;
            }
          }
        }
        if (i2 != 0)
          paramzzno.zzar(i2);
        k = i3;
      }
    }
    label410: return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzoz
 * JD-Core Version:    0.6.2
 */