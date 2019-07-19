package com.facebook.imagepipeline.decoder;

import com.facebook.imagepipeline.image.EncodedImage;

public class DecodeException extends RuntimeException
{
  private final EncodedImage mEncodedImage;

  public DecodeException(String paramString, EncodedImage paramEncodedImage)
  {
    super(paramString);
    this.mEncodedImage = paramEncodedImage;
  }

  public DecodeException(String paramString, Throwable paramThrowable, EncodedImage paramEncodedImage)
  {
    super(paramString, paramThrowable);
    this.mEncodedImage = paramEncodedImage;
  }

  public EncodedImage getEncodedImage()
  {
    return this.mEncodedImage;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.decoder.DecodeException
 * JD-Core Version:    0.6.2
 */