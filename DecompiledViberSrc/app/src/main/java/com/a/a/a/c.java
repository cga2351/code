package com.a.a.a;

import android.content.Context;
import android.view.MotionEvent;

public class c extends d
{
  private final a l;
  private boolean m;

  public c(Context paramContext, a parama)
  {
    super(paramContext);
    this.l = parama;
  }

  protected void a(int paramInt, MotionEvent paramMotionEvent)
  {
    switch (paramInt)
    {
    case 3:
    case 4:
    default:
    case 5:
    case 2:
    case 6:
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            ad_();
            this.c = MotionEvent.obtain(paramMotionEvent);
            this.g = 0L;
            b(paramMotionEvent);
            this.m = c(paramMotionEvent);
          }
          while (this.m);
          this.b = this.l.b(this);
          return;
        }
        while (!this.m);
        this.m = c(paramMotionEvent);
      }
      while (this.m);
      this.b = this.l.b(this);
      return;
    }
    while (this.m);
  }

  protected void ad_()
  {
    super.ad_();
    this.m = false;
  }

  protected void b(int paramInt, MotionEvent paramMotionEvent)
  {
    switch (paramInt)
    {
    case 4:
    case 5:
    default:
    case 6:
    case 3:
    case 2:
    }
    do
    {
      return;
      b(paramMotionEvent);
      if (!this.m)
        this.l.c(this);
      ad_();
      return;
      if (!this.m)
        this.l.c(this);
      ad_();
      return;
      b(paramMotionEvent);
    }
    while ((this.e / this.f <= 0.67F) || (!this.l.a(this)));
    this.c.recycle();
    this.c = MotionEvent.obtain(paramMotionEvent);
  }

  public float c()
  {
    return (float)(180.0D * (Math.atan2(this.i, this.h) - Math.atan2(this.k, this.j)) / 3.141592653589793D);
  }

  public static abstract interface a
  {
    public abstract boolean a(c paramc);

    public abstract boolean b(c paramc);

    public abstract void c(c paramc);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.a.a.a.c
 * JD-Core Version:    0.6.2
 */