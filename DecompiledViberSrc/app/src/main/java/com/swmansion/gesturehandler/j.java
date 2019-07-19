package com.swmansion.gesturehandler;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public class j extends b<j>
{
  private static float d = 3.4028235E+38F;
  private static float e = 1.4E-45F;
  private static int f = 1;
  private static int g = 10;
  private float A;
  private float B;
  private float C;
  private VelocityTracker D;
  private boolean E;
  private float h = e;
  private float i = d;
  private float j = e;
  private float k = e;
  private float l = d;
  private float m = d;
  private float n = e;
  private float o = e;
  private float p = d;
  private float q = d;
  private float r = d;
  private float s = d;
  private int t = f;
  private int u = g;
  private float v;
  private float w;
  private float x;
  private float y;
  private float z;

  public j(Context paramContext)
  {
    int i1 = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.h = (i1 * i1);
  }

  private static void a(VelocityTracker paramVelocityTracker, MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawX() - paramMotionEvent.getX();
    float f2 = paramMotionEvent.getRawY() - paramMotionEvent.getY();
    paramMotionEvent.offsetLocation(f1, f2);
    paramVelocityTracker.addMovement(paramMotionEvent);
    paramMotionEvent.offsetLocation(-f1, -f2);
  }

  private boolean x()
  {
    float f1 = this.z - this.v + this.x;
    if ((this.i != d) && (f1 < this.i));
    float f6;
    do
    {
      float f4;
      float f5;
      do
      {
        do
        {
          float f3;
          do
          {
            float f2;
            do
            {
              do
                return true;
              while ((this.j != e) && (f1 > this.j));
              f2 = this.A - this.w + this.y;
            }
            while (((this.m != d) && (f2 < this.m)) || ((this.n != e) && (f2 > this.n)));
            f3 = f1 * f1 + f2 * f2;
          }
          while ((this.h != d) && (f3 >= this.h));
          f4 = this.B;
        }
        while ((this.q != d) && (((this.q < 0.0F) && (f4 <= this.q)) || ((this.q >= 0.0F) && (f4 >= this.q))));
        f5 = this.C;
      }
      while ((this.r != d) && (((this.r < 0.0F) && (f4 <= this.r)) || ((this.r >= 0.0F) && (f4 >= this.r))));
      f6 = f4 * f4 + f5 * f5;
    }
    while ((this.s != d) && (f6 >= this.s));
    return false;
  }

  private boolean y()
  {
    float f1 = this.z - this.v + this.x;
    if ((this.k != e) && (f1 < this.k));
    float f2;
    do
    {
      do
        return true;
      while ((this.l != d) && (f1 > this.l));
      f2 = this.A - this.w + this.y;
    }
    while (((this.o != e) && (f2 < this.o)) || ((this.p != d) && (f2 > this.p)));
    return false;
  }

  public j a(float paramFloat)
  {
    this.i = paramFloat;
    return this;
  }

  public j a(int paramInt)
  {
    this.t = paramInt;
    return this;
  }

  protected void a(MotionEvent paramMotionEvent)
  {
    int i1 = i();
    int i2 = paramMotionEvent.getActionMasked();
    if ((i2 == 6) || (i2 == 5))
    {
      this.x += this.z - this.v;
      this.y += this.A - this.w;
      this.z = f.a(paramMotionEvent, this.E);
      this.A = f.b(paramMotionEvent, this.E);
      this.v = this.z;
      this.w = this.A;
      if ((i1 != 0) || (paramMotionEvent.getPointerCount() < this.t))
        break label199;
      this.v = this.z;
      this.w = this.A;
      this.x = 0.0F;
      this.y = 0.0F;
      this.D = VelocityTracker.obtain();
      a(this.D, paramMotionEvent);
      m();
      label157: if (i2 != 1)
        break label254;
      if (i1 != 4)
        break label249;
      n();
    }
    label199: label249: label254: 
    do
    {
      do
      {
        return;
        this.z = f.a(paramMotionEvent, this.E);
        this.A = f.b(paramMotionEvent, this.E);
        break;
        if (this.D == null)
          break label157;
        a(this.D, paramMotionEvent);
        this.D.computeCurrentVelocity(1000);
        this.B = this.D.getXVelocity();
        this.C = this.D.getYVelocity();
        break label157;
        k();
        return;
        if ((i2 == 5) && (paramMotionEvent.getPointerCount() > this.u))
        {
          if (i1 == 4)
          {
            j();
            return;
          }
          k();
          return;
        }
        if ((i2 == 6) && (i1 == 4) && (paramMotionEvent.getPointerCount() < this.t))
        {
          k();
          return;
        }
      }
      while (i1 != 2);
      if (y())
      {
        k();
        return;
      }
    }
    while (!x());
    this.v = this.z;
    this.w = this.A;
    l();
  }

  public j b(float paramFloat)
  {
    this.j = paramFloat;
    return this;
  }

  public j b(int paramInt)
  {
    this.u = paramInt;
    return this;
  }

  protected void b()
  {
    if (this.D != null)
    {
      this.D.recycle();
      this.D = null;
    }
  }

  public j c(float paramFloat)
  {
    this.k = paramFloat;
    return this;
  }

  public j c(boolean paramBoolean)
  {
    this.E = paramBoolean;
    return this;
  }

  public j d(float paramFloat)
  {
    this.l = paramFloat;
    return this;
  }

  public j e(float paramFloat)
  {
    this.m = paramFloat;
    return this;
  }

  public j f(float paramFloat)
  {
    this.n = paramFloat;
    return this;
  }

  public j g(float paramFloat)
  {
    this.o = paramFloat;
    return this;
  }

  public j h(float paramFloat)
  {
    this.p = paramFloat;
    return this;
  }

  public j i(float paramFloat)
  {
    this.h = (paramFloat * paramFloat);
    return this;
  }

  public j j(float paramFloat)
  {
    this.s = (paramFloat * paramFloat);
    return this;
  }

  public j k(float paramFloat)
  {
    this.q = paramFloat;
    return this;
  }

  public j l(float paramFloat)
  {
    this.r = paramFloat;
    return this;
  }

  public float t()
  {
    return this.z - this.v + this.x;
  }

  public float u()
  {
    return this.A - this.w + this.y;
  }

  public float v()
  {
    return this.B;
  }

  public float w()
  {
    return this.C;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.swmansion.gesturehandler.j
 * JD-Core Version:    0.6.2
 */