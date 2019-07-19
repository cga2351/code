package com.viber.voip.widget.b;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

public class a
  implements c.a
{
  private final View a;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private final Rect f = new Rect();

  a(View paramView, int paramInt)
  {
    this(paramView, paramInt, paramInt, paramInt, paramInt);
  }

  a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramView;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    if (this.a.getVisibility() == 8);
    do
    {
      return false;
      this.f.left = (this.a.getLeft() - this.b);
      this.f.top = (this.a.getTop() - this.c);
      this.f.right = (this.a.getRight() + this.d);
      this.f.bottom = (this.a.getBottom() + this.e);
    }
    while (!this.f.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()));
    paramMotionEvent.setLocation(this.a.getWidth() / 2.0F, this.a.getHeight() / 2.0F);
    this.a.dispatchTouchEvent(paramMotionEvent);
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.b.a
 * JD-Core Version:    0.6.2
 */