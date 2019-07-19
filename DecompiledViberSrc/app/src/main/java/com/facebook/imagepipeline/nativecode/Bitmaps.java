package com.facebook.imagepipeline.nativecode;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.imageutils.BitmapUtil;
import java.nio.ByteBuffer;

@DoNotStrip
public class Bitmaps
{
  static
  {
    ImagePipelineNativeLoader.load();
  }

  public static void copyBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    boolean bool1 = true;
    boolean bool2;
    boolean bool3;
    if (paramBitmap2.getConfig() == paramBitmap1.getConfig())
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2);
      Preconditions.checkArgument(paramBitmap1.isMutable());
      if (paramBitmap1.getWidth() != paramBitmap2.getWidth())
        break label83;
      bool3 = bool1;
      label40: Preconditions.checkArgument(bool3);
      if (paramBitmap1.getHeight() != paramBitmap2.getHeight())
        break label89;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1);
      nativeCopyBitmap(paramBitmap1, paramBitmap1.getRowBytes(), paramBitmap2, paramBitmap2.getRowBytes(), paramBitmap1.getHeight());
      return;
      bool2 = false;
      break;
      label83: bool3 = false;
      break label40;
      label89: bool1 = false;
    }
  }

  public static ByteBuffer getByteBuffer(Bitmap paramBitmap, long paramLong1, long paramLong2)
  {
    Preconditions.checkNotNull(paramBitmap);
    return nativeGetByteBuffer(paramBitmap, paramLong1, paramLong2);
  }

  @DoNotStrip
  private static native void nativeCopyBitmap(Bitmap paramBitmap1, int paramInt1, Bitmap paramBitmap2, int paramInt2, int paramInt3);

  @DoNotStrip
  private static native ByteBuffer nativeGetByteBuffer(Bitmap paramBitmap, long paramLong1, long paramLong2);

  @DoNotStrip
  private static native void nativePinBitmap(Bitmap paramBitmap);

  @DoNotStrip
  private static native void nativeReleaseByteBuffer(Bitmap paramBitmap);

  public static void pinBitmap(Bitmap paramBitmap)
  {
    Preconditions.checkNotNull(paramBitmap);
    nativePinBitmap(paramBitmap);
  }

  @TargetApi(19)
  public static void reconfigureBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    if (paramBitmap.getAllocationByteCount() >= paramInt1 * paramInt2 * BitmapUtil.getPixelSizeForBitmapConfig(paramConfig));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      paramBitmap.reconfigure(paramInt1, paramInt2, paramConfig);
      return;
    }
  }

  public static void releaseByteBuffer(Bitmap paramBitmap)
  {
    Preconditions.checkNotNull(paramBitmap);
    nativeReleaseByteBuffer(paramBitmap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.nativecode.Bitmaps
 * JD-Core Version:    0.6.2
 */