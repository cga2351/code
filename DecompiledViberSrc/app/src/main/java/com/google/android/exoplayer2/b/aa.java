package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.g.ag;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class aa
  implements f
{
  private boolean b;
  private int c;
  private int d;
  private int e = -1;
  private int f = -1;
  private int g;
  private boolean h;
  private int i;
  private ByteBuffer j = a;
  private ByteBuffer k = a;
  private byte[] l = ag.f;
  private int m;
  private boolean n;
  private long o;

  public void a(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
  }

  public void a(ByteBuffer paramByteBuffer)
  {
    int i1 = paramByteBuffer.position();
    int i2 = paramByteBuffer.limit();
    int i3 = i2 - i1;
    if (i3 == 0);
    int i4;
    do
    {
      return;
      this.h = true;
      i4 = Math.min(i3, this.i);
      this.o += i4 / this.g;
      this.i -= i4;
      paramByteBuffer.position(i1 + i4);
    }
    while (this.i > 0);
    int i5 = i3 - i4;
    int i6 = i5 + this.m - this.l.length;
    if (this.j.capacity() < i6)
      this.j = ByteBuffer.allocateDirect(i6).order(ByteOrder.nativeOrder());
    while (true)
    {
      int i7 = ag.a(i6, 0, this.m);
      this.j.put(this.l, 0, i7);
      int i8 = ag.a(i6 - i7, 0, i5);
      paramByteBuffer.limit(i8 + paramByteBuffer.position());
      this.j.put(paramByteBuffer);
      paramByteBuffer.limit(i2);
      int i9 = i5 - i8;
      this.m -= i7;
      System.arraycopy(this.l, i7, this.l, 0, this.m);
      paramByteBuffer.get(this.l, this.m, i9);
      this.m = (i9 + this.m);
      this.j.flip();
      this.k = this.j;
      return;
      this.j.clear();
    }
  }

  public boolean a()
  {
    return this.b;
  }

  public boolean a(int paramInt1, int paramInt2, int paramInt3)
    throws f.a
  {
    if (paramInt3 != 2)
      throw new f.a(paramInt1, paramInt2, paramInt3);
    if (this.m > 0)
      this.o += this.m / this.g;
    this.e = paramInt2;
    this.f = paramInt1;
    this.g = ag.b(2, paramInt2);
    this.l = new byte[this.d * this.g];
    this.m = 0;
    this.i = (this.c * this.g);
    boolean bool1 = this.b;
    if ((this.c != 0) || (this.d != 0));
    for (boolean bool2 = true; ; bool2 = false)
    {
      this.b = bool2;
      this.h = false;
      if (bool1 == this.b)
        break;
      return true;
    }
    return false;
  }

  public int b()
  {
    return this.e;
  }

  public int c()
  {
    return 2;
  }

  public int d()
  {
    return this.f;
  }

  public void e()
  {
    this.n = true;
  }

  public ByteBuffer f()
  {
    ByteBuffer localByteBuffer = this.k;
    if ((this.n) && (this.m > 0) && (localByteBuffer == a))
    {
      if (this.j.capacity() >= this.m)
        break label101;
      this.j = ByteBuffer.allocateDirect(this.m).order(ByteOrder.nativeOrder());
    }
    while (true)
    {
      this.j.put(this.l, 0, this.m);
      this.m = 0;
      this.j.flip();
      localByteBuffer = this.j;
      this.k = a;
      return localByteBuffer;
      label101: this.j.clear();
    }
  }

  public boolean g()
  {
    return (this.n) && (this.m == 0) && (this.k == a);
  }

  public void h()
  {
    this.k = a;
    this.n = false;
    if (this.h)
      this.i = 0;
    this.m = 0;
  }

  public void i()
  {
    h();
    this.j = a;
    this.e = -1;
    this.f = -1;
    this.l = ag.f;
  }

  public void j()
  {
    this.o = 0L;
  }

  public long k()
  {
    return this.o;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.b.aa
 * JD-Core Version:    0.6.2
 */