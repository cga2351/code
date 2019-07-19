package com.google.android.exoplayer2.extractor.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.c;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.extractor.n;
import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.extractor.o.b;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.w;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

public final class a
  implements g
{
  public static final j a = b.a;
  private static final int[] b = { 13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1 };
  private static final int[] c = { 18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1 };
  private static final byte[] d = ag.c("#!AMR\n");
  private static final byte[] e = ag.c("#!AMR-WB\n");
  private static final int f = c[8];
  private final byte[] g;
  private final int h;
  private boolean i;
  private long j;
  private int k;
  private int l;
  private boolean m;
  private long n;
  private int o;
  private int p;
  private long q;
  private i r;
  private q s;
  private o t;
  private boolean u;

  public a()
  {
    this(0);
  }

  public a(int paramInt)
  {
    this.h = paramInt;
    this.g = new byte[1];
    this.o = -1;
  }

  private int a(int paramInt)
    throws w
  {
    if (!b(paramInt))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Illegal AMR ");
      if (this.i);
      for (String str = "WB"; ; str = "NB")
        throw new w(str + " frame type " + paramInt);
    }
    if (this.i)
      return c[paramInt];
    return b[paramInt];
  }

  private static int a(int paramInt, long paramLong)
  {
    return (int)(1000000L * (paramInt * 8) / paramLong);
  }

  private o a(long paramLong)
  {
    int i1 = a(this.o, 20000L);
    return new c(paramLong, this.n, i1, this.o);
  }

  private void a(long paramLong, int paramInt)
  {
    if (this.m);
    do
    {
      return;
      if (((0x1 & this.h) == 0) || (paramLong == -1L) || ((this.o != -1) && (this.o != this.k)))
      {
        this.t = new o.b(-9223372036854775807L);
        this.r.a(this.t);
        this.m = true;
        return;
      }
    }
    while ((this.p < 20) && (paramInt != -1));
    this.t = a(paramLong);
    this.r.a(this.t);
    this.m = true;
  }

  private boolean a(h paramh, byte[] paramArrayOfByte)
    throws IOException, InterruptedException
  {
    paramh.a();
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    paramh.c(arrayOfByte, 0, paramArrayOfByte.length);
    return Arrays.equals(arrayOfByte, paramArrayOfByte);
  }

  private void b()
  {
    String str;
    if (!this.u)
    {
      this.u = true;
      if (!this.i)
        break label60;
      str = "audio/amr-wb";
      if (!this.i)
        break label66;
    }
    label60: label66: for (int i1 = 16000; ; i1 = 8000)
    {
      this.s.a(Format.createAudioSampleFormat(null, str, null, -1, f, 1, i1, -1, null, null, 0, null));
      return;
      str = "audio/3gpp";
      break;
    }
  }

  private boolean b(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 15) && ((c(paramInt)) || (d(paramInt)));
  }

  private boolean b(h paramh)
    throws IOException, InterruptedException
  {
    if (a(paramh, d))
    {
      this.i = false;
      paramh.b(d.length);
      return true;
    }
    if (a(paramh, e))
    {
      this.i = true;
      paramh.b(e.length);
      return true;
    }
    return false;
  }

  private int c(h paramh)
    throws IOException, InterruptedException
  {
    if (this.l == 0);
    int i2;
    do
    {
      int i1;
      try
      {
        this.k = d(paramh);
        this.l = this.k;
        if (this.o == -1)
        {
          this.n = paramh.c();
          this.o = this.k;
        }
        if (this.o == this.k)
          this.p = (1 + this.p);
        i1 = this.s.a(paramh, this.l, true);
        if (i1 == -1)
        {
          i3 = -1;
          return i3;
        }
      }
      catch (EOFException localEOFException)
      {
        return -1;
      }
      this.l -= i1;
      i2 = this.l;
      int i3 = 0;
    }
    while (i2 > 0);
    this.s.a(this.q + this.j, 1, this.k, 0, null);
    this.j = (20000L + this.j);
    return 0;
  }

  private boolean c(int paramInt)
  {
    return (this.i) && ((paramInt < 10) || (paramInt > 13));
  }

  private int d(h paramh)
    throws IOException, InterruptedException
  {
    paramh.a();
    paramh.c(this.g, 0, 1);
    int i1 = this.g[0];
    if ((i1 & 0x83) > 0)
      throw new w("Invalid padding bits for frame header " + i1);
    return a(0xF & i1 >> 3);
  }

  private boolean d(int paramInt)
  {
    return (!this.i) && ((paramInt < 12) || (paramInt > 14));
  }

  public int a(h paramh, n paramn)
    throws IOException, InterruptedException
  {
    if ((paramh.c() == 0L) && (!b(paramh)))
      throw new w("Could not find AMR header.");
    b();
    int i1 = c(paramh);
    a(paramh.d(), i1);
    return i1;
  }

  public void a(long paramLong1, long paramLong2)
  {
    this.j = 0L;
    this.k = 0;
    this.l = 0;
    if ((paramLong1 != 0L) && ((this.t instanceof c)))
    {
      this.q = ((c)this.t).b(paramLong1);
      return;
    }
    this.q = 0L;
  }

  public void a(i parami)
  {
    this.r = parami;
    this.s = parami.a(0, 1);
    parami.a();
  }

  public boolean a(h paramh)
    throws IOException, InterruptedException
  {
    return b(paramh);
  }

  public void c()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.a.a
 * JD-Core Version:    0.6.2
 */