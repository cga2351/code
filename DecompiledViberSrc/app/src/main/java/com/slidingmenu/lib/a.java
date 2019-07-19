package com.slidingmenu.lib;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.ArrayList;
import java.util.List;

public class a extends ViewGroup
{
  private static final Logger e = ViberEnv.getLogger();
  private static final Interpolator f = b.a;
  private float A;
  private List<View> B = new ArrayList();
  private boolean C = false;
  private float D = 0.0F;
  protected int a = -1;
  protected VelocityTracker b;
  protected int c;
  protected int d = 0;
  private View g;
  private int h;
  private Scroller i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private int n;
  private float o;
  private float p;
  private float q;
  private int r;
  private int s;
  private c t;
  private boolean u = true;
  private a v;
  private a w;
  private SlidingMenu.c x;
  private SlidingMenu.e y;
  private SlidingMenu.g z;

  public a(Context paramContext)
  {
    this(paramContext, null);
  }

  public a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }

  private int a(float paramFloat, int paramInt1, int paramInt2)
  {
    int i1 = this.h;
    if ((Math.abs(paramInt2) > this.s) && (Math.abs(paramInt1) > this.r))
    {
      if ((paramInt1 > 0) && (paramInt2 > 0))
        i1--;
      while ((paramInt1 >= 0) || (paramInt2 >= 0))
        return i1;
      return i1 + 1;
    }
    return Math.round(paramFloat + this.h);
  }

  private int a(MotionEvent paramMotionEvent, int paramInt)
  {
    int i1 = MotionEventCompat.findPointerIndex(paramMotionEvent, paramInt);
    if (i1 == -1)
      this.a = -1;
    return i1;
  }

  private boolean a(MotionEvent paramMotionEvent)
  {
    Rect localRect = new Rect();
    int i1 = this.B.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      View localView = (View)this.B.get(i2);
      int[] arrayOfInt = new int[2];
      localView.getLocationOnScreen(arrayOfInt);
      localView.getHitRect(localRect);
      localRect.offset(arrayOfInt[0] - localView.getLeft(), arrayOfInt[1] - localView.getTop());
      if ((localView.isShown()) && (localRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())))
        return true;
    }
    return false;
  }

  private void b(MotionEvent paramMotionEvent, int paramInt)
  {
    int i1 = this.a;
    int i2 = a(paramMotionEvent, i1);
    if ((i1 == -1) || (i2 == -1));
    float f3;
    do
    {
      return;
      float f1 = MotionEventCompat.getX(paramMotionEvent, i2);
      float f2 = f1 - this.p;
      f3 = Math.abs(f2);
      float f4 = MotionEventCompat.getY(paramMotionEvent, i2);
      float f5 = Math.abs(f4 - this.q);
      int i3;
      if (c())
        i3 = this.n / 2;
      while ((f3 > i3) && (f3 > f5) && (c(f2)))
        if (c(paramMotionEvent))
        {
          this.m = false;
          return;
          i3 = this.n;
        }
        else
        {
          g();
          if (this.z != null)
            this.z.a(paramInt);
          this.p = f1;
          this.q = f4;
          setScrollingCacheEnabled(true);
          return;
        }
    }
    while (f3 <= this.n);
    this.m = true;
  }

  private boolean b(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    int i1 = (int)(paramMotionEvent.getX() + this.D);
    if (c())
      bool = this.t.a(this.g, this.h, i1);
    do
    {
      do
      {
        return bool;
        switch (this.d)
        {
        default:
          return false;
        case 1:
        case 2:
        case 0:
        }
      }
      while (!a(paramMotionEvent));
      return false;
      return false;
    }
    while ((this.t.b(this.g, i1)) && (!a(paramMotionEvent)));
    return false;
  }

  private void c(int paramInt)
  {
    int i1 = getWidth();
    int i2 = paramInt / i1;
    int i3 = paramInt % i1;
    a(i2, i3 / i1, i3);
  }

  private boolean c(float paramFloat)
  {
    if (c());
    for (boolean bool = this.t.b(paramFloat); ; bool = this.t.a(paramFloat))
    {
      Logger localLogger = e;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Boolean.valueOf(bool);
      arrayOfObject[1] = Float.valueOf(paramFloat);
      localLogger.a("this slide allowed ? dx: ?", arrayOfObject);
      return bool;
    }
  }

  private boolean c(MotionEvent paramMotionEvent)
  {
    return (this.A > 0.0F) && (this.o > this.A) && (paramMotionEvent.getX() > this.o);
  }

  private void d(MotionEvent paramMotionEvent)
  {
    e.a("onSecondaryPointerUp called", new Object[0]);
    int i1 = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i1) == this.a)
    {
      int i2 = 0;
      if (i1 == 0)
        i2 = 1;
      this.p = MotionEventCompat.getX(paramMotionEvent, i2);
      this.a = MotionEventCompat.getPointerId(paramMotionEvent, i2);
      if (this.b != null)
        this.b.clear();
    }
  }

  private void f()
  {
    if (this.k)
    {
      setScrollingCacheEnabled(false);
      this.i.abortAnimation();
      int i1 = getScrollX();
      int i2 = getScrollY();
      int i3 = this.i.getCurrX();
      int i4 = this.i.getCurrY();
      if ((i1 != i3) || (i2 != i4))
        scrollTo(i3, i4);
      if (!c())
        break label93;
      if (this.y != null)
        this.y.b();
    }
    while (true)
    {
      this.k = false;
      return;
      label93: if (this.x != null)
        this.x.a();
    }
  }

  private void g()
  {
    this.l = true;
    this.C = false;
  }

  private int getLeftBound()
  {
    return this.t.a(this.g);
  }

  private int getRightBound()
  {
    return this.t.b(this.g);
  }

  private void h()
  {
    this.C = false;
    this.l = false;
    this.m = false;
    this.a = -1;
    if (this.b != null)
    {
      this.b.recycle();
      this.b = null;
    }
  }

  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.j != paramBoolean)
      this.j = paramBoolean;
  }

  float a(float paramFloat)
  {
    return (float)Math.sin((float)(0.47123891676382D * (paramFloat - 0.5F)));
  }

  public int a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return 0;
    case 0:
    case 2:
      return this.t.a(this.g, paramInt);
    case 1:
    }
    return this.g.getLeft();
  }

  a a(a parama)
  {
    a locala = this.w;
    this.w = parama;
    return locala;
  }

  void a()
  {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context localContext = getContext();
    this.i = new Scroller(localContext, f);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    this.n = ViewConfigurationCompat.getScaledPagingTouchSlop(localViewConfiguration);
    this.r = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.c = localViewConfiguration.getScaledMaximumFlingVelocity();
    a(new b()
    {
      public void a(int paramAnonymousInt)
      {
        if (a.a(a.this) != null);
        switch (paramAnonymousInt)
        {
        default:
          return;
        case 0:
        case 2:
          a.a(a.this).setChildrenEnabled(true);
          return;
        case 1:
        }
        a.a(a.this).setChildrenEnabled(false);
      }
    });
    this.s = ((int)(25.0F * localContext.getResources().getDisplayMetrics().density));
  }

  protected void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.v != null)
      this.v.a(paramInt1, paramFloat, paramInt2);
    if (this.w != null)
      this.w.a(paramInt1, paramFloat, paramInt2);
  }

  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (getChildCount() == 0)
      setScrollingCacheEnabled(false);
    int i1;
    int i2;
    int i3;
    int i4;
    do
    {
      do
      {
        return;
        i1 = getScrollX();
        i2 = getScrollY();
        i3 = paramInt1 - i1;
        i4 = paramInt2 - i2;
        if ((i3 != 0) || (i4 != 0))
          break label92;
        f();
        if (!c())
          break;
      }
      while (this.y == null);
      this.y.b();
      return;
    }
    while (this.x == null);
    this.x.a();
    return;
    label92: setScrollingCacheEnabled(true);
    this.k = true;
    int i5 = getBehindWidth();
    int i6 = i5 / 2;
    float f1 = Math.min(1.0F, 1.0F * Math.abs(i3) / i5);
    float f2 = i6 + i6 * a(f1);
    int i7 = Math.abs(paramInt3);
    if (i7 > 0);
    for (int i8 = 4 * Math.round(1000.0F * Math.abs(f2 / i7)); ; i8 = 600)
    {
      int i9 = Math.min(i8, 600);
      this.i.startScroll(i1, i2, i3, i4, i9);
      invalidate();
      return;
      ((int)(100.0F * (1.0F + Math.abs(i3) / i5)));
    }
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, paramBoolean, false);
  }

  void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, paramBoolean1, paramBoolean2, 0);
  }

  void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if ((!paramBoolean2) && (this.h == paramInt1))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    int i1 = this.t.a(paramInt1);
    if (this.h != i1);
    int i3;
    for (int i2 = 1; ; i2 = 0)
    {
      this.h = i1;
      i3 = a(this.h);
      if ((i2 != 0) && (this.v != null))
        this.v.a(i1);
      if ((i2 != 0) && (this.w != null))
        this.w.a(i1);
      if (!paramBoolean1)
        break;
      a(i3, 0, paramInt2);
      return;
    }
    f();
    scrollTo(i3, 0);
  }

  public void a(View paramView)
  {
    if (!this.B.contains(paramView))
      this.B.add(paramView);
  }

  public boolean a(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0)
      switch (paramKeyEvent.getKeyCode())
      {
      default:
      case 21:
      case 22:
      case 61:
      }
    do
    {
      do
      {
        return false;
        return b(17);
        return b(66);
      }
      while (Build.VERSION.SDK_INT < 11);
      if (paramKeyEvent.hasNoModifiers())
        return b(2);
    }
    while (!paramKeyEvent.hasModifiers(1));
    return b(1);
  }

  public void b()
  {
    this.B.clear();
  }

  public void b(View paramView)
  {
    this.B.remove(paramView);
  }

  public boolean b(int paramInt)
  {
    View localView1 = findFocus();
    if (localView1 == this)
      localView1 = null;
    View localView2 = FocusFinder.getInstance().findNextFocus(this, localView1, paramInt);
    boolean bool;
    if ((localView2 != null) && (localView2 != localView1))
      if (paramInt == 17)
        bool = localView2.requestFocus();
    while (true)
    {
      if (bool)
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
      return bool;
      if (paramInt == 66)
      {
        if ((localView1 != null) && (localView2.getLeft() <= localView1.getLeft()))
        {
          bool = e();
        }
        else
        {
          bool = localView2.requestFocus();
          continue;
          if ((paramInt == 17) || (paramInt == 1))
            bool = d();
          else if ((paramInt == 66) || (paramInt == 2))
            bool = e();
        }
      }
      else
        bool = false;
    }
  }

  public boolean c()
  {
    return (this.h == 0) || (this.h == 2);
  }

  public void computeScroll()
  {
    if ((!this.i.isFinished()) && (this.i.computeScrollOffset()))
    {
      int i1 = getScrollX();
      int i2 = getScrollY();
      int i3 = this.i.getCurrX();
      int i4 = this.i.getCurrY();
      if ((i1 != i3) || (i2 != i4))
      {
        scrollTo(i3, i4);
        c(i3);
      }
      invalidate();
      return;
    }
    f();
  }

  boolean d()
  {
    if (this.h > 0)
    {
      a(-1 + this.h, true);
      return true;
    }
    return false;
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    this.t.a(this.g, paramCanvas);
    this.t.a(this.g, paramCanvas, getPercentOpen());
    this.t.b(this.g, paramCanvas, getPercentOpen());
    super.dispatchDraw(paramCanvas);
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (a(paramKeyEvent));
  }

  boolean e()
  {
    if (this.h < 1)
    {
      a(1 + this.h, true);
      return true;
    }
    return false;
  }

  public int getBehindWidth()
  {
    if (this.t == null)
      return 0;
    return this.t.getBehindWidth();
  }

  public View getContent()
  {
    return this.g;
  }

  public int getContentLeft()
  {
    return this.g.getLeft() + this.g.getPaddingLeft();
  }

  public int getCurrentItem()
  {
    return this.h;
  }

  protected float getPercentOpen()
  {
    return Math.abs(this.D - this.g.getLeft()) / getBehindWidth();
  }

  public int getTouchMode()
  {
    return this.d;
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.u)
      return false;
    int i1 = 0xFF & paramMotionEvent.getAction();
    if (i1 == 0)
      e.a("Received ACTION_DOWN", new Object[0]);
    if ((i1 == 3) || (i1 == 1) || ((i1 != 0) && (this.m)))
    {
      h();
      return false;
    }
    switch (i1)
    {
    default:
    case 2:
    case 0:
    case 6:
    }
    while (true)
    {
      if (!this.l)
      {
        if (this.b == null)
          this.b = VelocityTracker.obtain();
        this.b.addMovement(paramMotionEvent);
      }
      if ((!this.l) && ((!this.C) || (!c())))
        break;
      return true;
      if (b(paramMotionEvent))
      {
        b(paramMotionEvent, 0);
      }
      else
      {
        this.m = true;
        continue;
        int i2 = MotionEventCompat.getActionIndex(paramMotionEvent);
        this.a = MotionEventCompat.getPointerId(paramMotionEvent, i2);
        if (this.a != -1)
        {
          float f1 = MotionEventCompat.getX(paramMotionEvent, i2);
          this.o = f1;
          this.p = f1;
          this.q = MotionEventCompat.getY(paramMotionEvent, i2);
          if (b(paramMotionEvent))
          {
            this.l = false;
            this.m = false;
            if ((c()) && (this.t.b(this.g, this.h, paramMotionEvent.getX() + this.D)))
              this.C = true;
          }
          else
          {
            this.m = true;
            continue;
            d(paramMotionEvent);
          }
        }
      }
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = paramInt3 - paramInt1;
    int i2 = paramInt4 - paramInt2;
    this.g.layout(0, 0, i1, i2);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = getDefaultSize(0, paramInt1);
    int i2 = getDefaultSize(0, paramInt2);
    setMeasuredDimension(i1, i2);
    int i3 = getChildMeasureSpec(paramInt1, 0, i1);
    int i4 = getChildMeasureSpec(paramInt2, 0, i2);
    this.g.measure(i3, i4);
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
    {
      f();
      scrollTo(a(this.h), getScrollY());
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.u);
    while ((!this.l) && (!b(paramMotionEvent)))
      return false;
    int i1 = paramMotionEvent.getAction();
    if (this.b == null)
      this.b = VelocityTracker.obtain();
    this.b.addMovement(paramMotionEvent);
    float f4;
    float f5;
    float f6;
    switch (i1 & 0xFF)
    {
    case 4:
    default:
    case 0:
    case 2:
      int i6;
      do
      {
        do
        {
          while (true)
          {
            return true;
            f();
            this.a = MotionEventCompat.getPointerId(paramMotionEvent, MotionEventCompat.getActionIndex(paramMotionEvent));
            float f7 = paramMotionEvent.getX();
            this.o = f7;
            this.p = f7;
          }
          if (!this.l)
          {
            if (c(paramMotionEvent))
              break;
            b(paramMotionEvent, 1);
            if (this.m)
              break;
          }
        }
        while (!this.l);
        i6 = a(paramMotionEvent, this.a);
      }
      while (this.a == -1);
      float f2 = MotionEventCompat.getX(paramMotionEvent, i6);
      float f3 = this.p - f2;
      this.p = f2;
      f4 = f3 + getScrollX();
      f5 = getLeftBound();
      f6 = getRightBound();
      if (f4 >= f5)
        break;
    case 1:
    case 3:
    case 5:
    case 6:
    }
    while (true)
    {
      this.p += f5 - (int)f5;
      scrollTo((int)f5, getScrollY());
      c((int)f5);
      break;
      if (f4 > f6)
      {
        f5 = f6;
        continue;
        if (this.l)
        {
          VelocityTracker localVelocityTracker = this.b;
          localVelocityTracker.computeCurrentVelocity(1000, this.c);
          int i4 = (int)VelocityTrackerCompat.getXVelocity(localVelocityTracker, this.a);
          float f1 = (getScrollX() - a(this.h)) / getBehindWidth();
          int i5 = a(paramMotionEvent, this.a);
          if (this.a != -1)
            a(a(f1, i4, (int)(MotionEventCompat.getX(paramMotionEvent, i5) - this.o)), true, true, i4);
          while (true)
          {
            this.a = -1;
            h();
            break;
            a(this.h, true, true, i4);
          }
        }
        if ((!this.C) || (!this.t.b(this.g, this.h, paramMotionEvent.getX() + this.D)))
          break;
        setCurrentItem(1);
        h();
        break;
        if (!this.l)
          break;
        a(this.h, true, true);
        this.a = -1;
        h();
        break;
        int i3 = MotionEventCompat.getActionIndex(paramMotionEvent);
        this.p = MotionEventCompat.getX(paramMotionEvent, i3);
        this.a = MotionEventCompat.getPointerId(paramMotionEvent, i3);
        break;
        d(paramMotionEvent);
        int i2 = a(paramMotionEvent, this.a);
        if (this.a == -1)
          break;
        this.p = MotionEventCompat.getX(paramMotionEvent, i2);
        break;
      }
      f5 = f4;
    }
  }

  public void scrollTo(int paramInt1, int paramInt2)
  {
    super.scrollTo(paramInt1, paramInt2);
    this.D = paramInt1;
    if (this.u)
      this.t.a(this.g, paramInt1, paramInt2);
    ViewParent localViewParent = getParent();
    if (localViewParent != null)
      ((SlidingMenu)localViewParent).a(getPercentOpen());
  }

  public void setAboveOffset(int paramInt)
  {
    this.g.setPadding(paramInt, this.g.getPaddingTop(), this.g.getPaddingRight(), this.g.getPaddingBottom());
  }

  public void setContent(View paramView)
  {
    if (this.g != null)
      removeView(this.g);
    this.g = paramView;
    addView(this.g);
  }

  public void setCurrentItem(int paramInt)
  {
    a(paramInt, true, false);
  }

  public void setCustomViewBehind(c paramc)
  {
    this.t = paramc;
  }

  public void setDragListener(SlidingMenu.g paramg)
  {
    this.z = paramg;
  }

  public void setOnClosedListener(SlidingMenu.c paramc)
  {
    this.x = paramc;
  }

  public void setOnOpenedListener(SlidingMenu.e parame)
  {
    this.y = parame;
  }

  public void setOnPageChangeListener(a parama)
  {
    this.v = parama;
  }

  public void setRightSwipeInitialAvailableArea(float paramFloat)
  {
    this.A = paramFloat;
  }

  public void setSlidingEnabled(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }

  public void setTouchMode(int paramInt)
  {
    this.d = paramInt;
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt);

    public abstract void a(int paramInt1, float paramFloat, int paramInt2);
  }

  public static class b
    implements a.a
  {
    public void a(int paramInt)
    {
    }

    public void a(int paramInt1, float paramFloat, int paramInt2)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.slidingmenu.lib.a
 * JD-Core Version:    0.6.2
 */