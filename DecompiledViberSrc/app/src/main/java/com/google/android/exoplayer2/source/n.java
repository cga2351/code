package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.f.ad;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.j;
import java.io.IOException;

public abstract interface n
{
  public abstract m a(a parama, b paramb, long paramLong);

  public abstract void a(Handler paramHandler, o paramo);

  public abstract void a(j paramj, boolean paramBoolean, b paramb, ad paramad);

  public abstract void a(m paramm);

  public abstract void a(b paramb);

  public abstract void a(o paramo);

  public abstract void b()
    throws IOException;

  public static final class a
  {
    public final Object a;
    public final int b;
    public final int c;
    public final long d;
    public final long e;

    public a(Object paramObject)
    {
      this(paramObject, -1L);
    }

    public a(Object paramObject, int paramInt1, int paramInt2, long paramLong)
    {
      this(paramObject, paramInt1, paramInt2, paramLong, -9223372036854775808L);
    }

    private a(Object paramObject, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      this.a = paramObject;
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramLong1;
      this.e = paramLong2;
    }

    public a(Object paramObject, long paramLong)
    {
      this(paramObject, -1, -1, paramLong, -9223372036854775808L);
    }

    public a(Object paramObject, long paramLong1, long paramLong2)
    {
      this(paramObject, -1, -1, paramLong1, paramLong2);
    }

    public boolean a()
    {
      return this.b != -1;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      a locala;
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        locala = (a)paramObject;
      }
      while ((this.a.equals(locala.a)) && (this.b == locala.b) && (this.c == locala.c) && (this.d == locala.d) && (this.e == locala.e));
      return false;
    }

    public int hashCode()
    {
      return 31 * (31 * (31 * (31 * (527 + this.a.hashCode()) + this.b) + this.c) + (int)this.d) + (int)this.e;
    }
  }

  public static abstract interface b
  {
    public abstract void a(n paramn, ak paramak, Object paramObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.n
 * JD-Core Version:    0.6.2
 */