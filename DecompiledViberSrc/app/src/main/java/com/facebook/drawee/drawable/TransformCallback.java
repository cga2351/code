package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.RectF;

public abstract interface TransformCallback
{
  public abstract void getRootBounds(RectF paramRectF);

  public abstract void getTransform(Matrix paramMatrix);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.drawable.TransformCallback
 * JD-Core Version:    0.6.2
 */