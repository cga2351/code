package com.viber.voip.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;

public class TouchInterceptorFrameLayout extends FrameLayout
{
  private View.OnTouchListener a;

  public TouchInterceptorFrameLayout(Context paramContext)
  {
    super(paramContext);
  }

  public TouchInterceptorFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public TouchInterceptorFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public TouchInterceptorFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a != null)
    {
      if (this.a.onTouch(this, paramMotionEvent))
        return true;
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }

  public void setOnInterceptTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.a = paramOnTouchListener;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.TouchInterceptorFrameLayout
 * JD-Core Version:    0.6.2
 */