package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.g.a;

public final class ac
{
  private final b a;
  private final a b;
  private final ak c;
  private int d;
  private Object e;
  private Handler f;
  private int g;
  private long h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;

  public ac(a parama, b paramb, ak paramak, int paramInt, Handler paramHandler)
  {
    this.b = parama;
    this.a = paramb;
    this.c = paramak;
    this.f = paramHandler;
    this.g = paramInt;
    this.h = -9223372036854775807L;
    this.i = true;
  }

  public ac a(int paramInt)
  {
    if (!this.j);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      this.d = paramInt;
      return this;
    }
  }

  public ac a(Object paramObject)
  {
    if (!this.j);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      this.e = paramObject;
      return this;
    }
  }

  public ak a()
  {
    return this.c;
  }

  public void a(boolean paramBoolean)
  {
    try
    {
      this.k = (paramBoolean | this.k);
      this.l = true;
      notifyAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public b b()
  {
    return this.a;
  }

  public int c()
  {
    return this.d;
  }

  public Object d()
  {
    return this.e;
  }

  public Handler e()
  {
    return this.f;
  }

  public long f()
  {
    return this.h;
  }

  public int g()
  {
    return this.g;
  }

  public boolean h()
  {
    return this.i;
  }

  public ac i()
  {
    if (!this.j);
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      if (this.h == -9223372036854775807L)
        a.a(this.i);
      this.j = true;
      this.b.a(this);
      return this;
    }
  }

  public boolean j()
  {
    try
    {
      boolean bool = this.m;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean k()
    throws InterruptedException
  {
    while (true)
    {
      try
      {
        a.b(this.j);
        if (this.f.getLooper().getThread() != Thread.currentThread())
        {
          bool1 = true;
          a.b(bool1);
          if (this.l)
            break;
          wait();
          continue;
        }
      }
      finally
      {
      }
      boolean bool1 = false;
    }
    boolean bool2 = this.k;
    return bool2;
  }

  public static abstract interface a
  {
    public abstract void a(ac paramac);
  }

  public static abstract interface b
  {
    public abstract void a(int paramInt, Object paramObject)
      throws i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.ac
 * JD-Core Version:    0.6.2
 */