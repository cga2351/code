package com.viber.voip.user.more;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.viber.voip.util.dj;
import com.viber.voip.widget.toolbar.ToolbarCustomView;

class MoreToolbarScrollController
  implements AppBarLayout.OnOffsetChangedListener, TextWatcher
{
  private static final float TITLE_SWITCH_COLLAPSING_RATE = 0.25F;
  private final float mCollapsedSubtitleY;
  private final int mCollapsedTitleLeftMargin;
  private float mExpandedSubtitleTextWidth;
  private float mExpandedTitleTextWidth;
  private final int mExpandedTitleTopMargin;
  private boolean mIsExpandedState = false;
  private boolean mIsInitialized = false;
  private float mLatestRatio;
  private String mLatestSubtitleText = "";
  private String mLatestTitleText = "";
  private final View mMarker;
  private float mStateLeftDiff = 0.0F;
  private final float mTextSizeScaleRatio;
  private final Toolbar mToolbar;
  private final ToolbarCustomView mToolbarCustomView;
  private int mToolbarCustomViewTopMargin;

  MoreToolbarScrollController(Toolbar paramToolbar, ToolbarCustomView paramToolbarCustomView, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mToolbar = paramToolbar;
    this.mToolbarCustomView = paramToolbarCustomView;
    this.mMarker = paramView;
    this.mTextSizeScaleRatio = (paramInt3 / this.mToolbarCustomView.b.getTextSize());
    float f = getTextHeight(this.mToolbarCustomView.b.getPaint());
    this.mCollapsedSubtitleY = (f * this.mTextSizeScaleRatio - f);
    this.mCollapsedTitleLeftMargin = paramInt2;
    this.mExpandedTitleTopMargin = paramInt1;
    dj.c(this.mToolbarCustomView, 4);
    this.mToolbarCustomView.b.setPivotX(0.0F);
    this.mToolbarCustomView.b.setPivotY(0.0F);
    this.mToolbarCustomView.b.addTextChangedListener(this);
    this.mToolbarCustomView.c.addTextChangedListener(this);
  }

  private int getCustomViewRightDiff()
  {
    return this.mToolbar.getRight() - this.mMarker.getRight();
  }

  private int getMarkerLeft()
  {
    return Math.max(this.mCollapsedTitleLeftMargin, this.mMarker.getLeft());
  }

  private float getScale(float paramFloat)
  {
    return this.mTextSizeScaleRatio + paramFloat * (1.0F - this.mTextSizeScaleRatio);
  }

  private float getTextHeight(TextPaint paramTextPaint)
  {
    return paramTextPaint.descent() - paramTextPaint.ascent();
  }

  private float getTextSize(int paramInt, CharSequence paramCharSequence, TextPaint paramTextPaint)
  {
    CharSequence localCharSequence = TextUtils.ellipsize(paramCharSequence, paramTextPaint, paramInt, TextUtils.TruncateAt.END);
    if (localCharSequence == null);
    while (true)
    {
      return Math.min(paramInt, paramTextPaint.measureText(paramCharSequence.toString()));
      paramCharSequence = localCharSequence;
    }
  }

  private float getToolbarViewCenterX(View paramView, float paramFloat)
  {
    return (this.mToolbar.getWidth() - paramView.getWidth()) / 2.0F + (paramView.getWidth() - paramFloat) / 2.0F;
  }

  private void invalidate()
  {
    if (!this.mIsInitialized)
      return;
    String str1 = this.mToolbarCustomView.b.getText().toString();
    if (!this.mLatestTitleText.equals(str1))
    {
      this.mLatestTitleText = str1;
      setExpandedTitleTextWidth();
    }
    String str2 = this.mToolbarCustomView.c.getText().toString();
    if (!this.mLatestSubtitleText.equals(str2))
    {
      this.mLatestSubtitleText = str2;
      setExpandedSubtitleTextWidth();
    }
    invalidateTitleWidth(this.mLatestRatio);
    setTitleWidthIfNeeded(this.mLatestRatio);
    setTranslation(this.mLatestRatio);
  }

  private void invalidateTitleWidth(float paramFloat)
  {
    if (paramFloat < 0.25F);
    for (boolean bool = true; ; bool = false)
    {
      this.mIsExpandedState = bool;
      return;
    }
  }

  private boolean isToolbarsFieldSet()
  {
    return (!TextUtils.isEmpty(this.mToolbarCustomView.b.getText())) && (!TextUtils.isEmpty(this.mToolbarCustomView.c.getText()));
  }

  private void setExpandedSubtitleTextWidth()
  {
    this.mExpandedSubtitleTextWidth = getTextSize(this.mToolbar.getWidth(), this.mToolbarCustomView.c.getText(), this.mToolbarCustomView.c.getPaint());
  }

  private void setExpandedTitleTextWidth()
  {
    this.mExpandedTitleTextWidth = getTextSize(this.mToolbar.getWidth(), this.mToolbarCustomView.b.getText(), this.mToolbarCustomView.b.getPaint());
  }

  private void setTitleWidthIfNeeded(float paramFloat)
  {
    float f = getScale(paramFloat);
    this.mToolbarCustomView.b.setScaleX(f);
    this.mToolbarCustomView.b.setScaleY(f);
    if ((paramFloat >= 0.25F) && (!this.mIsExpandedState))
    {
      this.mIsExpandedState = true;
      this.mToolbarCustomView.b.setTranslationX(this.mToolbarCustomView.b.getTranslationX() + this.mStateLeftDiff);
      this.mStateLeftDiff = 0.0F;
      setViewHorizontalMargins(this.mToolbarCustomView, 0, 0);
    }
    while ((paramFloat >= 0.25F) || (!this.mIsExpandedState))
      return;
    this.mIsExpandedState = false;
    this.mStateLeftDiff = 0.0F;
    setTranslation(0.25F);
    this.mStateLeftDiff = this.mToolbarCustomView.b.getTranslationX();
    if (this.mStateLeftDiff > getMarkerLeft())
      this.mStateLeftDiff -= this.mStateLeftDiff - getMarkerLeft();
    int i = (int)this.mStateLeftDiff;
    int j = getCustomViewRightDiff();
    int k = Math.max(0, (int)((this.mMarker.getRight() - getMarkerLeft()) / this.mTextSizeScaleRatio - (this.mToolbar.getWidth() - i - j)));
    setViewHorizontalMargins(this.mToolbarCustomView, i, j - k);
  }

  private void setTranslation(float paramFloat)
  {
    float f1 = (1.0F - paramFloat) * getMarkerLeft() - this.mStateLeftDiff;
    float f2 = (1.0F - paramFloat) * this.mToolbarCustomViewTopMargin;
    float f3 = getToolbarViewCenterX(this.mToolbarCustomView.b, this.mExpandedTitleTextWidth);
    this.mToolbarCustomView.b.setTranslationX(f1 + f3 * paramFloat);
    float f4 = getToolbarViewCenterX(this.mToolbarCustomView.c, this.mExpandedSubtitleTextWidth);
    this.mToolbarCustomView.c.setTranslationX(f1 + f4 * paramFloat);
    this.mToolbarCustomView.setTranslationY(f2 + paramFloat * this.mExpandedTitleTopMargin);
    this.mToolbarCustomView.c.setTranslationY(this.mCollapsedSubtitleY - paramFloat * this.mCollapsedSubtitleY);
  }

  private void setViewHorizontalMargins(View paramView, int paramInt1, int paramInt2)
  {
    int i = 1;
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int j = localMarginLayoutParams.rightMargin;
    int k = 0;
    if (j != paramInt2)
    {
      localMarginLayoutParams.rightMargin = paramInt2;
      k = i;
    }
    if (localMarginLayoutParams.leftMargin != paramInt1)
      localMarginLayoutParams.leftMargin = paramInt1;
    while (true)
    {
      if (i != 0)
        paramView.requestLayout();
      return;
      i = k;
    }
  }

  public void afterTextChanged(Editable paramEditable)
  {
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  void init()
  {
    if ((this.mIsInitialized) || (!isToolbarsFieldSet()))
      return;
    this.mToolbarCustomViewTopMargin = ((this.mToolbar.getHeight() - this.mToolbarCustomView.getHeight()) / 2);
    this.mLatestTitleText = this.mToolbarCustomView.b.getText().toString();
    this.mLatestSubtitleText = this.mToolbarCustomView.c.getText().toString();
    setExpandedTitleTextWidth();
    setExpandedSubtitleTextWidth();
    setTitleWidthIfNeeded(1.0F);
    setTranslation(1.0F);
    this.mToolbarCustomView.setVisibility(0);
    this.mIsInitialized = true;
  }

  public void onOffsetChanged(AppBarLayout paramAppBarLayout, int paramInt)
  {
    if (!this.mIsInitialized)
      return;
    float f = paramAppBarLayout.getTotalScrollRange();
    this.mLatestRatio = (1.0F - Math.abs(paramInt) / f);
    setTitleWidthIfNeeded(this.mLatestRatio);
    setTranslation(this.mLatestRatio);
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (isToolbarsFieldSet())
    {
      invalidate();
      return;
    }
    init();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.MoreToolbarScrollController
 * JD-Core Version:    0.6.2
 */