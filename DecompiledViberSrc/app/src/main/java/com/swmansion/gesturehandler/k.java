package com.swmansion.gesturehandler;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.ViewConfiguration;

public class k extends b<k>
{
  private ScaleGestureDetector d;
  private double e;
  private double f;
  private float g;
  private float h;
  private ScaleGestureDetector.OnScaleGestureListener i = new ScaleGestureDetector.OnScaleGestureListener()
  {
    public boolean onScale(ScaleGestureDetector paramAnonymousScaleGestureDetector)
    {
      double d = k.a(k.this);
      k.a(k.this, k.a(k.this) * paramAnonymousScaleGestureDetector.getScaleFactor());
      long l = paramAnonymousScaleGestureDetector.getTimeDelta();
      if (l > 0L)
        k.b(k.this, (k.a(k.this) - d) / l);
      if ((Math.abs(k.b(k.this) - paramAnonymousScaleGestureDetector.getCurrentSpan()) >= k.c(k.this)) && (k.this.i() == 2))
        k.this.l();
      return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector paramAnonymousScaleGestureDetector)
    {
      k.a(k.this, paramAnonymousScaleGestureDetector.getCurrentSpan());
      return true;
    }

    public void onScaleEnd(ScaleGestureDetector paramAnonymousScaleGestureDetector)
    {
    }
  };

  public k()
  {
    a(false);
  }

  protected void a(MotionEvent paramMotionEvent)
  {
    if (i() == 0)
    {
      Context localContext = e().getContext();
      this.f = 0.0D;
      this.e = 1.0D;
      this.d = new ScaleGestureDetector(localContext, this.i);
      this.h = ViewConfiguration.get(localContext).getScaledTouchSlop();
      m();
    }
    if (this.d != null)
      this.d.onTouchEvent(paramMotionEvent);
    int j = paramMotionEvent.getPointerCount();
    if (paramMotionEvent.getActionMasked() == 6)
      j--;
    if ((i() == 4) && (j < 2))
      n();
    while (paramMotionEvent.getActionMasked() != 1)
      return;
    k();
  }

  protected void b()
  {
    this.d = null;
    this.f = 0.0D;
    this.e = 1.0D;
  }

  public double t()
  {
    return this.e;
  }

  public double u()
  {
    return this.f;
  }

  public float v()
  {
    if (this.d == null)
      return (0.0F / 0.0F);
    return this.d.getFocusX();
  }

  public float w()
  {
    if (this.d == null)
      return (0.0F / 0.0F);
    return this.d.getFocusY();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.swmansion.gesturehandler.k
 * JD-Core Version:    0.6.2
 */