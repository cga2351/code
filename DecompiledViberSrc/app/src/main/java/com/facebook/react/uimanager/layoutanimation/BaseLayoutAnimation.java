package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.facebook.react.uimanager.IllegalViewOperationException;

abstract class BaseLayoutAnimation extends AbstractLayoutAnimation
{
  Animation createAnimationImpl(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mAnimatedProperty != null)
    {
      switch (1.$SwitchMap$com$facebook$react$uimanager$layoutanimation$AnimatedPropertyType[this.mAnimatedProperty.ordinal()])
      {
      default:
        throw new IllegalViewOperationException("Missing animation for property : " + this.mAnimatedProperty);
      case 1:
        float f7;
        if (isReverse())
        {
          f7 = paramView.getAlpha();
          if (!isReverse())
            break label120;
        }
        for (float f8 = 0.0F; ; f8 = paramView.getAlpha())
        {
          return new OpacityAnimation(paramView, f7, f8);
          f7 = 0.0F;
          break;
        }
      case 2:
        float f5;
        if (isReverse())
        {
          f5 = 1.0F;
          if (!isReverse())
            break label177;
        }
        for (float f6 = 0.0F; ; f6 = 1.0F)
        {
          return new ScaleAnimation(f5, f6, f5, f6, 1, 0.5F, 1, 0.5F);
          f5 = 0.0F;
          break;
        }
      case 3:
        label120: float f3;
        label177: if (isReverse())
        {
          f3 = 1.0F;
          if (!isReverse())
            break label228;
        }
        label228: for (float f4 = 0.0F; ; f4 = 1.0F)
        {
          return new ScaleAnimation(f3, f4, 1.0F, 1.0F, 1, 0.5F, 1, 0.0F);
          f3 = 0.0F;
          break;
        }
      case 4:
      }
      float f1;
      if (isReverse())
      {
        f1 = 1.0F;
        if (!isReverse())
          break label279;
      }
      label279: for (float f2 = 0.0F; ; f2 = 1.0F)
      {
        return new ScaleAnimation(1.0F, 1.0F, f1, f2, 1, 0.0F, 1, 0.5F);
        f1 = 0.0F;
        break;
      }
    }
    throw new IllegalViewOperationException("Missing animated property from animation config");
  }

  abstract boolean isReverse();

  boolean isValid()
  {
    return (this.mDurationMs > 0) && (this.mAnimatedProperty != null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.layoutanimation.BaseLayoutAnimation
 * JD-Core Version:    0.6.2
 */