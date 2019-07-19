package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.extractor.q.a;
import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.p;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;

public class y
  implements q
{
  private final com.google.android.exoplayer2.f.b a;
  private final int b;
  private final x c;
  private final x.a d;
  private final r e;
  private a f;
  private a g;
  private a h;
  private Format i;
  private boolean j;
  private Format k;
  private long l;
  private long m;
  private boolean n;
  private b o;

  public y(com.google.android.exoplayer2.f.b paramb)
  {
    this.a = paramb;
    this.b = paramb.c();
    this.c = new x();
    this.d = new x.a();
    this.e = new r(32);
    this.f = new a(0L, this.b);
    this.g = this.f;
    this.h = this.f;
  }

  private static Format a(Format paramFormat, long paramLong)
  {
    if (paramFormat == null)
      paramFormat = null;
    while ((paramLong == 0L) || (paramFormat.subsampleOffsetUs == 9223372036854775807L))
      return paramFormat;
    return paramFormat.copyWithSubsampleOffsetUs(paramLong + paramFormat.subsampleOffsetUs);
  }

  private void a(long paramLong, ByteBuffer paramByteBuffer, int paramInt)
  {
    b(paramLong);
    while (paramInt > 0)
    {
      int i1 = Math.min(paramInt, (int)(this.g.b - paramLong));
      paramByteBuffer.put(this.g.d.a, this.g.a(paramLong), i1);
      paramInt -= i1;
      paramLong += i1;
      if (paramLong == this.g.b)
        this.g = this.g.e;
    }
  }

  private void a(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    b(paramLong);
    int i1 = paramInt;
    while (i1 > 0)
    {
      int i2 = Math.min(i1, (int)(this.g.b - paramLong));
      System.arraycopy(this.g.d.a, this.g.a(paramLong), paramArrayOfByte, paramInt - i1, i2);
      i1 -= i2;
      paramLong += i2;
      if (paramLong == this.g.b)
        this.g = this.g.e;
    }
  }

  private void a(e parame, x.a parama)
  {
    int i1 = 1;
    int i2 = 0;
    long l1 = parama.b;
    this.e.a(i1);
    a(l1, this.e.a, i1);
    long l2 = l1 + 1L;
    int i3 = this.e.a[0];
    int i4;
    long l3;
    long l7;
    if ((i3 & 0x80) != 0)
    {
      i4 = i1;
      int i5 = i3 & 0x7F;
      if (parame.a.a == null)
        parame.a.a = new byte[16];
      a(l2, parame.a.a, i5);
      l3 = l2 + i5;
      if (i4 == 0)
        break label305;
      this.e.a(2);
      a(l3, this.e.a, 2);
      l7 = l3 + 2L;
      i1 = this.e.i();
    }
    int[] arrayOfInt1;
    int[] arrayOfInt2;
    long l6;
    label305: for (long l4 = l7; ; l4 = l3)
    {
      arrayOfInt1 = parame.a.d;
      if ((arrayOfInt1 == null) || (arrayOfInt1.length < i1))
        arrayOfInt1 = new int[i1];
      arrayOfInt2 = parame.a.e;
      if ((arrayOfInt2 == null) || (arrayOfInt2.length < i1))
        arrayOfInt2 = new int[i1];
      if (i4 == 0)
        break label395;
      int i7 = i1 * 6;
      this.e.a(i7);
      a(l4, this.e.a, i7);
      l6 = l4 + i7;
      this.e.c(0);
      while (i2 < i1)
      {
        arrayOfInt1[i2] = this.e.i();
        arrayOfInt2[i2] = this.e.v();
        i2++;
      }
      i4 = 0;
      break;
    }
    for (long l5 = l6; ; l5 = l4)
    {
      q.a locala = parama.c;
      parame.a.a(i1, arrayOfInt1, arrayOfInt2, locala.b, parame.a.a, locala.a, locala.c, locala.d);
      int i6 = (int)(l5 - parama.b);
      parama.b += i6;
      parama.a -= i6;
      return;
      label395: arrayOfInt1[0] = 0;
      arrayOfInt2[0] = (parama.a - (int)(l4 - parama.b));
    }
  }

  private void a(a parama)
  {
    int i1 = 0;
    if (!parama.c)
      return;
    if (this.h.c);
    a[] arrayOfa;
    for (int i2 = 1; ; i2 = 0)
    {
      arrayOfa = new a[i2 + (int)(this.h.a - parama.a) / this.b];
      while (i1 < arrayOfa.length)
      {
        arrayOfa[i1] = parama.d;
        parama = parama.a();
        i1++;
      }
    }
    this.a.a(arrayOfa);
  }

  private int b(int paramInt)
  {
    if (!this.h.c)
      this.h.a(this.a.a(), new a(this.h.b, this.b));
    return Math.min(paramInt, (int)(this.h.b - this.m));
  }

  private void b(long paramLong)
  {
    while (paramLong >= this.g.b)
      this.g = this.g.e;
  }

  private void c(int paramInt)
  {
    this.m += paramInt;
    if (this.m == this.h.b)
      this.h = this.h.e;
  }

  private void c(long paramLong)
  {
    if (paramLong == -1L);
    do
    {
      return;
      while (paramLong >= this.f.b)
      {
        this.a.a(this.f.d);
        this.f = this.f.a();
      }
    }
    while (this.g.a >= this.f.a);
    this.g = this.f;
  }

  public int a(h paramh, int paramInt, boolean paramBoolean)
    throws IOException, InterruptedException
  {
    int i1 = b(paramInt);
    int i2 = paramh.a(this.h.d.a, this.h.a(this.m), i1);
    if (i2 == -1)
    {
      if (paramBoolean)
        return -1;
      throw new EOFException();
    }
    c(i2);
    return i2;
  }

  public int a(p paramp, e parame, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    switch (this.c.a(paramp, parame, paramBoolean1, paramBoolean2, this.i, this.d))
    {
    default:
      throw new IllegalStateException();
    case -5:
      this.i = paramp.a;
      return -5;
    case -4:
      if (!parame.c())
      {
        if (parame.c < paramLong)
          parame.b(-2147483648);
        if (parame.g())
          a(parame, this.d);
        parame.e(this.d.a);
        a(this.d.b, parame.b, this.d.a);
      }
      return -4;
    case -3:
    }
    return -3;
  }

  public void a()
  {
    a(false);
  }

  public void a(int paramInt)
  {
    this.c.b(paramInt);
  }

  public void a(long paramLong)
  {
    if (this.l != paramLong)
    {
      this.l = paramLong;
      this.j = true;
    }
  }

  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, q.a parama)
  {
    if (this.j)
      a(this.k);
    long l1 = paramLong + this.l;
    if (this.n)
    {
      if (((paramInt1 & 0x1) == 0) || (!this.c.a(l1)))
        return;
      this.n = false;
    }
    long l2 = this.m - paramInt2 - paramInt3;
    this.c.a(l1, paramInt1, l2, paramInt2, parama);
  }

  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    c(this.c.b(paramLong, paramBoolean1, paramBoolean2));
  }

  public void a(Format paramFormat)
  {
    Format localFormat = a(paramFormat, this.l);
    boolean bool = this.c.a(localFormat);
    this.k = paramFormat;
    this.j = false;
    if ((this.o != null) && (bool))
      this.o.a(localFormat);
  }

  public void a(r paramr, int paramInt)
  {
    while (paramInt > 0)
    {
      int i1 = b(paramInt);
      paramr.a(this.h.d.a, this.h.a(this.m), i1);
      paramInt -= i1;
      c(i1);
    }
  }

  public void a(b paramb)
  {
    this.o = paramb;
  }

  public void a(boolean paramBoolean)
  {
    this.c.a(paramBoolean);
    a(this.f);
    this.f = new a(0L, this.b);
    this.g = this.f;
    this.h = this.f;
    this.m = 0L;
    this.a.b();
  }

  public int b(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.c.a(paramLong, paramBoolean1, paramBoolean2);
  }

  public void b()
  {
    this.n = true;
  }

  public int c()
  {
    return this.c.a();
  }

  public boolean d()
  {
    return this.c.d();
  }

  public int e()
  {
    return this.c.b();
  }

  public int f()
  {
    return this.c.c();
  }

  public Format g()
  {
    return this.c.e();
  }

  public long h()
  {
    return this.c.f();
  }

  public boolean i()
  {
    return this.c.g();
  }

  public void j()
  {
    this.c.h();
    this.g = this.f;
  }

  public void k()
  {
    c(this.c.j());
  }

  public int l()
  {
    return this.c.i();
  }

  private static final class a
  {
    public final long a;
    public final long b;
    public boolean c;
    public a d;
    public a e;

    public a(long paramLong, int paramInt)
    {
      this.a = paramLong;
      this.b = (paramLong + paramInt);
    }

    public int a(long paramLong)
    {
      return (int)(paramLong - this.a) + this.d.b;
    }

    public a a()
    {
      this.d = null;
      a locala = this.e;
      this.e = null;
      return locala;
    }

    public void a(a parama, a parama1)
    {
      this.d = parama;
      this.e = parama1;
      this.c = true;
    }
  }

  public static abstract interface b
  {
    public abstract void a(Format paramFormat);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.y
 * JD-Core Version:    0.6.2
 */