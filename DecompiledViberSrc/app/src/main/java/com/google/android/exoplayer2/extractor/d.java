package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.g.ag;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

public final class d
  implements h
{
  private final byte[] a;
  private final com.google.android.exoplayer2.f.h b;
  private final long c;
  private long d;
  private byte[] e;
  private int f;
  private int g;

  public d(com.google.android.exoplayer2.f.h paramh, long paramLong1, long paramLong2)
  {
    this.b = paramh;
    this.d = paramLong1;
    this.c = paramLong2;
    this.e = new byte[65536];
    this.a = new byte[4096];
  }

  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    throws InterruptedException, IOException
  {
    if (Thread.interrupted())
      throw new InterruptedException();
    int i = this.b.a(paramArrayOfByte, paramInt1 + paramInt3, paramInt2 - paramInt3);
    if (i == -1)
    {
      if ((paramInt3 == 0) && (paramBoolean))
        return -1;
      throw new EOFException();
    }
    return paramInt3 + i;
  }

  private int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.g == 0)
      return 0;
    int i = Math.min(this.g, paramInt2);
    System.arraycopy(this.e, 0, paramArrayOfByte, paramInt1, i);
    f(i);
    return i;
  }

  private void d(int paramInt)
  {
    int i = paramInt + this.f;
    if (i > this.e.length)
    {
      int j = ag.a(2 * this.e.length, 65536 + i, i + 524288);
      this.e = Arrays.copyOf(this.e, j);
    }
  }

  private int e(int paramInt)
  {
    int i = Math.min(this.g, paramInt);
    f(i);
    return i;
  }

  private void f(int paramInt)
  {
    this.g -= paramInt;
    this.f = 0;
    byte[] arrayOfByte = this.e;
    if (this.g < this.e.length - 524288)
      arrayOfByte = new byte[65536 + this.g];
    System.arraycopy(this.e, paramInt, arrayOfByte, 0, this.g);
    this.e = arrayOfByte;
  }

  private void g(int paramInt)
  {
    if (paramInt != -1)
      this.d += paramInt;
  }

  public int a(int paramInt)
    throws IOException, InterruptedException
  {
    int i = e(paramInt);
    if (i == 0)
      i = a(this.a, 0, Math.min(paramInt, this.a.length), 0, true);
    g(i);
    return i;
  }

  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, InterruptedException
  {
    int i = d(paramArrayOfByte, paramInt1, paramInt2);
    if (i == 0)
      i = a(paramArrayOfByte, paramInt1, paramInt2, 0, true);
    g(i);
    return i;
  }

  public void a()
  {
    this.f = 0;
  }

  public boolean a(int paramInt, boolean paramBoolean)
    throws IOException, InterruptedException
  {
    int j;
    for (int i = e(paramInt); (i < paramInt) && (i != -1); i = a(this.a, -i, j, i, paramBoolean))
      j = Math.min(paramInt, i + this.a.length);
    g(i);
    return i != -1;
  }

  public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    throws IOException, InterruptedException
  {
    for (int i = d(paramArrayOfByte, paramInt1, paramInt2); (i < paramInt2) && (i != -1); i = a(paramArrayOfByte, paramInt1, paramInt2, i, paramBoolean));
    g(i);
    return i != -1;
  }

  public long b()
  {
    return this.d + this.f;
  }

  public void b(int paramInt)
    throws IOException, InterruptedException
  {
    a(paramInt, false);
  }

  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, InterruptedException
  {
    a(paramArrayOfByte, paramInt1, paramInt2, false);
  }

  public boolean b(int paramInt, boolean paramBoolean)
    throws IOException, InterruptedException
  {
    d(paramInt);
    int i = this.g - this.f;
    while (i < paramInt)
    {
      i = a(this.e, this.f, paramInt, i, paramBoolean);
      if (i == -1)
        return false;
      this.g = (i + this.f);
    }
    this.f = (paramInt + this.f);
    return true;
  }

  public boolean b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    throws IOException, InterruptedException
  {
    if (!b(paramInt2, paramBoolean))
      return false;
    System.arraycopy(this.e, this.f - paramInt2, paramArrayOfByte, paramInt1, paramInt2);
    return true;
  }

  public long c()
  {
    return this.d;
  }

  public void c(int paramInt)
    throws IOException, InterruptedException
  {
    b(paramInt, false);
  }

  public void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, InterruptedException
  {
    b(paramArrayOfByte, paramInt1, paramInt2, false);
  }

  public long d()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.d
 * JD-Core Version:    0.6.2
 */