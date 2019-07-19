package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.y;
import java.nio.ByteBuffer;

public abstract interface n
{
  public abstract long a(boolean paramBoolean);

  public abstract y a(y paramy);

  public abstract void a();

  public abstract void a(float paramFloat);

  public abstract void a(int paramInt);

  public abstract void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5, int paramInt6)
    throws n.a;

  public abstract void a(b paramb);

  public abstract void a(c paramc);

  public abstract void a(q paramq);

  public abstract boolean a(int paramInt1, int paramInt2);

  public abstract boolean a(ByteBuffer paramByteBuffer, long paramLong)
    throws n.b, n.d;

  public abstract void b();

  public abstract void c()
    throws n.d;

  public abstract boolean d();

  public abstract boolean e();

  public abstract y f();

  public abstract void g();

  public abstract void h();

  public abstract void i();

  public abstract void j();

  public static final class a extends Exception
  {
    public a(String paramString)
    {
      super();
    }

    public a(Throwable paramThrowable)
    {
      super();
    }
  }

  public static final class b extends Exception
  {
    public final int a;

    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super();
      this.a = paramInt1;
    }
  }

  public static abstract interface c
  {
    public abstract void a();

    public abstract void a(int paramInt);

    public abstract void a(int paramInt, long paramLong1, long paramLong2);
  }

  public static final class d extends Exception
  {
    public final int a;

    public d(int paramInt)
    {
      super();
      this.a = paramInt;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.b.n
 * JD-Core Version:    0.6.2
 */