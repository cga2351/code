package com.google.android.exoplayer2.b;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class w
  implements f
{
  private int b = -1;
  private int c = -1;
  private int d = 0;
  private ByteBuffer e = a;
  private ByteBuffer f = a;
  private boolean g;

  public void a(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.position();
    int j = paramByteBuffer.limit();
    int k = j - i;
    int m;
    switch (this.d)
    {
    default:
      throw new IllegalStateException();
    case 3:
      m = k * 2;
      label66: if (this.e.capacity() < m)
        this.e = ByteBuffer.allocateDirect(m).order(ByteOrder.nativeOrder());
      break;
    case -2147483648:
    case 1073741824:
    }
    while (true)
      switch (this.d)
      {
      default:
        throw new IllegalStateException();
        m = 2 * (k / 3);
        break label66;
        m = k / 2;
        break label66;
        this.e.clear();
      case 3:
      case -2147483648:
      case 1073741824:
      }
    while (i < j)
    {
      this.e.put((byte)0);
      this.e.put((byte)(-128 + (0xFF & paramByteBuffer.get(i))));
      i++;
      continue;
      while (i < j)
      {
        this.e.put(paramByteBuffer.get(i + 1));
        this.e.put(paramByteBuffer.get(i + 2));
        i += 3;
        continue;
        for (int n = i; n < j; n += 4)
        {
          this.e.put(paramByteBuffer.get(n + 2));
          this.e.put(paramByteBuffer.get(n + 3));
        }
      }
    }
    paramByteBuffer.position(paramByteBuffer.limit());
    this.e.flip();
    this.f = this.e;
  }

  public boolean a()
  {
    return (this.d != 0) && (this.d != 2);
  }

  public boolean a(int paramInt1, int paramInt2, int paramInt3)
    throws f.a
  {
    if ((paramInt3 != 3) && (paramInt3 != 2) && (paramInt3 != -2147483648) && (paramInt3 != 1073741824))
      throw new f.a(paramInt1, paramInt2, paramInt3);
    if ((this.b == paramInt1) && (this.c == paramInt2) && (this.d == paramInt3))
      return false;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    return true;
  }

  public int b()
  {
    return this.c;
  }

  public int c()
  {
    return 2;
  }

  public int d()
  {
    return this.b;
  }

  public void e()
  {
    this.g = true;
  }

  public ByteBuffer f()
  {
    ByteBuffer localByteBuffer = this.f;
    this.f = a;
    return localByteBuffer;
  }

  public boolean g()
  {
    return (this.g) && (this.f == a);
  }

  public void h()
  {
    this.f = a;
    this.g = false;
  }

  public void i()
  {
    h();
    this.b = -1;
    this.c = -1;
    this.d = 0;
    this.e = a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.b.w
 * JD-Core Version:    0.6.2
 */