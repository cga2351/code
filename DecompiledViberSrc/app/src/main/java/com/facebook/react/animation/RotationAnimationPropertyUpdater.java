package com.facebook.react.animation;

import android.view.View;

public class RotationAnimationPropertyUpdater extends AbstractSingleFloatProperyUpdater
{
  public RotationAnimationPropertyUpdater(float paramFloat)
  {
    super(paramFloat);
  }

  protected float getProperty(View paramView)
  {
    return paramView.getRotation();
  }

  protected void setProperty(View paramView, float paramFloat)
  {
    paramView.setRotation((float)Math.toDegrees(paramFloat));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.animation.RotationAnimationPropertyUpdater
 * JD-Core Version:    0.6.2
 */