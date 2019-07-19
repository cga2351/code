package com.facebook.react.uimanager;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class ReactClippingViewGroupHelper
{
  public static final String PROP_REMOVE_CLIPPED_SUBVIEWS = "removeClippedSubviews";
  private static final Rect sHelperRect = new Rect();

  public static void calculateClippingRect(View paramView, Rect paramRect)
  {
    ViewParent localViewParent = paramView.getParent();
    if (localViewParent == null)
    {
      paramRect.setEmpty();
      return;
    }
    if ((localViewParent instanceof ReactClippingViewGroup))
    {
      ReactClippingViewGroup localReactClippingViewGroup = (ReactClippingViewGroup)localViewParent;
      if (localReactClippingViewGroup.getRemoveClippedSubviews())
      {
        localReactClippingViewGroup.getClippingRect(sHelperRect);
        if (!sHelperRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))
        {
          paramRect.setEmpty();
          return;
        }
        sHelperRect.offset(-paramView.getLeft(), -paramView.getTop());
        sHelperRect.offset(paramView.getScrollX(), paramView.getScrollY());
        paramRect.set(sHelperRect);
        return;
      }
    }
    paramView.getDrawingRect(paramRect);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ReactClippingViewGroupHelper
 * JD-Core Version:    0.6.2
 */