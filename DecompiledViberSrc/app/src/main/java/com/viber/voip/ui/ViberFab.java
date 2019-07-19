package com.viber.voip.ui;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class ViberFab extends FloatingActionButton
{
  public ViberFab(Context paramContext)
  {
    super(paramContext);
  }

  public ViberFab(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ViberFab(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    if (!bool)
    {
      if (paramMotionEvent.getAction() == 1)
        cancelLongPress();
      setPressed(false);
    }
    return bool;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.ViberFab
 * JD-Core Version:    0.6.2
 */