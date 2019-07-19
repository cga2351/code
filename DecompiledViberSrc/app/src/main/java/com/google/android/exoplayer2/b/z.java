package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ag;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class z
  implements f
{
  private int b = -1;
  private int c = -1;
  private float d = 1.0F;
  private float e = 1.0F;
  private int f = -1;
  private int g = -1;
  private y h;
  private ByteBuffer i = a;
  private ShortBuffer j = this.i.asShortBuffer();
  private ByteBuffer k = a;
  private long l;
  private long m;
  private boolean n;

  public float a(float paramFloat)
  {
    float f1 = ag.a(paramFloat, 0.1F, 8.0F);
    if (this.d != f1)
    {
      this.d = f1;
      this.h = null;
    }
    h();
    return f1;
  }

  public long a(long paramLong)
  {
    if (this.m >= 1024L)
    {
      if (this.f == this.c)
        return ag.d(paramLong, this.l, this.m);
      return ag.d(paramLong, this.l * this.f, this.m * this.c);
    }
    return ()(this.d * paramLong);
  }

  public void a(ByteBuffer paramByteBuffer)
  {
    boolean bool;
    int i1;
    if (this.h != null)
    {
      bool = true;
      a.b(bool);
      if (paramByteBuffer.hasRemaining())
      {
        ShortBuffer localShortBuffer = paramByteBuffer.asShortBuffer();
        int i2 = paramByteBuffer.remaining();
        this.l += i2;
        this.h.a(localShortBuffer);
        paramByteBuffer.position(i2 + paramByteBuffer.position());
      }
      i1 = 2 * (this.h.c() * this.b);
      if (i1 > 0)
      {
        if (this.i.capacity() >= i1)
          break label165;
        this.i = ByteBuffer.allocateDirect(i1).order(ByteOrder.nativeOrder());
        this.j = this.i.asShortBuffer();
      }
    }
    while (true)
    {
      this.h.b(this.j);
      this.m += i1;
      this.i.limit(i1);
      this.k = this.i;
      return;
      bool = false;
      break;
      label165: this.i.clear();
      this.j.clear();
    }
  }

  public boolean a()
  {
    return (this.c != -1) && ((Math.abs(this.d - 1.0F) >= 0.01F) || (Math.abs(this.e - 1.0F) >= 0.01F) || (this.f != this.c));
  }

  public boolean a(int paramInt1, int paramInt2, int paramInt3)
    throws f.a
  {
    if (paramInt3 != 2)
      throw new f.a(paramInt1, paramInt2, paramInt3);
    if (this.g == -1);
    for (int i1 = paramInt1; (this.c == paramInt1) && (this.b == paramInt2) && (this.f == i1); i1 = this.g)
      return false;
    this.c = paramInt1;
    this.b = paramInt2;
    this.f = i1;
    this.h = null;
    return true;
  }

  public float b(float paramFloat)
  {
    float f1 = ag.a(paramFloat, 0.1F, 8.0F);
    if (this.e != f1)
    {
      this.e = f1;
      this.h = null;
    }
    h();
    return f1;
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
    return this.f;
  }

  public void e()
  {
    if (this.h != null);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      this.h.a();
      this.n = true;
      return;
    }
  }

  public ByteBuffer f()
  {
    ByteBuffer localByteBuffer = this.k;
    this.k = a;
    return localByteBuffer;
  }

  public boolean g()
  {
    return (this.n) && ((this.h == null) || (this.h.c() == 0));
  }

  public void h()
  {
    if (a())
    {
      if (this.h != null)
        break label68;
      this.h = new y(this.c, this.b, this.d, this.e, this.f);
    }
    while (true)
    {
      this.k = a;
      this.l = 0L;
      this.m = 0L;
      this.n = false;
      return;
      label68: this.h.b();
    }
  }

  public void i()
  {
    this.d = 1.0F;
    this.e = 1.0F;
    this.b = -1;
    this.c = -1;
    this.f = -1;
    this.i = a;
    this.j = this.i.asShortBuffer();
    this.k = a;
    this.g = -1;
    this.h = null;
    this.l = 0L;
    this.m = 0L;
    this.n = false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.b.z
 * JD-Core Version:    0.6.2
 */