package com.viber.voip.widget;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.Toolbar;
import android.view.View;

public abstract class e
  implements ObservableCollapsingToolbarLayout.b
{
  private final Drawable mBackgroundColor;
  private View mGradientBottomView;
  private View mGradientTopView;
  private View mOverlayView;
  protected final Toolbar mToolbar;

  public e(Drawable paramDrawable, View paramView, Toolbar paramToolbar)
  {
    this(paramDrawable, paramView, null, null, paramToolbar);
  }

  public e(Drawable paramDrawable, View paramView1, View paramView2, View paramView3, Toolbar paramToolbar)
  {
    this.mOverlayView = paramView1;
    this.mGradientTopView = paramView2;
    this.mGradientBottomView = paramView3;
    this.mToolbar = paramToolbar;
    this.mBackgroundColor = paramDrawable;
  }

  private boolean hasGradient()
  {
    return (this.mGradientTopView != null) && (this.mGradientBottomView != null) && (adjustGradient());
  }

  public abstract boolean adjustGradient();

  protected float getAlpha(float paramFloat)
  {
    return paramFloat;
  }

  public void onScroll(float paramFloat, ObservableCollapsingToolbarLayout.c paramc)
  {
    if (paramFloat == 0.0F)
    {
      this.mOverlayView.setVisibility(8);
      if (this.mToolbar != null)
      {
        if (paramFloat != 1.0F)
          break label97;
        this.mToolbar.setBackground(this.mBackgroundColor);
      }
    }
    while (true)
    {
      if (hasGradient())
      {
        if (paramFloat <= 0.5D)
          break label108;
        this.mGradientBottomView.setVisibility(8);
        this.mGradientTopView.setVisibility(8);
      }
      return;
      this.mOverlayView.setAlpha(getAlpha(paramFloat));
      this.mOverlayView.setVisibility(0);
      break;
      label97: this.mToolbar.setBackground(null);
    }
    label108: this.mGradientBottomView.setVisibility(0);
    this.mGradientTopView.setVisibility(0);
    float f = 1.0F - 2.0F * paramFloat;
    this.mGradientBottomView.setAlpha(f);
    this.mGradientTopView.setAlpha(f);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.e
 * JD-Core Version:    0.6.2
 */