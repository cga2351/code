package com.facebook.drawee.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import javax.annotation.Nullable;

public class DrawableUtils
{
  @Nullable
  public static Drawable cloneDrawable(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof CloneableDrawable))
      return ((CloneableDrawable)paramDrawable).cloneDrawable();
    Drawable.ConstantState localConstantState = paramDrawable.getConstantState();
    if (localConstantState != null)
      return localConstantState.newDrawable();
    return null;
  }

  public static void copyProperties(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if ((paramDrawable2 == null) || (paramDrawable1 == null) || (paramDrawable1 == paramDrawable2))
      return;
    paramDrawable1.setBounds(paramDrawable2.getBounds());
    paramDrawable1.setChangingConfigurations(paramDrawable2.getChangingConfigurations());
    paramDrawable1.setLevel(paramDrawable2.getLevel());
    paramDrawable1.setVisible(paramDrawable2.isVisible(), false);
    paramDrawable1.setState(paramDrawable2.getState());
  }

  public static int getOpacityFromColor(int paramInt)
  {
    int i = paramInt >>> 24;
    if (i == 255)
      return -1;
    if (i == 0)
      return -2;
    return -3;
  }

  public static int multiplyColorAlpha(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 255)
      return paramInt1;
    if (paramInt2 == 0)
      return paramInt1 & 0xFFFFFF;
    return (paramInt2 + (paramInt2 >> 7)) * (paramInt1 >>> 24) >> 8 << 24 | paramInt1 & 0xFFFFFF;
  }

  public static void setCallbacks(Drawable paramDrawable, @Nullable Drawable.Callback paramCallback, @Nullable TransformCallback paramTransformCallback)
  {
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(paramCallback);
      if ((paramDrawable instanceof TransformAwareDrawable))
        ((TransformAwareDrawable)paramDrawable).setTransformCallback(paramTransformCallback);
    }
  }

  public static void setDrawableProperties(Drawable paramDrawable, DrawableProperties paramDrawableProperties)
  {
    if ((paramDrawable == null) || (paramDrawableProperties == null))
      return;
    paramDrawableProperties.applyTo(paramDrawable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.drawable.DrawableUtils
 * JD-Core Version:    0.6.2
 */