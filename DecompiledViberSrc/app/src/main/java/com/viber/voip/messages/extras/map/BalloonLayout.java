package com.viber.voip.messages.extras.map;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.viber.voip.R.dimen;
import com.viber.voip.ui.f;

public class BalloonLayout extends f
{
  protected float a;
  protected int b;

  public BalloonLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public BalloonLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public BalloonLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  protected float a()
  {
    return this.a;
  }

  protected int a(int paramInt)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(paramInt), (int)a()), i);
  }

  protected void a(Context paramContext)
  {
    this.a = paramContext.getResources().getDimension(R.dimen.msg_list_balloon_width_default);
    setDescendantFocusability(262144);
  }

  protected void dispatchSetPressed(boolean paramBoolean)
  {
  }

  public boolean hasOverlappingRendering()
  {
    return false;
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2:
    default:
    case 0:
    case 1:
    case 3:
    case 4:
    }
    while (true)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      setPressed(true);
      continue;
      setPressed(false);
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(a(paramInt1), paramInt2);
  }

  public void setBackgroundResource(int paramInt)
  {
    if (paramInt != this.b)
    {
      this.b = paramInt;
      super.setBackgroundResource(paramInt);
    }
  }

  public void setMaxWidth(float paramFloat)
  {
    if (paramFloat != this.a)
    {
      this.a = paramFloat;
      requestLayout();
    }
  }

  public void setPressed(boolean paramBoolean)
  {
    if ((paramBoolean) && (((View)getParent()).isPressed()))
      return;
    super.setPressed(paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extras.map.BalloonLayout
 * JD-Core Version:    0.6.2
 */