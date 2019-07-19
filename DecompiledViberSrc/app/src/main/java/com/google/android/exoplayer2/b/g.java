package com.google.android.exoplayer2.b;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.d;
import com.google.android.exoplayer2.g.a;

public abstract interface g
{
  public abstract void a(int paramInt);

  public abstract void a(int paramInt, long paramLong1, long paramLong2);

  public abstract void b(Format paramFormat);

  public abstract void b(String paramString, long paramLong1, long paramLong2);

  public abstract void c(d paramd);

  public abstract void d(d paramd);

  public static final class a
  {
    private final Handler a;
    private final g b;

    public a(Handler paramHandler, g paramg)
    {
      if (paramg != null);
      for (Handler localHandler = (Handler)a.a(paramHandler); ; localHandler = null)
      {
        this.a = localHandler;
        this.b = paramg;
        return;
      }
    }

    public void a(int paramInt)
    {
      if (this.b != null)
        this.a.post(new m(this, paramInt));
    }

    public void a(int paramInt, long paramLong1, long paramLong2)
    {
      if (this.b != null)
        this.a.post(new k(this, paramInt, paramLong1, paramLong2));
    }

    public void a(Format paramFormat)
    {
      if (this.b != null)
        this.a.post(new j(this, paramFormat));
    }

    public void a(d paramd)
    {
      if (this.b != null)
        this.a.post(new h(this, paramd));
    }

    public void a(String paramString, long paramLong1, long paramLong2)
    {
      if (this.b != null)
        this.a.post(new i(this, paramString, paramLong1, paramLong2));
    }

    public void b(d paramd)
    {
      if (this.b != null)
        this.a.post(new l(this, paramd));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.b.g
 * JD-Core Version:    0.6.2
 */