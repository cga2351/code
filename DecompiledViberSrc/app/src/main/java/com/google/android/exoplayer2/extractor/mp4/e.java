package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.extractor.o.b;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.extractor.q.a;
import com.google.android.exoplayer2.g.ad;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.p;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.w;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public final class e
  implements com.google.android.exoplayer2.extractor.g
{
  public static final com.google.android.exoplayer2.extractor.j a = f.a;
  private static final int b = ag.g("seig");
  private static final byte[] c = { -94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12 };
  private static final Format d = Format.createSampleFormat(null, "application/x-emsg", 9223372036854775807L);
  private long A;
  private long B;
  private b C;
  private int D;
  private int E;
  private int F;
  private boolean G;
  private i H;
  private q[] I;
  private q[] J;
  private boolean K;
  private final int e;
  private final l f;
  private final List<Format> g;
  private final DrmInitData h;
  private final SparseArray<b> i;
  private final r j;
  private final r k;
  private final r l;
  private final ad m;
  private final r n;
  private final byte[] o;
  private final ArrayDeque<a.a> p;
  private final ArrayDeque<a> q;
  private final q r;
  private int s;
  private int t;
  private long u;
  private int v;
  private r w;
  private long x;
  private int y;
  private long z;

  public e()
  {
    this(0);
  }

  public e(int paramInt)
  {
    this(paramInt, null);
  }

  public e(int paramInt, ad paramad)
  {
    this(paramInt, paramad, null, null);
  }

  public e(int paramInt, ad paramad, l paraml, DrmInitData paramDrmInitData)
  {
    this(paramInt, paramad, paraml, paramDrmInitData, Collections.emptyList());
  }

  public e(int paramInt, ad paramad, l paraml, DrmInitData paramDrmInitData, List<Format> paramList)
  {
    this(paramInt, paramad, paraml, paramDrmInitData, paramList, null);
  }

  public e(int paramInt, ad paramad, l paraml, DrmInitData paramDrmInitData, List<Format> paramList, q paramq)
  {
    if (paraml != null);
    for (int i1 = 8; ; i1 = 0)
    {
      this.e = (i1 | paramInt);
      this.m = paramad;
      this.f = paraml;
      this.h = paramDrmInitData;
      this.g = Collections.unmodifiableList(paramList);
      this.r = paramq;
      this.n = new r(16);
      this.j = new r(p.a);
      this.k = new r(5);
      this.l = new r();
      this.o = new byte[16];
      this.p = new ArrayDeque();
      this.q = new ArrayDeque();
      this.i = new SparseArray();
      this.A = -9223372036854775807L;
      this.z = -9223372036854775807L;
      this.B = -9223372036854775807L;
      b();
      return;
    }
  }

  private static int a(b paramb, int paramInt1, long paramLong, int paramInt2, r paramr, int paramInt3)
  {
    paramr.c(8);
    int i1 = a.b(paramr.p());
    l locall = paramb.c;
    n localn = paramb.b;
    c localc = localn.a;
    localn.h[paramInt1] = paramr.v();
    localn.g[paramInt1] = localn.c;
    if ((i1 & 0x1) != 0)
    {
      long[] arrayOfLong2 = localn.g;
      arrayOfLong2[paramInt1] += paramr.p();
    }
    int i2;
    int i3;
    int i4;
    label130: int i5;
    label142: int i6;
    label154: int i7;
    if ((i1 & 0x4) != 0)
    {
      i2 = 1;
      i3 = localc.d;
      if (i2 != 0)
        i3 = paramr.v();
      if ((i1 & 0x100) == 0)
        break label439;
      i4 = 1;
      if ((i1 & 0x200) == 0)
        break label445;
      i5 = 1;
      if ((i1 & 0x400) == 0)
        break label451;
      i6 = 1;
      if ((i1 & 0x800) == 0)
        break label457;
      i7 = 1;
      label166: if ((locall.h == null) || (locall.h.length != 1) || (locall.h[0] != 0L))
        break label539;
    }
    label263: label523: label529: label539: for (long l1 = ag.d(locall.i[0], 1000L, locall.c); ; l1 = 0L)
    {
      int[] arrayOfInt1 = localn.i;
      int[] arrayOfInt2 = localn.j;
      long[] arrayOfLong1 = localn.k;
      boolean[] arrayOfBoolean = localn.l;
      int i8;
      int i9;
      long l3;
      label295: int i10;
      label314: int i11;
      label326: int i12;
      if ((locall.b == 2) && ((paramInt2 & 0x1) != 0))
      {
        i8 = 1;
        i9 = paramInt3 + localn.h[paramInt1];
        long l2 = locall.c;
        if (paramInt1 > 0)
          paramLong = localn.s;
        l3 = paramLong;
        if (paramInt3 >= i9)
          break label529;
        if (i4 == 0)
          break label469;
        i10 = paramr.v();
        if (i5 == 0)
          break label479;
        i11 = paramr.v();
        if ((paramInt3 != 0) || (i2 == 0))
          break label489;
        i12 = i3;
        label340: if (i7 == 0)
          break label514;
        arrayOfInt2[paramInt3] = ((int)(1000L * paramr.p() / l2));
        label364: arrayOfLong1[paramInt3] = (ag.d(l3, 1000L, l2) - l1);
        arrayOfInt1[paramInt3] = i11;
        if (((0x1 & i12 >> 16) != 0) || ((i8 != 0) && (paramInt3 != 0)))
          break label523;
      }
      for (int i13 = 1; ; i13 = 0)
      {
        arrayOfBoolean[paramInt3] = i13;
        l3 += i10;
        paramInt3++;
        break label295;
        i2 = 0;
        break;
        label439: i4 = 0;
        break label130;
        label445: i5 = 0;
        break label142;
        label451: i6 = 0;
        break label154;
        label457: i7 = 0;
        break label166;
        i8 = 0;
        break label263;
        label469: i10 = localc.b;
        break label314;
        label479: i11 = localc.c;
        break label326;
        label489: if (i6 != 0)
        {
          i12 = paramr.p();
          break label340;
        }
        i12 = localc.d;
        break label340;
        arrayOfInt2[paramInt3] = 0;
        break label364;
      }
      localn.s = l3;
      return i9;
    }
  }

  private static Pair<Long, com.google.android.exoplayer2.extractor.b> a(r paramr, long paramLong)
    throws w
  {
    paramr.c(8);
    int i1 = a.a(paramr.p());
    paramr.d(4);
    long l1 = paramr.n();
    long l3;
    long l4;
    long l5;
    int i2;
    int[] arrayOfInt;
    long[] arrayOfLong1;
    long[] arrayOfLong2;
    long[] arrayOfLong3;
    long l6;
    int i3;
    long l7;
    if (i1 == 0)
    {
      long l12 = paramr.n();
      l3 = paramLong + paramr.n();
      l4 = l12;
      l5 = ag.d(l4, 1000000L, l1);
      paramr.d(2);
      i2 = paramr.i();
      arrayOfInt = new int[i2];
      arrayOfLong1 = new long[i2];
      arrayOfLong2 = new long[i2];
      arrayOfLong3 = new long[i2];
      l6 = l3;
      i3 = 0;
      l7 = l4;
    }
    long l11;
    for (long l8 = l5; ; l8 = l11)
    {
      if (i3 >= i2)
        break label256;
      int i4 = paramr.p();
      if ((0x80000000 & i4) != 0)
      {
        throw new w("Unhandled indirect reference");
        long l2 = paramr.x();
        l3 = paramLong + paramr.x();
        l4 = l2;
        break;
      }
      long l9 = paramr.n();
      arrayOfInt[i3] = (i4 & 0x7FFFFFFF);
      arrayOfLong1[i3] = l6;
      arrayOfLong3[i3] = l8;
      long l10 = l7 + l9;
      l11 = ag.d(l10, 1000000L, l1);
      arrayOfLong2[i3] = (l11 - arrayOfLong3[i3]);
      paramr.d(4);
      l6 += arrayOfInt[i3];
      i3++;
      l7 = l10;
    }
    label256: return Pair.create(Long.valueOf(l5), new com.google.android.exoplayer2.extractor.b(arrayOfInt, arrayOfLong1, arrayOfLong2, arrayOfLong3));
  }

  private static DrmInitData a(List<a.b> paramList)
  {
    int i1 = paramList.size();
    int i2 = 0;
    ArrayList localArrayList = null;
    if (i2 < i1)
    {
      a.b localb = (a.b)paramList.get(i2);
      byte[] arrayOfByte;
      UUID localUUID;
      if (localb.aW == a.U)
      {
        if (localArrayList == null)
          localArrayList = new ArrayList();
        arrayOfByte = localb.aX.a;
        localUUID = j.a(arrayOfByte);
        if (localUUID != null)
          break label88;
        com.google.android.exoplayer2.g.l.c("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
      }
      while (true)
      {
        i2++;
        break;
        label88: localArrayList.add(new DrmInitData.SchemeData(localUUID, "video/mp4", arrayOfByte));
      }
    }
    if (localArrayList == null)
      return null;
    return new DrmInitData(localArrayList);
  }

  private c a(SparseArray<c> paramSparseArray, int paramInt)
  {
    if (paramSparseArray.size() == 1)
      return (c)paramSparseArray.valueAt(0);
    return (c)com.google.android.exoplayer2.g.a.a(paramSparseArray.get(paramInt));
  }

  private static b a(SparseArray<b> paramSparseArray)
  {
    Object localObject1 = null;
    long l1 = 9223372036854775807L;
    int i1 = paramSparseArray.size();
    int i2 = 0;
    b localb;
    Object localObject2;
    long l4;
    if (i2 < i1)
    {
      localb = (b)paramSparseArray.valueAt(i2);
      if (localb.g == localb.b.e)
      {
        long l6 = l1;
        localObject2 = localObject1;
        l4 = l6;
      }
    }
    while (true)
    {
      i2++;
      long l5 = l4;
      localObject1 = localObject2;
      l1 = l5;
      break;
      long l2 = localb.b.g[localb.g];
      if (l2 < l1)
      {
        localObject2 = localb;
        l4 = l2;
        continue;
        return localObject1;
      }
      else
      {
        long l3 = l1;
        localObject2 = localObject1;
        l4 = l3;
      }
    }
  }

  private static b a(r paramr, SparseArray<b> paramSparseArray)
  {
    paramr.c(8);
    int i1 = a.b(paramr.p());
    b localb = b(paramSparseArray, paramr.p());
    if (localb == null)
      return null;
    if ((i1 & 0x1) != 0)
    {
      long l1 = paramr.x();
      localb.b.c = l1;
      localb.b.d = l1;
    }
    c localc = localb.d;
    int i2;
    int i3;
    label92: int i4;
    if ((i1 & 0x2) != 0)
    {
      i2 = -1 + paramr.v();
      if ((i1 & 0x8) == 0)
        break label152;
      i3 = paramr.v();
      if ((i1 & 0x10) == 0)
        break label162;
      i4 = paramr.v();
      label105: if ((i1 & 0x20) == 0)
        break label172;
    }
    label152: label162: label172: for (int i5 = paramr.v(); ; i5 = localc.d)
    {
      localb.b.a = new c(i2, i3, i4, i5);
      return localb;
      i2 = localc.a;
      break;
      i3 = localc.b;
      break label92;
      i4 = localc.c;
      break label105;
    }
  }

  private void a(long paramLong)
    throws w
  {
    while ((!this.p.isEmpty()) && (((a.a)this.p.peek()).aX == paramLong))
      a((a.a)this.p.pop());
    b();
  }

  private void a(a.a parama)
    throws w
  {
    if (parama.aW == a.B)
      b(parama);
    do
    {
      return;
      if (parama.aW == a.K)
      {
        c(parama);
        return;
      }
    }
    while (this.p.isEmpty());
    ((a.a)this.p.peek()).a(parama);
  }

  private static void a(a.a parama, SparseArray<b> paramSparseArray, int paramInt, byte[] paramArrayOfByte)
    throws w
  {
    int i1 = parama.aZ.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      a.a locala = (a.a)parama.aZ.get(i2);
      if (locala.aW == a.L)
        b(locala, paramSparseArray, paramInt, paramArrayOfByte);
    }
  }

  private static void a(a.a parama, b paramb, long paramLong, int paramInt)
  {
    List localList = parama.aY;
    int i1 = localList.size();
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i9;
    if (i2 < i1)
    {
      a.b localb2 = (a.b)localList.get(i2);
      if (localb2.aW != a.z)
        break label211;
      r localr = localb2.aX;
      localr.c(12);
      int i11 = localr.v();
      if (i11 <= 0)
        break label211;
      i9 = i11 + i3;
    }
    for (int i10 = i4 + 1; ; i10 = i4)
    {
      i2++;
      i4 = i10;
      i3 = i9;
      break;
      paramb.g = 0;
      paramb.f = 0;
      paramb.e = 0;
      paramb.b.a(i4, i3);
      int i5 = 0;
      int i6 = 0;
      int i7 = 0;
      while (i5 < i1)
      {
        a.b localb1 = (a.b)localList.get(i5);
        if (localb1.aW == a.z)
        {
          int i8 = i7 + 1;
          i6 = a(paramb, i7, paramLong, paramInt, localb1.aX, i6);
          i7 = i8;
        }
        i5++;
      }
      return;
      label211: i9 = i3;
    }
  }

  private void a(a.b paramb, long paramLong)
    throws w
  {
    if (!this.p.isEmpty())
      ((a.a)this.p.peek()).a(paramb);
    do
    {
      return;
      if (paramb.aW == a.A)
      {
        Pair localPair = a(paramb.aX, paramLong);
        this.B = ((Long)localPair.first).longValue();
        this.H.a((o)localPair.second);
        this.K = true;
        return;
      }
    }
    while (paramb.aW != a.aH);
    a(paramb.aX);
  }

  private static void a(m paramm, r paramr, n paramn)
    throws w
  {
    int i1 = 1;
    int i3 = paramm.d;
    paramr.c(8);
    if ((0x1 & a.b(paramr.p())) == i1)
      paramr.d(8);
    int i4 = paramr.h();
    int i5 = paramr.v();
    if (i5 != paramn.f)
      throw new w("Length mismatch: " + i5 + ", " + paramn.f);
    int i6;
    if (i4 == 0)
    {
      boolean[] arrayOfBoolean = paramn.n;
      int i7 = 0;
      i6 = 0;
      if (i7 < i5)
      {
        int i8 = paramr.h();
        int i9 = i6 + i8;
        if (i8 > i3);
        int i11;
        for (int i10 = i1; ; i11 = 0)
        {
          arrayOfBoolean[i7] = i10;
          i7++;
          i6 = i9;
          break;
        }
      }
    }
    else
    {
      if (i4 <= i3)
        break label200;
    }
    while (true)
    {
      i6 = 0 + i4 * i5;
      Arrays.fill(paramn.n, 0, i5, i1);
      paramn.a(i6);
      return;
      label200: int i2 = 0;
    }
  }

  private void a(r paramr)
  {
    if ((this.I == null) || (this.I.length == 0));
    int i1;
    long l2;
    while (true)
    {
      return;
      paramr.c(12);
      i1 = paramr.b();
      paramr.A();
      paramr.A();
      long l1 = paramr.n();
      l2 = ag.d(paramr.n(), 1000000L, l1);
      for (q localq : this.I)
      {
        paramr.c(12);
        localq.a(paramr, i1);
      }
      if (this.B == -9223372036854775807L)
        break;
      long l3 = l2 + this.B;
      if (this.m != null)
        l3 = this.m.c(l3);
      q[] arrayOfq2 = this.I;
      int i4 = arrayOfq2.length;
      for (int i5 = 0; i5 < i4; i5++)
        arrayOfq2[i5].a(l3, 1, i1, 0, null);
    }
    this.q.addLast(new a(l2, i1));
    this.y = (i1 + this.y);
  }

  private static void a(r paramr, int paramInt, n paramn)
    throws w
  {
    paramr.c(paramInt + 8);
    int i1 = a.b(paramr.p());
    if ((i1 & 0x1) != 0)
      throw new w("Overriding TrackEncryptionBox parameters is unsupported.");
    if ((i1 & 0x2) != 0);
    int i2;
    for (boolean bool = true; ; bool = false)
    {
      i2 = paramr.v();
      if (i2 == paramn.f)
        break;
      throw new w("Length mismatch: " + i2 + ", " + paramn.f);
    }
    Arrays.fill(paramn.n, 0, i2, bool);
    paramn.a(paramr.b());
    paramn.a(paramr);
  }

  private static void a(r paramr, n paramn)
    throws w
  {
    paramr.c(8);
    int i1 = paramr.p();
    if ((0x1 & a.b(i1)) == 1)
      paramr.d(8);
    int i2 = paramr.v();
    if (i2 != 1)
      throw new w("Unexpected saio entry count: " + i2);
    int i3 = a.a(i1);
    long l1 = paramn.d;
    if (i3 == 0);
    for (long l2 = paramr.n(); ; l2 = paramr.x())
    {
      paramn.d = (l2 + l1);
      return;
    }
  }

  private static void a(r paramr, n paramn, byte[] paramArrayOfByte)
    throws w
  {
    paramr.c(8);
    paramr.a(paramArrayOfByte, 0, 16);
    if (!Arrays.equals(paramArrayOfByte, c))
      return;
    a(paramr, 16, paramn);
  }

  private static void a(r paramr1, r paramr2, String paramString, n paramn)
    throws w
  {
    paramr1.c(8);
    int i1 = paramr1.p();
    if (paramr1.p() != b);
    while (true)
    {
      return;
      if (a.a(i1) == 1)
        paramr1.d(4);
      if (paramr1.p() != 1)
        throw new w("Entry count in sbgp != 1 (unsupported).");
      paramr2.c(8);
      int i2 = paramr2.p();
      if (paramr2.p() == b)
      {
        int i3 = a.a(i2);
        if (i3 == 1)
        {
          if (paramr2.n() == 0L)
            throw new w("Variable length description in sgpd found (unsupported)");
        }
        else if (i3 >= 2)
          paramr2.d(4);
        if (paramr2.n() != 1L)
          throw new w("Entry count in sgpd != 1 (unsupported).");
        paramr2.d(1);
        int i4 = paramr2.h();
        int i5 = (i4 & 0xF0) >> 4;
        int i6 = i4 & 0xF;
        if (paramr2.h() == 1);
        for (boolean bool = true; bool; bool = false)
        {
          int i7 = paramr2.h();
          byte[] arrayOfByte1 = new byte[16];
          paramr2.a(arrayOfByte1, 0, arrayOfByte1.length);
          byte[] arrayOfByte2 = null;
          if (bool)
          {
            arrayOfByte2 = null;
            if (i7 == 0)
            {
              int i8 = paramr2.h();
              arrayOfByte2 = new byte[i8];
              paramr2.a(arrayOfByte2, 0, i8);
            }
          }
          paramn.m = true;
          paramn.o = new m(bool, paramString, i7, arrayOfByte1, i5, i6, arrayOfByte2);
          return;
        }
      }
    }
  }

  private static boolean a(int paramInt)
  {
    return (paramInt == a.S) || (paramInt == a.R) || (paramInt == a.C) || (paramInt == a.A) || (paramInt == a.T) || (paramInt == a.w) || (paramInt == a.x) || (paramInt == a.O) || (paramInt == a.y) || (paramInt == a.z) || (paramInt == a.U) || (paramInt == a.ac) || (paramInt == a.ad) || (paramInt == a.ah) || (paramInt == a.ag) || (paramInt == a.ae) || (paramInt == a.af) || (paramInt == a.Q) || (paramInt == a.N) || (paramInt == a.aH);
  }

  private static Pair<Integer, c> b(r paramr)
  {
    paramr.c(12);
    int i1 = paramr.p();
    int i2 = -1 + paramr.v();
    int i3 = paramr.v();
    int i4 = paramr.v();
    int i5 = paramr.p();
    return Pair.create(Integer.valueOf(i1), new c(i2, i3, i4, i5));
  }

  private static b b(SparseArray<b> paramSparseArray, int paramInt)
  {
    if (paramSparseArray.size() == 1)
      return (b)paramSparseArray.valueAt(0);
    return (b)paramSparseArray.get(paramInt);
  }

  private void b()
  {
    this.s = 0;
    this.v = 0;
  }

  private void b(long paramLong)
  {
    if (!this.q.isEmpty())
    {
      a locala = (a)this.q.removeFirst();
      this.y -= locala.b;
      long l1 = paramLong + locala.a;
      if (this.m != null)
        l1 = this.m.c(l1);
      q[] arrayOfq = this.I;
      int i1 = arrayOfq.length;
      for (int i2 = 0; i2 < i1; i2++)
        arrayOfq[i2].a(l1, 1, locala.b, this.y, null);
    }
  }

  private void b(a.a parama)
    throws w
  {
    boolean bool1 = true;
    boolean bool2;
    DrmInitData localDrmInitData;
    label31: SparseArray localSparseArray1;
    long l1;
    int i2;
    label69: a.b localb2;
    if (this.f == null)
    {
      bool2 = bool1;
      com.google.android.exoplayer2.g.a.b(bool2, "Unexpected moov box.");
      if (this.h == null)
        break label146;
      localDrmInitData = this.h;
      a.a locala1 = parama.e(a.M);
      localSparseArray1 = new SparseArray();
      l1 = -9223372036854775807L;
      int i1 = locala1.aY.size();
      i2 = 0;
      if (i2 >= i1)
        break label182;
      localb2 = (a.b)locala1.aY.get(i2);
      if (localb2.aW != a.y)
        break label158;
      Pair localPair = b(localb2.aX);
      localSparseArray1.put(((Integer)localPair.first).intValue(), localPair.second);
    }
    while (true)
    {
      i2++;
      break label69;
      bool2 = false;
      break;
      label146: localDrmInitData = a(parama.aY);
      break label31;
      label158: if (localb2.aW == a.N)
        l1 = c(localb2.aX);
    }
    label182: SparseArray localSparseArray2 = new SparseArray();
    int i3 = parama.aZ.size();
    int i4 = 0;
    if (i4 < i3)
    {
      a.a locala2 = (a.a)parama.aZ.get(i4);
      a.b localb1;
      if (locala2.aW == a.D)
      {
        localb1 = parama.d(a.C);
        if ((0x10 & this.e) == 0)
          break label300;
      }
      label300: for (boolean bool3 = bool1; ; bool3 = false)
      {
        l locall3 = b.a(locala2, localb1, l1, localDrmInitData, bool3, false);
        if (locall3 != null)
          localSparseArray2.put(locall3.a, locall3);
        i4++;
        break;
      }
    }
    int i5 = localSparseArray2.size();
    int i6 = this.i.size();
    int i7 = 0;
    if (i6 == 0)
    {
      while (i7 < i5)
      {
        l locall2 = (l)localSparseArray2.valueAt(i7);
        b localb = new b(this.H.a(i7, locall2.b));
        localb.a(locall2, a(localSparseArray1, locall2.a));
        this.i.put(locall2.a, localb);
        this.A = Math.max(this.A, locall2.e);
        i7++;
      }
      d();
      this.H.a();
      return;
    }
    if (this.i.size() == i5);
    while (true)
    {
      com.google.android.exoplayer2.g.a.b(bool1);
      while (i7 < i5)
      {
        l locall1 = (l)localSparseArray2.valueAt(i7);
        ((b)this.i.get(locall1.a)).a(locall1, a(localSparseArray1, locall1.a));
        i7++;
      }
      break;
      bool1 = false;
    }
  }

  private static void b(a.a parama, SparseArray<b> paramSparseArray, int paramInt, byte[] paramArrayOfByte)
    throws w
  {
    b localb = a(parama.d(a.x).aX, paramSparseArray);
    if (localb == null)
      return;
    n localn = localb.b;
    long l1 = localn.s;
    localb.a();
    if ((parama.d(a.w) != null) && ((paramInt & 0x2) == 0))
      l1 = d(parama.d(a.w).aX);
    a(parama, localb, l1, paramInt);
    m localm = localb.c.a(localn.a.a);
    a.b localb1 = parama.d(a.ac);
    if (localb1 != null)
      a(localm, localb1.aX, localn);
    a.b localb2 = parama.d(a.ad);
    if (localb2 != null)
      a(localb2.aX, localn);
    a.b localb3 = parama.d(a.ah);
    if (localb3 != null)
      b(localb3.aX, localn);
    a.b localb4 = parama.d(a.ae);
    a.b localb5 = parama.d(a.af);
    r localr1;
    r localr2;
    if ((localb4 != null) && (localb5 != null))
    {
      localr1 = localb4.aX;
      localr2 = localb5.aX;
      if (localm == null)
        break label303;
    }
    label303: for (String str = localm.b; ; str = null)
    {
      a(localr1, localr2, str, localn);
      int i1 = parama.aY.size();
      for (int i2 = 0; i2 < i1; i2++)
      {
        a.b localb6 = (a.b)parama.aY.get(i2);
        if (localb6.aW == a.ag)
          a(localb6.aX, localn, paramArrayOfByte);
      }
      break;
    }
  }

  private static void b(r paramr, n paramn)
    throws w
  {
    a(paramr, 0, paramn);
  }

  private static boolean b(int paramInt)
  {
    return (paramInt == a.B) || (paramInt == a.D) || (paramInt == a.E) || (paramInt == a.F) || (paramInt == a.G) || (paramInt == a.K) || (paramInt == a.L) || (paramInt == a.M) || (paramInt == a.P);
  }

  private boolean b(h paramh)
    throws IOException, InterruptedException
  {
    if (this.v == 0)
    {
      if (!paramh.a(this.n.a, 0, 8, true))
        return false;
      this.v = 8;
      this.n.c(0);
      this.u = this.n.n();
      this.t = this.n.p();
    }
    if (this.u == 1L)
    {
      paramh.b(this.n.a, 8, 8);
      this.v = (8 + this.v);
      this.u = this.n.x();
    }
    while (this.u < this.v)
    {
      throw new w("Atom size less than header length (unsupported).");
      if (this.u == 0L)
      {
        long l1 = paramh.d();
        if ((l1 == -1L) && (!this.p.isEmpty()))
          l1 = ((a.a)this.p.peek()).aX;
        if (l1 != -1L)
          this.u = (l1 - paramh.c() + this.v);
      }
    }
    long l2 = paramh.c() - this.v;
    if (this.t == a.K)
    {
      int i1 = this.i.size();
      for (int i2 = 0; i2 < i1; i2++)
      {
        n localn = ((b)this.i.valueAt(i2)).b;
        localn.b = l2;
        localn.d = l2;
        localn.c = l2;
      }
    }
    if (this.t == a.h)
    {
      this.C = null;
      this.x = (l2 + this.u);
      if (!this.K)
      {
        this.H.a(new o.b(this.A, l2));
        this.K = true;
      }
      this.s = 2;
      return true;
    }
    if (b(this.t))
    {
      long l3 = paramh.c() + this.u - 8L;
      this.p.push(new a.a(this.t, l3));
      if (this.u == this.v)
        a(l3);
    }
    while (true)
    {
      return true;
      b();
      continue;
      if (a(this.t))
      {
        if (this.v != 8)
          throw new w("Leaf atom defines extended atom size (unsupported).");
        if (this.u > 2147483647L)
          throw new w("Leaf atom with length > 2147483647 (unsupported).");
        this.w = new r((int)this.u);
        System.arraycopy(this.n.a, 0, this.w.a, 0, 8);
        this.s = 1;
      }
      else
      {
        if (this.u > 2147483647L)
          throw new w("Skipping atom with length > 2147483647 (unsupported).");
        this.w = null;
        this.s = 1;
      }
    }
  }

  private static long c(r paramr)
  {
    paramr.c(8);
    if (a.a(paramr.p()) == 0)
      return paramr.n();
    return paramr.x();
  }

  private void c(h paramh)
    throws IOException, InterruptedException
  {
    int i1 = (int)this.u - this.v;
    if (this.w != null)
    {
      paramh.b(this.w.a, 8, i1);
      a(new a.b(this.t, this.w), paramh.c());
    }
    while (true)
    {
      a(paramh.c());
      return;
      paramh.b(i1);
    }
  }

  private void c(a.a parama)
    throws w
  {
    int i1 = 0;
    a(parama, this.i, this.e, this.o);
    if (this.h != null);
    for (DrmInitData localDrmInitData = null; localDrmInitData != null; localDrmInitData = a(parama.aY))
    {
      int i3 = this.i.size();
      for (int i4 = 0; i4 < i3; i4++)
        ((b)this.i.valueAt(i4)).a(localDrmInitData);
    }
    if (this.z != -9223372036854775807L)
    {
      int i2 = this.i.size();
      while (i1 < i2)
      {
        ((b)this.i.valueAt(i1)).a(this.z);
        i1++;
      }
      this.z = -9223372036854775807L;
    }
  }

  private static long d(r paramr)
  {
    paramr.c(8);
    if (a.a(paramr.p()) == 1)
      return paramr.x();
    return paramr.n();
  }

  private void d()
  {
    int i1 = 0;
    int i2;
    if (this.I == null)
    {
      this.I = new q[2];
      if (this.r == null)
        break label226;
      q[] arrayOfq3 = this.I;
      i2 = 1;
      arrayOfq3[0] = this.r;
    }
    while (true)
    {
      if ((0x4 & this.e) != 0)
      {
        q[] arrayOfq2 = this.I;
        int i5 = i2 + 1;
        arrayOfq2[i2] = this.H.a(this.i.size(), 4);
        i2 = i5;
      }
      this.I = ((q[])Arrays.copyOf(this.I, i2));
      q[] arrayOfq1 = this.I;
      int i3 = arrayOfq1.length;
      for (int i4 = 0; i4 < i3; i4++)
        arrayOfq1[i4].a(d);
      if (this.J == null)
      {
        this.J = new q[this.g.size()];
        while (i1 < this.J.length)
        {
          q localq = this.H.a(i1 + (1 + this.i.size()), 3);
          localq.a((Format)this.g.get(i1));
          this.J[i1] = localq;
          i1++;
        }
      }
      return;
      label226: i2 = 0;
    }
  }

  private void d(h paramh)
    throws IOException, InterruptedException
  {
    Object localObject1 = null;
    long l1 = 9223372036854775807L;
    int i1 = this.i.size();
    int i2 = 0;
    long l5;
    Object localObject2;
    if (i2 < i1)
    {
      n localn = ((b)this.i.valueAt(i2)).b;
      if ((!localn.r) || (localn.d >= l1))
        break label155;
      l5 = localn.d;
      localObject2 = (b)this.i.valueAt(i2);
    }
    label155: long l2;
    for (long l3 = l5; ; l3 = l2)
    {
      i2++;
      long l4 = l3;
      localObject1 = localObject2;
      l1 = l4;
      break;
      if (localObject1 == null)
      {
        this.s = 3;
        return;
      }
      int i3 = (int)(l1 - paramh.c());
      if (i3 < 0)
        throw new w("Offset to encryption data was negative.");
      paramh.b(i3);
      localObject1.b.a(paramh);
      return;
      l2 = l1;
      localObject2 = localObject1;
    }
  }

  private boolean e(h paramh)
    throws IOException, InterruptedException
  {
    if (this.s == 3)
    {
      if (this.C == null)
      {
        b localb = a(this.i);
        if (localb == null)
        {
          int i11 = (int)(this.x - paramh.c());
          if (i11 < 0)
            throw new w("Offset to end of mdat was negative.");
          paramh.b(i11);
          b();
          return false;
        }
        int i10 = (int)(localb.b.g[localb.g] - paramh.c());
        if (i10 < 0)
        {
          com.google.android.exoplayer2.g.l.c("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
          i10 = 0;
        }
        paramh.b(i10);
        this.C = localb;
      }
      this.D = this.C.b.i[this.C.e];
      if (this.C.e < this.C.h)
      {
        paramh.b(this.D);
        b.a(this.C);
        if (!this.C.b())
          this.C = null;
        this.s = 3;
        return true;
      }
      if (this.C.c.g == 1)
      {
        this.D = (-8 + this.D);
        paramh.b(8);
      }
      this.E = this.C.c();
      this.D += this.E;
      this.s = 4;
      this.F = 0;
    }
    n localn = this.C.b;
    l locall = this.C.c;
    q localq = this.C.a;
    int i1 = this.C.e;
    long l1 = 1000L * localn.b(i1);
    if (this.m != null)
      l1 = this.m.c(l1);
    if (locall.j != 0)
    {
      byte[] arrayOfByte = this.k.a;
      arrayOfByte[0] = 0;
      arrayOfByte[1] = 0;
      arrayOfByte[2] = 0;
      int i4 = 1 + locall.j;
      int i5 = 4 - locall.j;
      if (this.E < this.D)
      {
        if (this.F == 0)
        {
          paramh.b(arrayOfByte, i5, i4);
          this.k.c(0);
          this.F = (-1 + this.k.v());
          this.j.c(0);
          localq.a(this.j, 4);
          localq.a(this.k, 1);
          if ((this.J.length > 0) && (p.a(locall.f.sampleMimeType, arrayOfByte[4])));
          for (boolean bool = true; ; bool = false)
          {
            this.G = bool;
            this.E = (5 + this.E);
            this.D = (i5 + this.D);
            break;
          }
        }
        int i7;
        int i9;
        if (this.G)
        {
          this.l.a(this.F);
          paramh.b(this.l.a, 0, this.F);
          localq.a(this.l, this.F);
          i7 = this.F;
          int i8 = p.a(this.l.a, this.l.c());
          r localr = this.l;
          if ("video/hevc".equals(locall.f.sampleMimeType))
          {
            i9 = 1;
            label632: localr.c(i9);
            this.l.b(i8);
            com.google.android.exoplayer2.e.a.g.a(l1, this.l, this.J);
          }
        }
        for (int i6 = i7; ; i6 = localq.a(paramh, this.F, false))
        {
          this.E = (i6 + this.E);
          this.F -= i6;
          break;
          i9 = 0;
          break label632;
        }
      }
    }
    else
    {
      while (this.E < this.D)
        this.E = (localq.a(paramh, this.D - this.E, false) + this.E);
    }
    int i2;
    m localm;
    int i3;
    if (localn.l[i1] != 0)
    {
      i2 = 1;
      localm = b.b(this.C);
      if (localm == null)
        break label849;
      i3 = 0x40000000 | i2;
    }
    for (q.a locala = localm.c; ; locala = null)
    {
      localq.a(l1, i3, this.D, 0, locala);
      b(l1);
      if (!this.C.b())
        this.C = null;
      this.s = 3;
      return true;
      i2 = 0;
      break;
      label849: i3 = i2;
    }
  }

  public int a(h paramh, com.google.android.exoplayer2.extractor.n paramn)
    throws IOException, InterruptedException
  {
    while (true)
    {
      switch (this.s)
      {
      default:
        if (!e(paramh))
          continue;
        return 0;
      case 0:
        if (b(paramh))
          continue;
        return -1;
      case 1:
        c(paramh);
        break;
      case 2:
      }
      d(paramh);
    }
  }

  public void a(long paramLong1, long paramLong2)
  {
    int i1 = this.i.size();
    for (int i2 = 0; i2 < i1; i2++)
      ((b)this.i.valueAt(i2)).a();
    this.q.clear();
    this.y = 0;
    this.z = paramLong2;
    this.p.clear();
    b();
  }

  public void a(i parami)
  {
    this.H = parami;
    if (this.f != null)
    {
      b localb = new b(parami.a(0, this.f.b));
      localb.a(this.f, new c(0, 0, 0, 0));
      this.i.put(0, localb);
      d();
      this.H.a();
    }
  }

  public boolean a(h paramh)
    throws IOException, InterruptedException
  {
    return k.a(paramh);
  }

  public void c()
  {
  }

  private static final class a
  {
    public final long a;
    public final int b;

    public a(long paramLong, int paramInt)
    {
      this.a = paramLong;
      this.b = paramInt;
    }
  }

  private static final class b
  {
    public final q a;
    public final n b;
    public l c;
    public c d;
    public int e;
    public int f;
    public int g;
    public int h;
    private final r i;
    private final r j;

    public b(q paramq)
    {
      this.a = paramq;
      this.b = new n();
      this.i = new r(1);
      this.j = new r();
    }

    private void d()
    {
      m localm = e();
      if (localm == null);
      r localr;
      do
      {
        return;
        localr = this.b.q;
        if (localm.d != 0)
          localr.d(localm.d);
      }
      while (!this.b.c(this.e));
      localr.d(6 * localr.i());
    }

    private m e()
    {
      int k = this.b.a.a;
      if (this.b.o != null);
      for (m localm = this.b.o; (localm != null) && (localm.a); localm = this.c.a(k))
        return localm;
      return null;
    }

    public void a()
    {
      this.b.a();
      this.e = 0;
      this.g = 0;
      this.f = 0;
      this.h = 0;
    }

    public void a(long paramLong)
    {
      long l = com.google.android.exoplayer2.c.a(paramLong);
      for (int k = this.e; (k < this.b.f) && (this.b.b(k) < l); k++)
        if (this.b.l[k] != 0)
          this.h = k;
    }

    public void a(DrmInitData paramDrmInitData)
    {
      m localm = this.c.a(this.b.a.a);
      if (localm != null);
      for (String str = localm.b; ; str = null)
      {
        this.a.a(this.c.f.copyWithDrmInitData(paramDrmInitData.copyWithSchemeType(str)));
        return;
      }
    }

    public void a(l paraml, c paramc)
    {
      this.c = ((l)com.google.android.exoplayer2.g.a.a(paraml));
      this.d = ((c)com.google.android.exoplayer2.g.a.a(paramc));
      this.a.a(paraml.f);
      a();
    }

    public boolean b()
    {
      this.e = (1 + this.e);
      this.f = (1 + this.f);
      if (this.f == this.b.h[this.g])
      {
        this.g = (1 + this.g);
        this.f = 0;
        return false;
      }
      return true;
    }

    public int c()
    {
      m localm = e();
      if (localm == null)
        return 0;
      r localr1;
      int k;
      boolean bool;
      byte[] arrayOfByte2;
      if (localm.d != 0)
      {
        localr1 = this.b.q;
        k = localm.d;
        bool = this.b.c(this.e);
        arrayOfByte2 = this.i.a;
        if (!bool)
          break label145;
      }
      label145: for (int m = 128; ; m = 0)
      {
        arrayOfByte2[0] = ((byte)(m | k));
        this.i.c(0);
        this.a.a(this.i, 1);
        this.a.a(localr1, k);
        if (bool)
          break label151;
        return k + 1;
        byte[] arrayOfByte1 = localm.e;
        this.j.a(arrayOfByte1, arrayOfByte1.length);
        localr1 = this.j;
        k = arrayOfByte1.length;
        break;
      }
      label151: r localr2 = this.b.q;
      int n = localr2.i();
      localr2.d(-2);
      int i1 = 2 + n * 6;
      this.a.a(localr2, i1);
      return i1 + (k + 1);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.e
 * JD-Core Version:    0.6.2
 */