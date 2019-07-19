package android.support.design.widget;

import android.content.Context;
import android.support.v4.math.MathUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;

abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V>
{
  private static final int INVALID_POINTER = -1;
  private int activePointerId = -1;
  private Runnable flingRunnable;
  private boolean isBeingDragged;
  private int lastMotionY;
  OverScroller scroller;
  private int touchSlop = -1;
  private VelocityTracker velocityTracker;

  public HeaderBehavior()
  {
  }

  public HeaderBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void ensureVelocityTracker()
  {
    if (this.velocityTracker == null)
      this.velocityTracker = VelocityTracker.obtain();
  }

  boolean canDragView(V paramV)
  {
    return false;
  }

  final boolean fling(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, float paramFloat)
  {
    if (this.flingRunnable != null)
    {
      paramV.removeCallbacks(this.flingRunnable);
      this.flingRunnable = null;
    }
    if (this.scroller == null)
      this.scroller = new OverScroller(paramV.getContext());
    this.scroller.fling(0, getTopAndBottomOffset(), 0, Math.round(paramFloat), 0, 0, paramInt1, paramInt2);
    if (this.scroller.computeScrollOffset())
    {
      this.flingRunnable = new FlingRunnable(paramCoordinatorLayout, paramV);
      ViewCompat.postOnAnimation(paramV, this.flingRunnable);
      return true;
    }
    onFlingFinished(paramCoordinatorLayout, paramV);
    return false;
  }

  int getMaxDragOffset(V paramV)
  {
    return -paramV.getHeight();
  }

  int getScrollRangeForDragFling(V paramV)
  {
    return paramV.getHeight();
  }

  int getTopBottomOffsetForScrollingSibling()
  {
    return getTopAndBottomOffset();
  }

  void onFlingFinished(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
  }

  public boolean onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.touchSlop < 0)
      this.touchSlop = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    if ((paramMotionEvent.getAction() == 2) && (this.isBeingDragged))
      return true;
    switch (paramMotionEvent.getActionMasked())
    {
    default:
    case 0:
    case 2:
    case 1:
    case 3:
    }
    while (true)
    {
      if (this.velocityTracker != null)
        this.velocityTracker.addMovement(paramMotionEvent);
      return this.isBeingDragged;
      this.isBeingDragged = false;
      int m = (int)paramMotionEvent.getX();
      int n = (int)paramMotionEvent.getY();
      if ((canDragView(paramV)) && (paramCoordinatorLayout.isPointInChildBounds(paramV, m, n)))
      {
        this.lastMotionY = n;
        this.activePointerId = paramMotionEvent.getPointerId(0);
        ensureVelocityTracker();
        continue;
        int i = this.activePointerId;
        if (i != -1)
        {
          int j = paramMotionEvent.findPointerIndex(i);
          if (j != -1)
          {
            int k = (int)paramMotionEvent.getY(j);
            if (Math.abs(k - this.lastMotionY) > this.touchSlop)
            {
              this.isBeingDragged = true;
              this.lastMotionY = k;
              continue;
              this.isBeingDragged = false;
              this.activePointerId = -1;
              if (this.velocityTracker != null)
              {
                this.velocityTracker.recycle();
                this.velocityTracker = null;
              }
            }
          }
        }
      }
    }
  }

  public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.touchSlop < 0)
      this.touchSlop = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    switch (paramMotionEvent.getActionMasked())
    {
    default:
    case 0:
    case 2:
    case 1:
    case 3:
    }
    while (true)
    {
      if (this.velocityTracker != null)
        this.velocityTracker.addMovement(paramMotionEvent);
      boolean bool1 = true;
      int i;
      do
      {
        int n;
        boolean bool3;
        do
        {
          boolean bool2;
          do
          {
            return bool1;
            int m = (int)paramMotionEvent.getX();
            n = (int)paramMotionEvent.getY();
            bool2 = paramCoordinatorLayout.isPointInChildBounds(paramV, m, n);
            bool1 = false;
          }
          while (!bool2);
          bool3 = canDragView(paramV);
          bool1 = false;
        }
        while (!bool3);
        this.lastMotionY = n;
        this.activePointerId = paramMotionEvent.getPointerId(0);
        ensureVelocityTracker();
        break;
        i = paramMotionEvent.findPointerIndex(this.activePointerId);
        bool1 = false;
      }
      while (i == -1);
      int j = (int)paramMotionEvent.getY(i);
      int k = this.lastMotionY - j;
      if ((!this.isBeingDragged) && (Math.abs(k) > this.touchSlop))
      {
        this.isBeingDragged = true;
        if (k <= 0)
          break label253;
        k -= this.touchSlop;
      }
      while (this.isBeingDragged)
      {
        this.lastMotionY = j;
        scroll(paramCoordinatorLayout, paramV, k, getMaxDragOffset(paramV), 0);
        break;
        label253: k += this.touchSlop;
      }
      if (this.velocityTracker != null)
      {
        this.velocityTracker.addMovement(paramMotionEvent);
        this.velocityTracker.computeCurrentVelocity(1000);
        float f = this.velocityTracker.getYVelocity(this.activePointerId);
        fling(paramCoordinatorLayout, paramV, -getScrollRangeForDragFling(paramV), 0, f);
      }
      this.isBeingDragged = false;
      this.activePointerId = -1;
      if (this.velocityTracker != null)
      {
        this.velocityTracker.recycle();
        this.velocityTracker = null;
      }
    }
  }

  final int scroll(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    return setHeaderTopBottomOffset(paramCoordinatorLayout, paramV, getTopBottomOffsetForScrollingSibling() - paramInt1, paramInt2, paramInt3);
  }

  int setHeaderTopBottomOffset(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    return setHeaderTopBottomOffset(paramCoordinatorLayout, paramV, paramInt, -2147483648, 2147483647);
  }

  int setHeaderTopBottomOffset(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = getTopAndBottomOffset();
    int j = 0;
    if (paramInt2 != 0)
    {
      j = 0;
      if (i >= paramInt2)
      {
        j = 0;
        if (i <= paramInt3)
        {
          int k = MathUtils.clamp(paramInt1, paramInt2, paramInt3);
          j = 0;
          if (i != k)
          {
            setTopAndBottomOffset(k);
            j = i - k;
          }
        }
      }
    }
    return j;
  }

  private class FlingRunnable
    implements Runnable
  {
    private final V layout;
    private final CoordinatorLayout parent;

    FlingRunnable(V arg2)
    {
      Object localObject1;
      this.parent = localObject1;
      Object localObject2;
      this.layout = localObject2;
    }

    public void run()
    {
      if ((this.layout != null) && (HeaderBehavior.this.scroller != null))
      {
        if (HeaderBehavior.this.scroller.computeScrollOffset())
        {
          HeaderBehavior.this.setHeaderTopBottomOffset(this.parent, this.layout, HeaderBehavior.this.scroller.getCurrY());
          ViewCompat.postOnAnimation(this.layout, this);
        }
      }
      else
        return;
      HeaderBehavior.this.onFlingFinished(this.parent, this.layout);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.HeaderBehavior
 * JD-Core Version:    0.6.2
 */