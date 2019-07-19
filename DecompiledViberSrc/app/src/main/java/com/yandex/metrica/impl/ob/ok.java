package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.util.concurrent.TimeUnit;

public class ok
{
  private volatile long a;
  private fy b;
  private on c;

  public static ok a()
  {
    return a.a;
  }

  public void a(long paramLong, Long paramLong1)
  {
    boolean bool = true;
    try
    {
      this.a = ((paramLong - this.c.a()) / 1000L);
      if (this.b.b(true))
      {
        if (paramLong1 == null)
          break label113;
        long l = Math.abs(paramLong - this.c.a());
        fy localfy = this.b;
        if (l <= TimeUnit.SECONDS.toMillis(paramLong1.longValue()))
          break label107;
        localfy.c(bool);
      }
      while (true)
      {
        this.b.a(this.a);
        this.b.i();
        return;
        label107: bool = false;
        break;
        label113: this.b.c(false);
      }
    }
    finally
    {
    }
  }

  public void a(Context paramContext)
  {
    try
    {
      a(new fy(fj.a(paramContext).c()), new om());
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(fy paramfy, on paramon)
  {
    this.b = paramfy;
    this.a = this.b.c(0);
    this.c = paramon;
  }

  public long b()
  {
    try
    {
      long l = this.a;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void c()
  {
    try
    {
      this.b.c(false);
      this.b.i();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean d()
  {
    try
    {
      boolean bool = this.b.b(true);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private static class a
  {
    static ok a = new ok((byte)0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ok
 * JD-Core Version:    0.6.2
 */