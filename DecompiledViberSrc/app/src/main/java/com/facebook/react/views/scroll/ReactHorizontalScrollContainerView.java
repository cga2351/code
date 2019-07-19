package com.facebook.react.views.scroll;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import com.facebook.react.modules.i18nmanager.I18nUtil;

public class ReactHorizontalScrollContainerView extends ViewGroup
{
  private int mCurrentWidth;
  private int mLayoutDirection;

  public ReactHorizontalScrollContainerView(Context paramContext)
  {
    super(paramContext);
    if (I18nUtil.getInstance().isRTL(paramContext));
    for (int i = 1; ; i = 0)
    {
      this.mLayoutDirection = i;
      this.mCurrentWidth = 0;
      return;
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mLayoutDirection == 1)
    {
      int i = 0 + (paramInt3 - paramInt1);
      setLeft(0);
      setRight(i);
      HorizontalScrollView localHorizontalScrollView = (HorizontalScrollView)getParent();
      localHorizontalScrollView.scrollTo(localHorizontalScrollView.getScrollX() + getWidth() - this.mCurrentWidth, localHorizontalScrollView.getScrollY());
    }
    this.mCurrentWidth = getWidth();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.scroll.ReactHorizontalScrollContainerView
 * JD-Core Version:    0.6.2
 */