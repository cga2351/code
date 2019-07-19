package com.swmansion.gesturehandler;

import android.os.Handler;
import android.view.MotionEvent;

public class o extends b<o>
{
  private static float d = 1.4E-45F;
  private float e = d;
  private float f = d;
  private float g = d;
  private long h = 500L;
  private long i = 500L;
  private int j = 1;
  private int k = 1;
  private int l = 1;
  private float m;
  private float n;
  private float o;
  private float p;
  private float q;
  private float r;
  private Handler s;
  private int t;
  private final Runnable u = new Runnable()
  {
    public void run()
    {
      o.this.k();
    }
  };

  public o()
  {
    a(true);
  }

  private void t()
  {
    if (this.s == null)
      this.s = new Handler();
    while (true)
    {
      this.s.postDelayed(this.u, this.h);
      return;
      this.s.removeCallbacksAndMessages(null);
    }
  }

  private void u()
  {
    if (this.s == null)
      this.s = new Handler();
    while (true)
    {
      int i1 = 1 + this.t;
      this.t = i1;
      if ((i1 != this.j) || (this.l < this.k))
        break;
      l();
      n();
      return;
      this.s.removeCallbacksAndMessages(null);
    }
    this.s.postDelayed(this.u, this.i);
  }

  private boolean v()
  {
    float f1 = this.q - this.m + this.o;
    if ((this.e != d) && (Math.abs(f1) > this.e));
    float f3;
    do
    {
      float f2;
      do
      {
        return true;
        f2 = this.r - this.n + this.p;
      }
      while ((this.f != d) && (Math.abs(f2) > this.f));
      f3 = f2 * f2 + f1 * f1;
    }
    while ((this.g != d) && (f3 > this.g));
    return false;
  }

  public o a(float paramFloat)
  {
    this.e = paramFloat;
    return this;
  }

  public o a(int paramInt)
  {
    this.j = paramInt;
    return this;
  }

  public o a(long paramLong)
  {
    this.i = paramLong;
    return this;
  }

  protected void a()
  {
    if (this.s != null)
      this.s.removeCallbacksAndMessages(null);
  }

  protected void a(MotionEvent paramMotionEvent)
  {
    int i1 = i();
    int i2 = paramMotionEvent.getActionMasked();
    if (i1 == 0)
    {
      this.o = 0.0F;
      this.p = 0.0F;
      this.m = paramMotionEvent.getRawX();
      this.n = paramMotionEvent.getRawY();
    }
    if ((i2 == 6) || (i2 == 5))
    {
      this.o += this.q - this.m;
      this.p += this.r - this.n;
      this.q = f.a(paramMotionEvent, true);
      this.r = f.b(paramMotionEvent, true);
      this.m = this.q;
      this.n = this.r;
      if (this.l < paramMotionEvent.getPointerCount())
        this.l = paramMotionEvent.getPointerCount();
      if (!v())
        break label173;
      k();
    }
    label173: 
    do
    {
      do
      {
        return;
        this.q = f.a(paramMotionEvent, true);
        this.r = f.b(paramMotionEvent, true);
        break;
        if (i1 == 0)
        {
          if (i2 == 0)
            m();
          t();
          return;
        }
      }
      while (i1 != 2);
      if (i2 == 1)
      {
        u();
        return;
      }
    }
    while (i2 != 0);
    t();
  }

  public o b(float paramFloat)
  {
    this.f = paramFloat;
    return this;
  }

  public o b(int paramInt)
  {
    this.k = paramInt;
    return this;
  }

  public o b(long paramLong)
  {
    this.h = paramLong;
    return this;
  }

  protected void b()
  {
    this.t = 0;
    this.l = 0;
    if (this.s != null)
      this.s.removeCallbacksAndMessages(null);
  }

  public o c(float paramFloat)
  {
    this.g = (paramFloat * paramFloat);
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.swmansion.gesturehandler.o
 * JD-Core Version:    0.6.2
 */