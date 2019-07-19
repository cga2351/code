package com.google.android.exoplayer2.b;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract interface f
{
  public static final ByteBuffer a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

  public abstract void a(ByteBuffer paramByteBuffer);

  public abstract boolean a();

  public abstract boolean a(int paramInt1, int paramInt2, int paramInt3)
    throws f.a;

  public abstract int b();

  public abstract int c();

  public abstract int d();

  public abstract void e();

  public abstract ByteBuffer f();

  public abstract boolean g();

  public abstract void h();

  public abstract void i();

  public static final class a extends Exception
  {
    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.b.f
 * JD-Core Version:    0.6.2
 */