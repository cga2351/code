package com.facebook.react.animation;

import android.view.View;

public class OpacityAnimationPropertyUpdater extends AbstractSingleFloatProperyUpdater
{
  public OpacityAnimationPropertyUpdater(float paramFloat)
  {
    super(paramFloat);
  }

  public OpacityAnimationPropertyUpdater(float paramFloat1, float paramFloat2)
  {
    super(paramFloat1, paramFloat2);
  }

  protected float getProperty(View paramView)
  {
    return paramView.getAlpha();
  }

  protected void setProperty(View paramView, float paramFloat)
  {
    paramView.setAlpha(paramFloat);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.animation.OpacityAnimationPropertyUpdater
 * JD-Core Version:    0.6.2
 */