package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.g.ag;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class u
  implements f
{
  private static final int b = Float.floatToIntBits((0.0F / 0.0F));
  private int c = -1;
  private int d = -1;
  private int e = 0;
  private ByteBuffer f = a;
  private ByteBuffer g = a;
  private boolean h;

  private static void a(int paramInt, ByteBuffer paramByteBuffer)
  {
    int i = Float.floatToIntBits((float)(4.656612875245797E-010D * paramInt));
    if (i == b)
      i = Float.floatToIntBits(0.0F);
    paramByteBuffer.putInt(i);
  }

  public void a(ByteBuffer paramByteBuffer)
  {
    int i;
    int j;
    int k;
    int m;
    if (this.e == 1073741824)
    {
      i = 1;
      j = paramByteBuffer.position();
      k = paramByteBuffer.limit();
      m = k - j;
      if (i == 0)
        break label141;
      label32: if (this.f.capacity() >= m)
        break label152;
      this.f = ByteBuffer.allocateDirect(m).order(ByteOrder.nativeOrder());
    }
    while (true)
    {
      if (i == 0)
        break label163;
      while (j < k)
      {
        a(0xFF & paramByteBuffer.get(j) | (0xFF & paramByteBuffer.get(j + 1)) << 8 | (0xFF & paramByteBuffer.get(j + 2)) << 16 | (0xFF & paramByteBuffer.get(j + 3)) << 24, this.f);
        j += 4;
      }
      i = 0;
      break;
      label141: m = 4 * (m / 3);
      break label32;
      label152: this.f.clear();
    }
    label163: for (int n = j; n < k; n += 3)
      a((0xFF & paramByteBuffer.get(n)) << 8 | (0xFF & paramByteBuffer.get(n + 1)) << 16 | (0xFF & paramByteBuffer.get(n + 2)) << 24, this.f);
    paramByteBuffer.position(paramByteBuffer.limit());
    this.f.flip();
    this.g = this.f;
  }

  public boolean a()
  {
    return ag.d(this.e);
  }

  public boolean a(int paramInt1, int paramInt2, int paramInt3)
    throws f.a
  {
    if (!ag.d(paramInt3))
      throw new f.a(paramInt1, paramInt2, paramInt3);
    if ((this.c == paramInt1) && (this.d == paramInt2) && (this.e == paramInt3))
      return false;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    return true;
  }

  public int b()
  {
    return this.d;
  }

  public int c()
  {
    return 4;
  }

  public int d()
  {
    return this.c;
  }

  public void e()
  {
    this.h = true;
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
    this.g = a;
    this.h = false;
  }

  public void i()
  {
    h();
    this.c = -1;
    this.d = -1;
    this.e = 0;
    this.f = a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.b.u
 * JD-Core Version:    0.6.2
 */