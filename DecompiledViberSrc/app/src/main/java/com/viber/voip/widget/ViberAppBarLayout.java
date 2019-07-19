package com.viber.voip.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.LayoutParams;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.viber.voip.R.styleable;
import com.viber.voip.ui.FlingBehavior;
import java.util.ArrayList;
import java.util.List;

public class ViberAppBarLayout extends AppBarLayout
{
  private int a;
  private boolean b;
  private final List<AppBarLayout.OnOffsetChangedListener> c = new ArrayList();

  public ViberAppBarLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public ViberAppBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void b()
  {
    this.a = 0;
  }

  private boolean c()
  {
    return this.b;
  }

  private int getPendingAction()
  {
    return this.a;
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    int j;
    if (paramBoolean1)
    {
      i = 1;
      this.a = i;
      j = this.a;
      if (!paramBoolean2)
        break label43;
    }
    label43: for (int k = 4; ; k = 0)
    {
      this.a = (k | j);
      requestLayout();
      return;
      i = 2;
      break;
    }
  }

  public boolean a()
  {
    CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.LayoutParams)getLayoutParams()).getBehavior();
    return ((localBehavior instanceof Behavior)) && (((Behavior)localBehavior).getTopAndBottomOffset() == 0);
  }

  public void addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener paramOnOffsetChangedListener)
  {
    super.addOnOffsetChangedListener(paramOnOffsetChangedListener);
    if ((paramOnOffsetChangedListener != null) && (!this.c.contains(paramOnOffsetChangedListener)))
      this.c.add(paramOnOffsetChangedListener);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.b = false;
    int i = getChildCount();
    for (int j = 0; ; j++)
      if (j < i)
      {
        if (((AppBarLayout.LayoutParams)getChildAt(j).getLayoutParams()).getScrollInterpolator() != null)
          this.b = true;
      }
      else
        return;
  }

  public void removeOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener paramOnOffsetChangedListener)
  {
    super.removeOnOffsetChangedListener(paramOnOffsetChangedListener);
    if (paramOnOffsetChangedListener != null)
      this.c.remove(paramOnOffsetChangedListener);
  }

  public void setExpandedToOffset(boolean paramBoolean)
  {
    a(paramBoolean, ViewCompat.isLaidOut(this));
  }

  public void setInitialOffset(int paramInt)
  {
    CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.LayoutParams)getLayoutParams()).getBehavior();
    if ((localBehavior instanceof Behavior))
      ((Behavior)localBehavior).setInitialOffset(paramInt);
  }

  public static class Behavior extends FlingBehavior
  {
    private ValueAnimator mAnimator;
    private int mInitialOffset;
    private int mOffsetDelta;

    public Behavior()
    {
    }

    public Behavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ViberAppBarLayoutBehavior_Params);
      try
      {
        this.mInitialOffset = localTypedArray.getDimensionPixelSize(R.styleable.ViberAppBarLayoutBehavior_Params_behavior_initialOffset, 0);
        if (this.mInitialOffset > 0)
          setTopAndBottomOffset(-this.mInitialOffset);
        return;
      }
      finally
      {
        localTypedArray.recycle();
      }
    }

    private void animateOffsetTo(final CoordinatorLayout paramCoordinatorLayout, final ViberAppBarLayout paramViberAppBarLayout, int paramInt)
    {
      if (this.mAnimator == null)
      {
        this.mAnimator = new ValueAnimator();
        this.mAnimator.setInterpolator(new DecelerateInterpolator());
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            ViberAppBarLayout.Behavior.this.setHeaderTopBottomOffset(paramCoordinatorLayout, paramViberAppBarLayout, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
        });
      }
      while (true)
      {
        ValueAnimator localValueAnimator = this.mAnimator;
        int[] arrayOfInt = new int[2];
        arrayOfInt[0] = getTopBottomOffsetForScrollingSibling();
        arrayOfInt[1] = paramInt;
        localValueAnimator.setIntValues(arrayOfInt);
        this.mAnimator.start();
        return;
        this.mAnimator.cancel();
      }
    }

    private void dispatchOffsetUpdates(ViberAppBarLayout paramViberAppBarLayout)
    {
      List localList = ViberAppBarLayout.d(paramViberAppBarLayout);
      int i = localList.size();
      for (int j = 0; j < i; j++)
      {
        AppBarLayout.OnOffsetChangedListener localOnOffsetChangedListener = (AppBarLayout.OnOffsetChangedListener)localList.get(j);
        if (localOnOffsetChangedListener != null)
          localOnOffsetChangedListener.onOffsetChanged(paramViberAppBarLayout, getTopAndBottomOffset());
      }
    }

    private int getTopBottomOffsetForScrollingSibling()
    {
      return getTopAndBottomOffset() + this.mOffsetDelta;
    }

    private int interpolateOffset(ViberAppBarLayout paramViberAppBarLayout, int paramInt)
    {
      int i = Math.abs(paramInt);
      int j = paramViberAppBarLayout.getChildCount();
      int k = 0;
      View localView;
      Interpolator localInterpolator;
      int n;
      if (k < j)
      {
        localView = paramViberAppBarLayout.getChildAt(k);
        AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)localView.getLayoutParams();
        localInterpolator = localLayoutParams.getScrollInterpolator();
        if ((i < localView.getTop()) || (i > localView.getBottom()))
          break label174;
        if (localInterpolator != null)
        {
          int m = localLayoutParams.getScrollFlags();
          if ((m & 0x1) == 0)
            break label180;
          n = 0 + (localView.getHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin);
          if ((m & 0x2) != 0)
            n -= ViewCompat.getMinimumHeight(localView);
        }
      }
      while (true)
      {
        if (n > 0)
        {
          int i1 = i - localView.getTop();
          int i2 = Math.round(n * localInterpolator.getInterpolation(i1 / n));
          paramInt = Integer.signum(paramInt) * (i2 + localView.getTop());
        }
        return paramInt;
        label174: k++;
        break;
        label180: n = 0;
      }
    }

    private int setHeaderTopBottomOffset(CoordinatorLayout paramCoordinatorLayout, ViberAppBarLayout paramViberAppBarLayout, int paramInt)
    {
      int i = getTopBottomOffsetForScrollingSibling();
      int j = 0;
      if (i != paramInt)
        if (!ViberAppBarLayout.c(paramViberAppBarLayout))
          break label81;
      label81: for (int k = interpolateOffset(paramViberAppBarLayout, paramInt); ; k = paramInt)
      {
        boolean bool = setTopAndBottomOffset(k);
        int m = i - paramInt;
        this.mOffsetDelta = (paramInt - k);
        if ((!bool) && (ViberAppBarLayout.c(paramViberAppBarLayout)))
          paramCoordinatorLayout.dispatchDependentViewsChanged(paramViberAppBarLayout);
        dispatchOffsetUpdates(paramViberAppBarLayout);
        j = m;
        return j;
      }
    }

    private void stopNestedScrollIfNeeded(int paramInt1, AppBarLayout paramAppBarLayout, View paramView, int paramInt2)
    {
      if (paramInt2 == 1)
      {
        int i = getTopAndBottomOffset();
        if (((paramInt1 < 0) && (i == 0)) || ((paramInt1 > 0) && (i == -paramAppBarLayout.getTotalScrollRange())))
          ViewCompat.stopNestedScroll(paramView, 1);
      }
    }

    public int getInitialOffset()
    {
      return this.mInitialOffset;
    }

    public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, int paramInt)
    {
      boolean bool = super.onLayoutChild(paramCoordinatorLayout, paramAppBarLayout, paramInt);
      ViberAppBarLayout localViberAppBarLayout;
      int j;
      if ((paramAppBarLayout instanceof ViberAppBarLayout))
      {
        localViberAppBarLayout = (ViberAppBarLayout)paramAppBarLayout;
        int i = ViberAppBarLayout.a(localViberAppBarLayout);
        if ((i & 0x4) == 0)
          break label84;
        j = 1;
        if (((i & 0x2) != 0) || ((i & 0x1) != 0))
        {
          if (j == 0)
            break label90;
          animateOffsetTo(paramCoordinatorLayout, localViberAppBarLayout, -this.mInitialOffset);
        }
      }
      while (true)
      {
        ViberAppBarLayout.b(localViberAppBarLayout);
        dispatchOffsetUpdates(localViberAppBarLayout);
        return bool;
        label84: j = 0;
        break;
        label90: setHeaderTopBottomOffset(paramCoordinatorLayout, localViberAppBarLayout, -this.mInitialOffset);
      }
    }

    public void onNestedPreScroll(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
    {
      super.onNestedPreScroll(paramCoordinatorLayout, paramAppBarLayout, paramView, paramInt1, paramInt2, paramArrayOfInt, paramInt3);
      stopNestedScrollIfNeeded(paramInt2, paramAppBarLayout, paramView, paramInt3);
    }

    public void onNestedScroll(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      super.onNestedScroll(paramCoordinatorLayout, paramAppBarLayout, paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      stopNestedScrollIfNeeded(paramInt4, paramAppBarLayout, paramView, paramInt5);
    }

    public void setInitialOffset(int paramInt)
    {
      if ((this.mInitialOffset != paramInt) && (paramInt > 0))
      {
        this.mInitialOffset = paramInt;
        setTopAndBottomOffset(-paramInt);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.ViberAppBarLayout
 * JD-Core Version:    0.6.2
 */