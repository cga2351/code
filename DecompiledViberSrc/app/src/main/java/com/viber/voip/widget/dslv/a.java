package com.viber.voip.widget.dslv;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

public class a extends d
  implements GestureDetector.OnGestureListener, View.OnTouchListener
{
  protected MotionEvent a = null;
  private int b = 0;
  private boolean c = true;
  private int d;
  private boolean e = false;
  private boolean f = false;
  private GestureDetector g;
  private GestureDetector h;
  private int i;
  private int j = -1;
  private int k = -1;
  private int l = -1;
  private int[] m = new int[2];
  private int n;
  private int o;
  private int p;
  private int q;
  private boolean r = false;
  private float s = 500.0F;
  private int t;
  private int u;
  private int v;
  private boolean w;
  private DragSortListView x;
  private int y;
  private GestureDetector.OnGestureListener z = new GestureDetector.SimpleOnGestureListener()
  {
    public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      int i;
      if ((a.a(a.this)) && (a.b(a.this)))
      {
        i = a.c(a.this).getWidth() / 5;
        if (paramAnonymousFloat1 <= a.d(a.this))
          break label83;
        if (a.e(a.this) > -i)
          a.c(a.this).a(true, paramAnonymousFloat1);
      }
      while (true)
      {
        a.a(a.this, false);
        return false;
        label83: if ((paramAnonymousFloat1 < -a.d(a.this)) && (a.e(a.this) < i))
          a.c(a.this).a(true, paramAnonymousFloat1);
      }
    }
  };

  public a(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramDragSortListView, paramInt1, paramInt2, paramInt3, 0);
  }

  public a(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramDragSortListView, paramInt1, paramInt2, paramInt3, paramInt4, 0);
  }

  public a(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramDragSortListView);
    this.x = paramDragSortListView;
    this.g = new GestureDetector(paramDragSortListView.getContext(), this);
    this.h = new GestureDetector(paramDragSortListView.getContext(), this.z);
    this.h.setIsLongpressEnabled(false);
    this.i = ViewConfiguration.get(paramDragSortListView.getContext()).getScaledTouchSlop();
    this.t = paramInt1;
    this.u = paramInt4;
    this.v = paramInt5;
    c(paramInt3);
    b(paramInt2);
  }

  public int a(MotionEvent paramMotionEvent)
  {
    return c(paramMotionEvent);
  }

  public int a(MotionEvent paramMotionEvent, int paramInt)
  {
    int i1 = (int)paramMotionEvent.getX();
    int i2 = (int)paramMotionEvent.getY();
    int i3 = this.x.pointToPosition(i1, i2);
    int i4 = this.x.getHeaderViewsCount();
    int i5 = this.x.getFooterViewsCount();
    int i6 = this.x.getCount();
    if ((i3 != -1) && (i3 >= i4) && (i3 < i6 - i5))
    {
      View localView1 = this.x.getChildAt(i3 - this.x.getFirstVisiblePosition());
      int i7 = (int)paramMotionEvent.getRawX();
      int i8 = (int)paramMotionEvent.getRawY();
      if (paramInt == 0);
      for (View localView2 = localView1; localView2 != null; localView2 = localView1.findViewById(paramInt))
      {
        localView2.getLocationOnScreen(this.m);
        if ((i7 <= this.m[0]) || (i8 <= this.m[1]) || (i7 >= this.m[0] + localView2.getWidth()) || (i8 >= this.m[1] + localView2.getHeight()))
          break;
        this.n = localView1.getLeft();
        this.o = localView1.getTop();
        return i3;
      }
    }
    return -1;
  }

  public void a(View paramView, Point paramPoint1, Point paramPoint2)
  {
    if ((this.e) && (this.f))
      this.y = paramPoint1.x;
  }

  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool1 = this.c;
    int i1 = 0;
    if (bool1)
    {
      boolean bool2 = this.f;
      i1 = 0;
      if (!bool2)
        i1 = 12;
    }
    if ((this.e) && (this.f))
      i1 = 0x2 | (i1 | 0x1);
    this.r = this.x.a(paramInt1 - this.x.getHeaderViewsCount(), i1, paramInt2, paramInt3);
    return this.r;
  }

  public int b(MotionEvent paramMotionEvent)
  {
    if (this.d == 1)
      return d(paramMotionEvent);
    return -1;
  }

  public void b(int paramInt)
  {
    this.b = paramInt;
  }

  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }

  public int c(MotionEvent paramMotionEvent)
  {
    return a(paramMotionEvent, this.t);
  }

  public void c(int paramInt)
  {
    this.d = paramInt;
  }

  public int d(MotionEvent paramMotionEvent)
  {
    return a(paramMotionEvent, this.v);
  }

  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if ((this.e) && (this.d == 0))
      this.l = a(paramMotionEvent, this.u);
    this.j = a(paramMotionEvent);
    if ((this.j != -1) && (this.b == 0))
      a(this.j, (int)paramMotionEvent.getX() - this.n, (int)paramMotionEvent.getY() - this.o);
    this.f = false;
    this.w = true;
    this.y = 0;
    this.k = b(paramMotionEvent);
    return true;
  }

  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }

  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((this.j != -1) && (this.b == 2))
    {
      this.x.performHapticFeedback(0);
      a(this.j, this.p - this.n, this.q - this.o);
    }
  }

  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (paramMotionEvent1 == null)
    {
      paramMotionEvent1 = this.a;
      if ((paramMotionEvent1 != null) && (paramMotionEvent2 != null))
        break label27;
    }
    label27: int i2;
    int i4;
    label205: 
    do
    {
      int i1;
      int i3;
      int i5;
      int i6;
      do
      {
        do
        {
          do
          {
            return false;
            this.a = paramMotionEvent1;
            break;
            i1 = (int)paramMotionEvent1.getX();
            i2 = (int)paramMotionEvent1.getY();
            i3 = (int)paramMotionEvent2.getX();
            i4 = (int)paramMotionEvent2.getY();
            i5 = i3 - this.n;
            i6 = i4 - this.o;
          }
          while ((!this.w) || (this.r) || ((this.j == -1) && (this.k == -1)));
          if (this.j == -1)
            break label205;
          if ((this.b == 1) && (Math.abs(i4 - i2) > this.i) && (this.c))
          {
            a(this.j, i5, i6);
            return false;
          }
        }
        while ((this.b == 0) || (Math.abs(i3 - i1) <= this.i) || (!this.e));
        this.f = true;
        a(this.k, i5, i6);
        return false;
      }
      while (this.k == -1);
      if ((Math.abs(i3 - i1) > this.i) && (this.e))
      {
        this.f = true;
        a(this.k, i5, i6);
        return false;
      }
    }
    while (Math.abs(i4 - i2) <= this.i);
    this.w = false;
    return false;
  }

  public void onShowPress(MotionEvent paramMotionEvent)
  {
  }

  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if ((this.e) && (this.d == 0) && (this.l != -1))
      this.x.a(this.l - this.x.getHeaderViewsCount());
    return true;
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((!this.x.c()) || (this.x.b()))
      return false;
    this.g.onTouchEvent(paramMotionEvent);
    if ((this.e) && (this.r) && (this.d == 1))
      this.h.onTouchEvent(paramMotionEvent);
    switch (0xFF & paramMotionEvent.getAction())
    {
    case 2:
    default:
      return false;
    case 0:
      this.p = ((int)paramMotionEvent.getX());
      this.q = ((int)paramMotionEvent.getY());
      return false;
    case 1:
      if ((this.e) && (this.f))
        if (this.y < 0)
          break label185;
      break;
    case 3:
    }
    label185: for (int i1 = this.y; ; i1 = -this.y)
    {
      if (i1 > this.x.getWidth() / 2)
        this.x.a(true, 0.0F);
      this.f = false;
      this.r = false;
      return false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.dslv.a
 * JD-Core Version:    0.6.2
 */