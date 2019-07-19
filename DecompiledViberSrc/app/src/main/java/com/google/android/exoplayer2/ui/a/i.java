package com.google.android.exoplayer2.ui.a;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class i extends GestureDetector.SimpleOnGestureListener
  implements View.OnTouchListener
{
  private final PointF a = new PointF();
  private final PointF b = new PointF();
  private final a c;
  private final float d;
  private final GestureDetector e;
  private volatile float f;
  private e g;

  public i(Context paramContext, a parama, float paramFloat)
  {
    this.c = parama;
    this.d = paramFloat;
    this.e = new GestureDetector(paramContext, this);
    this.f = 3.141593F;
  }

  public void a(float paramFloat)
  {
    this.f = (-paramFloat);
  }

  public void a(e parame)
  {
    this.g = parame;
  }

  public boolean onDown(MotionEvent paramMotionEvent)
  {
    this.a.set(paramMotionEvent.getX(), paramMotionEvent.getY());
    return true;
  }

  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    float f1 = (paramMotionEvent2.getX() - this.a.x) / this.d;
    float f2 = (paramMotionEvent2.getY() - this.a.y) / this.d;
    this.a.set(paramMotionEvent2.getX(), paramMotionEvent2.getY());
    float f3 = this.f;
    float f4 = (float)Math.cos(f3);
    float f5 = (float)Math.sin(f3);
    PointF localPointF1 = this.b;
    localPointF1.x -= f4 * f1 - f5 * f2;
    PointF localPointF2 = this.b;
    localPointF2.y += f1 * f5 + f2 * f4;
    this.b.y = Math.max(-45.0F, Math.min(45.0F, this.b.y));
    this.c.a(this.b);
    return true;
  }

  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (this.g != null)
      return this.g.a(paramMotionEvent);
    return false;
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return this.e.onTouchEvent(paramMotionEvent);
  }

  static abstract interface a
  {
    public abstract void a(PointF paramPointF);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.ui.a.i
 * JD-Core Version:    0.6.2
 */