package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import javax.annotation.Nullable;

class LayoutUpdateAnimation extends AbstractLayoutAnimation
{
  private static final boolean USE_TRANSLATE_ANIMATION;

  @Nullable
  Animation createAnimationImpl(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramView.getX() != paramInt1) || (paramView.getY() != paramInt2));
    int j;
    for (int i = 1; ; i = 0)
    {
      if (paramView.getWidth() == paramInt3)
      {
        int k = paramView.getHeight();
        j = 0;
        if (k == paramInt4);
      }
      else
      {
        j = 1;
      }
      if ((i != 0) || (j != 0))
        break;
      return null;
    }
    if ((i != 0) && (j == 0));
    return new PositionAndSizeAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  boolean isValid()
  {
    return this.mDurationMs > 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.layoutanimation.LayoutUpdateAnimation
 * JD-Core Version:    0.6.2
 */