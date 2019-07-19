package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.references.ResourceReleaser;

public class SimpleBitmapReleaser
  implements ResourceReleaser<Bitmap>
{
  private static SimpleBitmapReleaser sInstance;

  public static SimpleBitmapReleaser getInstance()
  {
    if (sInstance == null)
      sInstance = new SimpleBitmapReleaser();
    return sInstance;
  }

  public void release(Bitmap paramBitmap)
  {
    paramBitmap.recycle();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser
 * JD-Core Version:    0.6.2
 */