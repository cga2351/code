package com.viber.voip.util;

import android.os.Handler;

public class cf
{
  private Handler a;
  private Runnable b;
  private long c;
  private volatile boolean d = false;
  private Runnable e = new Runnable()
  {
    public void run()
    {
      if (cf.a(cf.this))
      {
        cf.b(cf.this).run();
        cf.d(cf.this).removeCallbacks(cf.c(cf.this));
        cf.d(cf.this).postDelayed(cf.c(cf.this), cf.e(cf.this));
      }
    }
  };

  public cf(Handler paramHandler, Runnable paramRunnable, long paramLong)
  {
    this.a = paramHandler;
    this.b = paramRunnable;
    this.c = paramLong;
    if ((this.a == null) || (this.b == null))
      throw new RuntimeException("Invalid params");
  }

  public void a()
  {
    try
    {
      boolean bool = this.d;
      if (bool);
      while (true)
      {
        return;
        this.a.removeCallbacks(this.e);
        this.d = true;
        this.a.post(this.e);
      }
    }
    finally
    {
    }
  }

  public void b()
  {
    try
    {
      boolean bool = this.d;
      if (!bool);
      while (true)
      {
        return;
        this.d = false;
        this.a.removeCallbacks(this.e);
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.cf
 * JD-Core Version:    0.6.2
 */