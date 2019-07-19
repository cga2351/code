package com.viber.voip.widget.toolbar;

import android.content.Context;
import android.content.res.Resources;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.ui.ScalableTextView;

public class PublicAccountInfoToolbarBehavior extends ToolbarCustomViewBehavior
{
  private View mFollowBannerContainerView;
  private View mPublishBannerContainerView;
  private PublicAccountInfoToolbarView mToolbarView;
  private int mVerifiedMarginLeft;
  private int mVerifiedSize;

  public PublicAccountInfoToolbarBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  protected void adjustViews(float paramFloat1, float paramFloat2)
  {
    final ScalableTextView localScalableTextView;
    float f;
    if (this.mToolbarView != null)
    {
      localScalableTextView = (ScalableTextView)this.mToolbarView.b;
      if (localScalableTextView.getMaxWidth() == 0)
        this.mToolbar.post(new Runnable()
        {
          public void run()
          {
            PublicAccountInfoToolbarBehavior.this.mToolbarView.b.setMaxWidth(PublicAccountInfoToolbarBehavior.this.mToolbarView.getWidth() - PublicAccountInfoToolbarBehavior.this.mVerifiedMarginLeft - PublicAccountInfoToolbarBehavior.this.mVerifiedSize - PublicAccountInfoToolbarBehavior.this.mStartMarginRight - PublicAccountInfoToolbarBehavior.this.mStartMarginLeft);
            ((ViewGroup.MarginLayoutParams)PublicAccountInfoToolbarBehavior.this.mToolbarView.a.getLayoutParams()).leftMargin = ((int)(PublicAccountInfoToolbarBehavior.this.mVerifiedMarginLeft + localScalableTextView.getScaledWidthDelta()));
          }
        });
    }
    else
    {
      if (paramFloat1 >= 0.25F)
        break label110;
      f = 0.0F;
    }
    while (true)
    {
      if (this.mToolbarView.a.getVisibility() == 0)
        this.mToolbarView.a.setAlpha(f);
      return;
      ((ViewGroup.MarginLayoutParams)this.mToolbarView.a.getLayoutParams()).leftMargin = ((int)(this.mVerifiedMarginLeft + localScalableTextView.getScaledWidthDelta()));
      break;
      label110: if (paramFloat1 >= 0.5F)
        f = 1.0F;
      else
        f = 1.0F - (0.5F - paramFloat1) / (0.5F - 0.25F);
    }
  }

  protected int getChildExtraOffset()
  {
    if (this.mPublishBannerContainerView.getVisibility() == 0);
    for (int i = this.mPublishBannerContainerView.getHeight(); ; i = 0)
    {
      int j = this.mFollowBannerContainerView.getVisibility();
      int k = 0;
      if (j == 0)
        k = this.mFollowBannerContainerView.getHeight();
      return i + k;
    }
  }

  protected TextView getSubtitleView()
  {
    return this.mToolbarView.c;
  }

  protected TextView getTitleView()
  {
    return this.mToolbarView.b;
  }

  protected void shouldInitProperties(CoordinatorLayout paramCoordinatorLayout, ViewGroup paramViewGroup, View paramView)
  {
    super.shouldInitProperties(paramCoordinatorLayout, paramViewGroup, paramView);
    if (this.mToolbarView == null)
      if (!(paramViewGroup instanceof PublicAccountInfoToolbarView))
        break label114;
    label114: for (this.mToolbarView = ((PublicAccountInfoToolbarView)paramViewGroup); ; this.mToolbarView = ((PublicAccountInfoToolbarView)paramViewGroup.findViewById(R.id.float_toolbar_custom)))
    {
      if (this.mPublishBannerContainerView == null)
        this.mPublishBannerContainerView = paramCoordinatorLayout.findViewById(R.id.publish_public_account_banner_container);
      if (this.mFollowBannerContainerView == null)
        this.mFollowBannerContainerView = paramCoordinatorLayout.findViewById(R.id.follow_banner_container);
      if (this.mVerifiedMarginLeft == 0)
        this.mVerifiedMarginLeft = this.mContext.getResources().getDimensionPixelOffset(R.dimen.toolbar_custom_verified_margin_left);
      if (this.mVerifiedSize == 0)
        this.mVerifiedSize = this.mContext.getResources().getDimensionPixelOffset(R.dimen.toolbar_custom_verified_size);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.toolbar.PublicAccountInfoToolbarBehavior
 * JD-Core Version:    0.6.2
 */