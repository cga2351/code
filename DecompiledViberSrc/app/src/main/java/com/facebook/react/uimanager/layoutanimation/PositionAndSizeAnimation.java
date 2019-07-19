package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class PositionAndSizeAnimation extends Animation
  implements LayoutHandlingAnimation
{
  private int mDeltaHeight;
  private int mDeltaWidth;
  private float mDeltaX;
  private float mDeltaY;
  private int mStartHeight;
  private int mStartWidth;
  private float mStartX;
  private float mStartY;
  private final View mView;

  public PositionAndSizeAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mView = paramView;
    calculateAnimation(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  private void calculateAnimation(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mStartX = (this.mView.getX() - this.mView.getTranslationX());
    this.mStartY = (this.mView.getY() - this.mView.getTranslationY());
    this.mStartWidth = this.mView.getWidth();
    this.mStartHeight = this.mView.getHeight();
    this.mDeltaX = (paramInt1 - this.mStartX);
    this.mDeltaY = (paramInt2 - this.mStartY);
    this.mDeltaWidth = (paramInt3 - this.mStartWidth);
    this.mDeltaHeight = (paramInt4 - this.mStartHeight);
  }

  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = this.mStartX + paramFloat * this.mDeltaX;
    float f2 = this.mStartY + paramFloat * this.mDeltaY;
    float f3 = this.mStartWidth + paramFloat * this.mDeltaWidth;
    float f4 = this.mStartHeight + paramFloat * this.mDeltaHeight;
    this.mView.layout(Math.round(f1), Math.round(f2), Math.round(f1 + f3), Math.round(f2 + f4));
  }

  public void onLayoutUpdate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    calculateAnimation(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public boolean willChangeBounds()
  {
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.layoutanimation.PositionAndSizeAnimation
 * JD-Core Version:    0.6.2
 */