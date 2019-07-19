package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;

public abstract class CloseableBitmap extends CloseableImage
{
  public abstract Bitmap getUnderlyingBitmap();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.image.CloseableBitmap
 * JD-Core Version:    0.6.2
 */