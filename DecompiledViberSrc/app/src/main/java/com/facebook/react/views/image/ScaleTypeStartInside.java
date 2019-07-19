package com.facebook.react.views.image;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;

public class ScaleTypeStartInside extends ScalingUtils.AbstractScaleType
{
  public static final ScalingUtils.ScaleType INSTANCE = new ScaleTypeStartInside();

  public void getTransformImpl(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = Math.min(Math.min(paramFloat3, paramFloat4), 1.0F);
    float f2 = paramRect.left;
    float f3 = paramRect.top;
    paramMatrix.setScale(f1, f1);
    paramMatrix.postTranslate((int)(f2 + 0.5F), (int)(f3 + 0.5F));
  }

  public String toString()
  {
    return "start_inside";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.image.ScaleTypeStartInside
 * JD-Core Version:    0.6.2
 */