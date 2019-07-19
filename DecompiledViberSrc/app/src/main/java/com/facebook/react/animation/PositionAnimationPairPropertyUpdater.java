package com.facebook.react.animation;

import android.view.View;

public class PositionAnimationPairPropertyUpdater extends AbstractFloatPairPropertyUpdater
{
  public PositionAnimationPairPropertyUpdater(float paramFloat1, float paramFloat2)
  {
    super(paramFloat1, paramFloat2);
  }

  public PositionAnimationPairPropertyUpdater(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }

  protected void getProperty(View paramView, float[] paramArrayOfFloat)
  {
    paramArrayOfFloat[0] = (paramView.getX() + 0.5F * paramView.getWidth());
    paramArrayOfFloat[1] = (paramView.getY() + 0.5F * paramView.getHeight());
  }

  protected void setProperty(View paramView, float[] paramArrayOfFloat)
  {
    paramView.setX(paramArrayOfFloat[0] - 0.5F * paramView.getWidth());
    paramView.setY(paramArrayOfFloat[1] - 0.5F * paramView.getHeight());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.animation.PositionAnimationPairPropertyUpdater
 * JD-Core Version:    0.6.2
 */