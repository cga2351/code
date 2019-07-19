package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.g.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

final class r
  implements f
{
  private int b = -1;
  private int c = -1;
  private int[] d;
  private boolean e;
  private int[] f;
  private ByteBuffer g = a;
  private ByteBuffer h = a;
  private boolean i;

  public void a(ByteBuffer paramByteBuffer)
  {
    boolean bool;
    int j;
    int k;
    int n;
    if (this.f != null)
    {
      bool = true;
      a.b(bool);
      j = paramByteBuffer.position();
      k = paramByteBuffer.limit();
      int m = 2 * ((k - j) / (2 * this.b) * this.f.length);
      if (this.g.capacity() >= m)
        break label140;
      this.g = ByteBuffer.allocateDirect(m).order(ByteOrder.nativeOrder());
      n = j;
    }
    while (true)
    {
      label75: if (n >= k)
        break label168;
      int[] arrayOfInt = this.f;
      int i1 = arrayOfInt.length;
      int i2 = 0;
      while (true)
        if (i2 < i1)
        {
          int i3 = arrayOfInt[i2];
          this.g.putShort(paramByteBuffer.getShort(n + i3 * 2));
          i2++;
          continue;
          bool = false;
          break;
          label140: this.g.clear();
          n = j;
          break label75;
        }
      n += 2 * this.b;
    }
    label168: paramByteBuffer.position(k);
    this.g.flip();
    this.h = this.g;
  }

  public void a(int[] paramArrayOfInt)
  {
    this.d = paramArrayOfInt;
  }

  public boolean a()
  {
    return this.e;
  }

  public boolean a(int paramInt1, int paramInt2, int paramInt3)
    throws f.a
  {
    if (!Arrays.equals(this.d, this.f));
    for (boolean bool1 = true; ; bool1 = false)
    {
      this.f = this.d;
      if (this.f != null)
        break;
      this.e = false;
      return bool1;
    }
    if (paramInt3 != 2)
      throw new f.a(paramInt1, paramInt2, paramInt3);
    if ((!bool1) && (this.c == paramInt1) && (this.b == paramInt2))
      return false;
    this.c = paramInt1;
    this.b = paramInt2;
    if (paramInt2 != this.f.length);
    int j;
    int k;
    for (boolean bool2 = true; ; bool2 = false)
    {
      this.e = bool2;
      j = 0;
      if (j >= this.f.length)
        break label195;
      k = this.f[j];
      if (k < paramInt2)
        break;
      throw new f.a(paramInt1, paramInt2, paramInt3);
    }
    boolean bool3 = this.e;
    if (k != j);
    for (boolean bool4 = true; ; bool4 = false)
    {
      this.e = (bool4 | bool3);
      j++;
      break;
    }
    label195: return true;
  }

  public int b()
  {
    if (this.f == null)
      return this.b;
    return this.f.length;
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
    this.i = true;
  }

  public ByteBuffer f()
  {
    ByteBuffer localByteBuffer = this.h;
    this.h = a;
    return localByteBuffer;
  }

  public boolean g()
  {
    return (this.i) && (this.h == a);
  }

  public void h()
  {
    this.h = a;
    this.i = false;
  }

  public void i()
  {
    h();
    this.g = a;
    this.b = -1;
    this.c = -1;
    this.f = null;
    this.d = null;
    this.e = false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.b.r
 * JD-Core Version:    0.6.2
 */