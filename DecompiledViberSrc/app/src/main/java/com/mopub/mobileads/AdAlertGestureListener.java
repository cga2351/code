package com.mopub.mobileads;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.mopub.common.AdReport;

public class AdAlertGestureListener extends GestureDetector.SimpleOnGestureListener
{
  boolean a;
  private final AdReport b;
  private float c = 100.0F;
  private float d;
  private boolean e;
  private boolean f;
  private AdAlertReporter g;
  private int h;
  private float i;
  private a j = a.UNSET;
  private View k;

  AdAlertGestureListener(View paramView, AdReport paramAdReport)
  {
    if ((paramView != null) && (paramView.getWidth() > 0))
      this.c = Math.min(100.0F, paramView.getWidth() / 3.0F);
    this.a = false;
    this.k = paramView;
    this.b = paramAdReport;
  }

  private void a(float paramFloat)
  {
    if (paramFloat > this.i)
      this.j = a.GOING_RIGHT;
  }

  private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null));
    float f1;
    do
    {
      return false;
      f1 = paramMotionEvent1.getY();
    }
    while (Math.abs(paramMotionEvent2.getY() - f1) <= 100.0F);
    return true;
  }

  private void b(float paramFloat)
  {
    if ((d(paramFloat)) && (g(paramFloat)))
    {
      this.j = a.GOING_LEFT;
      this.i = paramFloat;
    }
  }

  private void c(float paramFloat)
  {
    if ((e(paramFloat)) && (f(paramFloat)))
    {
      this.j = a.GOING_RIGHT;
      this.i = paramFloat;
    }
  }

  private boolean d(float paramFloat)
  {
    if (this.f)
      return true;
    if (paramFloat >= this.i + this.c)
    {
      this.e = false;
      this.f = true;
      return true;
    }
    return false;
  }

  private void e()
  {
    this.h = (1 + this.h);
    if (this.h >= 4)
      this.j = a.FINISHED;
  }

  private boolean e(float paramFloat)
  {
    if (this.e)
      return true;
    if (paramFloat <= this.i - this.c)
    {
      this.f = false;
      this.e = true;
      e();
      return true;
    }
    return false;
  }

  private boolean f(float paramFloat)
  {
    return paramFloat > this.d;
  }

  private boolean g(float paramFloat)
  {
    return paramFloat < this.d;
  }

  void a()
  {
    a locala = this.j;
    if (locala == a.FINISHED)
    {
      this.g = new AdAlertReporter(this.k.getContext(), this.k, this.b);
      this.g.send();
    }
    b();
  }

  void b()
  {
    this.h = 0;
    this.j = a.UNSET;
  }

  void c()
  {
    this.a = false;
  }

  boolean d()
  {
    return this.a;
  }

  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.j == a.FINISHED)
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    if (a(paramMotionEvent1, paramMotionEvent2))
    {
      this.j = a.FAILED;
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    switch (1.a[this.j.ordinal()])
    {
    case 4:
    default:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      this.d = paramMotionEvent2.getX();
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      this.i = paramMotionEvent1.getX();
      a(paramMotionEvent2.getX());
      continue;
      b(paramMotionEvent2.getX());
      continue;
      c(paramMotionEvent2.getX());
    }
  }

  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    this.a = true;
    return super.onSingleTapUp(paramMotionEvent);
  }

  static enum a
  {
    static
    {
      GOING_RIGHT = new a("GOING_RIGHT", 1);
      GOING_LEFT = new a("GOING_LEFT", 2);
      FINISHED = new a("FINISHED", 3);
      FAILED = new a("FAILED", 4);
      a[] arrayOfa = new a[5];
      arrayOfa[0] = UNSET;
      arrayOfa[1] = GOING_RIGHT;
      arrayOfa[2] = GOING_LEFT;
      arrayOfa[3] = FINISHED;
      arrayOfa[4] = FAILED;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.AdAlertGestureListener
 * JD-Core Version:    0.6.2
 */