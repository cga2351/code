package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;

@DoNotStrip
public class NativeRoundingFilter
{
  static
  {
    ImagePipelineNativeLoader.load();
  }

  @DoNotStrip
  private static native void nativeToCircleFilter(Bitmap paramBitmap);

  public static void toCircle(Bitmap paramBitmap)
  {
    Preconditions.checkNotNull(paramBitmap);
    nativeToCircleFilter(paramBitmap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.nativecode.NativeRoundingFilter
 * JD-Core Version:    0.6.2
 */