package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;

public class au extends FrameLayout
{
  private final int a;
  private final BitmapDrawable b;
  private final int c;
  private final int d;
  private final int e;
  private final Rect f = new Rect();
  private final Rect g = new Rect();
  private final Rect h = new Rect();
  private final Rect i = new Rect();
  private final bj j;
  private a k;
  private boolean l;
  private boolean m;
  private int n = 8388661;

  public au(Context paramContext)
  {
    super(paramContext);
    this.j = bj.a(paramContext);
    this.b = new BitmapDrawable(ap.a(this.j.c(30)));
    this.b.setState(EMPTY_STATE_SET);
    this.b.setCallback(this);
    this.a = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.c = bj.a(50, paramContext);
    this.d = bj.a(30, paramContext);
    this.e = bj.a(8, paramContext);
    setWillNotDraw(false);
  }

  private void b()
  {
    playSoundEffect(0);
    if (this.k != null)
      this.k.a();
  }

  private void b(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    Gravity.apply(this.n, paramInt, paramInt, paramRect1, paramRect2);
  }

  public void a(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    Gravity.apply(paramInt, this.d, this.d, paramRect1, paramRect2);
  }

  public boolean a()
  {
    return this.b.isVisible();
  }

  boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 >= this.g.left - paramInt3) && (paramInt2 >= this.g.top - paramInt3) && (paramInt1 < paramInt3 + this.g.right) && (paramInt2 < paramInt3 + this.g.bottom);
  }

  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.l)
    {
      this.l = false;
      this.f.set(0, 0, getWidth(), getHeight());
      b(this.c, this.f, this.g);
      this.i.set(this.g);
      this.i.inset(this.e, this.e);
      b(this.d, this.i, this.h);
      this.b.setBounds(this.h);
    }
    if (this.b.isVisible())
      this.b.draw(paramCanvas);
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 0)
      return false;
    return a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), 0);
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.l = true;
  }

  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), this.a))
    {
      super.onTouchEvent(paramMotionEvent);
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    case 2:
    default:
    case 0:
    case 3:
    case 1:
    }
    while (true)
    {
      return true;
      this.m = true;
      continue;
      this.m = false;
      continue;
      if (this.m)
      {
        b();
        this.m = false;
      }
    }
  }

  void setCloseBounds(Rect paramRect)
  {
    this.g.set(paramRect);
  }

  public void setCloseGravity(int paramInt)
  {
    this.n = paramInt;
  }

  public void setCloseVisible(boolean paramBoolean)
  {
    if (this.b.setVisible(paramBoolean, false))
      invalidate(this.g);
  }

  public void setOnCloseListener(a parama)
  {
    this.k = parama;
  }

  public static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.au
 * JD-Core Version:    0.6.2
 */