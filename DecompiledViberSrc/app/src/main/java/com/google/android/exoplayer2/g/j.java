package com.google.android.exoplayer2.g;

public final class j
{
  public final int a;
  public final int b;
  public final int c;
  public final int d;
  public final int e;
  public final int f;
  public final int g;
  public final long h;

  public j(byte[] paramArrayOfByte, int paramInt)
  {
    q localq = new q(paramArrayOfByte);
    localq.a(paramInt * 8);
    this.a = localq.c(16);
    this.b = localq.c(16);
    this.c = localq.c(24);
    this.d = localq.c(24);
    this.e = localq.c(20);
    this.f = (1 + localq.c(3));
    this.g = (1 + localq.c(5));
    this.h = ((0xF & localq.c(4)) << 32 | 0xFFFFFFFF & localq.c(32));
  }

  public int a()
  {
    return this.g * this.e;
  }

  public long b()
  {
    return 1000000L * this.h / this.e;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.g.j
 * JD-Core Version:    0.6.2
 */