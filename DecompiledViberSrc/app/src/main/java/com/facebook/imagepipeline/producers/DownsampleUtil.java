package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;

public class DownsampleUtil
{
  public static final int DEFAULT_SAMPLE_SIZE = 1;
  private static final float INTERVAL_ROUNDING = 0.3333333F;

  @VisibleForTesting
  static float determineDownsampleRatio(ImageRequest paramImageRequest, EncodedImage paramEncodedImage)
  {
    Preconditions.checkArgument(EncodedImage.isMetaDataAvailable(paramEncodedImage));
    ResizeOptions localResizeOptions = paramImageRequest.getResizeOptions();
    if ((localResizeOptions == null) || (localResizeOptions.height <= 0) || (localResizeOptions.width <= 0) || (paramEncodedImage.getWidth() == 0) || (paramEncodedImage.getHeight() == 0))
      return 1.0F;
    int i = getRotationAngle(paramImageRequest, paramEncodedImage);
    int j;
    int k;
    if ((i == 90) || (i == 270))
    {
      j = 1;
      if (j == 0)
        break label226;
      k = paramEncodedImage.getHeight();
      label79: if (j == 0)
        break label235;
    }
    label226: label235: for (int m = paramEncodedImage.getWidth(); ; m = paramEncodedImage.getHeight())
    {
      float f1 = localResizeOptions.width / k;
      float f2 = localResizeOptions.height / m;
      float f3 = Math.max(f1, f2);
      Object[] arrayOfObject = new Object[8];
      arrayOfObject[0] = Integer.valueOf(localResizeOptions.width);
      arrayOfObject[1] = Integer.valueOf(localResizeOptions.height);
      arrayOfObject[2] = Integer.valueOf(k);
      arrayOfObject[3] = Integer.valueOf(m);
      arrayOfObject[4] = Float.valueOf(f1);
      arrayOfObject[5] = Float.valueOf(f2);
      arrayOfObject[6] = Float.valueOf(f3);
      arrayOfObject[7] = paramImageRequest.getSourceUri().toString();
      FLog.v("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f for %s", arrayOfObject);
      return f3;
      j = 0;
      break;
      k = paramEncodedImage.getWidth();
      break label79;
    }
  }

  public static int determineSampleSize(ImageRequest paramImageRequest, EncodedImage paramEncodedImage)
  {
    int i;
    if (!EncodedImage.isMetaDataAvailable(paramEncodedImage))
      i = 1;
    label99: label110: 
    while (true)
    {
      return i;
      float f1 = determineDownsampleRatio(paramImageRequest, paramEncodedImage);
      int j;
      float f2;
      if (paramEncodedImage.getImageFormat() == DefaultImageFormats.JPEG)
      {
        i = ratioToSampleSizeJPEG(f1);
        j = Math.max(paramEncodedImage.getHeight(), paramEncodedImage.getWidth());
        ResizeOptions localResizeOptions = paramImageRequest.getResizeOptions();
        if (localResizeOptions == null)
          break label99;
        f2 = localResizeOptions.maxBitmapSize;
      }
      while (true)
      {
        if (j / i <= f2)
          break label110;
        if (paramEncodedImage.getImageFormat() == DefaultImageFormats.JPEG)
        {
          i *= 2;
          continue;
          i = ratioToSampleSize(f1);
          break;
          f2 = 2048.0F;
          continue;
        }
        i++;
      }
    }
  }

  private static int getRotationAngle(ImageRequest paramImageRequest, EncodedImage paramEncodedImage)
  {
    if (!paramImageRequest.getRotationOptions().useImageMetadata())
      return 0;
    int i = paramEncodedImage.getRotationAngle();
    boolean bool;
    if ((i != 0) && (i != 90) && (i != 180))
    {
      bool = false;
      if (i != 270);
    }
    else
    {
      bool = true;
    }
    Preconditions.checkArgument(bool);
    return i;
  }

  @VisibleForTesting
  static int ratioToSampleSize(float paramFloat)
  {
    if (paramFloat > 0.6666667F)
      return 1;
    for (int i = 2; ; i++)
    {
      double d = 1.0D / (Math.pow(i, 2.0D) - i);
      if (1.0D / i + d * 0.333333343267441D <= paramFloat)
        return i - 1;
    }
  }

  @VisibleForTesting
  static int ratioToSampleSizeJPEG(float paramFloat)
  {
    if (paramFloat > 0.6666667F)
    {
      i = 1;
      return i;
    }
    int i = 2;
    while (true)
    {
      double d = 1.0D / (i * 2);
      if (1.0D / (i * 2) + d * 0.333333343267441D <= paramFloat)
        break;
      i *= 2;
    }
  }

  @VisibleForTesting
  static int roundToPowerOfTwo(int paramInt)
  {
    int i = 1;
    while (true)
    {
      if (i >= paramInt)
        return i;
      i *= 2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.DownsampleUtil
 * JD-Core Version:    0.6.2
 */