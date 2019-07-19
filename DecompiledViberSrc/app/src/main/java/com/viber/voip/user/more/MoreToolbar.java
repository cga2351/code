package com.viber.voip.user.more;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MoreToolbar extends Toolbar
{
  private boolean mConsumeTouchEvents;

  public MoreToolbar(Context paramContext)
  {
    super(paramContext);
  }

  public MoreToolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public MoreToolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void consumeTouchEvents(boolean paramBoolean)
  {
    this.mConsumeTouchEvents = paramBoolean;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return this.mConsumeTouchEvents;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.MoreToolbar
 * JD-Core Version:    0.6.2
 */