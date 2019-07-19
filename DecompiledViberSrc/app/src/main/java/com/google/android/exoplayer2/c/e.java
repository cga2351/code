package com.google.android.exoplayer2.c;

import java.nio.ByteBuffer;

public class e extends a
{
  public final b a = new b();
  public ByteBuffer b;
  public long c;
  private final int d;

  public e(int paramInt)
  {
    this.d = paramInt;
  }

  public static e e()
  {
    return new e(0);
  }

  private ByteBuffer f(int paramInt)
  {
    if (this.d == 1)
      return ByteBuffer.allocate(paramInt);
    if (this.d == 2)
      return ByteBuffer.allocateDirect(paramInt);
    if (this.b == null);
    for (int i = 0; ; i = this.b.capacity())
      throw new IllegalStateException("Buffer too small (" + i + " < " + paramInt + ")");
  }

  public void a()
  {
    super.a();
    if (this.b != null)
      this.b.clear();
  }

  public void e(int paramInt)
  {
    if (this.b == null)
      this.b = f(paramInt);
    int i;
    int j;
    int k;
    do
    {
      return;
      i = this.b.capacity();
      j = this.b.position();
      k = j + paramInt;
    }
    while (i >= k);
    ByteBuffer localByteBuffer = f(k);
    if (j > 0)
    {
      this.b.position(0);
      this.b.limit(j);
      localByteBuffer.put(this.b);
    }
    this.b = localByteBuffer;
  }

  public final boolean f()
  {
    return (this.b == null) && (this.d == 0);
  }

  public final boolean g()
  {
    return d(1073741824);
  }

  public final void h()
  {
    this.b.flip();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e
 * JD-Core Version:    0.6.2
 */