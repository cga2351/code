package com.facebook.imagepipeline.common;

import android.graphics.Bitmap.Config;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public class ImageDecodeOptions
{
  private static final ImageDecodeOptions DEFAULTS = newBuilder().build();
  public final Bitmap.Config bitmapConfig;

  @Nullable
  public final ImageDecoder customImageDecoder;
  public final boolean decodeAllFrames;
  public final boolean decodePreviewFrame;
  public final boolean forceStaticImage;
  public final int minDecodeIntervalMs;
  public final boolean useLastFrameForPreview;

  public ImageDecodeOptions(ImageDecodeOptionsBuilder paramImageDecodeOptionsBuilder)
  {
    this.minDecodeIntervalMs = paramImageDecodeOptionsBuilder.getMinDecodeIntervalMs();
    this.decodePreviewFrame = paramImageDecodeOptionsBuilder.getDecodePreviewFrame();
    this.useLastFrameForPreview = paramImageDecodeOptionsBuilder.getUseLastFrameForPreview();
    this.decodeAllFrames = paramImageDecodeOptionsBuilder.getDecodeAllFrames();
    this.forceStaticImage = paramImageDecodeOptionsBuilder.getForceStaticImage();
    this.bitmapConfig = paramImageDecodeOptionsBuilder.getBitmapConfig();
    this.customImageDecoder = paramImageDecodeOptionsBuilder.getCustomImageDecoder();
  }

  public static ImageDecodeOptions defaults()
  {
    return DEFAULTS;
  }

  public static ImageDecodeOptionsBuilder newBuilder()
  {
    return new ImageDecodeOptionsBuilder();
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    ImageDecodeOptions localImageDecodeOptions;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localImageDecodeOptions = (ImageDecodeOptions)paramObject;
      if (this.decodePreviewFrame != localImageDecodeOptions.decodePreviewFrame)
        return false;
      if (this.useLastFrameForPreview != localImageDecodeOptions.useLastFrameForPreview)
        return false;
      if (this.decodeAllFrames != localImageDecodeOptions.decodeAllFrames)
        return false;
      if (this.forceStaticImage != localImageDecodeOptions.forceStaticImage)
        return false;
      if (this.bitmapConfig != localImageDecodeOptions.bitmapConfig)
        return false;
    }
    while (this.customImageDecoder == localImageDecodeOptions.customImageDecoder);
    return false;
  }

  public int hashCode()
  {
    int i = 1;
    int j = 31 * this.minDecodeIntervalMs;
    int k;
    int n;
    label37: int i2;
    label57: int i3;
    if (this.decodePreviewFrame)
    {
      k = i;
      int m = 31 * (k + j);
      if (!this.useLastFrameForPreview)
        break label128;
      n = i;
      int i1 = 31 * (n + m);
      if (!this.decodeAllFrames)
        break label134;
      i2 = i;
      i3 = 31 * (i2 + i1);
      if (!this.forceStaticImage)
        break label140;
    }
    while (true)
    {
      int i4 = 31 * (31 * (i3 + i) + this.bitmapConfig.ordinal());
      ImageDecoder localImageDecoder = this.customImageDecoder;
      int i5 = 0;
      if (localImageDecoder != null)
        i5 = this.customImageDecoder.hashCode();
      return i4 + i5;
      k = 0;
      break;
      label128: n = 0;
      break label37;
      label134: i2 = 0;
      break label57;
      label140: i = 0;
    }
  }

  public String toString()
  {
    Locale localLocale = (Locale)null;
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = Integer.valueOf(this.minDecodeIntervalMs);
    arrayOfObject[1] = Boolean.valueOf(this.decodePreviewFrame);
    arrayOfObject[2] = Boolean.valueOf(this.useLastFrameForPreview);
    arrayOfObject[3] = Boolean.valueOf(this.decodeAllFrames);
    arrayOfObject[4] = Boolean.valueOf(this.forceStaticImage);
    arrayOfObject[5] = this.bitmapConfig.name();
    arrayOfObject[6] = this.customImageDecoder;
    return String.format(localLocale, "%d-%b-%b-%b-%b-%s-%s", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.common.ImageDecodeOptions
 * JD-Core Version:    0.6.2
 */