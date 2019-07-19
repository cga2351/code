package com.appboy.ui.inappmessage.listeners;

import android.view.MotionEvent;
import android.view.View;

public class TouchAwareSwipeDismissTouchListener extends SwipeDismissTouchListener
{
  private ITouchListener mTouchListener;

  public TouchAwareSwipeDismissTouchListener(View paramView, Object paramObject, SwipeDismissTouchListener.DismissCallbacks paramDismissCallbacks)
  {
    super(paramView, paramObject, paramDismissCallbacks);
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2:
    default:
    case 0:
    case 1:
    case 3:
    }
    while (true)
    {
      return super.onTouch(paramView, paramMotionEvent);
      if (this.mTouchListener != null)
      {
        this.mTouchListener.onTouchStartedOrContinued();
        continue;
        if (this.mTouchListener != null)
          this.mTouchListener.onTouchEnded();
      }
    }
  }

  public void setTouchListener(ITouchListener paramITouchListener)
  {
    this.mTouchListener = paramITouchListener;
  }

  public static abstract interface ITouchListener
  {
    public abstract void onTouchEnded();

    public abstract void onTouchStartedOrContinued();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.listeners.TouchAwareSwipeDismissTouchListener
 * JD-Core Version:    0.6.2
 */