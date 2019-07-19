package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.k;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.c;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class b
{
  private static final int a = ag.g("vide");
  private static final int b = ag.g("soun");
  private static final int c = ag.g("text");
  private static final int d = ag.g("sbtl");
  private static final int e = ag.g("subt");
  private static final int f = ag.g("clcp");
  private static final int g = ag.g("meta");
  private static final int h = ag.g("mdta");
  private static final byte[] i = ag.c("OpusHead");

  private static int a(int paramInt)
  {
    if (paramInt == b)
      return 1;
    if (paramInt == a)
      return 2;
    if ((paramInt == c) || (paramInt == d) || (paramInt == e) || (paramInt == f))
      return 3;
    if (paramInt == g)
      return 4;
    return -1;
  }

  private static long a(r paramr)
  {
    int j = 8;
    paramr.c(j);
    if (a.a(paramr.p()) == 0);
    while (true)
    {
      paramr.d(j);
      return paramr.n();
      j = 16;
    }
  }

  static Pair<Integer, m> a(r paramr, int paramInt1, int paramInt2)
  {
    boolean bool1 = true;
    int j = paramInt1 + 8;
    Integer localInteger = null;
    String str = null;
    int k = 0;
    int m = -1;
    if (j - paramInt1 < paramInt2)
    {
      paramr.c(j);
      int n = paramr.p();
      int i1 = paramr.p();
      if (i1 == a.ab)
        localInteger = Integer.valueOf(paramr.p());
      while (true)
      {
        j += n;
        break;
        if (i1 == a.W)
        {
          paramr.d(4);
          str = paramr.e(4);
        }
        else if (i1 == a.X)
        {
          k = n;
          m = j;
        }
      }
    }
    if (("cenc".equals(str)) || ("cbc1".equals(str)) || ("cens".equals(str)) || ("cbcs".equals(str)))
    {
      boolean bool2;
      boolean bool3;
      label179: m localm;
      if (localInteger != null)
      {
        bool2 = bool1;
        com.google.android.exoplayer2.g.a.a(bool2, "frma atom is mandatory");
        if (m == -1)
          break label223;
        bool3 = bool1;
        com.google.android.exoplayer2.g.a.a(bool3, "schi atom is mandatory");
        localm = a(paramr, m, k, str);
        if (localm == null)
          break label229;
      }
      while (true)
      {
        com.google.android.exoplayer2.g.a.a(bool1, "tenc atom is mandatory");
        return Pair.create(localInteger, localm);
        bool2 = false;
        break;
        label223: bool3 = false;
        break label179;
        label229: bool1 = false;
      }
    }
    return null;
  }

  private static c a(r paramr, int paramInt1, int paramInt2, String paramString, DrmInitData paramDrmInitData, boolean paramBoolean)
    throws w
  {
    paramr.c(12);
    int j = paramr.p();
    c localc = new c(j);
    int k = 0;
    if (k < j)
    {
      int m = paramr.d();
      int n = paramr.p();
      boolean bool;
      label53: int i1;
      if (n > 0)
      {
        bool = true;
        com.google.android.exoplayer2.g.a.a(bool, "childAtomSize should be positive");
        i1 = paramr.p();
        if ((i1 != a.b) && (i1 != a.c) && (i1 != a.Z) && (i1 != a.al) && (i1 != a.d) && (i1 != a.e) && (i1 != a.f) && (i1 != a.aL) && (i1 != a.aM))
          break label177;
        a(paramr, i1, m, n, paramInt1, paramInt2, paramDrmInitData, localc, k);
      }
      while (true)
      {
        paramr.c(m + n);
        k++;
        break;
        bool = false;
        break label53;
        label177: if ((i1 == a.i) || (i1 == a.aa) || (i1 == a.n) || (i1 == a.p) || (i1 == a.r) || (i1 == a.u) || (i1 == a.s) || (i1 == a.t) || (i1 == a.ay) || (i1 == a.az) || (i1 == a.l) || (i1 == a.m) || (i1 == a.j) || (i1 == a.aP) || (i1 == a.aQ) || (i1 == a.aR) || (i1 == a.aS) || (i1 == a.aU))
          a(paramr, i1, m, n, paramInt1, paramString, paramBoolean, paramDrmInitData, localc, k);
        else if ((i1 == a.aj) || (i1 == a.au) || (i1 == a.av) || (i1 == a.aw) || (i1 == a.ax))
          a(paramr, i1, m, n, paramInt1, paramString, localc);
        else if (i1 == a.aO)
          localc.b = Format.createSampleFormat(Integer.toString(paramInt1), "application/x-camera-motion", null, -1, null);
      }
    }
    return localc;
  }

  public static l a(a.a parama, a.b paramb, long paramLong, DrmInitData paramDrmInitData, boolean paramBoolean1, boolean paramBoolean2)
    throws w
  {
    a.a locala1 = parama.e(a.E);
    int j = a(c(locala1.d(a.S).aX));
    if (j == -1)
      return null;
    f localf = b(parama.d(a.O).aX);
    if (paramLong == -9223372036854775807L);
    for (long l1 = f.a(localf); ; l1 = paramLong)
    {
      long l2 = a(paramb.aX);
      if (l1 == -9223372036854775807L);
      Pair localPair1;
      c localc;
      Object localObject;
      long[] arrayOfLong1;
      for (long l3 = -9223372036854775807L; ; l3 = ag.d(l1, 1000000L, l2))
      {
        a.a locala2 = locala1.e(a.F).e(a.G);
        localPair1 = d(locala1.d(a.R).aX);
        localc = a(locala2.d(a.T).aX, f.b(localf), f.c(localf), (String)localPair1.second, paramDrmInitData, paramBoolean2);
        localObject = null;
        arrayOfLong1 = null;
        if (!paramBoolean1)
        {
          Pair localPair2 = b(parama.e(a.P));
          long[] arrayOfLong2 = (long[])localPair2.first;
          arrayOfLong1 = (long[])localPair2.second;
          localObject = arrayOfLong2;
        }
        if (localc.b != null)
          break;
        return null;
      }
      return new l(f.b(localf), j, ((Long)localPair1.first).longValue(), l2, l3, localc.b, localc.d, localc.a, localc.c, localObject, arrayOfLong1);
    }
  }

  private static m a(r paramr, int paramInt1, int paramInt2, String paramString)
  {
    int j = 1;
    int m = paramInt1 + 8;
    while (m - paramInt1 < paramInt2)
    {
      paramr.c(m);
      int n = paramr.p();
      if (paramr.p() == a.Y)
      {
        int i1 = a.a(paramr.p());
        paramr.d(j);
        int i4;
        int i3;
        if (i1 == 0)
        {
          paramr.d(j);
          i4 = 0;
          i3 = 0;
          if (paramr.h() != j)
            break label186;
        }
        while (true)
        {
          int i5 = paramr.h();
          byte[] arrayOfByte1 = new byte[16];
          paramr.a(arrayOfByte1, 0, arrayOfByte1.length);
          byte[] arrayOfByte2 = null;
          if (j != 0)
          {
            arrayOfByte2 = null;
            if (i5 == 0)
            {
              int i6 = paramr.h();
              arrayOfByte2 = new byte[i6];
              paramr.a(arrayOfByte2, 0, i6);
            }
          }
          return new m(j, paramString, i5, arrayOfByte1, i3, i4, arrayOfByte2);
          int i2 = paramr.h();
          i3 = (i2 & 0xF0) >> 4;
          i4 = i2 & 0xF;
          break;
          label186: int k = 0;
        }
      }
      m += n;
    }
    return null;
  }

  public static o a(l paraml, a.a parama, k paramk)
    throws w
  {
    a.b localb1 = parama.d(a.aq);
    if (localb1 != null);
    int j;
    a.b localb5;
    for (Object localObject1 = new d(localb1); ; localObject1 = new e(localb5))
    {
      j = ((b)localObject1).a();
      if (j != 0)
        break;
      return new o(paraml, new long[0], new int[0], 0, new long[0], new int[0], -9223372036854775807L);
      localb5 = parama.d(a.ar);
      if (localb5 == null)
        throw new w("Track has no sample table size information");
    }
    a.b localb2 = parama.d(a.as);
    boolean bool1 = false;
    if (localb2 == null)
    {
      bool1 = true;
      localb2 = parama.d(a.at);
    }
    r localr1 = localb2.aX;
    r localr2 = parama.d(a.ap).aX;
    r localr3 = parama.d(a.am).aX;
    a.b localb3 = parama.d(a.an);
    r localr4;
    r localr5;
    label202: a locala;
    int k;
    int m;
    int n;
    int i1;
    int i51;
    int i2;
    r localr6;
    int i3;
    if (localb3 != null)
    {
      localr4 = localb3.aX;
      a.b localb4 = parama.d(a.ao);
      if (localb4 == null)
        break label478;
      localr5 = localb4.aX;
      locala = new a(localr2, localr1, bool1);
      localr3.c(12);
      k = -1 + localr3.v();
      m = localr3.v();
      n = localr3.v();
      i1 = 0;
      if (localr5 != null)
      {
        localr5.c(12);
        i1 = localr5.v();
      }
      if (localr4 == null)
        break label2180;
      localr4.c(12);
      i51 = localr4.v();
      if (i51 <= 0)
        break label484;
      i2 = -1 + localr4.v();
      localr6 = localr4;
      i3 = i51;
    }
    while (true)
    {
      label310: if ((((b)localObject1).c()) && ("audio/raw".equals(paraml.f.sampleMimeType)) && (k == 0) && (i1 == 0) && (i3 == 0));
      int i5;
      long[] arrayOfLong5;
      int[] arrayOfInt7;
      long[] arrayOfLong6;
      int[] arrayOfInt8;
      long l17;
      int i31;
      int i32;
      int i33;
      int i34;
      int i35;
      long l18;
      int i36;
      int i37;
      int i38;
      int i39;
      int i43;
      boolean bool3;
      for (int i4 = 1; ; i4 = 0)
      {
        i5 = 0;
        if (i4 != 0)
          break label1065;
        arrayOfLong5 = new long[j];
        arrayOfInt7 = new int[j];
        arrayOfLong6 = new long[j];
        arrayOfInt8 = new int[j];
        l17 = 0L;
        i31 = 0;
        i32 = 0;
        i33 = n;
        i34 = k;
        i35 = i2;
        l18 = 0L;
        i36 = i1;
        i37 = i3;
        i38 = 0;
        i39 = 0;
        if (i32 >= j)
          break label2153;
        i43 = i31;
        bool3 = true;
        while (i43 == 0)
        {
          bool3 = locala.a();
          if (!bool3)
            break;
          l17 = locala.d;
          i43 = locala.c;
        }
        localr4 = null;
        break;
        label478: localr5 = null;
        break label202;
        label484: i2 = -1;
        i3 = i51;
        localr6 = null;
        break label310;
      }
      int i41;
      int i40;
      long[] arrayOfLong7;
      int[] arrayOfInt10;
      long[] arrayOfLong8;
      int[] arrayOfInt9;
      if (!bool3)
      {
        com.google.android.exoplayer2.g.l.c("AtomParsers", "Unexpected end of chunk data");
        long[] arrayOfLong9 = Arrays.copyOf(arrayOfLong5, i32);
        int[] arrayOfInt11 = Arrays.copyOf(arrayOfInt7, i32);
        long[] arrayOfLong10 = Arrays.copyOf(arrayOfLong6, i32);
        int[] arrayOfInt12 = Arrays.copyOf(arrayOfInt8, i32);
        i41 = i32;
        i40 = i43;
        arrayOfLong7 = arrayOfLong9;
        arrayOfInt10 = arrayOfInt11;
        arrayOfLong8 = arrayOfLong10;
        arrayOfInt9 = arrayOfInt12;
      }
      while (true)
      {
        long l19 = l18 + i38;
        int i42 = 1;
        label588: String str;
        label721: long l1;
        int i8;
        Object localObject2;
        Object localObject3;
        int i7;
        long[] arrayOfLong3;
        int[] arrayOfInt3;
        label765: int i44;
        label919: int i50;
        if (i36 > 0)
        {
          if (localr5.v() != 0)
            i42 = 0;
        }
        else
        {
          if ((i37 != 0) || (m != 0) || (i40 != 0) || (i34 != 0) || (i39 != 0) || (i42 == 0))
          {
            StringBuilder localStringBuilder = new StringBuilder().append("Inconsistent stbl box for track ").append(paraml.a).append(": remainingSynchronizationSamples ").append(i37).append(", remainingSamplesAtTimestampDelta ").append(m).append(", remainingSamplesInChunk ").append(i40).append(", remainingTimestampDeltaChanges ").append(i34).append(", remainingSamplesAtTimestampOffset ").append(i39);
            if (i42 != 0)
              break label1057;
            str = ", ctts invalid";
            com.google.android.exoplayer2.g.l.c("AtomParsers", str);
          }
          l1 = l19;
          i8 = i5;
          localObject2 = arrayOfInt10;
          localObject3 = arrayOfLong7;
          i7 = i41;
          arrayOfLong3 = arrayOfLong8;
          arrayOfInt3 = arrayOfInt9;
          long l2 = ag.d(l1, 1000000L, paraml.c);
          if ((paraml.h != null) && (!paramk.a()))
            break label1210;
          ag.a(arrayOfLong3, 1000000L, paraml.c);
          return new o(paraml, (long[])localObject3, (int[])localObject2, i8, arrayOfLong3, arrayOfInt3, l2);
          if (localr5 != null)
          {
            while ((i39 == 0) && (i36 > 0))
            {
              i39 = localr5.v();
              i38 = localr5.p();
              i36--;
            }
            i39--;
          }
          arrayOfLong5[i32] = l17;
          arrayOfInt7[i32] = ((b)localObject1).b();
          if (arrayOfInt7[i32] > i5)
            i5 = arrayOfInt7[i32];
          arrayOfLong6[i32] = (l18 + i38);
          if (localr6 == null)
          {
            i44 = 1;
            arrayOfInt8[i32] = i44;
            if (i32 == i35)
            {
              arrayOfInt8[i32] = 1;
              i50 = i37 - 1;
              if (i50 <= 0)
                break label2146;
              i35 = -1 + localr6.v();
            }
          }
        }
        label1057: label1065: label1210: label1728: label2116: label2146: for (i37 = i50; ; i37 = i50)
        {
          l18 += i33;
          int i45 = m - 1;
          int i47;
          int i48;
          if ((i45 == 0) && (i34 > 0))
          {
            i47 = localr3.v();
            i48 = localr3.p();
            i34--;
          }
          while (true)
          {
            l17 += arrayOfInt7[i32];
            int i49 = i43 - 1;
            i32++;
            m = i47;
            i33 = i48;
            i31 = i49;
            break;
            i44 = 0;
            break label919;
            localr5.p();
            i36--;
            break label588;
            str = "";
            break label721;
            long[] arrayOfLong1 = new long[locala.a];
            int[] arrayOfInt1 = new int[locala.a];
            while (locala.a())
            {
              arrayOfLong1[locala.b] = locala.d;
              arrayOfInt1[locala.b] = locala.c;
            }
            d.a locala1 = d.a(ag.b(paraml.f.pcmEncoding, paraml.f.channelCount), arrayOfLong1, arrayOfInt1, n);
            long[] arrayOfLong2 = locala1.a;
            int[] arrayOfInt2 = locala1.b;
            int i6 = locala1.c;
            arrayOfLong3 = locala1.d;
            arrayOfInt3 = locala1.e;
            l1 = locala1.f;
            localObject2 = arrayOfInt2;
            localObject3 = arrayOfLong2;
            i7 = j;
            i8 = i6;
            break label765;
            if ((paraml.h.length == 1) && (paraml.b == 1) && (arrayOfLong3.length >= 2))
            {
              long l11 = paraml.i[0];
              long l12 = l11 + ag.d(paraml.h[0], paraml.c, paraml.d);
              if (a(arrayOfLong3, l1, l11, l12))
              {
                long l13 = l1 - l12;
                long l14 = ag.d(l11 - arrayOfLong3[0], paraml.f.sampleRate, paraml.c);
                long l15 = ag.d(l13, paraml.f.sampleRate, paraml.c);
                if (((l14 != 0L) || (l15 != 0L)) && (l14 <= 2147483647L) && (l15 <= 2147483647L))
                {
                  paramk.a = ((int)l14);
                  paramk.b = ((int)l15);
                  ag.a(arrayOfLong3, 1000000L, paraml.c);
                  long l16 = ag.d(paraml.h[0], 1000000L, paraml.d);
                  return new o(paraml, (long[])localObject3, (int[])localObject2, i8, arrayOfLong3, arrayOfInt3, l16);
                }
              }
            }
            if ((paraml.h.length == 1) && (paraml.h[0] == 0L))
            {
              long l9 = paraml.i[0];
              for (int i30 = 0; i30 < arrayOfLong3.length; i30++)
                arrayOfLong3[i30] = ag.d(arrayOfLong3[i30] - l9, 1000000L, paraml.c);
              long l10 = ag.d(l1 - l9, 1000000L, paraml.c);
              return new o(paraml, (long[])localObject3, (int[])localObject2, i8, arrayOfLong3, arrayOfInt3, l10);
            }
            if (paraml.b == 1);
            int[] arrayOfInt4;
            int[] arrayOfInt5;
            int i9;
            int i10;
            int i11;
            int i12;
            for (boolean bool2 = true; ; bool2 = false)
            {
              arrayOfInt4 = new int[paraml.h.length];
              arrayOfInt5 = new int[paraml.h.length];
              i9 = 0;
              i10 = 0;
              i11 = 0;
              i12 = 0;
              if (i9 >= paraml.h.length)
                break label1766;
              long l7 = paraml.i[i9];
              if (l7 == -1L)
                break label2116;
              long l8 = ag.d(paraml.h[i9], paraml.c, paraml.d);
              arrayOfInt4[i9] = ag.b(arrayOfLong3, l7, true, true);
              arrayOfInt5[i9] = ag.b(arrayOfLong3, l8 + l7, bool2, false);
              while ((arrayOfInt4[i9] < arrayOfInt5[i9]) && ((0x1 & arrayOfInt3[arrayOfInt4[i9]]) == 0))
                arrayOfInt4[i9] = (1 + arrayOfInt4[i9]);
            }
            int i28 = i12 + (arrayOfInt5[i9] - arrayOfInt4[i9]);
            int i29;
            int i26;
            int i27;
            if (i11 != arrayOfInt4[i9])
            {
              i29 = 1;
              i26 = i10 | i29;
              i27 = arrayOfInt5[i9];
            }
            while (true)
            {
              i9++;
              i10 = i26;
              i11 = i27;
              i12 = i28;
              break;
              i29 = 0;
              break label1728;
              label1766: int i13;
              int i14;
              Object localObject4;
              Object localObject5;
              int i15;
              int[] arrayOfInt6;
              long[] arrayOfLong4;
              int i16;
              int i17;
              int i18;
              long l3;
              if (i12 != i7)
              {
                i13 = 1;
                i14 = i10 | i13;
                if (i14 == 0)
                  break label2023;
                localObject4 = new long[i12];
                if (i14 == 0)
                  break label2030;
                localObject5 = new int[i12];
                if (i14 == 0)
                  break label2037;
                i15 = 0;
                if (i14 == 0)
                  break label2044;
                arrayOfInt6 = new int[i12];
                arrayOfLong4 = new long[i12];
                i16 = 0;
                i17 = i15;
                i18 = 0;
                l3 = 0L;
              }
              while (true)
              {
                int i19 = paraml.h.length;
                if (i16 >= i19)
                  break label2081;
                long l5 = paraml.i[i16];
                int i20 = arrayOfInt4[i16];
                int i21 = arrayOfInt5[i16];
                if (i14 != 0)
                {
                  int i25 = i21 - i20;
                  System.arraycopy(localObject3, i20, localObject4, i18, i25);
                  System.arraycopy(localObject2, i20, localObject5, i18, i25);
                  System.arraycopy(arrayOfInt3, i20, arrayOfInt6, i18, i25);
                }
                int i22 = i20;
                int i23 = i18;
                int i24 = i17;
                while (true)
                  if (i22 < i21)
                  {
                    arrayOfLong4[i23] = (ag.d(l3, 1000000L, paraml.d) + ag.d(arrayOfLong3[i22] - l5, 1000000L, paraml.c));
                    if ((i14 != 0) && (localObject5[i23] > i24))
                      i24 = localObject2[i22];
                    i23++;
                    i22++;
                    continue;
                    i13 = 0;
                    break;
                    label2023: localObject4 = localObject3;
                    break label1794;
                    label2030: localObject5 = localObject2;
                    break label1805;
                    label2037: i15 = i8;
                    break label1813;
                    label2044: arrayOfInt6 = arrayOfInt3;
                    break label1824;
                  }
                long l6 = l3 + paraml.h[i16];
                i16++;
                i17 = i24;
                l3 = l6;
                i18 = i23;
              }
              long l4 = ag.d(l3, 1000000L, paraml.d);
              return new o(paraml, (long[])localObject4, (int[])localObject5, i17, arrayOfLong4, arrayOfInt6, l4);
              i26 = i10;
              i27 = i11;
              i28 = i12;
            }
            int i46 = i33;
            i47 = i45;
            i48 = i46;
          }
        }
        label1794: label1805: label1813: label1824: label2081: label2153: i40 = i31;
        arrayOfInt9 = arrayOfInt8;
        arrayOfInt10 = arrayOfInt7;
        arrayOfLong7 = arrayOfLong5;
        arrayOfLong8 = arrayOfLong6;
        i41 = j;
      }
      label2180: i2 = -1;
      localr6 = localr4;
      i3 = 0;
    }
  }

  public static Metadata a(a.a parama)
  {
    a.b localb1 = parama.d(a.S);
    a.b localb2 = parama.d(a.aC);
    a.b localb3 = parama.d(a.aD);
    if ((localb1 == null) || (localb2 == null) || (localb3 == null) || (c(localb1.aX) != h));
    ArrayList localArrayList;
    do
    {
      return null;
      r localr1 = localb2.aX;
      localr1.c(12);
      int j = localr1.p();
      String[] arrayOfString = new String[j];
      for (int k = 0; k < j; k++)
      {
        int i2 = localr1.p();
        localr1.d(4);
        arrayOfString[k] = localr1.e(i2 - 8);
      }
      r localr2 = localb3.aX;
      localr2.c(8);
      localArrayList = new ArrayList();
      if (localr2.b() > 8)
      {
        int m = localr2.d();
        int n = localr2.p();
        int i1 = -1 + localr2.p();
        if ((i1 >= 0) && (i1 < arrayOfString.length))
        {
          String str = arrayOfString[i1];
          MdtaMetadataEntry localMdtaMetadataEntry = g.a(localr2, m + n, str);
          if (localMdtaMetadataEntry != null)
            localArrayList.add(localMdtaMetadataEntry);
        }
        while (true)
        {
          localr2.c(m + n);
          break;
          com.google.android.exoplayer2.g.l.c("AtomParsers", "Skipped metadata with unknown key index: " + i1);
        }
      }
    }
    while (localArrayList.isEmpty());
    return new Metadata(localArrayList);
  }

  public static Metadata a(a.b paramb, boolean paramBoolean)
  {
    if (paramBoolean);
    while (true)
    {
      return null;
      r localr = paramb.aX;
      localr.c(8);
      while (localr.b() >= 8)
      {
        int j = localr.d();
        int k = localr.p();
        if (localr.p() == a.aB)
        {
          localr.c(j);
          return a(localr, j + k);
        }
        localr.c(j + k);
      }
    }
  }

  private static Metadata a(r paramr, int paramInt)
  {
    paramr.d(12);
    while (paramr.d() < paramInt)
    {
      int j = paramr.d();
      int k = paramr.p();
      if (paramr.p() == a.aD)
      {
        paramr.c(j);
        return b(paramr, j + k);
      }
      paramr.c(j + k);
    }
    return null;
  }

  private static void a(r paramr, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, DrmInitData paramDrmInitData, c paramc, int paramInt6)
    throws w
  {
    paramr.c(8 + (paramInt2 + 8));
    paramr.d(16);
    int j = paramr.i();
    int k = paramr.i();
    float f1 = 1.0F;
    paramr.d(50);
    int m = paramr.d();
    int n = a.Z;
    Pair localPair2;
    DrmInitData localDrmInitData2;
    if (paramInt1 == n)
    {
      localPair2 = c(paramr, paramInt2, paramInt3);
      if (localPair2 != null)
      {
        paramInt1 = ((Integer)localPair2.first).intValue();
        if (paramDrmInitData == null)
        {
          localDrmInitData2 = null;
          paramc.a[paramInt6] = ((m)localPair2.second);
          label104: paramr.c(m);
        }
      }
    }
    for (DrmInitData localDrmInitData1 = localDrmInitData2; ; localDrmInitData1 = paramDrmInitData)
    {
      List localList = null;
      Object localObject = null;
      byte[] arrayOfByte = null;
      int i1 = -1;
      int i2 = 0;
      int i3 = m;
      int i4;
      int i5;
      if (i3 - paramInt2 < paramInt3)
      {
        paramr.c(i3);
        i4 = paramr.d();
        i5 = paramr.p();
        if ((i5 != 0) || (paramr.d() - paramInt2 != paramInt3));
      }
      else
      {
        if (localObject != null)
          break label707;
        return;
        localDrmInitData2 = paramDrmInitData.copyWithSchemeType(((m)localPair2.second).b);
        break;
      }
      boolean bool1;
      label209: int i6;
      boolean bool6;
      label238: int i7;
      if (i5 > 0)
      {
        bool1 = true;
        com.google.android.exoplayer2.g.a.a(bool1, "childAtomSize should be positive");
        i6 = paramr.p();
        if (i6 != a.H)
          break label322;
        if (localObject != null)
          break label316;
        bool6 = true;
        com.google.android.exoplayer2.g.a.b(bool6);
        localObject = "video/avc";
        paramr.c(i4 + 8);
        com.google.android.exoplayer2.video.a locala = com.google.android.exoplayer2.video.a.a(paramr);
        localList = locala.a;
        paramc.c = locala.b;
        if (i2 == 0)
          f1 = locala.e;
        i7 = i2;
      }
      while (true)
      {
        i3 += i5;
        i2 = i7;
        break;
        bool1 = false;
        break label209;
        label316: bool6 = false;
        break label238;
        label322: if (i6 == a.I)
        {
          if (localObject == null);
          for (boolean bool5 = true; ; bool5 = false)
          {
            com.google.android.exoplayer2.g.a.b(bool5);
            localObject = "video/hevc";
            paramr.c(i4 + 8);
            com.google.android.exoplayer2.video.b localb = com.google.android.exoplayer2.video.b.a(paramr);
            localList = localb.a;
            paramc.c = localb.b;
            i7 = i2;
            break;
          }
        }
        if (i6 == a.aN)
        {
          boolean bool4;
          if (localObject == null)
          {
            bool4 = true;
            label409: com.google.android.exoplayer2.g.a.b(bool4);
            int i9 = a.aL;
            if (paramInt1 != i9)
              break label443;
          }
          label443: for (localObject = "video/x-vnd.on2.vp8"; ; localObject = "video/x-vnd.on2.vp9")
          {
            i7 = i2;
            break;
            bool4 = false;
            break label409;
          }
        }
        if (i6 == a.g)
        {
          if (localObject == null);
          for (boolean bool3 = true; ; bool3 = false)
          {
            com.google.android.exoplayer2.g.a.b(bool3);
            localObject = "video/3gpp";
            i7 = i2;
            break;
          }
        }
        if (i6 == a.J)
        {
          if (localObject == null);
          for (boolean bool2 = true; ; bool2 = false)
          {
            com.google.android.exoplayer2.g.a.b(bool2);
            Pair localPair1 = d(paramr, i4);
            String str = (String)localPair1.first;
            localList = Collections.singletonList(localPair1.second);
            localObject = str;
            i7 = i2;
            break;
          }
        }
        if (i6 == a.ai)
        {
          f1 = c(paramr, i4);
          i7 = 1;
        }
        else if (i6 == a.aJ)
        {
          arrayOfByte = d(paramr, i4, i5);
          i7 = i2;
        }
        else
        {
          if (i6 == a.aI)
          {
            int i8 = paramr.h();
            paramr.d(3);
            if (i8 != 0);
          }
          switch (paramr.h())
          {
          default:
            i7 = i2;
            break;
          case 0:
            i7 = i2;
            i1 = 0;
            break;
          case 1:
            i1 = 1;
            i7 = i2;
            break;
          case 2:
            i1 = 2;
            i7 = i2;
            break;
          case 3:
            i1 = 3;
            i7 = i2;
          }
        }
      }
      label707: paramc.b = Format.createVideoSampleFormat(Integer.toString(paramInt4), (String)localObject, null, -1, -1, j, k, -1.0F, localList, paramInt5, f1, arrayOfByte, i1, null, localDrmInitData1);
      return;
      localDrmInitData2 = paramDrmInitData;
      break label104;
    }
  }

  private static void a(r paramr, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, c paramc)
    throws w
  {
    paramr.c(8 + (paramInt2 + 8));
    List localList = null;
    long l = 9223372036854775807L;
    String str;
    if (paramInt1 == a.aj)
      str = "application/ttml+xml";
    while (true)
    {
      paramc.b = Format.createTextSampleFormat(Integer.toString(paramInt4), str, null, -1, 0, paramString, -1, null, l, localList);
      return;
      if (paramInt1 == a.au)
      {
        str = "application/x-quicktime-tx3g";
        int j = -8 + (paramInt3 - 8);
        byte[] arrayOfByte = new byte[j];
        paramr.a(arrayOfByte, 0, j);
        localList = Collections.singletonList(arrayOfByte);
      }
      else if (paramInt1 == a.av)
      {
        str = "application/x-mp4-vtt";
        localList = null;
      }
      else if (paramInt1 == a.aw)
      {
        str = "application/ttml+xml";
        l = 0L;
        localList = null;
      }
      else
      {
        if (paramInt1 != a.ax)
          break;
        str = "application/x-mp4-cea-608";
        paramc.d = 1;
        localList = null;
      }
    }
    throw new IllegalStateException();
  }

  private static void a(r paramr, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, boolean paramBoolean, DrmInitData paramDrmInitData, c paramc, int paramInt5)
    throws w
  {
    paramr.c(8 + (paramInt2 + 8));
    int j;
    int k;
    int m;
    int n;
    int i1;
    if (paramBoolean)
    {
      int i33 = paramr.i();
      paramr.d(6);
      j = i33;
      if ((j != 0) && (j != 1))
        break label366;
      k = paramr.i();
      paramr.d(6);
      m = paramr.t();
      if (j != 1)
        break label1100;
      paramr.d(16);
      n = k;
      i1 = m;
    }
    while (true)
    {
      label81: int i2 = paramr.d();
      int i3 = a.aa;
      Pair localPair3;
      DrmInitData localDrmInitData2;
      if (paramInt1 == i3)
      {
        localPair3 = c(paramr, paramInt2, paramInt3);
        if (localPair3 != null)
        {
          paramInt1 = ((Integer)localPair3.first).intValue();
          if (paramDrmInitData == null)
          {
            localDrmInitData2 = null;
            label131: paramc.a[paramInt5] = ((m)localPair3.second);
            label147: paramr.c(i2);
          }
        }
      }
      for (DrmInitData localDrmInitData1 = localDrmInitData2; ; localDrmInitData1 = paramDrmInitData)
      {
        int i4 = a.n;
        String str1;
        label173: Object localObject1;
        int i8;
        int i9;
        String str2;
        label188: int i11;
        boolean bool;
        label216: int i12;
        int i13;
        label262: Object localObject2;
        if (paramInt1 == i4)
        {
          str1 = "audio/ac3";
          localObject1 = null;
          i8 = i1;
          i9 = n;
          str2 = str1;
          if (i2 - paramInt2 >= paramInt3)
            break label992;
          paramr.c(i2);
          i11 = paramr.p();
          if (i11 <= 0)
            break label708;
          bool = true;
          com.google.android.exoplayer2.g.a.a(bool, "childAtomSize should be positive");
          i12 = paramr.p();
          if ((i12 != a.J) && ((!paramBoolean) || (i12 != a.k)))
            break label727;
          if (i12 != a.J)
            break label714;
          i13 = i2;
          if (i13 == -1)
            break label1079;
          Pair localPair1 = d(paramr, i13);
          str2 = (String)localPair1.first;
          localObject2 = (byte[])localPair1.second;
          if ("audio/mp4a-latm".equals(str2))
          {
            Pair localPair2 = c.a((byte[])localObject2);
            i8 = ((Integer)localPair2.first).intValue();
            i9 = ((Integer)localPair2.second).intValue();
          }
        }
        while (true)
        {
          localObject1 = localObject2;
          while (true)
          {
            i2 += i11;
            break label188;
            paramr.d(8);
            j = 0;
            break;
            label366: if (j != 2)
              break label1062;
            paramr.d(16);
            int i31 = (int)Math.round(paramr.z());
            int i32 = paramr.v();
            paramr.d(20);
            n = i32;
            i1 = i31;
            break label81;
            localDrmInitData2 = paramDrmInitData.copyWithSchemeType(((m)localPair3.second).b);
            break label131;
            int i5 = a.p;
            if (paramInt1 == i5)
            {
              str1 = "audio/eac3";
              break label173;
            }
            int i6 = a.r;
            if (paramInt1 == i6)
            {
              str1 = "audio/vnd.dts";
              break label173;
            }
            int i7 = a.s;
            if (paramInt1 != i7)
            {
              int i18 = a.t;
              if (paramInt1 != i18);
            }
            else
            {
              str1 = "audio/vnd.dts.hd";
              break label173;
            }
            int i19 = a.u;
            if (paramInt1 == i19)
            {
              str1 = "audio/vnd.dts.hd;profile=lbr";
              break label173;
            }
            int i20 = a.ay;
            if (paramInt1 == i20)
            {
              str1 = "audio/3gpp";
              break label173;
            }
            int i21 = a.az;
            if (paramInt1 == i21)
            {
              str1 = "audio/amr-wb";
              break label173;
            }
            int i22 = a.l;
            if (paramInt1 != i22)
            {
              int i23 = a.m;
              if (paramInt1 != i23);
            }
            else
            {
              str1 = "audio/raw";
              break label173;
            }
            int i24 = a.j;
            if (paramInt1 == i24)
            {
              str1 = "audio/mpeg";
              break label173;
            }
            int i25 = a.aP;
            if (paramInt1 == i25)
            {
              str1 = "audio/alac";
              break label173;
            }
            int i26 = a.aQ;
            if (paramInt1 == i26)
            {
              str1 = "audio/g711-alaw";
              break label173;
            }
            int i27 = a.aR;
            if (paramInt1 == i27)
            {
              str1 = "audio/g711-mlaw";
              break label173;
            }
            int i28 = a.aS;
            if (paramInt1 == i28)
            {
              str1 = "audio/opus";
              break label173;
            }
            int i29 = a.aU;
            int i30 = paramInt1;
            str1 = null;
            if (i30 != i29)
              break label173;
            str1 = "audio/flac";
            break label173;
            label708: bool = false;
            break label216;
            label714: i13 = b(paramr, i2, i11);
            break label262;
            label727: if (i12 == a.o)
            {
              paramr.c(i2 + 8);
              paramc.b = com.google.android.exoplayer2.b.a.a(paramr, Integer.toString(paramInt4), paramString, localDrmInitData1);
            }
            else if (i12 == a.q)
            {
              paramr.c(i2 + 8);
              paramc.b = com.google.android.exoplayer2.b.a.b(paramr, Integer.toString(paramInt4), paramString, localDrmInitData1);
            }
            else if (i12 == a.v)
            {
              paramc.b = Format.createAudioSampleFormat(Integer.toString(paramInt4), str2, null, -1, -1, i9, i8, null, localDrmInitData1, 0, paramString);
            }
            else if (i12 == a.aP)
            {
              localObject1 = new byte[i11];
              paramr.c(i2);
              paramr.a((byte[])localObject1, 0, i11);
            }
            else if (i12 == a.aT)
            {
              int i15 = i11 - 8;
              localObject1 = new byte[i15 + i.length];
              byte[] arrayOfByte = i;
              int i16 = i.length;
              System.arraycopy(arrayOfByte, 0, localObject1, 0, i16);
              paramr.c(i2 + 8);
              int i17 = i.length;
              paramr.a((byte[])localObject1, i17, i15);
            }
            else if (i11 == a.aV)
            {
              int i14 = i11 - 12;
              localObject1 = new byte[i14];
              paramr.c(i2 + 12);
              paramr.a((byte[])localObject1, 0, i14);
            }
          }
          label992: int i10;
          String str3;
          if ((paramc.b == null) && (str2 != null))
          {
            if (!"audio/raw".equals(str2))
              break label1063;
            i10 = 2;
            str3 = Integer.toString(paramInt4);
            if (localObject1 != null)
              break label1069;
          }
          label1062: label1063: label1069: for (List localList = null; ; localList = Collections.singletonList(localObject1))
          {
            paramc.b = Format.createAudioSampleFormat(str3, str2, null, -1, -1, i9, i8, i10, localList, localDrmInitData1, 0, paramString);
            return;
            i10 = -1;
            break;
          }
          label1079: localObject2 = localObject1;
        }
        localDrmInitData2 = paramDrmInitData;
        break label147;
      }
      label1100: n = k;
      i1 = m;
    }
  }

  private static boolean a(long[] paramArrayOfLong, long paramLong1, long paramLong2, long paramLong3)
  {
    int j = -1 + paramArrayOfLong.length;
    int k = ag.a(3, 0, j);
    int m = ag.a(-3 + paramArrayOfLong.length, 0, j);
    boolean bool1 = paramArrayOfLong[0] < paramLong2;
    boolean bool2 = false;
    if (!bool1)
    {
      boolean bool3 = paramLong2 < paramArrayOfLong[k];
      bool2 = false;
      if (bool3)
      {
        boolean bool4 = paramArrayOfLong[m] < paramLong3;
        bool2 = false;
        if (bool4)
        {
          boolean bool5 = paramLong3 < paramLong1;
          bool2 = false;
          if (!bool5)
            bool2 = true;
        }
      }
    }
    return bool2;
  }

  private static int b(r paramr, int paramInt1, int paramInt2)
  {
    int j = paramr.d();
    while (j - paramInt1 < paramInt2)
    {
      paramr.c(j);
      int k = paramr.p();
      if (k > 0);
      for (boolean bool = true; ; bool = false)
      {
        com.google.android.exoplayer2.g.a.a(bool, "childAtomSize should be positive");
        if (paramr.p() != a.J)
          break;
        return j;
      }
      j += k;
    }
    return -1;
  }

  private static Pair<long[], long[]> b(a.a parama)
  {
    a.b localb;
    if (parama != null)
    {
      localb = parama.d(a.Q);
      if (localb != null);
    }
    else
    {
      return Pair.create(null, null);
    }
    r localr = localb.aX;
    localr.c(8);
    int j = a.a(localr.p());
    int k = localr.v();
    long[] arrayOfLong1 = new long[k];
    long[] arrayOfLong2 = new long[k];
    for (int m = 0; m < k; m++)
    {
      long l1;
      if (j == 1)
      {
        l1 = localr.x();
        arrayOfLong1[m] = l1;
        if (j != 1)
          break label133;
      }
      label133: for (long l2 = localr.r(); ; l2 = localr.p())
      {
        arrayOfLong2[m] = l2;
        if (localr.k() == 1)
          break label143;
        throw new IllegalArgumentException("Unsupported media rate.");
        l1 = localr.n();
        break;
      }
      label143: localr.d(2);
    }
    return Pair.create(arrayOfLong1, arrayOfLong2);
  }

  private static f b(r paramr)
  {
    int j = 8;
    paramr.c(j);
    int k = a.a(paramr.p());
    int m;
    int n;
    int i3;
    label56: long l;
    label94: int i4;
    int i5;
    int i6;
    int i7;
    int i8;
    if (k == 0)
    {
      m = j;
      paramr.d(m);
      n = paramr.p();
      paramr.d(4);
      int i1 = 1;
      int i2 = paramr.d();
      if (k == 0)
        j = 4;
      i3 = 0;
      if (i3 < j)
      {
        if (paramr.a[(i2 + i3)] == -1)
          break label180;
        i1 = 0;
      }
      if (i1 == 0)
        break label186;
      paramr.d(j);
      l = -9223372036854775807L;
      paramr.d(16);
      i4 = paramr.p();
      i5 = paramr.p();
      paramr.d(4);
      i6 = paramr.p();
      i7 = paramr.p();
      if ((i4 != 0) || (i5 != 65536) || (i6 != -65536) || (i7 != 0))
        break label220;
      i8 = 90;
    }
    while (true)
    {
      return new f(n, l, i8);
      m = 16;
      break;
      label180: i3++;
      break label56;
      label186: if (k == 0);
      for (l = paramr.n(); ; l = paramr.x())
      {
        if (l != 0L)
          break label218;
        l = -9223372036854775807L;
        break;
      }
      label218: break label94;
      label220: if ((i4 == 0) && (i5 == -65536) && (i6 == 65536) && (i7 == 0))
        i8 = 270;
      else if ((i4 == -65536) && (i5 == 0) && (i6 == 0) && (i7 == -65536))
        i8 = 180;
      else
        i8 = 0;
    }
  }

  private static Metadata b(r paramr, int paramInt)
  {
    paramr.d(8);
    ArrayList localArrayList = new ArrayList();
    while (paramr.d() < paramInt)
    {
      Metadata.Entry localEntry = g.a(paramr);
      if (localEntry != null)
        localArrayList.add(localEntry);
    }
    if (localArrayList.isEmpty())
      return null;
    return new Metadata(localArrayList);
  }

  private static float c(r paramr, int paramInt)
  {
    paramr.c(paramInt + 8);
    int j = paramr.v();
    int k = paramr.v();
    return j / k;
  }

  private static int c(r paramr)
  {
    paramr.c(16);
    return paramr.p();
  }

  private static Pair<Integer, m> c(r paramr, int paramInt1, int paramInt2)
  {
    int j = paramr.d();
    while (j - paramInt1 < paramInt2)
    {
      paramr.c(j);
      int k = paramr.p();
      if (k > 0);
      for (boolean bool = true; ; bool = false)
      {
        com.google.android.exoplayer2.g.a.a(bool, "childAtomSize should be positive");
        if (paramr.p() != a.V)
          break;
        Pair localPair = a(paramr, j, k);
        if (localPair == null)
          break;
        return localPair;
      }
      j += k;
    }
    return null;
  }

  private static Pair<Long, String> d(r paramr)
  {
    int j = 8;
    paramr.c(j);
    int k = a.a(paramr.p());
    if (k == 0);
    for (int m = j; ; m = 16)
    {
      paramr.d(m);
      long l = paramr.n();
      if (k == 0)
        j = 4;
      paramr.d(j);
      int n = paramr.i();
      String str = "" + (char)(96 + (0x1F & n >> 10)) + (char)(96 + (0x1F & n >> 5)) + (char)(96 + (n & 0x1F));
      return Pair.create(Long.valueOf(l), str);
    }
  }

  private static Pair<String, byte[]> d(r paramr, int paramInt)
  {
    paramr.c(4 + (paramInt + 8));
    paramr.d(1);
    e(paramr);
    paramr.d(2);
    int j = paramr.h();
    if ((j & 0x80) != 0)
      paramr.d(2);
    if ((j & 0x40) != 0)
      paramr.d(paramr.i());
    if ((j & 0x20) != 0)
      paramr.d(2);
    paramr.d(1);
    e(paramr);
    String str = com.google.android.exoplayer2.g.o.a(paramr.h());
    if (("audio/mpeg".equals(str)) || ("audio/vnd.dts".equals(str)) || ("audio/vnd.dts.hd".equals(str)))
      return Pair.create(str, null);
    paramr.d(12);
    paramr.d(1);
    int k = e(paramr);
    byte[] arrayOfByte = new byte[k];
    paramr.a(arrayOfByte, 0, k);
    return Pair.create(str, arrayOfByte);
  }

  private static byte[] d(r paramr, int paramInt1, int paramInt2)
  {
    int j = paramInt1 + 8;
    while (j - paramInt1 < paramInt2)
    {
      paramr.c(j);
      int k = paramr.p();
      if (paramr.p() == a.aK)
        return Arrays.copyOfRange(paramr.a, j, k + j);
      j += k;
    }
    return null;
  }

  private static int e(r paramr)
  {
    int j = paramr.h();
    for (int k = j & 0x7F; (j & 0x80) == 128; k = k << 7 | j & 0x7F)
      j = paramr.h();
    return k;
  }

  private static final class a
  {
    public final int a;
    public int b;
    public int c;
    public long d;
    private final boolean e;
    private final r f;
    private final r g;
    private int h;
    private int i;

    public a(r paramr1, r paramr2, boolean paramBoolean)
    {
      this.g = paramr1;
      this.f = paramr2;
      this.e = paramBoolean;
      paramr2.c(12);
      this.a = paramr2.v();
      paramr1.c(12);
      this.i = paramr1.v();
      if (paramr1.p() == j);
      while (true)
      {
        com.google.android.exoplayer2.g.a.b(j, "first_chunk must be 1");
        this.b = -1;
        return;
        int k = 0;
      }
    }

    public boolean a()
    {
      int j = 1 + this.b;
      this.b = j;
      if (j == this.a)
        return false;
      long l;
      if (this.e)
      {
        l = this.f.x();
        this.d = l;
        if (this.b == this.h)
        {
          this.c = this.g.v();
          this.g.d(4);
          int k = -1 + this.i;
          this.i = k;
          if (k <= 0)
            break label121;
        }
      }
      label121: for (int m = -1 + this.g.v(); ; m = -1)
      {
        this.h = m;
        return true;
        l = this.f.n();
        break;
      }
    }
  }

  private static abstract interface b
  {
    public abstract int a();

    public abstract int b();

    public abstract boolean c();
  }

  private static final class c
  {
    public final m[] a;
    public Format b;
    public int c;
    public int d;

    public c(int paramInt)
    {
      this.a = new m[paramInt];
      this.d = 0;
    }
  }

  static final class d
    implements b.b
  {
    private final int a;
    private final int b;
    private final r c;

    public d(a.b paramb)
    {
      this.c = paramb.aX;
      this.c.c(12);
      this.a = this.c.v();
      this.b = this.c.v();
    }

    public int a()
    {
      return this.b;
    }

    public int b()
    {
      if (this.a == 0)
        return this.c.v();
      return this.a;
    }

    public boolean c()
    {
      return this.a != 0;
    }
  }

  static final class e
    implements b.b
  {
    private final r a;
    private final int b;
    private final int c;
    private int d;
    private int e;

    public e(a.b paramb)
    {
      this.a = paramb.aX;
      this.a.c(12);
      this.c = (0xFF & this.a.v());
      this.b = this.a.v();
    }

    public int a()
    {
      return this.b;
    }

    public int b()
    {
      if (this.c == 8)
        return this.a.h();
      if (this.c == 16)
        return this.a.i();
      int i = this.d;
      this.d = (i + 1);
      if (i % 2 == 0)
      {
        this.e = this.a.h();
        return (0xF0 & this.e) >> 4;
      }
      return 0xF & this.e;
    }

    public boolean c()
    {
      return false;
    }
  }

  private static final class f
  {
    private final int a;
    private final long b;
    private final int c;

    public f(int paramInt1, long paramLong, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramLong;
      this.c = paramInt2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.b
 * JD-Core Version:    0.6.2
 */