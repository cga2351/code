package com.facebook.react.animation;

import android.view.View;

public abstract interface AnimationPropertyUpdater
{
  public abstract void onFinish(View paramView);

  public abstract void onUpdate(View paramView, float paramFloat);

  public abstract void prepare(View paramView);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.animation.AnimationPropertyUpdater
 * JD-Core Version:    0.6.2
 */