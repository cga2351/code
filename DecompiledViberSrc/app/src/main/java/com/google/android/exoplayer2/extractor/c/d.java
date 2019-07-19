package com.google.android.exoplayer2.extractor.c;

import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.extractor.n;
import com.google.android.exoplayer2.extractor.o.b;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.extractor.q.a;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.m;
import com.google.android.exoplayer2.g.p;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.android.exoplayer2.w;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public final class d
  implements com.google.android.exoplayer2.extractor.g
{
  public static final j a = e.a;
  private static final byte[] b = { 49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10 };
  private static final byte[] c = { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
  private static final byte[] d = ag.c("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
  private static final byte[] e = { 68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44 };
  private static final byte[] f = { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
  private static final UUID g = new UUID(72057594037932032L, -9223371306706625679L);
  private b A;
  private boolean B;
  private int C;
  private long D;
  private boolean E;
  private long F = -1L;
  private long G = -1L;
  private long H = -9223372036854775807L;
  private m I;
  private m J;
  private boolean K;
  private int L;
  private long M;
  private long N;
  private int O;
  private int P;
  private int[] Q;
  private int R;
  private int S;
  private int T;
  private int U;
  private boolean V;
  private boolean W;
  private boolean X;
  private boolean Y;
  private byte Z;
  private int aa;
  private int ab;
  private int ac;
  private boolean ad;
  private boolean ae;
  private i af;
  private final b h;
  private final g i;
  private final SparseArray<b> j;
  private final boolean k;
  private final r l;
  private final r m;
  private final r n;
  private final r o;
  private final r p;
  private final r q;
  private final r r;
  private final r s;
  private final r t;
  private ByteBuffer u;
  private long v;
  private long w = -1L;
  private long x = -9223372036854775807L;
  private long y = -9223372036854775807L;
  private long z = -9223372036854775807L;

  public d()
  {
    this(0);
  }

  public d(int paramInt)
  {
    this(new a(), paramInt);
  }

  d(b paramb, int paramInt)
  {
    this.h = paramb;
    this.h.a(new a(null));
    if ((paramInt & 0x1) == 0);
    for (boolean bool = true; ; bool = false)
    {
      this.k = bool;
      this.i = new g();
      this.j = new SparseArray();
      this.n = new r(4);
      this.o = new r(ByteBuffer.allocate(4).putInt(-1).array());
      this.p = new r(4);
      this.l = new r(p.a);
      this.m = new r(4);
      this.q = new r();
      this.r = new r();
      this.s = new r(8);
      this.t = new r();
      return;
    }
  }

  private int a(h paramh, q paramq, int paramInt)
    throws IOException, InterruptedException
  {
    int i1 = this.q.b();
    int i2;
    if (i1 > 0)
    {
      i2 = Math.min(paramInt, i1);
      paramq.a(this.q, i2);
    }
    while (true)
    {
      this.U = (i2 + this.U);
      this.ac = (i2 + this.ac);
      return i2;
      i2 = paramq.a(paramh, paramInt, false);
    }
  }

  private long a(long paramLong)
    throws w
  {
    if (this.x == -9223372036854775807L)
      throw new w("Can't scale timecode prior to timecodeScale being set.");
    return ag.d(paramLong, this.x, 1000L);
  }

  private void a(b paramb, long paramLong)
  {
    if (paramb.Q != null)
    {
      paramb.Q.a(paramb, paramLong);
      this.ad = true;
      e();
      return;
    }
    if ("S_TEXT/UTF8".equals(paramb.b))
      a(paramb, "%02d:%02d:%02d,%03d", 19, 1000L, c);
    while (true)
    {
      paramb.T.a(paramLong, this.T, this.ac, 0, paramb.h);
      break;
      if ("S_TEXT/ASS".equals(paramb.b))
        a(paramb, "%01d:%02d:%02d:%02d", 21, 10000L, f);
    }
  }

  private void a(b paramb, String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    a(this.r.a, this.N, paramString, paramInt, paramLong, paramArrayOfByte);
    paramb.T.a(this.r, this.r.c());
    this.ac += this.r.c();
  }

  private void a(h paramh, int paramInt)
    throws IOException, InterruptedException
  {
    if (this.n.c() >= paramInt)
      return;
    if (this.n.e() < paramInt)
      this.n.a(Arrays.copyOf(this.n.a, Math.max(2 * this.n.a.length, paramInt)), this.n.c());
    paramh.b(this.n.a, this.n.c(), paramInt - this.n.c());
    this.n.b(paramInt);
  }

  private void a(h paramh, b paramb, int paramInt)
    throws IOException, InterruptedException
  {
    int i1 = 1;
    if ("S_TEXT/UTF8".equals(paramb.b))
      a(paramh, b, paramInt);
    q localq;
    label197: label582: label588: label604: 
    do
    {
      return;
      if ("S_TEXT/ASS".equals(paramb.b))
      {
        a(paramh, e, paramInt);
        return;
      }
      localq = paramb.T;
      int i14;
      int i3;
      byte[] arrayOfByte1;
      int i4;
      int i5;
      if (!this.V)
      {
        if (!paramb.f)
          break label860;
        this.T = (0xBFFFFFFF & this.T);
        if (!this.W)
        {
          paramh.b(this.n.a, 0, i1);
          this.U = (1 + this.U);
          if ((0x80 & this.n.a[0]) == 128)
            throw new w("Extension bit is set in signal byte");
          this.Z = this.n.a[0];
          this.W = i1;
        }
        int i16;
        int i11;
        int i12;
        int i13;
        int i15;
        if ((0x1 & this.Z) == i1)
        {
          int i6 = i1;
          if (i6 == 0)
            break label676;
          if ((0x2 & this.Z) != 2)
            break label576;
          int i8 = i1;
          this.T = (0x40000000 | this.T);
          if (!this.X)
          {
            paramh.b(this.s.a, 0, 8);
            this.U = (8 + this.U);
            this.X = i1;
            byte[] arrayOfByte2 = this.n.a;
            if (i8 == 0)
              break label582;
            i16 = 128;
            arrayOfByte2[0] = ((byte)(i16 | 0x8));
            this.n.c(0);
            localq.a(this.n, i1);
            this.ac = (1 + this.ac);
            this.s.c(0);
            localq.a(this.s, 8);
            this.ac = (8 + this.ac);
          }
          if (i8 == 0)
            break label676;
          if (!this.Y)
          {
            paramh.b(this.n.a, 0, i1);
            this.U = (1 + this.U);
            this.n.c(0);
            this.aa = this.n.h();
            this.Y = i1;
          }
          int i10 = 4 * this.aa;
          this.n.a(i10);
          paramh.b(this.n.a, 0, i10);
          this.U = (i10 + this.U);
          short s1 = (short)(1 + this.aa / 2);
          i11 = 2 + s1 * 6;
          if ((this.u == null) || (this.u.capacity() < i11))
            this.u = ByteBuffer.allocate(i11);
          this.u.position(0);
          this.u.putShort(s1);
          i12 = 0;
          i13 = 0;
          if (i12 >= this.aa)
            break label604;
          i15 = this.n.v();
          if (i12 % 2 != 0)
            break label588;
          this.u.putShort((short)(i15 - i13));
        }
        while (true)
        {
          i12++;
          i13 = i15;
          break label521;
          int i7 = 0;
          break;
          int i9 = 0;
          break label197;
          i16 = 0;
          break label268;
          this.u.putInt(i15 - i13);
        }
        i14 = paramInt - this.U - i13;
        if (this.aa % 2 == i1)
        {
          this.u.putInt(i14);
          this.t.a(this.u.array(), i11);
          localq.a(this.t, i11);
          this.ac = (i11 + this.ac);
          this.V = i1;
        }
      }
      else
      {
        i3 = paramInt + this.q.c();
        if ((!"V_MPEG4/ISO/AVC".equals(paramb.b)) && (!"V_MPEGH/ISO/HEVC".equals(paramb.b)))
          break label909;
        arrayOfByte1 = this.m.a;
        arrayOfByte1[0] = 0;
        arrayOfByte1[i1] = 0;
        arrayOfByte1[2] = 0;
        i4 = paramb.U;
        i5 = 4 - paramb.U;
      }
      while (true)
        if (this.U < i3)
        {
          if (this.ab == 0)
          {
            a(paramh, arrayOfByte1, i5, i4);
            this.m.c(0);
            this.ab = this.m.v();
            this.l.c(0);
            localq.a(this.l, 4);
            this.ac = (4 + this.ac);
            continue;
            this.u.putShort((short)i14);
            this.u.putInt(0);
            break;
            if (paramb.g == null)
              break label676;
            this.q.a(paramb.g, paramb.g.length);
            break label676;
          }
          this.ab -= a(paramh, localq, this.ab);
          continue;
          if (paramb.Q != null)
            if (this.q.c() != 0)
              break label972;
          while (true)
          {
            com.google.android.exoplayer2.g.a.b(i1);
            paramb.Q.a(paramh, this.T, i3);
            while (this.U < i3)
              a(paramh, localq, i3 - this.U);
            int i2 = 0;
          }
        }
    }
    while (!"A_VORBIS".equals(paramb.b));
    label268: label576: label860: this.o.c(0);
    label521: label676: label972: localq.a(this.o, 4);
    label909: this.ac = (4 + this.ac);
  }

  private void a(h paramh, byte[] paramArrayOfByte, int paramInt)
    throws IOException, InterruptedException
  {
    int i1 = paramInt + paramArrayOfByte.length;
    if (this.r.e() < i1)
      this.r.a = Arrays.copyOf(paramArrayOfByte, i1 + paramInt);
    while (true)
    {
      paramh.b(this.r.a, paramArrayOfByte.length, paramInt);
      this.r.a(i1);
      return;
      System.arraycopy(paramArrayOfByte, 0, this.r.a, 0, paramArrayOfByte.length);
    }
  }

  private void a(h paramh, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, InterruptedException
  {
    int i1 = Math.min(paramInt2, this.q.b());
    paramh.b(paramArrayOfByte, paramInt1 + i1, paramInt2 - i1);
    if (i1 > 0)
      this.q.a(paramArrayOfByte, paramInt1, i1);
    this.U = (paramInt2 + this.U);
  }

  private static void a(byte[] paramArrayOfByte1, long paramLong1, String paramString, int paramInt, long paramLong2, byte[] paramArrayOfByte2)
  {
    if (paramLong1 == -9223372036854775807L);
    Locale localLocale;
    Object[] arrayOfObject;
    for (byte[] arrayOfByte = paramArrayOfByte2; ; arrayOfByte = ag.c(String.format(localLocale, paramString, arrayOfObject)))
    {
      System.arraycopy(arrayOfByte, 0, paramArrayOfByte1, paramInt, paramArrayOfByte2.length);
      return;
      int i1 = (int)(paramLong1 / 3600000000L);
      long l1 = paramLong1 - 1000000L * (i1 * 3600);
      int i2 = (int)(l1 / 60000000L);
      long l2 = l1 - 1000000L * (i2 * 60);
      int i3 = (int)(l2 / 1000000L);
      int i4 = (int)((l2 - 1000000L * i3) / paramLong2);
      localLocale = Locale.US;
      arrayOfObject = new Object[4];
      arrayOfObject[0] = Integer.valueOf(i1);
      arrayOfObject[1] = Integer.valueOf(i2);
      arrayOfObject[2] = Integer.valueOf(i3);
      arrayOfObject[3] = Integer.valueOf(i4);
    }
  }

  private boolean a(n paramn, long paramLong)
  {
    if (this.E)
    {
      this.G = paramLong;
      paramn.a = this.F;
      this.E = false;
      return true;
    }
    if ((this.B) && (this.G != -1L))
    {
      paramn.a = this.G;
      this.G = -1L;
      return true;
    }
    return false;
  }

  private static boolean a(String paramString)
  {
    return ("V_VP8".equals(paramString)) || ("V_VP9".equals(paramString)) || ("V_MPEG2".equals(paramString)) || ("V_MPEG4/ISO/SP".equals(paramString)) || ("V_MPEG4/ISO/ASP".equals(paramString)) || ("V_MPEG4/ISO/AP".equals(paramString)) || ("V_MPEG4/ISO/AVC".equals(paramString)) || ("V_MPEGH/ISO/HEVC".equals(paramString)) || ("V_MS/VFW/FOURCC".equals(paramString)) || ("V_THEORA".equals(paramString)) || ("A_OPUS".equals(paramString)) || ("A_VORBIS".equals(paramString)) || ("A_AAC".equals(paramString)) || ("A_MPEG/L2".equals(paramString)) || ("A_MPEG/L3".equals(paramString)) || ("A_AC3".equals(paramString)) || ("A_EAC3".equals(paramString)) || ("A_TRUEHD".equals(paramString)) || ("A_DTS".equals(paramString)) || ("A_DTS/EXPRESS".equals(paramString)) || ("A_DTS/LOSSLESS".equals(paramString)) || ("A_FLAC".equals(paramString)) || ("A_MS/ACM".equals(paramString)) || ("A_PCM/INT/LIT".equals(paramString)) || ("S_TEXT/UTF8".equals(paramString)) || ("S_TEXT/ASS".equals(paramString)) || ("S_VOBSUB".equals(paramString)) || ("S_HDMV/PGS".equals(paramString)) || ("S_DVBSUB".equals(paramString));
  }

  private static int[] a(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null)
      paramArrayOfInt = new int[paramInt];
    while (paramArrayOfInt.length >= paramInt)
      return paramArrayOfInt;
    return new int[Math.max(2 * paramArrayOfInt.length, paramInt)];
  }

  private void e()
  {
    this.U = 0;
    this.ac = 0;
    this.ab = 0;
    this.V = false;
    this.W = false;
    this.Y = false;
    this.aa = 0;
    this.Z = 0;
    this.X = false;
    this.q.a();
  }

  private com.google.android.exoplayer2.extractor.o f()
  {
    if ((this.w == -1L) || (this.z == -9223372036854775807L) || (this.I == null) || (this.I.a() == 0) || (this.J == null) || (this.J.a() != this.I.a()))
    {
      this.I = null;
      this.J = null;
      return new o.b(this.z);
    }
    int i1 = this.I.a();
    int[] arrayOfInt = new int[i1];
    long[] arrayOfLong1 = new long[i1];
    long[] arrayOfLong2 = new long[i1];
    long[] arrayOfLong3 = new long[i1];
    int i3;
    for (int i2 = 0; ; i2++)
    {
      i3 = 0;
      if (i2 >= i1)
        break;
      arrayOfLong3[i2] = this.I.a(i2);
      arrayOfLong1[i2] = (this.w + this.J.a(i2));
    }
    while (i3 < i1 - 1)
    {
      arrayOfInt[i3] = ((int)(arrayOfLong1[(i3 + 1)] - arrayOfLong1[i3]));
      arrayOfLong2[i3] = (arrayOfLong3[(i3 + 1)] - arrayOfLong3[i3]);
      i3++;
    }
    arrayOfInt[(i1 - 1)] = ((int)(this.w + this.v - arrayOfLong1[(i1 - 1)]));
    arrayOfLong2[(i1 - 1)] = (this.z - arrayOfLong3[(i1 - 1)]);
    this.I = null;
    this.J = null;
    return new com.google.android.exoplayer2.extractor.b(arrayOfInt, arrayOfLong1, arrayOfLong2, arrayOfLong3);
  }

  public int a(h paramh, n paramn)
    throws IOException, InterruptedException
  {
    this.ad = false;
    boolean bool = true;
    int i1;
    while ((bool) && (!this.ad))
    {
      bool = this.h.a(paramh);
      if ((bool) && (a(paramn, paramh.c())))
        i1 = 1;
    }
    do
    {
      return i1;
      i1 = 0;
    }
    while (bool);
    for (int i2 = 0; i2 < this.j.size(); i2++)
      ((b)this.j.valueAt(i2)).a();
    return -1;
  }

  void a(int paramInt)
    throws w
  {
    switch (paramInt)
    {
    default:
    case 357149030:
    case 19899:
    case 475249515:
    case 160:
    case 25152:
    case 28032:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (this.x == -9223372036854775807L)
                    this.x = 1000000L;
                }
                while (this.y == -9223372036854775807L);
                this.z = a(this.y);
                return;
                if ((this.C == -1) || (this.D == -1L))
                  throw new w("Mandatory element SeekID or SeekPosition not found");
              }
              while (this.C != 475249515);
              this.F = this.D;
              return;
            }
            while (this.B);
            this.af.a(f());
            this.B = true;
            return;
          }
          while (this.L != 2);
          if (!this.ae)
            this.T = (0x1 | this.T);
          a((b)this.j.get(this.R), this.M);
          this.L = 0;
          return;
        }
        while (!this.A.f);
        if (this.A.h == null)
          throw new w("Encrypted Track found but ContentEncKeyID was not found");
        b localb = this.A;
        DrmInitData.SchemeData[] arrayOfSchemeData = new DrmInitData.SchemeData[1];
        arrayOfSchemeData[0] = new DrmInitData.SchemeData(com.google.android.exoplayer2.c.a, "video/webm", this.A.h.b);
        localb.j = new DrmInitData(arrayOfSchemeData);
        return;
      }
      while ((!this.A.f) || (this.A.g == null));
      throw new w("Combining encryption and compression is not supported");
    case 174:
      if (a(this.A.b))
      {
        this.A.a(this.af, this.A.c);
        this.j.put(this.A.c, this.A);
      }
      this.A = null;
      return;
    case 374648427:
    }
    if (this.j.size() == 0)
      throw new w("No valid tracks were found");
    this.af.a();
  }

  void a(int paramInt, double paramDouble)
  {
    switch (paramInt)
    {
    default:
      return;
    case 17545:
      this.y = (()paramDouble);
      return;
    case 181:
      this.A.N = ((int)paramDouble);
      return;
    case 21969:
      this.A.B = ((float)paramDouble);
      return;
    case 21970:
      this.A.C = ((float)paramDouble);
      return;
    case 21971:
      this.A.D = ((float)paramDouble);
      return;
    case 21972:
      this.A.E = ((float)paramDouble);
      return;
    case 21973:
      this.A.F = ((float)paramDouble);
      return;
    case 21974:
      this.A.G = ((float)paramDouble);
      return;
    case 21975:
      this.A.H = ((float)paramDouble);
      return;
    case 21976:
      this.A.I = ((float)paramDouble);
      return;
    case 21977:
      this.A.J = ((float)paramDouble);
      return;
    case 21978:
      this.A.K = ((float)paramDouble);
      return;
    case 30323:
      this.A.q = ((float)paramDouble);
      return;
    case 30324:
      this.A.r = ((float)paramDouble);
      return;
    case 30325:
    }
    this.A.s = ((float)paramDouble);
  }

  void a(int paramInt1, int paramInt2, h paramh)
    throws IOException, InterruptedException
  {
    switch (paramInt1)
    {
    default:
      throw new w("Unexpected id: " + paramInt1);
    case 21419:
      Arrays.fill(this.p.a, (byte)0);
      paramh.b(this.p.a, 4 - paramInt2, paramInt2);
      this.p.c(0);
      this.C = ((int)this.p.n());
      return;
    case 25506:
      this.A.i = new byte[paramInt2];
      paramh.b(this.A.i, 0, paramInt2);
      return;
    case 30322:
      this.A.t = new byte[paramInt2];
      paramh.b(this.A.t, 0, paramInt2);
      return;
    case 16981:
      this.A.g = new byte[paramInt2];
      paramh.b(this.A.g, 0, paramInt2);
      return;
    case 18402:
      byte[] arrayOfByte3 = new byte[paramInt2];
      paramh.b(arrayOfByte3, 0, paramInt2);
      this.A.h = new q.a(1, arrayOfByte3, 0, 0);
      return;
    case 161:
    case 163:
    }
    if (this.L == 0)
    {
      this.R = ((int)this.i.a(paramh, false, true, 8));
      this.S = this.i.b();
      this.N = -9223372036854775807L;
      this.L = 1;
      this.n.a();
    }
    b localb = (b)this.j.get(this.R);
    if (localb == null)
    {
      paramh.b(paramInt2 - this.S);
      this.L = 0;
      return;
    }
    int i1;
    int i6;
    label482: int i7;
    label520: int i8;
    if (this.L == 1)
    {
      a(paramh, 3);
      i1 = (0x6 & this.n.a[2]) >> 1;
      if (i1 != 0)
        break label630;
      this.P = 1;
      this.Q = a(this.Q, 1);
      this.Q[0] = (-3 + (paramInt2 - this.S));
      int i5 = this.n.a[0] << 8 | 0xFF & this.n.a[1];
      this.M = (this.H + a(i5));
      if ((0x8 & this.n.a[2]) != 8)
        break label1247;
      i6 = 1;
      if ((localb.d != 2) && ((paramInt1 != 163) || ((0x80 & this.n.a[2]) != 128)))
        break label1253;
      i7 = 1;
      if (i7 == 0)
        break label1259;
      i8 = 1;
      label528: if (i6 == 0)
        break label1265;
    }
    label1247: label1253: label1259: label1265: for (int i9 = -2147483648; ; i9 = 0)
    {
      this.T = (i9 | i8);
      this.L = 2;
      this.O = 0;
      if (paramInt1 != 163)
        break label1277;
      while (this.O < this.P)
      {
        a(paramh, localb, this.Q[this.O]);
        a(localb, this.M + this.O * localb.e / 1000);
        this.O = (1 + this.O);
      }
      label630: if (paramInt1 != 163)
        throw new w("Lacing only supported in SimpleBlocks.");
      a(paramh, 4);
      this.P = (1 + (0xFF & this.n.a[3]));
      this.Q = a(this.Q, this.P);
      if (i1 == 2)
      {
        int i21 = (-4 + (paramInt2 - this.S)) / this.P;
        Arrays.fill(this.Q, 0, this.P, i21);
        break;
      }
      if (i1 == 1)
      {
        int i17 = 0;
        int i18 = 4;
        for (int i19 = 0; i19 < -1 + this.P; i19++)
        {
          this.Q[i19] = 0;
          int i20;
          do
          {
            i18++;
            a(paramh, i18);
            i20 = 0xFF & this.n.a[(i18 - 1)];
            int[] arrayOfInt2 = this.Q;
            arrayOfInt2[i19] = (i20 + arrayOfInt2[i19]);
          }
          while (i20 == 255);
          i17 += this.Q[i19];
        }
        this.Q[(-1 + this.P)] = (paramInt2 - this.S - i18 - i17);
        break;
      }
      if (i1 == 3)
      {
        int i2 = 0;
        int i3 = 4;
        int i4 = 0;
        if (i4 < -1 + this.P)
        {
          this.Q[i4] = 0;
          i3++;
          a(paramh, i3);
          if (this.n.a[(i3 - 1)] == 0)
            throw new w("No valid varint length mask found");
          long l1 = 0L;
          for (int i10 = 0; ; i10++)
          {
            if (i10 < 8)
            {
              int i12 = 1 << 7 - i10;
              if ((i12 & this.n.a[(i3 - 1)]) == 0)
                continue;
              int i13 = i3 - 1;
              i3 += i10;
              a(paramh, i3);
              byte[] arrayOfByte1 = this.n.a;
              int i14 = i13 + 1;
              l1 = 0xFF & arrayOfByte1[i13] & (i12 ^ 0xFFFFFFFF);
              int i16;
              for (int i15 = i14; i15 < i3; i15 = i16)
              {
                long l2 = l1 << 8;
                byte[] arrayOfByte2 = this.n.a;
                i16 = i15 + 1;
                l1 = l2 | 0xFF & arrayOfByte2[i15];
              }
              if (i4 > 0)
                l1 -= (1L << 6 + i10 * 7) - 1L;
            }
            if ((l1 >= -2147483648L) && (l1 <= 2147483647L))
              break;
            throw new w("EBML lacing sample size out of range.");
          }
          int i11 = (int)l1;
          int[] arrayOfInt1 = this.Q;
          if (i4 == 0);
          while (true)
          {
            arrayOfInt1[i4] = i11;
            i2 += this.Q[i4];
            i4++;
            break;
            i11 += this.Q[(i4 - 1)];
          }
        }
        this.Q[(-1 + this.P)] = (paramInt2 - this.S - i3 - i2);
        break;
      }
      throw new w("Unexpected lacing value: " + i1);
      i6 = 0;
      break label482;
      i7 = 0;
      break label520;
      i8 = 0;
      break label528;
    }
    this.L = 0;
    return;
    label1277: a(paramh, localb, this.Q[0]);
  }

  void a(int paramInt, long paramLong)
    throws w
  {
    int i1 = 1;
    switch (paramInt)
    {
    default:
    case 17143:
    case 17029:
    case 21420:
    case 2807729:
    case 176:
    case 186:
    case 21680:
    case 21690:
    case 21682:
    case 215:
    case 136:
    case 21930:
    case 131:
    case 2352003:
    case 22186:
    case 22203:
    case 159:
    case 25188:
    case 251:
    case 20529:
    case 20530:
    case 16980:
    case 18401:
    case 18408:
    case 179:
    case 241:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                      return;
                    while (paramLong == 1L);
                    throw new w("EBMLReadVersion " + paramLong + " not supported");
                  }
                  while ((paramLong >= 1L) && (paramLong <= 2L));
                  throw new w("DocTypeReadVersion " + paramLong + " not supported");
                  this.D = (paramLong + this.w);
                  return;
                  this.x = paramLong;
                  return;
                  this.A.k = ((int)paramLong);
                  return;
                  this.A.l = ((int)paramLong);
                  return;
                  this.A.m = ((int)paramLong);
                  return;
                  this.A.n = ((int)paramLong);
                  return;
                  this.A.o = ((int)paramLong);
                  return;
                  this.A.c = ((int)paramLong);
                  return;
                  b localb2 = this.A;
                  if (paramLong == 1L);
                  while (true)
                  {
                    localb2.S = i1;
                    return;
                    i1 = 0;
                  }
                  b localb1 = this.A;
                  if (paramLong == 1L);
                  while (true)
                  {
                    localb1.R = i1;
                    return;
                    i1 = 0;
                  }
                  this.A.d = ((int)paramLong);
                  return;
                  this.A.e = ((int)paramLong);
                  return;
                  this.A.O = paramLong;
                  return;
                  this.A.P = paramLong;
                  return;
                  this.A.L = ((int)paramLong);
                  return;
                  this.A.M = ((int)paramLong);
                  return;
                  this.ae = i1;
                  return;
                }
                while (paramLong == 0L);
                throw new w("ContentEncodingOrder " + paramLong + " not supported");
              }
              while (paramLong == 1L);
              throw new w("ContentEncodingScope " + paramLong + " not supported");
            }
            while (paramLong == 3L);
            throw new w("ContentCompAlgo " + paramLong + " not supported");
          }
          while (paramLong == 5L);
          throw new w("ContentEncAlgo " + paramLong + " not supported");
        }
        while (paramLong == 1L);
        throw new w("AESSettingsCipherMode " + paramLong + " not supported");
        this.I.a(a(paramLong));
        return;
      }
      while (this.K);
      this.J.a(paramLong);
      this.K = i1;
      return;
    case 231:
      this.H = a(paramLong);
      return;
    case 155:
      this.N = a(paramLong);
      return;
    case 21432:
      switch ((int)paramLong)
      {
      default:
        return;
      case 0:
        this.A.u = 0;
        return;
      case 1:
        this.A.u = 2;
        return;
      case 3:
        this.A.u = i1;
        return;
      case 15:
      }
      this.A.u = 3;
      return;
    case 21947:
      this.A.v = i1;
      switch ((int)paramLong)
      {
      case 2:
      case 3:
      case 8:
      default:
        return;
      case 1:
        this.A.w = i1;
        return;
      case 4:
      case 5:
      case 6:
      case 7:
        this.A.w = 2;
        return;
      case 9:
      }
      this.A.w = 6;
      return;
    case 21946:
      switch ((int)paramLong)
      {
      default:
        return;
      case 1:
      case 6:
      case 7:
        this.A.x = 3;
        return;
      case 16:
        this.A.x = 6;
        return;
      case 18:
      }
      this.A.x = 7;
      return;
    case 21945:
      switch ((int)paramLong)
      {
      default:
        return;
      case 1:
        this.A.y = 2;
        return;
      case 2:
      }
      this.A.y = i1;
      return;
    case 21948:
      this.A.z = ((int)paramLong);
      return;
    case 21949:
      this.A.A = ((int)paramLong);
      return;
    case 30321:
    }
    switch ((int)paramLong)
    {
    default:
      return;
    case 0:
      this.A.p = 0;
      return;
    case 1:
      this.A.p = i1;
      return;
    case 2:
      this.A.p = 2;
      return;
    case 3:
    }
    this.A.p = 3;
  }

  void a(int paramInt, long paramLong1, long paramLong2)
    throws w
  {
    switch (paramInt)
    {
    case 25152:
    default:
    case 408125543:
    case 19899:
    case 475249515:
    case 187:
    case 524531317:
      do
      {
        return;
        if ((this.w != -1L) && (this.w != paramLong1))
          throw new w("Multiple Segment elements not supported");
        this.w = paramLong1;
        this.v = paramLong2;
        return;
        this.C = -1;
        this.D = -1L;
        return;
        this.I = new m();
        this.J = new m();
        return;
        this.K = false;
        return;
      }
      while (this.B);
      if ((this.k) && (this.F != -1L))
      {
        this.E = true;
        return;
      }
      this.af.a(new o.b(this.z));
      this.B = true;
      return;
    case 160:
      this.ae = false;
      return;
    case 20533:
      this.A.f = true;
      return;
    case 174:
      this.A = new b(null);
      return;
    case 21968:
    }
    this.A.v = true;
  }

  void a(int paramInt, String paramString)
    throws w
  {
    switch (paramInt)
    {
    default:
    case 17026:
      do
        return;
      while (("webm".equals(paramString)) || ("matroska".equals(paramString)));
      throw new w("DocType " + paramString + " not supported");
    case 21358:
      this.A.a = paramString;
      return;
    case 134:
      this.A.b = paramString;
      return;
    case 2274716:
    }
    b.a(this.A, paramString);
  }

  public void a(long paramLong1, long paramLong2)
  {
    this.H = -9223372036854775807L;
    this.L = 0;
    this.h.a();
    this.i.a();
    e();
    for (int i1 = 0; i1 < this.j.size(); i1++)
      ((b)this.j.valueAt(i1)).b();
  }

  public void a(i parami)
  {
    this.af = parami;
  }

  public boolean a(h paramh)
    throws IOException, InterruptedException
  {
    return new f().a(paramh);
  }

  public void c()
  {
  }

  private final class a
    implements c
  {
    private a()
    {
    }

    public int a(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return 0;
      case 160:
      case 174:
      case 183:
      case 187:
      case 224:
      case 225:
      case 18407:
      case 19899:
      case 20532:
      case 20533:
      case 21936:
      case 21968:
      case 25152:
      case 28032:
      case 30320:
      case 290298740:
      case 357149030:
      case 374648427:
      case 408125543:
      case 440786851:
      case 475249515:
      case 524531317:
        return 1;
      case 131:
      case 136:
      case 155:
      case 159:
      case 176:
      case 179:
      case 186:
      case 215:
      case 231:
      case 241:
      case 251:
      case 16980:
      case 17029:
      case 17143:
      case 18401:
      case 18408:
      case 20529:
      case 20530:
      case 21420:
      case 21432:
      case 21680:
      case 21682:
      case 21690:
      case 21930:
      case 21945:
      case 21946:
      case 21947:
      case 21948:
      case 21949:
      case 22186:
      case 22203:
      case 25188:
      case 30321:
      case 2352003:
      case 2807729:
        return 2;
      case 134:
      case 17026:
      case 21358:
      case 2274716:
        return 3;
      case 161:
      case 163:
      case 16981:
      case 18402:
      case 21419:
      case 25506:
      case 30322:
        return 4;
      case 181:
      case 17545:
      case 21969:
      case 21970:
      case 21971:
      case 21972:
      case 21973:
      case 21974:
      case 21975:
      case 21976:
      case 21977:
      case 21978:
      case 30323:
      case 30324:
      case 30325:
      }
      return 5;
    }

    public void a(int paramInt, double paramDouble)
      throws w
    {
      d.this.a(paramInt, paramDouble);
    }

    public void a(int paramInt1, int paramInt2, h paramh)
      throws IOException, InterruptedException
    {
      d.this.a(paramInt1, paramInt2, paramh);
    }

    public void a(int paramInt, long paramLong)
      throws w
    {
      d.this.a(paramInt, paramLong);
    }

    public void a(int paramInt, long paramLong1, long paramLong2)
      throws w
    {
      d.this.a(paramInt, paramLong1, paramLong2);
    }

    public void a(int paramInt, String paramString)
      throws w
    {
      d.this.a(paramInt, paramString);
    }

    public boolean b(int paramInt)
    {
      return (paramInt == 357149030) || (paramInt == 524531317) || (paramInt == 475249515) || (paramInt == 374648427);
    }

    public void c(int paramInt)
      throws w
    {
      d.this.a(paramInt);
    }
  }

  private static final class b
  {
    public int A = 200;
    public float B = -1.0F;
    public float C = -1.0F;
    public float D = -1.0F;
    public float E = -1.0F;
    public float F = -1.0F;
    public float G = -1.0F;
    public float H = -1.0F;
    public float I = -1.0F;
    public float J = -1.0F;
    public float K = -1.0F;
    public int L = 1;
    public int M = -1;
    public int N = 8000;
    public long O = 0L;
    public long P = 0L;
    public d.c Q;
    public boolean R;
    public boolean S = true;
    public q T;
    public int U;
    private String V = "eng";
    public String a;
    public String b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public byte[] g;
    public q.a h;
    public byte[] i;
    public DrmInitData j;
    public int k = -1;
    public int l = -1;
    public int m = -1;
    public int n = -1;
    public int o = 0;
    public int p = -1;
    public float q = 0.0F;
    public float r = 0.0F;
    public float s = 0.0F;
    public byte[] t = null;
    public int u = -1;
    public boolean v = false;
    public int w = -1;
    public int x = -1;
    public int y = -1;
    public int z = 1000;

    private static Pair<String, List<byte[]>> a(r paramr)
      throws w
    {
      while (true)
      {
        int i1;
        try
        {
          paramr.d(16);
          long l1 = paramr.o();
          if (l1 == 1482049860L)
            return new Pair("video/3gpp", null);
          if (l1 != 826496599L)
            break label159;
          i1 = 20 + paramr.d();
          byte[] arrayOfByte = paramr.a;
          if (i1 >= -4 + arrayOfByte.length)
            break;
          if ((arrayOfByte[i1] == 0) && (arrayOfByte[(i1 + 1)] == 0) && (arrayOfByte[(i1 + 2)] == 1) && (arrayOfByte[(i1 + 3)] == 15))
          {
            Pair localPair = new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(arrayOfByte, i1, arrayOfByte.length)));
            return localPair;
          }
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          throw new w("Error parsing FourCC private data");
        }
        i1++;
      }
      throw new w("Failed to find FourCC VC1 initialization data");
      label159: l.c("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
      return new Pair("video/x-unknown", null);
    }

    private static List<byte[]> a(byte[] paramArrayOfByte)
      throws w
    {
      int i1 = 0;
      try
      {
        if (paramArrayOfByte[0] != 2)
          throw new w("Error parsing vorbis codec private");
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        throw new w("Error parsing vorbis codec private");
      }
      int i2 = 0;
      int i3 = 1;
      while (paramArrayOfByte[i3] == -1)
      {
        int i4 = i2 + 255;
        i3++;
        i2 = i4;
      }
      int i5 = i3 + 1;
      int i6 = i2 + paramArrayOfByte[i3];
      while (paramArrayOfByte[i5] == -1)
      {
        i1 += 255;
        i5++;
      }
      int i7 = i5 + 1;
      int i8 = i1 + paramArrayOfByte[i5];
      if (paramArrayOfByte[i7] != 1)
        throw new w("Error parsing vorbis codec private");
      byte[] arrayOfByte1 = new byte[i6];
      System.arraycopy(paramArrayOfByte, i7, arrayOfByte1, 0, i6);
      int i9 = i6 + i7;
      if (paramArrayOfByte[i9] != 3)
        throw new w("Error parsing vorbis codec private");
      int i10 = i8 + i9;
      if (paramArrayOfByte[i10] != 5)
        throw new w("Error parsing vorbis codec private");
      byte[] arrayOfByte2 = new byte[paramArrayOfByte.length - i10];
      System.arraycopy(paramArrayOfByte, i10, arrayOfByte2, 0, paramArrayOfByte.length - i10);
      ArrayList localArrayList = new ArrayList(2);
      localArrayList.add(arrayOfByte1);
      localArrayList.add(arrayOfByte2);
      return localArrayList;
    }

    private static boolean b(r paramr)
      throws w
    {
      try
      {
        int i1 = paramr.j();
        if (i1 == 1)
          return true;
        if (i1 == 65534)
        {
          paramr.c(24);
          if (paramr.r() == d.d().getMostSignificantBits())
          {
            long l1 = paramr.r();
            long l2 = d.d().getLeastSignificantBits();
            if (l1 == l2);
          }
          else
          {
            return false;
          }
        }
        else
        {
          return false;
        }
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        throw new w("Error parsing MS/ACM codec private");
      }
      return true;
    }

    private byte[] c()
    {
      if ((this.B == -1.0F) || (this.C == -1.0F) || (this.D == -1.0F) || (this.E == -1.0F) || (this.F == -1.0F) || (this.G == -1.0F) || (this.H == -1.0F) || (this.I == -1.0F) || (this.J == -1.0F) || (this.K == -1.0F))
        return null;
      byte[] arrayOfByte = new byte[25];
      ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte);
      localByteBuffer.put((byte)0);
      localByteBuffer.putShort((short)(int)(0.5F + 50000.0F * this.B));
      localByteBuffer.putShort((short)(int)(0.5F + 50000.0F * this.C));
      localByteBuffer.putShort((short)(int)(0.5F + 50000.0F * this.D));
      localByteBuffer.putShort((short)(int)(0.5F + 50000.0F * this.E));
      localByteBuffer.putShort((short)(int)(0.5F + 50000.0F * this.F));
      localByteBuffer.putShort((short)(int)(0.5F + 50000.0F * this.G));
      localByteBuffer.putShort((short)(int)(0.5F + 50000.0F * this.H));
      localByteBuffer.putShort((short)(int)(0.5F + 50000.0F * this.I));
      localByteBuffer.putShort((short)(int)(0.5F + this.J));
      localByteBuffer.putShort((short)(int)(0.5F + this.K));
      localByteBuffer.putShort((short)this.z);
      localByteBuffer.putShort((short)this.A);
      return arrayOfByte;
    }

    public void a()
    {
      if (this.Q != null)
        this.Q.a(this);
    }

    public void a(i parami, int paramInt)
      throws w
    {
      int i1 = -1;
      int i2 = -1;
      Object localObject1 = null;
      String str1 = this.b;
      int i3 = -1;
      switch (str1.hashCode())
      {
      default:
      case 82338133:
      case 82338134:
      case 1809237540:
      case -2095575984:
      case -538363189:
      case -2095576542:
      case -538363109:
      case 855502857:
      case -1373388978:
      case 444813526:
      case -1730367663:
      case 1951062397:
      case 62923557:
      case -1482641358:
      case -1482641357:
      case 62923603:
      case 1950749482:
      case -1784763192:
      case 62927045:
      case 542569478:
      case -356037306:
      case 1950789798:
      case -1985379776:
      case 725957860:
      case 1422270023:
      case 738597099:
      case -425012669:
      case 99146302:
      case -933872740:
      }
      while (true)
        switch (i3)
        {
        default:
          throw new w("Unrecognized codec identifier.");
          if (str1.equals("V_VP8"))
          {
            i3 = 0;
            continue;
            if (str1.equals("V_VP9"))
            {
              i3 = 1;
              continue;
              if (str1.equals("V_MPEG2"))
              {
                i3 = 2;
                continue;
                if (str1.equals("V_MPEG4/ISO/SP"))
                {
                  i3 = 3;
                  continue;
                  if (str1.equals("V_MPEG4/ISO/ASP"))
                  {
                    i3 = 4;
                    continue;
                    if (str1.equals("V_MPEG4/ISO/AP"))
                    {
                      i3 = 5;
                      continue;
                      if (str1.equals("V_MPEG4/ISO/AVC"))
                      {
                        i3 = 6;
                        continue;
                        if (str1.equals("V_MPEGH/ISO/HEVC"))
                        {
                          i3 = 7;
                          continue;
                          if (str1.equals("V_MS/VFW/FOURCC"))
                          {
                            i3 = 8;
                            continue;
                            if (str1.equals("V_THEORA"))
                            {
                              i3 = 9;
                              continue;
                              if (str1.equals("A_VORBIS"))
                              {
                                i3 = 10;
                                continue;
                                if (str1.equals("A_OPUS"))
                                {
                                  i3 = 11;
                                  continue;
                                  if (str1.equals("A_AAC"))
                                  {
                                    i3 = 12;
                                    continue;
                                    if (str1.equals("A_MPEG/L2"))
                                    {
                                      i3 = 13;
                                      continue;
                                      if (str1.equals("A_MPEG/L3"))
                                      {
                                        i3 = 14;
                                        continue;
                                        if (str1.equals("A_AC3"))
                                        {
                                          i3 = 15;
                                          continue;
                                          if (str1.equals("A_EAC3"))
                                          {
                                            i3 = 16;
                                            continue;
                                            if (str1.equals("A_TRUEHD"))
                                            {
                                              i3 = 17;
                                              continue;
                                              if (str1.equals("A_DTS"))
                                              {
                                                i3 = 18;
                                                continue;
                                                if (str1.equals("A_DTS/EXPRESS"))
                                                {
                                                  i3 = 19;
                                                  continue;
                                                  if (str1.equals("A_DTS/LOSSLESS"))
                                                  {
                                                    i3 = 20;
                                                    continue;
                                                    if (str1.equals("A_FLAC"))
                                                    {
                                                      i3 = 21;
                                                      continue;
                                                      if (str1.equals("A_MS/ACM"))
                                                      {
                                                        i3 = 22;
                                                        continue;
                                                        if (str1.equals("A_PCM/INT/LIT"))
                                                        {
                                                          i3 = 23;
                                                          continue;
                                                          if (str1.equals("S_TEXT/UTF8"))
                                                          {
                                                            i3 = 24;
                                                            continue;
                                                            if (str1.equals("S_TEXT/ASS"))
                                                            {
                                                              i3 = 25;
                                                              continue;
                                                              if (str1.equals("S_VOBSUB"))
                                                              {
                                                                i3 = 26;
                                                                continue;
                                                                if (str1.equals("S_HDMV/PGS"))
                                                                {
                                                                  i3 = 27;
                                                                  continue;
                                                                  if (str1.equals("S_DVBSUB"))
                                                                    i3 = 28;
                                                                }
                                                              }
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          break;
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
        case 12:
        case 13:
        case 14:
        case 15:
        case 16:
        case 17:
        case 18:
        case 19:
        case 20:
        case 21:
        case 22:
        case 23:
        case 24:
        case 25:
        case 26:
        case 27:
        case 28:
        }
      Object localObject2 = "video/x-vnd.on2.vp8";
      int i4;
      label938: int i5;
      if (this.S)
      {
        i4 = 1;
        i5 = 0x0 | i4;
        if (!this.R)
          break label1788;
      }
      int i7;
      Format localFormat;
      int i8;
      label1788: for (int i6 = 2; ; i6 = 0)
      {
        i7 = i5 | i6;
        if (!com.google.android.exoplayer2.g.o.a((String)localObject2))
          break label1794;
        localFormat = Format.createAudioSampleFormat(Integer.toString(paramInt), (String)localObject2, null, -1, i1, this.L, this.N, i2, (List)localObject1, this.j, i7, this.V);
        i8 = 1;
        this.T = parami.a(this.c, i8);
        this.T.a(localFormat);
        return;
        localObject2 = "video/x-vnd.on2.vp9";
        localObject1 = null;
        break;
        localObject2 = "video/mpeg2";
        localObject1 = null;
        break;
        localObject2 = "video/mp4v-es";
        if (this.i == null);
        for (List localList = null; ; localList = Collections.singletonList(this.i))
        {
          localObject1 = localList;
          break;
        }
        localObject2 = "video/avc";
        com.google.android.exoplayer2.video.a locala = com.google.android.exoplayer2.video.a.a(new r(this.i));
        localObject1 = locala.a;
        this.U = locala.b;
        break;
        localObject2 = "video/hevc";
        com.google.android.exoplayer2.video.b localb = com.google.android.exoplayer2.video.b.a(new r(this.i));
        localObject1 = localb.a;
        this.U = localb.b;
        break;
        Pair localPair = a(new r(this.i));
        String str6 = (String)localPair.first;
        localObject1 = (List)localPair.second;
        localObject2 = str6;
        break;
        localObject2 = "video/x-unknown";
        localObject1 = null;
        break;
        localObject2 = "audio/vorbis";
        i1 = 8192;
        localObject1 = a(this.i);
        break;
        localObject2 = "audio/opus";
        i1 = 5760;
        localObject1 = new ArrayList(3);
        ((List)localObject1).add(this.i);
        ((List)localObject1).add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.O).array());
        ((List)localObject1).add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.P).array());
        break;
        localObject2 = "audio/mp4a-latm";
        localObject1 = Collections.singletonList(this.i);
        break;
        localObject2 = "audio/mpeg-L2";
        i1 = 4096;
        localObject1 = null;
        break;
        localObject2 = "audio/mpeg";
        i1 = 4096;
        localObject1 = null;
        break;
        localObject2 = "audio/ac3";
        localObject1 = null;
        break;
        localObject2 = "audio/eac3";
        localObject1 = null;
        break;
        localObject2 = "audio/true-hd";
        this.Q = new d.c();
        localObject1 = null;
        break;
        localObject2 = "audio/vnd.dts";
        localObject1 = null;
        break;
        localObject2 = "audio/vnd.dts.hd";
        localObject1 = null;
        break;
        localObject2 = "audio/flac";
        localObject1 = Collections.singletonList(this.i);
        break;
        localObject2 = "audio/raw";
        if (b(new r(this.i)))
        {
          i2 = ag.b(this.M);
          localObject1 = null;
          if (i2 != 0)
            break;
          i2 = -1;
          localObject2 = "audio/x-unknown";
          l.c("MatroskaExtractor", "Unsupported PCM bit depth: " + this.M + ". Setting mimeType to " + (String)localObject2);
          localObject1 = null;
          break;
        }
        localObject2 = "audio/x-unknown";
        l.c("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to " + (String)localObject2);
        localObject1 = null;
        break;
        localObject2 = "audio/raw";
        i2 = ag.b(this.M);
        localObject1 = null;
        if (i2 != 0)
          break;
        i2 = -1;
        localObject2 = "audio/x-unknown";
        l.c("MatroskaExtractor", "Unsupported PCM bit depth: " + this.M + ". Setting mimeType to " + (String)localObject2);
        localObject1 = null;
        break;
        localObject2 = "application/x-subrip";
        localObject1 = null;
        break;
        localObject2 = "text/x-ssa";
        localObject1 = null;
        break;
        localObject2 = "application/vobsub";
        localObject1 = Collections.singletonList(this.i);
        break;
        localObject2 = "application/pgs";
        localObject1 = null;
        break;
        localObject2 = "application/dvbsubs";
        byte[] arrayOfByte1 = new byte[4];
        arrayOfByte1[0] = this.i[0];
        arrayOfByte1[1] = this.i[1];
        arrayOfByte1[2] = this.i[2];
        arrayOfByte1[3] = this.i[3];
        localObject1 = Collections.singletonList(arrayOfByte1);
        break;
        i4 = 0;
        break label938;
      }
      label1794: int i11;
      label1823: int i12;
      label1843: float f1;
      ColorInfo localColorInfo;
      int i9;
      label1954: int i10;
      if (com.google.android.exoplayer2.g.o.b((String)localObject2))
        if (this.o == 0)
        {
          if (this.m == -1)
          {
            i11 = this.k;
            this.m = i11;
            if (this.n != -1)
              break label2056;
            i12 = this.l;
            this.n = i12;
          }
        }
        else
        {
          f1 = -1.0F;
          if ((this.m != -1) && (this.n != -1))
            f1 = this.l * this.m / (this.k * this.n);
          boolean bool = this.v;
          localColorInfo = null;
          if (bool)
          {
            byte[] arrayOfByte2 = c();
            localColorInfo = new ColorInfo(this.w, this.y, this.x, arrayOfByte2);
          }
          i9 = -1;
          if (!"htc_video_rotA-000".equals(this.a))
            break label2065;
          i9 = 0;
          if ((this.p != 0) || (Float.compare(this.q, 0.0F) != 0) || (Float.compare(this.r, 0.0F) != 0))
            break label2418;
          if (Float.compare(this.s, 0.0F) != 0)
            break label2127;
          i10 = 0;
        }
      while (true)
      {
        localFormat = Format.createVideoSampleFormat(Integer.toString(paramInt), (String)localObject2, null, -1, i1, this.k, this.l, -1.0F, (List)localObject1, i10, f1, this.t, this.u, localColorInfo, this.j);
        i8 = 2;
        break;
        i11 = this.m;
        break label1823;
        label2056: i12 = this.n;
        break label1843;
        label2065: if ("htc_video_rotA-090".equals(this.a))
        {
          i9 = 90;
          break label1954;
        }
        if ("htc_video_rotA-180".equals(this.a))
        {
          i9 = 180;
          break label1954;
        }
        if (!"htc_video_rotA-270".equals(this.a))
          break label1954;
        i9 = 270;
        break label1954;
        label2127: if (Float.compare(this.r, 90.0F) == 0)
        {
          i10 = 90;
        }
        else if ((Float.compare(this.r, -180.0F) == 0) || (Float.compare(this.r, 180.0F) == 0))
        {
          i10 = 180;
        }
        else
        {
          if (Float.compare(this.r, -90.0F) == 0)
          {
            i10 = 270;
            continue;
            if ("application/x-subrip".equals(localObject2))
            {
              localFormat = Format.createTextSampleFormat(Integer.toString(paramInt), (String)localObject2, i7, this.V, this.j);
              i8 = 3;
              break;
            }
            if ("text/x-ssa".equals(localObject2))
            {
              ArrayList localArrayList = new ArrayList(2);
              localArrayList.add(d.b());
              localArrayList.add(this.i);
              String str2 = Integer.toString(paramInt);
              String str3 = this.V;
              DrmInitData localDrmInitData1 = this.j;
              localFormat = Format.createTextSampleFormat(str2, (String)localObject2, null, -1, i7, str3, -1, localDrmInitData1, 9223372036854775807L, localArrayList);
              i8 = 3;
              break;
            }
            if (("application/vobsub".equals(localObject2)) || ("application/pgs".equals(localObject2)) || ("application/dvbsubs".equals(localObject2)))
            {
              String str4 = Integer.toString(paramInt);
              String str5 = this.V;
              DrmInitData localDrmInitData2 = this.j;
              localFormat = Format.createImageSampleFormat(str4, (String)localObject2, null, -1, i7, (List)localObject1, str5, localDrmInitData2);
              i8 = 3;
              break;
            }
            throw new w("Unexpected MIME type.");
          }
          label2418: i10 = i9;
        }
      }
    }

    public void b()
    {
      if (this.Q != null)
        this.Q.a();
    }
  }

  private static final class c
  {
    private final byte[] a = new byte[10];
    private boolean b;
    private int c;
    private int d;
    private long e;
    private int f;

    public void a()
    {
      this.b = false;
    }

    public void a(d.b paramb)
    {
      if ((this.b) && (this.c > 0))
      {
        paramb.T.a(this.e, this.f, this.d, 0, paramb.h);
        this.c = 0;
      }
    }

    public void a(d.b paramb, long paramLong)
    {
      if (!this.b);
      do
      {
        return;
        int i = this.c;
        this.c = (i + 1);
        if (i == 0)
          this.e = paramLong;
      }
      while (this.c < 16);
      paramb.T.a(this.e, this.f, this.d, 0, paramb.h);
      this.c = 0;
    }

    public void a(h paramh, int paramInt1, int paramInt2)
      throws IOException, InterruptedException
    {
      if (!this.b)
      {
        paramh.c(this.a, 0, 10);
        paramh.a();
        if (com.google.android.exoplayer2.b.a.b(this.a) == 0)
          return;
        this.b = true;
        this.c = 0;
      }
      if (this.c == 0)
      {
        this.f = paramInt1;
        this.d = 0;
      }
      this.d = (paramInt2 + this.d);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.c.d
 * JD-Core Version:    0.6.2
 */