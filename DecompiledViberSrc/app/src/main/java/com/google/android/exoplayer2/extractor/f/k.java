package com.google.android.exoplayer2.extractor.f;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.g.p;
import com.google.android.exoplayer2.g.r;
import java.util.Arrays;
import java.util.Collections;

public final class k
  implements j
{
  private static final double[] c = { 23.976023976023978D, 24.0D, 25.0D, 29.970029970029969D, 30.0D, 50.0D, 59.940059940059939D, 60.0D };
  private String a;
  private com.google.android.exoplayer2.extractor.q b;
  private boolean d;
  private long e;
  private final ag f;
  private final r g;
  private final boolean[] h;
  private final a i;
  private final q j;
  private long k;
  private boolean l;
  private long m;
  private long n;
  private long o;
  private boolean p;
  private boolean q;

  public k()
  {
    this(null);
  }

  public k(ag paramag)
  {
    this.f = paramag;
    this.h = new boolean[4];
    this.i = new a(128);
    if (paramag != null)
    {
      this.j = new q(178, 128);
      this.g = new r();
      return;
    }
    this.j = null;
    this.g = null;
  }

  private static Pair<Format, Long> a(a parama, String paramString)
  {
    byte[] arrayOfByte = Arrays.copyOf(parama.c, parama.a);
    int i1 = 0xFF & arrayOfByte[4];
    int i2 = 0xFF & arrayOfByte[5];
    int i3 = 0xFF & arrayOfByte[6];
    int i4 = i1 << 4 | i2 >> 4;
    int i5 = i3 | (i2 & 0xF) << 8;
    float f1 = 1.0F;
    switch ((0xF0 & arrayOfByte[7]) >> 4)
    {
    default:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      Format localFormat = Format.createVideoSampleFormat(paramString, "video/mpeg2", null, -1, -1, i4, i5, -1.0F, Collections.singletonList(arrayOfByte), -1, f1, null);
      long l1 = 0L;
      int i6 = -1 + (0xF & arrayOfByte[7]);
      if ((i6 >= 0) && (i6 < c.length))
      {
        double d1 = c[i6];
        int i7 = parama.b;
        int i8 = (0x60 & arrayOfByte[(i7 + 9)]) >> 5;
        int i9 = 0x1F & arrayOfByte[(i7 + 9)];
        if (i8 != i9)
          d1 *= (1.0D + i8) / (i9 + 1);
        l1 = ()(1000000.0D / d1);
      }
      return Pair.create(localFormat, Long.valueOf(l1));
      f1 = i5 * 4 / (i4 * 3);
      continue;
      f1 = i5 * 16 / (i4 * 9);
      continue;
      f1 = i5 * 121 / (i4 * 100);
    }
  }

  public void a()
  {
    p.a(this.h);
    this.i.a();
    if (this.f != null)
      this.j.a();
    this.k = 0L;
    this.l = false;
  }

  public void a(long paramLong, int paramInt)
  {
    this.m = paramLong;
  }

  public void a(i parami, ae.d paramd)
  {
    paramd.a();
    this.a = paramd.c();
    this.b = parami.a(paramd.b(), 2);
    if (this.f != null)
      this.f.a(parami, paramd);
  }

  public void a(r paramr)
  {
    int i1 = paramr.d();
    int i2 = paramr.c();
    byte[] arrayOfByte = paramr.a;
    this.k += paramr.b();
    this.b.a(paramr, paramr.b());
    int i3 = i1;
    int i4 = p.a(arrayOfByte, i3, i2, this.h);
    if (i4 == i2)
    {
      if (!this.d)
        this.i.a(arrayOfByte, i3, i2);
      if (this.f != null)
        this.j.a(arrayOfByte, i3, i2);
      return;
    }
    int i5 = 0xFF & paramr.a[(i4 + 3)];
    int i6 = i4 - i3;
    int i12;
    if (!this.d)
    {
      if (i6 > 0)
        this.i.a(arrayOfByte, i3, i4);
      if (i6 >= 0)
        break label521;
      i12 = -i6;
      label163: if (this.i.a(i5, i12))
      {
        Pair localPair = a(this.i, this.a);
        this.b.a((Format)localPair.first);
        this.e = ((Long)localPair.second).longValue();
        this.d = true;
      }
    }
    int i10;
    if (this.f != null)
    {
      i10 = 0;
      if (i6 <= 0)
        break label527;
      this.j.a(arrayOfByte, i3, i4);
      label255: if (this.j.b(i10))
      {
        int i11 = p.a(this.j.a, this.j.b);
        this.g.a(this.j.a, i11);
        this.f.a(this.o, this.g);
      }
      if ((i5 == 178) && (paramr.a[(i4 + 2)] == 1))
        this.j.a(i5);
    }
    int i8;
    label397: long l1;
    label475: boolean bool;
    if ((i5 == 0) || (i5 == 179))
    {
      int i7 = i2 - i4;
      if ((this.l) && (this.q) && (this.d))
      {
        if (this.p)
        {
          i8 = 1;
          int i9 = (int)(this.k - this.n) - i7;
          this.b.a(this.o, i8, i9, i7, null);
        }
      }
      else
      {
        if ((!this.l) || (this.q))
        {
          this.n = (this.k - i7);
          if (this.m == -9223372036854775807L)
            break label541;
          l1 = this.m;
          this.o = l1;
          this.p = false;
          this.m = -9223372036854775807L;
          this.l = true;
        }
        if (i5 != 0)
          break label568;
        bool = true;
        label506: this.q = bool;
      }
    }
    while (true)
    {
      i3 = i4 + 3;
      break;
      label521: i12 = 0;
      break label163;
      label527: i10 = -i6;
      break label255;
      i8 = 0;
      break label397;
      label541: if (this.l)
      {
        l1 = this.o + this.e;
        break label475;
      }
      l1 = 0L;
      break label475;
      label568: bool = false;
      break label506;
      if (i5 == 184)
        this.p = true;
    }
  }

  public void b()
  {
  }

  private static final class a
  {
    private static final byte[] d = { 0, 0, 1 };
    public int a;
    public int b;
    public byte[] c;
    private boolean e;

    public a(int paramInt)
    {
      this.c = new byte[paramInt];
    }

    public void a()
    {
      this.e = false;
      this.a = 0;
      this.b = 0;
    }

    public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (!this.e)
        return;
      int i = paramInt2 - paramInt1;
      if (this.c.length < i + this.a)
        this.c = Arrays.copyOf(this.c, 2 * (i + this.a));
      System.arraycopy(paramArrayOfByte, paramInt1, this.c, this.a, i);
      this.a = (i + this.a);
    }

    public boolean a(int paramInt1, int paramInt2)
    {
      if (this.e)
      {
        this.a -= paramInt2;
        if ((this.b == 0) && (paramInt1 == 181))
          this.b = this.a;
      }
      while (true)
      {
        a(d, 0, d.length);
        return false;
        this.e = false;
        return true;
        if (paramInt1 == 179)
          this.e = true;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.f.k
 * JD-Core Version:    0.6.2
 */