package com.facebook.react.animation;

import android.view.View;

public class ScaleYAnimationPropertyUpdater extends AbstractSingleFloatProperyUpdater
{
  public ScaleYAnimationPropertyUpdater(float paramFloat)
  {
    super(paramFloat);
  }

  public ScaleYAnimationPropertyUpdater(float paramFloat1, float paramFloat2)
  {
    super(paramFloat1, paramFloat2);
  }

  protected float getProperty(View paramView)
  {
    return paramView.getScaleY();
  }

  protected void setProperty(View paramView, float paramFloat)
  {
    paramView.setScaleY(paramFloat);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.animation.ScaleYAnimationPropertyUpdater
 * JD-Core Version:    0.6.2
 */