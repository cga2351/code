package com.viber.voip.widget;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.BaseBehavior.BaseDragCallback;
import android.support.design.widget.AppBarLayout.Behavior.DragCallback;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

public class ScrollingViberAppBarLayoutBehavior extends ViberAppBarLayout.Behavior
{
  private boolean mIsEnabled;

  public ScrollingViberAppBarLayoutBehavior()
  {
    init();
  }

  public ScrollingViberAppBarLayoutBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }

  private void init()
  {
    this.mIsEnabled = true;
    super.setDragCallback(new AppBarLayout.Behavior.DragCallback()
    {
      public boolean canDrag(AppBarLayout paramAnonymousAppBarLayout)
      {
        return ScrollingViberAppBarLayoutBehavior.this.mIsEnabled;
      }
    });
  }

  public void onNestedPreScroll(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    if (this.mIsEnabled)
      super.onNestedPreScroll(paramCoordinatorLayout, paramAppBarLayout, paramView, paramInt1, paramInt2, paramArrayOfInt, paramInt3);
  }

  public void onNestedScroll(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.mIsEnabled)
      super.onNestedScroll(paramCoordinatorLayout, paramAppBarLayout, paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }

  public boolean onStartNestedScroll(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    return (this.mIsEnabled) && (super.onStartNestedScroll(paramCoordinatorLayout, paramAppBarLayout, paramView1, paramView2, paramInt1, paramInt2));
  }

  public void setDragCallback(AppBarLayout.BaseBehavior.BaseDragCallback paramBaseDragCallback)
  {
  }

  public void setEnabled(boolean paramBoolean)
  {
    this.mIsEnabled = paramBoolean;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.ScrollingViberAppBarLayoutBehavior
 * JD-Core Version:    0.6.2
 */