package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;

@DoNotStrip
public class NativeBlurFilter
{
  static
  {
    ImagePipelineNativeLoader.load();
  }

  public static void iterativeBoxBlur(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    boolean bool1 = true;
    Preconditions.checkNotNull(paramBitmap);
    boolean bool2;
    if (paramInt1 > 0)
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2);
      if (paramInt2 <= 0)
        break label40;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1);
      nativeIterativeBoxBlur(paramBitmap, paramInt1, paramInt2);
      return;
      bool2 = false;
      break;
      label40: bool1 = false;
    }
  }

  @DoNotStrip
  private static native void nativeIterativeBoxBlur(Bitmap paramBitmap, int paramInt1, int paramInt2);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.nativecode.NativeBlurFilter
 * JD-Core Version:    0.6.2
 */