package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.OrientedDrawable;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;

public class DefaultDrawableFactory
  implements DrawableFactory
{
  private final DrawableFactory mAnimatedDrawableFactory;
  private final Resources mResources;

  public DefaultDrawableFactory(Resources paramResources, DrawableFactory paramDrawableFactory)
  {
    this.mResources = paramResources;
    this.mAnimatedDrawableFactory = paramDrawableFactory;
  }

  private static boolean hasTransformableExifOrientation(CloseableStaticBitmap paramCloseableStaticBitmap)
  {
    return (paramCloseableStaticBitmap.getExifOrientation() != 1) && (paramCloseableStaticBitmap.getExifOrientation() != 0);
  }

  private static boolean hasTransformableRotationAngle(CloseableStaticBitmap paramCloseableStaticBitmap)
  {
    return (paramCloseableStaticBitmap.getRotationAngle() != 0) && (paramCloseableStaticBitmap.getRotationAngle() != -1);
  }

  public Drawable createDrawable(CloseableImage paramCloseableImage)
  {
    if ((paramCloseableImage instanceof CloseableStaticBitmap))
    {
      CloseableStaticBitmap localCloseableStaticBitmap = (CloseableStaticBitmap)paramCloseableImage;
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(this.mResources, localCloseableStaticBitmap.getUnderlyingBitmap());
      if ((!hasTransformableRotationAngle(localCloseableStaticBitmap)) && (!hasTransformableExifOrientation(localCloseableStaticBitmap)))
        return localBitmapDrawable;
      return new OrientedDrawable(localBitmapDrawable, localCloseableStaticBitmap.getRotationAngle(), localCloseableStaticBitmap.getExifOrientation());
    }
    if ((this.mAnimatedDrawableFactory != null) && (this.mAnimatedDrawableFactory.supportsImageType(paramCloseableImage)))
      return this.mAnimatedDrawableFactory.createDrawable(paramCloseableImage);
    return null;
  }

  public boolean supportsImageType(CloseableImage paramCloseableImage)
  {
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.backends.pipeline.DefaultDrawableFactory
 * JD-Core Version:    0.6.2
 */