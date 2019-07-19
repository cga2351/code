package com.viber.voip.widget.toolbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.widget.ViberAppBarLayout.Behavior;

public abstract class ToolbarCustomViewBehavior extends CoordinatorLayout.Behavior<ViewGroup>
{
  protected static final Logger L = ViberEnv.getLogger();
  protected static final float TITLE_END_SCALE = 2.0F;
  protected static final float TITLE_START_SCALE = 1.0F;
  protected Context mContext;
  protected int mEndMarginLeft;
  protected boolean mHasNavigationIcon;
  protected boolean mIsFirst = true;
  protected boolean mIsHidden;
  protected float mOriginalTextSize;
  protected int mStartMarginBottom;
  protected int mStartMarginLeft;
  protected int mStartMarginRight;
  protected CharSequence mTitle;
  protected Rect mTitleContainerVisibleRect;
  protected int mTitleStartMarginBottom;
  protected float mTitleWidth;
  protected Toolbar mToolbar;
  private boolean mWasInvisible;

  public ToolbarCustomViewBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.mContext = paramContext;
  }

  private float getPercentage(AppBarLayout paramAppBarLayout)
  {
    int i = paramAppBarLayout.getTotalScrollRange();
    CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.LayoutParams)paramAppBarLayout.getLayoutParams()).getBehavior();
    if ((localBehavior instanceof ViberAppBarLayout.Behavior))
    {
      if ((localBehavior instanceof ViberAppBarLayout.Behavior));
      float f2;
      for (float f1 = i - ((ViberAppBarLayout.Behavior)localBehavior).getInitialOffset(); ; f1 = i)
      {
        f2 = Math.abs(paramAppBarLayout.getY());
        if (f1 != i)
          break;
        return 0.0F;
      }
      return Math.max(0.0F, f2 - f1) / (i - f1);
    }
    return Math.abs(paramAppBarLayout.getY()) / i;
  }

  private float getScale(float paramFloat)
  {
    return 1.0F + 1.0F * paramFloat;
  }

  private float getTopOffset(float paramFloat)
  {
    if (getSubtitleView().getVisibility() == 4)
    {
      float f = getSubtitleView().getHeight() / 2;
      this.mWasInvisible = true;
      return f;
    }
    if (this.mWasInvisible)
      return getSubtitleView().getHeight() / 2 * (1.0F - paramFloat);
    return 0.0F;
  }

  protected void adjustViews(float paramFloat1, float paramFloat2)
  {
  }

  protected int getChildExtraOffset()
  {
    return 0;
  }

  protected int getOriginalTextSize()
  {
    return this.mContext.getResources().getDimensionPixelSize(R.dimen.toolbar_custom_title_text_size);
  }

  protected abstract TextView getSubtitleView();

  protected abstract TextView getTitleView();

  public boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, ViewGroup paramViewGroup, View paramView)
  {
    return paramView instanceof AppBarLayout;
  }

  public boolean onDependentViewChanged(CoordinatorLayout paramCoordinatorLayout, ViewGroup paramViewGroup, View paramView)
  {
    shouldInitProperties(paramCoordinatorLayout, paramViewGroup, paramView);
    float f1 = getPercentage((AppBarLayout)paramView);
    float f2 = 1.0F - f1;
    float f3 = getScale(f2);
    float f4 = getTopOffset(f1);
    float f5 = f4 + paramViewGroup.getHeight();
    float f6 = f4 + (paramView.getHeight() + paramView.getY() - f5 - getChildExtraOffset() - f1 * (this.mToolbar.getHeight() - f5) / 2.0F - f2 * this.mStartMarginBottom);
    CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramViewGroup.getLayoutParams();
    localLayoutParams.leftMargin = ((int)(f1 * this.mEndMarginLeft) + this.mStartMarginLeft);
    localLayoutParams.rightMargin = ((int)(f2 * this.mStartMarginRight));
    paramViewGroup.setLayoutParams(localLayoutParams);
    int i = (int)(f2 * this.mTitleStartMarginBottom);
    int j = (int)f4;
    TextView localTextView = getTitleView();
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localTextView.getLayoutParams();
    localMarginLayoutParams.bottomMargin = i;
    localMarginLayoutParams.topMargin = j;
    if (this.mIsFirst)
      this.mIsFirst = false;
    for (float f7 = f6 - i - j; ; f7 = f6)
    {
      paramViewGroup.setY(f7);
      localTextView.setPivotY(0.0F);
      localTextView.setPivotX(0.0F);
      localTextView.setScaleX(f3);
      localTextView.setScaleY(f3);
      adjustViews(f2, f3);
      if (Build.VERSION.SDK_INT < 21)
      {
        if ((!this.mIsHidden) || (f1 >= 1.0F))
          break label291;
        paramViewGroup.setVisibility(0);
        this.mIsHidden = false;
      }
      label291: 
      while ((this.mIsHidden) || (f1 != 1.0F))
        return true;
      paramViewGroup.setVisibility(8);
      this.mIsHidden = true;
      return true;
    }
  }

  public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, ViewGroup paramViewGroup, int paramInt)
  {
    if (Build.VERSION.SDK_INT <= 17)
    {
      if (!this.mIsFirst)
        break label22;
      paramViewGroup.setVisibility(4);
    }
    label22: 
    while (this.mIsHidden)
      return false;
    paramViewGroup.setVisibility(0);
    return false;
  }

  protected void shouldInitProperties(CoordinatorLayout paramCoordinatorLayout, ViewGroup paramViewGroup, View paramView)
  {
    if (this.mToolbar == null)
    {
      this.mToolbar = ((Toolbar)paramCoordinatorLayout.findViewById(R.id.toolbar));
      if (this.mToolbar != null)
        if (this.mToolbar.getNavigationIcon() == null)
          break label218;
    }
    label218: for (boolean bool = true; ; bool = false)
    {
      this.mHasNavigationIcon = bool;
      if (this.mStartMarginLeft == 0)
        this.mStartMarginLeft = this.mContext.getResources().getDimensionPixelOffset(R.dimen.toolbar_custom_start_margin_left);
      if (this.mEndMarginLeft == 0)
      {
        int i = this.mContext.getResources().getDimensionPixelOffset(R.dimen.toolbar_custom_end_margin_left);
        if ((this.mToolbar != null) && (!this.mHasNavigationIcon))
          i = this.mToolbar.getContentInsetLeft() - this.mStartMarginLeft;
        this.mEndMarginLeft = i;
      }
      if (this.mStartMarginRight == 0)
        this.mStartMarginRight = this.mContext.getResources().getDimensionPixelOffset(R.dimen.toolbar_custom_start_margin_right);
      if (this.mTitleStartMarginBottom == 0)
        this.mTitleStartMarginBottom = this.mContext.getResources().getDimensionPixelOffset(R.dimen.toolbar_custom_title_start_margin_bottom);
      if (this.mStartMarginBottom == 0)
        this.mStartMarginBottom = this.mContext.getResources().getDimensionPixelOffset(R.dimen.toolbar_custom_start_margin_bottom);
      if (this.mOriginalTextSize == 0.0F)
        this.mOriginalTextSize = getOriginalTextSize();
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.toolbar.ToolbarCustomViewBehavior
 * JD-Core Version:    0.6.2
 */