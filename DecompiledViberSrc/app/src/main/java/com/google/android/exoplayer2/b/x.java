package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.g.ag;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class x
  implements f
{
  private int b = -1;
  private int c = -1;
  private int d;
  private boolean e;
  private ByteBuffer f = a;
  private ByteBuffer g = a;
  private boolean h;
  private byte[] i = ag.f;
  private byte[] j = ag.f;
  private int k;
  private int l;
  private int m;
  private boolean n;
  private long o;

  private int a(long paramLong)
  {
    return (int)(paramLong * this.c / 1000000L);
  }

  private void a(int paramInt)
  {
    if (this.f.capacity() < paramInt)
      this.f = ByteBuffer.allocateDirect(paramInt).order(ByteOrder.nativeOrder());
    while (true)
    {
      if (paramInt > 0)
        this.n = true;
      return;
      this.f.clear();
    }
  }

  private void a(ByteBuffer paramByteBuffer, byte[] paramArrayOfByte, int paramInt)
  {
    int i1 = Math.min(paramByteBuffer.remaining(), this.m);
    int i2 = this.m - i1;
    System.arraycopy(paramArrayOfByte, paramInt - i2, this.j, 0, i2);
    paramByteBuffer.position(paramByteBuffer.limit() - i1);
    paramByteBuffer.get(this.j, i2, i1);
  }

  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    a(paramInt);
    this.f.put(paramArrayOfByte, 0, paramInt);
    this.f.flip();
    this.g = this.f;
  }

  private void b(ByteBuffer paramByteBuffer)
  {
    int i1 = paramByteBuffer.limit();
    paramByteBuffer.limit(Math.min(i1, paramByteBuffer.position() + this.i.length));
    int i2 = g(paramByteBuffer);
    if (i2 == paramByteBuffer.position())
      this.k = 1;
    while (true)
    {
      paramByteBuffer.limit(i1);
      return;
      paramByteBuffer.limit(i2);
      e(paramByteBuffer);
    }
  }

  private void c(ByteBuffer paramByteBuffer)
  {
    int i1 = paramByteBuffer.limit();
    int i2 = f(paramByteBuffer);
    int i3 = i2 - paramByteBuffer.position();
    int i4 = this.i.length - this.l;
    if ((i2 < i1) && (i3 < i4))
    {
      a(this.i, this.l);
      this.l = 0;
      this.k = 0;
      return;
    }
    int i5 = Math.min(i3, i4);
    paramByteBuffer.limit(i5 + paramByteBuffer.position());
    paramByteBuffer.get(this.i, this.l, i5);
    this.l = (i5 + this.l);
    if (this.l == this.i.length)
    {
      if (!this.n)
        break label200;
      a(this.i, this.m);
    }
    label200: for (this.o += (this.l - 2 * this.m) / this.d; ; this.o += (this.l - this.m) / this.d)
    {
      a(paramByteBuffer, this.i, this.l);
      this.l = 0;
      this.k = 2;
      paramByteBuffer.limit(i1);
      return;
    }
  }

  private void d(ByteBuffer paramByteBuffer)
  {
    int i1 = paramByteBuffer.limit();
    int i2 = f(paramByteBuffer);
    paramByteBuffer.limit(i2);
    this.o += paramByteBuffer.remaining() / this.d;
    a(paramByteBuffer, this.j, this.m);
    if (i2 < i1)
    {
      a(this.j, this.m);
      this.k = 0;
      paramByteBuffer.limit(i1);
    }
  }

  private void e(ByteBuffer paramByteBuffer)
  {
    a(paramByteBuffer.remaining());
    this.f.put(paramByteBuffer);
    this.f.flip();
    this.g = this.f;
  }

  private int f(ByteBuffer paramByteBuffer)
  {
    for (int i1 = 1 + paramByteBuffer.position(); i1 < paramByteBuffer.limit(); i1 += 2)
      if (Math.abs(paramByteBuffer.get(i1)) > 4)
        return this.d * (i1 / this.d);
    return paramByteBuffer.limit();
  }

  private int g(ByteBuffer paramByteBuffer)
  {
    for (int i1 = -1 + paramByteBuffer.limit(); i1 >= paramByteBuffer.position(); i1 -= 2)
      if (Math.abs(paramByteBuffer.get(i1)) > 4)
        return this.d * (i1 / this.d) + this.d;
    return paramByteBuffer.position();
  }

  public void a(ByteBuffer paramByteBuffer)
  {
    while ((paramByteBuffer.hasRemaining()) && (!this.g.hasRemaining()))
    {
      switch (this.k)
      {
      default:
        throw new IllegalStateException();
      case 0:
        b(paramByteBuffer);
        break;
      case 1:
        c(paramByteBuffer);
        break;
      case 2:
      }
      d(paramByteBuffer);
    }
  }

  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    h();
  }

  public boolean a()
  {
    return (this.c != -1) && (this.e);
  }

  public boolean a(int paramInt1, int paramInt2, int paramInt3)
    throws f.a
  {
    if (paramInt3 != 2)
      throw new f.a(paramInt1, paramInt2, paramInt3);
    if ((this.c == paramInt1) && (this.b == paramInt2))
      return false;
    this.c = paramInt1;
    this.b = paramInt2;
    this.d = (paramInt2 * 2);
    return true;
  }

  public int b()
  {
    return this.b;
  }

  public int c()
  {
    return 2;
  }

  public int d()
  {
    return this.c;
  }

  public void e()
  {
    this.h = true;
    if (this.l > 0)
      a(this.i, this.l);
    if (!this.n)
      this.o += this.m / this.d;
  }

  public ByteBuffer f()
  {
    ByteBuffer localByteBuffer = this.g;
    this.g = a;
    return localByteBuffer;
  }

  public boolean g()
  {
    return (this.h) && (this.g == a);
  }

  public void h()
  {
    if (a())
    {
      int i1 = a(150000L) * this.d;
      if (this.i.length != i1)
        this.i = new byte[i1];
      this.m = (a(20000L) * this.d);
      if (this.j.length != this.m)
        this.j = new byte[this.m];
    }
    this.k = 0;
    this.g = a;
    this.h = false;
    this.o = 0L;
    this.l = 0;
    this.n = false;
  }

  public void i()
  {
    this.e = false;
    h();
    this.f = a;
    this.b = -1;
    this.c = -1;
    this.m = 0;
    this.i = ag.f;
    this.j = ag.f;
  }

  public long j()
  {
    return this.o;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.b.x
 * JD-Core Version:    0.6.2
 */