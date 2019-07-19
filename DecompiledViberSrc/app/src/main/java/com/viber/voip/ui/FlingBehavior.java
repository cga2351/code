package com.viber.voip.ui;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.Behavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ScrollingView;
import android.util.AttributeSet;
import android.view.View;

public class FlingBehavior extends AppBarLayout.Behavior
{
  private boolean mConsumed;
  private boolean mIsPositive;
  private float mVelocity;

  public FlingBehavior()
  {
  }

  public FlingBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public boolean onNestedFling(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (((paramFloat2 > 0.0F) && (!this.mIsPositive)) || ((paramFloat2 < 0.0F) && (this.mIsPositive)))
      paramFloat2 *= -1.0F;
    boolean bool;
    if ((paramView instanceof ScrollingView))
    {
      ScrollingView localScrollingView = (ScrollingView)paramView;
      if ((paramFloat2 > 0.0F) || (localScrollingView.computeVerticalScrollOffset() > 0))
        bool = true;
    }
    while (true)
    {
      this.mVelocity = paramFloat2;
      this.mConsumed = bool;
      return super.onNestedFling(paramCoordinatorLayout, paramAppBarLayout, paramView, paramFloat1, this.mVelocity, this.mConsumed);
      bool = false;
      continue;
      bool = paramBoolean;
    }
  }

  public void onNestedPreScroll(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    super.onNestedPreScroll(paramCoordinatorLayout, paramAppBarLayout, paramView, paramInt1, paramInt2, paramArrayOfInt);
    if (paramInt2 > 0);
    for (boolean bool = true; ; bool = false)
    {
      this.mIsPositive = bool;
      return;
    }
  }

  public void onStopNestedScroll(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView)
  {
    if ((this.mVelocity > 9000.0F) && (this.mConsumed))
    {
      paramAppBarLayout.setExpanded(false);
      this.mVelocity = 0.0F;
      this.mConsumed = false;
    }
    super.onStopNestedScroll(paramCoordinatorLayout, paramAppBarLayout, paramView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.FlingBehavior
 * JD-Core Version:    0.6.2
 */