package com.google.android.exoplayer2.e;

import java.nio.ByteBuffer;

public abstract class c extends com.google.android.exoplayer2.c.g<i, j, g>
  implements f
{
  private final String a;

  protected c(String paramString)
  {
    super(new i[2], new j[2]);
    this.a = paramString;
    a(1024);
  }

  protected abstract e a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
    throws g;

  protected final g a(i parami, j paramj, boolean paramBoolean)
  {
    try
    {
      ByteBuffer localByteBuffer = parami.b;
      e locale = a(localByteBuffer.array(), localByteBuffer.limit(), paramBoolean);
      paramj.a(parami.c, locale, parami.d);
      paramj.c(-2147483648);
      return null;
    }
    catch (g localg)
    {
      return localg;
    }
  }

  public void a(long paramLong)
  {
  }

  protected final void a(j paramj)
  {
    super.a(paramj);
  }

  protected final g b(Throwable paramThrowable)
  {
    return new g("Unexpected decode error", paramThrowable);
  }

  protected final i i()
  {
    return new i();
  }

  protected final j j()
  {
    return new d(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.c
 * JD-Core Version:    0.6.2
 */