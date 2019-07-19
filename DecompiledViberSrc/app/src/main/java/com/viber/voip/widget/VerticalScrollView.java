package com.viber.voip.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class VerticalScrollView extends ScrollView
{
  private GestureDetector a;

  public VerticalScrollView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public VerticalScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    this.a = new GestureDetector(paramContext, new a(null));
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (super.onInterceptTouchEvent(paramMotionEvent)) && (this.a.onTouchEvent(paramMotionEvent));
  }

  private final class a extends GestureDetector.SimpleOnGestureListener
  {
    private a()
    {
    }

    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return Math.abs(paramFloat2) > Math.abs(paramFloat1);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.VerticalScrollView
 * JD-Core Version:    0.6.2
 */