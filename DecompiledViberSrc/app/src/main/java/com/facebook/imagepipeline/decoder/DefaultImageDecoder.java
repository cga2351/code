package com.facebook.imagepipeline.decoder;

import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import java.util.Map;
import javax.annotation.Nullable;

public class DefaultImageDecoder
  implements ImageDecoder
{
  private final ImageDecoder mAnimatedGifDecoder;
  private final ImageDecoder mAnimatedWebPDecoder;

  @Nullable
  private final Map<ImageFormat, ImageDecoder> mCustomDecoders;
  private final ImageDecoder mDefaultDecoder = new ImageDecoder()
  {
    public CloseableImage decode(EncodedImage paramAnonymousEncodedImage, int paramAnonymousInt, QualityInfo paramAnonymousQualityInfo, ImageDecodeOptions paramAnonymousImageDecodeOptions)
    {
      ImageFormat localImageFormat = paramAnonymousEncodedImage.getImageFormat();
      if (localImageFormat == DefaultImageFormats.JPEG)
        return DefaultImageDecoder.this.decodeJpeg(paramAnonymousEncodedImage, paramAnonymousInt, paramAnonymousQualityInfo, paramAnonymousImageDecodeOptions);
      if (localImageFormat == DefaultImageFormats.GIF)
        return DefaultImageDecoder.this.decodeGif(paramAnonymousEncodedImage, paramAnonymousInt, paramAnonymousQualityInfo, paramAnonymousImageDecodeOptions);
      if (localImageFormat == DefaultImageFormats.WEBP_ANIMATED)
        return DefaultImageDecoder.this.decodeAnimatedWebp(paramAnonymousEncodedImage, paramAnonymousInt, paramAnonymousQualityInfo, paramAnonymousImageDecodeOptions);
      if (localImageFormat == ImageFormat.UNKNOWN)
        throw new DecodeException("unknown image format", paramAnonymousEncodedImage);
      return DefaultImageDecoder.this.decodeStaticImage(paramAnonymousEncodedImage, paramAnonymousImageDecodeOptions);
    }
  };
  private final PlatformDecoder mPlatformDecoder;

  public DefaultImageDecoder(ImageDecoder paramImageDecoder1, ImageDecoder paramImageDecoder2, PlatformDecoder paramPlatformDecoder)
  {
    this(paramImageDecoder1, paramImageDecoder2, paramPlatformDecoder, null);
  }

  public DefaultImageDecoder(ImageDecoder paramImageDecoder1, ImageDecoder paramImageDecoder2, PlatformDecoder paramPlatformDecoder, @Nullable Map<ImageFormat, ImageDecoder> paramMap)
  {
    this.mAnimatedGifDecoder = paramImageDecoder1;
    this.mAnimatedWebPDecoder = paramImageDecoder2;
    this.mPlatformDecoder = paramPlatformDecoder;
    this.mCustomDecoders = paramMap;
  }

  public CloseableImage decode(EncodedImage paramEncodedImage, int paramInt, QualityInfo paramQualityInfo, ImageDecodeOptions paramImageDecodeOptions)
  {
    if (paramImageDecodeOptions.customImageDecoder != null)
      return paramImageDecodeOptions.customImageDecoder.decode(paramEncodedImage, paramInt, paramQualityInfo, paramImageDecodeOptions);
    ImageFormat localImageFormat = paramEncodedImage.getImageFormat();
    if ((localImageFormat == null) || (localImageFormat == ImageFormat.UNKNOWN))
    {
      localImageFormat = ImageFormatChecker.getImageFormat_WrapIOException(paramEncodedImage.getInputStream());
      paramEncodedImage.setImageFormat(localImageFormat);
    }
    if (this.mCustomDecoders != null)
    {
      ImageDecoder localImageDecoder = (ImageDecoder)this.mCustomDecoders.get(localImageFormat);
      if (localImageDecoder != null)
        return localImageDecoder.decode(paramEncodedImage, paramInt, paramQualityInfo, paramImageDecodeOptions);
    }
    return this.mDefaultDecoder.decode(paramEncodedImage, paramInt, paramQualityInfo, paramImageDecodeOptions);
  }

  public CloseableImage decodeAnimatedWebp(EncodedImage paramEncodedImage, int paramInt, QualityInfo paramQualityInfo, ImageDecodeOptions paramImageDecodeOptions)
  {
    return this.mAnimatedWebPDecoder.decode(paramEncodedImage, paramInt, paramQualityInfo, paramImageDecodeOptions);
  }

  public CloseableImage decodeGif(EncodedImage paramEncodedImage, int paramInt, QualityInfo paramQualityInfo, ImageDecodeOptions paramImageDecodeOptions)
  {
    if ((!paramImageDecodeOptions.forceStaticImage) && (this.mAnimatedGifDecoder != null))
      return this.mAnimatedGifDecoder.decode(paramEncodedImage, paramInt, paramQualityInfo, paramImageDecodeOptions);
    return decodeStaticImage(paramEncodedImage, paramImageDecodeOptions);
  }

  public CloseableStaticBitmap decodeJpeg(EncodedImage paramEncodedImage, int paramInt, QualityInfo paramQualityInfo, ImageDecodeOptions paramImageDecodeOptions)
  {
    CloseableReference localCloseableReference = this.mPlatformDecoder.decodeJPEGFromEncodedImage(paramEncodedImage, paramImageDecodeOptions.bitmapConfig, null, paramInt);
    try
    {
      CloseableStaticBitmap localCloseableStaticBitmap = new CloseableStaticBitmap(localCloseableReference, paramQualityInfo, paramEncodedImage.getRotationAngle(), paramEncodedImage.getExifOrientation());
      return localCloseableStaticBitmap;
    }
    finally
    {
      localCloseableReference.close();
    }
  }

  public CloseableStaticBitmap decodeStaticImage(EncodedImage paramEncodedImage, ImageDecodeOptions paramImageDecodeOptions)
  {
    CloseableReference localCloseableReference = this.mPlatformDecoder.decodeFromEncodedImage(paramEncodedImage, paramImageDecodeOptions.bitmapConfig, null);
    try
    {
      CloseableStaticBitmap localCloseableStaticBitmap = new CloseableStaticBitmap(localCloseableReference, ImmutableQualityInfo.FULL_QUALITY, paramEncodedImage.getRotationAngle(), paramEncodedImage.getExifOrientation());
      return localCloseableStaticBitmap;
    }
    finally
    {
      localCloseableReference.close();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.decoder.DefaultImageDecoder
 * JD-Core Version:    0.6.2
 */