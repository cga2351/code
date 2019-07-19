package com.facebook.react.animation;

public class ImmediateAnimation extends Animation
{
  public ImmediateAnimation(int paramInt, AnimationPropertyUpdater paramAnimationPropertyUpdater)
  {
    super(paramInt, paramAnimationPropertyUpdater);
  }

  public void run()
  {
    onUpdate(1.0F);
    finish();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.animation.ImmediateAnimation
 * JD-Core Version:    0.6.2
 */