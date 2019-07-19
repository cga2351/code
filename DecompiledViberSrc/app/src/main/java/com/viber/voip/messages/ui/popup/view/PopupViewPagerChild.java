package com.viber.voip.messages.ui.popup.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class PopupViewPagerChild extends ViewPager
{
  public PopupViewPagerChild(Context paramContext)
  {
    super(paramContext);
    a();
  }

  public PopupViewPagerChild(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }

  private void a()
  {
    setOffscreenPageLimit(300);
    setHorizontalFadingEdgeEnabled(true);
    setFadingEdgeLength(15);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.popup.view.PopupViewPagerChild
 * JD-Core Version:    0.6.2
 */