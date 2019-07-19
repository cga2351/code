package com.swmansion.gesturehandler;

import android.os.Handler;
import android.view.MotionEvent;

public class a extends b<a>
{
  private long d = 800L;
  private long e = 160L;
  private int f = 1;
  private int g = 1;
  private float h;
  private float i;
  private Handler j;
  private int k;
  private final Runnable l = new Runnable()
  {
    public void run()
    {
      a.this.k();
    }
  };

  private void d(MotionEvent paramMotionEvent)
  {
    this.h = paramMotionEvent.getRawX();
    this.i = paramMotionEvent.getRawY();
    m();
    this.k = 1;
    if (this.j == null)
      this.j = new Handler();
    while (true)
    {
      this.j.postDelayed(this.l, this.d);
      return;
      this.j.removeCallbacksAndMessages(null);
    }
  }

  private boolean e(MotionEvent paramMotionEvent)
  {
    if ((this.k == this.g) && ((((0x1 & this.f) != 0) && (paramMotionEvent.getRawX() - this.h > (float)this.e)) || (((0x2 & this.f) != 0) && (this.h - paramMotionEvent.getRawX() > (float)this.e)) || (((0x4 & this.f) != 0) && (this.i - paramMotionEvent.getRawY() > (float)this.e)) || (((0x8 & this.f) != 0) && (paramMotionEvent.getRawY() - this.i > (float)this.e))))
    {
      this.j.removeCallbacksAndMessages(null);
      l();
      n();
      return true;
    }
    return false;
  }

  private void f(MotionEvent paramMotionEvent)
  {
    if (!e(paramMotionEvent))
      k();
  }

  protected void a()
  {
    if (this.j != null)
      this.j.removeCallbacksAndMessages(null);
  }

  public void a(int paramInt)
  {
    this.g = paramInt;
  }

  protected void a(MotionEvent paramMotionEvent)
  {
    int m = i();
    if (m == 0)
      d(paramMotionEvent);
    if (m == 2)
    {
      e(paramMotionEvent);
      if (paramMotionEvent.getPointerCount() > this.k)
        this.k = paramMotionEvent.getPointerCount();
      if (paramMotionEvent.getActionMasked() == 1)
        f(paramMotionEvent);
    }
  }

  protected void b()
  {
    if (this.j != null)
      this.j.removeCallbacksAndMessages(null);
  }

  public void b(int paramInt)
  {
    this.f = paramInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.swmansion.gesturehandler.a
 * JD-Core Version:    0.6.2
 */