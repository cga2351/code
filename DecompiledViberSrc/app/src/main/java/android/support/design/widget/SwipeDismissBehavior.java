package android.support.design.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V>
{
  private static final float DEFAULT_ALPHA_END_DISTANCE = 0.5F;
  private static final float DEFAULT_ALPHA_START_DISTANCE = 0.0F;
  private static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5F;
  public static final int STATE_DRAGGING = 1;
  public static final int STATE_IDLE = 0;
  public static final int STATE_SETTLING = 2;
  public static final int SWIPE_DIRECTION_ANY = 2;
  public static final int SWIPE_DIRECTION_END_TO_START = 1;
  public static final int SWIPE_DIRECTION_START_TO_END;
  float alphaEndSwipeDistance = 0.5F;
  float alphaStartSwipeDistance = 0.0F;
  private final ViewDragHelper.Callback dragCallback = new ViewDragHelper.Callback()
  {
    private static final int INVALID_POINTER_ID = -1;
    private int activePointerId = -1;
    private int originalCapturedViewLeft;

    private boolean shouldDismiss(View paramAnonymousView, float paramAnonymousFloat)
    {
      int k;
      if (paramAnonymousFloat != 0.0F)
        if (ViewCompat.getLayoutDirection(paramAnonymousView) == 1)
        {
          k = 1;
          if (SwipeDismissBehavior.this.swipeDirection != 2)
            break label36;
        }
      label36: label59: label67: label91: int i;
      int j;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return true;
                k = 0;
                break;
                if (SwipeDismissBehavior.this.swipeDirection != 0)
                  break label67;
                if (k == 0)
                  break label59;
              }
              while (paramAnonymousFloat < 0.0F);
              return false;
            }
            while (paramAnonymousFloat > 0.0F);
            return false;
            if (SwipeDismissBehavior.this.swipeDirection != 1)
              break label138;
            if (k == 0)
              break label91;
          }
          while (paramAnonymousFloat > 0.0F);
          return false;
        }
        while (paramAnonymousFloat < 0.0F);
        return false;
        i = paramAnonymousView.getLeft() - this.originalCapturedViewLeft;
        j = Math.round(paramAnonymousView.getWidth() * SwipeDismissBehavior.this.dragDismissThreshold);
      }
      while (Math.abs(i) >= j);
      return false;
      label138: return false;
    }

    public int clampViewPositionHorizontal(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      int i;
      int j;
      int k;
      if (ViewCompat.getLayoutDirection(paramAnonymousView) == 1)
      {
        i = 1;
        if (SwipeDismissBehavior.this.swipeDirection != 0)
          break label78;
        if (i == 0)
          break label58;
        j = this.originalCapturedViewLeft - paramAnonymousView.getWidth();
        k = this.originalCapturedViewLeft;
      }
      while (true)
      {
        return SwipeDismissBehavior.clamp(j, paramAnonymousInt1, k);
        i = 0;
        break;
        label58: j = this.originalCapturedViewLeft;
        k = this.originalCapturedViewLeft + paramAnonymousView.getWidth();
        continue;
        label78: if (SwipeDismissBehavior.this.swipeDirection == 1)
        {
          if (i != 0)
          {
            j = this.originalCapturedViewLeft;
            k = this.originalCapturedViewLeft + paramAnonymousView.getWidth();
          }
          else
          {
            j = this.originalCapturedViewLeft - paramAnonymousView.getWidth();
            k = this.originalCapturedViewLeft;
          }
        }
        else
        {
          j = this.originalCapturedViewLeft - paramAnonymousView.getWidth();
          k = this.originalCapturedViewLeft + paramAnonymousView.getWidth();
        }
      }
    }

    public int clampViewPositionVertical(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      return paramAnonymousView.getTop();
    }

    public int getViewHorizontalDragRange(View paramAnonymousView)
    {
      return paramAnonymousView.getWidth();
    }

    public void onViewCaptured(View paramAnonymousView, int paramAnonymousInt)
    {
      this.activePointerId = paramAnonymousInt;
      this.originalCapturedViewLeft = paramAnonymousView.getLeft();
      ViewParent localViewParent = paramAnonymousView.getParent();
      if (localViewParent != null)
        localViewParent.requestDisallowInterceptTouchEvent(true);
    }

    public void onViewDragStateChanged(int paramAnonymousInt)
    {
      if (SwipeDismissBehavior.this.listener != null)
        SwipeDismissBehavior.this.listener.onDragStateChanged(paramAnonymousInt);
    }

    public void onViewPositionChanged(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
    {
      float f1 = this.originalCapturedViewLeft + paramAnonymousView.getWidth() * SwipeDismissBehavior.this.alphaStartSwipeDistance;
      float f2 = this.originalCapturedViewLeft + paramAnonymousView.getWidth() * SwipeDismissBehavior.this.alphaEndSwipeDistance;
      if (paramAnonymousInt1 <= f1)
      {
        paramAnonymousView.setAlpha(1.0F);
        return;
      }
      if (paramAnonymousInt1 >= f2)
      {
        paramAnonymousView.setAlpha(0.0F);
        return;
      }
      paramAnonymousView.setAlpha(SwipeDismissBehavior.clamp(0.0F, 1.0F - SwipeDismissBehavior.fraction(f1, f2, paramAnonymousInt1), 1.0F));
    }

    public void onViewReleased(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      this.activePointerId = -1;
      int i = paramAnonymousView.getWidth();
      int k;
      int j;
      boolean bool;
      if (shouldDismiss(paramAnonymousView, paramAnonymousFloat1))
        if (paramAnonymousView.getLeft() < this.originalCapturedViewLeft)
        {
          k = this.originalCapturedViewLeft - i;
          j = k;
          bool = true;
          label47: if (!SwipeDismissBehavior.this.viewDragHelper.settleCapturedViewAt(j, paramAnonymousView.getTop()))
            break label109;
          ViewCompat.postOnAnimation(paramAnonymousView, new SwipeDismissBehavior.SettleRunnable(SwipeDismissBehavior.this, paramAnonymousView, bool));
        }
      label109: 
      while ((!bool) || (SwipeDismissBehavior.this.listener == null))
      {
        return;
        k = i + this.originalCapturedViewLeft;
        break;
        j = this.originalCapturedViewLeft;
        bool = false;
        break label47;
      }
      SwipeDismissBehavior.this.listener.onDismiss(paramAnonymousView);
    }

    public boolean tryCaptureView(View paramAnonymousView, int paramAnonymousInt)
    {
      return (this.activePointerId == -1) && (SwipeDismissBehavior.this.canSwipeDismissView(paramAnonymousView));
    }
  };
  float dragDismissThreshold = 0.5F;
  private boolean interceptingEvents;
  OnDismissListener listener;
  private float sensitivity = 0.0F;
  private boolean sensitivitySet;
  int swipeDirection = 2;
  ViewDragHelper viewDragHelper;

  static float clamp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.min(Math.max(paramFloat1, paramFloat2), paramFloat3);
  }

  static int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.min(Math.max(paramInt1, paramInt2), paramInt3);
  }

  private void ensureViewDragHelper(ViewGroup paramViewGroup)
  {
    if (this.viewDragHelper == null)
      if (!this.sensitivitySet)
        break label33;
    label33: for (ViewDragHelper localViewDragHelper = ViewDragHelper.create(paramViewGroup, this.sensitivity, this.dragCallback); ; localViewDragHelper = ViewDragHelper.create(paramViewGroup, this.dragCallback))
    {
      this.viewDragHelper = localViewDragHelper;
      return;
    }
  }

  static float fraction(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1);
  }

  public boolean canSwipeDismissView(View paramView)
  {
    return true;
  }

  public int getDragState()
  {
    if (this.viewDragHelper != null)
      return this.viewDragHelper.getViewDragState();
    return 0;
  }

  public boolean onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    boolean bool1 = this.interceptingEvents;
    switch (paramMotionEvent.getActionMasked())
    {
    case 2:
    default:
    case 0:
    case 1:
    case 3:
    }
    while (true)
    {
      boolean bool2 = false;
      if (bool1)
      {
        ensureViewDragHelper(paramCoordinatorLayout);
        bool2 = this.viewDragHelper.shouldInterceptTouchEvent(paramMotionEvent);
      }
      return bool2;
      this.interceptingEvents = paramCoordinatorLayout.isPointInChildBounds(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      bool1 = this.interceptingEvents;
      continue;
      this.interceptingEvents = false;
    }
  }

  public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.viewDragHelper != null)
    {
      this.viewDragHelper.processTouchEvent(paramMotionEvent);
      return true;
    }
    return false;
  }

  public void setDragDismissDistance(float paramFloat)
  {
    this.dragDismissThreshold = clamp(0.0F, paramFloat, 1.0F);
  }

  public void setEndAlphaSwipeDistance(float paramFloat)
  {
    this.alphaEndSwipeDistance = clamp(0.0F, paramFloat, 1.0F);
  }

  public void setListener(OnDismissListener paramOnDismissListener)
  {
    this.listener = paramOnDismissListener;
  }

  public void setSensitivity(float paramFloat)
  {
    this.sensitivity = paramFloat;
    this.sensitivitySet = true;
  }

  public void setStartAlphaSwipeDistance(float paramFloat)
  {
    this.alphaStartSwipeDistance = clamp(0.0F, paramFloat, 1.0F);
  }

  public void setSwipeDirection(int paramInt)
  {
    this.swipeDirection = paramInt;
  }

  public static abstract interface OnDismissListener
  {
    public abstract void onDismiss(View paramView);

    public abstract void onDragStateChanged(int paramInt);
  }

  private class SettleRunnable
    implements Runnable
  {
    private final boolean dismiss;
    private final View view;

    SettleRunnable(View paramBoolean, boolean arg3)
    {
      this.view = paramBoolean;
      boolean bool;
      this.dismiss = bool;
    }

    public void run()
    {
      if ((SwipeDismissBehavior.this.viewDragHelper != null) && (SwipeDismissBehavior.this.viewDragHelper.continueSettling(true)))
        ViewCompat.postOnAnimation(this.view, this);
      while ((!this.dismiss) || (SwipeDismissBehavior.this.listener == null))
        return;
      SwipeDismissBehavior.this.listener.onDismiss(this.view);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.SwipeDismissBehavior
 * JD-Core Version:    0.6.2
 */