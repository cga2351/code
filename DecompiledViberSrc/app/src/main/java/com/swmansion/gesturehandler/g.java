package com.swmansion.gesturehandler;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

public class g extends b<g>
{
  private static float d = 10.0F;
  private long e = 500L;
  private float f;
  private float g;
  private float h;
  private Handler i;

  public g(Context paramContext)
  {
    a(true);
    this.f = (d * paramContext.getResources().getDisplayMetrics().density);
  }

  public g a(float paramFloat)
  {
    this.f = (paramFloat * paramFloat);
    return this;
  }

  public void a(long paramLong)
  {
    this.e = paramLong;
  }

  protected void a(MotionEvent paramMotionEvent)
  {
    if (i() == 0)
    {
      m();
      this.g = paramMotionEvent.getRawX();
      this.h = paramMotionEvent.getRawY();
      this.i = new Handler();
      this.i.postDelayed(new Runnable()
      {
        public void run()
        {
          g.this.l();
        }
      }
      , this.e);
    }
    if (paramMotionEvent.getActionMasked() == 1)
    {
      if (this.i != null)
      {
        this.i.removeCallbacksAndMessages(null);
        this.i = null;
      }
      if (i() == 4)
        n();
    }
    float f1;
    float f2;
    do
    {
      return;
      k();
      return;
      f1 = paramMotionEvent.getRawX() - this.g;
      f2 = paramMotionEvent.getRawY() - this.h;
    }
    while (f1 * f1 + f2 * f2 <= this.f);
    if (i() == 4)
    {
      j();
      return;
    }
    k();
  }

  protected void b(int paramInt1, int paramInt2)
  {
    if (this.i != null)
    {
      this.i.removeCallbacksAndMessages(null);
      this.i = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.swmansion.gesturehandler.g
 * JD-Core Version:    0.6.2
 */