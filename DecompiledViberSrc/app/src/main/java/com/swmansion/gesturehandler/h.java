package com.swmansion.gesturehandler;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class h extends b<h>
{
  private boolean d;
  private boolean e;

  public h()
  {
    a(true);
  }

  private static boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    return ((paramView instanceof ViewGroup)) && (((ViewGroup)paramView).onInterceptTouchEvent(paramMotionEvent));
  }

  protected void a()
  {
    long l = SystemClock.uptimeMillis();
    MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
    localMotionEvent.setAction(3);
    e().onTouchEvent(localMotionEvent);
  }

  protected void a(MotionEvent paramMotionEvent)
  {
    View localView = e();
    int i = i();
    if (paramMotionEvent.getActionMasked() == 1)
    {
      localView.onTouchEvent(paramMotionEvent);
      if (((i == 0) || (i == 2)) && (localView.isPressed()))
        l();
      n();
    }
    do
    {
      do
      {
        return;
        if ((i != 0) && (i != 2))
          break;
        if (this.d)
        {
          a(localView, paramMotionEvent);
          localView.onTouchEvent(paramMotionEvent);
          l();
          return;
        }
        if (a(localView, paramMotionEvent))
        {
          localView.onTouchEvent(paramMotionEvent);
          l();
          return;
        }
      }
      while (i == 2);
      m();
      return;
    }
    while (i != 4);
    localView.onTouchEvent(paramMotionEvent);
  }

  public boolean b(b paramb)
  {
    return super.b(paramb);
  }

  public h c(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }

  public h d(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }

  public boolean d(b paramb)
  {
    boolean bool1 = true;
    if ((paramb instanceof h))
    {
      h localh = (h)paramb;
      if ((localh.i() != 4) || (!localh.e));
    }
    boolean bool2;
    int i;
    int j;
    do
    {
      return false;
      if (this.e)
        break;
      bool2 = bool1;
      i = i();
      j = paramb.i();
    }
    while ((i == 4) && (j == 4) && (bool2));
    if ((i == 4) && (bool2));
    while (true)
    {
      return bool1;
      bool2 = false;
      break;
      bool1 = false;
    }
  }

  public boolean e(b paramb)
  {
    return !this.e;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.swmansion.gesturehandler.h
 * JD-Core Version:    0.6.2
 */