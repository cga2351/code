package android.support.v7.widget;

import android.os.SystemClock;
import android.support.v7.view.menu.s;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;

public abstract class ForwardingListener
  implements View.OnAttachStateChangeListener, View.OnTouchListener
{
  private int mActivePointerId;
  private Runnable mDisallowIntercept;
  private boolean mForwarding;
  private final int mLongPressTimeout;
  private final float mScaledTouchSlop;
  final View mSrc;
  private final int mTapTimeout;
  private final int[] mTmpLocation = new int[2];
  private Runnable mTriggerLongPress;

  public ForwardingListener(View paramView)
  {
    this.mSrc = paramView;
    paramView.setLongClickable(true);
    paramView.addOnAttachStateChangeListener(this);
    this.mScaledTouchSlop = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    this.mTapTimeout = ViewConfiguration.getTapTimeout();
    this.mLongPressTimeout = ((this.mTapTimeout + ViewConfiguration.getLongPressTimeout()) / 2);
  }

  private void clearCallbacks()
  {
    if (this.mTriggerLongPress != null)
      this.mSrc.removeCallbacks(this.mTriggerLongPress);
    if (this.mDisallowIntercept != null)
      this.mSrc.removeCallbacks(this.mDisallowIntercept);
  }

  private boolean onTouchForwarded(MotionEvent paramMotionEvent)
  {
    View localView = this.mSrc;
    s locals = getPopup();
    if ((locals == null) || (!locals.isShowing()));
    DropDownListView localDropDownListView;
    do
    {
      return false;
      localDropDownListView = (DropDownListView)locals.getListView();
    }
    while ((localDropDownListView == null) || (!localDropDownListView.isShown()));
    MotionEvent localMotionEvent = MotionEvent.obtainNoHistory(paramMotionEvent);
    toGlobalMotionEvent(localView, localMotionEvent);
    toLocalMotionEvent(localDropDownListView, localMotionEvent);
    boolean bool1 = localDropDownListView.onForwardedEvent(localMotionEvent, this.mActivePointerId);
    localMotionEvent.recycle();
    int i = paramMotionEvent.getActionMasked();
    int j;
    if ((i != 1) && (i != 3))
    {
      j = 1;
      if ((!bool1) || (j == 0))
        break label133;
    }
    label133: for (boolean bool2 = true; ; bool2 = false)
    {
      return bool2;
      j = 0;
      break;
    }
  }

  private boolean onTouchObserved(MotionEvent paramMotionEvent)
  {
    View localView = this.mSrc;
    if (!localView.isEnabled());
    int i;
    do
    {
      return false;
      switch (paramMotionEvent.getActionMasked())
      {
      default:
        return false;
      case 0:
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        if (this.mDisallowIntercept == null)
          this.mDisallowIntercept = new DisallowIntercept();
        localView.postDelayed(this.mDisallowIntercept, this.mTapTimeout);
        if (this.mTriggerLongPress == null)
          this.mTriggerLongPress = new TriggerLongPress();
        localView.postDelayed(this.mTriggerLongPress, this.mLongPressTimeout);
        return false;
      case 2:
        i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      case 1:
      case 3:
      }
    }
    while ((i < 0) || (pointInView(localView, paramMotionEvent.getX(i), paramMotionEvent.getY(i), this.mScaledTouchSlop)));
    clearCallbacks();
    localView.getParent().requestDisallowInterceptTouchEvent(true);
    return true;
    clearCallbacks();
    return false;
  }

  private static boolean pointInView(View paramView, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat1 >= -paramFloat3) && (paramFloat2 >= -paramFloat3) && (paramFloat1 < paramFloat3 + (paramView.getRight() - paramView.getLeft())) && (paramFloat2 < paramFloat3 + (paramView.getBottom() - paramView.getTop()));
  }

  private boolean toGlobalMotionEvent(View paramView, MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = this.mTmpLocation;
    paramView.getLocationOnScreen(arrayOfInt);
    paramMotionEvent.offsetLocation(arrayOfInt[0], arrayOfInt[1]);
    return true;
  }

  private boolean toLocalMotionEvent(View paramView, MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = this.mTmpLocation;
    paramView.getLocationOnScreen(arrayOfInt);
    paramMotionEvent.offsetLocation(-arrayOfInt[0], -arrayOfInt[1]);
    return true;
  }

  public abstract s getPopup();

  protected boolean onForwardingStarted()
  {
    s locals = getPopup();
    if ((locals != null) && (!locals.isShowing()))
      locals.show();
    return true;
  }

  protected boolean onForwardingStopped()
  {
    s locals = getPopup();
    if ((locals != null) && (locals.isShowing()))
      locals.dismiss();
    return true;
  }

  void onLongPress()
  {
    clearCallbacks();
    View localView = this.mSrc;
    if ((!localView.isEnabled()) || (localView.isLongClickable()));
    while (!onForwardingStarted())
      return;
    localView.getParent().requestDisallowInterceptTouchEvent(true);
    long l = SystemClock.uptimeMillis();
    MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
    localView.onTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
    this.mForwarding = true;
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool1 = this.mForwarding;
    boolean bool3;
    if (bool1)
    {
      if ((onTouchForwarded(paramMotionEvent)) || (!onForwardingStopped()));
      for (bool3 = true; ; bool3 = false)
      {
        this.mForwarding = bool3;
        boolean bool4;
        if (!bool3)
        {
          bool4 = false;
          if (!bool1);
        }
        else
        {
          bool4 = true;
        }
        return bool4;
      }
    }
    if ((onTouchObserved(paramMotionEvent)) && (onForwardingStarted()));
    for (boolean bool2 = true; ; bool2 = false)
    {
      if (bool2)
      {
        long l = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        this.mSrc.onTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
      }
      bool3 = bool2;
      break;
    }
  }

  public void onViewAttachedToWindow(View paramView)
  {
  }

  public void onViewDetachedFromWindow(View paramView)
  {
    this.mForwarding = false;
    this.mActivePointerId = -1;
    if (this.mDisallowIntercept != null)
      this.mSrc.removeCallbacks(this.mDisallowIntercept);
  }

  private class DisallowIntercept
    implements Runnable
  {
    DisallowIntercept()
    {
    }

    public void run()
    {
      ViewParent localViewParent = ForwardingListener.this.mSrc.getParent();
      if (localViewParent != null)
        localViewParent.requestDisallowInterceptTouchEvent(true);
    }
  }

  private class TriggerLongPress
    implements Runnable
  {
    TriggerLongPress()
    {
    }

    public void run()
    {
      ForwardingListener.this.onLongPress();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ForwardingListener
 * JD-Core Version:    0.6.2
 */