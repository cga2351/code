package com.swmansion.gesturehandler;

import android.view.MotionEvent;

public class m
{
  private long a;
  private long b;
  private double c;
  private double d;
  private float e;
  private float f;
  private boolean g;
  private int[] h = new int[2];
  private a i;

  public m(a parama)
  {
    this.i = parama;
  }

  private void b(MotionEvent paramMotionEvent)
  {
    this.b = this.a;
    this.a = paramMotionEvent.getEventTime();
    int j = paramMotionEvent.findPointerIndex(this.h[0]);
    int k = paramMotionEvent.findPointerIndex(this.h[1]);
    float f1 = paramMotionEvent.getX(j);
    float f2 = paramMotionEvent.getY(j);
    float f3 = paramMotionEvent.getX(k);
    float f4 = paramMotionEvent.getY(k);
    float f5 = f3 - f1;
    float f6 = f4 - f2;
    this.e = (0.5F * (f1 + f3));
    this.f = (0.5F * (f2 + f4));
    double d1 = -Math.atan2(f6, f5);
    if (Double.isNaN(this.c))
    {
      this.d = 0.0D;
      this.c = d1;
      if (this.d <= 3.141592653589793D)
        break label198;
      this.d -= 3.141592653589793D;
      label160: if (this.d <= 1.570796326794897D)
        break label224;
      this.d -= 3.141592653589793D;
    }
    label198: label224: 
    while (this.d >= -1.570796326794897D)
    {
      return;
      this.d = (this.c - d1);
      break;
      if (this.d >= -3.141592653589793D)
        break label160;
      this.d = (3.141592653589793D + this.d);
      break label160;
    }
    this.d = (3.141592653589793D + this.d);
  }

  private void e()
  {
    if (this.g)
    {
      this.g = false;
      if (this.i != null)
        this.i.c(this);
    }
  }

  public double a()
  {
    return this.d;
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    case 3:
    case 4:
    default:
    case 0:
    case 5:
    case 2:
    case 6:
      int j;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return true;
                  this.g = false;
                  this.h[0] = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
                  this.h[1] = -1;
                  return true;
                }
                while (this.g);
                this.h[1] = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
                this.g = true;
                this.b = paramMotionEvent.getEventTime();
                this.c = (0.0D / 0.0D);
                b(paramMotionEvent);
              }
              while (this.i == null);
              this.i.b(this);
              return true;
            }
            while (!this.g);
            b(paramMotionEvent);
          }
          while (this.i == null);
          this.i.a(this);
          return true;
        }
        while (!this.g);
        j = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
      }
      while ((j != this.h[0]) && (j != this.h[1]));
      e();
      return true;
    case 1:
    }
    e();
    return true;
  }

  public long b()
  {
    return this.a - this.b;
  }

  public float c()
  {
    return this.e;
  }

  public float d()
  {
    return this.f;
  }

  public static abstract interface a
  {
    public abstract boolean a(m paramm);

    public abstract boolean b(m paramm);

    public abstract void c(m paramm);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.swmansion.gesturehandler.m
 * JD-Core Version:    0.6.2
 */